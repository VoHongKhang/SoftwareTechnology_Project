package vn.DAO;

import java.util.List;


import vn.Entity.SinhVien;



public interface ISinhVienDao {
	List<SinhVien> findAll();
	
	SinhVien findById(int masinhvien);
	
	void update(SinhVien sinhvien);
}
