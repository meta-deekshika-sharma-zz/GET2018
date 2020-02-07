package com.facade;

import java.util.List;

import com.DAO.JDBCQuery;
import com.entity.Category;

public class CategoryFacade {

	public static CategoryFacade categoryFacade = new CategoryFacade();

	/**
	 * This method will return single instance of Category facade class
	 */
	public static CategoryFacade getInstance() {
		return categoryFacade;
	}

	/**
	 * This method will add an advertisement category into database
	 * 
	 * @param categoryName
	 * @return
	 */
	public boolean addAdvertisementCategory(String categoryName) {
		if (JDBCQuery.getCategoryId(categoryName) == 0) {
			if (JDBCQuery.insertCategory(categoryName) > 0)
				return true;
		}
		return false;
	}

	/**
	 * This method will retrieve categories from database
	 * 
	 * @return
	 */
	public List<Category> getAllCategories() {
		return JDBCQuery.getAllCategories();
	}

	/**
	 * This method will update the category name in database
	 * 
	 * @param category
	 * @return
	 */
	public int updateCategoryName(Category category) {
		if (JDBCQuery.isCategoryAvailable(category.getId())) {
			return JDBCQuery.updateCategoryName(category);
		}
		return 0;
	}
}
