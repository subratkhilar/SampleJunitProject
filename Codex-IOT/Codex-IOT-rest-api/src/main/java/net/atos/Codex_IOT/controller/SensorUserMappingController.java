package net.atos.Codex_IOT.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.atos.Codex_IOT.model.AssetMapModel;
import net.atos.Codex_IOT.model.FTApiResponse;
import net.atos.Codex_IOT.model.SensorMapModel;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.AssetMapping;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.SensorMapping;
import net.atos.Codex_IOT.pojo.User;
import net.atos.Codex_IOT.service.SensorMappingService;
import net.atos.Codex_IOT.service.SensorService;
import net.atos.Codex_IOT.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@Api(value = "SensorMap",tags = "Sensor User Mapping")
@RequestMapping(value = "/sensorusermap", produces = "application/json")
public class SensorUserMappingController {

		@Autowired
		Validator validator;
		
		@Autowired
		public UserService service;
		
		@Autowired
		public SensorService sensorservice;
		
		@Autowired
		public SensorMappingService mapservice;
		
		@SuppressWarnings({ "rawtypes" })
		@CrossOrigin
		@RequestMapping(value = "/getSensorbyUser/{user_id}", method = RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "get sensor")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
				@ApiResponse(code = 404, message = "data not found") })
		@ResponseBody
		public ResponseEntity getSenosrbyUser(@ApiParam(value = "Get Sensor Data", required = true) @PathVariable("user_id") long user_id)
		{	
			
			List<SensorMapping> l = mapservice.getSensorList(user_id);
			List<Sensor> list = new ArrayList<Sensor>();
			
			for(int i = 0;i<l.size();i++){
				list.add(l.get(i).getSensor());
			}
			if(!list.isEmpty())
				return ResponseEntity.status(200).body(list);
				else
				return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");	
		
		}	
		
		@SuppressWarnings({ "rawtypes", "unused" })
		@CrossOrigin
		@RequestMapping(value = "/saveSensormap", method = RequestMethod.POST, produces = "application/json")
		@ApiOperation(value = "Save Sensor map")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
				@ApiResponse(code = 404, message = "data not found") })
		@ResponseBody
		public ResponseEntity saveAssetmap(@ApiParam(value = "Saving Project Data", required = true) @RequestBody SensorMapModel sensormm)
		{	
			
			Set<ConstraintViolation<SensorMapModel>> violations = validator.validate(sensormm);
			Map<String, String> errorListMap=new HashMap<>();
			for (ConstraintViolation<SensorMapModel> violation : violations) {
				 errorListMap.put(violation.getPropertyPath().toString(), violation.getMessage());
			}
			
			if (violations.size() > 0) {

				return ResponseEntity.badRequest()
						.body(FTApiResponse.failureResponse("Bad request! Required field missing", errorListMap, 400));
			}
			
			
			SensorMapping p = new SensorMapping();
			User user =service.getUserbyId(sensormm.getUserId());
			
			Sensor sensor = sensorservice.getSensorById(sensormm.getSensorId());
			
			p.setSensormappingid(sensormm.getSensormappingid());
			p.setSensor(sensor);
			p.setUser(user);
			
			
			mapservice.savesensormap(p);
			return ResponseEntity.status(200).body("{\"success\":\"Data Saved.\"}");
			
		}
		
	
	
}
