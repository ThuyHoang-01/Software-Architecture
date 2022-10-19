package Tuan4;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class benhnhan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msbn;
	private String socmnd;
	private String hoten;
	private String diachi;
	
	public benhnhan(String msbn, String socmnd, String hoten, String diachi) {
		super();
		this.msbn = msbn;
		this.socmnd = socmnd;
		this.hoten = hoten;
		this.diachi = diachi;
	}
	public benhnhan() {
		
	}
	public String getMsbn() {
		return msbn;
	}
	public void setMsbn(String msbn) {
		this.msbn = msbn;
	}
	public String getSocmnd() {
		return socmnd;
	}
	public void setSocmnd(String socmnd) {
		this.socmnd = socmnd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	@Override
	public String toString() {
		return "benhnhan [msbn=" + msbn + ", socmnd=" + socmnd + ", hoten=" + hoten + ", diachi=" + diachi + "]";
	}
	
	
	
}
