package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.Role;
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
	
	public boolean insert(String Username,String Adresse,String Nom,String Prenom,String Password) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Utilisateur ut=new Utilisateur(Username,Adresse,Nom,Prenom,Password);
			ut.setRole(Role.CLIENT);
			session.beginTransaction();
			session.save(ut);
	        session.getTransaction().commit();
	        return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	
}
