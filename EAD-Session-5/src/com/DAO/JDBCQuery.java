package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Advertisement;
import com.entity.Category;

public class JDBCQuery {

	/**
	 * This method will return true is category is available in the category
	 * table
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isCategoryAvailable(int id) {
		String query = "SELECT id FROM Category WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next())
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will return true is advertisement is available in the
	 * advertisement table
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isAdvertisementAvailable(int id) {
		String query = "SELECT id FROM Advertisement WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next())
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method will return category id by using advertisement id
	 * 
	 * @param advertisementId
	 * @return
	 */
	public static int getCategoryIdByAdvertisementId(int advertisementId) {
		String query = "SELECT categoryID FROM Advertisement WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setInt(1, advertisementId);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next())
				return resultSet.getInt("categoryID");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * This method will return category id by category name
	 * 
	 * @param categoryName
	 * @return
	 */
	public static int getCategoryId(String categoryName) {
		String query = "SELECT id FROM Category WHERE name = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, categoryName);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next())
				return resultSet.getInt("id");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * This method will insert category into category table
	 * 
	 * @param categoryName
	 * @return
	 */
	public static int insertCategory(String categoryName) {
		String query = "INSERT INTO Category (name) VALUES (?)";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, categoryName);

			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * This method will return category list
	 * 
	 * @return
	 */
	public static List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		String query = "SELECT * FROM Category";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				categories.add(new Category(resultSet.getInt("id"), resultSet
						.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	/**
	 * This method will insert advertisement into advertisement table
	 * 
	 * @param advertisement
	 * @return
	 */
	public static int insertAdvertisement(Advertisement advertisement) {
		String query = "INSERT INTO Advertisement(title, description, categoryID) VALUES (?, ?, ?)";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, advertisement.getTitle());
			statement.setString(2, advertisement.getDescription());
			statement.setInt(3, advertisement.getCategoryID());

			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * This method will retrieve advertisement list
	 * 
	 * @return
	 */
	public static List<Advertisement> getAllAdvertisement() {
		List<Advertisement> advertisements = new ArrayList<>();
		String query = "SELECT * FROM Advertisement";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				int categoryID = resultSet.getInt("categoryID");

				advertisements.add(new Advertisement(id, title, description,
						categoryID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return advertisements;
	}

	/**
	 * This method will return advertisement list by category id
	 * 
	 * @param categoryId
	 * @return
	 */
	public static List<Advertisement> getAllAdvertisementByCategoryID(
			int categoryId) {
		List<Advertisement> advertisements = new ArrayList<>();
		String query = "SELECT * FROM Advertisement WHERE categoryID = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setInt(1, categoryId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				int categoryID = resultSet.getInt("categoryID");

				advertisements.add(new Advertisement(id, title, description,
						categoryID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return advertisements;
	}

	/**
	 * This method will update the advertisement title
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public static int updateAdvertisementTitle(String name, int id) {
		String query = "UPDATE Advertisement SET title = ? WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, name);
			statement.setInt(2, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * This method will update the category name
	 * 
	 * @param category
	 * @return
	 */
	public static int updateCategoryName(Category category) {
		String query = "UPDATE Category SET name = ? WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setString(1, category.getName());
			statement.setInt(2, category.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * This method will delete the advertisement from advertisement table
	 * 
	 * @param id
	 * @return
	 */
	public static int deleteAdvertisement(int id) {
		String query = "DELETE FROM Advertisement WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
