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
@Table(name = "ad_createfact_template")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdCreatefactTemplate.findAll", query = "SELECT a FROM AdCreatefactTemplate a"),
    @NamedQuery(name = "AdCreatefactTemplate.findByAdCreatefactTemplateId", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.adCreatefactTemplateId = :adCreatefactTemplateId"),
    @NamedQuery(name = "AdCreatefactTemplate.findByIsactive", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdCreatefactTemplate.findByCreated", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.created = :created"),
    @NamedQuery(name = "AdCreatefactTemplate.findByCreatedby", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdCreatefactTemplate.findByUpdated", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdCreatefactTemplate.findByUpdatedby", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdCreatefactTemplate.findByName", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.name = :name"),
    @NamedQuery(name = "AdCreatefactTemplate.findByClassname", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.classname = :classname"),
    @NamedQuery(name = "AdCreatefactTemplate.findByDescription", query = "SELECT a FROM AdCreatefactTemplate a WHERE a.description = :description")})
public class AdCreatefactTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_createfact_template_id")
    private String adCreatefactTemplateId;
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
    @Size(min = 1, max = 1000)
    @Column(name = "classname")
    private String classname;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adCreatefactTemplateId")
    private List<CAcctschemaTableDoctype> cAcctschemaTableDoctypeList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTable adTableId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adCreatefactTemplateId")
    private List<CAcctschemaTable> cAcctschemaTableList;

    public AdCreatefactTemplate() {
    }

    public AdCreatefactTemplate(String adCreatefactTemplateId) {
        this.adCreatefactTemplateId = adCreatefactTemplateId;
    }

    public AdCreatefactTemplate(String adCreatefactTemplateId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String classname) {
        this.adCreatefactTemplateId = adCreatefactTemplateId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.classname = classname;
    }

    public String getAdCreatefactTemplateId() {
        return adCreatefactTemplateId;
    }

    public void setAdCreatefactTemplateId(String adCreatefactTemplateId) {
        this.adCreatefactTemplateId = adCreatefactTemplateId;
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
    public List<CAcctschemaTableDoctype> getCAcctschemaTableDoctypeList() {
        return cAcctschemaTableDoctypeList;
    }

    public void setCAcctschemaTableDoctypeList(List<CAcctschemaTableDoctype> cAcctschemaTableDoctypeList) {
        this.cAcctschemaTableDoctypeList = cAcctschemaTableDoctypeList;
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

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @XmlTransient
    public List<CAcctschemaTable> getCAcctschemaTableList() {
        return cAcctschemaTableList;
    }

    public void setCAcctschemaTableList(List<CAcctschemaTable> cAcctschemaTableList) {
        this.cAcctschemaTableList = cAcctschemaTableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adCreatefactTemplateId != null ? adCreatefactTemplateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdCreatefactTemplate)) {
            return false;
        }
        AdCreatefactTemplate other = (AdCreatefactTemplate) object;
        if ((this.adCreatefactTemplateId == null && other.adCreatefactTemplateId != null) || (this.adCreatefactTemplateId != null && !this.adCreatefactTemplateId.equals(other.adCreatefactTemplateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdCreatefactTemplate[ adCreatefactTemplateId=" + adCreatefactTemplateId + " ]";
    }
    
}
