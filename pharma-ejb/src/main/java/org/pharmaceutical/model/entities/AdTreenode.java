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
@Table(name = "ad_treenode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTreenode.findAll", query = "SELECT a FROM AdTreenode a"),
    @NamedQuery(name = "AdTreenode.findByAdTreenodeId", query = "SELECT a FROM AdTreenode a WHERE a.adTreenodeId = :adTreenodeId"),
    @NamedQuery(name = "AdTreenode.findByNodeId", query = "SELECT a FROM AdTreenode a WHERE a.nodeId = :nodeId"),
    @NamedQuery(name = "AdTreenode.findByIsactive", query = "SELECT a FROM AdTreenode a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTreenode.findByCreated", query = "SELECT a FROM AdTreenode a WHERE a.created = :created"),
    @NamedQuery(name = "AdTreenode.findByCreatedby", query = "SELECT a FROM AdTreenode a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTreenode.findByUpdated", query = "SELECT a FROM AdTreenode a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTreenode.findByUpdatedby", query = "SELECT a FROM AdTreenode a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTreenode.findByParentId", query = "SELECT a FROM AdTreenode a WHERE a.parentId = :parentId"),
    @NamedQuery(name = "AdTreenode.findBySeqno", query = "SELECT a FROM AdTreenode a WHERE a.seqno = :seqno")})
public class AdTreenode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_treenode_id")
    private String adTreenodeId;
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

    public AdTreenode() {
    }

    public AdTreenode(String adTreenodeId) {
        this.adTreenodeId = adTreenodeId;
    }

    public AdTreenode(String adTreenodeId, String nodeId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adTreenodeId = adTreenodeId;
        this.nodeId = nodeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdTreenodeId() {
        return adTreenodeId;
    }

    public void setAdTreenodeId(String adTreenodeId) {
        this.adTreenodeId = adTreenodeId;
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
        hash += (adTreenodeId != null ? adTreenodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTreenode)) {
            return false;
        }
        AdTreenode other = (AdTreenode) object;
        if ((this.adTreenodeId == null && other.adTreenodeId != null) || (this.adTreenodeId != null && !this.adTreenodeId.equals(other.adTreenodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTreenode[ adTreenodeId=" + adTreenodeId + " ]";
    }
    
}
