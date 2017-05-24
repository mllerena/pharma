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
@Table(name = "c_currency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCurrency.findAll", query = "SELECT c FROM CCurrency c"),
    @NamedQuery(name = "CCurrency.findByCCurrencyId", query = "SELECT c FROM CCurrency c WHERE c.cCurrencyId = :cCurrencyId"),
    @NamedQuery(name = "CCurrency.findByIsactive", query = "SELECT c FROM CCurrency c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCurrency.findByCreated", query = "SELECT c FROM CCurrency c WHERE c.created = :created"),
    @NamedQuery(name = "CCurrency.findByCreatedby", query = "SELECT c FROM CCurrency c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCurrency.findByUpdated", query = "SELECT c FROM CCurrency c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCurrency.findByUpdatedby", query = "SELECT c FROM CCurrency c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCurrency.findByIsoCode", query = "SELECT c FROM CCurrency c WHERE c.isoCode = :isoCode"),
    @NamedQuery(name = "CCurrency.findByCursymbol", query = "SELECT c FROM CCurrency c WHERE c.cursymbol = :cursymbol"),
    @NamedQuery(name = "CCurrency.findByDescription", query = "SELECT c FROM CCurrency c WHERE c.description = :description"),
    @NamedQuery(name = "CCurrency.findByStdprecision", query = "SELECT c FROM CCurrency c WHERE c.stdprecision = :stdprecision"),
    @NamedQuery(name = "CCurrency.findByCostingprecision", query = "SELECT c FROM CCurrency c WHERE c.costingprecision = :costingprecision"),
    @NamedQuery(name = "CCurrency.findByPriceprecision", query = "SELECT c FROM CCurrency c WHERE c.priceprecision = :priceprecision"),
    @NamedQuery(name = "CCurrency.findByIssymbolrightside", query = "SELECT c FROM CCurrency c WHERE c.issymbolrightside = :issymbolrightside")})
public class CCurrency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_currency_id")
    private String cCurrencyId;
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
    @Size(min = 1, max = 3)
    @Column(name = "iso_code")
    private String isoCode;
    @Size(max = 10)
    @Column(name = "cursymbol")
    private String cursymbol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stdprecision")
    private long stdprecision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costingprecision")
    private long costingprecision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priceprecision")
    private long priceprecision;
    @Column(name = "issymbolrightside")
    private Character issymbolrightside;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<CElementvalue> cElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<AdRole> adRoleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CSettlement> cSettlementList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<MFreight> mFreightList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CBankstatementline> cBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<AdClient> adClientList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CCommission> cCommissionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<MRappel> mRappelList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<FinFinancialAccount> finFinancialAccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<FinPaymentCredit> finPaymentCreditList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<IProduct> iProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<CTaxpayment> cTaxpaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<CCashline> cCashlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<CDpManagement> cDpManagementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<GlJournalbatch> glJournalbatchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<FinPaymentSchedule> finPaymentScheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CCurrencyTrl> cCurrencyTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<MProductPo> mProductPoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<MPricelist> mPricelistList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CCommissiondetail> cCommissiondetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyIdTo")
    private List<CConversionRate> cConversionRateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CConversionRate> cConversionRateList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<FinPaymentProposal> finPaymentProposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<AAmortization> aAmortizationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<GlJournal> glJournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<MRequisition> mRequisitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<CCountry> cCountryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "freightCurrencyId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CProject> cProjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CCashbook> cCashbookList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CBankaccount> cBankaccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<AAmortizationline> aAmortizationlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCurrencyId")
    private List<CAcctschema> cAcctschemaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCurrencyId")
    private List<AdOrg> adOrgList;

    public CCurrency() {
    }

    public CCurrency(String cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CCurrency(String cCurrencyId, Character isactive, Date created, String createdby, Date updated, String updatedby, String isoCode, String description, long stdprecision, long costingprecision, long priceprecision) {
        this.cCurrencyId = cCurrencyId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isoCode = isoCode;
        this.description = description;
        this.stdprecision = stdprecision;
        this.costingprecision = costingprecision;
        this.priceprecision = priceprecision;
    }

    public String getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(String cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
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

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getCursymbol() {
        return cursymbol;
    }

    public void setCursymbol(String cursymbol) {
        this.cursymbol = cursymbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStdprecision() {
        return stdprecision;
    }

    public void setStdprecision(long stdprecision) {
        this.stdprecision = stdprecision;
    }

    public long getCostingprecision() {
        return costingprecision;
    }

    public void setCostingprecision(long costingprecision) {
        this.costingprecision = costingprecision;
    }

    public long getPriceprecision() {
        return priceprecision;
    }

    public void setPriceprecision(long priceprecision) {
        this.priceprecision = priceprecision;
    }

    public Character getIssymbolrightside() {
        return issymbolrightside;
    }

    public void setIssymbolrightside(Character issymbolrightside) {
        this.issymbolrightside = issymbolrightside;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<CElementvalue> getCElementvalueList() {
        return cElementvalueList;
    }

    public void setCElementvalueList(List<CElementvalue> cElementvalueList) {
        this.cElementvalueList = cElementvalueList;
    }

    @XmlTransient
    public List<AdRole> getAdRoleList() {
        return adRoleList;
    }

    public void setAdRoleList(List<AdRole> adRoleList) {
        this.adRoleList = adRoleList;
    }

    @XmlTransient
    public List<CSettlement> getCSettlementList() {
        return cSettlementList;
    }

    public void setCSettlementList(List<CSettlement> cSettlementList) {
        this.cSettlementList = cSettlementList;
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

    @XmlTransient
    public List<AdTest> getAdTestList() {
        return adTestList;
    }

    public void setAdTestList(List<AdTest> adTestList) {
        this.adTestList = adTestList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<STimeexpenseline> getSTimeexpenselineList() {
        return sTimeexpenselineList;
    }

    public void setSTimeexpenselineList(List<STimeexpenseline> sTimeexpenselineList) {
        this.sTimeexpenselineList = sTimeexpenselineList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<MFreight> getMFreightList() {
        return mFreightList;
    }

    public void setMFreightList(List<MFreight> mFreightList) {
        this.mFreightList = mFreightList;
    }

    @XmlTransient
    public List<CBankstatementline> getCBankstatementlineList() {
        return cBankstatementlineList;
    }

    public void setCBankstatementlineList(List<CBankstatementline> cBankstatementlineList) {
        this.cBankstatementlineList = cBankstatementlineList;
    }

    @XmlTransient
    public List<AdClient> getAdClientList() {
        return adClientList;
    }

    public void setAdClientList(List<AdClient> adClientList) {
        this.adClientList = adClientList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<CCommission> getCCommissionList() {
        return cCommissionList;
    }

    public void setCCommissionList(List<CCommission> cCommissionList) {
        this.cCommissionList = cCommissionList;
    }

    @XmlTransient
    public List<MRappel> getMRappelList() {
        return mRappelList;
    }

    public void setMRappelList(List<MRappel> mRappelList) {
        this.mRappelList = mRappelList;
    }

    @XmlTransient
    public List<FinFinancialAccount> getFinFinancialAccountList() {
        return finFinancialAccountList;
    }

    public void setFinFinancialAccountList(List<FinFinancialAccount> finFinancialAccountList) {
        this.finFinancialAccountList = finFinancialAccountList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<FinPaymentCredit> getFinPaymentCreditList() {
        return finPaymentCreditList;
    }

    public void setFinPaymentCreditList(List<FinPaymentCredit> finPaymentCreditList) {
        this.finPaymentCreditList = finPaymentCreditList;
    }

    @XmlTransient
    public List<IProduct> getIProductList() {
        return iProductList;
    }

    public void setIProductList(List<IProduct> iProductList) {
        this.iProductList = iProductList;
    }

    @XmlTransient
    public List<CTaxpayment> getCTaxpaymentList() {
        return cTaxpaymentList;
    }

    public void setCTaxpaymentList(List<CTaxpayment> cTaxpaymentList) {
        this.cTaxpaymentList = cTaxpaymentList;
    }

    @XmlTransient
    public List<CCashline> getCCashlineList() {
        return cCashlineList;
    }

    public void setCCashlineList(List<CCashline> cCashlineList) {
        this.cCashlineList = cCashlineList;
    }

    @XmlTransient
    public List<CDpManagement> getCDpManagementList() {
        return cDpManagementList;
    }

    public void setCDpManagementList(List<CDpManagement> cDpManagementList) {
        this.cDpManagementList = cDpManagementList;
    }

    @XmlTransient
    public List<GlJournalbatch> getGlJournalbatchList() {
        return glJournalbatchList;
    }

    public void setGlJournalbatchList(List<GlJournalbatch> glJournalbatchList) {
        this.glJournalbatchList = glJournalbatchList;
    }

    @XmlTransient
    public List<FinPaymentSchedule> getFinPaymentScheduleList() {
        return finPaymentScheduleList;
    }

    public void setFinPaymentScheduleList(List<FinPaymentSchedule> finPaymentScheduleList) {
        this.finPaymentScheduleList = finPaymentScheduleList;
    }

    @XmlTransient
    public List<FinPayment> getFinPaymentList() {
        return finPaymentList;
    }

    public void setFinPaymentList(List<FinPayment> finPaymentList) {
        this.finPaymentList = finPaymentList;
    }

    @XmlTransient
    public List<CCurrencyTrl> getCCurrencyTrlList() {
        return cCurrencyTrlList;
    }

    public void setCCurrencyTrlList(List<CCurrencyTrl> cCurrencyTrlList) {
        this.cCurrencyTrlList = cCurrencyTrlList;
    }

    @XmlTransient
    public List<MProductPo> getMProductPoList() {
        return mProductPoList;
    }

    public void setMProductPoList(List<MProductPo> mProductPoList) {
        this.mProductPoList = mProductPoList;
    }

    @XmlTransient
    public List<MPricelist> getMPricelistList() {
        return mPricelistList;
    }

    public void setMPricelistList(List<MPricelist> mPricelistList) {
        this.mPricelistList = mPricelistList;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList() {
        return iBudgetlineList;
    }

    public void setIBudgetlineList(List<IBudgetline> iBudgetlineList) {
        this.iBudgetlineList = iBudgetlineList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<MRequisitionline> getMRequisitionlineList() {
        return mRequisitionlineList;
    }

    public void setMRequisitionlineList(List<MRequisitionline> mRequisitionlineList) {
        this.mRequisitionlineList = mRequisitionlineList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<CRevenuerecognitionPlan> getCRevenuerecognitionPlanList() {
        return cRevenuerecognitionPlanList;
    }

    public void setCRevenuerecognitionPlanList(List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList) {
        this.cRevenuerecognitionPlanList = cRevenuerecognitionPlanList;
    }

    @XmlTransient
    public List<CCommissiondetail> getCCommissiondetailList() {
        return cCommissiondetailList;
    }

    public void setCCommissiondetailList(List<CCommissiondetail> cCommissiondetailList) {
        this.cCommissiondetailList = cCommissiondetailList;
    }

    @XmlTransient
    public List<CConversionRate> getCConversionRateList() {
        return cConversionRateList;
    }

    public void setCConversionRateList(List<CConversionRate> cConversionRateList) {
        this.cConversionRateList = cConversionRateList;
    }

    @XmlTransient
    public List<CConversionRate> getCConversionRateList1() {
        return cConversionRateList1;
    }

    public void setCConversionRateList1(List<CConversionRate> cConversionRateList1) {
        this.cConversionRateList1 = cConversionRateList1;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<FinFinaccTransaction> getFinFinaccTransactionList() {
        return finFinaccTransactionList;
    }

    public void setFinFinaccTransactionList(List<FinFinaccTransaction> finFinaccTransactionList) {
        this.finFinaccTransactionList = finFinaccTransactionList;
    }

    @XmlTransient
    public List<FinPaymentProposal> getFinPaymentProposalList() {
        return finPaymentProposalList;
    }

    public void setFinPaymentProposalList(List<FinPaymentProposal> finPaymentProposalList) {
        this.finPaymentProposalList = finPaymentProposalList;
    }

    @XmlTransient
    public List<AAmortization> getAAmortizationList() {
        return aAmortizationList;
    }

    public void setAAmortizationList(List<AAmortization> aAmortizationList) {
        this.aAmortizationList = aAmortizationList;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
    }

    @XmlTransient
    public List<AAsset> getAAssetList() {
        return aAssetList;
    }

    public void setAAssetList(List<AAsset> aAssetList) {
        this.aAssetList = aAssetList;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList() {
        return cDebtPaymentList;
    }

    public void setCDebtPaymentList(List<CDebtPayment> cDebtPaymentList) {
        this.cDebtPaymentList = cDebtPaymentList;
    }

    @XmlTransient
    public List<GlJournal> getGlJournalList() {
        return glJournalList;
    }

    public void setGlJournalList(List<GlJournal> glJournalList) {
        this.glJournalList = glJournalList;
    }

    @XmlTransient
    public List<MRequisition> getMRequisitionList() {
        return mRequisitionList;
    }

    public void setMRequisitionList(List<MRequisition> mRequisitionList) {
        this.mRequisitionList = mRequisitionList;
    }

    @XmlTransient
    public List<CCountry> getCCountryList() {
        return cCountryList;
    }

    public void setCCountryList(List<CCountry> cCountryList) {
        this.cCountryList = cCountryList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @XmlTransient
    public List<CCashbook> getCCashbookList() {
        return cCashbookList;
    }

    public void setCCashbookList(List<CCashbook> cCashbookList) {
        this.cCashbookList = cCashbookList;
    }

    @XmlTransient
    public List<CBankaccount> getCBankaccountList() {
        return cBankaccountList;
    }

    public void setCBankaccountList(List<CBankaccount> cBankaccountList) {
        this.cBankaccountList = cBankaccountList;
    }

    @XmlTransient
    public List<AAmortizationline> getAAmortizationlineList() {
        return aAmortizationlineList;
    }

    public void setAAmortizationlineList(List<AAmortizationline> aAmortizationlineList) {
        this.aAmortizationlineList = aAmortizationlineList;
    }

    @XmlTransient
    public List<CAcctschema> getCAcctschemaList() {
        return cAcctschemaList;
    }

    public void setCAcctschemaList(List<CAcctschema> cAcctschemaList) {
        this.cAcctschemaList = cAcctschemaList;
    }

    @XmlTransient
    public List<AdOrg> getAdOrgList() {
        return adOrgList;
    }

    public void setAdOrgList(List<AdOrg> adOrgList) {
        this.adOrgList = adOrgList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCurrencyId != null ? cCurrencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCurrency)) {
            return false;
        }
        CCurrency other = (CCurrency) object;
        if ((this.cCurrencyId == null && other.cCurrencyId != null) || (this.cCurrencyId != null && !this.cCurrencyId.equals(other.cCurrencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCurrency[ cCurrencyId=" + cCurrencyId + " ]";
    }
    
}
