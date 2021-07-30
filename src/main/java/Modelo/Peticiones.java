/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charl
 */
public class Peticiones {
    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;
        return
            given().
                headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().get(endpoint).
                then().contentType(ContentType.JSON).extract().response();
    } 
    
    public static Response doPostRequest(String requestBody, String uri) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(uri)
                .then()
                .extract().response();
    }    
        
    public static Response doDeleteRequest(String uri, int id) {
        return given()
                .header("Content-type", "application/json")
                .when()
                .delete(uri+"/"+id)
                .then()
                .extract().response();
    }    
    
    public static Response doPutRequest(String requestBody, String uri) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put(uri)
                .then()
                .extract().response();
    }   
}
