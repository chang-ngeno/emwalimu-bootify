package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.FeePaymentDTO;
import io.changsoft.emwalimu.schoolmis.service.FeePaymentService;
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
@RequestMapping(value = "/api/feePayments", produces = MediaType.APPLICATION_JSON_VALUE)
public class FeePaymentController {

    private final FeePaymentService feePaymentService;

    public FeePaymentController(final FeePaymentService feePaymentService) {
        this.feePaymentService = feePaymentService;
    }

    @GetMapping
    public ResponseEntity<List<FeePaymentDTO>> getAllFeePayments() {
        return ResponseEntity.ok(feePaymentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeePaymentDTO> getFeePayment(@PathVariable final Long id) {
        return ResponseEntity.ok(feePaymentService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createFeePayment(
            @RequestBody @Valid final FeePaymentDTO feePaymentDTO) {
        return new ResponseEntity<>(feePaymentService.create(feePaymentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFeePayment(@PathVariable final Long id,
            @RequestBody @Valid final FeePaymentDTO feePaymentDTO) {
        feePaymentService.update(id, feePaymentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeePayment(@PathVariable final Long id) {
        feePaymentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
