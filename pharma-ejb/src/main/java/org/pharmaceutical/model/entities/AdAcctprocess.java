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
@Table(name = "ad_acctprocess")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdAcctprocess.findAll", query = "SELECT a FROM AdAcctprocess a"),
    @NamedQuery(name = "AdAcctprocess.findByAdAcctprocessId", query = "SELECT a FROM AdAcctprocess a WHERE a.adAcctprocessId = :adAcctprocessId"),
    @NamedQuery(name = "AdAcctprocess.findByIsactive", query = "SELECT a FROM AdAcctprocess a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdAcctprocess.findByCreated", query = "SELECT a FROM AdAcctprocess a WHERE a.created = :created"),
    @NamedQuery(name = "AdAcctprocess.findByCreatedby", query = "SELECT a FROM AdAcctprocess a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdAcctprocess.findByUpdated", query = "SELECT a FROM AdAcctprocess a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdAcctprocess.findByUpdatedby", query = "SELECT a FROM AdAcctprocess a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdAcctprocess.findByName", query = "SELECT a FROM AdAcctprocess a WHERE a.name = :name"),
    @NamedQuery(name = "AdAcctprocess.findByClassname", query = "SELECT a FROM AdAcctprocess a WHERE a.classname = :classname"),
    @NamedQuery(name = "AdAcctprocess.findByDescription", query = "SELECT a FROM AdAcctprocess a WHERE a.description = :description")})
public class AdAcctprocess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_acctprocess_id")
    private String adAcctprocessId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "classname")
    private String classname;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adAcctprocessId")
    private List<CAcctschemaProcess> cAcctschemaProcessList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdAcctprocess() {
    }

    public AdAcctprocess(String adAcctprocessId) {
        this.adAcctprocessId = adAcctprocessId;
    }

    public AdAcctprocess(String adAcctprocessId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String classname) {
        this.adAcctprocessId = adAcctprocessId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.classname = classname;
    }

    public String getAdAcctprocessId() {
        return adAcctprocessId;
    }

    public void setAdAcctprocessId(String adAcctprocessId) {
        this.adAcctprocessId = adAcctprocessId;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<CAcctschemaProcess> getCAcctschemaProcessList() {
        return cAcctschemaProcessList;
    }

    public void setCAcctschemaProcessList(List<CAcctschemaProcess> cAcctschemaProcessList) {
        this.cAcctschemaProcessList = cAcctschemaProcessList;
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
        hash += (adAcctprocessId != null ? adAcctprocessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdAcctprocess)) {
            return false;
        }
        AdAcctprocess other = (AdAcctprocess) object;
        if ((this.adAcctprocessId == null && other.adAcctprocessId != null) || (this.adAcctprocessId != null && !this.adAcctprocessId.equals(other.adAcctprocessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdAcctprocess[ adAcctprocessId=" + adAcctprocessId + " ]";
    }
    
}
