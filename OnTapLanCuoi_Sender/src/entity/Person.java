package entity;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"ma","ten" ,"tuoi","canNang","gioiTinh","nguoiChamSoc","ngayDen"})
public class Person {
	private int ma;
	private String ten;
	private int tuoi;
	private String nguoiChamsoc;
	private boolean gioiTinh;
	private Date ngayDen;
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getNguoiChamsoc() {
		return nguoiChamsoc;
	}
	public void setNguoiChamsoc(String nguoiChamsoc) {
		this.nguoiChamsoc = nguoiChamsoc;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	public Person(int ma, String ten, int tuoi, String nguoiChamsoc, boolean gioiTinh, Date ngayDen) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.tuoi = tuoi;
		this.nguoiChamsoc = nguoiChamsoc;
		this.gioiTinh = gioiTinh;
		this.ngayDen = ngayDen;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
