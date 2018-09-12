package com.metacube.training.mapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Project;

public class ProjectMapper implements RowMapper<Project>{

	@Override
	public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Project project = new Project();
		project.setId(resultSet.getInt("project_id"));
		project.setDescription(resultSet.getString("description"));
		project.setStartDate(resultSet.getDate("start_date"));
		project.setEndDate(resultSet.getDate("end_date"));

		Blob blob = resultSet.getBlob("project_logo");
		if (blob == null)
			project.setLogo(null);
		else
			project.setLogo(blob.getBinaryStream());
		return project;
	}

}
