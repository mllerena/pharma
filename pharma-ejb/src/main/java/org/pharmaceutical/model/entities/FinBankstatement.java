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
@Table(name = "fin_bankstatement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinBankstatement.findAll", query = "SELECT f FROM FinBankstatement f"),
    @NamedQuery(name = "FinBankstatement.findByFinBankstatementId", query = "SELECT f FROM FinBankstatement f WHERE f.finBankstatementId = :finBankstatementId"),
    @NamedQuery(name = "FinBankstatement.findByCreated", query = "SELECT f FROM FinBankstatement f WHERE f.created = :created"),
    @NamedQuery(name = "FinBankstatement.findByCreatedby", query = "SELECT f FROM FinBankstatement f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinBankstatement.findByUpdated", query = "SELECT f FROM FinBankstatement f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinBankstatement.findByUpdatedby", query = "SELECT f FROM FinBankstatement f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinBankstatement.findByIsactive", query = "SELECT f FROM FinBankstatement f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinBankstatement.findByDocumentno", query = "SELECT f FROM FinBankstatement f WHERE f.documentno = :documentno"),
    @NamedQuery(name = "FinBankstatement.findByName", query = "SELECT f FROM FinBankstatement f WHERE f.name = :name"),
    @NamedQuery(name = "FinBankstatement.findByNotes", query = "SELECT f FROM FinBankstatement f WHERE f.notes = :notes"),
    @NamedQuery(name = "FinBankstatement.findByFilename", query = "SELECT f FROM FinBankstatement f WHERE f.filename = :filename"),
    @NamedQuery(name = "FinBankstatement.findByImportdate", query = "SELECT f FROM FinBankstatement f WHERE f.importdate = :importdate"),
    @NamedQuery(name = "FinBankstatement.findByStatementdate", query = "SELECT f FROM FinBankstatement f WHERE f.statementdate = :statementdate"),
    @NamedQuery(name = "FinBankstatement.findByProcessing", query = "SELECT f FROM FinBankstatement f WHERE f.processing = :processing"),
    @NamedQuery(name = "FinBankstatement.findByProcessed", query = "SELECT f FROM FinBankstatement f WHERE f.processed = :processed"),
    @NamedQuery(name = "FinBankstatement.findByPosted", query = "SELECT f FROM FinBankstatement f WHERE f.posted = :posted")})
public class FinBankstatement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_bankstatement_id")
    private String finBankstatementId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "notes")
    private String notes;
    @Size(max = 255)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date importdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statementdate;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finBankstatementId")
    private List<FinBankstatementline> finBankstatementlineList;
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
    @JoinColumn(name = "fin_reconciliation_id", referencedColumnName = "fin_reconciliation_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinReconciliation finReconciliationId;

    public FinBankstatement() {
    }

    public FinBankstatement(String finBankstatementId) {
        this.finBankstatementId = finBankstatementId;
    }

    public FinBankstatement(String finBankstatementId, Date created, String createdby, Date updated, String updatedby, String documentno, String name, Date importdate, Date statementdate, Character processed, String posted) {
        this.finBankstatementId = finBankstatementId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.name = name;
        this.importdate = importdate;
        this.statementdate = statementdate;
        this.processed = processed;
        this.posted = posted;
    }

    public String getFinBankstatementId() {
        return finBankstatementId;
    }

    public void setFinBankstatementId(String finBankstatementId) {
        this.finBankstatementId = finBankstatementId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getImportdate() {
        return importdate;
    }

    public void setImportdate(Date importdate) {
        this.importdate = importdate;
    }

    public Date getStatementdate() {
        return statementdate;
    }

    public void setStatementdate(Date statementdate) {
        this.statementdate = statementdate;
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

    @XmlTransient
    public List<FinBankstatementline> getFinBankstatementlineList() {
        return finBankstatementlineList;
    }

    public void setFinBankstatementlineList(List<FinBankstatementline> finBankstatementlineList) {
        this.finBankstatementlineList = finBankstatementlineList;
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

    public FinReconciliation getFinReconciliationId() {
        return finReconciliationId;
    }

    public void setFinReconciliationId(FinReconciliation finReconciliationId) {
        this.finReconciliationId = finReconciliationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finBankstatementId != null ? finBankstatementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinBankstatement)) {
            return false;
        }
        FinBankstatement other = (FinBankstatement) object;
        if ((this.finBankstatementId == null && other.finBankstatementId != null) || (this.finBankstatementId != null && !this.finBankstatementId.equals(other.finBankstatementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinBankstatement[ finBankstatementId=" + finBankstatementId + " ]";
    }
    
}
