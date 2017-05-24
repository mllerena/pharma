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
@Table(name = "m_locator_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MLocatorType.findAll", query = "SELECT m FROM MLocatorType m"),
    @NamedQuery(name = "MLocatorType.findByMLocatorTypeId", query = "SELECT m FROM MLocatorType m WHERE m.mLocatorTypeId = :mLocatorTypeId"),
    @NamedQuery(name = "MLocatorType.findByIsactive", query = "SELECT m FROM MLocatorType m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MLocatorType.findByCreated", query = "SELECT m FROM MLocatorType m WHERE m.created = :created"),
    @NamedQuery(name = "MLocatorType.findByCreatedby", query = "SELECT m FROM MLocatorType m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MLocatorType.findByUpdated", query = "SELECT m FROM MLocatorType m WHERE m.updated = :updated"),
    @NamedQuery(name = "MLocatorType.findByUpdatedby", query = "SELECT m FROM MLocatorType m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MLocatorType.findByName", query = "SELECT m FROM MLocatorType m WHERE m.name = :name"),
    @NamedQuery(name = "MLocatorType.findByDescription", query = "SELECT m FROM MLocatorType m WHERE m.description = :description"),
    @NamedQuery(name = "MLocatorType.findBySizemultiplier", query = "SELECT m FROM MLocatorType m WHERE m.sizemultiplier = :sizemultiplier")})
public class MLocatorType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_locator_type_id")
    private String mLocatorTypeId;
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
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sizemultiplier")
    private BigInteger sizemultiplier;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public MLocatorType() {
    }

    public MLocatorType(String mLocatorTypeId) {
        this.mLocatorTypeId = mLocatorTypeId;
    }

    public MLocatorType(String mLocatorTypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, BigInteger sizemultiplier) {
        this.mLocatorTypeId = mLocatorTypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.sizemultiplier = sizemultiplier;
    }

    public String getMLocatorTypeId() {
        return mLocatorTypeId;
    }

    public void setMLocatorTypeId(String mLocatorTypeId) {
        this.mLocatorTypeId = mLocatorTypeId;
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

    public BigInteger getSizemultiplier() {
        return sizemultiplier;
    }

    public void setSizemultiplier(BigInteger sizemultiplier) {
        this.sizemultiplier = sizemultiplier;
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
        hash += (mLocatorTypeId != null ? mLocatorTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MLocatorType)) {
            return false;
        }
        MLocatorType other = (MLocatorType) object;
        if ((this.mLocatorTypeId == null && other.mLocatorTypeId != null) || (this.mLocatorTypeId != null && !this.mLocatorTypeId.equals(other.mLocatorTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MLocatorType[ mLocatorTypeId=" + mLocatorTypeId + " ]";
    }
    
}
