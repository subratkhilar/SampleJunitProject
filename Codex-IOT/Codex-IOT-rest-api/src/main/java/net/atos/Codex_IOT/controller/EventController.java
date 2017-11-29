package net.atos.Codex_IOT.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.Codex_IOT.model.EventModels;
import net.atos.Codex_IOT.model.IOTEventStatusModel;
import net.atos.Codex_IOT.pojo.Event;
import net.atos.Codex_IOT.service.EventService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
 * @author a622693
 *
 */

@RestController
@EnableSwagger2
@Api(value = "Event")
@RequestMapping(value = "/Event", produces = "application/json")
public class EventController {
	
	// Apache logger
			private static final Logger logger = Logger
					.getLogger(EventController.class);
			// UserService Interface Reference
	
	@Autowired
	EventService evs;
	
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get All Event")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getEvent()
	{
		
		List<Event> listEvent = evs.getallevent();
		if(listEvent.isEmpty()){
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		}
		return ResponseEntity.status(200).body(listEvent);
	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/getalleventbystatus/{status}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Getting asset by projsct id  data only true status ", notes = "", response = Event.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "asset are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing") })
	@ResponseBody
	public ResponseEntity getalleventbyStatus(
			@ApiParam(value = "status", required = true) @PathVariable("status")  String status) {

		logger.info("in get status id");
		final List<Event> eventlist= evs.geteventbystatus(status);
		System.out.println("event:-" +eventlist);
				
		if (eventlist.isEmpty()) {
			return ResponseEntity.status(401).body("{\"error\":\"Event not found.\"}"); 
		}
		return ResponseEntity.status(200).body(eventlist); 
	
	}
	
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/updateEvent", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Getting asset by projsct id  data only true status ", notes = "", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "asset are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing") })
	@ResponseBody
	public ResponseEntity updatEventByEventId( @RequestBody
			IOTEventStatusModel iotevent) {
		logger.info("in updatEventByEventId" + iotevent.getEventId());
		boolean msg=evs.updateEventByEventId(iotevent);
		System.out.println("event:-" +msg);
				
		if (msg) {
			return ResponseEntity.status(200).body("{\"success\":\"Data Updated.\"}"); 
		}
		return ResponseEntity.status(401).body("{\"error\":\"Event  updation failed.\"}"); 
			
	}
	
@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/getallEventbyCustomerID/{customerId}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Getting Event ", notes = "", response = Event.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Event are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"),
			@ApiResponse(code = 409, message = "Search results not found.") })
	@ResponseBody
	public ResponseEntity getallEventbyCustomerID(
			@ApiParam(value = "customerId", required = true) @PathVariable("customerId")  long customerId) {

		logger.info("in get Event by id");
		final List<EventModels>eventlist= evs.getallEventbyCustomerID(customerId);
		System.out.println("asset:-" +eventlist);
				
		if (eventlist.isEmpty()) {
			return ResponseEntity.status(404).body("{\"error\":\"eventlist not found.\"}"); 
		}
		return ResponseEntity.status(200).body(eventlist); 
	
	}
	
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/noOfEventsByCustomerId/{customerId}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Getting Event count ", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Event are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"), })
	@ResponseBody
	public ResponseEntity noOfEventsByCustomerId(@PathVariable("customerId") long customerId) {

		logger.info("inside noOfEventsByCustomerId()");
		int noOfEvents = evs.noOfEventsByCustomerId(customerId);

		if (noOfEvents==0) {
			return ResponseEntity.status(404).body("{\"error\":\"data not found.\"}");
		}
		return ResponseEntity.status(200).body(noOfEvents);

	}
	
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/updateAllEventStatus", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Updating Events status   ", notes = "")
	@ApiResponses(value = { 
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing") })
	@ResponseBody
	public ResponseEntity updateAllEventStatus(@RequestBody List<IOTEventStatusModel> iotEventStatusModels) {
		logger.info("inside updateAllEventStatus()");

		try {
			evs.updateAllEventStatus(iotEventStatusModels);
		} catch (RuntimeException e) {
			return ResponseEntity.status(405).body("{\"error\":\"All event status update failed.\"}");
		}

		return ResponseEntity.status(200).body("{\"success\":\"All event status updated.\"}");
	}
}
