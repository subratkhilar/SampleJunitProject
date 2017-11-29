package net.atos.Codex_IOT.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.Codex_IOT.dao.AssetMappingDao;
import net.atos.Codex_IOT.pojo.AssetMapping;


/**
 * @author a634945
 *
 */
@Service
@Transactional
public class AssetMapServiceImpl implements AssetMapService {

	@Autowired
	private AssetMappingDao assetMappingdao;
	
	
	@Override
	public List<AssetMapping> getAssetList(long id) {
		
		return assetMappingdao.getAssetList(id);
	}


	@Override
	public void saveprojmap(AssetMapping p) {
		
		assetMappingdao.saveprojmap(p);
	}

}
