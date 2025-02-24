package metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCommande")
	private int idCommande; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="etatCommande", nullable = false)
	private Etat etatCommande;
	
	@Column(name="dateRetraitCommande")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateRetraitCommande; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeUtil")
	private Utilisateur utilisateur;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodePreparateur")
	private Utilisateur preparateur;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeMag")
	private Magasin magasin;
	
	@OneToMany(mappedBy="commande")
	private Set<Produit> produits = new HashSet<>();
	
	public Commande() {}
	
	public Commande(Etat etat) {
		this.etatCommande = etat;
	}
	
	public Commande(int idCommande, Etat etat, Date dateRetrait) {
		this.etatCommande = etat;
		this.idCommande = idCommande; 
		this.dateRetraitCommande = dateRetrait;
	}
	
	public Date getDateRetrait() {
		return this.dateRetraitCommande;
	}
	
	public void setDateRetrait(Date date) {
		this.dateRetraitCommande = date;
	}
	
	// Getter et Setter pour idCommande
	public int getIdCommande() {
	    return idCommande;
	}

	public void setIdCommande(int idCommande) {
	    this.idCommande = idCommande;
	}

	// Getter et Setter pour etatCommande
	public Etat getEtatCommande() {
	    return etatCommande;
	}

	public void setEtatCommande(Etat etatCommande) {
	    this.etatCommande = etatCommande;
	}

	// Getter et Setter pour utilisateur
	public Utilisateur getUtilisateur() {
	    return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
	    this.utilisateur = utilisateur;
	}
	
	// Getter et Setter pour preparateur
	public Utilisateur getPreparateur() {
	    return utilisateur;
	}

	public void setPreparateur(Utilisateur preparateur) {
	    this.preparateur = preparateur;
	}

	// Getter et Setter pour magasin
	public Magasin getMagasin() {
	    return magasin;
	}

	public void setMagasin(Magasin magasin) {
	    this.magasin = magasin;
	}

	// Getter et Setter pour produits
	public Set<Produit> getProduits() {
	    return produits;
	}

	public void setProduits(Set<Produit> produits) {
	    this.produits = produits;
	}

	// Méthode pour ajouter un produit à la commande
	public void addProduit(Produit produit) {
	    if (produits == null) {
	        produits = new HashSet<>();
	    }
	    produits.add(produit);
	    produit.setCommande(this); // Associe le produit à cette commande
	}

	// Méthode pour supprimer un produit de la commande
	public void removeProduit(Produit produit) {
	    if (produits != null) {
	        produits.remove(produit);
	        produit.setCommande(null); // Désassocie le produit de la commande
	    }
	}

	// Méthode pour vérifier si un produit est dans la commande
	public boolean containsProduit(Produit produit) {
	    return produits != null && produits.contains(produit);
	}

	// Méthode pour obtenir le nombre total de produits dans la commande
	public int getNombreProduits() {
	    return produits != null ? produits.size() : 0;
	}

	// Méthode pour annuler une commande
	public void annulerCommande() {
	    this.etatCommande = Etat.ANNULEE;
	}
	
	// Méthode toString pour l'affichage des informations de la commande
    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", etatCommande=" + etatCommande +
                ", utilisateur=" + utilisateur.getIdUtil() +
                ", magasin=" + magasin.getIdMag() +
                '}';
    }

}
