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
@Table(name = "m_attributeinstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAttributeinstance.findAll", query = "SELECT m FROM MAttributeinstance m"),
    @NamedQuery(name = "MAttributeinstance.findByMAttributeinstanceId", query = "SELECT m FROM MAttributeinstance m WHERE m.mAttributeinstanceId = :mAttributeinstanceId"),
    @NamedQuery(name = "MAttributeinstance.findByIsactive", query = "SELECT m FROM MAttributeinstance m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MAttributeinstance.findByCreated", query = "SELECT m FROM MAttributeinstance m WHERE m.created = :created"),
    @NamedQuery(name = "MAttributeinstance.findByCreatedby", query = "SELECT m FROM MAttributeinstance m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MAttributeinstance.findByUpdated", query = "SELECT m FROM MAttributeinstance m WHERE m.updated = :updated"),
    @NamedQuery(name = "MAttributeinstance.findByUpdatedby", query = "SELECT m FROM MAttributeinstance m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MAttributeinstance.findByValue", query = "SELECT m FROM MAttributeinstance m WHERE m.value = :value")})
public class MAttributeinstance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_attributeinstance_id")
    private String mAttributeinstanceId;
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
    @Size(max = 40)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_attribute_id", referencedColumnName = "m_attribute_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MAttribute mAttributeId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_attributevalue_id", referencedColumnName = "m_attributevalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributevalue mAttributevalueId;

    public MAttributeinstance() {
    }

    public MAttributeinstance(String mAttributeinstanceId) {
        this.mAttributeinstanceId = mAttributeinstanceId;
    }

    public MAttributeinstance(String mAttributeinstanceId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mAttributeinstanceId = mAttributeinstanceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMAttributeinstanceId() {
        return mAttributeinstanceId;
    }

    public void setMAttributeinstanceId(String mAttributeinstanceId) {
        this.mAttributeinstanceId = mAttributeinstanceId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public MAttribute getMAttributeId() {
        return mAttributeId;
    }

    public void setMAttributeId(MAttribute mAttributeId) {
        this.mAttributeId = mAttributeId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MAttributevalue getMAttributevalueId() {
        return mAttributevalueId;
    }

    public void setMAttributevalueId(MAttributevalue mAttributevalueId) {
        this.mAttributevalueId = mAttributevalueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mAttributeinstanceId != null ? mAttributeinstanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MAttributeinstance)) {
            return false;
        }
        MAttributeinstance other = (MAttributeinstance) object;
        if ((this.mAttributeinstanceId == null && other.mAttributeinstanceId != null) || (this.mAttributeinstanceId != null && !this.mAttributeinstanceId.equals(other.mAttributeinstanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MAttributeinstance[ mAttributeinstanceId=" + mAttributeinstanceId + " ]";
    }
    
}
