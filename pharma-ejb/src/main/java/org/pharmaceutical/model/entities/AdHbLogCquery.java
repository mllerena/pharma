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
@Table(name = "ad_hb_log_cquery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdHbLogCquery.findAll", query = "SELECT a FROM AdHbLogCquery a"),
    @NamedQuery(name = "AdHbLogCquery.findByAdHbLogCqueryId", query = "SELECT a FROM AdHbLogCquery a WHERE a.adHbLogCqueryId = :adHbLogCqueryId"),
    @NamedQuery(name = "AdHbLogCquery.findByIsactive", query = "SELECT a FROM AdHbLogCquery a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdHbLogCquery.findByCreated", query = "SELECT a FROM AdHbLogCquery a WHERE a.created = :created"),
    @NamedQuery(name = "AdHbLogCquery.findByCreatedby", query = "SELECT a FROM AdHbLogCquery a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdHbLogCquery.findByUpdated", query = "SELECT a FROM AdHbLogCquery a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdHbLogCquery.findByUpdatedby", query = "SELECT a FROM AdHbLogCquery a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdHbLogCquery.findByName", query = "SELECT a FROM AdHbLogCquery a WHERE a.name = :name"),
    @NamedQuery(name = "AdHbLogCquery.findByType", query = "SELECT a FROM AdHbLogCquery a WHERE a.type = :type"),
    @NamedQuery(name = "AdHbLogCquery.findByCode", query = "SELECT a FROM AdHbLogCquery a WHERE a.code = :code")})
public class AdHbLogCquery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_hb_log_cquery_id")
    private String adHbLogCqueryId;
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
    @Column(name = "type")
    private String type;
    @Size(max = 2000)
    @Column(name = "code")
    private String code;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_heartbeat_log_id", referencedColumnName = "ad_heartbeat_log_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdHeartbeatLog adHeartbeatLogId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adHbLogCqueryId")
    private List<AdHbLogCqueryRow> adHbLogCqueryRowList;

    public AdHbLogCquery() {
    }

    public AdHbLogCquery(String adHbLogCqueryId) {
        this.adHbLogCqueryId = adHbLogCqueryId;
    }

    public AdHbLogCquery(String adHbLogCqueryId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String type) {
        this.adHbLogCqueryId = adHbLogCqueryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.type = type;
    }

    public String getAdHbLogCqueryId() {
        return adHbLogCqueryId;
    }

    public void setAdHbLogCqueryId(String adHbLogCqueryId) {
        this.adHbLogCqueryId = adHbLogCqueryId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdHeartbeatLog getAdHeartbeatLogId() {
        return adHeartbeatLogId;
    }

    public void setAdHeartbeatLogId(AdHeartbeatLog adHeartbeatLogId) {
        this.adHeartbeatLogId = adHeartbeatLogId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    @XmlTransient
    public List<AdHbLogCqueryRow> getAdHbLogCqueryRowList() {
        return adHbLogCqueryRowList;
    }

    public void setAdHbLogCqueryRowList(List<AdHbLogCqueryRow> adHbLogCqueryRowList) {
        this.adHbLogCqueryRowList = adHbLogCqueryRowList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adHbLogCqueryId != null ? adHbLogCqueryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdHbLogCquery)) {
            return false;
        }
        AdHbLogCquery other = (AdHbLogCquery) object;
        if ((this.adHbLogCqueryId == null && other.adHbLogCqueryId != null) || (this.adHbLogCqueryId != null && !this.adHbLogCqueryId.equals(other.adHbLogCqueryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdHbLogCquery[ adHbLogCqueryId=" + adHbLogCqueryId + " ]";
    }
    
}
