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
import javax.persistence.FetchType;
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
@Table(name = "ad_fieldgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdFieldgroup.findAll", query = "SELECT a FROM AdFieldgroup a"),
    @NamedQuery(name = "AdFieldgroup.findByAdFieldgroupId", query = "SELECT a FROM AdFieldgroup a WHERE a.adFieldgroupId = :adFieldgroupId"),
    @NamedQuery(name = "AdFieldgroup.findByIsactive", query = "SELECT a FROM AdFieldgroup a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdFieldgroup.findByCreated", query = "SELECT a FROM AdFieldgroup a WHERE a.created = :created"),
    @NamedQuery(name = "AdFieldgroup.findByCreatedby", query = "SELECT a FROM AdFieldgroup a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdFieldgroup.findByUpdated", query = "SELECT a FROM AdFieldgroup a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdFieldgroup.findByUpdatedby", query = "SELECT a FROM AdFieldgroup a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdFieldgroup.findByName", query = "SELECT a FROM AdFieldgroup a WHERE a.name = :name")})
public class AdFieldgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_fieldgroup_id")
    private String adFieldgroupId;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adFieldgroupId")
    private List<AdFieldgroupTrl> adFieldgroupTrlList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adFieldgroupId")
    private List<AdField> adFieldList;

    public AdFieldgroup() {
    }

    public AdFieldgroup(String adFieldgroupId) {
        this.adFieldgroupId = adFieldgroupId;
    }

    public AdFieldgroup(String adFieldgroupId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.adFieldgroupId = adFieldgroupId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getAdFieldgroupId() {
        return adFieldgroupId;
    }

    public void setAdFieldgroupId(String adFieldgroupId) {
        this.adFieldgroupId = adFieldgroupId;
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

    @XmlTransient
    public List<AdFieldgroupTrl> getAdFieldgroupTrlList() {
        return adFieldgroupTrlList;
    }

    public void setAdFieldgroupTrlList(List<AdFieldgroupTrl> adFieldgroupTrlList) {
        this.adFieldgroupTrlList = adFieldgroupTrlList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    @XmlTransient
    public List<AdField> getAdFieldList() {
        return adFieldList;
    }

    public void setAdFieldList(List<AdField> adFieldList) {
        this.adFieldList = adFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adFieldgroupId != null ? adFieldgroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdFieldgroup)) {
            return false;
        }
        AdFieldgroup other = (AdFieldgroup) object;
        if ((this.adFieldgroupId == null && other.adFieldgroupId != null) || (this.adFieldgroupId != null && !this.adFieldgroupId.equals(other.adFieldgroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdFieldgroup[ adFieldgroupId=" + adFieldgroupId + " ]";
    }
    
}
