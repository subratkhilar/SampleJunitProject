package net.atos.Codex_IOT.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.Codex_IOT.model.FTApiResponse;
import net.atos.Codex_IOT.model.ProjectMapModel;
import net.atos.Codex_IOT.model.ProjectMappingModel;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.ProjectMapping;
import net.atos.Codex_IOT.pojo.User;
import net.atos.Codex_IOT.service.CustomerService;
import net.atos.Codex_IOT.service.ProjectMapService;
import net.atos.Codex_IOT.service.ProjectService;
import net.atos.Codex_IOT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
@RestController
@Api(value = "projectmap",tags = "Project User Mapping")
@RequestMapping(value = "/projectusermap", produces = "application/json")
public class ProjectUserMappingContoller {

	
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
	 * 
	 */
	@Autowired
	public ProjectMapService mapservice;
	
	
	/**
	 * @param project
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/saveprojmap", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Save Project")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity saveProjectmap(@ApiParam(value = "Saving Project Data", required = true) @RequestBody ProjectMapModel project)
	{	
		
		Set<ConstraintViolation<ProjectMapModel>> violations = validator.validate(project);
		Map<String, String> errorListMap=new HashMap<>();
		for (ConstraintViolation<ProjectMapModel> violation : violations) {
			 errorListMap.put(violation.getPropertyPath().toString(), violation.getMessage());
		}
		
		if (violations.size() > 0) {

			return ResponseEntity.badRequest()
					.body(FTApiResponse.failureResponse("Bad request! Required field missing", errorListMap, 400));
		}
		
		
		ProjectMapping p = new ProjectMapping();
		User user =service.getUserbyId(project.getUserId());
		Project proj = projservice.findProjectById(project.getProjectId());
		
		p.setProjectmappingid(project.getProjectmappingid());
	
		p.setProject(proj);
		
		p.setUser(user);
		mapservice.saveprojmap(p);
		return ResponseEntity.status(200).body("{\"success\":\"Data Saved.\"}");
	}
	
	
	/**
	 * @param customer_id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getprojectAdminbycustomer/{customer_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "get project Admin by customerid")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getprojectAdminbycustomer(@PathVariable("customer_id") long customer_id )
	{
		
		List<User> p = mapservice.getprojectAdminbycustomer(customer_id);
		
		if(p.isEmpty())
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		return ResponseEntity.status(200).body(p);
		
			
	}
	
	
	/**
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getProjectbyUser/{user_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Save Project")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getProjectbyUser(@ApiParam(value = "Get Project Data", required = true) @PathVariable("user_id") long user_id)
	{	
		
		List<ProjectMapping> l = mapservice.getProjectList(user_id);
		List<Project> list = new ArrayList<Project>();
		
		for(int i = 0;i<l.size();i++){
			list.add(l.get(i).getProject());
		}
		if(!list.isEmpty())
			return ResponseEntity.status(200).body(list);
			else
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");	
	
	}
	
	
	/**
	 * @param project_id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getUserbyProject/{project_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Save Project")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getProjectbyUser(@ApiParam(value = "Get USer Data", required = true) @PathVariable String project_id)
	{	
		
		List<ProjectMapping> l = mapservice.getUser(project_id);
		List<User> list = new ArrayList<User>();
		
		for(int i = 0;i<l.size();i++){
			list.add(l.get(i).getUser());
		}
		if(!list.isEmpty())
			return ResponseEntity.status(200).body(list);
			else
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");	
	
	}
	

	
	/**
	 * @param model
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@PutMapping(value = "/updateProjectMap", produces = "application/json")
	@ApiOperation(value = "Update Project")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity updateProjectMap(@ApiParam(value = "Updating project", required = true) @RequestBody ProjectMappingModel model )
	{		
		
		List<ProjectMapping> l = mapservice.getUser(model.getProjectId());
		l.get(0).setUser(service.getUserbyId(model.getUserId()));
		ProjectMapping m = l.get(0);
		mapservice.updateProjectMapping(m);
		
		return ResponseEntity.status(200).body("{\"success\":\"Data Update.\"}");
	}
	
	
	
}
