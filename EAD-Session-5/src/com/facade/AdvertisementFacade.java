package com.facade;

import java.util.List;

import com.DAO.JDBCQuery;
import com.entity.Advertisement;

public class AdvertisementFacade {

	public static AdvertisementFacade advertisement = new AdvertisementFacade();

	/**
	 * This method will return the single instance of the Advertisement facade
	 * class
	 * 
	 * @return
	 */
	public static AdvertisementFacade getInstance() {
		return advertisement;
	}

	/**
	 * This class will retrieve advertisement list from database
	 * 
	 * @return
	 */
	public List<Advertisement> getAllAdvertisement() {
		return JDBCQuery.getAllAdvertisement();
	}

	/**
	 * This method will retrieve advertisement list by category id
	 * 
	 * @param categoryID
	 * @return
	 */
	public List<Advertisement> getAllAdvertisementByCategory(int categoryID) {
		if (JDBCQuery.isCategoryAvailable(categoryID)) {
			return JDBCQuery.getAllAdvertisementByCategoryID(categoryID);
		}
		return null;
	}

	/**
	 * This method will add an advertisement into databse
	 * 
	 * @param advertisement
	 * @return
	 */
	public int addAdvertisement(Advertisement advertisement) {
		if (JDBCQuery.isCategoryAvailable(advertisement.getCategoryID())) {
			return JDBCQuery.insertAdvertisement(advertisement);
		}
		return 0;
	}

	/**
	 * This mehtod will update the name of an advertisement
	 * 
	 * @param advertisement
	 * @return
	 */
	public int updateAdvertisement(Advertisement advertisement) {
		if (JDBCQuery.isAdvertisementAvailable(advertisement.getId())) {
			JDBCQuery.updateAdvertisementTitle(advertisement.getTitle(),
					advertisement.getId());
		}
		return 0;
	}

	/**
	 * This method will delete the advertisement from databse
	 * 
	 * @param id
	 * @return
	 */
	public int deleteAdvertisement(int id) {
		if (JDBCQuery.isAdvertisementAvailable(id)) {
			return JDBCQuery.deleteAdvertisement(id);
		}
		return 0;
	}
}
