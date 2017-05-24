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
@Table(name = "c_taxcategory_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxcategoryTrl.findAll", query = "SELECT c FROM CTaxcategoryTrl c"),
    @NamedQuery(name = "CTaxcategoryTrl.findByCTaxcategoryTrlId", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.cTaxcategoryTrlId = :cTaxcategoryTrlId"),
    @NamedQuery(name = "CTaxcategoryTrl.findByIsactive", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxcategoryTrl.findByCreated", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxcategoryTrl.findByCreatedby", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxcategoryTrl.findByUpdated", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxcategoryTrl.findByUpdatedby", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxcategoryTrl.findByName", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.name = :name"),
    @NamedQuery(name = "CTaxcategoryTrl.findByDescription", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.description = :description"),
    @NamedQuery(name = "CTaxcategoryTrl.findByIstranslated", query = "SELECT c FROM CTaxcategoryTrl c WHERE c.istranslated = :istranslated")})
public class CTaxcategoryTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_taxcategory_trl_id")
    private String cTaxcategoryTrlId;
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
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_taxcategory_id", referencedColumnName = "c_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTaxcategory cTaxcategoryId;

    public CTaxcategoryTrl() {
    }

    public CTaxcategoryTrl(String cTaxcategoryTrlId) {
        this.cTaxcategoryTrlId = cTaxcategoryTrlId;
    }

    public CTaxcategoryTrl(String cTaxcategoryTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.cTaxcategoryTrlId = cTaxcategoryTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getCTaxcategoryTrlId() {
        return cTaxcategoryTrlId;
    }

    public void setCTaxcategoryTrlId(String cTaxcategoryTrlId) {
        this.cTaxcategoryTrlId = cTaxcategoryTrlId;
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

    public CTaxcategory getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(CTaxcategory cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxcategoryTrlId != null ? cTaxcategoryTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxcategoryTrl)) {
            return false;
        }
        CTaxcategoryTrl other = (CTaxcategoryTrl) object;
        if ((this.cTaxcategoryTrlId == null && other.cTaxcategoryTrlId != null) || (this.cTaxcategoryTrlId != null && !this.cTaxcategoryTrlId.equals(other.cTaxcategoryTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxcategoryTrl[ cTaxcategoryTrlId=" + cTaxcategoryTrlId + " ]";
    }
    
}
