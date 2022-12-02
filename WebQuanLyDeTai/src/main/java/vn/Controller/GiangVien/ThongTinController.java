package vn.Controller.GiangVien;

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

import vn.Entity.GiangVien;
import vn.Entity.TaiKhoan;
import vn.Entity.ThongBao;
import vn.Service.IGiangVienService;
import vn.Service.ITaiKhoanService;
import vn.Service.Impl.GiangVienServiceImpl;
import vn.Service.Impl.TaiKhoanServiceImpl;
import vn.Service.Impl.ThongBaoServiceImpl;


@WebServlet(urlPatterns = { "/giangvien/thongtin" ,"/giangvien/thongtin/edit","/giangvien/thongtin/update"})
public class ThongTinController extends HttpServlet {
	IGiangVienService giangvienService = new GiangVienServiceImpl();
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
		GiangVien giangvien= new GiangVien();
		giangvien=giangvienService.findById(Integer.parseInt(taikhoan.getUsername()));
		req.setAttribute("ten", giangvien.getTen());
		req.setAttribute("chuyennganh", giangvien.getChuyennganh());
		req.setAttribute("email", giangvien.getEmail());
		req.setAttribute("namsinh", giangvien.getNamsinh());
		if (url.contains("edit")) {			
			req.getRequestDispatcher("/views/giangvien/editthongtin.jsp").forward(req, resp);			
		}
		else if(url.contains("update"))
		{
				
			req.getRequestDispatcher("/views/giangvien/editthongtin.jsp").forward(req, resp);
		}
		else
		{
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/giangvien/my-account.jsp");
		dispatcher.forward(req, resp);
		}
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//String url = req.getRequestURL().toString();
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			// lấy dữ liệu từ jsp bằng BeanUtils
			HttpSession session = req.getSession();
			session.getAttribute("acc");
			TaiKhoan taikhoan=(TaiKhoan) session.getAttribute("acc");	
			
			
		//	req.setAttribute("matkhaucu", taikhoan.getPassword());
			String mkc=req.getParameter("matkhaucu");
			
			System.out.print(mkc);
			System.out.print(taikhoan.getPassword());		
			System.out.print(req.getParameter("matkhaumoi"));
			
			if(taikhoan.getPassword().equals(mkc))
			{
				taikhoan.setPassword(req.getParameter("matkhaumoi"));	
				taikhoanservice.update(taikhoan);
				req.setAttribute("message", "thành công!");
				resp.sendRedirect(req.getContextPath() + "/login");
			}
			
			else 
			{
				req.setAttribute("message", "Sai mật khẩu cũ");
				req.getRequestDispatcher("/views/giangvien/editthongtin.jsp").forward(req, resp);
			}					
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Eror: " + e.getMessage());
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/giangvien/editthongtin.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	
	
}