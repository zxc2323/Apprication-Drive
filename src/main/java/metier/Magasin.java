package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Magasin")
public class Magasin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idMag")
	private int idMag; 
	
	@Column(name="nomMag")
	private String nomMag;
	
	@Column(name="adresseMag")
	private String adresseMag;
	
	@OneToMany(mappedBy="magasin")
	private Set<Stock> stocks;
	
	@OneToMany(mappedBy="magasin")
	private Set<Commande> commandes = new HashSet<>();
	
	@OneToMany(mappedBy="magasinTravail")
	private Set<Utilisateur> utilisateurs = new HashSet<>();
	
	public Magasin() {}
	
	public Magasin(String nom, String adr) {
		this.nomMag = nom; 
		this.adresseMag = adr;
	}

	// Getter et Setter pour idMag
	public int getIdMag() {
	    return idMag;
	}

	public void setIdMag(int idMag) {
	    this.idMag = idMag;
	}

	// Getter et Setter pour nomMag
	public String getNomMag() {
	    return nomMag;
	}

	public void setNomMag(String nomMag) {
	    this.nomMag = nomMag;
	}

	// Getter et Setter pour adresseMag
	public String getAdresseMag() {
	    return adresseMag;
	}

	public void setAdresseMag(String adresseMag) {
	    this.adresseMag = adresseMag;
	}

	// Getter et Setter pour stocks
	public Set<Stock> getStocks() {
	    return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
	    this.stocks = stocks;
	}

	// Méthode pour ajouter un stock
	public void addStock(Stock stock) {
	    this.stocks.add(stock);
	    stock.setMagasin(this);
	}

	// Méthode pour supprimer un stock
	public void removeStock(Stock stock) {
	    this.stocks.remove(stock);
	    stock.setMagasin(null);
	}

	// Getter et Setter pour commandes
	public Set<Commande> getCommandes() {
	    return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
	    this.commandes = commandes;
	}

	// Méthode pour ajouter une commande
	public void addCommande(Commande commande) {
	    this.commandes.add(commande);
	    commande.setMagasin(this);
	}

	// Méthode pour supprimer une commande
	public void removeCommande(Commande commande) {
	    this.commandes.remove(commande);
	    commande.setMagasin(null);
	}
	
	// Getter et Setter pour utilsateurs
		public Set<Utilisateur> getUtilisateurs() {
		    return this.utilisateurs;
		}

		public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		    this.utilisateurs = utilisateurs;
		}

		// Méthode pour ajouter une commande
		public void addUtilisateur(Utilisateur utilisateur) {
		    this.utilisateurs.add(utilisateur);
		    utilisateur.setMagasinTravail(this);
		}

		// Méthode pour supprimer une commande
		public void removeUtilisateur(Utilisateur utilisateur) {
		    this.utilisateurs.remove(utilisateur);
		    utilisateur.setMagasinTravail(null);
		}

	// Méthode toString pour afficher les informations du magasin
	@Override
	public String toString() {
	    return "Magasin{" +
	            "id=" + idMag +
	            ", nom='" + nomMag + '\'' +
	            ", adresse='" + adresseMag + '\'' +
	            ", nombre de stocks=" + (stocks != null ? stocks.size() : 0) +
	            ", nombre de commandes=" + (commandes != null ? commandes.size() : 0) +
	            '}';
	}

}
