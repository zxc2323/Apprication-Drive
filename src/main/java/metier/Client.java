package metier;

import javax.persistence.*;

@Entity(name="Utilisateur")
public class Client {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="IdUtil")
		private int idUtil; 
		
		@Column(name="prenomUtil")
		private String prenomUtil;
		
		@Column(name="nomUtil")
		private String nomUtil;
		
		@Column(name="adresseUtil")
		private String adresseUtil;
		
		@Column(name="mailUtil")
		private String mailUtil;
		
		@Column(name="motDePasseUtil")
		private String motDePasseUtil; 
		
		public Client() {}
		
		public Client(int id, String prenom, String nom, String adresse, String mail, String mdp) {
			this.idUtil = id; 
			this.prenomUtil = prenom; 
			this.nomUtil = nom; 
			this.adresseUtil = adresse; 
			this.mailUtil = mail; 
			this.motDePasseUtil = mdp;
		}
		
		    // Getter et Setter pour idCli
		    public int getIdUtil() {
		        return idUtil;
		    }

		    public void setIdUtil(int idCli) {
		        this.idUtil= idCli;
		    }

		    // Getter et Setter pour prenomCli
		    public String getPrenomUtil() {
		        return prenomUtil;
		    }

		    public void setPrenomUtil(String prenomCli) {
		        this.prenomUtil = prenomCli;
		    }

		    // Getter et Setter pour nomCli
		    public String getNomUtil() {
		        return nomUtil;
		    }

		    public void setNomUtil(String nomCli) {
		        this.nomUtil = nomCli;
		    }

		    // Getter et Setter pour adresseCli
		    public String getAdresseUtil() {
		        return adresseUtil;
		    }

		    public void setAdresseUtil(String adresseCli) {
		        this.adresseUtil = adresseCli;
		    }

		    // Getter et Setter pour mailCli
		    public String getMailUtil() {
		        return mailUtil;
		    }

		    public void setMailUtil(String mailCli) {
		        this.mailUtil = mailCli;
		    }

		    // Getter et Setter pour motDePasseCli
		    public String getMotDePasseUtil() {
		        return motDePasseUtil;
		    }

		    public void setMotDePasseUtil(String motDePasseCli) {
		        this.motDePasseUtil = motDePasseCli;
		    }		
}
