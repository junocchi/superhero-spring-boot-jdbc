package com.dto.entity;

import java.util.List;

import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.*;

public class Organisation {

	private int organisationId;
	private String orgName;
	private String orgDescription;
	private String orgInfo;

	@MappedCollection
	private List<Superhero> superheros = new ArrayList<Superhero>();

	public Organisation() {
	}


	public Organisation(int organisationId, String orgName, String orgDescription, String orgInfo) {
		super();
		this.organisationId = organisationId;
		this.orgName = orgName;
		this.orgDescription = orgDescription;
		this.orgInfo = orgInfo;
	}



	public int getOrganisationId() {
		return organisationId;
	}


	public void setOrganisationId(int organisationId) {
		this.organisationId = organisationId;
	}


	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgDescription() {
		return orgDescription;
	}

	public void setOrgDescription(String orgDescription) {
		this.orgDescription = orgDescription;
	}

	public String getOrgInfo() {
		return orgInfo;
	}

	public void setOrgInfo(String orgInfo) {
		this.orgInfo = orgInfo;
	}

	@Override
	public String toString() {
		return "Organisation [organisationId=" + organisationId + ", orgName=" + orgName + ", orgDescription="
				+ orgDescription + ", orgInfo=" + orgInfo + ", members=" + superheros + "]";
	}

}
