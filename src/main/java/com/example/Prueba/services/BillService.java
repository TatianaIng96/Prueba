package com.example.Prueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Prueba.models.Bill;
import com.example.Prueba.repositories.BillRepository;

@Service
public class BillService {
	
	@Autowired
	BillRepository billRepository;
	
	public Bill createdBill(Bill bill) {
		return billRepository.save(bill);
	}
	
	 public Bill updateBill(Long billId, Bill updatedBill) {
        Optional<Bill> billOptional = billRepository.findById(billId);
        if (billOptional.isPresent()) {
            Bill bill = billOptional.get();
            bill.setTotalAmount(updatedBill.getTotalAmount());
            if(updatedBill.getDescription()!= null) {
            	bill.setDescription(updatedBill.getDescription());
            }
            return billRepository.save(bill);
        } else {
            return null;
        }
    }
	
	public void deleteBill(Long billId) {
        billRepository.deleteById(billId);
    }
	 
}
