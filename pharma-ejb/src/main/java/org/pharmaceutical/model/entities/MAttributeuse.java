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
@Table(name = "m_attributeuse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAttributeuse.findAll", query = "SELECT m FROM MAttributeuse m"),
    @NamedQuery(name = "MAttributeuse.findByMAttributeuseId", query = "SELECT m FROM MAttributeuse m WHERE m.mAttributeuseId = :mAttributeuseId"),
    @NamedQuery(name = "MAttributeuse.findByIsactive", query = "SELECT m FROM MAttributeuse m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MAttributeuse.findByCreated", query = "SELECT m FROM MAttributeuse m WHERE m.created = :created"),
    @NamedQuery(name = "MAttributeuse.findByCreatedby", query = "SELECT m FROM MAttributeuse m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MAttributeuse.findByUpdated", query = "SELECT m FROM MAttributeuse m WHERE m.updated = :updated"),
    @NamedQuery(name = "MAttributeuse.findByUpdatedby", query = "SELECT m FROM MAttributeuse m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MAttributeuse.findBySeqno", query = "SELECT m FROM MAttributeuse m WHERE m.seqno = :seqno")})
public class MAttributeuse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_attributeuse_id")
    private String mAttributeuseId;
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
    @Column(name = "seqno")
    private long seqno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_attribute_id", referencedColumnName = "m_attribute_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MAttribute mAttributeId;
    @JoinColumn(name = "m_attributeset_id", referencedColumnName = "m_attributeset_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MAttributeset mAttributesetId;

    public MAttributeuse() {
    }

    public MAttributeuse(String mAttributeuseId) {
        this.mAttributeuseId = mAttributeuseId;
    }

    public MAttributeuse(String mAttributeuseId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno) {
        this.mAttributeuseId = mAttributeuseId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
    }

    public String getMAttributeuseId() {
        return mAttributeuseId;
    }

    public void setMAttributeuseId(String mAttributeuseId) {
        this.mAttributeuseId = mAttributeuseId;
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

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
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

    public MAttributeset getMAttributesetId() {
        return mAttributesetId;
    }

    public void setMAttributesetId(MAttributeset mAttributesetId) {
        this.mAttributesetId = mAttributesetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mAttributeuseId != null ? mAttributeuseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MAttributeuse)) {
            return false;
        }
        MAttributeuse other = (MAttributeuse) object;
        if ((this.mAttributeuseId == null && other.mAttributeuseId != null) || (this.mAttributeuseId != null && !this.mAttributeuseId.equals(other.mAttributeuseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MAttributeuse[ mAttributeuseId=" + mAttributeuseId + " ]";
    }
    
}
