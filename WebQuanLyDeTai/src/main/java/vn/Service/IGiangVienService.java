package vn.Service;

import java.util.List;


import vn.Entity.GiangVien;

public interface IGiangVienService {
	List<GiangVien> findAll();

	GiangVien findById(int magiangvien);

	void update(GiangVien giangvien);
	
	void delete(int cateid) throws Exception;
	
	void insert(GiangVien giangvien);
	
	GiangVien findByTenGV(String tengv);
}
