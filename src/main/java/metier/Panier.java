package metier;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

@Entity(name="Panier")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPanier")
	private int idPanier; 
	
	@OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
	@MapKeyJoinColumn(name = "CodeProd")
	private Map<Produit, Contenir> contenir = new HashMap<>();
	
	public Panier() {}
	
	public int getId() {
		return this.idPanier;
	}
	
	public void setId(int id) {
		this.idPanier = id;
	}
	
	public Map<Produit, Contenir> getContenir(){
		return this.contenir;
	}
	
	public void setContenir(Map<Produit, Contenir> contenir) {
		this.contenir = contenir;
	}
}
