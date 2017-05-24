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
@Table(name = "c_tax_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxTrl.findAll", query = "SELECT c FROM CTaxTrl c"),
    @NamedQuery(name = "CTaxTrl.findByCTaxTrlId", query = "SELECT c FROM CTaxTrl c WHERE c.cTaxTrlId = :cTaxTrlId"),
    @NamedQuery(name = "CTaxTrl.findByIsactive", query = "SELECT c FROM CTaxTrl c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxTrl.findByCreated", query = "SELECT c FROM CTaxTrl c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxTrl.findByCreatedby", query = "SELECT c FROM CTaxTrl c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxTrl.findByUpdated", query = "SELECT c FROM CTaxTrl c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxTrl.findByUpdatedby", query = "SELECT c FROM CTaxTrl c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxTrl.findByIstranslated", query = "SELECT c FROM CTaxTrl c WHERE c.istranslated = :istranslated"),
    @NamedQuery(name = "CTaxTrl.findByName", query = "SELECT c FROM CTaxTrl c WHERE c.name = :name"),
    @NamedQuery(name = "CTaxTrl.findByDescription", query = "SELECT c FROM CTaxTrl c WHERE c.description = :description"),
    @NamedQuery(name = "CTaxTrl.findByTaxindicator", query = "SELECT c FROM CTaxTrl c WHERE c.taxindicator = :taxindicator")})
public class CTaxTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_tax_trl_id")
    private String cTaxTrlId;
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
    @Size(max = 5)
    @Column(name = "taxindicator")
    private String taxindicator;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTax cTaxId;

    public CTaxTrl() {
    }

    public CTaxTrl(String cTaxTrlId) {
        this.cTaxTrlId = cTaxTrlId;
    }

    public CTaxTrl(String cTaxTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character istranslated, String name) {
        this.cTaxTrlId = cTaxTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.istranslated = istranslated;
        this.name = name;
    }

    public String getCTaxTrlId() {
        return cTaxTrlId;
    }

    public void setCTaxTrlId(String cTaxTrlId) {
        this.cTaxTrlId = cTaxTrlId;
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

    public String getTaxindicator() {
        return taxindicator;
    }

    public void setTaxindicator(String taxindicator) {
        this.taxindicator = taxindicator;
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

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxTrlId != null ? cTaxTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxTrl)) {
            return false;
        }
        CTaxTrl other = (CTaxTrl) object;
        if ((this.cTaxTrlId == null && other.cTaxTrlId != null) || (this.cTaxTrlId != null && !this.cTaxTrlId.equals(other.cTaxTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxTrl[ cTaxTrlId=" + cTaxTrlId + " ]";
    }
    
}
