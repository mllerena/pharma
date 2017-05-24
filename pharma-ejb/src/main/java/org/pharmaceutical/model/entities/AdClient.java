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
@Table(name = "ad_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdClient.findAll", query = "SELECT a FROM AdClient a"),
    @NamedQuery(name = "AdClient.findByAdClientId", query = "SELECT a FROM AdClient a WHERE a.adClientId = :adClientId"),
    @NamedQuery(name = "AdClient.findByIsactive", query = "SELECT a FROM AdClient a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdClient.findByCreated", query = "SELECT a FROM AdClient a WHERE a.created = :created"),
    @NamedQuery(name = "AdClient.findByCreatedby", query = "SELECT a FROM AdClient a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdClient.findByUpdated", query = "SELECT a FROM AdClient a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdClient.findByUpdatedby", query = "SELECT a FROM AdClient a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdClient.findByValue", query = "SELECT a FROM AdClient a WHERE a.value = :value"),
    @NamedQuery(name = "AdClient.findByName", query = "SELECT a FROM AdClient a WHERE a.name = :name"),
    @NamedQuery(name = "AdClient.findByDescription", query = "SELECT a FROM AdClient a WHERE a.description = :description"),
    @NamedQuery(name = "AdClient.findBySmtphost", query = "SELECT a FROM AdClient a WHERE a.smtphost = :smtphost"),
    @NamedQuery(name = "AdClient.findByRequestemail", query = "SELECT a FROM AdClient a WHERE a.requestemail = :requestemail"),
    @NamedQuery(name = "AdClient.findByRequestuser", query = "SELECT a FROM AdClient a WHERE a.requestuser = :requestuser"),
    @NamedQuery(name = "AdClient.findByRequestuserpw", query = "SELECT a FROM AdClient a WHERE a.requestuserpw = :requestuserpw"),
    @NamedQuery(name = "AdClient.findByRequestfolder", query = "SELECT a FROM AdClient a WHERE a.requestfolder = :requestfolder"),
    @NamedQuery(name = "AdClient.findByIsmultilingualdocument", query = "SELECT a FROM AdClient a WHERE a.ismultilingualdocument = :ismultilingualdocument"),
    @NamedQuery(name = "AdClient.findByIssmtpauthorization", query = "SELECT a FROM AdClient a WHERE a.issmtpauthorization = :issmtpauthorization")})
public class AdClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_client_id")
    private String adClientId;
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
    @Size(max = 60)
    @Column(name = "smtphost")
    private String smtphost;
    @Size(max = 40)
    @Column(name = "requestemail")
    private String requestemail;
    @Size(max = 40)
    @Column(name = "requestuser")
    private String requestuser;
    @Size(max = 60)
    @Column(name = "requestuserpw")
    private String requestuserpw;
    @Size(max = 20)
    @Column(name = "requestfolder")
    private String requestfolder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ismultilingualdocument")
    private Character ismultilingualdocument;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issmtpauthorization")
    private Character issmtpauthorization;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaPlInvoiceline> maPlInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoicelineOffer> cInvoicelineOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMaintenance> maMaintenanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaSection> maSectionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdProcessScheduling> adProcessSchedulingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaProcessplanVersion> maProcessplanVersionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CSalaryCategory> cSalaryCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjectphase> cProjectphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CExternalposCategory> cExternalposCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCampaign> cCampaignList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RRequesttype> rRequesttypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTreebar> adTreebarList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MAttribute> mAttributeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModuleDependencyInst> adModuleDependencyInstList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxcategoryTrl> cTaxcategoryTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CElementvalue> cElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<CPocEmail> cPocEmailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaSequenceMachine> maSequenceMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctschemaTableDoctype> cAcctschemaTableDoctypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdForm> adFormList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IBankstatement> iBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdExceptions> adExceptionsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRefList> adRefListList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCountryTrl> cCountryTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProduction> mProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RRequestprocessor> rRequestprocessorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MInventory> mInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRappelProductcategory> mRappelProductcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPeriodcontrol> cPeriodcontrolList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRole> adRoleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdMessageTrl> adMessageTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjectissue> cProjectissueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductionline> mProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTreenode> adTreenodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWfNodeTrl> adWfNodeTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<SResource> sResourceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjecttype> cProjecttypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AtRollogin> atRolloginList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdColumn> adColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdImage> adImageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTableAccess> adTableAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTreenodepr> adTreenodeprList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTax> cTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModelObjectPara> adModelObjectParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CSettlement> cSettlementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CDoctypeTrl> cDoctypeTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMaintOperation> maMaintOperationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinMatchingAlgorithm> finMatchingAlgorithmList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCurrency> cCurrencyList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaIndirectCost> maIndirectCostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CActivity> cActivityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RResourceplancost> rResourceplancostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MFreightcategory> mFreightcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpPlanningmethod> mrpPlanningmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<GlCategory> glCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpRunPurchase> mrpRunPurchaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdClientmodule> adClientmoduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpEmployeeAcct> cBpEmployeeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjectAcct> cProjectAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaWeincidence> maWeincidenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AAssetGroup> aAssetGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxregister> cTaxregisterList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdPreference> adPreferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "visibleatClientId")
    private List<AdPreference> adPreferenceList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<CChargeAcct> cChargeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaCostcenterIc> maCostcenterIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxTrl> cTaxTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdElementTrl> adElementTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdHbLogCquery> adHbLogCqueryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AAssetGroupAcct> aAssetGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaPcValue> maPcValueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctschemaProcess> cAcctschemaProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CDoctype> cDoctypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRequisitionorder> mRequisitionorderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<COrderlineOffer> cOrderlineOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaCostcenterMachine> maCostcenterMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxReport> cTaxReportList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaIndirectCostValue> maIndirectCostValueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCalendar> cCalendarList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdFormTrl> adFormTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpPlanningmethodline> mrpPlanningmethodlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdMenu> adMenuList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductCustomer> mProductCustomerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRappelProduct> mRappelProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AAssetAcct> aAssetAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CGreetingTrl> cGreetingTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMaintPart> maMaintPartList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MFreight> mFreightList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<SResourceassignment> sResourceassignmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRefListTrl> adRefListTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CElement> cElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FactAcctCfs> factAcctCfsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRefSearch> adRefSearchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpartnerLocation> cBpartnerLocationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinBankstatementline> finBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RInterestarea> rInterestareaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductTemplate> mProductTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModuleDbprefix> adModuleDbprefixList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoicelinetax> cInvoicelinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaToolsetused> maToolsetusedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBankstatementline> cBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdAcctprocess> adAcctprocessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTaskTrl> adTaskTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoiceDiscount> cInvoiceDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MWarehouse> mWarehouseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaWorkrequirement> maWorkrequirementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CRemittance> cRemittanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMaintWorker> maMaintWorkerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AtCommandTrl> atCommandTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMaintScheduled> maMaintScheduledList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdAlertrecipient> adAlertrecipientList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctschemaDefault> cAcctschemaDefaultList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWfNode> adWfNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModuleTrl> adModuleTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CYear> cYearList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MSubstitute> mSubstituteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MWhScheduleProduct> mWhScheduleProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MInternalConsumption> mInternalConsumptionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adClient1")
    private AdClient adClient;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AdClient adClient1;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCommission> cCommissionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CNonbusinessday> cNonbusinessdayList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaSequence> maSequenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRappel> mRappelList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductOrg> mProductOrgList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MWarehouseAcct> mWarehouseAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RMailtext> rMailtextList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpGroup> cBpGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CElementvalueTrl> cElementvalueTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinFinancialAccount> finFinancialAccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdReferenceTrl> adReferenceTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTextinterfacesTrl> adTextinterfacesTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentCredit> finPaymentCreditList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdUser> adUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "defaultAdClientId")
    private List<AdUser> adUserList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AtTestdocumentline> atTestdocumentlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinFinaccPaymentmethod> finFinaccPaymentmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<COrderDiscount> cOrderDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IProduct> iProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<CTaxpayment> cTaxpaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdSessionStatus> adSessionStatusList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdSystemInfo> adSystemInfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<COrderlinetax> cOrderlinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCashline> cCashlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCommissionrun> cCommissionrunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjectproposal> cProjectproposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaPlIc> maPlIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpartnerDiscount> cBpartnerDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IBpartner> iBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CUomConversion> cUomConversionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<CTaxZone> cTaxZoneList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CDpManagement> cDpManagementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AtTestdocument> atTestdocumentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CDebtPaymentBalReplace> cDebtPaymentBalReplaceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaCcp> maCcpList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTree> adTreeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<GlJournalbatch> glJournalbatchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdHeartbeatLog> adHeartbeatLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdSequence> adSequenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTextinterfaces> adTextinterfacesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CIncoterms> cIncotermsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentSchedule> finPaymentScheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdDataset> adDatasetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdAlertruleTrl> adAlertruleTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjectVendor> cProjectVendorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdDatasetColumn> adDatasetColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCommissionamt> cCommissionamtList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTask> cTaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CFile> cFileList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctRptNode> cAcctRptNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWindowAccess> adWindowAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCurrencyTrl> cCurrencyTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductAcct> mProductAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaProcess> maProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaToolsetType> maToolsetTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MCosting> mCostingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModule> adModuleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRefTable> adRefTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IInventory> iInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdFieldTrl> adFieldTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBankstatement> cBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MSernoctl> mSernoctlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCity> cCityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductPo> mProductPoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IElementvalue> iElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdProcessRun> adProcessRunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWorkflowTrl> adWorkflowTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPeriodcontrolLog> cPeriodcontrolLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctschemaGl> cAcctschemaGlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CRemittanceParameter> cRemittanceParameterList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MInternalConsumptionline> mInternalConsumptionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentRunPara> finPaymentRunParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaGlobaluse> maGlobaluseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjectproposaltask> cProjectproposaltaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MOfferProduct> mOfferProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MAttributevalue> mAttributevalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxAcct> cTaxAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CDebtPaymentBalancing> cDebtPaymentBalancingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CServicelevel> cServicelevelList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdNote> adNoteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MMatchinv> mMatchinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpGroupAcct> cBpGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdProcessParaTrl> adProcessParaTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoiceschedule> cInvoicescheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaToolset> maToolsetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaCostcenter> maCostcenterList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRoleOrgaccess> adRoleOrgaccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinReclineTemp> finReclineTempList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RContactinterest> rContactinterestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdChangelog> adChangelogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaCostcenterEmployee> maCostcenterEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModelObject> adModelObjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MPricelist> mPricelistList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjecttask> cProjecttaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdDatasetTable> adDatasetTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMachinestation> maMachinestationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpBankaccount> cBpBankaccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdDimension> adDimensionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdDatatype> adDatatypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdReference> adReferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxcategory> cTaxcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CServicelevelline> cServicelevellineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaProcessplan> maProcessplanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdMonth> adMonthList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPayExecProcess> finPayExecProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdErrorLog> adErrorLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBudget> cBudgetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MPricelistVersion> mPricelistVersionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<AdPinstance> adPinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModuleMerge> adModuleMergeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMachineCost> maMachineCostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CExternalpos> cExternalposList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdFieldgroupTrl> adFieldgroupTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpRunProduction> mrpRunProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<AdPinstancePara> adPinstanceParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdAuxiliarinput> adAuxiliarinputList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinBankfileFormat> finBankfileFormatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AtLine> atLineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<CPocEmailUser> cPocEmailUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdOrginfo> adOrginfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MInventoryline> mInventorylineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MAttributeinstance> mAttributeinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<CInterorgAcct> cInterorgAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaSequenceIc> maSequenceIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCommissionline> cCommissionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdCreatefactTemplate> adCreatefactTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CChannel> cChannelList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaWeemployee> maWeemployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaSequenceproduct> maSequenceproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoicetax> cInvoicetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MMovement> mMovementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinBankstatement> finBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPaymentterm> cPaymenttermList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPaymenttermline> cPaymenttermlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CRemittanceType> cRemittanceTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentPriority> finPaymentPriorityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MOfferBpartner> mOfferBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMeasureValues> maMeasureValuesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctRptGroup> cAcctRptGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdImpformatRow> adImpformatRowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCharge> cChargeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductBom> mProductBomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTab> adTabList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTaskAccess> adTaskAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentRun> finPaymentRunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWfNodenext> adWfNodenextList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MLot> mLotList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<SResourceunavailable> sResourceunavailableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MTransaction> mTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxregisterTypeLines> cTaxregisterTypeLinesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductTrl> mProductTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTable> adTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdAttachment> adAttachmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MOffer> mOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMeasureTime> maMeasureTimeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMachine> maMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CRevenuerecognition> cRevenuerecognitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MReplenish> mReplenishList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CGlitemAcct> cGlitemAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaWorkstation> maWorkstationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdProcessPara> adProcessParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdOrgAcctschema> adOrgAcctschemaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaWrphase> maWrphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctRpt> cAcctRptList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModuleLog> adModuleLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCommissiondetail> cCommissiondetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWorkflow> adWorkflowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaPcCase> maPcCaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MPerpetualinv> mPerpetualinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MStoragePending> mStoragePendingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdValRule> adValRuleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWindowTrl> adWindowTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MAttributeuse> mAttributeuseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CConversionRate> cConversionRateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxregisterline> cTaxregisterlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductCategoryAcct> mProductCategoryAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CUom> cUomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CGreeting> cGreetingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<COrdertax> cOrdertaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpSalcategory> cBpSalcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPocConfiguration> cPocConfigurationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModuleDependency> adModuleDependencyList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductCategory> mProductCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBank> cBankList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MOfferPricelist> mOfferPricelistList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MWhPeriodInvoiced> mWhPeriodInvoicedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdProcessAccess> adProcessAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MWarehouseShipper> mWarehouseShipperList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRappelScale> mRappelScaleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdAccountingrptElement> adAccountingrptElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpWithholding> cBpWithholdingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MStorageDetail> mStorageDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdExtensionPoints> adExtensionPointsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaCcpShift> maCcpShiftList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTreenodebp> adTreenodebpList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMeasureShift> maMeasureShiftList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdElement> adElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<SExpensetype> sExpensetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinReconciliation> finReconciliationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRefDataLoaded> adRefDataLoadedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdOrgmodule> adOrgmoduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<SResourcetype> sResourcetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CWithholding> cWithholdingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaPlEmployee> maPlEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdAlertrule> adAlertruleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpSalesforecast> mrpSalesforecastList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdProcess> adProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdProcessTrl> adProcessTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CRevenuerecognitionRun> cRevenuerecognitionRunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdOrgClosing> adOrgClosingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MAttributesetinstance> mAttributesetinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MMovementline> mMovementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductionplan> mProductionplanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CLocation> cLocationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctschemaTable> cAcctschemaTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MDiscountschema> mDiscountschemaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MOfferBpGroup> mOfferBpGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdEpProcedures> adEpProceduresList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpTaxcategory> cBpTaxcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpVendorAcct> cBpVendorAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdSession> adSessionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CRemittanceline> cRemittancelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaToolsetprocess> maToolsetprocessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MLocator> mLocatorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpRunProductionline> mrpRunProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MShipper> mShipperList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPhase> cPhaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdMonthTrl> adMonthTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<ITax> iTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductUom> mProductUomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentRunPayment> finPaymentRunPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaSequenceEmployee> maSequenceEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjectproposalline> cProjectproposallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CTaxregisterType> cTaxregisterTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdSessionUsageAudit> adSessionUsageAuditList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProjectline> cProjectlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdPackage> adPackageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CInvoiceReverse> cInvoiceReverseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdFormAccess> adFormAccessList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adClient")
    private AdClientinfo adClientinfo;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AtCommand> atCommandList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBpCustomerAcct> cBpCustomerAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaPlMachine> maPlMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MProductprice> mProductpriceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentProposal> finPaymentProposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdHbLogCqueryRow> adHbLogCqueryRowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AAmortization> aAmortizationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModuleInstall> adModuleInstallList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPocEmaildefinition> cPocEmaildefinitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWorkflowAccess> adWorkflowAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<CWithholdingAcct> cWithholdingAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adClientId")
    private List<STimetype> sTimetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPaymenttermTrl> cPaymenttermTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentPropDetail> finPaymentPropDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MDiscountschemaline> mDiscountschemalineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdImpformat> adImpformatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModuleDbprefixInstall> adModuleDbprefixInstallList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMachineType> maMachineTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdOrgtype> adOrgtypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTabTrl> adTabTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MMatchpo> mMatchpoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RRequestprocessorRoute> rRequestprocessorRouteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<STimeexpense> sTimeexpenseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPromissoryformat> cPromissoryformatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaCcpGroup> maCcpGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaPcTest> maPcTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CUomTrl> cUomTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPayExecProcessPara> finPayExecProcessParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentDetail> finPaymentDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTask> adTaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaWrphaseproduct> maWrphaseproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPeriod> cPeriodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdLanguage> adLanguageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdProcessRequest> adProcessRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdPropertyConfiguration> adPropertyConfigurationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AtTest> atTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MLocatorType> mLocatorTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<GlJournal> glJournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMeasureGroup> maMeasureGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRequisition> mRequisitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdTreenodemm> adTreenodemmList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CDiscount> cDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpSalesforecastline> mrpSalesforecastlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaCostcenterVersion> maCostcenterVersionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRegistrationInfo> adRegistrationInfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<COrgassignment> cOrgassignmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CRegion> cRegionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaIncidence> maIncidenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRappelInvoice> mRappelInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MWhPeriod> mWhPeriodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCashbookAcct> cCashbookAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdAlert> adAlertList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCountry> cCountryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MOfferProdCat> mOfferProdCatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MInoutline> mInoutlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CElementvalueOperand> cElementvalueOperandList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CProject> cProjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MAttributeset> mAttributesetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdMenuTrl> adMenuTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CSalesregion> cSalesregionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCashbook> cCashbookList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdSystem> adSystemList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CGlitem> cGlitemList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<FinPaymentmethod> finPaymentmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBankaccount> cBankaccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdCallout> adCalloutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdModelObjectMapping> adModelObjectMappingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdUserRoles> adUserRolesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MLotctl> mLotctlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CDpManagementline> cDpManagementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CExternalposProduct> cExternalposProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdColumnAccess> adColumnAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdWindow> adWindowList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MWhSchedule> mWhScheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CCash> cCashList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MRappelBpartner> mRappelBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRefSearchColumn> adRefSearchColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MrpPlanner> mrpPlannerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdFieldgroup> adFieldgroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CSalaryCategoryCost> cSalaryCategoryCostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdMessage> adMessageList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CPocDoctypeTemplate> cPocDoctypeTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<RRequestaction> rRequestactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaMaintPeriodicity> maMaintPeriodicityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AAmortizationline> aAmortizationlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdRecordAccess> adRecordAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdField> adFieldList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CAcctschema> cAcctschemaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<AdOrg> adOrgList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<MaPeriodicControl> maPeriodicControlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adClientId")
    private List<CBankaccountAcct> cBankaccountAcctList;

    public AdClient() {
    }

    public AdClient(String adClientId) {
        this.adClientId = adClientId;
    }

    public AdClient(String adClientId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, Character ismultilingualdocument, Character issmtpauthorization) {
        this.adClientId = adClientId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.ismultilingualdocument = ismultilingualdocument;
        this.issmtpauthorization = issmtpauthorization;
    }

    public String getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(String adClientId) {
        this.adClientId = adClientId;
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

    public String getSmtphost() {
        return smtphost;
    }

    public void setSmtphost(String smtphost) {
        this.smtphost = smtphost;
    }

    public String getRequestemail() {
        return requestemail;
    }

    public void setRequestemail(String requestemail) {
        this.requestemail = requestemail;
    }

    public String getRequestuser() {
        return requestuser;
    }

    public void setRequestuser(String requestuser) {
        this.requestuser = requestuser;
    }

    public String getRequestuserpw() {
        return requestuserpw;
    }

    public void setRequestuserpw(String requestuserpw) {
        this.requestuserpw = requestuserpw;
    }

    public String getRequestfolder() {
        return requestfolder;
    }

    public void setRequestfolder(String requestfolder) {
        this.requestfolder = requestfolder;
    }

    public Character getIsmultilingualdocument() {
        return ismultilingualdocument;
    }

    public void setIsmultilingualdocument(Character ismultilingualdocument) {
        this.ismultilingualdocument = ismultilingualdocument;
    }

    public Character getIssmtpauthorization() {
        return issmtpauthorization;
    }

    public void setIssmtpauthorization(Character issmtpauthorization) {
        this.issmtpauthorization = issmtpauthorization;
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
    public List<MInventory> getMInventoryList() {
        return mInventoryList;
    }

    public void setMInventoryList(List<MInventory> mInventoryList) {
        this.mInventoryList = mInventoryList;
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

    public AdClient getAdClient() {
        return adClient;
    }

    public void setAdClient(AdClient adClient) {
        this.adClient = adClient;
    }

    public AdClient getAdClient1() {
        return adClient1;
    }

    public void setAdClient1(AdClient adClient1) {
        this.adClient1 = adClient1;
    }

    public AdLanguage getAdLanguage() {
        return adLanguage;
    }

    public void setAdLanguage(AdLanguage adLanguage) {
        this.adLanguage = adLanguage;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
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

    @XmlTransient
    public List<AdOrginfo> getAdOrginfoList() {
        return adOrginfoList;
    }

    public void setAdOrginfoList(List<AdOrginfo> adOrginfoList) {
        this.adOrginfoList = adOrginfoList;
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

    public AdClientinfo getAdClientinfo() {
        return adClientinfo;
    }

    public void setAdClientinfo(AdClientinfo adClientinfo) {
        this.adClientinfo = adClientinfo;
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

    @XmlTransient
    public List<AdOrg> getAdOrgList() {
        return adOrgList;
    }

    public void setAdOrgList(List<AdOrg> adOrgList) {
        this.adOrgList = adOrgList;
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
        hash += (adClientId != null ? adClientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdClient)) {
            return false;
        }
        AdClient other = (AdClient) object;
        if ((this.adClientId == null && other.adClientId != null) || (this.adClientId != null && !this.adClientId.equals(other.adClientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdClient[ adClientId=" + adClientId + " ]";
    }
    
}
