package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.Etat;



public class EtatDAO {

	public List<Etat> findAllEtats(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Etat";
			Query<Etat> query = session.createQuery(hql,Etat.class);
			return query.list();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
