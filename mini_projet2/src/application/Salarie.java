package application;

public class Salarie {
	 private int mat ; 
	 private String nom ; 
	 private String email ; 
	 private double dateEmbauche ;
	 private double salaire ; 
	 private String categorie;

	public Salarie(int matricule, String nom, String email, double DateEmbauche , double salaire,String Categorie) {
		super();
		mat = matricule;
		this.nom = nom;
		this.email = email;
		this.dateEmbauche = DateEmbauche;
		this.salaire=salaire;
		this.categorie=Categorie;
	}
	 
	public int getMatricule() {
		return mat;
	}
	public void setMatricule(int matricule) {
		mat = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(double DateEmbauche) {
		this.dateEmbauche = DateEmbauche;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public double getSalaire() {
		double s=0;
		if (this.getDateEmbauche()<2005.0) {
			return s=salaire+400;
		}else {
			return s=salaire+280;
		}
	}

	public void setSalaire(double salaire) {
		this.salaire=salaire;
		}


	@Override
	public String toString() {
		return "Salarie [Mat=" + mat + ", Nom=" + nom + ", Email=" + email + ", DateEmbauche=" + dateEmbauche + ", Salaire="
				+ salaire + ", Categorie=" + categorie + "]";
	}



	}