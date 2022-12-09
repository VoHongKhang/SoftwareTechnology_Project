package vn.DAO;

import vn.Entity.*;
import java.util.List;
public interface IThamGiaHoiDongDao {
	void update(ThamGiaHoiDong thamgia);
	
	void insert(ThamGiaHoiDong giangvien);
	
	List<ThamGiaHoiDong> findAll();
}
