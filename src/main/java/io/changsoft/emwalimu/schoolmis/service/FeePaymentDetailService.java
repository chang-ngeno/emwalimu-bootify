package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.FeeInvoiceDetail;
import io.changsoft.emwalimu.schoolmis.domain.FeePayment;
import io.changsoft.emwalimu.schoolmis.domain.FeePaymentDetail;
import io.changsoft.emwalimu.schoolmis.model.FeePaymentDetailDTO;
import io.changsoft.emwalimu.schoolmis.repos.FeeInvoiceDetailRepository;
import io.changsoft.emwalimu.schoolmis.repos.FeePaymentDetailRepository;
import io.changsoft.emwalimu.schoolmis.repos.FeePaymentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class FeePaymentDetailService {

    private final FeePaymentDetailRepository feePaymentDetailRepository;
    private final FeePaymentRepository feePaymentRepository;
    private final FeeInvoiceDetailRepository feeInvoiceDetailRepository;

    public FeePaymentDetailService(final FeePaymentDetailRepository feePaymentDetailRepository,
            final FeePaymentRepository feePaymentRepository,
            final FeeInvoiceDetailRepository feeInvoiceDetailRepository) {
        this.feePaymentDetailRepository = feePaymentDetailRepository;
        this.feePaymentRepository = feePaymentRepository;
        this.feeInvoiceDetailRepository = feeInvoiceDetailRepository;
    }

    public List<FeePaymentDetailDTO> findAll() {
        return feePaymentDetailRepository.findAll()
                .stream()
                .map(feePaymentDetail -> mapToDTO(feePaymentDetail, new FeePaymentDetailDTO()))
                .collect(Collectors.toList());
    }

    public FeePaymentDetailDTO get(final Long id) {
        return feePaymentDetailRepository.findById(id)
                .map(feePaymentDetail -> mapToDTO(feePaymentDetail, new FeePaymentDetailDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final FeePaymentDetailDTO feePaymentDetailDTO) {
        final FeePaymentDetail feePaymentDetail = new FeePaymentDetail();
        mapToEntity(feePaymentDetailDTO, feePaymentDetail);
        return feePaymentDetailRepository.save(feePaymentDetail).getId();
    }

    public void update(final Long id, final FeePaymentDetailDTO feePaymentDetailDTO) {
        final FeePaymentDetail feePaymentDetail = feePaymentDetailRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(feePaymentDetailDTO, feePaymentDetail);
        feePaymentDetailRepository.save(feePaymentDetail);
    }

    public void delete(final Long id) {
        feePaymentDetailRepository.deleteById(id);
    }

    private FeePaymentDetailDTO mapToDTO(final FeePaymentDetail feePaymentDetail,
            final FeePaymentDetailDTO feePaymentDetailDTO) {
        feePaymentDetailDTO.setId(feePaymentDetail.getId());
        feePaymentDetailDTO.setAmount(feePaymentDetail.getAmount());
        feePaymentDetailDTO.setFeePayment(feePaymentDetail.getFeePayment() == null ? null : feePaymentDetail.getFeePayment().getId());
        feePaymentDetailDTO.setFeeInvoiceDetail(feePaymentDetail.getFeeInvoiceDetail() == null ? null : feePaymentDetail.getFeeInvoiceDetail().getId());
        return feePaymentDetailDTO;
    }

    private FeePaymentDetail mapToEntity(final FeePaymentDetailDTO feePaymentDetailDTO,
            final FeePaymentDetail feePaymentDetail) {
        feePaymentDetail.setAmount(feePaymentDetailDTO.getAmount());
        if (feePaymentDetailDTO.getFeePayment() != null && (feePaymentDetail.getFeePayment() == null || !feePaymentDetail.getFeePayment().getId().equals(feePaymentDetailDTO.getFeePayment()))) {
            final FeePayment feePayment = feePaymentRepository.findById(feePaymentDetailDTO.getFeePayment())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "feePayment not found"));
            feePaymentDetail.setFeePayment(feePayment);
        }
        if (feePaymentDetailDTO.getFeeInvoiceDetail() != null && (feePaymentDetail.getFeeInvoiceDetail() == null || !feePaymentDetail.getFeeInvoiceDetail().getId().equals(feePaymentDetailDTO.getFeeInvoiceDetail()))) {
            final FeeInvoiceDetail feeInvoiceDetail = feeInvoiceDetailRepository.findById(feePaymentDetailDTO.getFeeInvoiceDetail())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "feeInvoiceDetail not found"));
            feePaymentDetail.setFeeInvoiceDetail(feeInvoiceDetail);
        }
        return feePaymentDetail;
    }

}
