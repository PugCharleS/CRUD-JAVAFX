 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CEOCompany;
import Modelo.Company;
import Modelo.Peticiones;
import com.company.democrud.App;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author charl
 */
public class PrincipalControlador implements Initializable{

    @FXML private Button btnMenuLista, btnMenuInsercion;
    @FXML private StackPane spContenedor;
    @FXML private VBox vbUno, vbDos;
    private VBox vbListado, vbInsercion;
    ListadoCompanyController controladorListado;
    InsercionCompanyController controladorInsercion;
    
    @FXML public void EventosMenu(ActionEvent event) throws IOException{
        Object evt = event.getSource();
        
        if (evt.equals(btnMenuLista)) {        
            CargarVista("Listado");
        } else if(evt.equals(btnMenuInsercion)) {
            CargarVista("Insercion");
        }
    }
    
    public FXMLLoader CargarInterfaz(String url) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(url));
        return fxmlLoader;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        spContenedor.setVisible(false);
        spContenedor.setManaged(false);
        
        try {
            FXMLLoader loader = CargarInterfaz("/fxml/ListadoCompany.fxml");
            vbListado = (VBox)loader.load();
            controladorListado = loader.getController();
            controladorListado.PrincipalControlador(this);
            vbListado.setVisible(false);
                 
            FXMLLoader loader1 = CargarInterfaz("/fxml/InsercionCompany.fxml");
            vbInsercion = (VBox)loader1.load();
            controladorInsercion = loader1.getController();
            controladorInsercion.PrincipalControlador(this);
            vbInsercion.setVisible(false);
            
            spContenedor.getChildren().addAll(vbListado, vbInsercion);
                       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void CargarVista(String vista){
        switch(vista){
                case "Inicio":
                    vbUno.setVisible(true);
                    vbDos.setVisible(true);
                    vbListado.setVisible(false);
                    vbInsercion.setVisible(false);
                    spContenedor.setVisible(false);
                    spContenedor.setManaged(false);
                    break;
                case "Listado":
                    vbUno.setVisible(false);
                    vbDos.setVisible(false);
                    vbListado.setVisible(true);
                    vbInsercion.setVisible(false);
                    spContenedor.setVisible(true);
                    spContenedor.setManaged(true);
                    break;
                case "Insercion":
                    vbUno.setVisible(false);
                    vbDos.setVisible(false);
                    vbListado.setVisible(false);
                    vbInsercion.setVisible(true);
                    spContenedor.setVisible(true);
                    spContenedor.setManaged(true);
                    break;
        }
    }
    
    
}
