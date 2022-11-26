package vn.Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");

		ITaiKhoanService taikhoanService = new TaiKhoanServiceImpl();
		List<TaiKhoan> taikhoan = taikhoanService.findAll();
		TaiKhoan takhoan = new TaiKhoan();

		for (TaiKhoan i : taikhoan) {
			if (i.getUsername() == user && i.getPassword() == pass) {
				takhoan.setPassword(pass);
				takhoan.setUsername(user);
				takhoan.setPhanquyen(i.getPhanquyen());
			}

		}
		if (takhoan != null) 
		{
			if (takhoan.getPhanquyen() == 0 || takhoan.getPhanquyen() == 1 || takhoan.getPhanquyen() == 2) 
			{
				// khởi tạo cookie
				Cookie cookie = new Cookie("username", user);
				// thiết lập thời gian tồn tại 30s của cookie
				cookie.setMaxAge(30);
				// thêm cookie vào response
				resp.addCookie(cookie);
				// chuyển sang trang HelloServlet
				req.setAttribute("message", takhoan.getPhanquyen());
				resp.sendRedirect("admin-taikhoan");
			}
			else 
			{
				// khởi tạo cookie
				Cookie cookie = new Cookie("username", user);
				// thiết lập thời gian tồn tại 30s của cookie
				cookie.setMaxAge(30);
				// thêm cookie vào response
				resp.addCookie(cookie);
				// chuyển sang trang LoginServlet
				resp.sendRedirect("student/home");
			}
		} 
	
	}
}
