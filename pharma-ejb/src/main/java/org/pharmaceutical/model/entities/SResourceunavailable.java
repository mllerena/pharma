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
@Table(name = "s_resourceunavailable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SResourceunavailable.findAll", query = "SELECT s FROM SResourceunavailable s"),
    @NamedQuery(name = "SResourceunavailable.findBySResourceunavailableId", query = "SELECT s FROM SResourceunavailable s WHERE s.sResourceunavailableId = :sResourceunavailableId"),
    @NamedQuery(name = "SResourceunavailable.findByIsactive", query = "SELECT s FROM SResourceunavailable s WHERE s.isactive = :isactive"),
    @NamedQuery(name = "SResourceunavailable.findByCreated", query = "SELECT s FROM SResourceunavailable s WHERE s.created = :created"),
    @NamedQuery(name = "SResourceunavailable.findByCreatedby", query = "SELECT s FROM SResourceunavailable s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SResourceunavailable.findByUpdated", query = "SELECT s FROM SResourceunavailable s WHERE s.updated = :updated"),
    @NamedQuery(name = "SResourceunavailable.findByUpdatedby", query = "SELECT s FROM SResourceunavailable s WHERE s.updatedby = :updatedby"),
    @NamedQuery(name = "SResourceunavailable.findByDatefrom", query = "SELECT s FROM SResourceunavailable s WHERE s.datefrom = :datefrom"),
    @NamedQuery(name = "SResourceunavailable.findByDateto", query = "SELECT s FROM SResourceunavailable s WHERE s.dateto = :dateto"),
    @NamedQuery(name = "SResourceunavailable.findByDescription", query = "SELECT s FROM SResourceunavailable s WHERE s.description = :description")})
public class SResourceunavailable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "s_resourceunavailable_id")
    private String sResourceunavailableId;
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
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "s_resource_id", referencedColumnName = "s_resource_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private SResource sResourceId;

    public SResourceunavailable() {
    }

    public SResourceunavailable(String sResourceunavailableId) {
        this.sResourceunavailableId = sResourceunavailableId;
    }

    public SResourceunavailable(String sResourceunavailableId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date datefrom) {
        this.sResourceunavailableId = sResourceunavailableId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.datefrom = datefrom;
    }

    public String getSResourceunavailableId() {
        return sResourceunavailableId;
    }

    public void setSResourceunavailableId(String sResourceunavailableId) {
        this.sResourceunavailableId = sResourceunavailableId;
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

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public SResource getSResourceId() {
        return sResourceId;
    }

    public void setSResourceId(SResource sResourceId) {
        this.sResourceId = sResourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sResourceunavailableId != null ? sResourceunavailableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SResourceunavailable)) {
            return false;
        }
        SResourceunavailable other = (SResourceunavailable) object;
        if ((this.sResourceunavailableId == null && other.sResourceunavailableId != null) || (this.sResourceunavailableId != null && !this.sResourceunavailableId.equals(other.sResourceunavailableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.SResourceunavailable[ sResourceunavailableId=" + sResourceunavailableId + " ]";
    }
    
}
