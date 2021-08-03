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
public class CEOCompany {
    
    @JsonProperty("name") 
    private String name;
    @JsonProperty("phone")     
    private String phone;

    public CEOCompany() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[" + name + ", \nPhone = " + phone + "]";
    } 
}
