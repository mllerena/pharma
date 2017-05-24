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
@Table(name = "fin_payment_credit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentCredit.findAll", query = "SELECT f FROM FinPaymentCredit f"),
    @NamedQuery(name = "FinPaymentCredit.findByFinPaymentCreditId", query = "SELECT f FROM FinPaymentCredit f WHERE f.finPaymentCreditId = :finPaymentCreditId"),
    @NamedQuery(name = "FinPaymentCredit.findByCreated", query = "SELECT f FROM FinPaymentCredit f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentCredit.findByCreatedby", query = "SELECT f FROM FinPaymentCredit f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentCredit.findByUpdated", query = "SELECT f FROM FinPaymentCredit f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentCredit.findByUpdatedby", query = "SELECT f FROM FinPaymentCredit f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentCredit.findByIsactive", query = "SELECT f FROM FinPaymentCredit f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentCredit.findByAmount", query = "SELECT f FROM FinPaymentCredit f WHERE f.amount = :amount")})
public class FinPaymentCredit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_credit_id")
    private String finPaymentCreditId;
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
    @Column(name = "isactive")
    private Character isactive;
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
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "fin_payment_id_used", referencedColumnName = "fin_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPayment finPaymentIdUsed;
    @JoinColumn(name = "fin_payment_id", referencedColumnName = "fin_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPayment finPaymentId;

    public FinPaymentCredit() {
    }

    public FinPaymentCredit(String finPaymentCreditId) {
        this.finPaymentCreditId = finPaymentCreditId;
    }

    public FinPaymentCredit(String finPaymentCreditId, Date created, String createdby, Date updated, String updatedby, BigInteger amount) {
        this.finPaymentCreditId = finPaymentCreditId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.amount = amount;
    }

    public String getFinPaymentCreditId() {
        return finPaymentCreditId;
    }

    public void setFinPaymentCreditId(String finPaymentCreditId) {
        this.finPaymentCreditId = finPaymentCreditId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public FinPayment getFinPaymentIdUsed() {
        return finPaymentIdUsed;
    }

    public void setFinPaymentIdUsed(FinPayment finPaymentIdUsed) {
        this.finPaymentIdUsed = finPaymentIdUsed;
    }

    public FinPayment getFinPaymentId() {
        return finPaymentId;
    }

    public void setFinPaymentId(FinPayment finPaymentId) {
        this.finPaymentId = finPaymentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentCreditId != null ? finPaymentCreditId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentCredit)) {
            return false;
        }
        FinPaymentCredit other = (FinPaymentCredit) object;
        if ((this.finPaymentCreditId == null && other.finPaymentCreditId != null) || (this.finPaymentCreditId != null && !this.finPaymentCreditId.equals(other.finPaymentCreditId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentCredit[ finPaymentCreditId=" + finPaymentCreditId + " ]";
    }
    
}
