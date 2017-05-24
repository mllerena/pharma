/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "m_rappel_scale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRappelScale.findAll", query = "SELECT m FROM MRappelScale m"),
    @NamedQuery(name = "MRappelScale.findByMRappelScaleId", query = "SELECT m FROM MRappelScale m WHERE m.mRappelScaleId = :mRappelScaleId"),
    @NamedQuery(name = "MRappelScale.findByIsactive", query = "SELECT m FROM MRappelScale m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MRappelScale.findByCreated", query = "SELECT m FROM MRappelScale m WHERE m.created = :created"),
    @NamedQuery(name = "MRappelScale.findByCreatedby", query = "SELECT m FROM MRappelScale m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MRappelScale.findByUpdated", query = "SELECT m FROM MRappelScale m WHERE m.updated = :updated"),
    @NamedQuery(name = "MRappelScale.findByUpdatedby", query = "SELECT m FROM MRappelScale m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MRappelScale.findByDiscount", query = "SELECT m FROM MRappelScale m WHERE m.discount = :discount"),
    @NamedQuery(name = "MRappelScale.findByAmntFrom", query = "SELECT m FROM MRappelScale m WHERE m.amntFrom = :amntFrom"),
    @NamedQuery(name = "MRappelScale.findByAmntTo", query = "SELECT m FROM MRappelScale m WHERE m.amntTo = :amntTo")})
public class MRappelScale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_rappel_scale_id")
    private String mRappelScaleId;
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
    @Column(name = "discount")
    private BigInteger discount;
    @Column(name = "amnt_from")
    private BigInteger amntFrom;
    @Column(name = "amnt_to")
    private BigInteger amntTo;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_rappel_id", referencedColumnName = "m_rappel_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MRappel mRappelId;

    public MRappelScale() {
    }

    public MRappelScale(String mRappelScaleId) {
        this.mRappelScaleId = mRappelScaleId;
    }

    public MRappelScale(String mRappelScaleId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mRappelScaleId = mRappelScaleId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMRappelScaleId() {
        return mRappelScaleId;
    }

    public void setMRappelScaleId(String mRappelScaleId) {
        this.mRappelScaleId = mRappelScaleId;
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

    public BigInteger getDiscount() {
        return discount;
    }

    public void setDiscount(BigInteger discount) {
        this.discount = discount;
    }

    public BigInteger getAmntFrom() {
        return amntFrom;
    }

    public void setAmntFrom(BigInteger amntFrom) {
        this.amntFrom = amntFrom;
    }

    public BigInteger getAmntTo() {
        return amntTo;
    }

    public void setAmntTo(BigInteger amntTo) {
        this.amntTo = amntTo;
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

    public MRappel getMRappelId() {
        return mRappelId;
    }

    public void setMRappelId(MRappel mRappelId) {
        this.mRappelId = mRappelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mRappelScaleId != null ? mRappelScaleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRappelScale)) {
            return false;
        }
        MRappelScale other = (MRappelScale) object;
        if ((this.mRappelScaleId == null && other.mRappelScaleId != null) || (this.mRappelScaleId != null && !this.mRappelScaleId.equals(other.mRappelScaleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MRappelScale[ mRappelScaleId=" + mRappelScaleId + " ]";
    }
    
}
