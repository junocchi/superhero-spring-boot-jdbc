package com.model.persistence;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dto.entity.Organisation;

@Repository
public class OrganisationDaoImpl implements OrganisationDao{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int addOrganisation(Organisation organisation) {

		String query = "INSERT INTO ORGANISATION VALUES(?,?,?,?)";
		return jdbcTemplate.update(query, organisation.getOrganisationId(), organisation.getOrgName(), organisation.getOrgDescription(),
				organisation.getOrgInfo());

	}
	
	@Override
	public Organisation getOrganisationById(int organisationId) {
		String query="SELECT * FROM ORGANISATION WHERE ORGANISATIONID="+organisationId;
		try {
		return jdbcTemplate.queryForObject(query, new OrganisationMapper());
		}
		catch(EmptyResultDataAccessException exception) {
			return null;
		}
	}
		
	@Override
	public List<Organisation> getAllOrganisations() {
		String query = "SELECT * FROM ORGANISATION";
		return jdbcTemplate.query(query, new OrganisationMapper());
	}
	
	
	@Override
	public int deleteOrganisation(int organisationId) {
		String query = "DELETE FROM ORGANISATION WHERE ORGANISATIONID = ?";
		return jdbcTemplate.update(query, organisationId);
	}
	
	@Override
	public int updateOrganisation(Organisation organisation) {
		String query = "UPDATE ORGANISATION SET ORGNAME = ?, ORGDESCRIPTION = ?, ORGINFO = ? WHERE ORGANISATIONID = ?";
		return jdbcTemplate.update(query, organisation.getOrgName(), organisation.getOrgDescription(),
				organisation.getOrgInfo(), organisation.getOrganisationId());
	}
	



}