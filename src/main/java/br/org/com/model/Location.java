/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.com.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author leynnerroque
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
        , @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id")
        , @NamedQuery(name = "Location.findByStreetAddress", query = "SELECT l FROM Location l WHERE l.streetAddress = :streetAddress")
        , @NamedQuery(name = "Location.findByPostalCode", query = "SELECT l FROM Location l WHERE l.postalCode = :postalCode")
        , @NamedQuery(name = "Location.findByCity", query = "SELECT l FROM Location l WHERE l.city = :city")
        , @NamedQuery(name = "Location.findByStateProvince", query = "SELECT l FROM Location l WHERE l.stateProvince = :stateProvince")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "state_province")
    private String stateProvince;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private List<Peoples> peoplesList;

    public Location() {
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @XmlTransient
    public List<Peoples> getPeoplesList() {
        return peoplesList;
    }

    public void setPeoplesList(List<Peoples> peoplesList) {
        this.peoplesList = peoplesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.app.models.Location[ id=" + id + " ]";
    }

}
