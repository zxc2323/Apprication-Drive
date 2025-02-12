package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.Rayon;

public class RayonDAO {

	public List<Rayon> findAllRayon(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Rayon";
			Query query = session.createQuery(hql,Rayon.class);
			return query.list();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
