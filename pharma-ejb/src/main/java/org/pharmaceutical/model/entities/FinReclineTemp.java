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
@Table(name = "fin_recline_temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinReclineTemp.findAll", query = "SELECT f FROM FinReclineTemp f"),
    @NamedQuery(name = "FinReclineTemp.findByFinReclineTempId", query = "SELECT f FROM FinReclineTemp f WHERE f.finReclineTempId = :finReclineTempId"),
    @NamedQuery(name = "FinReclineTemp.findByCreated", query = "SELECT f FROM FinReclineTemp f WHERE f.created = :created"),
    @NamedQuery(name = "FinReclineTemp.findByCreatedby", query = "SELECT f FROM FinReclineTemp f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinReclineTemp.findByUpdated", query = "SELECT f FROM FinReclineTemp f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinReclineTemp.findByUpdatedby", query = "SELECT f FROM FinReclineTemp f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinReclineTemp.findByIsactive", query = "SELECT f FROM FinReclineTemp f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinReclineTemp.findByMatched", query = "SELECT f FROM FinReclineTemp f WHERE f.matched = :matched"),
    @NamedQuery(name = "FinReclineTemp.findByMatchlevel", query = "SELECT f FROM FinReclineTemp f WHERE f.matchlevel = :matchlevel"),
    @NamedQuery(name = "FinReclineTemp.findByPaymentDocumentno", query = "SELECT f FROM FinReclineTemp f WHERE f.paymentDocumentno = :paymentDocumentno")})
public class FinReclineTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_recline_temp_id")
    private String finReclineTempId;
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
    @Column(name = "matched")
    private Character matched;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "matchlevel")
    private String matchlevel;
    @Size(max = 30)
    @Column(name = "payment_documentno")
    private String paymentDocumentno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "fin_bankstatementline_id", referencedColumnName = "fin_bankstatementline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinBankstatementline finBankstatementlineId;
    @JoinColumn(name = "fin_finacc_transaction_id", referencedColumnName = "fin_finacc_transaction_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinFinaccTransaction finFinaccTransactionId;
    @JoinColumn(name = "fin_payment_id", referencedColumnName = "fin_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPayment finPaymentId;
    @JoinColumn(name = "fin_payment_scheduledetail_id", referencedColumnName = "fin_payment_scheduledetail_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentScheduledetail finPaymentScheduledetailId;
    @JoinColumn(name = "fin_reconciliation_id", referencedColumnName = "fin_reconciliation_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinReconciliation finReconciliationId;

    public FinReclineTemp() {
    }

    public FinReclineTemp(String finReclineTempId) {
        this.finReclineTempId = finReclineTempId;
    }

    public FinReclineTemp(String finReclineTempId, Date created, String createdby, Date updated, String updatedby, Character matched, String matchlevel) {
        this.finReclineTempId = finReclineTempId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.matched = matched;
        this.matchlevel = matchlevel;
    }

    public String getFinReclineTempId() {
        return finReclineTempId;
    }

    public void setFinReclineTempId(String finReclineTempId) {
        this.finReclineTempId = finReclineTempId;
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

    public Character getMatched() {
        return matched;
    }

    public void setMatched(Character matched) {
        this.matched = matched;
    }

    public String getMatchlevel() {
        return matchlevel;
    }

    public void setMatchlevel(String matchlevel) {
        this.matchlevel = matchlevel;
    }

    public String getPaymentDocumentno() {
        return paymentDocumentno;
    }

    public void setPaymentDocumentno(String paymentDocumentno) {
        this.paymentDocumentno = paymentDocumentno;
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

    public FinBankstatementline getFinBankstatementlineId() {
        return finBankstatementlineId;
    }

    public void setFinBankstatementlineId(FinBankstatementline finBankstatementlineId) {
        this.finBankstatementlineId = finBankstatementlineId;
    }

    public FinFinaccTransaction getFinFinaccTransactionId() {
        return finFinaccTransactionId;
    }

    public void setFinFinaccTransactionId(FinFinaccTransaction finFinaccTransactionId) {
        this.finFinaccTransactionId = finFinaccTransactionId;
    }

    public FinPayment getFinPaymentId() {
        return finPaymentId;
    }

    public void setFinPaymentId(FinPayment finPaymentId) {
        this.finPaymentId = finPaymentId;
    }

    public FinPaymentScheduledetail getFinPaymentScheduledetailId() {
        return finPaymentScheduledetailId;
    }

    public void setFinPaymentScheduledetailId(FinPaymentScheduledetail finPaymentScheduledetailId) {
        this.finPaymentScheduledetailId = finPaymentScheduledetailId;
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
        hash += (finReclineTempId != null ? finReclineTempId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinReclineTemp)) {
            return false;
        }
        FinReclineTemp other = (FinReclineTemp) object;
        if ((this.finReclineTempId == null && other.finReclineTempId != null) || (this.finReclineTempId != null && !this.finReclineTempId.equals(other.finReclineTempId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinReclineTemp[ finReclineTempId=" + finReclineTempId + " ]";
    }
    
}
