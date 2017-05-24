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

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_machinestation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMachinestation.findAll", query = "SELECT m FROM MaMachinestation m"),
    @NamedQuery(name = "MaMachinestation.findByMaMachinestationId", query = "SELECT m FROM MaMachinestation m WHERE m.maMachinestationId = :maMachinestationId"),
    @NamedQuery(name = "MaMachinestation.findByIsactive", query = "SELECT m FROM MaMachinestation m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMachinestation.findByCreated", query = "SELECT m FROM MaMachinestation m WHERE m.created = :created"),
    @NamedQuery(name = "MaMachinestation.findByCreatedby", query = "SELECT m FROM MaMachinestation m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMachinestation.findByUpdated", query = "SELECT m FROM MaMachinestation m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMachinestation.findByUpdatedby", query = "SELECT m FROM MaMachinestation m WHERE m.updatedby = :updatedby"), 
    @NamedQuery(name = "MaMachinestation.findByMaWorkstationId", query = "SELECT m FROM MaMachinestation m WHERE m.maWorkstationId = :maWorkstationId and m.isactive = :isactive")    
})


public class MaMachinestation extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ma_machinestation_id")
    private String maMachinestationId;
    
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_machine_id", referencedColumnName = "ma_machine_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMachine maMachineId;
    @JoinColumn(name = "ma_workstation_id", referencedColumnName = "ma_workstation_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaWorkstation maWorkstationId;

    public MaMachinestation() {
    }

    public MaMachinestation(String maMachinestationId) {
        this.maMachinestationId = maMachinestationId;
    }

    public String getMaMachinestationId() {
        return maMachinestationId;
    }

    public void setMaMachinestationId(String maMachinestationId) {
        this.maMachinestationId = maMachinestationId;
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

    public MaWorkstation getMaWorkstationId() {
        return maWorkstationId;
    }

    public void setMaWorkstationId(MaWorkstation maWorkstationId) {
        this.maWorkstationId = maWorkstationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMachinestationId != null ? maMachinestationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMachinestation)) {
            return false;
        }
        MaMachinestation other = (MaMachinestation) object;
        if ((this.maMachinestationId == null && other.maMachinestationId != null) || (this.maMachinestationId != null && !this.maMachinestationId.equals(other.maMachinestationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMachinestation[ maMachinestationId=" + maMachinestationId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maMachinestationId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maMachinestationId = id;
	}
    
}
