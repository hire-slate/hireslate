package com.hireslate.model;

public class CompanyMaster {

	private int companyId,companyPincode;
	private String companyName,companyWebsite,companyAddressLine,companyLandmark,companyGstin,companyPancard,companyPancardPhoto,companyLogo,companyDocument;
	private String companyContact;
	
	public CompanyMaster(int companyId, int companyPincode, String companyName, String companyWebsite,
			String companyAddressLine, String companyLandmark, String companyGstin, String companyPancard,
			String companyPancardPhoto, String companyLogo, String companyDocument, String companyContact) {
		super();
		this.companyId = companyId;
		this.companyPincode = companyPincode;
		this.companyName = companyName;
		this.companyWebsite = companyWebsite;
		this.companyAddressLine = companyAddressLine;
		this.companyLandmark = companyLandmark;
		this.companyGstin = companyGstin;
		this.companyPancard = companyPancard;
		this.companyPancardPhoto = companyPancardPhoto;
		this.companyLogo = companyLogo;
		this.companyDocument = companyDocument;
		this.companyContact = companyContact;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCompanyPincode() {
		return companyPincode;
	}

	public void setCompanyPincode(int companyPincode) {
		this.companyPincode = companyPincode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyAddressLine() {
		return companyAddressLine;
	}

	public void setCompanyAddressLine(String companyAddressLine) {
		this.companyAddressLine = companyAddressLine;
	}

	public String getCompanyLandmark() {
		return companyLandmark;
	}

	public void setCompanyLandmark(String companyLandmark) {
		this.companyLandmark = companyLandmark;
	}

	public String getCompanyGstin() {
		return companyGstin;
	}

	public void setCompanyGstin(String companyGstin) {
		this.companyGstin = companyGstin;
	}

	public String getCompanyPancard() {
		return companyPancard;
	}

	public void setCompanyPancard(String companyPancard) {
		this.companyPancard = companyPancard;
	}

	public String getCompanyPancardPhoto() {
		return companyPancardPhoto;
	}

	public void setCompanyPancardPhoto(String companyPancardPhoto) {
		this.companyPancardPhoto = companyPancardPhoto;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getCompanyDocument() {
		return companyDocument;
	}

	public void setCompanyDocument(String companyDocument) {
		this.companyDocument = companyDocument;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}
	
	
	
}
