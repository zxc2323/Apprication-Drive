package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.Utilisateur;

public class UtilisateurDAO {

	public List<Utilisateur> findAllUtilisateur(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Utilisateur";
			Query<Utilisateur> query = session.createQuery(hql,Utilisateur.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
