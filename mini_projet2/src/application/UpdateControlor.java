package application;





import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Service.SalarieService;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import connexion.connexion;

public class UpdateControlor implements Initializable {
 
    
    @FXML
	private TextField mat;
	@FXML
	private TextField nom;
	@FXML
	private TextField mail;
	@FXML
	private TextField Date;
	@FXML
	private TextField Sal;
	@FXML
	private TextField Cat;
	@FXML
	private Button edit;
	private Data Data;
	Connection con = null;
    PreparedStatement ps  =null;
	SalarieService ss = new SalarieService();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	       this.Data=new Data() ;		
	 
		 connexion.getCon();
	}
	public void update() {  
		
	    String req = "update salarie set nom ='"+nom.getText()+"', email ='"+mail.getText()+"',salaire ='"+ Double.parseDouble(Date.getText())+"' , dateEmbauche ='"+Double.parseDouble(Sal.getText())+"',categorie ='"+Cat.getText()+"' where matricule = "+mat.getText();
        try {
			Statement st = connexion.getCon().createStatement();
			 st.executeUpdate(req);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	 
       
  
	}
}