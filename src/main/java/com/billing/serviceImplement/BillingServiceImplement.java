package com.billing.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.model.BillingModel;
import com.billing.repository.BillingRepo;
import com.billing.serviceInterface.BillingServiceInterface;

import jakarta.transaction.Transactional;

@Service
public class BillingServiceImplement implements BillingServiceInterface {

	@Autowired
	private BillingRepo billingRepo;

	@Override
	@Transactional
	public BillingModel save(BillingModel billingModel) {
		return billingRepo.save(billingModel);
	}

	@Override
	public void delete(long id) {
		billingRepo.delete(id);
	}

	@Override
	public BillingModel getById(long id) {
		return billingRepo.getById(id);
	}

	@Override
	public BillingModel update(BillingModel billingModel) {
		return billingRepo.update(billingModel);
	}

	@Override
	public List<BillingModel> getAll() {
		return billingRepo.getAll();
	}
}
