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
import vn.Entity.HoiDong;
import vn.Entity.ThamGiaHoiDong;
import vn.Service.IGiangVienService;
import vn.Service.IHoiDongService;
import vn.Service.IThamGiaHoiDongService;
import vn.Service.Impl.GiangVienServiceImpl;
import vn.Service.Impl.HoiDongServiceImpl;
import vn.Service.Impl.ThamGiaHoiDongImpl;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = { "/admin-hoidong", "/admin-hoidong/create", "/admin-hoidong/update", "/admin-hoidong/edit",
		"/admin-hoidong/delete", "/admin-hoidong/reset", "/admin-hoidong/add", "/admin-hoidong/addthanhvien",
		"/admin-hoidong/deletethanhvien" })
public class HoiDongController extends HttpServlet {
	IHoiDongService hoidongService = new HoiDongServiceImpl();
	IGiangVienService giangvienservice = new GiangVienServiceImpl();
	IThamGiaHoiDongService thamgiaservice = new ThamGiaHoiDongImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();
		HoiDong hoidong = null;
		if (url.contains("create")) {
			request.getRequestDispatcher("/views/admin/hoidong/add.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			hoidong = new HoiDong();
			request.setAttribute("hoidong", hoidong);
		} else if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("reset")) {
			hoidong = new HoiDong();
			request.setAttribute("hoidong", hoidong);
		} else if (url.contains("addthanhvien")) {
		

			
			  String id = request.getParameter("id"); request.setAttribute("mahoidong",
			  id);
			  
			  List<GiangVien> list = giangvienservice.findAll();
			  request.setAttribute("giangvien", list);
			  
			  List<ThamGiaHoiDong> thamgiahoidong = thamgiaservice.findAll();
			  request.setAttribute("thamgiahoidongs", thamgiahoidong);
			  
			  List<GiangVien> listgiangvien=giangvienservice.findAll();
				request.setAttribute("giangviens", listgiangvien);
			  
			  request.getRequestDispatcher("/views/admin/hoidong-add.jsp").forward(request,
			  response);
			 
		} else if (url.contains("add")) {

			String id = request.getParameter("id");
			request.setAttribute("mahoidong", id);

			List<GiangVien> list = giangvienservice.findAll();
			request.setAttribute("giangvien", list);

			List<ThamGiaHoiDong> thamgiahoidong = thamgiaservice.findAll();
			request.setAttribute("thamgiahoidongs", thamgiahoidong);
			List<GiangVien> listgiangvien=giangvienservice.findAll();
			request.setAttribute("giangviens", listgiangvien);

			request.getRequestDispatcher("/views/admin/hoidong-add.jsp").forward(request, response);
		} else if (url.contains("deletethanhvien")) {
			try {
				String mahoidong = request.getParameter("mahoidong");
				String magiangvien = request.getParameter("ma");
				List<ThamGiaHoiDong> thamgiahd = thamgiaservice.findAllByGiangVien(Integer.parseInt(magiangvien));
				ThamGiaHoiDong thamgia = null;
				for (ThamGiaHoiDong hd : thamgiahd) {
					if (Integer.parseInt(mahoidong) == hd.getMahoidong())
						thamgia = hd;

				}
				if (thamgia != null)
					thamgiaservice.delete(16);

				request.setAttribute("message", "Đã xoá thành công");
				request.getRequestDispatcher("/views/admin/hoidong-add.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Eror: " + e.getMessage());
			}
			

		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/admin/list-hoidong.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy url
		String url = request.getRequestURL().toString();
		// kiểm tra url rồi chuyển đến hàm tương ứng
		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("hoidong", new HoiDong());
		} else if (url.contains("add")) {
			addTruong(request, response);
		} else if (url.contains("addthanhvien")) {
		
			addThanhvien(request, response);
		}

		else if (url.contains("deletethanhvien")) {
			try {
				String mahoidong = request.getParameter("mahoidong");
				String magiangvien = request.getParameter("magiangvien");
				List<ThamGiaHoiDong> thamgiahd = thamgiaservice.findAllByGiangVien(Integer.parseInt(magiangvien));
				ThamGiaHoiDong thamgia = null;
				for (ThamGiaHoiDong hd : thamgiahd) {
					if (Integer.parseInt(mahoidong) == hd.getMahoidong())
						thamgia = hd;

				}
				if (thamgia != null)
					thamgiaservice.delete(thamgia.getId());

				request.setAttribute("message", "Đã xoá thành công");
				request.getRequestDispatcher("/views/admin/hoidong-add.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Eror: " + e.getMessage());
			}

		}

		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/list-hoidong.jsp").forward(request, response);
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			HoiDong hoidong = new HoiDong();
			// sử dụng BeanUtils để tự lấy các name Field trên form
			// tên field phải trùng với entity
			BeanUtils.populate(hoidong, request.getParameterMap());

			// gọi hàm insert để thêm dữ liệu
			hoidongService.insert(hoidong);
			// thông báo
			request.setAttribute("message", "Đã Thêm Thành Công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void addTruong(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			HoiDong hoidong = hoidongService.findById(Integer.parseInt(request.getParameter("mahoidong")));

			int magiangvien = Integer.parseInt(request.getParameter("truonghoidong"));

			List<HoiDong> listhoidong = hoidongService.findAll();
			int check = 0;
			for (HoiDong hd : listhoidong) {
				if (hd.getTruonghoidong() != null) {
					if (hd.getMahoidong() == hoidong.getMahoidong()
							&& Integer.parseInt(hd.getTruonghoidong()) == magiangvien)

						check = 1;
				}

			}
			ThamGiaHoiDong hd = null;
			if (check == 0) {

				List<ThamGiaHoiDong> listthamgia = thamgiaservice.findAllByGiangVien(magiangvien);
				for (ThamGiaHoiDong thamgia : listthamgia) {
					if (thamgia.getMahoidong() == hoidong.getMahoidong() && thamgia.getMagiangvien() == magiangvien)
						hd = thamgia;

				}
				if (hd != null)
					thamgiaservice.delete(hd.getId());
			}
			// thamgiaservice.
			hoidong.setTruonghoidong(request.getParameter("truonghoidong"));
		//	thamgiaservice.delete(38);
			hoidongService.update(hoidong);

			ThamGiaHoiDong thamgia = new ThamGiaHoiDong();
			thamgia.setMahoidong(hoidong.getMahoidong());
			thamgia.setMagiangvien(magiangvien);
			thamgiaservice.insert(thamgia);

			request.setAttribute("message", "Đã Thêm Thành Công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void addThanhvien(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			HoiDong hoidong = hoidongService.findById(Integer.parseInt(request.getParameter("mahoidong")));

			int magiangvien = Integer.parseInt(request.getParameter("truonghoidong"));
			
			List<ThamGiaHoiDong> thamgiahoidong=thamgiaservice.findAllByGiangVien(magiangvien);
			
			ThamGiaHoiDong thamgia=null;
			for(ThamGiaHoiDong tg: thamgiahoidong )
			{
				if(tg.getMahoidong()==hoidong.getMahoidong())
					thamgia=tg;
			}
			if(thamgia.getId() >0)
				thamgiaservice.delete(thamgia.getId());			
		
		  thamgia = new ThamGiaHoiDong();
			thamgia.setMahoidong(hoidong.getMahoidong());
			thamgia.setMagiangvien(magiangvien);
			thamgiaservice.insert(thamgia);
			request.setAttribute("message", "Đã Thêm Thành Công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<HoiDong> list = hoidongService.findAll();
			List<GiangVien> listgiangvien=giangvienservice.findAll();
			request.setAttribute("giangviens", listgiangvien);
			// thông báo
			request.setAttribute("hoidongs", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
