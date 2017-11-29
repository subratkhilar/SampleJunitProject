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
import net.atos.Codex_IOT.model.AssetMapModel;
import net.atos.Codex_IOT.model.FTApiResponse;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.AssetMapping;
import net.atos.Codex_IOT.pojo.User;
import net.atos.Codex_IOT.service.AssetMapService;
import net.atos.Codex_IOT.service.AssetService;
import net.atos.Codex_IOT.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@RestController
@Api(value = "assetmap", tags = "Asset User Mapping")
@RequestMapping(value = "/assetusermap", produces = "application/json")
public class AssetUserMappingController {

	@Autowired
	Validator validator;

	@Autowired
	public UserService service;

	@Autowired
	public AssetService asstservice;

	@Autowired
	public AssetMapService mapservice;

	/**
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/getAssetbyUserID/{user_id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "get assett")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	public ResponseEntity getProjectbyUser(
			@ApiParam(value = "Get Project Data", required = true) @PathVariable("user_id") long user_id) {

		List<AssetMapping> assetmaplist = mapservice.getAssetList(user_id);
		List<Asset> assetlist = new ArrayList<Asset>();

		for (int i = 0; i < assetmaplist.size(); i++) {
			assetlist.add(assetmaplist.get(i).getAsset());
		}
		if (!assetlist.isEmpty())
			return ResponseEntity.status(200).body(assetlist);
		else
			return ResponseEntity.status(404).body("{\"error\":\" no data found.\"}");

	}

	/**
	 * @param assetmm
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	@CrossOrigin
	@RequestMapping(value = "/saveAssetmap", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Save Asset map")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "found data"),
			@ApiResponse(code = 404, message = "data not found") })
	@ResponseBody
	@Rollback(true)
	public ResponseEntity saveAssetmap(
			@ApiParam(value = "Saving Project Data", required = true) @RequestBody AssetMapModel assetmodelmap) {

		Set<ConstraintViolation<AssetMapModel>> violations = validator.validate(assetmodelmap);
		Map<String, String> errorListMap = new HashMap<>();
		for (ConstraintViolation<AssetMapModel> violation : violations) {
			errorListMap.put(violation.getPropertyPath().toString(), violation.getMessage());
		}

		if (violations.size() > 0) {

			return ResponseEntity.badRequest()
					.body(FTApiResponse.failureResponse("Bad request! Required field missing", errorListMap, 400));
		}

		AssetMapping assetmapping = new AssetMapping();
		User user = service.getUserbyId(assetmodelmap.getUserId());

		Asset asset = asstservice.getAssetbyId(assetmodelmap.getAssetId());

		assetmapping.setAssetmappingid(assetmodelmap.getAssetmappingid());
		assetmapping.setAsset(asset);
		assetmapping.setUser(user);
		mapservice.saveprojmap(assetmapping);
		return ResponseEntity.status(200).body("{\"success\":\"Data Saved.\"}");
	}

}
