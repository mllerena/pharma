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
@Table(name = "ma_sequence_machine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaSequenceMachine.findAll", query = "SELECT m FROM MaSequenceMachine m"),
    @NamedQuery(name = "MaSequenceMachine.findByMaSequenceMachineId", query = "SELECT m FROM MaSequenceMachine m WHERE m.maSequenceMachineId = :maSequenceMachineId"),
    @NamedQuery(name = "MaSequenceMachine.findByIsactive", query = "SELECT m FROM MaSequenceMachine m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaSequenceMachine.findByCreated", query = "SELECT m FROM MaSequenceMachine m WHERE m.created = :created"),
    @NamedQuery(name = "MaSequenceMachine.findByCreatedby", query = "SELECT m FROM MaSequenceMachine m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaSequenceMachine.findByUpdated", query = "SELECT m FROM MaSequenceMachine m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaSequenceMachine.findByUpdatedby", query = "SELECT m FROM MaSequenceMachine m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaSequenceMachine.findByCalccost", query = "SELECT m FROM MaSequenceMachine m WHERE m.calccost = :calccost")})
public class MaSequenceMachine extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_sequence_machine_id")
    private String maSequenceMachineId;
    
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
    
    @Column(name = "calccost")
    private BigDecimal calccost;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_machine_id", referencedColumnName = "ma_machine_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMachine maMachineId;
    @JoinColumn(name = "ma_sequence_id", referencedColumnName = "ma_sequence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaSequence maSequenceId;

    public MaSequenceMachine() {
    }

    public MaSequenceMachine(String maSequenceMachineId) {
        this.maSequenceMachineId = maSequenceMachineId;
    }

    public String getMaSequenceMachineId() {
        return maSequenceMachineId;
    }

    public void setMaSequenceMachineId(String maSequenceMachineId) {
        this.maSequenceMachineId = maSequenceMachineId;
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

    public MaMachine getMaMachineId() {
        return maMachineId;
    }

    public void setMaMachineId(MaMachine maMachineId) {
        this.maMachineId = maMachineId;
    }

    public MaSequence getMaSequenceId() {
        return maSequenceId;
    }

    public void setMaSequenceId(MaSequence maSequenceId) {
        this.maSequenceId = maSequenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSequenceMachineId != null ? maSequenceMachineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaSequenceMachine)) {
            return false;
        }
        MaSequenceMachine other = (MaSequenceMachine) object;
        if ((this.maSequenceMachineId == null && other.maSequenceMachineId != null) || (this.maSequenceMachineId != null && !this.maSequenceMachineId.equals(other.maSequenceMachineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaSequenceMachine[ maSequenceMachineId=" + maSequenceMachineId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maSequenceMachineId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maSequenceMachineId = id;
	}
    
}
