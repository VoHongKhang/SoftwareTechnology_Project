package vn.DAO;

import vn.Entity.*;
import java.util.List;
public interface IThamGiaHoiDongDao {
	void update(ThamGiaHoiDong thamgia);
	
	void insert(ThamGiaHoiDong giangvien);
	
	void delete(int id)throws Exception;
	
	List<ThamGiaHoiDong> findAll();
	List<ThamGiaHoiDong> findAllByGiangVien(int ma);
}
