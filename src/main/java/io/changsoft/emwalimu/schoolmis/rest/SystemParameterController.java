package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.SystemParameterDTO;
import io.changsoft.emwalimu.schoolmis.service.SystemParameterService;
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
@RequestMapping(value = "/api/systemParameters", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemParameterController {

    private final SystemParameterService systemParameterService;

    public SystemParameterController(final SystemParameterService systemParameterService) {
        this.systemParameterService = systemParameterService;
    }

    @GetMapping
    public ResponseEntity<List<SystemParameterDTO>> getAllSystemParameters() {
        return ResponseEntity.ok(systemParameterService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemParameterDTO> getSystemParameter(@PathVariable final Long id) {
        return ResponseEntity.ok(systemParameterService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createSystemParameter(
            @RequestBody @Valid final SystemParameterDTO systemParameterDTO) {
        return new ResponseEntity<>(systemParameterService.create(systemParameterDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSystemParameter(@PathVariable final Long id,
            @RequestBody @Valid final SystemParameterDTO systemParameterDTO) {
        systemParameterService.update(id, systemParameterDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSystemParameter(@PathVariable final Long id) {
        systemParameterService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
