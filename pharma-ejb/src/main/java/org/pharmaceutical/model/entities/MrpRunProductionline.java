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
@Table(name = "mrp_run_productionline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpRunProductionline.findAll", query = "SELECT m FROM MrpRunProductionline m"),
    @NamedQuery(name = "MrpRunProductionline.findByMrpRunProductionlineId", query = "SELECT m FROM MrpRunProductionline m WHERE m.mrpRunProductionlineId = :mrpRunProductionlineId"),
    @NamedQuery(name = "MrpRunProductionline.findByIsactive", query = "SELECT m FROM MrpRunProductionline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpRunProductionline.findByCreated", query = "SELECT m FROM MrpRunProductionline m WHERE m.created = :created"),
    @NamedQuery(name = "MrpRunProductionline.findByCreatedby", query = "SELECT m FROM MrpRunProductionline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpRunProductionline.findByUpdated", query = "SELECT m FROM MrpRunProductionline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpRunProductionline.findByUpdatedby", query = "SELECT m FROM MrpRunProductionline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpRunProductionline.findByQty", query = "SELECT m FROM MrpRunProductionline m WHERE m.qty = :qty"),
    @NamedQuery(name = "MrpRunProductionline.findByNeededqty", query = "SELECT m FROM MrpRunProductionline m WHERE m.neededqty = :neededqty"),
    @NamedQuery(name = "MrpRunProductionline.findByPlanneddate", query = "SELECT m FROM MrpRunProductionline m WHERE m.planneddate = :planneddate"),
    @NamedQuery(name = "MrpRunProductionline.findByInouttrxtype", query = "SELECT m FROM MrpRunProductionline m WHERE m.inouttrxtype = :inouttrxtype"),
    @NamedQuery(name = "MrpRunProductionline.findByIsfixed", query = "SELECT m FROM MrpRunProductionline m WHERE m.isfixed = :isfixed"),
    @NamedQuery(name = "MrpRunProductionline.findByIsexploded", query = "SELECT m FROM MrpRunProductionline m WHERE m.isexploded = :isexploded"),
    @NamedQuery(name = "MrpRunProductionline.findByPlannedorderdate", query = "SELECT m FROM MrpRunProductionline m WHERE m.plannedorderdate = :plannedorderdate"),
    @NamedQuery(name = "MrpRunProductionline.findByIsplanned", query = "SELECT m FROM MrpRunProductionline m WHERE m.isplanned = :isplanned"),
    @NamedQuery(name = "MrpRunProductionline.findByCumqty", query = "SELECT m FROM MrpRunProductionline m WHERE m.cumqty = :cumqty"),
    @NamedQuery(name = "MrpRunProductionline.findByRecalculatestock", query = "SELECT m FROM MrpRunProductionline m WHERE m.recalculatestock = :recalculatestock")})
public class MrpRunProductionline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_run_productionline_id")
    private String mrpRunProductionlineId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "neededqty")
    private BigInteger neededqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planneddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planneddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "inouttrxtype")
    private String inouttrxtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isfixed")
    private Character isfixed;
    @Column(name = "isexploded")
    private Character isexploded;
    @Column(name = "plannedorderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedorderdate;
    @Column(name = "isplanned")
    private Character isplanned;
    @Column(name = "cumqty")
    private BigInteger cumqty;
    @Column(name = "recalculatestock")
    private Character recalculatestock;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderline cOrderlineId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_requisitionline_id", referencedColumnName = "m_requisitionline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MRequisitionline mRequisitionlineId;
    @JoinColumn(name = "ma_processplan_id", referencedColumnName = "ma_processplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaProcessplan maProcessplanId;
    @JoinColumn(name = "ma_workrequirement_id", referencedColumnName = "ma_workrequirement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaWorkrequirement maWorkrequirementId;
    @JoinColumn(name = "mrp_run_production_id", referencedColumnName = "mrp_run_production_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MrpRunProduction mrpRunProductionId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "parentId")
    private List<MrpRunProductionline> mrpRunProductionlineList;
    @JoinColumn(name = "parent_id", referencedColumnName = "mrp_run_productionline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpRunProductionline parentId;
    @JoinColumn(name = "mrp_salesforecastline_id", referencedColumnName = "mrp_salesforecastline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpSalesforecastline mrpSalesforecastlineId;

    public MrpRunProductionline() {
    }

    public MrpRunProductionline(String mrpRunProductionlineId) {
        this.mrpRunProductionlineId = mrpRunProductionlineId;
    }

    public MrpRunProductionline(String mrpRunProductionlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger qty, BigInteger neededqty, Date planneddate, String inouttrxtype, Character isfixed) {
        this.mrpRunProductionlineId = mrpRunProductionlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.qty = qty;
        this.neededqty = neededqty;
        this.planneddate = planneddate;
        this.inouttrxtype = inouttrxtype;
        this.isfixed = isfixed;
    }

    public String getMrpRunProductionlineId() {
        return mrpRunProductionlineId;
    }

    public void setMrpRunProductionlineId(String mrpRunProductionlineId) {
        this.mrpRunProductionlineId = mrpRunProductionlineId;
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

    public BigInteger getNeededqty() {
        return neededqty;
    }

    public void setNeededqty(BigInteger neededqty) {
        this.neededqty = neededqty;
    }

    public Date getPlanneddate() {
        return planneddate;
    }

    public void setPlanneddate(Date planneddate) {
        this.planneddate = planneddate;
    }

    public String getInouttrxtype() {
        return inouttrxtype;
    }

    public void setInouttrxtype(String inouttrxtype) {
        this.inouttrxtype = inouttrxtype;
    }

    public Character getIsfixed() {
        return isfixed;
    }

    public void setIsfixed(Character isfixed) {
        this.isfixed = isfixed;
    }

    public Character getIsexploded() {
        return isexploded;
    }

    public void setIsexploded(Character isexploded) {
        this.isexploded = isexploded;
    }

    public Date getPlannedorderdate() {
        return plannedorderdate;
    }

    public void setPlannedorderdate(Date plannedorderdate) {
        this.plannedorderdate = plannedorderdate;
    }

    public Character getIsplanned() {
        return isplanned;
    }

    public void setIsplanned(Character isplanned) {
        this.isplanned = isplanned;
    }

    public BigInteger getCumqty() {
        return cumqty;
    }

    public void setCumqty(BigInteger cumqty) {
        this.cumqty = cumqty;
    }

    public Character getRecalculatestock() {
        return recalculatestock;
    }

    public void setRecalculatestock(Character recalculatestock) {
        this.recalculatestock = recalculatestock;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MRequisitionline getMRequisitionlineId() {
        return mRequisitionlineId;
    }

    public void setMRequisitionlineId(MRequisitionline mRequisitionlineId) {
        this.mRequisitionlineId = mRequisitionlineId;
    }

    public MaProcessplan getMaProcessplanId() {
        return maProcessplanId;
    }

    public void setMaProcessplanId(MaProcessplan maProcessplanId) {
        this.maProcessplanId = maProcessplanId;
    }

    public MaWorkrequirement getMaWorkrequirementId() {
        return maWorkrequirementId;
    }

    public void setMaWorkrequirementId(MaWorkrequirement maWorkrequirementId) {
        this.maWorkrequirementId = maWorkrequirementId;
    }

    public MrpRunProduction getMrpRunProductionId() {
        return mrpRunProductionId;
    }

    public void setMrpRunProductionId(MrpRunProduction mrpRunProductionId) {
        this.mrpRunProductionId = mrpRunProductionId;
    }

    @XmlTransient
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
    }

    public MrpRunProductionline getParentId() {
        return parentId;
    }

    public void setParentId(MrpRunProductionline parentId) {
        this.parentId = parentId;
    }

    public MrpSalesforecastline getMrpSalesforecastlineId() {
        return mrpSalesforecastlineId;
    }

    public void setMrpSalesforecastlineId(MrpSalesforecastline mrpSalesforecastlineId) {
        this.mrpSalesforecastlineId = mrpSalesforecastlineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrpRunProductionlineId != null ? mrpRunProductionlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpRunProductionline)) {
            return false;
        }
        MrpRunProductionline other = (MrpRunProductionline) object;
        if ((this.mrpRunProductionlineId == null && other.mrpRunProductionlineId != null) || (this.mrpRunProductionlineId != null && !this.mrpRunProductionlineId.equals(other.mrpRunProductionlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpRunProductionline[ mrpRunProductionlineId=" + mrpRunProductionlineId + " ]";
    }
    
}
