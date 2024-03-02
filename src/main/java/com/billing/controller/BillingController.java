package com.billing.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billing.model.BillingModel;
import com.billing.serviceImplement.BillingServiceImplement;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Api")
public class BillingController {

	@Autowired
	private BillingServiceImplement billingServiceImplement;

	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody BillingModel billingModel) {
		String message = "";
		try {
			billingServiceImplement.save(billingModel);
			message = "Data saved successfully...";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			message = "Data does not save";
			return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		String message = "";

		try {
			billingServiceImplement.delete(id);
			message = "Deleted successfully...";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			message = "Id not found";
			return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getById/{id}")
	public BillingModel getById(@PathVariable long id) {
		return billingServiceImplement.getById(id);
	}

	@GetMapping("/getAll")
	public List<BillingModel> getAll() {
		return billingServiceImplement.getAll();
	}

	@PutMapping("/put")
	public ResponseEntity<String> update(@RequestBody BillingModel billingModel, @RequestParam long id)
			throws NoSuchAlgorithmException {
		String message = "";

		BillingModel billingModel2 = billingServiceImplement.getById(id);
		if (billingModel2 != null) {
			billingServiceImplement.update(billingModel);
			message = "Successfuly Updated";
		} else {
			throw new NoSuchAlgorithmException("Not updated");
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@DeleteMapping("/deleteid/{id}")
	public String deleteMethod(@PathVariable long id) {
		BillingModel billingModel = billingServiceImplement.getById(id);

		if (billingModel == null) {
			throw new RuntimeException("Id not found-" + id);
		}

		billingServiceImplement.delete(id);
		return "Deleted";

	}

	@PutMapping("/update")
	public BillingModel updateId(@RequestBody BillingModel billingModel) {
		BillingModel billingModel2 = billingServiceImplement.update(billingModel);
		return billingModel2;

	}

}
