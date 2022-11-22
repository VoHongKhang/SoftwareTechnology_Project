package vn.DAO;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.Entity.GiangVien;
import vn.JPACongfig.JpaConfig;




public class GiangVienDaoImpl implements IGiangVienDao{
	@Override
	public void update(GiangVien giangvien) {

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//update
			enma.merge(giangvien);
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
			// TÌm cate
			GiangVien category = enma.find(GiangVien.class, cateid);
			if (category != null) {
				//delete
				enma.remove(category);
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
	public List<GiangVien> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<GiangVien> query = enma.createNamedQuery("GiangVien.findAll", GiangVien.class);
		return query.getResultList();
	}

	@Override
	public GiangVien findById(int magiangvien) {
		EntityManager enma = JpaConfig.getEntityManager();
		GiangVien giangvien = enma.find(GiangVien.class, magiangvien);
		return giangvien;
	}
	
	
}
