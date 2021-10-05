package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.ParentDTO;
import io.changsoft.emwalimu.schoolmis.service.ParentService;
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
@RequestMapping(value = "/api/parents", produces = MediaType.APPLICATION_JSON_VALUE)
public class ParentController {

    private final ParentService parentService;

    public ParentController(final ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public ResponseEntity<List<ParentDTO>> getAllParents() {
        return ResponseEntity.ok(parentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentDTO> getParent(@PathVariable final Long id) {
        return ResponseEntity.ok(parentService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createParent(@RequestBody @Valid final ParentDTO parentDTO) {
        return new ResponseEntity<>(parentService.create(parentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParent(@PathVariable final Long id,
            @RequestBody @Valid final ParentDTO parentDTO) {
        parentService.update(id, parentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable final Long id) {
        parentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
