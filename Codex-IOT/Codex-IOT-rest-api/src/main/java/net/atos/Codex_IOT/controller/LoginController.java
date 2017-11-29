package net.atos.Codex_IOT.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.Codex_IOT.model.AuthTokenInfo;
import net.atos.Codex_IOT.model.UserLogin;
import net.atos.Codex_IOT.model.UserModel;
import net.atos.Codex_IOT.pojo.User;
import net.atos.Codex_IOT.service.UserService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author a632972 This class is for login api
 *
 * 
 */
@RestController
@EnableSwagger2
@Api(value = "login")
@RequestMapping(value = "/login", method = RequestMethod.POST)
public class LoginController {

	
	/*public static final String AUTH_SERVER_URI ="https://mi-uaa.apps.eu01.cf.canopy-cloud.com"
			+ "/oauth/token?grant_type=password&";*/
	
	// Apache logger
	private static final Logger logger = Logger.getLogger(LoginController.class);
	// UserService Interface Reference

	@Autowired
	private UserService service;

	@Autowired
	private Environment env;


	/**
	 * @param user
	 * @return valid user along with http status
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Validate User Credentials", notes = "", response = UserModel.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "valid user"),
			@ApiResponse(code = 404, message = "un-authorized user") })
	@ResponseBody
	public ResponseEntity getValidatedUser(
			@ApiParam(value = "User credentials to be authenticated", required = true) @RequestBody UserLogin userLogin) {
	
		
		
		System.getProperties().put("http.proxyHost","proxy-in.glb.my-it-solutions.net");
		System.getProperties().put( "http.proxyPort", "84" );
		
		
		System.getProperties().put("https.proxyHost","proxy-in.glb.my-it-solutions.net");
		System.getProperties().put( "https.proxyPort", "84" );
		
		logger.info(userLogin.getUsername());
		logger.info(userLogin.getPassword());
		User user = new User();
		logger.info("inside login user");
		user.setUsername(userLogin.getUsername());
		user.setPassword(userLogin.getPassword());
		logger.info(user.getUsername());
		logger.info(user.getPassword());
		logger.info(env.getProperty("AUTH_SERVER_URI"));
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		header.set("Authorization", "Basic bW9iaWxlLWFwcDpzZWNyZXQ=");
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		HttpEntity entity = new HttpEntity(header);
		ResponseEntity<Object> response = null;
		logger.info("http header");
		try {
			response = restTemplate.exchange(
					env.getProperty("AUTH_SERVER_URI") + "&username=" + user.getUsername() + "&password=" + user.getPassword(),
					HttpMethod.POST, entity, Object.class);
		} catch (Exception e) {
			logger.error("Invalid User and pass");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\":\"un-authorized user.\"}");
		}
		logger.info(response);
		logger.info("token");
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();
		AuthTokenInfo tokenInfo;
		if (map != null) {
			tokenInfo = new AuthTokenInfo();
			tokenInfo.setAccessToken((String) map.get("access_token"));
			tokenInfo.setTokenType((String) map.get("token_type"));
			tokenInfo.setExpiresIn((int) map.get("expires_in"));
			tokenInfo.setScope((String) map.get("scope"));
			logger.info(tokenInfo);
		} else {
			logger.info("No user exist----------");

			logger.info("No user exist----------");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\":\"un-authorized user.\"}");

		}
		logger.info("After http header");

		User validUser = service.getValidateUser(user);
		if (validUser == null) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\":\"un-authorized user.\"}");

		}
		UserModel validUserModel = new UserModel();
		validUserModel.setFirstName(validUser.getFirstname());
		validUserModel.setLastName(validUser.getLastname());
		validUserModel.setUserid(validUser.getUserId());
		validUserModel.setUserName(validUser.getUsername());
		validUserModel.setRole(validUser.getRole());
		validUserModel.setCustomer(validUser.getCustomer());
		validUserModel.setAuthTokenInfo(tokenInfo);
		logger.info("User Name" + validUser.getFirstname());


		return ResponseEntity.status(200).body(validUserModel);

	}

}
