package com.taxpayer.service;

import java.io.File;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.taxpayer.model.Taxpayer;
import com.taxpayer.util.Utility;

public class TaxpayerServiceImpl implements ITaxpayerService {

	Logger log = Logger.getLogger(TaxpayerServiceImpl.class);

	@Override
	public String generateTaxpayerXML(Taxpayer taxpayer) {
		String filePath = null;

		try {
			filePath = createEmployeeXMLFile(taxpayer);
		} catch (ParserConfigurationException | TransformerException e) {
			log.error(e);
		}

		return filePath;
	}

	@Override
	public Taxpayer populateTaxpayerInfo(String userName, String address,
			String pan, String dob, String aYear, String income, String tds,
			String taxDeducted) {
		Taxpayer taxpayer = new Taxpayer();
		taxpayer.setUserName(userName);
		taxpayer.setAddress(address);
		taxpayer.setPan(pan);
		taxpayer.setDob(dob);
		taxpayer.setaYear(aYear);
		taxpayer.setIncome(Double.parseDouble(income));
		taxpayer.setTds(Double.parseDouble(tds));
		taxpayer.setTaxDeducted(Double.parseDouble(taxDeducted));
		return taxpayer;
	}

	@Override
	public boolean validateUserInput(String userName, String address,
			String pan, String dob, String aYear, String income, String tds,
			String taxDeducted) {
		boolean isValidInput = true;

		try {
			if (userName.trim().isEmpty()) {
				isValidInput = false;
			}

			if (isValidInput && (address.trim().isEmpty())) {
				isValidInput = false;
			}

			if (isValidInput && (pan.trim().isEmpty())) {
				isValidInput = false;
			}

			if (isValidInput
					&& ((dob.trim().isEmpty()) && ( dob.trim()) != null)) {
				isValidInput = false;
			}

			if (isValidInput && (aYear.trim().isEmpty())) {
				isValidInput = false;
			}

			if (isValidInput
					&& ((income.trim().isEmpty()) && (Double
							.parseDouble(income) != 0))) {
				isValidInput = false;
			}

			if (isValidInput && (tds.trim().isEmpty())) {
				Double.parseDouble(tds.trim());
				isValidInput = false;
			}

			if (isValidInput && (taxDeducted.trim().isEmpty())) {
				Double.parseDouble(taxDeducted.trim());
				isValidInput = false;
			}

		} catch (NumberFormatException e) {
			isValidInput = false;
		}

		return isValidInput;
	}

	private String createEmployeeXMLFile(Taxpayer taxpayer)
			throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		Element rootElement = doc.createElementNS(
				"http://www.taxpayer.in/employee", "Employee");
		doc.appendChild(populateEmployeeTagData(doc, rootElement, taxpayer));

		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);

		String filePath = System.getProperty("user.home") + File.separator
				+ taxpayer.getUserName() + "-" + taxpayer.getPan() + "_"
				+ taxpayer.getaYear() + ".xml";
		log.info("File path : " + filePath);
		StreamResult file = new StreamResult(new File(filePath));

		transformer.transform(source, file);

		return filePath;
	}

	private Node populateEmployeeTagData(Document doc, Element element,
			Taxpayer taxpayer) {
		element.appendChild(createChildTag(doc, element, "name",
				taxpayer.getUserName()));
		element.appendChild(createChildTag(doc, element, "address",
				taxpayer.getAddress()));
		element.appendChild(createChildTag(doc, element, "pan",
				taxpayer.getPan()));
		element.appendChild(createChildTag(doc, element, "dob",
				taxpayer.getDob()));
		element.appendChild(createChildTag(doc, element, "assesmentYear",
				taxpayer.getaYear()));
		element.appendChild(createChildTag(doc, element, "income",
				String.valueOf(taxpayer.getIncome())));
		element.appendChild(createChildTag(doc, element, "tds",
				String.valueOf(taxpayer.getTds())));
		element.appendChild(createChildTag(doc, element, "taxDeducted",
				String.valueOf(taxpayer.getTaxDeducted())));

		return element;
	}

	private Node createChildTag(Document doc, Element element, String name,
			String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}