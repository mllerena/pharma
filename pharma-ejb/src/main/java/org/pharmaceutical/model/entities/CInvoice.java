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
@Table(name = "c_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoice.findAll", query = "SELECT c FROM CInvoice c"),
    @NamedQuery(name = "CInvoice.findByCInvoiceId", query = "SELECT c FROM CInvoice c WHERE c.cInvoiceId = :cInvoiceId"),
    @NamedQuery(name = "CInvoice.findByIsactive", query = "SELECT c FROM CInvoice c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoice.findByCreated", query = "SELECT c FROM CInvoice c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoice.findByCreatedby", query = "SELECT c FROM CInvoice c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoice.findByUpdated", query = "SELECT c FROM CInvoice c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoice.findByUpdatedby", query = "SELECT c FROM CInvoice c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CInvoice.findByIssotrx", query = "SELECT c FROM CInvoice c WHERE c.issotrx = :issotrx"),
    @NamedQuery(name = "CInvoice.findByDocumentno", query = "SELECT c FROM CInvoice c WHERE c.documentno = :documentno"),
    @NamedQuery(name = "CInvoice.findByDocstatus", query = "SELECT c FROM CInvoice c WHERE c.docstatus = :docstatus"),
    @NamedQuery(name = "CInvoice.findByDocaction", query = "SELECT c FROM CInvoice c WHERE c.docaction = :docaction"),
    @NamedQuery(name = "CInvoice.findByProcessing", query = "SELECT c FROM CInvoice c WHERE c.processing = :processing"),
    @NamedQuery(name = "CInvoice.findByProcessed", query = "SELECT c FROM CInvoice c WHERE c.processed = :processed"),
    @NamedQuery(name = "CInvoice.findByPosted", query = "SELECT c FROM CInvoice c WHERE c.posted = :posted"),
    @NamedQuery(name = "CInvoice.findByDescription", query = "SELECT c FROM CInvoice c WHERE c.description = :description"),
    @NamedQuery(name = "CInvoice.findByIsprinted", query = "SELECT c FROM CInvoice c WHERE c.isprinted = :isprinted"),
    @NamedQuery(name = "CInvoice.findByDateinvoiced", query = "SELECT c FROM CInvoice c WHERE c.dateinvoiced = :dateinvoiced"),
    @NamedQuery(name = "CInvoice.findByDateprinted", query = "SELECT c FROM CInvoice c WHERE c.dateprinted = :dateprinted"),
    @NamedQuery(name = "CInvoice.findByDateacct", query = "SELECT c FROM CInvoice c WHERE c.dateacct = :dateacct"),
    @NamedQuery(name = "CInvoice.findByPoreference", query = "SELECT c FROM CInvoice c WHERE c.poreference = :poreference"),
    @NamedQuery(name = "CInvoice.findByIsdiscountprinted", query = "SELECT c FROM CInvoice c WHERE c.isdiscountprinted = :isdiscountprinted"),
    @NamedQuery(name = "CInvoice.findByDateordered", query = "SELECT c FROM CInvoice c WHERE c.dateordered = :dateordered"),
    @NamedQuery(name = "CInvoice.findByPaymentrule", query = "SELECT c FROM CInvoice c WHERE c.paymentrule = :paymentrule"),
    @NamedQuery(name = "CInvoice.findByChargeamt", query = "SELECT c FROM CInvoice c WHERE c.chargeamt = :chargeamt"),
    @NamedQuery(name = "CInvoice.findByTotallines", query = "SELECT c FROM CInvoice c WHERE c.totallines = :totallines"),
    @NamedQuery(name = "CInvoice.findByGrandtotal", query = "SELECT c FROM CInvoice c WHERE c.grandtotal = :grandtotal"),
    @NamedQuery(name = "CInvoice.findByIstaxincluded", query = "SELECT c FROM CInvoice c WHERE c.istaxincluded = :istaxincluded"),
    @NamedQuery(name = "CInvoice.findByCreatefrom", query = "SELECT c FROM CInvoice c WHERE c.createfrom = :createfrom"),
    @NamedQuery(name = "CInvoice.findByGenerateto", query = "SELECT c FROM CInvoice c WHERE c.generateto = :generateto"),
    @NamedQuery(name = "CInvoice.findByCopyfrom", query = "SELECT c FROM CInvoice c WHERE c.copyfrom = :copyfrom"),
    @NamedQuery(name = "CInvoice.findByIsselfservice", query = "SELECT c FROM CInvoice c WHERE c.isselfservice = :isselfservice"),
    @NamedQuery(name = "CInvoice.findByUser1Id", query = "SELECT c FROM CInvoice c WHERE c.user1Id = :user1Id"),
    @NamedQuery(name = "CInvoice.findByUser2Id", query = "SELECT c FROM CInvoice c WHERE c.user2Id = :user2Id"),
    @NamedQuery(name = "CInvoice.findByWithholdingamount", query = "SELECT c FROM CInvoice c WHERE c.withholdingamount = :withholdingamount"),
    @NamedQuery(name = "CInvoice.findByTaxdate", query = "SELECT c FROM CInvoice c WHERE c.taxdate = :taxdate"),
    @NamedQuery(name = "CInvoice.findByIspaid", query = "SELECT c FROM CInvoice c WHERE c.ispaid = :ispaid"),
    @NamedQuery(name = "CInvoice.findByTotalpaid", query = "SELECT c FROM CInvoice c WHERE c.totalpaid = :totalpaid"),
    @NamedQuery(name = "CInvoice.findByOutstandingamt", query = "SELECT c FROM CInvoice c WHERE c.outstandingamt = :outstandingamt"),
    @NamedQuery(name = "CInvoice.findByDaystilldue", query = "SELECT c FROM CInvoice c WHERE c.daystilldue = :daystilldue"),
    @NamedQuery(name = "CInvoice.findByDueamt", query = "SELECT c FROM CInvoice c WHERE c.dueamt = :dueamt"),
    @NamedQuery(name = "CInvoice.findByLastcalculatedondate", query = "SELECT c FROM CInvoice c WHERE c.lastcalculatedondate = :lastcalculatedondate"),
    @NamedQuery(name = "CInvoice.findByUpdatepaymentmonitor", query = "SELECT c FROM CInvoice c WHERE c.updatepaymentmonitor = :updatepaymentmonitor")})
public class CInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoice_id")
    private String cInvoiceId;
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
    @Column(name = "issotrx")
    private Character issotrx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docstatus")
    private String docstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docaction")
    private String docaction;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isprinted")
    private Character isprinted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateinvoiced")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinvoiced;
    @Column(name = "dateprinted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateprinted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Size(max = 20)
    @Column(name = "poreference")
    private String poreference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdiscountprinted")
    private Character isdiscountprinted;
    @Column(name = "dateordered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateordered;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "paymentrule")
    private String paymentrule;
    @Column(name = "chargeamt")
    private BigInteger chargeamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totallines")
    private BigInteger totallines;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grandtotal")
    private BigInteger grandtotal;
    @Column(name = "istaxincluded")
    private Character istaxincluded;
    @Column(name = "createfrom")
    private Character createfrom;
    @Column(name = "generateto")
    private Character generateto;
    @Column(name = "copyfrom")
    private Character copyfrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isselfservice")
    private Character isselfservice;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Column(name = "withholdingamount")
    private BigInteger withholdingamount;
    @Column(name = "taxdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date taxdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispaid")
    private Character ispaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalpaid")
    private BigInteger totalpaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "outstandingamt")
    private BigInteger outstandingamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "daystilldue")
    private BigInteger daystilldue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dueamt")
    private BigInteger dueamt;
    @Column(name = "lastcalculatedondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastcalculatedondate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updatepaymentmonitor")
    private Character updatepaymentmonitor;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<IBankstatement> iBankstatementList;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MPricelist mPricelistId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser salesrepId;
    @JoinColumn(name = "c_doctypetarget_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypetargetId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentmethod finPaymentmethodId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "fin_payment_priority_id", referencedColumnName = "fin_payment_priority_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentPriority finPaymentPriorityId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCharge cChargeId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CPaymentterm cPaymenttermId;
    @JoinColumn(name = "c_withholding_id", referencedColumnName = "c_withholding_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CWithholding cWithholdingId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoiceId")
    private List<CInvoicelinetax> cInvoicelinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoiceId")
    private List<CInvoiceDiscount> cInvoiceDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<CCommissionrun> cCommissionrunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<FinPaymentSchedule> finPaymentScheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoiceId")
    private List<CInvoicetax> cInvoicetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoiceId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "reversedCInvoiceId")
    private List<CInvoiceReverse> cInvoiceReverseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoiceId")
    private List<CInvoiceReverse> cInvoiceReverseList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<MRappelInvoice> mRappelInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceId")
    private List<RRequestaction> rRequestactionList;

    public CInvoice() {
    }

    public CInvoice(String cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    public CInvoice(String cInvoiceId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character issotrx, String documentno, String docstatus, String docaction, Character processed, String posted, Character isprinted, Date dateinvoiced, Date dateacct, Character isdiscountprinted, String paymentrule, BigInteger totallines, BigInteger grandtotal, Character isselfservice, Character ispaid, BigInteger totalpaid, BigInteger outstandingamt, BigInteger daystilldue, BigInteger dueamt, Character updatepaymentmonitor) {
        this.cInvoiceId = cInvoiceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.issotrx = issotrx;
        this.documentno = documentno;
        this.docstatus = docstatus;
        this.docaction = docaction;
        this.processed = processed;
        this.posted = posted;
        this.isprinted = isprinted;
        this.dateinvoiced = dateinvoiced;
        this.dateacct = dateacct;
        this.isdiscountprinted = isdiscountprinted;
        this.paymentrule = paymentrule;
        this.totallines = totallines;
        this.grandtotal = grandtotal;
        this.isselfservice = isselfservice;
        this.ispaid = ispaid;
        this.totalpaid = totalpaid;
        this.outstandingamt = outstandingamt;
        this.daystilldue = daystilldue;
        this.dueamt = dueamt;
        this.updatepaymentmonitor = updatepaymentmonitor;
    }

    public String getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(String cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
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

    public Character getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(Character issotrx) {
        this.issotrx = issotrx;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public String getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(String docstatus) {
        this.docstatus = docstatus;
    }

    public String getDocaction() {
        return docaction;
    }

    public void setDocaction(String docaction) {
        this.docaction = docaction;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIsprinted() {
        return isprinted;
    }

    public void setIsprinted(Character isprinted) {
        this.isprinted = isprinted;
    }

    public Date getDateinvoiced() {
        return dateinvoiced;
    }

    public void setDateinvoiced(Date dateinvoiced) {
        this.dateinvoiced = dateinvoiced;
    }

    public Date getDateprinted() {
        return dateprinted;
    }

    public void setDateprinted(Date dateprinted) {
        this.dateprinted = dateprinted;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public String getPoreference() {
        return poreference;
    }

    public void setPoreference(String poreference) {
        this.poreference = poreference;
    }

    public Character getIsdiscountprinted() {
        return isdiscountprinted;
    }

    public void setIsdiscountprinted(Character isdiscountprinted) {
        this.isdiscountprinted = isdiscountprinted;
    }

    public Date getDateordered() {
        return dateordered;
    }

    public void setDateordered(Date dateordered) {
        this.dateordered = dateordered;
    }

    public String getPaymentrule() {
        return paymentrule;
    }

    public void setPaymentrule(String paymentrule) {
        this.paymentrule = paymentrule;
    }

    public BigInteger getChargeamt() {
        return chargeamt;
    }

    public void setChargeamt(BigInteger chargeamt) {
        this.chargeamt = chargeamt;
    }

    public BigInteger getTotallines() {
        return totallines;
    }

    public void setTotallines(BigInteger totallines) {
        this.totallines = totallines;
    }

    public BigInteger getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(BigInteger grandtotal) {
        this.grandtotal = grandtotal;
    }

    public Character getIstaxincluded() {
        return istaxincluded;
    }

    public void setIstaxincluded(Character istaxincluded) {
        this.istaxincluded = istaxincluded;
    }

    public Character getCreatefrom() {
        return createfrom;
    }

    public void setCreatefrom(Character createfrom) {
        this.createfrom = createfrom;
    }

    public Character getGenerateto() {
        return generateto;
    }

    public void setGenerateto(Character generateto) {
        this.generateto = generateto;
    }

    public Character getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(Character copyfrom) {
        this.copyfrom = copyfrom;
    }

    public Character getIsselfservice() {
        return isselfservice;
    }

    public void setIsselfservice(Character isselfservice) {
        this.isselfservice = isselfservice;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public BigInteger getWithholdingamount() {
        return withholdingamount;
    }

    public void setWithholdingamount(BigInteger withholdingamount) {
        this.withholdingamount = withholdingamount;
    }

    public Date getTaxdate() {
        return taxdate;
    }

    public void setTaxdate(Date taxdate) {
        this.taxdate = taxdate;
    }

    public Character getIspaid() {
        return ispaid;
    }

    public void setIspaid(Character ispaid) {
        this.ispaid = ispaid;
    }

    public BigInteger getTotalpaid() {
        return totalpaid;
    }

    public void setTotalpaid(BigInteger totalpaid) {
        this.totalpaid = totalpaid;
    }

    public BigInteger getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(BigInteger outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public BigInteger getDaystilldue() {
        return daystilldue;
    }

    public void setDaystilldue(BigInteger daystilldue) {
        this.daystilldue = daystilldue;
    }

    public BigInteger getDueamt() {
        return dueamt;
    }

    public void setDueamt(BigInteger dueamt) {
        this.dueamt = dueamt;
    }

    public Date getLastcalculatedondate() {
        return lastcalculatedondate;
    }

    public void setLastcalculatedondate(Date lastcalculatedondate) {
        this.lastcalculatedondate = lastcalculatedondate;
    }

    public Character getUpdatepaymentmonitor() {
        return updatepaymentmonitor;
    }

    public void setUpdatepaymentmonitor(Character updatepaymentmonitor) {
        this.updatepaymentmonitor = updatepaymentmonitor;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<IBankstatement> getIBankstatementList() {
        return iBankstatementList;
    }

    public void setIBankstatementList(List<IBankstatement> iBankstatementList) {
        this.iBankstatementList = iBankstatementList;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
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

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
    }

    public CDoctype getCDoctypetargetId() {
        return cDoctypetargetId;
    }

    public void setCDoctypetargetId(CDoctype cDoctypetargetId) {
        this.cDoctypetargetId = cDoctypetargetId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public FinPaymentmethod getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(FinPaymentmethod finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public FinPaymentPriority getFinPaymentPriorityId() {
        return finPaymentPriorityId;
    }

    public void setFinPaymentPriorityId(FinPaymentPriority finPaymentPriorityId) {
        this.finPaymentPriorityId = finPaymentPriorityId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
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

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CCharge getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(CCharge cChargeId) {
        this.cChargeId = cChargeId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public CWithholding getCWithholdingId() {
        return cWithholdingId;
    }

    public void setCWithholdingId(CWithholding cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
    }

    @XmlTransient
    public List<CInvoicelinetax> getCInvoicelinetaxList() {
        return cInvoicelinetaxList;
    }

    public void setCInvoicelinetaxList(List<CInvoicelinetax> cInvoicelinetaxList) {
        this.cInvoicelinetaxList = cInvoicelinetaxList;
    }

    @XmlTransient
    public List<CInvoiceDiscount> getCInvoiceDiscountList() {
        return cInvoiceDiscountList;
    }

    public void setCInvoiceDiscountList(List<CInvoiceDiscount> cInvoiceDiscountList) {
        this.cInvoiceDiscountList = cInvoiceDiscountList;
    }

    @XmlTransient
    public List<CCommissionrun> getCCommissionrunList() {
        return cCommissionrunList;
    }

    public void setCCommissionrunList(List<CCommissionrun> cCommissionrunList) {
        this.cCommissionrunList = cCommissionrunList;
    }

    @XmlTransient
    public List<FinPaymentSchedule> getFinPaymentScheduleList() {
        return finPaymentScheduleList;
    }

    public void setFinPaymentScheduleList(List<FinPaymentSchedule> finPaymentScheduleList) {
        this.finPaymentScheduleList = finPaymentScheduleList;
    }

    @XmlTransient
    public List<CInvoicetax> getCInvoicetaxList() {
        return cInvoicetaxList;
    }

    public void setCInvoicetaxList(List<CInvoicetax> cInvoicetaxList) {
        this.cInvoicetaxList = cInvoicetaxList;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<CInvoiceReverse> getCInvoiceReverseList() {
        return cInvoiceReverseList;
    }

    public void setCInvoiceReverseList(List<CInvoiceReverse> cInvoiceReverseList) {
        this.cInvoiceReverseList = cInvoiceReverseList;
    }

    @XmlTransient
    public List<CInvoiceReverse> getCInvoiceReverseList1() {
        return cInvoiceReverseList1;
    }

    public void setCInvoiceReverseList1(List<CInvoiceReverse> cInvoiceReverseList1) {
        this.cInvoiceReverseList1 = cInvoiceReverseList1;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList() {
        return cDebtPaymentList;
    }

    public void setCDebtPaymentList(List<CDebtPayment> cDebtPaymentList) {
        this.cDebtPaymentList = cDebtPaymentList;
    }

    @XmlTransient
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
    }

    @XmlTransient
    public List<MRappelInvoice> getMRappelInvoiceList() {
        return mRappelInvoiceList;
    }

    public void setMRappelInvoiceList(List<MRappelInvoice> mRappelInvoiceList) {
        this.mRappelInvoiceList = mRappelInvoiceList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
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
        hash += (cInvoiceId != null ? cInvoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoice)) {
            return false;
        }
        CInvoice other = (CInvoice) object;
        if ((this.cInvoiceId == null && other.cInvoiceId != null) || (this.cInvoiceId != null && !this.cInvoiceId.equals(other.cInvoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoice[ cInvoiceId=" + cInvoiceId + " ]";
    }
    
}
