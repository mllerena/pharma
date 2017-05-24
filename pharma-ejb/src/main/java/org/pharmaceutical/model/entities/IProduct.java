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
@Table(name = "i_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IProduct.findAll", query = "SELECT i FROM IProduct i"),
    @NamedQuery(name = "IProduct.findByIProductId", query = "SELECT i FROM IProduct i WHERE i.iProductId = :iProductId"),
    @NamedQuery(name = "IProduct.findByIsactive", query = "SELECT i FROM IProduct i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IProduct.findByCreated", query = "SELECT i FROM IProduct i WHERE i.created = :created"),
    @NamedQuery(name = "IProduct.findByCreatedby", query = "SELECT i FROM IProduct i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IProduct.findByUpdated", query = "SELECT i FROM IProduct i WHERE i.updated = :updated"),
    @NamedQuery(name = "IProduct.findByUpdatedby", query = "SELECT i FROM IProduct i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IProduct.findByValue", query = "SELECT i FROM IProduct i WHERE i.value = :value"),
    @NamedQuery(name = "IProduct.findByName", query = "SELECT i FROM IProduct i WHERE i.name = :name"),
    @NamedQuery(name = "IProduct.findByDescription", query = "SELECT i FROM IProduct i WHERE i.description = :description"),
    @NamedQuery(name = "IProduct.findByDocumentnote", query = "SELECT i FROM IProduct i WHERE i.documentnote = :documentnote"),
    @NamedQuery(name = "IProduct.findByHelp", query = "SELECT i FROM IProduct i WHERE i.help = :help"),
    @NamedQuery(name = "IProduct.findByUpc", query = "SELECT i FROM IProduct i WHERE i.upc = :upc"),
    @NamedQuery(name = "IProduct.findBySku", query = "SELECT i FROM IProduct i WHERE i.sku = :sku"),
    @NamedQuery(name = "IProduct.findByX12de355", query = "SELECT i FROM IProduct i WHERE i.x12de355 = :x12de355"),
    @NamedQuery(name = "IProduct.findByProductcategoryValue", query = "SELECT i FROM IProduct i WHERE i.productcategoryValue = :productcategoryValue"),
    @NamedQuery(name = "IProduct.findByProducttype", query = "SELECT i FROM IProduct i WHERE i.producttype = :producttype"),
    @NamedQuery(name = "IProduct.findByClassification", query = "SELECT i FROM IProduct i WHERE i.classification = :classification"),
    @NamedQuery(name = "IProduct.findByVolume", query = "SELECT i FROM IProduct i WHERE i.volume = :volume"),
    @NamedQuery(name = "IProduct.findByWeight", query = "SELECT i FROM IProduct i WHERE i.weight = :weight"),
    @NamedQuery(name = "IProduct.findByShelfwidth", query = "SELECT i FROM IProduct i WHERE i.shelfwidth = :shelfwidth"),
    @NamedQuery(name = "IProduct.findByShelfheight", query = "SELECT i FROM IProduct i WHERE i.shelfheight = :shelfheight"),
    @NamedQuery(name = "IProduct.findByShelfdepth", query = "SELECT i FROM IProduct i WHERE i.shelfdepth = :shelfdepth"),
    @NamedQuery(name = "IProduct.findByUnitsperpallet", query = "SELECT i FROM IProduct i WHERE i.unitsperpallet = :unitsperpallet"),
    @NamedQuery(name = "IProduct.findByDiscontinued", query = "SELECT i FROM IProduct i WHERE i.discontinued = :discontinued"),
    @NamedQuery(name = "IProduct.findByDiscontinuedby", query = "SELECT i FROM IProduct i WHERE i.discontinuedby = :discontinuedby"),
    @NamedQuery(name = "IProduct.findByImageurl", query = "SELECT i FROM IProduct i WHERE i.imageurl = :imageurl"),
    @NamedQuery(name = "IProduct.findByDescriptionurl", query = "SELECT i FROM IProduct i WHERE i.descriptionurl = :descriptionurl"),
    @NamedQuery(name = "IProduct.findByBpartnerValue", query = "SELECT i FROM IProduct i WHERE i.bpartnerValue = :bpartnerValue"),
    @NamedQuery(name = "IProduct.findByIsoCode", query = "SELECT i FROM IProduct i WHERE i.isoCode = :isoCode"),
    @NamedQuery(name = "IProduct.findByPricelist", query = "SELECT i FROM IProduct i WHERE i.pricelist = :pricelist"),
    @NamedQuery(name = "IProduct.findByPricepo", query = "SELECT i FROM IProduct i WHERE i.pricepo = :pricepo"),
    @NamedQuery(name = "IProduct.findByRoyaltyamt", query = "SELECT i FROM IProduct i WHERE i.royaltyamt = :royaltyamt"),
    @NamedQuery(name = "IProduct.findByPriceeffective", query = "SELECT i FROM IProduct i WHERE i.priceeffective = :priceeffective"),
    @NamedQuery(name = "IProduct.findByVendorproductno", query = "SELECT i FROM IProduct i WHERE i.vendorproductno = :vendorproductno"),
    @NamedQuery(name = "IProduct.findByVendorcategory", query = "SELECT i FROM IProduct i WHERE i.vendorcategory = :vendorcategory"),
    @NamedQuery(name = "IProduct.findByManufacturer", query = "SELECT i FROM IProduct i WHERE i.manufacturer = :manufacturer"),
    @NamedQuery(name = "IProduct.findByOrderMin", query = "SELECT i FROM IProduct i WHERE i.orderMin = :orderMin"),
    @NamedQuery(name = "IProduct.findByOrderPack", query = "SELECT i FROM IProduct i WHERE i.orderPack = :orderPack"),
    @NamedQuery(name = "IProduct.findByCostperorder", query = "SELECT i FROM IProduct i WHERE i.costperorder = :costperorder"),
    @NamedQuery(name = "IProduct.findByDeliverytimePromised", query = "SELECT i FROM IProduct i WHERE i.deliverytimePromised = :deliverytimePromised"),
    @NamedQuery(name = "IProduct.findByProcessing", query = "SELECT i FROM IProduct i WHERE i.processing = :processing"),
    @NamedQuery(name = "IProduct.findByProcessed", query = "SELECT i FROM IProduct i WHERE i.processed = :processed"),
    @NamedQuery(name = "IProduct.findByIErrormsg", query = "SELECT i FROM IProduct i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IProduct.findByIIsimported", query = "SELECT i FROM IProduct i WHERE i.iIsimported = :iIsimported")})
public class IProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_product_id")
    private String iProductId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 40)
    @Column(name = "value")
    private String value;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
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
    @Size(max = 2)
    @Column(name = "x12de355")
    private String x12de355;
    @Size(max = 40)
    @Column(name = "productcategory_value")
    private String productcategoryValue;
    @Size(max = 60)
    @Column(name = "producttype")
    private String producttype;
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
    private Character discontinued;
    @Column(name = "discontinuedby")
    @Temporal(TemporalType.TIMESTAMP)
    private Date discontinuedby;
    @Size(max = 120)
    @Column(name = "imageurl")
    private String imageurl;
    @Size(max = 120)
    @Column(name = "descriptionurl")
    private String descriptionurl;
    @Size(max = 40)
    @Column(name = "bpartner_value")
    private String bpartnerValue;
    @Size(max = 3)
    @Column(name = "iso_code")
    private String isoCode;
    @Column(name = "pricelist")
    private BigInteger pricelist;
    @Column(name = "pricepo")
    private BigInteger pricepo;
    @Column(name = "royaltyamt")
    private BigInteger royaltyamt;
    @Column(name = "priceeffective")
    @Temporal(TemporalType.TIMESTAMP)
    private Date priceeffective;
    @Size(max = 40)
    @Column(name = "vendorproductno")
    private String vendorproductno;
    @Size(max = 30)
    @Column(name = "vendorcategory")
    private String vendorcategory;
    @Size(max = 30)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "order_min")
    private BigInteger orderMin;
    @Column(name = "order_pack")
    private BigInteger orderPack;
    @Column(name = "costperorder")
    private BigInteger costperorder;
    @Column(name = "deliverytime_promised")
    private Long deliverytimePromised;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;

    public IProduct() {
    }

    public IProduct(String iProductId) {
        this.iProductId = iProductId;
    }

    public String getIProductId() {
        return iProductId;
    }

    public void setIProductId(String iProductId) {
        this.iProductId = iProductId;
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

    public String getX12de355() {
        return x12de355;
    }

    public void setX12de355(String x12de355) {
        this.x12de355 = x12de355;
    }

    public String getProductcategoryValue() {
        return productcategoryValue;
    }

    public void setProductcategoryValue(String productcategoryValue) {
        this.productcategoryValue = productcategoryValue;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
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

    public String getBpartnerValue() {
        return bpartnerValue;
    }

    public void setBpartnerValue(String bpartnerValue) {
        this.bpartnerValue = bpartnerValue;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
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

    public BigInteger getRoyaltyamt() {
        return royaltyamt;
    }

    public void setRoyaltyamt(BigInteger royaltyamt) {
        this.royaltyamt = royaltyamt;
    }

    public Date getPriceeffective() {
        return priceeffective;
    }

    public void setPriceeffective(Date priceeffective) {
        this.priceeffective = priceeffective;
    }

    public String getVendorproductno() {
        return vendorproductno;
    }

    public void setVendorproductno(String vendorproductno) {
        this.vendorproductno = vendorproductno;
    }

    public String getVendorcategory() {
        return vendorcategory;
    }

    public void setVendorcategory(String vendorcategory) {
        this.vendorcategory = vendorcategory;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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

    public String getIErrormsg() {
        return iErrormsg;
    }

    public void setIErrormsg(String iErrormsg) {
        this.iErrormsg = iErrormsg;
    }

    public Character getIIsimported() {
        return iIsimported;
    }

    public void setIIsimported(Character iIsimported) {
        this.iIsimported = iIsimported;
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

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iProductId != null ? iProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IProduct)) {
            return false;
        }
        IProduct other = (IProduct) object;
        if ((this.iProductId == null && other.iProductId != null) || (this.iProductId != null && !this.iProductId.equals(other.iProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IProduct[ iProductId=" + iProductId + " ]";
    }
    
}
