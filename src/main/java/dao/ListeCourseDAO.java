package dao;
import metier.*;
import java.util.*;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.query.Query;



public class ListeCourseDAO {

	public List<ListeCourse> findAllListeCourses(){
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = "from ListeCourse";
			Query<ListeCourse> query = session.createQuery(hql,ListeCourse.class);
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public void insert(ListeCourse lc) {
		org.hibernate.Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			tx= session.beginTransaction();
			session.save(lc);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (tx != null) {
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    // Log the rollback exception
                    ex.printStackTrace();
                }
            }
		}
	}
	public ListeCourse findListeCourseById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from ListeCourse where idListe = :id";
            Query<ListeCourse> query = session.createQuery(hql, ListeCourse.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
	
	public Set<Produit> findproduitById(int id){
		
		return null;
		
	}
	
}
