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
@Table(name = "c_withholding_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CWithholdingAcct.findAll", query = "SELECT c FROM CWithholdingAcct c"),
    @NamedQuery(name = "CWithholdingAcct.findByCWithholdingAcctId", query = "SELECT c FROM CWithholdingAcct c WHERE c.cWithholdingAcctId = :cWithholdingAcctId"),
    @NamedQuery(name = "CWithholdingAcct.findByIsactive", query = "SELECT c FROM CWithholdingAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CWithholdingAcct.findByCreated", query = "SELECT c FROM CWithholdingAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CWithholdingAcct.findByCreatedby", query = "SELECT c FROM CWithholdingAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CWithholdingAcct.findByUpdated", query = "SELECT c FROM CWithholdingAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CWithholdingAcct.findByUpdatedby", query = "SELECT c FROM CWithholdingAcct c WHERE c.updatedby = :updatedby")})
public class CWithholdingAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_withholding_acct_id")
    private String cWithholdingAcctId;
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
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "withholding_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination withholdingAcct;
    @JoinColumn(name = "c_withholding_id", referencedColumnName = "c_withholding_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CWithholding cWithholdingId;

    public CWithholdingAcct() {
    }

    public CWithholdingAcct(String cWithholdingAcctId) {
        this.cWithholdingAcctId = cWithholdingAcctId;
    }

    public CWithholdingAcct(String cWithholdingAcctId, Date created, String createdby, Date updated, String updatedby) {
        this.cWithholdingAcctId = cWithholdingAcctId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCWithholdingAcctId() {
        return cWithholdingAcctId;
    }

    public void setCWithholdingAcctId(String cWithholdingAcctId) {
        this.cWithholdingAcctId = cWithholdingAcctId;
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

    public CValidcombination getWithholdingAcct() {
        return withholdingAcct;
    }

    public void setWithholdingAcct(CValidcombination withholdingAcct) {
        this.withholdingAcct = withholdingAcct;
    }

    public CWithholding getCWithholdingId() {
        return cWithholdingId;
    }

    public void setCWithholdingId(CWithholding cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cWithholdingAcctId != null ? cWithholdingAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CWithholdingAcct)) {
            return false;
        }
        CWithholdingAcct other = (CWithholdingAcct) object;
        if ((this.cWithholdingAcctId == null && other.cWithholdingAcctId != null) || (this.cWithholdingAcctId != null && !this.cWithholdingAcctId.equals(other.cWithholdingAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CWithholdingAcct[ cWithholdingAcctId=" + cWithholdingAcctId + " ]";
    }
    
}
