/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ma_toolset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaToolset.findAll", query = "SELECT m FROM MaToolset m"),
    @NamedQuery(name = "MaToolset.findByMaToolsetId", query = "SELECT m FROM MaToolset m WHERE m.maToolsetId = :maToolsetId"),
    @NamedQuery(name = "MaToolset.findByIsactive", query = "SELECT m FROM MaToolset m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaToolset.findByCreated", query = "SELECT m FROM MaToolset m WHERE m.created = :created"),
    @NamedQuery(name = "MaToolset.findByCreatedby", query = "SELECT m FROM MaToolset m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaToolset.findByUpdated", query = "SELECT m FROM MaToolset m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaToolset.findByUpdatedby", query = "SELECT m FROM MaToolset m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaToolset.findByValue", query = "SELECT m FROM MaToolset m WHERE m.value = :value"),
    @NamedQuery(name = "MaToolset.findByNumberuses", query = "SELECT m FROM MaToolset m WHERE m.numberuses = :numberuses"),
    @NamedQuery(name = "MaToolset.findByDiscarded", query = "SELECT m FROM MaToolset m WHERE m.discarded = :discarded"),
    @NamedQuery(name = "MaToolset.findByMaToolsetTypeId", query = "SELECT m FROM MaToolset m WHERE m.maToolsetTypeId = :maToolsetTypeId and m.isactive = :isactive")
})
public class MaToolset extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_toolset_id")
    private String maToolsetId;
    
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
    @Column(name = "value")
    private String value;
    @Column(name = "numberuses")
    private BigInteger numberuses;
    
    @Basic(optional = false)
    @Column(name = "discarded")
    @Convert(converter=YesNoConverter.class)
    private YesNo discarded;
    
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maToolsetId")
    private List<MaToolsetused> maToolsetusedList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatorId;
    @JoinColumn(name = "ma_toolset_type_id", referencedColumnName = "ma_toolset_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaToolsetType maToolsetTypeId;

    public MaToolset() {
    }

    public MaToolset(String maToolsetId) {
        this.maToolsetId = maToolsetId;
    }

    public String getMaToolsetId() {
        return maToolsetId;
    }

    public void setMaToolsetId(String maToolsetId) {
        this.maToolsetId = maToolsetId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigInteger getNumberuses() {
        return numberuses;
    }

    public void setNumberuses(BigInteger numberuses) {
        this.numberuses = numberuses;
    }

    public YesNo getDiscarded() {
        return discarded;
    }

    public void setDiscarded(YesNo discarded) { 
        this.discarded = discarded;
    }

    @XmlTransient
    public List<MaToolsetused> getMaToolsetusedList() {
        return maToolsetusedList;
    }

    public void setMaToolsetusedList(List<MaToolsetused> maToolsetusedList) {
        this.maToolsetusedList = maToolsetusedList;
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

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
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
        hash += (maToolsetId != null ? maToolsetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaToolset)) {
            return false;
        }
        MaToolset other = (MaToolset) object;
        if ((this.maToolsetId == null && other.maToolsetId != null) || (this.maToolsetId != null && !this.maToolsetId.equals(other.maToolsetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaToolset[ maToolsetId=" + maToolsetId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maToolsetId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maToolsetId = id;
	}
    
}
