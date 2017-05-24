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
@Table(name = "c_project_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjectAcct.findAll", query = "SELECT c FROM CProjectAcct c"),
    @NamedQuery(name = "CProjectAcct.findByCProjectAcctId", query = "SELECT c FROM CProjectAcct c WHERE c.cProjectAcctId = :cProjectAcctId"),
    @NamedQuery(name = "CProjectAcct.findByIsactive", query = "SELECT c FROM CProjectAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjectAcct.findByCreated", query = "SELECT c FROM CProjectAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CProjectAcct.findByCreatedby", query = "SELECT c FROM CProjectAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjectAcct.findByUpdated", query = "SELECT c FROM CProjectAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjectAcct.findByUpdatedby", query = "SELECT c FROM CProjectAcct c WHERE c.updatedby = :updatedby")})
public class CProjectAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_project_acct_id")
    private String cProjectAcctId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProject cProjectId;
    @JoinColumn(name = "pj_wip_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pjWipAcct;
    @JoinColumn(name = "pj_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pjAssetAcct;

    public CProjectAcct() {
    }

    public CProjectAcct(String cProjectAcctId) {
        this.cProjectAcctId = cProjectAcctId;
    }

    public CProjectAcct(String cProjectAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cProjectAcctId = cProjectAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCProjectAcctId() {
        return cProjectAcctId;
    }

    public void setCProjectAcctId(String cProjectAcctId) {
        this.cProjectAcctId = cProjectAcctId;
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

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public CValidcombination getPjWipAcct() {
        return pjWipAcct;
    }

    public void setPjWipAcct(CValidcombination pjWipAcct) {
        this.pjWipAcct = pjWipAcct;
    }

    public CValidcombination getPjAssetAcct() {
        return pjAssetAcct;
    }

    public void setPjAssetAcct(CValidcombination pjAssetAcct) {
        this.pjAssetAcct = pjAssetAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProjectAcctId != null ? cProjectAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjectAcct)) {
            return false;
        }
        CProjectAcct other = (CProjectAcct) object;
        if ((this.cProjectAcctId == null && other.cProjectAcctId != null) || (this.cProjectAcctId != null && !this.cProjectAcctId.equals(other.cProjectAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjectAcct[ cProjectAcctId=" + cProjectAcctId + " ]";
    }
    
}