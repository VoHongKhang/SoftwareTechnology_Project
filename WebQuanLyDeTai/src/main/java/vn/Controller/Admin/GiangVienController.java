package vn.Controller.Admin;

import java.io.IOException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import vn.Entity.GiangVien;
import vn.Service.IGiangVienService;
import vn.Service.Impl.GiangVienServiceImpl;


@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/admin-giangvien", "/admin-giangvien/edit", "/admin-giangvien/update",
		"/admin-giangvien/reset" ,"/admin-giangvien/delete"})
public class GiangVienController extends HttpServlet {
	IGiangVienService giangvienService = new GiangVienServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();
		GiangVien giangvien = null;

		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/giangvien/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			giangvien = new GiangVien();
			request.setAttribute("giangvien", giangvien);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			giangvien = new GiangVien();
			request.setAttribute("giangvien", giangvien);
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/list-giangvien.jsp").forward(request, response);
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
			request.setAttribute("giangvien", new GiangVien());
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/list-giangvien.jsp").forward(request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<GiangVien> list = giangvienService.findAll();
			// thông báo
			request.setAttribute("giangviens", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// khai báo biến userId
			String magiangvien = request.getParameter("magiangvien");
			// khởi tạo DAO
			// gọi hàm insert để thêm dữ liệu
			GiangVien giangvien = giangvienService.findById(Integer.parseInt(magiangvien));
			// thông báo
			request.setAttribute("giangvien", giangvien);
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
			GiangVien giangvien = new GiangVien();
			BeanUtils.populate(giangvien, request.getParameterMap());

			// khai báo danh sách và gọi hàm update trong service
			giangvienService.update(giangvien);
			// thông báo
			request.setAttribute("giangvien", giangvien);
			request.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// lấy dữ liệu trong jsp
			String magiangvien = request.getParameter("magiangvien");
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			giangvienService.delete(Integer.parseInt(magiangvien));
			// thông báo
			request.setAttribute("message", "Đã xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
