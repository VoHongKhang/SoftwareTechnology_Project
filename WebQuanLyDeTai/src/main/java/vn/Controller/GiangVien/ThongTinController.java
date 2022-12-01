package vn.Controller.GiangVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.Entity.SinhVien;
import vn.Entity.ThongBao;
import vn.Service.ISinhVienService;
import vn.Service.Impl.SinhVienServiceImpl;
import vn.Service.Impl.ThongBaoServiceImpl;


@WebServlet(urlPatterns = { "/giangvien/thongtin" })
public class ThongTinController extends HttpServlet {
	ISinhVienService sinhvienService = new SinhVienServiceImpl();
	ThongBaoServiceImpl thongbaoservice = new ThongBaoServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<SinhVien> list = sinhvienService.findAll();
		req.setAttribute("sinhviens", list);
		List<ThongBao> listhongbao=thongbaoservice.findAll();
		req.setAttribute("thongbaos", listhongbao);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/giangvien/my-account.jsp");
		dispatcher.forward(req, resp);
	}

}