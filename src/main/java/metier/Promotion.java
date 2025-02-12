package metier;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPromo")
	private int idPromo; 
	
	@Column(name="typePromo")
	private String typePromo;
	
	@Column(name="valeurPromo")
	private int valeurPromo; 
	
	@Column(name="date_deb")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date_deb;
	
	@Column(name="date_fin")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date_fin;
	
	@OneToMany(mappedBy="promotion")
	private Set<Produit> produits = new HashSet<>();
	
	public Promotion() {}
	
	public Promotion(String type, int valeur, Date datedeb, Date datefin) {
		this.typePromo = type; 
		this.valeurPromo = valeur; 
		this.date_deb = datedeb; 
		this.date_fin = datefin;
	}

 // Getter et Setter pour idPromo
    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    // Getter et Setter pour typePromo
    public String getTypePromo() {
        return typePromo;
    }

    public void setTypePromo(String typePromo) {
        this.typePromo = typePromo;
    }

    // Getter et Setter pour valeurPromo
    public int getValeurPromo() {
        return valeurPromo;
    }

    public void setValeurPromo(int valeurPromo) {
        this.valeurPromo = valeurPromo;
    }

    // Getter et Setter pour date_deb
    public Date getDateDeb() {
        return date_deb;
    }

    public void setDateDeb(Date dateDeb) {
        this.date_deb = dateDeb;
    }

    // Getter et Setter pour date_fin
    public Date getDateFin() {
        return date_fin;
    }

    public void setDateFin(Date dateFin) {
        this.date_fin = dateFin;
    }

    // Getter et Setter pour produits
    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    // Méthode pour ajouter un produit à la promotion
    public void addProduit(Produit produit) {
        this.produits.add(produit);
        produit.setPromotion(this);
    }

    // Méthode pour supprimer un produit de la promotion
    public void removeProduit(Produit produit) {
        this.produits.remove(produit);
        produit.setPromotion(null);
    }

    // Méthode pour vérifier si une promotion est toujours valide
    public boolean estToujoursValide() {
        Date today = new Date();
        return (today.after(date_deb) || today.equals(date_deb)) && today.before(date_fin);
    }

    // Méthode pour afficher les détails de la promotion
    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + idPromo +
                ", type='" + typePromo + '\'' +
                ", valeur=" + valeurPromo +
                ", date_deb=" + date_deb +
                ", date_fin=" + date_fin +
                ", nombre de produits affectés=" + produits.size() +
                '}';
    }

}
