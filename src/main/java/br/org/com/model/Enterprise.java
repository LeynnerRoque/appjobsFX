package br.org.com.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;



@Entity
@Table(name = "enterprise")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Enterprise.findAll", query = "SELECT e FROM Enterprise e")
        , @NamedQuery(name = "Enterprise.findById", query = "SELECT e FROM Enterprise e WHERE e.id = :id")
        , @NamedQuery(name = "Enterprise.findByFoundationName", query = "SELECT e FROM Enterprise e WHERE e.foundationName = :foundationName")
        , @NamedQuery(name = "Enterprise.findByEmail", query = "SELECT e FROM Enterprise e WHERE e.email = :email")
        , @NamedQuery(name = "Enterprise.findByPhoneNumber", query = "SELECT e FROM Enterprise e WHERE e.phoneNumber = :phoneNumber")
        , @NamedQuery(name = "Enterprise.findByIdentify", query = "SELECT e FROM Enterprise e WHERE e.identify = :identify")})
public class Enterprise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "foundation_name")
    private String foundationName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "identify")
    private BigInteger identify;
    @OneToMany(mappedBy = "enterprisesId")
    private List<Job> jobList;

    public Enterprise() {
    }

    public Enterprise(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigInteger getIdentify() {
        return identify;
    }

    public void setIdentify(BigInteger identify) {
        this.identify = identify;
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
        return "br.org.app.model.Enterprises[ id=" + id + " ]";
    }
}
