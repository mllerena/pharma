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
@Table(name = "ad_model_object_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModelObjectMapping.findAll", query = "SELECT a FROM AdModelObjectMapping a"),
    @NamedQuery(name = "AdModelObjectMapping.findByAdModelObjectMappingId", query = "SELECT a FROM AdModelObjectMapping a WHERE a.adModelObjectMappingId = :adModelObjectMappingId"),
    @NamedQuery(name = "AdModelObjectMapping.findByIsactive", query = "SELECT a FROM AdModelObjectMapping a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModelObjectMapping.findByCreated", query = "SELECT a FROM AdModelObjectMapping a WHERE a.created = :created"),
    @NamedQuery(name = "AdModelObjectMapping.findByCreatedby", query = "SELECT a FROM AdModelObjectMapping a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModelObjectMapping.findByUpdated", query = "SELECT a FROM AdModelObjectMapping a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModelObjectMapping.findByUpdatedby", query = "SELECT a FROM AdModelObjectMapping a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModelObjectMapping.findByMappingname", query = "SELECT a FROM AdModelObjectMapping a WHERE a.mappingname = :mappingname"),
    @NamedQuery(name = "AdModelObjectMapping.findByIsdefault", query = "SELECT a FROM AdModelObjectMapping a WHERE a.isdefault = :isdefault")})
public class AdModelObjectMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_model_object_mapping_id")
    private String adModelObjectMappingId;
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
    @Size(min = 1, max = 1000)
    @Column(name = "mappingname")
    private String mappingname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_model_object_id", referencedColumnName = "ad_model_object_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModelObject adModelObjectId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModelObjectMapping() {
    }

    public AdModelObjectMapping(String adModelObjectMappingId) {
        this.adModelObjectMappingId = adModelObjectMappingId;
    }

    public AdModelObjectMapping(String adModelObjectMappingId, Character isactive, Date created, String createdby, Date updated, String updatedby, String mappingname, Character isdefault) {
        this.adModelObjectMappingId = adModelObjectMappingId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.mappingname = mappingname;
        this.isdefault = isdefault;
    }

    public String getAdModelObjectMappingId() {
        return adModelObjectMappingId;
    }

    public void setAdModelObjectMappingId(String adModelObjectMappingId) {
        this.adModelObjectMappingId = adModelObjectMappingId;
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

    public String getMappingname() {
        return mappingname;
    }

    public void setMappingname(String mappingname) {
        this.mappingname = mappingname;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdModelObject getAdModelObjectId() {
        return adModelObjectId;
    }

    public void setAdModelObjectId(AdModelObject adModelObjectId) {
        this.adModelObjectId = adModelObjectId;
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
        hash += (adModelObjectMappingId != null ? adModelObjectMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModelObjectMapping)) {
            return false;
        }
        AdModelObjectMapping other = (AdModelObjectMapping) object;
        if ((this.adModelObjectMappingId == null && other.adModelObjectMappingId != null) || (this.adModelObjectMappingId != null && !this.adModelObjectMappingId.equals(other.adModelObjectMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModelObjectMapping[ adModelObjectMappingId=" + adModelObjectMappingId + " ]";
    }
    
}
