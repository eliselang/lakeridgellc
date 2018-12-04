/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Danny Perez
 */
@Entity
@Table(name = "patient list", catalog = "445", schema = "")
@NamedQueries({
    @NamedQuery(name = "PatientList.findAll", query = "SELECT p FROM PatientList p")
    , @NamedQuery(name = "PatientList.findByPatientID", query = "SELECT p FROM PatientList p WHERE p.patientID = :patientID")
    , @NamedQuery(name = "PatientList.findByFirstName", query = "SELECT p FROM PatientList p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "PatientList.findByLastName", query = "SELECT p FROM PatientList p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "PatientList.findByDateofBirth", query = "SELECT p FROM PatientList p WHERE p.dateofBirth = :dateofBirth")
    , @NamedQuery(name = "PatientList.findByPhoneNumber", query = "SELECT p FROM PatientList p WHERE p.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "PatientList.findBySocialSecurityNumber", query = "SELECT p FROM PatientList p WHERE p.socialSecurityNumber = :socialSecurityNumber")
    , @NamedQuery(name = "PatientList.findByAddress", query = "SELECT p FROM PatientList p WHERE p.address = :address")
    , @NamedQuery(name = "PatientList.findByCity", query = "SELECT p FROM PatientList p WHERE p.city = :city")
    , @NamedQuery(name = "PatientList.findByProvince", query = "SELECT p FROM PatientList p WHERE p.province = :province")
    , @NamedQuery(name = "PatientList.findByHealthInsuranceProvider", query = "SELECT p FROM PatientList p WHERE p.healthInsuranceProvider = :healthInsuranceProvider")
    , @NamedQuery(name = "PatientList.findByHealthInsuranceNumber", query = "SELECT p FROM PatientList p WHERE p.healthInsuranceNumber = :healthInsuranceNumber")
    , @NamedQuery(name = "PatientList.findByComments", query = "SELECT p FROM PatientList p WHERE p.comments = :comments")})
public class PatientList implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Patient ID")
    private Integer patientID;
    @Basic(optional = false)
    @Column(name = "First Name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "Last Name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Date of Birth")
    @Temporal(TemporalType.DATE)
    private Date dateofBirth;
    @Basic(optional = false)
    @Column(name = "Phone Number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "Social Security Number")
    private String socialSecurityNumber;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "Province")
    private String province;
    @Column(name = "Health Insurance Provider")
    private String healthInsuranceProvider;
    @Column(name = "Health Insurance Number")
    private String healthInsuranceNumber;
    @Column(name = "Comments")
    private String comments;

    public PatientList() {
    }

    public PatientList(Integer patientID) {
        this.patientID = patientID;
    }

    public PatientList(Integer patientID, String firstName, String lastName, Date dateofBirth, String phoneNumber, String socialSecurityNumber, String address, String city, String province) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.phoneNumber = phoneNumber;
        this.socialSecurityNumber = socialSecurityNumber;
        this.address = address;
        this.city = city;
        this.province = province;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        Integer oldPatientID = this.patientID;
        this.patientID = patientID;
        changeSupport.firePropertyChange("patientID", oldPatientID, patientID);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        Date oldDateofBirth = this.dateofBirth;
        this.dateofBirth = dateofBirth;
        changeSupport.firePropertyChange("dateofBirth", oldDateofBirth, dateofBirth);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        changeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, phoneNumber);
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        String oldSocialSecurityNumber = this.socialSecurityNumber;
        this.socialSecurityNumber = socialSecurityNumber;
        changeSupport.firePropertyChange("socialSecurityNumber", oldSocialSecurityNumber, socialSecurityNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        changeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        String oldProvince = this.province;
        this.province = province;
        changeSupport.firePropertyChange("province", oldProvince, province);
    }

    public String getHealthInsuranceProvider() {
        return healthInsuranceProvider;
    }

    public void setHealthInsuranceProvider(String healthInsuranceProvider) {
        String oldHealthInsuranceProvider = this.healthInsuranceProvider;
        this.healthInsuranceProvider = healthInsuranceProvider;
        changeSupport.firePropertyChange("healthInsuranceProvider", oldHealthInsuranceProvider, healthInsuranceProvider);
    }

    public String getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(String healthInsuranceNumber) {
        String oldHealthInsuranceNumber = this.healthInsuranceNumber;
        this.healthInsuranceNumber = healthInsuranceNumber;
        changeSupport.firePropertyChange("healthInsuranceNumber", oldHealthInsuranceNumber, healthInsuranceNumber);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        String oldComments = this.comments;
        this.comments = comments;
        changeSupport.firePropertyChange("comments", oldComments, comments);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientID != null ? patientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientList)) {
            return false;
        }
        PatientList other = (PatientList) object;
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capstone.PatientList[ patientID=" + patientID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
