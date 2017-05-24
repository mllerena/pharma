/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_offer_bp_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MOfferBpGroup.findAll", query = "SELECT m FROM MOfferBpGroup m"),
    @NamedQuery(name = "MOfferBpGroup.findByMOfferBpGroupId", query = "SELECT m FROM MOfferBpGroup m WHERE m.mOfferBpGroupId = :mOfferBpGroupId"),
    @NamedQuery(name = "MOfferBpGroup.findByIsactive", query = "SELECT m FROM MOfferBpGroup m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MOfferBpGroup.findByCreated", query = "SELECT m FROM MOfferBpGroup m WHERE m.created = :created"),
    @NamedQuery(name = "MOfferBpGroup.findByCreatedby", query = "SELECT m FROM MOfferBpGroup m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MOfferBpGroup.findByUpdated", query = "SELECT m FROM MOfferBpGroup m WHERE m.updated = :updated"),
    @NamedQuery(name = "MOfferBpGroup.findByUpdatedby", query = "SELECT m FROM MOfferBpGroup m WHERE m.updatedby = :updatedby")})
public class MOfferBpGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_offer_bp_group_id")
    private String mOfferBpGroupId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bp_group_id", referencedColumnName = "c_bp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpGroup cBpGroupId;
    @JoinColumn(name = "m_offer_id", referencedColumnName = "m_offer_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MOffer mOfferId;

    public MOfferBpGroup() {
    }

    public MOfferBpGroup(String mOfferBpGroupId) {
        this.mOfferBpGroupId = mOfferBpGroupId;
    }

    public MOfferBpGroup(String mOfferBpGroupId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mOfferBpGroupId = mOfferBpGroupId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMOfferBpGroupId() {
        return mOfferBpGroupId;
    }

    public void setMOfferBpGroupId(String mOfferBpGroupId) {
        this.mOfferBpGroupId = mOfferBpGroupId;
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

    public CBpGroup getCBpGroupId() {
        return cBpGroupId;
    }

    public void setCBpGroupId(CBpGroup cBpGroupId) {
        this.cBpGroupId = cBpGroupId;
    }

    public MOffer getMOfferId() {
        return mOfferId;
    }

    public void setMOfferId(MOffer mOfferId) {
        this.mOfferId = mOfferId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mOfferBpGroupId != null ? mOfferBpGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MOfferBpGroup)) {
            return false;
        }
        MOfferBpGroup other = (MOfferBpGroup) object;
        if ((this.mOfferBpGroupId == null && other.mOfferBpGroupId != null) || (this.mOfferBpGroupId != null && !this.mOfferBpGroupId.equals(other.mOfferBpGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MOfferBpGroup[ mOfferBpGroupId=" + mOfferBpGroupId + " ]";
    }
    
}
