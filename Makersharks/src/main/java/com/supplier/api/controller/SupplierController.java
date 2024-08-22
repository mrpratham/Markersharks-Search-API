package com.supplier.api.controller;

import com.supplier.api.service.SupplierService;
import com.supplier.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@Validated
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<List<Supplier>> getSuppliers(
            @RequestParam @NotBlank(message = "Location is required") String location,
            @RequestParam @NotNull(message = "Nature of business is required") Supplier.NatureOfBusiness natureOfBusiness,
            @RequestParam @NotEmpty(message = "At least one manufacturing process is required") List<Supplier.ManufacturingProcess> processes,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Limit must be at least 1") int limit) {

        List<Supplier> suppliers = supplierService.getSuppliers(location, natureOfBusiness, processes, limit);
        return ResponseEntity.ok(suppliers);
    }
}