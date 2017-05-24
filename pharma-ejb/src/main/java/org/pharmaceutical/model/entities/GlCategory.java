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
@Table(name = "gl_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlCategory.findAll", query = "SELECT g FROM GlCategory g"),
    @NamedQuery(name = "GlCategory.findByGlCategoryId", query = "SELECT g FROM GlCategory g WHERE g.glCategoryId = :glCategoryId"),
    @NamedQuery(name = "GlCategory.findByIsactive", query = "SELECT g FROM GlCategory g WHERE g.isactive = :isactive"),
    @NamedQuery(name = "GlCategory.findByCreated", query = "SELECT g FROM GlCategory g WHERE g.created = :created"),
    @NamedQuery(name = "GlCategory.findByCreatedby", query = "SELECT g FROM GlCategory g WHERE g.createdby = :createdby"),
    @NamedQuery(name = "GlCategory.findByUpdated", query = "SELECT g FROM GlCategory g WHERE g.updated = :updated"),
    @NamedQuery(name = "GlCategory.findByUpdatedby", query = "SELECT g FROM GlCategory g WHERE g.updatedby = :updatedby"),
    @NamedQuery(name = "GlCategory.findByName", query = "SELECT g FROM GlCategory g WHERE g.name = :name"),
    @NamedQuery(name = "GlCategory.findByDescription", query = "SELECT g FROM GlCategory g WHERE g.description = :description"),
    @NamedQuery(name = "GlCategory.findByCategorytype", query = "SELECT g FROM GlCategory g WHERE g.categorytype = :categorytype"),
    @NamedQuery(name = "GlCategory.findByIsdefault", query = "SELECT g FROM GlCategory g WHERE g.isdefault = :isdefault"),
    @NamedQuery(name = "GlCategory.findByDocbasetype", query = "SELECT g FROM GlCategory g WHERE g.docbasetype = :docbasetype")})
public class GlCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "gl_category_id")
    private String glCategoryId;
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
    @Size(min = 1, max = 60)
    @Column(name = "categorytype")
    private String categorytype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @Size(max = 60)
    @Column(name = "docbasetype")
    private String docbasetype;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "glCategoryId")
    private List<CDoctype> cDoctypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "glCategoryId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "glCategoryId")
    private List<GlJournalbatch> glJournalbatchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "glCategoryId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "glCategoryId")
    private List<GlJournal> glJournalList;

    public GlCategory() {
    }

    public GlCategory(String glCategoryId) {
        this.glCategoryId = glCategoryId;
    }

    public GlCategory(String glCategoryId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String categorytype, Character isdefault) {
        this.glCategoryId = glCategoryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.categorytype = categorytype;
        this.isdefault = isdefault;
    }

    public String getGlCategoryId() {
        return glCategoryId;
    }

    public void setGlCategoryId(String glCategoryId) {
        this.glCategoryId = glCategoryId;
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

    public String getCategorytype() {
        return categorytype;
    }

    public void setCategorytype(String categorytype) {
        this.categorytype = categorytype;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public String getDocbasetype() {
        return docbasetype;
    }

    public void setDocbasetype(String docbasetype) {
        this.docbasetype = docbasetype;
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
    public List<CDoctype> getCDoctypeList() {
        return cDoctypeList;
    }

    public void setCDoctypeList(List<CDoctype> cDoctypeList) {
        this.cDoctypeList = cDoctypeList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<GlJournalbatch> getGlJournalbatchList() {
        return glJournalbatchList;
    }

    public void setGlJournalbatchList(List<GlJournalbatch> glJournalbatchList) {
        this.glJournalbatchList = glJournalbatchList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<GlJournal> getGlJournalList() {
        return glJournalList;
    }

    public void setGlJournalList(List<GlJournal> glJournalList) {
        this.glJournalList = glJournalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (glCategoryId != null ? glCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlCategory)) {
            return false;
        }
        GlCategory other = (GlCategory) object;
        if ((this.glCategoryId == null && other.glCategoryId != null) || (this.glCategoryId != null && !this.glCategoryId.equals(other.glCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.GlCategory[ glCategoryId=" + glCategoryId + " ]";
    }
    
}
