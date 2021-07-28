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
public class Company {
    
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("CEO")
    private CEOCompany ceoCompany;
    @JsonProperty("address")
    private AddressCompany addressCompany;
    
//    private String Ceo;
    
    public Company() {
    }
    
//    public String getCeo() {
//        return Ceo;
//    }
//
//    public void setCeo(String Ceo) {
//        this.Ceo = Ceo;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public AddressCompany getAddressCompany() {
        return addressCompany;
    }

    public void setAddressCompany(AddressCompany addressCompany) {
        this.addressCompany = addressCompany;
    }

    public CEOCompany getCeoCompany() {
        return ceoCompany;
    }

    public void setCeoCompany(CEOCompany ceoCompany) {
        this.ceoCompany = ceoCompany;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", CEOCompany=" + ceoCompany + ", addressCompany=" + addressCompany + '}';
    }  
}
