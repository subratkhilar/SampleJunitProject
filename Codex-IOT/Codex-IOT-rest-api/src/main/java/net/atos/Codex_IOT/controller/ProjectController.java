package net.atos.Codex_IOT.controller;


import java.util.Date;
import java.util.List;

import javax.validation.Validator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import net.atos.Codex_IOT.model.ProjectDto;
import net.atos.Codex_IOT.model.ProjectModel;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.service.CustomerService;
import net.atos.Codex_IOT.service.ProjectService;
import net.atos.Codex_IOT.service.UserService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author a631080
 *
 */
@RestController
@EnableSwagger2
@Api(value = "project")
@RequestMapping(value = "/project", produces = "application/json")

public class ProjectController {
	private static final Logger logger = Logger
			.getLogger(EventController.class);
	
	/**
	 * 
	 */
	@Autowired
	public UserService service;
	
	/**
	 * 
	 */
	@Autowired
	public ProjectService projservice;
	
	/**
	 * 
	 */
	@Autowired
	public CustomerService  custservice;
	
	@Autowired
	Validator validator;
	
	/**
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Project Data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getProject()
	{
	
		  List<Project> project = projservice.get();
		
		  if(!project.isEmpty())
			  return ResponseEntity.status(200).body(project);
		  else
			  return ResponseEntity.status(200).body("{\"error\":\" no data found.\"}");
	}
	
	
	/**
	 * @param customer_id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getbycustomer/{customer_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Project by Customer ID all true status data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getProjectByCustomerId(@PathVariable("customer_id") long customer_id )
	{
		
		List<Project> project = projservice.findByCustomerId(customer_id);
		
		if(!project.isEmpty())
		return ResponseEntity.status(200).body(project);
		else
		return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");	
	}
	
	/**
	 * @param customer_id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getallbycustomer/{customer_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Project by Customer ID all status data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getAllProjectByCustomerId(@PathVariable("customer_id") long customer_id )
	{
		
		List<Project> project = projservice.findAllByCustomerId(customer_id);
		
		if(!project.isEmpty())
		return ResponseEntity.status(200).body(project);
		else
		return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");	
	}
	
	
	/**
	 * @param project_id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getbyid/{project_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Project by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getProjectById(@PathVariable("project_id") String project_id )
	{
	
		Project project = projservice.findProjectById(project_id);
		if(project==null){
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		}
		return ResponseEntity.status(200).body(project);
	}
	
	
	/**
	 * @param project
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Save Project")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity saveProject(@ApiParam(value = "Saving Project Data", required = true) @RequestBody ProjectModel project)
	{	
		
		Project projectById= projservice.findProjectById(project.getProjectId());
		if(null!=projectById && (projectById.getProjectId()).equalsIgnoreCase(project.getProjectId())){
			return ResponseEntity.status(405).body("{\"error\":\"Project id already exist.\"}");
		}
		
		projectById = new Project();
		projectById.setProjectId(project.getProjectId());
		projectById.setProjectName(project.getProjectName());
		projectById.setProjectLocation(project.getProjectLocation());
		projectById.setProjectDescription(project.getProjectDescription());
		projectById.setActive(true);
		projectById.setCreatedDate(new Date());
		projectById.setUpdatedDate(new Date());
		projectById.setLatitude(project.getLatitude());
		projectById.setLongitude(project.getLongitude());
		Customer customer = custservice.findById(project.getCustomerId());
		projectById.setCustomer(customer);
		projservice.save(projectById);
		return ResponseEntity.status(200).body("{\"success\":\"Data Saved.\"}");
	}
	
	
	/**
	 * @param project
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/update/{project_id}", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Update Project")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity updateProject(@ApiParam(value = "Updating project", required = true) @RequestBody ProjectModel project )
	{		
		
		
		
		Project projectById = projservice.findProjectById(project.getProjectId());
		Customer customer = custservice.findById(project.getCustomerId());
		if(project.getProjectName()!=null)
		{
			projectById.setProjectName(project.getProjectName());
		}
		if(project.getProjectLocation()!=null)
		{projectById.setProjectLocation(project.getProjectLocation());}
		if(project.getProjectDescription()!=null){
			projectById.setUpdatedDate(new Date());}
		if(project.getProjectDescription()!=null){
			projectById.setProjectDescription(project.getProjectDescription());}
		if(project.getCustomerId()!=0){
			projectById.setCustomer(customer);}
		if(project.getLatitude()!=null){
			projectById.setLatitude(project.getLatitude());}
		if(project.getLongitude()!=null){
			projectById.setLongitude(project.getLongitude());}
		projservice.update(projectById);
		return ResponseEntity.status(200).body("{\"success\":\"Data Update.\"}");
	}
	
	
	
	/**
	 * @param project_id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/delete/{project_id}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Delete Project")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity deleteProject(@PathVariable("project_id") String project_id  )
	{		
		
		projservice.delete(project_id);
		return ResponseEntity.status(200).body("{\"success\":\"Data Deleted.\"}");
	}
	

	/**
	 * @param projectId
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getProjectDetails/{project_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Project Details by id", response = ProjectDto.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getProjectDetailsById(@PathVariable("project_id") String projectId) {

		ProjectDto projectDto;
		try {
			projectDto = projservice.findProjectDetails(projectId);

		} catch (RuntimeException e) {
			logger.info("error in catch"+e);
			return ResponseEntity.status(404).body("{\"error\":\" id not found\"}");
		} catch (Exception e) {
			logger.info(e);
			return ResponseEntity.badRequest().body("{\"error\":\" internal error\"}");
		}
		return ResponseEntity.status(200).body(projectDto);

	}
	
	/**
	 * @param projectId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@CrossOrigin
	@RequestMapping(value = "/updateActiveState/{projectId}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Updating Project Active Status ", notes = "")
	@ApiResponses(value = { 
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 400, message = "Bad request! Required field missing"),
			@ApiResponse(code = 409, message = "Search results not found.") })
	
	public ResponseEntity updateSensorActiveState(@PathVariable String projectId){
			try {
				
				projservice.updateProjectActiveState(projectId);
				
			} catch (Exception e) {
				logger.info(e);
				return ResponseEntity.badRequest().body("{\"error\":\" Unable to update.\"}");
				
			}
			return ResponseEntity.status(200).body("{\"success\":\"Data Updated.\"}");
	}	
	
	
	
	
	
	
}
