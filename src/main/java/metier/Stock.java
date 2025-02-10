package metier;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private int idStock; 
	
	@Column(name="qteStock")
	private int qteStock; 
	
	@Column(name="dateStock")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateStock;
	
	public Stock() {}
	
	public Stock(int id, int qte, Date date) {
		this.idStock = id; 
		this.qteStock = qte; 
		this.dateStock = date;
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
}
