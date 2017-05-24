/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "m_warehouse_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MWarehouseAcct.findAll", query = "SELECT m FROM MWarehouseAcct m"),
    @NamedQuery(name = "MWarehouseAcct.findByMWarehouseAcctId", query = "SELECT m FROM MWarehouseAcct m WHERE m.mWarehouseAcctId = :mWarehouseAcctId"),
    @NamedQuery(name = "MWarehouseAcct.findByIsactive", query = "SELECT m FROM MWarehouseAcct m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MWarehouseAcct.findByCreated", query = "SELECT m FROM MWarehouseAcct m WHERE m.created = :created"),
    @NamedQuery(name = "MWarehouseAcct.findByCreatedby", query = "SELECT m FROM MWarehouseAcct m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MWarehouseAcct.findByUpdated", query = "SELECT m FROM MWarehouseAcct m WHERE m.updated = :updated"),
    @NamedQuery(name = "MWarehouseAcct.findByUpdatedby", query = "SELECT m FROM MWarehouseAcct m WHERE m.updatedby = :updatedby")})
public class MWarehouseAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_warehouse_acct_id")
    private String mWarehouseAcctId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "w_invactualadjust_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination wInvactualadjustAcct;
    @JoinColumn(name = "w_differences_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination wDifferencesAcct;
    @JoinColumn(name = "w_revaluation_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination wRevaluationAcct;
    @JoinColumn(name = "w_inventory_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination wInventoryAcct;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;

    public MWarehouseAcct() {
    }

    public MWarehouseAcct(String mWarehouseAcctId) {
        this.mWarehouseAcctId = mWarehouseAcctId;
    }

    public MWarehouseAcct(String mWarehouseAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mWarehouseAcctId = mWarehouseAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMWarehouseAcctId() {
        return mWarehouseAcctId;
    }

    public void setMWarehouseAcctId(String mWarehouseAcctId) {
        this.mWarehouseAcctId = mWarehouseAcctId;
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

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CValidcombination getWInvactualadjustAcct() {
        return wInvactualadjustAcct;
    }

    public void setWInvactualadjustAcct(CValidcombination wInvactualadjustAcct) {
        this.wInvactualadjustAcct = wInvactualadjustAcct;
    }

    public CValidcombination getWDifferencesAcct() {
        return wDifferencesAcct;
    }

    public void setWDifferencesAcct(CValidcombination wDifferencesAcct) {
        this.wDifferencesAcct = wDifferencesAcct;
    }

    public CValidcombination getWRevaluationAcct() {
        return wRevaluationAcct;
    }

    public void setWRevaluationAcct(CValidcombination wRevaluationAcct) {
        this.wRevaluationAcct = wRevaluationAcct;
    }

    public CValidcombination getWInventoryAcct() {
        return wInventoryAcct;
    }

    public void setWInventoryAcct(CValidcombination wInventoryAcct) {
        this.wInventoryAcct = wInventoryAcct;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mWarehouseAcctId != null ? mWarehouseAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MWarehouseAcct)) {
            return false;
        }
        MWarehouseAcct other = (MWarehouseAcct) object;
        if ((this.mWarehouseAcctId == null && other.mWarehouseAcctId != null) || (this.mWarehouseAcctId != null && !this.mWarehouseAcctId.equals(other.mWarehouseAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MWarehouseAcct[ mWarehouseAcctId=" + mWarehouseAcctId + " ]";
    }
    
}
