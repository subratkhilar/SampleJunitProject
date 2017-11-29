package net.atos.Codex_IOT.mapper;

import java.util.ArrayList;
import java.util.List;

import net.atos.Codex_IOT.model.AssetModel;
import net.atos.Codex_IOT.model.ProjectModel;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Project;

import org.springframework.stereotype.Component;


/**
 * @author a634945
 *
 */
@Component
public class AssetMapper {
	
	/**
	 * @param assetModel
	 * @return
	 */
	public Asset mapAssetModelToAssetPojo(AssetModel assetModel)
	{

	if (assetModel != null)
	{
	Asset asset = new Asset();
	asset.setAssetId(assetModel.getAssetId());
	asset.setAssetSerialNumber(assetModel.getAssetSerialNumber());
	asset.setAssetName(assetModel.getAssetName());
	asset.setAssetDesc(assetModel.getAssetDesc());
	asset.setAssetIpAddress(assetModel.getAssetIpAddress());
	asset.setAssetProtocol(assetModel.getAssetProtocol());
	
	return asset;
	}
	return null;


	}
	
	/**
	 * @param projectmodels
	 * @return
	 */
	public List<Project> mapProjectModelListtoAssetList(List<ProjectModel> projectmodels)
	{
		
		final List<Project> projects = new ArrayList<Project>();
		for(final ProjectModel projectmodel : projectmodels ){
			
			projects.add(maptoProjectPojo(projectmodel));
	
	}
	
		return null;
				
	}
	
	private Project maptoProjectPojo(ProjectModel projectmodel)
	{
		final Project project = new Project();
		project.setProjectId(projectmodel.getProjectId());
		return project; 
	}
	
	/**
	 * @param asset
	 * @return
	 */
	public AssetModel mapAssetToAssetModel(Asset asset)
	{
		if (asset != null)
		{
		 AssetModel assetmodel = new AssetModel();
		 assetmodel.setAssetId(asset.getAssetId());
		 assetmodel.setAssetName(asset.getAssetName());
		 assetmodel.setAssetSerialNumber(asset.getAssetSerialNumber());
		 assetmodel.setAssetDesc(asset.getAssetDesc());
		 assetmodel.setAssetIpAddress(asset.getAssetIpAddress());
		 assetmodel.setAssetProtocol(asset.getAssetProtocol());
		 return assetmodel;
			
		}
			
		return null;
	}
	
	/**
	 * @param projects
	 * @return
	 */
	public List<ProjectModel> mapAssetListToProjectModelList(List<Project> projects)
	{
		final List<ProjectModel> projectModels = new ArrayList<ProjectModel>();
		for (final Project project : projects)
		{
			projectModels.add(mapTOProjectModel(project));
			
		}
		return projectModels;
	}
	
	private ProjectModel mapTOProjectModel(Project project)
	{
		final ProjectModel projectModel = new ProjectModel();
		projectModel.setProjectId(project.getProjectId());
		return projectModel;
		
		
	}
	
	

}
