package dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import metier.*;

/**
 * Classe de test pour Hibernate.
 */
public class TestHibernate
{
	/**
	 * Programme de test.
	 */
	public static void main(String[] args) {
	    try {
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/*
	 *  Méthodes pour utiliser la classe Produit
	 */
	public static String loadStringProduit(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Produit e = session.load(Produit.class, id);
			String d = e.toString();
			session.close();
			return d; 
		}
	}
	
	public static Produit loadProduit(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Produit e = session.get(Produit.class, id);
			session.close();
			return e; 
		}
	}
	
	public static Produit createProduit(String lib, double PrixU, double Prixkg, String nutriScore, double Pds, String condition) {
		Produit e = new Produit(lib, PrixU, Prixkg, nutriScore, Pds, condition); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
	
	/*
	 * Méthodes pour utiliser la classe Commande
	 */
	public static Commande createCommande(Etat etat) {
		Commande e = new Commande(etat); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
	
	/*
	 * Méthodes pour utiliser la classe Contenir
	 */
	public static Contenir createContenir(Panier panier, Produit produit, int quantite) {
		Contenir e = new Contenir(panier, produit, quantite); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
	
	/*
	 * Méthodes pour utiliser la classe ContenirId
	 */
	public static ContenirId createContenirId(int CodeP, int CodePa) {
		ContenirId e = new ContenirId(CodeP, CodePa); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
	
	/*
	 * Méthodes pour utiliser la classe ListeCourse
	 */
	public static ListeCourse createListeCourse(String nom) {
		ListeCourse e = new ListeCourse(nom); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
	
	/*
	 * Méthodes pour utiliser la classe Magasin
	 */
	public static Magasin createMagasin(String nom, String adr) {
		Magasin e = new Magasin(nom, adr); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
	
	/*
	 * Méthodes pour utiliser la classe Panier
	 */
	public static Panier createPanier() {
		Panier e = new Panier(); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	} 
	
	/*
	 * Méthodes pour utiliser la classe Categorie
	 */
	public static Categorie createCategorie(String nom) {
		Categorie e = new Categorie(nom); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	} 
	
	/*
	 * Méthodes pour utiliser la classe Promotion
	 */
	public static Promotion createPromotion(String type, int valeur, Date datedeb, Date datefin) {
		Promotion e = new Promotion(type, valeur, datedeb, datefin); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	} 
	
	/*
	 * Méthodes pour utiliser la classe Rayon
	 */
	public static Rayon createRayon(String nom) {
		Rayon e = new Rayon(nom); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
	
	/*
	 * Méthodes pour utiliser la classe Stock
	 */
	public static Stock createStock(Produit produit, Magasin magasin, int qteStock, Date dateStock) {
		Stock e = new Stock(produit, magasin, qteStock, dateStock); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
	
	/*
	 * Méthodes pour utiliser la classe Utilisateur
	 */
	public static Utilisateur createUtilisateur(String prenom, String nom, String adresse, String mail, String mdp) {
		Utilisateur e = new Utilisateur(prenom, nom, adresse, mail, mdp); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t = session.beginTransaction();
			session.save(e); 
			t.commit(); 
			session.close(); 
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
		return e;
	}
} /*----- Fin de la classe TestHibernate -----*/
