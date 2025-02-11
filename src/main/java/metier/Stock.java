package metier;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private int idStock; 
	
	@ManyToOne
    @JoinColumn(name="idProduit", referencedColumnName="idPro")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name="idMagasin", referencedColumnName="idMag")
    private Magasin magasin;

    @Column(name="qteStock")
    private int qteStock;

    @Column(name="dateStock")
    @Temporal(TemporalType.DATE)
    private Date dateStock;
	
	public Stock() {}
	
	public Stock(Produit produit, Magasin magasin, int qteStock, Date dateStock) {
        this.produit = produit;
        this.magasin = magasin;
        this.qteStock = qteStock;
        this.dateStock = dateStock;
    }

    // Getters et setters
    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public Date getDateStock() {
        return dateStock;
    }

    public void setDateStock(Date dateStock) {
        this.dateStock = dateStock;
    }
}
