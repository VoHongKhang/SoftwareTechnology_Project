package vn.Controller.GiangVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.Entity.DeTai;
import vn.Entity.HoiDong;
import vn.Entity.TaiKhoan;
import vn.Entity.ThamGiaHoiDong;
import vn.Service.IBangDiemService;
import vn.Service.IDeTaiService;
import vn.Service.IGiangVienService;
import vn.Service.IHoiDongService;
import vn.Service.IThamGiaHoiDongService;
import vn.Service.Impl.BangDiemServiceImpl;
import vn.Service.Impl.DeTaiServiceImpl;
import vn.Service.Impl.GiangVienServiceImpl;
import vn.Service.Impl.HoiDongServiceImpl;
import vn.Service.Impl.ThamGiaHoiDongImpl;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/giangvien-hoidong", "/giangvien-hoidong/view" })
public class HoiDongController extends HttpServlet {
	IHoiDongService hoidongservice = new HoiDongServiceImpl();
	IThamGiaHoiDongService thamgiahoidong = new ThamGiaHoiDongImpl();
	IGiangVienService giangvienservice = new GiangVienServiceImpl();
	IDeTaiService detaiservice = new DeTaiServiceImpl();
	IBangDiemService bangdiemservice = new BangDiemServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();
		

		List<HoiDong> hoidong = hoidongservice.findAll();
		if (url.contains("view")) {

			String mahoidong = request.getParameter("id");
			request.setAttribute("mahoidong", mahoidong);

			
			List<ThamGiaHoiDong>thamgia= thamgiahoidong.findAll();
			request.setAttribute("thamgiahoidongs", thamgia);
			
			
			List<DeTai> detai=detaiservice.findAll();
			request.setAttribute("detai", detai);
			
			
			request.getRequestDispatcher("/views/giangvien/hoidong-detail.jsp").forward(request, response);

		}

		HttpSession session = request.getSession();
		TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("acc");

		int magiangvien = Integer.parseInt(taikhoan.getUsername());
		
		List<ThamGiaHoiDong> thamgia = thamgiahoidong.findAllByGiangVien(magiangvien);
		request.setAttribute("thamgiahoidong", thamgia);
		request.setAttribute("hoidong", hoidong);

		request.getRequestDispatcher("/views/giangvien/list-hoidong.jsp").forward(request, response);

	}

}
