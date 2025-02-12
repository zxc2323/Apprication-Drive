package metier;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private int idStock; 

    @Column(name="qteStock")
    private int qteStock;

    @Column(name="dateStock")
    @Temporal(TemporalType.DATE)
    private Date dateStock;
    
	@OneToMany(mappedBy="stock")
    private Set<Produit> produits = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="idMagasin", referencedColumnName="idMag")
    private Magasin magasin;
	
	public Stock() {}
	
	public Stock(Set<Produit> produits, Magasin magasin, int qteStock, Date dateStock) {
        this.produits = produits;
        this.magasin = magasin;
        this.qteStock = qteStock;
        this.dateStock = dateStock;
    }

	// Getter et Setter pour idStock
	public int getIdStock() {
	    return idStock;
	}

	public void setIdStock(int idStock) {
	    this.idStock = idStock;
	}

	// Getter et Setter pour qteStock
	public int getQteStock() {
	    return qteStock;
	}

	public void setQteStock(int qteStock) {
	    this.qteStock = qteStock;
	}

	// Getter et Setter pour dateStock
	public Date getDateStock() {
	    return dateStock;
	}

	public void setDateStock(Date dateStock) {
	    this.dateStock = dateStock;
	}

	// Getter et Setter pour produits
	public Set<Produit> getProduits() {
	    return produits;
	}

	public void setProduits(Set<Produit> produits) {
	    this.produits = produits;
	}

	// Méthode pour ajouter un produit au stock
	public void addProduit(Produit produit) {
	    this.produits.add(produit);
	    produit.setStock(this);
	}

	// Méthode pour supprimer un produit du stock
	public void removeProduit(Produit produit) {
	    this.produits.remove(produit);
	    produit.setStock(null);
	}

	// Getter et Setter pour magasin
	public Magasin getMagasin() {
	    return magasin;
	}

	public void setMagasin(Magasin magasin) {
	    this.magasin = magasin;
	}

	// Méthode pour mettre à jour la quantité de stock
	public void updateStock(int quantite) {
	    this.qteStock += quantite;
	}

	// Méthode toString pour afficher les informations du stock
	@Override
	public String toString() {
	    return "Stock{" +
	            "idStock=" + idStock +
	            ", qteStock=" + qteStock +
	            ", dateStock=" + dateStock +
	            ", nombre de produits=" + produits.size() +
	            ", magasin=" + (magasin != null ? magasin.getNomMag() : "Aucun") +
	            '}';
	}

}
