package vn.DAO;

import java.util.List;



import vn.Entity.DeTai;



public interface IDeTaiDao {
	List<DeTai> findAll();

	DeTai findById(int madetai);

	void update(DeTai detai);
	
	void delete(int cateid) throws Exception;
	
	void insert(DeTai detai);
	
	List<DeTai> findByTenDeTai(String tendetai);
	
	DeTai findByMaDeTai(int madetai);
	
	List<DeTai> findByTenGV(String giangvien);
	
	List<DeTai> findAllDaDuyet();
	List<DeTai> findByLoaiDeTai(String loaidetai);
	
	List<DeTai> findByChuyenNganh(String chuyennganh);

}
