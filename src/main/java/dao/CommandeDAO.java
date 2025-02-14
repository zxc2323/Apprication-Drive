package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;
import metier.Commande;

public class CommandeDAO {
	
	public List<Commande> findAllCommande(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "from Commande";
			Query<Commande> query = session.createQuery(hql,Commande.class); 
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
