package vn.Controller.Admin;



import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vn.Entity.TaiKhoan;
import vn.Service.ITaiKhoanService;
import vn.Service.Impl.TaiKhoanServiceImpl;




@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/admin-taikhoan", "/admin-taikhoan/create", "/admin-taikhoan/update",
		"/admin-taikhoan/edit", "/admin-taikhoan/delete", "/admin-taikhoan/reset" })
public class TaiKhoanController extends HttpServlet{
	ITaiKhoanService taikhoanService = new TaiKhoanServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();
		TaiKhoan taikhoan = null;
		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/taikhoan/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			taikhoan = new TaiKhoan();
			request.setAttribute("taikhoan", taikhoan);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			taikhoan = new TaiKhoan();
			request.setAttribute("taikhoan", taikhoan);
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/list-taikhoan.jsp").forward(request, response);
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
			request.setAttribute("taikhoan", new TaiKhoan());
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/list-taikhoan.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			TaiKhoan taikhoan = new TaiKhoan();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			BeanUtils.populate(taikhoan, request.getParameterMap());
			
			// gọi hàm insert để thêm dữ liệu
			taikhoanService.insert(taikhoan);
			// thông báo
			request.setAttribute("message", "Đã thêm thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<TaiKhoan> list = taikhoanService.findAll();
			// thông báo
			request.setAttribute("taikhoans", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
