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
@Table(name = "ma_wrphaseproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaWrphaseproduct.findAll", query = "SELECT m FROM MaWrphaseproduct m"),
    @NamedQuery(name = "MaWrphaseproduct.findByMaWrphaseproductId", query = "SELECT m FROM MaWrphaseproduct m WHERE m.maWrphaseproductId = :maWrphaseproductId"),
    @NamedQuery(name = "MaWrphaseproduct.findByIsactive", query = "SELECT m FROM MaWrphaseproduct m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaWrphaseproduct.findByCreated", query = "SELECT m FROM MaWrphaseproduct m WHERE m.created = :created"),
    @NamedQuery(name = "MaWrphaseproduct.findByCreatedby", query = "SELECT m FROM MaWrphaseproduct m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaWrphaseproduct.findByUpdated", query = "SELECT m FROM MaWrphaseproduct m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaWrphaseproduct.findByUpdatedby", query = "SELECT m FROM MaWrphaseproduct m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaWrphaseproduct.findByName", query = "SELECT m FROM MaWrphaseproduct m WHERE m.name = :name"),
    @NamedQuery(name = "MaWrphaseproduct.findByMovementqty", query = "SELECT m FROM MaWrphaseproduct m WHERE m.movementqty = :movementqty"),
    @NamedQuery(name = "MaWrphaseproduct.findByProductiontype", query = "SELECT m FROM MaWrphaseproduct m WHERE m.productiontype = :productiontype"),
    @NamedQuery(name = "MaWrphaseproduct.findByQuantityorder", query = "SELECT m FROM MaWrphaseproduct m WHERE m.quantityorder = :quantityorder"),
    @NamedQuery(name = "MaWrphaseproduct.findByComponentcost", query = "SELECT m FROM MaWrphaseproduct m WHERE m.componentcost = :componentcost"),
    @NamedQuery(name = "MaWrphaseproduct.findByMaWrphaseId", query = "SELECT m FROM MaWrphaseproduct m WHERE m.maWrphaseId = :maWrphaseId and m.isactive = :isactive"),
    @NamedQuery(name = "MaWrphaseproduct.findByMaWorkrequirementId", query = "select m from MaWrphaseproduct m where m.maWrphaseId in (SELECT f.maWrphaseId FROM MaWrphase f WHERE f.maWorkrequirementId = :maWorkrequirementId and f.isactive = :isactive ) and m.isactive = :isactive")
})
public class MaWrphaseproduct extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_wrphaseproduct_id")
    private String maWrphaseproductId;
    
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
    
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "movementqty")
    private BigInteger movementqty;
    
    @Column(name = "productiontype")
    @Convert(converter=ProductionTypeConverter.class) 
    private ProductionType productiontype;
    
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    
    @Column(name = "componentcost")
    private BigInteger componentcost;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @JoinColumn(name = "ma_wrphase_id", referencedColumnName = "ma_wrphase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaWrphase maWrphaseId;

    public MaWrphaseproduct() {
    }

    public MaWrphaseproduct(String maWrphaseproductId) {
        this.maWrphaseproductId = maWrphaseproductId;
    }

    public String getMaWrphaseproductId() {
        return maWrphaseproductId;
    }

    public void setMaWrphaseproductId(String maWrphaseproductId) {
        this.maWrphaseproductId = maWrphaseproductId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getMovementqty() {
        return movementqty;
    }

    public void setMovementqty(BigInteger movementqty) {
        this.movementqty = movementqty;
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

    public MaWrphase getMaWrphaseId() {
        return maWrphaseId;
    }

    public void setMaWrphaseId(MaWrphase maWrphaseId) {
        this.maWrphaseId = maWrphaseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maWrphaseproductId != null ? maWrphaseproductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaWrphaseproduct)) {
            return false;
        }
        MaWrphaseproduct other = (MaWrphaseproduct) object;
        if ((this.maWrphaseproductId == null && other.maWrphaseproductId != null) || (this.maWrphaseproductId != null && !this.maWrphaseproductId.equals(other.maWrphaseproductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaWrphaseproduct[ maWrphaseproductId=" + maWrphaseproductId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maWrphaseproductId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maWrphaseproductId = id;
	}
    
}
