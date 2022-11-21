package vn.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import vn.Entity.DeTai;
import vn.JPACongfig.JpaConfig;




public class DeTaiDaoImpl implements IDeTaiDao{

	@Override
	public int count() {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT count(c) FROM DeTai c";
		Query query = enma.createQuery(jpql);
		return ((Long) query.getSingleResult()).intValue();
	}
	@Override
	public List<DeTai> findAll(int page, int pagesize) {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<DeTai> query = enma.createNamedQuery("Video.findAll", DeTai.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}
	@Override
	public List<DeTai> findByGiangVien(String vdname) {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM DeTai c WHERE c.giangvien like :vdname";
		TypedQuery<DeTai> query = enma.createQuery(jpql, DeTai.class);
		query.setParameter("vdname","%"+vdname+"%");
		return query.getResultList();
	}
	@Override
	public List<DeTai> findAll() {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<DeTai> query = enma.createNamedQuery("DeTai.findAll", DeTai.class);
		return query.getResultList();
	}
	@Override
	public List<DeTai> findByLoaideTai(String vdname) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT c FROM DeTai c WHERE c.loaidetai like :vdname";
		TypedQuery<DeTai> query = enma.createQuery(jpql, DeTai.class);
		query.setParameter("vdname","%"+vdname+"%");
		return query.getResultList();
	}
	@Override
	public void delete(int madetai) throws Exception {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// TÌm video
			DeTai detai = enma.find(DeTai.class, madetai);
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
	public void update(DeTai detai) {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// update
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
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// thêm
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
}

	