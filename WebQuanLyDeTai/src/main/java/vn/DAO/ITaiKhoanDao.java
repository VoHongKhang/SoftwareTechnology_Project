package vn.DAO;

import java.util.List;

import vn.Entity.TaiKhoan;


public interface ITaiKhoanDao {
	List<TaiKhoan> findAll();

	TaiKhoan findById(int id);

	void update(TaiKhoan taikhoan);
	
	void insert(TaiKhoan taikhoan);
}
