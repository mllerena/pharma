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
@Table(name = "ma_machine_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMachineType.findAll", query = "SELECT m FROM MaMachineType m"),
    @NamedQuery(name = "MaMachineType.findByMaMachineTypeId", query = "SELECT m FROM MaMachineType m WHERE m.maMachineTypeId = :maMachineTypeId"),
    @NamedQuery(name = "MaMachineType.findByIsactive", query = "SELECT m FROM MaMachineType m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMachineType.findByCreated", query = "SELECT m FROM MaMachineType m WHERE m.created = :created"),
    @NamedQuery(name = "MaMachineType.findByCreatedby", query = "SELECT m FROM MaMachineType m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMachineType.findByUpdated", query = "SELECT m FROM MaMachineType m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMachineType.findByUpdatedby", query = "SELECT m FROM MaMachineType m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMachineType.findByName", query = "SELECT m FROM MaMachineType m WHERE m.name = :name and m.isactive = :isactive"), 
    @NamedQuery(name = "MaMachineType.findByDescription", query = "SELECT m FROM MaMachineType m WHERE m.description = :description")})
public class MaMachineType extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_machine_type_id")
    private String maMachineTypeId;
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
    @Column(name = "description")
    private String description;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMachineTypeId")
    private List<MaMaintenance> maMaintenanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMachineTypeId")
    private List<MaMaintScheduled> maMaintScheduledList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMachineTypeId")
    private List<MaMachine> maMachineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public MaMachineType() {
    }

    public MaMachineType(String maMachineTypeId) {
        this.maMachineTypeId = maMachineTypeId;
    }

    public String getMaMachineTypeId() {
        return maMachineTypeId;
    }

    public void setMaMachineTypeId(String maMachineTypeId) {
        this.maMachineTypeId = maMachineTypeId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<MaMaintenance> getMaMaintenanceList() {
        return maMaintenanceList;
    }

    public void setMaMaintenanceList(List<MaMaintenance> maMaintenanceList) {
        this.maMaintenanceList = maMaintenanceList;
    }

    @XmlTransient
    public List<MaMaintScheduled> getMaMaintScheduledList() {
        return maMaintScheduledList;
    }

    public void setMaMaintScheduledList(List<MaMaintScheduled> maMaintScheduledList) {
        this.maMaintScheduledList = maMaintScheduledList;
    }

    @XmlTransient
    public List<MaMachine> getMaMachineList() {
        return maMachineList;
    }

    public void setMaMachineList(List<MaMachine> maMachineList) {
        this.maMachineList = maMachineList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMachineTypeId != null ? maMachineTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMachineType)) {
            return false;
        }
        MaMachineType other = (MaMachineType) object;
        if ((this.maMachineTypeId == null && other.maMachineTypeId != null) || (this.maMachineTypeId != null && !this.maMachineTypeId.equals(other.maMachineTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMachineType[ maMachineTypeId=" + maMachineTypeId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maMachineTypeId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maMachineTypeId = id; 
	}
    
}
