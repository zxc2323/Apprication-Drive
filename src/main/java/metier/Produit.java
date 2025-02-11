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
	
	@ManyToMany
	@JoinTable(name="Contenir", 
	joinColumns=@JoinColumn(name="CodeProd"), 
	inverseJoinColumns=@JoinColumn(name="CodeCommande"))
	private Set<Commande> commandes = new HashSet<>(); 
	
	@ManyToMany
	@JoinTable(name="Englober", 
	joinColumns=@JoinColumn(name="CodeProd"),
	inverseJoinColumns=@JoinColumn(name="CodeListe"))
	private Set<ListeCourse> liste_course = new HashSet<>(); 
	
	@OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
	@MapKeyJoinColumn(name = "CodePanier")
	private Map<Panier, Contenir> contenir = new HashMap<>();
	
	public Produit() {}
	
	public Produit(String lib, double PrixU, double Prixkg, String nutriScore, double Pds, String condition) {
		this.libellePro = lib; 
		this.PrixUnitaire = PrixU; 
		this.Prix_kg = Prixkg; 
		this.Nutriscore = nutriScore; 
		this.PoidsPro = Pds; 
		this.conditionnementPro = condition; 
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

    public void setPrixUnitaire(double PrixUnitaire) {
        this.PrixUnitaire = PrixUnitaire;
    }

    // Getter et Setter pour Prix_kg
    public double getPrix_kg() {
        return Prix_kg;
    }

    public void setPrix_kg(double Prix_kg) {
        this.Prix_kg = Prix_kg;
    }

    // Getter et Setter pour Nutriscore
    public String getNutriscore() {
        return Nutriscore;
    }

    public void setNutriscore(String Nutriscore) {
        this.Nutriscore = Nutriscore;
    }

    // Getter et Setter pour PoidsPro
    public double getPoidsPro() {
        return PoidsPro;
    }

    public void setPoidsPro(double PoidsPro) {
        this.PoidsPro = PoidsPro;
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

    // Getter et Setter pour commandes
    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    // Getter et Setter pour liste_course
    public Set<ListeCourse> getListe_course() {
        return liste_course;
    }

    public void setListe_course(Set<ListeCourse> liste_course) {
        this.liste_course = liste_course;
    }

    // Getter et Setter pour contenir
    public Map<Panier, Contenir> getContenir() {
        return contenir;
    }

    public void setContenir(Map<Panier, Contenir> contenir) {
        this.contenir = contenir;
    }

    // Méthode utilitaire pour ajouter une commande
    public void ajouterCommande(Commande commande) {
        this.commandes.add(commande);
    }

    // Méthode utilitaire pour ajouter une liste de course
    public void ajouterListeCourse(ListeCourse listeCourse) {
        this.liste_course.add(listeCourse);
    }

    // Méthode utilitaire pour ajouter un produit à un panier
    public void ajouterAuPanier(Panier panier, Contenir contenir) {
        this.contenir.put(panier, contenir);
    }
}
