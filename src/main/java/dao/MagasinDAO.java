package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;



import metier.*;

public class MagasinDAO {

	public List<Magasin> findAllMagasin(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Magasin";
			Query<Magasin> query = session.createQuery(hql,Magasin.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
}
