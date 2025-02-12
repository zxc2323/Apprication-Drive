package metier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Panier")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPanier")
	private int idPanier; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeUtil")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="panier")
	private Set<Produit> produits = new HashSet<>();
	
	public Panier() {}
	
	// Getter et Setter pour idPanier
	public int getIdPanier() {
	    return idPanier;
	}

	public void setIdPanier(int idPanier) {
	    this.idPanier = idPanier;
	}

	// Getter et Setter pour utilisateur
	public Utilisateur getUtilisateur() {
	    return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
	    this.utilisateur = utilisateur;
	}

	// Getter et Setter pour produits
	public Set<Produit> getProduits() {
	    return produits;
	}

	public void setProduits(Set<Produit> produits) {
	    this.produits = produits;
	}

	// Méthode pour ajouter un produit
	public void addProduit(Produit produit) {
	    this.produits.add(produit);
	    produit.setPanier(this);
	}

	// Méthode pour supprimer un produit
	public void removeProduit(Produit produit) {
	    this.produits.remove(produit);
	    produit.setPanier(null);
	}

	// Méthode toString pour afficher les informations du panier
	@Override
	public String toString() {
	    return "Panier{" +
	            "idPanier=" + idPanier +
	            ", utilisateur=" + utilisateur.getNomUtil() + " " + utilisateur.getPrenomUtil() +
	            ", nombre de produits=" + produits.size() +
	            '}';
	}

}
