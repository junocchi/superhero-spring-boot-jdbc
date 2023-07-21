package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Organisation;
import com.model.persistence.OrganisationDao;

@Service
public class OrganisationServiceImp implements OrganisationService {

    @Autowired
    private OrganisationDao organisationDao;

    @Override
    public Organisation getOrganisationById(int organisationId) {
        return organisationDao.getOrganisationById(organisationId);
    }

    @Override
    public List<Organisation> getAllOrganisation() {
        return organisationDao.getAllOrganisations();
    }

    @Override
    public boolean addOrganisation(Organisation organisation) {
        return organisationDao.addOrganisation(organisation) > 0;
    }

    /*
    @Override
    public Organisation deleteOrganisation(int organisationId) {
        Organisation organisation = getOrganisationById(organisationId);

        if (organisation != null)
            organisationDao.deleteOrganisation(organisationId);

        return organisation;
    }
    
*/
    
	public int deleteOrganisation(int organisationId) {

		return organisationDao.deleteOrganisation(organisationId);

	}
	
	
    @Override
    public boolean updateOrganisation(Organisation organisation) {
        return organisationDao.updateOrganisation(organisation) > 0;
    }
    
   
	
}
