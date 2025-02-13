package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import metier.*;



public class PromotionDAO {
	public List<Promotion> findAllPromotion(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Promotion";
			Query query = session.createQuery(hql,Promotion.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
}
