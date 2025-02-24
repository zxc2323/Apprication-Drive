package dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import metier.Rayon;
import org.hibernate.query.Query;

public class RayonDAO {
    public List<Rayon> getAllRayons() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Rayon";
            Query<Rayon> query = session.createQuery(hql, Rayon.class);

            List<Rayon> result = query.list();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Rayon getRayonById(int id){
    	try(Session session=HibernateUtil.getSessionFactory().openSession()){
    		String hql = "from Rayon where CodeRay=:id";
    		Query<Rayon> query = session.createQuery(hql,Rayon.class);
    		query.setParameter("id", id); // 绑定参数
    		Rayon result = query.uniqueResult(); // 获取唯一结果
    		if (result == null) {
    		    System.out.println("No Rayon found with ID: " + id);
    		    return null;
    		}
    		return result;
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		return null;
		}
    }
    
    
    }

