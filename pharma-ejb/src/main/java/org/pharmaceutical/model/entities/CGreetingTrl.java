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
@Table(name = "c_greeting_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CGreetingTrl.findAll", query = "SELECT c FROM CGreetingTrl c"),
    @NamedQuery(name = "CGreetingTrl.findByCGreetingTrlId", query = "SELECT c FROM CGreetingTrl c WHERE c.cGreetingTrlId = :cGreetingTrlId"),
    @NamedQuery(name = "CGreetingTrl.findByIsactive", query = "SELECT c FROM CGreetingTrl c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CGreetingTrl.findByCreated", query = "SELECT c FROM CGreetingTrl c WHERE c.created = :created"),
    @NamedQuery(name = "CGreetingTrl.findByCreatedby", query = "SELECT c FROM CGreetingTrl c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CGreetingTrl.findByUpdated", query = "SELECT c FROM CGreetingTrl c WHERE c.updated = :updated"),
    @NamedQuery(name = "CGreetingTrl.findByUpdatedby", query = "SELECT c FROM CGreetingTrl c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CGreetingTrl.findByName", query = "SELECT c FROM CGreetingTrl c WHERE c.name = :name"),
    @NamedQuery(name = "CGreetingTrl.findByGreeting", query = "SELECT c FROM CGreetingTrl c WHERE c.greeting = :greeting"),
    @NamedQuery(name = "CGreetingTrl.findByIstranslated", query = "SELECT c FROM CGreetingTrl c WHERE c.istranslated = :istranslated")})
public class CGreetingTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_greeting_trl_id")
    private String cGreetingTrlId;
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
    @Column(name = "istranslated")
    private Character istranslated;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_greeting_id", referencedColumnName = "c_greeting_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CGreeting cGreetingId;

    public CGreetingTrl() {
    }

    public CGreetingTrl(String cGreetingTrlId) {
        this.cGreetingTrlId = cGreetingTrlId;
    }

    public CGreetingTrl(String cGreetingTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.cGreetingTrlId = cGreetingTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getCGreetingTrlId() {
        return cGreetingTrlId;
    }

    public void setCGreetingTrlId(String cGreetingTrlId) {
        this.cGreetingTrlId = cGreetingTrlId;
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

    public Character getIstranslated() {
        return istranslated;
    }

    public void setIstranslated(Character istranslated) {
        this.istranslated = istranslated;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdLanguage getAdLanguage() {
        return adLanguage;
    }

    public void setAdLanguage(AdLanguage adLanguage) {
        this.adLanguage = adLanguage;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CGreeting getCGreetingId() {
        return cGreetingId;
    }

    public void setCGreetingId(CGreeting cGreetingId) {
        this.cGreetingId = cGreetingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cGreetingTrlId != null ? cGreetingTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CGreetingTrl)) {
            return false;
        }
        CGreetingTrl other = (CGreetingTrl) object;
        if ((this.cGreetingTrlId == null && other.cGreetingTrlId != null) || (this.cGreetingTrlId != null && !this.cGreetingTrlId.equals(other.cGreetingTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CGreetingTrl[ cGreetingTrlId=" + cGreetingTrlId + " ]";
    }
    
}
