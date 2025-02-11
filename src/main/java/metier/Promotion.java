package metier;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPromo")
	private int idPromo; 
	
	@Column(name="typePromo")
	private String typePromo;
	
	@Column(name="valeurPromo")
	private int valeurPromo; 
	
	@Column(name="date_deb")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date_deb;
	
	@Column(name="date_fin")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date date_fin;
	
	public Promotion() {}
	
	public Promotion(String type, int valeur, Date datedeb, Date datefin) {
		this.typePromo = type; 
		this.valeurPromo = valeur; 
		this.date_deb = datedeb; 
		this.date_fin = datefin;
	}
	
	// Getter et Setter pour idPromo
    public int getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    // Getter et Setter pour typePromo
    public String getTypePromo() {
        return typePromo;
    }

    public void setTypePromo(String typePromo) {
        this.typePromo = typePromo;
    }

    // Getter et Setter pour valeurPromo
    public int getValeurPromo() {
        return valeurPromo;
    }

    public void setValeurPromo(int valeurPromo) {
        this.valeurPromo = valeurPromo;
    }

    // Getter et Setter pour date_deb
    public Date getDateDeb() {
        return date_deb;
    }

    public void setDateDeb(Date date_deb) {
        this.date_deb = date_deb;
    }

    // Getter et Setter pour date_fin
    public Date getDateFin() {
        return date_fin;
    }

    public void setDateFin(Date date_fin) {
        this.date_fin = date_fin;
    }
}
