package vn.Service;

import java.util.List;

import vn.Entity.DeTai;

public interface IDeTaiService {

	int count();

	List<DeTai> findAll(int page, int pagesize);

	List<DeTai> findByGiangVien(String vdname);

	List<DeTai> findAll();

	List<DeTai> findByLoaideTai(String vdname);
	
	void delete(int madetai) throws Exception;

	void update(DeTai detai);

	void insert(DeTai detai);
}
