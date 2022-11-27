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
		// kiá»ƒm tra url rá»“i chuyá»ƒn Ä‘áº¿n hÃ m tÆ°Æ¡ng á»©ng
		// láº¥y url
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

		// gá»�i hÃ m findAll Ä‘á»ƒ láº¥y thÃ´ng tin tá»« entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/list-taikhoan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// láº¥y url
		String url = request.getRequestURL().toString();
		// kiá»ƒm tra url rá»“i chuyá»ƒn Ä‘áº¿n hÃ m tÆ°Æ¡ng á»©ng
		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("taikhoan", new TaiKhoan());
		}

		// gá»�i hÃ m findAll Ä‘á»ƒ láº¥y thÃ´ng tin tá»« entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/list-taikhoan.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// khá»�i táº¡o Ä‘á»‘i tÆ°á»£ng Model
			TaiKhoan taikhoan = new TaiKhoan();
			// sá»­ dá»¥ng BeanUtils Ä‘á»ƒ tá»± láº¥y cÃ¡c name Field trÃªn form
			// tÃªn field pháº£i trÃ¹ng vá»›i entity
			BeanUtils.populate(taikhoan, request.getParameterMap());
			
			// gá»�i hÃ m insert Ä‘á»ƒ thÃªm dá»¯ liá»‡u
			taikhoanService.insert(taikhoan);
			// thÃ´ng bÃ¡o
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
			// khá»Ÿi táº¡o DAO
			// khai bÃ¡o danh sÃ¡ch vÃ  gá»�i hÃ m findAll() trong dao
			List<TaiKhoan> list = taikhoanService.findAll();
			// thÃ´ng bÃ¡o
			request.setAttribute("taikhoans", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
