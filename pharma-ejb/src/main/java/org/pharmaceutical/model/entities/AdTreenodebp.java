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
@Table(name = "ad_treenodebp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTreenodebp.findAll", query = "SELECT a FROM AdTreenodebp a"),
    @NamedQuery(name = "AdTreenodebp.findByAdTreenodebpId", query = "SELECT a FROM AdTreenodebp a WHERE a.adTreenodebpId = :adTreenodebpId"),
    @NamedQuery(name = "AdTreenodebp.findByNodeId", query = "SELECT a FROM AdTreenodebp a WHERE a.nodeId = :nodeId"),
    @NamedQuery(name = "AdTreenodebp.findByIsactive", query = "SELECT a FROM AdTreenodebp a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTreenodebp.findByCreated", query = "SELECT a FROM AdTreenodebp a WHERE a.created = :created"),
    @NamedQuery(name = "AdTreenodebp.findByCreatedby", query = "SELECT a FROM AdTreenodebp a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTreenodebp.findByUpdated", query = "SELECT a FROM AdTreenodebp a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTreenodebp.findByUpdatedby", query = "SELECT a FROM AdTreenodebp a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTreenodebp.findByParentId", query = "SELECT a FROM AdTreenodebp a WHERE a.parentId = :parentId"),
    @NamedQuery(name = "AdTreenodebp.findBySeqno", query = "SELECT a FROM AdTreenodebp a WHERE a.seqno = :seqno")})
public class AdTreenodebp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_treenodebp_id")
    private String adTreenodebpId;
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

    public AdTreenodebp() {
    }

    public AdTreenodebp(String adTreenodebpId) {
        this.adTreenodebpId = adTreenodebpId;
    }

    public AdTreenodebp(String adTreenodebpId, String nodeId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adTreenodebpId = adTreenodebpId;
        this.nodeId = nodeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdTreenodebpId() {
        return adTreenodebpId;
    }

    public void setAdTreenodebpId(String adTreenodebpId) {
        this.adTreenodebpId = adTreenodebpId;
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
        hash += (adTreenodebpId != null ? adTreenodebpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTreenodebp)) {
            return false;
        }
        AdTreenodebp other = (AdTreenodebp) object;
        if ((this.adTreenodebpId == null && other.adTreenodebpId != null) || (this.adTreenodebpId != null && !this.adTreenodebpId.equals(other.adTreenodebpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTreenodebp[ adTreenodebpId=" + adTreenodebpId + " ]";
    }
    
}
