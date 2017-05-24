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
@Table(name = "ma_maint_scheduled")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMaintScheduled.findAll", query = "SELECT m FROM MaMaintScheduled m"),
    @NamedQuery(name = "MaMaintScheduled.findByMaMaintScheduledId", query = "SELECT m FROM MaMaintScheduled m WHERE m.maMaintScheduledId = :maMaintScheduledId"),
    @NamedQuery(name = "MaMaintScheduled.findByIsactive", query = "SELECT m FROM MaMaintScheduled m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMaintScheduled.findByCreated", query = "SELECT m FROM MaMaintScheduled m WHERE m.created = :created"),
    @NamedQuery(name = "MaMaintScheduled.findByCreatedby", query = "SELECT m FROM MaMaintScheduled m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMaintScheduled.findByUpdated", query = "SELECT m FROM MaMaintScheduled m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMaintScheduled.findByUpdatedby", query = "SELECT m FROM MaMaintScheduled m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMaintScheduled.findByMaintenanceType", query = "SELECT m FROM MaMaintScheduled m WHERE m.maintenanceType = :maintenanceType"),
    @NamedQuery(name = "MaMaintScheduled.findByScheduleddate", query = "SELECT m FROM MaMaintScheduled m WHERE m.scheduleddate = :scheduleddate"),
    @NamedQuery(name = "MaMaintScheduled.findByConfirmed", query = "SELECT m FROM MaMaintScheduled m WHERE m.confirmed = :confirmed"),
    @NamedQuery(name = "MaMaintScheduled.findByShift", query = "SELECT m FROM MaMaintScheduled m WHERE m.shift = :shift"),
    @NamedQuery(name = "MaMaintScheduled.findByResult", query = "SELECT m FROM MaMaintScheduled m WHERE m.result = :result"),
    @NamedQuery(name = "MaMaintScheduled.findByObservation", query = "SELECT m FROM MaMaintScheduled m WHERE m.observation = :observation"),
    @NamedQuery(name = "MaMaintScheduled.findByUsedtime", query = "SELECT m FROM MaMaintScheduled m WHERE m.usedtime = :usedtime"),
    @NamedQuery(name = "MaMaintScheduled.findByDescription", query = "SELECT m FROM MaMaintScheduled m WHERE m.description = :description")})
public class MaMaintScheduled implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_maint_scheduled_id")
    private String maMaintScheduledId;
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
    @Column(name = "maintenance_type")
    private String maintenanceType;
    @Column(name = "scheduleddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduleddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "confirmed")
    private Character confirmed;
    @Size(max = 60)
    @Column(name = "shift")
    private String shift;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result")
    private Character result;
    @Size(max = 255)
    @Column(name = "observation")
    private String observation;
    @Column(name = "usedtime")
    private BigInteger usedtime;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_internal_consumption_id", referencedColumnName = "m_internal_consumption_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInternalConsumption mInternalConsumptionId;
    @JoinColumn(name = "ma_machine_id", referencedColumnName = "ma_machine_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMachine maMachineId;
    @JoinColumn(name = "ma_machine_type_id", referencedColumnName = "ma_machine_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMachineType maMachineTypeId;
    @JoinColumn(name = "ma_maint_operation_id", referencedColumnName = "ma_maint_operation_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMaintOperation maMaintOperationId;
    @JoinColumn(name = "ma_maint_part_id", referencedColumnName = "ma_maint_part_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMaintPart maMaintPartId;
    @JoinColumn(name = "ma_maintenance_id", referencedColumnName = "ma_maintenance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMaintenance maMaintenanceId;

    public MaMaintScheduled() {
    }

    public MaMaintScheduled(String maMaintScheduledId) {
        this.maMaintScheduledId = maMaintScheduledId;
    }

    public MaMaintScheduled(String maMaintScheduledId, Character isactive, Date created, String createdby, Date updated, String updatedby, String maintenanceType, Character confirmed, Character result) {
        this.maMaintScheduledId = maMaintScheduledId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.maintenanceType = maintenanceType;
        this.confirmed = confirmed;
        this.result = result;
    }

    public String getMaMaintScheduledId() {
        return maMaintScheduledId;
    }

    public void setMaMaintScheduledId(String maMaintScheduledId) {
        this.maMaintScheduledId = maMaintScheduledId;
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

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public Date getScheduleddate() {
        return scheduleddate;
    }

    public void setScheduleddate(Date scheduleddate) {
        this.scheduleddate = scheduleddate;
    }

    public Character getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Character confirmed) {
        this.confirmed = confirmed;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Character getResult() {
        return result;
    }

    public void setResult(Character result) {
        this.result = result;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public BigInteger getUsedtime() {
        return usedtime;
    }

    public void setUsedtime(BigInteger usedtime) {
        this.usedtime = usedtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public MInternalConsumption getMInternalConsumptionId() {
        return mInternalConsumptionId;
    }

    public void setMInternalConsumptionId(MInternalConsumption mInternalConsumptionId) {
        this.mInternalConsumptionId = mInternalConsumptionId;
    }

    public MaMachine getMaMachineId() {
        return maMachineId;
    }

    public void setMaMachineId(MaMachine maMachineId) {
        this.maMachineId = maMachineId;
    }

    public MaMachineType getMaMachineTypeId() {
        return maMachineTypeId;
    }

    public void setMaMachineTypeId(MaMachineType maMachineTypeId) {
        this.maMachineTypeId = maMachineTypeId;
    }

    public MaMaintOperation getMaMaintOperationId() {
        return maMaintOperationId;
    }

    public void setMaMaintOperationId(MaMaintOperation maMaintOperationId) {
        this.maMaintOperationId = maMaintOperationId;
    }

    public MaMaintPart getMaMaintPartId() {
        return maMaintPartId;
    }

    public void setMaMaintPartId(MaMaintPart maMaintPartId) {
        this.maMaintPartId = maMaintPartId;
    }

    public MaMaintenance getMaMaintenanceId() {
        return maMaintenanceId;
    }

    public void setMaMaintenanceId(MaMaintenance maMaintenanceId) {
        this.maMaintenanceId = maMaintenanceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMaintScheduledId != null ? maMaintScheduledId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMaintScheduled)) {
            return false;
        }
        MaMaintScheduled other = (MaMaintScheduled) object;
        if ((this.maMaintScheduledId == null && other.maMaintScheduledId != null) || (this.maMaintScheduledId != null && !this.maMaintScheduledId.equals(other.maMaintScheduledId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMaintScheduled[ maMaintScheduledId=" + maMaintScheduledId + " ]";
    }
    
}
