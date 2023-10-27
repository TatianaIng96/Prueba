package com.example.Prueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prueba.models.Bill;
import com.example.Prueba.services.BillService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	BillService billService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Bill createBill(@Valid @RequestBody Bill bill) {
		return billService.createdBill(bill);
	}
	
	@PutMapping(path = "/{billId}")
    public Bill updateBill(@PathVariable("billId") Long billId, @RequestBody Bill updatedBill) {
        return billService.updateBill(billId, updatedBill);
    }
	
	@DeleteMapping(path = "/{billId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBill(@PathVariable("billId") Long billId) {
	    billService.deleteBill(billId);
	}
}
