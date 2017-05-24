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
@Table(name = "m_product_org")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductOrg.findAll", query = "SELECT m FROM MProductOrg m"),
    @NamedQuery(name = "MProductOrg.findByMProductOrgId", query = "SELECT m FROM MProductOrg m WHERE m.mProductOrgId = :mProductOrgId"),
    @NamedQuery(name = "MProductOrg.findByIsactive", query = "SELECT m FROM MProductOrg m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductOrg.findByCreated", query = "SELECT m FROM MProductOrg m WHERE m.created = :created"),
    @NamedQuery(name = "MProductOrg.findByCreatedby", query = "SELECT m FROM MProductOrg m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductOrg.findByUpdated", query = "SELECT m FROM MProductOrg m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductOrg.findByUpdatedby", query = "SELECT m FROM MProductOrg m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductOrg.findByCapacity", query = "SELECT m FROM MProductOrg m WHERE m.capacity = :capacity"),
    @NamedQuery(name = "MProductOrg.findByDelaymin", query = "SELECT m FROM MProductOrg m WHERE m.delaymin = :delaymin"),
    @NamedQuery(name = "MProductOrg.findByQtymax", query = "SELECT m FROM MProductOrg m WHERE m.qtymax = :qtymax"),
    @NamedQuery(name = "MProductOrg.findByQtymin", query = "SELECT m FROM MProductOrg m WHERE m.qtymin = :qtymin"),
    @NamedQuery(name = "MProductOrg.findByQtystd", query = "SELECT m FROM MProductOrg m WHERE m.qtystd = :qtystd"),
    @NamedQuery(name = "MProductOrg.findByQtytype", query = "SELECT m FROM MProductOrg m WHERE m.qtytype = :qtytype"),
    @NamedQuery(name = "MProductOrg.findByStockmin", query = "SELECT m FROM MProductOrg m WHERE m.stockmin = :stockmin"),
    @NamedQuery(name = "MProductOrg.findByAbc", query = "SELECT m FROM MProductOrg m WHERE m.abc = :abc")})
public class MProductOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_product_org_id")
    private String mProductOrgId;
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
    @Column(name = "capacity")
    private BigInteger capacity;
    @Column(name = "delaymin")
    private BigInteger delaymin;
    @Column(name = "qtymax")
    private BigInteger qtymax;
    @Column(name = "qtymin")
    private BigInteger qtymin;
    @Column(name = "qtystd")
    private BigInteger qtystd;
    @Size(max = 60)
    @Column(name = "qtytype")
    private String qtytype;
    @Column(name = "stockmin")
    private BigInteger stockmin;
    @Size(max = 60)
    @Column(name = "abc")
    private String abc;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "mrp_planner_id", referencedColumnName = "mrp_planner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpPlanner mrpPlannerId;
    @JoinColumn(name = "mrp_planningmethod_id", referencedColumnName = "mrp_planningmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpPlanningmethod mrpPlanningmethodId;

    public MProductOrg() {
    }

    public MProductOrg(String mProductOrgId) {
        this.mProductOrgId = mProductOrgId;
    }

    public MProductOrg(String mProductOrgId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mProductOrgId = mProductOrgId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMProductOrgId() {
        return mProductOrgId;
    }

    public void setMProductOrgId(String mProductOrgId) {
        this.mProductOrgId = mProductOrgId;
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

    public BigInteger getCapacity() {
        return capacity;
    }

    public void setCapacity(BigInteger capacity) {
        this.capacity = capacity;
    }

    public BigInteger getDelaymin() {
        return delaymin;
    }

    public void setDelaymin(BigInteger delaymin) {
        this.delaymin = delaymin;
    }

    public BigInteger getQtymax() {
        return qtymax;
    }

    public void setQtymax(BigInteger qtymax) {
        this.qtymax = qtymax;
    }

    public BigInteger getQtymin() {
        return qtymin;
    }

    public void setQtymin(BigInteger qtymin) {
        this.qtymin = qtymin;
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

    public BigInteger getStockmin() {
        return stockmin;
    }

    public void setStockmin(BigInteger stockmin) {
        this.stockmin = stockmin;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
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

    public MrpPlanner getMrpPlannerId() {
        return mrpPlannerId;
    }

    public void setMrpPlannerId(MrpPlanner mrpPlannerId) {
        this.mrpPlannerId = mrpPlannerId;
    }

    public MrpPlanningmethod getMrpPlanningmethodId() {
        return mrpPlanningmethodId;
    }

    public void setMrpPlanningmethodId(MrpPlanningmethod mrpPlanningmethodId) {
        this.mrpPlanningmethodId = mrpPlanningmethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductOrgId != null ? mProductOrgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductOrg)) {
            return false;
        }
        MProductOrg other = (MProductOrg) object;
        if ((this.mProductOrgId == null && other.mProductOrgId != null) || (this.mProductOrgId != null && !this.mProductOrgId.equals(other.mProductOrgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductOrg[ mProductOrgId=" + mProductOrgId + " ]";
    }
    
}
