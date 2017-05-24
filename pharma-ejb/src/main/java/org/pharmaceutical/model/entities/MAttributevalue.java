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
@Table(name = "m_attributevalue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAttributevalue.findAll", query = "SELECT m FROM MAttributevalue m"),
    @NamedQuery(name = "MAttributevalue.findByMAttributevalueId", query = "SELECT m FROM MAttributevalue m WHERE m.mAttributevalueId = :mAttributevalueId"),
    @NamedQuery(name = "MAttributevalue.findByIsactive", query = "SELECT m FROM MAttributevalue m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MAttributevalue.findByCreated", query = "SELECT m FROM MAttributevalue m WHERE m.created = :created"),
    @NamedQuery(name = "MAttributevalue.findByCreatedby", query = "SELECT m FROM MAttributevalue m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MAttributevalue.findByUpdated", query = "SELECT m FROM MAttributevalue m WHERE m.updated = :updated"),
    @NamedQuery(name = "MAttributevalue.findByUpdatedby", query = "SELECT m FROM MAttributevalue m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MAttributevalue.findByValue", query = "SELECT m FROM MAttributevalue m WHERE m.value = :value"),
    @NamedQuery(name = "MAttributevalue.findByName", query = "SELECT m FROM MAttributevalue m WHERE m.name = :name"),
    @NamedQuery(name = "MAttributevalue.findByDescription", query = "SELECT m FROM MAttributevalue m WHERE m.description = :description")})
public class MAttributevalue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_attributevalue_id")
    private String mAttributevalueId;
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
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_attribute_id", referencedColumnName = "m_attribute_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MAttribute mAttributeId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributevalueId")
    private List<MAttributeinstance> mAttributeinstanceList;

    public MAttributevalue() {
    }

    public MAttributevalue(String mAttributevalueId) {
        this.mAttributevalueId = mAttributevalueId;
    }

    public MAttributevalue(String mAttributevalueId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name) {
        this.mAttributevalueId = mAttributevalueId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
    }

    public String getMAttributevalueId() {
        return mAttributevalueId;
    }

    public void setMAttributevalueId(String mAttributevalueId) {
        this.mAttributevalueId = mAttributevalueId;
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

    @XmlTransient
    public List<MAttributeinstance> getMAttributeinstanceList() {
        return mAttributeinstanceList;
    }

    public void setMAttributeinstanceList(List<MAttributeinstance> mAttributeinstanceList) {
        this.mAttributeinstanceList = mAttributeinstanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mAttributevalueId != null ? mAttributevalueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MAttributevalue)) {
            return false;
        }
        MAttributevalue other = (MAttributevalue) object;
        if ((this.mAttributevalueId == null && other.mAttributevalueId != null) || (this.mAttributevalueId != null && !this.mAttributevalueId.equals(other.mAttributevalueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MAttributevalue[ mAttributevalueId=" + mAttributevalueId + " ]";
    }
    
}
