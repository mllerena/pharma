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
@Table(name = "c_debt_payment_balancing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CDebtPaymentBalancing.findAll", query = "SELECT c FROM CDebtPaymentBalancing c"),
    @NamedQuery(name = "CDebtPaymentBalancing.findByCDebtPaymentBalancingId", query = "SELECT c FROM CDebtPaymentBalancing c WHERE c.cDebtPaymentBalancingId = :cDebtPaymentBalancingId"),
    @NamedQuery(name = "CDebtPaymentBalancing.findByIsactive", query = "SELECT c FROM CDebtPaymentBalancing c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CDebtPaymentBalancing.findByCreated", query = "SELECT c FROM CDebtPaymentBalancing c WHERE c.created = :created"),
    @NamedQuery(name = "CDebtPaymentBalancing.findByCreatedby", query = "SELECT c FROM CDebtPaymentBalancing c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CDebtPaymentBalancing.findByUpdated", query = "SELECT c FROM CDebtPaymentBalancing c WHERE c.updated = :updated"),
    @NamedQuery(name = "CDebtPaymentBalancing.findByUpdatedby", query = "SELECT c FROM CDebtPaymentBalancing c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CDebtPaymentBalancing.findByAmountdebit", query = "SELECT c FROM CDebtPaymentBalancing c WHERE c.amountdebit = :amountdebit"),
    @NamedQuery(name = "CDebtPaymentBalancing.findByAmountcredit", query = "SELECT c FROM CDebtPaymentBalancing c WHERE c.amountcredit = :amountcredit")})
public class CDebtPaymentBalancing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_debt_payment_balancing_id")
    private String cDebtPaymentBalancingId;
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
    @Column(name = "amountdebit")
    private BigInteger amountdebit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amountcredit")
    private BigInteger amountcredit;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CGlitem cGlitemId;

    public CDebtPaymentBalancing() {
    }

    public CDebtPaymentBalancing(String cDebtPaymentBalancingId) {
        this.cDebtPaymentBalancingId = cDebtPaymentBalancingId;
    }

    public CDebtPaymentBalancing(String cDebtPaymentBalancingId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger amountdebit, BigInteger amountcredit) {
        this.cDebtPaymentBalancingId = cDebtPaymentBalancingId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.amountdebit = amountdebit;
        this.amountcredit = amountcredit;
    }

    public String getCDebtPaymentBalancingId() {
        return cDebtPaymentBalancingId;
    }

    public void setCDebtPaymentBalancingId(String cDebtPaymentBalancingId) {
        this.cDebtPaymentBalancingId = cDebtPaymentBalancingId;
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

    public BigInteger getAmountdebit() {
        return amountdebit;
    }

    public void setAmountdebit(BigInteger amountdebit) {
        this.amountdebit = amountdebit;
    }

    public BigInteger getAmountcredit() {
        return amountcredit;
    }

    public void setAmountcredit(BigInteger amountcredit) {
        this.amountcredit = amountcredit;
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

    public CDebtPayment getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(CDebtPayment cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
    }

    public CGlitem getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(CGlitem cGlitemId) {
        this.cGlitemId = cGlitemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDebtPaymentBalancingId != null ? cDebtPaymentBalancingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDebtPaymentBalancing)) {
            return false;
        }
        CDebtPaymentBalancing other = (CDebtPaymentBalancing) object;
        if ((this.cDebtPaymentBalancingId == null && other.cDebtPaymentBalancingId != null) || (this.cDebtPaymentBalancingId != null && !this.cDebtPaymentBalancingId.equals(other.cDebtPaymentBalancingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CDebtPaymentBalancing[ cDebtPaymentBalancingId=" + cDebtPaymentBalancingId + " ]";
    }
    
}
