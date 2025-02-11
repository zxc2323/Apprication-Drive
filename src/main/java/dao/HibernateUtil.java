package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Chargement de la configuration et création de la SessionFactory.
 * (hibernate.cfg.xml)
 */
public class HibernateUtil
{
	private static final SessionFactory SESSION_FACTORY;

	static
		{
		try	{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");

			/**
			 * Entité.
			 */
			configuration.addAnnotatedClass(metier.Categorie.class);
			configuration.addAnnotatedClass(metier.Utilisateur.class);
			configuration.addAnnotatedClass(metier.Commande.class);
			configuration.addAnnotatedClass(metier.Contenir.class);
			configuration.addAnnotatedClass(metier.ContenirId.class);
			configuration.addAnnotatedClass(metier.ListeCourse.class);
			configuration.addAnnotatedClass(metier.Magasin.class);
			configuration.addAnnotatedClass(metier.Panier.class);
			configuration.addAnnotatedClass(metier.Produit.class);
			configuration.addAnnotatedClass(metier.Promotion.class);
			configuration.addAnnotatedClass(metier.Rayon.class);
			configuration.addAnnotatedClass(metier.Stock.class);
			
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");

            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
			}
		catch (HibernateException ex)
			{
			/*----- Exception -----*/
			System.err.println("Initial SessionFactory creation failed.\n" + ex);
			throw new ExceptionInInitializerError(ex);
			}
		}

	public static SessionFactory getSessionFactory () { return SESSION_FACTORY; }

} /*----- Fin de la classe HibernateUtil -----*/
