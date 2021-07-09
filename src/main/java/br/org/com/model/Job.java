package br.org.com.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;


@Entity
@Table(name = "job")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
        , @NamedQuery(name = "Job.findById", query = "SELECT j FROM Job j WHERE j.id = :id")
        , @NamedQuery(name = "Job.findByTitle", query = "SELECT j FROM Job j WHERE j.title = :title")
        , @NamedQuery(name = "Job.findByDescription", query = "SELECT j FROM Job j WHERE j.description = :description")
        , @NamedQuery(name = "Job.findBySalry", query = "SELECT j FROM Job j WHERE j.salry = :salry")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "salry")
    private BigInteger salry;
    @OneToMany(mappedBy = "workId")
    private List<Peoples> peoplesList;
    @JoinColumn(name = "enterprises_id", referencedColumnName = "id")
    @ManyToOne
    private Enterprise enterprisesId;

    public Job() {
    }

    public Job(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigInteger getSalry() {
        return salry;
    }

    public void setSalry(BigInteger salry) {
        this.salry = salry;
    }

    @XmlTransient
    public List<Peoples> getPeoplesList() {
        return peoplesList;
    }

    public void setPeoplesList(List<Peoples> peoplesList) {
        this.peoplesList = peoplesList;
    }

    public Enterprise getEnterprisesId() {
        return enterprisesId;
    }

    public void setEnterprisesId(Enterprise enterprisesId) {
        this.enterprisesId = enterprisesId;
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

