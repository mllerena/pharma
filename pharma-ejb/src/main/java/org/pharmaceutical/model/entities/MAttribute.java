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
@Table(name = "m_attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAttribute.findAll", query = "SELECT m FROM MAttribute m"),
    @NamedQuery(name = "MAttribute.findByMAttributeId", query = "SELECT m FROM MAttribute m WHERE m.mAttributeId = :mAttributeId"),
    @NamedQuery(name = "MAttribute.findByIsactive", query = "SELECT m FROM MAttribute m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MAttribute.findByCreated", query = "SELECT m FROM MAttribute m WHERE m.created = :created"),
    @NamedQuery(name = "MAttribute.findByCreatedby", query = "SELECT m FROM MAttribute m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MAttribute.findByUpdated", query = "SELECT m FROM MAttribute m WHERE m.updated = :updated"),
    @NamedQuery(name = "MAttribute.findByUpdatedby", query = "SELECT m FROM MAttribute m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MAttribute.findByName", query = "SELECT m FROM MAttribute m WHERE m.name = :name"),
    @NamedQuery(name = "MAttribute.findByDescription", query = "SELECT m FROM MAttribute m WHERE m.description = :description"),
    @NamedQuery(name = "MAttribute.findByIsmandatory", query = "SELECT m FROM MAttribute m WHERE m.ismandatory = :ismandatory"),
    @NamedQuery(name = "MAttribute.findByIsinstanceattribute", query = "SELECT m FROM MAttribute m WHERE m.isinstanceattribute = :isinstanceattribute"),
    @NamedQuery(name = "MAttribute.findByIslist", query = "SELECT m FROM MAttribute m WHERE m.islist = :islist")})
public class MAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_attribute_id")
    private String mAttributeId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ismandatory")
    private Character ismandatory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isinstanceattribute")
    private Character isinstanceattribute;
    @Column(name = "islist")
    private Character islist;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mAttributeId")
    private List<MAttributevalue> mAttributevalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mAttributeId")
    private List<MAttributeinstance> mAttributeinstanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mAttributeId")
    private List<MAttributeuse> mAttributeuseList;

    public MAttribute() {
    }

    public MAttribute(String mAttributeId) {
        this.mAttributeId = mAttributeId;
    }

    public MAttribute(String mAttributeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character ismandatory, Character isinstanceattribute) {
        this.mAttributeId = mAttributeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.ismandatory = ismandatory;
        this.isinstanceattribute = isinstanceattribute;
    }

    public String getMAttributeId() {
        return mAttributeId;
    }

    public void setMAttributeId(String mAttributeId) {
        this.mAttributeId = mAttributeId;
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

    public Character getIsmandatory() {
        return ismandatory;
    }

    public void setIsmandatory(Character ismandatory) {
        this.ismandatory = ismandatory;
    }

    public Character getIsinstanceattribute() {
        return isinstanceattribute;
    }

    public void setIsinstanceattribute(Character isinstanceattribute) {
        this.isinstanceattribute = isinstanceattribute;
    }

    public Character getIslist() {
        return islist;
    }

    public void setIslist(Character islist) {
        this.islist = islist;
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

    @XmlTransient
    public List<MAttributevalue> getMAttributevalueList() {
        return mAttributevalueList;
    }

    public void setMAttributevalueList(List<MAttributevalue> mAttributevalueList) {
        this.mAttributevalueList = mAttributevalueList;
    }

    @XmlTransient
    public List<MAttributeinstance> getMAttributeinstanceList() {
        return mAttributeinstanceList;
    }

    public void setMAttributeinstanceList(List<MAttributeinstance> mAttributeinstanceList) {
        this.mAttributeinstanceList = mAttributeinstanceList;
    }

    @XmlTransient
    public List<MAttributeuse> getMAttributeuseList() {
        return mAttributeuseList;
    }

    public void setMAttributeuseList(List<MAttributeuse> mAttributeuseList) {
        this.mAttributeuseList = mAttributeuseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mAttributeId != null ? mAttributeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MAttribute)) {
            return false;
        }
        MAttribute other = (MAttribute) object;
        if ((this.mAttributeId == null && other.mAttributeId != null) || (this.mAttributeId != null && !this.mAttributeId.equals(other.mAttributeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MAttribute[ mAttributeId=" + mAttributeId + " ]";
    }
    
}
