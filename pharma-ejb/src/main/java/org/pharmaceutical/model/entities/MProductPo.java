/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_product_po")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductPo.findAll", query = "SELECT m FROM MProductPo m"),
    @NamedQuery(name = "MProductPo.findByMProductPoId", query = "SELECT m FROM MProductPo m WHERE m.mProductPoId = :mProductPoId"),
    @NamedQuery(name = "MProductPo.findByIsactive", query = "SELECT m FROM MProductPo m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductPo.findByCreated", query = "SELECT m FROM MProductPo m WHERE m.created = :created"),
    @NamedQuery(name = "MProductPo.findByCreatedby", query = "SELECT m FROM MProductPo m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductPo.findByUpdated", query = "SELECT m FROM MProductPo m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductPo.findByUpdatedby", query = "SELECT m FROM MProductPo m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductPo.findByIscurrentvendor", query = "SELECT m FROM MProductPo m WHERE m.iscurrentvendor = :iscurrentvendor"),
    @NamedQuery(name = "MProductPo.findByPricelist", query = "SELECT m FROM MProductPo m WHERE m.pricelist = :pricelist"),
    @NamedQuery(name = "MProductPo.findByPricepo", query = "SELECT m FROM MProductPo m WHERE m.pricepo = :pricepo"),
    @NamedQuery(name = "MProductPo.findByPriceeffective", query = "SELECT m FROM MProductPo m WHERE m.priceeffective = :priceeffective"),
    @NamedQuery(name = "MProductPo.findByPricelastpo", query = "SELECT m FROM MProductPo m WHERE m.pricelastpo = :pricelastpo"),
    @NamedQuery(name = "MProductPo.findByPricelastinv", query = "SELECT m FROM MProductPo m WHERE m.pricelastinv = :pricelastinv"),
    @NamedQuery(name = "MProductPo.findByVendorproductno", query = "SELECT m FROM MProductPo m WHERE m.vendorproductno = :vendorproductno"),
    @NamedQuery(name = "MProductPo.findByUpc", query = "SELECT m FROM MProductPo m WHERE m.upc = :upc"),
    @NamedQuery(name = "MProductPo.findByVendorcategory", query = "SELECT m FROM MProductPo m WHERE m.vendorcategory = :vendorcategory"),
    @NamedQuery(name = "MProductPo.findByDiscontinued", query = "SELECT m FROM MProductPo m WHERE m.discontinued = :discontinued"),
    @NamedQuery(name = "MProductPo.findByDiscontinuedby", query = "SELECT m FROM MProductPo m WHERE m.discontinuedby = :discontinuedby"),
    @NamedQuery(name = "MProductPo.findByOrderMin", query = "SELECT m FROM MProductPo m WHERE m.orderMin = :orderMin"),
    @NamedQuery(name = "MProductPo.findByOrderPack", query = "SELECT m FROM MProductPo m WHERE m.orderPack = :orderPack"),
    @NamedQuery(name = "MProductPo.findByCostperorder", query = "SELECT m FROM MProductPo m WHERE m.costperorder = :costperorder"),
    @NamedQuery(name = "MProductPo.findByDeliverytimePromised", query = "SELECT m FROM MProductPo m WHERE m.deliverytimePromised = :deliverytimePromised"),
    @NamedQuery(name = "MProductPo.findByDeliverytimeActual", query = "SELECT m FROM MProductPo m WHERE m.deliverytimeActual = :deliverytimeActual"),
    @NamedQuery(name = "MProductPo.findByQualityrating", query = "SELECT m FROM MProductPo m WHERE m.qualityrating = :qualityrating"),
    @NamedQuery(name = "MProductPo.findByRoyaltyamt", query = "SELECT m FROM MProductPo m WHERE m.royaltyamt = :royaltyamt"),
    @NamedQuery(name = "MProductPo.findByManufacturer", query = "SELECT m FROM MProductPo m WHERE m.manufacturer = :manufacturer"),
    @NamedQuery(name = "MProductPo.findByCapacity", query = "SELECT m FROM MProductPo m WHERE m.capacity = :capacity"),
    @NamedQuery(name = "MProductPo.findByQtystd", query = "SELECT m FROM MProductPo m WHERE m.qtystd = :qtystd"),
    @NamedQuery(name = "MProductPo.findByQtytype", query = "SELECT m FROM MProductPo m WHERE m.qtytype = :qtytype")})
public class MProductPo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_product_po_id")
    private String mProductPoId;
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
    @Column(name = "iscurrentvendor")
    private Character iscurrentvendor;
    @Column(name = "pricelist")
    private BigInteger pricelist;
    @Column(name = "pricepo")
    private BigInteger pricepo;
    @Column(name = "priceeffective")
    @Temporal(TemporalType.TIMESTAMP)
    private Date priceeffective;
    @Column(name = "pricelastpo")
    private BigInteger pricelastpo;
    @Column(name = "pricelastinv")
    private BigInteger pricelastinv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "vendorproductno")
    private String vendorproductno;
    @Size(max = 20)
    @Column(name = "upc")
    private String upc;
    @Size(max = 30)
    @Column(name = "vendorcategory")
    private String vendorcategory;
    @Column(name = "discontinued")
    private Character discontinued;
    @Column(name = "discontinuedby")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discontinuedby;
    @Column(name = "order_min")
    private BigInteger orderMin;
    @Column(name = "order_pack")
    private BigInteger orderPack;
    @Column(name = "costperorder")
    private BigInteger costperorder;
    @Column(name = "deliverytime_promised")
    private Long deliverytimePromised;
    @Column(name = "deliverytime_actual")
    private Long deliverytimeActual;
    @Column(name = "qualityrating")
    private BigInteger qualityrating;
    @Column(name = "royaltyamt")
    private BigInteger royaltyamt;
    @Size(max = 30)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "capacity")
    private BigInteger capacity;
    @Column(name = "qtystd")
    private BigInteger qtystd;
    @Size(max = 60)
    @Column(name = "qtytype")
    private String qtytype;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public MProductPo() {
    }

    public MProductPo(String mProductPoId) {
        this.mProductPoId = mProductPoId;
    }

    public MProductPo(String mProductPoId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character iscurrentvendor, String vendorproductno) {
        this.mProductPoId = mProductPoId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.iscurrentvendor = iscurrentvendor;
        this.vendorproductno = vendorproductno;
    }

    public String getMProductPoId() {
        return mProductPoId;
    }

    public void setMProductPoId(String mProductPoId) {
        this.mProductPoId = mProductPoId;
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

    public Character getIscurrentvendor() {
        return iscurrentvendor;
    }

    public void setIscurrentvendor(Character iscurrentvendor) {
        this.iscurrentvendor = iscurrentvendor;
    }

    public BigInteger getPricelist() {
        return pricelist;
    }

    public void setPricelist(BigInteger pricelist) {
        this.pricelist = pricelist;
    }

    public BigInteger getPricepo() {
        return pricepo;
    }

    public void setPricepo(BigInteger pricepo) {
        this.pricepo = pricepo;
    }

    public Date getPriceeffective() {
        return priceeffective;
    }

    public void setPriceeffective(Date priceeffective) {
        this.priceeffective = priceeffective;
    }

    public BigInteger getPricelastpo() {
        return pricelastpo;
    }

    public void setPricelastpo(BigInteger pricelastpo) {
        this.pricelastpo = pricelastpo;
    }

    public BigInteger getPricelastinv() {
        return pricelastinv;
    }

    public void setPricelastinv(BigInteger pricelastinv) {
        this.pricelastinv = pricelastinv;
    }

    public String getVendorproductno() {
        return vendorproductno;
    }

    public void setVendorproductno(String vendorproductno) {
        this.vendorproductno = vendorproductno;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getVendorcategory() {
        return vendorcategory;
    }

    public void setVendorcategory(String vendorcategory) {
        this.vendorcategory = vendorcategory;
    }

    public Character getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Character discontinued) {
        this.discontinued = discontinued;
    }

    public Date getDiscontinuedby() {
        return discontinuedby;
    }

    public void setDiscontinuedby(Date discontinuedby) {
        this.discontinuedby = discontinuedby;
    }

    public BigInteger getOrderMin() {
        return orderMin;
    }

    public void setOrderMin(BigInteger orderMin) {
        this.orderMin = orderMin;
    }

    public BigInteger getOrderPack() {
        return orderPack;
    }

    public void setOrderPack(BigInteger orderPack) {
        this.orderPack = orderPack;
    }

    public BigInteger getCostperorder() {
        return costperorder;
    }

    public void setCostperorder(BigInteger costperorder) {
        this.costperorder = costperorder;
    }

    public Long getDeliverytimePromised() {
        return deliverytimePromised;
    }

    public void setDeliverytimePromised(Long deliverytimePromised) {
        this.deliverytimePromised = deliverytimePromised;
    }

    public Long getDeliverytimeActual() {
        return deliverytimeActual;
    }

    public void setDeliverytimeActual(Long deliverytimeActual) {
        this.deliverytimeActual = deliverytimeActual;
    }

    public BigInteger getQualityrating() {
        return qualityrating;
    }

    public void setQualityrating(BigInteger qualityrating) {
        this.qualityrating = qualityrating;
    }

    public BigInteger getRoyaltyamt() {
        return royaltyamt;
    }

    public void setRoyaltyamt(BigInteger royaltyamt) {
        this.royaltyamt = royaltyamt;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigInteger getCapacity() {
        return capacity;
    }

    public void setCapacity(BigInteger capacity) {
        this.capacity = capacity;
    }

    public BigInteger getQtystd() {
        return qtystd;
    }

    public void setQtystd(BigInteger qtystd) {
        this.qtystd = qtystd;
    }

    public String getQtytype() {
        return qtytype;
    }

    public void setQtytype(String qtytype) {
        this.qtytype = qtytype;
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

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductPoId != null ? mProductPoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductPo)) {
            return false;
        }
        MProductPo other = (MProductPo) object;
        if ((this.mProductPoId == null && other.mProductPoId != null) || (this.mProductPoId != null && !this.mProductPoId.equals(other.mProductPoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductPo[ mProductPoId=" + mProductPoId + " ]";
    }
    
}
