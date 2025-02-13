package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.Contenir;

public class ContenirDAO {
	
	public List<Contenir> findAllContenir(){
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Contenir";
			Query<Contenir> query = session.createQuery(hql,Contenir.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
