package net.atos.Codex_IOT.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.Codex_IOT.model.FTApiResponse;
import net.atos.Codex_IOT.model.SensorModel;
import net.atos.Codex_IOT.model.SensorModels;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.service.AssetService;
import net.atos.Codex_IOT.service.SensorService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

@EnableSwagger2
@CrossOrigin
@RestController
@RequestMapping(value = "/sensor")
@Api(value = "/sensor", description = "Fetch operations pertaining to IOt Application")

public class SensorController {

	// Apache logger
	private static final Logger logger = Logger.getLogger(SensorController.class);

	@Autowired
	SensorService sensorservice;

	@Autowired
	AssetService assetservice;

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Getting sensor data ", notes = "", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sensors are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"),
			@ApiResponse(code = 409, message = "Search results not found.") })

	@ResponseBody
	public ResponseEntity getSensorsData() {
		logger.info("inside getsensordata");
		List<Sensor> sensorlist = sensorservice.getSensor();

		if (sensorlist == null || sensorlist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(FTApiResponse.failureResponse("no  data found", null, HttpStatus.OK.value()));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(FTApiResponse.successResponse("getAllAssets successful", sensorlist));

	}

	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getbyid/{sensor_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Project by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getSensorById(@PathVariable("sensor_id") String sensorId) {

		logger.info("inside getSensorById()");
		Sensor sensor = sensorservice.getSensorById(sensorId);
		if (sensor == null) {
			return ResponseEntity.status(404).body("{\"error\":\"no data found.\"}");
		}
		return ResponseEntity.status(200).body(sensor);
	}

	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getbyassetid/{asset_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Sensor by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getSensorByAssetId(@PathVariable("asset_id") String assetId) {
		logger.info("inside getSensorByAssetId()");
		List<Sensor> sensors = sensorservice.getSensorByAssetId(assetId);
		if (sensors.isEmpty()) {
			return ResponseEntity.status(404).body("{\"error\":\" no data found. \"}");
		}
		return ResponseEntity.status(200).body(sensors);
	}

	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getallsensorbyassetid/{asset_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Sensor by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getallSensorByAssetId(@PathVariable("asset_id") String assetId) {
		logger.info("inside getallSensorByAssetId()");
		List<Sensor> sensors = sensorservice.getallSensorByAssetId(assetId);
		if (sensors.isEmpty()) {
			return ResponseEntity.status(404).body("{\"error\":\" No data found.\"}");
		}
		return ResponseEntity.status(200).body(sensors);
	}

	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getbycustomerid/{customer_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get all only Sensor table list by customer id only true status")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getSensorByCustomerId(@PathVariable("customer_id") long customerId) {
		logger.info("inside getSensorByCustomerId()");
		List<Sensor> sensors = sensorservice.getSensorsByCustomerId(customerId);
		if (sensors.isEmpty()) {
			return ResponseEntity.status(404).body("{\"error\":\"no data found.\"}");
		}
		return ResponseEntity.status(200).body(sensors);
	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Saving sensor data ", notes = "", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sensors are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"),
			@ApiResponse(code = 409, message = "Search results not found.") })

	@ResponseBody
	public ResponseEntity saveSensor(
			@ApiParam(value = "Data to save sensor", required = true) @RequestBody SensorModel sensor) {
		logger.info("inside savesensor data");
		Sensor sensor1 = sensorservice.getSensorById(sensor.getSensorId());
		logger.info("after retriving sensor data by id " + sensor1);
		if (null != sensor1 && (sensor1.getSensorId()).equalsIgnoreCase(sensor.getSensorId())) {
			return ResponseEntity.status(405).body("{\"error\":\"Sensor id already exist.\"}");
		}

		sensor1 = new Sensor();
		sensor1.setSensorId(sensor.getSensorId());
		sensor1.setSensorSerialNumber(sensor.getSensorSerialNumber());
		sensor1.setAsset(assetservice.getAssetbyId(sensor.getAssetId()));
		sensor1.setCreatedDate(new Date());
		sensor1.setUpdatedDate(new Date());
		sensor1.setSensorDescription(sensor.getSensorDescription());
		sensor1.setActive(true);
		sensor1.setSensorsName(sensor.getSensorsName());
		sensor1.setSensorTag(sensor.getSensorTag());
		sensor1.setSensorDatatype(sensor.getSensorDatatype());

		Sensor sensor2 = sensorservice.saveSensor(sensor1);
		if (sensor2 != null) {
			return ResponseEntity.status(200).body("{\"success\":\" Data Saved.\"}");
		}
		return ResponseEntity.status(404).body("{\"success\":\"Data not Saved.\"}");

	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/update/{sensor_id}", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Updating sensor data ", notes = "", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sensors are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"),
			@ApiResponse(code = 409, message = "Search results not found.") })

	@ResponseBody
	public ResponseEntity updateSensor(
			@ApiParam(value = "Data to update sensor", required = true) @RequestBody SensorModel sensor,
			@PathVariable("sensor_id") String sensorId) {
		logger.info("inside update sensor data");

		Sensor sensor1 = sensorservice.getSensorById(sensorId);
		if (sensor.getSensorSerialNumber() != null)
			sensor1.setSensorSerialNumber(sensor.getSensorSerialNumber());
		if (sensor.getAssetId() != null) {
			sensor1.setAsset(assetservice.getAssetbyId(sensor.getAssetId()));
		}
		sensor1.setUpdatedDate(new Date());
		if (sensor.getSensorDescription() != null)
			sensor1.setSensorDescription(sensor.getSensorDescription());
		if (sensor.getSensorsName() != null)
			sensor1.setSensorsName(sensor.getSensorsName());

		if (sensor.getSensorTag() != null)
			sensor1.setSensorTag(sensor.getSensorTag());
		if (sensor.getSensorDatatype() != null)
			sensor1.setSensorDatatype(sensor.getSensorDatatype());

		sensorservice.updateSensor(sensor1);

		return ResponseEntity.status(200).body("{\"success\":\"Data Saved.\"}");

	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/delete/{sensor_id}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Deleting sensor data ", notes = "", response = Sensor.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "sensors are fetched."),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "No  data found"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"),
			@ApiResponse(code = 409, message = "Search results not found.") })

	@ResponseBody
	public ResponseEntity deleteSensor(@PathVariable("sensor_id") String sensorId) {
		logger.info("inside savesensordata");
		Sensor sensor = sensorservice.getSensorById(sensorId);
		sensor.setActive(false);
		sensor.setUpdatedDate(new Date());
		sensorservice.updateSensor(sensor);

		return ResponseEntity.status(200).body("{\"success\":\"Data Saved.\"}");

	}

	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/updateActiveState/{sensorId}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Updating Sensor Active Status ", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"),
			@ApiResponse(code = 409, message = "Search results not found.") })

	public ResponseEntity updateSensorActiveState(@PathVariable String sensorId) {

		logger.info("inside updateSensorActiveState()");

		try {

			sensorservice.updateSensorActiveState(sensorId);

		} catch (Exception e) {
			logger.info(e);
			return ResponseEntity.badRequest().body("{\"error\":\" Unable to update.\"}");

		}
		return ResponseEntity.status(200).body("{\"success\":\"Data Updated.\"}");
	}

	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getallbycustomerid/{customer_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Sensor by id with all status")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getallbycustomerId(@PathVariable("customer_id") long customerId) {
		logger.info("inside getallbycustomerId()");

		List<Sensor> sensors = sensorservice.getallSensorsByCustomerId(customerId);
		if (sensors.isEmpty()) {
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		}
		return ResponseEntity.status(200).body(sensors);
	}

	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getallsensorbycustomerid/{customer_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Sensor by id with all status")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getallSensorByCustomerId(@PathVariable("customer_id") long customerId) {

		logger.info("inside getallSensorByCustomerId()");
		List<Sensor> sensors = sensorservice.getallSensorsByCustomerId(customerId);
		if (sensors.isEmpty()) {
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		}
		List<SensorModels> sensorModels = new ArrayList<>();
		for (Sensor sensort : sensors)

		{
			SensorModels sensormo = new SensorModels();
			sensormo.setSensorId(sensort.getSensorId());
			sensormo.setSensorsName(sensort.getSensorsName());
			sensormo.setSensorSerialNumber(sensort.getSensorSerialNumber());
			sensormo.setSensorDatatype(sensort.getSensorDatatype());
			sensormo.setSensorDescription(sensort.getSensorDescription());
			sensormo.setSensorTag(sensort.getSensorTag());
			sensormo.setActive(sensort.isActive());
			sensormo.setCreatedDate(sensort.getCreatedDate());
			sensormo.setUpdatedDate(sensort.getUpdatedDate());
			sensormo.setAssetId(sensort.getAsset().getAssetId());
			logger.info("assetm" + sensormo.getAssetId());
			sensorModels.add(sensormo);

		}

		return ResponseEntity.status(200).body(sensorModels);
	}

	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getallsensorbycustomeridTrue/{customer_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Sensor by customer id only ture status")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getallSensorCustomerIdTrue(@PathVariable("customer_id") long customerId) {

		logger.info("inside getallSensorCustomerIdTrue()");
		List<Sensor> sensors = sensorservice.getallSensorCustomerIdTrue(customerId);
		if (sensors.isEmpty()) {
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		}
		List<SensorModels> sensorModels = new ArrayList<>();
		for (Sensor sensort : sensors)

		{
			SensorModels sensormo = new SensorModels();
			sensormo.setSensorId(sensort.getSensorId());
			sensormo.setSensorsName(sensort.getSensorsName());
			sensormo.setSensorSerialNumber(sensort.getSensorSerialNumber());
			sensormo.setSensorDatatype(sensort.getSensorDatatype());
			sensormo.setSensorDescription(sensort.getSensorDescription());
			sensormo.setSensorTag(sensort.getSensorTag());
			sensormo.setActive(sensort.isActive());
			sensormo.setCreatedDate(sensort.getCreatedDate());
			sensormo.setUpdatedDate(sensort.getUpdatedDate());
			sensormo.setAssetId(sensort.getAsset().getAssetId());
			logger.info("assetm" + sensormo.getAssetId());
			sensorModels.add(sensormo);

		}

		return ResponseEntity.status(200).body(sensorModels);
	}

}
