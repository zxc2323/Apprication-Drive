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
	
	public int getIdProd() {
		return this.idProd;
	}
	
	public void setIdProd(int code) {
		this.idProd = code; 
	}
	
	public int getIdPanier() {
		return this.idPanier;
	}
	
	public void setIdPanier(int code) {
		this.idPanier = code; 
	}
	
	// hashCode() et equals() doivent être implémentés pour une clé composite
}
