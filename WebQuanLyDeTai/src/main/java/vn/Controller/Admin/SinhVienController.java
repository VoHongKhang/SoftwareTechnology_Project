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

import vn.Entity.SinhVien;
import vn.Service.ISinhVienService;
import vn.Service.Impl.SinhVienServiceImpl;


@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/admin-sinhvien","/admin-sinhvien/edit","/admin-sinhvien/update","/admin-sinhvien/reset"})
public class SinhVienController extends HttpServlet {
	ISinhVienService sinhvienService = new SinhVienServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();
		SinhVien sinhvien = null;
		
		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/sinhvien/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			sinhvien = new SinhVien();
			request.setAttribute("sinhvien", sinhvien);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			sinhvien = new SinhVien();
			request.setAttribute("sinhvien", sinhvien);
		} 
		 
		
		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/list-sinhvien.jsp").forward(request, response);
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
			request.setAttribute("sinhvien", new SinhVien());
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/list-sinhvien.jsp").forward(request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<SinhVien> list = sinhvienService.findAll();
			// thông báo
			request.setAttribute("sinhviens", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// khai báo biến userId
			String masinhvien = request.getParameter("masinhvien");
			// khởi tạo DAO
			// gọi hàm insert để thêm dữ liệu
			SinhVien sinhvien = sinhvienService.findById(Integer.parseInt(masinhvien));
			// thông báo
			request.setAttribute("sinhvien", sinhvien);
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
			SinhVien sinhvien = new SinhVien();
			BeanUtils.populate(sinhvien, request.getParameterMap());
	
			
			// khai báo danh sách và gọi hàm update trong service
			sinhvienService.update(sinhvien);
			// thông báo
			request.setAttribute("sinhvien", sinhvien);
			request.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}
}
