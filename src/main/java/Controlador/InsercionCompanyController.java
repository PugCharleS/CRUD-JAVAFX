/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AddressCompany;
import Modelo.CEOCompany;
import Modelo.Company;
import Modelo.Peticiones;
import static Modelo.Peticiones.doPostRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author charl
 */
public class InsercionCompanyController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtCalle;
    @FXML
    private TextField txtCP;
    @FXML
    private TextField txtNum;
    @FXML
    private TextField txtNombreCeo;
    @FXML
    private TextField txtTelCeo;
    @FXML
    private Button btnCargar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnInicio;
    
    PrincipalControlador principal;
    int id;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void PrincipalControlador(PrincipalControlador principal){
        this.principal = principal;
    }

    @FXML
    private void EventosInsercion(ActionEvent event) {
        Object evt = event.getSource();
        
        if (evt.equals(btnCargar)) {
            if (!txtNombre.getText().isEmpty() && !txtTel.getText().isEmpty() && !txtEstado.getText().isEmpty() && !txtCiudad.getText().isEmpty() && !txtCalle.getText().isEmpty() && !txtCP.getText().isEmpty() && !txtNum.getText().isEmpty() && !txtNombreCeo.getText().isEmpty() && !txtTelCeo.getText().isEmpty()) {
                Company company = new Company();
                company.setName(txtNombre.getText());
                company.setPhone(txtTel.getText());

                AddressCompany address = new AddressCompany();
                address.setCity(txtCiudad.getText());
                address.setState(txtEstado.getText());
                address.setNumber(Integer.parseInt(txtNum.getText()));
                address.setStreet(txtCalle.getText());
                address.setZipcode(txtCP.getText());

                CEOCompany ceo = new CEOCompany();
                ceo.setName(txtNombreCeo.getText());
                ceo.setPhone(txtTelCeo.getText());

                company.setAddressCompany(address);
                company.setCeoCompany(ceo);

//                Aqui construyo mi mapper
                 ObjectMapper mapper = new ObjectMapper();
//                 Este es el string que llamo json para poder usarlo para mi payload
                 String json;
//                 Esta es la respueta
                 Response response;
                 try {
                     if(btnCargar.getText().equals("MODIFICAR")){
                        company.setId(id);
                        json = mapper.writeValueAsString(company);
                        response = Peticiones.doPutRequest(json, "http://localhost:3000/company/"+id);
                        System.out.println("MODIFICAR");
                     } else{
//                       Aqui mapeo mi string de los valores que traigo de company
                        json = mapper.writeValueAsString(company);
//                        Aqui mando mi payload hacia ese metodo que esta en peticiones.java, le pones el string que mandas como primer parametro y el segundo es tu API
                        response = doPostRequest(json, "http://localhost:3000/company");
//                        Esto solo es un mensaje para mi de decoracions
                        System.out.println("CARGAR");
                     }
//                     Todo esto es mera decoracion
                     if (response.getStatusCode() >= 200 && response.getStatusCode() <= 299) {
                         JOptionPane.showMessageDialog(null, "Operacion Exitosa " + response.getStatusLine());
                         LimpiarCampos();
                         principal.controladorListado.RefrescarTabla();
                     } else {
                         System.out.println("Error: no hay respuesta");
                     }
                 } catch (JsonProcessingException ex) {
                     Logger.getLogger(Peticiones.class.getName()).log(Level.SEVERE, null, ex);
                 }       
            } else {
                JOptionPane.showMessageDialog(null, "Los campos no están completos");
            }
        } else if (evt.equals(btnLimpiar)){
            LimpiarCampos();
        } else if (evt.equals(btnInicio)){
            principal.CargarVista("Inicio");
        }
    }   
    
    public void ModificarCampos(Company company){
        id = company.getId();
        
        txtNombre.setText(company.getName());
        txtTel.setText(company.getPhone());
        txtCiudad.setText(company.getAddressCompany().getCity());
        txtEstado.setText(company.getAddressCompany().getState());
        txtNum.setText(String.valueOf(company.getAddressCompany().getNumber()));
        txtCalle.setText(company.getAddressCompany().getStreet());
        txtCP.setText(company.getAddressCompany().getZipcode());
        txtNombreCeo.setText(company.getCeoCompany().getName());
        txtTelCeo.setText(company.getCeoCompany().getPhone());
        
        btnCargar.setText("MODIFICAR");
    }
    
    public void LimpiarCampos(){
        txtNombre.setText("");
        txtTel.setText("");
        txtCiudad.setText("");
        txtEstado.setText("");
        txtNum.setText("");
        txtCalle.setText("");
        txtCP.setText("");
        txtNombreCeo.setText("");
        txtTelCeo.setText("");
        btnCargar.setText("GUARDAR");
        id = -1;
    }
    
}
