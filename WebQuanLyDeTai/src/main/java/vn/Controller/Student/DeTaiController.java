package vn.Controller.Student;

import java.io.IOException;

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
import vn.Entity.TaiKhoan;
import vn.Service.IBangDiemService;
import vn.Service.IDeTaiService;
import vn.Service.Impl.BangDiemServiceImpl;
import vn.Service.Impl.DeTaiServiceImpl;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/student-detai", "/student-detai/search", "/student-detai/register",
		"/student-detai/xoadangky" })
public class DeTaiController extends HttpServlet {
	IDeTaiService detaiService = new DeTaiServiceImpl();
	IBangDiemService bangdiemservice = new BangDiemServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();

		if (url.contains("register")) {
			insert(request, response);

			findAll(request, response);
			List<BangDiem> bangdiem = bangdiemservice.findAll();
			request.setAttribute("detaidangky", bangdiem);
			request.getRequestDispatcher("/views/student/list-detai.jsp").forward(request, response);
		} else if (url.contains("xoadangky")) {
			try {
				int madetai = Integer.parseInt(request.getParameter("madetai1"));
				HttpSession session = request.getSession();
				session.getAttribute("acc");
				TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("acc");

				BangDiem bangdiem = bangdiemservice.findbyMaSinhVien_and_detai(madetai, taikhoan.getUsername());
				bangdiemservice.delete(bangdiem.getId());

				findAll(request, response);
				request.setAttribute("tag", "cate");
				List<BangDiem> bangdiem2 = bangdiemservice.findAll();
				request.setAttribute("detaidangky", bangdiem2);

				request.setAttribute("message", "Xoá thành công ");

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Eror: " + e.getMessage());
			}
			request.getRequestDispatcher("/views/student/list-detai.jsp").forward(request, response);

		} else if (url.contains("search")) {

			TimKiemDeTai(request, response);

		}
		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		List<BangDiem> bangdiem = bangdiemservice.findAll();
		request.setAttribute("detaidangky", bangdiem);
		request.getRequestDispatcher("/views/student/list-detai.jsp").forward(request, response);
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
			List<DeTai> list = detaiService.findAllDaDuyet();
			// thông báo
			request.setAttribute("detais", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			int madetai = Integer.parseInt(request.getParameter("madetai"));

			HttpSession session = request.getSession();
			session.getAttribute("acc");
			TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("acc");

			int check = 0;

			DeTai detai = detaiService.findByMaDeTai(madetai);
			String loaidetai = detai.getLoaidetai();

			List<BangDiem> listbangdiem = bangdiemservice.findByMaSinhVien(taikhoan.getUsername());
			BangDiem bangdiem2 = new BangDiem();

			
			for(BangDiem i: listbangdiem)
			{
				DeTai dt= detaiService.findByMaDeTai(i.getMadetai());
				String ldt=dt.getLoaidetai();
				System.out.print(loaidetai);
				System.out.print(ldt);
				System.out.print(i.getMadetai());
				
				if(ldt.equals(loaidetai))
				{
					check=1;
					bangdiem2=i;
					
				}
			}
			

			if (check == 0)

			{
				BangDiem bangdiem1 = new BangDiem();
				bangdiem1.setMadetai(madetai);
				bangdiem1.setMasinhvien(taikhoan.getUsername());
				bangdiem1.setDiem(0);
				bangdiem1.setNamhoc(2022);
				// BeanUtils.populate(bangdiem, map);
				bangdiemservice.insert(bangdiem1);
			}

			else if (check == 1) {
				bangdiemservice.delete(bangdiem2.getId());
				BangDiem bangdiem1 = new BangDiem();
				bangdiem1.setMadetai(madetai);
				bangdiem1.setMasinhvien(taikhoan.getUsername());
				bangdiem1.setDiem(0);
				bangdiem1.setNamhoc(2022); // BeanUtils.populate(bangdiem, map);
				bangdiemservice.insert(bangdiem1);

			} // detaiService.delete(dt);

			// thông báo
			request.setAttribute("message", "Đăng ký thành công");
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
