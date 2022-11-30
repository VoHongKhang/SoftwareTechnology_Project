package vn.Controller.Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.Entity.TaiKhoan;
import vn.Service.ITaiKhoanService;
import vn.Service.Impl.TaiKhoanServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String username = req.getParameter("username");
		String pass = req.getParameter("password");

		ITaiKhoanService taikhoanService = new TaiKhoanServiceImpl();
		TaiKhoan takhoan = taikhoanService.findByUser_pass(username,pass);
		System.out.println(takhoan.getPhanquyen());
		/*
		 * for (TaiKhoan i : taikhoan) { if (i.getUsername().equals(user) &&
		 * i.getPassword().equals(pass)) { takhoan.setPassword(pass);
		 * takhoan.setUsername(user); takhoan.setPhanquyen(i.getPhanquyen()); } }
		 */
		HttpSession session = req.getSession();
		session.setAttribute("acc", takhoan);
		
		
		if (takhoan.getPhanquyen() == 0) {
			// khởi tạo cookie
			Cookie cookie = new Cookie("username", username);
			// thiết lập thời gian tồn tại 30s của cookie
			cookie.setMaxAge(30);
			// thêm cookie vào response
			resp.addCookie(cookie);
			// chuyển sang trang HelloServlet

			resp.sendRedirect("admin/home");

		}
		else if (takhoan.getPhanquyen() == 3 ) {
			// khởi tạo cookie
			Cookie cookie = new Cookie("username", username);
			// thiết lập thời gian tồn tại 30s của cookie
			cookie.setMaxAge(30);
			// thêm cookie vào response
			resp.addCookie(cookie);
			// chuyển sang trang LoginServlet
				resp.sendRedirect("student/home");
		}
		else if (takhoan.getPhanquyen() == 2  || takhoan.getPhanquyen() == 1) {
			// khởi tạo cookie
			Cookie cookie = new Cookie("username", username);
			// thiết lập thời gian tồn tại 30s của cookie
			cookie.setMaxAge(30);
			// thêm cookie vào response
			resp.addCookie(cookie);
			// chuyển sang trang LoginServlet
				resp.sendRedirect("giangvien/home");
		}
		
	}
}
