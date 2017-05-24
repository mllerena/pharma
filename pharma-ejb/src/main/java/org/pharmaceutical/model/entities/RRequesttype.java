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
@Table(name = "r_requesttype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RRequesttype.findAll", query = "SELECT r FROM RRequesttype r"),
    @NamedQuery(name = "RRequesttype.findByRRequesttypeId", query = "SELECT r FROM RRequesttype r WHERE r.rRequesttypeId = :rRequesttypeId"),
    @NamedQuery(name = "RRequesttype.findByIsactive", query = "SELECT r FROM RRequesttype r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RRequesttype.findByCreated", query = "SELECT r FROM RRequesttype r WHERE r.created = :created"),
    @NamedQuery(name = "RRequesttype.findByCreatedby", query = "SELECT r FROM RRequesttype r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RRequesttype.findByUpdated", query = "SELECT r FROM RRequesttype r WHERE r.updated = :updated"),
    @NamedQuery(name = "RRequesttype.findByUpdatedby", query = "SELECT r FROM RRequesttype r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RRequesttype.findByName", query = "SELECT r FROM RRequesttype r WHERE r.name = :name"),
    @NamedQuery(name = "RRequesttype.findByDescription", query = "SELECT r FROM RRequesttype r WHERE r.description = :description"),
    @NamedQuery(name = "RRequesttype.findByIsdefault", query = "SELECT r FROM RRequesttype r WHERE r.isdefault = :isdefault"),
    @NamedQuery(name = "RRequesttype.findByIsselfservice", query = "SELECT r FROM RRequesttype r WHERE r.isselfservice = :isselfservice")})
public class RRequesttype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_requesttype_id")
    private String rRequesttypeId;
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
    @Column(name = "isdefault")
    private Character isdefault;
    @Column(name = "isselfservice")
    private Character isselfservice;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "rRequesttypeId")
    private List<RRequestprocessorRoute> rRequestprocessorRouteList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "rRequesttypeId")
    private List<RRequest> rRequestList;

    public RRequesttype() {
    }

    public RRequesttype(String rRequesttypeId) {
        this.rRequesttypeId = rRequesttypeId;
    }

    public RRequesttype(String rRequesttypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isdefault) {
        this.rRequesttypeId = rRequesttypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isdefault = isdefault;
    }

    public String getRRequesttypeId() {
        return rRequesttypeId;
    }

    public void setRRequesttypeId(String rRequesttypeId) {
        this.rRequesttypeId = rRequesttypeId;
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

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public Character getIsselfservice() {
        return isselfservice;
    }

    public void setIsselfservice(Character isselfservice) {
        this.isselfservice = isselfservice;
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
    public List<RRequestprocessorRoute> getRRequestprocessorRouteList() {
        return rRequestprocessorRouteList;
    }

    public void setRRequestprocessorRouteList(List<RRequestprocessorRoute> rRequestprocessorRouteList) {
        this.rRequestprocessorRouteList = rRequestprocessorRouteList;
    }

    @XmlTransient
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rRequesttypeId != null ? rRequesttypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RRequesttype)) {
            return false;
        }
        RRequesttype other = (RRequesttype) object;
        if ((this.rRequesttypeId == null && other.rRequesttypeId != null) || (this.rRequesttypeId != null && !this.rRequesttypeId.equals(other.rRequesttypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RRequesttype[ rRequesttypeId=" + rRequesttypeId + " ]";
    }
    
}
