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
@Table(name = "ad_module_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModuleTrl.findAll", query = "SELECT a FROM AdModuleTrl a"),
    @NamedQuery(name = "AdModuleTrl.findByAdModuleTrlId", query = "SELECT a FROM AdModuleTrl a WHERE a.adModuleTrlId = :adModuleTrlId"),
    @NamedQuery(name = "AdModuleTrl.findByIsactive", query = "SELECT a FROM AdModuleTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModuleTrl.findByCreated", query = "SELECT a FROM AdModuleTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdModuleTrl.findByCreatedby", query = "SELECT a FROM AdModuleTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModuleTrl.findByUpdated", query = "SELECT a FROM AdModuleTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModuleTrl.findByUpdatedby", query = "SELECT a FROM AdModuleTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModuleTrl.findByDescription", query = "SELECT a FROM AdModuleTrl a WHERE a.description = :description"),
    @NamedQuery(name = "AdModuleTrl.findByHelp", query = "SELECT a FROM AdModuleTrl a WHERE a.help = :help"),
    @NamedQuery(name = "AdModuleTrl.findByLicense", query = "SELECT a FROM AdModuleTrl a WHERE a.license = :license"),
    @NamedQuery(name = "AdModuleTrl.findByIstranslated", query = "SELECT a FROM AdModuleTrl a WHERE a.istranslated = :istranslated"),
    @NamedQuery(name = "AdModuleTrl.findByUpdateinfo", query = "SELECT a FROM AdModuleTrl a WHERE a.updateinfo = :updateinfo"),
    @NamedQuery(name = "AdModuleTrl.findByReferencedatainfo", query = "SELECT a FROM AdModuleTrl a WHERE a.referencedatainfo = :referencedatainfo")})
public class AdModuleTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_module_trl_id")
    private String adModuleTrlId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Size(max = 2000)
    @Column(name = "license")
    private String license;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslated")
    private Character istranslated;
    @Size(max = 2000)
    @Column(name = "updateinfo")
    private String updateinfo;
    @Size(max = 2000)
    @Column(name = "referencedatainfo")
    private String referencedatainfo;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModuleTrl() {
    }

    public AdModuleTrl(String adModuleTrlId) {
        this.adModuleTrlId = adModuleTrlId;
    }

    public AdModuleTrl(String adModuleTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character istranslated) {
        this.adModuleTrlId = adModuleTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.istranslated = istranslated;
    }

    public String getAdModuleTrlId() {
        return adModuleTrlId;
    }

    public void setAdModuleTrlId(String adModuleTrlId) {
        this.adModuleTrlId = adModuleTrlId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Character getIstranslated() {
        return istranslated;
    }

    public void setIstranslated(Character istranslated) {
        this.istranslated = istranslated;
    }

    public String getUpdateinfo() {
        return updateinfo;
    }

    public void setUpdateinfo(String updateinfo) {
        this.updateinfo = updateinfo;
    }

    public String getReferencedatainfo() {
        return referencedatainfo;
    }

    public void setReferencedatainfo(String referencedatainfo) {
        this.referencedatainfo = referencedatainfo;
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

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
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
        hash += (adModuleTrlId != null ? adModuleTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModuleTrl)) {
            return false;
        }
        AdModuleTrl other = (AdModuleTrl) object;
        if ((this.adModuleTrlId == null && other.adModuleTrlId != null) || (this.adModuleTrlId != null && !this.adModuleTrlId.equals(other.adModuleTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModuleTrl[ adModuleTrlId=" + adModuleTrlId + " ]";
    }
    
}
