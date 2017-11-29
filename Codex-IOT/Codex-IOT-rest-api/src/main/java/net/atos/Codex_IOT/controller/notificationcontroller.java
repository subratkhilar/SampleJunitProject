package net.atos.Codex_IOT.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.Codex_IOT.model.EventModel;
import net.atos.Codex_IOT.model.PushNotification;
import net.atos.Codex_IOT.model.TokenModel;
import net.atos.Codex_IOT.pojo.User;
import net.atos.Codex_IOT.service.NotificationService;
import net.atos.Codex_IOT.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author a622693
 *
 */


@RestController
@EnableSwagger2
@Api(value = "notification")
@RequestMapping("/notification")

public class notificationcontroller {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(notificationcontroller.class);
	
	public static final String IONIC_URI = "https://fcm.googleapis.com/fcm/send";
	
	@Autowired
	private UserService userService;
	@Autowired
	private NotificationService notificationService;
	
	/**
	 * constructor
	 */
	public notificationcontroller() {
		logger.info("In notification controller");
	}

	
	/**
	 * @param user
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/savedevicetoken", method = RequestMethod.PUT)
	@ApiOperation(value = "Save or Update ", notes = "", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "devicetoken"),
			@ApiResponse(code = 404, message = "token not found") })
	
	@ResponseBody
	public ResponseEntity saveDeviceToken(
			@ApiParam(name = "User", value = "user is and device id for specific user", required = true) @RequestBody TokenModel user)
	{
		logger.info("inside getting saveDeviceToken controller");
		User dummyUser = userService.getUserbyId(user.getUserId());
		dummyUser.setDeviceToken(user.getDeviceToken());
		if (userService.saveDeviceIdForSpecificUser(dummyUser)) // token
			return ResponseEntity.status(201).body("{\"success\":\"user device token updated sucessfully\"}");
		return ResponseEntity.status(401).body("{\"error\":\"User device token not updated.\"}");
	
    }

		
	
	/**
	 * @param eventm
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/notifyfromtable", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "sent notification to user", notes = "",response =PushNotification.class )
	@ApiResponses(value = { @ApiResponse(code = 201, message = "notification successfull"),
			@ApiResponse(code = 404, message = "notificationfailed") })
	@ResponseBody
	public ResponseEntity notifyfromeventtable ( 
			@ApiParam(name = "notified", value = "notification to user", required = true) @RequestBody EventModel eventm ) 
	{
		logger.info("inside push notification controller");
		
		boolean msg = notificationService.notifyfromeventtable(eventm);
		if (msg) {
			logger.info("inside notification :" + msg);
			return ResponseEntity.status(201).body("{\"success\":\"notification successfull.\"}");
		
		}
		return ResponseEntity.status(401).body("{\"error\":\"notification failed.\"}");
	}



}
