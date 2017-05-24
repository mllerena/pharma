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
@Table(name = "m_offer_bpartner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MOfferBpartner.findAll", query = "SELECT m FROM MOfferBpartner m"),
    @NamedQuery(name = "MOfferBpartner.findByMOfferBpartnerId", query = "SELECT m FROM MOfferBpartner m WHERE m.mOfferBpartnerId = :mOfferBpartnerId"),
    @NamedQuery(name = "MOfferBpartner.findByIsactive", query = "SELECT m FROM MOfferBpartner m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MOfferBpartner.findByCreated", query = "SELECT m FROM MOfferBpartner m WHERE m.created = :created"),
    @NamedQuery(name = "MOfferBpartner.findByCreatedby", query = "SELECT m FROM MOfferBpartner m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MOfferBpartner.findByUpdated", query = "SELECT m FROM MOfferBpartner m WHERE m.updated = :updated"),
    @NamedQuery(name = "MOfferBpartner.findByUpdatedby", query = "SELECT m FROM MOfferBpartner m WHERE m.updatedby = :updatedby")})
public class MOfferBpartner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_offer_bpartner_id")
    private String mOfferBpartnerId;
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
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "m_offer_id", referencedColumnName = "m_offer_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MOffer mOfferId;

    public MOfferBpartner() {
    }

    public MOfferBpartner(String mOfferBpartnerId) {
        this.mOfferBpartnerId = mOfferBpartnerId;
    }

    public MOfferBpartner(String mOfferBpartnerId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mOfferBpartnerId = mOfferBpartnerId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMOfferBpartnerId() {
        return mOfferBpartnerId;
    }

    public void setMOfferBpartnerId(String mOfferBpartnerId) {
        this.mOfferBpartnerId = mOfferBpartnerId;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
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
        hash += (mOfferBpartnerId != null ? mOfferBpartnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MOfferBpartner)) {
            return false;
        }
        MOfferBpartner other = (MOfferBpartner) object;
        if ((this.mOfferBpartnerId == null && other.mOfferBpartnerId != null) || (this.mOfferBpartnerId != null && !this.mOfferBpartnerId.equals(other.mOfferBpartnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MOfferBpartner[ mOfferBpartnerId=" + mOfferBpartnerId + " ]";
    }
    
}
