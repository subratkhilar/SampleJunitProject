/**
 * 
 */
package net.atos.Codex_IOT.model;

/**
 * @author a622693
 *
 */

public class PushNotification {

	private String to;
		
	private Data  data;



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */



	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}



	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}



	/**
	 * @return the data
	 */
	public Data getData() {
		return data;
	}



	/**
	 * @param data the data to set
	 */
	public void setData(Data data) {
		this.data = data;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "PushNotification [to=" + to + ", data=" + data + "]";
	}

	
}
