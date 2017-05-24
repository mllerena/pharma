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
@Table(name = "ad_impformat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdImpformat.findAll", query = "SELECT a FROM AdImpformat a"),
    @NamedQuery(name = "AdImpformat.findByAdImpformatId", query = "SELECT a FROM AdImpformat a WHERE a.adImpformatId = :adImpformatId"),
    @NamedQuery(name = "AdImpformat.findByIsactive", query = "SELECT a FROM AdImpformat a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdImpformat.findByCreated", query = "SELECT a FROM AdImpformat a WHERE a.created = :created"),
    @NamedQuery(name = "AdImpformat.findByCreatedby", query = "SELECT a FROM AdImpformat a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdImpformat.findByUpdated", query = "SELECT a FROM AdImpformat a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdImpformat.findByUpdatedby", query = "SELECT a FROM AdImpformat a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdImpformat.findByName", query = "SELECT a FROM AdImpformat a WHERE a.name = :name"),
    @NamedQuery(name = "AdImpformat.findByDescription", query = "SELECT a FROM AdImpformat a WHERE a.description = :description"),
    @NamedQuery(name = "AdImpformat.findByFormattype", query = "SELECT a FROM AdImpformat a WHERE a.formattype = :formattype"),
    @NamedQuery(name = "AdImpformat.findByProcessing", query = "SELECT a FROM AdImpformat a WHERE a.processing = :processing")})
public class AdImpformat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_impformat_id")
    private String adImpformatId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "formattype")
    private String formattype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processing")
    private Character processing;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adImpformatId")
    private List<AdImpformatRow> adImpformatRowList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;

    public AdImpformat() {
    }

    public AdImpformat(String adImpformatId) {
        this.adImpformatId = adImpformatId;
    }

    public AdImpformat(String adImpformatId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String formattype, Character processing) {
        this.adImpformatId = adImpformatId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.formattype = formattype;
        this.processing = processing;
    }

    public String getAdImpformatId() {
        return adImpformatId;
    }

    public void setAdImpformatId(String adImpformatId) {
        this.adImpformatId = adImpformatId;
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

    public String getFormattype() {
        return formattype;
    }

    public void setFormattype(String formattype) {
        this.formattype = formattype;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    @XmlTransient
    public List<AdImpformatRow> getAdImpformatRowList() {
        return adImpformatRowList;
    }

    public void setAdImpformatRowList(List<AdImpformatRow> adImpformatRowList) {
        this.adImpformatRowList = adImpformatRowList;
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

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adImpformatId != null ? adImpformatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdImpformat)) {
            return false;
        }
        AdImpformat other = (AdImpformat) object;
        if ((this.adImpformatId == null && other.adImpformatId != null) || (this.adImpformatId != null && !this.adImpformatId.equals(other.adImpformatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdImpformat[ adImpformatId=" + adImpformatId + " ]";
    }
    
}
