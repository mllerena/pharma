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
@Table(name = "ma_weemployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaWeemployee.findAll", query = "SELECT m FROM MaWeemployee m"),
    @NamedQuery(name = "MaWeemployee.findByMaWeemployeeId", query = "SELECT m FROM MaWeemployee m WHERE m.maWeemployeeId = :maWeemployeeId"),
    @NamedQuery(name = "MaWeemployee.findByIsactive", query = "SELECT m FROM MaWeemployee m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaWeemployee.findByCreated", query = "SELECT m FROM MaWeemployee m WHERE m.created = :created"),
    @NamedQuery(name = "MaWeemployee.findByCreatedby", query = "SELECT m FROM MaWeemployee m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaWeemployee.findByUpdated", query = "SELECT m FROM MaWeemployee m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaWeemployee.findByUpdatedby", query = "SELECT m FROM MaWeemployee m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaWeemployee.findByMProductionId", query = "SELECT m FROM MaWeemployee m WHERE m.mProductionId = :mProductionId and m.isactive = :isactive")
    
    
    
})
public class MaWeemployee extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_weemployee_id")
    private String maWeemployeeId;
    
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
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "m_production_id", referencedColumnName = "m_production_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduction mProductionId;

    public MaWeemployee() {
    }

    public MaWeemployee(String maWeemployeeId) {
        this.maWeemployeeId = maWeemployeeId;
    }

    public String getMaWeemployeeId() {
        return maWeemployeeId;
    }

    public void setMaWeemployeeId(String maWeemployeeId) {
        this.maWeemployeeId = maWeemployeeId;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public MProduction getMProductionId() {
        return mProductionId;
    }

    public void setMProductionId(MProduction mProductionId) {
        this.mProductionId = mProductionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maWeemployeeId != null ? maWeemployeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaWeemployee)) {
            return false;
        }
        MaWeemployee other = (MaWeemployee) object;
        if ((this.maWeemployeeId == null && other.maWeemployeeId != null) || (this.maWeemployeeId != null && !this.maWeemployeeId.equals(other.maWeemployeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaWeemployee[ maWeemployeeId=" + maWeemployeeId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maWeemployeeId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maWeemployeeId = id;
	}
    
}
