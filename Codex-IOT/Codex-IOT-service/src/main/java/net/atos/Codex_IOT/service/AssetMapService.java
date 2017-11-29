package net.atos.Codex_IOT.service;

import java.util.List;

import net.atos.Codex_IOT.pojo.AssetMapping;

/**
 * @author a634945
 *
 */
public interface AssetMapService {
	
	/**
	 * @param id
	 * @return
	 */
	List<AssetMapping> getAssetList(long id);

	/**
	 * @param p
	 */
	void saveprojmap(AssetMapping p); 

}
