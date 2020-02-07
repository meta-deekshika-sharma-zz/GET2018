package com.resources;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import com.DAO.JDBCQuery;
import com.entity.Advertisement;
import com.entity.Category;
import com.facade.CategoryFacade;
import com.google.gson.Gson;

@Path("/category")
public class CategoryResources {

	Gson gson = new Gson();

	/**
	 * This method will retrieve category list
	 * @param authorization
	 * @return
	 */
	@GET
	@Path("/getCategories")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String getAllCategories(
			@HeaderParam("Authorization") String authorization) {
		if (!"GET-2018".equals(authorization)) {
			return "Error: 401 Unauthorized";
		}
		return gson.toJson(CategoryFacade.getInstance().getAllCategories());
	}

	/**
	 * This method will add category into database
	 * @param categoryName
	 * @param authorization
	 * @return
	 */
	@POST
	@Path("/addCategory")
	@Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String addCategory(String categoryName,
			@HeaderParam("Authorization") String authorization) {
		if (!"GET-2018".equals(authorization)) {
			return "Error: 401 Unauthorized";
		}

		return gson.toJson(CategoryFacade.getInstance()
				.addAdvertisementCategory(categoryName));
	}

	/**
	 * This method will update the category name
	 * @param category
	 * @param authorization
	 * @return
	 */
	@PUT
	@Path("/updateCategoryName")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String updateCategoryName(Category category,
			@HeaderParam("Authorization") String authorization) {
		if (!"GET-2018".equals(authorization)) {
			return "Error: 401 Unauthorized";
		}
		return gson.toJson(CategoryFacade.getInstance().updateCategoryName(
				category));
	}
}
