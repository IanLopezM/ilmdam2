/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_uf1_act6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Alumne
 */

@XmlRootElement(name = "row")
class Row {
    
    private String _id;
    private String _uuid;
    private String _position;
    private String _address;
    private String nom;
    private String adre_a;
    private String codi_postal;
    private String municipi;
    private String comarca;
    private String modalitat;

    @XmlAttribute(name="_id")
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

//    @XmlAttribute(name="_uuid")
    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String _uuid) {
        this._uuid = _uuid;
    }

//    @XmlAttribute(name="_position")
    public String getPosition() {
        return _position;
    }

    public void setPosition(String _position) {
        this._position = _position;
    }

//    @XmlAttribute(name="_address")
    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdre_a() {
        return adre_a;
    }

    public void setAdre_a(String adre_a) {
        this.adre_a = adre_a;
    }

    public String getCodi_postal() {
        return codi_postal;
    }

    public void setCodi_postal(String codi_postal) {
        this.codi_postal = codi_postal;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getModalitat() {
        return modalitat;
    }

    public void setModalitat(String modalitat) {
        this.modalitat = modalitat;
    }
    
    
}
