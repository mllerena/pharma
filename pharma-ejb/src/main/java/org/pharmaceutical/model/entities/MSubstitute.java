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
@Table(name = "m_substitute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MSubstitute.findAll", query = "SELECT m FROM MSubstitute m"),
    @NamedQuery(name = "MSubstitute.findByMSubstituteId", query = "SELECT m FROM MSubstitute m WHERE m.mSubstituteId = :mSubstituteId"),
    @NamedQuery(name = "MSubstitute.findByIsactive", query = "SELECT m FROM MSubstitute m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MSubstitute.findByCreated", query = "SELECT m FROM MSubstitute m WHERE m.created = :created"),
    @NamedQuery(name = "MSubstitute.findByCreatedby", query = "SELECT m FROM MSubstitute m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MSubstitute.findByUpdated", query = "SELECT m FROM MSubstitute m WHERE m.updated = :updated"),
    @NamedQuery(name = "MSubstitute.findByUpdatedby", query = "SELECT m FROM MSubstitute m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MSubstitute.findByName", query = "SELECT m FROM MSubstitute m WHERE m.name = :name")})
public class MSubstitute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_substitute_id")
    private String mSubstituteId;
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
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "substitute_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct substituteId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public MSubstitute() {
    }

    public MSubstitute(String mSubstituteId) {
        this.mSubstituteId = mSubstituteId;
    }

    public MSubstitute(String mSubstituteId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mSubstituteId = mSubstituteId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMSubstituteId() {
        return mSubstituteId;
    }

    public void setMSubstituteId(String mSubstituteId) {
        this.mSubstituteId = mSubstituteId;
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

    public MProduct getSubstituteId() {
        return substituteId;
    }

    public void setSubstituteId(MProduct substituteId) {
        this.substituteId = substituteId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mSubstituteId != null ? mSubstituteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MSubstitute)) {
            return false;
        }
        MSubstitute other = (MSubstitute) object;
        if ((this.mSubstituteId == null && other.mSubstituteId != null) || (this.mSubstituteId != null && !this.mSubstituteId.equals(other.mSubstituteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MSubstitute[ mSubstituteId=" + mSubstituteId + " ]";
    }
    
}
