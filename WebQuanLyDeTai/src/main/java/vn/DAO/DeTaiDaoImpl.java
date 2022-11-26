package vn.DAO;

import java.util.List;





import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.Entity.DeTai;

import vn.JPACongfig.JpaConfig;




public class DeTaiDaoImpl implements IDeTaiDao{
	@Override
	public void update(DeTai detai) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//update
			enma.merge(detai);
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
	public void insert(DeTai detai) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//thêm
			enma.persist(detai);
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
	public void delete(int madetai) throws Exception {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// TÌm cate
			DeTai detai = enma.find(DeTai.class, madetai);
			if (detai != null) {
				//delete
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
	public List<DeTai> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<DeTai> query = enma.createNamedQuery("DeTai.findAll", DeTai.class);
		return query.getResultList();
	}

	@Override
	public DeTai findById(int madetai) {
		EntityManager enma = JpaConfig.getEntityManager();
		DeTai detai = enma.find(DeTai.class, madetai);
		return detai;
	}
	
	@Override
	public List<DeTai> findByTenDeTai(String tendetai) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM DeTai c WHERE c.tendetai like :tendetai";
		TypedQuery<DeTai> query = enma.createQuery(jpql, DeTai.class);
		query.setParameter("tendetai","%"+tendetai+"%");
		return query.getResultList();
	}
	
	@Override
	public List<DeTai> findByTenGV(String giangvien) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM DeTai c WHERE c.giangvien like :giangvien";
		TypedQuery<DeTai> query = enma.createQuery(jpql, DeTai.class);
		query.setParameter("giangvien","%"+giangvien+"%");
		return query.getResultList();
	}
	
	
	@Override
	public List<DeTai> findByMaDeTai(int madetai) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM DeTai c WHERE c.madetai like :madetai";
		TypedQuery<DeTai> query = enma.createQuery(jpql, DeTai.class);
		query.setParameter("madetai","%"+madetai+"%");
		return query.getResultList();
	}

}
