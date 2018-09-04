package com.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.entity.Advertisement;
import com.facade.AdvertisementFacade;
import com.google.gson.Gson;

@Path("/advertisement")
public class AdvertisementResources {

	Gson gson = new Gson();

	/**
	 * This method will add advertisement in advertisement
	 * @param advertisement
	 * @param authorization
	 * @return
	 */
	@POST
	@Path("/addAdvertisement")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String addAdvertissement(Advertisement advertisement,
			@HeaderParam("Authorization") String authorization) {
		if (!"GET-2018".equals(authorization)) {
			return "Error: 401 Unauthorized";
		}
		return gson.toJson(AdvertisementFacade.getInstance().addAdvertisement(
				advertisement));
	}

	/**
	 * This method will retrieve advertisement list from advertisement
	 * @param advertisement
	 * @param authorization
	 * @return
	 */
	@GET
	@Path("/getAllAdvertisement")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String getAllAdvertisement(
			@HeaderParam("Authorization") String authorization) {
		if (!"GET-2018".equals(authorization)) {
			return "Error: 401 Unauthorized";
		}
		return gson.toJson(AdvertisementFacade.getInstance()
				.getAllAdvertisement());
	}

	/**
	 * This method will get advertisement list by category id
	 * @param advertisement
	 * @param authorization
	 * @return
	 */
	@GET
	@Path("/getAllAdvertisementByCategory/{categoryID}/advertisement")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String getAllAdvertisementByCategory(
			@javax.ws.rs.PathParam("categoryID") int categoryID,
			@HeaderParam("Authorization") String authorization) {
		if (!"GET-2018".equals(authorization)) {
			return "Error: 401 Unauthorized";
		}
		return gson.toJson(AdvertisementFacade.getInstance()
				.getAllAdvertisementByCategory(categoryID));
	}

	/**
	 * This method will update advertisement name
	 * @param advertisement
	 * @param authorization
	 * @return
	 */
	@PUT
	@Path("/updateAdvertisement")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String updateAdvertisementName(Advertisement advertisement,
			@HeaderParam("Authorization") String authorization) {
		if (!"GET-2018".equals(authorization)) {
			return "Error: 401 Unauthorized";
		}
		return gson.toJson(AdvertisementFacade.getInstance()
				.updateAdvertisement(advertisement));
	}

	/**
	 * This method will delete advertisement
	 * @param advertisement
	 * @param authorization will check authorization key
	 * @return
	 */
	@DELETE
	@Path("/deleteAdvertisement/{advertisementID}/delete")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String deleteAdvertisement(
			@javax.ws.rs.PathParam("advertisementID") int advertisementID,
			@HeaderParam("Authorization") String authorization) {
		if (!"GET-2018".equals(authorization)) {
			return "Error: 401 Unauthorized";
		}
		return gson.toJson(AdvertisementFacade.getInstance()
				.deleteAdvertisement(advertisementID));
	}
}
