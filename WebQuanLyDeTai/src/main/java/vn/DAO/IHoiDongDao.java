package vn.DAO;

import java.util.List;

import vn.Entity.HoiDong;

public interface IHoiDongDao {
	List<HoiDong> findAll();

	HoiDong findById(int id);
	HoiDong findByUser_pass(String userna,String pass);
	HoiDong findByMaHoiDong(int ma);

	void update(HoiDong taikhoan);
	
	void insert(HoiDong taikhoan);
}
