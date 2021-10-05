package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.FeeInvoiceDTO;
import io.changsoft.emwalimu.schoolmis.service.FeeInvoiceService;
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
@RequestMapping(value = "/api/feeInvoices", produces = MediaType.APPLICATION_JSON_VALUE)
public class FeeInvoiceController {

    private final FeeInvoiceService feeInvoiceService;

    public FeeInvoiceController(final FeeInvoiceService feeInvoiceService) {
        this.feeInvoiceService = feeInvoiceService;
    }

    @GetMapping
    public ResponseEntity<List<FeeInvoiceDTO>> getAllFeeInvoices() {
        return ResponseEntity.ok(feeInvoiceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeeInvoiceDTO> getFeeInvoice(@PathVariable final Long id) {
        return ResponseEntity.ok(feeInvoiceService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createFeeInvoice(
            @RequestBody @Valid final FeeInvoiceDTO feeInvoiceDTO) {
        return new ResponseEntity<>(feeInvoiceService.create(feeInvoiceDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFeeInvoice(@PathVariable final Long id,
            @RequestBody @Valid final FeeInvoiceDTO feeInvoiceDTO) {
        feeInvoiceService.update(id, feeInvoiceDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeeInvoice(@PathVariable final Long id) {
        feeInvoiceService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
