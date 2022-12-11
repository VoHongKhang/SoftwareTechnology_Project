package vn.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.Entity.HoiDong;
import vn.JPACongfig.JpaConfig;

public class HoiDongDaoImpl implements IHoiDongDao{

	@Override
	public void update(HoiDong HoiDong) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//update
			enma.merge(HoiDong);
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
	public void insert(HoiDong HoiDong) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//thêm
			enma.persist(HoiDong);
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
	public List<HoiDong> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<HoiDong> query = enma.createNamedQuery("HoiDong.findAll", HoiDong.class);
		return query.getResultList();
	}

	@Override
	public HoiDong findById(int id) {
		EntityManager enma = JpaConfig.getEntityManager();
		HoiDong HoiDong = enma.find(HoiDong.class, id);
		return HoiDong;
	}
	@Override
	public HoiDong findByUser_pass(String userna,String pass) {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<HoiDong> query=enma.createQuery("SELECT c from HoiDong c where c.username = :user and c.password = :pass",HoiDong.class);
			
		query.setParameter("user",userna);
		query.setParameter("pass",pass);
		HoiDong HoiDong=(HoiDong) query.getSingleResult();
		return HoiDong;
	}
	@Override
	public HoiDong findByMaHoiDong(int ma) {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<HoiDong> query=enma.createQuery("SELECT c from HoiDong c where c.mahoidong = :mahoidong",HoiDong.class);
		query.setParameter("mahoidong",ma);
		HoiDong HoiDong=(HoiDong) query.getSingleResult();
		
		return HoiDong;
	}

}
