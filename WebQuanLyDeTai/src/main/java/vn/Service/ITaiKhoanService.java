package vn.Service;

import java.util.List;


import vn.Entity.TaiKhoan;

public interface ITaiKhoanService {
	
	List<TaiKhoan> findAll();
	
	TaiKhoan findById(int id);
	TaiKhoan findByUser_pass(String user,String pass);
	void update(TaiKhoan taikhoan);
	
	void insert(TaiKhoan taikhoan);
}
