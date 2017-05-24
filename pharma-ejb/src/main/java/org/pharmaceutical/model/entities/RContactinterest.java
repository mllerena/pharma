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
@Table(name = "r_contactinterest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RContactinterest.findAll", query = "SELECT r FROM RContactinterest r"),
    @NamedQuery(name = "RContactinterest.findByIsactive", query = "SELECT r FROM RContactinterest r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RContactinterest.findByCreated", query = "SELECT r FROM RContactinterest r WHERE r.created = :created"),
    @NamedQuery(name = "RContactinterest.findByCreatedby", query = "SELECT r FROM RContactinterest r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RContactinterest.findByUpdated", query = "SELECT r FROM RContactinterest r WHERE r.updated = :updated"),
    @NamedQuery(name = "RContactinterest.findByUpdatedby", query = "SELECT r FROM RContactinterest r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RContactinterest.findBySubscribedate", query = "SELECT r FROM RContactinterest r WHERE r.subscribedate = :subscribedate"),
    @NamedQuery(name = "RContactinterest.findByOptoutdate", query = "SELECT r FROM RContactinterest r WHERE r.optoutdate = :optoutdate"),
    @NamedQuery(name = "RContactinterest.findByRContactinterestId", query = "SELECT r FROM RContactinterest r WHERE r.rContactinterestId = :rContactinterestId")})
public class RContactinterest implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Column(name = "subscribedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscribedate;
    @Column(name = "optoutdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optoutdate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_contactinterest_id")
    private String rContactinterestId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser adUserId;
    @JoinColumn(name = "r_interestarea_id", referencedColumnName = "r_interestarea_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private RInterestarea rInterestareaId;

    public RContactinterest() {
    }

    public RContactinterest(String rContactinterestId) {
        this.rContactinterestId = rContactinterestId;
    }

    public RContactinterest(String rContactinterestId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.rContactinterestId = rContactinterestId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
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

    public Date getSubscribedate() {
        return subscribedate;
    }

    public void setSubscribedate(Date subscribedate) {
        this.subscribedate = subscribedate;
    }

    public Date getOptoutdate() {
        return optoutdate;
    }

    public void setOptoutdate(Date optoutdate) {
        this.optoutdate = optoutdate;
    }

    public String getRContactinterestId() {
        return rContactinterestId;
    }

    public void setRContactinterestId(String rContactinterestId) {
        this.rContactinterestId = rContactinterestId;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public RInterestarea getRInterestareaId() {
        return rInterestareaId;
    }

    public void setRInterestareaId(RInterestarea rInterestareaId) {
        this.rInterestareaId = rInterestareaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rContactinterestId != null ? rContactinterestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RContactinterest)) {
            return false;
        }
        RContactinterest other = (RContactinterest) object;
        if ((this.rContactinterestId == null && other.rContactinterestId != null) || (this.rContactinterestId != null && !this.rContactinterestId.equals(other.rContactinterestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RContactinterest[ rContactinterestId=" + rContactinterestId + " ]";
    }
    
}
