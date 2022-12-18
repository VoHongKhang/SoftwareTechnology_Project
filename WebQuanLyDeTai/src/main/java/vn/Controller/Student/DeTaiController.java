package vn.Controller.Student;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.Entity.BangDiem;
import vn.Entity.DeTai;
import vn.Entity.GiangVien;
import vn.Entity.SinhVien;
import vn.Entity.TaiKhoan;
import vn.Entity.ThongBao;
import vn.Service.IBangDiemService;
import vn.Service.IDeTaiService;
import vn.Service.IGiangVienService;
import vn.Service.ISinhVienService;
import vn.Service.IThongBaoService;
import vn.Service.Impl.BangDiemServiceImpl;
import vn.Service.Impl.DeTaiServiceImpl;
import vn.Service.Impl.GiangVienServiceImpl;
import vn.Service.Impl.SinhVienServiceImpl;
import vn.Service.Impl.ThongBaoServiceImpl;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/student-detai", "/student-detai/search", "/student-detai/register",
		"/student-detai/xoadangky", "/student-detai/diem", "/student-detai/loaidetai", "/student-detai/detail" })
public class DeTaiController extends HttpServlet {
	IDeTaiService detaiService = new DeTaiServiceImpl();
	IBangDiemService bangdiemservice = new BangDiemServiceImpl();
	IGiangVienService giangvienservice = new GiangVienServiceImpl();
	IThongBaoService thongbaoservice = new ThongBaoServiceImpl();
	ISinhVienService sinhvienservice = new SinhVienServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();

		if (url.contains("register")) {
			insert(request, response);

			String loaidetai = request.getParameter("loaidetai");
			List<DeTai> detais = detaiService.findByLoaiDeTai(loaidetai);

			request.setAttribute("loaidetai", loaidetai);

			List<DeTai> listdt = detaiService.findAll();
			request.setAttribute("detaidk", listdt);

			List<BangDiem> bangdiem = bangdiemservice.findAll();
			request.setAttribute("detaidangky", bangdiem);
			request.setAttribute("detais", detais);
			request.getRequestDispatcher("/views/student/list-detai.jsp").forward(request, response);
		} else if (url.contains("xoadangky")) {
			try {
				int madetai = Integer.parseInt(request.getParameter("madetai1"));
				HttpSession session = request.getSession();
				session.getAttribute("acc");
				TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("acc");

				BangDiem bangdiem = bangdiemservice.findbyMaSinhVien_and_detai(madetai, taikhoan.getUsername());
<<<<<<< HEAD

=======
				
				
>>>>>>> 65e0200b2e9a602a3fb92e3d617d3d24373641db
				bangdiemservice.delete(bangdiem.getId());

				String loaidetai = request.getParameter("loaidetai");
				List<DeTai> detais = detaiService.findByLoaiDeTai(loaidetai);

				request.setAttribute("loaidetai", loaidetai);

				List<DeTai> listdt = detaiService.findAll();
				request.setAttribute("detaidk", listdt);

				List<BangDiem> bangdiem123 = bangdiemservice.findAll();
				request.setAttribute("detaidangky", bangdiem123);

				request.setAttribute("detais", detais);

				request.setAttribute("message", "Xoá thành công ");

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Eror: " + e.getMessage());
			}
			request.getRequestDispatcher("/views/student/list-detai.jsp").forward(request, response);

		} else if (url.contains("search")) {

			TimKiemDeTai(request, response);

		} else if (url.contains("diem")) {
			HttpSession session = request.getSession();
			session.getAttribute("acc");
			TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("acc");
			List<BangDiem> bangdiem = bangdiemservice.findByMaSinhVien((taikhoan.getUsername()));
			request.setAttribute("diem", bangdiem);

			List<DeTai> detai = detaiService.findAll();
			List<GiangVien> giangvien = giangvienservice.findAll();

			request.setAttribute("giangviens", giangvien);
			request.setAttribute("detais", detai);
			request.getRequestDispatcher("/views/student/diem.jsp").forward(request, response);

		} else if (url.contains("loaidetai")) {
			String loaidetai = request.getParameter("loaidetai");
			List<DeTai> detais = detaiService.findByLoaiDeTai(loaidetai);

			request.setAttribute("loaidetai", loaidetai);

			List<DeTai> listdt = detaiService.findAll();
			request.setAttribute("detaidk", listdt);

			List<BangDiem> bangdiem = bangdiemservice.findAll();
			request.setAttribute("detaidangky", bangdiem);

			request.setAttribute("detais", detais);

			List<GiangVien> listgiangvien = giangvienservice.findAll();
			request.setAttribute("giangviens", listgiangvien);

			request.getRequestDispatcher("/views/student/list-detai.jsp").forward(request, response);

		} else if (url.contains("detail"))

		{
			List<BangDiem> bangdiem = bangdiemservice.findAll();
			List<SinhVien> sinhvien = sinhvienservice.findAll();
			DeTai detai1 = (DeTai) detaiService.findById(Integer.parseInt(request.getParameter("madetai")));

			int sl = 0;
			int diem = 0;

			List<SinhVien> sinhviendangky = new ArrayList<SinhVien>();
			for (BangDiem bd : bangdiem) {
				if (bd.getMadetai() == detai1.getMadetai()) {
					sl++;
					diem = bd.getDiem();
				}

			}
			String duocdk = new String();

			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			ThongBao thongbao = thongbaoservice.findbyLoaiDeTai(detai1.getLoaidetai());
			if (thongbao.getNgaybatdau().compareTo(date) <= 0 && thongbao.getNgayketthuc().compareTo(date) >= 0
					&& sl < detai1.getSoluongsv())
				duocdk = "Được phép đăng ký";
			else
				duocdk = "Không cho phép đăng ký";

			for (BangDiem bd : bangdiem) {
				for (SinhVien sv : sinhvien) {
					if (Integer.parseInt(bd.getMasinhvien()) == sv.getMasinhvien()
							&& bd.getMadetai() == detai1.getMadetai())

						sinhviendangky.add(sv);
				}
			}

			SinhVien sv = null;

			if (sinhviendangky.size() > 0)
				sv = sinhvienservice.findById(sinhviendangky.get(0).getMasinhvien());

			request.setAttribute("dangky", duocdk);
			request.setAttribute("nhomtruong", sv);
			request.setAttribute("soluong", sl);
			request.setAttribute("detai", detai1);
			request.setAttribute("danhsach", sinhviendangky);
			request.setAttribute("diem", diem);
			request.getRequestDispatcher("/views/student/detai-detail.jsp").forward(request, response);
		}
		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		List<BangDiem> bangdiem = bangdiemservice.findAll();
		request.setAttribute("detaidangky", bangdiem);
		request.getRequestDispatcher("/views/student/loaidetai.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy url
		String url = request.getRequestURL().toString();

		// kiểm tra url rồi chuyển đến hàm tương ứng
		if (url.contains("register")) {
			insert(request, response);
		} else if (url.contains("search")) {

			TimKiemDeTai(request, response);

		} else if (url.contains("loaidetai")) {
			String loaidetai = request.getParameter("loaidetai");
			List<DeTai> detais = detaiService.findByLoaiDeTai(loaidetai);
			request.setAttribute("loaidetai", loaidetai);
			String chuyennganh = request.getParameter("chuyennganh");

			List<DeTai> detai_chuyennganh = new ArrayList<DeTai>();
			if (chuyennganh == "tat ca" || chuyennganh == null) {
				request.setAttribute("detais", detais);
			}

			else if (chuyennganh == "cong nghe phan mem") {
				for (DeTai dt : detais) {
					if (dt.getChuyennganh() == "cong nghe phan mem")
						detai_chuyennganh.add(dt);
				}

				request.setAttribute("detais", detai_chuyennganh);
			} else if (chuyennganh == "He thong thong tin") {
				for (DeTai dt : detais) {
					if (dt.getChuyennganh() == "He thong thong tin")
						detai_chuyennganh.add(dt);
				}
				request.setAttribute("detais", detai_chuyennganh);
			} else if (chuyennganh == "mang va an ninh mang") {
				for (DeTai dt : detais) {
					if (dt.getChuyennganh() == "mang va an ninh mang")
						detai_chuyennganh.add(dt);
				}
				request.setAttribute("detais", detai_chuyennganh);
			} else if (chuyennganh == "tri tue nhan tao") {
				for (DeTai dt : detais) {
					if (dt.getChuyennganh() == "tri tue nhan tao")
						detai_chuyennganh.add(dt);
				}
				request.setAttribute("detais", detai_chuyennganh);
			} else {
				request.setAttribute("message", "Lỗi");

			}

			request.getRequestDispatcher("/views/student/list-detai.jsp").forward(request, response);

		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/student/list-detai.jsp").forward(request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			// List<DeTai> list = detaiService.findAllDaDuyet();

			List<ThongBao> thongbaos = thongbaoservice.findAll();
			// thông báo
			request.setAttribute("loaidetais", thongbaos);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			int madetai = Integer.parseInt(request.getParameter("madetai"));

			HttpSession session = request.getSession();
			session.getAttribute("acc");
			TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("acc");
			int sl = 0;

			List<BangDiem> bangdiem = bangdiemservice.findAll();
			DeTai detai1 = (DeTai) detaiService.findById(Integer.parseInt(request.getParameter("madetai")));

			for (BangDiem bd : bangdiem) {
				if (bd.getMadetai() == detai1.getMadetai()) {
					sl++;
				}

			}

			int ddk = 0;
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			ThongBao thongbao = thongbaoservice.findbyLoaiDeTai(detai1.getLoaidetai());

			if (thongbao.getNgayketthuc().compareTo(date) < 0)
				ddk = 0;
			else if (thongbao.getNgaybatdau().compareTo(date) <= 0 && thongbao.getNgayketthuc().compareTo(date) >= 0
					&& sl == detai1.getSoluongsv())
				ddk = 1;
			else
				ddk = 2;

			if (ddk == 2)

			{
				int check = 0;

				DeTai detai = detaiService.findByMaDeTai(madetai);
				String loaidetai = detai.getLoaidetai();

				List<BangDiem> listbangdiem = bangdiemservice.findByMaSinhVien(taikhoan.getUsername());
				BangDiem bangdiem2 = new BangDiem();
				SinhVien sv = sinhvienservice.findById(Integer.parseInt(taikhoan.getUsername()));

				if (detai.getChuyennganh() != "khong" && !detai.getChuyennganh().equals(sv.getChuyennganh())) {
					check = 2;

				}
				if (detai.getChuyennganh().equals("khong"))
					check = 0;

				for (BangDiem i : listbangdiem) {
					DeTai dt = detaiService.findByMaDeTai(i.getMadetai());
					String ldt = dt.getLoaidetai();

					if (ldt.equals(loaidetai)) {
						check = 1;
						bangdiem2 = i;

					}
				}
				SinhVien sv= sinhvienservice.findById(Integer.parseInt(taikhoan.getUsername()));
				
				if(detai.getChuyennganh() !="khong" && !detai.getChuyennganh().equals(sv.getChuyennganh()))
					check=2;

				if (check == 0)

				{
					BangDiem bangdiem1 = new BangDiem();
					bangdiem1.setMadetai(madetai);
					bangdiem1.setMasinhvien(taikhoan.getUsername());
					bangdiem1.setDiem(0);
					bangdiem1.setNamhoc(date.getYear());
					// BeanUtils.populate(bangdiem, map);
					bangdiemservice.insert(bangdiem1);
					request.setAttribute("message", "Đăng ký thành công");
				}

				else if (check == 1) {
					bangdiemservice.delete(bangdiem2.getId());
					BangDiem bangdiem1 = new BangDiem();
					bangdiem1.setMadetai(madetai);
					bangdiem1.setMasinhvien(taikhoan.getUsername());
					bangdiem1.setDiem(0);
					bangdiem1.setNamhoc(2022); // BeanUtils.populate(bangdiem, map);
					bangdiemservice.insert(bangdiem1);
					request.setAttribute("message", "Đăng ký thành công");

<<<<<<< HEAD
				} else if (check == 2)// detaiService.delete(dt);
					request.setAttribute("message", "Chuyên đề đăng ký không phù hợp! ");

				// thông báo

			} else if (ddk == 0) {
=======
				} 
				else if(check==2)// detaiService.delete(dt);
					request.setAttribute("message", detai.getChuyennganh());

				// thông báo
				
			}
			else if(ddk==0)
			{
>>>>>>> 65e0200b2e9a602a3fb92e3d617d3d24373641db
				request.setAttribute("message", "Không nằm trong thời hạn đăng ký");
			} else if (ddk == 1) {
				request.setAttribute("message", "Đã đử số lượng đăng ký ! Vui lòng chọn đề tài khác");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// lấy dữ liệu trong jsp
			String madetai = request.getParameter("madetai");
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			detaiService.delete(Integer.parseInt(madetai));
			// thông báo
			request.setAttribute("message", "Đã xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void TimKiemDeTai(HttpServletRequest req, HttpServletResponse resp) {

		String tendetai = req.getParameter("tendetai");
		List<DeTai> detais = detaiService.findByTenDeTai(tendetai);

		req.setAttribute("detais", detais);
		req.setAttribute("tendetai", tendetai);
		List<GiangVien> listgiangvien = giangvienservice.findAll();
		req.setAttribute("giangviens", listgiangvien);
		try {
			req.getRequestDispatcher("/views/student/timkiem-detai.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
