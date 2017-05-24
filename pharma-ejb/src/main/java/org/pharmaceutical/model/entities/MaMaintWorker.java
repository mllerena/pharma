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
@Table(name = "ma_maint_worker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMaintWorker.findAll", query = "SELECT m FROM MaMaintWorker m"),
    @NamedQuery(name = "MaMaintWorker.findByMaMaintWorkerId", query = "SELECT m FROM MaMaintWorker m WHERE m.maMaintWorkerId = :maMaintWorkerId"),
    @NamedQuery(name = "MaMaintWorker.findByIsactive", query = "SELECT m FROM MaMaintWorker m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMaintWorker.findByCreated", query = "SELECT m FROM MaMaintWorker m WHERE m.created = :created"),
    @NamedQuery(name = "MaMaintWorker.findByCreatedby", query = "SELECT m FROM MaMaintWorker m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMaintWorker.findByUpdated", query = "SELECT m FROM MaMaintWorker m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMaintWorker.findByUpdatedby", query = "SELECT m FROM MaMaintWorker m WHERE m.updatedby = :updatedby")})
public class MaMaintWorker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_maint_worker_id")
    private String maMaintWorkerId;
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
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "ma_maint_part_id", referencedColumnName = "ma_maint_part_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMaintPart maMaintPartId;

    public MaMaintWorker() {
    }

    public MaMaintWorker(String maMaintWorkerId) {
        this.maMaintWorkerId = maMaintWorkerId;
    }

    public MaMaintWorker(String maMaintWorkerId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.maMaintWorkerId = maMaintWorkerId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMaMaintWorkerId() {
        return maMaintWorkerId;
    }

    public void setMaMaintWorkerId(String maMaintWorkerId) {
        this.maMaintWorkerId = maMaintWorkerId;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public MaMaintPart getMaMaintPartId() {
        return maMaintPartId;
    }

    public void setMaMaintPartId(MaMaintPart maMaintPartId) {
        this.maMaintPartId = maMaintPartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMaintWorkerId != null ? maMaintWorkerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMaintWorker)) {
            return false;
        }
        MaMaintWorker other = (MaMaintWorker) object;
        if ((this.maMaintWorkerId == null && other.maMaintWorkerId != null) || (this.maMaintWorkerId != null && !this.maMaintWorkerId.equals(other.maMaintWorkerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMaintWorker[ maMaintWorkerId=" + maMaintWorkerId + " ]";
    }
    
}
