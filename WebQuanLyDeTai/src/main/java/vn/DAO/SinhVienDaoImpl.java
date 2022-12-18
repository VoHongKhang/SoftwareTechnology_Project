package vn.DAO;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.Entity.DeTai;
import vn.Entity.SinhVien;
import vn.JPACongfig.JpaConfig;



public class SinhVienDaoImpl implements ISinhVienDao{
	@Override
	public void update(SinhVien sinhvien) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//update
			enma.merge(sinhvien);
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
	public void delete(int cateid) throws Exception {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// tìm cate
			SinhVien category = enma.find(SinhVien.class, cateid);
			if (category != null) {
				//delete
				enma.remove(category);
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
	public List<SinhVien> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<SinhVien> query = enma.createNamedQuery("SinhVien.findAll", SinhVien.class);
		return query.getResultList();
	}

	@Override
	public SinhVien findById(int masinhvien) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM SinhVien c WHERE c.masinhvien = :madetai";
		TypedQuery<SinhVien> query = enma.createQuery(jpql, SinhVien.class);
		query.setParameter("madetai",  masinhvien );
		return query.getSingleResult();
	}
	
	
	
}
