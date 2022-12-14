package vn.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.Entity.BangDiem;
import vn.Entity.HoiDong;
import vn.Entity.TaiKhoan;
import vn.JPACongfig.JpaConfig;

public class BangDiemDaoImpl   implements IBangDiemDao{

	@Override
	public List<BangDiem> findAll() {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<BangDiem> query = enma.createNamedQuery("BangDiem.findAll", BangDiem.class);
		return query.getResultList();
	}

	@Override
	public BangDiem findById(int madetai) {
		EntityManager enma = JpaConfig.getEntityManager();
		BangDiem BangDiem = enma.find(BangDiem.class, madetai);
		return BangDiem;
	}

	@Override
	public List<BangDiem> findByMaSinhVien(String masinhvien) {
	
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<BangDiem> query=enma.createQuery("SELECT c from BangDiem c where c.masinhvien = :user ",BangDiem.class);
			
		query.setParameter("user",masinhvien);
		
		List<BangDiem> HoiDong=query.getResultList();
		return HoiDong;
	}

	@Override
	public void update(BangDiem bangdiem) {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//update
			enma.merge(bangdiem);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void insert(BangDiem bangdiem) {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//thêm
			enma.persist(bangdiem);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void delete(int id) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// tìm cate
			BangDiem detai = enma.find(BangDiem.class, id);
			if (detai != null) {
				//delete
				enma.remove(detai);
			} else {
				throw new Exception("Không tìm thấy!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void updatebyMadetai(int detai) {
		
	
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// tìm cate
			enma.createQuery("update c from BangDiem c where c.madetai = :pass",BangDiem.class).setParameter("pass",detai).executeUpdate();
			
		trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public BangDiem findbyMaSinhVien_and_detai(int madetai, String masinhvien) {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<BangDiem> query=enma.createQuery("SELECT c from BangDiem c where c.madetai = :user and c.masinhvien = :pass",BangDiem.class);
			
		query.setParameter("user",madetai);
		query.setParameter("pass",masinhvien);
		BangDiem HoiDong=(BangDiem) query.getSingleResult();
		return HoiDong;
	}

}
