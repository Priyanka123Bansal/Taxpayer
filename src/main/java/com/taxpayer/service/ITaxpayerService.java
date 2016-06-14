package com.taxpayer.service;

import com.taxpayer.model.Taxpayer;

public interface ITaxpayerService {

	String generateTaxpayerXML(Taxpayer taxpayer);

	Taxpayer populateTaxpayerInfo(String userName, String address, String pan,
			String dob, String aYear, String income, String tds,
			String taxDeducted);

	boolean validateUserInput(String userName, String address, String pan,
			String dob, String aYear, String income, String tds,
			String taxDeducted);

}
