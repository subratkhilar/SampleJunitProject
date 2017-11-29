package net.atos.Codex_IOT.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.atos.Codex_IOT.model.AssetModel;
import net.atos.Codex_IOT.model.AssetModels;
import net.atos.Codex_IOT.model.FTApiResponse;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.service.AssetService;
import net.atos.Codex_IOT.service.ProjectService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author a634945
 *
 */
@EnableSwagger2
@CrossOrigin
@RestController
@RequestMapping(value = "/Asset")
@Api(value = "/asset", description = "Fetch operations pertaining to IOt Application")
public class AssetController {
	

		private static final Logger logger = Logger
				.getLogger(AssetController.class);
		
		
		@Autowired
		private AssetService astservice;
		
		@Autowired
		public ProjectService projservice; 
		
		@Autowired
		Validator validator;
		
		
		/**
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/allasset", method = RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "Getting asset data ", notes = "", response = Asset.class)
		@ApiResponses(value = {
				@ApiResponse(code = 201, message = "asset are fetched."),
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "No  data found"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 409, message = "Search results not found.") })
		@ResponseBody
		public ResponseEntity getassetList()
		{
			logger.info("in  asset controller");
			
			List<Asset> assetlist= astservice.getassetList();
			if (assetlist == null || assetlist.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(
						FTApiResponse.failureResponse("no  data found", null,
								404));
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					FTApiResponse.successResponse("getAllAssets successful",
							assetlist));
					
		}
		
		/**
		 * @param assetdata
		 * @return
		 * @throws SQLException
		 */
		@SuppressWarnings({ "rawtypes" })
		@CrossOrigin
		@PostMapping(value = "/addAsset", produces = "application/json")
		@ApiOperation(value = "Validate User Credentials", notes = "", response = Asset.class)
		@ApiResponses(value = {
				@ApiResponse(code = 201, message = "Values is inserted"),
				@ApiResponse(code = 400, message = "values-not successfully inserted") })
		@ResponseBody
		public ResponseEntity addAsset(@RequestBody final AssetModel assetdata)
				throws SQLException {
			
			Asset asset= astservice.getAssetbyId(assetdata.getAssetId());
			if(null!=asset && (asset.getAssetId()).equalsIgnoreCase(assetdata.getAssetId())){
				return ResponseEntity.status(405).body("{\"error\":\"Asset id already exist.\"}");
			}
			
			asset = new Asset();
			asset.setAssetId(assetdata.getAssetId());
			asset.setAssetName(assetdata.getAssetName());
			asset.setAssetDesc(assetdata.getAssetDesc());
			asset.setAssetIpAddress(assetdata.getAssetIpAddress());
			asset.setAssetProtocol(assetdata.getAssetProtocol());
			asset.setAssetSerialNumber(assetdata.getAssetSerialNumber());
			asset.setCreatedDate(new Date());
			asset.setUpdatedDate(new Date());
			asset.setActive(true);
			asset.setProject(projservice.findProjectById(assetdata.getProjectId()));
			
			Asset asset1 = astservice.addAsset(asset);
						if (asset1 != null)
				return ResponseEntity.status(201).body(asset1);
			return ResponseEntity.status(404).body(asset1);
		}
		
		
		
		/**
		 * @param assetId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/getAssetbyId/{assetId}", method = RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "Getting asset data ", notes = "", response = Asset.class)
		@ApiResponses(value = {
				@ApiResponse(code = 201, message = "asset are fetched."),
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "No  data found"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 409, message = "Search results not found.") })
		@ResponseBody
		public ResponseEntity getAssetbyId(
				@ApiParam(value = "assetId", required = true) @PathVariable("assetId") final String assetId) {

			logger.info("in get Asset by id");
			final Asset assetuser = astservice.getAssetbyId(assetId);

			if (assetuser == null) {
				return ResponseEntity.status(404).body(FTApiResponse.failureResponse("No Aspects found for the given  userId :"+ assetId, null, 404));
			}

			return ResponseEntity.status(HttpStatus.OK).body(
					FTApiResponse.successResponse(
							"Successfull Able to fetch all Aspects for the assetId Id : "
									+ assetId, assetuser));

		}
		
		
		
		/**
		 * @param projectId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/getAssetbyprojId/{projectId}", method = RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "Getting asset by projsct id  data only true status ", notes = "", response = Asset.class)
		@ApiResponses(value = {
				@ApiResponse(code = 201, message = "asset are fetched."),
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "No  data found"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 409, message = "Search results not found.") })
		@ResponseBody
		public ResponseEntity getAssetbyprojId(
				@ApiParam(value = "projectId", required = true) @PathVariable("projectId")  String projectId) {

			logger.info("in get Asset by id");
			final List<Asset> assetlist= astservice.getAssetbyprojId(projectId);
			System.out.println("asset:-" +assetlist);
					
			if (assetlist.isEmpty()) {
				return ResponseEntity.status(404).body("{\"error\":\"Asset not found.\"}"); 
			}
			return ResponseEntity.status(200).body(assetlist); 
		
		}
		
		/**
		 * @param projectId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/getallAssetbyprojId/{projectId}", method = RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "Getting asset data by proj id with all status ", notes = "", response = Asset.class)
		@ApiResponses(value = {
				@ApiResponse(code = 201, message = "asset are fetched."),
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "No  data found"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 409, message = "Search results not found.") })
		@ResponseBody
		public ResponseEntity getallAssetbyprojId(
				@ApiParam(value = "projectId", required = true) @PathVariable("projectId")  String projectId) {

			logger.info("in get Asset by id");
			final List<Asset> assetlist= astservice.getallAssetbyprojId(projectId);
			System.out.println("asset:-" +assetlist);
					
			if (assetlist.isEmpty()) {
				return ResponseEntity.status(404).body("{\"error\":\"Asset not found.\"}"); 
			}
			return ResponseEntity.status(200).body(assetlist); 
		
		}
		
		
		
		
		/**
		 * @param assetId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/deleteAssetbyId/{assetId}", method = RequestMethod.DELETE, produces = "application/json")
		@ApiOperation(value = "Getting asset data ", notes = "", response = Asset.class)
		@ApiResponses(value = {
				@ApiResponse(code = 201, message = "asset are deleted."),
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 404, message = "No  data found"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 409, message = "Search results not found.") })
		@ResponseBody
		public ResponseEntity deleteAssetbyId(
				@ApiParam(value = "assetId", required = true) @PathVariable("assetId") final String assetId) {

		logger.info("in get Asset by id");
		
		final Asset assetuser = astservice.getAssetbyId(assetId);
		if(assetuser == null)
		{
			
			return ResponseEntity.status(404).body("{\"Delete Failed\":\"please check assetId.\"}");
		}
		astservice.deleteAssetbyId(assetId);
		return ResponseEntity.status(200).body("{\"success\":\"Data Deleted.\"}");
		
		
		
		
		}
		
		
		
		/**
		 * @param assetId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/updateActiveState/{assetId}", method = RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "Updating Asset Active Status ", notes = "")
		@ApiResponses(value = { 
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 409, message = "Search results not found.") })
		
		public ResponseEntity updateAssetActiveState(@PathVariable String assetId){
				try {
					
					astservice.updateAssetActiveState(assetId);
					
				} catch (Exception e) {
					logger.info(e);
					return ResponseEntity.badRequest().body("{\"error\":\" Unable to update.\"}");
					
				}
				return ResponseEntity.status(200).body("{\"success\":\"Data Updated.\"}");
		}
		
		/**
		 * @param customerId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/getallassetbycustomerid/{customerId}", method = RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "getting Asset Active Status data by CustomerID with only true  status", notes = "")
		@ApiResponses(value = { 
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 409, message = "Search results not found.") })
		
		public ResponseEntity getallassetbycustomerid(@PathVariable long customerId){
			logger.info("in get Asset by customer id");
			
			final List<Asset> assetlist= astservice.getallassetbycustomerid(customerId);			
			if (assetlist.isEmpty()) {
				return ResponseEntity.status(404).body("{\"error\":\"Asset not found.\"}"); 
			}
			List<AssetModels> assetModels=new ArrayList<>();
			for(Asset assetmodel : assetlist)
			{
			  	
				   AssetModels assetmodels1 =new AssetModels();
				   assetmodels1.setAssetId(assetmodel.getAssetId());
				   assetmodels1.setAssetName(assetmodel.getAssetName());
				   assetmodels1.setAssetDesc(assetmodel.getAssetDesc());
				   assetmodels1.setAssetIpAddress(assetmodel.getAssetIpAddress());
				   assetmodels1.setAssetProtocol(assetmodel.getAssetProtocol());
				   assetmodels1.setAssetSerialNumber(assetmodel.getAssetSerialNumber());
				   assetmodels1.setCreatedDate(assetmodel.getCreatedDate());
				   assetmodels1.setUpdatedDate(assetmodel.getUpdatedDate());
				   assetmodels1.setActive(assetmodel.isActive());
				   assetmodels1.setProjectId(assetmodel.getProject().getProjectId());
					logger.info("assetm" + assetmodels1.getProjectId());	
					assetModels.add(assetmodels1);
			
			}							
			return ResponseEntity.status(200).body(assetModels); 
			
					
		}
		
		
		@SuppressWarnings({ "rawtypes" })
		@CrossOrigin
		@RequestMapping(value = "/updateAsset", method = RequestMethod.POST)
		@ApiOperation(value = "Map Values", notes = "Mapdata", response = Asset.class)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "asset is updated"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 404, message = "assset-not successfully updated") })
		@ResponseBody
		public ResponseEntity updateasset(@ApiParam(value = "Updating project", required = true)@RequestBody AssetModel asset)
				throws SQLException {
			
			
			Asset assets = astservice.getAssetbyId(asset.getAssetId());
			Project project= projservice.findProjectById(asset.getProjectId());
			
			assets.setAssetId(asset.getAssetId());
				
			if(asset.getAssetSerialNumber()!=null)
				assets.setAssetSerialNumber(asset.getAssetSerialNumber());
			if(asset.getAssetName()!=null)
				assets.setAssetName(asset.getAssetName());
			if(asset.getAssetDesc()!=null)
				assets.setAssetDesc(asset.getAssetDesc());
			if(asset.getAssetIpAddress()!=null)
				assets.setAssetIpAddress(asset.getAssetIpAddress());
			if(asset.getAssetProtocol()!=null)
			{
				assets.setAssetProtocol(asset.getAssetProtocol());
			}
			assets.setUpdatedDate(new Date());
			if(asset.getProjectId()!=null)
				assets.setProject(project);
				
			astservice.updateasset(assets);
			return ResponseEntity.status(200).body("{\"success\":\"Data Update.\"}");
			

		}
		
		/**
		 * @param customerId
		 * @return
		 */
		@SuppressWarnings("rawtypes")
		@CrossOrigin
		@RequestMapping(value = "/getallassetbycustid/{customerId}", method = RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "getting all data by CustomerID with all status ", notes = "")
		@ApiResponses(value = { 
				@ApiResponse(code = 500, message = "Internal server error"),
				@ApiResponse(code = 400, message = "Bad request! Required field missing"),
				@ApiResponse(code = 409, message = "Search results not found.") })
		
		public ResponseEntity getallassetbycustid(@PathVariable long customerId){
logger.info("in get Asset by customer id");
			
			final List<Asset> assetlist= astservice.getallassetbycustid(customerId);
			if (assetlist.isEmpty()) {
				return ResponseEntity.status(404).body("{\"error\":\"Asset not found.\"}"); 
			}
			List<AssetModels> assetModels=new ArrayList<>();
			for(Asset assetmodel : assetlist)
			{
			  	
				   AssetModels assetmodels1 =new AssetModels();
					assetmodels1.setAssetId(assetmodel.getAssetId());
					assetmodels1.setAssetName(assetmodel.getAssetName());
					assetmodels1.setAssetDesc(assetmodel.getAssetDesc());
					assetmodels1.setAssetIpAddress(assetmodel.getAssetIpAddress());
					assetmodels1.setAssetProtocol(assetmodel.getAssetProtocol());
					assetmodels1.setAssetSerialNumber(assetmodel.getAssetSerialNumber());
					assetmodels1.setCreatedDate(assetmodel.getCreatedDate());
					assetmodels1.setUpdatedDate(assetmodel.getUpdatedDate());
					assetmodels1.setActive(assetmodel.isActive());
					assetmodels1.setProjectId(assetmodel.getProject().getProjectId());
					logger.info("assetm" + assetmodels1.getProjectId());	
					assetModels.add(assetmodels1);
			
			}							
			return ResponseEntity.status(200).body(assetModels); 
		
		
		}
		
		
		
		

	
	

}
