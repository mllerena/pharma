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
@Table(name = "at_rollogin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtRollogin.findAll", query = "SELECT a FROM AtRollogin a"),
    @NamedQuery(name = "AtRollogin.findByAtRolloginId", query = "SELECT a FROM AtRollogin a WHERE a.atRolloginId = :atRolloginId"),
    @NamedQuery(name = "AtRollogin.findByIsactive", query = "SELECT a FROM AtRollogin a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AtRollogin.findByCreated", query = "SELECT a FROM AtRollogin a WHERE a.created = :created"),
    @NamedQuery(name = "AtRollogin.findByCreatedby", query = "SELECT a FROM AtRollogin a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AtRollogin.findByUpdated", query = "SELECT a FROM AtRollogin a WHERE a.updated = :updated"),
    @NamedQuery(name = "AtRollogin.findByUpdatedby", query = "SELECT a FROM AtRollogin a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AtRollogin.findByName", query = "SELECT a FROM AtRollogin a WHERE a.name = :name")})
public class AtRollogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "at_rollogin_id")
    private String atRolloginId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "at_test_id", referencedColumnName = "at_test_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AtTest atTestId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "atRolloginId")
    private List<AtTest> atTestList;

    public AtRollogin() {
    }

    public AtRollogin(String atRolloginId) {
        this.atRolloginId = atRolloginId;
    }

    public AtRollogin(String atRolloginId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.atRolloginId = atRolloginId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getAtRolloginId() {
        return atRolloginId;
    }

    public void setAtRolloginId(String atRolloginId) {
        this.atRolloginId = atRolloginId;
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

    public AtTest getAtTestId() {
        return atTestId;
    }

    public void setAtTestId(AtTest atTestId) {
        this.atTestId = atTestId;
    }

    @XmlTransient
    public List<AtTest> getAtTestList() {
        return atTestList;
    }

    public void setAtTestList(List<AtTest> atTestList) {
        this.atTestList = atTestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atRolloginId != null ? atRolloginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtRollogin)) {
            return false;
        }
        AtRollogin other = (AtRollogin) object;
        if ((this.atRolloginId == null && other.atRolloginId != null) || (this.atRolloginId != null && !this.atRolloginId.equals(other.atRolloginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AtRollogin[ atRolloginId=" + atRolloginId + " ]";
    }
    
}
