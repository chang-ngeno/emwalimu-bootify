package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.FeeInvoiceDetailDTO;
import io.changsoft.emwalimu.schoolmis.service.FeeInvoiceDetailService;
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
@RequestMapping(value = "/api/feeInvoiceDetails", produces = MediaType.APPLICATION_JSON_VALUE)
public class FeeInvoiceDetailController {

    private final FeeInvoiceDetailService feeInvoiceDetailService;

    public FeeInvoiceDetailController(final FeeInvoiceDetailService feeInvoiceDetailService) {
        this.feeInvoiceDetailService = feeInvoiceDetailService;
    }

    @GetMapping
    public ResponseEntity<List<FeeInvoiceDetailDTO>> getAllFeeInvoiceDetails() {
        return ResponseEntity.ok(feeInvoiceDetailService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeeInvoiceDetailDTO> getFeeInvoiceDetail(@PathVariable final Long id) {
        return ResponseEntity.ok(feeInvoiceDetailService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createFeeInvoiceDetail(
            @RequestBody @Valid final FeeInvoiceDetailDTO feeInvoiceDetailDTO) {
        return new ResponseEntity<>(feeInvoiceDetailService.create(feeInvoiceDetailDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFeeInvoiceDetail(@PathVariable final Long id,
            @RequestBody @Valid final FeeInvoiceDetailDTO feeInvoiceDetailDTO) {
        feeInvoiceDetailService.update(id, feeInvoiceDetailDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeeInvoiceDetail(@PathVariable final Long id) {
        feeInvoiceDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
