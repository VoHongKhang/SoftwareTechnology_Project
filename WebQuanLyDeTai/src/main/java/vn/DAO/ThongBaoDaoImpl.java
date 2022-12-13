package vn.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.Entity.BangDiem;
import vn.Entity.ThongBao;
import vn.JPACongfig.JpaConfig;

public class ThongBaoDaoImpl implements IThongBaoDao {

	@Override
	public List<ThongBao> findAll() {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<ThongBao> query = enma.createNamedQuery("ThongBao.findAll", ThongBao.class);
		return query.getResultList();
	}

	@Override
	public void insert(ThongBao thongbao) {
		// TODO Auto-generated method stub

		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//thêm
			enma.persist(thongbao);
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
	public void update(ThongBao thongbao) {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			//update
			enma.merge(thongbao);
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
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();

		try {
			trans.begin();
			// tìm cate
			ThongBao thongbao = enma.find(ThongBao.class, id);
			if (thongbao != null) {
				//delete
				enma.remove(thongbao);
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
	public ThongBao findByID(int id) {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<ThongBao> query=enma.createQuery("SELECT c from ThongBao c where c.id= :user ",ThongBao.class);
			
		query.setParameter("user",id);
		
		ThongBao HoiDong=(ThongBao) query.getSingleResult();
		return HoiDong;
	}

}
