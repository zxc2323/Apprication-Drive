package metier;

import javax.persistence.*;

@Embeddable
public class ContenirId implements java.io.Serializable{

	@Column(name="idProd")
	private int idProd; 
	
	@Column(name="idPanier")
	private int idPanier;
	
	public ContenirId() {}
	
	public ContenirId(int CodeP, int CodePa) {
		this.idProd = CodeP;
		this.idPanier = CodePa; 
	}
	
	// Getter et Setter pour idProd
	public int getIdProd() {
	    return idProd;
	}

	public void setIdProd(int idProd) {
	    this.idProd = idProd;
	}

	// Getter et Setter pour idPanier
	public int getIdPanier() {
	    return idPanier;
	}

	public void setIdPanier(int idPanier) {
	    this.idPanier = idPanier;
	}

	
	// hashCode() et equals() doivent être implémentés pour une clé composite
}
