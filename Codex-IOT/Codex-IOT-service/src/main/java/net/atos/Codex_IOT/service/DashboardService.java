package net.atos.Codex_IOT.service;

/**
 * @author a622890
 *
 */
public interface DashboardService {

	/**
	 * @param customerId
	 * @return
	 */
	public int getNoOfProjects(String customerId);

	/**
	 * @param customerId
	 * @return
	 */
	public int getNoOfAssets(String customerId);

	/**
	 * @param customerId
	 * @return
	 */
	public int getNoOfSensors(String customerId);

	/**
	 * @param projectId
	 * @return
	 */
	public int getNoOfAssetsByProjectId(String projectId);

	/**
	 * @param assetId
	 * @return
	 */
	public int getNoOfSensorsByAssetId(String assetId);
}
