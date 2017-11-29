package net.atos.Codex_IOT.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import net.atos.Codex_IOT.service.DashboardService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author a622890
 *
 */
@Controller
@EnableSwagger2
@RequestMapping(value = "/dashboard")
public class DashboardController {

	// Apache logger
	private static final Logger logger = Logger.getLogger(DashboardController.class);

	@Autowired
	DashboardService dashboardService;

	/**
	 * @param customerId
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/getNoOfProjects/{customerId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getNoOfPrjojects(@PathVariable("customerId") String customerId) {
		logger.info("inside getNoOfProjects()");
		String noOfProjects;
		try {
			noOfProjects = Integer.toString(dashboardService.getNoOfProjects(customerId));

		} catch (RuntimeException e) {
			logger.info(e);
			return ResponseEntity.status(404).body("{\"error\":\" id not found for count of projects\"}");
		} catch (Exception e) {
			logger.info(e);
			return ResponseEntity.badRequest().body("{\"error\":\" internal error while fetching count of project\"}");
		}
		return new ResponseEntity<String>(noOfProjects, HttpStatus.OK);
	}
	
	/**
	 * @param customerId
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/getNoOfAssets/{customerId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getNoOfAssets(@PathVariable("customerId") String customerId) {
		logger.info("inside getNoOfAssets()");

		String noOfAssets;
		try {
			noOfAssets = Integer.toString(dashboardService.getNoOfAssets(customerId));

		} catch (RuntimeException e) {
			logger.info(e);
			return ResponseEntity.status(404).body("{\"error\":\" id not found in count of asset\"}");
		} catch (Exception e) {
			logger.info(e);
			return ResponseEntity.badRequest().body("{\"error\":\" internal error while fetching count of asset\"}");
		}
		return new ResponseEntity<String>(noOfAssets, HttpStatus.OK);

	}

	
	/**
	 * @param customerId
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/getNoOfSensors/{customerId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getNoOfSensors(@PathVariable("customerId") String customerId) {
		logger.info("inside getNoOfSensors()");

		String noOfSensors;
		try {
			noOfSensors = Integer.toString(dashboardService.getNoOfSensors(customerId));

		} catch (RuntimeException e) {
			logger.info(e);
			return ResponseEntity.status(404).body("{\"error\":\" id not found in get no of sensors\"}");
		} catch (Exception e) {
			logger.info(e);
			return ResponseEntity.badRequest().body("{\"error\":\" internal error\"}");
		}
		return new ResponseEntity<String>(noOfSensors, HttpStatus.OK);

	}
	
	/**
	 * @param projectId
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/getNoOfAssetsByProjectId/{projectId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getNoOfAssetsByProjectId(@PathVariable("projectId") String projectId) {
		logger.info("inside getNoOfAssetByProjectId()");

		String noOfAsset;
		try {
			noOfAsset = Integer.toString(dashboardService.getNoOfAssetsByProjectId(projectId));

		} catch (RuntimeException e) {
			logger.info(e);
			return ResponseEntity.status(404).body("{\"error\":\" id not found\"}");
		} catch (Exception e) {
			logger.info(e);
			return ResponseEntity.badRequest().body("{\"error\":\" internal error\"}");
		}
		return new ResponseEntity<String>(noOfAsset, HttpStatus.OK);

	}
	
	/**
	 * @param assetId
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/getNoOfSensorsByAssetId/{assetId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getNoOfSensorsByAssetId(@PathVariable("assetId") String assetId) {
		logger.info("inside getNoOfSensorsByAssetId()");

		String noOfSensors;
		try {
			noOfSensors = Integer.toString(dashboardService.getNoOfSensorsByAssetId(assetId));

		} catch (RuntimeException e) {
			logger.info(e);
			return ResponseEntity.status(404).body("{\"error\":\" id not found for get no of sensors\"}");
		} catch (Exception e) {
			logger.info(e);
			return ResponseEntity.badRequest().body("{\"error\":\" internal error for get no of sensors\"}");
		}
		return new ResponseEntity<String>(noOfSensors, HttpStatus.OK);

	}
	
	

}
