package vn.Service;

import java.util.List;

import vn.Entity.SinhVien;

public interface ISinhVienService {
	List<SinhVien> findAll();
	
	SinhVien findById(int masinhvien);

	void update(SinhVien sinhvien);
	
	void delete(int masinhvien) throws Exception;
}
