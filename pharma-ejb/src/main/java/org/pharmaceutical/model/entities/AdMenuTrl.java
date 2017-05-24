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
@Table(name = "ad_menu_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdMenuTrl.findAll", query = "SELECT a FROM AdMenuTrl a"),
    @NamedQuery(name = "AdMenuTrl.findByAdMenuTrlId", query = "SELECT a FROM AdMenuTrl a WHERE a.adMenuTrlId = :adMenuTrlId"),
    @NamedQuery(name = "AdMenuTrl.findByIsactive", query = "SELECT a FROM AdMenuTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdMenuTrl.findByCreated", query = "SELECT a FROM AdMenuTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdMenuTrl.findByCreatedby", query = "SELECT a FROM AdMenuTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdMenuTrl.findByUpdated", query = "SELECT a FROM AdMenuTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdMenuTrl.findByUpdatedby", query = "SELECT a FROM AdMenuTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdMenuTrl.findByName", query = "SELECT a FROM AdMenuTrl a WHERE a.name = :name"),
    @NamedQuery(name = "AdMenuTrl.findByDescription", query = "SELECT a FROM AdMenuTrl a WHERE a.description = :description"),
    @NamedQuery(name = "AdMenuTrl.findByIstranslated", query = "SELECT a FROM AdMenuTrl a WHERE a.istranslated = :istranslated")})
public class AdMenuTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_menu_trl_id")
    private String adMenuTrlId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
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
    @JoinColumn(name = "ad_menu_id", referencedColumnName = "ad_menu_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdMenu adMenuId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdMenuTrl() {
    }

    public AdMenuTrl(String adMenuTrlId) {
        this.adMenuTrlId = adMenuTrlId;
    }

    public AdMenuTrl(String adMenuTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.adMenuTrlId = adMenuTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getAdMenuTrlId() {
        return adMenuTrlId;
    }

    public void setAdMenuTrlId(String adMenuTrlId) {
        this.adMenuTrlId = adMenuTrlId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public AdMenu getAdMenuId() {
        return adMenuId;
    }

    public void setAdMenuId(AdMenu adMenuId) {
        this.adMenuId = adMenuId;
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
        hash += (adMenuTrlId != null ? adMenuTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdMenuTrl)) {
            return false;
        }
        AdMenuTrl other = (AdMenuTrl) object;
        if ((this.adMenuTrlId == null && other.adMenuTrlId != null) || (this.adMenuTrlId != null && !this.adMenuTrlId.equals(other.adMenuTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdMenuTrl[ adMenuTrlId=" + adMenuTrlId + " ]";
    }
    
}
