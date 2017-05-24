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

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_costcenter_machine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaCostcenterMachine.findAll", query = "SELECT m FROM MaCostcenterMachine m"),
    @NamedQuery(name = "MaCostcenterMachine.findByMaCostcenterMachineId", query = "SELECT m FROM MaCostcenterMachine m WHERE m.maCostcenterMachineId = :maCostcenterMachineId"),
    @NamedQuery(name = "MaCostcenterMachine.findByCreated", query = "SELECT m FROM MaCostcenterMachine m WHERE m.created = :created"),
    @NamedQuery(name = "MaCostcenterMachine.findByCreatedby", query = "SELECT m FROM MaCostcenterMachine m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaCostcenterMachine.findByUpdated", query = "SELECT m FROM MaCostcenterMachine m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaCostcenterMachine.findByUpdatedby", query = "SELECT m FROM MaCostcenterMachine m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaCostcenterMachine.findByUse", query = "SELECT m FROM MaCostcenterMachine m WHERE m.use = :use"),
    @NamedQuery(name = "MaCostcenterMachine.findByIsactive", query = "SELECT m FROM MaCostcenterMachine m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaCostcenterMachine.findByMaCostcenterVersionId", query = "SELECT m FROM MaCostcenterMachine m WHERE m.maCostcenterVersionId = :maCostcenterVersionId and m.isactive = :isactive")
    
})
public class MaCostcenterMachine extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_costcenter_machine_id")
    private String maCostcenterMachineId;
    
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
    @Column(name = "use")
    private BigInteger use;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive;
    
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_costcenter_version_id", referencedColumnName = "ma_costcenter_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaCostcenterVersion maCostcenterVersionId;
    @JoinColumn(name = "ma_machine_id", referencedColumnName = "ma_machine_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMachine maMachineId;

    public MaCostcenterMachine() {
    }

    public MaCostcenterMachine(String maCostcenterMachineId) {
        this.maCostcenterMachineId = maCostcenterMachineId;
    }

    public String getMaCostcenterMachineId() {
        return maCostcenterMachineId;
    }

    public void setMaCostcenterMachineId(String maCostcenterMachineId) {
        this.maCostcenterMachineId = maCostcenterMachineId;
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

    public BigInteger getUse() {
        return use;
    }

    public void setUse(BigInteger use) {
        this.use = use;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
        this.isactive = isactive;
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

    public MaCostcenterVersion getMaCostcenterVersionId() {
        return maCostcenterVersionId;
    }

    public void setMaCostcenterVersionId(MaCostcenterVersion maCostcenterVersionId) {
        this.maCostcenterVersionId = maCostcenterVersionId;
    }

    public MaMachine getMaMachineId() {
        return maMachineId;
    }

    public void setMaMachineId(MaMachine maMachineId) {
        this.maMachineId = maMachineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCostcenterMachineId != null ? maCostcenterMachineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaCostcenterMachine)) {
            return false;
        }
        MaCostcenterMachine other = (MaCostcenterMachine) object;
        if ((this.maCostcenterMachineId == null && other.maCostcenterMachineId != null) || (this.maCostcenterMachineId != null && !this.maCostcenterMachineId.equals(other.maCostcenterMachineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaCostcenterMachine[ maCostcenterMachineId=" + maCostcenterMachineId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maCostcenterMachineId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maCostcenterMachineId =id;
	}
    
}
