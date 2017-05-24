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
@Table(name = "fin_financial_account_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinFinancialAccountAcct.findAll", query = "SELECT f FROM FinFinancialAccountAcct f"),
    @NamedQuery(name = "FinFinancialAccountAcct.findByFinFinancialAccountAcctId", query = "SELECT f FROM FinFinancialAccountAcct f WHERE f.finFinancialAccountAcctId = :finFinancialAccountAcctId"),
    @NamedQuery(name = "FinFinancialAccountAcct.findByIsactive", query = "SELECT f FROM FinFinancialAccountAcct f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinFinancialAccountAcct.findByCreated", query = "SELECT f FROM FinFinancialAccountAcct f WHERE f.created = :created"),
    @NamedQuery(name = "FinFinancialAccountAcct.findByCreatedby", query = "SELECT f FROM FinFinancialAccountAcct f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinFinancialAccountAcct.findByUpdated", query = "SELECT f FROM FinFinancialAccountAcct f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinFinancialAccountAcct.findByUpdatedby", query = "SELECT f FROM FinFinancialAccountAcct f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinFinancialAccountAcct.findByEnablebankstatement", query = "SELECT f FROM FinFinancialAccountAcct f WHERE f.enablebankstatement = :enablebankstatement")})
public class FinFinancialAccountAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_financial_account_acct_id")
    private String finFinancialAccountAcctId;
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
    @Column(name = "enablebankstatement")
    private Character enablebankstatement;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "fin_bankrevaluationgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finBankrevaluationgainAcct;
    @JoinColumn(name = "fin_receivepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finReceivepaymentAcct;
    @JoinColumn(name = "fin_in_clear_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finInClearAcct;
    @JoinColumn(name = "fin_financial_account_id", referencedColumnName = "fin_financial_account_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinFinancialAccount finFinancialAccountId;
    @JoinColumn(name = "fin_out_intransit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finOutIntransitAcct;
    @JoinColumn(name = "fin_transitory_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finTransitoryAcct;
    @JoinColumn(name = "fin_bankrevaluationloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finBankrevaluationlossAcct;
    @JoinColumn(name = "fin_out_clear_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finOutClearAcct;
    @JoinColumn(name = "fin_credit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finCreditAcct;
    @JoinColumn(name = "fin_makepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finMakepaymentAcct;
    @JoinColumn(name = "fin_in_intransit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finInIntransitAcct;
    @JoinColumn(name = "fin_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finAssetAcct;
    @JoinColumn(name = "fin_withdrawal_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finWithdrawalAcct;
    @JoinColumn(name = "fin_deposit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finDepositAcct;
    @JoinColumn(name = "fin_debit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finDebitAcct;
    @JoinColumn(name = "fin_bankfee_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination finBankfeeAcct;

    public FinFinancialAccountAcct() {
    }

    public FinFinancialAccountAcct(String finFinancialAccountAcctId) {
        this.finFinancialAccountAcctId = finFinancialAccountAcctId;
    }

    public FinFinancialAccountAcct(String finFinancialAccountAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character enablebankstatement) {
        this.finFinancialAccountAcctId = finFinancialAccountAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.enablebankstatement = enablebankstatement;
    }

    public String getFinFinancialAccountAcctId() {
        return finFinancialAccountAcctId;
    }

    public void setFinFinancialAccountAcctId(String finFinancialAccountAcctId) {
        this.finFinancialAccountAcctId = finFinancialAccountAcctId;
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

    public Character getEnablebankstatement() {
        return enablebankstatement;
    }

    public void setEnablebankstatement(Character enablebankstatement) {
        this.enablebankstatement = enablebankstatement;
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

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CValidcombination getFinBankrevaluationgainAcct() {
        return finBankrevaluationgainAcct;
    }

    public void setFinBankrevaluationgainAcct(CValidcombination finBankrevaluationgainAcct) {
        this.finBankrevaluationgainAcct = finBankrevaluationgainAcct;
    }

    public CValidcombination getFinReceivepaymentAcct() {
        return finReceivepaymentAcct;
    }

    public void setFinReceivepaymentAcct(CValidcombination finReceivepaymentAcct) {
        this.finReceivepaymentAcct = finReceivepaymentAcct;
    }

    public CValidcombination getFinInClearAcct() {
        return finInClearAcct;
    }

    public void setFinInClearAcct(CValidcombination finInClearAcct) {
        this.finInClearAcct = finInClearAcct;
    }

    public FinFinancialAccount getFinFinancialAccountId() {
        return finFinancialAccountId;
    }

    public void setFinFinancialAccountId(FinFinancialAccount finFinancialAccountId) {
        this.finFinancialAccountId = finFinancialAccountId;
    }

    public CValidcombination getFinOutIntransitAcct() {
        return finOutIntransitAcct;
    }

    public void setFinOutIntransitAcct(CValidcombination finOutIntransitAcct) {
        this.finOutIntransitAcct = finOutIntransitAcct;
    }

    public CValidcombination getFinTransitoryAcct() {
        return finTransitoryAcct;
    }

    public void setFinTransitoryAcct(CValidcombination finTransitoryAcct) {
        this.finTransitoryAcct = finTransitoryAcct;
    }

    public CValidcombination getFinBankrevaluationlossAcct() {
        return finBankrevaluationlossAcct;
    }

    public void setFinBankrevaluationlossAcct(CValidcombination finBankrevaluationlossAcct) {
        this.finBankrevaluationlossAcct = finBankrevaluationlossAcct;
    }

    public CValidcombination getFinOutClearAcct() {
        return finOutClearAcct;
    }

    public void setFinOutClearAcct(CValidcombination finOutClearAcct) {
        this.finOutClearAcct = finOutClearAcct;
    }

    public CValidcombination getFinCreditAcct() {
        return finCreditAcct;
    }

    public void setFinCreditAcct(CValidcombination finCreditAcct) {
        this.finCreditAcct = finCreditAcct;
    }

    public CValidcombination getFinMakepaymentAcct() {
        return finMakepaymentAcct;
    }

    public void setFinMakepaymentAcct(CValidcombination finMakepaymentAcct) {
        this.finMakepaymentAcct = finMakepaymentAcct;
    }

    public CValidcombination getFinInIntransitAcct() {
        return finInIntransitAcct;
    }

    public void setFinInIntransitAcct(CValidcombination finInIntransitAcct) {
        this.finInIntransitAcct = finInIntransitAcct;
    }

    public CValidcombination getFinAssetAcct() {
        return finAssetAcct;
    }

    public void setFinAssetAcct(CValidcombination finAssetAcct) {
        this.finAssetAcct = finAssetAcct;
    }

    public CValidcombination getFinWithdrawalAcct() {
        return finWithdrawalAcct;
    }

    public void setFinWithdrawalAcct(CValidcombination finWithdrawalAcct) {
        this.finWithdrawalAcct = finWithdrawalAcct;
    }

    public CValidcombination getFinDepositAcct() {
        return finDepositAcct;
    }

    public void setFinDepositAcct(CValidcombination finDepositAcct) {
        this.finDepositAcct = finDepositAcct;
    }

    public CValidcombination getFinDebitAcct() {
        return finDebitAcct;
    }

    public void setFinDebitAcct(CValidcombination finDebitAcct) {
        this.finDebitAcct = finDebitAcct;
    }

    public CValidcombination getFinBankfeeAcct() {
        return finBankfeeAcct;
    }

    public void setFinBankfeeAcct(CValidcombination finBankfeeAcct) {
        this.finBankfeeAcct = finBankfeeAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finFinancialAccountAcctId != null ? finFinancialAccountAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinFinancialAccountAcct)) {
            return false;
        }
        FinFinancialAccountAcct other = (FinFinancialAccountAcct) object;
        if ((this.finFinancialAccountAcctId == null && other.finFinancialAccountAcctId != null) || (this.finFinancialAccountAcctId != null && !this.finFinancialAccountAcctId.equals(other.finFinancialAccountAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinFinancialAccountAcct[ finFinancialAccountAcctId=" + finFinancialAccountAcctId + " ]";
    }
    
}
