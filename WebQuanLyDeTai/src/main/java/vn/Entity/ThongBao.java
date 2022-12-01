package vn.Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ThongBao")
@NamedQuery(name = "ThongBao.findAll", query = "SELECT c FROM ThongBao c")
public class ThongBao implements Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Ten")
	private String tenthongbao;
	
	@Column(name = "MoTa")
	private String mota;
	
	@Column(name = "LoaiDeTai")
	private String loaidetai;
	
	@Column(name = "NgayBD")
	private Date ngaybatdau;
	
	@Column(name = "NgayKT")
	private String ngayketthuc;
	
	

	public String getLoaidetai() {
		return loaidetai;
	}

	public void setLoaidetai(String loaidetai) {
		this.loaidetai = loaidetai;
	}

	public Date getNgaybatdau() {
		return ngaybatdau;
	}

	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}

	public String getNgayketthuc() {
		return ngayketthuc;
	}

	public void setNgayketthuc(String ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}

	public ThongBao(int id, String tenthongbao, String mota, String loaidetai, Date ngaybatdau, String ngayketthuc) {
		super();
		this.id = id;
		this.tenthongbao = tenthongbao;
		this.mota = mota;
		this.loaidetai = loaidetai;
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
	}

	public ThongBao(int id, String tenthongbao, String mota) {
		super();
		this.id = id;
		this.tenthongbao = tenthongbao;
		this.mota = mota;
	}

	public ThongBao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenthongbao() {
		return tenthongbao;
	}

	public void setTenthongbao(String tenthongbao) {
		this.tenthongbao = tenthongbao;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}
	
	
}
