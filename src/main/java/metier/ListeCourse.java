package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="ListeCourse")
public class ListeCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idListe")
	private int idListe; 
	
	@Column(name="nomListe")
	private String nomListe;
	
	@Column(name="descriptionPostIt")
	private String descrPostIt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeUtil")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="liste_course")
	private Set<Produit> produits = new HashSet<>();
	
	public ListeCourse() {}
	
	public ListeCourse(String nom) {
		this.nomListe = nom;
	}
	
	// Getter et Setter pour idListe
	public int getIdListe() {
	    return idListe;
	}

	public void setIdListe(int idListe) {
	    this.idListe = idListe;
	}

	// Getter et Setter pour nomListe
	public String getNomListe() {
	    return nomListe;
	}

	public void setNomListe(String nomListe) {
	    this.nomListe = nomListe;
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
	    produit.setListeCourse(this);
	}

	// Méthode pour supprimer un produit
	public void removeProduit(Produit produit) {
	    this.produits.remove(produit);
	    produit.setListeCourse(null);
	}

	public String getDescrPostIt() {
		return this.descrPostIt;
	}
	
	public void setDescrPostIt(String descr) {
		this.descrPostIt = descr;
	}
	
	// Méthode toString pour afficher les informations de la liste
	@Override
	public String toString() {
	    return "ListeCourse{" +
	            "idListe=" + idListe +
	            ", nomListe='" + nomListe + '\'' +
	            ", utilisateur=" + utilisateur.getNomUtil() + " " + utilisateur.getPrenomUtil() +
	            ", nombre de produits=" + produits.size() +
	            '}';
	}

}
