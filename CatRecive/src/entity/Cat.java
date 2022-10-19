package entity;
import java.util.Date;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;





@XmlRootElement
@XmlType(propOrder={"ma","ten","tuoi","canNang","nguoiChamSoc","gioiTinh","ngayDen"})

public class Cat {
	private int     ma;
	private String ten;
	private int    tuoi;
	private double canNang;
	private String nguoiChamSoc;
	private boolean gioiTinh;
	private Date ngayDen;
	
	
	public String getTen() {
		return ten;
	}
	
	
	@XmlElement
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	
	@XmlElement
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public double getCanNang() {
		return canNang;
	}
	
	@XmlElement
	public void setCanNang(double canNang) {
		this.canNang = canNang;
	}
	public String getNguoiChamSoc() {
		return nguoiChamSoc;
	}
	
	@XmlElement
	public void setNguoiChamSoc(String nguoiChamSoc) {
		this.nguoiChamSoc = nguoiChamSoc;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	@XmlElement
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgayDen() {
		return ngayDen;
	}
	
	@XmlElement
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	
	public int getMa() {
		return ma;
	}
	@XmlAttribute
	public void setMa(int ma) {
		this.ma = ma;
	}

	
	public Cat(int ma, String ten, int tuoi, double canNang, String nguoiChamSoc, boolean gioiTinh, Date ngayDen) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.tuoi = tuoi;
		this.canNang = canNang;
		this.nguoiChamSoc = nguoiChamSoc;
		this.gioiTinh = gioiTinh;
		this.ngayDen = ngayDen;
	}
	@Override
	public String toString() {
		return "Cat [ma=" + ma + ", ten=" + ten + ", tuoi=" + tuoi + ", canNang=" + canNang + ", nguoiChamSoc="
				+ nguoiChamSoc + ", gioiTinh=" + gioiTinh + ", ngayDen=" + ngayDen + "]";
	}


	public Cat() {
		super();
	}
	
	
	
	
	
	
	
	

}
