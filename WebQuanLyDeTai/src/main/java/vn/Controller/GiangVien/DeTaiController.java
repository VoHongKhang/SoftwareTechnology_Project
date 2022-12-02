package vn.Controller.GiangVien;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vn.Entity.DeTai;
import vn.Entity.TaiKhoan;
import vn.Service.IDeTaiService;
import vn.Service.Impl.DeTaiServiceImpl;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/giangvien-detai", "/giangvien-detai/create", "/giangvien-detai/edit", "/giangvien-detai/update",
		"/giangvien-detai/reset", "/giangvien-detai/delete", "/giangvien-detai/search", "/giangvien-detai/ma",
		"/giangvien-detai/search-tengv" })
public class DeTaiController extends HttpServlet {
	IDeTaiService detaiService = new DeTaiServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();
		DeTai detai = null;

		if (url.contains("create")) {
			request.getRequestDispatcher("/views/giangvien/detai/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			detai = new DeTai();
			request.setAttribute("detai", detai);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			detai = new DeTai();
			request.setAttribute("detai", detai);
		} else if (url.contains("search")) {

			TimKiemDeTai(request, response);

		} else if (url.contains("ma")) {

			TimKiemDeTaiBangMa(request, response);

		}

		else if (url.contains("search-tengv")) {

			TimKiemDeTaiBangTengv(request, response);

		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/giangvien/list-detai.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy url
		String url = request.getRequestURL().toString();
		// kiểm tra url rồi chuyển đến hàm tương ứng

		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("detai", new DeTai());
		} else if (url.contains("search")) {
			TimKiemDeTai(request, response);
		} else if (url.contains("ma")) {
			TimKiemDeTaiBangMa(request, response);
		}else if (url.contains("search-tengv")) {
			TimKiemDeTaiBangTengv(request, response);
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/giangvien/list-detai.jsp").forward(request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<DeTai> list = detaiService.findAll();
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
			// khỏi tạo đối tượng Model
			DeTai detai = new DeTai();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			//BeanUtils.populate(detai, request.getParameterMap());
			detai.setChuyennganh(request.getParameter("chuyennganh"));
			
			HttpSession session = request.getSession();
			session.getAttribute("acc");
			TaiKhoan taikhoan=(TaiKhoan) session.getAttribute("acc");
			detai.setGiangvien(taikhoan.getUsername());
			detai.setLoaidetai(request.getParameter("loaidetai"));
			
			detai.setSoluongsv(Integer.parseInt(request.getParameter("soluongsv")));
			detai.setTendetai(request.getParameter("tendetai"));
			detai.setTinhtrang(0);
			
			
			detaiService.insert(detai);
			// thông báo
			request.setAttribute("message", "Đã Thêm Thành Công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// khai báo biến userId
			String madetai = request.getParameter("madetai");
			// khởi tạo DAO
			// gọi hàm insert để thêm dữ liệu
			DeTai detai = detaiService.findById(Integer.parseInt(madetai));
			// thông báo
			request.setAttribute("detai", detai);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// lấy dữ liệu từ jsp bằng BeanUtils
			DeTai detai = new DeTai();
			BeanUtils.populate(detai, request.getParameterMap());

			// khai báo danh sách và gọi hàm update trong service
			detaiService.update(detai);
			// thông báo
			request.setAttribute("detai", detai);
			request.setAttribute("message", "Cập Nhật Thành Công");
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
			request.setAttribute("message", "Đã Xóa Thành Công");
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
			req.getRequestDispatcher("/views/giangvien/timkiem-detai.jsp").forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void TimKiemDeTaiBangMa(HttpServletRequest req, HttpServletResponse resp) {

		String madetai = req.getParameter("madetai");
		List<DeTai> detaii = detaiService.findByTenDeTai(madetai);

		req.setAttribute("detaii", detaii);
		req.setAttribute("madetai", madetai);
		try {
			req.getRequestDispatcher("/views/giangvien/timkiem-detai.jsp").forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	private void TimKiemDeTaiBangTengv(HttpServletRequest req, HttpServletResponse resp) {

		String giangvien = req.getParameter("giangvien");
		List<DeTai> detaim = detaiService.findByTenDeTai(giangvien);

		req.setAttribute("detaim", detaim);
		req.setAttribute("giangvien", giangvien);
		try {
			req.getRequestDispatcher("/views/detai/timkiem-detai-ten.jsp").forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
