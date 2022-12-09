package vn.Service;

import java.util.List;

import vn.Entity.ThamGiaHoiDong;

public interface IThamGiaHoiDongService {

	void update(ThamGiaHoiDong thamgia);	
	void insert(ThamGiaHoiDong giangvien);
	List<ThamGiaHoiDong> findAll();
}
