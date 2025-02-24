package metier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPro")
	private int idPro; 
	
	@Column(name="libellePro")
	private String libellePro;
	
	@Column(name="PrixUnitaire")
	private double PrixUnitaire;
	
	@Column(name="Prix_kg")
	private double Prix_kg;
	
	@Column(name="Nutriscore")
	private String Nutriscore;
	
	@Column(name="PoidsPro")
	private double PoidsPro;
	
	@Column(name="conditionnementPro")
	private String conditionnementPro;
	
	@Column(name="urlImage")
	private String urlImage;
	
	//Clé étrangère CodeCate dans Produit
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodeCate")
	private Categorie categorie;
	
	//Clé étrangère CodeRay dans Produit (1 produit est rangé dans 1 rayon)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeRay")
	private Rayon rayon;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodePromo")
	private Promotion promotion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeCommande")
	private Commande commande;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeStock")
	private Stock stock;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeListeCourse")
	private ListeCourse liste_course;
	
	public Produit() {}
	
	public Produit(String lib, double PrixU, double Prixkg, String nutriScore, double Pds, String condition) {
		this.libellePro = lib;
		this.PrixUnitaire = PrixU;
		this.Prix_kg = Prixkg;
		this.Nutriscore = nutriScore;
		this.PoidsPro = Pds;
		this.conditionnementPro = condition; 
	}	
	
	public Produit(int idPro, String urlImage, String lib, double PrixU, double Prixkg, String nutriScore, double Pds, String condition) {
		this.idPro = idPro;
		this.libellePro = lib; 
		this.PrixUnitaire = PrixU; 
		this.Prix_kg = Prixkg; 
		this.Nutriscore = nutriScore; 
		this.PoidsPro = Pds; 
		this.conditionnementPro = condition; 
		this.urlImage = urlImage;
	}

	// Getter et Setter pour idPro
	public int getIdPro() {
	    return idPro;
	}

	public void setIdPro(int idPro) {
	    this.idPro = idPro;
	}

	// Getter et Setter pour libellePro
	public String getLibellePro() {
	    return libellePro;
	}

	public void setLibellePro(String libellePro) {
	    this.libellePro = libellePro;
	}

	// Getter et Setter pour PrixUnitaire
	public double getPrixUnitaire() {
	    return PrixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
	    this.PrixUnitaire = prixUnitaire;
	}

	// Getter et Setter pour Prix_kg
	public double getPrixKg() {
	    return Prix_kg;
	}

	public void setPrixKg(double prixKg) {
	    this.Prix_kg = prixKg;
	}

	// Getter et Setter pour Nutriscore
	public String getNutriscore() {
	    return Nutriscore;
	}

	public void setNutriscore(String nutriscore) {
	    this.Nutriscore = nutriscore;
	}

	// Getter et Setter pour PoidsPro
	public double getPoidsPro() {
	    return PoidsPro;
	}

	public void setPoidsPro(double poidsPro) {
	    this.PoidsPro = poidsPro;
	}

	// Getter et Setter pour conditionnementPro
	public String getConditionnementPro() {
	    return conditionnementPro;
	}

	public void setConditionnementPro(String conditionnementPro) {
	    this.conditionnementPro = conditionnementPro;
	}

	// Getter et Setter pour categorie
	public Categorie getCategorie() {
	    return categorie;
	}

	public void setCategorie(Categorie categorie) {
	    this.categorie = categorie;
	}

	// Getter et Setter pour rayon
	public Rayon getRayon() {
	    return rayon;
	}

	public void setRayon(Rayon rayon) {
	    this.rayon = rayon;
	}

	// Getter et Setter pour promotion
	public Promotion getPromotion() {
	    return promotion;
	}

	public void setPromotion(Promotion promotion) {
	    this.promotion = promotion;
	}

	// Getter et Setter pour commande
	public Commande getCommande() {
	    return commande;
	}

	public void setCommande(Commande commande) {
	    this.commande = commande;
	}

	// Getter et Setter pour stock
	public Stock getStock() {
	    return stock;
	}

	public void setStock(Stock stock) {
	    this.stock = stock;
	}
	
	public String getURLImage() {
		return this.urlImage;
	}
	
	public void setURLImage(String image) {
		this.urlImage = image;
	}

	// Getter et Setter pour liste_course
	public ListeCourse getListeCourse() {
	    return liste_course;
	}

	public void setListeCourse(ListeCourse listeCourse) {
	    this.liste_course = listeCourse;
	}

	// Méthode pour appliquer une promotion à un produit
	public void appliquerPromotion(Promotion promo) {
	    this.promotion = promo;
	}

	// Méthode pour enlever une promotion du produit
	public void enleverPromotion() {
	    this.promotion = null;
	}

	// Méthode pour vérifier si le produit est en promotion
	public boolean estEnPromotion() {
	    return this.promotion != null;
	}

	// Méthode pour obtenir le prix après promotion (exemple avec un pourcentage de réduction)
	public double getPrixApresPromotion() {
	    if (this.promotion != null) {
	        return this.PrixUnitaire * (1 - this.promotion.getValeurPromo() / 100.0);
	    }
	    return this.PrixUnitaire;
	}

	// Méthode pour savoir si un produit est en stock
	public boolean estDisponibleEnStock() {
	    return this.stock != null;
	}

	// Méthode toString pour afficher un produit
	@Override
	public String toString() {
	    return "Produit{" +
	            "id=" + idPro +
	            ", libelle='" + libellePro + '\'' +
	            ", prixUnitaire=" + PrixUnitaire +
	            ", nutriscore='" + Nutriscore + '\'' +
	            ", poids=" + PoidsPro +
	            ", conditionnement='" + conditionnementPro + '\'' +
	            ", categorie=" + (categorie != null ? categorie.getNomCate() : "Aucune") +
	            ", rayon=" + (rayon != null ? rayon.getNomRayon() : "Aucun") +
	            ", en promotion=" + (promotion != null ? "Oui" : "Non") +
	            '}';
	}

}
