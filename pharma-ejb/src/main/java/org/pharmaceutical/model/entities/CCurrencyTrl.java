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
@Table(name = "c_currency_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCurrencyTrl.findAll", query = "SELECT c FROM CCurrencyTrl c"),
    @NamedQuery(name = "CCurrencyTrl.findByCCurrencyTrlId", query = "SELECT c FROM CCurrencyTrl c WHERE c.cCurrencyTrlId = :cCurrencyTrlId"),
    @NamedQuery(name = "CCurrencyTrl.findByIsactive", query = "SELECT c FROM CCurrencyTrl c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCurrencyTrl.findByCreated", query = "SELECT c FROM CCurrencyTrl c WHERE c.created = :created"),
    @NamedQuery(name = "CCurrencyTrl.findByCreatedby", query = "SELECT c FROM CCurrencyTrl c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCurrencyTrl.findByUpdated", query = "SELECT c FROM CCurrencyTrl c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCurrencyTrl.findByUpdatedby", query = "SELECT c FROM CCurrencyTrl c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCurrencyTrl.findByIstranslated", query = "SELECT c FROM CCurrencyTrl c WHERE c.istranslated = :istranslated"),
    @NamedQuery(name = "CCurrencyTrl.findByCursymbol", query = "SELECT c FROM CCurrencyTrl c WHERE c.cursymbol = :cursymbol"),
    @NamedQuery(name = "CCurrencyTrl.findByDescription", query = "SELECT c FROM CCurrencyTrl c WHERE c.description = :description")})
public class CCurrencyTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_currency_trl_id")
    private String cCurrencyTrlId;
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
    @Size(max = 10)
    @Column(name = "cursymbol")
    private String cursymbol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;

    public CCurrencyTrl() {
    }

    public CCurrencyTrl(String cCurrencyTrlId) {
        this.cCurrencyTrlId = cCurrencyTrlId;
    }

    public CCurrencyTrl(String cCurrencyTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character istranslated, String description) {
        this.cCurrencyTrlId = cCurrencyTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.istranslated = istranslated;
        this.description = description;
    }

    public String getCCurrencyTrlId() {
        return cCurrencyTrlId;
    }

    public void setCCurrencyTrlId(String cCurrencyTrlId) {
        this.cCurrencyTrlId = cCurrencyTrlId;
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

    public String getCursymbol() {
        return cursymbol;
    }

    public void setCursymbol(String cursymbol) {
        this.cursymbol = cursymbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCurrencyTrlId != null ? cCurrencyTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCurrencyTrl)) {
            return false;
        }
        CCurrencyTrl other = (CCurrencyTrl) object;
        if ((this.cCurrencyTrlId == null && other.cCurrencyTrlId != null) || (this.cCurrencyTrlId != null && !this.cCurrencyTrlId.equals(other.cCurrencyTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCurrencyTrl[ cCurrencyTrlId=" + cCurrencyTrlId + " ]";
    }
    
}
