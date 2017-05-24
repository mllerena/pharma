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
@Table(name = "c_bankaccount_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBankaccountAcct.findAll", query = "SELECT c FROM CBankaccountAcct c"),
    @NamedQuery(name = "CBankaccountAcct.findByCBankaccountAcctId", query = "SELECT c FROM CBankaccountAcct c WHERE c.cBankaccountAcctId = :cBankaccountAcctId"),
    @NamedQuery(name = "CBankaccountAcct.findByIsactive", query = "SELECT c FROM CBankaccountAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBankaccountAcct.findByCreated", query = "SELECT c FROM CBankaccountAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CBankaccountAcct.findByCreatedby", query = "SELECT c FROM CBankaccountAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBankaccountAcct.findByUpdated", query = "SELECT c FROM CBankaccountAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBankaccountAcct.findByUpdatedby", query = "SELECT c FROM CBankaccountAcct c WHERE c.updatedby = :updatedby")})
public class CBankaccountAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bankaccount_acct_id")
    private String cBankaccountAcctId;
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
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBankaccount cBankaccountId;
    @JoinColumn(name = "b_settlementgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bSettlementgainAcct;
    @JoinColumn(name = "b_unallocatedcash_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bUnallocatedcashAcct;
    @JoinColumn(name = "b_unidentified_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bUnidentifiedAcct;
    @JoinColumn(name = "b_settlementloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bSettlementlossAcct;
    @JoinColumn(name = "b_revaluationgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bRevaluationgainAcct;
    @JoinColumn(name = "b_revaluationloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bRevaluationlossAcct;
    @JoinColumn(name = "b_paymentselect_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bPaymentselectAcct;
    @JoinColumn(name = "b_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bAssetAcct;
    @JoinColumn(name = "b_interestexp_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bInterestexpAcct;
    @JoinColumn(name = "b_intransit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bIntransitAcct;
    @JoinColumn(name = "b_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bExpenseAcct;
    @JoinColumn(name = "b_interestrev_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bInterestrevAcct;

    public CBankaccountAcct() {
    }

    public CBankaccountAcct(String cBankaccountAcctId) {
        this.cBankaccountAcctId = cBankaccountAcctId;
    }

    public CBankaccountAcct(String cBankaccountAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cBankaccountAcctId = cBankaccountAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCBankaccountAcctId() {
        return cBankaccountAcctId;
    }

    public void setCBankaccountAcctId(String cBankaccountAcctId) {
        this.cBankaccountAcctId = cBankaccountAcctId;
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

    public CBankaccount getCBankaccountId() {
        return cBankaccountId;
    }

    public void setCBankaccountId(CBankaccount cBankaccountId) {
        this.cBankaccountId = cBankaccountId;
    }

    public CValidcombination getBSettlementgainAcct() {
        return bSettlementgainAcct;
    }

    public void setBSettlementgainAcct(CValidcombination bSettlementgainAcct) {
        this.bSettlementgainAcct = bSettlementgainAcct;
    }

    public CValidcombination getBUnallocatedcashAcct() {
        return bUnallocatedcashAcct;
    }

    public void setBUnallocatedcashAcct(CValidcombination bUnallocatedcashAcct) {
        this.bUnallocatedcashAcct = bUnallocatedcashAcct;
    }

    public CValidcombination getBUnidentifiedAcct() {
        return bUnidentifiedAcct;
    }

    public void setBUnidentifiedAcct(CValidcombination bUnidentifiedAcct) {
        this.bUnidentifiedAcct = bUnidentifiedAcct;
    }

    public CValidcombination getBSettlementlossAcct() {
        return bSettlementlossAcct;
    }

    public void setBSettlementlossAcct(CValidcombination bSettlementlossAcct) {
        this.bSettlementlossAcct = bSettlementlossAcct;
    }

    public CValidcombination getBRevaluationgainAcct() {
        return bRevaluationgainAcct;
    }

    public void setBRevaluationgainAcct(CValidcombination bRevaluationgainAcct) {
        this.bRevaluationgainAcct = bRevaluationgainAcct;
    }

    public CValidcombination getBRevaluationlossAcct() {
        return bRevaluationlossAcct;
    }

    public void setBRevaluationlossAcct(CValidcombination bRevaluationlossAcct) {
        this.bRevaluationlossAcct = bRevaluationlossAcct;
    }

    public CValidcombination getBPaymentselectAcct() {
        return bPaymentselectAcct;
    }

    public void setBPaymentselectAcct(CValidcombination bPaymentselectAcct) {
        this.bPaymentselectAcct = bPaymentselectAcct;
    }

    public CValidcombination getBAssetAcct() {
        return bAssetAcct;
    }

    public void setBAssetAcct(CValidcombination bAssetAcct) {
        this.bAssetAcct = bAssetAcct;
    }

    public CValidcombination getBInterestexpAcct() {
        return bInterestexpAcct;
    }

    public void setBInterestexpAcct(CValidcombination bInterestexpAcct) {
        this.bInterestexpAcct = bInterestexpAcct;
    }

    public CValidcombination getBIntransitAcct() {
        return bIntransitAcct;
    }

    public void setBIntransitAcct(CValidcombination bIntransitAcct) {
        this.bIntransitAcct = bIntransitAcct;
    }

    public CValidcombination getBExpenseAcct() {
        return bExpenseAcct;
    }

    public void setBExpenseAcct(CValidcombination bExpenseAcct) {
        this.bExpenseAcct = bExpenseAcct;
    }

    public CValidcombination getBInterestrevAcct() {
        return bInterestrevAcct;
    }

    public void setBInterestrevAcct(CValidcombination bInterestrevAcct) {
        this.bInterestrevAcct = bInterestrevAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBankaccountAcctId != null ? cBankaccountAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBankaccountAcct)) {
            return false;
        }
        CBankaccountAcct other = (CBankaccountAcct) object;
        if ((this.cBankaccountAcctId == null && other.cBankaccountAcctId != null) || (this.cBankaccountAcctId != null && !this.cBankaccountAcctId.equals(other.cBankaccountAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBankaccountAcct[ cBankaccountAcctId=" + cBankaccountAcctId + " ]";
    }
    
}
