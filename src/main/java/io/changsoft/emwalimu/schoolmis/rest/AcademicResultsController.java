package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.AcademicResultsDTO;
import io.changsoft.emwalimu.schoolmis.service.AcademicResultsService;
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
@RequestMapping(value = "/api/academicResultss", produces = MediaType.APPLICATION_JSON_VALUE)
public class AcademicResultsController {

    private final AcademicResultsService academicResultsService;

    public AcademicResultsController(final AcademicResultsService academicResultsService) {
        this.academicResultsService = academicResultsService;
    }

    @GetMapping
    public ResponseEntity<List<AcademicResultsDTO>> getAllAcademicResultss() {
        return ResponseEntity.ok(academicResultsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicResultsDTO> getAcademicResults(@PathVariable final Long id) {
        return ResponseEntity.ok(academicResultsService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createAcademicResults(
            @RequestBody @Valid final AcademicResultsDTO academicResultsDTO) {
        return new ResponseEntity<>(academicResultsService.create(academicResultsDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAcademicResults(@PathVariable final Long id,
            @RequestBody @Valid final AcademicResultsDTO academicResultsDTO) {
        academicResultsService.update(id, academicResultsDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicResults(@PathVariable final Long id) {
        academicResultsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
