/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ad_changelog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdChangelog.findAll", query = "SELECT a FROM AdChangelog a"),
    @NamedQuery(name = "AdChangelog.findByAdChangelogId", query = "SELECT a FROM AdChangelog a WHERE a.adChangelogId = :adChangelogId"),
    @NamedQuery(name = "AdChangelog.findByIsactive", query = "SELECT a FROM AdChangelog a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdChangelog.findByCreated", query = "SELECT a FROM AdChangelog a WHERE a.created = :created"),
    @NamedQuery(name = "AdChangelog.findByCreatedby", query = "SELECT a FROM AdChangelog a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdChangelog.findByUpdated", query = "SELECT a FROM AdChangelog a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdChangelog.findByUpdatedby", query = "SELECT a FROM AdChangelog a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdChangelog.findByRecordId", query = "SELECT a FROM AdChangelog a WHERE a.recordId = :recordId"),
    @NamedQuery(name = "AdChangelog.findByOldvalue", query = "SELECT a FROM AdChangelog a WHERE a.oldvalue = :oldvalue"),
    @NamedQuery(name = "AdChangelog.findByNewvalue", query = "SELECT a FROM AdChangelog a WHERE a.newvalue = :newvalue")})
public class AdChangelog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_changelog_id")
    private String adChangelogId;
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
    @Size(min = 1, max = 32)
    @Column(name = "record_id")
    private String recordId;
    @Size(max = 2000)
    @Column(name = "oldvalue")
    private String oldvalue;
    @Size(max = 2000)
    @Column(name = "newvalue")
    private String newvalue;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_column_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdColumn adColumnId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_session_id", referencedColumnName = "ad_session_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdSession adSessionId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;

    public AdChangelog() {
    }

    public AdChangelog(String adChangelogId) {
        this.adChangelogId = adChangelogId;
    }

    public AdChangelog(String adChangelogId, Character isactive, Date created, String createdby, Date updated, String updatedby, String recordId) {
        this.adChangelogId = adChangelogId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.recordId = recordId;
    }

    public String getAdChangelogId() {
        return adChangelogId;
    }

    public void setAdChangelogId(String adChangelogId) {
        this.adChangelogId = adChangelogId;
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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String getNewvalue() {
        return newvalue;
    }

    public void setNewvalue(String newvalue) {
        this.newvalue = newvalue;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdColumn getAdColumnId() {
        return adColumnId;
    }

    public void setAdColumnId(AdColumn adColumnId) {
        this.adColumnId = adColumnId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdSession getAdSessionId() {
        return adSessionId;
    }

    public void setAdSessionId(AdSession adSessionId) {
        this.adSessionId = adSessionId;
    }

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adChangelogId != null ? adChangelogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdChangelog)) {
            return false;
        }
        AdChangelog other = (AdChangelog) object;
        if ((this.adChangelogId == null && other.adChangelogId != null) || (this.adChangelogId != null && !this.adChangelogId.equals(other.adChangelogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdChangelog[ adChangelogId=" + adChangelogId + " ]";
    }
    
}
