package metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Magasin")
public class Magasin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idMag")
	private int idMag; 
	
	@Column(name="nomMag")
	private String nomMag;
	
	@Column(name="adresseMag")
	private String adresseMag;
	
	public Magasin() {}
	
	public Magasin(String nom, String adr) {
		this.nomMag = nom; 
		this.adresseMag = adr;
	}

	// Getter et Setter pour idMag
    public int getIdMag() {
        return idMag;
    }

    public void setIdMag(int idMag) {
        this.idMag = idMag;
    }

    // Getter et Setter pour nomMag
    public String getNomMag() {
        return nomMag;
    }

    public void setNomMag(String nomMag) {
        this.nomMag = nomMag;
    }

    // Getter et Setter pour adresseMag
    public String getAdresseMag() {
        return adresseMag;
    }

    public void setAdresseMag(String adresseMag) {
        this.adresseMag = adresseMag;
    }	
    
}
