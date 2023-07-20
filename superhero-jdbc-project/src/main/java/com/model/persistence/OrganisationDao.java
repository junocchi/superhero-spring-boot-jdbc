package com.model.persistence;

import java.util.List;

import com.dto.entity.Organisation;

public interface OrganisationDao {

	int addOrganisation(Organisation organisation);

	Organisation getOrganisationById(int organisationId);

	List<Organisation> getAllOrganisations();

	int deleteOrganisation(int organisationId);

	int updateOrganisation(Organisation organisation);

}
