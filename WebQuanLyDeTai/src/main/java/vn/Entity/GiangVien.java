package vn.Entity;


import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "GiangVien")
@NamedQuery(name = "GiangVien.findAll", query = "SELECT c FROM GiangVien c")
public class GiangVien implements Serializable{
	
	@Id 
	@Column(name = "MaGiangVien")
	private int magiangvien;

	@Column(name = "Ten")
	private String ten;

	@Column(name = "NamSinh")
	private int namsinh;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "ChuyenNganh")
	private String chuyennganh;
	
	@Column(name = "LaTruongBoMon")
	private int latruongbomon;
	// 1 là trưởng bộ môn, 0 là giảng viên bình thường

	public int getMagiangvien() {
		return magiangvien;
	}

	public void setMagiangvien(int magiangvien) {
		this.magiangvien = magiangvien;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChuyennganh() {
		return chuyennganh;
	}

	public void setChuyennganh(String chuyennganh) {
		this.chuyennganh = chuyennganh;
	}

	public int getLatruongbomon() {
		return latruongbomon;
	}

	public void setLatruongbomon(int latruongbomon) {
		this.latruongbomon = latruongbomon;
	}

	public GiangVien(int magiangvien, String ten, int namsinh, String email, String chuyennganh, int latruongbomon) {
		super();
		this.magiangvien = magiangvien;
		this.ten = ten;
		this.namsinh = namsinh;
		this.email = email;
		this.chuyennganh = chuyennganh;
		this.latruongbomon = latruongbomon;
	}

	public GiangVien() {
		super();
	}
	
	
	
}
