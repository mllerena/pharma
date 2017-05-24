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
@Table(name = "fin_reconciliation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinReconciliation.findAll", query = "SELECT f FROM FinReconciliation f"),
    @NamedQuery(name = "FinReconciliation.findByFinReconciliationId", query = "SELECT f FROM FinReconciliation f WHERE f.finReconciliationId = :finReconciliationId"),
    @NamedQuery(name = "FinReconciliation.findByCreated", query = "SELECT f FROM FinReconciliation f WHERE f.created = :created"),
    @NamedQuery(name = "FinReconciliation.findByCreatedby", query = "SELECT f FROM FinReconciliation f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinReconciliation.findByUpdated", query = "SELECT f FROM FinReconciliation f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinReconciliation.findByUpdatedby", query = "SELECT f FROM FinReconciliation f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinReconciliation.findByIsactive", query = "SELECT f FROM FinReconciliation f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinReconciliation.findByDocumentno", query = "SELECT f FROM FinReconciliation f WHERE f.documentno = :documentno"),
    @NamedQuery(name = "FinReconciliation.findByDateto", query = "SELECT f FROM FinReconciliation f WHERE f.dateto = :dateto"),
    @NamedQuery(name = "FinReconciliation.findByStatementdate", query = "SELECT f FROM FinReconciliation f WHERE f.statementdate = :statementdate"),
    @NamedQuery(name = "FinReconciliation.findByEndingbalance", query = "SELECT f FROM FinReconciliation f WHERE f.endingbalance = :endingbalance"),
    @NamedQuery(name = "FinReconciliation.findByStartingbalance", query = "SELECT f FROM FinReconciliation f WHERE f.startingbalance = :startingbalance"),
    @NamedQuery(name = "FinReconciliation.findByDocstatus", query = "SELECT f FROM FinReconciliation f WHERE f.docstatus = :docstatus"),
    @NamedQuery(name = "FinReconciliation.findByProcessing", query = "SELECT f FROM FinReconciliation f WHERE f.processing = :processing"),
    @NamedQuery(name = "FinReconciliation.findByProcessed", query = "SELECT f FROM FinReconciliation f WHERE f.processed = :processed"),
    @NamedQuery(name = "FinReconciliation.findByPosted", query = "SELECT f FROM FinReconciliation f WHERE f.posted = :posted"),
    @NamedQuery(name = "FinReconciliation.findByPrintdetailed", query = "SELECT f FROM FinReconciliation f WHERE f.printdetailed = :printdetailed"),
    @NamedQuery(name = "FinReconciliation.findByPrintsummary", query = "SELECT f FROM FinReconciliation f WHERE f.printsummary = :printsummary")})
public class FinReconciliation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_reconciliation_id")
    private String finReconciliationId;
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
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statementdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endingbalance")
    private BigInteger endingbalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startingbalance")
    private BigInteger startingbalance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docstatus")
    private String docstatus;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "printdetailed")
    private Character printdetailed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "printsummary")
    private Character printsummary;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finReconciliationId")
    private List<FinReclineTemp> finReclineTempList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finReconciliationId")
    private List<FinBankstatement> finBankstatementList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "fin_financial_account_id", referencedColumnName = "fin_financial_account_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinFinancialAccount finFinancialAccountId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finReconciliationId")
    private List<FinFinaccTransaction> finFinaccTransactionList;

    public FinReconciliation() {
    }

    public FinReconciliation(String finReconciliationId) {
        this.finReconciliationId = finReconciliationId;
    }

    public FinReconciliation(String finReconciliationId, Date created, String createdby, Date updated, String updatedby, String documentno, Date dateto, Date statementdate, BigInteger endingbalance, BigInteger startingbalance, String docstatus, Character processed, String posted, Character printdetailed, Character printsummary) {
        this.finReconciliationId = finReconciliationId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.dateto = dateto;
        this.statementdate = statementdate;
        this.endingbalance = endingbalance;
        this.startingbalance = startingbalance;
        this.docstatus = docstatus;
        this.processed = processed;
        this.posted = posted;
        this.printdetailed = printdetailed;
        this.printsummary = printsummary;
    }

    public String getFinReconciliationId() {
        return finReconciliationId;
    }

    public void setFinReconciliationId(String finReconciliationId) {
        this.finReconciliationId = finReconciliationId;
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

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public Date getStatementdate() {
        return statementdate;
    }

    public void setStatementdate(Date statementdate) {
        this.statementdate = statementdate;
    }

    public BigInteger getEndingbalance() {
        return endingbalance;
    }

    public void setEndingbalance(BigInteger endingbalance) {
        this.endingbalance = endingbalance;
    }

    public BigInteger getStartingbalance() {
        return startingbalance;
    }

    public void setStartingbalance(BigInteger startingbalance) {
        this.startingbalance = startingbalance;
    }

    public String getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(String docstatus) {
        this.docstatus = docstatus;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public Character getPrintdetailed() {
        return printdetailed;
    }

    public void setPrintdetailed(Character printdetailed) {
        this.printdetailed = printdetailed;
    }

    public Character getPrintsummary() {
        return printsummary;
    }

    public void setPrintsummary(Character printsummary) {
        this.printsummary = printsummary;
    }

    @XmlTransient
    public List<FinReclineTemp> getFinReclineTempList() {
        return finReclineTempList;
    }

    public void setFinReclineTempList(List<FinReclineTemp> finReclineTempList) {
        this.finReclineTempList = finReclineTempList;
    }

    @XmlTransient
    public List<FinBankstatement> getFinBankstatementList() {
        return finBankstatementList;
    }

    public void setFinBankstatementList(List<FinBankstatement> finBankstatementList) {
        this.finBankstatementList = finBankstatementList;
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

    @XmlTransient
    public List<FinFinaccTransaction> getFinFinaccTransactionList() {
        return finFinaccTransactionList;
    }

    public void setFinFinaccTransactionList(List<FinFinaccTransaction> finFinaccTransactionList) {
        this.finFinaccTransactionList = finFinaccTransactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finReconciliationId != null ? finReconciliationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinReconciliation)) {
            return false;
        }
        FinReconciliation other = (FinReconciliation) object;
        if ((this.finReconciliationId == null && other.finReconciliationId != null) || (this.finReconciliationId != null && !this.finReconciliationId.equals(other.finReconciliationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinReconciliation[ finReconciliationId=" + finReconciliationId + " ]";
    }
    
}
