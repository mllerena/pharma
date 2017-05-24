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
@Table(name = "ad_datatype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdDatatype.findAll", query = "SELECT a FROM AdDatatype a"),
    @NamedQuery(name = "AdDatatype.findByAdDatatypeId", query = "SELECT a FROM AdDatatype a WHERE a.adDatatypeId = :adDatatypeId"),
    @NamedQuery(name = "AdDatatype.findByIsactive", query = "SELECT a FROM AdDatatype a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdDatatype.findByCreated", query = "SELECT a FROM AdDatatype a WHERE a.created = :created"),
    @NamedQuery(name = "AdDatatype.findByCreatedby", query = "SELECT a FROM AdDatatype a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdDatatype.findByUpdated", query = "SELECT a FROM AdDatatype a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdDatatype.findByUpdatedby", query = "SELECT a FROM AdDatatype a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdDatatype.findByName", query = "SELECT a FROM AdDatatype a WHERE a.name = :name"),
    @NamedQuery(name = "AdDatatype.findByFormat", query = "SELECT a FROM AdDatatype a WHERE a.format = :format")})
public class AdDatatype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_datatype_id")
    private String adDatatypeId;
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
    @Size(max = 100)
    @Column(name = "format")
    private String format;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adDatatypeId")
    private List<AdAttachment> adAttachmentList;

    public AdDatatype() {
    }

    public AdDatatype(String adDatatypeId) {
        this.adDatatypeId = adDatatypeId;
    }

    public AdDatatype(String adDatatypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.adDatatypeId = adDatatypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getAdDatatypeId() {
        return adDatatypeId;
    }

    public void setAdDatatypeId(String adDatatypeId) {
        this.adDatatypeId = adDatatypeId;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
    public List<AdAttachment> getAdAttachmentList() {
        return adAttachmentList;
    }

    public void setAdAttachmentList(List<AdAttachment> adAttachmentList) {
        this.adAttachmentList = adAttachmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adDatatypeId != null ? adDatatypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdDatatype)) {
            return false;
        }
        AdDatatype other = (AdDatatype) object;
        if ((this.adDatatypeId == null && other.adDatatypeId != null) || (this.adDatatypeId != null && !this.adDatatypeId.equals(other.adDatatypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdDatatype[ adDatatypeId=" + adDatatypeId + " ]";
    }
    
}
