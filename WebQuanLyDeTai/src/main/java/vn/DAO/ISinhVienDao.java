package vn.DAO;

import java.util.List;

import vn.Entity.SinhVien;


public interface ISinhVienDao {
	List<SinhVien> findAll();
	
	void update(SinhVien sinhvien);
}
