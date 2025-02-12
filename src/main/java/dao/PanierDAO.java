package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.*;

public class PanierDAO {
	public List<Panier> findAllPanier(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Panier";
			Query<Panier> query = session.createQuery(hql,Panier.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
