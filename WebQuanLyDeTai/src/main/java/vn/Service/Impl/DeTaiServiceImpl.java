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
	
	@Override
	public List<DeTai> findByTenDeTai(String tendetai) {
		return detaiDao.findByTenDeTai(tendetai);
	}
	
	@Override
	public DeTai findByMaDeTai(int madetai) {
		return detaiDao.findByMaDeTai(madetai);
	}
	
	@Override
	public List<DeTai> findByTenGV (String giangvien) {
		return detaiDao.findByTenGV(giangvien);
	}

	@Override
	public List<DeTai> findAllDaDuyet() {
		// TODO Auto-generated method stub
		return detaiDao.findAllDaDuyet();
	}

	@Override
	public List<DeTai> findByLoaiDeTai(String loaidetai) {
		// TODO Auto-generated method stub
		return detaiDao.findByLoaiDeTai(loaidetai);
	}

	@Override
	public List<DeTai> findByChuyenNganh(String chuyennganh) {
		// TODO Auto-generated method stub
		return detaiDao.findByChuyenNganh(chuyennganh);
	}
}
