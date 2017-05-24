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
@Table(name = "ma_toolsetused")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaToolsetused.findAll", query = "SELECT m FROM MaToolsetused m"),
    @NamedQuery(name = "MaToolsetused.findByIsactive", query = "SELECT m FROM MaToolsetused m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaToolsetused.findByCreated", query = "SELECT m FROM MaToolsetused m WHERE m.created = :created"),
    @NamedQuery(name = "MaToolsetused.findByCreatedby", query = "SELECT m FROM MaToolsetused m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaToolsetused.findByUpdated", query = "SELECT m FROM MaToolsetused m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaToolsetused.findByUpdatedby", query = "SELECT m FROM MaToolsetused m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaToolsetused.findByUsed", query = "SELECT m FROM MaToolsetused m WHERE m.used = :used"),
    @NamedQuery(name = "MaToolsetused.findByMaToolsetusedId", query = "SELECT m FROM MaToolsetused m WHERE m.maToolsetusedId = :maToolsetusedId"),
    @NamedQuery(name = "MaToolsetused.findByMProductionplanId", query = "SELECT m FROM MaToolsetused m WHERE m.mProductionplanId = :mProductionplanId and m.isactive = :isactive")
})
public class MaToolsetused extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
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
    @NotNull
    @Column(name = "used")
    private BigInteger used;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ma_toolsetused_id")
    private String maToolsetusedId;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_productionplan_id", referencedColumnName = "m_productionplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductionplan mProductionplanId;
    @JoinColumn(name = "ma_toolset_id", referencedColumnName = "ma_toolset_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaToolset maToolsetId;

    public MaToolsetused() {
    }

    public MaToolsetused(String maToolsetusedId) {
        this.maToolsetusedId = maToolsetusedId;
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

    public BigInteger getUsed() {
        return used;
    }

    public void setUsed(BigInteger used) {
        this.used = used;
    }

    public String getMaToolsetusedId() {
        return maToolsetusedId;
    }

    public void setMaToolsetusedId(String maToolsetusedId) {
        this.maToolsetusedId = maToolsetusedId;
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

    public MaToolset getMaToolsetId() {
        return maToolsetId;
    }

    public void setMaToolsetId(MaToolset maToolsetId) {
        this.maToolsetId = maToolsetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maToolsetusedId != null ? maToolsetusedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaToolsetused)) {
            return false;
        }
        MaToolsetused other = (MaToolsetused) object;
        if ((this.maToolsetusedId == null && other.maToolsetusedId != null) || (this.maToolsetusedId != null && !this.maToolsetusedId.equals(other.maToolsetusedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaToolsetused[ maToolsetusedId=" + maToolsetusedId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maToolsetusedId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maToolsetusedId = id;
	}
    
}
