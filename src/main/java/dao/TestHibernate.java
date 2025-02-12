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
		 try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
		        Transaction t = session.beginTransaction();

		        for (int i = 1; i <= 10; i++) {
		            // Charger le produit, la catégorie et le rayon correspondants à l'ID i
		            Produit produit = session.get(Produit.class, i);
		            Categorie categorie = session.get(Categorie.class, i);
		            Rayon rayon = session.get(Rayon.class, i);

		            // Vérifier si les entités existent bien
		            if (produit != null && categorie != null && rayon != null) {
		                // Assigner la catégorie et le rayon au produit
		                produit.setCategorie(categorie);
		                produit.setRayon(rayon);

		                // Mettre à jour le produit en base de données
		                session.update(produit);
		            } else {
		                System.out.println("Erreur : Produit, Catégorie ou Rayon introuvable pour l'ID " + i);
		            }
		        }

		        t.commit(); // Valider toutes les mises à jour en une seule transaction
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
	
	public static Contenir loadContenir(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Contenir e = session.get(Contenir.class, id);
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
	
	public static Panier loadPanier(int id) {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			session.beginTransaction();
			Panier e = session.get(Panier.class, id);
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
	public static Stock createStock(Set<Produit> produits, Magasin magasin, int qteStock, Date dateStock) {
		Stock e = new Stock(produits, magasin, qteStock, dateStock); 
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
