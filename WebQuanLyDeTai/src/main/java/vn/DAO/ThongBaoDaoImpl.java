package vn.DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;
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

	@Override
	public List<ThongBao> findConHan() {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<ThongBao> query=enma.createQuery("SELECT c from ThongBao c where c.ngaybatdau <= :user and c.ngayketthuc >= :user ",ThongBao.class);
			
		
		  long millis = System.currentTimeMillis();
		  Date date = new Date(millis);
		 
		query.setParameter("user",date);
					
		List<ThongBao> HoiDong=query.getResultList();
		return HoiDong;
	}

	@Override
	public ThongBao findbyLoaiDeTai(String loaidetai) {
		// TODO Auto-generated method stub
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<ThongBao> query=enma.createQuery("SELECT c from ThongBao c where c.loaidetai= :user ",ThongBao.class);
			
		query.setParameter("user",loaidetai);
		
		ThongBao HoiDong=(ThongBao) query.getSingleResult();
		return HoiDong;
	}

}
