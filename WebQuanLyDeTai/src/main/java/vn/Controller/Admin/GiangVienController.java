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


import vn.Entity.GiangVien;

import vn.Service.IGiangVienService;
import vn.Service.Impl.GiangVienServiceImpl;


@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/admin-giangvien","/admin-giangvien/create", "/admin-giangvien/edit", "/admin-giangvien/update",
		"/admin-giangvien/reset" ,"/admin-giangvien/delete","/admin-giangvien/searchten"})
public class GiangVienController extends HttpServlet {
	IGiangVienService giangvienService = new GiangVienServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiá»ƒm tra url rá»“i chuyá»ƒn Ä‘áº¿n hÃ m tÆ°Æ¡ng á»©ng
		// láº¥y url
		String url = request.getRequestURL().toString();
		GiangVien giangvien = null;

		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/giangvien/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			giangvien = new GiangVien();
			request.setAttribute("giangvien", giangvien);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			giangvien = new GiangVien();
			request.setAttribute("giangvien", giangvien);
		} else if (url.contains("searchten")){
			TimKiemGiangVienBangTen(request, response);
		}

		// gá»�i hÃ m findAll Ä‘á»ƒ láº¥y thÃ´ng tin tá»« entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/list-giangvien.jsp").forward(request, response);
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
			request.setAttribute("giangvien", new GiangVien());
		} else if (url.contains("searchten")){
			TimKiemGiangVienBangTen(request, response);
		}
		// gá»�i hÃ m findAll Ä‘á»ƒ láº¥y thÃ´ng tin tá»« entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/list-giangvien.jsp").forward(request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khá»Ÿi táº¡o DAO
			// khai bÃ¡o danh sÃ¡ch vÃ  gá»�i hÃ m findAll() trong dao
			List<GiangVien> list = giangvienService.findAll();
			// thÃ´ng bÃ¡o
			request.setAttribute("giangviens", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// khá»�i táº¡o Ä‘á»‘i tÆ°á»£ng Model
			GiangVien giangvien = new GiangVien();
			// sá»­ dá»¥ng BeanUtils Ä‘á»ƒ tá»± láº¥y cÃ¡c name Field trÃªn form
			// tÃªn field pháº£i trÃ¹ng vá»›i entity
			BeanUtils.populate(giangvien, request.getParameterMap());
			
			// gá»�i hÃ m insert Ä‘á»ƒ thÃªm dá»¯ liá»‡u
			giangvienService.insert(giangvien);
			// thÃ´ng bÃ¡o
			request.setAttribute("message", "Đã Thêm Thành Công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// khai bÃ¡o biáº¿n userId
			String magiangvien = request.getParameter("magiangvien");
			// khá»Ÿi táº¡o DAO
			// gá»�i hÃ m insert Ä‘á»ƒ thÃªm dá»¯ liá»‡u
			GiangVien giangvien = giangvienService.findById(Integer.parseInt(magiangvien));
			// thÃ´ng bÃ¡o
			request.setAttribute("giangvien", giangvien);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// láº¥y dá»¯ liá»‡u tá»« jsp báº±ng BeanUtils
			GiangVien giangvien = new GiangVien();
			BeanUtils.populate(giangvien, request.getParameterMap());

			// khai bÃ¡o danh sÃ¡ch vÃ  gá»�i hÃ m update trong service
			giangvienService.update(giangvien);
			// thÃ´ng bÃ¡o
			request.setAttribute("giangvien", giangvien);
			request.setAttribute("message", "Cập Nhật Thành Công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// láº¥y dá»¯ liá»‡u trong jsp
			String magiangvien = request.getParameter("magiangvien");
			// khá»Ÿi táº¡o DAO
			// khai bÃ¡o danh sÃ¡ch vÃ  gá»�i hÃ m findAll() trong dao
			giangvienService.delete(Integer.parseInt(magiangvien));
			// thÃ´ng bÃ¡o
			request.setAttribute("message", "Đã Xóa Thành Công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	
	private void TimKiemGiangVienBangTen(HttpServletRequest req, HttpServletResponse resp) {

		String ten = req.getParameter("ten");
		List<GiangVien> giangviens = giangvienService.findByTenGV(ten);

		req.setAttribute("giangviens", giangviens);
		req.setAttribute("ten", ten);
		try {
			req.getRequestDispatcher("/views/giangvien/timkiem-giangvien-ten.jsp").forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
