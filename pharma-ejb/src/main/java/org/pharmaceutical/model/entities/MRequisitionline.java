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
@Table(name = "m_requisitionline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRequisitionline.findAll", query = "SELECT m FROM MRequisitionline m"),
    @NamedQuery(name = "MRequisitionline.findByMRequisitionlineId", query = "SELECT m FROM MRequisitionline m WHERE m.mRequisitionlineId = :mRequisitionlineId"),
    @NamedQuery(name = "MRequisitionline.findByIsactive", query = "SELECT m FROM MRequisitionline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MRequisitionline.findByCreated", query = "SELECT m FROM MRequisitionline m WHERE m.created = :created"),
    @NamedQuery(name = "MRequisitionline.findByCreatedby", query = "SELECT m FROM MRequisitionline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MRequisitionline.findByUpdated", query = "SELECT m FROM MRequisitionline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MRequisitionline.findByUpdatedby", query = "SELECT m FROM MRequisitionline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MRequisitionline.findByQty", query = "SELECT m FROM MRequisitionline m WHERE m.qty = :qty"),
    @NamedQuery(name = "MRequisitionline.findByPricelist", query = "SELECT m FROM MRequisitionline m WHERE m.pricelist = :pricelist"),
    @NamedQuery(name = "MRequisitionline.findByLinenetamt", query = "SELECT m FROM MRequisitionline m WHERE m.linenetamt = :linenetamt"),
    @NamedQuery(name = "MRequisitionline.findByQuantityorder", query = "SELECT m FROM MRequisitionline m WHERE m.quantityorder = :quantityorder"),
    @NamedQuery(name = "MRequisitionline.findByReqstatus", query = "SELECT m FROM MRequisitionline m WHERE m.reqstatus = :reqstatus"),
    @NamedQuery(name = "MRequisitionline.findByOrderedqty", query = "SELECT m FROM MRequisitionline m WHERE m.orderedqty = :orderedqty"),
    @NamedQuery(name = "MRequisitionline.findByDescription", query = "SELECT m FROM MRequisitionline m WHERE m.description = :description"),
    @NamedQuery(name = "MRequisitionline.findByChangestatus", query = "SELECT m FROM MRequisitionline m WHERE m.changestatus = :changestatus"),
    @NamedQuery(name = "MRequisitionline.findByInternalnotes", query = "SELECT m FROM MRequisitionline m WHERE m.internalnotes = :internalnotes"),
    @NamedQuery(name = "MRequisitionline.findBySuppliernotes", query = "SELECT m FROM MRequisitionline m WHERE m.suppliernotes = :suppliernotes"),
    @NamedQuery(name = "MRequisitionline.findByDateplanned", query = "SELECT m FROM MRequisitionline m WHERE m.dateplanned = :dateplanned"),
    @NamedQuery(name = "MRequisitionline.findByNeedbydate", query = "SELECT m FROM MRequisitionline m WHERE m.needbydate = :needbydate"),
    @NamedQuery(name = "MRequisitionline.findByPriceactual", query = "SELECT m FROM MRequisitionline m WHERE m.priceactual = :priceactual"),
    @NamedQuery(name = "MRequisitionline.findByDiscount", query = "SELECT m FROM MRequisitionline m WHERE m.discount = :discount"),
    @NamedQuery(name = "MRequisitionline.findByLockqty", query = "SELECT m FROM MRequisitionline m WHERE m.lockqty = :lockqty"),
    @NamedQuery(name = "MRequisitionline.findByLockprice", query = "SELECT m FROM MRequisitionline m WHERE m.lockprice = :lockprice"),
    @NamedQuery(name = "MRequisitionline.findByLockdate", query = "SELECT m FROM MRequisitionline m WHERE m.lockdate = :lockdate"),
    @NamedQuery(name = "MRequisitionline.findByLockcause", query = "SELECT m FROM MRequisitionline m WHERE m.lockcause = :lockcause"),
    @NamedQuery(name = "MRequisitionline.findByLine", query = "SELECT m FROM MRequisitionline m WHERE m.line = :line")})
public class MRequisitionline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_requisitionline_id")
    private String mRequisitionlineId;
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
    @Column(name = "qty")
    private BigInteger qty;
    @Column(name = "pricelist")
    private BigInteger pricelist;
    @Column(name = "linenetamt")
    private BigInteger linenetamt;
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "reqstatus")
    private String reqstatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderedqty")
    private BigInteger orderedqty;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "changestatus")
    private Character changestatus;
    @Size(max = 255)
    @Column(name = "internalnotes")
    private String internalnotes;
    @Size(max = 255)
    @Column(name = "suppliernotes")
    private String suppliernotes;
    @Column(name = "dateplanned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateplanned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "needbydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date needbydate;
    @Column(name = "priceactual")
    private BigInteger priceactual;
    @Column(name = "discount")
    private BigInteger discount;
    @Column(name = "lockqty")
    private BigInteger lockqty;
    @Column(name = "lockprice")
    private BigInteger lockprice;
    @Column(name = "lockdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockdate;
    @Size(max = 60)
    @Column(name = "lockcause")
    private String lockcause;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line")
    private long line;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mRequisitionlineId")
    private List<MRequisitionorder> mRequisitionorderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mRequisitionlineId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "lockedby", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser lockedby;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @JoinColumn(name = "m_requisition_id", referencedColumnName = "m_requisition_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MRequisition mRequisitionId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mRequisitionlineId")
    private List<MrpRunProductionline> mrpRunProductionlineList;

    public MRequisitionline() {
    }

    public MRequisitionline(String mRequisitionlineId) {
        this.mRequisitionlineId = mRequisitionlineId;
    }

    public MRequisitionline(String mRequisitionlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger qty, String reqstatus, BigInteger orderedqty, Date needbydate, long line) {
        this.mRequisitionlineId = mRequisitionlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.qty = qty;
        this.reqstatus = reqstatus;
        this.orderedqty = orderedqty;
        this.needbydate = needbydate;
        this.line = line;
    }

    public String getMRequisitionlineId() {
        return mRequisitionlineId;
    }

    public void setMRequisitionlineId(String mRequisitionlineId) {
        this.mRequisitionlineId = mRequisitionlineId;
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

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public BigInteger getPricelist() {
        return pricelist;
    }

    public void setPricelist(BigInteger pricelist) {
        this.pricelist = pricelist;
    }

    public BigInteger getLinenetamt() {
        return linenetamt;
    }

    public void setLinenetamt(BigInteger linenetamt) {
        this.linenetamt = linenetamt;
    }

    public BigInteger getQuantityorder() {
        return quantityorder;
    }

    public void setQuantityorder(BigInteger quantityorder) {
        this.quantityorder = quantityorder;
    }

    public String getReqstatus() {
        return reqstatus;
    }

    public void setReqstatus(String reqstatus) {
        this.reqstatus = reqstatus;
    }

    public BigInteger getOrderedqty() {
        return orderedqty;
    }

    public void setOrderedqty(BigInteger orderedqty) {
        this.orderedqty = orderedqty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getChangestatus() {
        return changestatus;
    }

    public void setChangestatus(Character changestatus) {
        this.changestatus = changestatus;
    }

    public String getInternalnotes() {
        return internalnotes;
    }

    public void setInternalnotes(String internalnotes) {
        this.internalnotes = internalnotes;
    }

    public String getSuppliernotes() {
        return suppliernotes;
    }

    public void setSuppliernotes(String suppliernotes) {
        this.suppliernotes = suppliernotes;
    }

    public Date getDateplanned() {
        return dateplanned;
    }

    public void setDateplanned(Date dateplanned) {
        this.dateplanned = dateplanned;
    }

    public Date getNeedbydate() {
        return needbydate;
    }

    public void setNeedbydate(Date needbydate) {
        this.needbydate = needbydate;
    }

    public BigInteger getPriceactual() {
        return priceactual;
    }

    public void setPriceactual(BigInteger priceactual) {
        this.priceactual = priceactual;
    }

    public BigInteger getDiscount() {
        return discount;
    }

    public void setDiscount(BigInteger discount) {
        this.discount = discount;
    }

    public BigInteger getLockqty() {
        return lockqty;
    }

    public void setLockqty(BigInteger lockqty) {
        this.lockqty = lockqty;
    }

    public BigInteger getLockprice() {
        return lockprice;
    }

    public void setLockprice(BigInteger lockprice) {
        this.lockprice = lockprice;
    }

    public Date getLockdate() {
        return lockdate;
    }

    public void setLockdate(Date lockdate) {
        this.lockdate = lockdate;
    }

    public String getLockcause() {
        return lockcause;
    }

    public void setLockcause(String lockcause) {
        this.lockcause = lockcause;
    }

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    @XmlTransient
    public List<MRequisitionorder> getMRequisitionorderList() {
        return mRequisitionorderList;
    }

    public void setMRequisitionorderList(List<MRequisitionorder> mRequisitionorderList) {
        this.mRequisitionorderList = mRequisitionorderList;
    }

    @XmlTransient
    public List<MrpRunPurchaseline> getMrpRunPurchaselineList() {
        return mrpRunPurchaselineList;
    }

    public void setMrpRunPurchaselineList(List<MrpRunPurchaseline> mrpRunPurchaselineList) {
        this.mrpRunPurchaselineList = mrpRunPurchaselineList;
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

    public AdUser getLockedby() {
        return lockedby;
    }

    public void setLockedby(AdUser lockedby) {
        this.lockedby = lockedby;
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

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MProductUom getMProductUomId() {
        return mProductUomId;
    }

    public void setMProductUomId(MProductUom mProductUomId) {
        this.mProductUomId = mProductUomId;
    }

    public MRequisition getMRequisitionId() {
        return mRequisitionId;
    }

    public void setMRequisitionId(MRequisition mRequisitionId) {
        this.mRequisitionId = mRequisitionId;
    }

    @XmlTransient
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mRequisitionlineId != null ? mRequisitionlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRequisitionline)) {
            return false;
        }
        MRequisitionline other = (MRequisitionline) object;
        if ((this.mRequisitionlineId == null && other.mRequisitionlineId != null) || (this.mRequisitionlineId != null && !this.mRequisitionlineId.equals(other.mRequisitionlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MRequisitionline[ mRequisitionlineId=" + mRequisitionlineId + " ]";
    }
    
}
