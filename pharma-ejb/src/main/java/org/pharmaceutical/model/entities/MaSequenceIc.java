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
@Table(name = "ma_sequence_ic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaSequenceIc.findAll", query = "SELECT m FROM MaSequenceIc m"),
    @NamedQuery(name = "MaSequenceIc.findByMaSequenceIcId", query = "SELECT m FROM MaSequenceIc m WHERE m.maSequenceIcId = :maSequenceIcId"),
    @NamedQuery(name = "MaSequenceIc.findByIsactive", query = "SELECT m FROM MaSequenceIc m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaSequenceIc.findByCreated", query = "SELECT m FROM MaSequenceIc m WHERE m.created = :created"),
    @NamedQuery(name = "MaSequenceIc.findByCreatedby", query = "SELECT m FROM MaSequenceIc m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaSequenceIc.findByUpdated", query = "SELECT m FROM MaSequenceIc m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaSequenceIc.findByUpdatedby", query = "SELECT m FROM MaSequenceIc m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaSequenceIc.findByCalccost", query = "SELECT m FROM MaSequenceIc m WHERE m.calccost = :calccost")})
public class MaSequenceIc extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_sequence_ic_id")
    private String maSequenceIcId;
    
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
    @JoinColumn(name = "ma_indirect_cost_id", referencedColumnName = "ma_indirect_cost_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaIndirectCost maIndirectCostId;
    @JoinColumn(name = "ma_sequence_id", referencedColumnName = "ma_sequence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaSequence maSequenceId;

    public MaSequenceIc() {
    }

    public MaSequenceIc(String maSequenceIcId) {
        this.maSequenceIcId = maSequenceIcId;
    }
    public String getMaSequenceIcId() {
        return maSequenceIcId;
    }

    public void setMaSequenceIcId(String maSequenceIcId) {
        this.maSequenceIcId = maSequenceIcId;
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

    public MaIndirectCost getMaIndirectCostId() {
        return maIndirectCostId;
    }

    public void setMaIndirectCostId(MaIndirectCost maIndirectCostId) {
        this.maIndirectCostId = maIndirectCostId;
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
        hash += (maSequenceIcId != null ? maSequenceIcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaSequenceIc)) {
            return false;
        }
        MaSequenceIc other = (MaSequenceIc) object;
        if ((this.maSequenceIcId == null && other.maSequenceIcId != null) || (this.maSequenceIcId != null && !this.maSequenceIcId.equals(other.maSequenceIcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaSequenceIc[ maSequenceIcId=" + maSequenceIcId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maSequenceIcId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maSequenceIcId = id;
	}
    
}
