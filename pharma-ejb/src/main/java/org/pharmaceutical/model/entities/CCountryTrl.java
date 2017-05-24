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
@Table(name = "c_country_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCountryTrl.findAll", query = "SELECT c FROM CCountryTrl c"),
    @NamedQuery(name = "CCountryTrl.findByCCountryTrlId", query = "SELECT c FROM CCountryTrl c WHERE c.cCountryTrlId = :cCountryTrlId"),
    @NamedQuery(name = "CCountryTrl.findByIsactive", query = "SELECT c FROM CCountryTrl c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCountryTrl.findByCreated", query = "SELECT c FROM CCountryTrl c WHERE c.created = :created"),
    @NamedQuery(name = "CCountryTrl.findByCreatedby", query = "SELECT c FROM CCountryTrl c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCountryTrl.findByUpdated", query = "SELECT c FROM CCountryTrl c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCountryTrl.findByUpdatedby", query = "SELECT c FROM CCountryTrl c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCountryTrl.findByIstranslated", query = "SELECT c FROM CCountryTrl c WHERE c.istranslated = :istranslated"),
    @NamedQuery(name = "CCountryTrl.findByName", query = "SELECT c FROM CCountryTrl c WHERE c.name = :name"),
    @NamedQuery(name = "CCountryTrl.findByDescription", query = "SELECT c FROM CCountryTrl c WHERE c.description = :description"),
    @NamedQuery(name = "CCountryTrl.findByRegionname", query = "SELECT c FROM CCountryTrl c WHERE c.regionname = :regionname"),
    @NamedQuery(name = "CCountryTrl.findByDisplaysequence", query = "SELECT c FROM CCountryTrl c WHERE c.displaysequence = :displaysequence")})
public class CCountryTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_country_trl_id")
    private String cCountryTrlId;
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
    @Column(name = "istranslated")
    private Character istranslated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 60)
    @Column(name = "regionname")
    private String regionname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "displaysequence")
    private String displaysequence;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCountry cCountryId;

    public CCountryTrl() {
    }

    public CCountryTrl(String cCountryTrlId) {
        this.cCountryTrlId = cCountryTrlId;
    }

    public CCountryTrl(String cCountryTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character istranslated, String name, String displaysequence) {
        this.cCountryTrlId = cCountryTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.istranslated = istranslated;
        this.name = name;
        this.displaysequence = displaysequence;
    }

    public String getCCountryTrlId() {
        return cCountryTrlId;
    }

    public void setCCountryTrlId(String cCountryTrlId) {
        this.cCountryTrlId = cCountryTrlId;
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

    public Character getIstranslated() {
        return istranslated;
    }

    public void setIstranslated(Character istranslated) {
        this.istranslated = istranslated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getDisplaysequence() {
        return displaysequence;
    }

    public void setDisplaysequence(String displaysequence) {
        this.displaysequence = displaysequence;
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

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCountryTrlId != null ? cCountryTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCountryTrl)) {
            return false;
        }
        CCountryTrl other = (CCountryTrl) object;
        if ((this.cCountryTrlId == null && other.cCountryTrlId != null) || (this.cCountryTrlId != null && !this.cCountryTrlId.equals(other.cCountryTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCountryTrl[ cCountryTrlId=" + cCountryTrlId + " ]";
    }
    
}
