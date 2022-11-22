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
@Table(name = "TaiKhoan")
@NamedQuery(name = "TaiKhoan.findAll", query = "SELECT c FROM TaiKhoan c")

public class TaiKhoan  implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Username")
	private String username;

	@Column(name = "Password")
	private String password;

	@Column(name = "PhanQuyen")
	private int phanquyen;
	
	// 0 là Admin
	// 1 là Trưởng bộ môn
	// 2 là Giảng viên
	// 3 là Sinh viên
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhanquyen() {
		return phanquyen;
	}
	public void setPhanquyen(int phanquyen) {
		this.phanquyen = phanquyen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TaiKhoan(int id, String username, String password, int phanquyen) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phanquyen = phanquyen;
	}
	public TaiKhoan() {
		super();
	}
}
