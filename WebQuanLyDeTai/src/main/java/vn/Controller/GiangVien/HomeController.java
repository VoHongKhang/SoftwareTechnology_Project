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
import vn.Entity.ThongBao;
import vn.Service.IGiangVienService;
import vn.Service.Impl.GiangVienServiceImpl;
import vn.Service.Impl.ThongBaoServiceImpl;


@WebServlet(urlPatterns = { "/giangvien/home" })
public class HomeController extends HttpServlet {
	IGiangVienService giangvienService = new GiangVienServiceImpl();
	ThongBaoServiceImpl thongbaoservice = new ThongBaoServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<GiangVien> list = giangvienService.findAll();
		req.setAttribute("giangviens", list);
		
		List<ThongBao> listhongbao=thongbaoservice.findAll();
		req.setAttribute("thongbaos", listhongbao);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/giangvien/home.jsp");
		dispatcher.forward(req, resp);
	}

}