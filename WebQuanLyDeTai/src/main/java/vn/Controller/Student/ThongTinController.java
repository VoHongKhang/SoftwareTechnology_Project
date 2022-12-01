package vn.Controller.Student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vn.Entity.SinhVien;
import vn.Entity.TaiKhoan;
import vn.Entity.ThongBao;
import vn.Service.ISinhVienService;
import vn.Service.ITaiKhoanService;
import vn.Service.Impl.SinhVienServiceImpl;
import vn.Service.Impl.TaiKhoanServiceImpl;
import vn.Service.Impl.ThongBaoServiceImpl;


@WebServlet(urlPatterns = { "/student/thongtin" ,"/student/thongtin/edit","/student/thongtin/update"})
public class ThongTinController extends HttpServlet {
	ISinhVienService sinhvienService = new SinhVienServiceImpl();
	ThongBaoServiceImpl thongbaoservice = new ThongBaoServiceImpl();
	ITaiKhoanService taikhoanservice= new TaiKhoanServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String url = req.getRequestURL().toString();

			
		HttpSession session = req.getSession();
		session.getAttribute("acc");
		TaiKhoan taikhoan=(TaiKhoan) session.getAttribute("acc");		
		req.setAttribute("tendangnhap", taikhoan.getUsername());
		req.setAttribute("matkhau", taikhoan.getPassword());
		if (url.contains("edit")) {			
			req.getRequestDispatcher("/views/student/editthongtin.jsp").forward(req, resp);			
		}
		else if(url.contains("update"))
		{
			update(req,resp);		
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/student/my-account.jsp");
		dispatcher.forward(req, resp);
	
	}	
	
	protected void update(HttpServletRequest req, HttpServletResponse resp)
	{
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// lấy dữ liệu từ jsp bằng BeanUtils
			HttpSession session = req.getSession();
			session.getAttribute("acc");
			TaiKhoan taikhoan=(TaiKhoan) session.getAttribute("acc");	
			
			req.setAttribute("matkhaucu", taikhoan.getPassword());
			if(taikhoan.getPassword()==req.getParameter("matkhaucu"))
			{
				taikhoan.setPassword(req.getParameter("matkhaumoi"));	
				taikhoanservice.update(taikhoan);
				req.setAttribute("message", "thành công!");
				req.getRequestDispatcher("/login").forward(req, resp);
			}
			else 
			{
				req.setAttribute("message", "Sai mật khẩu cũ");
				req.getRequestDispatcher("/views/student/editthongtin.jsp").forward(req, resp);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}