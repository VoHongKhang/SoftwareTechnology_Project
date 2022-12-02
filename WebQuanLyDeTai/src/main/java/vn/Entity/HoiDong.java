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
<<<<<<< HEAD
	private String tenhoidong;

	public HoiDong(int mahoidong, String tenhoidong) {
=======
	private int tenhoidong;

	public HoiDong(int mahoidong, int tenhoidong) {
>>>>>>> 5a5fd0d1e4feaf4ab33ce42197ed0bfe6359c1f2
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

<<<<<<< HEAD
	public String getTenhoidong() {
		return tenhoidong;
	}

	public void setTenhoidong(String tenhoidong) {
=======
	public int getTenhoidong() {
		return tenhoidong;
	}

	public void setTenhoidong(int tenhoidong) {
>>>>>>> 5a5fd0d1e4feaf4ab33ce42197ed0bfe6359c1f2
		this.tenhoidong = tenhoidong;
	}
	
}
