/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author charl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressCompany {

    @JsonProperty("state")
    private String state;
    
    @JsonProperty("city")    
    private String city;
    
    @JsonProperty("street")    
    private String street;
    
    @JsonProperty("zipcode")    
    private String zipcode;
    
    @JsonProperty("number")    
    private int number;

    public AddressCompany() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
//      return "AddressCompany{" + "state=" + state + ", city=" + city + ", street=" + street + ", zipcode=" + zipcode + ", number=" + number + '}';
        return state + ", " + city + ", " + street + ", " + number + "\n C.P.:" + zipcode;
    }   
}
