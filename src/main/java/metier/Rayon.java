package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Rayon")
public class Rayon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private int idRayon; 
	
	@Column(name="nomRayon")
	private String nomRayon; 
	
	@OneToMany(mappedBy="rayon")
	private Set<Produit> produits = new HashSet<>();
	
	@OneToMany(mappedBy="rayon")
	private Set<Categorie> categories = new HashSet<>();
	
	public Rayon() {}
	
	public Rayon(String nom) {
		this.nomRayon = nom;
	}

	// Getter et Setter pour idRayon
	public int getIdRayon() {
	    return idRayon;
	}

	public void setIdRayon(int idRayon) {
	    this.idRayon = idRayon;
	}

	// Getter et Setter pour nomRayon
	public String getNomRayon() {
	    return nomRayon;
	}

	public void setNomRayon(String nomRayon) {
	    this.nomRayon = nomRayon;
	}

	// Getter et Setter pour produits
	public Set<Produit> getProduits() {
	    return produits;
	}

	public void setProduits(Set<Produit> produits) {
	    this.produits = produits;
	}

	// Méthode pour ajouter un produit au rayon
	public void addProduit(Produit produit) {
	    this.produits.add(produit);
	    produit.setRayon(this);
	}

	// Méthode pour supprimer un produit du rayon
	public void removeProduit(Produit produit) {
	    this.produits.remove(produit);
	    produit.setRayon(null);
	}

	// Getter et Setter pour categories
	public Set<Categorie> getCategories() {
	    return categories;
	}

	public void setCategories(Set<Categorie> categories) {
	    this.categories = categories;
	}

	// Méthode pour ajouter une catégorie au rayon
	public void addCategorie(Categorie categorie) {
	    this.categories.add(categorie);
	    categorie.setRayon(this);
	}

	// Méthode pour supprimer une catégorie du rayon
	public void removeCategorie(Categorie categorie) {
	    this.categories.remove(categorie);
	    categorie.setRayon(null);
	}

	// Méthode toString pour afficher les informations du rayon
	@Override
	public String toString() {
	    return "Rayon{" +
	            "id=" + idRayon +
	            ", nom='" + nomRayon + '\'' +
	            ", nombre de produits=" + produits.size() +
	            ", nombre de catégories=" + categories.size() +
	            '}';
	}

}
