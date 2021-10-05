package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.FeeInvoice;
import io.changsoft.emwalimu.schoolmis.domain.FeeInvoiceDetail;
import io.changsoft.emwalimu.schoolmis.model.FeeInvoiceDetailDTO;
import io.changsoft.emwalimu.schoolmis.repos.FeeInvoiceDetailRepository;
import io.changsoft.emwalimu.schoolmis.repos.FeeInvoiceRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class FeeInvoiceDetailService {

    private final FeeInvoiceDetailRepository feeInvoiceDetailRepository;
    private final FeeInvoiceRepository feeInvoiceRepository;

    public FeeInvoiceDetailService(final FeeInvoiceDetailRepository feeInvoiceDetailRepository,
            final FeeInvoiceRepository feeInvoiceRepository) {
        this.feeInvoiceDetailRepository = feeInvoiceDetailRepository;
        this.feeInvoiceRepository = feeInvoiceRepository;
    }

    public List<FeeInvoiceDetailDTO> findAll() {
        return feeInvoiceDetailRepository.findAll()
                .stream()
                .map(feeInvoiceDetail -> mapToDTO(feeInvoiceDetail, new FeeInvoiceDetailDTO()))
                .collect(Collectors.toList());
    }

    public FeeInvoiceDetailDTO get(final Long id) {
        return feeInvoiceDetailRepository.findById(id)
                .map(feeInvoiceDetail -> mapToDTO(feeInvoiceDetail, new FeeInvoiceDetailDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final FeeInvoiceDetailDTO feeInvoiceDetailDTO) {
        final FeeInvoiceDetail feeInvoiceDetail = new FeeInvoiceDetail();
        mapToEntity(feeInvoiceDetailDTO, feeInvoiceDetail);
        return feeInvoiceDetailRepository.save(feeInvoiceDetail).getId();
    }

    public void update(final Long id, final FeeInvoiceDetailDTO feeInvoiceDetailDTO) {
        final FeeInvoiceDetail feeInvoiceDetail = feeInvoiceDetailRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(feeInvoiceDetailDTO, feeInvoiceDetail);
        feeInvoiceDetailRepository.save(feeInvoiceDetail);
    }

    public void delete(final Long id) {
        feeInvoiceDetailRepository.deleteById(id);
    }

    private FeeInvoiceDetailDTO mapToDTO(final FeeInvoiceDetail feeInvoiceDetail,
            final FeeInvoiceDetailDTO feeInvoiceDetailDTO) {
        feeInvoiceDetailDTO.setId(feeInvoiceDetail.getId());
        feeInvoiceDetailDTO.setVoteHead(feeInvoiceDetail.getVoteHead());
        feeInvoiceDetailDTO.setDateFrom(feeInvoiceDetail.getDateFrom());
        feeInvoiceDetailDTO.setDateTo(feeInvoiceDetail.getDateTo());
        feeInvoiceDetailDTO.setPeriodcity(feeInvoiceDetail.getPeriodcity());
        feeInvoiceDetailDTO.setTotalAmount(feeInvoiceDetail.getTotalAmount());
        feeInvoiceDetailDTO.setGovtCapitation(feeInvoiceDetail.getGovtCapitation());
        feeInvoiceDetailDTO.setParentGuardianSponsor(feeInvoiceDetail.getParentGuardianSponsor());
        feeInvoiceDetailDTO.setFeeInvoice(feeInvoiceDetail.getFeeInvoice() == null ? null : feeInvoiceDetail.getFeeInvoice().getId());
        return feeInvoiceDetailDTO;
    }

    private FeeInvoiceDetail mapToEntity(final FeeInvoiceDetailDTO feeInvoiceDetailDTO,
            final FeeInvoiceDetail feeInvoiceDetail) {
        feeInvoiceDetail.setVoteHead(feeInvoiceDetailDTO.getVoteHead());
        feeInvoiceDetail.setDateFrom(feeInvoiceDetailDTO.getDateFrom());
        feeInvoiceDetail.setDateTo(feeInvoiceDetailDTO.getDateTo());
        feeInvoiceDetail.setPeriodcity(feeInvoiceDetailDTO.getPeriodcity());
        feeInvoiceDetail.setTotalAmount(feeInvoiceDetailDTO.getTotalAmount());
        feeInvoiceDetail.setGovtCapitation(feeInvoiceDetailDTO.getGovtCapitation());
        feeInvoiceDetail.setParentGuardianSponsor(feeInvoiceDetailDTO.getParentGuardianSponsor());
        if (feeInvoiceDetailDTO.getFeeInvoice() != null && (feeInvoiceDetail.getFeeInvoice() == null || !feeInvoiceDetail.getFeeInvoice().getId().equals(feeInvoiceDetailDTO.getFeeInvoice()))) {
            final FeeInvoice feeInvoice = feeInvoiceRepository.findById(feeInvoiceDetailDTO.getFeeInvoice())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "feeInvoice not found"));
            feeInvoiceDetail.setFeeInvoice(feeInvoice);
        }
        return feeInvoiceDetail;
    }

}
