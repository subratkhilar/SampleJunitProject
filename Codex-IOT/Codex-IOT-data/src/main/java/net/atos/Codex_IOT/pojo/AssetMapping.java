package net.atos.Codex_IOT.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author a634945
 *
 */
@Entity
@Table(name="AssetMapping",schema ="operationdb")
@NamedQuery(name="AssetMapping.findAll", query="SELECT a FROM AssetMapping a")
public class AssetMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="assetmapping_Id")
	private long assetmappingid;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ASSET_ID")
	private Asset asset;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "USER_ID")
	private User user;

	public long getAssetmappingid() {
		return assetmappingid;
	}

	public void setAssetmappingid(long assetmappingid) {
		this.assetmappingid = assetmappingid;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AssetMapping [assetmappingid=" + assetmappingid + ", asset="
				+ asset + ", user=" + user + "]";
	}
	
	
	

}
