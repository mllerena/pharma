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
@Table(name = "ad_treebar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTreebar.findAll", query = "SELECT a FROM AdTreebar a"),
    @NamedQuery(name = "AdTreebar.findByAdTreebarId", query = "SELECT a FROM AdTreebar a WHERE a.adTreebarId = :adTreebarId"),
    @NamedQuery(name = "AdTreebar.findByNodeId", query = "SELECT a FROM AdTreebar a WHERE a.nodeId = :nodeId"),
    @NamedQuery(name = "AdTreebar.findByIsactive", query = "SELECT a FROM AdTreebar a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTreebar.findByCreated", query = "SELECT a FROM AdTreebar a WHERE a.created = :created"),
    @NamedQuery(name = "AdTreebar.findByCreatedby", query = "SELECT a FROM AdTreebar a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTreebar.findByUpdated", query = "SELECT a FROM AdTreebar a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTreebar.findByUpdatedby", query = "SELECT a FROM AdTreebar a WHERE a.updatedby = :updatedby")})
public class AdTreebar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_treebar_id")
    private String adTreebarId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "node_id")
    private String nodeId;
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
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_tree_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTree adTreeId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser adUserId;

    public AdTreebar() {
    }

    public AdTreebar(String adTreebarId) {
        this.adTreebarId = adTreebarId;
    }

    public AdTreebar(String adTreebarId, String nodeId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adTreebarId = adTreebarId;
        this.nodeId = nodeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdTreebarId() {
        return adTreebarId;
    }

    public void setAdTreebarId(String adTreebarId) {
        this.adTreebarId = adTreebarId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
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

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdTree getAdTreeId() {
        return adTreeId;
    }

    public void setAdTreeId(AdTree adTreeId) {
        this.adTreeId = adTreeId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTreebarId != null ? adTreebarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTreebar)) {
            return false;
        }
        AdTreebar other = (AdTreebar) object;
        if ((this.adTreebarId == null && other.adTreebarId != null) || (this.adTreebarId != null && !this.adTreebarId.equals(other.adTreebarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTreebar[ adTreebarId=" + adTreebarId + " ]";
    }
    
}
