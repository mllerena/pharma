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
@Table(name = "ma_toolset_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaToolsetType.findAll", query = "SELECT m FROM MaToolsetType m"),
    @NamedQuery(name = "MaToolsetType.findByMaToolsetTypeId", query = "SELECT m FROM MaToolsetType m WHERE m.maToolsetTypeId = :maToolsetTypeId"),
    @NamedQuery(name = "MaToolsetType.findByIsactive", query = "SELECT m FROM MaToolsetType m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaToolsetType.findByCreated", query = "SELECT m FROM MaToolsetType m WHERE m.created = :created"),
    @NamedQuery(name = "MaToolsetType.findByCreatedby", query = "SELECT m FROM MaToolsetType m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaToolsetType.findByUpdated", query = "SELECT m FROM MaToolsetType m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaToolsetType.findByUpdatedby", query = "SELECT m FROM MaToolsetType m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaToolsetType.findByName", query = "SELECT m FROM MaToolsetType m WHERE m.name = :name and m.isactive = :isactive"),
    @NamedQuery(name = "MaToolsetType.findByDescription", query = "SELECT m FROM MaToolsetType m WHERE m.description = :description"),
    @NamedQuery(name = "MaToolsetType.findByUsecycle", query = "SELECT m FROM MaToolsetType m WHERE m.usecycle = :usecycle")})
public class MaToolsetType extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_toolset_type_id")
    private String maToolsetTypeId;
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
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "usecycle")
    private long usecycle;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maToolsetTypeId")
    private List<MaToolset> maToolsetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maToolsetTypeId")
    private List<MaToolsetprocess> maToolsetprocessList;

    public MaToolsetType() {
    }

    public MaToolsetType(String maToolsetTypeId) {
        this.maToolsetTypeId = maToolsetTypeId;
    }

    public String getMaToolsetTypeId() {
        return maToolsetTypeId;
    }

    public void setMaToolsetTypeId(String maToolsetTypeId) {
        this.maToolsetTypeId = maToolsetTypeId;
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

    public long getUsecycle() {
        return usecycle;
    }

    public void setUsecycle(long usecycle) {
        this.usecycle = usecycle;
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
    public List<MaToolset> getMaToolsetList() {
        return maToolsetList;
    }

    public void setMaToolsetList(List<MaToolset> maToolsetList) {
        this.maToolsetList = maToolsetList;
    }

    @XmlTransient
    public List<MaToolsetprocess> getMaToolsetprocessList() {
        return maToolsetprocessList;
    }

    public void setMaToolsetprocessList(List<MaToolsetprocess> maToolsetprocessList) {
        this.maToolsetprocessList = maToolsetprocessList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maToolsetTypeId != null ? maToolsetTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaToolsetType)) {
            return false;
        }
        MaToolsetType other = (MaToolsetType) object;
        if ((this.maToolsetTypeId == null && other.maToolsetTypeId != null) || (this.maToolsetTypeId != null && !this.maToolsetTypeId.equals(other.maToolsetTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaToolsetType[ maToolsetTypeId=" + maToolsetTypeId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maToolsetTypeId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maToolsetTypeId = id;
	}
    
}
