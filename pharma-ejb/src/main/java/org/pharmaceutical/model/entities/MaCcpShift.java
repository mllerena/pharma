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
@Table(name = "ma_ccp_shift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaCcpShift.findAll", query = "SELECT m FROM MaCcpShift m"),
    @NamedQuery(name = "MaCcpShift.findByMaCcpShiftId", query = "SELECT m FROM MaCcpShift m WHERE m.maCcpShiftId = :maCcpShiftId"),
    @NamedQuery(name = "MaCcpShift.findByIsactive", query = "SELECT m FROM MaCcpShift m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaCcpShift.findByCreated", query = "SELECT m FROM MaCcpShift m WHERE m.created = :created"),
    @NamedQuery(name = "MaCcpShift.findByCreatedby", query = "SELECT m FROM MaCcpShift m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaCcpShift.findByUpdated", query = "SELECT m FROM MaCcpShift m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaCcpShift.findByUpdatedby", query = "SELECT m FROM MaCcpShift m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaCcpShift.findByStarttime", query = "SELECT m FROM MaCcpShift m WHERE m.starttime = :starttime"),
    @NamedQuery(name = "MaCcpShift.findByEndtime", query = "SELECT m FROM MaCcpShift m WHERE m.endtime = :endtime"),
    @NamedQuery(name = "MaCcpShift.findByShift", query = "SELECT m FROM MaCcpShift m WHERE m.shift = :shift")})
public class MaCcpShift implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_ccp_shift_id")
    private String maCcpShiftId;
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
    @Column(name = "starttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "shift")
    private String shift;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_ccp_group_id", referencedColumnName = "ma_ccp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaCcpGroup maCcpGroupId;

    public MaCcpShift() {
    }

    public MaCcpShift(String maCcpShiftId) {
        this.maCcpShiftId = maCcpShiftId;
    }

    public MaCcpShift(String maCcpShiftId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date starttime, Date endtime, String shift) {
        this.maCcpShiftId = maCcpShiftId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.starttime = starttime;
        this.endtime = endtime;
        this.shift = shift;
    }

    public String getMaCcpShiftId() {
        return maCcpShiftId;
    }

    public void setMaCcpShiftId(String maCcpShiftId) {
        this.maCcpShiftId = maCcpShiftId;
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
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

    public MaCcpGroup getMaCcpGroupId() {
        return maCcpGroupId;
    }

    public void setMaCcpGroupId(MaCcpGroup maCcpGroupId) {
        this.maCcpGroupId = maCcpGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCcpShiftId != null ? maCcpShiftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaCcpShift)) {
            return false;
        }
        MaCcpShift other = (MaCcpShift) object;
        if ((this.maCcpShiftId == null && other.maCcpShiftId != null) || (this.maCcpShiftId != null && !this.maCcpShiftId.equals(other.maCcpShiftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaCcpShift[ maCcpShiftId=" + maCcpShiftId + " ]";
    }
    
}
