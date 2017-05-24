/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "fact_acct_cfs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactAcctCfs.findAll", query = "SELECT f FROM FactAcctCfs f"),
    @NamedQuery(name = "FactAcctCfs.findByFactAcctCfsId", query = "SELECT f FROM FactAcctCfs f WHERE f.factAcctCfsId = :factAcctCfsId"),
    @NamedQuery(name = "FactAcctCfs.findByIsactive", query = "SELECT f FROM FactAcctCfs f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FactAcctCfs.findByCreated", query = "SELECT f FROM FactAcctCfs f WHERE f.created = :created"),
    @NamedQuery(name = "FactAcctCfs.findByCreatedby", query = "SELECT f FROM FactAcctCfs f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FactAcctCfs.findByUpdated", query = "SELECT f FROM FactAcctCfs f WHERE f.updated = :updated"),
    @NamedQuery(name = "FactAcctCfs.findByUpdatedby", query = "SELECT f FROM FactAcctCfs f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FactAcctCfs.findByAmount", query = "SELECT f FROM FactAcctCfs f WHERE f.amount = :amount")})
public class FactAcctCfs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fact_acct_cfs_id")
    private String factAcctCfsId;
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
    @Column(name = "amount")
    private BigInteger amount;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "account_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CElementvalue accountId;
    @JoinColumn(name = "fact_acct_id", referencedColumnName = "fact_acct_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FactAcct factAcctId;
    @JoinColumn(name = "fact_acct_ref_id", referencedColumnName = "fact_acct_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FactAcct factAcctRefId;

    public FactAcctCfs() {
    }

    public FactAcctCfs(String factAcctCfsId) {
        this.factAcctCfsId = factAcctCfsId;
    }

    public FactAcctCfs(String factAcctCfsId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger amount) {
        this.factAcctCfsId = factAcctCfsId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.amount = amount;
    }

    public String getFactAcctCfsId() {
        return factAcctCfsId;
    }

    public void setFactAcctCfsId(String factAcctCfsId) {
        this.factAcctCfsId = factAcctCfsId;
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

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
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

    public CElementvalue getAccountId() {
        return accountId;
    }

    public void setAccountId(CElementvalue accountId) {
        this.accountId = accountId;
    }

    public FactAcct getFactAcctId() {
        return factAcctId;
    }

    public void setFactAcctId(FactAcct factAcctId) {
        this.factAcctId = factAcctId;
    }

    public FactAcct getFactAcctRefId() {
        return factAcctRefId;
    }

    public void setFactAcctRefId(FactAcct factAcctRefId) {
        this.factAcctRefId = factAcctRefId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factAcctCfsId != null ? factAcctCfsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactAcctCfs)) {
            return false;
        }
        FactAcctCfs other = (FactAcctCfs) object;
        if ((this.factAcctCfsId == null && other.factAcctCfsId != null) || (this.factAcctCfsId != null && !this.factAcctCfsId.equals(other.factAcctCfsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FactAcctCfs[ factAcctCfsId=" + factAcctCfsId + " ]";
    }
    
}
