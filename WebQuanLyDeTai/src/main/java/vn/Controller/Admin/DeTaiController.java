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

import vn.Entity.DeTai;
import vn.Service.IDeTaiService;

import vn.Service.Impl.DeTaiServiceImpl;


@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/admin-detai", "/admin-detai/create", "/admin-detai/update","/admin-detai/edit", "/admin-detai/delete", "/admin-detai/reset" })
public class DeTaiController  extends HttpServlet{
	IDeTaiService detaiService = new DeTaiServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();
		DeTai detai = null;
		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/list-detai.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			detai = new DeTai();
			request.setAttribute("detai", detai);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			detai = new DeTai();
			request.setAttribute("detai", detai);
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/list-detai.jsp").forward(request, response);
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
			
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/list-detai.jsp").forward(request, response);
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
			BeanUtils.populate(detai, request.getParameterMap());
			
			// gọi hàm insert để thêm dữ liệu
			detaiService.insert(detai);
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

		try {
			// lấy dữ liệu trong jsp
			String magiangvien = request.getParameter("magiangvien");
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			detaiService.delete(Integer.parseInt(magiangvien));
			// thông báo
			request.setAttribute("message", "Đã xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

} 
