package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.Stock;

public class StockDAO {
	public List<Stock> findAllStock(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Stock";
			Query<Stock> query = session.createQuery(hql,Stock.class);
			return query.list();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
