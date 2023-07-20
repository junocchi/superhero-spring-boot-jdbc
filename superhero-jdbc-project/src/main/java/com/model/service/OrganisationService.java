package com.model.service;

import java.util.List;

import com.dto.entity.Organisation;

public interface OrganisationService {

	Organisation getOrganisationById(int organisationId);

	List<Organisation> getAllOrganisation();

	boolean addOrganisation(Organisation organisation);

	int deleteOrganisation(int organisationId);

	boolean updateOrganisation(Organisation organisation);

}
