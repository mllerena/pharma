/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ad_dataset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdDataset.findAll", query = "SELECT a FROM AdDataset a"),
    @NamedQuery(name = "AdDataset.findByAdDatasetId", query = "SELECT a FROM AdDataset a WHERE a.adDatasetId = :adDatasetId"),
    @NamedQuery(name = "AdDataset.findByIsactive", query = "SELECT a FROM AdDataset a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdDataset.findByCreated", query = "SELECT a FROM AdDataset a WHERE a.created = :created"),
    @NamedQuery(name = "AdDataset.findByCreatedby", query = "SELECT a FROM AdDataset a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdDataset.findByUpdated", query = "SELECT a FROM AdDataset a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdDataset.findByUpdatedby", query = "SELECT a FROM AdDataset a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdDataset.findByValue", query = "SELECT a FROM AdDataset a WHERE a.value = :value"),
    @NamedQuery(name = "AdDataset.findByName", query = "SELECT a FROM AdDataset a WHERE a.name = :name"),
    @NamedQuery(name = "AdDataset.findByDescription", query = "SELECT a FROM AdDataset a WHERE a.description = :description"),
    @NamedQuery(name = "AdDataset.findByExport", query = "SELECT a FROM AdDataset a WHERE a.export = :export"),
    @NamedQuery(name = "AdDataset.findByAccesslevel", query = "SELECT a FROM AdDataset a WHERE a.accesslevel = :accesslevel"),
    @NamedQuery(name = "AdDataset.findByExportallowed", query = "SELECT a FROM AdDataset a WHERE a.exportallowed = :exportallowed"),
    @NamedQuery(name = "AdDataset.findByChecksum", query = "SELECT a FROM AdDataset a WHERE a.checksum = :checksum"),
    @NamedQuery(name = "AdDataset.findBySeqno", query = "SELECT a FROM AdDataset a WHERE a.seqno = :seqno")})
public class AdDataset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_dataset_id")
    private String adDatasetId;
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
    @Column(name = "value")
    private String value;
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
    @Column(name = "export")
    private Character export;
    @Size(max = 60)
    @Column(name = "accesslevel")
    private String accesslevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exportallowed")
    private Character exportallowed;
    @Size(max = 100)
    @Column(name = "checksum")
    private String checksum;
    @Column(name = "seqno")
    private BigInteger seqno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adDatasetId")
    private List<AdDatasetTable> adDatasetTableList;

    public AdDataset() {
    }

    public AdDataset(String adDatasetId) {
        this.adDatasetId = adDatasetId;
    }

    public AdDataset(String adDatasetId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, Character export, Character exportallowed) {
        this.adDatasetId = adDatasetId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.export = export;
        this.exportallowed = exportallowed;
    }

    public String getAdDatasetId() {
        return adDatasetId;
    }

    public void setAdDatasetId(String adDatasetId) {
        this.adDatasetId = adDatasetId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Character getExport() {
        return export;
    }

    public void setExport(Character export) {
        this.export = export;
    }

    public String getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(String accesslevel) {
        this.accesslevel = accesslevel;
    }

    public Character getExportallowed() {
        return exportallowed;
    }

    public void setExportallowed(Character exportallowed) {
        this.exportallowed = exportallowed;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public BigInteger getSeqno() {
        return seqno;
    }

    public void setSeqno(BigInteger seqno) {
        this.seqno = seqno;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
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

    @XmlTransient
    public List<AdDatasetTable> getAdDatasetTableList() {
        return adDatasetTableList;
    }

    public void setAdDatasetTableList(List<AdDatasetTable> adDatasetTableList) {
        this.adDatasetTableList = adDatasetTableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adDatasetId != null ? adDatasetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdDataset)) {
            return false;
        }
        AdDataset other = (AdDataset) object;
        if ((this.adDatasetId == null && other.adDatasetId != null) || (this.adDatasetId != null && !this.adDatasetId.equals(other.adDatasetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdDataset[ adDatasetId=" + adDatasetId + " ]";
    }
    
}
