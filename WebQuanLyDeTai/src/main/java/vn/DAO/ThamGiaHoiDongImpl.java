package vn.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.Entity.DeTai;
import vn.Entity.GiangVien;
import vn.Entity.ThamGiaHoiDong;
import vn.JPACongfig.JpaConfig;

public class ThamGiaHoiDongImpl implements IThamGiaHoiDongDao {

	@Override
	public void update(ThamGiaHoiDong thamgia) {
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//update
			enma.merge(thamgia);
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
	public void insert(ThamGiaHoiDong giangvien) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//thêm
			enma.persist(giangvien);
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
			// kiếm đề tài
			ThamGiaHoiDong detai = enma.find(ThamGiaHoiDong.class, id);
			if (detai != null) {
				// delete
				enma.remove(detai);
			} else {
				throw new Exception("Không tìm thấy");
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
	public List<ThamGiaHoiDong> findAll() {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<ThamGiaHoiDong> query = enma.createNamedQuery("ThamGiaHoiDong.findAll", ThamGiaHoiDong.class);
		return query.getResultList();
	}

	@Override
	public List<ThamGiaHoiDong> findAllByGiangVien(int ma) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM ThamGiaHoiDong c WHERE c.magiangvien = :ten";
		TypedQuery<ThamGiaHoiDong> query = enma.createQuery(jpql, ThamGiaHoiDong.class);
		query.setParameter("ten",ma);
		return query.getResultList();
	}

}
