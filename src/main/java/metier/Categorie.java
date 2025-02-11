package metier;

import javax.persistence.*;

@Entity(name="Categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCate")
	private int idCate; 
	
	@Column(name="nomCate")
	private String nomCate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CodeRay")
	private Rayon rayon;

	public Categorie() {}
	
	public Categorie(String nom) {
		this.nomCate = nom;
	}

	// Getter et Setter pour idCate
    public int getIdCate() {
        return idCate;
    }

    public void setIdCate(int idCate) {
        this.idCate = idCate;
    }

    // Getter et Setter pour nomCate
    public String getNomCate() {
        return nomCate;
    }

    public void setNomCate(String nomCate) {
        this.nomCate = nomCate;
    }
    
    public Rayon getRayon() {
    	return this.rayon;
    }
    
    public void setRayon(Rayon ray) {
    	this.rayon = ray;
    }
}
