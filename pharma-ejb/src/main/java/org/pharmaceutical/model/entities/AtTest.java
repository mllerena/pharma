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
@Table(name = "at_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtTest.findAll", query = "SELECT a FROM AtTest a"),
    @NamedQuery(name = "AtTest.findByAtTestId", query = "SELECT a FROM AtTest a WHERE a.atTestId = :atTestId"),
    @NamedQuery(name = "AtTest.findByIsactive", query = "SELECT a FROM AtTest a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AtTest.findByCreated", query = "SELECT a FROM AtTest a WHERE a.created = :created"),
    @NamedQuery(name = "AtTest.findByCreatedby", query = "SELECT a FROM AtTest a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AtTest.findByUpdated", query = "SELECT a FROM AtTest a WHERE a.updated = :updated"),
    @NamedQuery(name = "AtTest.findByUpdatedby", query = "SELECT a FROM AtTest a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AtTest.findByName", query = "SELECT a FROM AtTest a WHERE a.name = :name"),
    @NamedQuery(name = "AtTest.findByDescription", query = "SELECT a FROM AtTest a WHERE a.description = :description"),
    @NamedQuery(name = "AtTest.findByIntroduction", query = "SELECT a FROM AtTest a WHERE a.introduction = :introduction"),
    @NamedQuery(name = "AtTest.findByType", query = "SELECT a FROM AtTest a WHERE a.type = :type"),
    @NamedQuery(name = "AtTest.findByFilename", query = "SELECT a FROM AtTest a WHERE a.filename = :filename"),
    @NamedQuery(name = "AtTest.findByImporttest", query = "SELECT a FROM AtTest a WHERE a.importtest = :importtest"),
    @NamedQuery(name = "AtTest.findByCopylines", query = "SELECT a FROM AtTest a WHERE a.copylines = :copylines"),
    @NamedQuery(name = "AtTest.findByDeleting", query = "SELECT a FROM AtTest a WHERE a.deleting = :deleting"),
    @NamedQuery(name = "AtTest.findByIssummary", query = "SELECT a FROM AtTest a WHERE a.issummary = :issummary"),
    @NamedQuery(name = "AtTest.findByAction", query = "SELECT a FROM AtTest a WHERE a.action = :action")})
public class AtTest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "at_test_id")
    private String atTestId;
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
    @Column(name = "introduction")
    private String introduction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "filename")
    private String filename;
    @Column(name = "importtest")
    private Character importtest;
    @Column(name = "copylines")
    private Character copylines;
    @Column(name = "deleting")
    private Character deleting;
    @Column(name = "issummary")
    private Character issummary;
    @Column(name = "action")
    private Character action;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "atTestId")
    private List<AtRollogin> atRolloginList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "atTestId")
    private List<AtLine> atLineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "childTest")
    private List<AtLine> atLineList1;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "at_rollogin_id", referencedColumnName = "at_rollogin_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AtRollogin atRolloginId;

    public AtTest() {
    }

    public AtTest(String atTestId) {
        this.atTestId = atTestId;
    }

    public AtTest(String atTestId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String type, String filename) {
        this.atTestId = atTestId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.type = type;
        this.filename = filename;
    }

    public String getAtTestId() {
        return atTestId;
    }

    public void setAtTestId(String atTestId) {
        this.atTestId = atTestId;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Character getImporttest() {
        return importtest;
    }

    public void setImporttest(Character importtest) {
        this.importtest = importtest;
    }

    public Character getCopylines() {
        return copylines;
    }

    public void setCopylines(Character copylines) {
        this.copylines = copylines;
    }

    public Character getDeleting() {
        return deleting;
    }

    public void setDeleting(Character deleting) {
        this.deleting = deleting;
    }

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
    }

    public Character getAction() {
        return action;
    }

    public void setAction(Character action) {
        this.action = action;
    }

    @XmlTransient
    public List<AtRollogin> getAtRolloginList() {
        return atRolloginList;
    }

    public void setAtRolloginList(List<AtRollogin> atRolloginList) {
        this.atRolloginList = atRolloginList;
    }

    @XmlTransient
    public List<AtLine> getAtLineList() {
        return atLineList;
    }

    public void setAtLineList(List<AtLine> atLineList) {
        this.atLineList = atLineList;
    }

    @XmlTransient
    public List<AtLine> getAtLineList1() {
        return atLineList1;
    }

    public void setAtLineList1(List<AtLine> atLineList1) {
        this.atLineList1 = atLineList1;
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

    public AtRollogin getAtRolloginId() {
        return atRolloginId;
    }

    public void setAtRolloginId(AtRollogin atRolloginId) {
        this.atRolloginId = atRolloginId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atTestId != null ? atTestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtTest)) {
            return false;
        }
        AtTest other = (AtTest) object;
        if ((this.atTestId == null && other.atTestId != null) || (this.atTestId != null && !this.atTestId.equals(other.atTestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AtTest[ atTestId=" + atTestId + " ]";
    }
    
}
