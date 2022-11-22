package vn.Service.Impl;

import java.util.List;

import vn.DAO.GiangVienDaoImpl;
import vn.DAO.IGiangVienDao;
import vn.Entity.GiangVien;
import vn.Service.IGiangVienService;


public class GiangVienServiceImpl implements IGiangVienService{
	IGiangVienDao giangvienDao = new GiangVienDaoImpl(); 
	@Override
	public List<GiangVien> findAll() {
		return giangvienDao.findAll();
	}

	@Override
	public void update(GiangVien giangvien) {
		giangvienDao.update(giangvien);
	}

	@Override
	public GiangVien findById(int magiangvien) {
		return giangvienDao.findById(magiangvien);
	}

	@Override
	public void delete(int cateid) throws Exception {
		giangvienDao.delete(cateid);
	}
	
}
