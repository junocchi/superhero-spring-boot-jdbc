package com.model.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dto.entity.Organisation;

public class OrganisationMapper implements RowMapper <Organisation> {

	@Override
	public Organisation mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int organisationId = resultSet.getInt("ORGANISATIONID");
		String orgName = resultSet.getString("ORGNAME");
		String orgDescription = resultSet.getString("ORGDESCRIPTION");
		String orgInfo = resultSet.getString("ORGINFO");
		

		Organisation organisation = new Organisation(organisationId, orgName, orgDescription, orgInfo);
		return organisation;
	}

}
