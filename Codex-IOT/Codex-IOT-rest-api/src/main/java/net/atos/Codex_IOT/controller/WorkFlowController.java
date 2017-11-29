package net.atos.Codex_IOT.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import net.atos.Codex_IOT.model.WorkflowModel;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Workflow;
import net.atos.Codex_IOT.service.AssetService;
import net.atos.Codex_IOT.service.CustomerService;
import net.atos.Codex_IOT.service.ProjectService;
import net.atos.Codex_IOT.service.SensorService;
import net.atos.Codex_IOT.service.UserService;
import net.atos.Codex_IOT.service.WorkflowService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author a631080
 *
 */
@RestController
@EnableSwagger2
@Api(value = "service_crud_workflow")
@RequestMapping(value = "/service_crud_workflow", produces = "application/json")
public class WorkFlowController {

	@Autowired
	private WorkflowService wservice;

	@Autowired
	private ProjectService pservice;

	@Autowired
	private SensorService sservice;

	@Autowired
	private CustomerService cservice;

	@Autowired
	private AssetService aservice;

	@Autowired
	private UserService uservice;



	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getDataByWorkflowID/{workflow_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Worklow")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getbyId(@PathVariable("workflow_id") long id){


		Workflow w  = wservice.getbyid(id);

		WorkflowModel model = new WorkflowModel();

		model.setWorkflowId(w.getWorkflowId());
		model.setUpdatedDate(w.getUpdatedDate());
		model.setEventType(w.getEventType());
		model.setMeadiaType(w.getMeadiaType());
		model.setMediaValue(w.getMediaValue());
		model.setActive(w.isActive());
		model.setCreatedDate(w.getCreatedDate());
		model.setUpdatedDate(w.getUpdatedDate());
		model.setNoOfOccurrences(w.getNoOfOccurrences());
		model.setUpperLimit(w.getUpperLimit());
		model.setLowerLimit(w.getLowerLimit());
		model.setSensorId(w.getSensor().getSensorId());
		model.setAssetId(w.getAsset().getAssetId());
		model.setProjectId(w.getProject().getProjectId());
		model.setCustomerId(w.getCustomer().getCustomerId());
		model.setUserId(w.getUser().getUserId());


		return ResponseEntity.status(200).body(model);

	}


	


	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getWorkflowByUserID/{user_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Worklow")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getbyUserId(@PathVariable("user_id") long userId) {

		List<Workflow> workflow = wservice.getbyUserId(userId);

		List<WorkflowModel> wmodel = new ArrayList<WorkflowModel>();

		for (int i = 0; i < workflow.size(); i++) {
			Workflow w = workflow.get(i);
			WorkflowModel model = new WorkflowModel();
			model.setWorkflowId(w.getWorkflowId());
			model.setUpdatedDate(w.getUpdatedDate());
			model.setEventType(w.getEventType());
			model.setMeadiaType(w.getMeadiaType());
			model.setMediaValue(w.getMediaValue());
			model.setActive(w.isActive());
			model.setCreatedDate(w.getCreatedDate());
			model.setUpdatedDate(w.getUpdatedDate());
			model.setNoOfOccurrences(w.getNoOfOccurrences());
			model.setUpperLimit(w.getUpperLimit());
			model.setLowerLimit(w.getLowerLimit());
			if (null != w.getSensor()) {
				model.setSensorId(w.getSensor().getSensorId());
			}
			if (null != w.getAsset()) {
				model.setAssetId(w.getAsset().getAssetId());
			}
			if (null != w.getProject()) {
				model.setProjectId(w.getProject().getProjectId());
			}
			if (null != w.getCustomer()) {
				model.setCustomerId(w.getCustomer().getCustomerId());
			}
			if (null != w.getUser()) {
				model.setUserId(w.getUser().getUserId());
			}

			wmodel.add(model);
		}

		return ResponseEntity.status(200).body(wmodel);
	}

	/**
	 * @param workflow
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/saveWorkflowData", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Saving Workflow Data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity saveWorkflow(@ApiParam(value = "Saving Workflow Data", required = true) @RequestBody WorkflowModel workflow){

		Workflow w = new Workflow();

		w.setActive(true);
		w.setEventType(workflow.getEventType());
		w.setLowerLimit(workflow.getLowerLimit());
		w.setUpperLimit(workflow.getUpperLimit());
		w.setCreatedDate(new Date());
		w.setUpdatedDate(new Date());
		w.setMeadiaType(workflow.getMeadiaType());
		w.setMediaValue(workflow.getMediaValue());
		w.setNoOfOccurrences(workflow.getNoOfOccurrences());
		w.setCustomer(cservice.findById(workflow.getCustomerId()));
		w.setAsset(aservice.getAssetbyId(workflow.getAssetId()));
		w.setProject(pservice.findProjectById(workflow.getProjectId()));
		w.setSensor(sservice.getSensorById(workflow.getSensorId()));
		w.setUser(uservice.getUserbyId(workflow.getUserId()));

		if("success".equals(wservice.save(w)))
			return ResponseEntity.status(200).body("{\"success\":\"Data Saved.\"}");
		else
			return ResponseEntity.status(400).body("{\"error\":\"Data Not Saved.\"}");
	}


	/**
	 * @param workflow
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/updateWorkflowData", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "update Workflow Data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity updateWorkflow(@ApiParam(value = "update Workflow Data", required = true) @RequestBody WorkflowModel workflow){

		Workflow w = wservice.getbyid(workflow.getWorkflowId());

		if(workflow.getEventType()!=null)
		{
			w.setEventType(workflow.getEventType());
		}
		w.setUpdatedDate(new Date());

		if(workflow.getMeadiaType()!=null)
		{
			w.setMeadiaType(workflow.getMeadiaType());
		}
		if(workflow.getMediaValue()!=null)
		{
			w.setMediaValue(workflow.getMediaValue());
		}
		if(workflow.getUpperLimit()!=0)
		{
			w.setUpperLimit(workflow.getUpperLimit());
		}
		if(workflow.getLowerLimit()!=0)
		{
			w.setLowerLimit(workflow.getLowerLimit());
		}
		if(workflow.getNoOfOccurrences()!=0)
		{
			w.setNoOfOccurrences(workflow.getNoOfOccurrences());
		}
		w.setActive(workflow.isActive());
		wservice.update(w);

		return ResponseEntity.status(200).body("{\"success\":\"Data Saved.\"}");
	}

	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getSensorsForWorkflowByAssetID/{asset_id}/{event_type}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get all sensors which is not associates to any workflow.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity allSensorsforWorkflow(@PathVariable("asset_id") String assetId, @PathVariable("event_type") String eventType) {
		List<Sensor> s = wservice.allSensorsforWorkflow(assetId, eventType);
		if (s == null) {
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");
		}
		return ResponseEntity.status(200).body(s);
	}




}
