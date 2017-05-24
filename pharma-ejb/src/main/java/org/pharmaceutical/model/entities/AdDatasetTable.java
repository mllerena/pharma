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
@Table(name = "ad_dataset_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdDatasetTable.findAll", query = "SELECT a FROM AdDatasetTable a"),
    @NamedQuery(name = "AdDatasetTable.findByAdDatasetTableId", query = "SELECT a FROM AdDatasetTable a WHERE a.adDatasetTableId = :adDatasetTableId"),
    @NamedQuery(name = "AdDatasetTable.findByIsactive", query = "SELECT a FROM AdDatasetTable a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdDatasetTable.findByCreated", query = "SELECT a FROM AdDatasetTable a WHERE a.created = :created"),
    @NamedQuery(name = "AdDatasetTable.findByCreatedby", query = "SELECT a FROM AdDatasetTable a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdDatasetTable.findByUpdated", query = "SELECT a FROM AdDatasetTable a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdDatasetTable.findByUpdatedby", query = "SELECT a FROM AdDatasetTable a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdDatasetTable.findByIncludeallcolumns", query = "SELECT a FROM AdDatasetTable a WHERE a.includeallcolumns = :includeallcolumns"),
    @NamedQuery(name = "AdDatasetTable.findByWhereclause", query = "SELECT a FROM AdDatasetTable a WHERE a.whereclause = :whereclause"),
    @NamedQuery(name = "AdDatasetTable.findByExcludeauditinfo", query = "SELECT a FROM AdDatasetTable a WHERE a.excludeauditinfo = :excludeauditinfo"),
    @NamedQuery(name = "AdDatasetTable.findByIsbusinessobject", query = "SELECT a FROM AdDatasetTable a WHERE a.isbusinessobject = :isbusinessobject"),
    @NamedQuery(name = "AdDatasetTable.findBySecondarywhereclause", query = "SELECT a FROM AdDatasetTable a WHERE a.secondarywhereclause = :secondarywhereclause")})
public class AdDatasetTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_dataset_table_id")
    private String adDatasetTableId;
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
    @Column(name = "includeallcolumns")
    private Character includeallcolumns;
    @Size(max = 2000)
    @Column(name = "whereclause")
    private String whereclause;
    @Column(name = "excludeauditinfo")
    private Character excludeauditinfo;
    @Column(name = "isbusinessobject")
    private Character isbusinessobject;
    @Size(max = 2000)
    @Column(name = "secondarywhereclause")
    private String secondarywhereclause;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adDatasetTableId")
    private List<AdDatasetColumn> adDatasetColumnList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_dataset_id", referencedColumnName = "ad_dataset_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdDataset adDatasetId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;

    public AdDatasetTable() {
    }

    public AdDatasetTable(String adDatasetTableId) {
        this.adDatasetTableId = adDatasetTableId;
    }

    public AdDatasetTable(String adDatasetTableId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character includeallcolumns) {
        this.adDatasetTableId = adDatasetTableId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.includeallcolumns = includeallcolumns;
    }

    public String getAdDatasetTableId() {
        return adDatasetTableId;
    }

    public void setAdDatasetTableId(String adDatasetTableId) {
        this.adDatasetTableId = adDatasetTableId;
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

    public Character getIncludeallcolumns() {
        return includeallcolumns;
    }

    public void setIncludeallcolumns(Character includeallcolumns) {
        this.includeallcolumns = includeallcolumns;
    }

    public String getWhereclause() {
        return whereclause;
    }

    public void setWhereclause(String whereclause) {
        this.whereclause = whereclause;
    }

    public Character getExcludeauditinfo() {
        return excludeauditinfo;
    }

    public void setExcludeauditinfo(Character excludeauditinfo) {
        this.excludeauditinfo = excludeauditinfo;
    }

    public Character getIsbusinessobject() {
        return isbusinessobject;
    }

    public void setIsbusinessobject(Character isbusinessobject) {
        this.isbusinessobject = isbusinessobject;
    }

    public String getSecondarywhereclause() {
        return secondarywhereclause;
    }

    public void setSecondarywhereclause(String secondarywhereclause) {
        this.secondarywhereclause = secondarywhereclause;
    }

    @XmlTransient
    public List<AdDatasetColumn> getAdDatasetColumnList() {
        return adDatasetColumnList;
    }

    public void setAdDatasetColumnList(List<AdDatasetColumn> adDatasetColumnList) {
        this.adDatasetColumnList = adDatasetColumnList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdDataset getAdDatasetId() {
        return adDatasetId;
    }

    public void setAdDatasetId(AdDataset adDatasetId) {
        this.adDatasetId = adDatasetId;
    }

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adDatasetTableId != null ? adDatasetTableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdDatasetTable)) {
            return false;
        }
        AdDatasetTable other = (AdDatasetTable) object;
        if ((this.adDatasetTableId == null && other.adDatasetTableId != null) || (this.adDatasetTableId != null && !this.adDatasetTableId.equals(other.adDatasetTableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdDatasetTable[ adDatasetTableId=" + adDatasetTableId + " ]";
    }
    
}
