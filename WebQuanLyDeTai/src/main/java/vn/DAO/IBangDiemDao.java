package vn.DAO;

import java.util.List;

import vn.Entity.BangDiem;



public interface IBangDiemDao {
	List<BangDiem> findAll();
	BangDiem findById(int madetai);
	List<BangDiem> findByMaSinhVien(String madetai);
	void update(BangDiem detai);	
	
	void updatebyMadetai(int detai);
	
	void insert(BangDiem detai);
	void delete(int id) throws Exception;
	 BangDiem findbyMaSinhVien_and_detai(int madetai,String masinhvien);

}
