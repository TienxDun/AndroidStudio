package com.example.lab01.model;

import java.io.Serializable;

public class Contact implements Serializable {
    String MaContact;
    String TenContact;
    String SDTContact;

    public Contact() {
    }
    public Contact(String maContact, String tenContact, String sDTContact) {
        MaContact = maContact;
        TenContact = tenContact;
        SDTContact = sDTContact;
    }

    public String getMaContact() {
        return MaContact;
    }

    public void setMaContact(String maContact) {
        MaContact = maContact;
    }

    public String getTenContact() {
        return TenContact;
    }

    public void setTenContact(String tenContact) {
        TenContact = tenContact;
    }

    public String getSDTContact() {
        return SDTContact;
    }

    public void setSDTContact(String SDTContact) {
        this.SDTContact = SDTContact;
    }

    public String toString(){
        return getMaContact() + "\t" + getTenContact() + "\t" + getSDTContact();
    }
}
