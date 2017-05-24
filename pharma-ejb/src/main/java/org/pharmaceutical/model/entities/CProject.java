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
@Table(name = "c_project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProject.findAll", query = "SELECT c FROM CProject c"),
    @NamedQuery(name = "CProject.findByCProjectId", query = "SELECT c FROM CProject c WHERE c.cProjectId = :cProjectId"),
    @NamedQuery(name = "CProject.findByIsactive", query = "SELECT c FROM CProject c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProject.findByCreated", query = "SELECT c FROM CProject c WHERE c.created = :created"),
    @NamedQuery(name = "CProject.findByCreatedby", query = "SELECT c FROM CProject c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProject.findByUpdated", query = "SELECT c FROM CProject c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProject.findByUpdatedby", query = "SELECT c FROM CProject c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProject.findByValue", query = "SELECT c FROM CProject c WHERE c.value = :value"),
    @NamedQuery(name = "CProject.findByName", query = "SELECT c FROM CProject c WHERE c.name = :name"),
    @NamedQuery(name = "CProject.findByDescription", query = "SELECT c FROM CProject c WHERE c.description = :description"),
    @NamedQuery(name = "CProject.findByNote", query = "SELECT c FROM CProject c WHERE c.note = :note"),
    @NamedQuery(name = "CProject.findByIssummary", query = "SELECT c FROM CProject c WHERE c.issummary = :issummary"),
    @NamedQuery(name = "CProject.findByPoreference", query = "SELECT c FROM CProject c WHERE c.poreference = :poreference"),
    @NamedQuery(name = "CProject.findByCreatetemppricelist", query = "SELECT c FROM CProject c WHERE c.createtemppricelist = :createtemppricelist"),
    @NamedQuery(name = "CProject.findByIscommitment", query = "SELECT c FROM CProject c WHERE c.iscommitment = :iscommitment"),
    @NamedQuery(name = "CProject.findByPlannedamt", query = "SELECT c FROM CProject c WHERE c.plannedamt = :plannedamt"),
    @NamedQuery(name = "CProject.findByPlannedqty", query = "SELECT c FROM CProject c WHERE c.plannedqty = :plannedqty"),
    @NamedQuery(name = "CProject.findByPlannedmarginamt", query = "SELECT c FROM CProject c WHERE c.plannedmarginamt = :plannedmarginamt"),
    @NamedQuery(name = "CProject.findByCommittedamt", query = "SELECT c FROM CProject c WHERE c.committedamt = :committedamt"),
    @NamedQuery(name = "CProject.findByDatecontract", query = "SELECT c FROM CProject c WHERE c.datecontract = :datecontract"),
    @NamedQuery(name = "CProject.findByDatefinish", query = "SELECT c FROM CProject c WHERE c.datefinish = :datefinish"),
    @NamedQuery(name = "CProject.findByGenerateto", query = "SELECT c FROM CProject c WHERE c.generateto = :generateto"),
    @NamedQuery(name = "CProject.findByProcessed", query = "SELECT c FROM CProject c WHERE c.processed = :processed"),
    @NamedQuery(name = "CProject.findByCopyfrom", query = "SELECT c FROM CProject c WHERE c.copyfrom = :copyfrom"),
    @NamedQuery(name = "CProject.findByCommittedqty", query = "SELECT c FROM CProject c WHERE c.committedqty = :committedqty"),
    @NamedQuery(name = "CProject.findByInvoicedamt", query = "SELECT c FROM CProject c WHERE c.invoicedamt = :invoicedamt"),
    @NamedQuery(name = "CProject.findByInvoicedqty", query = "SELECT c FROM CProject c WHERE c.invoicedqty = :invoicedqty"),
    @NamedQuery(name = "CProject.findByProjectbalanceamt", query = "SELECT c FROM CProject c WHERE c.projectbalanceamt = :projectbalanceamt"),
    @NamedQuery(name = "CProject.findByIscommitceiling", query = "SELECT c FROM CProject c WHERE c.iscommitceiling = :iscommitceiling"),
    @NamedQuery(name = "CProject.findByProjectcategory", query = "SELECT c FROM CProject c WHERE c.projectcategory = :projectcategory"),
    @NamedQuery(name = "CProject.findByProcessing", query = "SELECT c FROM CProject c WHERE c.processing = :processing"),
    @NamedQuery(name = "CProject.findByPublicprivate", query = "SELECT c FROM CProject c WHERE c.publicprivate = :publicprivate"),
    @NamedQuery(name = "CProject.findByProjectstatus", query = "SELECT c FROM CProject c WHERE c.projectstatus = :projectstatus"),
    @NamedQuery(name = "CProject.findByProjectkind", query = "SELECT c FROM CProject c WHERE c.projectkind = :projectkind"),
    @NamedQuery(name = "CProject.findByProjectphase", query = "SELECT c FROM CProject c WHERE c.projectphase = :projectphase"),
    @NamedQuery(name = "CProject.findByGenerateorder", query = "SELECT c FROM CProject c WHERE c.generateorder = :generateorder"),
    @NamedQuery(name = "CProject.findByChangeprojectstatus", query = "SELECT c FROM CProject c WHERE c.changeprojectstatus = :changeprojectstatus"),
    @NamedQuery(name = "CProject.findByPaymentrule", query = "SELECT c FROM CProject c WHERE c.paymentrule = :paymentrule"),
    @NamedQuery(name = "CProject.findByInvoiceToproject", query = "SELECT c FROM CProject c WHERE c.invoiceToproject = :invoiceToproject"),
    @NamedQuery(name = "CProject.findByPlannedpoamt", query = "SELECT c FROM CProject c WHERE c.plannedpoamt = :plannedpoamt"),
    @NamedQuery(name = "CProject.findByLastplannedproposaldate", query = "SELECT c FROM CProject c WHERE c.lastplannedproposaldate = :lastplannedproposaldate"),
    @NamedQuery(name = "CProject.findByDocumentCopies", query = "SELECT c FROM CProject c WHERE c.documentCopies = :documentCopies"),
    @NamedQuery(name = "CProject.findByAccountno", query = "SELECT c FROM CProject c WHERE c.accountno = :accountno"),
    @NamedQuery(name = "CProject.findByExpexpenses", query = "SELECT c FROM CProject c WHERE c.expexpenses = :expexpenses"),
    @NamedQuery(name = "CProject.findByExpmargin", query = "SELECT c FROM CProject c WHERE c.expmargin = :expmargin"),
    @NamedQuery(name = "CProject.findByExpreinvoicing", query = "SELECT c FROM CProject c WHERE c.expreinvoicing = :expreinvoicing"),
    @NamedQuery(name = "CProject.findByServcost", query = "SELECT c FROM CProject c WHERE c.servcost = :servcost"),
    @NamedQuery(name = "CProject.findByServmargin", query = "SELECT c FROM CProject c WHERE c.servmargin = :servmargin"),
    @NamedQuery(name = "CProject.findByServrevenue", query = "SELECT c FROM CProject c WHERE c.servrevenue = :servrevenue"),
    @NamedQuery(name = "CProject.findBySetprojecttype", query = "SELECT c FROM CProject c WHERE c.setprojecttype = :setprojecttype"),
    @NamedQuery(name = "CProject.findByStartdate", query = "SELECT c FROM CProject c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "CProject.findByServsercost", query = "SELECT c FROM CProject c WHERE c.servsercost = :servsercost"),
    @NamedQuery(name = "CProject.findByServoutcost", query = "SELECT c FROM CProject c WHERE c.servoutcost = :servoutcost")})
public class CProject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_project_id")
    private String cProjectId;
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
    @Size(max = 2000)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issummary")
    private Character issummary;
    @Size(max = 20)
    @Column(name = "poreference")
    private String poreference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createtemppricelist")
    private Character createtemppricelist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscommitment")
    private Character iscommitment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedamt")
    private BigInteger plannedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedqty")
    private BigInteger plannedqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedmarginamt")
    private BigInteger plannedmarginamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "committedamt")
    private BigInteger committedamt;
    @Column(name = "datecontract")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecontract;
    @Column(name = "datefinish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefinish;
    @Column(name = "generateto")
    private Character generateto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Column(name = "copyfrom")
    private Character copyfrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "committedqty")
    private BigInteger committedqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoicedamt")
    private BigInteger invoicedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoicedqty")
    private BigInteger invoicedqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectbalanceamt")
    private BigInteger projectbalanceamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscommitceiling")
    private Character iscommitceiling;
    @Size(max = 60)
    @Column(name = "projectcategory")
    private String projectcategory;
    @Column(name = "processing")
    private Character processing;
    @Size(max = 60)
    @Column(name = "publicprivate")
    private String publicprivate;
    @Size(max = 60)
    @Column(name = "projectstatus")
    private String projectstatus;
    @Size(max = 60)
    @Column(name = "projectkind")
    private String projectkind;
    @Size(max = 60)
    @Column(name = "projectphase")
    private String projectphase;
    @Column(name = "generateorder")
    private Character generateorder;
    @Size(max = 60)
    @Column(name = "changeprojectstatus")
    private String changeprojectstatus;
    @Size(max = 60)
    @Column(name = "paymentrule")
    private String paymentrule;
    @Column(name = "invoice_toproject")
    private Character invoiceToproject;
    @Column(name = "plannedpoamt")
    private BigInteger plannedpoamt;
    @Column(name = "lastplannedproposaldate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastplannedproposaldate;
    @Column(name = "document_copies")
    private BigInteger documentCopies;
    @Size(max = 20)
    @Column(name = "accountno")
    private String accountno;
    @Column(name = "expexpenses")
    private BigInteger expexpenses;
    @Column(name = "expmargin")
    private BigInteger expmargin;
    @Column(name = "expreinvoicing")
    private BigInteger expreinvoicing;
    @Column(name = "servcost")
    private BigInteger servcost;
    @Column(name = "servmargin")
    private BigInteger servmargin;
    @Column(name = "servrevenue")
    private BigInteger servrevenue;
    @Column(name = "setprojecttype")
    private Character setprojecttype;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "servsercost")
    private BigInteger servsercost;
    @Column(name = "servoutcost")
    private BigInteger servoutcost;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectId")
    private List<CProjectphase> cProjectphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<MProduction> mProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<MInventory> mInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectId")
    private List<CProjectissue> cProjectissueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CSettlement> cSettlementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectId")
    private List<CProjectAcct> cProjectAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectId")
    private List<CProjectproposal> cProjectproposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CDpManagement> cDpManagementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectId")
    private List<CProjectVendor> cProjectVendorList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<MMovement> mMovementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectId")
    private List<CProjectline> cProjectlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<AAmortization> aAmortizationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<GlJournal> glJournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<MInout> mInoutList;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentmethod finPaymentmethodId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_projectphase_id", referencedColumnName = "c_projectphase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProjectphase cProjectphaseId;
    @JoinColumn(name = "m_pricelist_version_id", referencedColumnName = "m_pricelist_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelistVersion mPricelistVersionId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser salesrepId;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPaymentterm cPaymenttermId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MWarehouse mWarehouseId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "responsible_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner responsibleId;
    @JoinColumn(name = "billto_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation billtoId;
    @JoinColumn(name = "c_projecttype_id", referencedColumnName = "c_projecttype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProjecttype cProjecttypeId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;
    @JoinColumn(name = "c_phase_id", referencedColumnName = "c_phase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPhase cPhaseId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<CCash> cCashList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectId")
    private List<RRequestaction> rRequestactionList;

    public CProject() {
    }

    public CProject(String cProjectId) {
        this.cProjectId = cProjectId;
    }

    public CProject(String cProjectId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, Character issummary, Character createtemppricelist, Character iscommitment, BigInteger plannedamt, BigInteger plannedqty, BigInteger plannedmarginamt, BigInteger committedamt, Character processed, BigInteger committedqty, BigInteger invoicedamt, BigInteger invoicedqty, BigInteger projectbalanceamt, Character iscommitceiling) {
        this.cProjectId = cProjectId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.issummary = issummary;
        this.createtemppricelist = createtemppricelist;
        this.iscommitment = iscommitment;
        this.plannedamt = plannedamt;
        this.plannedqty = plannedqty;
        this.plannedmarginamt = plannedmarginamt;
        this.committedamt = committedamt;
        this.processed = processed;
        this.committedqty = committedqty;
        this.invoicedamt = invoicedamt;
        this.invoicedqty = invoicedqty;
        this.projectbalanceamt = projectbalanceamt;
        this.iscommitceiling = iscommitceiling;
    }

    public String getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(String cProjectId) {
        this.cProjectId = cProjectId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
    }

    public String getPoreference() {
        return poreference;
    }

    public void setPoreference(String poreference) {
        this.poreference = poreference;
    }

    public Character getCreatetemppricelist() {
        return createtemppricelist;
    }

    public void setCreatetemppricelist(Character createtemppricelist) {
        this.createtemppricelist = createtemppricelist;
    }

    public Character getIscommitment() {
        return iscommitment;
    }

    public void setIscommitment(Character iscommitment) {
        this.iscommitment = iscommitment;
    }

    public BigInteger getPlannedamt() {
        return plannedamt;
    }

    public void setPlannedamt(BigInteger plannedamt) {
        this.plannedamt = plannedamt;
    }

    public BigInteger getPlannedqty() {
        return plannedqty;
    }

    public void setPlannedqty(BigInteger plannedqty) {
        this.plannedqty = plannedqty;
    }

    public BigInteger getPlannedmarginamt() {
        return plannedmarginamt;
    }

    public void setPlannedmarginamt(BigInteger plannedmarginamt) {
        this.plannedmarginamt = plannedmarginamt;
    }

    public BigInteger getCommittedamt() {
        return committedamt;
    }

    public void setCommittedamt(BigInteger committedamt) {
        this.committedamt = committedamt;
    }

    public Date getDatecontract() {
        return datecontract;
    }

    public void setDatecontract(Date datecontract) {
        this.datecontract = datecontract;
    }

    public Date getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(Date datefinish) {
        this.datefinish = datefinish;
    }

    public Character getGenerateto() {
        return generateto;
    }

    public void setGenerateto(Character generateto) {
        this.generateto = generateto;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(Character copyfrom) {
        this.copyfrom = copyfrom;
    }

    public BigInteger getCommittedqty() {
        return committedqty;
    }

    public void setCommittedqty(BigInteger committedqty) {
        this.committedqty = committedqty;
    }

    public BigInteger getInvoicedamt() {
        return invoicedamt;
    }

    public void setInvoicedamt(BigInteger invoicedamt) {
        this.invoicedamt = invoicedamt;
    }

    public BigInteger getInvoicedqty() {
        return invoicedqty;
    }

    public void setInvoicedqty(BigInteger invoicedqty) {
        this.invoicedqty = invoicedqty;
    }

    public BigInteger getProjectbalanceamt() {
        return projectbalanceamt;
    }

    public void setProjectbalanceamt(BigInteger projectbalanceamt) {
        this.projectbalanceamt = projectbalanceamt;
    }

    public Character getIscommitceiling() {
        return iscommitceiling;
    }

    public void setIscommitceiling(Character iscommitceiling) {
        this.iscommitceiling = iscommitceiling;
    }

    public String getProjectcategory() {
        return projectcategory;
    }

    public void setProjectcategory(String projectcategory) {
        this.projectcategory = projectcategory;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public String getPublicprivate() {
        return publicprivate;
    }

    public void setPublicprivate(String publicprivate) {
        this.publicprivate = publicprivate;
    }

    public String getProjectstatus() {
        return projectstatus;
    }

    public void setProjectstatus(String projectstatus) {
        this.projectstatus = projectstatus;
    }

    public String getProjectkind() {
        return projectkind;
    }

    public void setProjectkind(String projectkind) {
        this.projectkind = projectkind;
    }

    public String getProjectphase() {
        return projectphase;
    }

    public void setProjectphase(String projectphase) {
        this.projectphase = projectphase;
    }

    public Character getGenerateorder() {
        return generateorder;
    }

    public void setGenerateorder(Character generateorder) {
        this.generateorder = generateorder;
    }

    public String getChangeprojectstatus() {
        return changeprojectstatus;
    }

    public void setChangeprojectstatus(String changeprojectstatus) {
        this.changeprojectstatus = changeprojectstatus;
    }

    public String getPaymentrule() {
        return paymentrule;
    }

    public void setPaymentrule(String paymentrule) {
        this.paymentrule = paymentrule;
    }

    public Character getInvoiceToproject() {
        return invoiceToproject;
    }

    public void setInvoiceToproject(Character invoiceToproject) {
        this.invoiceToproject = invoiceToproject;
    }

    public BigInteger getPlannedpoamt() {
        return plannedpoamt;
    }

    public void setPlannedpoamt(BigInteger plannedpoamt) {
        this.plannedpoamt = plannedpoamt;
    }

    public Date getLastplannedproposaldate() {
        return lastplannedproposaldate;
    }

    public void setLastplannedproposaldate(Date lastplannedproposaldate) {
        this.lastplannedproposaldate = lastplannedproposaldate;
    }

    public BigInteger getDocumentCopies() {
        return documentCopies;
    }

    public void setDocumentCopies(BigInteger documentCopies) {
        this.documentCopies = documentCopies;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public BigInteger getExpexpenses() {
        return expexpenses;
    }

    public void setExpexpenses(BigInteger expexpenses) {
        this.expexpenses = expexpenses;
    }

    public BigInteger getExpmargin() {
        return expmargin;
    }

    public void setExpmargin(BigInteger expmargin) {
        this.expmargin = expmargin;
    }

    public BigInteger getExpreinvoicing() {
        return expreinvoicing;
    }

    public void setExpreinvoicing(BigInteger expreinvoicing) {
        this.expreinvoicing = expreinvoicing;
    }

    public BigInteger getServcost() {
        return servcost;
    }

    public void setServcost(BigInteger servcost) {
        this.servcost = servcost;
    }

    public BigInteger getServmargin() {
        return servmargin;
    }

    public void setServmargin(BigInteger servmargin) {
        this.servmargin = servmargin;
    }

    public BigInteger getServrevenue() {
        return servrevenue;
    }

    public void setServrevenue(BigInteger servrevenue) {
        this.servrevenue = servrevenue;
    }

    public Character getSetprojecttype() {
        return setprojecttype;
    }

    public void setSetprojecttype(Character setprojecttype) {
        this.setprojecttype = setprojecttype;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public BigInteger getServsercost() {
        return servsercost;
    }

    public void setServsercost(BigInteger servsercost) {
        this.servsercost = servsercost;
    }

    public BigInteger getServoutcost() {
        return servoutcost;
    }

    public void setServoutcost(BigInteger servoutcost) {
        this.servoutcost = servoutcost;
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
    public List<MProduction> getMProductionList() {
        return mProductionList;
    }

    public void setMProductionList(List<MProduction> mProductionList) {
        this.mProductionList = mProductionList;
    }

    @XmlTransient
    public List<MInventory> getMInventoryList() {
        return mInventoryList;
    }

    public void setMInventoryList(List<MInventory> mInventoryList) {
        this.mInventoryList = mInventoryList;
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
    public List<CSettlement> getCSettlementList() {
        return cSettlementList;
    }

    public void setCSettlementList(List<CSettlement> cSettlementList) {
        this.cSettlementList = cSettlementList;
    }

    @XmlTransient
    public List<CProjectAcct> getCProjectAcctList() {
        return cProjectAcctList;
    }

    public void setCProjectAcctList(List<CProjectAcct> cProjectAcctList) {
        this.cProjectAcctList = cProjectAcctList;
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
    public List<CInvoicelineAcctdimension> getCInvoicelineAcctdimensionList() {
        return cInvoicelineAcctdimensionList;
    }

    public void setCInvoicelineAcctdimensionList(List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList) {
        this.cInvoicelineAcctdimensionList = cInvoicelineAcctdimensionList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<CProjectproposal> getCProjectproposalList() {
        return cProjectproposalList;
    }

    public void setCProjectproposalList(List<CProjectproposal> cProjectproposalList) {
        this.cProjectproposalList = cProjectproposalList;
    }

    @XmlTransient
    public List<CDpManagement> getCDpManagementList() {
        return cDpManagementList;
    }

    public void setCDpManagementList(List<CDpManagement> cDpManagementList) {
        this.cDpManagementList = cDpManagementList;
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
    public List<MMovement> getMMovementList() {
        return mMovementList;
    }

    public void setMMovementList(List<MMovement> mMovementList) {
        this.mMovementList = mMovementList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<FinFinaccTransaction> getFinFinaccTransactionList() {
        return finFinaccTransactionList;
    }

    public void setFinFinaccTransactionList(List<FinFinaccTransaction> finFinaccTransactionList) {
        this.finFinaccTransactionList = finFinaccTransactionList;
    }

    @XmlTransient
    public List<CProjectline> getCProjectlineList() {
        return cProjectlineList;
    }

    public void setCProjectlineList(List<CProjectline> cProjectlineList) {
        this.cProjectlineList = cProjectlineList;
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
    public List<GlJournal> getGlJournalList() {
        return glJournalList;
    }

    public void setGlJournalList(List<GlJournal> glJournalList) {
        this.glJournalList = glJournalList;
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

    public FinPaymentmethod getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(FinPaymentmethod finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CProjectphase getCProjectphaseId() {
        return cProjectphaseId;
    }

    public void setCProjectphaseId(CProjectphase cProjectphaseId) {
        this.cProjectphaseId = cProjectphaseId;
    }

    public MPricelistVersion getMPricelistVersionId() {
        return mPricelistVersionId;
    }

    public void setMPricelistVersionId(MPricelistVersion mPricelistVersionId) {
        this.mPricelistVersionId = mPricelistVersionId;
    }

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
    }

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CBpartner getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(CBpartner responsibleId) {
        this.responsibleId = responsibleId;
    }

    public CBpartnerLocation getBilltoId() {
        return billtoId;
    }

    public void setBilltoId(CBpartnerLocation billtoId) {
        this.billtoId = billtoId;
    }

    public CProjecttype getCProjecttypeId() {
        return cProjecttypeId;
    }

    public void setCProjecttypeId(CProjecttype cProjecttypeId) {
        this.cProjecttypeId = cProjecttypeId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public CPhase getCPhaseId() {
        return cPhaseId;
    }

    public void setCPhaseId(CPhase cPhaseId) {
        this.cPhaseId = cPhaseId;
    }

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    @XmlTransient
    public List<CCash> getCCashList() {
        return cCashList;
    }

    public void setCCashList(List<CCash> cCashList) {
        this.cCashList = cCashList;
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
        hash += (cProjectId != null ? cProjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProject)) {
            return false;
        }
        CProject other = (CProject) object;
        if ((this.cProjectId == null && other.cProjectId != null) || (this.cProjectId != null && !this.cProjectId.equals(other.cProjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProject[ cProjectId=" + cProjectId + " ]";
    }
    
}
