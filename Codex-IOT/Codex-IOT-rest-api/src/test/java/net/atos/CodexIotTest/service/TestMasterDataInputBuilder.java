package net.atos.CodexIotTest.service;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.atos.CodexIotTest.commonutility.CommonJsonUtility;
import net.atos.Codex_IOT.model.ProjectMapModel;
import net.atos.Codex_IOT.model.ProjectMappingModel;
import net.atos.Codex_IOT.model.ProjectModel;
import net.atos.Codex_IOT.model.SensorMapModel;
import net.atos.Codex_IOT.model.WorkflowModel;
import net.atos.Codex_IOT.model.AssetMapModel;
import net.atos.Codex_IOT.model.AssetModel;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Temperature;



@Component
public class TestMasterDataInputBuilder {

	@Autowired
	private CommonJsonUtility commonJsonUtility=new CommonJsonUtility();
	private Temperature temperature=new Temperature();
	private Project project=new Project();
	private Sensor sensor=new Sensor();
	private Asset asset=new Asset();
	private Customer customer=new Customer();
	private ProjectMapModel projectMapModel=new ProjectMapModel();
	private ProjectMappingModel projectMappingModel=new ProjectMappingModel();
	private ProjectModel projectModel=new ProjectModel();
	private SensorMapModel sensorMapModel=new SensorMapModel();
	private AssetMapModel assetMapModel = new AssetMapModel();
	private AssetModel assetModel = new AssetModel();

	String chk;
	
	
	public String saveTemperature() throws JsonProcessingException{
		temperature.setTempId(111);
		temperature.setDate(new Date());
		temperature.setTemperature(299);
		try{
		 chk= commonJsonUtility.getJsonStringForObject(temperature);
		System.out.println("chkkk "+chk);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return chk;
	}
	
	public String saveProject() throws JsonProcessingException{
		customer.setCustomerId(10);
		project.setProjectId("1101");
		project.setProjectName("Mindspere");
		project.setProjectLocation("Pune");
		project.setProjectDescription("Management");
		project.setLatitude("18.5204");
		project.setLongitude("73.8567");
		project.setCustomer(customer);
		try{
			 chk= commonJsonUtility.getJsonStringForObject(project);
			System.out.println("chkkk "+chk);
			}
			catch(Exception e){
				System.out.println(e);
			}
		return chk;
	
	}
	
	
	
	public String updateProject() throws JsonProcessingException{
		
		projectModel.setProjectId("11");
		projectModel.setCustomerId(4);
		projectModel.setProjectLocation("Pune");
		projectModel.setLatitude("18.5204");
		projectModel.setLongitude("73.8567");
		projectModel.setProjectName("Mindspere");
		projectModel.setProjectDescription("Development");
		try{
		 chk= commonJsonUtility.getJsonStringForObject(projectModel);
		System.out.println("chkkk "+chk);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return chk;
	}
	
	
	
	public String saveProjectmap() throws JsonProcessingException{
		
		projectMapModel.setProjectmappingid(222);
		projectMapModel.setProjectId("23");
		projectMapModel.setUserId(256);
		
		try{
		 chk= commonJsonUtility.getJsonStringForObject(projectMapModel);
		System.out.println("chkkk "+chk);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return chk;
	}
	
	
	
public String updateProjectMap() throws JsonProcessingException{
		
	projectMappingModel.setUserId(210);
	projectMappingModel.setProjectId("11");
		
		try{
		 chk= commonJsonUtility.getJsonStringForObject(projectMappingModel);
		System.out.println("chkkk "+chk);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return chk;
	}

	
	
	
	public String saveSensor() throws JsonProcessingException{
		asset.setAssetId("1061");
		sensor.setSensorId("102");
		sensor.setSensorSerialNumber("220ab");
		sensor.setAsset(asset);
		sensor.setSensorDescription("Sensor alarm");
		sensor.setSensorsName("Alarm sensor");
		sensor.setSensorTag("alarmsensor");
		sensor.setSensorDatatype("alarmtype");
		try{
			 chk= commonJsonUtility.getJsonStringForObject(sensor);
			System.out.println("chkkk "+chk);
			}
			catch(Exception e){
				System.out.println(e);
			}
		return chk;
	
	}
	
	
	public String updateSensor() throws JsonProcessingException{
		asset.setAssetId("100");
		sensor.setSensorId("1");
		sensor.setSensorSerialNumber("220ab");
		sensor.setAsset(asset);
		sensor.setSensorDescription("Sensor alarm");
		sensor.setSensorsName("Alarm sensor");
		sensor.setSensorTag("alarmsensor");
		sensor.setSensorDatatype("alarmtype");
		try{
			 chk= commonJsonUtility.getJsonStringForObject(sensor);
			System.out.println("chkkk "+chk);
			}
			catch(Exception e){
				System.out.println(e);
			}
		return chk;
	
	}
	
	public String saveSensormap() throws JsonProcessingException{
		sensorMapModel.setSensormappingid(123);
		sensorMapModel.setSensorId("6");
		sensorMapModel.setUserId(6);
		try{
			 chk= commonJsonUtility.getJsonStringForObject(sensorMapModel);
			System.out.println("chkkk "+chk);
			}
			catch(Exception e){
				System.out.println(e);
			}
		return chk;
	
	}
	
	public String saveWorkFlowData(){
		WorkflowModel w=new WorkflowModel();

		w.setActive(true);
		w.setEventType("notification");
		w.setLowerLimit(22);
		w.setUpperLimit(33);
		w.setCreatedDate(new Date());
		w.setUpdatedDate(new Date());
		w.setMeadiaType("333");
		w.setMediaValue("32");
		w.setNoOfOccurrences(22);
		w.setCustomerId(1);
		w.setAssetId("11");;
		w.setProjectId("check");
		w.setSensorId("");;
		w.setUserId(210);
		w.setWorkflowId(41);
		
		
		try{
			 chk= commonJsonUtility.getJsonStringForObject(w);
			System.out.println("chkkk "+chk);
			}
			catch(Exception e){
				System.out.println(e);
			}
		
		
			return chk;
	}
	
	public String addAsset() throws JsonProcessingException{
	
		assetModel.setAssetDesc("AssetMonitoring");
		assetModel.setProjectId("11");
		assetModel.setAssetId("205");
		assetModel.setAssetIpAddress("190.168.12.2");
		assetModel.setAssetName("Licences");
		assetModel.setAssetProtocol("IP");
		assetModel.setAssetSerialNumber("vv30111");
		

		try{
			 chk= commonJsonUtility.getJsonStringForObject(assetModel);
			System.out.println("chkkk "+chk);
			}
			catch(Exception e){
				System.out.println(e);
			}
		return chk;

	
	}
	//ProjectId and AssetId need to be exist in db
	public String updateAsset() throws JsonProcessingException{
		assetModel.setProjectId("14");
		assetModel.setAssetId("103");
		assetModel.setAssetDesc("AssetMonitoring");
		assetModel.setAssetIpAddress("190.168.12.1");
		assetModel.setAssetName("Monitor");
		assetModel.setAssetProtocol("IP");
		assetModel.setAssetSerialNumber("vv3009");
		
		
		try{
			 chk= commonJsonUtility.getJsonStringForObject(assetModel);
			System.out.println("chkkk "+chk);
			}
			catch(Exception e){
				System.out.println(e);
			}
		return chk;
	
	}
	
	public String saveAssetmap() throws JsonProcessingException{
		
		assetMapModel.setAssetId("106");
		assetMapModel.setAssetmappingid(7);
		assetMapModel.setUserId(270);
		
	     
		try{
			 chk= commonJsonUtility.getJsonStringForObject(assetMapModel);
			System.out.println("chkkk "+chk);
			}
			catch(Exception e){
				System.out.println(e);
			}
		return chk;
	
	}
	
	
}