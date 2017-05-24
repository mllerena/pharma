/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "i_bpartner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IBpartner.findAll", query = "SELECT i FROM IBpartner i"),
    @NamedQuery(name = "IBpartner.findByIBpartnerId", query = "SELECT i FROM IBpartner i WHERE i.iBpartnerId = :iBpartnerId"),
    @NamedQuery(name = "IBpartner.findByIsactive", query = "SELECT i FROM IBpartner i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IBpartner.findByCreated", query = "SELECT i FROM IBpartner i WHERE i.created = :created"),
    @NamedQuery(name = "IBpartner.findByCreatedby", query = "SELECT i FROM IBpartner i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IBpartner.findByUpdated", query = "SELECT i FROM IBpartner i WHERE i.updated = :updated"),
    @NamedQuery(name = "IBpartner.findByUpdatedby", query = "SELECT i FROM IBpartner i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IBpartner.findByValue", query = "SELECT i FROM IBpartner i WHERE i.value = :value"),
    @NamedQuery(name = "IBpartner.findByName", query = "SELECT i FROM IBpartner i WHERE i.name = :name"),
    @NamedQuery(name = "IBpartner.findByName2", query = "SELECT i FROM IBpartner i WHERE i.name2 = :name2"),
    @NamedQuery(name = "IBpartner.findByDescription", query = "SELECT i FROM IBpartner i WHERE i.description = :description"),
    @NamedQuery(name = "IBpartner.findByDuns", query = "SELECT i FROM IBpartner i WHERE i.duns = :duns"),
    @NamedQuery(name = "IBpartner.findByTaxid", query = "SELECT i FROM IBpartner i WHERE i.taxid = :taxid"),
    @NamedQuery(name = "IBpartner.findByNaics", query = "SELECT i FROM IBpartner i WHERE i.naics = :naics"),
    @NamedQuery(name = "IBpartner.findByGroupvalue", query = "SELECT i FROM IBpartner i WHERE i.groupvalue = :groupvalue"),
    @NamedQuery(name = "IBpartner.findByAddress1", query = "SELECT i FROM IBpartner i WHERE i.address1 = :address1"),
    @NamedQuery(name = "IBpartner.findByAddress2", query = "SELECT i FROM IBpartner i WHERE i.address2 = :address2"),
    @NamedQuery(name = "IBpartner.findByPostal", query = "SELECT i FROM IBpartner i WHERE i.postal = :postal"),
    @NamedQuery(name = "IBpartner.findByPostalAdd", query = "SELECT i FROM IBpartner i WHERE i.postalAdd = :postalAdd"),
    @NamedQuery(name = "IBpartner.findByCity", query = "SELECT i FROM IBpartner i WHERE i.city = :city"),
    @NamedQuery(name = "IBpartner.findByRegionname", query = "SELECT i FROM IBpartner i WHERE i.regionname = :regionname"),
    @NamedQuery(name = "IBpartner.findByCountrycode", query = "SELECT i FROM IBpartner i WHERE i.countrycode = :countrycode"),
    @NamedQuery(name = "IBpartner.findByTitle", query = "SELECT i FROM IBpartner i WHERE i.title = :title"),
    @NamedQuery(name = "IBpartner.findByContactname", query = "SELECT i FROM IBpartner i WHERE i.contactname = :contactname"),
    @NamedQuery(name = "IBpartner.findByContactdescription", query = "SELECT i FROM IBpartner i WHERE i.contactdescription = :contactdescription"),
    @NamedQuery(name = "IBpartner.findByComments", query = "SELECT i FROM IBpartner i WHERE i.comments = :comments"),
    @NamedQuery(name = "IBpartner.findByPhone", query = "SELECT i FROM IBpartner i WHERE i.phone = :phone"),
    @NamedQuery(name = "IBpartner.findByPhone2", query = "SELECT i FROM IBpartner i WHERE i.phone2 = :phone2"),
    @NamedQuery(name = "IBpartner.findByFax", query = "SELECT i FROM IBpartner i WHERE i.fax = :fax"),
    @NamedQuery(name = "IBpartner.findByEmail", query = "SELECT i FROM IBpartner i WHERE i.email = :email"),
    @NamedQuery(name = "IBpartner.findByPassword", query = "SELECT i FROM IBpartner i WHERE i.password = :password"),
    @NamedQuery(name = "IBpartner.findByBirthday", query = "SELECT i FROM IBpartner i WHERE i.birthday = :birthday"),
    @NamedQuery(name = "IBpartner.findByBpcontactgreeting", query = "SELECT i FROM IBpartner i WHERE i.bpcontactgreeting = :bpcontactgreeting"),
    @NamedQuery(name = "IBpartner.findByProcessing", query = "SELECT i FROM IBpartner i WHERE i.processing = :processing"),
    @NamedQuery(name = "IBpartner.findByProcessed", query = "SELECT i FROM IBpartner i WHERE i.processed = :processed"),
    @NamedQuery(name = "IBpartner.findByIErrormsg", query = "SELECT i FROM IBpartner i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IBpartner.findByIIsimported", query = "SELECT i FROM IBpartner i WHERE i.iIsimported = :iIsimported")})
public class IBpartner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_bpartner_id")
    private String iBpartnerId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 40)
    @Column(name = "value")
    private String value;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 60)
    @Column(name = "name2")
    private String name2;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 11)
    @Column(name = "duns")
    private String duns;
    @Size(max = 20)
    @Column(name = "taxid")
    private String taxid;
    @Size(max = 6)
    @Column(name = "naics")
    private String naics;
    @Size(max = 40)
    @Column(name = "groupvalue")
    private String groupvalue;
    @Size(max = 60)
    @Column(name = "address1")
    private String address1;
    @Size(max = 60)
    @Column(name = "address2")
    private String address2;
    @Size(max = 10)
    @Column(name = "postal")
    private String postal;
    @Size(max = 10)
    @Column(name = "postal_add")
    private String postalAdd;
    @Size(max = 60)
    @Column(name = "city")
    private String city;
    @Size(max = 60)
    @Column(name = "regionname")
    private String regionname;
    @Size(max = 2)
    @Column(name = "countrycode")
    private String countrycode;
    @Size(max = 40)
    @Column(name = "title")
    private String title;
    @Size(max = 60)
    @Column(name = "contactname")
    private String contactname;
    @Size(max = 255)
    @Column(name = "contactdescription")
    private String contactdescription;
    @Size(max = 2000)
    @Column(name = "comments")
    private String comments;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "phone")
    private String phone;
    @Size(max = 40)
    @Column(name = "phone2")
    private String phone2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Size(max = 60)
    @Column(name = "bpcontactgreeting")
    private String bpcontactgreeting;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_bp_group_id", referencedColumnName = "c_bp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpGroup cBpGroupId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;
    @JoinColumn(name = "c_greeting_id", referencedColumnName = "c_greeting_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGreeting cGreetingId;
    @JoinColumn(name = "c_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion cRegionId;

    public IBpartner() {
    }

    public IBpartner(String iBpartnerId) {
        this.iBpartnerId = iBpartnerId;
    }

    public String getIBpartnerId() {
        return iBpartnerId;
    }

    public void setIBpartnerId(String iBpartnerId) {
        this.iBpartnerId = iBpartnerId;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuns() {
        return duns;
    }

    public void setDuns(String duns) {
        this.duns = duns;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    public String getNaics() {
        return naics;
    }

    public void setNaics(String naics) {
        this.naics = naics;
    }

    public String getGroupvalue() {
        return groupvalue;
    }

    public void setGroupvalue(String groupvalue) {
        this.groupvalue = groupvalue;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getPostalAdd() {
        return postalAdd;
    }

    public void setPostalAdd(String postalAdd) {
        this.postalAdd = postalAdd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactdescription() {
        return contactdescription;
    }

    public void setContactdescription(String contactdescription) {
        this.contactdescription = contactdescription;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBpcontactgreeting() {
        return bpcontactgreeting;
    }

    public void setBpcontactgreeting(String bpcontactgreeting) {
        this.bpcontactgreeting = bpcontactgreeting;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public String getIErrormsg() {
        return iErrormsg;
    }

    public void setIErrormsg(String iErrormsg) {
        this.iErrormsg = iErrormsg;
    }

    public Character getIIsimported() {
        return iIsimported;
    }

    public void setIIsimported(Character iIsimported) {
        this.iIsimported = iIsimported;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CBpGroup getCBpGroupId() {
        return cBpGroupId;
    }

    public void setCBpGroupId(CBpGroup cBpGroupId) {
        this.cBpGroupId = cBpGroupId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    public CGreeting getCGreetingId() {
        return cGreetingId;
    }

    public void setCGreetingId(CGreeting cGreetingId) {
        this.cGreetingId = cGreetingId;
    }

    public CRegion getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(CRegion cRegionId) {
        this.cRegionId = cRegionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iBpartnerId != null ? iBpartnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IBpartner)) {
            return false;
        }
        IBpartner other = (IBpartner) object;
        if ((this.iBpartnerId == null && other.iBpartnerId != null) || (this.iBpartnerId != null && !this.iBpartnerId.equals(other.iBpartnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IBpartner[ iBpartnerId=" + iBpartnerId + " ]";
    }
    
}
