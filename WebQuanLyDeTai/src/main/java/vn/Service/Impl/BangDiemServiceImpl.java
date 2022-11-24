package vn.Service.Impl;

import java.util.List;

import vn.DAO.BangDiemDaoImpl;
import vn.DAO.IBangDiemDao;
import vn.Entity.BangDiem;
import vn.Service.IBangDiemService;

public class BangDiemServiceImpl  implements IBangDiemService{

	IBangDiemDao bangdiem= new BangDiemDaoImpl();
	@Override
	public List<BangDiem> findAll() {
		// TODO Auto-generated method stub
		return bangdiem.findAll();
	}

	@Override
	public BangDiem findById(int madetai) {
		// TODO Auto-generated method stub
		return bangdiem.findById(madetai);
	}

	@Override
	public BangDiem findByMaSinhVien(int madetai) {
		// TODO Auto-generated method stub
		return bangdiem.findByMaSinhVien(madetai);
	}

	@Override
	public void update(BangDiem detai) {
		// TODO Auto-generated method stub
		bangdiem.update(detai);
	}

	@Override
	public void insert(BangDiem detai) {
		// TODO Auto-generated method stub
		bangdiem.insert(detai);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		bangdiem.delete(id);
	}

}
