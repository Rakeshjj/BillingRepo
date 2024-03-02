package com.billing.repository;

import java.util.List;

import com.billing.model.BillingModel;

public interface BillingRepo {

	public BillingModel save(BillingModel billingModel);

	public BillingModel update(BillingModel billingModel);

	public void delete(long id);

	public BillingModel getById(long id);

	public List<BillingModel> getAll();

	public void deleteAll();
}
