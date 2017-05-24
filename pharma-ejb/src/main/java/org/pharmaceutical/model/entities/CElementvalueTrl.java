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
@Table(name = "c_elementvalue_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CElementvalueTrl.findAll", query = "SELECT c FROM CElementvalueTrl c"),
    @NamedQuery(name = "CElementvalueTrl.findByCElementvalueTrlId", query = "SELECT c FROM CElementvalueTrl c WHERE c.cElementvalueTrlId = :cElementvalueTrlId"),
    @NamedQuery(name = "CElementvalueTrl.findByIsactive", query = "SELECT c FROM CElementvalueTrl c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CElementvalueTrl.findByCreated", query = "SELECT c FROM CElementvalueTrl c WHERE c.created = :created"),
    @NamedQuery(name = "CElementvalueTrl.findByCreatedby", query = "SELECT c FROM CElementvalueTrl c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CElementvalueTrl.findByUpdated", query = "SELECT c FROM CElementvalueTrl c WHERE c.updated = :updated"),
    @NamedQuery(name = "CElementvalueTrl.findByUpdatedby", query = "SELECT c FROM CElementvalueTrl c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CElementvalueTrl.findByName", query = "SELECT c FROM CElementvalueTrl c WHERE c.name = :name"),
    @NamedQuery(name = "CElementvalueTrl.findByDescription", query = "SELECT c FROM CElementvalueTrl c WHERE c.description = :description"),
    @NamedQuery(name = "CElementvalueTrl.findByIstranslated", query = "SELECT c FROM CElementvalueTrl c WHERE c.istranslated = :istranslated")})
public class CElementvalueTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_elementvalue_trl_id")
    private String cElementvalueTrlId;
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
    @Size(min = 1, max = 255)
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
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_elementvalue_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CElementvalue cElementvalueId;

    public CElementvalueTrl() {
    }

    public CElementvalueTrl(String cElementvalueTrlId) {
        this.cElementvalueTrlId = cElementvalueTrlId;
    }

    public CElementvalueTrl(String cElementvalueTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.cElementvalueTrlId = cElementvalueTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getCElementvalueTrlId() {
        return cElementvalueTrlId;
    }

    public void setCElementvalueTrlId(String cElementvalueTrlId) {
        this.cElementvalueTrlId = cElementvalueTrlId;
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

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CElementvalue getCElementvalueId() {
        return cElementvalueId;
    }

    public void setCElementvalueId(CElementvalue cElementvalueId) {
        this.cElementvalueId = cElementvalueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cElementvalueTrlId != null ? cElementvalueTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CElementvalueTrl)) {
            return false;
        }
        CElementvalueTrl other = (CElementvalueTrl) object;
        if ((this.cElementvalueTrlId == null && other.cElementvalueTrlId != null) || (this.cElementvalueTrlId != null && !this.cElementvalueTrlId.equals(other.cElementvalueTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CElementvalueTrl[ cElementvalueTrlId=" + cElementvalueTrlId + " ]";
    }
    
}
