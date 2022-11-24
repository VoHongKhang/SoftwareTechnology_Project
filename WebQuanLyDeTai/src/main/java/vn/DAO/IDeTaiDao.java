package vn.DAO;

import java.util.List;


import vn.Entity.DeTai;


public interface IDeTaiDao {
	List<DeTai> findAll();

	DeTai findById(int madetai);

	void update(DeTai detai);
	
	void delete(int cateid) throws Exception;
	
	void insert(DeTai detai);
}
