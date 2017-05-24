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
@Table(name = "m_product_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductTrl.findAll", query = "SELECT m FROM MProductTrl m"),
    @NamedQuery(name = "MProductTrl.findByMProductTrlId", query = "SELECT m FROM MProductTrl m WHERE m.mProductTrlId = :mProductTrlId"),
    @NamedQuery(name = "MProductTrl.findByIsactive", query = "SELECT m FROM MProductTrl m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductTrl.findByCreated", query = "SELECT m FROM MProductTrl m WHERE m.created = :created"),
    @NamedQuery(name = "MProductTrl.findByCreatedby", query = "SELECT m FROM MProductTrl m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductTrl.findByUpdated", query = "SELECT m FROM MProductTrl m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductTrl.findByUpdatedby", query = "SELECT m FROM MProductTrl m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductTrl.findByName", query = "SELECT m FROM MProductTrl m WHERE m.name = :name"),
    @NamedQuery(name = "MProductTrl.findByDocumentnote", query = "SELECT m FROM MProductTrl m WHERE m.documentnote = :documentnote"),
    @NamedQuery(name = "MProductTrl.findByIstranslated", query = "SELECT m FROM MProductTrl m WHERE m.istranslated = :istranslated")})
public class MProductTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_product_trl_id")
    private String mProductTrlId;
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
    @Size(max = 2000)
    @Column(name = "documentnote")
    private String documentnote;
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
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public MProductTrl() {
    }

    public MProductTrl(String mProductTrlId) {
        this.mProductTrlId = mProductTrlId;
    }

    public MProductTrl(String mProductTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.mProductTrlId = mProductTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getMProductTrlId() {
        return mProductTrlId;
    }

    public void setMProductTrlId(String mProductTrlId) {
        this.mProductTrlId = mProductTrlId;
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

    public String getDocumentnote() {
        return documentnote;
    }

    public void setDocumentnote(String documentnote) {
        this.documentnote = documentnote;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductTrlId != null ? mProductTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductTrl)) {
            return false;
        }
        MProductTrl other = (MProductTrl) object;
        if ((this.mProductTrlId == null && other.mProductTrlId != null) || (this.mProductTrlId != null && !this.mProductTrlId.equals(other.mProductTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductTrl[ mProductTrlId=" + mProductTrlId + " ]";
    }
    
}
