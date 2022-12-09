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
@WebServlet(urlPatterns = { "/admin-hoidong", "/admin-hoidong/create", "/admin-hoidong/update",
		"/admin-hoidong/edit", "/admin-hoidong/delete", "/admin-hoidong/reset","/admin-hoidong/add" })
public class HoiDongController extends HttpServlet{
	IHoiDongService hoidongService = new HoiDongServiceImpl();
	IGiangVienService giangvienservice= new GiangVienServiceImpl();
	IThamGiaHoiDongService thamgiaservice=new ThamGiaHoiDongImpl();

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
		}
		else if (url.contains("add")) {
			
			String id= request.getParameter("id");
			request.setAttribute("mahoidong", id);	
			
			List<GiangVien> list= giangvienservice.findAll();
			request.setAttribute("giangvien", list);
			
			List<ThamGiaHoiDong> thamgiahoidong=thamgiaservice.findAll();
			request.setAttribute("thamgiahoidong", thamgiahoidong);
		
			request.getRequestDispatcher("/views/admin/hoidong-add.jsp").forward(request, response);
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
		}
		else if (url.contains("add")) {
			add(request, response);
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
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			// khỏi tạo đối tượng Model
			HoiDong hoidong = hoidongService.findById(Integer.parseInt(request.getParameter("mahoidong")));
			hoidong.setTruonghoidong(request.getParameter("truonghoidong"));
			hoidongService.update(hoidong);
			
			
			System.out.print(hoidong.getMahoidong());
			
			ThamGiaHoiDong thamgia= new ThamGiaHoiDong();
			thamgia.setMahoidong(hoidong.getMahoidong());
			thamgia.setMagiangvien(Integer.parseInt(request.getParameter("truonghoidong")));
			thamgiaservice.insert(thamgia);
			
			ThamGiaHoiDong thamgia1= new ThamGiaHoiDong();
			thamgia1.setMahoidong(hoidong.getMahoidong());
			thamgia1.setMagiangvien(Integer.parseInt(request.getParameter("thanhvien1")));
			thamgiaservice.insert(thamgia1);
			
	

			ThamGiaHoiDong thamgia2= new ThamGiaHoiDong();
			thamgia2.setMahoidong(hoidong.getMahoidong());
			thamgia2.setMagiangvien(Integer.parseInt(request.getParameter("thanhvien2")));
			thamgiaservice.insert(thamgia2);
			


			ThamGiaHoiDong thamgia3= new ThamGiaHoiDong();
			thamgia3.setMahoidong(hoidong.getMahoidong());
			thamgia3.setMagiangvien(Integer.parseInt(request.getParameter("thanhvien3")));
			thamgiaservice.insert(thamgia3);
			
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
			// thông báo
			request.setAttribute("hoidongs", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
}
