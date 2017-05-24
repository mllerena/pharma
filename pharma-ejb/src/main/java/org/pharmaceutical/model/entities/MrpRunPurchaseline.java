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
@Table(name = "mrp_run_purchaseline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpRunPurchaseline.findAll", query = "SELECT m FROM MrpRunPurchaseline m"),
    @NamedQuery(name = "MrpRunPurchaseline.findByMrpRunPurchaselineId", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.mrpRunPurchaselineId = :mrpRunPurchaselineId"),
    @NamedQuery(name = "MrpRunPurchaseline.findByIsactive", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpRunPurchaseline.findByCreated", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.created = :created"),
    @NamedQuery(name = "MrpRunPurchaseline.findByCreatedby", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpRunPurchaseline.findByUpdated", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpRunPurchaseline.findByUpdatedby", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpRunPurchaseline.findByQty", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.qty = :qty"),
    @NamedQuery(name = "MrpRunPurchaseline.findByNeededqty", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.neededqty = :neededqty"),
    @NamedQuery(name = "MrpRunPurchaseline.findByPlanneddate", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.planneddate = :planneddate"),
    @NamedQuery(name = "MrpRunPurchaseline.findByInouttrxtype", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.inouttrxtype = :inouttrxtype"),
    @NamedQuery(name = "MrpRunPurchaseline.findByIsfixed", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.isfixed = :isfixed"),
    @NamedQuery(name = "MrpRunPurchaseline.findByIscompleted", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.iscompleted = :iscompleted"),
    @NamedQuery(name = "MrpRunPurchaseline.findByPlannedorderdate", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.plannedorderdate = :plannedorderdate"),
    @NamedQuery(name = "MrpRunPurchaseline.findByCumqty", query = "SELECT m FROM MrpRunPurchaseline m WHERE m.cumqty = :cumqty")})
public class MrpRunPurchaseline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_run_purchaseline_id")
    private String mrpRunPurchaselineId;
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
    @Column(name = "iscompleted")
    private Character iscompleted;
    @Column(name = "plannedorderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedorderdate;
    @Column(name = "cumqty")
    private BigInteger cumqty;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderline cOrderlineId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_requisitionline_id", referencedColumnName = "m_requisitionline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MRequisitionline mRequisitionlineId;
    @JoinColumn(name = "ma_workrequirement_id", referencedColumnName = "ma_workrequirement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaWorkrequirement maWorkrequirementId;
    @JoinColumn(name = "mrp_run_purchase_id", referencedColumnName = "mrp_run_purchase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MrpRunPurchase mrpRunPurchaseId;
    @JoinColumn(name = "mrp_salesforecastline_id", referencedColumnName = "mrp_salesforecastline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpSalesforecastline mrpSalesforecastlineId;

    public MrpRunPurchaseline() {
    }

    public MrpRunPurchaseline(String mrpRunPurchaselineId) {
        this.mrpRunPurchaselineId = mrpRunPurchaselineId;
    }

    public MrpRunPurchaseline(String mrpRunPurchaselineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger qty, BigInteger neededqty, Date planneddate, String inouttrxtype, Character isfixed) {
        this.mrpRunPurchaselineId = mrpRunPurchaselineId;
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

    public String getMrpRunPurchaselineId() {
        return mrpRunPurchaselineId;
    }

    public void setMrpRunPurchaselineId(String mrpRunPurchaselineId) {
        this.mrpRunPurchaselineId = mrpRunPurchaselineId;
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

    public Character getIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(Character iscompleted) {
        this.iscompleted = iscompleted;
    }

    public Date getPlannedorderdate() {
        return plannedorderdate;
    }

    public void setPlannedorderdate(Date plannedorderdate) {
        this.plannedorderdate = plannedorderdate;
    }

    public BigInteger getCumqty() {
        return cumqty;
    }

    public void setCumqty(BigInteger cumqty) {
        this.cumqty = cumqty;
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

    public MaWorkrequirement getMaWorkrequirementId() {
        return maWorkrequirementId;
    }

    public void setMaWorkrequirementId(MaWorkrequirement maWorkrequirementId) {
        this.maWorkrequirementId = maWorkrequirementId;
    }

    public MrpRunPurchase getMrpRunPurchaseId() {
        return mrpRunPurchaseId;
    }

    public void setMrpRunPurchaseId(MrpRunPurchase mrpRunPurchaseId) {
        this.mrpRunPurchaseId = mrpRunPurchaseId;
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
        hash += (mrpRunPurchaselineId != null ? mrpRunPurchaselineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpRunPurchaseline)) {
            return false;
        }
        MrpRunPurchaseline other = (MrpRunPurchaseline) object;
        if ((this.mrpRunPurchaselineId == null && other.mrpRunPurchaselineId != null) || (this.mrpRunPurchaselineId != null && !this.mrpRunPurchaselineId.equals(other.mrpRunPurchaselineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpRunPurchaseline[ mrpRunPurchaselineId=" + mrpRunPurchaselineId + " ]";
    }
    
}
