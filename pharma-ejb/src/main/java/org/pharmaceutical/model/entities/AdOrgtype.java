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
@Table(name = "ad_orgtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdOrgtype.findAll", query = "SELECT a FROM AdOrgtype a"),
    @NamedQuery(name = "AdOrgtype.findByAdOrgtypeId", query = "SELECT a FROM AdOrgtype a WHERE a.adOrgtypeId = :adOrgtypeId"),
    @NamedQuery(name = "AdOrgtype.findByIsactive", query = "SELECT a FROM AdOrgtype a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdOrgtype.findByCreated", query = "SELECT a FROM AdOrgtype a WHERE a.created = :created"),
    @NamedQuery(name = "AdOrgtype.findByCreatedby", query = "SELECT a FROM AdOrgtype a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdOrgtype.findByUpdated", query = "SELECT a FROM AdOrgtype a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdOrgtype.findByUpdatedby", query = "SELECT a FROM AdOrgtype a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdOrgtype.findByIsdefault", query = "SELECT a FROM AdOrgtype a WHERE a.isdefault = :isdefault"),
    @NamedQuery(name = "AdOrgtype.findByName", query = "SELECT a FROM AdOrgtype a WHERE a.name = :name"),
    @NamedQuery(name = "AdOrgtype.findByDescription", query = "SELECT a FROM AdOrgtype a WHERE a.description = :description"),
    @NamedQuery(name = "AdOrgtype.findByIslegalentity", query = "SELECT a FROM AdOrgtype a WHERE a.islegalentity = :islegalentity"),
    @NamedQuery(name = "AdOrgtype.findByIsbusinessunit", query = "SELECT a FROM AdOrgtype a WHERE a.isbusinessunit = :isbusinessunit"),
    @NamedQuery(name = "AdOrgtype.findByIstransactionsallowed", query = "SELECT a FROM AdOrgtype a WHERE a.istransactionsallowed = :istransactionsallowed"),
    @NamedQuery(name = "AdOrgtype.findByIsacctlegalentity", query = "SELECT a FROM AdOrgtype a WHERE a.isacctlegalentity = :isacctlegalentity")})
public class AdOrgtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_orgtype_id")
    private String adOrgtypeId;
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
    @Column(name = "isdefault")
    private Character isdefault;
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
    @Column(name = "islegalentity")
    private Character islegalentity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbusinessunit")
    private Character isbusinessunit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istransactionsallowed")
    private Character istransactionsallowed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isacctlegalentity")
    private Character isacctlegalentity;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adOrgtypeId")
    private List<AdOrg> adOrgList;

    public AdOrgtype() {
    }

    public AdOrgtype(String adOrgtypeId) {
        this.adOrgtypeId = adOrgtypeId;
    }

    public AdOrgtype(String adOrgtypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isdefault, String name, Character islegalentity, Character isbusinessunit, Character istransactionsallowed, Character isacctlegalentity) {
        this.adOrgtypeId = adOrgtypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isdefault = isdefault;
        this.name = name;
        this.islegalentity = islegalentity;
        this.isbusinessunit = isbusinessunit;
        this.istransactionsallowed = istransactionsallowed;
        this.isacctlegalentity = isacctlegalentity;
    }

    public String getAdOrgtypeId() {
        return adOrgtypeId;
    }

    public void setAdOrgtypeId(String adOrgtypeId) {
        this.adOrgtypeId = adOrgtypeId;
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

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
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

    public Character getIslegalentity() {
        return islegalentity;
    }

    public void setIslegalentity(Character islegalentity) {
        this.islegalentity = islegalentity;
    }

    public Character getIsbusinessunit() {
        return isbusinessunit;
    }

    public void setIsbusinessunit(Character isbusinessunit) {
        this.isbusinessunit = isbusinessunit;
    }

    public Character getIstransactionsallowed() {
        return istransactionsallowed;
    }

    public void setIstransactionsallowed(Character istransactionsallowed) {
        this.istransactionsallowed = istransactionsallowed;
    }

    public Character getIsacctlegalentity() {
        return isacctlegalentity;
    }

    public void setIsacctlegalentity(Character isacctlegalentity) {
        this.isacctlegalentity = isacctlegalentity;
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
    public List<AdOrg> getAdOrgList() {
        return adOrgList;
    }

    public void setAdOrgList(List<AdOrg> adOrgList) {
        this.adOrgList = adOrgList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adOrgtypeId != null ? adOrgtypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdOrgtype)) {
            return false;
        }
        AdOrgtype other = (AdOrgtype) object;
        if ((this.adOrgtypeId == null && other.adOrgtypeId != null) || (this.adOrgtypeId != null && !this.adOrgtypeId.equals(other.adOrgtypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdOrgtype[ adOrgtypeId=" + adOrgtypeId + " ]";
    }
    
}
