/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "c_acct_rpt_node")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctRptNode.findAll", query = "SELECT c FROM CAcctRptNode c"),
    @NamedQuery(name = "CAcctRptNode.findByCAcctRptNodeId", query = "SELECT c FROM CAcctRptNode c WHERE c.cAcctRptNodeId = :cAcctRptNodeId"),
    @NamedQuery(name = "CAcctRptNode.findByIsactive", query = "SELECT c FROM CAcctRptNode c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctRptNode.findByCreated", query = "SELECT c FROM CAcctRptNode c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctRptNode.findByCreatedby", query = "SELECT c FROM CAcctRptNode c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctRptNode.findByUpdated", query = "SELECT c FROM CAcctRptNode c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctRptNode.findByUpdatedby", query = "SELECT c FROM CAcctRptNode c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctRptNode.findByName", query = "SELECT c FROM CAcctRptNode c WHERE c.name = :name"),
    @NamedQuery(name = "CAcctRptNode.findByDescription", query = "SELECT c FROM CAcctRptNode c WHERE c.description = :description"),
    @NamedQuery(name = "CAcctRptNode.findByLine", query = "SELECT c FROM CAcctRptNode c WHERE c.line = :line")})
public class CAcctRptNode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acct_rpt_node_id")
    private String cAcctRptNodeId;
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
    @Column(name = "line")
    private BigInteger line;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acct_rpt_group_id", referencedColumnName = "c_acct_rpt_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctRptGroup cAcctRptGroupId;
    @JoinColumn(name = "c_elementvalue_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CElementvalue cElementvalueId;

    public CAcctRptNode() {
    }

    public CAcctRptNode(String cAcctRptNodeId) {
        this.cAcctRptNodeId = cAcctRptNodeId;
    }

    public CAcctRptNode(String cAcctRptNodeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cAcctRptNodeId = cAcctRptNodeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCAcctRptNodeId() {
        return cAcctRptNodeId;
    }

    public void setCAcctRptNodeId(String cAcctRptNodeId) {
        this.cAcctRptNodeId = cAcctRptNodeId;
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

    public BigInteger getLine() {
        return line;
    }

    public void setLine(BigInteger line) {
        this.line = line;
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

    public CAcctRptGroup getCAcctRptGroupId() {
        return cAcctRptGroupId;
    }

    public void setCAcctRptGroupId(CAcctRptGroup cAcctRptGroupId) {
        this.cAcctRptGroupId = cAcctRptGroupId;
    }

    public CElementvalue getCElementvalueId() {
        return cElementvalueId;
    }

    public void setCElementvalueId(CElementvalue cElementvalueId) {
        this.cElementvalueId = cElementvalueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctRptNodeId != null ? cAcctRptNodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctRptNode)) {
            return false;
        }
        CAcctRptNode other = (CAcctRptNode) object;
        if ((this.cAcctRptNodeId == null && other.cAcctRptNodeId != null) || (this.cAcctRptNodeId != null && !this.cAcctRptNodeId.equals(other.cAcctRptNodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctRptNode[ cAcctRptNodeId=" + cAcctRptNodeId + " ]";
    }
    
}
