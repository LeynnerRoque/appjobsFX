package br.org.com.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author leynnerroque
 */
@Entity
@Table(name = "peoples")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Peoples.findAll", query = "SELECT p FROM Peoples p")
        , @NamedQuery(name = "Peoples.findById", query = "SELECT p FROM Peoples p WHERE p.id = :id")
        , @NamedQuery(name = "Peoples.findByName", query = "SELECT p FROM Peoples p WHERE p.name = :name")
        , @NamedQuery(name = "Peoples.findByGender", query = "SELECT p FROM Peoples p WHERE p.gender = :gender")
        , @NamedQuery(name = "Peoples.findByAge", query = "SELECT p FROM Peoples p WHERE p.age = :age")
        , @NamedQuery(name = "Peoples.findByIdentify", query = "SELECT p FROM Peoples p WHERE p.identify = :identify")
        , @NamedQuery(name = "Peoples.findByRegionName", query = "SELECT p FROM Peoples p WHERE p.regionName = :regionName")
        , @NamedQuery(name = "Peoples.findByEmail", query = "SELECT p FROM Peoples p WHERE p.email = :email")
        , @NamedQuery(name = "Peoples.findByPhone", query = "SELECT p FROM Peoples p WHERE p.phone = :phone")})
public class Peoples implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "identify")
    private BigInteger identify;
    @Column(name = "region_name")
    private String regionName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @JoinColumn(name = "work_id", referencedColumnName = "id")
    @ManyToOne
    private Job workId;
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ManyToOne
    private Location regionId;

    public Peoples() {
    }

    public Peoples(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigInteger getIdentify() {
        return identify;
    }

    public void setIdentify(BigInteger identify) {
        this.identify = identify;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Job getWorkId() {
        return workId;
    }

    public void setWorkId(Job workId) {
        this.workId = workId;
    }

    public Location getRegionId() {
        return regionId;
    }

    public void setRegionId(Location regionId) {
        this.regionId = regionId;
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
        if (!(object instanceof Peoples)) {
            return false;
        }
        Peoples other = (Peoples) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.app.models.Peoples[ id=" + id + " ]";
    }

}

