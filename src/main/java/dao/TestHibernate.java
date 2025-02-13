package dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
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
		String[] descriptions = {
	            "Courses de la semaine", "Produits pour le dîner", "Liste pour l’anniversaire",
	            "Ingrédients pour le gâteau", "Stock pour le mois", "Repas équilibré",
	            "Courses express", "Achats pour la famille", "Liste spéciale promo",
	            "Préparation du week-end", "Articles pour la cuisine", "Boissons et snacks",
	            "Fruits et légumes bio", "Essentiels du petit-déjeuner", "Courses de dernière minute",
	            "Courses pour la soirée", "Recharge en produits ménagers", "Ravitaillement en viande",
	            "Besoin de produits frais", "Liste pour l’été", "Spécial repas en extérieur",
	            "Préparation de pique-nique", "Courses pour la rentrée", "Articles de santé",
	            "Épicerie fine", "Stock de la salle de bain", "Vêtements et accessoires",
	            "Fournitures pour le bureau", "Jeux et divertissements", "Achats de Noël"
	        };

	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            session.beginTransaction();

	            int userId = 16; // Commence avec le premier utilisateur valide

	            for (int i = 1; i <= 30; i++) { // Pour chaque liste de course
	                ListeCourse liste = session.get(ListeCourse.class, i);
	                if (liste != null) {
	                    liste.setDescrPostIt(descriptions[i - 1]); // Attribuer une description

	                    Utilisateur utilisateur = session.get(Utilisateur.class, userId);
	                    if (utilisateur != null) {
	                        liste.setUtilisateur(utilisateur);
	                    }

	                    session.update(liste);

	                    // Boucle entre les ID 16 et 36
	                    userId = (userId < 36) ? userId + 1 : 16;
	                }
	            }

	            session.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	
	/*
	 *  Méthodes pour utiliser la classe Produit
	 */
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
	
	public static Commande loadCommande(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Commande e = session.get(Commande.class, id);
			session.close();
			return e; 
		}
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
	
	public static ContenirId loadContenirId(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			ContenirId e = session.get(ContenirId.class, id);
			session.close();
			return e; 
		}
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
	
	public static ListeCourse loadListeCourse(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			ListeCourse e = session.get(ListeCourse.class, id);
			session.close();
			return e; 
		}
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
	
	public static Magasin loadMagasin(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Magasin e = session.get(Magasin.class, id);
			session.close();
			return e; 
		}
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
	
	public static Categorie loadCategorie(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Categorie e = session.get(Categorie.class, id);
			session.close();
			return e; 
		}
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
	
	public static Promotion loadPromotion(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Promotion e = session.get(Promotion.class, id);
			session.close();
			return e; 
		}
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
	
	public static Rayon loadRayon(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Rayon e = session.get(Rayon.class, id);
			session.close();
			return e; 
		}
	}
	
	/*
	 * Méthodes pour utiliser la classe Stock
	 */
	public static Stock createStock(int qteStock, Date dateStock) {
		Stock e = new Stock(qteStock, dateStock); 
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
	
	public static Stock loadStock(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Stock e = session.get(Stock.class, id);
			session.close();
			return e; 
		}
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
	
	public static Utilisateur loadUtilisateur(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Utilisateur e = session.get(Utilisateur.class, id);
			session.close();
			return e; 
		}
	}
} /*----- Fin de la classe TestHibernate -----*/
