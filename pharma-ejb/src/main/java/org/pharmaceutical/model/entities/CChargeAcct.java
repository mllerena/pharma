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
@Table(name = "c_charge_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CChargeAcct.findAll", query = "SELECT c FROM CChargeAcct c"),
    @NamedQuery(name = "CChargeAcct.findByCChargeAcctId", query = "SELECT c FROM CChargeAcct c WHERE c.cChargeAcctId = :cChargeAcctId"),
    @NamedQuery(name = "CChargeAcct.findByIsactive", query = "SELECT c FROM CChargeAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CChargeAcct.findByCreated", query = "SELECT c FROM CChargeAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CChargeAcct.findByCreatedby", query = "SELECT c FROM CChargeAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CChargeAcct.findByUpdated", query = "SELECT c FROM CChargeAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CChargeAcct.findByUpdatedby", query = "SELECT c FROM CChargeAcct c WHERE c.updatedby = :updatedby")})
public class CChargeAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_charge_acct_id")
    private String cChargeAcctId;
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
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCharge cChargeId;
    @JoinColumn(name = "ch_revenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination chRevenueAcct;
    @JoinColumn(name = "ch_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination chExpenseAcct;

    public CChargeAcct() {
    }

    public CChargeAcct(String cChargeAcctId) {
        this.cChargeAcctId = cChargeAcctId;
    }

    public CChargeAcct(String cChargeAcctId, Date created, String createdby, Date updated, String updatedby) {
        this.cChargeAcctId = cChargeAcctId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCChargeAcctId() {
        return cChargeAcctId;
    }

    public void setCChargeAcctId(String cChargeAcctId) {
        this.cChargeAcctId = cChargeAcctId;
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

    public CCharge getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(CCharge cChargeId) {
        this.cChargeId = cChargeId;
    }

    public CValidcombination getChRevenueAcct() {
        return chRevenueAcct;
    }

    public void setChRevenueAcct(CValidcombination chRevenueAcct) {
        this.chRevenueAcct = chRevenueAcct;
    }

    public CValidcombination getChExpenseAcct() {
        return chExpenseAcct;
    }

    public void setChExpenseAcct(CValidcombination chExpenseAcct) {
        this.chExpenseAcct = chExpenseAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cChargeAcctId != null ? cChargeAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CChargeAcct)) {
            return false;
        }
        CChargeAcct other = (CChargeAcct) object;
        if ((this.cChargeAcctId == null && other.cChargeAcctId != null) || (this.cChargeAcctId != null && !this.cChargeAcctId.equals(other.cChargeAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CChargeAcct[ cChargeAcctId=" + cChargeAcctId + " ]";
    }
    
}
