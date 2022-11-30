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

import vn.DAO.IThongBaoDao;
import vn.DAO.ThongBaoDaoImpl;
import vn.Entity.*;
@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = {"/admin-thongbao","/admin-thongbao/add","/admin-thongbao/update","/admin-thongbao/delete,/admin-thongbao/reset"})
public class ThongBaoController extends HttpServlet {

	IThongBaoDao thongbaoservice= new ThongBaoDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String url = request.getRequestURL().toString();
		ThongBao thongbao= null;
		if (url.contains("add")) {
			request.getRequestDispatcher("/views/admin/thongbao.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			thongbao = new ThongBao();
			request.setAttribute("thongbao", thongbao);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("reset")) {
			thongbao = new ThongBao();
			request.setAttribute("thongbao", thongbao);
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/thongbao.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy url
		String url = request.getRequestURL().toString();
		// kiểm tra url rồi chuyển đến hàm tương ứng
		if (url.contains("add")) {
			insert(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("thongbao", new TaiKhoan());
		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/thongbao.jsp").forward(request, response);
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			ThongBao thongbao = new ThongBao();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			BeanUtils.populate(thongbao, request.getParameterMap());
			
			// gọi hàm insert để thêm dữ liệu
			thongbaoservice.insert(thongbao);
			// thông báo
			request.setAttribute("message", "Đã Thêm Thành Công");
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
			List<ThongBao> list = thongbaoservice.findAll();
			// thông báo
			request.setAttribute("thongbaos", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
