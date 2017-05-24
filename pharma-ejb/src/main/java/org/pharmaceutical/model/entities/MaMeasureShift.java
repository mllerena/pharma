/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "ma_measure_shift")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMeasureShift.findAll", query = "SELECT m FROM MaMeasureShift m"),
    @NamedQuery(name = "MaMeasureShift.findByMaMeasureShiftId", query = "SELECT m FROM MaMeasureShift m WHERE m.maMeasureShiftId = :maMeasureShiftId"),
    @NamedQuery(name = "MaMeasureShift.findByIsactive", query = "SELECT m FROM MaMeasureShift m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMeasureShift.findByCreated", query = "SELECT m FROM MaMeasureShift m WHERE m.created = :created"),
    @NamedQuery(name = "MaMeasureShift.findByCreatedby", query = "SELECT m FROM MaMeasureShift m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMeasureShift.findByUpdated", query = "SELECT m FROM MaMeasureShift m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMeasureShift.findByUpdatedby", query = "SELECT m FROM MaMeasureShift m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMeasureShift.findByShift", query = "SELECT m FROM MaMeasureShift m WHERE m.shift = :shift"),
    @NamedQuery(name = "MaMeasureShift.findByMeasuredate", query = "SELECT m FROM MaMeasureShift m WHERE m.measuredate = :measuredate"),
    @NamedQuery(name = "MaMeasureShift.findByObservation", query = "SELECT m FROM MaMeasureShift m WHERE m.observation = :observation"),
    @NamedQuery(name = "MaMeasureShift.findByEdit", query = "SELECT m FROM MaMeasureShift m WHERE m.edit = :edit"),
    @NamedQuery(name = "MaMeasureShift.findByProcessed", query = "SELECT m FROM MaMeasureShift m WHERE m.processed = :processed")})
public class MaMeasureShift implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_measure_shift_id")
    private String maMeasureShiftId;
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
    @Size(min = 1, max = 60)
    @Column(name = "shift")
    private String shift;
    @Basic(optional = false)
    @NotNull
    @Column(name = "measuredate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measuredate;
    @Size(max = 4000)
    @Column(name = "observation")
    private String observation;
    @Column(name = "edit")
    private Character edit;
    @Column(name = "processed")
    private Character processed;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMeasureShiftId")
    private List<MaMeasureGroup> maMeasureGroupList;

    public MaMeasureShift() {
    }

    public MaMeasureShift(String maMeasureShiftId) {
        this.maMeasureShiftId = maMeasureShiftId;
    }

    public MaMeasureShift(String maMeasureShiftId, Character isactive, Date created, String createdby, Date updated, String updatedby, String shift, Date measuredate) {
        this.maMeasureShiftId = maMeasureShiftId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.shift = shift;
        this.measuredate = measuredate;
    }

    public String getMaMeasureShiftId() {
        return maMeasureShiftId;
    }

    public void setMaMeasureShiftId(String maMeasureShiftId) {
        this.maMeasureShiftId = maMeasureShiftId;
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

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Date getMeasuredate() {
        return measuredate;
    }

    public void setMeasuredate(Date measuredate) {
        this.measuredate = measuredate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Character getEdit() {
        return edit;
    }

    public void setEdit(Character edit) {
        this.edit = edit;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    @XmlTransient
    public List<MaMeasureGroup> getMaMeasureGroupList() {
        return maMeasureGroupList;
    }

    public void setMaMeasureGroupList(List<MaMeasureGroup> maMeasureGroupList) {
        this.maMeasureGroupList = maMeasureGroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMeasureShiftId != null ? maMeasureShiftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMeasureShift)) {
            return false;
        }
        MaMeasureShift other = (MaMeasureShift) object;
        if ((this.maMeasureShiftId == null && other.maMeasureShiftId != null) || (this.maMeasureShiftId != null && !this.maMeasureShiftId.equals(other.maMeasureShiftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMeasureShift[ maMeasureShiftId=" + maMeasureShiftId + " ]";
    }
    
}
