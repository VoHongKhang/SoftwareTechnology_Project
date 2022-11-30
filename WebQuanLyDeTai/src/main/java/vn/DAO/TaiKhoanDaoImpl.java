package vn.DAO;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import vn.Entity.TaiKhoan;
import vn.JPACongfig.JpaConfig;



public class TaiKhoanDaoImpl implements ITaiKhoanDao{
	@Override
	public void update(TaiKhoan taikhoan) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//update
			enma.merge(taikhoan);
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
	public void insert(TaiKhoan taikhoan) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//thêm
			enma.persist(taikhoan);
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
	public List<TaiKhoan> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<TaiKhoan> query = enma.createNamedQuery("TaiKhoan.findAll", TaiKhoan.class);
		return query.getResultList();
	}

	@Override
	public TaiKhoan findById(int id) {
		EntityManager enma = JpaConfig.getEntityManager();
		TaiKhoan taikhoan = enma.find(TaiKhoan.class, id);
		return taikhoan;
	}
	@Override
	public TaiKhoan findByUser_pass(String userna,String pass) {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<TaiKhoan> query=enma.createQuery("SELECT c from TaiKhoan c where c.username = :user and c.password = :pass",TaiKhoan.class);
			
		query.setParameter("user",userna);
		query.setParameter("pass",pass);
		TaiKhoan taikhoan=(TaiKhoan) query.getSingleResult();
		return taikhoan;
		//TaiKhoan taikhoan = enma.find(TaiKhoan.class, user);
		
		//return taikhoan;
		
	}
	
}
