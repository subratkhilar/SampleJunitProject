package net.atos.Codex_IOT.service;

import java.util.List;

import net.atos.Codex_IOT.pojo.Asset;

/**
 * @author a634945
 *
 */
public interface AssetService {
	
	
		
	
	/**
	 * @return
	 */
	List<Asset> getassetList();

	/**
	 * @param assetId
	 * @return
	 */
	Asset getAssetbyId(String assetId);

	/**
	 * @param assetId
	 * @return
	 */
	boolean deleteAssetbyId(String assetId);

	/**
	 * @param asset
	 */
	void updateasset(Asset asset);

	/**
	 * @param assetdata
	 * @return
	 */
	public Asset addAsset(Asset assetdata);

	/**
	 * @param projectId
	 * @return
	 */
	public List<Asset> getAssetbyprojId(String projectId);
	
	/**
	 * @param assetId
	 */
	public void updateAssetActiveState(String assetId);

	/**
	 * @param customerId
	 * @return
	 */
	List<Asset> getallassetbycustomerid(long customerId);

	/**
	 * @param customerId
	 * @return
	 */
	List<Asset> getallassetbycustid(long customerId);

	/**
	 * @param projectId
	 * @return
	 */
	List<Asset> getallAssetbyprojId(String projectId);

}
