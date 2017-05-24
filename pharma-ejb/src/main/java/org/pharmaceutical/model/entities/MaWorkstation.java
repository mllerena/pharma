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
@Table(name = "ma_workstation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaWorkstation.findAll", query = "SELECT m FROM MaWorkstation m"),
    @NamedQuery(name = "MaWorkstation.findByMaWorkstationId", query = "SELECT m FROM MaWorkstation m WHERE m.maWorkstationId = :maWorkstationId"),
    @NamedQuery(name = "MaWorkstation.findByIsactive", query = "SELECT m FROM MaWorkstation m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaWorkstation.findByCreated", query = "SELECT m FROM MaWorkstation m WHERE m.created = :created"),
    @NamedQuery(name = "MaWorkstation.findByCreatedby", query = "SELECT m FROM MaWorkstation m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaWorkstation.findByUpdated", query = "SELECT m FROM MaWorkstation m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaWorkstation.findByUpdatedby", query = "SELECT m FROM MaWorkstation m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaWorkstation.findByName", query = "SELECT m FROM MaWorkstation m WHERE m.name = :name and m.isactive = :isactive"),
    @NamedQuery(name = "MaWorkstation.findByValue", query = "SELECT m FROM MaWorkstation m WHERE m.value = :value")})
public class MaWorkstation extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_workstation_id")
    private String maWorkstationId;
    
    @Basic(optional = false)
    @Convert(converter=YesNoConverter.class)
    @Column(name = "isactive")
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
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maWorkstationId")
    private List<MaProcess> maProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maWorkstationId")
    private List<MaMachinestation> maMachinestationList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_section_id", referencedColumnName = "ma_section_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaSection maSectionId;

    public MaWorkstation() {
    }

    public MaWorkstation(String maWorkstationId) {
        this.maWorkstationId = maWorkstationId;
    }

    public String getMaWorkstationId() {
        return maWorkstationId;
    }

    public void setMaWorkstationId(String maWorkstationId) {
        this.maWorkstationId = maWorkstationId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlTransient
    public List<MaProcess> getMaProcessList() {
        return maProcessList;
    }

    public void setMaProcessList(List<MaProcess> maProcessList) {
        this.maProcessList = maProcessList;
    }

    @XmlTransient
    public List<MaMachinestation> getMaMachinestationList() {
        return maMachinestationList;
    }

    public void setMaMachinestationList(List<MaMachinestation> maMachinestationList) {
        this.maMachinestationList = maMachinestationList;
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

    public MaSection getMaSectionId() {
        return maSectionId;
    }

    public void setMaSectionId(MaSection maSectionId) {
        this.maSectionId = maSectionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maWorkstationId != null ? maWorkstationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaWorkstation)) {
            return false;
        }
        MaWorkstation other = (MaWorkstation) object;
        if ((this.maWorkstationId == null && other.maWorkstationId != null) || (this.maWorkstationId != null && !this.maWorkstationId.equals(other.maWorkstationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaWorkstation[ maWorkstationId=" + maWorkstationId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maWorkstationId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maWorkstationId = id;	
	}
    
}
