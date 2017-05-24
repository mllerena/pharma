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
import javax.persistence.OneToOne;
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
@Table(name = "c_acctschema_default")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctschemaDefault.findAll", query = "SELECT c FROM CAcctschemaDefault c"),
    @NamedQuery(name = "CAcctschemaDefault.findByIsactive", query = "SELECT c FROM CAcctschemaDefault c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctschemaDefault.findByCreated", query = "SELECT c FROM CAcctschemaDefault c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctschemaDefault.findByCreatedby", query = "SELECT c FROM CAcctschemaDefault c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctschemaDefault.findByUpdated", query = "SELECT c FROM CAcctschemaDefault c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctschemaDefault.findByUpdatedby", query = "SELECT c FROM CAcctschemaDefault c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctschemaDefault.findByProcessing", query = "SELECT c FROM CAcctschemaDefault c WHERE c.processing = :processing"),
    @NamedQuery(name = "CAcctschemaDefault.findByCAcctschemaDefaultId", query = "SELECT c FROM CAcctschemaDefault c WHERE c.cAcctschemaDefaultId = :cAcctschemaDefaultId")})
public class CAcctschemaDefault implements Serializable {
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
    @Column(name = "c_acctschema_default_id")
    private String cAcctschemaDefaultId;
    @JoinColumn(name = "p_tradediscountgrant_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pTradediscountgrantAcct;
    @JoinColumn(name = "w_invactualadjust_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination wInvactualadjustAcct;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "realizedgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination realizedgainAcct;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @OneToOne(optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_receivable_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cReceivableAcct;
    @JoinColumn(name = "writeoff_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination writeoffAcct;
    @JoinColumn(name = "p_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination pExpenseAcct;
    @JoinColumn(name = "p_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination pAssetAcct;
    @JoinColumn(name = "ch_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination chExpenseAcct;
    @JoinColumn(name = "b_unidentified_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bUnidentifiedAcct;
    @JoinColumn(name = "b_unallocatedcash_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bUnallocatedcashAcct;
    @JoinColumn(name = "ch_revenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination chRevenueAcct;
    @JoinColumn(name = "t_liability_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination tLiabilityAcct;
    @JoinColumn(name = "paydiscount_exp_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination paydiscountExpAcct;
    @JoinColumn(name = "cb_cashtransfer_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbCashtransferAcct;
    @JoinColumn(name = "b_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bExpenseAcct;
    @JoinColumn(name = "a_disposal_loss", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination aDisposalLoss;
    @JoinColumn(name = "b_settlementloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bSettlementlossAcct;
    @JoinColumn(name = "notinvoicedreceipts_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination notinvoicedreceiptsAcct;
    @JoinColumn(name = "b_interestexp_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bInterestexpAcct;
    @JoinColumn(name = "w_inventory_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination wInventoryAcct;
    @JoinColumn(name = "w_differences_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination wDifferencesAcct;
    @JoinColumn(name = "p_purchasepricevariance_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pPurchasepricevarianceAcct;
    @JoinColumn(name = "b_paymentselect_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bPaymentselectAcct;
    @JoinColumn(name = "p_cogs_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination pCogsAcct;
    @JoinColumn(name = "e_prepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination ePrepaymentAcct;
    @JoinColumn(name = "a_depreciation_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination aDepreciationAcct;
    @JoinColumn(name = "notinvoicedrevenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination notinvoicedrevenueAcct;
    @JoinColumn(name = "p_tradediscountrec_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pTradediscountrecAcct;
    @JoinColumn(name = "b_intransit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bIntransitAcct;
    @JoinColumn(name = "t_credit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination tCreditAcct;
    @JoinColumn(name = "cb_receipt_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbReceiptAcct;
    @JoinColumn(name = "w_revaluation_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination wRevaluationAcct;
    @JoinColumn(name = "notinvoicedreceivables_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination notinvoicedreceivablesAcct;
    @JoinColumn(name = "b_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bAssetAcct;
    @JoinColumn(name = "cb_differences_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbDifferencesAcct;
    @JoinColumn(name = "b_revaluationloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bRevaluationlossAcct;
    @JoinColumn(name = "e_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination eExpenseAcct;
    @JoinColumn(name = "unearnedrevenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination unearnedrevenueAcct;
    @JoinColumn(name = "withholding_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination withholdingAcct;
    @JoinColumn(name = "t_due_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination tDueAcct;
    @JoinColumn(name = "t_receivables_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination tReceivablesAcct;
    @JoinColumn(name = "v_prepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination vPrepaymentAcct;
    @JoinColumn(name = "v_liability_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination vLiabilityAcct;
    @JoinColumn(name = "b_revaluationgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination bRevaluationgainAcct;
    @JoinColumn(name = "pj_wip_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pjWipAcct;
    @JoinColumn(name = "p_revenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination pRevenueAcct;
    @JoinColumn(name = "pj_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pjAssetAcct;
    @JoinColumn(name = "v_liability_services_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination vLiabilityServicesAcct;
    @JoinColumn(name = "writeoff_rev_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination writeoffRevAcct;
    @JoinColumn(name = "b_interestrev_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bInterestrevAcct;
    @JoinColumn(name = "c_prepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination cPrepaymentAcct;
    @JoinColumn(name = "b_settlementgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination bSettlementgainAcct;
    @JoinColumn(name = "t_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination tExpenseAcct;
    @JoinColumn(name = "p_invoicepricevariance_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pInvoicepricevarianceAcct;
    @JoinColumn(name = "cb_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbAssetAcct;
    @JoinColumn(name = "cb_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbExpenseAcct;
    @JoinColumn(name = "paydiscount_rev_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination paydiscountRevAcct;
    @JoinColumn(name = "a_accumdepreciation_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination aAccumdepreciationAcct;
    @JoinColumn(name = "realizedloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination realizedlossAcct;
    @JoinColumn(name = "unrealizedgain_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination unrealizedgainAcct;
    @JoinColumn(name = "a_disposal_gain", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination aDisposalGain;
    @JoinColumn(name = "unrealizedloss_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination unrealizedlossAcct;

    public CAcctschemaDefault() {
    }

    public CAcctschemaDefault(String cAcctschemaDefaultId) {
        this.cAcctschemaDefaultId = cAcctschemaDefaultId;
    }

    public CAcctschemaDefault(String cAcctschemaDefaultId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cAcctschemaDefaultId = cAcctschemaDefaultId;
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

    public String getCAcctschemaDefaultId() {
        return cAcctschemaDefaultId;
    }

    public void setCAcctschemaDefaultId(String cAcctschemaDefaultId) {
        this.cAcctschemaDefaultId = cAcctschemaDefaultId;
    }

    public CValidcombination getPTradediscountgrantAcct() {
        return pTradediscountgrantAcct;
    }

    public void setPTradediscountgrantAcct(CValidcombination pTradediscountgrantAcct) {
        this.pTradediscountgrantAcct = pTradediscountgrantAcct;
    }

    public CValidcombination getWInvactualadjustAcct() {
        return wInvactualadjustAcct;
    }

    public void setWInvactualadjustAcct(CValidcombination wInvactualadjustAcct) {
        this.wInvactualadjustAcct = wInvactualadjustAcct;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public CValidcombination getRealizedgainAcct() {
        return realizedgainAcct;
    }

    public void setRealizedgainAcct(CValidcombination realizedgainAcct) {
        this.realizedgainAcct = realizedgainAcct;
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

    public CValidcombination getCReceivableAcct() {
        return cReceivableAcct;
    }

    public void setCReceivableAcct(CValidcombination cReceivableAcct) {
        this.cReceivableAcct = cReceivableAcct;
    }

    public CValidcombination getWriteoffAcct() {
        return writeoffAcct;
    }

    public void setWriteoffAcct(CValidcombination writeoffAcct) {
        this.writeoffAcct = writeoffAcct;
    }

    public CValidcombination getPExpenseAcct() {
        return pExpenseAcct;
    }

    public void setPExpenseAcct(CValidcombination pExpenseAcct) {
        this.pExpenseAcct = pExpenseAcct;
    }

    public CValidcombination getPAssetAcct() {
        return pAssetAcct;
    }

    public void setPAssetAcct(CValidcombination pAssetAcct) {
        this.pAssetAcct = pAssetAcct;
    }

    public CValidcombination getChExpenseAcct() {
        return chExpenseAcct;
    }

    public void setChExpenseAcct(CValidcombination chExpenseAcct) {
        this.chExpenseAcct = chExpenseAcct;
    }

    public CValidcombination getBUnidentifiedAcct() {
        return bUnidentifiedAcct;
    }

    public void setBUnidentifiedAcct(CValidcombination bUnidentifiedAcct) {
        this.bUnidentifiedAcct = bUnidentifiedAcct;
    }

    public CValidcombination getBUnallocatedcashAcct() {
        return bUnallocatedcashAcct;
    }

    public void setBUnallocatedcashAcct(CValidcombination bUnallocatedcashAcct) {
        this.bUnallocatedcashAcct = bUnallocatedcashAcct;
    }

    public CValidcombination getChRevenueAcct() {
        return chRevenueAcct;
    }

    public void setChRevenueAcct(CValidcombination chRevenueAcct) {
        this.chRevenueAcct = chRevenueAcct;
    }

    public CValidcombination getTLiabilityAcct() {
        return tLiabilityAcct;
    }

    public void setTLiabilityAcct(CValidcombination tLiabilityAcct) {
        this.tLiabilityAcct = tLiabilityAcct;
    }

    public CValidcombination getPaydiscountExpAcct() {
        return paydiscountExpAcct;
    }

    public void setPaydiscountExpAcct(CValidcombination paydiscountExpAcct) {
        this.paydiscountExpAcct = paydiscountExpAcct;
    }

    public CValidcombination getCbCashtransferAcct() {
        return cbCashtransferAcct;
    }

    public void setCbCashtransferAcct(CValidcombination cbCashtransferAcct) {
        this.cbCashtransferAcct = cbCashtransferAcct;
    }

    public CValidcombination getBExpenseAcct() {
        return bExpenseAcct;
    }

    public void setBExpenseAcct(CValidcombination bExpenseAcct) {
        this.bExpenseAcct = bExpenseAcct;
    }

    public CValidcombination getADisposalLoss() {
        return aDisposalLoss;
    }

    public void setADisposalLoss(CValidcombination aDisposalLoss) {
        this.aDisposalLoss = aDisposalLoss;
    }

    public CValidcombination getBSettlementlossAcct() {
        return bSettlementlossAcct;
    }

    public void setBSettlementlossAcct(CValidcombination bSettlementlossAcct) {
        this.bSettlementlossAcct = bSettlementlossAcct;
    }

    public CValidcombination getNotinvoicedreceiptsAcct() {
        return notinvoicedreceiptsAcct;
    }

    public void setNotinvoicedreceiptsAcct(CValidcombination notinvoicedreceiptsAcct) {
        this.notinvoicedreceiptsAcct = notinvoicedreceiptsAcct;
    }

    public CValidcombination getBInterestexpAcct() {
        return bInterestexpAcct;
    }

    public void setBInterestexpAcct(CValidcombination bInterestexpAcct) {
        this.bInterestexpAcct = bInterestexpAcct;
    }

    public CValidcombination getWInventoryAcct() {
        return wInventoryAcct;
    }

    public void setWInventoryAcct(CValidcombination wInventoryAcct) {
        this.wInventoryAcct = wInventoryAcct;
    }

    public CValidcombination getWDifferencesAcct() {
        return wDifferencesAcct;
    }

    public void setWDifferencesAcct(CValidcombination wDifferencesAcct) {
        this.wDifferencesAcct = wDifferencesAcct;
    }

    public CValidcombination getPPurchasepricevarianceAcct() {
        return pPurchasepricevarianceAcct;
    }

    public void setPPurchasepricevarianceAcct(CValidcombination pPurchasepricevarianceAcct) {
        this.pPurchasepricevarianceAcct = pPurchasepricevarianceAcct;
    }

    public CValidcombination getBPaymentselectAcct() {
        return bPaymentselectAcct;
    }

    public void setBPaymentselectAcct(CValidcombination bPaymentselectAcct) {
        this.bPaymentselectAcct = bPaymentselectAcct;
    }

    public CValidcombination getPCogsAcct() {
        return pCogsAcct;
    }

    public void setPCogsAcct(CValidcombination pCogsAcct) {
        this.pCogsAcct = pCogsAcct;
    }

    public CValidcombination getEPrepaymentAcct() {
        return ePrepaymentAcct;
    }

    public void setEPrepaymentAcct(CValidcombination ePrepaymentAcct) {
        this.ePrepaymentAcct = ePrepaymentAcct;
    }

    public CValidcombination getADepreciationAcct() {
        return aDepreciationAcct;
    }

    public void setADepreciationAcct(CValidcombination aDepreciationAcct) {
        this.aDepreciationAcct = aDepreciationAcct;
    }

    public CValidcombination getNotinvoicedrevenueAcct() {
        return notinvoicedrevenueAcct;
    }

    public void setNotinvoicedrevenueAcct(CValidcombination notinvoicedrevenueAcct) {
        this.notinvoicedrevenueAcct = notinvoicedrevenueAcct;
    }

    public CValidcombination getPTradediscountrecAcct() {
        return pTradediscountrecAcct;
    }

    public void setPTradediscountrecAcct(CValidcombination pTradediscountrecAcct) {
        this.pTradediscountrecAcct = pTradediscountrecAcct;
    }

    public CValidcombination getBIntransitAcct() {
        return bIntransitAcct;
    }

    public void setBIntransitAcct(CValidcombination bIntransitAcct) {
        this.bIntransitAcct = bIntransitAcct;
    }

    public CValidcombination getTCreditAcct() {
        return tCreditAcct;
    }

    public void setTCreditAcct(CValidcombination tCreditAcct) {
        this.tCreditAcct = tCreditAcct;
    }

    public CValidcombination getCbReceiptAcct() {
        return cbReceiptAcct;
    }

    public void setCbReceiptAcct(CValidcombination cbReceiptAcct) {
        this.cbReceiptAcct = cbReceiptAcct;
    }

    public CValidcombination getWRevaluationAcct() {
        return wRevaluationAcct;
    }

    public void setWRevaluationAcct(CValidcombination wRevaluationAcct) {
        this.wRevaluationAcct = wRevaluationAcct;
    }

    public CValidcombination getNotinvoicedreceivablesAcct() {
        return notinvoicedreceivablesAcct;
    }

    public void setNotinvoicedreceivablesAcct(CValidcombination notinvoicedreceivablesAcct) {
        this.notinvoicedreceivablesAcct = notinvoicedreceivablesAcct;
    }

    public CValidcombination getBAssetAcct() {
        return bAssetAcct;
    }

    public void setBAssetAcct(CValidcombination bAssetAcct) {
        this.bAssetAcct = bAssetAcct;
    }

    public CValidcombination getCbDifferencesAcct() {
        return cbDifferencesAcct;
    }

    public void setCbDifferencesAcct(CValidcombination cbDifferencesAcct) {
        this.cbDifferencesAcct = cbDifferencesAcct;
    }

    public CValidcombination getBRevaluationlossAcct() {
        return bRevaluationlossAcct;
    }

    public void setBRevaluationlossAcct(CValidcombination bRevaluationlossAcct) {
        this.bRevaluationlossAcct = bRevaluationlossAcct;
    }

    public CValidcombination getEExpenseAcct() {
        return eExpenseAcct;
    }

    public void setEExpenseAcct(CValidcombination eExpenseAcct) {
        this.eExpenseAcct = eExpenseAcct;
    }

    public CValidcombination getUnearnedrevenueAcct() {
        return unearnedrevenueAcct;
    }

    public void setUnearnedrevenueAcct(CValidcombination unearnedrevenueAcct) {
        this.unearnedrevenueAcct = unearnedrevenueAcct;
    }

    public CValidcombination getWithholdingAcct() {
        return withholdingAcct;
    }

    public void setWithholdingAcct(CValidcombination withholdingAcct) {
        this.withholdingAcct = withholdingAcct;
    }

    public CValidcombination getTDueAcct() {
        return tDueAcct;
    }

    public void setTDueAcct(CValidcombination tDueAcct) {
        this.tDueAcct = tDueAcct;
    }

    public CValidcombination getTReceivablesAcct() {
        return tReceivablesAcct;
    }

    public void setTReceivablesAcct(CValidcombination tReceivablesAcct) {
        this.tReceivablesAcct = tReceivablesAcct;
    }

    public CValidcombination getVPrepaymentAcct() {
        return vPrepaymentAcct;
    }

    public void setVPrepaymentAcct(CValidcombination vPrepaymentAcct) {
        this.vPrepaymentAcct = vPrepaymentAcct;
    }

    public CValidcombination getVLiabilityAcct() {
        return vLiabilityAcct;
    }

    public void setVLiabilityAcct(CValidcombination vLiabilityAcct) {
        this.vLiabilityAcct = vLiabilityAcct;
    }

    public CValidcombination getBRevaluationgainAcct() {
        return bRevaluationgainAcct;
    }

    public void setBRevaluationgainAcct(CValidcombination bRevaluationgainAcct) {
        this.bRevaluationgainAcct = bRevaluationgainAcct;
    }

    public CValidcombination getPjWipAcct() {
        return pjWipAcct;
    }

    public void setPjWipAcct(CValidcombination pjWipAcct) {
        this.pjWipAcct = pjWipAcct;
    }

    public CValidcombination getPRevenueAcct() {
        return pRevenueAcct;
    }

    public void setPRevenueAcct(CValidcombination pRevenueAcct) {
        this.pRevenueAcct = pRevenueAcct;
    }

    public CValidcombination getPjAssetAcct() {
        return pjAssetAcct;
    }

    public void setPjAssetAcct(CValidcombination pjAssetAcct) {
        this.pjAssetAcct = pjAssetAcct;
    }

    public CValidcombination getVLiabilityServicesAcct() {
        return vLiabilityServicesAcct;
    }

    public void setVLiabilityServicesAcct(CValidcombination vLiabilityServicesAcct) {
        this.vLiabilityServicesAcct = vLiabilityServicesAcct;
    }

    public CValidcombination getWriteoffRevAcct() {
        return writeoffRevAcct;
    }

    public void setWriteoffRevAcct(CValidcombination writeoffRevAcct) {
        this.writeoffRevAcct = writeoffRevAcct;
    }

    public CValidcombination getBInterestrevAcct() {
        return bInterestrevAcct;
    }

    public void setBInterestrevAcct(CValidcombination bInterestrevAcct) {
        this.bInterestrevAcct = bInterestrevAcct;
    }

    public CValidcombination getCPrepaymentAcct() {
        return cPrepaymentAcct;
    }

    public void setCPrepaymentAcct(CValidcombination cPrepaymentAcct) {
        this.cPrepaymentAcct = cPrepaymentAcct;
    }

    public CValidcombination getBSettlementgainAcct() {
        return bSettlementgainAcct;
    }

    public void setBSettlementgainAcct(CValidcombination bSettlementgainAcct) {
        this.bSettlementgainAcct = bSettlementgainAcct;
    }

    public CValidcombination getTExpenseAcct() {
        return tExpenseAcct;
    }

    public void setTExpenseAcct(CValidcombination tExpenseAcct) {
        this.tExpenseAcct = tExpenseAcct;
    }

    public CValidcombination getPInvoicepricevarianceAcct() {
        return pInvoicepricevarianceAcct;
    }

    public void setPInvoicepricevarianceAcct(CValidcombination pInvoicepricevarianceAcct) {
        this.pInvoicepricevarianceAcct = pInvoicepricevarianceAcct;
    }

    public CValidcombination getCbAssetAcct() {
        return cbAssetAcct;
    }

    public void setCbAssetAcct(CValidcombination cbAssetAcct) {
        this.cbAssetAcct = cbAssetAcct;
    }

    public CValidcombination getCbExpenseAcct() {
        return cbExpenseAcct;
    }

    public void setCbExpenseAcct(CValidcombination cbExpenseAcct) {
        this.cbExpenseAcct = cbExpenseAcct;
    }

    public CValidcombination getPaydiscountRevAcct() {
        return paydiscountRevAcct;
    }

    public void setPaydiscountRevAcct(CValidcombination paydiscountRevAcct) {
        this.paydiscountRevAcct = paydiscountRevAcct;
    }

    public CValidcombination getAAccumdepreciationAcct() {
        return aAccumdepreciationAcct;
    }

    public void setAAccumdepreciationAcct(CValidcombination aAccumdepreciationAcct) {
        this.aAccumdepreciationAcct = aAccumdepreciationAcct;
    }

    public CValidcombination getRealizedlossAcct() {
        return realizedlossAcct;
    }

    public void setRealizedlossAcct(CValidcombination realizedlossAcct) {
        this.realizedlossAcct = realizedlossAcct;
    }

    public CValidcombination getUnrealizedgainAcct() {
        return unrealizedgainAcct;
    }

    public void setUnrealizedgainAcct(CValidcombination unrealizedgainAcct) {
        this.unrealizedgainAcct = unrealizedgainAcct;
    }

    public CValidcombination getADisposalGain() {
        return aDisposalGain;
    }

    public void setADisposalGain(CValidcombination aDisposalGain) {
        this.aDisposalGain = aDisposalGain;
    }

    public CValidcombination getUnrealizedlossAcct() {
        return unrealizedlossAcct;
    }

    public void setUnrealizedlossAcct(CValidcombination unrealizedlossAcct) {
        this.unrealizedlossAcct = unrealizedlossAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctschemaDefaultId != null ? cAcctschemaDefaultId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctschemaDefault)) {
            return false;
        }
        CAcctschemaDefault other = (CAcctschemaDefault) object;
        if ((this.cAcctschemaDefaultId == null && other.cAcctschemaDefaultId != null) || (this.cAcctschemaDefaultId != null && !this.cAcctschemaDefaultId.equals(other.cAcctschemaDefaultId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctschemaDefault[ cAcctschemaDefaultId=" + cAcctschemaDefaultId + " ]";
    }
    
}
