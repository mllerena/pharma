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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProduct.findAll", query = "SELECT m FROM MProduct m"),
    @NamedQuery(name = "MProduct.findByMProductId", query = "SELECT m FROM MProduct m WHERE m.mProductId = :mProductId"),
    @NamedQuery(name = "MProduct.findByIsactive", query = "SELECT m FROM MProduct m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProduct.findByCreated", query = "SELECT m FROM MProduct m WHERE m.created = :created"),
    @NamedQuery(name = "MProduct.findByCreatedby", query = "SELECT m FROM MProduct m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProduct.findByUpdated", query = "SELECT m FROM MProduct m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProduct.findByUpdatedby", query = "SELECT m FROM MProduct m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProduct.findByValue", query = "SELECT m FROM MProduct m WHERE m.value = :value"),
    @NamedQuery(name = "MProduct.findByName", query = "SELECT m FROM MProduct m WHERE m.name = :name"),
    @NamedQuery(name = "MProduct.findByDescription", query = "SELECT m FROM MProduct m WHERE m.description = :description"),
    @NamedQuery(name = "MProduct.findByDocumentnote", query = "SELECT m FROM MProduct m WHERE m.documentnote = :documentnote"),
    @NamedQuery(name = "MProduct.findByHelp", query = "SELECT m FROM MProduct m WHERE m.help = :help"),
    @NamedQuery(name = "MProduct.findByUpc", query = "SELECT m FROM MProduct m WHERE m.upc = :upc"),
    @NamedQuery(name = "MProduct.findBySku", query = "SELECT m FROM MProduct m WHERE m.sku = :sku"),
    @NamedQuery(name = "MProduct.findByIssummary", query = "SELECT m FROM MProduct m WHERE m.issummary = :issummary"),
    @NamedQuery(name = "MProduct.findByIsstocked", query = "SELECT m FROM MProduct m WHERE m.isstocked = :isstocked"),
    @NamedQuery(name = "MProduct.findByIspurchased", query = "SELECT m FROM MProduct m WHERE m.ispurchased = :ispurchased"),
    @NamedQuery(name = "MProduct.findByIssold", query = "SELECT m FROM MProduct m WHERE m.issold = :issold"),
    @NamedQuery(name = "MProduct.findByIsbom", query = "SELECT m FROM MProduct m WHERE m.isbom = :isbom"),
    @NamedQuery(name = "MProduct.findByIsinvoiceprintdetails", query = "SELECT m FROM MProduct m WHERE m.isinvoiceprintdetails = :isinvoiceprintdetails"),
    @NamedQuery(name = "MProduct.findByIspicklistprintdetails", query = "SELECT m FROM MProduct m WHERE m.ispicklistprintdetails = :ispicklistprintdetails"),
    @NamedQuery(name = "MProduct.findByIsverified", query = "SELECT m FROM MProduct m WHERE m.isverified = :isverified"),
    @NamedQuery(name = "MProduct.findByClassification", query = "SELECT m FROM MProduct m WHERE m.classification = :classification"),
    @NamedQuery(name = "MProduct.findByVolume", query = "SELECT m FROM MProduct m WHERE m.volume = :volume"),
    @NamedQuery(name = "MProduct.findByWeight", query = "SELECT m FROM MProduct m WHERE m.weight = :weight"),
    @NamedQuery(name = "MProduct.findByShelfwidth", query = "SELECT m FROM MProduct m WHERE m.shelfwidth = :shelfwidth"),
    @NamedQuery(name = "MProduct.findByShelfheight", query = "SELECT m FROM MProduct m WHERE m.shelfheight = :shelfheight"),
    @NamedQuery(name = "MProduct.findByShelfdepth", query = "SELECT m FROM MProduct m WHERE m.shelfdepth = :shelfdepth"),
    @NamedQuery(name = "MProduct.findByUnitsperpallet", query = "SELECT m FROM MProduct m WHERE m.unitsperpallet = :unitsperpallet"),
    @NamedQuery(name = "MProduct.findByDiscontinued", query = "SELECT m FROM MProduct m WHERE m.discontinued = :discontinued"),
    @NamedQuery(name = "MProduct.findByDiscontinuedby", query = "SELECT m FROM MProduct m WHERE m.discontinuedby = :discontinuedby"),
    @NamedQuery(name = "MProduct.findByProcessing", query = "SELECT m FROM MProduct m WHERE m.processing = :processing"),
    @NamedQuery(name = "MProduct.findByProducttype", query = "SELECT m FROM MProduct m WHERE m.producttype = :producttype"),
    @NamedQuery(name = "MProduct.findByImageurl", query = "SELECT m FROM MProduct m WHERE m.imageurl = :imageurl"),
    @NamedQuery(name = "MProduct.findByDescriptionurl", query = "SELECT m FROM MProduct m WHERE m.descriptionurl = :descriptionurl"),
    @NamedQuery(name = "MProduct.findByGuaranteedays", query = "SELECT m FROM MProduct m WHERE m.guaranteedays = :guaranteedays"),
    @NamedQuery(name = "MProduct.findByVersionno", query = "SELECT m FROM MProduct m WHERE m.versionno = :versionno"),
    @NamedQuery(name = "MProduct.findByDownloadurl", query = "SELECT m FROM MProduct m WHERE m.downloadurl = :downloadurl"),
    @NamedQuery(name = "MProduct.findByIspriceprinted", query = "SELECT m FROM MProduct m WHERE m.ispriceprinted = :ispriceprinted"),
    @NamedQuery(name = "MProduct.findByName2", query = "SELECT m FROM MProduct m WHERE m.name2 = :name2"),
    @NamedQuery(name = "MProduct.findByCosttype", query = "SELECT m FROM MProduct m WHERE m.costtype = :costtype"),
    @NamedQuery(name = "MProduct.findByCoststd", query = "SELECT m FROM MProduct m WHERE m.coststd = :coststd"),
    @NamedQuery(name = "MProduct.findByStockMin", query = "SELECT m FROM MProduct m WHERE m.stockMin = :stockMin"),
    @NamedQuery(name = "MProduct.findByEnforceAttribute", query = "SELECT m FROM MProduct m WHERE m.enforceAttribute = :enforceAttribute"),
    @NamedQuery(name = "MProduct.findByCalculated", query = "SELECT m FROM MProduct m WHERE m.calculated = :calculated"),
    @NamedQuery(name = "MProduct.findByProduction", query = "SELECT m FROM MProduct m WHERE m.production = :production"),
    @NamedQuery(name = "MProduct.findByCapacity", query = "SELECT m FROM MProduct m WHERE m.capacity = :capacity"),
    @NamedQuery(name = "MProduct.findByDelaymin", query = "SELECT m FROM MProduct m WHERE m.delaymin = :delaymin"),
    @NamedQuery(name = "MProduct.findByQtymax", query = "SELECT m FROM MProduct m WHERE m.qtymax = :qtymax"),
    @NamedQuery(name = "MProduct.findByQtymin", query = "SELECT m FROM MProduct m WHERE m.qtymin = :qtymin"),
    @NamedQuery(name = "MProduct.findByQtystd", query = "SELECT m FROM MProduct m WHERE m.qtystd = :qtystd"),
    @NamedQuery(name = "MProduct.findByQtytype", query = "SELECT m FROM MProduct m WHERE m.qtytype = :qtytype"),
    @NamedQuery(name = "MProduct.findByStockmin", query = "SELECT m FROM MProduct m WHERE m.stockmin = :stockmin"),
    @NamedQuery(name = "MProduct.findByAttrsetvaluetype", query = "SELECT m FROM MProduct m WHERE m.attrsetvaluetype = :attrsetvaluetype"),
    @NamedQuery(name = "MProduct.findByMLocatorId", query = "SELECT m FROM MProduct m WHERE m.mLocatorId in (:mLocatorId) and m.isactive = :isactive")
})
public class MProduct extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "m_product_id")
    private String mProductId;
    
    
    @Column(name = "m_classification_id")
    private String mClassificationId;
    
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
    
    @Column(name = "description")
    private String description;
    
    @Size(max = 2000)
    @Column(name = "documentnote")
    private String documentnote;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Size(max = 30)
    @Column(name = "upc")
    private String upc;
    @Size(max = 30)
    @Column(name = "sku")
    private String sku;
    
    @Basic(optional = false)
    @Column(name = "issummary")
    @Convert(converter=YesNoConverter.class) 
    private YesNo issummary;
    
    @Basic(optional = false)
    @Column(name = "isstocked")
    @Convert(converter=YesNoConverter.class)
    private YesNo isstocked;
    
    @Basic(optional = false)
    @Column(name = "ispurchased")
    @Convert(converter=YesNoConverter.class)
    private YesNo ispurchased;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "issold")
    @Convert(converter=YesNoConverter.class)
    private YesNo issold;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbom")
    @Convert(converter=YesNoConverter.class)
    private YesNo isbom;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "isinvoiceprintdetails")
    @Convert(converter=YesNoConverter.class)
    private YesNo isinvoiceprintdetails;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispicklistprintdetails")
    @Convert(converter=YesNoConverter.class)
    private YesNo ispicklistprintdetails;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "isverified")
    @Convert(converter=YesNoConverter.class)
    private YesNo isverified;
    
    @Column(name = "classification")
    private Character classification;
    
    @Column(name = "volume")
    private BigInteger volume;
    @Column(name = "weight")
    private BigInteger weight;
    @Column(name = "shelfwidth")
    private Long shelfwidth;
    @Column(name = "shelfheight")
    private Long shelfheight;
    @Column(name = "shelfdepth")
    private Long shelfdepth;
    @Column(name = "unitsperpallet")
    private Long unitsperpallet;
    
    @Column(name = "discontinued")
    @Convert(converter=YesNoConverter.class)
    private YesNo discontinued;
    
    @Column(name = "discontinuedby")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discontinuedby;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "processing")
    @Convert(converter=YesNoConverter.class)
    private YesNo processing;
    
    @Basic(optional = false)
    @Column(name = "producttype")
    private String producttype;
    
    @Size(max = 120)
    @Column(name = "imageurl")
    private String imageurl;
    
    @Size(max = 120)
    @Column(name = "descriptionurl")
    private String descriptionurl;
    @Column(name = "guaranteedays")
    private Long guaranteedays;
    @Size(max = 20)
    @Column(name = "versionno")
    private String versionno;
    @Size(max = 120)
    @Column(name = "downloadurl")
    private String downloadurl;
    
    @Column(name = "ispriceprinted")
    @Convert(converter=YesNoConverter.class)
    private YesNo ispriceprinted;
    
    @Size(max = 60)
    @Column(name = "name2")
    private String name2;
    
    @Size(max = 60)
    @Column(name = "costtype")
    private String costtype;
    
    @Column(name = "coststd")
    private BigInteger coststd;
    @Column(name = "stock_min")
    private Long stockMin;
    @Column(name = "enforce_attribute")
    private Character enforceAttribute;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "calculated")
    @Convert(converter=YesNoConverter.class)
    private YesNo calculated;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "production")
    @Convert(converter=YesNoConverter.class)
    private YesNo production;
    
    @Column(name = "capacity")
    private BigInteger capacity;
    @Column(name = "delaymin")
    private BigInteger delaymin;
    @Column(name = "qtymax")
    private BigInteger qtymax;
    @Column(name = "qtymin")
    private BigInteger qtymin;
    @Column(name = "qtystd")
    private BigInteger qtystd;
    @Column(name = "qtytype")
    private Character qtytype;
    @Column(name = "stockmin")
    private BigInteger stockmin;
    @Size(max = 60)
    @Column(name = "attrsetvaluetype")
    private String attrsetvaluetype;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CProjectphase> cProjectphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<CProjectissue> cProjectissueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductionline> mProductionlineList;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_image_id", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage adImageId;
    @JoinColumn(name = "mrp_planningmethod_id", referencedColumnName = "mrp_planningmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpPlanningmethod mrpPlanningmethodId;
    @JoinColumn(name = "s_resource_id", referencedColumnName = "s_resource_id")
    @OneToOne
    private SResource sResourceId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser salesrepId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_taxcategory_id", referencedColumnName = "c_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTaxcategory cTaxcategoryId;
    @JoinColumn(name = "s_expensetype_id", referencedColumnName = "s_expensetype_id")
    @OneToOne
    private SExpensetype sExpensetypeId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @JoinColumn(name = "ma_processplan_id", referencedColumnName = "ma_processplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaProcessplan maProcessplanId;
    @JoinColumn(name = "m_attributeset_id", referencedColumnName = "m_attributeset_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributeset mAttributesetId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_freightcategory_id", referencedColumnName = "m_freightcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MFreightcategory mFreightcategoryId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductCategory mProductCategoryId;
    @JoinColumn(name = "mrp_planner_id", referencedColumnName = "mrp_planner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpPlanner mrpPlannerId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLocator mLocatorId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MrpRunPurchase> mrpRunPurchaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductCustomer> mProductCustomerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MRappelProduct> mRappelProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MProductTemplate> mProductTemplateList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "substituteId")
    private List<MSubstitute> mSubstituteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MSubstitute> mSubstituteList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MWhScheduleProduct> mWhScheduleProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CCommission> cCommissionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductOrg> mProductOrgList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<IProduct> iProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CTask> cTaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductAcct> mProductAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MCosting> mCostingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<IInventory> iInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductPo> mProductPoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MInternalConsumptionline> mInternalConsumptionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MaGlobaluse> maGlobaluseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MOfferProduct> mOfferProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<CServicelevel> cServicelevelList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MMatchinv> mMatchinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CProjecttask> cProjecttaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MrpRunProduction> mrpRunProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MInventoryline> mInventorylineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CCommissionline> cCommissionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MaSequenceproduct> maSequenceproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductbomId")
    private List<MProductBom> mProductBomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductBom> mProductBomList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MLot> mLotList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MTransaction> mTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductTrl> mProductTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MReplenish> mReplenishList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MaPcCase> maPcCaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MStoragePending> mStoragePendingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MStorageDetail> mStorageDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MMovementline> mMovementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MProductionplan> mProductionplanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MrpRunProductionline> mrpRunProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CPhase> cPhaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductUom> mProductUomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<CProjectproposalline> cProjectproposallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CProjectline> cProjectlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductfreightId")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MProductprice> mProductpriceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MDiscountschemaline> mDiscountschemalineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MMatchpo> mMatchpoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MaWrphaseproduct> maWrphaseproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<CDiscount> cDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductId")
    private List<MrpSalesforecastline> mrpSalesforecastlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<MInoutline> mInoutlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<CExternalposProduct> cExternalposProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductId")
    private List<RRequestaction> rRequestactionList;

    public MProduct() {
    }

    public MProduct(String mProductId) {
        this.mProductId = mProductId;
    }

    public String getMProductId() {
        return mProductId;
    }

    public void setMProductId(String mProductId) {
        this.mProductId = mProductId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentnote() {
        return documentnote;
    }

    public void setDocumentnote(String documentnote) {
        this.documentnote = documentnote;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public YesNo getIssummary() {
        return issummary;
    }

    public void setIssummary(YesNo issummary) {
        this.issummary = issummary;
    }

    public YesNo getIsstocked() {
        return isstocked;
    }

    public void setIsstocked(YesNo isstocked) {
        this.isstocked = isstocked;
    }

    public YesNo getIspurchased() {
        return ispurchased;
    }

    public void setIspurchased(YesNo ispurchased) {
        this.ispurchased = ispurchased;
    }

    public YesNo getIssold() {
        return issold;
    }

    public void setIssold(YesNo issold) {
        this.issold = issold;
    }

    public YesNo getIsbom() {
        return isbom;
    }

    public void setIsbom(YesNo isbom) {
        this.isbom = isbom;
    }

    public YesNo getIsinvoiceprintdetails() {
        return isinvoiceprintdetails;
    }

    public void setIsinvoiceprintdetails(YesNo isinvoiceprintdetails) {
        this.isinvoiceprintdetails = isinvoiceprintdetails;
    }

    public YesNo getIspicklistprintdetails() {
        return ispicklistprintdetails;
    }

    public void setIspicklistprintdetails(YesNo ispicklistprintdetails) {
        this.ispicklistprintdetails = ispicklistprintdetails;
    }

    public YesNo getIsverified() {
        return isverified;
    }

    public void setIsverified(YesNo isverified) {
        this.isverified = isverified;
    }

    public Character getClassification() {
        return classification;
    }

    public void setClassification(Character classification) {
        this.classification = classification;
    }

    public BigInteger getVolume() {
        return volume;
    }

    public void setVolume(BigInteger volume) {
        this.volume = volume;
    }

    public BigInteger getWeight() {
        return weight;
    }

    public void setWeight(BigInteger weight) {
        this.weight = weight;
    }

    public Long getShelfwidth() {
        return shelfwidth;
    }

    public void setShelfwidth(Long shelfwidth) {
        this.shelfwidth = shelfwidth;
    }

    public Long getShelfheight() {
        return shelfheight;
    }

    public void setShelfheight(Long shelfheight) {
        this.shelfheight = shelfheight;
    }

    public Long getShelfdepth() {
        return shelfdepth;
    }

    public void setShelfdepth(Long shelfdepth) {
        this.shelfdepth = shelfdepth;
    }

    public Long getUnitsperpallet() {
        return unitsperpallet;
    }

    public void setUnitsperpallet(Long unitsperpallet) {
        this.unitsperpallet = unitsperpallet;
    }

    public YesNo getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(YesNo discontinued) {
        this.discontinued = discontinued;
    }

    public Date getDiscontinuedby() {
        return discontinuedby;
    }

    public void setDiscontinuedby(Date discontinuedby) {
        this.discontinuedby = discontinuedby;
    }

    public YesNo getProcessing() {
        return processing;
    }

    public void setProcessing(YesNo processing) {
        this.processing = processing;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescriptionurl() {
        return descriptionurl;
    }

    public void setDescriptionurl(String descriptionurl) {
        this.descriptionurl = descriptionurl;
    }

    public Long getGuaranteedays() {
        return guaranteedays;
    }

    public void setGuaranteedays(Long guaranteedays) {
        this.guaranteedays = guaranteedays;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public YesNo getIspriceprinted() {
        return ispriceprinted;
    }

    public void setIspriceprinted(YesNo ispriceprinted) {
        this.ispriceprinted = ispriceprinted;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getCosttype() {
        return costtype;
    }

    public void setCosttype(String costtype) {
        this.costtype = costtype;
    }

    public BigInteger getCoststd() {
        return coststd;
    }

    public void setCoststd(BigInteger coststd) {
        this.coststd = coststd;
    }

    public Long getStockMin() {
        return stockMin;
    }

    public void setStockMin(Long stockMin) {
        this.stockMin = stockMin;
    }

    public Character getEnforceAttribute() {
        return enforceAttribute;
    }

    public void setEnforceAttribute(Character enforceAttribute) {
        this.enforceAttribute = enforceAttribute;
    }

    public YesNo getCalculated() {
        return calculated;
    }

    public void setCalculated(YesNo calculated) {
        this.calculated = calculated;
    }

    public YesNo getProduction() {
        return production;
    }

    public void setProduction(YesNo production) {
        this.production = production;
    }

    public BigInteger getCapacity() {
        return capacity;
    }

    public void setCapacity(BigInteger capacity) {
        this.capacity = capacity;
    }

    public BigInteger getDelaymin() {
        return delaymin;
    }

    public void setDelaymin(BigInteger delaymin) {
        this.delaymin = delaymin;
    }

    public BigInteger getQtymax() {
        return qtymax;
    }

    public void setQtymax(BigInteger qtymax) {
        this.qtymax = qtymax;
    }

    public BigInteger getQtymin() {
        return qtymin;
    }

    public void setQtymin(BigInteger qtymin) {
        this.qtymin = qtymin;
    }

    public BigInteger getQtystd() {
        return qtystd;
    }

    public void setQtystd(BigInteger qtystd) {
        this.qtystd = qtystd;
    }

    public Character getQtytype() {
        return qtytype;
    }

    public void setQtytype(Character qtytype) {
        this.qtytype = qtytype;
    }

    public BigInteger getStockmin() {
        return stockmin;
    }

    public void setStockmin(BigInteger stockmin) {
        this.stockmin = stockmin;
    }

    public String getAttrsetvaluetype() {
        return attrsetvaluetype;
    }

    public void setAttrsetvaluetype(String attrsetvaluetype) {
        this.attrsetvaluetype = attrsetvaluetype;
    }

    @XmlTransient
    public List<CProjectphase> getCProjectphaseList() {
        return cProjectphaseList;
    }

    public void setCProjectphaseList(List<CProjectphase> cProjectphaseList) {
        this.cProjectphaseList = cProjectphaseList;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
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

    public AdImage getAdImageId() {
        return adImageId;
    }

    public void setAdImageId(AdImage adImageId) {
        this.adImageId = adImageId;
    }

    public MrpPlanningmethod getMrpPlanningmethodId() {
        return mrpPlanningmethodId;
    }

    public void setMrpPlanningmethodId(MrpPlanningmethod mrpPlanningmethodId) {
        this.mrpPlanningmethodId = mrpPlanningmethodId;
    }

    public SResource getSResourceId() {
        return sResourceId;
    }

    public void setSResourceId(SResource sResourceId) {
        this.sResourceId = sResourceId;
    }

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CTaxcategory getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(CTaxcategory cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    public SExpensetype getSExpensetypeId() {
        return sExpensetypeId;
    }

    public void setSExpensetypeId(SExpensetype sExpensetypeId) {
        this.sExpensetypeId = sExpensetypeId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public MaProcessplan getMaProcessplanId() {
        return maProcessplanId;
    }

    public void setMaProcessplanId(MaProcessplan maProcessplanId) {
        this.maProcessplanId = maProcessplanId;
    }

    public MAttributeset getMAttributesetId() {
        return mAttributesetId;
    }

    public void setMAttributesetId(MAttributeset mAttributesetId) {
        this.mAttributesetId = mAttributesetId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MFreightcategory getMFreightcategoryId() {
        return mFreightcategoryId;
    }

    public void setMFreightcategoryId(MFreightcategory mFreightcategoryId) {
        this.mFreightcategoryId = mFreightcategoryId;
    }

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    public MrpPlanner getMrpPlannerId() {
        return mrpPlannerId;
    }

    public void setMrpPlannerId(MrpPlanner mrpPlannerId) {
        this.mrpPlannerId = mrpPlannerId;
    }

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
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
    public List<MRappelProduct> getMRappelProductList() {
        return mRappelProductList;
    }

    public void setMRappelProductList(List<MRappelProduct> mRappelProductList) {
        this.mRappelProductList = mRappelProductList;
    }

    @XmlTransient
    public List<MProductTemplate> getMProductTemplateList() {
        return mProductTemplateList;
    }

    public void setMProductTemplateList(List<MProductTemplate> mProductTemplateList) {
        this.mProductTemplateList = mProductTemplateList;
    }

    @XmlTransient
    public List<MSubstitute> getMSubstituteList() {
        return mSubstituteList;
    }

    public void setMSubstituteList(List<MSubstitute> mSubstituteList) {
        this.mSubstituteList = mSubstituteList;
    }

    @XmlTransient
    public List<MSubstitute> getMSubstituteList1() {
        return mSubstituteList1;
    }

    public void setMSubstituteList1(List<MSubstitute> mSubstituteList1) {
        this.mSubstituteList1 = mSubstituteList1;
    }

    @XmlTransient
    public List<MWhScheduleProduct> getMWhScheduleProductList() {
        return mWhScheduleProductList;
    }

    public void setMWhScheduleProductList(List<MWhScheduleProduct> mWhScheduleProductList) {
        this.mWhScheduleProductList = mWhScheduleProductList;
    }

    @XmlTransient
    public List<CCommission> getCCommissionList() {
        return cCommissionList;
    }

    public void setCCommissionList(List<CCommission> cCommissionList) {
        this.cCommissionList = cCommissionList;
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
    public List<IProduct> getIProductList() {
        return iProductList;
    }

    public void setIProductList(List<IProduct> iProductList) {
        this.iProductList = iProductList;
    }

    @XmlTransient
    public List<CValidcombination> getCValidcombinationList() {
        return cValidcombinationList;
    }

    public void setCValidcombinationList(List<CValidcombination> cValidcombinationList) {
        this.cValidcombinationList = cValidcombinationList;
    }

    @XmlTransient
    public List<CTask> getCTaskList() {
        return cTaskList;
    }

    public void setCTaskList(List<CTask> cTaskList) {
        this.cTaskList = cTaskList;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList() {
        return mProductAcctList;
    }

    public void setMProductAcctList(List<MProductAcct> mProductAcctList) {
        this.mProductAcctList = mProductAcctList;
    }

    @XmlTransient
    public List<MCosting> getMCostingList() {
        return mCostingList;
    }

    public void setMCostingList(List<MCosting> mCostingList) {
        this.mCostingList = mCostingList;
    }

    @XmlTransient
    public List<IInventory> getIInventoryList() {
        return iInventoryList;
    }

    public void setIInventoryList(List<IInventory> iInventoryList) {
        this.iInventoryList = iInventoryList;
    }

    @XmlTransient
    public List<MProductPo> getMProductPoList() {
        return mProductPoList;
    }

    public void setMProductPoList(List<MProductPo> mProductPoList) {
        this.mProductPoList = mProductPoList;
    }

    @XmlTransient
    public List<MInternalConsumptionline> getMInternalConsumptionlineList() {
        return mInternalConsumptionlineList;
    }

    public void setMInternalConsumptionlineList(List<MInternalConsumptionline> mInternalConsumptionlineList) {
        this.mInternalConsumptionlineList = mInternalConsumptionlineList;
    }

    @XmlTransient
    public List<MaGlobaluse> getMaGlobaluseList() {
        return maGlobaluseList;
    }

    public void setMaGlobaluseList(List<MaGlobaluse> maGlobaluseList) {
        this.maGlobaluseList = maGlobaluseList;
    }

    @XmlTransient
    public List<MOfferProduct> getMOfferProductList() {
        return mOfferProductList;
    }

    public void setMOfferProductList(List<MOfferProduct> mOfferProductList) {
        this.mOfferProductList = mOfferProductList;
    }

    @XmlTransient
    public List<CServicelevel> getCServicelevelList() {
        return cServicelevelList;
    }

    public void setCServicelevelList(List<CServicelevel> cServicelevelList) {
        this.cServicelevelList = cServicelevelList;
    }

    @XmlTransient
    public List<MMatchinv> getMMatchinvList() {
        return mMatchinvList;
    }

    public void setMMatchinvList(List<MMatchinv> mMatchinvList) {
        this.mMatchinvList = mMatchinvList;
    }

    @XmlTransient
    public List<CProjecttask> getCProjecttaskList() {
        return cProjecttaskList;
    }

    public void setCProjecttaskList(List<CProjecttask> cProjecttaskList) {
        this.cProjecttaskList = cProjecttaskList;
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
    public List<MrpRunProduction> getMrpRunProductionList() {
        return mrpRunProductionList;
    }

    public void setMrpRunProductionList(List<MrpRunProduction> mrpRunProductionList) {
        this.mrpRunProductionList = mrpRunProductionList;
    }

    @XmlTransient
    public List<MInventoryline> getMInventorylineList() {
        return mInventorylineList;
    }

    public void setMInventorylineList(List<MInventoryline> mInventorylineList) {
        this.mInventorylineList = mInventorylineList;
    }

    @XmlTransient
    public List<CCommissionline> getCCommissionlineList() {
        return cCommissionlineList;
    }

    public void setCCommissionlineList(List<CCommissionline> cCommissionlineList) {
        this.cCommissionlineList = cCommissionlineList;
    }

    @XmlTransient
    public List<MaSequenceproduct> getMaSequenceproductList() {
        return maSequenceproductList;
    }

    public void setMaSequenceproductList(List<MaSequenceproduct> maSequenceproductList) {
        this.maSequenceproductList = maSequenceproductList;
    }

    @XmlTransient
    public List<MProductBom> getMProductBomList() {
        return mProductBomList;
    }

    public void setMProductBomList(List<MProductBom> mProductBomList) {
        this.mProductBomList = mProductBomList;
    }

    @XmlTransient
    public List<MProductBom> getMProductBomList1() {
        return mProductBomList1;
    }

    public void setMProductBomList1(List<MProductBom> mProductBomList1) {
        this.mProductBomList1 = mProductBomList1;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<MLot> getMLotList() {
        return mLotList;
    }

    public void setMLotList(List<MLot> mLotList) {
        this.mLotList = mLotList;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @XmlTransient
    public List<MProductTrl> getMProductTrlList() {
        return mProductTrlList;
    }

    public void setMProductTrlList(List<MProductTrl> mProductTrlList) {
        this.mProductTrlList = mProductTrlList;
    }

    @XmlTransient
    public List<MReplenish> getMReplenishList() {
        return mReplenishList;
    }

    public void setMReplenishList(List<MReplenish> mReplenishList) {
        this.mReplenishList = mReplenishList;
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
    public List<MStoragePending> getMStoragePendingList() {
        return mStoragePendingList;
    }

    public void setMStoragePendingList(List<MStoragePending> mStoragePendingList) {
        this.mStoragePendingList = mStoragePendingList;
    }

    @XmlTransient
    public List<MStorageDetail> getMStorageDetailList() {
        return mStorageDetailList;
    }

    public void setMStorageDetailList(List<MStorageDetail> mStorageDetailList) {
        this.mStorageDetailList = mStorageDetailList;
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
    public List<FinFinaccTransaction> getFinFinaccTransactionList() {
        return finFinaccTransactionList;
    }

    public void setFinFinaccTransactionList(List<FinFinaccTransaction> finFinaccTransactionList) {
        this.finFinaccTransactionList = finFinaccTransactionList;
    }

    @XmlTransient
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
    }

    @XmlTransient
    public List<CPhase> getCPhaseList() {
        return cPhaseList;
    }

    public void setCPhaseList(List<CPhase> cPhaseList) {
        this.cPhaseList = cPhaseList;
    }

    @XmlTransient
    public List<MProductUom> getMProductUomList() {
        return mProductUomList;
    }

    public void setMProductUomList(List<MProductUom> mProductUomList) {
        this.mProductUomList = mProductUomList;
    }

    @XmlTransient
    public List<CProjectproposalline> getCProjectproposallineList() {
        return cProjectproposallineList;
    }

    public void setCProjectproposallineList(List<CProjectproposalline> cProjectproposallineList) {
        this.cProjectproposallineList = cProjectproposallineList;
    }

    @XmlTransient
    public List<CProjectline> getCProjectlineList() {
        return cProjectlineList;
    }

    public void setCProjectlineList(List<CProjectline> cProjectlineList) {
        this.cProjectlineList = cProjectlineList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList() {
        return adClientinfoList;
    }

    public void setAdClientinfoList(List<AdClientinfo> adClientinfoList) {
        this.adClientinfoList = adClientinfoList;
    }

    @XmlTransient
    public List<MProductprice> getMProductpriceList() {
        return mProductpriceList;
    }

    public void setMProductpriceList(List<MProductprice> mProductpriceList) {
        this.mProductpriceList = mProductpriceList;
    }

    @XmlTransient
    public List<MDiscountschemaline> getMDiscountschemalineList() {
        return mDiscountschemalineList;
    }

    public void setMDiscountschemalineList(List<MDiscountschemaline> mDiscountschemalineList) {
        this.mDiscountschemalineList = mDiscountschemalineList;
    }

    @XmlTransient
    public List<MMatchpo> getMMatchpoList() {
        return mMatchpoList;
    }

    public void setMMatchpoList(List<MMatchpo> mMatchpoList) {
        this.mMatchpoList = mMatchpoList;
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
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
    }

    @XmlTransient
    public List<MInoutline> getMInoutlineList() {
        return mInoutlineList;
    }

    public void setMInoutlineList(List<MInoutline> mInoutlineList) {
        this.mInoutlineList = mInoutlineList;
    }

    @XmlTransient
    public List<CExternalposProduct> getCExternalposProductList() {
        return cExternalposProductList;
    }

    public void setCExternalposProductList(List<CExternalposProduct> cExternalposProductList) {
        this.cExternalposProductList = cExternalposProductList;
    }

    @XmlTransient
    public List<RRequestaction> getRRequestactionList() {
        return rRequestactionList;
    }

    public void setRRequestactionList(List<RRequestaction> rRequestactionList) {
        this.rRequestactionList = rRequestactionList;
    }
    
    

    public String getmClassificationId() {
		return mClassificationId;
	}

	public void setmClassificationId(String mClassificationId) {
		this.mClassificationId = mClassificationId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductId != null ? mProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProduct)) {
            return false;
        }
        MProduct other = (MProduct) object;
        if ((this.mProductId == null && other.mProductId != null) || (this.mProductId != null && !this.mProductId.equals(other.mProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProduct[ mProductId=" + mProductId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return mProductId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		mProductId = id;
	}
    
}
