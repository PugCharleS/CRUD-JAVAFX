/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.democrud;

import Modelo.CEOCompany;
import Modelo.Company;
import Modelo.Peticiones;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author charl
 */
public class PrincipalControlador implements Initializable{
    
    @FXML private Button btnLista;
    
    @FXML private TableView<Company> tvLista;
    private ObservableList<Company> data;
    
    @FXML public void CargarLista(ActionEvent event){
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
        
        //añade columnas al tableview
        tvLista.getColumns().addAll(colId); 
        tvLista.getColumns().addAll(colNombre);         
        tvLista.getColumns().addAll(colDir);  
        tvLista.getColumns().addAll(colTel); 
        tvLista.getColumns().addAll(colCeo); 
        
        //inicializamos datos
        data = tvLista.getItems();  
    }
    
}
