package net.atos.Codex_IOT.model;

/**
 * @author a632972
 *
 */
public class AuthTokenInfo {

	/**
	 * {@link String} accessToken
	 */
	private String accessToken;
	/**
	 * {@link String} tokenType
	 */
	private String tokenType;
	/**
	 * {@link Integer} expiresIn
	 */
	private int expiresIn;
	/**
	 * {@link String} scope
	 */
	private String scope;
	public String getAccessToken() {
	    return accessToken;
	}
	/**
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken) {
	    this.accessToken = accessToken;
	}
	/**
	 * @return {@link String}tokenType
	 */
	public String getTokenType() {
	    return tokenType;
	}
	/**
	 * @param tokenType
	 */
	public void setTokenType(String tokenType) {
	    this.tokenType = tokenType;
	}
	/**
	 * @return expiresIn
	 */
	public int getExpiresIn() {
	    return expiresIn;
	}
	/**
	 * @param expiresIn
	 */
	public void setExpiresIn(int expiresIn) {
	    this.expiresIn = expiresIn;
	}
	/**
	 * @return scope
	 */
	public String getScope() {
	    return scope;
	}
	/**
	 * @param scope
	 */
	public void setScope(String scope) {
	    this.scope = scope;
	}
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthTokenInfo [accessToken=" + accessToken + ", tokenType="
				+ tokenType + ", expiresIn=" + expiresIn + ", scope=" + scope
				+ "]";
	}

	


	
}
