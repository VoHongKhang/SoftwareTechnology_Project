package vn.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;






@SuppressWarnings("serial")
@Entity
@Table(name = "SinhVien")
@NamedQuery(name = "SinhVien.findAll", query = "SELECT c FROM SinhVien c")

public class SinhVien implements Serializable{
	

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaSinhVien")
	private int masinhvien;

	@Column(name = "Ten")
	private String ten;

	@Column(name = "NamSinh")
	private int namsinh;
	
	@Column(name = "KhoaHoc")
	private String khoahoc;
	
	@Column(name = "ChuyenNganh")
	private String chuyennganh;

	
	public int getMasinhvien() {
		return masinhvien;
	}

	public void setMasinhvien(int masinhvien) {
		this.masinhvien = masinhvien;
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

	public String getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(String khoahoc) {
		this.khoahoc = khoahoc;
	}

	public String getChuyennganh() {
		return chuyennganh;
	}

	public void setChuyennganh(String chuyennganh) {
		this.chuyennganh = chuyennganh;
	}

	public SinhVien(int masinhvien, String ten, int namsinh, String khoahoc, String chuyennganh) {
		super();
		this.masinhvien = masinhvien;
		this.ten = ten;
		this.namsinh = namsinh;
		this.khoahoc = khoahoc;
		this.chuyennganh = chuyennganh;
	}

	public SinhVien() {
		super();
	}
	
	
}
