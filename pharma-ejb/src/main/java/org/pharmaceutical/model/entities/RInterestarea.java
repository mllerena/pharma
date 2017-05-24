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
@Table(name = "r_interestarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RInterestarea.findAll", query = "SELECT r FROM RInterestarea r"),
    @NamedQuery(name = "RInterestarea.findByRInterestareaId", query = "SELECT r FROM RInterestarea r WHERE r.rInterestareaId = :rInterestareaId"),
    @NamedQuery(name = "RInterestarea.findByIsactive", query = "SELECT r FROM RInterestarea r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RInterestarea.findByCreated", query = "SELECT r FROM RInterestarea r WHERE r.created = :created"),
    @NamedQuery(name = "RInterestarea.findByCreatedby", query = "SELECT r FROM RInterestarea r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RInterestarea.findByUpdated", query = "SELECT r FROM RInterestarea r WHERE r.updated = :updated"),
    @NamedQuery(name = "RInterestarea.findByUpdatedby", query = "SELECT r FROM RInterestarea r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RInterestarea.findByName", query = "SELECT r FROM RInterestarea r WHERE r.name = :name"),
    @NamedQuery(name = "RInterestarea.findByDescription", query = "SELECT r FROM RInterestarea r WHERE r.description = :description")})
public class RInterestarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_interestarea_id")
    private String rInterestareaId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "rInterestareaId")
    private List<RContactinterest> rContactinterestList;

    public RInterestarea() {
    }

    public RInterestarea(String rInterestareaId) {
        this.rInterestareaId = rInterestareaId;
    }

    public RInterestarea(String rInterestareaId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.rInterestareaId = rInterestareaId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getRInterestareaId() {
        return rInterestareaId;
    }

    public void setRInterestareaId(String rInterestareaId) {
        this.rInterestareaId = rInterestareaId;
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
    public List<RContactinterest> getRContactinterestList() {
        return rContactinterestList;
    }

    public void setRContactinterestList(List<RContactinterest> rContactinterestList) {
        this.rContactinterestList = rContactinterestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rInterestareaId != null ? rInterestareaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RInterestarea)) {
            return false;
        }
        RInterestarea other = (RInterestarea) object;
        if ((this.rInterestareaId == null && other.rInterestareaId != null) || (this.rInterestareaId != null && !this.rInterestareaId.equals(other.rInterestareaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RInterestarea[ rInterestareaId=" + rInterestareaId + " ]";
    }
    
}
