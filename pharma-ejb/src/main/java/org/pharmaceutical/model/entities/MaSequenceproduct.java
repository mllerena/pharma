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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.ProductionTypeConverter;
import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.ProductionType;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_sequenceproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaSequenceproduct.findAll", query = "SELECT m FROM MaSequenceproduct m"),
    @NamedQuery(name = "MaSequenceproduct.findByMaSequenceproductId", query = "SELECT m FROM MaSequenceproduct m WHERE m.maSequenceproductId = :maSequenceproductId"),
    @NamedQuery(name = "MaSequenceproduct.findByIsactive", query = "SELECT m FROM MaSequenceproduct m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaSequenceproduct.findByCreated", query = "SELECT m FROM MaSequenceproduct m WHERE m.created = :created"),
    @NamedQuery(name = "MaSequenceproduct.findByCreatedby", query = "SELECT m FROM MaSequenceproduct m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaSequenceproduct.findByUpdated", query = "SELECT m FROM MaSequenceproduct m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaSequenceproduct.findByUpdatedby", query = "SELECT m FROM MaSequenceproduct m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaSequenceproduct.findByQuantity", query = "SELECT m FROM MaSequenceproduct m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MaSequenceproduct.findByProductiontype", query = "SELECT m FROM MaSequenceproduct m WHERE m.productiontype = :productiontype"),
    @NamedQuery(name = "MaSequenceproduct.findByQuantityorder", query = "SELECT m FROM MaSequenceproduct m WHERE m.quantityorder = :quantityorder"),
    @NamedQuery(name = "MaSequenceproduct.findByComponentcost", query = "SELECT m FROM MaSequenceproduct m WHERE m.componentcost = :componentcost"),
    @NamedQuery(name = "MaSequenceproduct.findByDecrease", query = "SELECT m FROM MaSequenceproduct m WHERE m.decrease = :decrease"),
    @NamedQuery(name = "MaSequenceproduct.findByRejected", query = "SELECT m FROM MaSequenceproduct m WHERE m.rejected = :rejected"),
    @NamedQuery(name = "MaSequenceproduct.findByCost", query = "SELECT m FROM MaSequenceproduct m WHERE m.cost = :cost"),
    @NamedQuery(name = "MaSequenceproduct.findByMaSequenceId", query = "SELECT m FROM MaSequenceproduct m WHERE m.maSequenceId = :maSequenceId and m.isactive = :isactive")
})
public class MaSequenceproduct extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_sequenceproduct_id")
    private String maSequenceproductId;
    
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
    @Column(name = "quantity")
    private BigInteger quantity;
    
    @Column(name = "productiontype")
    @Convert(converter=ProductionTypeConverter.class) 
    private ProductionType productiontype;
    
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    
    @Column(name = "componentcost")
    private BigInteger componentcost;
    
    @Column(name = "decrease")
    private BigDecimal decrease;
    
    @Column(name = "rejected")
    private BigDecimal rejected;
    
    @Column(name = "cost")
    private BigDecimal cost;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @JoinColumn(name = "ma_sequence_id", referencedColumnName = "ma_sequence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaSequence maSequenceId;

    public MaSequenceproduct() {
    }

    public MaSequenceproduct(String maSequenceproductId) {
        this.maSequenceproductId = maSequenceproductId;
    }

    public String getMaSequenceproductId() {
        return maSequenceproductId;
    }

    public void setMaSequenceproductId(String maSequenceproductId) {
        this.maSequenceproductId = maSequenceproductId;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public ProductionType getProductiontype() {
        return productiontype;
    }

    public void setProductiontype(ProductionType productiontype) {
        this.productiontype = productiontype;
    }

    public BigInteger getQuantityorder() {
        return quantityorder;
    }

    public void setQuantityorder(BigInteger quantityorder) {
        this.quantityorder = quantityorder;
    }

    public BigInteger getComponentcost() {
        return componentcost;
    }

    public void setComponentcost(BigInteger componentcost) {
        this.componentcost = componentcost;
    }

    public BigDecimal getDecrease() {
        return decrease;
    }

    public void setDecrease(BigDecimal decrease) {
        this.decrease = decrease;
    }

    public BigDecimal getRejected() {
        return rejected;
    }

    public void setRejected(BigDecimal rejected) {
        this.rejected = rejected;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

    public MaSequence getMaSequenceId() {
        return maSequenceId;
    }

    public void setMaSequenceId(MaSequence maSequenceId) {
        this.maSequenceId = maSequenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSequenceproductId != null ? maSequenceproductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaSequenceproduct)) {
            return false;
        }
        MaSequenceproduct other = (MaSequenceproduct) object;
        if ((this.maSequenceproductId == null && other.maSequenceproductId != null) || (this.maSequenceproductId != null && !this.maSequenceproductId.equals(other.maSequenceproductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaSequenceproduct[ maSequenceproductId=" + maSequenceproductId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maSequenceproductId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maSequenceproductId = id;
	}
    
}
