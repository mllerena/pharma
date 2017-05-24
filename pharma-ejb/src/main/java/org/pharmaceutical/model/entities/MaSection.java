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
@Table(name = "ma_section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaSection.findAll", query = "SELECT m FROM MaSection m"),
    @NamedQuery(name = "MaSection.findByMaSectionId", query = "SELECT m FROM MaSection m WHERE m.maSectionId = :maSectionId"),
    @NamedQuery(name = "MaSection.findByIsactive", query = "SELECT m FROM MaSection m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaSection.findByCreated", query = "SELECT m FROM MaSection m WHERE m.created = :created"),
    @NamedQuery(name = "MaSection.findByCreatedby", query = "SELECT m FROM MaSection m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaSection.findByUpdated", query = "SELECT m FROM MaSection m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaSection.findByUpdatedby", query = "SELECT m FROM MaSection m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaSection.findByName", query = "SELECT m FROM MaSection m WHERE m.name = :name and m.isactive = :isactive"),
    @NamedQuery(name = "MaSection.findByDescription", query = "SELECT m FROM MaSection m WHERE m.description = :description")})
public class MaSection extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_section_id")
    private String maSectionId;
    
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maSectionId")
    private List<MaWorkstation> maWorkstationList;

    public MaSection() {
    }

    public MaSection(String maSectionId) {
        this.maSectionId = maSectionId;
    }

    public String getMaSectionId() {
        return maSectionId;
    }

    public void setMaSectionId(String maSectionId) {
        this.maSectionId = maSectionId;
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
    public List<MaWorkstation> getMaWorkstationList() {
        return maWorkstationList;
    }

    public void setMaWorkstationList(List<MaWorkstation> maWorkstationList) {
        this.maWorkstationList = maWorkstationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSectionId != null ? maSectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaSection)) {
            return false;
        }
        MaSection other = (MaSection) object;
        if ((this.maSectionId == null && other.maSectionId != null) || (this.maSectionId != null && !this.maSectionId.equals(other.maSectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaSection[ maSectionId=" + maSectionId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maSectionId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maSectionId = id;
	}
    
}
