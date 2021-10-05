package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.AcademicRegistrationDTO;
import io.changsoft.emwalimu.schoolmis.service.AcademicRegistrationService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/academicRegistrations", produces = MediaType.APPLICATION_JSON_VALUE)
public class AcademicRegistrationController {

    private final AcademicRegistrationService academicRegistrationService;

    public AcademicRegistrationController(
            final AcademicRegistrationService academicRegistrationService) {
        this.academicRegistrationService = academicRegistrationService;
    }

    @GetMapping
    public ResponseEntity<List<AcademicRegistrationDTO>> getAllAcademicRegistrations() {
        return ResponseEntity.ok(academicRegistrationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicRegistrationDTO> getAcademicRegistration(
            @PathVariable final Long id) {
        return ResponseEntity.ok(academicRegistrationService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createAcademicRegistration(
            @RequestBody @Valid final AcademicRegistrationDTO academicRegistrationDTO) {
        return new ResponseEntity<>(academicRegistrationService.create(academicRegistrationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAcademicRegistration(@PathVariable final Long id,
            @RequestBody @Valid final AcademicRegistrationDTO academicRegistrationDTO) {
        academicRegistrationService.update(id, academicRegistrationDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicRegistration(@PathVariable final Long id) {
        academicRegistrationService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
