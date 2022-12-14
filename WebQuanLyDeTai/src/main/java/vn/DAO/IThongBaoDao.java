package vn.DAO;
import java.util.List;

import vn.Entity.ThongBao;
public interface IThongBaoDao {

	List<ThongBao> findAll();
	void insert(ThongBao thongbao);
	void update(ThongBao thongbao);
	void delete (int id)throws Exception;
	List<ThongBao> findConHan();
	
	ThongBao findByID(int id);
	
	
}
