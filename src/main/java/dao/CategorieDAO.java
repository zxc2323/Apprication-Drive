package dao;

import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Session;
import org.hibernate.query.Query;

import metier.Categorie;
import net.bytebuddy.asm.Advice.This;

public class CategorieDAO {
	
	public List<Categorie> findAllCategorie() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Categorie";
            Query<Categorie> query = session.createQuery(hql,Categorie.class);
            return query.list();
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
        	return null;
		}
    }
	
	public List<Categorie> findCategoriebyCodeRay(int Ray){
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			String hql = "from Categorie where coderay = :id";
			Query<Categorie> query = session.createQuery(hql,Categorie.class);
			return query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
	}
	

	
}
