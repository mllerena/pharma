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
@Table(name = "c_poc_configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPocConfiguration.findAll", query = "SELECT c FROM CPocConfiguration c"),
    @NamedQuery(name = "CPocConfiguration.findByCPocConfigurationId", query = "SELECT c FROM CPocConfiguration c WHERE c.cPocConfigurationId = :cPocConfigurationId"),
    @NamedQuery(name = "CPocConfiguration.findByIsactive", query = "SELECT c FROM CPocConfiguration c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPocConfiguration.findByCreated", query = "SELECT c FROM CPocConfiguration c WHERE c.created = :created"),
    @NamedQuery(name = "CPocConfiguration.findByCreatedby", query = "SELECT c FROM CPocConfiguration c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPocConfiguration.findByUpdated", query = "SELECT c FROM CPocConfiguration c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPocConfiguration.findByUpdatedby", query = "SELECT c FROM CPocConfiguration c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPocConfiguration.findBySmtpserver", query = "SELECT c FROM CPocConfiguration c WHERE c.smtpserver = :smtpserver"),
    @NamedQuery(name = "CPocConfiguration.findBySmtpserveraccount", query = "SELECT c FROM CPocConfiguration c WHERE c.smtpserveraccount = :smtpserveraccount"),
    @NamedQuery(name = "CPocConfiguration.findBySmtpserverpassword", query = "SELECT c FROM CPocConfiguration c WHERE c.smtpserverpassword = :smtpserverpassword"),
    @NamedQuery(name = "CPocConfiguration.findByIssmtpauthorization", query = "SELECT c FROM CPocConfiguration c WHERE c.issmtpauthorization = :issmtpauthorization"),
    @NamedQuery(name = "CPocConfiguration.findBySmtpserversenderaddress", query = "SELECT c FROM CPocConfiguration c WHERE c.smtpserversenderaddress = :smtpserversenderaddress")})
public class CPocConfiguration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_poc_configuration_id")
    private String cPocConfigurationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
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
    @Size(max = 200)
    @Column(name = "smtpserver")
    private String smtpserver;
    @Size(max = 50)
    @Column(name = "smtpserveraccount")
    private String smtpserveraccount;
    @Size(max = 60)
    @Column(name = "smtpserverpassword")
    private String smtpserverpassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issmtpauthorization")
    private Character issmtpauthorization;
    @Size(max = 50)
    @Column(name = "smtpserversenderaddress")
    private String smtpserversenderaddress;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public CPocConfiguration() {
    }

    public CPocConfiguration(String cPocConfigurationId) {
        this.cPocConfigurationId = cPocConfigurationId;
    }

    public CPocConfiguration(String cPocConfigurationId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character issmtpauthorization) {
        this.cPocConfigurationId = cPocConfigurationId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.issmtpauthorization = issmtpauthorization;
    }

    public String getCPocConfigurationId() {
        return cPocConfigurationId;
    }

    public void setCPocConfigurationId(String cPocConfigurationId) {
        this.cPocConfigurationId = cPocConfigurationId;
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

    public String getSmtpserver() {
        return smtpserver;
    }

    public void setSmtpserver(String smtpserver) {
        this.smtpserver = smtpserver;
    }

    public String getSmtpserveraccount() {
        return smtpserveraccount;
    }

    public void setSmtpserveraccount(String smtpserveraccount) {
        this.smtpserveraccount = smtpserveraccount;
    }

    public String getSmtpserverpassword() {
        return smtpserverpassword;
    }

    public void setSmtpserverpassword(String smtpserverpassword) {
        this.smtpserverpassword = smtpserverpassword;
    }

    public Character getIssmtpauthorization() {
        return issmtpauthorization;
    }

    public void setIssmtpauthorization(Character issmtpauthorization) {
        this.issmtpauthorization = issmtpauthorization;
    }

    public String getSmtpserversenderaddress() {
        return smtpserversenderaddress;
    }

    public void setSmtpserversenderaddress(String smtpserversenderaddress) {
        this.smtpserversenderaddress = smtpserversenderaddress;
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
        hash += (cPocConfigurationId != null ? cPocConfigurationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPocConfiguration)) {
            return false;
        }
        CPocConfiguration other = (CPocConfiguration) object;
        if ((this.cPocConfigurationId == null && other.cPocConfigurationId != null) || (this.cPocConfigurationId != null && !this.cPocConfigurationId.equals(other.cPocConfigurationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPocConfiguration[ cPocConfigurationId=" + cPocConfigurationId + " ]";
    }
    
}
