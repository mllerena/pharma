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
@Table(name = "ad_wf_nodenext")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdWfNodenext.findAll", query = "SELECT a FROM AdWfNodenext a"),
    @NamedQuery(name = "AdWfNodenext.findByAdWfNodenextId", query = "SELECT a FROM AdWfNodenext a WHERE a.adWfNodenextId = :adWfNodenextId"),
    @NamedQuery(name = "AdWfNodenext.findByIsactive", query = "SELECT a FROM AdWfNodenext a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdWfNodenext.findByCreated", query = "SELECT a FROM AdWfNodenext a WHERE a.created = :created"),
    @NamedQuery(name = "AdWfNodenext.findByCreatedby", query = "SELECT a FROM AdWfNodenext a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdWfNodenext.findByUpdated", query = "SELECT a FROM AdWfNodenext a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdWfNodenext.findByUpdatedby", query = "SELECT a FROM AdWfNodenext a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdWfNodenext.findByCondition", query = "SELECT a FROM AdWfNodenext a WHERE a.condition = :condition")})
public class AdWfNodenext implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_wf_nodenext_id")
    private String adWfNodenextId;
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
    @Size(max = 2000)
    @Column(name = "condition")
    private String condition;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_wf_node_id", referencedColumnName = "ad_wf_node_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdWfNode adWfNodeId;
    @JoinColumn(name = "ad_wf_next_id", referencedColumnName = "ad_wf_node_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdWfNode adWfNextId;

    public AdWfNodenext() {
    }

    public AdWfNodenext(String adWfNodenextId) {
        this.adWfNodenextId = adWfNodenextId;
    }

    public AdWfNodenext(String adWfNodenextId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adWfNodenextId = adWfNodenextId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdWfNodenextId() {
        return adWfNodenextId;
    }

    public void setAdWfNodenextId(String adWfNodenextId) {
        this.adWfNodenextId = adWfNodenextId;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public AdWfNode getAdWfNodeId() {
        return adWfNodeId;
    }

    public void setAdWfNodeId(AdWfNode adWfNodeId) {
        this.adWfNodeId = adWfNodeId;
    }

    public AdWfNode getAdWfNextId() {
        return adWfNextId;
    }

    public void setAdWfNextId(AdWfNode adWfNextId) {
        this.adWfNextId = adWfNextId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adWfNodenextId != null ? adWfNodenextId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdWfNodenext)) {
            return false;
        }
        AdWfNodenext other = (AdWfNodenext) object;
        if ((this.adWfNodenextId == null && other.adWfNodenextId != null) || (this.adWfNodenextId != null && !this.adWfNodenextId.equals(other.adWfNodenextId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdWfNodenext[ adWfNodenextId=" + adWfNodenextId + " ]";
    }
    
}
