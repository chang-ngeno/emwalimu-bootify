package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.AcademicRegistration;
import io.changsoft.emwalimu.schoolmis.model.AcademicRegistrationDTO;
import io.changsoft.emwalimu.schoolmis.repos.AcademicRegistrationRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AcademicRegistrationService {

    private final AcademicRegistrationRepository academicRegistrationRepository;

    public AcademicRegistrationService(
            final AcademicRegistrationRepository academicRegistrationRepository) {
        this.academicRegistrationRepository = academicRegistrationRepository;
    }

    public List<AcademicRegistrationDTO> findAll() {
        return academicRegistrationRepository.findAll()
                .stream()
                .map(academicRegistration -> mapToDTO(academicRegistration, new AcademicRegistrationDTO()))
                .collect(Collectors.toList());
    }

    public AcademicRegistrationDTO get(final Long id) {
        return academicRegistrationRepository.findById(id)
                .map(academicRegistration -> mapToDTO(academicRegistration, new AcademicRegistrationDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final AcademicRegistrationDTO academicRegistrationDTO) {
        final AcademicRegistration academicRegistration = new AcademicRegistration();
        mapToEntity(academicRegistrationDTO, academicRegistration);
        return academicRegistrationRepository.save(academicRegistration).getId();
    }

    public void update(final Long id, final AcademicRegistrationDTO academicRegistrationDTO) {
        final AcademicRegistration academicRegistration = academicRegistrationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(academicRegistrationDTO, academicRegistration);
        academicRegistrationRepository.save(academicRegistration);
    }

    public void delete(final Long id) {
        academicRegistrationRepository.deleteById(id);
    }

    private AcademicRegistrationDTO mapToDTO(final AcademicRegistration academicRegistration,
            final AcademicRegistrationDTO academicRegistrationDTO) {
        academicRegistrationDTO.setId(academicRegistration.getId());
        academicRegistrationDTO.setCalender(academicRegistration.getCalender());
        academicRegistrationDTO.setTermSemester(academicRegistration.getTermSemester());
        academicRegistrationDTO.setClassGroup(academicRegistration.getClassGroup());
        return academicRegistrationDTO;
    }

    private AcademicRegistration mapToEntity(final AcademicRegistrationDTO academicRegistrationDTO,
            final AcademicRegistration academicRegistration) {
        academicRegistration.setCalender(academicRegistrationDTO.getCalender());
        academicRegistration.setTermSemester(academicRegistrationDTO.getTermSemester());
        academicRegistration.setClassGroup(academicRegistrationDTO.getClassGroup());
        return academicRegistration;
    }

}
