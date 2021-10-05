package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.AcademicResults;
import io.changsoft.emwalimu.schoolmis.domain.StudentCourseEnrollment;
import io.changsoft.emwalimu.schoolmis.domain.SystemParameter;
import io.changsoft.emwalimu.schoolmis.model.AcademicResultsDTO;
import io.changsoft.emwalimu.schoolmis.repos.AcademicResultsRepository;
import io.changsoft.emwalimu.schoolmis.repos.StudentCourseEnrollmentRepository;
import io.changsoft.emwalimu.schoolmis.repos.SystemParameterRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Transactional
@Service
public class AcademicResultsService {

    private final AcademicResultsRepository academicResultsRepository;
    private final SystemParameterRepository systemParameterRepository;
    private final StudentCourseEnrollmentRepository studentCourseEnrollmentRepository;

    public AcademicResultsService(final AcademicResultsRepository academicResultsRepository,
            final SystemParameterRepository systemParameterRepository,
            final StudentCourseEnrollmentRepository studentCourseEnrollmentRepository) {
        this.academicResultsRepository = academicResultsRepository;
        this.systemParameterRepository = systemParameterRepository;
        this.studentCourseEnrollmentRepository = studentCourseEnrollmentRepository;
    }

    public List<AcademicResultsDTO> findAll() {
        return academicResultsRepository.findAll()
                .stream()
                .map(academicResults -> mapToDTO(academicResults, new AcademicResultsDTO()))
                .collect(Collectors.toList());
    }

    public AcademicResultsDTO get(final Long id) {
        return academicResultsRepository.findById(id)
                .map(academicResults -> mapToDTO(academicResults, new AcademicResultsDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final AcademicResultsDTO academicResultsDTO) {
        final AcademicResults academicResults = new AcademicResults();
        mapToEntity(academicResultsDTO, academicResults);
        return academicResultsRepository.save(academicResults).getId();
    }

    public void update(final Long id, final AcademicResultsDTO academicResultsDTO) {
        final AcademicResults academicResults = academicResultsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(academicResultsDTO, academicResults);
        academicResultsRepository.save(academicResults);
    }

    public void delete(final Long id) {
        academicResultsRepository.deleteById(id);
    }

    private AcademicResultsDTO mapToDTO(final AcademicResults academicResults,
            final AcademicResultsDTO academicResultsDTO) {
        academicResultsDTO.setId(academicResults.getId());
        academicResultsDTO.setScore(academicResults.getScore());
        academicResultsDTO.setRatingFactor(academicResults.getRatingFactor());
        academicResultsDTO.setExamTypes(academicResults.getExamTypeSystemParameters() == null ? null : academicResults.getExamTypeSystemParameters().stream()
                .map(systemParameter -> systemParameter.getId())
                .collect(Collectors.toList()));
        academicResultsDTO.setStudentCourseSubjectResult(academicResults.getStudentCourseSubjectResult() == null ? null : academicResults.getStudentCourseSubjectResult().getId());
        return academicResultsDTO;
    }

    private AcademicResults mapToEntity(final AcademicResultsDTO academicResultsDTO,
            final AcademicResults academicResults) {
        academicResults.setScore(academicResultsDTO.getScore());
        academicResults.setRatingFactor(academicResultsDTO.getRatingFactor());
        if (academicResultsDTO.getExamTypes() != null) {
            final List<SystemParameter> examTypes = systemParameterRepository.findAllById(academicResultsDTO.getExamTypes());
            if (examTypes.size() != academicResultsDTO.getExamTypes().size()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one of examTypes not found");
            }
            academicResults.setExamTypeSystemParameters(examTypes.stream().collect(Collectors.toSet()));
        }
        if (academicResultsDTO.getStudentCourseSubjectResult() != null && (academicResults.getStudentCourseSubjectResult() == null || !academicResults.getStudentCourseSubjectResult().getId().equals(academicResultsDTO.getStudentCourseSubjectResult()))) {
            final StudentCourseEnrollment studentCourseSubjectResult = studentCourseEnrollmentRepository.findById(academicResultsDTO.getStudentCourseSubjectResult())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "studentCourseSubjectResult not found"));
            academicResults.setStudentCourseSubjectResult(studentCourseSubjectResult);
        }
        return academicResults;
    }

}
