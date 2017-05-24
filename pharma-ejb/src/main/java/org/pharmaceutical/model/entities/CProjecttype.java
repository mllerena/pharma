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
@Table(name = "c_projecttype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjecttype.findAll", query = "SELECT c FROM CProjecttype c"),
    @NamedQuery(name = "CProjecttype.findByCProjecttypeId", query = "SELECT c FROM CProjecttype c WHERE c.cProjecttypeId = :cProjecttypeId"),
    @NamedQuery(name = "CProjecttype.findByIsactive", query = "SELECT c FROM CProjecttype c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjecttype.findByCreated", query = "SELECT c FROM CProjecttype c WHERE c.created = :created"),
    @NamedQuery(name = "CProjecttype.findByCreatedby", query = "SELECT c FROM CProjecttype c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjecttype.findByUpdated", query = "SELECT c FROM CProjecttype c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjecttype.findByUpdatedby", query = "SELECT c FROM CProjecttype c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjecttype.findByName", query = "SELECT c FROM CProjecttype c WHERE c.name = :name"),
    @NamedQuery(name = "CProjecttype.findByDescription", query = "SELECT c FROM CProjecttype c WHERE c.description = :description"),
    @NamedQuery(name = "CProjecttype.findByHelp", query = "SELECT c FROM CProjecttype c WHERE c.help = :help"),
    @NamedQuery(name = "CProjecttype.findByProjectcategory", query = "SELECT c FROM CProjecttype c WHERE c.projectcategory = :projectcategory")})
public class CProjecttype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_projecttype_id")
    private String cProjecttypeId;
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
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "projectcategory")
    private String projectcategory;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjecttypeId")
    private List<CPhase> cPhaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjecttypeId")
    private List<CProject> cProjectList;

    public CProjecttype() {
    }

    public CProjecttype(String cProjecttypeId) {
        this.cProjecttypeId = cProjecttypeId;
    }

    public CProjecttype(String cProjecttypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String projectcategory) {
        this.cProjecttypeId = cProjecttypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.projectcategory = projectcategory;
    }

    public String getCProjecttypeId() {
        return cProjecttypeId;
    }

    public void setCProjecttypeId(String cProjecttypeId) {
        this.cProjecttypeId = cProjecttypeId;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getProjectcategory() {
        return projectcategory;
    }

    public void setProjectcategory(String projectcategory) {
        this.projectcategory = projectcategory;
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
    public List<CPhase> getCPhaseList() {
        return cPhaseList;
    }

    public void setCPhaseList(List<CPhase> cPhaseList) {
        this.cPhaseList = cPhaseList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProjecttypeId != null ? cProjecttypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjecttype)) {
            return false;
        }
        CProjecttype other = (CProjecttype) object;
        if ((this.cProjecttypeId == null && other.cProjecttypeId != null) || (this.cProjecttypeId != null && !this.cProjecttypeId.equals(other.cProjecttypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjecttype[ cProjecttypeId=" + cProjecttypeId + " ]";
    }
    
}
