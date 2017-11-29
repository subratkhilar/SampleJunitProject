package net.atos.Codex_IOT.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.Codex_IOT.dao.TemperatureRepo;
import net.atos.Codex_IOT.model.UserModel;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Temperature;
import net.atos.Codex_IOT.service.SensorService;
import net.atos.Codex_IOT.service.TemperatureService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author a631080
 *
 */
@RestController
@EnableSwagger2
@Api(value = "temperature")
@RequestMapping(value = "/temperature", produces = "application/json")
public class TemperatureController {

	@Autowired
	TemperatureService service;
	
	@Autowired 
	public TemperatureRepo rep;
	
		
	@Autowired
	public SensorService sensorService;
	
	
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/get/{sensor_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Getting Temperature by sensor id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getTemperatureById(@PathVariable String sensor_id){
		
		
		List<Temperature> list = service.getTempbyID(sensor_id);
		
		if(list.isEmpty()){
			return ResponseEntity.status(400).body("{\"error\":\"data - not-  user.\"}"); 
		}
		return ResponseEntity.status(200).body(list);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Getting Temperature")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getTemperature(){
		
		List<Temperature> list = service.getTemperature();
		
		if(list.isEmpty()){
			return ResponseEntity.status(400).body("{\"error\":\"data - not-  find.\"}"); 
		}
		return ResponseEntity.status(200).body(list);
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/save/{sensor_id}", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Saving Temperature")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity saveTemperature(@PathVariable("sensor_id") String sensor_id){
		
		Date date = new Date();
		
		Random rand = new Random();
		Temperature temp = new Temperature();
		temp.setDate(date);
		temp.setTemperature(rand.nextInt(100));
		temp.setSensor(sensorService.getSensorById(sensor_id));
		
		service.save(temp);
		
		System.out.println("Data saved");
		return ResponseEntity.status(200).body("{\"success\":\"data saved\"}");
	}
	
	
}
