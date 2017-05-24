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
@Table(name = "c_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "COrder.findAll", query = "SELECT c FROM COrder c"),
    @NamedQuery(name = "COrder.findByCOrderId", query = "SELECT c FROM COrder c WHERE c.cOrderId = :cOrderId"),
    @NamedQuery(name = "COrder.findByIsactive", query = "SELECT c FROM COrder c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "COrder.findByCreated", query = "SELECT c FROM COrder c WHERE c.created = :created"),
    @NamedQuery(name = "COrder.findByCreatedby", query = "SELECT c FROM COrder c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "COrder.findByUpdated", query = "SELECT c FROM COrder c WHERE c.updated = :updated"),
    @NamedQuery(name = "COrder.findByUpdatedby", query = "SELECT c FROM COrder c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "COrder.findByIssotrx", query = "SELECT c FROM COrder c WHERE c.issotrx = :issotrx"),
    @NamedQuery(name = "COrder.findByDocumentno", query = "SELECT c FROM COrder c WHERE c.documentno = :documentno"),
    @NamedQuery(name = "COrder.findByDocstatus", query = "SELECT c FROM COrder c WHERE c.docstatus = :docstatus"),
    @NamedQuery(name = "COrder.findByDocaction", query = "SELECT c FROM COrder c WHERE c.docaction = :docaction"),
    @NamedQuery(name = "COrder.findByProcessing", query = "SELECT c FROM COrder c WHERE c.processing = :processing"),
    @NamedQuery(name = "COrder.findByProcessed", query = "SELECT c FROM COrder c WHERE c.processed = :processed"),
    @NamedQuery(name = "COrder.findByDescription", query = "SELECT c FROM COrder c WHERE c.description = :description"),
    @NamedQuery(name = "COrder.findByIsdelivered", query = "SELECT c FROM COrder c WHERE c.isdelivered = :isdelivered"),
    @NamedQuery(name = "COrder.findByIsinvoiced", query = "SELECT c FROM COrder c WHERE c.isinvoiced = :isinvoiced"),
    @NamedQuery(name = "COrder.findByIsprinted", query = "SELECT c FROM COrder c WHERE c.isprinted = :isprinted"),
    @NamedQuery(name = "COrder.findByIsselected", query = "SELECT c FROM COrder c WHERE c.isselected = :isselected"),
    @NamedQuery(name = "COrder.findByDateordered", query = "SELECT c FROM COrder c WHERE c.dateordered = :dateordered"),
    @NamedQuery(name = "COrder.findByDatepromised", query = "SELECT c FROM COrder c WHERE c.datepromised = :datepromised"),
    @NamedQuery(name = "COrder.findByDateprinted", query = "SELECT c FROM COrder c WHERE c.dateprinted = :dateprinted"),
    @NamedQuery(name = "COrder.findByDateacct", query = "SELECT c FROM COrder c WHERE c.dateacct = :dateacct"),
    @NamedQuery(name = "COrder.findByPoreference", query = "SELECT c FROM COrder c WHERE c.poreference = :poreference"),
    @NamedQuery(name = "COrder.findByIsdiscountprinted", query = "SELECT c FROM COrder c WHERE c.isdiscountprinted = :isdiscountprinted"),
    @NamedQuery(name = "COrder.findByPaymentrule", query = "SELECT c FROM COrder c WHERE c.paymentrule = :paymentrule"),
    @NamedQuery(name = "COrder.findByInvoicerule", query = "SELECT c FROM COrder c WHERE c.invoicerule = :invoicerule"),
    @NamedQuery(name = "COrder.findByDeliveryrule", query = "SELECT c FROM COrder c WHERE c.deliveryrule = :deliveryrule"),
    @NamedQuery(name = "COrder.findByFreightcostrule", query = "SELECT c FROM COrder c WHERE c.freightcostrule = :freightcostrule"),
    @NamedQuery(name = "COrder.findByFreightamt", query = "SELECT c FROM COrder c WHERE c.freightamt = :freightamt"),
    @NamedQuery(name = "COrder.findByDeliveryviarule", query = "SELECT c FROM COrder c WHERE c.deliveryviarule = :deliveryviarule"),
    @NamedQuery(name = "COrder.findByChargeamt", query = "SELECT c FROM COrder c WHERE c.chargeamt = :chargeamt"),
    @NamedQuery(name = "COrder.findByPriorityrule", query = "SELECT c FROM COrder c WHERE c.priorityrule = :priorityrule"),
    @NamedQuery(name = "COrder.findByTotallines", query = "SELECT c FROM COrder c WHERE c.totallines = :totallines"),
    @NamedQuery(name = "COrder.findByGrandtotal", query = "SELECT c FROM COrder c WHERE c.grandtotal = :grandtotal"),
    @NamedQuery(name = "COrder.findByIstaxincluded", query = "SELECT c FROM COrder c WHERE c.istaxincluded = :istaxincluded"),
    @NamedQuery(name = "COrder.findByPosted", query = "SELECT c FROM COrder c WHERE c.posted = :posted"),
    @NamedQuery(name = "COrder.findByCopyfrom", query = "SELECT c FROM COrder c WHERE c.copyfrom = :copyfrom"),
    @NamedQuery(name = "COrder.findByIsselfservice", query = "SELECT c FROM COrder c WHERE c.isselfservice = :isselfservice"),
    @NamedQuery(name = "COrder.findByUser1Id", query = "SELECT c FROM COrder c WHERE c.user1Id = :user1Id"),
    @NamedQuery(name = "COrder.findByUser2Id", query = "SELECT c FROM COrder c WHERE c.user2Id = :user2Id"),
    @NamedQuery(name = "COrder.findByDeliverynotes", query = "SELECT c FROM COrder c WHERE c.deliverynotes = :deliverynotes"),
    @NamedQuery(name = "COrder.findByIncotermsdescription", query = "SELECT c FROM COrder c WHERE c.incotermsdescription = :incotermsdescription"),
    @NamedQuery(name = "COrder.findByGeneratetemplate", query = "SELECT c FROM COrder c WHERE c.generatetemplate = :generatetemplate"),
    @NamedQuery(name = "COrder.findByCopyfrompo", query = "SELECT c FROM COrder c WHERE c.copyfrompo = :copyfrompo")})
public class COrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_order_id")
    private String cOrderId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdelivered")
    private Character isdelivered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isinvoiced")
    private Character isinvoiced;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isprinted")
    private Character isprinted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isselected")
    private Character isselected;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateordered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateordered;
    @Column(name = "datepromised")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepromised;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "paymentrule")
    private String paymentrule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "invoicerule")
    private String invoicerule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "deliveryrule")
    private String deliveryrule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "freightcostrule")
    private String freightcostrule;
    @Column(name = "freightamt")
    private BigInteger freightamt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "deliveryviarule")
    private String deliveryviarule;
    @Column(name = "chargeamt")
    private BigInteger chargeamt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "priorityrule")
    private String priorityrule;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
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
    @Size(max = 2000)
    @Column(name = "deliverynotes")
    private String deliverynotes;
    @Size(max = 255)
    @Column(name = "incotermsdescription")
    private String incotermsdescription;
    @Column(name = "generatetemplate")
    private Character generatetemplate;
    @Column(name = "copyfrompo")
    private Character copyfrompo;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<CProjectphase> cProjectphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<CInvoice> cInvoiceList;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser salesrepId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "c_incoterms_id", referencedColumnName = "c_incoterms_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CIncoterms cIncotermsId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_doctypetarget_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypetargetId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MPricelist mPricelistId;
    @JoinColumn(name = "dropship_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser dropshipUserId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "billto_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation billtoId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "dropship_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner dropshipBpartnerId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CPaymentterm cPaymenttermId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentmethod finPaymentmethodId;
    @JoinColumn(name = "fin_payment_priority_id", referencedColumnName = "fin_payment_priority_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentPriority finPaymentPriorityId;
    @JoinColumn(name = "m_shipper_id", referencedColumnName = "m_shipper_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MShipper mShipperId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCharge cChargeId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "delivery_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation deliveryLocationId;
    @JoinColumn(name = "dropship_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation dropshipLocationId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cOrderId")
    private List<COrderDiscount> cOrderDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<COrderlinetax> cOrderlinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<CCashline> cCashlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<FinPaymentSchedule> finPaymentScheduleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cOrderId")
    private List<COrdertax> cOrdertaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<MWhPeriodInvoiced> mWhPeriodInvoicedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cOrderId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderpoId")
    private List<CProjectline> cProjectlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<CProjectline> cProjectlineList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderId")
    private List<RRequestaction> rRequestactionList;

    public COrder() {
    }

    public COrder(String cOrderId) {
        this.cOrderId = cOrderId;
    }

    public COrder(String cOrderId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character issotrx, String documentno, String docstatus, String docaction, Character processed, Character isdelivered, Character isinvoiced, Character isprinted, Character isselected, Date dateordered, Date dateacct, Character isdiscountprinted, String paymentrule, String invoicerule, String deliveryrule, String freightcostrule, String deliveryviarule, String priorityrule, BigInteger totallines, BigInteger grandtotal, String posted, Character isselfservice) {
        this.cOrderId = cOrderId;
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
        this.isdelivered = isdelivered;
        this.isinvoiced = isinvoiced;
        this.isprinted = isprinted;
        this.isselected = isselected;
        this.dateordered = dateordered;
        this.dateacct = dateacct;
        this.isdiscountprinted = isdiscountprinted;
        this.paymentrule = paymentrule;
        this.invoicerule = invoicerule;
        this.deliveryrule = deliveryrule;
        this.freightcostrule = freightcostrule;
        this.deliveryviarule = deliveryviarule;
        this.priorityrule = priorityrule;
        this.totallines = totallines;
        this.grandtotal = grandtotal;
        this.posted = posted;
        this.isselfservice = isselfservice;
    }

    public String getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(String cOrderId) {
        this.cOrderId = cOrderId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIsdelivered() {
        return isdelivered;
    }

    public void setIsdelivered(Character isdelivered) {
        this.isdelivered = isdelivered;
    }

    public Character getIsinvoiced() {
        return isinvoiced;
    }

    public void setIsinvoiced(Character isinvoiced) {
        this.isinvoiced = isinvoiced;
    }

    public Character getIsprinted() {
        return isprinted;
    }

    public void setIsprinted(Character isprinted) {
        this.isprinted = isprinted;
    }

    public Character getIsselected() {
        return isselected;
    }

    public void setIsselected(Character isselected) {
        this.isselected = isselected;
    }

    public Date getDateordered() {
        return dateordered;
    }

    public void setDateordered(Date dateordered) {
        this.dateordered = dateordered;
    }

    public Date getDatepromised() {
        return datepromised;
    }

    public void setDatepromised(Date datepromised) {
        this.datepromised = datepromised;
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

    public String getPaymentrule() {
        return paymentrule;
    }

    public void setPaymentrule(String paymentrule) {
        this.paymentrule = paymentrule;
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

    public String getFreightcostrule() {
        return freightcostrule;
    }

    public void setFreightcostrule(String freightcostrule) {
        this.freightcostrule = freightcostrule;
    }

    public BigInteger getFreightamt() {
        return freightamt;
    }

    public void setFreightamt(BigInteger freightamt) {
        this.freightamt = freightamt;
    }

    public String getDeliveryviarule() {
        return deliveryviarule;
    }

    public void setDeliveryviarule(String deliveryviarule) {
        this.deliveryviarule = deliveryviarule;
    }

    public BigInteger getChargeamt() {
        return chargeamt;
    }

    public void setChargeamt(BigInteger chargeamt) {
        this.chargeamt = chargeamt;
    }

    public String getPriorityrule() {
        return priorityrule;
    }

    public void setPriorityrule(String priorityrule) {
        this.priorityrule = priorityrule;
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

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
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

    public String getDeliverynotes() {
        return deliverynotes;
    }

    public void setDeliverynotes(String deliverynotes) {
        this.deliverynotes = deliverynotes;
    }

    public String getIncotermsdescription() {
        return incotermsdescription;
    }

    public void setIncotermsdescription(String incotermsdescription) {
        this.incotermsdescription = incotermsdescription;
    }

    public Character getGeneratetemplate() {
        return generatetemplate;
    }

    public void setGeneratetemplate(Character generatetemplate) {
        this.generatetemplate = generatetemplate;
    }

    public Character getCopyfrompo() {
        return copyfrompo;
    }

    public void setCopyfrompo(Character copyfrompo) {
        this.copyfrompo = copyfrompo;
    }

    @XmlTransient
    public List<CProjectphase> getCProjectphaseList() {
        return cProjectphaseList;
    }

    public void setCProjectphaseList(List<CProjectphase> cProjectphaseList) {
        this.cProjectphaseList = cProjectphaseList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
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

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public CIncoterms getCIncotermsId() {
        return cIncotermsId;
    }

    public void setCIncotermsId(CIncoterms cIncotermsId) {
        this.cIncotermsId = cIncotermsId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CDoctype getCDoctypetargetId() {
        return cDoctypetargetId;
    }

    public void setCDoctypetargetId(CDoctype cDoctypetargetId) {
        this.cDoctypetargetId = cDoctypetargetId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public AdUser getDropshipUserId() {
        return dropshipUserId;
    }

    public void setDropshipUserId(AdUser dropshipUserId) {
        this.dropshipUserId = dropshipUserId;
    }

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CBpartnerLocation getBilltoId() {
        return billtoId;
    }

    public void setBilltoId(CBpartnerLocation billtoId) {
        this.billtoId = billtoId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CBpartner getDropshipBpartnerId() {
        return dropshipBpartnerId;
    }

    public void setDropshipBpartnerId(CBpartner dropshipBpartnerId) {
        this.dropshipBpartnerId = dropshipBpartnerId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public FinPaymentmethod getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(FinPaymentmethod finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    public FinPaymentPriority getFinPaymentPriorityId() {
        return finPaymentPriorityId;
    }

    public void setFinPaymentPriorityId(FinPaymentPriority finPaymentPriorityId) {
        this.finPaymentPriorityId = finPaymentPriorityId;
    }

    public MShipper getMShipperId() {
        return mShipperId;
    }

    public void setMShipperId(MShipper mShipperId) {
        this.mShipperId = mShipperId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    public CCharge getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(CCharge cChargeId) {
        this.cChargeId = cChargeId;
    }

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public CBpartnerLocation getDeliveryLocationId() {
        return deliveryLocationId;
    }

    public void setDeliveryLocationId(CBpartnerLocation deliveryLocationId) {
        this.deliveryLocationId = deliveryLocationId;
    }

    public CBpartnerLocation getDropshipLocationId() {
        return dropshipLocationId;
    }

    public void setDropshipLocationId(CBpartnerLocation dropshipLocationId) {
        this.dropshipLocationId = dropshipLocationId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<COrderDiscount> getCOrderDiscountList() {
        return cOrderDiscountList;
    }

    public void setCOrderDiscountList(List<COrderDiscount> cOrderDiscountList) {
        this.cOrderDiscountList = cOrderDiscountList;
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
    public List<FinPaymentSchedule> getFinPaymentScheduleList() {
        return finPaymentScheduleList;
    }

    public void setFinPaymentScheduleList(List<FinPaymentSchedule> finPaymentScheduleList) {
        this.finPaymentScheduleList = finPaymentScheduleList;
    }

    @XmlTransient
    public List<COrdertax> getCOrdertaxList() {
        return cOrdertaxList;
    }

    public void setCOrdertaxList(List<COrdertax> cOrdertaxList) {
        this.cOrdertaxList = cOrdertaxList;
    }

    @XmlTransient
    public List<MWhPeriodInvoiced> getMWhPeriodInvoicedList() {
        return mWhPeriodInvoicedList;
    }

    public void setMWhPeriodInvoicedList(List<MWhPeriodInvoiced> mWhPeriodInvoicedList) {
        this.mWhPeriodInvoicedList = mWhPeriodInvoicedList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<CProjectline> getCProjectlineList() {
        return cProjectlineList;
    }

    public void setCProjectlineList(List<CProjectline> cProjectlineList) {
        this.cProjectlineList = cProjectlineList;
    }

    @XmlTransient
    public List<CProjectline> getCProjectlineList1() {
        return cProjectlineList1;
    }

    public void setCProjectlineList1(List<CProjectline> cProjectlineList1) {
        this.cProjectlineList1 = cProjectlineList1;
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
        hash += (cOrderId != null ? cOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof COrder)) {
            return false;
        }
        COrder other = (COrder) object;
        if ((this.cOrderId == null && other.cOrderId != null) || (this.cOrderId != null && !this.cOrderId.equals(other.cOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.COrder[ cOrderId=" + cOrderId + " ]";
    }
    
}
