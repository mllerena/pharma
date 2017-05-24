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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_maint_operation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMaintOperation.findAll", query = "SELECT m FROM MaMaintOperation m"),
    @NamedQuery(name = "MaMaintOperation.findByMaMaintOperationId", query = "SELECT m FROM MaMaintOperation m WHERE m.maMaintOperationId = :maMaintOperationId"),
    @NamedQuery(name = "MaMaintOperation.findByIsactive", query = "SELECT m FROM MaMaintOperation m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMaintOperation.findByCreated", query = "SELECT m FROM MaMaintOperation m WHERE m.created = :created"),
    @NamedQuery(name = "MaMaintOperation.findByCreatedby", query = "SELECT m FROM MaMaintOperation m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMaintOperation.findByUpdated", query = "SELECT m FROM MaMaintOperation m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMaintOperation.findByUpdatedby", query = "SELECT m FROM MaMaintOperation m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMaintOperation.findByName", query = "SELECT m FROM MaMaintOperation m WHERE m.name = :name and m.isactive = :isactive"),
    @NamedQuery(name = "MaMaintOperation.findByDescription", query = "SELECT m FROM MaMaintOperation m WHERE m.description = :description")})
public class MaMaintOperation extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false) 
    @Column(name = "ma_maint_operation_id")
    private String maMaintOperationId;
    
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
    @Column(name = "description")
    private String description;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMaintOperationId")
    private List<MaMaintenance> maMaintenanceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMaintOperationId")
    private List<MaMaintScheduled> maMaintScheduledList;

    public MaMaintOperation() {
    }

    public MaMaintOperation(String maMaintOperationId) {
        this.maMaintOperationId = maMaintOperationId;
    }

    public String getMaMaintOperationId() {
        return maMaintOperationId;
    }

    public void setMaMaintOperationId(String maMaintOperationId) {
        this.maMaintOperationId = maMaintOperationId;
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

    @XmlTransient
    public List<MaMaintScheduled> getMaMaintScheduledList() {
        return maMaintScheduledList;
    }

    public void setMaMaintScheduledList(List<MaMaintScheduled> maMaintScheduledList) {
        this.maMaintScheduledList = maMaintScheduledList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMaintOperationId != null ? maMaintOperationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMaintOperation)) {
            return false;
        }
        MaMaintOperation other = (MaMaintOperation) object;
        if ((this.maMaintOperationId == null && other.maMaintOperationId != null) || (this.maMaintOperationId != null && !this.maMaintOperationId.equals(other.maMaintOperationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMaintOperation[ maMaintOperationId=" + maMaintOperationId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maMaintOperationId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maMaintOperationId = id;
	}
    
}
