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
@Table(name = "DeTai")
@NamedQuery(name = "DeTai.findAll", query = "SELECT c FROM DeTai c")
public class DeTai implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Madetai")
	private int madetai;
	@Column(name = "TenDt")
	private String tendetai;
	@Column(name = "LoaiDt")
	private String loaidetai;
	@Column(name = "Soluongsv")
	private int soluongsv;
	@Column(name = "Giangvien")
	private String giangvien;
	public DeTai(int madetai, String tendetai, String loaidetai, int soluongsv, String giangvien) {
		super();
		this.madetai = madetai;
		this.tendetai = tendetai;
		this.loaidetai = loaidetai;
		this.soluongsv = soluongsv;
		this.giangvien = giangvien;
	}
	public DeTai() {
		super();
	}
	public int getMadetai() {
		return madetai;
	}
	public void setMadetai(int madetai) {
		this.madetai = madetai;
	}
	public String getTendetai() {
		return tendetai;
	}
	public void setTendetai(String tendetai) {
		this.tendetai = tendetai;
	}
	public String getLoaidetai() {
		return loaidetai;
	}
	public void setLoaidetai(String loaidetai) {
		this.loaidetai = loaidetai;
	}
	public int getSoluongsv() {
		return soluongsv;
	}
	public void setSoluongsv(int soluongsv) {
		this.soluongsv = soluongsv;
	}
	public String getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(String giangvien) {
		this.giangvien = giangvien;
	}
}
