package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="ListeCourse")
public class ListeCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idListe")
	private int idListe; 
	
	@Column(name="nomListe")
	private String nomListe;
	
	@ManyToMany(mappedBy="liste_course")
	private Set<Produit> produits = new HashSet<>();
	
	public ListeCourse() {}
	
	public ListeCourse(int id, String nom) {
		this.idListe = id; 
		this.nomListe = nom;
	}
	
	public int getId() {
		return this.idListe;
	}
	
	public void setId(int id) {
		this.idListe = id; 
	}
	
	public String getNom() {
		return this.nomListe; 
	}
	
	public void setNom(String nom) {
		this.nomListe = nom; 
	}
	
	public Set<Produit> getProduits(){
		return this.produits;
	}
	
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
}
