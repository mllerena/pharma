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
import javax.persistence.Convert;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "c_bpartner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpartner.findAll", query = "SELECT c FROM CBpartner c"),
    @NamedQuery(name = "CBpartner.findByCBpartnerId", query = "SELECT c FROM CBpartner c WHERE c.cBpartnerId = :cBpartnerId"),
    @NamedQuery(name = "CBpartner.findByIsactive", query = "SELECT c FROM CBpartner c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpartner.findByCreated", query = "SELECT c FROM CBpartner c WHERE c.created = :created"),
    @NamedQuery(name = "CBpartner.findByCreatedby", query = "SELECT c FROM CBpartner c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpartner.findByUpdated", query = "SELECT c FROM CBpartner c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpartner.findByUpdatedby", query = "SELECT c FROM CBpartner c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpartner.findByValue", query = "SELECT c FROM CBpartner c WHERE c.value = :value"),
    @NamedQuery(name = "CBpartner.findByName", query = "SELECT c FROM CBpartner c WHERE c.name = :name and c.isactive = :isactive"),
    @NamedQuery(name = "CBpartner.findByName2", query = "SELECT c FROM CBpartner c WHERE c.name2 = :name2"),
    @NamedQuery(name = "CBpartner.findByDescription", query = "SELECT c FROM CBpartner c WHERE c.description = :description"),
    @NamedQuery(name = "CBpartner.findByIssummary", query = "SELECT c FROM CBpartner c WHERE c.issummary = :issummary"),
    @NamedQuery(name = "CBpartner.findByIsonetime", query = "SELECT c FROM CBpartner c WHERE c.isonetime = :isonetime"),
    @NamedQuery(name = "CBpartner.findByIsprospect", query = "SELECT c FROM CBpartner c WHERE c.isprospect = :isprospect"),
    @NamedQuery(name = "CBpartner.findByIsvendor", query = "SELECT c FROM CBpartner c WHERE c.isvendor = :isvendor"),
    @NamedQuery(name = "CBpartner.findByIscustomer", query = "SELECT c FROM CBpartner c WHERE c.iscustomer = :iscustomer"),
    @NamedQuery(name = "CBpartner.findByIsemployee", query = "SELECT c FROM CBpartner c WHERE c.isemployee = :isemployee"),
    @NamedQuery(name = "CBpartner.findByIssalesrep", query = "SELECT c FROM CBpartner c WHERE c.issalesrep = :issalesrep"),
    @NamedQuery(name = "CBpartner.findByReferenceno", query = "SELECT c FROM CBpartner c WHERE c.referenceno = :referenceno"),
    @NamedQuery(name = "CBpartner.findByDuns", query = "SELECT c FROM CBpartner c WHERE c.duns = :duns"),
    @NamedQuery(name = "CBpartner.findByUrl", query = "SELECT c FROM CBpartner c WHERE c.url = :url"),
    @NamedQuery(name = "CBpartner.findByTaxid", query = "SELECT c FROM CBpartner c WHERE c.taxid = :taxid"),
    @NamedQuery(name = "CBpartner.findByIstaxexempt", query = "SELECT c FROM CBpartner c WHERE c.istaxexempt = :istaxexempt"),
    @NamedQuery(name = "CBpartner.findByRating", query = "SELECT c FROM CBpartner c WHERE c.rating = :rating"),
    @NamedQuery(name = "CBpartner.findBySalesvolume", query = "SELECT c FROM CBpartner c WHERE c.salesvolume = :salesvolume"),
    @NamedQuery(name = "CBpartner.findByNumberemployees", query = "SELECT c FROM CBpartner c WHERE c.numberemployees = :numberemployees"),
    @NamedQuery(name = "CBpartner.findByNaics", query = "SELECT c FROM CBpartner c WHERE c.naics = :naics"),
    @NamedQuery(name = "CBpartner.findByFirstsale", query = "SELECT c FROM CBpartner c WHERE c.firstsale = :firstsale"),
    @NamedQuery(name = "CBpartner.findByAcqusitioncost", query = "SELECT c FROM CBpartner c WHERE c.acqusitioncost = :acqusitioncost"),
    @NamedQuery(name = "CBpartner.findByPotentiallifetimevalue", query = "SELECT c FROM CBpartner c WHERE c.potentiallifetimevalue = :potentiallifetimevalue"),
    @NamedQuery(name = "CBpartner.findByActuallifetimevalue", query = "SELECT c FROM CBpartner c WHERE c.actuallifetimevalue = :actuallifetimevalue"),
    @NamedQuery(name = "CBpartner.findByShareofcustomer", query = "SELECT c FROM CBpartner c WHERE c.shareofcustomer = :shareofcustomer"),
    @NamedQuery(name = "CBpartner.findByPaymentrule", query = "SELECT c FROM CBpartner c WHERE c.paymentrule = :paymentrule"),
    @NamedQuery(name = "CBpartner.findBySoCreditlimit", query = "SELECT c FROM CBpartner c WHERE c.soCreditlimit = :soCreditlimit"),
    @NamedQuery(name = "CBpartner.findBySoCreditused", query = "SELECT c FROM CBpartner c WHERE c.soCreditused = :soCreditused"),
    @NamedQuery(name = "CBpartner.findByIsdiscountprinted", query = "SELECT c FROM CBpartner c WHERE c.isdiscountprinted = :isdiscountprinted"),
    @NamedQuery(name = "CBpartner.findBySoDescription", query = "SELECT c FROM CBpartner c WHERE c.soDescription = :soDescription"),
    @NamedQuery(name = "CBpartner.findByPoreference", query = "SELECT c FROM CBpartner c WHERE c.poreference = :poreference"),
    @NamedQuery(name = "CBpartner.findByPaymentrulepo", query = "SELECT c FROM CBpartner c WHERE c.paymentrulepo = :paymentrulepo"),
    @NamedQuery(name = "CBpartner.findByDocumentcopies", query = "SELECT c FROM CBpartner c WHERE c.documentcopies = :documentcopies"),
    @NamedQuery(name = "CBpartner.findByInvoicerule", query = "SELECT c FROM CBpartner c WHERE c.invoicerule = :invoicerule"),
    @NamedQuery(name = "CBpartner.findByDeliveryrule", query = "SELECT c FROM CBpartner c WHERE c.deliveryrule = :deliveryrule"),
    @NamedQuery(name = "CBpartner.findByDeliveryviarule", query = "SELECT c FROM CBpartner c WHERE c.deliveryviarule = :deliveryviarule"),
    @NamedQuery(name = "CBpartner.findBySocreditstatus", query = "SELECT c FROM CBpartner c WHERE c.socreditstatus = :socreditstatus"),
    @NamedQuery(name = "CBpartner.findByShowpriceinorder", query = "SELECT c FROM CBpartner c WHERE c.showpriceinorder = :showpriceinorder"),
    @NamedQuery(name = "CBpartner.findByInvoicegrouping", query = "SELECT c FROM CBpartner c WHERE c.invoicegrouping = :invoicegrouping"),
    @NamedQuery(name = "CBpartner.findByFixmonthday", query = "SELECT c FROM CBpartner c WHERE c.fixmonthday = :fixmonthday"),
    @NamedQuery(name = "CBpartner.findByFixmonthday2", query = "SELECT c FROM CBpartner c WHERE c.fixmonthday2 = :fixmonthday2"),
    @NamedQuery(name = "CBpartner.findByFixmonthday3", query = "SELECT c FROM CBpartner c WHERE c.fixmonthday3 = :fixmonthday3"),
    @NamedQuery(name = "CBpartner.findByIsworker", query = "SELECT c FROM CBpartner c WHERE c.isworker = :isworker"),
    @NamedQuery(name = "CBpartner.findByUpc", query = "SELECT c FROM CBpartner c WHERE c.upc = :upc"),
    @NamedQuery(name = "CBpartner.findByInvoicePrintformat", query = "SELECT c FROM CBpartner c WHERE c.invoicePrintformat = :invoicePrintformat"),
    @NamedQuery(name = "CBpartner.findByLastDays", query = "SELECT c FROM CBpartner c WHERE c.lastDays = :lastDays"),
    @NamedQuery(name = "CBpartner.findByPoFixmonthday", query = "SELECT c FROM CBpartner c WHERE c.poFixmonthday = :poFixmonthday"),
    @NamedQuery(name = "CBpartner.findByPoFixmonthday2", query = "SELECT c FROM CBpartner c WHERE c.poFixmonthday2 = :poFixmonthday2"),
    @NamedQuery(name = "CBpartner.findByPoFixmonthday3", query = "SELECT c FROM CBpartner c WHERE c.poFixmonthday3 = :poFixmonthday3"),
    @NamedQuery(name = "CBpartner.findByFiscalcode", query = "SELECT c FROM CBpartner c WHERE c.fiscalcode = :fiscalcode"),
    @NamedQuery(name = "CBpartner.findByIsofiscalcode", query = "SELECT c FROM CBpartner c WHERE c.isofiscalcode = :isofiscalcode")})
public class CBpartner extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_bpartner_id")
    private String cBpartnerId;
    @Basic(optional = false)
    
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class)
    private YesNo isactive;  
    
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    
    @Basic(optional = false)
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    
    
    @Column(name = "value")
    private String value;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Column(name = "name2")
    private String name2;
    
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    
    @Column(name = "issummary")
    @Convert(converter=YesNoConverter.class)
    private YesNo issummary;
    
    @Basic(optional = false)
    @Column(name = "isonetime")
    @Convert(converter=YesNoConverter.class)
    private YesNo isonetime;
    
    @Basic(optional = false)
    @Column(name = "isprospect")
    @Convert(converter=YesNoConverter.class)
    private YesNo isprospect;
    
    @Basic(optional = false)
    @Column(name = "isvendor")
    @Convert(converter=YesNoConverter.class)
    private YesNo isvendor;
    
    @Basic(optional = false)    
    @Column(name = "iscustomer")
    @Convert(converter=YesNoConverter.class)
    private YesNo iscustomer;
    
    @Basic(optional = false)    
    @Column(name = "isemployee")
    @Convert(converter=YesNoConverter.class)
    private YesNo isemployee;
    
    @Basic(optional = false)    
    @Column(name = "issalesrep")
    @Convert(converter=YesNoConverter.class)
    private YesNo issalesrep;
    
    @Column(name = "referenceno")
    private String referenceno;
    
    @Column(name = "duns")
    private String duns;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "taxid")
    private String taxid;
    @Column(name = "istaxexempt")
    @Convert(converter=YesNoConverter.class)
    private YesNo istaxexempt;
    @Column(name = "rating")
    private Character rating;
    @Column(name = "salesvolume")
    private Long salesvolume;
    @Column(name = "numberemployees")
    private Long numberemployees;
    
    @Column(name = "naics")
    private String naics;
    @Column(name = "firstsale")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstsale;
    @Column(name = "acqusitioncost")
    private BigInteger acqusitioncost;
    @Column(name = "potentiallifetimevalue")
    private BigInteger potentiallifetimevalue;
    @Column(name = "actuallifetimevalue")
    private BigInteger actuallifetimevalue;
    @Column(name = "shareofcustomer")
    private Long shareofcustomer;
    
    @Column(name = "paymentrule")
    private String paymentrule;
    @Column(name = "so_creditlimit")
    private BigInteger soCreditlimit;
    @Column(name = "so_creditused")
    private BigInteger soCreditused;
    @Column(name = "isdiscountprinted")
    @Convert(converter=YesNoConverter.class)
    private YesNo isdiscountprinted;
    
    @Column(name = "so_description")
    private String soDescription;
    
    @Column(name = "poreference")
    private String poreference;
    
    @Column(name = "paymentrulepo")
    private String paymentrulepo;
    @Column(name = "documentcopies")
    private Long documentcopies;
    
    @Column(name = "invoicerule")
    private String invoicerule;
    
    @Column(name = "deliveryrule")
    private String deliveryrule;
    
    @Column(name = "deliveryviarule")
    private String deliveryviarule;
    
    @Column(name = "socreditstatus")
    private String socreditstatus;
    @Basic(optional = false)
    
    @Column(name = "showpriceinorder")
    @Convert(converter=YesNoConverter.class)
    private YesNo showpriceinorder;
    
    @Column(name = "invoicegrouping")
    private String invoicegrouping;
    @Column(name = "fixmonthday")
    private Long fixmonthday;
    @Column(name = "fixmonthday2")
    private Long fixmonthday2;
    @Column(name = "fixmonthday3")
    private Long fixmonthday3;
    @Column(name = "isworker")
    @Convert(converter=YesNoConverter.class)
    private YesNo isworker;
    
    @Column(name = "upc")
    private String upc;
    
    @Column(name = "invoice_printformat")
    private String invoicePrintformat;
    @Column(name = "last_days")
    private Long lastDays;
    @Column(name = "po_fixmonthday")
    private Long poFixmonthday;
    @Column(name = "po_fixmonthday2")
    private Long poFixmonthday2;
    @Column(name = "po_fixmonthday3")
    private Long poFixmonthday3;
    
    @Column(name = "fiscalcode")
    private String fiscalcode;
    
    @Column(name = "isofiscalcode")
    private String isofiscalcode;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CPocEmail> cPocEmailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<IBankstatement> iBankstatementList;
    @JoinColumn(name = "ad_forced_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adForcedOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "po_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentmethod poPaymentmethodId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentmethod finPaymentmethodId;
    @JoinColumn(name = "so_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankaccount soBankaccountId;
    @JoinColumn(name = "po_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankaccount poBankaccountId;
    @JoinColumn(name = "so_c_incoterms_id", referencedColumnName = "c_incoterms_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CIncoterms soCIncotermsId;
    @JoinColumn(name = "po_c_incoterms_id", referencedColumnName = "c_incoterms_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CIncoterms poCIncotermsId;
    @JoinColumn(name = "c_bp_group_id", referencedColumnName = "c_bp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpGroup cBpGroupId;
    @JoinColumn(name = "po_financial_account_id", referencedColumnName = "fin_financial_account_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinFinancialAccount poFinancialAccountId;
    @JoinColumn(name = "po_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPaymentterm poPaymenttermId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;
    @JoinColumn(name = "c_salary_category_id", referencedColumnName = "c_salary_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalaryCategory cSalaryCategoryId;
    @JoinColumn(name = "so_bp_taxcategory_id", referencedColumnName = "c_bp_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpTaxcategory soBpTaxcategoryId;
    @JoinColumn(name = "c_greeting_id", referencedColumnName = "c_greeting_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGreeting cGreetingId;
    @JoinColumn(name = "fin_financial_account_id", referencedColumnName = "fin_financial_account_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinFinancialAccount finFinancialAccountId;
    @JoinColumn(name = "po_bp_taxcategory_id", referencedColumnName = "c_bp_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpTaxcategory poBpTaxcategoryId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "salesrepId")
    private List<CBpartner> cBpartnerList;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner salesrepId;
    @JoinColumn(name = "c_invoiceschedule_id", referencedColumnName = "c_invoiceschedule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoiceschedule cInvoicescheduleId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "bpartnerParentId")
    private List<CBpartner> cBpartnerList1;
    @JoinColumn(name = "bpartner_parent_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner bpartnerParentId;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPaymentterm cPaymenttermId;
    @JoinColumn(name = "po_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist poPricelistId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MrpRunPurchase> mrpRunPurchaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "vendorId")
    private List<MrpRunPurchase> mrpRunPurchaseList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CBpEmployeeAcct> cBpEmployeeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<MProductCustomer> mProductCustomerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CBpartnerLocation> cBpartnerLocationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<FinBankstatementline> finBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MProductTemplate> mProductTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<MaMaintWorker> maMaintWorkerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "dropshipBpartnerId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<COrder> cOrderList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CCommission> cCommissionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<FinFinancialAccount> finFinancialAccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<AdUser> adUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<IProduct> iProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CTaxpayment> cTaxpaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CProjectproposal> cProjectproposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CBpartnerDiscount> cBpartnerDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<IBpartner> iBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CProjectVendor> cProjectVendorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<MProductPo> mProductPoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CBpBankaccount> cBpBankaccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CExternalpos> cExternalposList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MrpRunProduction> mrpRunProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<AdOrginfo> adOrginfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CCommissionline> cCommissionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<MaWeemployee> maWeemployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<MOfferBpartner> mOfferBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CBpSalcategory> cBpSalcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CBank> cBankList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<MWhPeriodInvoiced> mWhPeriodInvoicedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MWarehouseShipper> mWarehouseShipperList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CBpWithholding> cBpWithholdingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "beneficiary")
    private List<CWithholding> cWithholdingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<MrpSalesforecast> mrpSalesforecastList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CBpVendorAcct> cBpVendorAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MShipper> mShipperList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnercashtrxId")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<CBpCustomerAcct> cBpCustomerAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<FinPaymentProposal> finPaymentProposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MDiscountschemaline> mDiscountschemalineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<STimeexpense> sTimeexpenseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MRequisition> mRequisitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<CProject> cProjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "responsibleId")
    private List<CProject> cProjectList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<MRappelBpartner> mRappelBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerId")
    private List<RRequestaction> rRequestactionList;

    public CBpartner() {
    }

    public CBpartner(String cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public String getCBpartnerId() {
        return cBpartnerId; 
    }

    public void setCBpartnerId(String cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public YesNo getIsactive() {
		return isactive;
	}

	public void setIsactive(YesNo isactive) {
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

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public YesNo getIssummary() {
        return issummary;
    }

    public void setIssummary(YesNo issummary) {
        this.issummary = issummary;
    }

    public YesNo getIsonetime() {
        return isonetime;
    }

    public void setIsonetime(YesNo isonetime) {
        this.isonetime = isonetime;
    }

    public YesNo getIsprospect() {
        return isprospect;
    }

    public void setIsprospect(YesNo isprospect) {
        this.isprospect = isprospect;
    }

    public YesNo getIsvendor() {
        return isvendor;
    }

    public void setIsvendor(YesNo isvendor) {
        this.isvendor = isvendor;
    }

    public YesNo getIscustomer() {
        return iscustomer;
    }

    public void setIscustomer(YesNo iscustomer) {
        this.iscustomer = iscustomer;
    }

    public YesNo getIsemployee() {
        return isemployee;
    }

    public void setIsemployee(YesNo isemployee) {
        this.isemployee = isemployee;
    }

    public YesNo getIssalesrep() {
        return issalesrep;
    }

    public void setIssalesrep(YesNo issalesrep) {
        this.issalesrep = issalesrep;
    }

    public String getReferenceno() {
        return referenceno;
    }

    public void setReferenceno(String referenceno) {
        this.referenceno = referenceno;
    }

    public String getDuns() {
        return duns;
    }

    public void setDuns(String duns) {
        this.duns = duns;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    public YesNo getIstaxexempt() {
        return istaxexempt;
    }

    public void setIstaxexempt(YesNo istaxexempt) {
        this.istaxexempt = istaxexempt;
    }

    public Character getRating() {
        return rating;
    }

    public void setRating(Character rating) {
        this.rating = rating;
    }

    public Long getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(Long salesvolume) {
        this.salesvolume = salesvolume;
    }

    public Long getNumberemployees() {
        return numberemployees;
    }

    public void setNumberemployees(Long numberemployees) {
        this.numberemployees = numberemployees;
    }

    public String getNaics() {
        return naics;
    }

    public void setNaics(String naics) {
        this.naics = naics;
    }

    public Date getFirstsale() {
        return firstsale;
    }

    public void setFirstsale(Date firstsale) {
        this.firstsale = firstsale;
    }

    public BigInteger getAcqusitioncost() {
        return acqusitioncost;
    }

    public void setAcqusitioncost(BigInteger acqusitioncost) {
        this.acqusitioncost = acqusitioncost;
    }

    public BigInteger getPotentiallifetimevalue() {
        return potentiallifetimevalue;
    }

    public void setPotentiallifetimevalue(BigInteger potentiallifetimevalue) {
        this.potentiallifetimevalue = potentiallifetimevalue;
    }

    public BigInteger getActuallifetimevalue() {
        return actuallifetimevalue;
    }

    public void setActuallifetimevalue(BigInteger actuallifetimevalue) {
        this.actuallifetimevalue = actuallifetimevalue;
    }

    public Long getShareofcustomer() {
        return shareofcustomer;
    }

    public void setShareofcustomer(Long shareofcustomer) {
        this.shareofcustomer = shareofcustomer;
    }

    public String getPaymentrule() {
        return paymentrule;
    }

    public void setPaymentrule(String paymentrule) {
        this.paymentrule = paymentrule;
    }

    public BigInteger getSoCreditlimit() {
        return soCreditlimit;
    }

    public void setSoCreditlimit(BigInteger soCreditlimit) {
        this.soCreditlimit = soCreditlimit;
    }

    public BigInteger getSoCreditused() {
        return soCreditused;
    }

    public void setSoCreditused(BigInteger soCreditused) {
        this.soCreditused = soCreditused;
    }

    public YesNo getIsdiscountprinted() {
        return isdiscountprinted;
    }

    public void setIsdiscountprinted(YesNo isdiscountprinted) {
        this.isdiscountprinted = isdiscountprinted;
    }

    public String getSoDescription() {
        return soDescription;
    }

    public void setSoDescription(String soDescription) {
        this.soDescription = soDescription;
    }

    public String getPoreference() {
        return poreference;
    }

    public void setPoreference(String poreference) {
        this.poreference = poreference;
    }

    public String getPaymentrulepo() {
        return paymentrulepo;
    }

    public void setPaymentrulepo(String paymentrulepo) {
        this.paymentrulepo = paymentrulepo;
    }

    public Long getDocumentcopies() {
        return documentcopies;
    }

    public void setDocumentcopies(Long documentcopies) {
        this.documentcopies = documentcopies;
    }

    public String getInvoicerule() {
        return invoicerule;
    }

    public void setInvoicerule(String invoicerule) {
        this.invoicerule = invoicerule;
    }

    public String getDeliveryrule() {
        return deliveryrule;
    }

    public void setDeliveryrule(String deliveryrule) {
        this.deliveryrule = deliveryrule;
    }

    public String getDeliveryviarule() {
        return deliveryviarule;
    }

    public void setDeliveryviarule(String deliveryviarule) {
        this.deliveryviarule = deliveryviarule;
    }

    public String getSocreditstatus() {
        return socreditstatus;
    }

    public void setSocreditstatus(String socreditstatus) {
        this.socreditstatus = socreditstatus;
    }

    public YesNo getShowpriceinorder() {
        return showpriceinorder;
    }

    public void setShowpriceinorder(YesNo showpriceinorder) {
        this.showpriceinorder = showpriceinorder;
    }

    public String getInvoicegrouping() {
        return invoicegrouping;
    }

    public void setInvoicegrouping(String invoicegrouping) {
        this.invoicegrouping = invoicegrouping;
    }

    public Long getFixmonthday() {
        return fixmonthday;
    }

    public void setFixmonthday(Long fixmonthday) {
        this.fixmonthday = fixmonthday;
    }

    public Long getFixmonthday2() {
        return fixmonthday2;
    }

    public void setFixmonthday2(Long fixmonthday2) {
        this.fixmonthday2 = fixmonthday2;
    }

    public Long getFixmonthday3() {
        return fixmonthday3;
    }

    public void setFixmonthday3(Long fixmonthday3) {
        this.fixmonthday3 = fixmonthday3;
    }

    public YesNo getIsworker() {
        return isworker;
    }

    public void setIsworker(YesNo isworker) {
        this.isworker = isworker;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getInvoicePrintformat() {
        return invoicePrintformat;
    }

    public void setInvoicePrintformat(String invoicePrintformat) {
        this.invoicePrintformat = invoicePrintformat;
    }

    public Long getLastDays() {
        return lastDays;
    }

    public void setLastDays(Long lastDays) {
        this.lastDays = lastDays;
    }

    public Long getPoFixmonthday() {
        return poFixmonthday;
    }

    public void setPoFixmonthday(Long poFixmonthday) {
        this.poFixmonthday = poFixmonthday;
    }

    public Long getPoFixmonthday2() {
        return poFixmonthday2;
    }

    public void setPoFixmonthday2(Long poFixmonthday2) {
        this.poFixmonthday2 = poFixmonthday2;
    }

    public Long getPoFixmonthday3() {
        return poFixmonthday3;
    }

    public void setPoFixmonthday3(Long poFixmonthday3) {
        this.poFixmonthday3 = poFixmonthday3;
    }

    public String getFiscalcode() {
        return fiscalcode;
    }

    public void setFiscalcode(String fiscalcode) {
        this.fiscalcode = fiscalcode;
    }

    public String getIsofiscalcode() {
        return isofiscalcode;
    }

    public void setIsofiscalcode(String isofiscalcode) {
        this.isofiscalcode = isofiscalcode;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<CPocEmail> getCPocEmailList() {
        return cPocEmailList;
    }

    public void setCPocEmailList(List<CPocEmail> cPocEmailList) {
        this.cPocEmailList = cPocEmailList;
    }

    @XmlTransient
    public List<IBankstatement> getIBankstatementList() {
        return iBankstatementList;
    }

    public void setIBankstatementList(List<IBankstatement> iBankstatementList) {
        this.iBankstatementList = iBankstatementList;
    }

    public AdOrg getAdForcedOrgId() {
        return adForcedOrgId;
    }

    public void setAdForcedOrgId(AdOrg adForcedOrgId) {
        this.adForcedOrgId = adForcedOrgId;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
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

    public FinPaymentmethod getPoPaymentmethodId() {
        return poPaymentmethodId;
    }

    public void setPoPaymentmethodId(FinPaymentmethod poPaymentmethodId) {
        this.poPaymentmethodId = poPaymentmethodId;
    }

    public FinPaymentmethod getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(FinPaymentmethod finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    public CBankaccount getSoBankaccountId() {
        return soBankaccountId;
    }

    public void setSoBankaccountId(CBankaccount soBankaccountId) {
        this.soBankaccountId = soBankaccountId;
    }

    public CBankaccount getPoBankaccountId() {
        return poBankaccountId;
    }

    public void setPoBankaccountId(CBankaccount poBankaccountId) {
        this.poBankaccountId = poBankaccountId;
    }

    public CIncoterms getSoCIncotermsId() {
        return soCIncotermsId;
    }

    public void setSoCIncotermsId(CIncoterms soCIncotermsId) {
        this.soCIncotermsId = soCIncotermsId;
    }

    public CIncoterms getPoCIncotermsId() {
        return poCIncotermsId;
    }

    public void setPoCIncotermsId(CIncoterms poCIncotermsId) {
        this.poCIncotermsId = poCIncotermsId;
    }

    public CBpGroup getCBpGroupId() {
        return cBpGroupId;
    }

    public void setCBpGroupId(CBpGroup cBpGroupId) {
        this.cBpGroupId = cBpGroupId;
    }

    public FinFinancialAccount getPoFinancialAccountId() {
        return poFinancialAccountId;
    }

    public void setPoFinancialAccountId(FinFinancialAccount poFinancialAccountId) {
        this.poFinancialAccountId = poFinancialAccountId;
    }

    public CPaymentterm getPoPaymenttermId() {
        return poPaymenttermId;
    }

    public void setPoPaymenttermId(CPaymentterm poPaymenttermId) {
        this.poPaymenttermId = poPaymenttermId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public CSalaryCategory getCSalaryCategoryId() {
        return cSalaryCategoryId;
    }

    public void setCSalaryCategoryId(CSalaryCategory cSalaryCategoryId) {
        this.cSalaryCategoryId = cSalaryCategoryId;
    }

    public CBpTaxcategory getSoBpTaxcategoryId() {
        return soBpTaxcategoryId;
    }

    public void setSoBpTaxcategoryId(CBpTaxcategory soBpTaxcategoryId) {
        this.soBpTaxcategoryId = soBpTaxcategoryId;
    }

    public CGreeting getCGreetingId() {
        return cGreetingId;
    }

    public void setCGreetingId(CGreeting cGreetingId) {
        this.cGreetingId = cGreetingId;
    }

    public FinFinancialAccount getFinFinancialAccountId() {
        return finFinancialAccountId;
    }

    public void setFinFinancialAccountId(FinFinancialAccount finFinancialAccountId) {
        this.finFinancialAccountId = finFinancialAccountId;
    }

    public CBpTaxcategory getPoBpTaxcategoryId() {
        return poBpTaxcategoryId;
    }

    public void setPoBpTaxcategoryId(CBpTaxcategory poBpTaxcategoryId) {
        this.poBpTaxcategoryId = poBpTaxcategoryId;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    public CBpartner getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(CBpartner salesrepId) {
        this.salesrepId = salesrepId;
    }

    public CInvoiceschedule getCInvoicescheduleId() {
        return cInvoicescheduleId;
    }

    public void setCInvoicescheduleId(CInvoiceschedule cInvoicescheduleId) {
        this.cInvoicescheduleId = cInvoicescheduleId;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList1() {
        return cBpartnerList1;
    }

    public void setCBpartnerList1(List<CBpartner> cBpartnerList1) {
        this.cBpartnerList1 = cBpartnerList1;
    }

    public CBpartner getBpartnerParentId() {
        return bpartnerParentId;
    }

    public void setBpartnerParentId(CBpartner bpartnerParentId) {
        this.bpartnerParentId = bpartnerParentId;
    }

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public MPricelist getPoPricelistId() {
        return poPricelistId;
    }

    public void setPoPricelistId(MPricelist poPricelistId) {
        this.poPricelistId = poPricelistId;
    }

    @XmlTransient
    public List<FinPaymentScheduledetail> getFinPaymentScheduledetailList() {
        return finPaymentScheduledetailList;
    }

    public void setFinPaymentScheduledetailList(List<FinPaymentScheduledetail> finPaymentScheduledetailList) {
        this.finPaymentScheduledetailList = finPaymentScheduledetailList;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<AdTest> getAdTestList() {
        return adTestList;
    }

    public void setAdTestList(List<AdTest> adTestList) {
        this.adTestList = adTestList;
    }

    @XmlTransient
    public List<MrpRunPurchase> getMrpRunPurchaseList() {
        return mrpRunPurchaseList;
    }

    public void setMrpRunPurchaseList(List<MrpRunPurchase> mrpRunPurchaseList) {
        this.mrpRunPurchaseList = mrpRunPurchaseList;
    }

    @XmlTransient
    public List<MrpRunPurchase> getMrpRunPurchaseList1() {
        return mrpRunPurchaseList1;
    }

    public void setMrpRunPurchaseList1(List<MrpRunPurchase> mrpRunPurchaseList1) {
        this.mrpRunPurchaseList1 = mrpRunPurchaseList1;
    }

    @XmlTransient
    public List<CBpEmployeeAcct> getCBpEmployeeAcctList() {
        return cBpEmployeeAcctList;
    }

    public void setCBpEmployeeAcctList(List<CBpEmployeeAcct> cBpEmployeeAcctList) {
        this.cBpEmployeeAcctList = cBpEmployeeAcctList;
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
    public List<MProductCustomer> getMProductCustomerList() {
        return mProductCustomerList;
    }

    public void setMProductCustomerList(List<MProductCustomer> mProductCustomerList) {
        this.mProductCustomerList = mProductCustomerList;
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
    public List<MProductTemplate> getMProductTemplateList() {
        return mProductTemplateList;
    }

    public void setMProductTemplateList(List<MProductTemplate> mProductTemplateList) {
        this.mProductTemplateList = mProductTemplateList;
    }

    @XmlTransient
    public List<MaMaintWorker> getMaMaintWorkerList() {
        return maMaintWorkerList;
    }

    public void setMaMaintWorkerList(List<MaMaintWorker> maMaintWorkerList) {
        this.maMaintWorkerList = maMaintWorkerList;
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
    public List<MrpRunPurchaseline> getMrpRunPurchaselineList() {
        return mrpRunPurchaselineList;
    }

    public void setMrpRunPurchaselineList(List<MrpRunPurchaseline> mrpRunPurchaselineList) {
        this.mrpRunPurchaselineList = mrpRunPurchaselineList;
    }

    @XmlTransient
    public List<FinFinancialAccount> getFinFinancialAccountList() {
        return finFinancialAccountList;
    }

    public void setFinFinancialAccountList(List<FinFinancialAccount> finFinancialAccountList) {
        this.finFinancialAccountList = finFinancialAccountList;
    }

    @XmlTransient
    public List<AdUser> getAdUserList() {
        return adUserList;
    }

    public void setAdUserList(List<AdUser> adUserList) {
        this.adUserList = adUserList;
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
    public List<CProjectproposal> getCProjectproposalList() {
        return cProjectproposalList;
    }

    public void setCProjectproposalList(List<CProjectproposal> cProjectproposalList) {
        this.cProjectproposalList = cProjectproposalList;
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
    public List<CValidcombination> getCValidcombinationList() {
        return cValidcombinationList;
    }

    public void setCValidcombinationList(List<CValidcombination> cValidcombinationList) {
        this.cValidcombinationList = cValidcombinationList;
    }

    @XmlTransient
    public List<CProjectVendor> getCProjectVendorList() {
        return cProjectVendorList;
    }

    public void setCProjectVendorList(List<CProjectVendor> cProjectVendorList) {
        this.cProjectVendorList = cProjectVendorList;
    }

    @XmlTransient
    public List<FinPayment> getFinPaymentList() {
        return finPaymentList;
    }

    public void setFinPaymentList(List<FinPayment> finPaymentList) {
        this.finPaymentList = finPaymentList;
    }

    @XmlTransient
    public List<MProductPo> getMProductPoList() {
        return mProductPoList;
    }

    public void setMProductPoList(List<MProductPo> mProductPoList) {
        this.mProductPoList = mProductPoList;
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
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
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
    public List<MrpRunProduction> getMrpRunProductionList() {
        return mrpRunProductionList;
    }

    public void setMrpRunProductionList(List<MrpRunProduction> mrpRunProductionList) {
        this.mrpRunProductionList = mrpRunProductionList;
    }

    @XmlTransient
    public List<AdOrginfo> getAdOrginfoList() {
        return adOrginfoList;
    }

    public void setAdOrginfoList(List<AdOrginfo> adOrginfoList) {
        this.adOrginfoList = adOrginfoList;
    }

    @XmlTransient
    public List<CCommissionline> getCCommissionlineList() {
        return cCommissionlineList;
    }

    public void setCCommissionlineList(List<CCommissionline> cCommissionlineList) {
        this.cCommissionlineList = cCommissionlineList;
    }

    @XmlTransient
    public List<MaWeemployee> getMaWeemployeeList() {
        return maWeemployeeList;
    }

    public void setMaWeemployeeList(List<MaWeemployee> maWeemployeeList) {
        this.maWeemployeeList = maWeemployeeList;
    }

    @XmlTransient
    public List<MOfferBpartner> getMOfferBpartnerList() {
        return mOfferBpartnerList;
    }

    public void setMOfferBpartnerList(List<MOfferBpartner> mOfferBpartnerList) {
        this.mOfferBpartnerList = mOfferBpartnerList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<CBpSalcategory> getCBpSalcategoryList() {
        return cBpSalcategoryList;
    }

    public void setCBpSalcategoryList(List<CBpSalcategory> cBpSalcategoryList) {
        this.cBpSalcategoryList = cBpSalcategoryList;
    }

    @XmlTransient
    public List<CBank> getCBankList() {
        return cBankList;
    }

    public void setCBankList(List<CBank> cBankList) {
        this.cBankList = cBankList;
    }

    @XmlTransient
    public List<MWhPeriodInvoiced> getMWhPeriodInvoicedList() {
        return mWhPeriodInvoicedList;
    }

    public void setMWhPeriodInvoicedList(List<MWhPeriodInvoiced> mWhPeriodInvoicedList) {
        this.mWhPeriodInvoicedList = mWhPeriodInvoicedList;
    }

    @XmlTransient
    public List<MWarehouseShipper> getMWarehouseShipperList() {
        return mWarehouseShipperList;
    }

    public void setMWarehouseShipperList(List<MWarehouseShipper> mWarehouseShipperList) {
        this.mWarehouseShipperList = mWarehouseShipperList;
    }

    @XmlTransient
    public List<CBpWithholding> getCBpWithholdingList() {
        return cBpWithholdingList;
    }

    public void setCBpWithholdingList(List<CBpWithholding> cBpWithholdingList) {
        this.cBpWithholdingList = cBpWithholdingList;
    }

    @XmlTransient
    public List<CWithholding> getCWithholdingList() {
        return cWithholdingList;
    }

    public void setCWithholdingList(List<CWithholding> cWithholdingList) {
        this.cWithholdingList = cWithholdingList;
    }

    @XmlTransient
    public List<MrpSalesforecast> getMrpSalesforecastList() {
        return mrpSalesforecastList;
    }

    public void setMrpSalesforecastList(List<MrpSalesforecast> mrpSalesforecastList) {
        this.mrpSalesforecastList = mrpSalesforecastList;
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
    public List<CBpVendorAcct> getCBpVendorAcctList() {
        return cBpVendorAcctList;
    }

    public void setCBpVendorAcctList(List<CBpVendorAcct> cBpVendorAcctList) {
        this.cBpVendorAcctList = cBpVendorAcctList;
    }

    @XmlTransient
    public List<MShipper> getMShipperList() {
        return mShipperList;
    }

    public void setMShipperList(List<MShipper> mShipperList) {
        this.mShipperList = mShipperList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList() {
        return adClientinfoList;
    }

    public void setAdClientinfoList(List<AdClientinfo> adClientinfoList) {
        this.adClientinfoList = adClientinfoList;
    }

    @XmlTransient
    public List<CBpCustomerAcct> getCBpCustomerAcctList() {
        return cBpCustomerAcctList;
    }

    public void setCBpCustomerAcctList(List<CBpCustomerAcct> cBpCustomerAcctList) {
        this.cBpCustomerAcctList = cBpCustomerAcctList;
    }

    @XmlTransient
    public List<FinPaymentProposal> getFinPaymentProposalList() {
        return finPaymentProposalList;
    }

    public void setFinPaymentProposalList(List<FinPaymentProposal> finPaymentProposalList) {
        this.finPaymentProposalList = finPaymentProposalList;
    }

    @XmlTransient
    public List<MDiscountschemaline> getMDiscountschemalineList() {
        return mDiscountschemalineList;
    }

    public void setMDiscountschemalineList(List<MDiscountschemaline> mDiscountschemalineList) {
        this.mDiscountschemalineList = mDiscountschemalineList;
    }

    @XmlTransient
    public List<STimeexpense> getSTimeexpenseList() {
        return sTimeexpenseList;
    }

    public void setSTimeexpenseList(List<STimeexpense> sTimeexpenseList) {
        this.sTimeexpenseList = sTimeexpenseList;
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
    public List<MRequisition> getMRequisitionList() {
        return mRequisitionList;
    }

    public void setMRequisitionList(List<MRequisition> mRequisitionList) {
        this.mRequisitionList = mRequisitionList;
    }

    @XmlTransient
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
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
    public List<CProject> getCProjectList1() {
        return cProjectList1;
    }

    public void setCProjectList1(List<CProject> cProjectList1) {
        this.cProjectList1 = cProjectList1;
    }

    @XmlTransient
    public List<MRappelBpartner> getMRappelBpartnerList() {
        return mRappelBpartnerList;
    }

    public void setMRappelBpartnerList(List<MRappelBpartner> mRappelBpartnerList) {
        this.mRappelBpartnerList = mRappelBpartnerList;
    }

    @XmlTransient
    public List<RRequestaction> getRRequestactionList() {
        return rRequestactionList;
    }

    public void setRRequestactionList(List<RRequestaction> rRequestactionList) {
        this.rRequestactionList = rRequestactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpartnerId != null ? cBpartnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpartner)) {
            return false;
        }
        CBpartner other = (CBpartner) object;
        if ((this.cBpartnerId == null && other.cBpartnerId != null) || (this.cBpartnerId != null && !this.cBpartnerId.equals(other.cBpartnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpartner[ cBpartnerId=" + cBpartnerId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return cBpartnerId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		cBpartnerId = id;
	}
    
}
