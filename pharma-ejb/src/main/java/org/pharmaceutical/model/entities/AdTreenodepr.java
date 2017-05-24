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
@Table(name = "ad_treenodepr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTreenodepr.findAll", query = "SELECT a FROM AdTreenodepr a"),
    @NamedQuery(name = "AdTreenodepr.findByAdTreenodeprId", query = "SELECT a FROM AdTreenodepr a WHERE a.adTreenodeprId = :adTreenodeprId"),
    @NamedQuery(name = "AdTreenodepr.findByNodeId", query = "SELECT a FROM AdTreenodepr a WHERE a.nodeId = :nodeId"),
    @NamedQuery(name = "AdTreenodepr.findByIsactive", query = "SELECT a FROM AdTreenodepr a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTreenodepr.findByCreated", query = "SELECT a FROM AdTreenodepr a WHERE a.created = :created"),
    @NamedQuery(name = "AdTreenodepr.findByCreatedby", query = "SELECT a FROM AdTreenodepr a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTreenodepr.findByUpdated", query = "SELECT a FROM AdTreenodepr a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTreenodepr.findByUpdatedby", query = "SELECT a FROM AdTreenodepr a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTreenodepr.findByParentId", query = "SELECT a FROM AdTreenodepr a WHERE a.parentId = :parentId"),
    @NamedQuery(name = "AdTreenodepr.findBySeqno", query = "SELECT a FROM AdTreenodepr a WHERE a.seqno = :seqno")})
public class AdTreenodepr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_treenodepr_id")
    private String adTreenodeprId;
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
    @Size(max = 32)
    @Column(name = "parent_id")
    private String parentId;
    @Column(name = "seqno")
    private Long seqno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_tree_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTree adTreeId;

    public AdTreenodepr() {
    }

    public AdTreenodepr(String adTreenodeprId) {
        this.adTreenodeprId = adTreenodeprId;
    }

    public AdTreenodepr(String adTreenodeprId, String nodeId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adTreenodeprId = adTreenodeprId;
        this.nodeId = nodeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdTreenodeprId() {
        return adTreenodeprId;
    }

    public void setAdTreenodeprId(String adTreenodeprId) {
        this.adTreenodeprId = adTreenodeprId;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTreenodeprId != null ? adTreenodeprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTreenodepr)) {
            return false;
        }
        AdTreenodepr other = (AdTreenodepr) object;
        if ((this.adTreenodeprId == null && other.adTreenodeprId != null) || (this.adTreenodeprId != null && !this.adTreenodeprId.equals(other.adTreenodeprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTreenodepr[ adTreenodeprId=" + adTreenodeprId + " ]";
    }
    
}
