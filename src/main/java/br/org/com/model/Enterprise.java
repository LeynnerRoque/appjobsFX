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
@Table(name = "enterprise")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Enterprise.findAll", query = "SELECT e FROM Enterprise e")
        , @NamedQuery(name = "Enterprise.findById", query = "SELECT e FROM Enterprise e WHERE e.id = :id")
        , @NamedQuery(name = "Enterprise.findByFoundationName", query = "SELECT e FROM Enterprise e WHERE e.foundationName = :foundationName")
        , @NamedQuery(name = "Enterprise.findByEmail", query = "SELECT e FROM Enterprise e WHERE e.email = :email")
        , @NamedQuery(name = "Enterprise.findByPhoneNumber", query = "SELECT e FROM Enterprise e WHERE e.phoneNumber = :phoneNumber")})
public class Enterprise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "foundation_name")
    private String foundationName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enterpriseId")
    private List<Job> jobList;

    public Enterprise() {
    }

    public Enterprise(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoundationName() {
        return foundationName;
    }

    public void setFoundationName(String foundationName) {
        this.foundationName = foundationName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlTransient
    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
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
        if (!(object instanceof Enterprise)) {
            return false;
        }
        Enterprise other = (Enterprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.app.models.Enterprise[ id=" + id + " ]";
    }

}
