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
@Table(name = "c_orderline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "COrderline.findAll", query = "SELECT c FROM COrderline c"),
    @NamedQuery(name = "COrderline.findByCOrderlineId", query = "SELECT c FROM COrderline c WHERE c.cOrderlineId = :cOrderlineId"),
    @NamedQuery(name = "COrderline.findByIsactive", query = "SELECT c FROM COrderline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "COrderline.findByCreated", query = "SELECT c FROM COrderline c WHERE c.created = :created"),
    @NamedQuery(name = "COrderline.findByCreatedby", query = "SELECT c FROM COrderline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "COrderline.findByUpdated", query = "SELECT c FROM COrderline c WHERE c.updated = :updated"),
    @NamedQuery(name = "COrderline.findByUpdatedby", query = "SELECT c FROM COrderline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "COrderline.findByLine", query = "SELECT c FROM COrderline c WHERE c.line = :line"),
    @NamedQuery(name = "COrderline.findByDateordered", query = "SELECT c FROM COrderline c WHERE c.dateordered = :dateordered"),
    @NamedQuery(name = "COrderline.findByDatepromised", query = "SELECT c FROM COrderline c WHERE c.datepromised = :datepromised"),
    @NamedQuery(name = "COrderline.findByDatedelivered", query = "SELECT c FROM COrderline c WHERE c.datedelivered = :datedelivered"),
    @NamedQuery(name = "COrderline.findByDateinvoiced", query = "SELECT c FROM COrderline c WHERE c.dateinvoiced = :dateinvoiced"),
    @NamedQuery(name = "COrderline.findByDescription", query = "SELECT c FROM COrderline c WHERE c.description = :description"),
    @NamedQuery(name = "COrderline.findByDirectship", query = "SELECT c FROM COrderline c WHERE c.directship = :directship"),
    @NamedQuery(name = "COrderline.findByQtyordered", query = "SELECT c FROM COrderline c WHERE c.qtyordered = :qtyordered"),
    @NamedQuery(name = "COrderline.findByQtyreserved", query = "SELECT c FROM COrderline c WHERE c.qtyreserved = :qtyreserved"),
    @NamedQuery(name = "COrderline.findByQtydelivered", query = "SELECT c FROM COrderline c WHERE c.qtydelivered = :qtydelivered"),
    @NamedQuery(name = "COrderline.findByQtyinvoiced", query = "SELECT c FROM COrderline c WHERE c.qtyinvoiced = :qtyinvoiced"),
    @NamedQuery(name = "COrderline.findByPricelist", query = "SELECT c FROM COrderline c WHERE c.pricelist = :pricelist"),
    @NamedQuery(name = "COrderline.findByPriceactual", query = "SELECT c FROM COrderline c WHERE c.priceactual = :priceactual"),
    @NamedQuery(name = "COrderline.findByPricelimit", query = "SELECT c FROM COrderline c WHERE c.pricelimit = :pricelimit"),
    @NamedQuery(name = "COrderline.findByLinenetamt", query = "SELECT c FROM COrderline c WHERE c.linenetamt = :linenetamt"),
    @NamedQuery(name = "COrderline.findByDiscount", query = "SELECT c FROM COrderline c WHERE c.discount = :discount"),
    @NamedQuery(name = "COrderline.findByFreightamt", query = "SELECT c FROM COrderline c WHERE c.freightamt = :freightamt"),
    @NamedQuery(name = "COrderline.findByChargeamt", query = "SELECT c FROM COrderline c WHERE c.chargeamt = :chargeamt"),
    @NamedQuery(name = "COrderline.findByIsdescription", query = "SELECT c FROM COrderline c WHERE c.isdescription = :isdescription"),
    @NamedQuery(name = "COrderline.findByQuantityorder", query = "SELECT c FROM COrderline c WHERE c.quantityorder = :quantityorder"),
    @NamedQuery(name = "COrderline.findByPricestd", query = "SELECT c FROM COrderline c WHERE c.pricestd = :pricestd"),
    @NamedQuery(name = "COrderline.findByCancelpricead", query = "SELECT c FROM COrderline c WHERE c.cancelpricead = :cancelpricead"),
    @NamedQuery(name = "COrderline.findByIseditlinenetamt", query = "SELECT c FROM COrderline c WHERE c.iseditlinenetamt = :iseditlinenetamt"),
    @NamedQuery(name = "COrderline.findByTaxbaseamt", query = "SELECT c FROM COrderline c WHERE c.taxbaseamt = :taxbaseamt")})
public class COrderline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_orderline_id")
    private String cOrderlineId;
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
    @Column(name = "line")
    private long line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateordered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateordered;
    @Column(name = "datepromised")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepromised;
    @Column(name = "datedelivered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedelivered;
    @Column(name = "dateinvoiced")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinvoiced;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "directship")
    private Character directship;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyordered")
    private BigInteger qtyordered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyreserved")
    private BigInteger qtyreserved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtydelivered")
    private BigInteger qtydelivered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyinvoiced")
    private BigInteger qtyinvoiced;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricelist")
    private BigInteger pricelist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priceactual")
    private BigInteger priceactual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricelimit")
    private BigInteger pricelimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "linenetamt")
    private BigInteger linenetamt;
    @Column(name = "discount")
    private BigInteger discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "freightamt")
    private BigInteger freightamt;
    @Column(name = "chargeamt")
    private BigInteger chargeamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdescription")
    private Character isdescription;
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricestd")
    private BigInteger pricestd;
    @Column(name = "cancelpricead")
    private Character cancelpricead;
    @Column(name = "iseditlinenetamt")
    private Character iseditlinenetamt;
    @Column(name = "taxbaseamt")
    private BigInteger taxbaseamt;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderlineId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cOrderlineId")
    private List<MRequisitionorder> mRequisitionorderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cOrderlineId")
    private List<COrderlineOffer> cOrderlineOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderlineId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderlineId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cOrderlineId")
    private List<COrderlinetax> cOrderlinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderlineId")
    private List<CCommissiondetail> cCommissiondetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderlineId")
    private List<CInvoiceline> cInvoicelineList;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCharge cChargeId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "m_shipper_id", referencedColumnName = "m_shipper_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MShipper mShipperId;
    @JoinColumn(name = "s_resourceassignment_id", referencedColumnName = "s_resourceassignment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private SResourceassignment sResourceassignmentId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private COrder cOrderId;
    @JoinColumn(name = "c_order_discount_id", referencedColumnName = "c_order_discount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderDiscount cOrderDiscountId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "refOrderlineId")
    private List<COrderline> cOrderlineList;
    @JoinColumn(name = "ref_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderline refOrderlineId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTax cTaxId;
    @JoinColumn(name = "m_offer_id", referencedColumnName = "m_offer_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MOffer mOfferId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderlineId")
    private List<MrpRunProductionline> mrpRunProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cOrderlineId")
    private List<MMatchpo> mMatchpoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cOrderlineId")
    private List<MInoutline> mInoutlineList;

    public COrderline() {
    }

    public COrderline(String cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
    }

    public COrderline(String cOrderlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, Date dateordered, Character directship, BigInteger qtyordered, BigInteger qtyreserved, BigInteger qtydelivered, BigInteger qtyinvoiced, BigInteger pricelist, BigInteger priceactual, BigInteger pricelimit, BigInteger linenetamt, BigInteger freightamt, Character isdescription, BigInteger pricestd) {
        this.cOrderlineId = cOrderlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.dateordered = dateordered;
        this.directship = directship;
        this.qtyordered = qtyordered;
        this.qtyreserved = qtyreserved;
        this.qtydelivered = qtydelivered;
        this.qtyinvoiced = qtyinvoiced;
        this.pricelist = pricelist;
        this.priceactual = priceactual;
        this.pricelimit = pricelimit;
        this.linenetamt = linenetamt;
        this.freightamt = freightamt;
        this.isdescription = isdescription;
        this.pricestd = pricestd;
    }

    public String getCOrderlineId() {
        return cOrderlineId;
    }

    public void setCOrderlineId(String cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
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

    public Date getDatedelivered() {
        return datedelivered;
    }

    public void setDatedelivered(Date datedelivered) {
        this.datedelivered = datedelivered;
    }

    public Date getDateinvoiced() {
        return dateinvoiced;
    }

    public void setDateinvoiced(Date dateinvoiced) {
        this.dateinvoiced = dateinvoiced;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getDirectship() {
        return directship;
    }

    public void setDirectship(Character directship) {
        this.directship = directship;
    }

    public BigInteger getQtyordered() {
        return qtyordered;
    }

    public void setQtyordered(BigInteger qtyordered) {
        this.qtyordered = qtyordered;
    }

    public BigInteger getQtyreserved() {
        return qtyreserved;
    }

    public void setQtyreserved(BigInteger qtyreserved) {
        this.qtyreserved = qtyreserved;
    }

    public BigInteger getQtydelivered() {
        return qtydelivered;
    }

    public void setQtydelivered(BigInteger qtydelivered) {
        this.qtydelivered = qtydelivered;
    }

    public BigInteger getQtyinvoiced() {
        return qtyinvoiced;
    }

    public void setQtyinvoiced(BigInteger qtyinvoiced) {
        this.qtyinvoiced = qtyinvoiced;
    }

    public BigInteger getPricelist() {
        return pricelist;
    }

    public void setPricelist(BigInteger pricelist) {
        this.pricelist = pricelist;
    }

    public BigInteger getPriceactual() {
        return priceactual;
    }

    public void setPriceactual(BigInteger priceactual) {
        this.priceactual = priceactual;
    }

    public BigInteger getPricelimit() {
        return pricelimit;
    }

    public void setPricelimit(BigInteger pricelimit) {
        this.pricelimit = pricelimit;
    }

    public BigInteger getLinenetamt() {
        return linenetamt;
    }

    public void setLinenetamt(BigInteger linenetamt) {
        this.linenetamt = linenetamt;
    }

    public BigInteger getDiscount() {
        return discount;
    }

    public void setDiscount(BigInteger discount) {
        this.discount = discount;
    }

    public BigInteger getFreightamt() {
        return freightamt;
    }

    public void setFreightamt(BigInteger freightamt) {
        this.freightamt = freightamt;
    }

    public BigInteger getChargeamt() {
        return chargeamt;
    }

    public void setChargeamt(BigInteger chargeamt) {
        this.chargeamt = chargeamt;
    }

    public Character getIsdescription() {
        return isdescription;
    }

    public void setIsdescription(Character isdescription) {
        this.isdescription = isdescription;
    }

    public BigInteger getQuantityorder() {
        return quantityorder;
    }

    public void setQuantityorder(BigInteger quantityorder) {
        this.quantityorder = quantityorder;
    }

    public BigInteger getPricestd() {
        return pricestd;
    }

    public void setPricestd(BigInteger pricestd) {
        this.pricestd = pricestd;
    }

    public Character getCancelpricead() {
        return cancelpricead;
    }

    public void setCancelpricead(Character cancelpricead) {
        this.cancelpricead = cancelpricead;
    }

    public Character getIseditlinenetamt() {
        return iseditlinenetamt;
    }

    public void setIseditlinenetamt(Character iseditlinenetamt) {
        this.iseditlinenetamt = iseditlinenetamt;
    }

    public BigInteger getTaxbaseamt() {
        return taxbaseamt;
    }

    public void setTaxbaseamt(BigInteger taxbaseamt) {
        this.taxbaseamt = taxbaseamt;
    }

    @XmlTransient
    public List<STimeexpenseline> getSTimeexpenselineList() {
        return sTimeexpenselineList;
    }

    public void setSTimeexpenselineList(List<STimeexpenseline> sTimeexpenselineList) {
        this.sTimeexpenselineList = sTimeexpenselineList;
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
    public List<MrpRunPurchaseline> getMrpRunPurchaselineList() {
        return mrpRunPurchaselineList;
    }

    public void setMrpRunPurchaselineList(List<MrpRunPurchaseline> mrpRunPurchaselineList) {
        this.mrpRunPurchaselineList = mrpRunPurchaselineList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<COrderlinetax> getCOrderlinetaxList() {
        return cOrderlinetaxList;
    }

    public void setCOrderlinetaxList(List<COrderlinetax> cOrderlinetaxList) {
        this.cOrderlinetaxList = cOrderlinetaxList;
    }

    @XmlTransient
    public List<CCommissiondetail> getCCommissiondetailList() {
        return cCommissiondetailList;
    }

    public void setCCommissiondetailList(List<CCommissiondetail> cCommissiondetailList) {
        this.cCommissiondetailList = cCommissiondetailList;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
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

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public CCharge getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(CCharge cChargeId) {
        this.cChargeId = cChargeId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public MShipper getMShipperId() {
        return mShipperId;
    }

    public void setMShipperId(MShipper mShipperId) {
        this.mShipperId = mShipperId;
    }

    public SResourceassignment getSResourceassignmentId() {
        return sResourceassignmentId;
    }

    public void setSResourceassignmentId(SResourceassignment sResourceassignmentId) {
        this.sResourceassignmentId = sResourceassignmentId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public COrderDiscount getCOrderDiscountId() {
        return cOrderDiscountId;
    }

    public void setCOrderDiscountId(COrderDiscount cOrderDiscountId) {
        this.cOrderDiscountId = cOrderDiscountId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    public COrderline getRefOrderlineId() {
        return refOrderlineId;
    }

    public void setRefOrderlineId(COrderline refOrderlineId) {
        this.refOrderlineId = refOrderlineId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public MOffer getMOfferId() {
        return mOfferId;
    }

    public void setMOfferId(MOffer mOfferId) {
        this.mOfferId = mOfferId;
    }

    public MProductUom getMProductUomId() {
        return mProductUomId;
    }

    public void setMProductUomId(MProductUom mProductUomId) {
        this.mProductUomId = mProductUomId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    @XmlTransient
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
    }

    @XmlTransient
    public List<MMatchpo> getMMatchpoList() {
        return mMatchpoList;
    }

    public void setMMatchpoList(List<MMatchpo> mMatchpoList) {
        this.mMatchpoList = mMatchpoList;
    }

    @XmlTransient
    public List<MInoutline> getMInoutlineList() {
        return mInoutlineList;
    }

    public void setMInoutlineList(List<MInoutline> mInoutlineList) {
        this.mInoutlineList = mInoutlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cOrderlineId != null ? cOrderlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof COrderline)) {
            return false;
        }
        COrderline other = (COrderline) object;
        if ((this.cOrderlineId == null && other.cOrderlineId != null) || (this.cOrderlineId != null && !this.cOrderlineId.equals(other.cOrderlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.COrderline[ cOrderlineId=" + cOrderlineId + " ]";
    }
    
}
