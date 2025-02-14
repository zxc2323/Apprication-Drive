package dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import metier.Produit;
import org.hibernate.query.Query;

public class ProduitDAO {

    public List<Produit> getProduitsParMotCle(String motCle) throws Exception {
        if (motCle == null || motCle.trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot-clé de recherche est vide !");
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Produit p WHERE p.libellePro LIKE :motCle";
            Query<Produit> query = session.createQuery(hql, Produit.class);
            query.setParameter("motCle", "%" + motCle + "%");

            List<Produit> result = query.list();
            System.out.println("Produits trouvés: " + result.size());
            return result;
        } catch (Exception e) {
            System.err.println("Erreur Hibernate dans ProduitDAO: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Produit> getProduitsParRayon(int rayonId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Produit WHERE rayon.id = :rayonId";
            Query<Produit> query = session.createQuery(hql, Produit.class);
            query.setParameter("rayonId", rayonId);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}

