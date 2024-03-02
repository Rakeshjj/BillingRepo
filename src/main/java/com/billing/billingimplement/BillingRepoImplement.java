package com.billing.billingimplement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.billing.model.BillingModel;
import com.billing.repository.BillingRepo;

@Repository
public class BillingRepoImplement implements BillingRepo {

	private static final String INSERTY_QUERY = "INSERT INTO billing_model(product_name,quantity,mrp,gst) values(:product_name,:quantity,:mrp,:gst)";
	private static final String DELETE_QUERY = "DELETE FROM billing_model WHERE id=:id";
	private static final String GETBYID = "SELECT * FROM billing_model WHERE id=:id";
	private static final String UPDATE_QUERY = "UPDATE billing_model SET product_name=:product_name,mrp=:mrp,gst=:gst WHERE id=:id";

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public BillingModel save(BillingModel billingModel) {
		namedParameterJdbcTemplate.update(INSERTY_QUERY, new BeanPropertySqlParameterSource(billingModel));
		return billingModel;
	}

	@Override
	public void delete(long id) {
		BillingModel billingModel = new BillingModel();
		billingModel.setId(id);
		namedParameterJdbcTemplate.update(DELETE_QUERY, new BeanPropertySqlParameterSource(billingModel));
	}

	@Override
	public BillingModel getById(long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(GETBYID, map,
				new BeanPropertyRowMapper<BillingModel>(BillingModel.class));
	}

	@Override
	public BillingModel update(BillingModel billingModel) {
		namedParameterJdbcTemplate.update(UPDATE_QUERY, new BeanPropertySqlParameterSource(billingModel));
		return billingModel;
	}

	@Override
	public List<BillingModel> getAll() {
		List<BillingModel> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String sql = "";
		sb.append("SELECT * FROM billing_model");
		sql = sb.toString();
		list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<BillingModel>(BillingModel.class));
		return list;
	}

	

}