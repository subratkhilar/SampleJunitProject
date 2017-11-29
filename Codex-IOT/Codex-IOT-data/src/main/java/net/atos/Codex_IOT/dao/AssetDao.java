package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.Asset;

/**
 * @author a634945
 *
 */
public interface AssetDao {

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
	 * @param asset
	 * @return
	 */
	boolean deleteAssetbyId(Asset asset);

	/**
	 * @param asset
	 */
	public void updateasset(Asset asset);

	/**
	 * @param asset
	 * @return
	 */
	public Asset addAsset(Asset asset);

	/**
	 * @param projectId
	 * @return
	 */
	List<Asset> getAssetbyprojId(String projectId);

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
