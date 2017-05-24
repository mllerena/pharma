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

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_movement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMovement.findAll", query = "SELECT m FROM MMovement m"),
    @NamedQuery(name = "MMovement.findByMMovementId", query = "SELECT m FROM MMovement m WHERE m.mMovementId = :mMovementId"),
    @NamedQuery(name = "MMovement.findByIsactive", query = "SELECT m FROM MMovement m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MMovement.findByCreated", query = "SELECT m FROM MMovement m WHERE m.created = :created"),
    @NamedQuery(name = "MMovement.findByCreatedby", query = "SELECT m FROM MMovement m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MMovement.findByUpdatedby", query = "SELECT m FROM MMovement m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MMovement.findByUpdated", query = "SELECT m FROM MMovement m WHERE m.updated = :updated"),
    @NamedQuery(name = "MMovement.findByName", query = "SELECT m FROM MMovement m WHERE m.name = :name"),
    @NamedQuery(name = "MMovement.findByDescription", query = "SELECT m FROM MMovement m WHERE m.description = :description"),
    @NamedQuery(name = "MMovement.findByMovementdate", query = "SELECT m FROM MMovement m WHERE m.movementdate = :movementdate"),
    @NamedQuery(name = "MMovement.findByPosted", query = "SELECT m FROM MMovement m WHERE m.posted = :posted"),
    @NamedQuery(name = "MMovement.findByProcessed", query = "SELECT m FROM MMovement m WHERE m.processed = :processed"),
    @NamedQuery(name = "MMovement.findByProcessing", query = "SELECT m FROM MMovement m WHERE m.processing = :processing"),
    @NamedQuery(name = "MMovement.findByUser1Id", query = "SELECT m FROM MMovement m WHERE m.user1Id = :user1Id"),
    @NamedQuery(name = "MMovement.findByUser2Id", query = "SELECT m FROM MMovement m WHERE m.user2Id = :user2Id"),
    @NamedQuery(name = "MMovement.findByMoveFromtoLocator", query = "SELECT m FROM MMovement m WHERE m.moveFromtoLocator = :moveFromtoLocator"),
    @NamedQuery(name = "MMovement.findByDocumentno", query = "SELECT m FROM MMovement m WHERE m.documentno = :documentno")})
public class MMovement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_movement_id")
    private String mMovementId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Column(name = "processing")
    private Character processing;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "move_fromto_locator")
    private Character moveFromtoLocator;
    @Size(max = 30)
    @Column(name = "documentno")
    private String documentno;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mMovementId")
    private List<MMovementline> mMovementlineList;

    public MMovement() {
    }

    public MMovement(String mMovementId) {
        this.mMovementId = mMovementId;
    }

    public MMovement(String mMovementId, Character isactive, Date created, String createdby, String updatedby, Date updated, String name, Date movementdate, String posted, Character processed, Character moveFromtoLocator) {
        this.mMovementId = mMovementId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.updated = updated;
        this.name = name;
        this.movementdate = movementdate;
        this.posted = posted;
        this.processed = processed;
        this.moveFromtoLocator = moveFromtoLocator;
    }

    public String getMMovementId() {
        return mMovementId;
    }

    public void setMMovementId(String mMovementId) {
        this.mMovementId = mMovementId;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
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

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
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

    public Character getMoveFromtoLocator() {
        return moveFromtoLocator;
    }

    public void setMoveFromtoLocator(Character moveFromtoLocator) {
        this.moveFromtoLocator = moveFromtoLocator;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
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
    public List<MMovementline> getMMovementlineList() {
        return mMovementlineList;
    }

    public void setMMovementlineList(List<MMovementline> mMovementlineList) {
        this.mMovementlineList = mMovementlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mMovementId != null ? mMovementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MMovement)) {
            return false;
        }
        MMovement other = (MMovement) object;
        if ((this.mMovementId == null && other.mMovementId != null) || (this.mMovementId != null && !this.mMovementId.equals(other.mMovementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MMovement[ mMovementId=" + mMovementId + " ]";
    }
    
}
