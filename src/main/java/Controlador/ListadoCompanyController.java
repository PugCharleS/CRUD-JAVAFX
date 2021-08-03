/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Company;
import Modelo.Peticiones;
import static Modelo.Peticiones.doPostRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author charl
 */
public class ListadoCompanyController implements Initializable {

    PrincipalControlador principal;
    
    @FXML private Button btnLista, btnInicio;
    
    @FXML public TableView<Company> tvLista;
    private ObservableList<Company> data;
    
    private MenuItem miModificar, miEliminar;
    
    private ContextMenu cmOpciones; 
    
    public void PrincipalControlador(PrincipalControlador principal){
        this.principal = principal;
    }
    
    @FXML public void CargarLista(ActionEvent event){
        RefrescarTabla();
    }
    
    @FXML public void CargarInicio(ActionEvent event){
        principal.CargarVista("Inicio");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        Response res = Peticiones.doGetRequest("http://localhost:3000/company");
        ObjectMapper mapper = new ObjectMapper();
            
        try {
            ArrayList<Company> listCompanys  = mapper.readValue(res.asString(), new TypeReference<ArrayList<Company>>(){});
            
            if (listCompanys.size()>0) {
                for (int i = 0; i < listCompanys.size(); i++) {
                    System.out.println(listCompanys.get(i));
                }                             
            }else{
                System.out.println("Error: no hay informacion");
            }             
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }  
        */
        
        cmOpciones = new ContextMenu();
        miEliminar = new MenuItem("Eliminar");
        miModificar = new MenuItem("Modificar");
        cmOpciones.getItems().addAll(miEliminar, miModificar);
        
        
        tvLista.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //nombre de las columnas
        TableColumn<Company, String> colId = new TableColumn<>("ID");
        TableColumn<Company, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Company, String> colDir = new TableColumn<>("Direccion");
        TableColumn<Company, String> colTel = new TableColumn<>("Telefono");
        TableColumn<Company, String> colCeo = new TableColumn<>("CEO");
        
        //relaciona el valor para cada columna       
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));  
        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDir.setCellValueFactory(new PropertyValueFactory<>("addressCompany"));  
        colTel.setCellValueFactory(new PropertyValueFactory<>("phone"));  
        colCeo.setCellValueFactory(new PropertyValueFactory<>("ceoCompany"));  
        
//        Tamano de columnas en tabla predefinidos
        colId.setMaxWidth(45);
        colId.setMinWidth(45);
        colTel.setMaxWidth(150);
        colTel.setMinWidth(150);
        colDir.setMaxWidth(320);
        colDir.setMinWidth(300);
        colNombre.setMaxWidth(215);
        colNombre.setMinWidth(215);
        
        //añade columnas al tableview
        tvLista.getColumns().addAll(colId); 
        tvLista.getColumns().addAll(colNombre);         
        tvLista.getColumns().addAll(colDir);  
        tvLista.getColumns().addAll(colTel); 
        tvLista.getColumns().addAll(colCeo); 
        
        //inicializamos datos
        data = tvLista.getItems();  
        
        tvLista.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.SECONDARY) {
                    cmOpciones.show(tvLista, event.getScreenX(), event.getScreenY());
                }
            }
        });
        
        miEliminar.setOnAction((event) -> {
            if(tvLista.getSelectionModel().getSelectedIndex() >= 0){
                cmOpciones.hide();
                int id = tvLista.getSelectionModel().getSelectedItem().getId();
                Response response = Peticiones.doDeleteRequest("http://localhost:3000/company", id);
                if (response.getStatusCode() >= 200 && response.getStatusCode() <= 299) {
                         JOptionPane.showMessageDialog(null, "Operacion Exitosa " + response.getStatusLine());
                         tvLista.getItems().remove(tvLista.getSelectionModel().getSelectedIndex());
                         tvLista.refresh();
                     } else {
                         System.out.println("Error: no hay respuesta");
                     }
            }
        });
        
        miModificar.setOnAction((event) -> {
            if(tvLista.getSelectionModel().getSelectedIndex() >= 0){
                cmOpciones.hide();
                Company company = tvLista.getSelectionModel().getSelectedItem();
                principal.CargarVista("Insercion");
                principal.controladorInsercion.ModificarCampos(company);
            }
        });
          
    }  
    
    public void RefrescarTabla(){
        Response res = Peticiones.doGetRequest("http://localhost:3000/company");
        tvLista.getItems().removeAll(data);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("\t __^__                          __^__\n" +
                           "\t( ___ )------------------------( ___ )\n" +
                           "\t | / |                          | / |\n" +
                           "\t | / |     Conexion Exitosa!    | / |\n" +
                           "\t |___|                          |___|\n" +
                           "\t(_____)------------------------(_____)");   
        try {
            ArrayList<Company> listCompanys  = mapper.readValue(res.asString(), new TypeReference<ArrayList<Company>>(){});
            
            if (listCompanys.size()>0) {
                for (int i = 0; i < listCompanys.size(); i++) {
//                    listCompanys.get(i).setCeo(listCompanys.get(i).getCeoCompany().toString());
                    data.add(listCompanys.get(i));
//                    System.out.println(data.get(i).getCeoCompany());                      
                }             
            }else{
                System.out.println("Error: no hay informacion");
            }             
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }  
}
