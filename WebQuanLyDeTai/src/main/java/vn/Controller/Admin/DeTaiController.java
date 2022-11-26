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

import vn.Entity.DeTai;

import vn.Service.IDeTaiService;
import vn.Service.Impl.DeTaiServiceImpl;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/admin-detai", "/admin-detai/create", "/admin-detai/edit", "/admin-detai/update",
		"/admin-detai/reset", "/admin-detai/delete", "/admin-detai/search", "/admin-detai/ma",
		"/admin-detai/search-tengv" })
public class DeTaiController extends HttpServlet {
	IDeTaiService detaiService = new DeTaiServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiá»ƒm tra url rá»“i chuyá»ƒn Ä‘áº¿n hÃ m tÆ°Æ¡ng á»©ng
		// láº¥y url
		String url = request.getRequestURL().toString();
		DeTai detai = null;

		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/detai/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			detai = new DeTai();
			request.setAttribute("detai", detai);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			detai = new DeTai();
			request.setAttribute("detai", detai);
		} else if (url.contains("search")) {

			TimKiemDeTai(request, response);

		} else if (url.contains("ma")) {

			TimKiemDeTaiBangMa(request, response);

		}

		else if (url.contains("search-tengv")) {

			TimKiemDeTaiBangTengv(request, response);

		}

		// gá»�i hÃ m findAll Ä‘á»ƒ láº¥y thÃ´ng tin tá»« entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/list-detai.jsp").forward(request, response);
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
			request.setAttribute("detai", new DeTai());
		} else if (url.contains("search")) {
			TimKiemDeTai(request, response);
		} else if (url.contains("ma")) {
			TimKiemDeTaiBangMa(request, response);
		}else if (url.contains("search-tengv")) {
			TimKiemDeTaiBangTengv(request, response);
		}

		// gá»�i hÃ m findAll Ä‘á»ƒ láº¥y thÃ´ng tin tá»« entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/list-detai.jsp").forward(request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khá»Ÿi táº¡o DAO
			// khai bÃ¡o danh sÃ¡ch vÃ  gá»�i hÃ m findAll() trong dao
			List<DeTai> list = detaiService.findAll();
			// thÃ´ng bÃ¡o
			request.setAttribute("detais", list);
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
			DeTai detai = new DeTai();
			// sá»­ dá»¥ng BeanUtils Ä‘á»ƒ tá»± láº¥y cÃ¡c name Field trÃªn form
			// tÃªn field pháº£i trÃ¹ng vá»›i entity
			BeanUtils.populate(detai, request.getParameterMap());
			detaiService.insert(detai);
			// thÃ´ng bÃ¡o
			request.setAttribute("message", "Ä�Ã£ thÃªm thÃ nh cÃ´ng");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// khai bÃ¡o biáº¿n userId
			String madetai = request.getParameter("madetai");
			// khá»Ÿi táº¡o DAO
			// gá»�i hÃ m insert Ä‘á»ƒ thÃªm dá»¯ liá»‡u
			DeTai detai = detaiService.findById(Integer.parseInt(madetai));
			// thÃ´ng bÃ¡o
			request.setAttribute("detai", detai);
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
			DeTai detai = new DeTai();
			BeanUtils.populate(detai, request.getParameterMap());

			// khai bÃ¡o danh sÃ¡ch vÃ  gá»�i hÃ m update trong service
			detaiService.update(detai);
			// thÃ´ng bÃ¡o
			request.setAttribute("detai", detai);
			request.setAttribute("message", "Cáº­p nháº­t thÃ nh cÃ´ng!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// láº¥y dá»¯ liá»‡u trong jsp
			String madetai = request.getParameter("madetai");
			// khá»Ÿi táº¡o DAO
			// khai bÃ¡o danh sÃ¡ch vÃ  gá»�i hÃ m findAll() trong dao
			detaiService.delete(Integer.parseInt(madetai));
			// thÃ´ng bÃ¡o
			request.setAttribute("message", "Ä�Ã£ xÃ³a thÃ nh cÃ´ng");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	private void TimKiemDeTai(HttpServletRequest req, HttpServletResponse resp) {

		String tendetai = req.getParameter("tendetai");
		List<DeTai> detais = detaiService.findByTenDeTai(tendetai);

		req.setAttribute("detais", detais);
		req.setAttribute("tendetai", tendetai);
		try {
			req.getRequestDispatcher("/views/detai/timkiem-detai-ten.jsp").forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void TimKiemDeTaiBangMa(HttpServletRequest req, HttpServletResponse resp) {

		String madetai = req.getParameter("madetai");
		List<DeTai> detais = detaiService.findByTenDeTai(madetai);

		req.setAttribute("detais", detais);
		req.setAttribute("madetai", madetai);
		try {
			req.getRequestDispatcher("/views/detai/timkiem-detai-ma.jsp").forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	private void TimKiemDeTaiBangTengv(HttpServletRequest req, HttpServletResponse resp) {

		String giangvien = req.getParameter("giangvien");
		List<DeTai> detaim = detaiService.findByTenDeTai(giangvien);

		req.setAttribute("detaim", detaim);
		req.setAttribute("giangvien", giangvien);
		try {
			req.getRequestDispatcher("/views/detai/timkiem-detai-ten.jsp").forward(req, resp);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
