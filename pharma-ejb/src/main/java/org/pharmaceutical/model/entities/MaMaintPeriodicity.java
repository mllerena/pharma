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
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.PeriodicityTypeConverter;
import org.pharmaceutical.model.converters.ShiftTypeConverter;
import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.PeriodicityType;
import org.pharmaceutical.model.enums.ShiftType;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_maint_periodicity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMaintPeriodicity.findAll", query = "SELECT m FROM MaMaintPeriodicity m"),
    @NamedQuery(name = "MaMaintPeriodicity.findByMaMaintPeriodicityId", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.maMaintPeriodicityId = :maMaintPeriodicityId"),
    @NamedQuery(name = "MaMaintPeriodicity.findByIsactive", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMaintPeriodicity.findByCreated", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.created = :created"),
    @NamedQuery(name = "MaMaintPeriodicity.findByCreatedby", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMaintPeriodicity.findByUpdated", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMaintPeriodicity.findByUpdatedby", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMaintPeriodicity.findByPeriodicityType", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.periodicityType = :periodicityType"),
    @NamedQuery(name = "MaMaintPeriodicity.findByWeekday", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.weekday = :weekday"),
    @NamedQuery(name = "MaMaintPeriodicity.findByMonthday", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.monthday = :monthday"),
    @NamedQuery(name = "MaMaintPeriodicity.findByShift", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.shift = :shift"),
    @NamedQuery(name = "MaMaintPeriodicity.findByInitdate", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.initdate = :initdate"),
    @NamedQuery(name = "MaMaintPeriodicity.findByExcludeweekend", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.excludeweekend = :excludeweekend"),
    @NamedQuery(name = "MaMaintPeriodicity.findByMaMaintenanceId", query = "SELECT m FROM MaMaintPeriodicity m WHERE m.maMaintenanceId = :maMaintenanceId and m.isactive = :isactive")
    
})
public class MaMaintPeriodicity extends AbstractEntityModel implements Serializable { 
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_maint_periodicity_id")
    private String maMaintPeriodicityId;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive;
    
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    
    @Column(name = "periodicity_type")
    @Convert(converter=PeriodicityTypeConverter.class)  
    private PeriodicityType periodicityType;
    
    
    @Column(name = "weekday")
    private String weekday;
    
    @Column(name = "monthday")
    private BigInteger monthday;
    
    
    @Column(name = "shift")
    @Convert(converter=ShiftTypeConverter.class)   
    private ShiftType shift;
    
    @Column(name = "initdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initdate;
    
    @Column(name = "excludeweekend")
    @Convert(converter=YesNoConverter.class) 
    private YesNo excludeweekend; 
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_maintenance_id", referencedColumnName = "ma_maintenance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMaintenance maMaintenanceId;

    public MaMaintPeriodicity() {  
    }

    public MaMaintPeriodicity(String maMaintPeriodicityId) {
        this.maMaintPeriodicityId = maMaintPeriodicityId;
    }

    public String getMaMaintPeriodicityId() {
        return maMaintPeriodicityId;
    }

    public void setMaMaintPeriodicityId(String maMaintPeriodicityId) {
        this.maMaintPeriodicityId = maMaintPeriodicityId;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
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

    public PeriodicityType getPeriodicityType() {
        return periodicityType;
    }

    public void setPeriodicityType(PeriodicityType periodicityType) {  
        this.periodicityType = periodicityType;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public BigInteger getMonthday() {
        return monthday;
    }

    public void setMonthday(BigInteger monthday) {
        this.monthday = monthday;
    }

    public ShiftType getShift() {
        return shift;
    }

    public void setShift(ShiftType shift) {   
        this.shift = shift;
    }

    public Date getInitdate() {
        return initdate;
    }

    public void setInitdate(Date initdate) {
        this.initdate = initdate;
    }

    public YesNo getExcludeweekend() {
        return excludeweekend;
    }

    public void setExcludeweekend(YesNo excludeweekend) {
        this.excludeweekend = excludeweekend;
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

    public MaMaintenance getMaMaintenanceId() {
        return maMaintenanceId;
    }

    public void setMaMaintenanceId(MaMaintenance maMaintenanceId) {
        this.maMaintenanceId = maMaintenanceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMaintPeriodicityId != null ? maMaintPeriodicityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMaintPeriodicity)) {
            return false;
        }
        MaMaintPeriodicity other = (MaMaintPeriodicity) object;
        if ((this.maMaintPeriodicityId == null && other.maMaintPeriodicityId != null) || (this.maMaintPeriodicityId != null && !this.maMaintPeriodicityId.equals(other.maMaintPeriodicityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMaintPeriodicity[ maMaintPeriodicityId=" + maMaintPeriodicityId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maMaintPeriodicityId; 
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maMaintPeriodicityId = id;
	}
    
}
