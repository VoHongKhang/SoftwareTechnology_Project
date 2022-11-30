package vn.Service.Impl;

import java.util.List;

import vn.DAO.ISinhVienDao;
import vn.DAO.SinhVienDaoImpl;
import vn.Entity.SinhVien;
import vn.Service.ISinhVienService;


public class SinhVienServiceImpl implements ISinhVienService{

	ISinhVienDao sinhvienDao = new SinhVienDaoImpl(); 
	@Override
	public List<SinhVien> findAll() {
		return sinhvienDao.findAll();
	}

	@Override
	public void update(SinhVien sinhvien) {
		sinhvienDao.update(sinhvien);
	}

	@Override
	public SinhVien findById(int masinhvien) {
		return sinhvienDao.findById(masinhvien);
	}
	
	@Override
	public void delete(int masinhvien) throws Exception {
		sinhvienDao.delete(masinhvien);
	}
}
