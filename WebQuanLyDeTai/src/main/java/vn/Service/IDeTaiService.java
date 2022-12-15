package vn.Service;

import java.util.List;


import vn.Entity.DeTai;


public interface IDeTaiService {
	List<DeTai> findAll();

	DeTai findById(int madetai);

	void update(DeTai detai);
	
	void delete(int madetai) throws Exception;
	
	void insert(DeTai detai);
	
	List<DeTai> findByTenDeTai(String tendetai);
	
	DeTai findByMaDeTai(int tendetai);
	
	List<DeTai> findByTenGV(String giangvien);
	
	List<DeTai> findAllDaDuyet();
	List<DeTai> findByLoaiDeTai(String loaidetai);
	List<DeTai> findByChuyenNganh(String chuyennganh);

}
