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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_machine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMachine.findAll", query = "SELECT m FROM MaMachine m"),
    @NamedQuery(name = "MaMachine.findByMaMachineId", query = "SELECT m FROM MaMachine m WHERE m.maMachineId = :maMachineId"),
    @NamedQuery(name = "MaMachine.findByIsactive", query = "SELECT m FROM MaMachine m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMachine.findByCreated", query = "SELECT m FROM MaMachine m WHERE m.created = :created"),
    @NamedQuery(name = "MaMachine.findByCreatedby", query = "SELECT m FROM MaMachine m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMachine.findByUpdated", query = "SELECT m FROM MaMachine m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMachine.findByUpdatedby", query = "SELECT m FROM MaMachine m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMachine.findByName", query = "SELECT m FROM MaMachine m WHERE m.name = :name and m.isactive = :isactive"),
    @NamedQuery(name = "MaMachine.findByPurchaseyear", query = "SELECT m FROM MaMachine m WHERE m.purchaseyear = :purchaseyear"),
    @NamedQuery(name = "MaMachine.findByUsecycle", query = "SELECT m FROM MaMachine m WHERE m.usecycle = :usecycle"),
    @NamedQuery(name = "MaMachine.findByValue", query = "SELECT m FROM MaMachine m WHERE m.value = :value")
    
})
public class MaMachine extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_machine_id")
    private String maMachineId;
    
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
    @Column(name = "name")
    private String name;
    @Column(name = "purchaseyear")
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseyear;
    @Column(name = "usecycle")
    private BigInteger usecycle;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMachineId")
    private List<MaMaintenance> maMaintenanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMachineId")
    private List<MaSequenceMachine> maSequenceMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMachineId")
    private List<MaCostcenterMachine> maCostcenterMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMachineId")
    private List<MaMaintScheduled> maMaintScheduledList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMachineId")
    private List<MaMachinestation> maMachinestationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMachineId")
    private List<MaMachineCost> maMachineCostList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_costcenter_id", referencedColumnName = "ma_costcenter_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaCostcenter maCostcenterId;
    @JoinColumn(name = "ma_machine_type_id", referencedColumnName = "ma_machine_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMachineType maMachineTypeId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMachineId")
    private List<MaPlMachine> maPlMachineList;

    public MaMachine() {
    }

    public MaMachine(String maMachineId) {
        this.maMachineId = maMachineId;
    }

    public String getMaMachineId() {
        return maMachineId;
    }

    public void setMaMachineId(String maMachineId) {
        this.maMachineId = maMachineId;
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

    public Date getPurchaseyear() {
        return purchaseyear;
    }

    public void setPurchaseyear(Date purchaseyear) {
        this.purchaseyear = purchaseyear;
    }

    public BigInteger getUsecycle() {
        return usecycle;
    }

    public void setUsecycle(BigInteger usecycle) {
        this.usecycle = usecycle;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlTransient
    public List<MaMaintenance> getMaMaintenanceList() {
        return maMaintenanceList;
    }

    public void setMaMaintenanceList(List<MaMaintenance> maMaintenanceList) {
        this.maMaintenanceList = maMaintenanceList;
    }

    @XmlTransient
    public List<MaSequenceMachine> getMaSequenceMachineList() {
        return maSequenceMachineList;
    }

    public void setMaSequenceMachineList(List<MaSequenceMachine> maSequenceMachineList) {
        this.maSequenceMachineList = maSequenceMachineList;
    }

    @XmlTransient
    public List<MaCostcenterMachine> getMaCostcenterMachineList() {
        return maCostcenterMachineList;
    }

    public void setMaCostcenterMachineList(List<MaCostcenterMachine> maCostcenterMachineList) {
        this.maCostcenterMachineList = maCostcenterMachineList;
    }

    @XmlTransient
    public List<MaMaintScheduled> getMaMaintScheduledList() {
        return maMaintScheduledList;
    }

    public void setMaMaintScheduledList(List<MaMaintScheduled> maMaintScheduledList) {
        this.maMaintScheduledList = maMaintScheduledList;
    }

    @XmlTransient
    public List<MaMachinestation> getMaMachinestationList() {
        return maMachinestationList;
    }

    public void setMaMachinestationList(List<MaMachinestation> maMachinestationList) {
        this.maMachinestationList = maMachinestationList;
    }

    @XmlTransient
    public List<MaMachineCost> getMaMachineCostList() {
        return maMachineCostList;
    }

    public void setMaMachineCostList(List<MaMachineCost> maMachineCostList) {
        this.maMachineCostList = maMachineCostList;
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

    public MaCostcenter getMaCostcenterId() {
        return maCostcenterId;
    }

    public void setMaCostcenterId(MaCostcenter maCostcenterId) {
        this.maCostcenterId = maCostcenterId;
    }

    public MaMachineType getMaMachineTypeId() {
        return maMachineTypeId;
    }

    public void setMaMachineTypeId(MaMachineType maMachineTypeId) {
        this.maMachineTypeId = maMachineTypeId;
    }

    @XmlTransient
    public List<MaPlMachine> getMaPlMachineList() {
        return maPlMachineList;
    }

    public void setMaPlMachineList(List<MaPlMachine> maPlMachineList) {
        this.maPlMachineList = maPlMachineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMachineId != null ? maMachineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMachine)) {
            return false;
        }
        MaMachine other = (MaMachine) object;
        if ((this.maMachineId == null && other.maMachineId != null) || (this.maMachineId != null && !this.maMachineId.equals(other.maMachineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMachine[ maMachineId=" + maMachineId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maMachineId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maMachineId = id;
	}
    
}
