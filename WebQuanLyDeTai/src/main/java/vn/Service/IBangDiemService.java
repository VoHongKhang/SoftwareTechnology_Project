package vn.Service;

import java.util.List;

import vn.Entity.BangDiem;

public interface IBangDiemService {
	List<BangDiem> findAll();
	BangDiem findById(int madetai);
	List<BangDiem> findByMaSinhVien(String madetai);
	void update(BangDiem detai);		
	void insert(BangDiem detai);
	void delete(int id) throws Exception;
	void updatebyMadetai(int detai);
	 BangDiem findbyMaSinhVien_and_detai(int madetai,String masinhvien);

}
