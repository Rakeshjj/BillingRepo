package com.billing.serviceInterface;

import java.util.List;

import com.billing.model.BillingModel;

public interface BillingServiceInterface {

	public BillingModel save(BillingModel billingModel);

	public void delete(long id);

	public BillingModel getById(long id);
	
	public BillingModel update(BillingModel billingModel);
	
	public List<BillingModel> getAll();
}
