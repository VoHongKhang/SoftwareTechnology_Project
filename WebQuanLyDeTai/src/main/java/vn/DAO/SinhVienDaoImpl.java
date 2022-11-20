package vn.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
	public List<SinhVien> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<SinhVien> query = enma.createNamedQuery("SinhVien.findAll", SinhVien.class);
		return query.getResultList();
	}
}
