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
@Table(name = "ma_pl_ic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaPlIc.findAll", query = "SELECT m FROM MaPlIc m"),
    @NamedQuery(name = "MaPlIc.findByMaPlIcId", query = "SELECT m FROM MaPlIc m WHERE m.maPlIcId = :maPlIcId"),
    @NamedQuery(name = "MaPlIc.findByCreated", query = "SELECT m FROM MaPlIc m WHERE m.created = :created"),
    @NamedQuery(name = "MaPlIc.findByCreatedby", query = "SELECT m FROM MaPlIc m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaPlIc.findByUpdated", query = "SELECT m FROM MaPlIc m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaPlIc.findByUpdatedby", query = "SELECT m FROM MaPlIc m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaPlIc.findByIsactive", query = "SELECT m FROM MaPlIc m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaPlIc.findByCalccost", query = "SELECT m FROM MaPlIc m WHERE m.calccost = :calccost")})
public class MaPlIc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_pl_ic_id")
    private String maPlIcId;
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
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "calccost")
    private BigInteger calccost;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_productionplan_id", referencedColumnName = "m_productionplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductionplan mProductionplanId;
    @JoinColumn(name = "ma_indirect_cost_id", referencedColumnName = "ma_indirect_cost_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaIndirectCost maIndirectCostId;

    public MaPlIc() {
    }

    public MaPlIc(String maPlIcId) {
        this.maPlIcId = maPlIcId;
    }

    public MaPlIc(String maPlIcId, Date created, String createdby, Date updated, String updatedby, Character isactive) {
        this.maPlIcId = maPlIcId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
    }

    public String getMaPlIcId() {
        return maPlIcId;
    }

    public void setMaPlIcId(String maPlIcId) {
        this.maPlIcId = maPlIcId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public BigInteger getCalccost() {
        return calccost;
    }

    public void setCalccost(BigInteger calccost) {
        this.calccost = calccost;
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

    public MProductionplan getMProductionplanId() {
        return mProductionplanId;
    }

    public void setMProductionplanId(MProductionplan mProductionplanId) {
        this.mProductionplanId = mProductionplanId;
    }

    public MaIndirectCost getMaIndirectCostId() {
        return maIndirectCostId;
    }

    public void setMaIndirectCostId(MaIndirectCost maIndirectCostId) {
        this.maIndirectCostId = maIndirectCostId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPlIcId != null ? maPlIcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaPlIc)) {
            return false;
        }
        MaPlIc other = (MaPlIc) object;
        if ((this.maPlIcId == null && other.maPlIcId != null) || (this.maPlIcId != null && !this.maPlIcId.equals(other.maPlIcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaPlIc[ maPlIcId=" + maPlIcId + " ]";
    }
    
}
