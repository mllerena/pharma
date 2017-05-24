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
@Table(name = "ad_fieldgroup_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdFieldgroupTrl.findAll", query = "SELECT a FROM AdFieldgroupTrl a"),
    @NamedQuery(name = "AdFieldgroupTrl.findByAdFieldgroupTrlId", query = "SELECT a FROM AdFieldgroupTrl a WHERE a.adFieldgroupTrlId = :adFieldgroupTrlId"),
    @NamedQuery(name = "AdFieldgroupTrl.findByIsactive", query = "SELECT a FROM AdFieldgroupTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdFieldgroupTrl.findByCreated", query = "SELECT a FROM AdFieldgroupTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdFieldgroupTrl.findByCreatedby", query = "SELECT a FROM AdFieldgroupTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdFieldgroupTrl.findByUpdated", query = "SELECT a FROM AdFieldgroupTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdFieldgroupTrl.findByUpdatedby", query = "SELECT a FROM AdFieldgroupTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdFieldgroupTrl.findByName", query = "SELECT a FROM AdFieldgroupTrl a WHERE a.name = :name"),
    @NamedQuery(name = "AdFieldgroupTrl.findByIstranslated", query = "SELECT a FROM AdFieldgroupTrl a WHERE a.istranslated = :istranslated")})
public class AdFieldgroupTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_fieldgroup_trl_id")
    private String adFieldgroupTrlId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslated")
    private Character istranslated;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_fieldgroup_id", referencedColumnName = "ad_fieldgroup_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdFieldgroup adFieldgroupId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdFieldgroupTrl() {
    }

    public AdFieldgroupTrl(String adFieldgroupTrlId) {
        this.adFieldgroupTrlId = adFieldgroupTrlId;
    }

    public AdFieldgroupTrl(String adFieldgroupTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.adFieldgroupTrlId = adFieldgroupTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getAdFieldgroupTrlId() {
        return adFieldgroupTrlId;
    }

    public void setAdFieldgroupTrlId(String adFieldgroupTrlId) {
        this.adFieldgroupTrlId = adFieldgroupTrlId;
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

    public AdFieldgroup getAdFieldgroupId() {
        return adFieldgroupId;
    }

    public void setAdFieldgroupId(AdFieldgroup adFieldgroupId) {
        this.adFieldgroupId = adFieldgroupId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adFieldgroupTrlId != null ? adFieldgroupTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdFieldgroupTrl)) {
            return false;
        }
        AdFieldgroupTrl other = (AdFieldgroupTrl) object;
        if ((this.adFieldgroupTrlId == null && other.adFieldgroupTrlId != null) || (this.adFieldgroupTrlId != null && !this.adFieldgroupTrlId.equals(other.adFieldgroupTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdFieldgroupTrl[ adFieldgroupTrlId=" + adFieldgroupTrlId + " ]";
    }
    
}
