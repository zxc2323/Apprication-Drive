package metier;

import javax.persistence.*;

@Entity(name="Rayon")
public class Rayon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private int idRayon; 
	
	@Column(name="nomRayon")
	private String nomRayon; 
	
	public Rayon() {}
	
	public Rayon(String nom) {
		this.nomRayon = nom;
	}

	// Getter et Setter pour idRayon
    public int getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(int idRayon) {
        this.idRayon = idRayon;
    }

    // Getter et Setter pour nomRayon
    public String getNomRayon() {
        return nomRayon;
    }

    public void setNomRayon(String nomRayon) {
        this.nomRayon = nomRayon;
    }
}
