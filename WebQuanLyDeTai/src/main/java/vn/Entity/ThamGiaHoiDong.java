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
@Table(name = "ThamGiaHoiDong")
@NamedQuery(name = "ThamGiaHoiDong.findAll", query = "SELECT c FROM ThamGiaHoiDong c")
public class ThamGiaHoiDong implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "MaHoiDong")
	private int mahoidong;
	
	@Column(name = "MaGiangVien")
	private int magiangvien;

	public ThamGiaHoiDong() {
		super();
	}

	public ThamGiaHoiDong(int mahoidong, int magiangvien) {
		super();
		this.mahoidong = mahoidong;
		this.magiangvien = magiangvien;
	}

	public int getMahoidong() {
		return mahoidong;
	}

	public void setMahoidong(int mahoidong) {
		this.mahoidong = mahoidong;
	}

	public int getMagiangvien() {
		return magiangvien;
	}

	public void setMagiangvien(int magiangvien) {
		this.magiangvien = magiangvien;
	}
	
}
