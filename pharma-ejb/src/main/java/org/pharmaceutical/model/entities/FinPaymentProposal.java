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
@Table(name = "fin_payment_proposal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentProposal.findAll", query = "SELECT f FROM FinPaymentProposal f"),
    @NamedQuery(name = "FinPaymentProposal.findByFinPaymentProposalId", query = "SELECT f FROM FinPaymentProposal f WHERE f.finPaymentProposalId = :finPaymentProposalId"),
    @NamedQuery(name = "FinPaymentProposal.findByIsactive", query = "SELECT f FROM FinPaymentProposal f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentProposal.findByCreated", query = "SELECT f FROM FinPaymentProposal f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentProposal.findByCreatedby", query = "SELECT f FROM FinPaymentProposal f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentProposal.findByUpdated", query = "SELECT f FROM FinPaymentProposal f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentProposal.findByUpdatedby", query = "SELECT f FROM FinPaymentProposal f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentProposal.findByIsreceipt", query = "SELECT f FROM FinPaymentProposal f WHERE f.isreceipt = :isreceipt"),
    @NamedQuery(name = "FinPaymentProposal.findByDescription", query = "SELECT f FROM FinPaymentProposal f WHERE f.description = :description"),
    @NamedQuery(name = "FinPaymentProposal.findByPaymentdate", query = "SELECT f FROM FinPaymentProposal f WHERE f.paymentdate = :paymentdate"),
    @NamedQuery(name = "FinPaymentProposal.findByAmount", query = "SELECT f FROM FinPaymentProposal f WHERE f.amount = :amount"),
    @NamedQuery(name = "FinPaymentProposal.findByWriteoffamt", query = "SELECT f FROM FinPaymentProposal f WHERE f.writeoffamt = :writeoffamt"),
    @NamedQuery(name = "FinPaymentProposal.findByDocumentno", query = "SELECT f FROM FinPaymentProposal f WHERE f.documentno = :documentno"),
    @NamedQuery(name = "FinPaymentProposal.findByReferenceno", query = "SELECT f FROM FinPaymentProposal f WHERE f.referenceno = :referenceno"),
    @NamedQuery(name = "FinPaymentProposal.findByStatus", query = "SELECT f FROM FinPaymentProposal f WHERE f.status = :status"),
    @NamedQuery(name = "FinPaymentProposal.findByProcessed", query = "SELECT f FROM FinPaymentProposal f WHERE f.processed = :processed"),
    @NamedQuery(name = "FinPaymentProposal.findByProcessing", query = "SELECT f FROM FinPaymentProposal f WHERE f.processing = :processing"),
    @NamedQuery(name = "FinPaymentProposal.findByDuedate", query = "SELECT f FROM FinPaymentProposal f WHERE f.duedate = :duedate")})
public class FinPaymentProposal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_proposal_id")
    private String finPaymentProposalId;
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
    @Size(min = 1, max = 40)
    @Column(name = "documentno")
    private String documentno;
    @Size(max = 40)
    @Column(name = "referenceno")
    private String referenceno;
    @Size(max = 60)
    @Column(name = "status")
    private String status;
    @Column(name = "processed")
    private Character processed;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "duedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "fin_financial_account_id", referencedColumnName = "fin_financial_account_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinFinancialAccount finFinancialAccountId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPaymentmethod finPaymentmethodId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentProposalId")
    private List<FinPaymentPropDetail> finPaymentPropDetailList;

    public FinPaymentProposal() {
    }

    public FinPaymentProposal(String finPaymentProposalId) {
        this.finPaymentProposalId = finPaymentProposalId;
    }

    public FinPaymentProposal(String finPaymentProposalId, Date created, String createdby, Date updated, String updatedby, Character isreceipt, Date paymentdate, BigInteger amount, BigInteger writeoffamt, String documentno) {
        this.finPaymentProposalId = finPaymentProposalId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isreceipt = isreceipt;
        this.paymentdate = paymentdate;
        this.amount = amount;
        this.writeoffamt = writeoffamt;
        this.documentno = documentno;
    }

    public String getFinPaymentProposalId() {
        return finPaymentProposalId;
    }

    public void setFinPaymentProposalId(String finPaymentProposalId) {
        this.finPaymentProposalId = finPaymentProposalId;
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

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
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
    public List<FinPaymentPropDetail> getFinPaymentPropDetailList() {
        return finPaymentPropDetailList;
    }

    public void setFinPaymentPropDetailList(List<FinPaymentPropDetail> finPaymentPropDetailList) {
        this.finPaymentPropDetailList = finPaymentPropDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentProposalId != null ? finPaymentProposalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentProposal)) {
            return false;
        }
        FinPaymentProposal other = (FinPaymentProposal) object;
        if ((this.finPaymentProposalId == null && other.finPaymentProposalId != null) || (this.finPaymentProposalId != null && !this.finPaymentProposalId.equals(other.finPaymentProposalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentProposal[ finPaymentProposalId=" + finPaymentProposalId + " ]";
    }
    
}
