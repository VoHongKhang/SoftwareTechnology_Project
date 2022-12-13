package vn.Service;

import java.util.List;

import vn.Entity.ThongBao;

public interface IThongBaoService {

	List<ThongBao> findAll();
	void insert(ThongBao thongbao);
	void update(ThongBao thongbao);
	void delete (int id)throws Exception;
	ThongBao findByID(int id);
}
