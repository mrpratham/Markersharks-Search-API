package com.supplier.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplier.api.repository.SupplierRepository;
import com.supplier.model.Supplier;

@Service
public class SupplierService {
	
	@Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getSuppliers(String location, Supplier.NatureOfBusiness natureOfBusiness, List<Supplier.ManufacturingProcess> processes, int limit) {
        List<Supplier> suppliers = supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(location, natureOfBusiness, processes);
        return suppliers.size() > limit ? suppliers.subList(0, limit) : suppliers;
    }
	

}
