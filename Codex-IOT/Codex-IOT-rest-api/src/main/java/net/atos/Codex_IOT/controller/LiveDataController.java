package net.atos.Codex_IOT.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.Codex_IOT.model.LiveDataModel;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Project;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@Api(value = "livedata")
@RequestMapping(value = "/livedata", method = RequestMethod.GET, produces = "application/json")
public class LiveDataController {

	
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/get/{sensor_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Live Data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getdata(@PathVariable("sensor_id") long sensor_id)
	{		 	List <LiveDataModel> data = new ArrayList<LiveDataModel>();
			    Random rand = new Random();
			    Date dt = new Date();
				LiveDataModel d = new LiveDataModel();
				d.setDate(dt);
				d.setKpiid("104");
				d.setTemperature(rand.nextInt(100));
				data.add(d);
			    return ResponseEntity.status(200).body(data);
		
	
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Live Data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity saveProject()
	{		 	
		List <LiveDataModel> data = new ArrayList<LiveDataModel>();
		Random rand = new Random();
		for(int i=0;i<=60;i++)
		{
			Date dt = new Date();
			LiveDataModel d = new LiveDataModel();
			d.setDate(dt);
			d.setKpiid("104");
			d.setTemperature(rand.nextInt(100));
			data.add(d);
		}
	 return ResponseEntity.status(200).body(data);
	}
	
	
	
}
