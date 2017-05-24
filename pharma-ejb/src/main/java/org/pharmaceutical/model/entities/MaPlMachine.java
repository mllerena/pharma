/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ma_pl_machine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaPlMachine.findAll", query = "SELECT m FROM MaPlMachine m"),
    @NamedQuery(name = "MaPlMachine.findByMaPlMachineId", query = "SELECT m FROM MaPlMachine m WHERE m.maPlMachineId = :maPlMachineId"),
    @NamedQuery(name = "MaPlMachine.findByCreated", query = "SELECT m FROM MaPlMachine m WHERE m.created = :created"),
    @NamedQuery(name = "MaPlMachine.findByCreatedby", query = "SELECT m FROM MaPlMachine m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaPlMachine.findByUpdated", query = "SELECT m FROM MaPlMachine m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaPlMachine.findByUpdatedby", query = "SELECT m FROM MaPlMachine m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaPlMachine.findByUse", query = "SELECT m FROM MaPlMachine m WHERE m.use = :use"),
    @NamedQuery(name = "MaPlMachine.findByIsactive", query = "SELECT m FROM MaPlMachine m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaPlMachine.findByCalccost", query = "SELECT m FROM MaPlMachine m WHERE m.calccost = :calccost"),
    @NamedQuery(name = "MaPlMachine.findByMProductionplanId", query = "SELECT m FROM MaPlMachine m WHERE m.mProductionplanId = :mProductionplanId and m.isactive = :isactive")
    
})
public class MaPlMachine extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_pl_machine_id")
    private String maPlMachineId;
    
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
    @Column(name = "use")
    private BigInteger use;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive; 
    
    
    @Column(name = "calccost")
    private BigDecimal calccost;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_productionplan_id", referencedColumnName = "m_productionplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductionplan mProductionplanId;
    @JoinColumn(name = "ma_machine_id", referencedColumnName = "ma_machine_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMachine maMachineId;

    public MaPlMachine() {
    }

    public MaPlMachine(String maPlMachineId) {
        this.maPlMachineId = maPlMachineId;
    }

    public String getMaPlMachineId() {
        return maPlMachineId;
    }

    public void setMaPlMachineId(String maPlMachineId) {
        this.maPlMachineId = maPlMachineId;
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

    public BigDecimal getCalccost() {
        return calccost;
    }

    public void setCalccost(BigDecimal calccost) {
        this.calccost = calccost;
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

    public MProductionplan getMProductionplanId() {
        return mProductionplanId;
    }

    public void setMProductionplanId(MProductionplan mProductionplanId) {
        this.mProductionplanId = mProductionplanId;
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
        hash += (maPlMachineId != null ? maPlMachineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaPlMachine)) {
            return false;
        }
        MaPlMachine other = (MaPlMachine) object;
        if ((this.maPlMachineId == null && other.maPlMachineId != null) || (this.maPlMachineId != null && !this.maPlMachineId.equals(other.maPlMachineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaPlMachine[ maPlMachineId=" + maPlMachineId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maPlMachineId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maPlMachineId = id;
	}
    
}
