package vn.Service;

import java.util.List;

import vn.Entity.BangDiem;

public interface IBangDiemService {
	List<BangDiem> findAll();
	BangDiem findById(int madetai);
	BangDiem findByMaSinhVien(int madetai);
	void update(BangDiem detai);		
	void insert(BangDiem detai);
	void delete(int id) throws Exception;

}
