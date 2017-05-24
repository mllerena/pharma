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
@Table(name = "ad_alertrule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdAlertrule.findAll", query = "SELECT a FROM AdAlertrule a"),
    @NamedQuery(name = "AdAlertrule.findByAdAlertruleId", query = "SELECT a FROM AdAlertrule a WHERE a.adAlertruleId = :adAlertruleId"),
    @NamedQuery(name = "AdAlertrule.findByIsactive", query = "SELECT a FROM AdAlertrule a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdAlertrule.findByCreated", query = "SELECT a FROM AdAlertrule a WHERE a.created = :created"),
    @NamedQuery(name = "AdAlertrule.findByCreatedby", query = "SELECT a FROM AdAlertrule a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdAlertrule.findByUpdated", query = "SELECT a FROM AdAlertrule a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdAlertrule.findByUpdatedby", query = "SELECT a FROM AdAlertrule a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdAlertrule.findByName", query = "SELECT a FROM AdAlertrule a WHERE a.name = :name"),
    @NamedQuery(name = "AdAlertrule.findByFilterclause", query = "SELECT a FROM AdAlertrule a WHERE a.filterclause = :filterclause"),
    @NamedQuery(name = "AdAlertrule.findBySql", query = "SELECT a FROM AdAlertrule a WHERE a.sql = :sql"),
    @NamedQuery(name = "AdAlertrule.findByType", query = "SELECT a FROM AdAlertrule a WHERE a.type = :type")})
public class AdAlertrule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_alertrule_id")
    private String adAlertruleId;
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
    @Size(max = 2000)
    @Column(name = "filterclause")
    private String filterclause;
    @Size(max = 2000)
    @Column(name = "sql")
    private String sql;
    @Size(max = 60)
    @Column(name = "type")
    private String type;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adAlertruleId")
    private List<AdAlertrecipient> adAlertrecipientList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adAlertruleId")
    private List<AdAlertruleTrl> adAlertruleTrlList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_tab_id", referencedColumnName = "ad_tab_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTab adTabId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adAlertruleId")
    private List<AdAlert> adAlertList;

    public AdAlertrule() {
    }

    public AdAlertrule(String adAlertruleId) {
        this.adAlertruleId = adAlertruleId;
    }

    public AdAlertrule(String adAlertruleId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.adAlertruleId = adAlertruleId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getAdAlertruleId() {
        return adAlertruleId;
    }

    public void setAdAlertruleId(String adAlertruleId) {
        this.adAlertruleId = adAlertruleId;
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

    public String getFilterclause() {
        return filterclause;
    }

    public void setFilterclause(String filterclause) {
        this.filterclause = filterclause;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<AdAlertrecipient> getAdAlertrecipientList() {
        return adAlertrecipientList;
    }

    public void setAdAlertrecipientList(List<AdAlertrecipient> adAlertrecipientList) {
        this.adAlertrecipientList = adAlertrecipientList;
    }

    @XmlTransient
    public List<AdAlertruleTrl> getAdAlertruleTrlList() {
        return adAlertruleTrlList;
    }

    public void setAdAlertruleTrlList(List<AdAlertruleTrl> adAlertruleTrlList) {
        this.adAlertruleTrlList = adAlertruleTrlList;
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

    public AdTab getAdTabId() {
        return adTabId;
    }

    public void setAdTabId(AdTab adTabId) {
        this.adTabId = adTabId;
    }

    @XmlTransient
    public List<AdAlert> getAdAlertList() {
        return adAlertList;
    }

    public void setAdAlertList(List<AdAlert> adAlertList) {
        this.adAlertList = adAlertList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adAlertruleId != null ? adAlertruleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdAlertrule)) {
            return false;
        }
        AdAlertrule other = (AdAlertrule) object;
        if ((this.adAlertruleId == null && other.adAlertruleId != null) || (this.adAlertruleId != null && !this.adAlertruleId.equals(other.adAlertruleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdAlertrule[ adAlertruleId=" + adAlertruleId + " ]";
    }
    
}
