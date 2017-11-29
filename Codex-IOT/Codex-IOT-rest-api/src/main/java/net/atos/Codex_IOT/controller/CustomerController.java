package net.atos.Codex_IOT.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@Api(value = "customer")
@RequestMapping(value = "/customer", produces = "application/json")
public class CustomerController {

	
	
	
	@Autowired
	CustomerService custservice;
	
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getCustomerbyId/{customer_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Customer by Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getCustomerById(@PathVariable("customer_id") int customer_id  )
	{
		
		Customer customer = custservice.findById(customer_id);
		if(customer==null){
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		}
		return ResponseEntity.status(200).body(customer);
	}
	
	
	
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getallCustomerList", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get All Customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getCustomer()
	{
		
		List<Customer> customerlist = custservice.findAll();
		if(customerlist.isEmpty()){
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		}
		return ResponseEntity.status(200).body(customerlist);
	}

	
}
