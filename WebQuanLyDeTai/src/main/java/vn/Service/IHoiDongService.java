package vn.Service;

import java.util.List;

import vn.Entity.HoiDong;

public interface IHoiDongService {
	List<HoiDong> findAll();

	HoiDong findById(int id);

	HoiDong findByUser_pass(String user, String pass);

	void update(HoiDong HoiDong);

	void insert(HoiDong HoiDong);
	HoiDong findByMaHoiDong(String ma);
}
