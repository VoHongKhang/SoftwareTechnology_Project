package vn.Service.Impl;

import java.util.List;

import vn.DAO.IHoiDongDao;
import vn.DAO.HoiDongDaoImpl;
import vn.Entity.HoiDong;
import vn.Service.IHoiDongService;

public class HoiDongServiceImpl implements IHoiDongService {
	IHoiDongDao hoidongDao = new HoiDongDaoImpl();

	@Override
	public List<HoiDong> findAll() {
		return hoidongDao.findAll();
	}

	@Override
	public void update(HoiDong sinhvien) {
		hoidongDao.update(sinhvien);
	}

	@Override
	public HoiDong findById(int masinhvien) {
		return hoidongDao.findById(masinhvien);
	}

	@Override
	public void insert(HoiDong HoiDong) {
		hoidongDao.insert(HoiDong);
	}

	@Override
	public HoiDong findByUser_pass(String user, String pass) {
		// TODO Auto-generated method stub
		return hoidongDao.findByUser_pass(user, pass);
	}

	@Override
	public HoiDong findByMaHoiDong(String ma) {
		// TODO Auto-generated method stub
		return hoidongDao.findByMaHoiDong(ma);
	}
}
