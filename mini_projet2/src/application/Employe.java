package application;

public class Employe extends Salarie {

	private double Hsupp;
	private double PHsupp;


public Employe(int matricule, String nom, String email, double DateEmbauche, double salaire, String Categorie,
			double hsupp, double pHsupp) {
		super(matricule, nom, email, DateEmbauche, salaire, Categorie);
		Hsupp = hsupp;
		PHsupp = pHsupp;
	}

public double getHsupp() {
	return Hsupp;
}

public void setHsupp(double hsupp) {
	Hsupp = hsupp;
}


public double getPHsupp() {
	return PHsupp;
}

public void setPHsupp(double pHsupp) {
	PHsupp = pHsupp;
}
@Override
public String toString() {
	return "Employes [Hsupp=" + Hsupp + ", PHsupp=" + PHsupp + "]";
}

	
	
}
