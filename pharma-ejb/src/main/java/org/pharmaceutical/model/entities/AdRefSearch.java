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
import javax.persistence.FetchType;
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
@Table(name = "ad_ref_search")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdRefSearch.findAll", query = "SELECT a FROM AdRefSearch a"),
    @NamedQuery(name = "AdRefSearch.findByAdRefSearchId", query = "SELECT a FROM AdRefSearch a WHERE a.adRefSearchId = :adRefSearchId"),
    @NamedQuery(name = "AdRefSearch.findByIsactive", query = "SELECT a FROM AdRefSearch a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdRefSearch.findByCreated", query = "SELECT a FROM AdRefSearch a WHERE a.created = :created"),
    @NamedQuery(name = "AdRefSearch.findByCreatedby", query = "SELECT a FROM AdRefSearch a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdRefSearch.findByUpdated", query = "SELECT a FROM AdRefSearch a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdRefSearch.findByUpdatedby", query = "SELECT a FROM AdRefSearch a WHERE a.updatedby = :updatedby")})
public class AdRefSearch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_ref_search_id")
    private String adRefSearchId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_column_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdColumn adColumnId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_reference_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdReference adReferenceId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRefSearchId")
    private List<AdRefSearchColumn> adRefSearchColumnList;

    public AdRefSearch() {
    }

    public AdRefSearch(String adRefSearchId) {
        this.adRefSearchId = adRefSearchId;
    }

    public AdRefSearch(String adRefSearchId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adRefSearchId = adRefSearchId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdRefSearchId() {
        return adRefSearchId;
    }

    public void setAdRefSearchId(String adRefSearchId) {
        this.adRefSearchId = adRefSearchId;
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

    public AdReference getAdReferenceId() {
        return adReferenceId;
    }

    public void setAdReferenceId(AdReference adReferenceId) {
        this.adReferenceId = adReferenceId;
    }

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @XmlTransient
    public List<AdRefSearchColumn> getAdRefSearchColumnList() {
        return adRefSearchColumnList;
    }

    public void setAdRefSearchColumnList(List<AdRefSearchColumn> adRefSearchColumnList) {
        this.adRefSearchColumnList = adRefSearchColumnList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adRefSearchId != null ? adRefSearchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdRefSearch)) {
            return false;
        }
        AdRefSearch other = (AdRefSearch) object;
        if ((this.adRefSearchId == null && other.adRefSearchId != null) || (this.adRefSearchId != null && !this.adRefSearchId.equals(other.adRefSearchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdRefSearch[ adRefSearchId=" + adRefSearchId + " ]";
    }
    
}
