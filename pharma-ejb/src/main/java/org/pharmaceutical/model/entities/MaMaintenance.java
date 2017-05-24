/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.CostUOMConverter;
import org.pharmaceutical.model.converters.MaintTypeConverter;
import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.MaintType;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_maintenance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMaintenance.findAll", query = "SELECT m FROM MaMaintenance m"),
    @NamedQuery(name = "MaMaintenance.findByMaMaintenanceId", query = "SELECT m FROM MaMaintenance m WHERE m.maMaintenanceId = :maMaintenanceId"),
    @NamedQuery(name = "MaMaintenance.findByIsactive", query = "SELECT m FROM MaMaintenance m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMaintenance.findByCreated", query = "SELECT m FROM MaMaintenance m WHERE m.created = :created"),
    @NamedQuery(name = "MaMaintenance.findByCreatedby", query = "SELECT m FROM MaMaintenance m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMaintenance.findByUpdated", query = "SELECT m FROM MaMaintenance m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMaintenance.findByUpdatedby", query = "SELECT m FROM MaMaintenance m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMaintenance.findByName", query = "SELECT m FROM MaMaintenance m WHERE m.name = :name"),
    @NamedQuery(name = "MaMaintenance.findByMaintenanceType", query = "SELECT m FROM MaMaintenance m WHERE m.maintenanceType = :maintenanceType"),
    @NamedQuery(name = "MaMaintenance.findByDescription", query = "SELECT m FROM MaMaintenance m WHERE m.description = :description"),
    @NamedQuery(name = "MaMaintenance.findByPlannedtime", query = "SELECT m FROM MaMaintenance m WHERE m.plannedtime = :plannedtime"),
    @NamedQuery(name = "MaMaintenance.findByExplode", query = "SELECT m FROM MaMaintenance m WHERE m.explode = :explode"),
    @NamedQuery(name = "MaMaintenance.findByMaMachineId", query = "SELECT m FROM MaMaintenance m WHERE m.maMachineId = :maMachineId and m.isactive = :isactive"),
    @NamedQuery(name = "MaMaintenance.findByMaMachineTypeId", query = "SELECT m FROM MaMaintenance m WHERE m.maMachineTypeId = :maMachineTypeId and m.isactive = :isactive")
    
})
public class MaMaintenance extends AbstractEntityModel  implements Serializable { 
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_maintenance_id")
    private String maMaintenanceId;
    
    @Basic(optional = false)
    @Convert(converter=YesNoConverter.class)
    @Column(name = "isactive")
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
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "maintenance_type")
    @Convert(converter=MaintTypeConverter.class)  
    private MaintType maintenanceType;
    
    @Column(name = "description")
    private String description;
    @Column(name = "plannedtime")
    private BigInteger plannedtime;
    
    @Column(name = "explode")
    @Convert(converter=YesNoConverter.class)
    private YesNo explode;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_machine_id", referencedColumnName = "ma_machine_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMachine maMachineId;
    @JoinColumn(name = "ma_machine_type_id", referencedColumnName = "ma_machine_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMachineType maMachineTypeId;
    @JoinColumn(name = "ma_maint_operation_id", referencedColumnName = "ma_maint_operation_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMaintOperation maMaintOperationId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMaintenanceId")
    private List<MaMaintScheduled> maMaintScheduledList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMaintenanceId")
    private List<MaMaintPeriodicity> maMaintPeriodicityList;

    public MaMaintenance() {
    }

    public MaMaintenance(String maMaintenanceId) {
        this.maMaintenanceId = maMaintenanceId;
    }

    public String getMaMaintenanceId() {
        return maMaintenanceId;
    }

    public void setMaMaintenanceId(String maMaintenanceId) {
        this.maMaintenanceId = maMaintenanceId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaintType getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintType maintenanceType) { 
        this.maintenanceType = maintenanceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getPlannedtime() {
        return plannedtime;
    }

    public void setPlannedtime(BigInteger plannedtime) {
        this.plannedtime = plannedtime;
    }

    public YesNo getExplode() {
        return explode;
    }

    public void setExplode(YesNo explode) { 
        this.explode = explode;
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

    @XmlTransient
    public List<MaMaintScheduled> getMaMaintScheduledList() {
        return maMaintScheduledList;
    }

    public void setMaMaintScheduledList(List<MaMaintScheduled> maMaintScheduledList) {
        this.maMaintScheduledList = maMaintScheduledList;
    }

    @XmlTransient
    public List<MaMaintPeriodicity> getMaMaintPeriodicityList() {
        return maMaintPeriodicityList;
    }

    public void setMaMaintPeriodicityList(List<MaMaintPeriodicity> maMaintPeriodicityList) {
        this.maMaintPeriodicityList = maMaintPeriodicityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMaintenanceId != null ? maMaintenanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMaintenance)) {
            return false;
        }
        MaMaintenance other = (MaMaintenance) object;
        if ((this.maMaintenanceId == null && other.maMaintenanceId != null) || (this.maMaintenanceId != null && !this.maMaintenanceId.equals(other.maMaintenanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMaintenance[ maMaintenanceId=" + maMaintenanceId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maMaintenanceId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maMaintenanceId = id;
	}
    
}
