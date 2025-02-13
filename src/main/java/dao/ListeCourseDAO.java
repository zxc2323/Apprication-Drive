package dao;
import metier.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.query.Query;



public class ListeCourseDAO {

	public List<ListeCourse> findAllListeCourses(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from ListeCourse";
			Query<ListeCourse> query = session.createQuery(hql,ListeCourse.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
