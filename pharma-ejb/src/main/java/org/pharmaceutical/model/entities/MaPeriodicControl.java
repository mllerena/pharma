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
@Table(name = "ma_periodic_control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaPeriodicControl.findAll", query = "SELECT m FROM MaPeriodicControl m"),
    @NamedQuery(name = "MaPeriodicControl.findByMaPeriodicControlId", query = "SELECT m FROM MaPeriodicControl m WHERE m.maPeriodicControlId = :maPeriodicControlId"),
    @NamedQuery(name = "MaPeriodicControl.findByIsactive", query = "SELECT m FROM MaPeriodicControl m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaPeriodicControl.findByCreated", query = "SELECT m FROM MaPeriodicControl m WHERE m.created = :created"),
    @NamedQuery(name = "MaPeriodicControl.findByCreatedby", query = "SELECT m FROM MaPeriodicControl m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaPeriodicControl.findByUpdated", query = "SELECT m FROM MaPeriodicControl m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaPeriodicControl.findByUpdatedby", query = "SELECT m FROM MaPeriodicControl m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaPeriodicControl.findByName", query = "SELECT m FROM MaPeriodicControl m WHERE m.name = :name and m.isactive = :isactive"), 
    @NamedQuery(name = "MaPeriodicControl.findByDescription", query = "SELECT m FROM MaPeriodicControl m WHERE m.description = :description")})
public class MaPeriodicControl extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_periodic_control_id")
    private String maPeriodicControlId;
    
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
    
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maPeriodicControlId")
    private List<MaPcCase> maPcCaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maPeriodicControlId")
    private List<MaPcTest> maPcTestList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public MaPeriodicControl() {
    }

    public MaPeriodicControl(String maPeriodicControlId) {
        this.maPeriodicControlId = maPeriodicControlId;
    }

    public String getMaPeriodicControlId() {
        return maPeriodicControlId;
    }

    public void setMaPeriodicControlId(String maPeriodicControlId) {
        this.maPeriodicControlId = maPeriodicControlId;
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

    @XmlTransient
    public List<MaPcCase> getMaPcCaseList() {
        return maPcCaseList;
    }

    public void setMaPcCaseList(List<MaPcCase> maPcCaseList) {
        this.maPcCaseList = maPcCaseList;
    }

    @XmlTransient
    public List<MaPcTest> getMaPcTestList() {
        return maPcTestList;
    }

    public void setMaPcTestList(List<MaPcTest> maPcTestList) {
        this.maPcTestList = maPcTestList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPeriodicControlId != null ? maPeriodicControlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaPeriodicControl)) {
            return false;
        }
        MaPeriodicControl other = (MaPeriodicControl) object;
        if ((this.maPeriodicControlId == null && other.maPeriodicControlId != null) || (this.maPeriodicControlId != null && !this.maPeriodicControlId.equals(other.maPeriodicControlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaPeriodicControl[ maPeriodicControlId=" + maPeriodicControlId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maPeriodicControlId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maPeriodicControlId = id;
	}
    
}
