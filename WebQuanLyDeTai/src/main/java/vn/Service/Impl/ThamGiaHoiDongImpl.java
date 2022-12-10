package vn.Service.Impl;
import java.util.List;

import vn.DAO.IThamGiaHoiDongDao;
import vn.Entity.ThamGiaHoiDong;
import vn.Service.IThamGiaHoiDongService;

public class ThamGiaHoiDongImpl implements IThamGiaHoiDongService {

	
	IThamGiaHoiDongDao sinhvienDao = new vn.DAO.ThamGiaHoiDongImpl(); 
	
	
	@Override
	public void update(ThamGiaHoiDong thamgia) {
		// TODO Auto-generated method stub
		sinhvienDao.update(thamgia);
		
	}

	@Override
	public void insert(ThamGiaHoiDong giangvien) {
		// TODO Auto-generated method stub
		sinhvienDao.insert(giangvien);
	}

	@Override
	public List<ThamGiaHoiDong> findAll() {
		// TODO Auto-generated method stub
		return sinhvienDao.findAll();
	}

	@Override
	public List<ThamGiaHoiDong> findAllByGiangVien(int ma) {
		// TODO Auto-generated method stub
		return sinhvienDao.findAllByGiangVien(ma);
	}

}
