package application;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Entreprise {
	private String nomEntreprise ;
	HashMap <Integer,Salarie> liste_Salarie;

	public void entreprise(String nomEntreprise) {
	
		this.nomEntreprise = nomEntreprise;
		liste_Salarie = new HashMap <Integer,Salarie> ();
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	@Override
	public String toString() {
		return "Entreprise [nomEntreprise=" + nomEntreprise + ", liste_Salarie=" + liste_Salarie + "]";
	}
	


	
	
}
