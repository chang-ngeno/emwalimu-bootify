package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.AcademicRegistration;
import io.changsoft.emwalimu.schoolmis.domain.FeeInvoice;
import io.changsoft.emwalimu.schoolmis.model.FeeInvoiceDTO;
import io.changsoft.emwalimu.schoolmis.repos.AcademicRegistrationRepository;
import io.changsoft.emwalimu.schoolmis.repos.FeeInvoiceRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class FeeInvoiceService {

    private final FeeInvoiceRepository feeInvoiceRepository;
    private final AcademicRegistrationRepository academicRegistrationRepository;

    public FeeInvoiceService(final FeeInvoiceRepository feeInvoiceRepository,
            final AcademicRegistrationRepository academicRegistrationRepository) {
        this.feeInvoiceRepository = feeInvoiceRepository;
        this.academicRegistrationRepository = academicRegistrationRepository;
    }

    public List<FeeInvoiceDTO> findAll() {
        return feeInvoiceRepository.findAll()
                .stream()
                .map(feeInvoice -> mapToDTO(feeInvoice, new FeeInvoiceDTO()))
                .collect(Collectors.toList());
    }

    public FeeInvoiceDTO get(final Long id) {
        return feeInvoiceRepository.findById(id)
                .map(feeInvoice -> mapToDTO(feeInvoice, new FeeInvoiceDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final FeeInvoiceDTO feeInvoiceDTO) {
        final FeeInvoice feeInvoice = new FeeInvoice();
        mapToEntity(feeInvoiceDTO, feeInvoice);
        return feeInvoiceRepository.save(feeInvoice).getId();
    }

    public void update(final Long id, final FeeInvoiceDTO feeInvoiceDTO) {
        final FeeInvoice feeInvoice = feeInvoiceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(feeInvoiceDTO, feeInvoice);
        feeInvoiceRepository.save(feeInvoice);
    }

    public void delete(final Long id) {
        feeInvoiceRepository.deleteById(id);
    }

    private FeeInvoiceDTO mapToDTO(final FeeInvoice feeInvoice, final FeeInvoiceDTO feeInvoiceDTO) {
        feeInvoiceDTO.setId(feeInvoice.getId());
        feeInvoiceDTO.setGrandTotal(feeInvoice.getGrandTotal());
        feeInvoiceDTO.setSubTotal(feeInvoice.getSubTotal());
        feeInvoiceDTO.setAcademicRegistration(feeInvoice.getAcademicRegistration() == null ? null : feeInvoice.getAcademicRegistration().getId());
        return feeInvoiceDTO;
    }

    private FeeInvoice mapToEntity(final FeeInvoiceDTO feeInvoiceDTO, final FeeInvoice feeInvoice) {
        feeInvoice.setGrandTotal(feeInvoiceDTO.getGrandTotal());
        feeInvoice.setSubTotal(feeInvoiceDTO.getSubTotal());
        if (feeInvoiceDTO.getAcademicRegistration() != null && (feeInvoice.getAcademicRegistration() == null || !feeInvoice.getAcademicRegistration().getId().equals(feeInvoiceDTO.getAcademicRegistration()))) {
            final AcademicRegistration academicRegistration = academicRegistrationRepository.findById(feeInvoiceDTO.getAcademicRegistration())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "academicRegistration not found"));
            feeInvoice.setAcademicRegistration(academicRegistration);
        }
        return feeInvoice;
    }

}
