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
@Table(name = "ad_dimension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdDimension.findAll", query = "SELECT a FROM AdDimension a"),
    @NamedQuery(name = "AdDimension.findByAdDimensionId", query = "SELECT a FROM AdDimension a WHERE a.adDimensionId = :adDimensionId"),
    @NamedQuery(name = "AdDimension.findByIsactive", query = "SELECT a FROM AdDimension a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdDimension.findByCreated", query = "SELECT a FROM AdDimension a WHERE a.created = :created"),
    @NamedQuery(name = "AdDimension.findByCreatedby", query = "SELECT a FROM AdDimension a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdDimension.findByUpdated", query = "SELECT a FROM AdDimension a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdDimension.findByUpdatedby", query = "SELECT a FROM AdDimension a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdDimension.findByColumnname", query = "SELECT a FROM AdDimension a WHERE a.columnname = :columnname"),
    @NamedQuery(name = "AdDimension.findByLine", query = "SELECT a FROM AdDimension a WHERE a.line = :line"),
    @NamedQuery(name = "AdDimension.findByDescription", query = "SELECT a FROM AdDimension a WHERE a.description = :description"),
    @NamedQuery(name = "AdDimension.findByJoinGroup1", query = "SELECT a FROM AdDimension a WHERE a.joinGroup1 = :joinGroup1"),
    @NamedQuery(name = "AdDimension.findByTablename", query = "SELECT a FROM AdDimension a WHERE a.tablename = :tablename"),
    @NamedQuery(name = "AdDimension.findByJoinGroup2", query = "SELECT a FROM AdDimension a WHERE a.joinGroup2 = :joinGroup2")})
public class AdDimension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_dimension_id")
    private String adDimensionId;
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
    @Size(min = 1, max = 40)
    @Column(name = "columnname")
    private String columnname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line")
    private long line;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "join_group1")
    private String joinGroup1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "tablename")
    private String tablename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "join_group2")
    private String joinGroup2;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdProcess adProcessId;

    public AdDimension() {
    }

    public AdDimension(String adDimensionId) {
        this.adDimensionId = adDimensionId;
    }

    public AdDimension(String adDimensionId, Character isactive, Date created, String createdby, Date updated, String updatedby, String columnname, long line, String description, String joinGroup1, String tablename, String joinGroup2) {
        this.adDimensionId = adDimensionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.columnname = columnname;
        this.line = line;
        this.description = description;
        this.joinGroup1 = joinGroup1;
        this.tablename = tablename;
        this.joinGroup2 = joinGroup2;
    }

    public String getAdDimensionId() {
        return adDimensionId;
    }

    public void setAdDimensionId(String adDimensionId) {
        this.adDimensionId = adDimensionId;
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

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJoinGroup1() {
        return joinGroup1;
    }

    public void setJoinGroup1(String joinGroup1) {
        this.joinGroup1 = joinGroup1;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getJoinGroup2() {
        return joinGroup2;
    }

    public void setJoinGroup2(String joinGroup2) {
        this.joinGroup2 = joinGroup2;
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

    public AdProcess getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(AdProcess adProcessId) {
        this.adProcessId = adProcessId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adDimensionId != null ? adDimensionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdDimension)) {
            return false;
        }
        AdDimension other = (AdDimension) object;
        if ((this.adDimensionId == null && other.adDimensionId != null) || (this.adDimensionId != null && !this.adDimensionId.equals(other.adDimensionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdDimension[ adDimensionId=" + adDimensionId + " ]";
    }
    
}
