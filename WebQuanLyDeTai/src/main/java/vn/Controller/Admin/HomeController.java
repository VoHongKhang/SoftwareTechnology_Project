package vn.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.Entity.SinhVien;
import vn.Service.ISinhVienService;
import vn.Service.Impl.SinhVienServiceImpl;


@WebServlet(urlPatterns = { "/admin/home" })
public class HomeController extends HttpServlet {
	ISinhVienService sinhvienService = new SinhVienServiceImpl();


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<SinhVien> list = sinhvienService.findAll();
		req.setAttribute("sinhviens", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/home.jsp");
		dispatcher.forward(req, resp);
	}

}