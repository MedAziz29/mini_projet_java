package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connexion.connexion;


import Dao.IDao;


public class SalarieService implements IDao<Salarie> {

	public boolean delete(Salarie s) {
		try {
            PreparedStatement ps = connexion.getCon().prepareStatement("delete from salarie where matricule=?");
            ps.setInt(1,s.getMatricule());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur delete!");
        }
        return false;
    }

		
	@Override
	public Salarie findByMat(int mat) {
		try {
            String req = "select * from salarie where matricule=" + mat;
            Statement stmt = connexion.getCon().createStatement();
            ResultSet r = stmt.executeQuery(req);
            if (r.next()) {
                return new Salarie(r.getInt("matricule"), r.getString("nom"), r.getString("email"), r.getDouble("dateEmbauche"), r.getDouble("salaire"),r.getString("categorie"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur select!");
        }
        return null;
    }


	 @Override
	    public List<Salarie> findAll() {
	        List<Salarie> salaries = new ArrayList<>();
	        try {
	            String req = "select * from salarie";
	            Statement st = connexion.getCon().createStatement();
	            ResultSet r = st.executeQuery(req);
	            while (r.next()) {
	                salaries.add(new Salarie(r.getInt("matricule"), r.getString("nom"), r.getString("email"), r.getDouble("dateEmbauche"), r.getDouble("salaire"),r.getString("categorie")));
	            }
	 
	        } catch (SQLException ex) {
	            System.out.println("Erreur findAll!");
	        }
	        return salaries;
	    }


	@Override
	public boolean add(Salarie o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Salarie o) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
