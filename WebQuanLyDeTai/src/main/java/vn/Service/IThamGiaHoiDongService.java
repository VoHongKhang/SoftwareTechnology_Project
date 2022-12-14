package vn.Service;

import java.util.List;

import vn.Entity.ThamGiaHoiDong;

public interface IThamGiaHoiDongService {

	void update(ThamGiaHoiDong thamgia);	
	void insert(ThamGiaHoiDong giangvien);
	void delete(int id)throws Exception;
	List<ThamGiaHoiDong> findAll();
	List<ThamGiaHoiDong> findAllByGiangVien(int ma);
}
