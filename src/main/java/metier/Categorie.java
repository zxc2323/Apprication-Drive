package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCate")
	private int idCate; 
	
	@Column(name="nomCate")
	private String nomCate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeRay")
	private Rayon rayon;
	
	@OneToMany(mappedBy="categorie")
	private Set<Produit> produits = new HashSet<>();

	public Categorie() {}
	
	public Categorie(String nom) {
		this.nomCate = nom;
	}

	// Getter et Setter pour idCate
	public int getIdCate() {
	    return idCate;
	}

	public void setIdCate(int idCate) {
	    this.idCate = idCate;
	}

	// Getter et Setter pour nomCate
	public String getNomCate() {
	    return nomCate;
	}

	public void setNomCate(String nomCate) {
	    this.nomCate = nomCate;
	}

	// Getter et Setter pour rayon
	public Rayon getRayon() {
	    return rayon;
	}

	public void setRayon(Rayon rayon) {
	    this.rayon = rayon;
	}

	// Getter et Setter pour produits
	public Set<Produit> getProduits() {
	    return produits;
	}

	public void setProduits(Set<Produit> produits) {
	    this.produits = produits;
	}

	// Méthode pour ajouter un produit à la catégorie
	public void addProduit(Produit produit) {
	    if (produits == null) {
	        produits = new HashSet<>();
	    }
	    produits.add(produit);
	    produit.setCategorie(this); // Associe le produit à cette catégorie
	}

	// Méthode pour supprimer un produit de la catégorie
	public void removeProduit(Produit produit) {
	    if (produits != null) {
	        produits.remove(produit);
	        produit.setCategorie(null); // Désassocie le produit de la catégorie
	    }
	}

	// Méthode utilitaire pour vérifier si un produit est dans la catégorie
	public boolean containsProduit(Produit produit) {
	    return produits != null && produits.contains(produit);
	}

	// Méthode pour obtenir le nombre total de produits dans la catégorie
	public int getNombreProduits() {
	    return produits != null ? produits.size() : 0;
	}

}
