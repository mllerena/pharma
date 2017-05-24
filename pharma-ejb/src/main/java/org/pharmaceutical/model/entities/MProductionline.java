/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.ProductionTypeConverter;
import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.ProductionType;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_productionline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductionline.findAll", query = "SELECT m FROM MProductionline m"),
    @NamedQuery(name = "MProductionline.findByMProductionlineId", query = "SELECT m FROM MProductionline m WHERE m.mProductionlineId = :mProductionlineId"),
    @NamedQuery(name = "MProductionline.findByIsactive", query = "SELECT m FROM MProductionline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductionline.findByCreated", query = "SELECT m FROM MProductionline m WHERE m.created = :created"),
    @NamedQuery(name = "MProductionline.findByCreatedby", query = "SELECT m FROM MProductionline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductionline.findByUpdated", query = "SELECT m FROM MProductionline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductionline.findByUpdatedby", query = "SELECT m FROM MProductionline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductionline.findByLine", query = "SELECT m FROM MProductionline m WHERE m.line = :line"),
    @NamedQuery(name = "MProductionline.findByMovementqty", query = "SELECT m FROM MProductionline m WHERE m.movementqty = :movementqty"),
    @NamedQuery(name = "MProductionline.findByDescription", query = "SELECT m FROM MProductionline m WHERE m.description = :description"),
    @NamedQuery(name = "MProductionline.findByQuantityorder", query = "SELECT m FROM MProductionline m WHERE m.quantityorder = :quantityorder"),
    @NamedQuery(name = "MProductionline.findByCalculated", query = "SELECT m FROM MProductionline m WHERE m.calculated = :calculated"),
    @NamedQuery(name = "MProductionline.findByProductiontype", query = "SELECT m FROM MProductionline m WHERE m.productiontype = :productiontype"),
    @NamedQuery(name = "MProductionline.findByRejectedquantity", query = "SELECT m FROM MProductionline m WHERE m.rejectedquantity = :rejectedquantity"),
    @NamedQuery(name = "MProductionline.findByCalccost", query = "SELECT m FROM MProductionline m WHERE m.calccost = :calccost"),
    @NamedQuery(name = "MProductionline.findByComponentcost", query = "SELECT m FROM MProductionline m WHERE m.componentcost = :componentcost"),
    @NamedQuery(name = "MProductionline.findByMProductionplanId", query = "SELECT m FROM MProductionline m WHERE m.mProductionplanId = :mProductionplanId and m.isactive = :isactive")
})
public class MProductionline extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "m_productionline_id")
    private String mProductionlineId;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive; 
    
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    
    @Basic(optional = false)
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    
    @Basic(optional = false)
    @Column(name = "line")
    private long line;
    
    @Basic(optional = false)
    @Column(name = "movementqty")
    private BigInteger movementqty;
    
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    
    @Column(name = "calculated")
    private YesNo calculated;
    
    @Column(name = "productiontype")
    @Convert(converter=ProductionTypeConverter.class) 
    private ProductionType productiontype;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "rejectedquantity")
    private BigInteger rejectedquantity;
    
    @Column(name = "calccost")
    private BigDecimal calccost;
    
    @Column(name = "componentcost")
    private BigInteger componentcost;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @JoinColumn(name = "m_productionplan_id", referencedColumnName = "m_productionplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductionplan mProductionplanId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductionlineId")
    private List<MCosting> mCostingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductionlineId")
    private List<MTransaction> mTransactionList;

    public MProductionline() {
    }

    public MProductionline(String mProductionlineId) {
        this.mProductionlineId = mProductionlineId;
    }

    public String getMProductionlineId() {
        return mProductionlineId;
    }

    public void setMProductionlineId(String mProductionlineId) {
        this.mProductionlineId = mProductionlineId;
    }

    public YesNo getIsactive() { 
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
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

    public BigInteger getMovementqty() {
        return movementqty;
    }

    public void setMovementqty(BigInteger movementqty) {
        this.movementqty = movementqty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getQuantityorder() {
        return quantityorder;
    }

    public void setQuantityorder(BigInteger quantityorder) {
        this.quantityorder = quantityorder;
    }

    public YesNo getCalculated() {
        return calculated;
    }

    public void setCalculated(YesNo calculated) {
        this.calculated = calculated;
    }

    public ProductionType getProductiontype() {
        return productiontype;
    }

    public void setProductiontype(ProductionType productiontype) {
        this.productiontype = productiontype;
    }

    public BigInteger getRejectedquantity() {
        return rejectedquantity;
    }

    public void setRejectedquantity(BigInteger rejectedquantity) {
        this.rejectedquantity = rejectedquantity;
    }

    public BigDecimal getCalccost() {
        return calccost;
    }

    public void setCalccost(BigDecimal calccost) {
        this.calccost = calccost;
    }

    public BigInteger getComponentcost() {
        return componentcost;
    }

    public void setComponentcost(BigInteger componentcost) {
        this.componentcost = componentcost;
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

    public MProductionplan getMProductionplanId() {
        return mProductionplanId;
    }

    public void setMProductionplanId(MProductionplan mProductionplanId) {
        this.mProductionplanId = mProductionplanId;
    }

    @XmlTransient
    public List<MCosting> getMCostingList() {
        return mCostingList;
    }

    public void setMCostingList(List<MCosting> mCostingList) {
        this.mCostingList = mCostingList;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductionlineId != null ? mProductionlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductionline)) {
            return false;
        }
        MProductionline other = (MProductionline) object;
        if ((this.mProductionlineId == null && other.mProductionlineId != null) || (this.mProductionlineId != null && !this.mProductionlineId.equals(other.mProductionlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductionline[ mProductionlineId=" + mProductionlineId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return mProductionlineId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		mProductionlineId = id;
	}
    
}
