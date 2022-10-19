package Tuan4;

import java.util.Date;

public class khambenh {
	private String msbn;
	private String msbacsy;
	private Date ngaykham;
	private String ghichu;
	public khambenh(String msbn, String msbacsy, Date ngaykham, String ghichu) {
		this.msbn = msbn;
		this.msbacsy = msbacsy;
		this.ngaykham = ngaykham;
		this.ghichu = ghichu;
	}
	public khambenh() {
		
	}
	public String getMsbn() {
		return msbn;
	}
	public void setMsbn(String msbn) {
		this.msbn = msbn;
	}
	public String getMsbacsy() {
		return msbacsy;
	}
	public void setMsbacsy(String msbacsy) {
		this.msbacsy = msbacsy;
	}
	public Date getNgaykham() {
		return ngaykham;
	}
	public void setNgaykham(Date ngaykham) {
		this.ngaykham = ngaykham;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
	
}
