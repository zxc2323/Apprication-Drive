package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.ContenirId;



public class ContenirIdDAO {
	public List<ContenirId> findAllContenirId(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from ContenirId";
			Query<ContenirId> query = session.createQuery(hql,ContenirId.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
