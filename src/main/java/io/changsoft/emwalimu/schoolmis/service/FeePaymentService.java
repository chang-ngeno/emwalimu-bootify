package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.FeePayment;
import io.changsoft.emwalimu.schoolmis.model.FeePaymentDTO;
import io.changsoft.emwalimu.schoolmis.repos.FeePaymentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class FeePaymentService {

    private final FeePaymentRepository feePaymentRepository;

    public FeePaymentService(final FeePaymentRepository feePaymentRepository) {
        this.feePaymentRepository = feePaymentRepository;
    }

    public List<FeePaymentDTO> findAll() {
        return feePaymentRepository.findAll()
                .stream()
                .map(feePayment -> mapToDTO(feePayment, new FeePaymentDTO()))
                .collect(Collectors.toList());
    }

    public FeePaymentDTO get(final Long id) {
        return feePaymentRepository.findById(id)
                .map(feePayment -> mapToDTO(feePayment, new FeePaymentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final FeePaymentDTO feePaymentDTO) {
        final FeePayment feePayment = new FeePayment();
        mapToEntity(feePaymentDTO, feePayment);
        return feePaymentRepository.save(feePayment).getId();
    }

    public void update(final Long id, final FeePaymentDTO feePaymentDTO) {
        final FeePayment feePayment = feePaymentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(feePaymentDTO, feePayment);
        feePaymentRepository.save(feePayment);
    }

    public void delete(final Long id) {
        feePaymentRepository.deleteById(id);
    }

    private FeePaymentDTO mapToDTO(final FeePayment feePayment, final FeePaymentDTO feePaymentDTO) {
        feePaymentDTO.setId(feePayment.getId());
        feePaymentDTO.setTxnDate(feePayment.getTxnDate());
        feePaymentDTO.setTxnAmount(feePayment.getTxnAmount());
        feePaymentDTO.setBalance(feePayment.getBalance());
        feePaymentDTO.setTxnMode(feePayment.getTxnMode());
        return feePaymentDTO;
    }

    private FeePayment mapToEntity(final FeePaymentDTO feePaymentDTO, final FeePayment feePayment) {
        feePayment.setTxnDate(feePaymentDTO.getTxnDate());
        feePayment.setTxnAmount(feePaymentDTO.getTxnAmount());
        feePayment.setBalance(feePaymentDTO.getBalance());
        feePayment.setTxnMode(feePaymentDTO.getTxnMode());
        return feePayment;
    }

}
