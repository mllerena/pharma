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
@Table(name = "m_requisitionorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRequisitionorder.findAll", query = "SELECT m FROM MRequisitionorder m"),
    @NamedQuery(name = "MRequisitionorder.findByMRequisitionorderId", query = "SELECT m FROM MRequisitionorder m WHERE m.mRequisitionorderId = :mRequisitionorderId"),
    @NamedQuery(name = "MRequisitionorder.findByCreated", query = "SELECT m FROM MRequisitionorder m WHERE m.created = :created"),
    @NamedQuery(name = "MRequisitionorder.findByCreatedby", query = "SELECT m FROM MRequisitionorder m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MRequisitionorder.findByUpdated", query = "SELECT m FROM MRequisitionorder m WHERE m.updated = :updated"),
    @NamedQuery(name = "MRequisitionorder.findByUpdatedby", query = "SELECT m FROM MRequisitionorder m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MRequisitionorder.findByIsactive", query = "SELECT m FROM MRequisitionorder m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MRequisitionorder.findByQty", query = "SELECT m FROM MRequisitionorder m WHERE m.qty = :qty")})
public class MRequisitionorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_requisitionorder_id")
    private String mRequisitionorderId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private BigInteger qty;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private COrderline cOrderlineId;
    @JoinColumn(name = "m_requisitionline_id", referencedColumnName = "m_requisitionline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MRequisitionline mRequisitionlineId;

    public MRequisitionorder() {
    }

    public MRequisitionorder(String mRequisitionorderId) {
        this.mRequisitionorderId = mRequisitionorderId;
    }

    public MRequisitionorder(String mRequisitionorderId, Date created, String createdby, Date updated, String updatedby, Character isactive, BigInteger qty) {
        this.mRequisitionorderId = mRequisitionorderId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.qty = qty;
    }

    public String getMRequisitionorderId() {
        return mRequisitionorderId;
    }

    public void setMRequisitionorderId(String mRequisitionorderId) {
        this.mRequisitionorderId = mRequisitionorderId;
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

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
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

    public MRequisitionline getMRequisitionlineId() {
        return mRequisitionlineId;
    }

    public void setMRequisitionlineId(MRequisitionline mRequisitionlineId) {
        this.mRequisitionlineId = mRequisitionlineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mRequisitionorderId != null ? mRequisitionorderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRequisitionorder)) {
            return false;
        }
        MRequisitionorder other = (MRequisitionorder) object;
        if ((this.mRequisitionorderId == null && other.mRequisitionorderId != null) || (this.mRequisitionorderId != null && !this.mRequisitionorderId.equals(other.mRequisitionorderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MRequisitionorder[ mRequisitionorderId=" + mRequisitionorderId + " ]";
    }
    
}
