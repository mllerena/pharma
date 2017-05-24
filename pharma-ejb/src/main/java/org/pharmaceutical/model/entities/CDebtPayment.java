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
@Table(name = "c_debt_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CDebtPayment.findAll", query = "SELECT c FROM CDebtPayment c"),
    @NamedQuery(name = "CDebtPayment.findByCDebtPaymentId", query = "SELECT c FROM CDebtPayment c WHERE c.cDebtPaymentId = :cDebtPaymentId"),
    @NamedQuery(name = "CDebtPayment.findByIsactive", query = "SELECT c FROM CDebtPayment c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CDebtPayment.findByCreated", query = "SELECT c FROM CDebtPayment c WHERE c.created = :created"),
    @NamedQuery(name = "CDebtPayment.findByCreatedby", query = "SELECT c FROM CDebtPayment c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CDebtPayment.findByUpdated", query = "SELECT c FROM CDebtPayment c WHERE c.updated = :updated"),
    @NamedQuery(name = "CDebtPayment.findByUpdatedby", query = "SELECT c FROM CDebtPayment c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CDebtPayment.findByIsreceipt", query = "SELECT c FROM CDebtPayment c WHERE c.isreceipt = :isreceipt"),
    @NamedQuery(name = "CDebtPayment.findByDescription", query = "SELECT c FROM CDebtPayment c WHERE c.description = :description"),
    @NamedQuery(name = "CDebtPayment.findByPaymentrule", query = "SELECT c FROM CDebtPayment c WHERE c.paymentrule = :paymentrule"),
    @NamedQuery(name = "CDebtPayment.findByIspaid", query = "SELECT c FROM CDebtPayment c WHERE c.ispaid = :ispaid"),
    @NamedQuery(name = "CDebtPayment.findByAmount", query = "SELECT c FROM CDebtPayment c WHERE c.amount = :amount"),
    @NamedQuery(name = "CDebtPayment.findByWriteoffamt", query = "SELECT c FROM CDebtPayment c WHERE c.writeoffamt = :writeoffamt"),
    @NamedQuery(name = "CDebtPayment.findByDateplanned", query = "SELECT c FROM CDebtPayment c WHERE c.dateplanned = :dateplanned"),
    @NamedQuery(name = "CDebtPayment.findByIsmanual", query = "SELECT c FROM CDebtPayment c WHERE c.ismanual = :ismanual"),
    @NamedQuery(name = "CDebtPayment.findByIsvalid", query = "SELECT c FROM CDebtPayment c WHERE c.isvalid = :isvalid"),
    @NamedQuery(name = "CDebtPayment.findByChangesettlementcancel", query = "SELECT c FROM CDebtPayment c WHERE c.changesettlementcancel = :changesettlementcancel"),
    @NamedQuery(name = "CDebtPayment.findByCancelProcessed", query = "SELECT c FROM CDebtPayment c WHERE c.cancelProcessed = :cancelProcessed"),
    @NamedQuery(name = "CDebtPayment.findByGenerateProcessed", query = "SELECT c FROM CDebtPayment c WHERE c.generateProcessed = :generateProcessed"),
    @NamedQuery(name = "CDebtPayment.findByGlitemamt", query = "SELECT c FROM CDebtPayment c WHERE c.glitemamt = :glitemamt"),
    @NamedQuery(name = "CDebtPayment.findByIsdirectposting", query = "SELECT c FROM CDebtPayment c WHERE c.isdirectposting = :isdirectposting"),
    @NamedQuery(name = "CDebtPayment.findByIsautomaticgenerated", query = "SELECT c FROM CDebtPayment c WHERE c.isautomaticgenerated = :isautomaticgenerated"),
    @NamedQuery(name = "CDebtPayment.findByStatus", query = "SELECT c FROM CDebtPayment c WHERE c.status = :status"),
    @NamedQuery(name = "CDebtPayment.findByStatusInitial", query = "SELECT c FROM CDebtPayment c WHERE c.statusInitial = :statusInitial"),
    @NamedQuery(name = "CDebtPayment.findByWithholdingamount", query = "SELECT c FROM CDebtPayment c WHERE c.withholdingamount = :withholdingamount")})
public class CDebtPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_debt_payment_id")
    private String cDebtPaymentId;
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
    @Column(name = "isreceipt")
    private Character isreceipt;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "paymentrule")
    private String paymentrule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispaid")
    private Character ispaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigInteger amount;
    @Column(name = "writeoffamt")
    private BigInteger writeoffamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateplanned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateplanned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ismanual")
    private Character ismanual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isvalid")
    private Character isvalid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "changesettlementcancel")
    private Character changesettlementcancel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancel_processed")
    private Character cancelProcessed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "generate_processed")
    private Character generateProcessed;
    @Column(name = "glitemamt")
    private BigInteger glitemamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdirectposting")
    private Character isdirectposting;
    @Column(name = "isautomaticgenerated")
    private Character isautomaticgenerated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "status")
    private String status;
    @Size(max = 60)
    @Column(name = "status_initial")
    private String statusInitial;
    @Column(name = "withholdingamount")
    private BigInteger withholdingamount;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentId")
    private List<IBankstatement> iBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentId")
    private List<CBankstatementline> cBankstatementlineList;
    @OneToOne(mappedBy = "cDebtPaymentId")
    private CCashline cCashline;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDebtPaymentId")
    private List<CDebtPaymentBalReplace> cDebtPaymentBalReplaceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDebtPaymentId")
    private List<CDebtPaymentBalancing> cDebtPaymentBalancingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentId")
    private List<CRemittanceline> cRemittancelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentCancelled")
    private List<CRemittanceline> cRemittancelineList1;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankaccount cBankaccountId;
    @JoinColumn(name = "c_bankstatementline_id", referencedColumnName = "c_bankstatementline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankstatementline cBankstatementlineId;
    @JoinColumn(name = "c_withholding_id", referencedColumnName = "c_withholding_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CWithholding cWithholdingId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "c_settlement_cancel_id", referencedColumnName = "c_settlement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSettlement cSettlementCancelId;
    @JoinColumn(name = "c_cashbook_id", referencedColumnName = "c_cashbook_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCashbook cCashbookId;
    @JoinColumn(name = "c_cashline_id", referencedColumnName = "c_cashline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCashline cCashlineId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_settlement_generate_id", referencedColumnName = "c_settlement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSettlement cSettlementGenerateId;
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGlitem cGlitemId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentId")
    private List<CDpManagementline> cDpManagementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDebtPaymentId")
    private List<RRequestaction> rRequestactionList;

    public CDebtPayment() {
    }

    public CDebtPayment(String cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
    }

    public CDebtPayment(String cDebtPaymentId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isreceipt, String paymentrule, Character ispaid, BigInteger amount, Date dateplanned, Character ismanual, Character isvalid, Character changesettlementcancel, Character cancelProcessed, Character generateProcessed, Character isdirectposting, String status) {
        this.cDebtPaymentId = cDebtPaymentId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isreceipt = isreceipt;
        this.paymentrule = paymentrule;
        this.ispaid = ispaid;
        this.amount = amount;
        this.dateplanned = dateplanned;
        this.ismanual = ismanual;
        this.isvalid = isvalid;
        this.changesettlementcancel = changesettlementcancel;
        this.cancelProcessed = cancelProcessed;
        this.generateProcessed = generateProcessed;
        this.isdirectposting = isdirectposting;
        this.status = status;
    }

    public String getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(String cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
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

    public Character getIsreceipt() {
        return isreceipt;
    }

    public void setIsreceipt(Character isreceipt) {
        this.isreceipt = isreceipt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentrule() {
        return paymentrule;
    }

    public void setPaymentrule(String paymentrule) {
        this.paymentrule = paymentrule;
    }

    public Character getIspaid() {
        return ispaid;
    }

    public void setIspaid(Character ispaid) {
        this.ispaid = ispaid;
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

    public Date getDateplanned() {
        return dateplanned;
    }

    public void setDateplanned(Date dateplanned) {
        this.dateplanned = dateplanned;
    }

    public Character getIsmanual() {
        return ismanual;
    }

    public void setIsmanual(Character ismanual) {
        this.ismanual = ismanual;
    }

    public Character getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Character isvalid) {
        this.isvalid = isvalid;
    }

    public Character getChangesettlementcancel() {
        return changesettlementcancel;
    }

    public void setChangesettlementcancel(Character changesettlementcancel) {
        this.changesettlementcancel = changesettlementcancel;
    }

    public Character getCancelProcessed() {
        return cancelProcessed;
    }

    public void setCancelProcessed(Character cancelProcessed) {
        this.cancelProcessed = cancelProcessed;
    }

    public Character getGenerateProcessed() {
        return generateProcessed;
    }

    public void setGenerateProcessed(Character generateProcessed) {
        this.generateProcessed = generateProcessed;
    }

    public BigInteger getGlitemamt() {
        return glitemamt;
    }

    public void setGlitemamt(BigInteger glitemamt) {
        this.glitemamt = glitemamt;
    }

    public Character getIsdirectposting() {
        return isdirectposting;
    }

    public void setIsdirectposting(Character isdirectposting) {
        this.isdirectposting = isdirectposting;
    }

    public Character getIsautomaticgenerated() {
        return isautomaticgenerated;
    }

    public void setIsautomaticgenerated(Character isautomaticgenerated) {
        this.isautomaticgenerated = isautomaticgenerated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusInitial() {
        return statusInitial;
    }

    public void setStatusInitial(String statusInitial) {
        this.statusInitial = statusInitial;
    }

    public BigInteger getWithholdingamount() {
        return withholdingamount;
    }

    public void setWithholdingamount(BigInteger withholdingamount) {
        this.withholdingamount = withholdingamount;
    }

    @XmlTransient
    public List<IBankstatement> getIBankstatementList() {
        return iBankstatementList;
    }

    public void setIBankstatementList(List<IBankstatement> iBankstatementList) {
        this.iBankstatementList = iBankstatementList;
    }

    @XmlTransient
    public List<AdTest> getAdTestList() {
        return adTestList;
    }

    public void setAdTestList(List<AdTest> adTestList) {
        this.adTestList = adTestList;
    }

    @XmlTransient
    public List<CBankstatementline> getCBankstatementlineList() {
        return cBankstatementlineList;
    }

    public void setCBankstatementlineList(List<CBankstatementline> cBankstatementlineList) {
        this.cBankstatementlineList = cBankstatementlineList;
    }

    public CCashline getCCashline() {
        return cCashline;
    }

    public void setCCashline(CCashline cCashline) {
        this.cCashline = cCashline;
    }

    @XmlTransient
    public List<CDebtPaymentBalReplace> getCDebtPaymentBalReplaceList() {
        return cDebtPaymentBalReplaceList;
    }

    public void setCDebtPaymentBalReplaceList(List<CDebtPaymentBalReplace> cDebtPaymentBalReplaceList) {
        this.cDebtPaymentBalReplaceList = cDebtPaymentBalReplaceList;
    }

    @XmlTransient
    public List<CDebtPaymentBalancing> getCDebtPaymentBalancingList() {
        return cDebtPaymentBalancingList;
    }

    public void setCDebtPaymentBalancingList(List<CDebtPaymentBalancing> cDebtPaymentBalancingList) {
        this.cDebtPaymentBalancingList = cDebtPaymentBalancingList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<CRemittanceline> getCRemittancelineList() {
        return cRemittancelineList;
    }

    public void setCRemittancelineList(List<CRemittanceline> cRemittancelineList) {
        this.cRemittancelineList = cRemittancelineList;
    }

    @XmlTransient
    public List<CRemittanceline> getCRemittancelineList1() {
        return cRemittancelineList1;
    }

    public void setCRemittancelineList1(List<CRemittanceline> cRemittancelineList1) {
        this.cRemittancelineList1 = cRemittancelineList1;
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

    public CBankaccount getCBankaccountId() {
        return cBankaccountId;
    }

    public void setCBankaccountId(CBankaccount cBankaccountId) {
        this.cBankaccountId = cBankaccountId;
    }

    public CBankstatementline getCBankstatementlineId() {
        return cBankstatementlineId;
    }

    public void setCBankstatementlineId(CBankstatementline cBankstatementlineId) {
        this.cBankstatementlineId = cBankstatementlineId;
    }

    public CWithholding getCWithholdingId() {
        return cWithholdingId;
    }

    public void setCWithholdingId(CWithholding cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public CSettlement getCSettlementCancelId() {
        return cSettlementCancelId;
    }

    public void setCSettlementCancelId(CSettlement cSettlementCancelId) {
        this.cSettlementCancelId = cSettlementCancelId;
    }

    public CCashbook getCCashbookId() {
        return cCashbookId;
    }

    public void setCCashbookId(CCashbook cCashbookId) {
        this.cCashbookId = cCashbookId;
    }

    public CCashline getCCashlineId() {
        return cCashlineId;
    }

    public void setCCashlineId(CCashline cCashlineId) {
        this.cCashlineId = cCashlineId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CSettlement getCSettlementGenerateId() {
        return cSettlementGenerateId;
    }

    public void setCSettlementGenerateId(CSettlement cSettlementGenerateId) {
        this.cSettlementGenerateId = cSettlementGenerateId;
    }

    public CGlitem getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(CGlitem cGlitemId) {
        this.cGlitemId = cGlitemId;
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

    @XmlTransient
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
    }

    @XmlTransient
    public List<CDpManagementline> getCDpManagementlineList() {
        return cDpManagementlineList;
    }

    public void setCDpManagementlineList(List<CDpManagementline> cDpManagementlineList) {
        this.cDpManagementlineList = cDpManagementlineList;
    }

    @XmlTransient
    public List<RRequestaction> getRRequestactionList() {
        return rRequestactionList;
    }

    public void setRRequestactionList(List<RRequestaction> rRequestactionList) {
        this.rRequestactionList = rRequestactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDebtPaymentId != null ? cDebtPaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDebtPayment)) {
            return false;
        }
        CDebtPayment other = (CDebtPayment) object;
        if ((this.cDebtPaymentId == null && other.cDebtPaymentId != null) || (this.cDebtPaymentId != null && !this.cDebtPaymentId.equals(other.cDebtPaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CDebtPayment[ cDebtPaymentId=" + cDebtPaymentId + " ]";
    }
    
}
