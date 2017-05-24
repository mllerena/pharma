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
@Table(name = "ma_toolsetprocess")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaToolsetprocess.findAll", query = "SELECT m FROM MaToolsetprocess m"),
    @NamedQuery(name = "MaToolsetprocess.findByMaToolsetprocessId", query = "SELECT m FROM MaToolsetprocess m WHERE m.maToolsetprocessId = :maToolsetprocessId"),
    @NamedQuery(name = "MaToolsetprocess.findByIsactive", query = "SELECT m FROM MaToolsetprocess m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaToolsetprocess.findByCreated", query = "SELECT m FROM MaToolsetprocess m WHERE m.created = :created"),
    @NamedQuery(name = "MaToolsetprocess.findByCreatedby", query = "SELECT m FROM MaToolsetprocess m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaToolsetprocess.findByUpdated", query = "SELECT m FROM MaToolsetprocess m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaToolsetprocess.findByUpdatedby", query = "SELECT m FROM MaToolsetprocess m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaToolsetprocess.findByUsecoef", query = "SELECT m FROM MaToolsetprocess m WHERE m.usecoef = :usecoef"),
    @NamedQuery(name = "MaToolsetprocess.findByMaProcessId", query = "SELECT m FROM MaToolsetprocess m WHERE m.maProcessId = :maProcessId and m.isactive = :isactive")
    
})
public class MaToolsetprocess extends AbstractEntityModel implements Serializable { 
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_toolsetprocess_id")
    private String maToolsetprocessId;
    
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
    @Column(name = "usecoef")
    private BigInteger usecoef;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_process_id", referencedColumnName = "ma_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaProcess maProcessId;
    @JoinColumn(name = "ma_toolset_type_id", referencedColumnName = "ma_toolset_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaToolsetType maToolsetTypeId;

    public MaToolsetprocess() {
    }

    public MaToolsetprocess(String maToolsetprocessId) {
        this.maToolsetprocessId = maToolsetprocessId;
    }

    public String getMaToolsetprocessId() {
        return maToolsetprocessId;
    }

    public void setMaToolsetprocessId(String maToolsetprocessId) {
        this.maToolsetprocessId = maToolsetprocessId;
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

    public BigInteger getUsecoef() {
        return usecoef;
    }

    public void setUsecoef(BigInteger usecoef) {
        this.usecoef = usecoef;
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

    public MaProcess getMaProcessId() {
        return maProcessId;
    }

    public void setMaProcessId(MaProcess maProcessId) {
        this.maProcessId = maProcessId;
    }

    public MaToolsetType getMaToolsetTypeId() {
        return maToolsetTypeId;
    }

    public void setMaToolsetTypeId(MaToolsetType maToolsetTypeId) {
        this.maToolsetTypeId = maToolsetTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maToolsetprocessId != null ? maToolsetprocessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaToolsetprocess)) {
            return false;
        }
        MaToolsetprocess other = (MaToolsetprocess) object;
        if ((this.maToolsetprocessId == null && other.maToolsetprocessId != null) || (this.maToolsetprocessId != null && !this.maToolsetprocessId.equals(other.maToolsetprocessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaToolsetprocess[ maToolsetprocessId=" + maToolsetprocessId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maToolsetprocessId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maToolsetprocessId = id;
	}
    
}
