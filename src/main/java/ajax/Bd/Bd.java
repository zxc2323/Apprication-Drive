package ajax.Bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import metier.Commande;
import metier.Etat;
import metier.Produit;


/**
 * Classe en charge de la base de données.
 */
public class Bd
{
	/*---------*/
	/* Données */
	/*---------*/

	/*----- Connexion -----*/
	private static Connection cx = null;

	/*----- Données de connexion -----*/
	private static final String URL			= "jdbc:mysql://localhost:3307/db_22006090_2";
	private static final String LOGIN		= "22006090";
	private static final String PASSWORD	= "6737GG";


	/*----------*/
	/* Méthodes */
	/*----------*/

	/**
	 * Crée la connexion avec la base de données.
	 */
	private static void connexion() throws ClassNotFoundException, SQLException
		{
		/*----- Chargement du pilote pour la BD -----*/
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}
		catch (ClassNotFoundException ex)
			{
			throw new ClassNotFoundException("Exception Bd.connexion() - Pilote MySql introuvable - " + ex.getMessage());
			}

		/*----- Ouverture de la connexion -----*/
		try {
			Bd.cx = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			}
		catch (SQLException ex)
			{
			throw new SQLException("Exception Bd.connexion() - Problème de connexion à la base de données - " + ex.getMessage());
			}
		}
	
	
	/**
	 * Retourne la liste des commandes selon l'idUtil transmis
	 */
	public static ArrayList<Commande> recupererCommandes(String idUtil) throws ClassNotFoundException, SQLException {
	    /*----- Création de la connexion à la base de données -----*/
	    if (Bd.cx == null)
	        Bd.connexion();

	    /*----- Interrogation de la base -----*/
	    ArrayList<Commande> commandes = new ArrayList<>();

	    /*----- Requête SQL -----*/
	    String sql = "SELECT C.idCommande, C.etatCommande, C.dateCommande "
	            + "FROM Commande C "
	            + "JOIN Magasin M ON C.CodeMag = M.idMag "
	            + "JOIN Utilisateur U ON M.idMag = U.CodeMag "
	            + "WHERE U.IdUtil = ? AND C.etatCommande <> 'LIVREE' " //A voir si il ne faut pas mettre un chiffre de réference à la place 
	            + "ORDER BY C.dateCommande ASC"; //dateRetraitCommande

	    /*----- Ouverture de l'espace de requête -----*/
	    try (PreparedStatement st = Bd.cx.prepareStatement(sql)) {
	        st.setString(1, idUtil);
	        try (ResultSet rs = st.executeQuery()) {
	            /*----- Lecture du contenu du ResultSet -----*/
	        	while (rs.next()) {
	        		int idCommande = rs.getInt("idCommande");

                    // Conversion de la chaîne en Enum
                    Etat etatCommande = Etat.valueOf(rs.getString("etatCommande"));

                    // Conversion du Timestamp en Date
                    java.sql.Date sqlDate = rs.getDate("dateCommande");
                    Date dateRetraitCommande = new Date(sqlDate.getTime());

                    Commande cmd = new Commande(idCommande, etatCommande, dateRetraitCommande);
                    commandes.add(cmd);
	            }
	        }
	    }
	    return commandes;
	}

	
	public static ArrayList<Produit> recuperer1Commande(String idCommande) throws ClassNotFoundException, SQLException
	{
		/*----- Création de la connexion à la base de données -----*/
		if (Bd.cx == null)
			Bd.connexion();

		/*----- Interrogation de la base -----*/
		ArrayList<Produit> produits = new ArrayList<>();

		/*----- Requête SQL -----*/
		String sql = "SELECT P.idPro, P.urlImage, P.libellePro, P.PoidsPro, P.conditionnementPro, P.PrixUnitaire, P.Prix_kg, P.Nutriscore"
				+ "   FROM Produit P, Commande C "
				+ "   WHERE P.CodeCommande = C.idCommande "
				+ "   AND C.idCommande = (?) ;";  //voir id en int ou en String 
		// Voir si il faut mettre un point-virgule en fin de requete

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = Bd.cx.prepareStatement(sql))
			{
			/*----- Exécution de la requête -----*/
			st.setString(1, idCommande);
			try (ResultSet rs = st.executeQuery()) {
	            /*----- Lecture du contenu du ResultSet -----*/
				while (rs.next()) {
	        		int idPro = rs.getInt("idPro");
	        		String urlImage = rs.getString("urlImage");
	        		String libellePro = rs.getString("libellePro");
	        		double PoidsPro = rs.getInt("PoidsPro");
	        		String conditionnementPro = rs.getString("conditionnementPro");
	        		double PrixUnitairePro = rs.getInt("PrixUnitaire");
	        		double Prix_kg = rs.getInt("Prix_kg");
	        		String Nutriscore = rs.getString("Nutriscore");

                    Produit produit = new Produit(idPro, urlImage, libellePro, PrixUnitairePro, Prix_kg, Nutriscore, PoidsPro, conditionnementPro);
                    produits.add(produit);
	            }
	            }
	        }
		catch (SQLException ex)
			{
			throw new SQLException("Exception Bd.recuperer1Commande() : Problème SQL - " + ex.getMessage());
			}

		return produits;
	}
	
	
	/**
	 * Ajouter mots dans la table Mot colonne Texte
	 */
	public static void changerEtatCommande(String idCommande, String nouvelEtat) throws ClassNotFoundException, SQLException {
	    if (Bd.cx == null) 
	        Bd.connexion();

	    String sql = "UPDATE Commande SET etatCommande = ? WHERE idCommande = ?";

	    try (PreparedStatement st = Bd.cx.prepareStatement(sql)) {
	        st.setString(1, nouvelEtat);
	        st.setString(2, idCommande);
	        st.executeUpdate();
	    }
	}

	/*----------------------------*/
	/* Programme principal (test) */
	/*----------------------------*/

	public static void main (String[] s)
		{
		
		}

} /*----- Fin de la classe Bd -----*/

