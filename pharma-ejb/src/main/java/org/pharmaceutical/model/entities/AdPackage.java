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
@Table(name = "ad_package")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdPackage.findAll", query = "SELECT a FROM AdPackage a"),
    @NamedQuery(name = "AdPackage.findByAdPackageId", query = "SELECT a FROM AdPackage a WHERE a.adPackageId = :adPackageId"),
    @NamedQuery(name = "AdPackage.findByName", query = "SELECT a FROM AdPackage a WHERE a.name = :name"),
    @NamedQuery(name = "AdPackage.findByDescription", query = "SELECT a FROM AdPackage a WHERE a.description = :description"),
    @NamedQuery(name = "AdPackage.findByJavapackage", query = "SELECT a FROM AdPackage a WHERE a.javapackage = :javapackage"),
    @NamedQuery(name = "AdPackage.findByIsactive", query = "SELECT a FROM AdPackage a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdPackage.findByCreated", query = "SELECT a FROM AdPackage a WHERE a.created = :created"),
    @NamedQuery(name = "AdPackage.findByCreatedby", query = "SELECT a FROM AdPackage a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdPackage.findByUpdated", query = "SELECT a FROM AdPackage a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdPackage.findByUpdatedby", query = "SELECT a FROM AdPackage a WHERE a.updatedby = :updatedby")})
public class AdPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_package_id")
    private String adPackageId;
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
    @Size(min = 1, max = 255)
    @Column(name = "javapackage")
    private String javapackage;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adPackageId")
    private List<AdTable> adTableList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdPackage() {
    }

    public AdPackage(String adPackageId) {
        this.adPackageId = adPackageId;
    }

    public AdPackage(String adPackageId, String name, String javapackage, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adPackageId = adPackageId;
        this.name = name;
        this.javapackage = javapackage;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdPackageId() {
        return adPackageId;
    }

    public void setAdPackageId(String adPackageId) {
        this.adPackageId = adPackageId;
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

    public String getJavapackage() {
        return javapackage;
    }

    public void setJavapackage(String javapackage) {
        this.javapackage = javapackage;
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

    @XmlTransient
    public List<AdTable> getAdTableList() {
        return adTableList;
    }

    public void setAdTableList(List<AdTable> adTableList) {
        this.adTableList = adTableList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adPackageId != null ? adPackageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdPackage)) {
            return false;
        }
        AdPackage other = (AdPackage) object;
        if ((this.adPackageId == null && other.adPackageId != null) || (this.adPackageId != null && !this.adPackageId.equals(other.adPackageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdPackage[ adPackageId=" + adPackageId + " ]";
    }
    
}
