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
@Table(name = "ma_process")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaProcess.findAll", query = "SELECT m FROM MaProcess m"),
    @NamedQuery(name = "MaProcess.findByMaProcessId", query = "SELECT m FROM MaProcess m WHERE m.maProcessId = :maProcessId"),
    @NamedQuery(name = "MaProcess.findByIsactive", query = "SELECT m FROM MaProcess m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaProcess.findByCreated", query = "SELECT m FROM MaProcess m WHERE m.created = :created"),
    @NamedQuery(name = "MaProcess.findByCreatedby", query = "SELECT m FROM MaProcess m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaProcess.findByUpdated", query = "SELECT m FROM MaProcess m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaProcess.findByUpdatedby", query = "SELECT m FROM MaProcess m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaProcess.findByName", query = "SELECT m FROM MaProcess m WHERE m.name = :name and m.isactive = :isactive"), 
    @NamedQuery(name = "MaProcess.findByValue", query = "SELECT m FROM MaProcess m WHERE m.value = :value"),
    @NamedQuery(name = "MaProcess.findByDescription", query = "SELECT m FROM MaProcess m WHERE m.description = :description"), 
    @NamedQuery(name = "MaProcess.findByMaWorkstationId", query = "SELECT m FROM MaProcess m WHERE m.maWorkstationId = :maWorkstationId and m.isactive = :isactive")
})
public class MaProcess extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_process_id")
    private String maProcessId;
    
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
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maProcessId")
    private List<MaSequence> maSequenceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_costcenter_id", referencedColumnName = "ma_costcenter_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaCostcenter maCostcenterId;
    @JoinColumn(name = "ma_workstation_id", referencedColumnName = "ma_workstation_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaWorkstation maWorkstationId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maProcessId")
    private List<MaWrphase> maWrphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maProcessId")
    private List<MaToolsetprocess> maToolsetprocessList;

    public MaProcess() {
    }

    public MaProcess(String maProcessId) {
        this.maProcessId = maProcessId;
    }

    public String getMaProcessId() {
        return maProcessId;
    }

    public void setMaProcessId(String maProcessId) {
        this.maProcessId = maProcessId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<MaSequence> getMaSequenceList() {
        return maSequenceList;
    }

    public void setMaSequenceList(List<MaSequence> maSequenceList) {
        this.maSequenceList = maSequenceList;
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

    public MaCostcenter getMaCostcenterId() {
        return maCostcenterId;
    }

    public void setMaCostcenterId(MaCostcenter maCostcenterId) {
        this.maCostcenterId = maCostcenterId;
    }

    public MaWorkstation getMaWorkstationId() {
        return maWorkstationId;
    }

    public void setMaWorkstationId(MaWorkstation maWorkstationId) {
        this.maWorkstationId = maWorkstationId;
    }

    @XmlTransient
    public List<MaWrphase> getMaWrphaseList() {
        return maWrphaseList;
    }

    public void setMaWrphaseList(List<MaWrphase> maWrphaseList) {
        this.maWrphaseList = maWrphaseList;
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
        hash += (maProcessId != null ? maProcessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaProcess)) {
            return false;
        }
        MaProcess other = (MaProcess) object;
        if ((this.maProcessId == null && other.maProcessId != null) || (this.maProcessId != null && !this.maProcessId.equals(other.maProcessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaProcess[ maProcessId=" + maProcessId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maProcessId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maProcessId = id; 
	}
    
}
