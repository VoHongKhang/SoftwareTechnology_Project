package vn.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "HoiDong")
@NamedQuery(name = "HoiDong.findAll", query = "SELECT c FROM HoiDong c")

public class HoiDong implements Serializable{
	
	@Id 
	@Column(name = "MaHoiDong")
	private int mahoidong;
	
	@Column(name = "TenHoiDong")
	private String tenhoidong;
	
	@Column(name = "Truonghoidong")
	private String truonghoidong;
	

	public String getTruonghoidong() {
		return truonghoidong;
	}

	public void setTruonghoidong(String truonghoidong) {
		this.truonghoidong = truonghoidong;
	}

	public HoiDong(int mahoidong, String tenhoidong, String truonghoidong) {
		super();
		this.mahoidong = mahoidong;
		this.tenhoidong = tenhoidong;
		this.truonghoidong = truonghoidong;
	}

	public HoiDong(int mahoidong, String tenhoidong) {
		super();
		this.mahoidong = mahoidong;
		this.tenhoidong = tenhoidong;
	}

	public HoiDong() {
		super();
	}

	public int getMahoidong() {
		return mahoidong;
	}

	public void setMahoidong(int mahoidong) {
		this.mahoidong = mahoidong;
	}

	public String getTenhoidong() {
		return tenhoidong;
	}

	public void setTenhoidong(String tenhoidong) {
		this.tenhoidong = tenhoidong;
	}
	
}
