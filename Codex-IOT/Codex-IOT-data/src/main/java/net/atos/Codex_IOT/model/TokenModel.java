package net.atos.Codex_IOT.model;

public class TokenModel {

	private long userId;
	
	private String deviceToken;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	@Override
	public String toString() {
		return "TokenModel [userId=" + userId + ", deviceToken=" + deviceToken
				+ "]";
	}
	
	
	
	
	
}
