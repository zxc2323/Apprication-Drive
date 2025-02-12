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
	    this.id = new ContenirId(panier.getIdPanier(), produit.getIdPro());
	    this.panier = panier;
	    this.produit = produit;
	    this.quantite = quantite;
	}

	
	// Getters et Setters
    public ContenirId getId() {
        return id;
    }

    public void setId(ContenirId id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    // Méthode toString pour afficher les informations
    @Override
    public String toString() {
        return "Contenir{" +
                "id=" + id +
                ", quantite=" + quantite +
                ", panier=" + panier.getIdPanier() +
                ", produit=" + produit.getLibellePro() +
                '}';
    }
}
