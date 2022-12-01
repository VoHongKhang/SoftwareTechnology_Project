package vn.Controller.GiangVien;

import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import vn.Entity.BangDiem;
import vn.Entity.DeTai;
import vn.Service.IBangDiemService;
import vn.Service.IDeTaiService;
import vn.Service.Impl.BangDiemServiceImpl;
import vn.Service.Impl.DeTaiServiceImpl;



@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = {"/giangvien-detai","/giangvien-detai/search","/giangvien-detai/register"})
public class DeTaiController extends HttpServlet {
	IDeTaiService detaiService = new DeTaiServiceImpl();
	IBangDiemService bangdiemservice = new BangDiemServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiểm tra url rồi chuyển đến hàm tương ứng
		// lấy url
		String url = request.getRequestURL().toString();

		if (url.contains("register")) {
			insert(request, response);
			findAll(request, response);
			request.getRequestDispatcher("/views/giangvien/list-detai.jsp").forward(request, response);
		}
			
		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);
		request.setAttribute("tag", "cate");
		request.getRequestDispatcher("/views/giangvien/list-detai.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy url
		String url = request.getRequestURL().toString();
		
		// kiểm tra url rồi chuyển đến hàm tương ứng
		if (url.contains("register")) {
			insert(request, response);
		} 
		// gọi hàm findAll để lấy thông tin từ entity
		findAll(request, response);		
		request.getRequestDispatcher("/views/giangvien/list-detai.jsp").forward(request, response);
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			List<DeTai> list = detaiService.findAll();
			// thông báo
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
			
			String MaDT= request.getParameter("madetai");
			
			int dt=Integer.parseInt(MaDT);

			
			BangDiem bangdiem = new BangDiem();
			bangdiem.setMadetai(dt);
			bangdiem.setMasinhvien("123456");	
			bangdiem.setDiem(0);
			bangdiem.setNamhoc(2022);
			//BeanUtils.populate(bangdiem, map);
			bangdiemservice.insert(bangdiem);
			//detaiService.delete(dt);
			
			// thông báo
			request.setAttribute("message", "Đăng ký thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	

	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// lấy dữ liệu trong jsp
			String madetai = request.getParameter("madetai");
			// khởi tạo DAO
			// khai báo danh sách và gọi hàm findAll() trong dao
			detaiService.delete(Integer.parseInt(madetai));
			// thông báo
			request.setAttribute("message", "Đã xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}
	}
	

	/*private void TimKiemDeTai(HttpServletRequest req, HttpServletResponse resp) {

		String tendetai = req.getParameter("tendetai");
		List<DeTai> detais = detaiService.findByTenDeTai(tendetai);

		req.setAttribute("detais", detais);
		req.setAttribute("tendetai", tendetai);
		try {
			req.getRequestDispatcher("/views/detai/timkiem_detai.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
