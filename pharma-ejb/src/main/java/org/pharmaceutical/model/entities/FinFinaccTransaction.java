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
@Table(name = "fin_finacc_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinFinaccTransaction.findAll", query = "SELECT f FROM FinFinaccTransaction f"),
    @NamedQuery(name = "FinFinaccTransaction.findByFinFinaccTransactionId", query = "SELECT f FROM FinFinaccTransaction f WHERE f.finFinaccTransactionId = :finFinaccTransactionId"),
    @NamedQuery(name = "FinFinaccTransaction.findByCreated", query = "SELECT f FROM FinFinaccTransaction f WHERE f.created = :created"),
    @NamedQuery(name = "FinFinaccTransaction.findByCreatedby", query = "SELECT f FROM FinFinaccTransaction f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinFinaccTransaction.findByUpdated", query = "SELECT f FROM FinFinaccTransaction f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinFinaccTransaction.findByUpdatedby", query = "SELECT f FROM FinFinaccTransaction f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinFinaccTransaction.findByIsactive", query = "SELECT f FROM FinFinaccTransaction f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinFinaccTransaction.findByLine", query = "SELECT f FROM FinFinaccTransaction f WHERE f.line = :line"),
    @NamedQuery(name = "FinFinaccTransaction.findByDateacct", query = "SELECT f FROM FinFinaccTransaction f WHERE f.dateacct = :dateacct"),
    @NamedQuery(name = "FinFinaccTransaction.findByStatus", query = "SELECT f FROM FinFinaccTransaction f WHERE f.status = :status"),
    @NamedQuery(name = "FinFinaccTransaction.findByPaymentamt", query = "SELECT f FROM FinFinaccTransaction f WHERE f.paymentamt = :paymentamt"),
    @NamedQuery(name = "FinFinaccTransaction.findByDepositamt", query = "SELECT f FROM FinFinaccTransaction f WHERE f.depositamt = :depositamt"),
    @NamedQuery(name = "FinFinaccTransaction.findByProcessed", query = "SELECT f FROM FinFinaccTransaction f WHERE f.processed = :processed"),
    @NamedQuery(name = "FinFinaccTransaction.findByProcessing", query = "SELECT f FROM FinFinaccTransaction f WHERE f.processing = :processing"),
    @NamedQuery(name = "FinFinaccTransaction.findByPosted", query = "SELECT f FROM FinFinaccTransaction f WHERE f.posted = :posted"),
    @NamedQuery(name = "FinFinaccTransaction.findByUser1Id", query = "SELECT f FROM FinFinaccTransaction f WHERE f.user1Id = :user1Id"),
    @NamedQuery(name = "FinFinaccTransaction.findByUser2Id", query = "SELECT f FROM FinFinaccTransaction f WHERE f.user2Id = :user2Id"),
    @NamedQuery(name = "FinFinaccTransaction.findByTrxtype", query = "SELECT f FROM FinFinaccTransaction f WHERE f.trxtype = :trxtype"),
    @NamedQuery(name = "FinFinaccTransaction.findByStatementdate", query = "SELECT f FROM FinFinaccTransaction f WHERE f.statementdate = :statementdate"),
    @NamedQuery(name = "FinFinaccTransaction.findByDescription", query = "SELECT f FROM FinFinaccTransaction f WHERE f.description = :description"),
    @NamedQuery(name = "FinFinaccTransaction.findByCreatedbyalgorithm", query = "SELECT f FROM FinFinaccTransaction f WHERE f.createdbyalgorithm = :createdbyalgorithm")})
public class FinFinaccTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_finacc_transaction_id")
    private String finFinaccTransactionId;
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
    @Column(name = "line")
    private long line;
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paymentamt")
    private BigInteger paymentamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depositamt")
    private BigInteger depositamt;
    @Column(name = "processed")
    private Character processed;
    @Column(name = "processing")
    private Character processing;
    @Size(max = 60)
    @Column(name = "posted")
    private String posted;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Size(max = 60)
    @Column(name = "trxtype")
    private String trxtype;
    @Column(name = "statementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statementdate;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdbyalgorithm")
    private Character createdbyalgorithm;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finFinaccTransactionId")
    private List<FinBankstatementline> finBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finFinaccTransactionId")
    private List<FinReclineTemp> finReclineTempList;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "fin_reconciliation_id", referencedColumnName = "fin_reconciliation_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinReconciliation finReconciliationId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGlitem cGlitemId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "fin_financial_account_id", referencedColumnName = "fin_financial_account_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinFinancialAccount finFinancialAccountId;
    @JoinColumn(name = "fin_payment_id", referencedColumnName = "fin_payment_id")
    @OneToOne
    private FinPayment finPaymentId;

    public FinFinaccTransaction() {
    }

    public FinFinaccTransaction(String finFinaccTransactionId) {
        this.finFinaccTransactionId = finFinaccTransactionId;
    }

    public FinFinaccTransaction(String finFinaccTransactionId, Date created, String createdby, Date updated, String updatedby, long line, String status, BigInteger paymentamt, BigInteger depositamt, Character createdbyalgorithm) {
        this.finFinaccTransactionId = finFinaccTransactionId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.status = status;
        this.paymentamt = paymentamt;
        this.depositamt = depositamt;
        this.createdbyalgorithm = createdbyalgorithm;
    }

    public String getFinFinaccTransactionId() {
        return finFinaccTransactionId;
    }

    public void setFinFinaccTransactionId(String finFinaccTransactionId) {
        this.finFinaccTransactionId = finFinaccTransactionId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getPaymentamt() {
        return paymentamt;
    }

    public void setPaymentamt(BigInteger paymentamt) {
        this.paymentamt = paymentamt;
    }

    public BigInteger getDepositamt() {
        return depositamt;
    }

    public void setDepositamt(BigInteger depositamt) {
        this.depositamt = depositamt;
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

    public String getTrxtype() {
        return trxtype;
    }

    public void setTrxtype(String trxtype) {
        this.trxtype = trxtype;
    }

    public Date getStatementdate() {
        return statementdate;
    }

    public void setStatementdate(Date statementdate) {
        this.statementdate = statementdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getCreatedbyalgorithm() {
        return createdbyalgorithm;
    }

    public void setCreatedbyalgorithm(Character createdbyalgorithm) {
        this.createdbyalgorithm = createdbyalgorithm;
    }

    @XmlTransient
    public List<FinBankstatementline> getFinBankstatementlineList() {
        return finBankstatementlineList;
    }

    public void setFinBankstatementlineList(List<FinBankstatementline> finBankstatementlineList) {
        this.finBankstatementlineList = finBankstatementlineList;
    }

    @XmlTransient
    public List<FinReclineTemp> getFinReclineTempList() {
        return finReclineTempList;
    }

    public void setFinReclineTempList(List<FinReclineTemp> finReclineTempList) {
        this.finReclineTempList = finReclineTempList;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public FinReconciliation getFinReconciliationId() {
        return finReconciliationId;
    }

    public void setFinReconciliationId(FinReconciliation finReconciliationId) {
        this.finReconciliationId = finReconciliationId;
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

    public CGlitem getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(CGlitem cGlitemId) {
        this.cGlitemId = cGlitemId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CSalesregion getCSalesregionId() {
        return cSalesregionId;
    }

    public void setCSalesregionId(CSalesregion cSalesregionId) {
        this.cSalesregionId = cSalesregionId;
    }

    public FinFinancialAccount getFinFinancialAccountId() {
        return finFinancialAccountId;
    }

    public void setFinFinancialAccountId(FinFinancialAccount finFinancialAccountId) {
        this.finFinancialAccountId = finFinancialAccountId;
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
        hash += (finFinaccTransactionId != null ? finFinaccTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinFinaccTransaction)) {
            return false;
        }
        FinFinaccTransaction other = (FinFinaccTransaction) object;
        if ((this.finFinaccTransactionId == null && other.finFinaccTransactionId != null) || (this.finFinaccTransactionId != null && !this.finFinaccTransactionId.equals(other.finFinaccTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinFinaccTransaction[ finFinaccTransactionId=" + finFinaccTransactionId + " ]";
    }
    
}
