package net.atos.Codex_IOT.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.sql.SQLException;
import java.util.List;

import net.atos.Codex_IOT.model.FTApiResponse;
import net.atos.Codex_IOT.model.UserData;
import net.atos.Codex_IOT.model.UserModels;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Role;
import net.atos.Codex_IOT.pojo.User;
import net.atos.Codex_IOT.service.CustomerService;
import net.atos.Codex_IOT.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author a622890
 *
 */
@EnableSwagger2
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
@Api(value = "/user", description = "Fetch operations pertaining to IOt Application")
public class UserController {

	
	private static final Logger logger = Logger
			.getLogger(LoginController.class);


	@Autowired
	private UserService service;
	
	@Autowired
	private CustomerService custservice;

	@Autowired
	private Environment env;

	/**
	 * @param userdata
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Validate User Credentials", notes = "", response = UserModels.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Value is inserted"),
			@ApiResponse(code = 404, message = "value-not successfully inserted") })
	@ResponseBody
	public ResponseEntity addUser(@RequestBody final UserData userdata)
			throws SQLException {

		UserData user = this.service.addUser(userdata);
		if (user != null)
			return ResponseEntity.status(200).body(user);
		return ResponseEntity.status(401).body(user);

	}

	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/getUserbyId/{userId}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Getting User data for the given id", notes = "", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "data Fetch is successful"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! No data found for the given userId "),
			@ApiResponse(code = 409, message = "Search results not found.") })
	@ResponseBody
	public ResponseEntity getUserbyId(
			@ApiParam(value = "userId", required = true) @PathVariable("userId") final long userId) {

		logger.info("in get user by id");
		final User uuser = service.getUserbyId(userId);

		if (uuser == null) {
			return ResponseEntity.status(404).body(FTApiResponse.failureResponse("No data found for the given  userId :"+ userId, null, 404));
		}

		return ResponseEntity.status(HttpStatus.OK).body(
				FTApiResponse.successResponse(
						"Successfull Able to fetch all Aspects for the userId : "
								+ userId, uuser));

	}

	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/deleteUsrbyId/{userId}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "deleting User data for the given id", notes = "", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "data Fetch is successful"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! No data found for the given userId "),
			@ApiResponse(code = 409, message = "Search results not found.") })
	@ResponseBody
	public ResponseEntity deleteUsrbyId(
			@ApiParam(value = "userId", required = true) @PathVariable("userId") final long userId) {

		logger.info("in get user by id");
		final boolean msg = service.deleteUsrbyId(userId);

		if (msg)
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(FTApiResponse
							.successResponse(
									"Successfull Able to fetch all Aspects for the userId Id : ",
									userId));
		return ResponseEntity.status(404).body(FTApiResponse.failureResponse("No data found for the given  userId :"+ userId, null, 404));

	}

	/**
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/allusers", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Getting users data ", notes = "", response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "users are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"),
			@ApiResponse(code = 409, message = "Search results not found.") })
	@ResponseBody
	public ResponseEntity getusersData() {
		logger.info("inside getsensordata");
		List<User> userslist = service.getusersData();

		if (userslist == null || userslist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(
					FTApiResponse.failureResponse("no  data found", null,
							404));
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				FTApiResponse.successResponse("getAllAssets successful",
						userslist));

	}

	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	@ApiOperation(value = "user update values", notes = "Mapdata", response = UserModels.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Value is inserted"),
			@ApiResponse(code = 404, message = "value-not successfully inserted") })
	@ResponseBody
	public ResponseEntity updateuser(@RequestBody UserModels user)
			throws SQLException {
		
		User usr =service.getUserbyId(user.getUserId());
		Customer cust=custservice.findById(user.getCustomerId());
		Role role=service.getRolebyid(user.getRoleId());
		
	
		
		usr.setUserId(user.getUserId());
		if(user.getFirstname()!=null){
		usr.setFirstname(user.getFirstname());}
		if(user.getLastname()!=null){
		usr.setLastname(user.getLastname());}
		if(user.getPassword()!=null){
		usr.setPassword(user.getPassword());}
		if(user.getUsername()!=null){
		usr.setUsername(user.getUsername());}
		if(user.getDeviceToken()!=null){
		usr.setDeviceToken(user.getDeviceToken());}
		usr.setCustomer(cust);
		usr.setRole(role);
						
		service.updateuser(usr);
		return ResponseEntity.status(200).body("{\"success\":\"Data Update.\"}");

	}

}
