package metier;

import javax.persistence.*;

@Entity(name="Contenir")
public class Contenir {

	@EmbeddedId
	private ContenirId id;
	
	@Column(name="quantite")
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name = "CodePanier", insertable = false, updatable = false)
	private Panier panier;
	
	@ManyToOne
	@JoinColumn(name = "CodeProd", insertable = false, updatable = false)
	private Produit produit;
	
	public Contenir() {}
	
	public Contenir(Panier panier, Produit produit, int quantite) {
	    this.id = new ContenirId(panier.getId(), produit.getIdPro());
	    this.panier = panier;
	    this.produit = produit;
	    this.quantite = quantite;
	}

	
	// Getter et Setter pour id
    public ContenirId getId() {
        return id;
    }

    public void setId(ContenirId id) {
        this.id = id;
    }

    // Getter et Setter pour quantite
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Getter et Setter pour panier
    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    // Getter et Setter pour produit
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
