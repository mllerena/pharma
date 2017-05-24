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
@Table(name = "m_offer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MOffer.findAll", query = "SELECT m FROM MOffer m"),
    @NamedQuery(name = "MOffer.findByMOfferId", query = "SELECT m FROM MOffer m WHERE m.mOfferId = :mOfferId"),
    @NamedQuery(name = "MOffer.findByIsactive", query = "SELECT m FROM MOffer m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MOffer.findByCreated", query = "SELECT m FROM MOffer m WHERE m.created = :created"),
    @NamedQuery(name = "MOffer.findByCreatedby", query = "SELECT m FROM MOffer m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MOffer.findByUpdated", query = "SELECT m FROM MOffer m WHERE m.updated = :updated"),
    @NamedQuery(name = "MOffer.findByUpdatedby", query = "SELECT m FROM MOffer m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MOffer.findByName", query = "SELECT m FROM MOffer m WHERE m.name = :name"),
    @NamedQuery(name = "MOffer.findByPriority", query = "SELECT m FROM MOffer m WHERE m.priority = :priority"),
    @NamedQuery(name = "MOffer.findByAddamt", query = "SELECT m FROM MOffer m WHERE m.addamt = :addamt"),
    @NamedQuery(name = "MOffer.findByDiscount", query = "SELECT m FROM MOffer m WHERE m.discount = :discount"),
    @NamedQuery(name = "MOffer.findByFixed", query = "SELECT m FROM MOffer m WHERE m.fixed = :fixed"),
    @NamedQuery(name = "MOffer.findByDatefrom", query = "SELECT m FROM MOffer m WHERE m.datefrom = :datefrom"),
    @NamedQuery(name = "MOffer.findByDateto", query = "SELECT m FROM MOffer m WHERE m.dateto = :dateto"),
    @NamedQuery(name = "MOffer.findByBpartnerSelection", query = "SELECT m FROM MOffer m WHERE m.bpartnerSelection = :bpartnerSelection"),
    @NamedQuery(name = "MOffer.findByBpGroupSelection", query = "SELECT m FROM MOffer m WHERE m.bpGroupSelection = :bpGroupSelection"),
    @NamedQuery(name = "MOffer.findByProductSelection", query = "SELECT m FROM MOffer m WHERE m.productSelection = :productSelection"),
    @NamedQuery(name = "MOffer.findByProdCatSelection", query = "SELECT m FROM MOffer m WHERE m.prodCatSelection = :prodCatSelection"),
    @NamedQuery(name = "MOffer.findByDescription", query = "SELECT m FROM MOffer m WHERE m.description = :description"),
    @NamedQuery(name = "MOffer.findByPricelistSelection", query = "SELECT m FROM MOffer m WHERE m.pricelistSelection = :pricelistSelection"),
    @NamedQuery(name = "MOffer.findByQtyFrom", query = "SELECT m FROM MOffer m WHERE m.qtyFrom = :qtyFrom"),
    @NamedQuery(name = "MOffer.findByQtyTo", query = "SELECT m FROM MOffer m WHERE m.qtyTo = :qtyTo")})
public class MOffer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_offer_id")
    private String mOfferId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Column(name = "priority")
    private BigInteger priority;
    @Basic(optional = false)
    @NotNull
    @Column(name = "addamt")
    private BigInteger addamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private BigInteger discount;
    @Column(name = "fixed")
    private BigInteger fixed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "bpartner_selection")
    private String bpartnerSelection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "bp_group_selection")
    private String bpGroupSelection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "product_selection")
    private String productSelection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "prod_cat_selection")
    private String prodCatSelection;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 60)
    @Column(name = "pricelist_selection")
    private String pricelistSelection;
    @Column(name = "qty_from")
    private BigInteger qtyFrom;
    @Column(name = "qty_to")
    private BigInteger qtyTo;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mOfferId")
    private List<CInvoicelineOffer> cInvoicelineOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mOfferId")
    private List<COrderlineOffer> cOrderlineOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mOfferId")
    private List<MOfferProduct> mOfferProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mOfferId")
    private List<MOfferBpartner> mOfferBpartnerList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mOfferId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mOfferId")
    private List<MOfferPricelist> mOfferPricelistList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mOfferId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mOfferId")
    private List<MOfferBpGroup> mOfferBpGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mOfferId")
    private List<MOfferProdCat> mOfferProdCatList;

    public MOffer() {
    }

    public MOffer(String mOfferId) {
        this.mOfferId = mOfferId;
    }

    public MOffer(String mOfferId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, BigInteger addamt, BigInteger discount, Date datefrom, String bpartnerSelection, String bpGroupSelection, String productSelection, String prodCatSelection) {
        this.mOfferId = mOfferId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.addamt = addamt;
        this.discount = discount;
        this.datefrom = datefrom;
        this.bpartnerSelection = bpartnerSelection;
        this.bpGroupSelection = bpGroupSelection;
        this.productSelection = productSelection;
        this.prodCatSelection = prodCatSelection;
    }

    public String getMOfferId() {
        return mOfferId;
    }

    public void setMOfferId(String mOfferId) {
        this.mOfferId = mOfferId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPriority() {
        return priority;
    }

    public void setPriority(BigInteger priority) {
        this.priority = priority;
    }

    public BigInteger getAddamt() {
        return addamt;
    }

    public void setAddamt(BigInteger addamt) {
        this.addamt = addamt;
    }

    public BigInteger getDiscount() {
        return discount;
    }

    public void setDiscount(BigInteger discount) {
        this.discount = discount;
    }

    public BigInteger getFixed() {
        return fixed;
    }

    public void setFixed(BigInteger fixed) {
        this.fixed = fixed;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public String getBpartnerSelection() {
        return bpartnerSelection;
    }

    public void setBpartnerSelection(String bpartnerSelection) {
        this.bpartnerSelection = bpartnerSelection;
    }

    public String getBpGroupSelection() {
        return bpGroupSelection;
    }

    public void setBpGroupSelection(String bpGroupSelection) {
        this.bpGroupSelection = bpGroupSelection;
    }

    public String getProductSelection() {
        return productSelection;
    }

    public void setProductSelection(String productSelection) {
        this.productSelection = productSelection;
    }

    public String getProdCatSelection() {
        return prodCatSelection;
    }

    public void setProdCatSelection(String prodCatSelection) {
        this.prodCatSelection = prodCatSelection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPricelistSelection() {
        return pricelistSelection;
    }

    public void setPricelistSelection(String pricelistSelection) {
        this.pricelistSelection = pricelistSelection;
    }

    public BigInteger getQtyFrom() {
        return qtyFrom;
    }

    public void setQtyFrom(BigInteger qtyFrom) {
        this.qtyFrom = qtyFrom;
    }

    public BigInteger getQtyTo() {
        return qtyTo;
    }

    public void setQtyTo(BigInteger qtyTo) {
        this.qtyTo = qtyTo;
    }

    @XmlTransient
    public List<CInvoicelineOffer> getCInvoicelineOfferList() {
        return cInvoicelineOfferList;
    }

    public void setCInvoicelineOfferList(List<CInvoicelineOffer> cInvoicelineOfferList) {
        this.cInvoicelineOfferList = cInvoicelineOfferList;
    }

    @XmlTransient
    public List<COrderlineOffer> getCOrderlineOfferList() {
        return cOrderlineOfferList;
    }

    public void setCOrderlineOfferList(List<COrderlineOffer> cOrderlineOfferList) {
        this.cOrderlineOfferList = cOrderlineOfferList;
    }

    @XmlTransient
    public List<MOfferProduct> getMOfferProductList() {
        return mOfferProductList;
    }

    public void setMOfferProductList(List<MOfferProduct> mOfferProductList) {
        this.mOfferProductList = mOfferProductList;
    }

    @XmlTransient
    public List<MOfferBpartner> getMOfferBpartnerList() {
        return mOfferBpartnerList;
    }

    public void setMOfferBpartnerList(List<MOfferBpartner> mOfferBpartnerList) {
        this.mOfferBpartnerList = mOfferBpartnerList;
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

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<MOfferPricelist> getMOfferPricelistList() {
        return mOfferPricelistList;
    }

    public void setMOfferPricelistList(List<MOfferPricelist> mOfferPricelistList) {
        this.mOfferPricelistList = mOfferPricelistList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<MOfferBpGroup> getMOfferBpGroupList() {
        return mOfferBpGroupList;
    }

    public void setMOfferBpGroupList(List<MOfferBpGroup> mOfferBpGroupList) {
        this.mOfferBpGroupList = mOfferBpGroupList;
    }

    @XmlTransient
    public List<MOfferProdCat> getMOfferProdCatList() {
        return mOfferProdCatList;
    }

    public void setMOfferProdCatList(List<MOfferProdCat> mOfferProdCatList) {
        this.mOfferProdCatList = mOfferProdCatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mOfferId != null ? mOfferId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MOffer)) {
            return false;
        }
        MOffer other = (MOffer) object;
        if ((this.mOfferId == null && other.mOfferId != null) || (this.mOfferId != null && !this.mOfferId.equals(other.mOfferId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MOffer[ mOfferId=" + mOfferId + " ]";
    }
    
}
