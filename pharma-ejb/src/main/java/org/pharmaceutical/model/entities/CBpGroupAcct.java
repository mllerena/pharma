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
@Table(name = "c_bp_group_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpGroupAcct.findAll", query = "SELECT c FROM CBpGroupAcct c"),
    @NamedQuery(name = "CBpGroupAcct.findByIsactive", query = "SELECT c FROM CBpGroupAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpGroupAcct.findByCreated", query = "SELECT c FROM CBpGroupAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CBpGroupAcct.findByCreatedby", query = "SELECT c FROM CBpGroupAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpGroupAcct.findByUpdated", query = "SELECT c FROM CBpGroupAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpGroupAcct.findByUpdatedby", query = "SELECT c FROM CBpGroupAcct c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpGroupAcct.findByProcessing", query = "SELECT c FROM CBpGroupAcct c WHERE c.processing = :processing"),
    @NamedQuery(name = "CBpGroupAcct.findByCBpGroupAcctId", query = "SELECT c FROM CBpGroupAcct c WHERE c.cBpGroupAcctId = :cBpGroupAcctId"),
    @NamedQuery(name = "CBpGroupAcct.findByStatus", query = "SELECT c FROM CBpGroupAcct c WHERE c.status = :status")})
public class CBpGroupAcct implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Column(name = "processing")
    private Character processing;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bp_group_acct_id")
    private String cBpGroupAcctId;
    @Size(max = 60)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_bp_group_id", referencedColumnName = "c_bp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpGroup cBpGroupId;
    @JoinColumn(name = "v_liability_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination vLiabilityAcct;
    @JoinColumn(name = "unrealizedloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination unrealizedlossAcct;
    @JoinColumn(name = "unrealizedgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination unrealizedgainAcct;
    @JoinColumn(name = "paydiscount_rev_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination paydiscountRevAcct;
    @JoinColumn(name = "c_receivable_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination cReceivableAcct;
    @JoinColumn(name = "v_prepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination vPrepaymentAcct;
    @JoinColumn(name = "notinvoicedrevenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination notinvoicedrevenueAcct;
    @JoinColumn(name = "unearnedrevenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination unearnedrevenueAcct;
    @JoinColumn(name = "notinvoicedreceivables_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination notinvoicedreceivablesAcct;
    @JoinColumn(name = "v_liability_services_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination vLiabilityServicesAcct;
    @JoinColumn(name = "notinvoicedreceipts_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination notinvoicedreceiptsAcct;
    @JoinColumn(name = "writeoff_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination writeoffAcct;
    @JoinColumn(name = "realizedloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination realizedlossAcct;
    @JoinColumn(name = "realizedgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination realizedgainAcct;
    @JoinColumn(name = "writeoff_rev_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination writeoffRevAcct;
    @JoinColumn(name = "c_prepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination cPrepaymentAcct;
    @JoinColumn(name = "paydiscount_exp_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination paydiscountExpAcct;

    public CBpGroupAcct() {
    }

    public CBpGroupAcct(String cBpGroupAcctId) {
        this.cBpGroupAcctId = cBpGroupAcctId;
    }

    public CBpGroupAcct(String cBpGroupAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cBpGroupAcctId = cBpGroupAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
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

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public String getCBpGroupAcctId() {
        return cBpGroupAcctId;
    }

    public void setCBpGroupAcctId(String cBpGroupAcctId) {
        this.cBpGroupAcctId = cBpGroupAcctId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CBpGroup getCBpGroupId() {
        return cBpGroupId;
    }

    public void setCBpGroupId(CBpGroup cBpGroupId) {
        this.cBpGroupId = cBpGroupId;
    }

    public CValidcombination getVLiabilityAcct() {
        return vLiabilityAcct;
    }

    public void setVLiabilityAcct(CValidcombination vLiabilityAcct) {
        this.vLiabilityAcct = vLiabilityAcct;
    }

    public CValidcombination getUnrealizedlossAcct() {
        return unrealizedlossAcct;
    }

    public void setUnrealizedlossAcct(CValidcombination unrealizedlossAcct) {
        this.unrealizedlossAcct = unrealizedlossAcct;
    }

    public CValidcombination getUnrealizedgainAcct() {
        return unrealizedgainAcct;
    }

    public void setUnrealizedgainAcct(CValidcombination unrealizedgainAcct) {
        this.unrealizedgainAcct = unrealizedgainAcct;
    }

    public CValidcombination getPaydiscountRevAcct() {
        return paydiscountRevAcct;
    }

    public void setPaydiscountRevAcct(CValidcombination paydiscountRevAcct) {
        this.paydiscountRevAcct = paydiscountRevAcct;
    }

    public CValidcombination getCReceivableAcct() {
        return cReceivableAcct;
    }

    public void setCReceivableAcct(CValidcombination cReceivableAcct) {
        this.cReceivableAcct = cReceivableAcct;
    }

    public CValidcombination getVPrepaymentAcct() {
        return vPrepaymentAcct;
    }

    public void setVPrepaymentAcct(CValidcombination vPrepaymentAcct) {
        this.vPrepaymentAcct = vPrepaymentAcct;
    }

    public CValidcombination getNotinvoicedrevenueAcct() {
        return notinvoicedrevenueAcct;
    }

    public void setNotinvoicedrevenueAcct(CValidcombination notinvoicedrevenueAcct) {
        this.notinvoicedrevenueAcct = notinvoicedrevenueAcct;
    }

    public CValidcombination getUnearnedrevenueAcct() {
        return unearnedrevenueAcct;
    }

    public void setUnearnedrevenueAcct(CValidcombination unearnedrevenueAcct) {
        this.unearnedrevenueAcct = unearnedrevenueAcct;
    }

    public CValidcombination getNotinvoicedreceivablesAcct() {
        return notinvoicedreceivablesAcct;
    }

    public void setNotinvoicedreceivablesAcct(CValidcombination notinvoicedreceivablesAcct) {
        this.notinvoicedreceivablesAcct = notinvoicedreceivablesAcct;
    }

    public CValidcombination getVLiabilityServicesAcct() {
        return vLiabilityServicesAcct;
    }

    public void setVLiabilityServicesAcct(CValidcombination vLiabilityServicesAcct) {
        this.vLiabilityServicesAcct = vLiabilityServicesAcct;
    }

    public CValidcombination getNotinvoicedreceiptsAcct() {
        return notinvoicedreceiptsAcct;
    }

    public void setNotinvoicedreceiptsAcct(CValidcombination notinvoicedreceiptsAcct) {
        this.notinvoicedreceiptsAcct = notinvoicedreceiptsAcct;
    }

    public CValidcombination getWriteoffAcct() {
        return writeoffAcct;
    }

    public void setWriteoffAcct(CValidcombination writeoffAcct) {
        this.writeoffAcct = writeoffAcct;
    }

    public CValidcombination getRealizedlossAcct() {
        return realizedlossAcct;
    }

    public void setRealizedlossAcct(CValidcombination realizedlossAcct) {
        this.realizedlossAcct = realizedlossAcct;
    }

    public CValidcombination getRealizedgainAcct() {
        return realizedgainAcct;
    }

    public void setRealizedgainAcct(CValidcombination realizedgainAcct) {
        this.realizedgainAcct = realizedgainAcct;
    }

    public CValidcombination getWriteoffRevAcct() {
        return writeoffRevAcct;
    }

    public void setWriteoffRevAcct(CValidcombination writeoffRevAcct) {
        this.writeoffRevAcct = writeoffRevAcct;
    }

    public CValidcombination getCPrepaymentAcct() {
        return cPrepaymentAcct;
    }

    public void setCPrepaymentAcct(CValidcombination cPrepaymentAcct) {
        this.cPrepaymentAcct = cPrepaymentAcct;
    }

    public CValidcombination getPaydiscountExpAcct() {
        return paydiscountExpAcct;
    }

    public void setPaydiscountExpAcct(CValidcombination paydiscountExpAcct) {
        this.paydiscountExpAcct = paydiscountExpAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpGroupAcctId != null ? cBpGroupAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpGroupAcct)) {
            return false;
        }
        CBpGroupAcct other = (CBpGroupAcct) object;
        if ((this.cBpGroupAcctId == null && other.cBpGroupAcctId != null) || (this.cBpGroupAcctId != null && !this.cBpGroupAcctId.equals(other.cBpGroupAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpGroupAcct[ cBpGroupAcctId=" + cBpGroupAcctId + " ]";
    }
    
}
