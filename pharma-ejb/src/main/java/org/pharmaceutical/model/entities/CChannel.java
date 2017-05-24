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
@Table(name = "c_channel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CChannel.findAll", query = "SELECT c FROM CChannel c"),
    @NamedQuery(name = "CChannel.findByCChannelId", query = "SELECT c FROM CChannel c WHERE c.cChannelId = :cChannelId"),
    @NamedQuery(name = "CChannel.findByIsactive", query = "SELECT c FROM CChannel c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CChannel.findByCreated", query = "SELECT c FROM CChannel c WHERE c.created = :created"),
    @NamedQuery(name = "CChannel.findByCreatedby", query = "SELECT c FROM CChannel c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CChannel.findByUpdated", query = "SELECT c FROM CChannel c WHERE c.updated = :updated"),
    @NamedQuery(name = "CChannel.findByUpdatedby", query = "SELECT c FROM CChannel c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CChannel.findByName", query = "SELECT c FROM CChannel c WHERE c.name = :name"),
    @NamedQuery(name = "CChannel.findByDescription", query = "SELECT c FROM CChannel c WHERE c.description = :description")})
public class CChannel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_channel_id")
    private String cChannelId;
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
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChannelId")
    private List<CCampaign> cCampaignList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public CChannel() {
    }

    public CChannel(String cChannelId) {
        this.cChannelId = cChannelId;
    }

    public CChannel(String cChannelId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cChannelId = cChannelId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCChannelId() {
        return cChannelId;
    }

    public void setCChannelId(String cChannelId) {
        this.cChannelId = cChannelId;
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
    public List<CCampaign> getCCampaignList() {
        return cCampaignList;
    }

    public void setCCampaignList(List<CCampaign> cCampaignList) {
        this.cCampaignList = cCampaignList;
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
        hash += (cChannelId != null ? cChannelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CChannel)) {
            return false;
        }
        CChannel other = (CChannel) object;
        if ((this.cChannelId == null && other.cChannelId != null) || (this.cChannelId != null && !this.cChannelId.equals(other.cChannelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CChannel[ cChannelId=" + cChannelId + " ]";
    }
    
}