package vn.Service.Impl;

import java.util.List;


import vn.DAO.DeTaiDaoImpl;
import vn.DAO.IDeTaiDao;
import vn.Entity.DeTai;
import vn.Service.IDeTaiService;


public class DeTaiServiceImpl implements IDeTaiService{
	IDeTaiDao detaiDao = new DeTaiDaoImpl(); 
	@Override
	public List<DeTai> findAll() {
		return detaiDao.findAll();
	}

	@Override
	public void update(DeTai detai) {
		detaiDao.update(detai);
	}

	@Override
	public DeTai findById(int madetai) {
		return detaiDao.findById(madetai);
	}

	@Override
	public void delete(int madetai) throws Exception {
		detaiDao.delete(madetai);
	}
	
	@Override
	public void insert(DeTai detai) {
		detaiDao.insert(detai);	
	}
	
}
