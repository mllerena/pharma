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
@Table(name = "ma_costcenter_ic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaCostcenterIc.findAll", query = "SELECT m FROM MaCostcenterIc m"),
    @NamedQuery(name = "MaCostcenterIc.findByMaCostcenterIcId", query = "SELECT m FROM MaCostcenterIc m WHERE m.maCostcenterIcId = :maCostcenterIcId"),
    @NamedQuery(name = "MaCostcenterIc.findByCreated", query = "SELECT m FROM MaCostcenterIc m WHERE m.created = :created"),
    @NamedQuery(name = "MaCostcenterIc.findByCreatedby", query = "SELECT m FROM MaCostcenterIc m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaCostcenterIc.findByUpdated", query = "SELECT m FROM MaCostcenterIc m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaCostcenterIc.findByUpdatedby", query = "SELECT m FROM MaCostcenterIc m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaCostcenterIc.findByIsactive", query = "SELECT m FROM MaCostcenterIc m WHERE m.isactive = :isactive")})
public class MaCostcenterIc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_costcenter_ic_id")
    private String maCostcenterIcId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_costcenter_version_id", referencedColumnName = "ma_costcenter_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaCostcenterVersion maCostcenterVersionId;
    @JoinColumn(name = "ma_indirect_cost_id", referencedColumnName = "ma_indirect_cost_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaIndirectCost maIndirectCostId;

    public MaCostcenterIc() {
    }

    public MaCostcenterIc(String maCostcenterIcId) {
        this.maCostcenterIcId = maCostcenterIcId;
    }

    public MaCostcenterIc(String maCostcenterIcId, Date created, String createdby, Date updated, String updatedby, Character isactive) {
        this.maCostcenterIcId = maCostcenterIcId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
    }

    public String getMaCostcenterIcId() {
        return maCostcenterIcId;
    }

    public void setMaCostcenterIcId(String maCostcenterIcId) {
        this.maCostcenterIcId = maCostcenterIcId;
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

    public MaCostcenterVersion getMaCostcenterVersionId() {
        return maCostcenterVersionId;
    }

    public void setMaCostcenterVersionId(MaCostcenterVersion maCostcenterVersionId) {
        this.maCostcenterVersionId = maCostcenterVersionId;
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
        hash += (maCostcenterIcId != null ? maCostcenterIcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaCostcenterIc)) {
            return false;
        }
        MaCostcenterIc other = (MaCostcenterIc) object;
        if ((this.maCostcenterIcId == null && other.maCostcenterIcId != null) || (this.maCostcenterIcId != null && !this.maCostcenterIcId.equals(other.maCostcenterIcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaCostcenterIc[ maCostcenterIcId=" + maCostcenterIcId + " ]";
    }
    
}
