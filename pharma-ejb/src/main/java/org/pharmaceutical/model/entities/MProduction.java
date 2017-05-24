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
@Table(name = "m_production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProduction.findAll", query = "SELECT m FROM MProduction m"),
    @NamedQuery(name = "MProduction.findByMProductionId", query = "SELECT m FROM MProduction m WHERE m.mProductionId = :mProductionId"),
    @NamedQuery(name = "MProduction.findByIsactive", query = "SELECT m FROM MProduction m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProduction.findByCreated", query = "SELECT m FROM MProduction m WHERE m.created = :created"),
    @NamedQuery(name = "MProduction.findByCreatedby", query = "SELECT m FROM MProduction m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProduction.findByUpdated", query = "SELECT m FROM MProduction m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProduction.findByUpdatedby", query = "SELECT m FROM MProduction m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProduction.findByName", query = "SELECT m FROM MProduction m WHERE m.name = :name and m.isactive = :isactive"),
    @NamedQuery(name = "MProduction.findByDescription", query = "SELECT m FROM MProduction m WHERE m.description = :description"),
    @NamedQuery(name = "MProduction.findByMovementdate", query = "SELECT m FROM MProduction m WHERE m.movementdate = :movementdate"),
    @NamedQuery(name = "MProduction.findByIscreated", query = "SELECT m FROM MProduction m WHERE m.iscreated = :iscreated"),
    @NamedQuery(name = "MProduction.findByPosted", query = "SELECT m FROM MProduction m WHERE m.posted = :posted"),
    @NamedQuery(name = "MProduction.findByProcessed", query = "SELECT m FROM MProduction m WHERE m.processed = :processed"),
    @NamedQuery(name = "MProduction.findByProcessing", query = "SELECT m FROM MProduction m WHERE m.processing = :processing"),
    @NamedQuery(name = "MProduction.findByUser1Id", query = "SELECT m FROM MProduction m WHERE m.user1Id = :user1Id"),
    @NamedQuery(name = "MProduction.findByUser2Id", query = "SELECT m FROM MProduction m WHERE m.user2Id = :user2Id"),
    @NamedQuery(name = "MProduction.findByDocumentno", query = "SELECT m FROM MProduction m WHERE m.documentno = :documentno"),
    @NamedQuery(name = "MProduction.findByEndtime", query = "SELECT m FROM MProduction m WHERE m.endtime = :endtime"),
    @NamedQuery(name = "MProduction.findByIssotrx", query = "SELECT m FROM MProduction m WHERE m.issotrx = :issotrx"),
    @NamedQuery(name = "MProduction.findByStarttime", query = "SELECT m FROM MProduction m WHERE m.starttime = :starttime"),
    @NamedQuery(name = "MProduction.findByValidating", query = "SELECT m FROM MProduction m WHERE m.validating = :validating"),
    @NamedQuery(name = "MProduction.findByTaskId", query = "SELECT m FROM MProduction m WHERE m.taskId = :taskId and m.isactive = :isactive")
    
})
public class MProduction extends AbstractEntityModel implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "m_production_id")
    private String mProductionId;
    
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
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementdate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscreated")
    @Convert(converter=YesNoConverter.class)
    private YesNo iscreated;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    @Convert(converter=YesNoConverter.class)
    private YesNo processed;
    
    @Column(name = "processing")
    @Convert(converter=YesNoConverter.class)
    private YesNo processing; 
    
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Size(max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Column(name = "endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "issotrx")
    @Convert(converter=YesNoConverter.class)
    private YesNo issotrx;
    
    @Column(name = "starttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    
    @Column(name = "validating")
    @Convert(converter=YesNoConverter.class)
    private YesNo validating;
    
    @Column(name = "task_id")
    private Long taskId;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionId")
    private List<MaWeincidence> maWeincidenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionId")
    private List<MaGlobaluse> maGlobaluseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionId")
    private List<MaWeemployee> maWeemployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionId")
    private List<MProductionplan> mProductionplanList;

    public MProduction() {
    }

    public MProduction(String mProductionId) {
        this.mProductionId = mProductionId;
    }

    public String getMProductionId() {
        return mProductionId;
    }

    public void setMProductionId(String mProductionId) {
        this.mProductionId = mProductionId;
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

    public Date getMovementdate() {
        return movementdate;
    }

    public void setMovementdate(Date movementdate) {
        this.movementdate = movementdate;
    }

    public YesNo getIscreated() {
        return iscreated;
    }

    public void setIscreated(YesNo iscreated) {
        this.iscreated = iscreated;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public YesNo getProcessed() {
        return processed;
    }

    public void setProcessed(YesNo processed) {
        this.processed = processed;
    }

    public YesNo getProcessing() {
        return processing;
    }

    public void setProcessing(YesNo processing) {
        this.processing = processing;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public YesNo getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(YesNo issotrx) {
        this.issotrx = issotrx;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public YesNo getValidating() {
        return validating;
    }

    public void setValidating(YesNo validating) {
        this.validating = validating;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @XmlTransient
    public List<MaWeincidence> getMaWeincidenceList() {
        return maWeincidenceList;
    }

    public void setMaWeincidenceList(List<MaWeincidence> maWeincidenceList) {
        this.maWeincidenceList = maWeincidenceList;
    }

    @XmlTransient
    public List<MaGlobaluse> getMaGlobaluseList() {
        return maGlobaluseList;
    }

    public void setMaGlobaluseList(List<MaGlobaluse> maGlobaluseList) {
        this.maGlobaluseList = maGlobaluseList;
    }

    @XmlTransient
    public List<MaWeemployee> getMaWeemployeeList() {
        return maWeemployeeList;
    }

    public void setMaWeemployeeList(List<MaWeemployee> maWeemployeeList) {
        this.maWeemployeeList = maWeemployeeList;
    }

    @XmlTransient
    public List<MProductionplan> getMProductionplanList() {
        return mProductionplanList;
    }

    public void setMProductionplanList(List<MProductionplan> mProductionplanList) {
        this.mProductionplanList = mProductionplanList;
    }
    
    

    public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductionId != null ? mProductionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProduction)) {
            return false;
        }
        MProduction other = (MProduction) object;
        if ((this.mProductionId == null && other.mProductionId != null) || (this.mProductionId != null && !this.mProductionId.equals(other.mProductionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProduction[ mProductionId=" + mProductionId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return mProductionId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		mProductionId = id;
	}
    
}
