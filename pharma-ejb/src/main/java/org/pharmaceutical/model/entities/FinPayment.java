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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "fin_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPayment.findAll", query = "SELECT f FROM FinPayment f"),
    @NamedQuery(name = "FinPayment.findByFinPaymentId", query = "SELECT f FROM FinPayment f WHERE f.finPaymentId = :finPaymentId"),
    @NamedQuery(name = "FinPayment.findByCreated", query = "SELECT f FROM FinPayment f WHERE f.created = :created"),
    @NamedQuery(name = "FinPayment.findByCreatedby", query = "SELECT f FROM FinPayment f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPayment.findByUpdated", query = "SELECT f FROM FinPayment f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPayment.findByUpdatedby", query = "SELECT f FROM FinPayment f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPayment.findByIsactive", query = "SELECT f FROM FinPayment f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPayment.findByIsreceipt", query = "SELECT f FROM FinPayment f WHERE f.isreceipt = :isreceipt"),
    @NamedQuery(name = "FinPayment.findByPaymentdate", query = "SELECT f FROM FinPayment f WHERE f.paymentdate = :paymentdate"),
    @NamedQuery(name = "FinPayment.findByAmount", query = "SELECT f FROM FinPayment f WHERE f.amount = :amount"),
    @NamedQuery(name = "FinPayment.findByWriteoffamt", query = "SELECT f FROM FinPayment f WHERE f.writeoffamt = :writeoffamt"),
    @NamedQuery(name = "FinPayment.findByDocumentno", query = "SELECT f FROM FinPayment f WHERE f.documentno = :documentno"),
    @NamedQuery(name = "FinPayment.findByReferenceno", query = "SELECT f FROM FinPayment f WHERE f.referenceno = :referenceno"),
    @NamedQuery(name = "FinPayment.findByStatus", query = "SELECT f FROM FinPayment f WHERE f.status = :status"),
    @NamedQuery(name = "FinPayment.findByProcessed", query = "SELECT f FROM FinPayment f WHERE f.processed = :processed"),
    @NamedQuery(name = "FinPayment.findByProcessing", query = "SELECT f FROM FinPayment f WHERE f.processing = :processing"),
    @NamedQuery(name = "FinPayment.findByPosted", query = "SELECT f FROM FinPayment f WHERE f.posted = :posted"),
    @NamedQuery(name = "FinPayment.findByDescription", query = "SELECT f FROM FinPayment f WHERE f.description = :description"),
    @NamedQuery(name = "FinPayment.findByUser1Id", query = "SELECT f FROM FinPayment f WHERE f.user1Id = :user1Id"),
    @NamedQuery(name = "FinPayment.findByUser2Id", query = "SELECT f FROM FinPayment f WHERE f.user2Id = :user2Id"),
    @NamedQuery(name = "FinPayment.findByGeneratedCredit", query = "SELECT f FROM FinPayment f WHERE f.generatedCredit = :generatedCredit"),
    @NamedQuery(name = "FinPayment.findByUsedCredit", query = "SELECT f FROM FinPayment f WHERE f.usedCredit = :usedCredit"),
    @NamedQuery(name = "FinPayment.findByCreatedbyalgorithm", query = "SELECT f FROM FinPayment f WHERE f.createdbyalgorithm = :createdbyalgorithm")})
public class FinPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_id")
    private String finPaymentId;
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
    @Column(name = "isreceipt")
    private Character isreceipt;
    @Column(name = "paymentdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigInteger amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "writeoffamt")
    private BigInteger writeoffamt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Size(max = 40)
    @Column(name = "referenceno")
    private String referenceno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Column(name = "generated_credit")
    private BigInteger generatedCredit;
    @Column(name = "used_credit")
    private BigInteger usedCredit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdbyalgorithm")
    private Character createdbyalgorithm;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentIdUsed")
    private List<FinPaymentCredit> finPaymentCreditList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentId")
    private List<FinPaymentCredit> finPaymentCreditList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentId")
    private List<CTaxpayment> cTaxpaymentList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "fin_financial_account_id", referencedColumnName = "fin_financial_account_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinFinancialAccount finFinancialAccountId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPaymentmethod finPaymentmethodId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentId")
    private List<FinReclineTemp> finReclineTempList;
    @OneToOne(mappedBy = "finPaymentId")
    private FinFinaccTransaction finFinaccTransaction;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentId")
    private List<FinPaymentRunPayment> finPaymentRunPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentId")
    private List<FinPaymentDetail> finPaymentDetailList;

    public FinPayment() {
    }

    public FinPayment(String finPaymentId) {
        this.finPaymentId = finPaymentId;
    }

    public FinPayment(String finPaymentId, Date created, String createdby, Date updated, String updatedby, BigInteger amount, BigInteger writeoffamt, String documentno, String status, Character processed, Character processing, String posted, Character createdbyalgorithm) {
        this.finPaymentId = finPaymentId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.amount = amount;
        this.writeoffamt = writeoffamt;
        this.documentno = documentno;
        this.status = status;
        this.processed = processed;
        this.processing = processing;
        this.posted = posted;
        this.createdbyalgorithm = createdbyalgorithm;
    }

    public String getFinPaymentId() {
        return finPaymentId;
    }

    public void setFinPaymentId(String finPaymentId) {
        this.finPaymentId = finPaymentId;
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

    public Character getIsreceipt() {
        return isreceipt;
    }

    public void setIsreceipt(Character isreceipt) {
        this.isreceipt = isreceipt;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getWriteoffamt() {
        return writeoffamt;
    }

    public void setWriteoffamt(BigInteger writeoffamt) {
        this.writeoffamt = writeoffamt;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public String getReferenceno() {
        return referenceno;
    }

    public void setReferenceno(String referenceno) {
        this.referenceno = referenceno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public BigInteger getGeneratedCredit() {
        return generatedCredit;
    }

    public void setGeneratedCredit(BigInteger generatedCredit) {
        this.generatedCredit = generatedCredit;
    }

    public BigInteger getUsedCredit() {
        return usedCredit;
    }

    public void setUsedCredit(BigInteger usedCredit) {
        this.usedCredit = usedCredit;
    }

    public Character getCreatedbyalgorithm() {
        return createdbyalgorithm;
    }

    public void setCreatedbyalgorithm(Character createdbyalgorithm) {
        this.createdbyalgorithm = createdbyalgorithm;
    }

    @XmlTransient
    public List<FinPaymentCredit> getFinPaymentCreditList() {
        return finPaymentCreditList;
    }

    public void setFinPaymentCreditList(List<FinPaymentCredit> finPaymentCreditList) {
        this.finPaymentCreditList = finPaymentCreditList;
    }

    @XmlTransient
    public List<FinPaymentCredit> getFinPaymentCreditList1() {
        return finPaymentCreditList1;
    }

    public void setFinPaymentCreditList1(List<FinPaymentCredit> finPaymentCreditList1) {
        this.finPaymentCreditList1 = finPaymentCreditList1;
    }

    @XmlTransient
    public List<CTaxpayment> getCTaxpaymentList() {
        return cTaxpaymentList;
    }

    public void setCTaxpaymentList(List<CTaxpayment> cTaxpaymentList) {
        this.cTaxpaymentList = cTaxpaymentList;
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

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public FinFinancialAccount getFinFinancialAccountId() {
        return finFinancialAccountId;
    }

    public void setFinFinancialAccountId(FinFinancialAccount finFinancialAccountId) {
        this.finFinancialAccountId = finFinancialAccountId;
    }

    public FinPaymentmethod getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(FinPaymentmethod finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    @XmlTransient
    public List<FinReclineTemp> getFinReclineTempList() {
        return finReclineTempList;
    }

    public void setFinReclineTempList(List<FinReclineTemp> finReclineTempList) {
        this.finReclineTempList = finReclineTempList;
    }

    public FinFinaccTransaction getFinFinaccTransaction() {
        return finFinaccTransaction;
    }

    public void setFinFinaccTransaction(FinFinaccTransaction finFinaccTransaction) {
        this.finFinaccTransaction = finFinaccTransaction;
    }

    @XmlTransient
    public List<FinPaymentRunPayment> getFinPaymentRunPaymentList() {
        return finPaymentRunPaymentList;
    }

    public void setFinPaymentRunPaymentList(List<FinPaymentRunPayment> finPaymentRunPaymentList) {
        this.finPaymentRunPaymentList = finPaymentRunPaymentList;
    }

    @XmlTransient
    public List<FinPaymentDetail> getFinPaymentDetailList() {
        return finPaymentDetailList;
    }

    public void setFinPaymentDetailList(List<FinPaymentDetail> finPaymentDetailList) {
        this.finPaymentDetailList = finPaymentDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentId != null ? finPaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPayment)) {
            return false;
        }
        FinPayment other = (FinPayment) object;
        if ((this.finPaymentId == null && other.finPaymentId != null) || (this.finPaymentId != null && !this.finPaymentId.equals(other.finPaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPayment[ finPaymentId=" + finPaymentId + " ]";
    }
    
}
