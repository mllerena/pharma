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
import javax.persistence.FetchType;
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
@Table(name = "ad_org")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdOrg.findAll", query = "SELECT a FROM AdOrg a"),
    @NamedQuery(name = "AdOrg.findByAdOrgId", query = "SELECT a FROM AdOrg a WHERE a.adOrgId = :adOrgId"),
    @NamedQuery(name = "AdOrg.findByIsactive", query = "SELECT a FROM AdOrg a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdOrg.findByCreated", query = "SELECT a FROM AdOrg a WHERE a.created = :created"),
    @NamedQuery(name = "AdOrg.findByCreatedby", query = "SELECT a FROM AdOrg a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdOrg.findByUpdated", query = "SELECT a FROM AdOrg a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdOrg.findByUpdatedby", query = "SELECT a FROM AdOrg a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdOrg.findByValue", query = "SELECT a FROM AdOrg a WHERE a.value = :value"),
    @NamedQuery(name = "AdOrg.findByName", query = "SELECT a FROM AdOrg a WHERE a.name = :name"),
    @NamedQuery(name = "AdOrg.findByDescription", query = "SELECT a FROM AdOrg a WHERE a.description = :description"),
    @NamedQuery(name = "AdOrg.findByIssummary", query = "SELECT a FROM AdOrg a WHERE a.issummary = :issummary"),
    @NamedQuery(name = "AdOrg.findByIsperiodcontrolallowed", query = "SELECT a FROM AdOrg a WHERE a.isperiodcontrolallowed = :isperiodcontrolallowed"),
    @NamedQuery(name = "AdOrg.findByIsready", query = "SELECT a FROM AdOrg a WHERE a.isready = :isready"),
    @NamedQuery(name = "AdOrg.findBySocialName", query = "SELECT a FROM AdOrg a WHERE a.socialName = :socialName")})
public class AdOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_org_id")
    private String adOrgId;
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
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issummary")
    private Character issummary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isperiodcontrolallowed")
    private Character isperiodcontrolallowed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isready")
    private Character isready;
    @Size(max = 60)
    @Column(name = "social_name")
    private String socialName;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaPlInvoiceline> maPlInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoicelineOffer> cInvoicelineOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMaintenance> maMaintenanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaSection> maSectionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdProcessScheduling> adProcessSchedulingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaProcessplanVersion> maProcessplanVersionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CSalaryCategory> cSalaryCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjectphase> cProjectphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CExternalposCategory> cExternalposCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCampaign> cCampaignList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RRequesttype> rRequesttypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IInvoice> iInvoiceList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTreebar> adTreebarList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MAttribute> mAttributeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModuleDependencyInst> adModuleDependencyInstList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxcategoryTrl> cTaxcategoryTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CElementvalue> cElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<CPocEmail> cPocEmailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaSequenceMachine> maSequenceMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctschemaTableDoctype> cAcctschemaTableDoctypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdForm> adFormList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IBankstatement> iBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdExceptions> adExceptionsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRefList> adRefListList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCountryTrl> cCountryTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<MProduction> mProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProduction> mProductionList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RRequestprocessor> rRequestprocessorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adForcedOrgId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpartner> cBpartnerList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<MInventory> mInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MInventory> mInventoryList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRappelProductcategory> mRappelProductcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPeriodcontrol> cPeriodcontrolList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRole> adRoleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdMessageTrl> adMessageTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjectissue> cProjectissueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductionline> mProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTreenode> adTreenodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWfNodeTrl> adWfNodeTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<SResource> sResourceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjecttype> cProjecttypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AtRollogin> atRolloginList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdColumn> adColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdImage> adImageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTableAccess> adTableAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTreenodepr> adTreenodeprList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTax> cTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModelObjectPara> adModelObjectParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CSettlement> cSettlementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CDoctypeTrl> cDoctypeTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMaintOperation> maMaintOperationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinMatchingAlgorithm> finMatchingAlgorithmList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCurrency> cCurrencyList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaIndirectCost> maIndirectCostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CActivity> cActivityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RResourceplancost> rResourceplancostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MFreightcategory> mFreightcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpPlanningmethod> mrpPlanningmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<GlCategory> glCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpRunPurchase> mrpRunPurchaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdClientmodule> adClientmoduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpEmployeeAcct> cBpEmployeeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjectAcct> cProjectAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaWeincidence> maWeincidenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<CInvoice> cInvoiceList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AAssetGroup> aAssetGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxregister> cTaxregisterList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdPreference> adPreferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "visibleatOrgId")
    private List<AdPreference> adPreferenceList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<CChargeAcct> cChargeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaCostcenterIc> maCostcenterIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxTrl> cTaxTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdElementTrl> adElementTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdHbLogCquery> adHbLogCqueryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AAssetGroupAcct> aAssetGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaPcValue> maPcValueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctschemaProcess> cAcctschemaProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CDoctype> cDoctypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRequisitionorder> mRequisitionorderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<COrderlineOffer> cOrderlineOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<IGljournal> iGljournalList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgdocId")
    private List<IGljournal> iGljournalList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaCostcenterMachine> maCostcenterMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxReport> cTaxReportList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaIndirectCostValue> maIndirectCostValueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCalendar> cCalendarList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdFormTrl> adFormTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpPlanningmethodline> mrpPlanningmethodlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdMenu> adMenuList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductCustomer> mProductCustomerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRappelProduct> mRappelProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AAssetAcct> aAssetAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CGreetingTrl> cGreetingTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMaintPart> maMaintPartList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MFreight> mFreightList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<SResourceassignment> sResourceassignmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRefListTrl> adRefListTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CElement> cElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FactAcctCfs> factAcctCfsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRefSearch> adRefSearchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpartnerLocation> cBpartnerLocationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinBankstatementline> finBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RInterestarea> rInterestareaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductTemplate> mProductTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModuleDbprefix> adModuleDbprefixList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoicelinetax> cInvoicelinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaToolsetused> maToolsetusedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBankstatementline> cBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdAcctprocess> adAcctprocessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTaskTrl> adTaskTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoiceDiscount> cInvoiceDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MWarehouse> mWarehouseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaWorkrequirement> maWorkrequirementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CRemittance> cRemittanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMaintWorker> maMaintWorkerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AtCommandTrl> atCommandTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMaintScheduled> maMaintScheduledList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdAlertrecipient> adAlertrecipientList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctschemaDefault> cAcctschemaDefaultList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWfNode> adWfNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModuleTrl> adModuleTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CYear> cYearList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MSubstitute> mSubstituteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MWhScheduleProduct> mWhScheduleProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MInternalConsumption> mInternalConsumptionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdClient> adClientList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<COrder> cOrderList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCommission> cCommissionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CNonbusinessday> cNonbusinessdayList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaSequence> maSequenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRappel> mRappelList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductOrg> mProductOrgList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MWarehouseAcct> mWarehouseAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RMailtext> rMailtextList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpGroup> cBpGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CElementvalueTrl> cElementvalueTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinFinancialAccount> finFinancialAccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<IOrder> iOrderList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdReferenceTrl> adReferenceTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTextinterfacesTrl> adTextinterfacesTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentCredit> finPaymentCreditList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<AdUser> adUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdUser> adUserList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "defaultAdOrgId")
    private List<AdUser> adUserList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AtTestdocumentline> atTestdocumentlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinFinaccPaymentmethod> finFinaccPaymentmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<COrderDiscount> cOrderDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IProduct> iProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxpayment> cTaxpaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdSessionStatus> adSessionStatusList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdSystemInfo> adSystemInfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<COrderlinetax> cOrderlinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCashline> cCashlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCommissionrun> cCommissionrunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjectproposal> cProjectproposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaPlIc> maPlIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpartnerDiscount> cBpartnerDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IBpartner> iBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CUomConversion> cUomConversionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<CTaxZone> cTaxZoneList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CDpManagement> cDpManagementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AtTestdocument> atTestdocumentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CDebtPaymentBalReplace> cDebtPaymentBalReplaceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaCcp> maCcpList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTree> adTreeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<GlJournalbatch> glJournalbatchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdHeartbeatLog> adHeartbeatLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdSequence> adSequenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTextinterfaces> adTextinterfacesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CIncoterms> cIncotermsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentSchedule> finPaymentScheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdDataset> adDatasetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<CValidcombination> cValidcombinationList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdAlertruleTrl> adAlertruleTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjectVendor> cProjectVendorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdDatasetColumn> adDatasetColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCommissionamt> cCommissionamtList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTask> cTaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CFile> cFileList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctRptNode> cAcctRptNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWindowAccess> adWindowAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCurrencyTrl> cCurrencyTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductAcct> mProductAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaProcess> maProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaToolsetType> maToolsetTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MCosting> mCostingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModule> adModuleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRefTable> adRefTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IInventory> iInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdFieldTrl> adFieldTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBankstatement> cBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MSernoctl> mSernoctlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCity> cCityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductPo> mProductPoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IElementvalue> iElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdProcessRun> adProcessRunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWorkflowTrl> adWorkflowTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPeriodcontrolLog> cPeriodcontrolLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctschemaGl> cAcctschemaGlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CRemittanceParameter> cRemittanceParameterList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MInternalConsumptionline> mInternalConsumptionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentRunPara> finPaymentRunParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaGlobaluse> maGlobaluseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjectproposaltask> cProjectproposaltaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MOfferProduct> mOfferProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MAttributevalue> mAttributevalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxAcct> cTaxAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CDebtPaymentBalancing> cDebtPaymentBalancingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CServicelevel> cServicelevelList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdNote> adNoteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MMatchinv> mMatchinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpGroupAcct> cBpGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdProcessParaTrl> adProcessParaTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoiceschedule> cInvoicescheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaToolset> maToolsetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaCostcenter> maCostcenterList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRoleOrgaccess> adRoleOrgaccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinReclineTemp> finReclineTempList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RContactinterest> rContactinterestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdChangelog> adChangelogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaCostcenterEmployee> maCostcenterEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModelObject> adModelObjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MPricelist> mPricelistList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjecttask> cProjecttaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdDatasetTable> adDatasetTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMachinestation> maMachinestationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpBankaccount> cBpBankaccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<IBudgetline> iBudgetlineList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdDimension> adDimensionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdDatatype> adDatatypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdReference> adReferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxcategory> cTaxcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CServicelevelline> cServicelevellineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaProcessplan> maProcessplanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdMonth> adMonthList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPayExecProcess> finPayExecProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdErrorLog> adErrorLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBudget> cBudgetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<FactAcct> factAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MPricelistVersion> mPricelistVersionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<AdPinstance> adPinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModuleMerge> adModuleMergeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMachineCost> maMachineCostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CExternalpos> cExternalposList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdFieldgroupTrl> adFieldgroupTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpRunProduction> mrpRunProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<AdPinstancePara> adPinstanceParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdAuxiliarinput> adAuxiliarinputList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinBankfileFormat> finBankfileFormatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AtLine> atLineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<CPocEmailUser> cPocEmailUserList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adOrg")
    private AdOrginfo adOrginfo;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MInventoryline> mInventorylineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MAttributeinstance> mAttributeinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgtoId")
    private List<CInterorgAcct> cInterorgAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInterorgAcct> cInterorgAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaSequenceIc> maSequenceIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "orgId")
    private List<CCommissionline> cCommissionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCommissionline> cCommissionlineList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdCreatefactTemplate> adCreatefactTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CChannel> cChannelList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaWeemployee> maWeemployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaSequenceproduct> maSequenceproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoicetax> cInvoicetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<MMovement> mMovementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MMovement> mMovementList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinBankstatement> finBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPaymentterm> cPaymenttermList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPaymenttermline> cPaymenttermlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CRemittanceType> cRemittanceTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentPriority> finPaymentPriorityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MOfferBpartner> mOfferBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMeasureValues> maMeasureValuesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctRptGroup> cAcctRptGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdImpformatRow> adImpformatRowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCharge> cChargeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductBom> mProductBomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTab> adTabList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTaskAccess> adTaskAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentRun> finPaymentRunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWfNodenext> adWfNodenextList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MLot> mLotList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<SResourceunavailable> sResourceunavailableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MTransaction> mTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxregisterTypeLines> cTaxregisterTypeLinesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductTrl> mProductTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTable> adTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdAttachment> adAttachmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MOffer> mOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMeasureTime> maMeasureTimeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMachine> maMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CRevenuerecognition> cRevenuerecognitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MReplenish> mReplenishList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CGlitemAcct> cGlitemAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaWorkstation> maWorkstationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdProcessPara> adProcessParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdOrgAcctschema> adOrgAcctschemaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaWrphase> maWrphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctRpt> cAcctRptList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModuleLog> adModuleLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCommissiondetail> cCommissiondetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWorkflow> adWorkflowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaPcCase> maPcCaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MPerpetualinv> mPerpetualinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MStoragePending> mStoragePendingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdValRule> adValRuleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWindowTrl> adWindowTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MAttributeuse> mAttributeuseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CConversionRate> cConversionRateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxregisterline> cTaxregisterlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductCategoryAcct> mProductCategoryAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CUom> cUomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CGreeting> cGreetingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<COrdertax> cOrdertaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpSalcategory> cBpSalcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPocConfiguration> cPocConfigurationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModuleDependency> adModuleDependencyList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductCategory> mProductCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBank> cBankList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MOfferPricelist> mOfferPricelistList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MWhPeriodInvoiced> mWhPeriodInvoicedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdProcessAccess> adProcessAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MWarehouseShipper> mWarehouseShipperList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRappelScale> mRappelScaleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdAccountingrptElement> adAccountingrptElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpWithholding> cBpWithholdingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MStorageDetail> mStorageDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdExtensionPoints> adExtensionPointsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaCcpShift> maCcpShiftList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTreenodebp> adTreenodebpList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMeasureShift> maMeasureShiftList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<AdElement> adElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<SExpensetype> sExpensetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinReconciliation> finReconciliationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRefDataLoaded> adRefDataLoadedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdOrgmodule> adOrgmoduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<SResourcetype> sResourcetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CWithholding> cWithholdingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaPlEmployee> maPlEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdAlertrule> adAlertruleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpSalesforecast> mrpSalesforecastList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdProcess> adProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdProcessTrl> adProcessTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CRevenuerecognitionRun> cRevenuerecognitionRunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdOrgClosing> adOrgClosingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MAttributesetinstance> mAttributesetinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MMovementline> mMovementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductionplan> mProductionplanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CLocation> cLocationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctschemaTable> cAcctschemaTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MDiscountschema> mDiscountschemaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MOfferBpGroup> mOfferBpGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdEpProcedures> adEpProceduresList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpTaxcategory> cBpTaxcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpVendorAcct> cBpVendorAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdSession> adSessionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CRemittanceline> cRemittancelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaToolsetprocess> maToolsetprocessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MLocator> mLocatorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpRunProductionline> mrpRunProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MShipper> mShipperList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPhase> cPhaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdMonthTrl> adMonthTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<ITax> iTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductUom> mProductUomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentRunPayment> finPaymentRunPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaSequenceEmployee> maSequenceEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjectproposalline> cProjectproposallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CTaxregisterType> cTaxregisterTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdSessionUsageAudit> adSessionUsageAuditList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProjectline> cProjectlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdPackage> adPackageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CInvoiceReverse> cInvoiceReverseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdFormAccess> adFormAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AtCommand> atCommandList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBpCustomerAcct> cBpCustomerAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaPlMachine> maPlMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MProductprice> mProductpriceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentProposal> finPaymentProposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdHbLogCqueryRow> adHbLogCqueryRowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AAmortization> aAmortizationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModuleInstall> adModuleInstallList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPocEmaildefinition> cPocEmaildefinitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWorkflowAccess> adWorkflowAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<CWithholdingAcct> cWithholdingAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgId")
    private List<STimetype> sTimetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPaymenttermTrl> cPaymenttermTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentPropDetail> finPaymentPropDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MDiscountschemaline> mDiscountschemalineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdImpformat> adImpformatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModuleDbprefixInstall> adModuleDbprefixInstallList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMachineType> maMachineTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdOrgtype> adOrgtypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTabTrl> adTabTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MMatchpo> mMatchpoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RRequestprocessorRoute> rRequestprocessorRouteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<STimeexpense> sTimeexpenseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPromissoryformat> cPromissoryformatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaCcpGroup> maCcpGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<CBudgetline> cBudgetlineList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaPcTest> maPcTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CUomTrl> cUomTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPayExecProcessPara> finPayExecProcessParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentDetail> finPaymentDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTask> adTaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaWrphaseproduct> maWrphaseproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "orgId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctschemaElement> cAcctschemaElementList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPeriod> cPeriodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdLanguage> adLanguageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdProcessRequest> adProcessRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdPropertyConfiguration> adPropertyConfigurationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AtTest> atTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MLocatorType> mLocatorTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<GlJournal> glJournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMeasureGroup> maMeasureGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRequisition> mRequisitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdTreenodemm> adTreenodemmList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CDiscount> cDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpSalesforecastline> mrpSalesforecastlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaCostcenterVersion> maCostcenterVersionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRegistrationInfo> adRegistrationInfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<COrgassignment> cOrgassignmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CRegion> cRegionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaIncidence> maIncidenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRappelInvoice> mRappelInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MWhPeriod> mWhPeriodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCashbookAcct> cCashbookAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdAlert> adAlertList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCountry> cCountryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MOfferProdCat> mOfferProdCatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MInoutline> mInoutlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MInout> mInoutList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CElementvalueOperand> cElementvalueOperandList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CProject> cProjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MAttributeset> mAttributesetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdMenuTrl> adMenuTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CSalesregion> cSalesregionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCashbook> cCashbookList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdSystem> adSystemList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CGlitem> cGlitemList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<FinPaymentmethod> finPaymentmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBankaccount> cBankaccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdCallout> adCalloutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdModelObjectMapping> adModelObjectMappingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdUserRoles> adUserRolesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MLotctl> mLotctlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CDpManagementline> cDpManagementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CExternalposProduct> cExternalposProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdColumnAccess> adColumnAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdWindow> adWindowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MWhSchedule> mWhScheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgtrxId")
    private List<CCash> cCashList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CCash> cCashList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MRappelBpartner> mRappelBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRefSearchColumn> adRefSearchColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MrpPlanner> mrpPlannerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdFieldgroup> adFieldgroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CSalaryCategoryCost> cSalaryCategoryCostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdMessage> adMessageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CPocDoctypeTemplate> cPocDoctypeTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<RRequestaction> rRequestactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaMaintPeriodicity> maMaintPeriodicityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AAmortizationline> aAmortizationlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdRecordAccess> adRecordAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<AdField> adFieldList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CAcctschema> cAcctschemaList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_orgtype_id", referencedColumnName = "ad_orgtype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrgtype adOrgtypeId;
    @JoinColumn(name = "c_calendar_id", referencedColumnName = "c_calendar_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCalendar cCalendarId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<MaPeriodicControl> maPeriodicControlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgId")
    private List<CBankaccountAcct> cBankaccountAcctList;

    public AdOrg() {
    }

    public AdOrg(String adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdOrg(String adOrgId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, Character issummary, Character isperiodcontrolallowed, Character isready) {
        this.adOrgId = adOrgId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.issummary = issummary;
        this.isperiodcontrolallowed = isperiodcontrolallowed;
        this.isready = isready;
    }

    public String getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(String adOrgId) {
        this.adOrgId = adOrgId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
    }

    public Character getIsperiodcontrolallowed() {
        return isperiodcontrolallowed;
    }

    public void setIsperiodcontrolallowed(Character isperiodcontrolallowed) {
        this.isperiodcontrolallowed = isperiodcontrolallowed;
    }

    public Character getIsready() {
        return isready;
    }

    public void setIsready(Character isready) {
        this.isready = isready;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    @XmlTransient
    public List<MaPlInvoiceline> getMaPlInvoicelineList() {
        return maPlInvoicelineList;
    }

    public void setMaPlInvoicelineList(List<MaPlInvoiceline> maPlInvoicelineList) {
        this.maPlInvoicelineList = maPlInvoicelineList;
    }

    @XmlTransient
    public List<CInvoicelineOffer> getCInvoicelineOfferList() {
        return cInvoicelineOfferList;
    }

    public void setCInvoicelineOfferList(List<CInvoicelineOffer> cInvoicelineOfferList) {
        this.cInvoicelineOfferList = cInvoicelineOfferList;
    }

    @XmlTransient
    public List<MaMaintenance> getMaMaintenanceList() {
        return maMaintenanceList;
    }

    public void setMaMaintenanceList(List<MaMaintenance> maMaintenanceList) {
        this.maMaintenanceList = maMaintenanceList;
    }

    @XmlTransient
    public List<MaSection> getMaSectionList() {
        return maSectionList;
    }

    public void setMaSectionList(List<MaSection> maSectionList) {
        this.maSectionList = maSectionList;
    }

    @XmlTransient
    public List<AdProcessScheduling> getAdProcessSchedulingList() {
        return adProcessSchedulingList;
    }

    public void setAdProcessSchedulingList(List<AdProcessScheduling> adProcessSchedulingList) {
        this.adProcessSchedulingList = adProcessSchedulingList;
    }

    @XmlTransient
    public List<MaProcessplanVersion> getMaProcessplanVersionList() {
        return maProcessplanVersionList;
    }

    public void setMaProcessplanVersionList(List<MaProcessplanVersion> maProcessplanVersionList) {
        this.maProcessplanVersionList = maProcessplanVersionList;
    }

    @XmlTransient
    public List<CSalaryCategory> getCSalaryCategoryList() {
        return cSalaryCategoryList;
    }

    public void setCSalaryCategoryList(List<CSalaryCategory> cSalaryCategoryList) {
        this.cSalaryCategoryList = cSalaryCategoryList;
    }

    @XmlTransient
    public List<CProjectphase> getCProjectphaseList() {
        return cProjectphaseList;
    }

    public void setCProjectphaseList(List<CProjectphase> cProjectphaseList) {
        this.cProjectphaseList = cProjectphaseList;
    }

    @XmlTransient
    public List<CExternalposCategory> getCExternalposCategoryList() {
        return cExternalposCategoryList;
    }

    public void setCExternalposCategoryList(List<CExternalposCategory> cExternalposCategoryList) {
        this.cExternalposCategoryList = cExternalposCategoryList;
    }

    @XmlTransient
    public List<CCampaign> getCCampaignList() {
        return cCampaignList;
    }

    public void setCCampaignList(List<CCampaign> cCampaignList) {
        this.cCampaignList = cCampaignList;
    }

    @XmlTransient
    public List<RRequesttype> getRRequesttypeList() {
        return rRequesttypeList;
    }

    public void setRRequesttypeList(List<RRequesttype> rRequesttypeList) {
        this.rRequesttypeList = rRequesttypeList;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList1() {
        return iInvoiceList1;
    }

    public void setIInvoiceList1(List<IInvoice> iInvoiceList1) {
        this.iInvoiceList1 = iInvoiceList1;
    }

    @XmlTransient
    public List<AdTreebar> getAdTreebarList() {
        return adTreebarList;
    }

    public void setAdTreebarList(List<AdTreebar> adTreebarList) {
        this.adTreebarList = adTreebarList;
    }

    @XmlTransient
    public List<MAttribute> getMAttributeList() {
        return mAttributeList;
    }

    public void setMAttributeList(List<MAttribute> mAttributeList) {
        this.mAttributeList = mAttributeList;
    }

    @XmlTransient
    public List<AdModuleDependencyInst> getAdModuleDependencyInstList() {
        return adModuleDependencyInstList;
    }

    public void setAdModuleDependencyInstList(List<AdModuleDependencyInst> adModuleDependencyInstList) {
        this.adModuleDependencyInstList = adModuleDependencyInstList;
    }

    @XmlTransient
    public List<CTaxcategoryTrl> getCTaxcategoryTrlList() {
        return cTaxcategoryTrlList;
    }

    public void setCTaxcategoryTrlList(List<CTaxcategoryTrl> cTaxcategoryTrlList) {
        this.cTaxcategoryTrlList = cTaxcategoryTrlList;
    }

    @XmlTransient
    public List<CElementvalue> getCElementvalueList() {
        return cElementvalueList;
    }

    public void setCElementvalueList(List<CElementvalue> cElementvalueList) {
        this.cElementvalueList = cElementvalueList;
    }

    @XmlTransient
    public List<CPocEmail> getCPocEmailList() {
        return cPocEmailList;
    }

    public void setCPocEmailList(List<CPocEmail> cPocEmailList) {
        this.cPocEmailList = cPocEmailList;
    }

    @XmlTransient
    public List<MaSequenceMachine> getMaSequenceMachineList() {
        return maSequenceMachineList;
    }

    public void setMaSequenceMachineList(List<MaSequenceMachine> maSequenceMachineList) {
        this.maSequenceMachineList = maSequenceMachineList;
    }

    @XmlTransient
    public List<CAcctschemaTableDoctype> getCAcctschemaTableDoctypeList() {
        return cAcctschemaTableDoctypeList;
    }

    public void setCAcctschemaTableDoctypeList(List<CAcctschemaTableDoctype> cAcctschemaTableDoctypeList) {
        this.cAcctschemaTableDoctypeList = cAcctschemaTableDoctypeList;
    }

    @XmlTransient
    public List<AdForm> getAdFormList() {
        return adFormList;
    }

    public void setAdFormList(List<AdForm> adFormList) {
        this.adFormList = adFormList;
    }

    @XmlTransient
    public List<IBankstatement> getIBankstatementList() {
        return iBankstatementList;
    }

    public void setIBankstatementList(List<IBankstatement> iBankstatementList) {
        this.iBankstatementList = iBankstatementList;
    }

    @XmlTransient
    public List<AdExceptions> getAdExceptionsList() {
        return adExceptionsList;
    }

    public void setAdExceptionsList(List<AdExceptions> adExceptionsList) {
        this.adExceptionsList = adExceptionsList;
    }

    @XmlTransient
    public List<AdRefList> getAdRefListList() {
        return adRefListList;
    }

    public void setAdRefListList(List<AdRefList> adRefListList) {
        this.adRefListList = adRefListList;
    }

    @XmlTransient
    public List<CCountryTrl> getCCountryTrlList() {
        return cCountryTrlList;
    }

    public void setCCountryTrlList(List<CCountryTrl> cCountryTrlList) {
        this.cCountryTrlList = cCountryTrlList;
    }

    @XmlTransient
    public List<MProduction> getMProductionList() {
        return mProductionList;
    }

    public void setMProductionList(List<MProduction> mProductionList) {
        this.mProductionList = mProductionList;
    }

    @XmlTransient
    public List<MProduction> getMProductionList1() {
        return mProductionList1;
    }

    public void setMProductionList1(List<MProduction> mProductionList1) {
        this.mProductionList1 = mProductionList1;
    }

    @XmlTransient
    public List<RRequestprocessor> getRRequestprocessorList() {
        return rRequestprocessorList;
    }

    public void setRRequestprocessorList(List<RRequestprocessor> rRequestprocessorList) {
        this.rRequestprocessorList = rRequestprocessorList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList1() {
        return cBpartnerList1;
    }

    public void setCBpartnerList1(List<CBpartner> cBpartnerList1) {
        this.cBpartnerList1 = cBpartnerList1;
    }

    @XmlTransient
    public List<MInventory> getMInventoryList() {
        return mInventoryList;
    }

    public void setMInventoryList(List<MInventory> mInventoryList) {
        this.mInventoryList = mInventoryList;
    }

    @XmlTransient
    public List<MInventory> getMInventoryList1() {
        return mInventoryList1;
    }

    public void setMInventoryList1(List<MInventory> mInventoryList1) {
        this.mInventoryList1 = mInventoryList1;
    }

    @XmlTransient
    public List<MRappelProductcategory> getMRappelProductcategoryList() {
        return mRappelProductcategoryList;
    }

    public void setMRappelProductcategoryList(List<MRappelProductcategory> mRappelProductcategoryList) {
        this.mRappelProductcategoryList = mRappelProductcategoryList;
    }

    @XmlTransient
    public List<CPeriodcontrol> getCPeriodcontrolList() {
        return cPeriodcontrolList;
    }

    public void setCPeriodcontrolList(List<CPeriodcontrol> cPeriodcontrolList) {
        this.cPeriodcontrolList = cPeriodcontrolList;
    }

    @XmlTransient
    public List<AdRole> getAdRoleList() {
        return adRoleList;
    }

    public void setAdRoleList(List<AdRole> adRoleList) {
        this.adRoleList = adRoleList;
    }

    @XmlTransient
    public List<AdMessageTrl> getAdMessageTrlList() {
        return adMessageTrlList;
    }

    public void setAdMessageTrlList(List<AdMessageTrl> adMessageTrlList) {
        this.adMessageTrlList = adMessageTrlList;
    }

    @XmlTransient
    public List<FinPaymentScheduledetail> getFinPaymentScheduledetailList() {
        return finPaymentScheduledetailList;
    }

    public void setFinPaymentScheduledetailList(List<FinPaymentScheduledetail> finPaymentScheduledetailList) {
        this.finPaymentScheduledetailList = finPaymentScheduledetailList;
    }

    @XmlTransient
    public List<CProjectissue> getCProjectissueList() {
        return cProjectissueList;
    }

    public void setCProjectissueList(List<CProjectissue> cProjectissueList) {
        this.cProjectissueList = cProjectissueList;
    }

    @XmlTransient
    public List<MProductionline> getMProductionlineList() {
        return mProductionlineList;
    }

    public void setMProductionlineList(List<MProductionline> mProductionlineList) {
        this.mProductionlineList = mProductionlineList;
    }

    @XmlTransient
    public List<AdTreenode> getAdTreenodeList() {
        return adTreenodeList;
    }

    public void setAdTreenodeList(List<AdTreenode> adTreenodeList) {
        this.adTreenodeList = adTreenodeList;
    }

    @XmlTransient
    public List<AdWfNodeTrl> getAdWfNodeTrlList() {
        return adWfNodeTrlList;
    }

    public void setAdWfNodeTrlList(List<AdWfNodeTrl> adWfNodeTrlList) {
        this.adWfNodeTrlList = adWfNodeTrlList;
    }

    @XmlTransient
    public List<SResource> getSResourceList() {
        return sResourceList;
    }

    public void setSResourceList(List<SResource> sResourceList) {
        this.sResourceList = sResourceList;
    }

    @XmlTransient
    public List<CProjecttype> getCProjecttypeList() {
        return cProjecttypeList;
    }

    public void setCProjecttypeList(List<CProjecttype> cProjecttypeList) {
        this.cProjecttypeList = cProjecttypeList;
    }

    @XmlTransient
    public List<AtRollogin> getAtRolloginList() {
        return atRolloginList;
    }

    public void setAtRolloginList(List<AtRollogin> atRolloginList) {
        this.atRolloginList = atRolloginList;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<AdColumn> getAdColumnList() {
        return adColumnList;
    }

    public void setAdColumnList(List<AdColumn> adColumnList) {
        this.adColumnList = adColumnList;
    }

    @XmlTransient
    public List<AdImage> getAdImageList() {
        return adImageList;
    }

    public void setAdImageList(List<AdImage> adImageList) {
        this.adImageList = adImageList;
    }

    @XmlTransient
    public List<AdTableAccess> getAdTableAccessList() {
        return adTableAccessList;
    }

    public void setAdTableAccessList(List<AdTableAccess> adTableAccessList) {
        this.adTableAccessList = adTableAccessList;
    }

    @XmlTransient
    public List<AdTreenodepr> getAdTreenodeprList() {
        return adTreenodeprList;
    }

    public void setAdTreenodeprList(List<AdTreenodepr> adTreenodeprList) {
        this.adTreenodeprList = adTreenodeprList;
    }

    @XmlTransient
    public List<CTax> getCTaxList() {
        return cTaxList;
    }

    public void setCTaxList(List<CTax> cTaxList) {
        this.cTaxList = cTaxList;
    }

    @XmlTransient
    public List<AdModelObjectPara> getAdModelObjectParaList() {
        return adModelObjectParaList;
    }

    public void setAdModelObjectParaList(List<AdModelObjectPara> adModelObjectParaList) {
        this.adModelObjectParaList = adModelObjectParaList;
    }

    @XmlTransient
    public List<CSettlement> getCSettlementList() {
        return cSettlementList;
    }

    public void setCSettlementList(List<CSettlement> cSettlementList) {
        this.cSettlementList = cSettlementList;
    }

    @XmlTransient
    public List<CDoctypeTrl> getCDoctypeTrlList() {
        return cDoctypeTrlList;
    }

    public void setCDoctypeTrlList(List<CDoctypeTrl> cDoctypeTrlList) {
        this.cDoctypeTrlList = cDoctypeTrlList;
    }

    @XmlTransient
    public List<MaMaintOperation> getMaMaintOperationList() {
        return maMaintOperationList;
    }

    public void setMaMaintOperationList(List<MaMaintOperation> maMaintOperationList) {
        this.maMaintOperationList = maMaintOperationList;
    }

    @XmlTransient
    public List<FinMatchingAlgorithm> getFinMatchingAlgorithmList() {
        return finMatchingAlgorithmList;
    }

    public void setFinMatchingAlgorithmList(List<FinMatchingAlgorithm> finMatchingAlgorithmList) {
        this.finMatchingAlgorithmList = finMatchingAlgorithmList;
    }

    @XmlTransient
    public List<CCurrency> getCCurrencyList() {
        return cCurrencyList;
    }

    public void setCCurrencyList(List<CCurrency> cCurrencyList) {
        this.cCurrencyList = cCurrencyList;
    }

    @XmlTransient
    public List<MaIndirectCost> getMaIndirectCostList() {
        return maIndirectCostList;
    }

    public void setMaIndirectCostList(List<MaIndirectCost> maIndirectCostList) {
        this.maIndirectCostList = maIndirectCostList;
    }

    @XmlTransient
    public List<AdTest> getAdTestList() {
        return adTestList;
    }

    public void setAdTestList(List<AdTest> adTestList) {
        this.adTestList = adTestList;
    }

    @XmlTransient
    public List<CActivity> getCActivityList() {
        return cActivityList;
    }

    public void setCActivityList(List<CActivity> cActivityList) {
        this.cActivityList = cActivityList;
    }

    @XmlTransient
    public List<RResourceplancost> getRResourceplancostList() {
        return rResourceplancostList;
    }

    public void setRResourceplancostList(List<RResourceplancost> rResourceplancostList) {
        this.rResourceplancostList = rResourceplancostList;
    }

    @XmlTransient
    public List<MFreightcategory> getMFreightcategoryList() {
        return mFreightcategoryList;
    }

    public void setMFreightcategoryList(List<MFreightcategory> mFreightcategoryList) {
        this.mFreightcategoryList = mFreightcategoryList;
    }

    @XmlTransient
    public List<MrpPlanningmethod> getMrpPlanningmethodList() {
        return mrpPlanningmethodList;
    }

    public void setMrpPlanningmethodList(List<MrpPlanningmethod> mrpPlanningmethodList) {
        this.mrpPlanningmethodList = mrpPlanningmethodList;
    }

    @XmlTransient
    public List<GlCategory> getGlCategoryList() {
        return glCategoryList;
    }

    public void setGlCategoryList(List<GlCategory> glCategoryList) {
        this.glCategoryList = glCategoryList;
    }

    @XmlTransient
    public List<MrpRunPurchase> getMrpRunPurchaseList() {
        return mrpRunPurchaseList;
    }

    public void setMrpRunPurchaseList(List<MrpRunPurchase> mrpRunPurchaseList) {
        this.mrpRunPurchaseList = mrpRunPurchaseList;
    }

    @XmlTransient
    public List<AdClientmodule> getAdClientmoduleList() {
        return adClientmoduleList;
    }

    public void setAdClientmoduleList(List<AdClientmodule> adClientmoduleList) {
        this.adClientmoduleList = adClientmoduleList;
    }

    @XmlTransient
    public List<CBpEmployeeAcct> getCBpEmployeeAcctList() {
        return cBpEmployeeAcctList;
    }

    public void setCBpEmployeeAcctList(List<CBpEmployeeAcct> cBpEmployeeAcctList) {
        this.cBpEmployeeAcctList = cBpEmployeeAcctList;
    }

    @XmlTransient
    public List<CProjectAcct> getCProjectAcctList() {
        return cProjectAcctList;
    }

    public void setCProjectAcctList(List<CProjectAcct> cProjectAcctList) {
        this.cProjectAcctList = cProjectAcctList;
    }

    @XmlTransient
    public List<MaWeincidence> getMaWeincidenceList() {
        return maWeincidenceList;
    }

    public void setMaWeincidenceList(List<MaWeincidence> maWeincidenceList) {
        this.maWeincidenceList = maWeincidenceList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList1() {
        return cInvoiceList1;
    }

    public void setCInvoiceList1(List<CInvoice> cInvoiceList1) {
        this.cInvoiceList1 = cInvoiceList1;
    }

    @XmlTransient
    public List<AAssetGroup> getAAssetGroupList() {
        return aAssetGroupList;
    }

    public void setAAssetGroupList(List<AAssetGroup> aAssetGroupList) {
        this.aAssetGroupList = aAssetGroupList;
    }

    @XmlTransient
    public List<CTaxregister> getCTaxregisterList() {
        return cTaxregisterList;
    }

    public void setCTaxregisterList(List<CTaxregister> cTaxregisterList) {
        this.cTaxregisterList = cTaxregisterList;
    }

    @XmlTransient
    public List<AdPreference> getAdPreferenceList() {
        return adPreferenceList;
    }

    public void setAdPreferenceList(List<AdPreference> adPreferenceList) {
        this.adPreferenceList = adPreferenceList;
    }

    @XmlTransient
    public List<AdPreference> getAdPreferenceList1() {
        return adPreferenceList1;
    }

    public void setAdPreferenceList1(List<AdPreference> adPreferenceList1) {
        this.adPreferenceList1 = adPreferenceList1;
    }

    @XmlTransient
    public List<CChargeAcct> getCChargeAcctList() {
        return cChargeAcctList;
    }

    public void setCChargeAcctList(List<CChargeAcct> cChargeAcctList) {
        this.cChargeAcctList = cChargeAcctList;
    }

    @XmlTransient
    public List<MaCostcenterIc> getMaCostcenterIcList() {
        return maCostcenterIcList;
    }

    public void setMaCostcenterIcList(List<MaCostcenterIc> maCostcenterIcList) {
        this.maCostcenterIcList = maCostcenterIcList;
    }

    @XmlTransient
    public List<CTaxTrl> getCTaxTrlList() {
        return cTaxTrlList;
    }

    public void setCTaxTrlList(List<CTaxTrl> cTaxTrlList) {
        this.cTaxTrlList = cTaxTrlList;
    }

    @XmlTransient
    public List<AdElementTrl> getAdElementTrlList() {
        return adElementTrlList;
    }

    public void setAdElementTrlList(List<AdElementTrl> adElementTrlList) {
        this.adElementTrlList = adElementTrlList;
    }

    @XmlTransient
    public List<AdHbLogCquery> getAdHbLogCqueryList() {
        return adHbLogCqueryList;
    }

    public void setAdHbLogCqueryList(List<AdHbLogCquery> adHbLogCqueryList) {
        this.adHbLogCqueryList = adHbLogCqueryList;
    }

    @XmlTransient
    public List<STimeexpenseline> getSTimeexpenselineList() {
        return sTimeexpenselineList;
    }

    public void setSTimeexpenselineList(List<STimeexpenseline> sTimeexpenselineList) {
        this.sTimeexpenselineList = sTimeexpenselineList;
    }

    @XmlTransient
    public List<AAssetGroupAcct> getAAssetGroupAcctList() {
        return aAssetGroupAcctList;
    }

    public void setAAssetGroupAcctList(List<AAssetGroupAcct> aAssetGroupAcctList) {
        this.aAssetGroupAcctList = aAssetGroupAcctList;
    }

    @XmlTransient
    public List<MaPcValue> getMaPcValueList() {
        return maPcValueList;
    }

    public void setMaPcValueList(List<MaPcValue> maPcValueList) {
        this.maPcValueList = maPcValueList;
    }

    @XmlTransient
    public List<CAcctschemaProcess> getCAcctschemaProcessList() {
        return cAcctschemaProcessList;
    }

    public void setCAcctschemaProcessList(List<CAcctschemaProcess> cAcctschemaProcessList) {
        this.cAcctschemaProcessList = cAcctschemaProcessList;
    }

    @XmlTransient
    public List<CDoctype> getCDoctypeList() {
        return cDoctypeList;
    }

    public void setCDoctypeList(List<CDoctype> cDoctypeList) {
        this.cDoctypeList = cDoctypeList;
    }

    @XmlTransient
    public List<MRequisitionorder> getMRequisitionorderList() {
        return mRequisitionorderList;
    }

    public void setMRequisitionorderList(List<MRequisitionorder> mRequisitionorderList) {
        this.mRequisitionorderList = mRequisitionorderList;
    }

    @XmlTransient
    public List<COrderlineOffer> getCOrderlineOfferList() {
        return cOrderlineOfferList;
    }

    public void setCOrderlineOfferList(List<COrderlineOffer> cOrderlineOfferList) {
        this.cOrderlineOfferList = cOrderlineOfferList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList1() {
        return iGljournalList1;
    }

    public void setIGljournalList1(List<IGljournal> iGljournalList1) {
        this.iGljournalList1 = iGljournalList1;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList2() {
        return iGljournalList2;
    }

    public void setIGljournalList2(List<IGljournal> iGljournalList2) {
        this.iGljournalList2 = iGljournalList2;
    }

    @XmlTransient
    public List<MaCostcenterMachine> getMaCostcenterMachineList() {
        return maCostcenterMachineList;
    }

    public void setMaCostcenterMachineList(List<MaCostcenterMachine> maCostcenterMachineList) {
        this.maCostcenterMachineList = maCostcenterMachineList;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList() {
        return finFinancialAccountAcctList;
    }

    public void setFinFinancialAccountAcctList(List<FinFinancialAccountAcct> finFinancialAccountAcctList) {
        this.finFinancialAccountAcctList = finFinancialAccountAcctList;
    }

    @XmlTransient
    public List<CTaxReport> getCTaxReportList() {
        return cTaxReportList;
    }

    public void setCTaxReportList(List<CTaxReport> cTaxReportList) {
        this.cTaxReportList = cTaxReportList;
    }

    @XmlTransient
    public List<MaIndirectCostValue> getMaIndirectCostValueList() {
        return maIndirectCostValueList;
    }

    public void setMaIndirectCostValueList(List<MaIndirectCostValue> maIndirectCostValueList) {
        this.maIndirectCostValueList = maIndirectCostValueList;
    }

    @XmlTransient
    public List<CCalendar> getCCalendarList() {
        return cCalendarList;
    }

    public void setCCalendarList(List<CCalendar> cCalendarList) {
        this.cCalendarList = cCalendarList;
    }

    @XmlTransient
    public List<AdFormTrl> getAdFormTrlList() {
        return adFormTrlList;
    }

    public void setAdFormTrlList(List<AdFormTrl> adFormTrlList) {
        this.adFormTrlList = adFormTrlList;
    }

    @XmlTransient
    public List<MrpPlanningmethodline> getMrpPlanningmethodlineList() {
        return mrpPlanningmethodlineList;
    }

    public void setMrpPlanningmethodlineList(List<MrpPlanningmethodline> mrpPlanningmethodlineList) {
        this.mrpPlanningmethodlineList = mrpPlanningmethodlineList;
    }

    @XmlTransient
    public List<AdMenu> getAdMenuList() {
        return adMenuList;
    }

    public void setAdMenuList(List<AdMenu> adMenuList) {
        this.adMenuList = adMenuList;
    }

    @XmlTransient
    public List<MProductCustomer> getMProductCustomerList() {
        return mProductCustomerList;
    }

    public void setMProductCustomerList(List<MProductCustomer> mProductCustomerList) {
        this.mProductCustomerList = mProductCustomerList;
    }

    @XmlTransient
    public List<MRappelProduct> getMRappelProductList() {
        return mRappelProductList;
    }

    public void setMRappelProductList(List<MRappelProduct> mRappelProductList) {
        this.mRappelProductList = mRappelProductList;
    }

    @XmlTransient
    public List<AAssetAcct> getAAssetAcctList() {
        return aAssetAcctList;
    }

    public void setAAssetAcctList(List<AAssetAcct> aAssetAcctList) {
        this.aAssetAcctList = aAssetAcctList;
    }

    @XmlTransient
    public List<CGreetingTrl> getCGreetingTrlList() {
        return cGreetingTrlList;
    }

    public void setCGreetingTrlList(List<CGreetingTrl> cGreetingTrlList) {
        this.cGreetingTrlList = cGreetingTrlList;
    }

    @XmlTransient
    public List<MaMaintPart> getMaMaintPartList() {
        return maMaintPartList;
    }

    public void setMaMaintPartList(List<MaMaintPart> maMaintPartList) {
        this.maMaintPartList = maMaintPartList;
    }

    @XmlTransient
    public List<MFreight> getMFreightList() {
        return mFreightList;
    }

    public void setMFreightList(List<MFreight> mFreightList) {
        this.mFreightList = mFreightList;
    }

    @XmlTransient
    public List<SResourceassignment> getSResourceassignmentList() {
        return sResourceassignmentList;
    }

    public void setSResourceassignmentList(List<SResourceassignment> sResourceassignmentList) {
        this.sResourceassignmentList = sResourceassignmentList;
    }

    @XmlTransient
    public List<AdRefListTrl> getAdRefListTrlList() {
        return adRefListTrlList;
    }

    public void setAdRefListTrlList(List<AdRefListTrl> adRefListTrlList) {
        this.adRefListTrlList = adRefListTrlList;
    }

    @XmlTransient
    public List<CElement> getCElementList() {
        return cElementList;
    }

    public void setCElementList(List<CElement> cElementList) {
        this.cElementList = cElementList;
    }

    @XmlTransient
    public List<FactAcctCfs> getFactAcctCfsList() {
        return factAcctCfsList;
    }

    public void setFactAcctCfsList(List<FactAcctCfs> factAcctCfsList) {
        this.factAcctCfsList = factAcctCfsList;
    }

    @XmlTransient
    public List<AdRefSearch> getAdRefSearchList() {
        return adRefSearchList;
    }

    public void setAdRefSearchList(List<AdRefSearch> adRefSearchList) {
        this.adRefSearchList = adRefSearchList;
    }

    @XmlTransient
    public List<CBpartnerLocation> getCBpartnerLocationList() {
        return cBpartnerLocationList;
    }

    public void setCBpartnerLocationList(List<CBpartnerLocation> cBpartnerLocationList) {
        this.cBpartnerLocationList = cBpartnerLocationList;
    }

    @XmlTransient
    public List<FinBankstatementline> getFinBankstatementlineList() {
        return finBankstatementlineList;
    }

    public void setFinBankstatementlineList(List<FinBankstatementline> finBankstatementlineList) {
        this.finBankstatementlineList = finBankstatementlineList;
    }

    @XmlTransient
    public List<RInterestarea> getRInterestareaList() {
        return rInterestareaList;
    }

    public void setRInterestareaList(List<RInterestarea> rInterestareaList) {
        this.rInterestareaList = rInterestareaList;
    }

    @XmlTransient
    public List<MProductTemplate> getMProductTemplateList() {
        return mProductTemplateList;
    }

    public void setMProductTemplateList(List<MProductTemplate> mProductTemplateList) {
        this.mProductTemplateList = mProductTemplateList;
    }

    @XmlTransient
    public List<CInvoicelineAcctdimension> getCInvoicelineAcctdimensionList() {
        return cInvoicelineAcctdimensionList;
    }

    public void setCInvoicelineAcctdimensionList(List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList) {
        this.cInvoicelineAcctdimensionList = cInvoicelineAcctdimensionList;
    }

    @XmlTransient
    public List<AdModuleDbprefix> getAdModuleDbprefixList() {
        return adModuleDbprefixList;
    }

    public void setAdModuleDbprefixList(List<AdModuleDbprefix> adModuleDbprefixList) {
        this.adModuleDbprefixList = adModuleDbprefixList;
    }

    @XmlTransient
    public List<CInvoicelinetax> getCInvoicelinetaxList() {
        return cInvoicelinetaxList;
    }

    public void setCInvoicelinetaxList(List<CInvoicelinetax> cInvoicelinetaxList) {
        this.cInvoicelinetaxList = cInvoicelinetaxList;
    }

    @XmlTransient
    public List<MaToolsetused> getMaToolsetusedList() {
        return maToolsetusedList;
    }

    public void setMaToolsetusedList(List<MaToolsetused> maToolsetusedList) {
        this.maToolsetusedList = maToolsetusedList;
    }

    @XmlTransient
    public List<CBankstatementline> getCBankstatementlineList() {
        return cBankstatementlineList;
    }

    public void setCBankstatementlineList(List<CBankstatementline> cBankstatementlineList) {
        this.cBankstatementlineList = cBankstatementlineList;
    }

    @XmlTransient
    public List<AdAcctprocess> getAdAcctprocessList() {
        return adAcctprocessList;
    }

    public void setAdAcctprocessList(List<AdAcctprocess> adAcctprocessList) {
        this.adAcctprocessList = adAcctprocessList;
    }

    @XmlTransient
    public List<AdTaskTrl> getAdTaskTrlList() {
        return adTaskTrlList;
    }

    public void setAdTaskTrlList(List<AdTaskTrl> adTaskTrlList) {
        this.adTaskTrlList = adTaskTrlList;
    }

    @XmlTransient
    public List<CInvoiceDiscount> getCInvoiceDiscountList() {
        return cInvoiceDiscountList;
    }

    public void setCInvoiceDiscountList(List<CInvoiceDiscount> cInvoiceDiscountList) {
        this.cInvoiceDiscountList = cInvoiceDiscountList;
    }

    @XmlTransient
    public List<MWarehouse> getMWarehouseList() {
        return mWarehouseList;
    }

    public void setMWarehouseList(List<MWarehouse> mWarehouseList) {
        this.mWarehouseList = mWarehouseList;
    }

    @XmlTransient
    public List<MaWorkrequirement> getMaWorkrequirementList() {
        return maWorkrequirementList;
    }

    public void setMaWorkrequirementList(List<MaWorkrequirement> maWorkrequirementList) {
        this.maWorkrequirementList = maWorkrequirementList;
    }

    @XmlTransient
    public List<CRemittance> getCRemittanceList() {
        return cRemittanceList;
    }

    public void setCRemittanceList(List<CRemittance> cRemittanceList) {
        this.cRemittanceList = cRemittanceList;
    }

    @XmlTransient
    public List<MaMaintWorker> getMaMaintWorkerList() {
        return maMaintWorkerList;
    }

    public void setMaMaintWorkerList(List<MaMaintWorker> maMaintWorkerList) {
        this.maMaintWorkerList = maMaintWorkerList;
    }

    @XmlTransient
    public List<AtCommandTrl> getAtCommandTrlList() {
        return atCommandTrlList;
    }

    public void setAtCommandTrlList(List<AtCommandTrl> atCommandTrlList) {
        this.atCommandTrlList = atCommandTrlList;
    }

    @XmlTransient
    public List<MaMaintScheduled> getMaMaintScheduledList() {
        return maMaintScheduledList;
    }

    public void setMaMaintScheduledList(List<MaMaintScheduled> maMaintScheduledList) {
        this.maMaintScheduledList = maMaintScheduledList;
    }

    @XmlTransient
    public List<AdAlertrecipient> getAdAlertrecipientList() {
        return adAlertrecipientList;
    }

    public void setAdAlertrecipientList(List<AdAlertrecipient> adAlertrecipientList) {
        this.adAlertrecipientList = adAlertrecipientList;
    }

    @XmlTransient
    public List<CAcctschemaDefault> getCAcctschemaDefaultList() {
        return cAcctschemaDefaultList;
    }

    public void setCAcctschemaDefaultList(List<CAcctschemaDefault> cAcctschemaDefaultList) {
        this.cAcctschemaDefaultList = cAcctschemaDefaultList;
    }

    @XmlTransient
    public List<AdWfNode> getAdWfNodeList() {
        return adWfNodeList;
    }

    public void setAdWfNodeList(List<AdWfNode> adWfNodeList) {
        this.adWfNodeList = adWfNodeList;
    }

    @XmlTransient
    public List<AdModuleTrl> getAdModuleTrlList() {
        return adModuleTrlList;
    }

    public void setAdModuleTrlList(List<AdModuleTrl> adModuleTrlList) {
        this.adModuleTrlList = adModuleTrlList;
    }

    @XmlTransient
    public List<CYear> getCYearList() {
        return cYearList;
    }

    public void setCYearList(List<CYear> cYearList) {
        this.cYearList = cYearList;
    }

    @XmlTransient
    public List<MSubstitute> getMSubstituteList() {
        return mSubstituteList;
    }

    public void setMSubstituteList(List<MSubstitute> mSubstituteList) {
        this.mSubstituteList = mSubstituteList;
    }

    @XmlTransient
    public List<MWhScheduleProduct> getMWhScheduleProductList() {
        return mWhScheduleProductList;
    }

    public void setMWhScheduleProductList(List<MWhScheduleProduct> mWhScheduleProductList) {
        this.mWhScheduleProductList = mWhScheduleProductList;
    }

    @XmlTransient
    public List<MInternalConsumption> getMInternalConsumptionList() {
        return mInternalConsumptionList;
    }

    public void setMInternalConsumptionList(List<MInternalConsumption> mInternalConsumptionList) {
        this.mInternalConsumptionList = mInternalConsumptionList;
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
    public List<COrder> getCOrderList1() {
        return cOrderList1;
    }

    public void setCOrderList1(List<COrder> cOrderList1) {
        this.cOrderList1 = cOrderList1;
    }

    @XmlTransient
    public List<CCommission> getCCommissionList() {
        return cCommissionList;
    }

    public void setCCommissionList(List<CCommission> cCommissionList) {
        this.cCommissionList = cCommissionList;
    }

    @XmlTransient
    public List<CNonbusinessday> getCNonbusinessdayList() {
        return cNonbusinessdayList;
    }

    public void setCNonbusinessdayList(List<CNonbusinessday> cNonbusinessdayList) {
        this.cNonbusinessdayList = cNonbusinessdayList;
    }

    @XmlTransient
    public List<MaSequence> getMaSequenceList() {
        return maSequenceList;
    }

    public void setMaSequenceList(List<MaSequence> maSequenceList) {
        this.maSequenceList = maSequenceList;
    }

    @XmlTransient
    public List<MRappel> getMRappelList() {
        return mRappelList;
    }

    public void setMRappelList(List<MRappel> mRappelList) {
        this.mRappelList = mRappelList;
    }

    @XmlTransient
    public List<MProductOrg> getMProductOrgList() {
        return mProductOrgList;
    }

    public void setMProductOrgList(List<MProductOrg> mProductOrgList) {
        this.mProductOrgList = mProductOrgList;
    }

    @XmlTransient
    public List<MrpRunPurchaseline> getMrpRunPurchaselineList() {
        return mrpRunPurchaselineList;
    }

    public void setMrpRunPurchaselineList(List<MrpRunPurchaseline> mrpRunPurchaselineList) {
        this.mrpRunPurchaselineList = mrpRunPurchaselineList;
    }

    @XmlTransient
    public List<MWarehouseAcct> getMWarehouseAcctList() {
        return mWarehouseAcctList;
    }

    public void setMWarehouseAcctList(List<MWarehouseAcct> mWarehouseAcctList) {
        this.mWarehouseAcctList = mWarehouseAcctList;
    }

    @XmlTransient
    public List<RMailtext> getRMailtextList() {
        return rMailtextList;
    }

    public void setRMailtextList(List<RMailtext> rMailtextList) {
        this.rMailtextList = rMailtextList;
    }

    @XmlTransient
    public List<CBpGroup> getCBpGroupList() {
        return cBpGroupList;
    }

    public void setCBpGroupList(List<CBpGroup> cBpGroupList) {
        this.cBpGroupList = cBpGroupList;
    }

    @XmlTransient
    public List<CElementvalueTrl> getCElementvalueTrlList() {
        return cElementvalueTrlList;
    }

    public void setCElementvalueTrlList(List<CElementvalueTrl> cElementvalueTrlList) {
        this.cElementvalueTrlList = cElementvalueTrlList;
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
    public List<IOrder> getIOrderList1() {
        return iOrderList1;
    }

    public void setIOrderList1(List<IOrder> iOrderList1) {
        this.iOrderList1 = iOrderList1;
    }

    @XmlTransient
    public List<AdReferenceTrl> getAdReferenceTrlList() {
        return adReferenceTrlList;
    }

    public void setAdReferenceTrlList(List<AdReferenceTrl> adReferenceTrlList) {
        this.adReferenceTrlList = adReferenceTrlList;
    }

    @XmlTransient
    public List<AdTextinterfacesTrl> getAdTextinterfacesTrlList() {
        return adTextinterfacesTrlList;
    }

    public void setAdTextinterfacesTrlList(List<AdTextinterfacesTrl> adTextinterfacesTrlList) {
        this.adTextinterfacesTrlList = adTextinterfacesTrlList;
    }

    @XmlTransient
    public List<FinPaymentCredit> getFinPaymentCreditList() {
        return finPaymentCreditList;
    }

    public void setFinPaymentCreditList(List<FinPaymentCredit> finPaymentCreditList) {
        this.finPaymentCreditList = finPaymentCreditList;
    }

    @XmlTransient
    public List<AdUser> getAdUserList() {
        return adUserList;
    }

    public void setAdUserList(List<AdUser> adUserList) {
        this.adUserList = adUserList;
    }

    @XmlTransient
    public List<AdUser> getAdUserList1() {
        return adUserList1;
    }

    public void setAdUserList1(List<AdUser> adUserList1) {
        this.adUserList1 = adUserList1;
    }

    @XmlTransient
    public List<AdUser> getAdUserList2() {
        return adUserList2;
    }

    public void setAdUserList2(List<AdUser> adUserList2) {
        this.adUserList2 = adUserList2;
    }

    @XmlTransient
    public List<AtTestdocumentline> getAtTestdocumentlineList() {
        return atTestdocumentlineList;
    }

    public void setAtTestdocumentlineList(List<AtTestdocumentline> atTestdocumentlineList) {
        this.atTestdocumentlineList = atTestdocumentlineList;
    }

    @XmlTransient
    public List<FinFinaccPaymentmethod> getFinFinaccPaymentmethodList() {
        return finFinaccPaymentmethodList;
    }

    public void setFinFinaccPaymentmethodList(List<FinFinaccPaymentmethod> finFinaccPaymentmethodList) {
        this.finFinaccPaymentmethodList = finFinaccPaymentmethodList;
    }

    @XmlTransient
    public List<COrderDiscount> getCOrderDiscountList() {
        return cOrderDiscountList;
    }

    public void setCOrderDiscountList(List<COrderDiscount> cOrderDiscountList) {
        this.cOrderDiscountList = cOrderDiscountList;
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
    public List<AdSessionStatus> getAdSessionStatusList() {
        return adSessionStatusList;
    }

    public void setAdSessionStatusList(List<AdSessionStatus> adSessionStatusList) {
        this.adSessionStatusList = adSessionStatusList;
    }

    @XmlTransient
    public List<AdSystemInfo> getAdSystemInfoList() {
        return adSystemInfoList;
    }

    public void setAdSystemInfoList(List<AdSystemInfo> adSystemInfoList) {
        this.adSystemInfoList = adSystemInfoList;
    }

    @XmlTransient
    public List<COrderlinetax> getCOrderlinetaxList() {
        return cOrderlinetaxList;
    }

    public void setCOrderlinetaxList(List<COrderlinetax> cOrderlinetaxList) {
        this.cOrderlinetaxList = cOrderlinetaxList;
    }

    @XmlTransient
    public List<CCashline> getCCashlineList() {
        return cCashlineList;
    }

    public void setCCashlineList(List<CCashline> cCashlineList) {
        this.cCashlineList = cCashlineList;
    }

    @XmlTransient
    public List<CCommissionrun> getCCommissionrunList() {
        return cCommissionrunList;
    }

    public void setCCommissionrunList(List<CCommissionrun> cCommissionrunList) {
        this.cCommissionrunList = cCommissionrunList;
    }

    @XmlTransient
    public List<CProjectproposal> getCProjectproposalList() {
        return cProjectproposalList;
    }

    public void setCProjectproposalList(List<CProjectproposal> cProjectproposalList) {
        this.cProjectproposalList = cProjectproposalList;
    }

    @XmlTransient
    public List<MaPlIc> getMaPlIcList() {
        return maPlIcList;
    }

    public void setMaPlIcList(List<MaPlIc> maPlIcList) {
        this.maPlIcList = maPlIcList;
    }

    @XmlTransient
    public List<CBpartnerDiscount> getCBpartnerDiscountList() {
        return cBpartnerDiscountList;
    }

    public void setCBpartnerDiscountList(List<CBpartnerDiscount> cBpartnerDiscountList) {
        this.cBpartnerDiscountList = cBpartnerDiscountList;
    }

    @XmlTransient
    public List<IBpartner> getIBpartnerList() {
        return iBpartnerList;
    }

    public void setIBpartnerList(List<IBpartner> iBpartnerList) {
        this.iBpartnerList = iBpartnerList;
    }

    @XmlTransient
    public List<CUomConversion> getCUomConversionList() {
        return cUomConversionList;
    }

    public void setCUomConversionList(List<CUomConversion> cUomConversionList) {
        this.cUomConversionList = cUomConversionList;
    }

    @XmlTransient
    public List<CTaxZone> getCTaxZoneList() {
        return cTaxZoneList;
    }

    public void setCTaxZoneList(List<CTaxZone> cTaxZoneList) {
        this.cTaxZoneList = cTaxZoneList;
    }

    @XmlTransient
    public List<CDpManagement> getCDpManagementList() {
        return cDpManagementList;
    }

    public void setCDpManagementList(List<CDpManagement> cDpManagementList) {
        this.cDpManagementList = cDpManagementList;
    }

    @XmlTransient
    public List<AtTestdocument> getAtTestdocumentList() {
        return atTestdocumentList;
    }

    public void setAtTestdocumentList(List<AtTestdocument> atTestdocumentList) {
        this.atTestdocumentList = atTestdocumentList;
    }

    @XmlTransient
    public List<CDebtPaymentBalReplace> getCDebtPaymentBalReplaceList() {
        return cDebtPaymentBalReplaceList;
    }

    public void setCDebtPaymentBalReplaceList(List<CDebtPaymentBalReplace> cDebtPaymentBalReplaceList) {
        this.cDebtPaymentBalReplaceList = cDebtPaymentBalReplaceList;
    }

    @XmlTransient
    public List<MaCcp> getMaCcpList() {
        return maCcpList;
    }

    public void setMaCcpList(List<MaCcp> maCcpList) {
        this.maCcpList = maCcpList;
    }

    @XmlTransient
    public List<AdTree> getAdTreeList() {
        return adTreeList;
    }

    public void setAdTreeList(List<AdTree> adTreeList) {
        this.adTreeList = adTreeList;
    }

    @XmlTransient
    public List<GlJournalbatch> getGlJournalbatchList() {
        return glJournalbatchList;
    }

    public void setGlJournalbatchList(List<GlJournalbatch> glJournalbatchList) {
        this.glJournalbatchList = glJournalbatchList;
    }

    @XmlTransient
    public List<AdHeartbeatLog> getAdHeartbeatLogList() {
        return adHeartbeatLogList;
    }

    public void setAdHeartbeatLogList(List<AdHeartbeatLog> adHeartbeatLogList) {
        this.adHeartbeatLogList = adHeartbeatLogList;
    }

    @XmlTransient
    public List<AdSequence> getAdSequenceList() {
        return adSequenceList;
    }

    public void setAdSequenceList(List<AdSequence> adSequenceList) {
        this.adSequenceList = adSequenceList;
    }

    @XmlTransient
    public List<AdTextinterfaces> getAdTextinterfacesList() {
        return adTextinterfacesList;
    }

    public void setAdTextinterfacesList(List<AdTextinterfaces> adTextinterfacesList) {
        this.adTextinterfacesList = adTextinterfacesList;
    }

    @XmlTransient
    public List<CIncoterms> getCIncotermsList() {
        return cIncotermsList;
    }

    public void setCIncotermsList(List<CIncoterms> cIncotermsList) {
        this.cIncotermsList = cIncotermsList;
    }

    @XmlTransient
    public List<FinPaymentSchedule> getFinPaymentScheduleList() {
        return finPaymentScheduleList;
    }

    public void setFinPaymentScheduleList(List<FinPaymentSchedule> finPaymentScheduleList) {
        this.finPaymentScheduleList = finPaymentScheduleList;
    }

    @XmlTransient
    public List<AdDataset> getAdDatasetList() {
        return adDatasetList;
    }

    public void setAdDatasetList(List<AdDataset> adDatasetList) {
        this.adDatasetList = adDatasetList;
    }

    @XmlTransient
    public List<CValidcombination> getCValidcombinationList() {
        return cValidcombinationList;
    }

    public void setCValidcombinationList(List<CValidcombination> cValidcombinationList) {
        this.cValidcombinationList = cValidcombinationList;
    }

    @XmlTransient
    public List<CValidcombination> getCValidcombinationList1() {
        return cValidcombinationList1;
    }

    public void setCValidcombinationList1(List<CValidcombination> cValidcombinationList1) {
        this.cValidcombinationList1 = cValidcombinationList1;
    }

    @XmlTransient
    public List<AdAlertruleTrl> getAdAlertruleTrlList() {
        return adAlertruleTrlList;
    }

    public void setAdAlertruleTrlList(List<AdAlertruleTrl> adAlertruleTrlList) {
        this.adAlertruleTrlList = adAlertruleTrlList;
    }

    @XmlTransient
    public List<CProjectVendor> getCProjectVendorList() {
        return cProjectVendorList;
    }

    public void setCProjectVendorList(List<CProjectVendor> cProjectVendorList) {
        this.cProjectVendorList = cProjectVendorList;
    }

    @XmlTransient
    public List<AdDatasetColumn> getAdDatasetColumnList() {
        return adDatasetColumnList;
    }

    public void setAdDatasetColumnList(List<AdDatasetColumn> adDatasetColumnList) {
        this.adDatasetColumnList = adDatasetColumnList;
    }

    @XmlTransient
    public List<CCommissionamt> getCCommissionamtList() {
        return cCommissionamtList;
    }

    public void setCCommissionamtList(List<CCommissionamt> cCommissionamtList) {
        this.cCommissionamtList = cCommissionamtList;
    }

    @XmlTransient
    public List<FinPayment> getFinPaymentList() {
        return finPaymentList;
    }

    public void setFinPaymentList(List<FinPayment> finPaymentList) {
        this.finPaymentList = finPaymentList;
    }

    @XmlTransient
    public List<CTask> getCTaskList() {
        return cTaskList;
    }

    public void setCTaskList(List<CTask> cTaskList) {
        this.cTaskList = cTaskList;
    }

    @XmlTransient
    public List<CFile> getCFileList() {
        return cFileList;
    }

    public void setCFileList(List<CFile> cFileList) {
        this.cFileList = cFileList;
    }

    @XmlTransient
    public List<CAcctRptNode> getCAcctRptNodeList() {
        return cAcctRptNodeList;
    }

    public void setCAcctRptNodeList(List<CAcctRptNode> cAcctRptNodeList) {
        this.cAcctRptNodeList = cAcctRptNodeList;
    }

    @XmlTransient
    public List<AdWindowAccess> getAdWindowAccessList() {
        return adWindowAccessList;
    }

    public void setAdWindowAccessList(List<AdWindowAccess> adWindowAccessList) {
        this.adWindowAccessList = adWindowAccessList;
    }

    @XmlTransient
    public List<CCurrencyTrl> getCCurrencyTrlList() {
        return cCurrencyTrlList;
    }

    public void setCCurrencyTrlList(List<CCurrencyTrl> cCurrencyTrlList) {
        this.cCurrencyTrlList = cCurrencyTrlList;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList() {
        return mProductAcctList;
    }

    public void setMProductAcctList(List<MProductAcct> mProductAcctList) {
        this.mProductAcctList = mProductAcctList;
    }

    @XmlTransient
    public List<MaProcess> getMaProcessList() {
        return maProcessList;
    }

    public void setMaProcessList(List<MaProcess> maProcessList) {
        this.maProcessList = maProcessList;
    }

    @XmlTransient
    public List<MaToolsetType> getMaToolsetTypeList() {
        return maToolsetTypeList;
    }

    public void setMaToolsetTypeList(List<MaToolsetType> maToolsetTypeList) {
        this.maToolsetTypeList = maToolsetTypeList;
    }

    @XmlTransient
    public List<MCosting> getMCostingList() {
        return mCostingList;
    }

    public void setMCostingList(List<MCosting> mCostingList) {
        this.mCostingList = mCostingList;
    }

    @XmlTransient
    public List<AdModule> getAdModuleList() {
        return adModuleList;
    }

    public void setAdModuleList(List<AdModule> adModuleList) {
        this.adModuleList = adModuleList;
    }

    @XmlTransient
    public List<AdRefTable> getAdRefTableList() {
        return adRefTableList;
    }

    public void setAdRefTableList(List<AdRefTable> adRefTableList) {
        this.adRefTableList = adRefTableList;
    }

    @XmlTransient
    public List<IInventory> getIInventoryList() {
        return iInventoryList;
    }

    public void setIInventoryList(List<IInventory> iInventoryList) {
        this.iInventoryList = iInventoryList;
    }

    @XmlTransient
    public List<AdFieldTrl> getAdFieldTrlList() {
        return adFieldTrlList;
    }

    public void setAdFieldTrlList(List<AdFieldTrl> adFieldTrlList) {
        this.adFieldTrlList = adFieldTrlList;
    }

    @XmlTransient
    public List<CBankstatement> getCBankstatementList() {
        return cBankstatementList;
    }

    public void setCBankstatementList(List<CBankstatement> cBankstatementList) {
        this.cBankstatementList = cBankstatementList;
    }

    @XmlTransient
    public List<MSernoctl> getMSernoctlList() {
        return mSernoctlList;
    }

    public void setMSernoctlList(List<MSernoctl> mSernoctlList) {
        this.mSernoctlList = mSernoctlList;
    }

    @XmlTransient
    public List<CCity> getCCityList() {
        return cCityList;
    }

    public void setCCityList(List<CCity> cCityList) {
        this.cCityList = cCityList;
    }

    @XmlTransient
    public List<MProductPo> getMProductPoList() {
        return mProductPoList;
    }

    public void setMProductPoList(List<MProductPo> mProductPoList) {
        this.mProductPoList = mProductPoList;
    }

    @XmlTransient
    public List<IElementvalue> getIElementvalueList() {
        return iElementvalueList;
    }

    public void setIElementvalueList(List<IElementvalue> iElementvalueList) {
        this.iElementvalueList = iElementvalueList;
    }

    @XmlTransient
    public List<AdProcessRun> getAdProcessRunList() {
        return adProcessRunList;
    }

    public void setAdProcessRunList(List<AdProcessRun> adProcessRunList) {
        this.adProcessRunList = adProcessRunList;
    }

    @XmlTransient
    public List<AdWorkflowTrl> getAdWorkflowTrlList() {
        return adWorkflowTrlList;
    }

    public void setAdWorkflowTrlList(List<AdWorkflowTrl> adWorkflowTrlList) {
        this.adWorkflowTrlList = adWorkflowTrlList;
    }

    @XmlTransient
    public List<CPeriodcontrolLog> getCPeriodcontrolLogList() {
        return cPeriodcontrolLogList;
    }

    public void setCPeriodcontrolLogList(List<CPeriodcontrolLog> cPeriodcontrolLogList) {
        this.cPeriodcontrolLogList = cPeriodcontrolLogList;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList() {
        return cAcctschemaGlList;
    }

    public void setCAcctschemaGlList(List<CAcctschemaGl> cAcctschemaGlList) {
        this.cAcctschemaGlList = cAcctschemaGlList;
    }

    @XmlTransient
    public List<CRemittanceParameter> getCRemittanceParameterList() {
        return cRemittanceParameterList;
    }

    public void setCRemittanceParameterList(List<CRemittanceParameter> cRemittanceParameterList) {
        this.cRemittanceParameterList = cRemittanceParameterList;
    }

    @XmlTransient
    public List<MInternalConsumptionline> getMInternalConsumptionlineList() {
        return mInternalConsumptionlineList;
    }

    public void setMInternalConsumptionlineList(List<MInternalConsumptionline> mInternalConsumptionlineList) {
        this.mInternalConsumptionlineList = mInternalConsumptionlineList;
    }

    @XmlTransient
    public List<FinPaymentRunPara> getFinPaymentRunParaList() {
        return finPaymentRunParaList;
    }

    public void setFinPaymentRunParaList(List<FinPaymentRunPara> finPaymentRunParaList) {
        this.finPaymentRunParaList = finPaymentRunParaList;
    }

    @XmlTransient
    public List<MaGlobaluse> getMaGlobaluseList() {
        return maGlobaluseList;
    }

    public void setMaGlobaluseList(List<MaGlobaluse> maGlobaluseList) {
        this.maGlobaluseList = maGlobaluseList;
    }

    @XmlTransient
    public List<CProjectproposaltask> getCProjectproposaltaskList() {
        return cProjectproposaltaskList;
    }

    public void setCProjectproposaltaskList(List<CProjectproposaltask> cProjectproposaltaskList) {
        this.cProjectproposaltaskList = cProjectproposaltaskList;
    }

    @XmlTransient
    public List<MOfferProduct> getMOfferProductList() {
        return mOfferProductList;
    }

    public void setMOfferProductList(List<MOfferProduct> mOfferProductList) {
        this.mOfferProductList = mOfferProductList;
    }

    @XmlTransient
    public List<MAttributevalue> getMAttributevalueList() {
        return mAttributevalueList;
    }

    public void setMAttributevalueList(List<MAttributevalue> mAttributevalueList) {
        this.mAttributevalueList = mAttributevalueList;
    }

    @XmlTransient
    public List<CTaxAcct> getCTaxAcctList() {
        return cTaxAcctList;
    }

    public void setCTaxAcctList(List<CTaxAcct> cTaxAcctList) {
        this.cTaxAcctList = cTaxAcctList;
    }

    @XmlTransient
    public List<CDebtPaymentBalancing> getCDebtPaymentBalancingList() {
        return cDebtPaymentBalancingList;
    }

    public void setCDebtPaymentBalancingList(List<CDebtPaymentBalancing> cDebtPaymentBalancingList) {
        this.cDebtPaymentBalancingList = cDebtPaymentBalancingList;
    }

    @XmlTransient
    public List<CServicelevel> getCServicelevelList() {
        return cServicelevelList;
    }

    public void setCServicelevelList(List<CServicelevel> cServicelevelList) {
        this.cServicelevelList = cServicelevelList;
    }

    @XmlTransient
    public List<AdNote> getAdNoteList() {
        return adNoteList;
    }

    public void setAdNoteList(List<AdNote> adNoteList) {
        this.adNoteList = adNoteList;
    }

    @XmlTransient
    public List<MMatchinv> getMMatchinvList() {
        return mMatchinvList;
    }

    public void setMMatchinvList(List<MMatchinv> mMatchinvList) {
        this.mMatchinvList = mMatchinvList;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList() {
        return cBpGroupAcctList;
    }

    public void setCBpGroupAcctList(List<CBpGroupAcct> cBpGroupAcctList) {
        this.cBpGroupAcctList = cBpGroupAcctList;
    }

    @XmlTransient
    public List<AdProcessParaTrl> getAdProcessParaTrlList() {
        return adProcessParaTrlList;
    }

    public void setAdProcessParaTrlList(List<AdProcessParaTrl> adProcessParaTrlList) {
        this.adProcessParaTrlList = adProcessParaTrlList;
    }

    @XmlTransient
    public List<CInvoiceschedule> getCInvoicescheduleList() {
        return cInvoicescheduleList;
    }

    public void setCInvoicescheduleList(List<CInvoiceschedule> cInvoicescheduleList) {
        this.cInvoicescheduleList = cInvoicescheduleList;
    }

    @XmlTransient
    public List<MaToolset> getMaToolsetList() {
        return maToolsetList;
    }

    public void setMaToolsetList(List<MaToolset> maToolsetList) {
        this.maToolsetList = maToolsetList;
    }

    @XmlTransient
    public List<MaCostcenter> getMaCostcenterList() {
        return maCostcenterList;
    }

    public void setMaCostcenterList(List<MaCostcenter> maCostcenterList) {
        this.maCostcenterList = maCostcenterList;
    }

    @XmlTransient
    public List<AdRoleOrgaccess> getAdRoleOrgaccessList() {
        return adRoleOrgaccessList;
    }

    public void setAdRoleOrgaccessList(List<AdRoleOrgaccess> adRoleOrgaccessList) {
        this.adRoleOrgaccessList = adRoleOrgaccessList;
    }

    @XmlTransient
    public List<FinReclineTemp> getFinReclineTempList() {
        return finReclineTempList;
    }

    public void setFinReclineTempList(List<FinReclineTemp> finReclineTempList) {
        this.finReclineTempList = finReclineTempList;
    }

    @XmlTransient
    public List<RContactinterest> getRContactinterestList() {
        return rContactinterestList;
    }

    public void setRContactinterestList(List<RContactinterest> rContactinterestList) {
        this.rContactinterestList = rContactinterestList;
    }

    @XmlTransient
    public List<AdChangelog> getAdChangelogList() {
        return adChangelogList;
    }

    public void setAdChangelogList(List<AdChangelog> adChangelogList) {
        this.adChangelogList = adChangelogList;
    }

    @XmlTransient
    public List<MaCostcenterEmployee> getMaCostcenterEmployeeList() {
        return maCostcenterEmployeeList;
    }

    public void setMaCostcenterEmployeeList(List<MaCostcenterEmployee> maCostcenterEmployeeList) {
        this.maCostcenterEmployeeList = maCostcenterEmployeeList;
    }

    @XmlTransient
    public List<AdModelObject> getAdModelObjectList() {
        return adModelObjectList;
    }

    public void setAdModelObjectList(List<AdModelObject> adModelObjectList) {
        this.adModelObjectList = adModelObjectList;
    }

    @XmlTransient
    public List<MPricelist> getMPricelistList() {
        return mPricelistList;
    }

    public void setMPricelistList(List<MPricelist> mPricelistList) {
        this.mPricelistList = mPricelistList;
    }

    @XmlTransient
    public List<CProjecttask> getCProjecttaskList() {
        return cProjecttaskList;
    }

    public void setCProjecttaskList(List<CProjecttask> cProjecttaskList) {
        this.cProjecttaskList = cProjecttaskList;
    }

    @XmlTransient
    public List<AdDatasetTable> getAdDatasetTableList() {
        return adDatasetTableList;
    }

    public void setAdDatasetTableList(List<AdDatasetTable> adDatasetTableList) {
        this.adDatasetTableList = adDatasetTableList;
    }

    @XmlTransient
    public List<MaMachinestation> getMaMachinestationList() {
        return maMachinestationList;
    }

    public void setMaMachinestationList(List<MaMachinestation> maMachinestationList) {
        this.maMachinestationList = maMachinestationList;
    }

    @XmlTransient
    public List<CBpBankaccount> getCBpBankaccountList() {
        return cBpBankaccountList;
    }

    public void setCBpBankaccountList(List<CBpBankaccount> cBpBankaccountList) {
        this.cBpBankaccountList = cBpBankaccountList;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList() {
        return iBudgetlineList;
    }

    public void setIBudgetlineList(List<IBudgetline> iBudgetlineList) {
        this.iBudgetlineList = iBudgetlineList;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList1() {
        return iBudgetlineList1;
    }

    public void setIBudgetlineList1(List<IBudgetline> iBudgetlineList1) {
        this.iBudgetlineList1 = iBudgetlineList1;
    }

    @XmlTransient
    public List<AdDimension> getAdDimensionList() {
        return adDimensionList;
    }

    public void setAdDimensionList(List<AdDimension> adDimensionList) {
        this.adDimensionList = adDimensionList;
    }

    @XmlTransient
    public List<AdDatatype> getAdDatatypeList() {
        return adDatatypeList;
    }

    public void setAdDatatypeList(List<AdDatatype> adDatatypeList) {
        this.adDatatypeList = adDatatypeList;
    }

    @XmlTransient
    public List<AdReference> getAdReferenceList() {
        return adReferenceList;
    }

    public void setAdReferenceList(List<AdReference> adReferenceList) {
        this.adReferenceList = adReferenceList;
    }

    @XmlTransient
    public List<CTaxcategory> getCTaxcategoryList() {
        return cTaxcategoryList;
    }

    public void setCTaxcategoryList(List<CTaxcategory> cTaxcategoryList) {
        this.cTaxcategoryList = cTaxcategoryList;
    }

    @XmlTransient
    public List<CServicelevelline> getCServicelevellineList() {
        return cServicelevellineList;
    }

    public void setCServicelevellineList(List<CServicelevelline> cServicelevellineList) {
        this.cServicelevellineList = cServicelevellineList;
    }

    @XmlTransient
    public List<MaProcessplan> getMaProcessplanList() {
        return maProcessplanList;
    }

    public void setMaProcessplanList(List<MaProcessplan> maProcessplanList) {
        this.maProcessplanList = maProcessplanList;
    }

    @XmlTransient
    public List<AdMonth> getAdMonthList() {
        return adMonthList;
    }

    public void setAdMonthList(List<AdMonth> adMonthList) {
        this.adMonthList = adMonthList;
    }

    @XmlTransient
    public List<FinPayExecProcess> getFinPayExecProcessList() {
        return finPayExecProcessList;
    }

    public void setFinPayExecProcessList(List<FinPayExecProcess> finPayExecProcessList) {
        this.finPayExecProcessList = finPayExecProcessList;
    }

    @XmlTransient
    public List<AdErrorLog> getAdErrorLogList() {
        return adErrorLogList;
    }

    public void setAdErrorLogList(List<AdErrorLog> adErrorLogList) {
        this.adErrorLogList = adErrorLogList;
    }

    @XmlTransient
    public List<CBudget> getCBudgetList() {
        return cBudgetList;
    }

    public void setCBudgetList(List<CBudget> cBudgetList) {
        this.cBudgetList = cBudgetList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList1() {
        return factAcctList1;
    }

    public void setFactAcctList1(List<FactAcct> factAcctList1) {
        this.factAcctList1 = factAcctList1;
    }

    @XmlTransient
    public List<MPricelistVersion> getMPricelistVersionList() {
        return mPricelistVersionList;
    }

    public void setMPricelistVersionList(List<MPricelistVersion> mPricelistVersionList) {
        this.mPricelistVersionList = mPricelistVersionList;
    }

    @XmlTransient
    public List<AdPinstance> getAdPinstanceList() {
        return adPinstanceList;
    }

    public void setAdPinstanceList(List<AdPinstance> adPinstanceList) {
        this.adPinstanceList = adPinstanceList;
    }

    @XmlTransient
    public List<AdModuleMerge> getAdModuleMergeList() {
        return adModuleMergeList;
    }

    public void setAdModuleMergeList(List<AdModuleMerge> adModuleMergeList) {
        this.adModuleMergeList = adModuleMergeList;
    }

    @XmlTransient
    public List<MaMachineCost> getMaMachineCostList() {
        return maMachineCostList;
    }

    public void setMaMachineCostList(List<MaMachineCost> maMachineCostList) {
        this.maMachineCostList = maMachineCostList;
    }

    @XmlTransient
    public List<CExternalpos> getCExternalposList() {
        return cExternalposList;
    }

    public void setCExternalposList(List<CExternalpos> cExternalposList) {
        this.cExternalposList = cExternalposList;
    }

    @XmlTransient
    public List<MRequisitionline> getMRequisitionlineList() {
        return mRequisitionlineList;
    }

    public void setMRequisitionlineList(List<MRequisitionline> mRequisitionlineList) {
        this.mRequisitionlineList = mRequisitionlineList;
    }

    @XmlTransient
    public List<AdFieldgroupTrl> getAdFieldgroupTrlList() {
        return adFieldgroupTrlList;
    }

    public void setAdFieldgroupTrlList(List<AdFieldgroupTrl> adFieldgroupTrlList) {
        this.adFieldgroupTrlList = adFieldgroupTrlList;
    }

    @XmlTransient
    public List<MrpRunProduction> getMrpRunProductionList() {
        return mrpRunProductionList;
    }

    public void setMrpRunProductionList(List<MrpRunProduction> mrpRunProductionList) {
        this.mrpRunProductionList = mrpRunProductionList;
    }

    @XmlTransient
    public List<AdPinstancePara> getAdPinstanceParaList() {
        return adPinstanceParaList;
    }

    public void setAdPinstanceParaList(List<AdPinstancePara> adPinstanceParaList) {
        this.adPinstanceParaList = adPinstanceParaList;
    }

    @XmlTransient
    public List<AdAuxiliarinput> getAdAuxiliarinputList() {
        return adAuxiliarinputList;
    }

    public void setAdAuxiliarinputList(List<AdAuxiliarinput> adAuxiliarinputList) {
        this.adAuxiliarinputList = adAuxiliarinputList;
    }

    @XmlTransient
    public List<FinBankfileFormat> getFinBankfileFormatList() {
        return finBankfileFormatList;
    }

    public void setFinBankfileFormatList(List<FinBankfileFormat> finBankfileFormatList) {
        this.finBankfileFormatList = finBankfileFormatList;
    }

    @XmlTransient
    public List<AtLine> getAtLineList() {
        return atLineList;
    }

    public void setAtLineList(List<AtLine> atLineList) {
        this.atLineList = atLineList;
    }

    @XmlTransient
    public List<CPocEmailUser> getCPocEmailUserList() {
        return cPocEmailUserList;
    }

    public void setCPocEmailUserList(List<CPocEmailUser> cPocEmailUserList) {
        this.cPocEmailUserList = cPocEmailUserList;
    }

    public AdOrginfo getAdOrginfo() {
        return adOrginfo;
    }

    public void setAdOrginfo(AdOrginfo adOrginfo) {
        this.adOrginfo = adOrginfo;
    }

    @XmlTransient
    public List<MInventoryline> getMInventorylineList() {
        return mInventorylineList;
    }

    public void setMInventorylineList(List<MInventoryline> mInventorylineList) {
        this.mInventorylineList = mInventorylineList;
    }

    @XmlTransient
    public List<MAttributeinstance> getMAttributeinstanceList() {
        return mAttributeinstanceList;
    }

    public void setMAttributeinstanceList(List<MAttributeinstance> mAttributeinstanceList) {
        this.mAttributeinstanceList = mAttributeinstanceList;
    }

    @XmlTransient
    public List<CInterorgAcct> getCInterorgAcctList() {
        return cInterorgAcctList;
    }

    public void setCInterorgAcctList(List<CInterorgAcct> cInterorgAcctList) {
        this.cInterorgAcctList = cInterorgAcctList;
    }

    @XmlTransient
    public List<CInterorgAcct> getCInterorgAcctList1() {
        return cInterorgAcctList1;
    }

    public void setCInterorgAcctList1(List<CInterorgAcct> cInterorgAcctList1) {
        this.cInterorgAcctList1 = cInterorgAcctList1;
    }

    @XmlTransient
    public List<MaSequenceIc> getMaSequenceIcList() {
        return maSequenceIcList;
    }

    public void setMaSequenceIcList(List<MaSequenceIc> maSequenceIcList) {
        this.maSequenceIcList = maSequenceIcList;
    }

    @XmlTransient
    public List<CCommissionline> getCCommissionlineList() {
        return cCommissionlineList;
    }

    public void setCCommissionlineList(List<CCommissionline> cCommissionlineList) {
        this.cCommissionlineList = cCommissionlineList;
    }

    @XmlTransient
    public List<CCommissionline> getCCommissionlineList1() {
        return cCommissionlineList1;
    }

    public void setCCommissionlineList1(List<CCommissionline> cCommissionlineList1) {
        this.cCommissionlineList1 = cCommissionlineList1;
    }

    @XmlTransient
    public List<AdCreatefactTemplate> getAdCreatefactTemplateList() {
        return adCreatefactTemplateList;
    }

    public void setAdCreatefactTemplateList(List<AdCreatefactTemplate> adCreatefactTemplateList) {
        this.adCreatefactTemplateList = adCreatefactTemplateList;
    }

    @XmlTransient
    public List<CChannel> getCChannelList() {
        return cChannelList;
    }

    public void setCChannelList(List<CChannel> cChannelList) {
        this.cChannelList = cChannelList;
    }

    @XmlTransient
    public List<MaWeemployee> getMaWeemployeeList() {
        return maWeemployeeList;
    }

    public void setMaWeemployeeList(List<MaWeemployee> maWeemployeeList) {
        this.maWeemployeeList = maWeemployeeList;
    }

    @XmlTransient
    public List<MaSequenceproduct> getMaSequenceproductList() {
        return maSequenceproductList;
    }

    public void setMaSequenceproductList(List<MaSequenceproduct> maSequenceproductList) {
        this.maSequenceproductList = maSequenceproductList;
    }

    @XmlTransient
    public List<CInvoicetax> getCInvoicetaxList() {
        return cInvoicetaxList;
    }

    public void setCInvoicetaxList(List<CInvoicetax> cInvoicetaxList) {
        this.cInvoicetaxList = cInvoicetaxList;
    }

    @XmlTransient
    public List<MMovement> getMMovementList() {
        return mMovementList;
    }

    public void setMMovementList(List<MMovement> mMovementList) {
        this.mMovementList = mMovementList;
    }

    @XmlTransient
    public List<MMovement> getMMovementList1() {
        return mMovementList1;
    }

    public void setMMovementList1(List<MMovement> mMovementList1) {
        this.mMovementList1 = mMovementList1;
    }

    @XmlTransient
    public List<FinBankstatement> getFinBankstatementList() {
        return finBankstatementList;
    }

    public void setFinBankstatementList(List<FinBankstatement> finBankstatementList) {
        this.finBankstatementList = finBankstatementList;
    }

    @XmlTransient
    public List<CPaymentterm> getCPaymenttermList() {
        return cPaymenttermList;
    }

    public void setCPaymenttermList(List<CPaymentterm> cPaymenttermList) {
        this.cPaymenttermList = cPaymenttermList;
    }

    @XmlTransient
    public List<CPaymenttermline> getCPaymenttermlineList() {
        return cPaymenttermlineList;
    }

    public void setCPaymenttermlineList(List<CPaymenttermline> cPaymenttermlineList) {
        this.cPaymenttermlineList = cPaymenttermlineList;
    }

    @XmlTransient
    public List<CRemittanceType> getCRemittanceTypeList() {
        return cRemittanceTypeList;
    }

    public void setCRemittanceTypeList(List<CRemittanceType> cRemittanceTypeList) {
        this.cRemittanceTypeList = cRemittanceTypeList;
    }

    @XmlTransient
    public List<FinPaymentPriority> getFinPaymentPriorityList() {
        return finPaymentPriorityList;
    }

    public void setFinPaymentPriorityList(List<FinPaymentPriority> finPaymentPriorityList) {
        this.finPaymentPriorityList = finPaymentPriorityList;
    }

    @XmlTransient
    public List<MOfferBpartner> getMOfferBpartnerList() {
        return mOfferBpartnerList;
    }

    public void setMOfferBpartnerList(List<MOfferBpartner> mOfferBpartnerList) {
        this.mOfferBpartnerList = mOfferBpartnerList;
    }

    @XmlTransient
    public List<MaMeasureValues> getMaMeasureValuesList() {
        return maMeasureValuesList;
    }

    public void setMaMeasureValuesList(List<MaMeasureValues> maMeasureValuesList) {
        this.maMeasureValuesList = maMeasureValuesList;
    }

    @XmlTransient
    public List<CAcctRptGroup> getCAcctRptGroupList() {
        return cAcctRptGroupList;
    }

    public void setCAcctRptGroupList(List<CAcctRptGroup> cAcctRptGroupList) {
        this.cAcctRptGroupList = cAcctRptGroupList;
    }

    @XmlTransient
    public List<AdImpformatRow> getAdImpformatRowList() {
        return adImpformatRowList;
    }

    public void setAdImpformatRowList(List<AdImpformatRow> adImpformatRowList) {
        this.adImpformatRowList = adImpformatRowList;
    }

    @XmlTransient
    public List<CCharge> getCChargeList() {
        return cChargeList;
    }

    public void setCChargeList(List<CCharge> cChargeList) {
        this.cChargeList = cChargeList;
    }

    @XmlTransient
    public List<MProductBom> getMProductBomList() {
        return mProductBomList;
    }

    public void setMProductBomList(List<MProductBom> mProductBomList) {
        this.mProductBomList = mProductBomList;
    }

    @XmlTransient
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    @XmlTransient
    public List<AdTaskAccess> getAdTaskAccessList() {
        return adTaskAccessList;
    }

    public void setAdTaskAccessList(List<AdTaskAccess> adTaskAccessList) {
        this.adTaskAccessList = adTaskAccessList;
    }

    @XmlTransient
    public List<FinPaymentRun> getFinPaymentRunList() {
        return finPaymentRunList;
    }

    public void setFinPaymentRunList(List<FinPaymentRun> finPaymentRunList) {
        this.finPaymentRunList = finPaymentRunList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<AdWfNodenext> getAdWfNodenextList() {
        return adWfNodenextList;
    }

    public void setAdWfNodenextList(List<AdWfNodenext> adWfNodenextList) {
        this.adWfNodenextList = adWfNodenextList;
    }

    @XmlTransient
    public List<MLot> getMLotList() {
        return mLotList;
    }

    public void setMLotList(List<MLot> mLotList) {
        this.mLotList = mLotList;
    }

    @XmlTransient
    public List<SResourceunavailable> getSResourceunavailableList() {
        return sResourceunavailableList;
    }

    public void setSResourceunavailableList(List<SResourceunavailable> sResourceunavailableList) {
        this.sResourceunavailableList = sResourceunavailableList;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @XmlTransient
    public List<CRevenuerecognitionPlan> getCRevenuerecognitionPlanList() {
        return cRevenuerecognitionPlanList;
    }

    public void setCRevenuerecognitionPlanList(List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList) {
        this.cRevenuerecognitionPlanList = cRevenuerecognitionPlanList;
    }

    @XmlTransient
    public List<CTaxregisterTypeLines> getCTaxregisterTypeLinesList() {
        return cTaxregisterTypeLinesList;
    }

    public void setCTaxregisterTypeLinesList(List<CTaxregisterTypeLines> cTaxregisterTypeLinesList) {
        this.cTaxregisterTypeLinesList = cTaxregisterTypeLinesList;
    }

    @XmlTransient
    public List<MProductTrl> getMProductTrlList() {
        return mProductTrlList;
    }

    public void setMProductTrlList(List<MProductTrl> mProductTrlList) {
        this.mProductTrlList = mProductTrlList;
    }

    @XmlTransient
    public List<AdTable> getAdTableList() {
        return adTableList;
    }

    public void setAdTableList(List<AdTable> adTableList) {
        this.adTableList = adTableList;
    }

    @XmlTransient
    public List<AdAttachment> getAdAttachmentList() {
        return adAttachmentList;
    }

    public void setAdAttachmentList(List<AdAttachment> adAttachmentList) {
        this.adAttachmentList = adAttachmentList;
    }

    @XmlTransient
    public List<MOffer> getMOfferList() {
        return mOfferList;
    }

    public void setMOfferList(List<MOffer> mOfferList) {
        this.mOfferList = mOfferList;
    }

    @XmlTransient
    public List<MaMeasureTime> getMaMeasureTimeList() {
        return maMeasureTimeList;
    }

    public void setMaMeasureTimeList(List<MaMeasureTime> maMeasureTimeList) {
        this.maMeasureTimeList = maMeasureTimeList;
    }

    @XmlTransient
    public List<MaMachine> getMaMachineList() {
        return maMachineList;
    }

    public void setMaMachineList(List<MaMachine> maMachineList) {
        this.maMachineList = maMachineList;
    }

    @XmlTransient
    public List<CRevenuerecognition> getCRevenuerecognitionList() {
        return cRevenuerecognitionList;
    }

    public void setCRevenuerecognitionList(List<CRevenuerecognition> cRevenuerecognitionList) {
        this.cRevenuerecognitionList = cRevenuerecognitionList;
    }

    @XmlTransient
    public List<MReplenish> getMReplenishList() {
        return mReplenishList;
    }

    public void setMReplenishList(List<MReplenish> mReplenishList) {
        this.mReplenishList = mReplenishList;
    }

    @XmlTransient
    public List<CGlitemAcct> getCGlitemAcctList() {
        return cGlitemAcctList;
    }

    public void setCGlitemAcctList(List<CGlitemAcct> cGlitemAcctList) {
        this.cGlitemAcctList = cGlitemAcctList;
    }

    @XmlTransient
    public List<MaWorkstation> getMaWorkstationList() {
        return maWorkstationList;
    }

    public void setMaWorkstationList(List<MaWorkstation> maWorkstationList) {
        this.maWorkstationList = maWorkstationList;
    }

    @XmlTransient
    public List<AdProcessPara> getAdProcessParaList() {
        return adProcessParaList;
    }

    public void setAdProcessParaList(List<AdProcessPara> adProcessParaList) {
        this.adProcessParaList = adProcessParaList;
    }

    @XmlTransient
    public List<AdOrgAcctschema> getAdOrgAcctschemaList() {
        return adOrgAcctschemaList;
    }

    public void setAdOrgAcctschemaList(List<AdOrgAcctschema> adOrgAcctschemaList) {
        this.adOrgAcctschemaList = adOrgAcctschemaList;
    }

    @XmlTransient
    public List<MaWrphase> getMaWrphaseList() {
        return maWrphaseList;
    }

    public void setMaWrphaseList(List<MaWrphase> maWrphaseList) {
        this.maWrphaseList = maWrphaseList;
    }

    @XmlTransient
    public List<CAcctRpt> getCAcctRptList() {
        return cAcctRptList;
    }

    public void setCAcctRptList(List<CAcctRpt> cAcctRptList) {
        this.cAcctRptList = cAcctRptList;
    }

    @XmlTransient
    public List<AdModuleLog> getAdModuleLogList() {
        return adModuleLogList;
    }

    public void setAdModuleLogList(List<AdModuleLog> adModuleLogList) {
        this.adModuleLogList = adModuleLogList;
    }

    @XmlTransient
    public List<CCommissiondetail> getCCommissiondetailList() {
        return cCommissiondetailList;
    }

    public void setCCommissiondetailList(List<CCommissiondetail> cCommissiondetailList) {
        this.cCommissiondetailList = cCommissiondetailList;
    }

    @XmlTransient
    public List<AdWorkflow> getAdWorkflowList() {
        return adWorkflowList;
    }

    public void setAdWorkflowList(List<AdWorkflow> adWorkflowList) {
        this.adWorkflowList = adWorkflowList;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<MaPcCase> getMaPcCaseList() {
        return maPcCaseList;
    }

    public void setMaPcCaseList(List<MaPcCase> maPcCaseList) {
        this.maPcCaseList = maPcCaseList;
    }

    @XmlTransient
    public List<MPerpetualinv> getMPerpetualinvList() {
        return mPerpetualinvList;
    }

    public void setMPerpetualinvList(List<MPerpetualinv> mPerpetualinvList) {
        this.mPerpetualinvList = mPerpetualinvList;
    }

    @XmlTransient
    public List<MStoragePending> getMStoragePendingList() {
        return mStoragePendingList;
    }

    public void setMStoragePendingList(List<MStoragePending> mStoragePendingList) {
        this.mStoragePendingList = mStoragePendingList;
    }

    @XmlTransient
    public List<AdValRule> getAdValRuleList() {
        return adValRuleList;
    }

    public void setAdValRuleList(List<AdValRule> adValRuleList) {
        this.adValRuleList = adValRuleList;
    }

    @XmlTransient
    public List<AdWindowTrl> getAdWindowTrlList() {
        return adWindowTrlList;
    }

    public void setAdWindowTrlList(List<AdWindowTrl> adWindowTrlList) {
        this.adWindowTrlList = adWindowTrlList;
    }

    @XmlTransient
    public List<MAttributeuse> getMAttributeuseList() {
        return mAttributeuseList;
    }

    public void setMAttributeuseList(List<MAttributeuse> mAttributeuseList) {
        this.mAttributeuseList = mAttributeuseList;
    }

    @XmlTransient
    public List<CConversionRate> getCConversionRateList() {
        return cConversionRateList;
    }

    public void setCConversionRateList(List<CConversionRate> cConversionRateList) {
        this.cConversionRateList = cConversionRateList;
    }

    @XmlTransient
    public List<CTaxregisterline> getCTaxregisterlineList() {
        return cTaxregisterlineList;
    }

    public void setCTaxregisterlineList(List<CTaxregisterline> cTaxregisterlineList) {
        this.cTaxregisterlineList = cTaxregisterlineList;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList() {
        return mProductCategoryAcctList;
    }

    public void setMProductCategoryAcctList(List<MProductCategoryAcct> mProductCategoryAcctList) {
        this.mProductCategoryAcctList = mProductCategoryAcctList;
    }

    @XmlTransient
    public List<CUom> getCUomList() {
        return cUomList;
    }

    public void setCUomList(List<CUom> cUomList) {
        this.cUomList = cUomList;
    }

    @XmlTransient
    public List<CGreeting> getCGreetingList() {
        return cGreetingList;
    }

    public void setCGreetingList(List<CGreeting> cGreetingList) {
        this.cGreetingList = cGreetingList;
    }

    @XmlTransient
    public List<COrdertax> getCOrdertaxList() {
        return cOrdertaxList;
    }

    public void setCOrdertaxList(List<COrdertax> cOrdertaxList) {
        this.cOrdertaxList = cOrdertaxList;
    }

    @XmlTransient
    public List<CBpSalcategory> getCBpSalcategoryList() {
        return cBpSalcategoryList;
    }

    public void setCBpSalcategoryList(List<CBpSalcategory> cBpSalcategoryList) {
        this.cBpSalcategoryList = cBpSalcategoryList;
    }

    @XmlTransient
    public List<CPocConfiguration> getCPocConfigurationList() {
        return cPocConfigurationList;
    }

    public void setCPocConfigurationList(List<CPocConfiguration> cPocConfigurationList) {
        this.cPocConfigurationList = cPocConfigurationList;
    }

    @XmlTransient
    public List<AdModuleDependency> getAdModuleDependencyList() {
        return adModuleDependencyList;
    }

    public void setAdModuleDependencyList(List<AdModuleDependency> adModuleDependencyList) {
        this.adModuleDependencyList = adModuleDependencyList;
    }

    @XmlTransient
    public List<MProductCategory> getMProductCategoryList() {
        return mProductCategoryList;
    }

    public void setMProductCategoryList(List<MProductCategory> mProductCategoryList) {
        this.mProductCategoryList = mProductCategoryList;
    }

    @XmlTransient
    public List<CBank> getCBankList() {
        return cBankList;
    }

    public void setCBankList(List<CBank> cBankList) {
        this.cBankList = cBankList;
    }

    @XmlTransient
    public List<MOfferPricelist> getMOfferPricelistList() {
        return mOfferPricelistList;
    }

    public void setMOfferPricelistList(List<MOfferPricelist> mOfferPricelistList) {
        this.mOfferPricelistList = mOfferPricelistList;
    }

    @XmlTransient
    public List<MWhPeriodInvoiced> getMWhPeriodInvoicedList() {
        return mWhPeriodInvoicedList;
    }

    public void setMWhPeriodInvoicedList(List<MWhPeriodInvoiced> mWhPeriodInvoicedList) {
        this.mWhPeriodInvoicedList = mWhPeriodInvoicedList;
    }

    @XmlTransient
    public List<AdProcessAccess> getAdProcessAccessList() {
        return adProcessAccessList;
    }

    public void setAdProcessAccessList(List<AdProcessAccess> adProcessAccessList) {
        this.adProcessAccessList = adProcessAccessList;
    }

    @XmlTransient
    public List<MWarehouseShipper> getMWarehouseShipperList() {
        return mWarehouseShipperList;
    }

    public void setMWarehouseShipperList(List<MWarehouseShipper> mWarehouseShipperList) {
        this.mWarehouseShipperList = mWarehouseShipperList;
    }

    @XmlTransient
    public List<MRappelScale> getMRappelScaleList() {
        return mRappelScaleList;
    }

    public void setMRappelScaleList(List<MRappelScale> mRappelScaleList) {
        this.mRappelScaleList = mRappelScaleList;
    }

    @XmlTransient
    public List<AdAccountingrptElement> getAdAccountingrptElementList() {
        return adAccountingrptElementList;
    }

    public void setAdAccountingrptElementList(List<AdAccountingrptElement> adAccountingrptElementList) {
        this.adAccountingrptElementList = adAccountingrptElementList;
    }

    @XmlTransient
    public List<CBpWithholding> getCBpWithholdingList() {
        return cBpWithholdingList;
    }

    public void setCBpWithholdingList(List<CBpWithholding> cBpWithholdingList) {
        this.cBpWithholdingList = cBpWithholdingList;
    }

    @XmlTransient
    public List<MStorageDetail> getMStorageDetailList() {
        return mStorageDetailList;
    }

    public void setMStorageDetailList(List<MStorageDetail> mStorageDetailList) {
        this.mStorageDetailList = mStorageDetailList;
    }

    @XmlTransient
    public List<AdExtensionPoints> getAdExtensionPointsList() {
        return adExtensionPointsList;
    }

    public void setAdExtensionPointsList(List<AdExtensionPoints> adExtensionPointsList) {
        this.adExtensionPointsList = adExtensionPointsList;
    }

    @XmlTransient
    public List<MaCcpShift> getMaCcpShiftList() {
        return maCcpShiftList;
    }

    public void setMaCcpShiftList(List<MaCcpShift> maCcpShiftList) {
        this.maCcpShiftList = maCcpShiftList;
    }

    @XmlTransient
    public List<AdTreenodebp> getAdTreenodebpList() {
        return adTreenodebpList;
    }

    public void setAdTreenodebpList(List<AdTreenodebp> adTreenodebpList) {
        this.adTreenodebpList = adTreenodebpList;
    }

    @XmlTransient
    public List<MaMeasureShift> getMaMeasureShiftList() {
        return maMeasureShiftList;
    }

    public void setMaMeasureShiftList(List<MaMeasureShift> maMeasureShiftList) {
        this.maMeasureShiftList = maMeasureShiftList;
    }

    @XmlTransient
    public List<AdElement> getAdElementList() {
        return adElementList;
    }

    public void setAdElementList(List<AdElement> adElementList) {
        this.adElementList = adElementList;
    }

    @XmlTransient
    public List<SExpensetype> getSExpensetypeList() {
        return sExpensetypeList;
    }

    public void setSExpensetypeList(List<SExpensetype> sExpensetypeList) {
        this.sExpensetypeList = sExpensetypeList;
    }

    @XmlTransient
    public List<FinReconciliation> getFinReconciliationList() {
        return finReconciliationList;
    }

    public void setFinReconciliationList(List<FinReconciliation> finReconciliationList) {
        this.finReconciliationList = finReconciliationList;
    }

    @XmlTransient
    public List<AdRefDataLoaded> getAdRefDataLoadedList() {
        return adRefDataLoadedList;
    }

    public void setAdRefDataLoadedList(List<AdRefDataLoaded> adRefDataLoadedList) {
        this.adRefDataLoadedList = adRefDataLoadedList;
    }

    @XmlTransient
    public List<AdOrgmodule> getAdOrgmoduleList() {
        return adOrgmoduleList;
    }

    public void setAdOrgmoduleList(List<AdOrgmodule> adOrgmoduleList) {
        this.adOrgmoduleList = adOrgmoduleList;
    }

    @XmlTransient
    public List<SResourcetype> getSResourcetypeList() {
        return sResourcetypeList;
    }

    public void setSResourcetypeList(List<SResourcetype> sResourcetypeList) {
        this.sResourcetypeList = sResourcetypeList;
    }

    @XmlTransient
    public List<CWithholding> getCWithholdingList() {
        return cWithholdingList;
    }

    public void setCWithholdingList(List<CWithholding> cWithholdingList) {
        this.cWithholdingList = cWithholdingList;
    }

    @XmlTransient
    public List<MaPlEmployee> getMaPlEmployeeList() {
        return maPlEmployeeList;
    }

    public void setMaPlEmployeeList(List<MaPlEmployee> maPlEmployeeList) {
        this.maPlEmployeeList = maPlEmployeeList;
    }

    @XmlTransient
    public List<AdAlertrule> getAdAlertruleList() {
        return adAlertruleList;
    }

    public void setAdAlertruleList(List<AdAlertrule> adAlertruleList) {
        this.adAlertruleList = adAlertruleList;
    }

    @XmlTransient
    public List<MrpSalesforecast> getMrpSalesforecastList() {
        return mrpSalesforecastList;
    }

    public void setMrpSalesforecastList(List<MrpSalesforecast> mrpSalesforecastList) {
        this.mrpSalesforecastList = mrpSalesforecastList;
    }

    @XmlTransient
    public List<AdProcess> getAdProcessList() {
        return adProcessList;
    }

    public void setAdProcessList(List<AdProcess> adProcessList) {
        this.adProcessList = adProcessList;
    }

    @XmlTransient
    public List<AdProcessTrl> getAdProcessTrlList() {
        return adProcessTrlList;
    }

    public void setAdProcessTrlList(List<AdProcessTrl> adProcessTrlList) {
        this.adProcessTrlList = adProcessTrlList;
    }

    @XmlTransient
    public List<CRevenuerecognitionRun> getCRevenuerecognitionRunList() {
        return cRevenuerecognitionRunList;
    }

    public void setCRevenuerecognitionRunList(List<CRevenuerecognitionRun> cRevenuerecognitionRunList) {
        this.cRevenuerecognitionRunList = cRevenuerecognitionRunList;
    }

    @XmlTransient
    public List<AdOrgClosing> getAdOrgClosingList() {
        return adOrgClosingList;
    }

    public void setAdOrgClosingList(List<AdOrgClosing> adOrgClosingList) {
        this.adOrgClosingList = adOrgClosingList;
    }

    @XmlTransient
    public List<MAttributesetinstance> getMAttributesetinstanceList() {
        return mAttributesetinstanceList;
    }

    public void setMAttributesetinstanceList(List<MAttributesetinstance> mAttributesetinstanceList) {
        this.mAttributesetinstanceList = mAttributesetinstanceList;
    }

    @XmlTransient
    public List<MMovementline> getMMovementlineList() {
        return mMovementlineList;
    }

    public void setMMovementlineList(List<MMovementline> mMovementlineList) {
        this.mMovementlineList = mMovementlineList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<MProductionplan> getMProductionplanList() {
        return mProductionplanList;
    }

    public void setMProductionplanList(List<MProductionplan> mProductionplanList) {
        this.mProductionplanList = mProductionplanList;
    }

    @XmlTransient
    public List<CLocation> getCLocationList() {
        return cLocationList;
    }

    public void setCLocationList(List<CLocation> cLocationList) {
        this.cLocationList = cLocationList;
    }

    @XmlTransient
    public List<FinFinaccTransaction> getFinFinaccTransactionList() {
        return finFinaccTransactionList;
    }

    public void setFinFinaccTransactionList(List<FinFinaccTransaction> finFinaccTransactionList) {
        this.finFinaccTransactionList = finFinaccTransactionList;
    }

    @XmlTransient
    public List<CAcctschemaTable> getCAcctschemaTableList() {
        return cAcctschemaTableList;
    }

    public void setCAcctschemaTableList(List<CAcctschemaTable> cAcctschemaTableList) {
        this.cAcctschemaTableList = cAcctschemaTableList;
    }

    @XmlTransient
    public List<MDiscountschema> getMDiscountschemaList() {
        return mDiscountschemaList;
    }

    public void setMDiscountschemaList(List<MDiscountschema> mDiscountschemaList) {
        this.mDiscountschemaList = mDiscountschemaList;
    }

    @XmlTransient
    public List<MOfferBpGroup> getMOfferBpGroupList() {
        return mOfferBpGroupList;
    }

    public void setMOfferBpGroupList(List<MOfferBpGroup> mOfferBpGroupList) {
        this.mOfferBpGroupList = mOfferBpGroupList;
    }

    @XmlTransient
    public List<AdEpProcedures> getAdEpProceduresList() {
        return adEpProceduresList;
    }

    public void setAdEpProceduresList(List<AdEpProcedures> adEpProceduresList) {
        this.adEpProceduresList = adEpProceduresList;
    }

    @XmlTransient
    public List<CBpTaxcategory> getCBpTaxcategoryList() {
        return cBpTaxcategoryList;
    }

    public void setCBpTaxcategoryList(List<CBpTaxcategory> cBpTaxcategoryList) {
        this.cBpTaxcategoryList = cBpTaxcategoryList;
    }

    @XmlTransient
    public List<CBpVendorAcct> getCBpVendorAcctList() {
        return cBpVendorAcctList;
    }

    public void setCBpVendorAcctList(List<CBpVendorAcct> cBpVendorAcctList) {
        this.cBpVendorAcctList = cBpVendorAcctList;
    }

    @XmlTransient
    public List<AdSession> getAdSessionList() {
        return adSessionList;
    }

    public void setAdSessionList(List<AdSession> adSessionList) {
        this.adSessionList = adSessionList;
    }

    @XmlTransient
    public List<CRemittanceline> getCRemittancelineList() {
        return cRemittancelineList;
    }

    public void setCRemittancelineList(List<CRemittanceline> cRemittancelineList) {
        this.cRemittancelineList = cRemittancelineList;
    }

    @XmlTransient
    public List<MaToolsetprocess> getMaToolsetprocessList() {
        return maToolsetprocessList;
    }

    public void setMaToolsetprocessList(List<MaToolsetprocess> maToolsetprocessList) {
        this.maToolsetprocessList = maToolsetprocessList;
    }

    @XmlTransient
    public List<MLocator> getMLocatorList() {
        return mLocatorList;
    }

    public void setMLocatorList(List<MLocator> mLocatorList) {
        this.mLocatorList = mLocatorList;
    }

    @XmlTransient
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
    }

    @XmlTransient
    public List<MShipper> getMShipperList() {
        return mShipperList;
    }

    public void setMShipperList(List<MShipper> mShipperList) {
        this.mShipperList = mShipperList;
    }

    @XmlTransient
    public List<CPhase> getCPhaseList() {
        return cPhaseList;
    }

    public void setCPhaseList(List<CPhase> cPhaseList) {
        this.cPhaseList = cPhaseList;
    }

    @XmlTransient
    public List<AdMonthTrl> getAdMonthTrlList() {
        return adMonthTrlList;
    }

    public void setAdMonthTrlList(List<AdMonthTrl> adMonthTrlList) {
        this.adMonthTrlList = adMonthTrlList;
    }

    @XmlTransient
    public List<ITax> getITaxList() {
        return iTaxList;
    }

    public void setITaxList(List<ITax> iTaxList) {
        this.iTaxList = iTaxList;
    }

    @XmlTransient
    public List<MProductUom> getMProductUomList() {
        return mProductUomList;
    }

    public void setMProductUomList(List<MProductUom> mProductUomList) {
        this.mProductUomList = mProductUomList;
    }

    @XmlTransient
    public List<FinPaymentRunPayment> getFinPaymentRunPaymentList() {
        return finPaymentRunPaymentList;
    }

    public void setFinPaymentRunPaymentList(List<FinPaymentRunPayment> finPaymentRunPaymentList) {
        this.finPaymentRunPaymentList = finPaymentRunPaymentList;
    }

    @XmlTransient
    public List<MaSequenceEmployee> getMaSequenceEmployeeList() {
        return maSequenceEmployeeList;
    }

    public void setMaSequenceEmployeeList(List<MaSequenceEmployee> maSequenceEmployeeList) {
        this.maSequenceEmployeeList = maSequenceEmployeeList;
    }

    @XmlTransient
    public List<CProjectproposalline> getCProjectproposallineList() {
        return cProjectproposallineList;
    }

    public void setCProjectproposallineList(List<CProjectproposalline> cProjectproposallineList) {
        this.cProjectproposallineList = cProjectproposallineList;
    }

    @XmlTransient
    public List<CTaxregisterType> getCTaxregisterTypeList() {
        return cTaxregisterTypeList;
    }

    public void setCTaxregisterTypeList(List<CTaxregisterType> cTaxregisterTypeList) {
        this.cTaxregisterTypeList = cTaxregisterTypeList;
    }

    @XmlTransient
    public List<AdSessionUsageAudit> getAdSessionUsageAuditList() {
        return adSessionUsageAuditList;
    }

    public void setAdSessionUsageAuditList(List<AdSessionUsageAudit> adSessionUsageAuditList) {
        this.adSessionUsageAuditList = adSessionUsageAuditList;
    }

    @XmlTransient
    public List<CProjectline> getCProjectlineList() {
        return cProjectlineList;
    }

    public void setCProjectlineList(List<CProjectline> cProjectlineList) {
        this.cProjectlineList = cProjectlineList;
    }

    @XmlTransient
    public List<AdPackage> getAdPackageList() {
        return adPackageList;
    }

    public void setAdPackageList(List<AdPackage> adPackageList) {
        this.adPackageList = adPackageList;
    }

    @XmlTransient
    public List<CInvoiceReverse> getCInvoiceReverseList() {
        return cInvoiceReverseList;
    }

    public void setCInvoiceReverseList(List<CInvoiceReverse> cInvoiceReverseList) {
        this.cInvoiceReverseList = cInvoiceReverseList;
    }

    @XmlTransient
    public List<AdFormAccess> getAdFormAccessList() {
        return adFormAccessList;
    }

    public void setAdFormAccessList(List<AdFormAccess> adFormAccessList) {
        this.adFormAccessList = adFormAccessList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList() {
        return adClientinfoList;
    }

    public void setAdClientinfoList(List<AdClientinfo> adClientinfoList) {
        this.adClientinfoList = adClientinfoList;
    }

    @XmlTransient
    public List<AtCommand> getAtCommandList() {
        return atCommandList;
    }

    public void setAtCommandList(List<AtCommand> atCommandList) {
        this.atCommandList = atCommandList;
    }

    @XmlTransient
    public List<CBpCustomerAcct> getCBpCustomerAcctList() {
        return cBpCustomerAcctList;
    }

    public void setCBpCustomerAcctList(List<CBpCustomerAcct> cBpCustomerAcctList) {
        this.cBpCustomerAcctList = cBpCustomerAcctList;
    }

    @XmlTransient
    public List<MaPlMachine> getMaPlMachineList() {
        return maPlMachineList;
    }

    public void setMaPlMachineList(List<MaPlMachine> maPlMachineList) {
        this.maPlMachineList = maPlMachineList;
    }

    @XmlTransient
    public List<MProductprice> getMProductpriceList() {
        return mProductpriceList;
    }

    public void setMProductpriceList(List<MProductprice> mProductpriceList) {
        this.mProductpriceList = mProductpriceList;
    }

    @XmlTransient
    public List<FinPaymentProposal> getFinPaymentProposalList() {
        return finPaymentProposalList;
    }

    public void setFinPaymentProposalList(List<FinPaymentProposal> finPaymentProposalList) {
        this.finPaymentProposalList = finPaymentProposalList;
    }

    @XmlTransient
    public List<AdHbLogCqueryRow> getAdHbLogCqueryRowList() {
        return adHbLogCqueryRowList;
    }

    public void setAdHbLogCqueryRowList(List<AdHbLogCqueryRow> adHbLogCqueryRowList) {
        this.adHbLogCqueryRowList = adHbLogCqueryRowList;
    }

    @XmlTransient
    public List<AAmortization> getAAmortizationList() {
        return aAmortizationList;
    }

    public void setAAmortizationList(List<AAmortization> aAmortizationList) {
        this.aAmortizationList = aAmortizationList;
    }

    @XmlTransient
    public List<AdModuleInstall> getAdModuleInstallList() {
        return adModuleInstallList;
    }

    public void setAdModuleInstallList(List<AdModuleInstall> adModuleInstallList) {
        this.adModuleInstallList = adModuleInstallList;
    }

    @XmlTransient
    public List<CPocEmaildefinition> getCPocEmaildefinitionList() {
        return cPocEmaildefinitionList;
    }

    public void setCPocEmaildefinitionList(List<CPocEmaildefinition> cPocEmaildefinitionList) {
        this.cPocEmaildefinitionList = cPocEmaildefinitionList;
    }

    @XmlTransient
    public List<AdWorkflowAccess> getAdWorkflowAccessList() {
        return adWorkflowAccessList;
    }

    public void setAdWorkflowAccessList(List<AdWorkflowAccess> adWorkflowAccessList) {
        this.adWorkflowAccessList = adWorkflowAccessList;
    }

    @XmlTransient
    public List<CWithholdingAcct> getCWithholdingAcctList() {
        return cWithholdingAcctList;
    }

    public void setCWithholdingAcctList(List<CWithholdingAcct> cWithholdingAcctList) {
        this.cWithholdingAcctList = cWithholdingAcctList;
    }

    @XmlTransient
    public List<STimetype> getSTimetypeList() {
        return sTimetypeList;
    }

    public void setSTimetypeList(List<STimetype> sTimetypeList) {
        this.sTimetypeList = sTimetypeList;
    }

    @XmlTransient
    public List<CPaymenttermTrl> getCPaymenttermTrlList() {
        return cPaymenttermTrlList;
    }

    public void setCPaymenttermTrlList(List<CPaymenttermTrl> cPaymenttermTrlList) {
        this.cPaymenttermTrlList = cPaymenttermTrlList;
    }

    @XmlTransient
    public List<FinPaymentPropDetail> getFinPaymentPropDetailList() {
        return finPaymentPropDetailList;
    }

    public void setFinPaymentPropDetailList(List<FinPaymentPropDetail> finPaymentPropDetailList) {
        this.finPaymentPropDetailList = finPaymentPropDetailList;
    }

    @XmlTransient
    public List<MDiscountschemaline> getMDiscountschemalineList() {
        return mDiscountschemalineList;
    }

    public void setMDiscountschemalineList(List<MDiscountschemaline> mDiscountschemalineList) {
        this.mDiscountschemalineList = mDiscountschemalineList;
    }

    @XmlTransient
    public List<AdImpformat> getAdImpformatList() {
        return adImpformatList;
    }

    public void setAdImpformatList(List<AdImpformat> adImpformatList) {
        this.adImpformatList = adImpformatList;
    }

    @XmlTransient
    public List<AdModuleDbprefixInstall> getAdModuleDbprefixInstallList() {
        return adModuleDbprefixInstallList;
    }

    public void setAdModuleDbprefixInstallList(List<AdModuleDbprefixInstall> adModuleDbprefixInstallList) {
        this.adModuleDbprefixInstallList = adModuleDbprefixInstallList;
    }

    @XmlTransient
    public List<MaMachineType> getMaMachineTypeList() {
        return maMachineTypeList;
    }

    public void setMaMachineTypeList(List<MaMachineType> maMachineTypeList) {
        this.maMachineTypeList = maMachineTypeList;
    }

    @XmlTransient
    public List<AdOrgtype> getAdOrgtypeList() {
        return adOrgtypeList;
    }

    public void setAdOrgtypeList(List<AdOrgtype> adOrgtypeList) {
        this.adOrgtypeList = adOrgtypeList;
    }

    @XmlTransient
    public List<AdTabTrl> getAdTabTrlList() {
        return adTabTrlList;
    }

    public void setAdTabTrlList(List<AdTabTrl> adTabTrlList) {
        this.adTabTrlList = adTabTrlList;
    }

    @XmlTransient
    public List<MMatchpo> getMMatchpoList() {
        return mMatchpoList;
    }

    public void setMMatchpoList(List<MMatchpo> mMatchpoList) {
        this.mMatchpoList = mMatchpoList;
    }

    @XmlTransient
    public List<RRequestprocessorRoute> getRRequestprocessorRouteList() {
        return rRequestprocessorRouteList;
    }

    public void setRRequestprocessorRouteList(List<RRequestprocessorRoute> rRequestprocessorRouteList) {
        this.rRequestprocessorRouteList = rRequestprocessorRouteList;
    }

    @XmlTransient
    public List<STimeexpense> getSTimeexpenseList() {
        return sTimeexpenseList;
    }

    public void setSTimeexpenseList(List<STimeexpense> sTimeexpenseList) {
        this.sTimeexpenseList = sTimeexpenseList;
    }

    @XmlTransient
    public List<CPromissoryformat> getCPromissoryformatList() {
        return cPromissoryformatList;
    }

    public void setCPromissoryformatList(List<CPromissoryformat> cPromissoryformatList) {
        this.cPromissoryformatList = cPromissoryformatList;
    }

    @XmlTransient
    public List<MaCcpGroup> getMaCcpGroupList() {
        return maCcpGroupList;
    }

    public void setMaCcpGroupList(List<MaCcpGroup> maCcpGroupList) {
        this.maCcpGroupList = maCcpGroupList;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList1() {
        return cBudgetlineList1;
    }

    public void setCBudgetlineList1(List<CBudgetline> cBudgetlineList1) {
        this.cBudgetlineList1 = cBudgetlineList1;
    }

    @XmlTransient
    public List<MaPcTest> getMaPcTestList() {
        return maPcTestList;
    }

    public void setMaPcTestList(List<MaPcTest> maPcTestList) {
        this.maPcTestList = maPcTestList;
    }

    @XmlTransient
    public List<CUomTrl> getCUomTrlList() {
        return cUomTrlList;
    }

    public void setCUomTrlList(List<CUomTrl> cUomTrlList) {
        this.cUomTrlList = cUomTrlList;
    }

    @XmlTransient
    public List<FinPayExecProcessPara> getFinPayExecProcessParaList() {
        return finPayExecProcessParaList;
    }

    public void setFinPayExecProcessParaList(List<FinPayExecProcessPara> finPayExecProcessParaList) {
        this.finPayExecProcessParaList = finPayExecProcessParaList;
    }

    @XmlTransient
    public List<FinPaymentDetail> getFinPaymentDetailList() {
        return finPaymentDetailList;
    }

    public void setFinPaymentDetailList(List<FinPaymentDetail> finPaymentDetailList) {
        this.finPaymentDetailList = finPaymentDetailList;
    }

    @XmlTransient
    public List<AdTask> getAdTaskList() {
        return adTaskList;
    }

    public void setAdTaskList(List<AdTask> adTaskList) {
        this.adTaskList = adTaskList;
    }

    @XmlTransient
    public List<AAsset> getAAssetList() {
        return aAssetList;
    }

    public void setAAssetList(List<AAsset> aAssetList) {
        this.aAssetList = aAssetList;
    }

    @XmlTransient
    public List<MaWrphaseproduct> getMaWrphaseproductList() {
        return maWrphaseproductList;
    }

    public void setMaWrphaseproductList(List<MaWrphaseproduct> maWrphaseproductList) {
        this.maWrphaseproductList = maWrphaseproductList;
    }

    @XmlTransient
    public List<CAcctschemaElement> getCAcctschemaElementList() {
        return cAcctschemaElementList;
    }

    public void setCAcctschemaElementList(List<CAcctschemaElement> cAcctschemaElementList) {
        this.cAcctschemaElementList = cAcctschemaElementList;
    }

    @XmlTransient
    public List<CAcctschemaElement> getCAcctschemaElementList1() {
        return cAcctschemaElementList1;
    }

    public void setCAcctschemaElementList1(List<CAcctschemaElement> cAcctschemaElementList1) {
        this.cAcctschemaElementList1 = cAcctschemaElementList1;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList() {
        return cDebtPaymentList;
    }

    public void setCDebtPaymentList(List<CDebtPayment> cDebtPaymentList) {
        this.cDebtPaymentList = cDebtPaymentList;
    }

    @XmlTransient
    public List<CPeriod> getCPeriodList() {
        return cPeriodList;
    }

    public void setCPeriodList(List<CPeriod> cPeriodList) {
        this.cPeriodList = cPeriodList;
    }

    @XmlTransient
    public List<AdLanguage> getAdLanguageList() {
        return adLanguageList;
    }

    public void setAdLanguageList(List<AdLanguage> adLanguageList) {
        this.adLanguageList = adLanguageList;
    }

    @XmlTransient
    public List<AdProcessRequest> getAdProcessRequestList() {
        return adProcessRequestList;
    }

    public void setAdProcessRequestList(List<AdProcessRequest> adProcessRequestList) {
        this.adProcessRequestList = adProcessRequestList;
    }

    @XmlTransient
    public List<AdPropertyConfiguration> getAdPropertyConfigurationList() {
        return adPropertyConfigurationList;
    }

    public void setAdPropertyConfigurationList(List<AdPropertyConfiguration> adPropertyConfigurationList) {
        this.adPropertyConfigurationList = adPropertyConfigurationList;
    }

    @XmlTransient
    public List<AtTest> getAtTestList() {
        return atTestList;
    }

    public void setAtTestList(List<AtTest> atTestList) {
        this.atTestList = atTestList;
    }

    @XmlTransient
    public List<MLocatorType> getMLocatorTypeList() {
        return mLocatorTypeList;
    }

    public void setMLocatorTypeList(List<MLocatorType> mLocatorTypeList) {
        this.mLocatorTypeList = mLocatorTypeList;
    }

    @XmlTransient
    public List<GlJournal> getGlJournalList() {
        return glJournalList;
    }

    public void setGlJournalList(List<GlJournal> glJournalList) {
        this.glJournalList = glJournalList;
    }

    @XmlTransient
    public List<MaMeasureGroup> getMaMeasureGroupList() {
        return maMeasureGroupList;
    }

    public void setMaMeasureGroupList(List<MaMeasureGroup> maMeasureGroupList) {
        this.maMeasureGroupList = maMeasureGroupList;
    }

    @XmlTransient
    public List<MRequisition> getMRequisitionList() {
        return mRequisitionList;
    }

    public void setMRequisitionList(List<MRequisition> mRequisitionList) {
        this.mRequisitionList = mRequisitionList;
    }

    @XmlTransient
    public List<AdTreenodemm> getAdTreenodemmList() {
        return adTreenodemmList;
    }

    public void setAdTreenodemmList(List<AdTreenodemm> adTreenodemmList) {
        this.adTreenodemmList = adTreenodemmList;
    }

    @XmlTransient
    public List<CDiscount> getCDiscountList() {
        return cDiscountList;
    }

    public void setCDiscountList(List<CDiscount> cDiscountList) {
        this.cDiscountList = cDiscountList;
    }

    @XmlTransient
    public List<MrpSalesforecastline> getMrpSalesforecastlineList() {
        return mrpSalesforecastlineList;
    }

    public void setMrpSalesforecastlineList(List<MrpSalesforecastline> mrpSalesforecastlineList) {
        this.mrpSalesforecastlineList = mrpSalesforecastlineList;
    }

    @XmlTransient
    public List<MaCostcenterVersion> getMaCostcenterVersionList() {
        return maCostcenterVersionList;
    }

    public void setMaCostcenterVersionList(List<MaCostcenterVersion> maCostcenterVersionList) {
        this.maCostcenterVersionList = maCostcenterVersionList;
    }

    @XmlTransient
    public List<AdRegistrationInfo> getAdRegistrationInfoList() {
        return adRegistrationInfoList;
    }

    public void setAdRegistrationInfoList(List<AdRegistrationInfo> adRegistrationInfoList) {
        this.adRegistrationInfoList = adRegistrationInfoList;
    }

    @XmlTransient
    public List<COrgassignment> getCOrgassignmentList() {
        return cOrgassignmentList;
    }

    public void setCOrgassignmentList(List<COrgassignment> cOrgassignmentList) {
        this.cOrgassignmentList = cOrgassignmentList;
    }

    @XmlTransient
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
    }

    @XmlTransient
    public List<CRegion> getCRegionList() {
        return cRegionList;
    }

    public void setCRegionList(List<CRegion> cRegionList) {
        this.cRegionList = cRegionList;
    }

    @XmlTransient
    public List<MaIncidence> getMaIncidenceList() {
        return maIncidenceList;
    }

    public void setMaIncidenceList(List<MaIncidence> maIncidenceList) {
        this.maIncidenceList = maIncidenceList;
    }

    @XmlTransient
    public List<MRappelInvoice> getMRappelInvoiceList() {
        return mRappelInvoiceList;
    }

    public void setMRappelInvoiceList(List<MRappelInvoice> mRappelInvoiceList) {
        this.mRappelInvoiceList = mRappelInvoiceList;
    }

    @XmlTransient
    public List<MWhPeriod> getMWhPeriodList() {
        return mWhPeriodList;
    }

    public void setMWhPeriodList(List<MWhPeriod> mWhPeriodList) {
        this.mWhPeriodList = mWhPeriodList;
    }

    @XmlTransient
    public List<CCashbookAcct> getCCashbookAcctList() {
        return cCashbookAcctList;
    }

    public void setCCashbookAcctList(List<CCashbookAcct> cCashbookAcctList) {
        this.cCashbookAcctList = cCashbookAcctList;
    }

    @XmlTransient
    public List<AdAlert> getAdAlertList() {
        return adAlertList;
    }

    public void setAdAlertList(List<AdAlert> adAlertList) {
        this.adAlertList = adAlertList;
    }

    @XmlTransient
    public List<CCountry> getCCountryList() {
        return cCountryList;
    }

    public void setCCountryList(List<CCountry> cCountryList) {
        this.cCountryList = cCountryList;
    }

    @XmlTransient
    public List<MOfferProdCat> getMOfferProdCatList() {
        return mOfferProdCatList;
    }

    public void setMOfferProdCatList(List<MOfferProdCat> mOfferProdCatList) {
        this.mOfferProdCatList = mOfferProdCatList;
    }

    @XmlTransient
    public List<MInoutline> getMInoutlineList() {
        return mInoutlineList;
    }

    public void setMInoutlineList(List<MInoutline> mInoutlineList) {
        this.mInoutlineList = mInoutlineList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @XmlTransient
    public List<MInout> getMInoutList1() {
        return mInoutList1;
    }

    public void setMInoutList1(List<MInout> mInoutList1) {
        this.mInoutList1 = mInoutList1;
    }

    @XmlTransient
    public List<CElementvalueOperand> getCElementvalueOperandList() {
        return cElementvalueOperandList;
    }

    public void setCElementvalueOperandList(List<CElementvalueOperand> cElementvalueOperandList) {
        this.cElementvalueOperandList = cElementvalueOperandList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @XmlTransient
    public List<MAttributeset> getMAttributesetList() {
        return mAttributesetList;
    }

    public void setMAttributesetList(List<MAttributeset> mAttributesetList) {
        this.mAttributesetList = mAttributesetList;
    }

    @XmlTransient
    public List<AdMenuTrl> getAdMenuTrlList() {
        return adMenuTrlList;
    }

    public void setAdMenuTrlList(List<AdMenuTrl> adMenuTrlList) {
        this.adMenuTrlList = adMenuTrlList;
    }

    @XmlTransient
    public List<CSalesregion> getCSalesregionList() {
        return cSalesregionList;
    }

    public void setCSalesregionList(List<CSalesregion> cSalesregionList) {
        this.cSalesregionList = cSalesregionList;
    }

    @XmlTransient
    public List<CCashbook> getCCashbookList() {
        return cCashbookList;
    }

    public void setCCashbookList(List<CCashbook> cCashbookList) {
        this.cCashbookList = cCashbookList;
    }

    @XmlTransient
    public List<AdSystem> getAdSystemList() {
        return adSystemList;
    }

    public void setAdSystemList(List<AdSystem> adSystemList) {
        this.adSystemList = adSystemList;
    }

    @XmlTransient
    public List<CGlitem> getCGlitemList() {
        return cGlitemList;
    }

    public void setCGlitemList(List<CGlitem> cGlitemList) {
        this.cGlitemList = cGlitemList;
    }

    @XmlTransient
    public List<FinPaymentmethod> getFinPaymentmethodList() {
        return finPaymentmethodList;
    }

    public void setFinPaymentmethodList(List<FinPaymentmethod> finPaymentmethodList) {
        this.finPaymentmethodList = finPaymentmethodList;
    }

    @XmlTransient
    public List<CBankaccount> getCBankaccountList() {
        return cBankaccountList;
    }

    public void setCBankaccountList(List<CBankaccount> cBankaccountList) {
        this.cBankaccountList = cBankaccountList;
    }

    @XmlTransient
    public List<AdCallout> getAdCalloutList() {
        return adCalloutList;
    }

    public void setAdCalloutList(List<AdCallout> adCalloutList) {
        this.adCalloutList = adCalloutList;
    }

    @XmlTransient
    public List<AdModelObjectMapping> getAdModelObjectMappingList() {
        return adModelObjectMappingList;
    }

    public void setAdModelObjectMappingList(List<AdModelObjectMapping> adModelObjectMappingList) {
        this.adModelObjectMappingList = adModelObjectMappingList;
    }

    @XmlTransient
    public List<AdUserRoles> getAdUserRolesList() {
        return adUserRolesList;
    }

    public void setAdUserRolesList(List<AdUserRoles> adUserRolesList) {
        this.adUserRolesList = adUserRolesList;
    }

    @XmlTransient
    public List<MLotctl> getMLotctlList() {
        return mLotctlList;
    }

    public void setMLotctlList(List<MLotctl> mLotctlList) {
        this.mLotctlList = mLotctlList;
    }

    @XmlTransient
    public List<CDpManagementline> getCDpManagementlineList() {
        return cDpManagementlineList;
    }

    public void setCDpManagementlineList(List<CDpManagementline> cDpManagementlineList) {
        this.cDpManagementlineList = cDpManagementlineList;
    }

    @XmlTransient
    public List<CExternalposProduct> getCExternalposProductList() {
        return cExternalposProductList;
    }

    public void setCExternalposProductList(List<CExternalposProduct> cExternalposProductList) {
        this.cExternalposProductList = cExternalposProductList;
    }

    @XmlTransient
    public List<AdColumnAccess> getAdColumnAccessList() {
        return adColumnAccessList;
    }

    public void setAdColumnAccessList(List<AdColumnAccess> adColumnAccessList) {
        this.adColumnAccessList = adColumnAccessList;
    }

    @XmlTransient
    public List<AdWindow> getAdWindowList() {
        return adWindowList;
    }

    public void setAdWindowList(List<AdWindow> adWindowList) {
        this.adWindowList = adWindowList;
    }

    @XmlTransient
    public List<MWhSchedule> getMWhScheduleList() {
        return mWhScheduleList;
    }

    public void setMWhScheduleList(List<MWhSchedule> mWhScheduleList) {
        this.mWhScheduleList = mWhScheduleList;
    }

    @XmlTransient
    public List<CCash> getCCashList() {
        return cCashList;
    }

    public void setCCashList(List<CCash> cCashList) {
        this.cCashList = cCashList;
    }

    @XmlTransient
    public List<CCash> getCCashList1() {
        return cCashList1;
    }

    public void setCCashList1(List<CCash> cCashList1) {
        this.cCashList1 = cCashList1;
    }

    @XmlTransient
    public List<MRappelBpartner> getMRappelBpartnerList() {
        return mRappelBpartnerList;
    }

    public void setMRappelBpartnerList(List<MRappelBpartner> mRappelBpartnerList) {
        this.mRappelBpartnerList = mRappelBpartnerList;
    }

    @XmlTransient
    public List<AdRefSearchColumn> getAdRefSearchColumnList() {
        return adRefSearchColumnList;
    }

    public void setAdRefSearchColumnList(List<AdRefSearchColumn> adRefSearchColumnList) {
        this.adRefSearchColumnList = adRefSearchColumnList;
    }

    @XmlTransient
    public List<MrpPlanner> getMrpPlannerList() {
        return mrpPlannerList;
    }

    public void setMrpPlannerList(List<MrpPlanner> mrpPlannerList) {
        this.mrpPlannerList = mrpPlannerList;
    }

    @XmlTransient
    public List<AdFieldgroup> getAdFieldgroupList() {
        return adFieldgroupList;
    }

    public void setAdFieldgroupList(List<AdFieldgroup> adFieldgroupList) {
        this.adFieldgroupList = adFieldgroupList;
    }

    @XmlTransient
    public List<CSalaryCategoryCost> getCSalaryCategoryCostList() {
        return cSalaryCategoryCostList;
    }

    public void setCSalaryCategoryCostList(List<CSalaryCategoryCost> cSalaryCategoryCostList) {
        this.cSalaryCategoryCostList = cSalaryCategoryCostList;
    }

    @XmlTransient
    public List<AdMessage> getAdMessageList() {
        return adMessageList;
    }

    public void setAdMessageList(List<AdMessage> adMessageList) {
        this.adMessageList = adMessageList;
    }

    @XmlTransient
    public List<CPocDoctypeTemplate> getCPocDoctypeTemplateList() {
        return cPocDoctypeTemplateList;
    }

    public void setCPocDoctypeTemplateList(List<CPocDoctypeTemplate> cPocDoctypeTemplateList) {
        this.cPocDoctypeTemplateList = cPocDoctypeTemplateList;
    }

    @XmlTransient
    public List<RRequestaction> getRRequestactionList() {
        return rRequestactionList;
    }

    public void setRRequestactionList(List<RRequestaction> rRequestactionList) {
        this.rRequestactionList = rRequestactionList;
    }

    @XmlTransient
    public List<MaMaintPeriodicity> getMaMaintPeriodicityList() {
        return maMaintPeriodicityList;
    }

    public void setMaMaintPeriodicityList(List<MaMaintPeriodicity> maMaintPeriodicityList) {
        this.maMaintPeriodicityList = maMaintPeriodicityList;
    }

    @XmlTransient
    public List<AAmortizationline> getAAmortizationlineList() {
        return aAmortizationlineList;
    }

    public void setAAmortizationlineList(List<AAmortizationline> aAmortizationlineList) {
        this.aAmortizationlineList = aAmortizationlineList;
    }

    @XmlTransient
    public List<AdRecordAccess> getAdRecordAccessList() {
        return adRecordAccessList;
    }

    public void setAdRecordAccessList(List<AdRecordAccess> adRecordAccessList) {
        this.adRecordAccessList = adRecordAccessList;
    }

    @XmlTransient
    public List<AdField> getAdFieldList() {
        return adFieldList;
    }

    public void setAdFieldList(List<AdField> adFieldList) {
        this.adFieldList = adFieldList;
    }

    @XmlTransient
    public List<CAcctschema> getCAcctschemaList() {
        return cAcctschemaList;
    }

    public void setCAcctschemaList(List<CAcctschema> cAcctschemaList) {
        this.cAcctschemaList = cAcctschemaList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrgtype getAdOrgtypeId() {
        return adOrgtypeId;
    }

    public void setAdOrgtypeId(AdOrgtype adOrgtypeId) {
        this.adOrgtypeId = adOrgtypeId;
    }

    public CCalendar getCCalendarId() {
        return cCalendarId;
    }

    public void setCCalendarId(CCalendar cCalendarId) {
        this.cCalendarId = cCalendarId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @XmlTransient
    public List<MaPeriodicControl> getMaPeriodicControlList() {
        return maPeriodicControlList;
    }

    public void setMaPeriodicControlList(List<MaPeriodicControl> maPeriodicControlList) {
        this.maPeriodicControlList = maPeriodicControlList;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList() {
        return cBankaccountAcctList;
    }

    public void setCBankaccountAcctList(List<CBankaccountAcct> cBankaccountAcctList) {
        this.cBankaccountAcctList = cBankaccountAcctList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adOrgId != null ? adOrgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdOrg)) {
            return false;
        }
        AdOrg other = (AdOrg) object;
        if ((this.adOrgId == null && other.adOrgId != null) || (this.adOrgId != null && !this.adOrgId.equals(other.adOrgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdOrg[ adOrgId=" + adOrgId + " ]";
    }
    
}
