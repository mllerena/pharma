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
@Table(name = "m_inout")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MInout.findAll", query = "SELECT m FROM MInout m"),
    @NamedQuery(name = "MInout.findByMInoutId", query = "SELECT m FROM MInout m WHERE m.mInoutId = :mInoutId"),
    @NamedQuery(name = "MInout.findByIsactive", query = "SELECT m FROM MInout m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MInout.findByCreated", query = "SELECT m FROM MInout m WHERE m.created = :created"),
    @NamedQuery(name = "MInout.findByCreatedby", query = "SELECT m FROM MInout m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MInout.findByUpdated", query = "SELECT m FROM MInout m WHERE m.updated = :updated"),
    @NamedQuery(name = "MInout.findByUpdatedby", query = "SELECT m FROM MInout m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MInout.findByIssotrx", query = "SELECT m FROM MInout m WHERE m.issotrx = :issotrx"),
    @NamedQuery(name = "MInout.findByDocumentno", query = "SELECT m FROM MInout m WHERE m.documentno = :documentno"),
    @NamedQuery(name = "MInout.findByDocaction", query = "SELECT m FROM MInout m WHERE m.docaction = :docaction"),
    @NamedQuery(name = "MInout.findByDocstatus", query = "SELECT m FROM MInout m WHERE m.docstatus = :docstatus"),
    @NamedQuery(name = "MInout.findByPosted", query = "SELECT m FROM MInout m WHERE m.posted = :posted"),
    @NamedQuery(name = "MInout.findByProcessing", query = "SELECT m FROM MInout m WHERE m.processing = :processing"),
    @NamedQuery(name = "MInout.findByProcessed", query = "SELECT m FROM MInout m WHERE m.processed = :processed"),
    @NamedQuery(name = "MInout.findByDescription", query = "SELECT m FROM MInout m WHERE m.description = :description"),
    @NamedQuery(name = "MInout.findByDateordered", query = "SELECT m FROM MInout m WHERE m.dateordered = :dateordered"),
    @NamedQuery(name = "MInout.findByIsprinted", query = "SELECT m FROM MInout m WHERE m.isprinted = :isprinted"),
    @NamedQuery(name = "MInout.findByMovementtype", query = "SELECT m FROM MInout m WHERE m.movementtype = :movementtype"),
    @NamedQuery(name = "MInout.findByMovementdate", query = "SELECT m FROM MInout m WHERE m.movementdate = :movementdate"),
    @NamedQuery(name = "MInout.findByDateacct", query = "SELECT m FROM MInout m WHERE m.dateacct = :dateacct"),
    @NamedQuery(name = "MInout.findByPoreference", query = "SELECT m FROM MInout m WHERE m.poreference = :poreference"),
    @NamedQuery(name = "MInout.findByDeliveryrule", query = "SELECT m FROM MInout m WHERE m.deliveryrule = :deliveryrule"),
    @NamedQuery(name = "MInout.findByFreightcostrule", query = "SELECT m FROM MInout m WHERE m.freightcostrule = :freightcostrule"),
    @NamedQuery(name = "MInout.findByFreightamt", query = "SELECT m FROM MInout m WHERE m.freightamt = :freightamt"),
    @NamedQuery(name = "MInout.findByDeliveryviarule", query = "SELECT m FROM MInout m WHERE m.deliveryviarule = :deliveryviarule"),
    @NamedQuery(name = "MInout.findByChargeamt", query = "SELECT m FROM MInout m WHERE m.chargeamt = :chargeamt"),
    @NamedQuery(name = "MInout.findByPriorityrule", query = "SELECT m FROM MInout m WHERE m.priorityrule = :priorityrule"),
    @NamedQuery(name = "MInout.findByDateprinted", query = "SELECT m FROM MInout m WHERE m.dateprinted = :dateprinted"),
    @NamedQuery(name = "MInout.findByCreatefrom", query = "SELECT m FROM MInout m WHERE m.createfrom = :createfrom"),
    @NamedQuery(name = "MInout.findByGenerateto", query = "SELECT m FROM MInout m WHERE m.generateto = :generateto"),
    @NamedQuery(name = "MInout.findByNopackages", query = "SELECT m FROM MInout m WHERE m.nopackages = :nopackages"),
    @NamedQuery(name = "MInout.findByPickdate", query = "SELECT m FROM MInout m WHERE m.pickdate = :pickdate"),
    @NamedQuery(name = "MInout.findByShipdate", query = "SELECT m FROM MInout m WHERE m.shipdate = :shipdate"),
    @NamedQuery(name = "MInout.findByTrackingno", query = "SELECT m FROM MInout m WHERE m.trackingno = :trackingno"),
    @NamedQuery(name = "MInout.findByUser1Id", query = "SELECT m FROM MInout m WHERE m.user1Id = :user1Id"),
    @NamedQuery(name = "MInout.findByUser2Id", query = "SELECT m FROM MInout m WHERE m.user2Id = :user2Id"),
    @NamedQuery(name = "MInout.findByUpdatelines", query = "SELECT m FROM MInout m WHERE m.updatelines = :updatelines"),
    @NamedQuery(name = "MInout.findByIslogistic", query = "SELECT m FROM MInout m WHERE m.islogistic = :islogistic"),
    @NamedQuery(name = "MInout.findByGeneratelines", query = "SELECT m FROM MInout m WHERE m.generatelines = :generatelines"),
    @NamedQuery(name = "MInout.findByCalculateFreight", query = "SELECT m FROM MInout m WHERE m.calculateFreight = :calculateFreight")})
public class MInout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_inout_id")
    private String mInoutId;
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
    @Column(name = "docaction")
    private String docaction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docstatus")
    private String docstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "dateordered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateordered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isprinted")
    private Character isprinted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "movementtype")
    private String movementtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementdate;
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
    @Column(name = "dateprinted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateprinted;
    @Column(name = "createfrom")
    private Character createfrom;
    @Column(name = "generateto")
    private Character generateto;
    @Column(name = "nopackages")
    private Long nopackages;
    @Column(name = "pickdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickdate;
    @Column(name = "shipdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipdate;
    @Size(max = 60)
    @Column(name = "trackingno")
    private String trackingno;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Column(name = "updatelines")
    private Character updatelines;
    @Column(name = "islogistic")
    private Character islogistic;
    @Column(name = "generatelines")
    private Character generatelines;
    @Column(name = "calculate_freight")
    private Character calculateFreight;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mInoutId")
    private List<MInoutline> mInoutlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "m_shipper_id", referencedColumnName = "m_shipper_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MShipper mShipperId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser salesrepId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;
    @JoinColumn(name = "delivery_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation deliveryLocationId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "m_freightcategory_id", referencedColumnName = "m_freightcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MFreightcategory mFreightcategoryId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCharge cChargeId;
    @JoinColumn(name = "freight_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency freightCurrencyId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;

    public MInout() {
    }

    public MInout(String mInoutId) {
        this.mInoutId = mInoutId;
    }

    public MInout(String mInoutId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character issotrx, String documentno, String docaction, String docstatus, String posted, Character processed, Character isprinted, String movementtype, Date movementdate, Date dateacct, String deliveryrule, String freightcostrule, String deliveryviarule, String priorityrule) {
        this.mInoutId = mInoutId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.issotrx = issotrx;
        this.documentno = documentno;
        this.docaction = docaction;
        this.docstatus = docstatus;
        this.posted = posted;
        this.processed = processed;
        this.isprinted = isprinted;
        this.movementtype = movementtype;
        this.movementdate = movementdate;
        this.dateacct = dateacct;
        this.deliveryrule = deliveryrule;
        this.freightcostrule = freightcostrule;
        this.deliveryviarule = deliveryviarule;
        this.priorityrule = priorityrule;
    }

    public String getMInoutId() {
        return mInoutId;
    }

    public void setMInoutId(String mInoutId) {
        this.mInoutId = mInoutId;
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

    public String getDocaction() {
        return docaction;
    }

    public void setDocaction(String docaction) {
        this.docaction = docaction;
    }

    public String getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(String docstatus) {
        this.docstatus = docstatus;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
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

    public Date getDateordered() {
        return dateordered;
    }

    public void setDateordered(Date dateordered) {
        this.dateordered = dateordered;
    }

    public Character getIsprinted() {
        return isprinted;
    }

    public void setIsprinted(Character isprinted) {
        this.isprinted = isprinted;
    }

    public String getMovementtype() {
        return movementtype;
    }

    public void setMovementtype(String movementtype) {
        this.movementtype = movementtype;
    }

    public Date getMovementdate() {
        return movementdate;
    }

    public void setMovementdate(Date movementdate) {
        this.movementdate = movementdate;
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

    public Date getDateprinted() {
        return dateprinted;
    }

    public void setDateprinted(Date dateprinted) {
        this.dateprinted = dateprinted;
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

    public Long getNopackages() {
        return nopackages;
    }

    public void setNopackages(Long nopackages) {
        this.nopackages = nopackages;
    }

    public Date getPickdate() {
        return pickdate;
    }

    public void setPickdate(Date pickdate) {
        this.pickdate = pickdate;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public String getTrackingno() {
        return trackingno;
    }

    public void setTrackingno(String trackingno) {
        this.trackingno = trackingno;
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

    public Character getUpdatelines() {
        return updatelines;
    }

    public void setUpdatelines(Character updatelines) {
        this.updatelines = updatelines;
    }

    public Character getIslogistic() {
        return islogistic;
    }

    public void setIslogistic(Character islogistic) {
        this.islogistic = islogistic;
    }

    public Character getGeneratelines() {
        return generatelines;
    }

    public void setGeneratelines(Character generatelines) {
        this.generatelines = generatelines;
    }

    public Character getCalculateFreight() {
        return calculateFreight;
    }

    public void setCalculateFreight(Character calculateFreight) {
        this.calculateFreight = calculateFreight;
    }

    @XmlTransient
    public List<MInoutline> getMInoutlineList() {
        return mInoutlineList;
    }

    public void setMInoutlineList(List<MInoutline> mInoutlineList) {
        this.mInoutlineList = mInoutlineList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public MShipper getMShipperId() {
        return mShipperId;
    }

    public void setMShipperId(MShipper mShipperId) {
        this.mShipperId = mShipperId;
    }

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    public CBpartnerLocation getDeliveryLocationId() {
        return deliveryLocationId;
    }

    public void setDeliveryLocationId(CBpartnerLocation deliveryLocationId) {
        this.deliveryLocationId = deliveryLocationId;
    }

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public MFreightcategory getMFreightcategoryId() {
        return mFreightcategoryId;
    }

    public void setMFreightcategoryId(MFreightcategory mFreightcategoryId) {
        this.mFreightcategoryId = mFreightcategoryId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    public CCharge getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(CCharge cChargeId) {
        this.cChargeId = cChargeId;
    }

    public CCurrency getFreightCurrencyId() {
        return freightCurrencyId;
    }

    public void setFreightCurrencyId(CCurrency freightCurrencyId) {
        this.freightCurrencyId = freightCurrencyId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mInoutId != null ? mInoutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MInout)) {
            return false;
        }
        MInout other = (MInout) object;
        if ((this.mInoutId == null && other.mInoutId != null) || (this.mInoutId != null && !this.mInoutId.equals(other.mInoutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MInout[ mInoutId=" + mInoutId + " ]";
    }
    
}
