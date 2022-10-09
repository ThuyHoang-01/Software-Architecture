package entity;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Person {
	private long mssv;
	private String hoten;
	private Date ngaysinh;

	public Person(long mssv, String hoten, Date ngaysinh) {
		this.mssv = mssv;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
	}
	public Person() {
	}
	public long getMssv() {
		return mssv;
	}
	@XmlElement
	public void setMssv(long mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	@XmlElement
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	@XmlElement
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	@Override
	public String toString() {
		return mssv+"\t"+hoten+"\t"+ngaysinh;
	}

}
