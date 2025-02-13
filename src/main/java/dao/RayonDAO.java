package dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import metier.Rayon;
import org.hibernate.query.Query;

public class RayonDAO {
    public static List<Rayon> getAllRayons() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Rayon";
            Query<Rayon> query = session.createQuery(hql, Rayon.class);

            List<Rayon> result = query.list();
            System.out.println("Rayons trouvés: " + result.size());
            return result;
        } catch (Exception e) {
            System.err.println("Erreur Hibernate dans RayonDAO: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    }

