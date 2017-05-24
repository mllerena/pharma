/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "fin_paymentmethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentmethod.findAll", query = "SELECT f FROM FinPaymentmethod f"),
    @NamedQuery(name = "FinPaymentmethod.findByFinPaymentmethodId", query = "SELECT f FROM FinPaymentmethod f WHERE f.finPaymentmethodId = :finPaymentmethodId"),
    @NamedQuery(name = "FinPaymentmethod.findByCreated", query = "SELECT f FROM FinPaymentmethod f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentmethod.findByCreatedby", query = "SELECT f FROM FinPaymentmethod f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentmethod.findByUpdated", query = "SELECT f FROM FinPaymentmethod f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentmethod.findByUpdatedby", query = "SELECT f FROM FinPaymentmethod f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentmethod.findByIsactive", query = "SELECT f FROM FinPaymentmethod f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentmethod.findByName", query = "SELECT f FROM FinPaymentmethod f WHERE f.name = :name"),
    @NamedQuery(name = "FinPaymentmethod.findByDescription", query = "SELECT f FROM FinPaymentmethod f WHERE f.description = :description"),
    @NamedQuery(name = "FinPaymentmethod.findByAutomaticReceipt", query = "SELECT f FROM FinPaymentmethod f WHERE f.automaticReceipt = :automaticReceipt"),
    @NamedQuery(name = "FinPaymentmethod.findByAutomaticPayment", query = "SELECT f FROM FinPaymentmethod f WHERE f.automaticPayment = :automaticPayment"),
    @NamedQuery(name = "FinPaymentmethod.findByAutomaticDeposit", query = "SELECT f FROM FinPaymentmethod f WHERE f.automaticDeposit = :automaticDeposit"),
    @NamedQuery(name = "FinPaymentmethod.findByAutomaticWithdrawn", query = "SELECT f FROM FinPaymentmethod f WHERE f.automaticWithdrawn = :automaticWithdrawn"),
    @NamedQuery(name = "FinPaymentmethod.findByPayinAllow", query = "SELECT f FROM FinPaymentmethod f WHERE f.payinAllow = :payinAllow"),
    @NamedQuery(name = "FinPaymentmethod.findByPayoutAllow", query = "SELECT f FROM FinPaymentmethod f WHERE f.payoutAllow = :payoutAllow"),
    @NamedQuery(name = "FinPaymentmethod.findByPayinExecutionType", query = "SELECT f FROM FinPaymentmethod f WHERE f.payinExecutionType = :payinExecutionType"),
    @NamedQuery(name = "FinPaymentmethod.findByPayoutExecutionType", query = "SELECT f FROM FinPaymentmethod f WHERE f.payoutExecutionType = :payoutExecutionType"),
    @NamedQuery(name = "FinPaymentmethod.findByPayinDeferred", query = "SELECT f FROM FinPaymentmethod f WHERE f.payinDeferred = :payinDeferred"),
    @NamedQuery(name = "FinPaymentmethod.findByPayoutDeferred", query = "SELECT f FROM FinPaymentmethod f WHERE f.payoutDeferred = :payoutDeferred"),
    @NamedQuery(name = "FinPaymentmethod.findByUponreceiptuse", query = "SELECT f FROM FinPaymentmethod f WHERE f.uponreceiptuse = :uponreceiptuse"),
    @NamedQuery(name = "FinPaymentmethod.findByUpondeposituse", query = "SELECT f FROM FinPaymentmethod f WHERE f.upondeposituse = :upondeposituse"),
    @NamedQuery(name = "FinPaymentmethod.findByInuponclearinguse", query = "SELECT f FROM FinPaymentmethod f WHERE f.inuponclearinguse = :inuponclearinguse"),
    @NamedQuery(name = "FinPaymentmethod.findByUponpaymentuse", query = "SELECT f FROM FinPaymentmethod f WHERE f.uponpaymentuse = :uponpaymentuse"),
    @NamedQuery(name = "FinPaymentmethod.findByUponwithdrawaluse", query = "SELECT f FROM FinPaymentmethod f WHERE f.uponwithdrawaluse = :uponwithdrawaluse"),
    @NamedQuery(name = "FinPaymentmethod.findByOutuponclearinguse", query = "SELECT f FROM FinPaymentmethod f WHERE f.outuponclearinguse = :outuponclearinguse")})
public class FinPaymentmethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_paymentmethod_id")
    private String finPaymentmethodId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "poPaymentmethodId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentmethodId")
    private List<CBpartner> cBpartnerList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentmethodId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentmethodId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentmethodId")
    private List<FinFinaccPaymentmethod> finFinaccPaymentmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentmethodId")
    private List<CProjectproposal> cProjectproposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentmethodId")
    private List<FinPaymentSchedule> finPaymentScheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentmethodId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentmethodId")
    private List<CPaymenttermline> cPaymenttermlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentmethodId")
    private List<FinPaymentProposal> finPaymentProposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentmethodId")
    private List<CProject> cProjectList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "payout_execution_process_id", referencedColumnName = "fin_pay_exec_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPayExecProcess payoutExecutionProcessId;
    @JoinColumn(name = "payin_execution_process_id", referencedColumnName = "fin_pay_exec_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPayExecProcess payinExecutionProcessId;

    public FinPaymentmethod() {
    }

    public FinPaymentmethod(String finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    public FinPaymentmethod(String finPaymentmethodId, Date created, String createdby, Date updated, String updatedby, String name, Character automaticReceipt, Character automaticPayment, Character automaticDeposit, Character automaticWithdrawn, Character payinAllow, Character payoutAllow, String payinExecutionType, String payoutExecutionType, Character payinDeferred, Character payoutDeferred) {
        this.finPaymentmethodId = finPaymentmethodId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
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

    public String getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(String finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList1() {
        return cBpartnerList1;
    }

    public void setCBpartnerList1(List<CBpartner> cBpartnerList1) {
        this.cBpartnerList1 = cBpartnerList1;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<FinFinaccPaymentmethod> getFinFinaccPaymentmethodList() {
        return finFinaccPaymentmethodList;
    }

    public void setFinFinaccPaymentmethodList(List<FinFinaccPaymentmethod> finFinaccPaymentmethodList) {
        this.finFinaccPaymentmethodList = finFinaccPaymentmethodList;
    }

    @XmlTransient
    public List<CProjectproposal> getCProjectproposalList() {
        return cProjectproposalList;
    }

    public void setCProjectproposalList(List<CProjectproposal> cProjectproposalList) {
        this.cProjectproposalList = cProjectproposalList;
    }

    @XmlTransient
    public List<FinPaymentSchedule> getFinPaymentScheduleList() {
        return finPaymentScheduleList;
    }

    public void setFinPaymentScheduleList(List<FinPaymentSchedule> finPaymentScheduleList) {
        this.finPaymentScheduleList = finPaymentScheduleList;
    }

    @XmlTransient
    public List<FinPayment> getFinPaymentList() {
        return finPaymentList;
    }

    public void setFinPaymentList(List<FinPayment> finPaymentList) {
        this.finPaymentList = finPaymentList;
    }

    @XmlTransient
    public List<CPaymenttermline> getCPaymenttermlineList() {
        return cPaymenttermlineList;
    }

    public void setCPaymenttermlineList(List<CPaymenttermline> cPaymenttermlineList) {
        this.cPaymenttermlineList = cPaymenttermlineList;
    }

    @XmlTransient
    public List<FinPaymentProposal> getFinPaymentProposalList() {
        return finPaymentProposalList;
    }

    public void setFinPaymentProposalList(List<FinPaymentProposal> finPaymentProposalList) {
        this.finPaymentProposalList = finPaymentProposalList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentmethodId != null ? finPaymentmethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentmethod)) {
            return false;
        }
        FinPaymentmethod other = (FinPaymentmethod) object;
        if ((this.finPaymentmethodId == null && other.finPaymentmethodId != null) || (this.finPaymentmethodId != null && !this.finPaymentmethodId.equals(other.finPaymentmethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentmethod[ finPaymentmethodId=" + finPaymentmethodId + " ]";
    }
    
}
