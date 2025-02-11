package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCommande")
	private int idCommande; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="etatCommande", nullable = false)
	private Etat etatCommande;
	
	@ManyToMany(mappedBy="commandes")
	private Set<Produit> produits = new HashSet<>();
	
	public Commande() {}
	
	public Commande(Etat etat) {
		this.etatCommande = etat;
	}
	
	// Getter et Setter pour idCommande
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    // Getter et Setter pour etatCommande
    public Etat getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(Etat etatCommande) {
        this.etatCommande = etatCommande;
    }
    
    public Set<Produit> getProduits(){
    	return this.produits;
    }
    
    public void setProduits(Set<Produit> produits) {
    	this.produits = produits;
    }
}
