package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import metier.ListeCourse;

/**
 * Servlet implementation class ctrlListCourse
 */
@WebServlet("/ListCourse")
public class ctrlListCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ctrlListCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// 使用SessionFactory打开一个新的Session
		Session session = sessionFactory.openSession();

		// 开始事务
		Transaction tx = null;
		try {
		    tx = session.beginTransaction();

		    // 创建一个新的ListeCourse实例
		    ListeCourse listeCourse = new ListeCourse();
		    // 设置listeCourse的属性，例如：
		    // listeCourse.setName("购物清单");
		    
		    // 保存listeCourse实例到数据库
		    session.save(listeCourse);

		    // 提交事务
		    tx.commit();
		    request.setAttribute("a", listeCourse);
		    request.getRequestDispatcher("listCourses.jsp").forward(request, response);
		} catch (HibernateException e) {
		    // 如果出现异常，回滚事务
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    // 关闭Session
		    if (session != null) {
		        session.close();
		    }
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
