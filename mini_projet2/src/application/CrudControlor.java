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
public class CrudControlor implements Initializable {
    @FXML
	private Button delete;
	@FXML
	private Button add;
	@FXML
	private Button edit;
	@FXML
	private Button importBt;
	@FXML
	private Button ExportBt;
    @FXML
    private TableView <Salarie> table;
    @FXML
    private TableColumn<Salarie,Integer> matCol;
    @FXML
    private TableColumn<Salarie,String> nomCol;
    @FXML
    private TableColumn <Salarie,String> emailCol;
    @FXML
    private TableColumn<Salarie,Double> dateEmbCol;
    @FXML
    private TableColumn <Salarie,Double> SalCol;
  
    @FXML
    private TableColumn <Salarie,String> Categorie;
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
	
	private Data Data;
	Connection con = null;
    PreparedStatement ps  =null;
	SalarieService ss = new SalarieService();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	       this.Data=new Data() ;		
	       matCol.setCellValueFactory(new PropertyValueFactory<Salarie,Integer>("matricule"));
	       nomCol.setCellValueFactory(new PropertyValueFactory<Salarie,String>("nom"));
	       emailCol.setCellValueFactory(new PropertyValueFactory<Salarie,String>("email"));
	       dateEmbCol.setCellValueFactory(new PropertyValueFactory<Salarie,Double>("DateEmbauche"));
	       SalCol.setCellValueFactory(new PropertyValueFactory<Salarie,Double>("salaire"));
	       Categorie.setCellValueFactory(new PropertyValueFactory<Salarie,String>("categorie"));
		 connexion.getCon();
	}

	@FXML
	protected void Ajouter()
	{ 
	            String r = "insert into salarie values ('" +Integer.parseInt(mat.getText()) + "', '" + nom.getText()+ "', '" + mail.getText() + "', '" + Double.parseDouble(Date.getText())+  "', '" + Double.parseDouble(Sal.getText())+  "', '" + Cat.getText()+"')";

	            Statement st;
				try {
					st = connexion.getCon().createStatement();
					 st.executeUpdate(r);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				 Salarie s = new Salarie (Integer.parseInt(mat.getText()),nom.getText(),mail.getText(),Double.parseDouble(Sal.getText()),Double.parseDouble(Date.getText()),Cat.getText());
			   		Data.getImportList().add(s);
			   		table.getItems().add(s);
	}
	
	@FXML
	protected void Supprimer()
{ 
		Salarie s = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(s);
	        ss.delete(ss.findByMat(s.getMatricule()));
}
	
	@FXML
	protected void ImportSalarie()
	{ 
		   table.getItems().clear();	  
	 table.getItems().addAll(Data.getImportList());

	}

	
	public void select() {
	
	    Salarie s = table.getSelectionModel().getSelectedItem();
        mat.setText(String.valueOf(s.getMatricule()));
        nom.setText(s.getNom());
        mail.setText(s.getEmail());
        Date.setText(String.valueOf(s.getSalaire()));
        Sal.setText(String.valueOf(s.getDateEmbauche()));
        Cat.setText(s.getCategorie());
        table.getItems().remove(s);
	}

	@FXML
	protected void ExportSalarie()
	{ 
	 table.getItems().addAll(Data.getExportList());
	 FileWriter writer = null;
	try {
		writer = new FileWriter("Liste.txt");
	} catch (IOException e1) {
		e1.printStackTrace();
	} 
	 for(Salarie s: Data.getImportList()) {
	   try {
		writer.write(s + System.lineSeparator());
	} catch (IOException e) {
		e.printStackTrace();
	}
	 }
	 try {
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

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


	public void update1(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		Parent root =FXMLLoader.load(getClass().getResource("/application/update.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
