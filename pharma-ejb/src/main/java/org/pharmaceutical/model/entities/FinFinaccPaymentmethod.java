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
@Table(name = "fin_finacc_paymentmethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinFinaccPaymentmethod.findAll", query = "SELECT f FROM FinFinaccPaymentmethod f"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByFinFinaccPaymentmethodId", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.finFinaccPaymentmethodId = :finFinaccPaymentmethodId"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByCreated", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.created = :created"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByCreatedby", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByUpdated", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByUpdatedby", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByIsactive", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByAutomaticReceipt", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.automaticReceipt = :automaticReceipt"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByAutomaticPayment", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.automaticPayment = :automaticPayment"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByAutomaticDeposit", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.automaticDeposit = :automaticDeposit"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByAutomaticWithdrawn", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.automaticWithdrawn = :automaticWithdrawn"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByPayinAllow", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.payinAllow = :payinAllow"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByPayoutAllow", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.payoutAllow = :payoutAllow"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByPayinExecutionType", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.payinExecutionType = :payinExecutionType"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByPayoutExecutionType", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.payoutExecutionType = :payoutExecutionType"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByPayinDeferred", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.payinDeferred = :payinDeferred"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByPayoutDeferred", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.payoutDeferred = :payoutDeferred"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByUponreceiptuse", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.uponreceiptuse = :uponreceiptuse"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByUpondeposituse", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.upondeposituse = :upondeposituse"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByInuponclearinguse", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.inuponclearinguse = :inuponclearinguse"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByUponpaymentuse", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.uponpaymentuse = :uponpaymentuse"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByUponwithdrawaluse", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.uponwithdrawaluse = :uponwithdrawaluse"),
    @NamedQuery(name = "FinFinaccPaymentmethod.findByOutuponclearinguse", query = "SELECT f FROM FinFinaccPaymentmethod f WHERE f.outuponclearinguse = :outuponclearinguse")})
public class FinFinaccPaymentmethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_finacc_paymentmethod_id")
    private String finFinaccPaymentmethodId;
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
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "automatic_receipt")
    private Character automaticReceipt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "automatic_payment")
    private Character automaticPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "automatic_deposit")
    private Character automaticDeposit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "automatic_withdrawn")
    private Character automaticWithdrawn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payin_allow")
    private Character payinAllow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payout_allow")
    private Character payoutAllow;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "payin_execution_type")
    private String payinExecutionType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "payout_execution_type")
    private String payoutExecutionType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payin_deferred")
    private Character payinDeferred;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payout_deferred")
    private Character payoutDeferred;
    @Size(max = 60)
    @Column(name = "uponreceiptuse")
    private String uponreceiptuse;
    @Size(max = 60)
    @Column(name = "upondeposituse")
    private String upondeposituse;
    @Size(max = 60)
    @Column(name = "inuponclearinguse")
    private String inuponclearinguse;
    @Size(max = 60)
    @Column(name = "uponpaymentuse")
    private String uponpaymentuse;
    @Size(max = 60)
    @Column(name = "uponwithdrawaluse")
    private String uponwithdrawaluse;
    @Size(max = 60)
    @Column(name = "outuponclearinguse")
    private String outuponclearinguse;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "fin_financial_account_id", referencedColumnName = "fin_financial_account_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinFinancialAccount finFinancialAccountId;
    @JoinColumn(name = "payout_execution_process_id", referencedColumnName = "fin_pay_exec_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPayExecProcess payoutExecutionProcessId;
    @JoinColumn(name = "payin_execution_process_id", referencedColumnName = "fin_pay_exec_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPayExecProcess payinExecutionProcessId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPaymentmethod finPaymentmethodId;

    public FinFinaccPaymentmethod() {
    }

    public FinFinaccPaymentmethod(String finFinaccPaymentmethodId) {
        this.finFinaccPaymentmethodId = finFinaccPaymentmethodId;
    }

    public FinFinaccPaymentmethod(String finFinaccPaymentmethodId, Date created, String createdby, Date updated, String updatedby, Character isactive, Character automaticReceipt, Character automaticPayment, Character automaticDeposit, Character automaticWithdrawn, Character payinAllow, Character payoutAllow, String payinExecutionType, String payoutExecutionType, Character payinDeferred, Character payoutDeferred) {
        this.finFinaccPaymentmethodId = finFinaccPaymentmethodId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.automaticReceipt = automaticReceipt;
        this.automaticPayment = automaticPayment;
        this.automaticDeposit = automaticDeposit;
        this.automaticWithdrawn = automaticWithdrawn;
        this.payinAllow = payinAllow;
        this.payoutAllow = payoutAllow;
        this.payinExecutionType = payinExecutionType;
        this.payoutExecutionType = payoutExecutionType;
        this.payinDeferred = payinDeferred;
        this.payoutDeferred = payoutDeferred;
    }

    public String getFinFinaccPaymentmethodId() {
        return finFinaccPaymentmethodId;
    }

    public void setFinFinaccPaymentmethodId(String finFinaccPaymentmethodId) {
        this.finFinaccPaymentmethodId = finFinaccPaymentmethodId;
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

    public Character getAutomaticReceipt() {
        return automaticReceipt;
    }

    public void setAutomaticReceipt(Character automaticReceipt) {
        this.automaticReceipt = automaticReceipt;
    }

    public Character getAutomaticPayment() {
        return automaticPayment;
    }

    public void setAutomaticPayment(Character automaticPayment) {
        this.automaticPayment = automaticPayment;
    }

    public Character getAutomaticDeposit() {
        return automaticDeposit;
    }

    public void setAutomaticDeposit(Character automaticDeposit) {
        this.automaticDeposit = automaticDeposit;
    }

    public Character getAutomaticWithdrawn() {
        return automaticWithdrawn;
    }

    public void setAutomaticWithdrawn(Character automaticWithdrawn) {
        this.automaticWithdrawn = automaticWithdrawn;
    }

    public Character getPayinAllow() {
        return payinAllow;
    }

    public void setPayinAllow(Character payinAllow) {
        this.payinAllow = payinAllow;
    }

    public Character getPayoutAllow() {
        return payoutAllow;
    }

    public void setPayoutAllow(Character payoutAllow) {
        this.payoutAllow = payoutAllow;
    }

    public String getPayinExecutionType() {
        return payinExecutionType;
    }

    public void setPayinExecutionType(String payinExecutionType) {
        this.payinExecutionType = payinExecutionType;
    }

    public String getPayoutExecutionType() {
        return payoutExecutionType;
    }

    public void setPayoutExecutionType(String payoutExecutionType) {
        this.payoutExecutionType = payoutExecutionType;
    }

    public Character getPayinDeferred() {
        return payinDeferred;
    }

    public void setPayinDeferred(Character payinDeferred) {
        this.payinDeferred = payinDeferred;
    }

    public Character getPayoutDeferred() {
        return payoutDeferred;
    }

    public void setPayoutDeferred(Character payoutDeferred) {
        this.payoutDeferred = payoutDeferred;
    }

    public String getUponreceiptuse() {
        return uponreceiptuse;
    }

    public void setUponreceiptuse(String uponreceiptuse) {
        this.uponreceiptuse = uponreceiptuse;
    }

    public String getUpondeposituse() {
        return upondeposituse;
    }

    public void setUpondeposituse(String upondeposituse) {
        this.upondeposituse = upondeposituse;
    }

    public String getInuponclearinguse() {
        return inuponclearinguse;
    }

    public void setInuponclearinguse(String inuponclearinguse) {
        this.inuponclearinguse = inuponclearinguse;
    }

    public String getUponpaymentuse() {
        return uponpaymentuse;
    }

    public void setUponpaymentuse(String uponpaymentuse) {
        this.uponpaymentuse = uponpaymentuse;
    }

    public String getUponwithdrawaluse() {
        return uponwithdrawaluse;
    }

    public void setUponwithdrawaluse(String uponwithdrawaluse) {
        this.uponwithdrawaluse = uponwithdrawaluse;
    }

    public String getOutuponclearinguse() {
        return outuponclearinguse;
    }

    public void setOutuponclearinguse(String outuponclearinguse) {
        this.outuponclearinguse = outuponclearinguse;
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

    public FinFinancialAccount getFinFinancialAccountId() {
        return finFinancialAccountId;
    }

    public void setFinFinancialAccountId(FinFinancialAccount finFinancialAccountId) {
        this.finFinancialAccountId = finFinancialAccountId;
    }

    public FinPayExecProcess getPayoutExecutionProcessId() {
        return payoutExecutionProcessId;
    }

    public void setPayoutExecutionProcessId(FinPayExecProcess payoutExecutionProcessId) {
        this.payoutExecutionProcessId = payoutExecutionProcessId;
    }

    public FinPayExecProcess getPayinExecutionProcessId() {
        return payinExecutionProcessId;
    }

    public void setPayinExecutionProcessId(FinPayExecProcess payinExecutionProcessId) {
        this.payinExecutionProcessId = payinExecutionProcessId;
    }

    public FinPaymentmethod getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(FinPaymentmethod finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finFinaccPaymentmethodId != null ? finFinaccPaymentmethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinFinaccPaymentmethod)) {
            return false;
        }
        FinFinaccPaymentmethod other = (FinFinaccPaymentmethod) object;
        if ((this.finFinaccPaymentmethodId == null && other.finFinaccPaymentmethodId != null) || (this.finFinaccPaymentmethodId != null && !this.finFinaccPaymentmethodId.equals(other.finFinaccPaymentmethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinFinaccPaymentmethod[ finFinaccPaymentmethodId=" + finFinaccPaymentmethodId + " ]";
    }
    
}
