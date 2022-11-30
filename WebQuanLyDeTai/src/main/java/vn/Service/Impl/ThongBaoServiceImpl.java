package vn.Service.Impl;

import java.util.List;

import vn.DAO.IThongBaoDao;
import vn.DAO.ThongBaoDaoImpl;
import vn.Entity.ThongBao;

public class ThongBaoServiceImpl implements IThongBaoDao {

	IThongBaoDao thongbao=new ThongBaoDaoImpl();
	@Override
	public List<ThongBao> findAll() {
		// TODO Auto-generated method stub
		return thongbao.findAll();
	}

	@Override
	public void insert(ThongBao thongbao) {
		// TODO Auto-generated method stub
		this.thongbao.insert(thongbao);
	}

	@Override
	public void update(ThongBao thongbao) {
		// TODO Auto-generated method stub
		this.thongbao.update(thongbao);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		this.thongbao.delete(id);
	}

}
