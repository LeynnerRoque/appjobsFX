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
@Table(name = "job")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
        , @NamedQuery(name = "Job.findById", query = "SELECT j FROM Job j WHERE j.id = :id")
        , @NamedQuery(name = "Job.findByTitle", query = "SELECT j FROM Job j WHERE j.title = :title")
        , @NamedQuery(name = "Job.findByDescription", query = "SELECT j FROM Job j WHERE j.description = :description")
        , @NamedQuery(name = "Job.findBySalary", query = "SELECT j FROM Job j WHERE j.salary = :salary")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private Double salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId")
    private List<Peoples> peoplesList;
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Enterprise enterpriseId;

    public Job() {
    }

    public Job(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @XmlTransient
    public List<Peoples> getPeoplesList() {
        return peoplesList;
    }

    public void setPeoplesList(List<Peoples> peoplesList) {
        this.peoplesList = peoplesList;
    }

    public Enterprise getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Enterprise enterpriseId) {
        this.enterpriseId = enterpriseId;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.app.models.Job[ id=" + id + " ]";
    }

}
