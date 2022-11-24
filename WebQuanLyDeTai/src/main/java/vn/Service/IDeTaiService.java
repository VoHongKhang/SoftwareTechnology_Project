package vn.Service;

import java.util.List;

import vn.Entity.DeTai;

public interface IDeTaiService {
	List<DeTai> findAll();

	DeTai findById(int madetai);

	void update(DeTai detai);
	
	void delete(int madetai) throws Exception;
	
	void insert(DeTai detai);
}
