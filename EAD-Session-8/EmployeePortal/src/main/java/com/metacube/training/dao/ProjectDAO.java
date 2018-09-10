package com.metacube.training.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Project;

/**
 * @author Deekshika Sharma
 * This class have database access for project implementation
 */
public class ProjectDAO implements AdminDAO<Project> {

	@Override
	public int createField(Project project) {

		System.out.println("Project dao");
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(ProjectQuery.CREATE_PROJECT);) {
			statement.setString(1, project.getDescription());

			java.util.Date utilDate = project.getStartDate();
			java.sql.Date sqlStartDate = new java.sql.Date(utilDate.getTime());

			java.util.Date utilEndDate = project.getEndDate();
			java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());

			statement.setDate(2, sqlStartDate);
			statement.setDate(3, sqlEndDate);

			System.out.println(project.getLogo());
		    statement.setBlob(4, project.getLogo());

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateField(Project project) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(ProjectQuery.UPDATE_PROJECT);) {
			statement.setString(1, project.getDescription());
			statement.setDate(2, (Date) project.getStartDate());
			statement.setDate(3, (Date) project.getEndDate());
			statement.setBlob(4, project.getLogo());
			statement.setInt(5, project.getId());

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteField(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Project> getField() {
		List<Project> projectList = new ArrayList<Project>();
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(ProjectQuery.GET_PROJECT_LIST);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
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

				projectList.add(project);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
	}

	@Override
	public Project getFieldById(String project_id) {
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(ProjectQuery.GET_PROJECT_BY_ID);) {
			int projectId = Integer.parseInt(project_id);

			statement.setInt(1, projectId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Project project = new Project();
				project.setId(resultSet.getInt("project_id"));
				project.setDescription(resultSet.getString("description"));
				project.setStartDate(resultSet.getDate("start_date"));
				project.setEndDate(resultSet.getDate("end_date"));
				Blob blob = resultSet.getBlob("project_logo");
				project.setLogo(blob.getBinaryStream());

				return project;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
