package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.*;


public class ProduitDAO {
	public List<Produit> findAllProduit(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Produit";
			Query<Produit> query = session.createQuery(hql,Produit.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
