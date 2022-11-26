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
@Table(name = "BangDiem")
@NamedQuery(name = "BangDiem.findAll", query = "SELECT c FROM BangDiem c")
public class BangDiem implements Serializable {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "Madetai")
	private String madetai;
	
	@Column(name = "MaSinhVien")
	private String masinhvien;
	
	@Column(name = "Diem")
	private int diem;
	
	@Column(name = "NamHoc")
	private int namhoc;

	public BangDiem(int id, String madetai, String masinhvien, int diem, int namhoc) {
		super();
		this.id = id;
		this.madetai = madetai;
		this.masinhvien = masinhvien;
		this.diem = diem;
		this.namhoc = namhoc;
	}

	public BangDiem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMadetai() {
		return madetai;
	}

	public void setMadetai(String madetai) {
		this.madetai = madetai;
	}

	public String getMasinhvien() {
		return masinhvien;
	}

	public void setMasinhvien(String masinhvien) {
		this.masinhvien = masinhvien;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public int getNamhoc() {
		return namhoc;
	}

	public void setNamhoc(int namhoc) {
		this.namhoc = namhoc;
	}


}
