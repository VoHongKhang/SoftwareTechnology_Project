package vn.Controller.GiangVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.Entity.GiangVien;
<<<<<<< HEAD
import vn.Entity.ThongBao;
import vn.Service.IGiangVienService;
import vn.Service.Impl.GiangVienServiceImpl;
import vn.Service.Impl.ThongBaoServiceImpl;
=======
import vn.Service.IGiangVienService;
import vn.Service.Impl.GiangVienServiceImpl;
>>>>>>> c83c10fe95543fbc20c7c7c3cef755db2a4f532b


@WebServlet(urlPatterns = { "/giangvien/home" })
public class HomeController extends HttpServlet {
	IGiangVienService giangvienService = new GiangVienServiceImpl();
<<<<<<< HEAD
	ThongBaoServiceImpl thongbaoservice = new ThongBaoServiceImpl();
=======

>>>>>>> c83c10fe95543fbc20c7c7c3cef755db2a4f532b

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<GiangVien> list = giangvienService.findAll();
		req.setAttribute("giangviens", list);
		
<<<<<<< HEAD
		List<ThongBao> listhongbao=thongbaoservice.findAll();
		req.setAttribute("thongbaos", listhongbao);
=======
>>>>>>> c83c10fe95543fbc20c7c7c3cef755db2a4f532b
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/giangvien/home.jsp");
		dispatcher.forward(req, resp);
	}

}