/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "fin_payment_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentSchedule.findAll", query = "SELECT f FROM FinPaymentSchedule f"),
    @NamedQuery(name = "FinPaymentSchedule.findByFinPaymentScheduleId", query = "SELECT f FROM FinPaymentSchedule f WHERE f.finPaymentScheduleId = :finPaymentScheduleId"),
    @NamedQuery(name = "FinPaymentSchedule.findByCreated", query = "SELECT f FROM FinPaymentSchedule f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentSchedule.findByCreatedby", query = "SELECT f FROM FinPaymentSchedule f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentSchedule.findByUpdated", query = "SELECT f FROM FinPaymentSchedule f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentSchedule.findByUpdatedby", query = "SELECT f FROM FinPaymentSchedule f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentSchedule.findByDuedate", query = "SELECT f FROM FinPaymentSchedule f WHERE f.duedate = :duedate"),
    @NamedQuery(name = "FinPaymentSchedule.findByAmount", query = "SELECT f FROM FinPaymentSchedule f WHERE f.amount = :amount"),
    @NamedQuery(name = "FinPaymentSchedule.findByPaidamt", query = "SELECT f FROM FinPaymentSchedule f WHERE f.paidamt = :paidamt"),
    @NamedQuery(name = "FinPaymentSchedule.findByOutstandingamt", query = "SELECT f FROM FinPaymentSchedule f WHERE f.outstandingamt = :outstandingamt"),
    @NamedQuery(name = "FinPaymentSchedule.findByIsactive", query = "SELECT f FROM FinPaymentSchedule f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentSchedule.findByUpdatePaymentPlan", query = "SELECT f FROM FinPaymentSchedule f WHERE f.updatePaymentPlan = :updatePaymentPlan")})
public class FinPaymentSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_schedule_id")
    private String finPaymentScheduleId;
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
    @Column(name = "duedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigInteger amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paidamt")
    private BigInteger paidamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "outstandingamt")
    private BigInteger outstandingamt;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "update_payment_plan")
    private Character updatePaymentPlan;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentScheduleInvoice")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentScheduleOrder")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList1;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "fin_payment_priority_id", referencedColumnName = "fin_payment_priority_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentPriority finPaymentPriorityId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPaymentmethod finPaymentmethodId;

    public FinPaymentSchedule() {
    }

    public FinPaymentSchedule(String finPaymentScheduleId) {
        this.finPaymentScheduleId = finPaymentScheduleId;
    }

    public FinPaymentSchedule(String finPaymentScheduleId, Date created, String createdby, Date updated, String updatedby, BigInteger amount, BigInteger paidamt, BigInteger outstandingamt) {
        this.finPaymentScheduleId = finPaymentScheduleId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.amount = amount;
        this.paidamt = paidamt;
        this.outstandingamt = outstandingamt;
    }

    public String getFinPaymentScheduleId() {
        return finPaymentScheduleId;
    }

    public void setFinPaymentScheduleId(String finPaymentScheduleId) {
        this.finPaymentScheduleId = finPaymentScheduleId;
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

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getPaidamt() {
        return paidamt;
    }

    public void setPaidamt(BigInteger paidamt) {
        this.paidamt = paidamt;
    }

    public BigInteger getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(BigInteger outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public Character getUpdatePaymentPlan() {
        return updatePaymentPlan;
    }

    public void setUpdatePaymentPlan(Character updatePaymentPlan) {
        this.updatePaymentPlan = updatePaymentPlan;
    }

    @XmlTransient
    public List<FinPaymentScheduledetail> getFinPaymentScheduledetailList() {
        return finPaymentScheduledetailList;
    }

    public void setFinPaymentScheduledetailList(List<FinPaymentScheduledetail> finPaymentScheduledetailList) {
        this.finPaymentScheduledetailList = finPaymentScheduledetailList;
    }

    @XmlTransient
    public List<FinPaymentScheduledetail> getFinPaymentScheduledetailList1() {
        return finPaymentScheduledetailList1;
    }

    public void setFinPaymentScheduledetailList1(List<FinPaymentScheduledetail> finPaymentScheduledetailList1) {
        this.finPaymentScheduledetailList1 = finPaymentScheduledetailList1;
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

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public FinPaymentPriority getFinPaymentPriorityId() {
        return finPaymentPriorityId;
    }

    public void setFinPaymentPriorityId(FinPaymentPriority finPaymentPriorityId) {
        this.finPaymentPriorityId = finPaymentPriorityId;
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
        hash += (finPaymentScheduleId != null ? finPaymentScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentSchedule)) {
            return false;
        }
        FinPaymentSchedule other = (FinPaymentSchedule) object;
        if ((this.finPaymentScheduleId == null && other.finPaymentScheduleId != null) || (this.finPaymentScheduleId != null && !this.finPaymentScheduleId.equals(other.finPaymentScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentSchedule[ finPaymentScheduleId=" + finPaymentScheduleId + " ]";
    }
    
}
