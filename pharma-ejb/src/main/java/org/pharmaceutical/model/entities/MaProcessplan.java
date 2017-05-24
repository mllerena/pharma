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
@Table(name = "ma_processplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaProcessplan.findAll", query = "SELECT m FROM MaProcessplan m"),
    @NamedQuery(name = "MaProcessplan.findByMaProcessplanId", query = "SELECT m FROM MaProcessplan m WHERE m.maProcessplanId = :maProcessplanId"),
    @NamedQuery(name = "MaProcessplan.findByIsactive", query = "SELECT m FROM MaProcessplan m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaProcessplan.findByCreated", query = "SELECT m FROM MaProcessplan m WHERE m.created = :created"),
    @NamedQuery(name = "MaProcessplan.findByCreatedby", query = "SELECT m FROM MaProcessplan m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaProcessplan.findByUpdated", query = "SELECT m FROM MaProcessplan m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaProcessplan.findByUpdatedby", query = "SELECT m FROM MaProcessplan m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaProcessplan.findByValue", query = "SELECT m FROM MaProcessplan m WHERE m.value = :value"),
    @NamedQuery(name = "MaProcessplan.findByName", query = "SELECT m FROM MaProcessplan m WHERE m.name = :name and m.isactive = :isactive"),
    @NamedQuery(name = "MaProcessplan.findByDescription", query = "SELECT m FROM MaProcessplan m WHERE m.description = :description"),
    @NamedQuery(name = "MaProcessplan.findByExplodephases", query = "SELECT m FROM MaProcessplan m WHERE m.explodephases = :explodephases"),
    @NamedQuery(name = "MaProcessplan.findBySecondaryunit", query = "SELECT m FROM MaProcessplan m WHERE m.secondaryunit = :secondaryunit"),
    @NamedQuery(name = "MaProcessplan.findByConversionrate", query = "SELECT m FROM MaProcessplan m WHERE m.conversionrate = :conversionrate"),
    @NamedQuery(name = "MaProcessplan.findByCopyversion", query = "SELECT m FROM MaProcessplan m WHERE m.copyversion = :copyversion"),
    @NamedQuery(name = "MaProcessplan.findByTaskId", query = "SELECT m FROM MaProcessplan m WHERE m.taskId = :taskId and m.isactive = :isactive"),
    
})
public class MaProcessplan extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_processplan_id")
    private String maProcessplanId;

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
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @Column(name = "explodephases")
    @Convert(converter=YesNoConverter.class) 
    private YesNo explodephases;
    
    @Column(name = "secondaryunit")
    private String secondaryunit;
    
    @Column(name = "conversionrate")
    private BigInteger conversionrate;
    
    @Basic(optional = false)
    @Column(name = "copyversion")
    @Convert(converter=YesNoConverter.class) 
    private YesNo copyversion;
    
    @Column(name = "task_id")
    private Long taskId;
    
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maProcessplanId")
    private List<MaProcessplanVersion> maProcessplanVersionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maProcessplanId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maProcessplanId")
    private List<MaWorkrequirement> maWorkrequirementList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maProcessplanId")
    private List<MrpRunProductionline> mrpRunProductionlineList;

    public MaProcessplan() {
    }

    public MaProcessplan(String maProcessplanId) {
        this.maProcessplanId = maProcessplanId;
    }

    public String getMaProcessplanId() {
        return maProcessplanId;
    }

    public void setMaProcessplanId(String maProcessplanId) {
        this.maProcessplanId = maProcessplanId;
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

    public YesNo getExplodephases() {
        return explodephases;
    }

    public void setExplodephases(YesNo explodephases) {
        this.explodephases = explodephases;
    }

    public String getSecondaryunit() {
        return secondaryunit;
    }

    public void setSecondaryunit(String secondaryunit) {
        this.secondaryunit = secondaryunit;
    }

    public BigInteger getConversionrate() {
        return conversionrate;
    }

    public void setConversionrate(BigInteger conversionrate) {
        this.conversionrate = conversionrate;
    }

    public YesNo getCopyversion() {
        return copyversion;
    }

    public void setCopyversion(YesNo copyversion) {
        this.copyversion = copyversion;
    }

    @XmlTransient
    public List<MaProcessplanVersion> getMaProcessplanVersionList() {
        return maProcessplanVersionList;
    }

    public void setMaProcessplanVersionList(List<MaProcessplanVersion> maProcessplanVersionList) {
        this.maProcessplanVersionList = maProcessplanVersionList;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<MaWorkrequirement> getMaWorkrequirementList() {
        return maWorkrequirementList;
    }

    public void setMaWorkrequirementList(List<MaWorkrequirement> maWorkrequirementList) {
        this.maWorkrequirementList = maWorkrequirementList;
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
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maProcessplanId != null ? maProcessplanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaProcessplan)) {
            return false;
        }
        MaProcessplan other = (MaProcessplan) object;
        if ((this.maProcessplanId == null && other.maProcessplanId != null) || (this.maProcessplanId != null && !this.maProcessplanId.equals(other.maProcessplanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaProcessplan[ maProcessplanId=" + maProcessplanId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maProcessplanId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maProcessplanId = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	
    
}
