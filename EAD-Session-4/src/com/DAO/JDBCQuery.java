package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.UserDAO;

public class JDBCQuery {

	public static int addUser(UserDAO user) {
		String insertUser = "INSERT INTO User(firstName, lastName, email, dob, password, contactNumber, organization, image) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(insertUser);) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());

			java.util.Date utilDate = user.getDob();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			statement.setDate(4, sqlDate);
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getContactNumber());
			statement.setString(7, user.getOrganization());
            statement.setString(8, user.getImagePath());  
            System.out.println(user.getImagePath());
			
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean validateEmail(String email) {
		String query = "SELECT * FROM User WHERE email = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, email);

			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<UserDAO> showFriends(String searchEmail) {
		List<UserDAO> friendList = new ArrayList<UserDAO>();
		String showFriend = "SELECT * FROM User WHERE organization = ? AND email <> ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(showFriend);) {
			String organization = JDBCQuery.getOrganizationName(searchEmail);
			if (organization != null) {
				statement.setString(1, organization);
				statement.setString(2, searchEmail);

				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					String firstNameResult = resultSet.getString("firstName");
					String lastNameResult = resultSet.getString("lastName");
					String email = resultSet.getString("email");
					Date dob = resultSet.getDate("dob");
					String password = resultSet.getString("password");
					String contactNumber = resultSet.getString("contactNumber");
					String image = resultSet.getString("image");
					friendList.add(new UserDAO(firstNameResult, lastNameResult,
							email, dob, password, contactNumber, organization, image));
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return friendList;
	}

	public static boolean validateUser(String email, String password) {
		String query = "SELECT firstName, lastName FROM User WHERE email = ? AND password = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, email);
			statement.setString(2, password);

			return statement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public static UserDAO getUser(String email, String password) {
		String query = "SELECT firstName, lastName, dob, contactNumber, organization, image FROM User WHERE email = ? AND password = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, email);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String firstNameResult = resultSet.getString("firstName");
				String lastNameResult = resultSet.getString("lastName");
				Date dob = resultSet.getDate("dob");
				String contactNumber = resultSet.getString("contactNumber");
				String organization = resultSet.getString("organization");
				String image = resultSet.getString("image");
				return new UserDAO(firstNameResult, lastNameResult, email, dob,
						password, contactNumber, organization, image);
			}

		} catch (SQLException e) {
            System.out.println(e.toString());
			e.printStackTrace();
		}
		return null;
	}

	public static int updateUser(UserDAO user) {
		String updateData = "UPDATE User SET firstName = ?, lastName = ?, email = ?, dob = ?, password = ?, contactNumber = ?, organization = ? WHERE email = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(updateData);) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());

			java.util.Date utilDate = user.getDob();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			statement.setDate(4, sqlDate);
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getContactNumber());
			statement.setString(7, user.getOrganization());
			statement.setString(8, user.getEmail());

			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getOrganizationName(String email) {
		String organization = "SELECT organization FROM User WHERE email = ?";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(organization);) {
			statement.setString(1, email);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				return resultSet.getString("organization");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
}
