package vn.Service.Impl;

import java.util.List;

import vn.DAO.DeTaiDaoImpl;
import vn.DAO.IDeTaiDao;
import vn.Entity.DeTai;
import vn.Service.IDeTaiService;

public class DeTaiService implements IDeTaiService{

	IDeTaiDao detaiDao = new DeTaiDaoImpl();
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return detaiDao.count();
	}

	@Override
	public List<DeTai> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return detaiDao.findAll(page, pagesize);
	}

	@Override
	public List<DeTai> findByGiangVien(String vdname) {
		// TODO Auto-generated method stub
		return detaiDao.findByGiangVien(vdname);
	}

	@Override
	public List<DeTai> findAll() {
		// TODO Auto-generated method stub
		return detaiDao.findAll();
	}

	@Override
	public List<DeTai> findByLoaideTai(String vdname) {
		// TODO Auto-generated method stub
		return detaiDao.findByLoaideTai(vdname);
	}

	@Override
	public void delete(int madetai) throws Exception {
		// TODO Auto-generated method stub
		detaiDao.delete(madetai);
	}

	@Override
	public void update(DeTai detai) {
		// TODO Auto-generated method stub
		detaiDao.update(detai);
	}

	@Override
	public void insert(DeTai detai) {
		// TODO Auto-generated method stub
		detaiDao.insert(detai);
	}

}
