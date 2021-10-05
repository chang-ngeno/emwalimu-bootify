package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.FeePaymentDetailDTO;
import io.changsoft.emwalimu.schoolmis.service.FeePaymentDetailService;
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
@RequestMapping(value = "/api/feePaymentDetails", produces = MediaType.APPLICATION_JSON_VALUE)
public class FeePaymentDetailController {

    private final FeePaymentDetailService feePaymentDetailService;

    public FeePaymentDetailController(final FeePaymentDetailService feePaymentDetailService) {
        this.feePaymentDetailService = feePaymentDetailService;
    }

    @GetMapping
    public ResponseEntity<List<FeePaymentDetailDTO>> getAllFeePaymentDetails() {
        return ResponseEntity.ok(feePaymentDetailService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeePaymentDetailDTO> getFeePaymentDetail(@PathVariable final Long id) {
        return ResponseEntity.ok(feePaymentDetailService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createFeePaymentDetail(
            @RequestBody @Valid final FeePaymentDetailDTO feePaymentDetailDTO) {
        return new ResponseEntity<>(feePaymentDetailService.create(feePaymentDetailDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFeePaymentDetail(@PathVariable final Long id,
            @RequestBody @Valid final FeePaymentDetailDTO feePaymentDetailDTO) {
        feePaymentDetailService.update(id, feePaymentDetailDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeePaymentDetail(@PathVariable final Long id) {
        feePaymentDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
