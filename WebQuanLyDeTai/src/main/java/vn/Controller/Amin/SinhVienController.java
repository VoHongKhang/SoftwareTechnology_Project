package vn.Controller.Amin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.Entity.SinhVien;
import vn.Service.ISinhVienService;
import vn.Service.Impl.SinhVienServiceImpl;


@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/admin-sinhvien" })
public class SinhVienController extends HttpServlet {
	ISinhVienService sinhvienService = new SinhVienServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();
		SinhVien sinhvien = null;
		/*
		 * if (url.contains("create")) {
		 * request.getRequestDispatcher("/views/admin/sinhvien/add.jsp").forward(
		 * request, response); } else if (url.contains("delete")) { delete(request,
		 * response); category = new Category(); request.setAttribute("category",
		 * category); } else if (url.contains("edit")) { edit(request, response); } else
		 * if (url.contains("reset")) { category = new Category();
		 * request.setAttribute("category", category); }
		 */

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/sinhvien/list.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy url
		String url = request.getRequestURL().toString();
		// kiểm tra url rồi chuyển đến hàm tương ứng
		/*
		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("category", new Category());
		}*/

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/sinhvien/list.jsp").forward(request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<SinhVien> list = sinhvienService.findAll();
			// thông báo
			request.setAttribute("sinhvien", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
