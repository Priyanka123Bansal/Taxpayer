package com.taxpayer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.taxpayer.model.Taxpayer;
import com.taxpayer.service.ITaxpayerService;
import com.taxpayer.service.TaxpayerServiceImpl;

public class TaxpayerController extends HttpServlet {

	Logger log = Logger.getLogger(TaxpayerController.class);

	private static final long serialVersionUID = 3537508925173719986L;

	ITaxpayerService iTaxpayerService = new TaxpayerServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		log.info("TaxpayerController...................");

		String userName = request.getParameter("userName");
		String address = request.getParameter("address");
		String pan = request.getParameter("pan");
		String dob = request.getParameter("dob");

		String aYear = request.getParameter("ayear");
		String income = request.getParameter("income");
		String tds = request.getParameter("tds");
		String taxDeducted = request.getParameter("taxdeducted");

		log.info("User information : ");
		log.info("username : " + userName);
		log.info("address : " + address);
		log.info("pan : " + pan);
		log.info("dob : " + dob);
		log.info("assesment year : " + aYear);
		log.info("income : " + income);
		log.info("tds : " + tds);
		log.info("taxdeducted : " + taxDeducted);

		boolean isValidInput = iTaxpayerService.validateUserInput(userName,
				address, pan, dob, aYear, income, tds, taxDeducted);
		String message = null;

		if (isValidInput) {
			Taxpayer taxpayer = iTaxpayerService.populateTaxpayerInfo(userName,
					address, pan, dob, aYear, income, tds, taxDeducted);
			String filePath = iTaxpayerService.generateTaxpayerXML(taxpayer);
			if (filePath != null) {
				log.info("File path : " + filePath);
				message = "file path of XML File : " + filePath;
			} else {
				message = "Oops something went wrong, please try again later";
			}
		} else {
			message = "Please Enter Correct Value";
		}
		response.sendRedirect("../index.jsp?message=" + message);

	}

}
