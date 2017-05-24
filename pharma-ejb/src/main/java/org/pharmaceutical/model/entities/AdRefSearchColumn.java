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
@Table(name = "ad_ref_search_column")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdRefSearchColumn.findAll", query = "SELECT a FROM AdRefSearchColumn a"),
    @NamedQuery(name = "AdRefSearchColumn.findByAdRefSearchColumnId", query = "SELECT a FROM AdRefSearchColumn a WHERE a.adRefSearchColumnId = :adRefSearchColumnId"),
    @NamedQuery(name = "AdRefSearchColumn.findByIsactive", query = "SELECT a FROM AdRefSearchColumn a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdRefSearchColumn.findByCreated", query = "SELECT a FROM AdRefSearchColumn a WHERE a.created = :created"),
    @NamedQuery(name = "AdRefSearchColumn.findByCreatedby", query = "SELECT a FROM AdRefSearchColumn a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdRefSearchColumn.findByUpdated", query = "SELECT a FROM AdRefSearchColumn a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdRefSearchColumn.findByUpdatedby", query = "SELECT a FROM AdRefSearchColumn a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdRefSearchColumn.findByName", query = "SELECT a FROM AdRefSearchColumn a WHERE a.name = :name"),
    @NamedQuery(name = "AdRefSearchColumn.findByColumnname", query = "SELECT a FROM AdRefSearchColumn a WHERE a.columnname = :columnname"),
    @NamedQuery(name = "AdRefSearchColumn.findByColumntype", query = "SELECT a FROM AdRefSearchColumn a WHERE a.columntype = :columntype"),
    @NamedQuery(name = "AdRefSearchColumn.findByColumnSuffix", query = "SELECT a FROM AdRefSearchColumn a WHERE a.columnSuffix = :columnSuffix")})
public class AdRefSearchColumn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_ref_search_column_id")
    private String adRefSearchColumnId;
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
    @Column(name = "columnname")
    private String columnname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "columntype")
    private String columntype;
    @Size(max = 10)
    @Column(name = "column_suffix")
    private String columnSuffix;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_ref_search_id", referencedColumnName = "ad_ref_search_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdRefSearch adRefSearchId;

    public AdRefSearchColumn() {
    }

    public AdRefSearchColumn(String adRefSearchColumnId) {
        this.adRefSearchColumnId = adRefSearchColumnId;
    }

    public AdRefSearchColumn(String adRefSearchColumnId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String columnname, String columntype) {
        this.adRefSearchColumnId = adRefSearchColumnId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.columnname = columnname;
        this.columntype = columntype;
    }

    public String getAdRefSearchColumnId() {
        return adRefSearchColumnId;
    }

    public void setAdRefSearchColumnId(String adRefSearchColumnId) {
        this.adRefSearchColumnId = adRefSearchColumnId;
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

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public String getColumntype() {
        return columntype;
    }

    public void setColumntype(String columntype) {
        this.columntype = columntype;
    }

    public String getColumnSuffix() {
        return columnSuffix;
    }

    public void setColumnSuffix(String columnSuffix) {
        this.columnSuffix = columnSuffix;
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

    public AdRefSearch getAdRefSearchId() {
        return adRefSearchId;
    }

    public void setAdRefSearchId(AdRefSearch adRefSearchId) {
        this.adRefSearchId = adRefSearchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adRefSearchColumnId != null ? adRefSearchColumnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdRefSearchColumn)) {
            return false;
        }
        AdRefSearchColumn other = (AdRefSearchColumn) object;
        if ((this.adRefSearchColumnId == null && other.adRefSearchColumnId != null) || (this.adRefSearchColumnId != null && !this.adRefSearchColumnId.equals(other.adRefSearchColumnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdRefSearchColumn[ adRefSearchColumnId=" + adRefSearchColumnId + " ]";
    }
    
}
