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
@Table(name = "m_inoutline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MInoutline.findAll", query = "SELECT m FROM MInoutline m"),
    @NamedQuery(name = "MInoutline.findByMInoutlineId", query = "SELECT m FROM MInoutline m WHERE m.mInoutlineId = :mInoutlineId"),
    @NamedQuery(name = "MInoutline.findByIsactive", query = "SELECT m FROM MInoutline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MInoutline.findByCreated", query = "SELECT m FROM MInoutline m WHERE m.created = :created"),
    @NamedQuery(name = "MInoutline.findByCreatedby", query = "SELECT m FROM MInoutline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MInoutline.findByUpdated", query = "SELECT m FROM MInoutline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MInoutline.findByUpdatedby", query = "SELECT m FROM MInoutline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MInoutline.findByLine", query = "SELECT m FROM MInoutline m WHERE m.line = :line"),
    @NamedQuery(name = "MInoutline.findByDescription", query = "SELECT m FROM MInoutline m WHERE m.description = :description"),
    @NamedQuery(name = "MInoutline.findByMovementqty", query = "SELECT m FROM MInoutline m WHERE m.movementqty = :movementqty"),
    @NamedQuery(name = "MInoutline.findByIsinvoiced", query = "SELECT m FROM MInoutline m WHERE m.isinvoiced = :isinvoiced"),
    @NamedQuery(name = "MInoutline.findByIsdescription", query = "SELECT m FROM MInoutline m WHERE m.isdescription = :isdescription"),
    @NamedQuery(name = "MInoutline.findByQuantityorder", query = "SELECT m FROM MInoutline m WHERE m.quantityorder = :quantityorder")})
public class MInoutline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_inoutline_id")
    private String mInoutlineId;
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
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementqty")
    private BigInteger movementqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isinvoiced")
    private Character isinvoiced;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdescription")
    private Character isdescription;
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInoutlineId")
    private List<CProjectissue> cProjectissueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInoutlineId")
    private List<MCosting> mCostingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mInoutlineId")
    private List<MMatchinv> mMatchinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInoutlineId")
    private List<MTransaction> mTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInoutlineId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mInoutlineId")
    private List<MMatchpo> mMatchpoList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderline cOrderlineId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_inout_id", referencedColumnName = "m_inout_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MInout mInoutId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;

    public MInoutline() {
    }

    public MInoutline(String mInoutlineId) {
        this.mInoutlineId = mInoutlineId;
    }

    public MInoutline(String mInoutlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, BigInteger movementqty, Character isinvoiced, Character isdescription) {
        this.mInoutlineId = mInoutlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.movementqty = movementqty;
        this.isinvoiced = isinvoiced;
        this.isdescription = isdescription;
    }

    public String getMInoutlineId() {
        return mInoutlineId;
    }

    public void setMInoutlineId(String mInoutlineId) {
        this.mInoutlineId = mInoutlineId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getMovementqty() {
        return movementqty;
    }

    public void setMovementqty(BigInteger movementqty) {
        this.movementqty = movementqty;
    }

    public Character getIsinvoiced() {
        return isinvoiced;
    }

    public void setIsinvoiced(Character isinvoiced) {
        this.isinvoiced = isinvoiced;
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

    @XmlTransient
    public List<CProjectissue> getCProjectissueList() {
        return cProjectissueList;
    }

    public void setCProjectissueList(List<CProjectissue> cProjectissueList) {
        this.cProjectissueList = cProjectissueList;
    }

    @XmlTransient
    public List<MCosting> getMCostingList() {
        return mCostingList;
    }

    public void setMCostingList(List<MCosting> mCostingList) {
        this.mCostingList = mCostingList;
    }

    @XmlTransient
    public List<MMatchinv> getMMatchinvList() {
        return mMatchinvList;
    }

    public void setMMatchinvList(List<MMatchinv> mMatchinvList) {
        this.mMatchinvList = mMatchinvList;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<MMatchpo> getMMatchpoList() {
        return mMatchpoList;
    }

    public void setMMatchpoList(List<MMatchpo> mMatchpoList) {
        this.mMatchpoList = mMatchpoList;
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

    public COrderline getCOrderlineId() {
        return cOrderlineId;
    }

    public void setCOrderlineId(COrderline cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
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

    public MInout getMInoutId() {
        return mInoutId;
    }

    public void setMInoutId(MInout mInoutId) {
        this.mInoutId = mInoutId;
    }

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mInoutlineId != null ? mInoutlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MInoutline)) {
            return false;
        }
        MInoutline other = (MInoutline) object;
        if ((this.mInoutlineId == null && other.mInoutlineId != null) || (this.mInoutlineId != null && !this.mInoutlineId.equals(other.mInoutlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MInoutline[ mInoutlineId=" + mInoutlineId + " ]";
    }
    
}
