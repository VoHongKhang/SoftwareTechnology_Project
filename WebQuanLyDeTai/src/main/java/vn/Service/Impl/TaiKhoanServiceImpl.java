package vn.Service.Impl;

import java.util.List;


import vn.DAO.ITaiKhoanDao;
import vn.DAO.TaiKhoanDaoImpl;
import vn.Entity.TaiKhoan;
import vn.Service.ITaiKhoanService;

public class TaiKhoanServiceImpl implements ITaiKhoanService{
	ITaiKhoanDao taikhoanDao = new TaiKhoanDaoImpl(); 
	
	@Override
	public List<TaiKhoan> findAll() {
		return taikhoanDao.findAll();
	}

	@Override
	public void update(TaiKhoan sinhvien) {
		taikhoanDao.update(sinhvien);
	}

	@Override
	public TaiKhoan findById(int masinhvien) {
		return taikhoanDao.findById(masinhvien);
	}

	@Override
	public void insert(TaiKhoan taikhoan) {
		taikhoanDao.insert(taikhoan);	
	}

}
