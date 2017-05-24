/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "c_greeting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CGreeting.findAll", query = "SELECT c FROM CGreeting c"),
    @NamedQuery(name = "CGreeting.findByCGreetingId", query = "SELECT c FROM CGreeting c WHERE c.cGreetingId = :cGreetingId"),
    @NamedQuery(name = "CGreeting.findByIsactive", query = "SELECT c FROM CGreeting c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CGreeting.findByCreated", query = "SELECT c FROM CGreeting c WHERE c.created = :created"),
    @NamedQuery(name = "CGreeting.findByCreatedby", query = "SELECT c FROM CGreeting c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CGreeting.findByUpdated", query = "SELECT c FROM CGreeting c WHERE c.updated = :updated"),
    @NamedQuery(name = "CGreeting.findByUpdatedby", query = "SELECT c FROM CGreeting c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CGreeting.findByName", query = "SELECT c FROM CGreeting c WHERE c.name = :name"),
    @NamedQuery(name = "CGreeting.findByGreeting", query = "SELECT c FROM CGreeting c WHERE c.greeting = :greeting"),
    @NamedQuery(name = "CGreeting.findByIsfirstnameonly", query = "SELECT c FROM CGreeting c WHERE c.isfirstnameonly = :isfirstnameonly"),
    @NamedQuery(name = "CGreeting.findByIsdefault", query = "SELECT c FROM CGreeting c WHERE c.isdefault = :isdefault")})
public class CGreeting extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_greeting_id")
    private String cGreetingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class)
    private YesNo isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 60)
    @Column(name = "greeting")
    private String greeting;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isfirstnameonly")
    private Character isfirstnameonly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGreetingId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cGreetingId")
    private List<CGreetingTrl> cGreetingTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGreetingId")
    private List<AdUser> adUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGreetingId")
    private List<IBpartner> iBpartnerList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public CGreeting() {
    }

    public CGreeting(String cGreetingId) {
        this.cGreetingId = cGreetingId;
    }

    public String getCGreetingId() {
        return cGreetingId;
    }

    public void setCGreetingId(String cGreetingId) {
        this.cGreetingId = cGreetingId;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Character getIsfirstnameonly() {
        return isfirstnameonly;
    }

    public void setIsfirstnameonly(Character isfirstnameonly) {
        this.isfirstnameonly = isfirstnameonly;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<CGreetingTrl> getCGreetingTrlList() {
        return cGreetingTrlList;
    }

    public void setCGreetingTrlList(List<CGreetingTrl> cGreetingTrlList) {
        this.cGreetingTrlList = cGreetingTrlList;
    }

    @XmlTransient
    public List<AdUser> getAdUserList() {
        return adUserList;
    }

    public void setAdUserList(List<AdUser> adUserList) {
        this.adUserList = adUserList;
    }

    @XmlTransient
    public List<IBpartner> getIBpartnerList() {
        return iBpartnerList;
    }

    public void setIBpartnerList(List<IBpartner> iBpartnerList) {
        this.iBpartnerList = iBpartnerList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cGreetingId != null ? cGreetingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CGreeting)) {
            return false;
        }
        CGreeting other = (CGreeting) object;
        if ((this.cGreetingId == null && other.cGreetingId != null) || (this.cGreetingId != null && !this.cGreetingId.equals(other.cGreetingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CGreeting[ cGreetingId=" + cGreetingId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return cGreetingId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		cGreetingId = id;
	}
    
}
