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
@Table(name = "r_requestprocessor_route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RRequestprocessorRoute.findAll", query = "SELECT r FROM RRequestprocessorRoute r"),
    @NamedQuery(name = "RRequestprocessorRoute.findByRRequestprocessorRouteId", query = "SELECT r FROM RRequestprocessorRoute r WHERE r.rRequestprocessorRouteId = :rRequestprocessorRouteId"),
    @NamedQuery(name = "RRequestprocessorRoute.findByIsactive", query = "SELECT r FROM RRequestprocessorRoute r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RRequestprocessorRoute.findByCreated", query = "SELECT r FROM RRequestprocessorRoute r WHERE r.created = :created"),
    @NamedQuery(name = "RRequestprocessorRoute.findByCreatedby", query = "SELECT r FROM RRequestprocessorRoute r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RRequestprocessorRoute.findByUpdated", query = "SELECT r FROM RRequestprocessorRoute r WHERE r.updated = :updated"),
    @NamedQuery(name = "RRequestprocessorRoute.findByUpdatedby", query = "SELECT r FROM RRequestprocessorRoute r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RRequestprocessorRoute.findBySeqno", query = "SELECT r FROM RRequestprocessorRoute r WHERE r.seqno = :seqno"),
    @NamedQuery(name = "RRequestprocessorRoute.findByKeyword", query = "SELECT r FROM RRequestprocessorRoute r WHERE r.keyword = :keyword")})
public class RRequestprocessorRoute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_requestprocessor_route_id")
    private String rRequestprocessorRouteId;
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
    @Column(name = "seqno")
    private long seqno;
    @Size(max = 60)
    @Column(name = "keyword")
    private String keyword;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser adUserId;
    @JoinColumn(name = "r_requestprocessor_id", referencedColumnName = "r_requestprocessor_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private RRequestprocessor rRequestprocessorId;
    @JoinColumn(name = "r_requesttype_id", referencedColumnName = "r_requesttype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private RRequesttype rRequesttypeId;

    public RRequestprocessorRoute() {
    }

    public RRequestprocessorRoute(String rRequestprocessorRouteId) {
        this.rRequestprocessorRouteId = rRequestprocessorRouteId;
    }

    public RRequestprocessorRoute(String rRequestprocessorRouteId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno) {
        this.rRequestprocessorRouteId = rRequestprocessorRouteId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
    }

    public String getRRequestprocessorRouteId() {
        return rRequestprocessorRouteId;
    }

    public void setRRequestprocessorRouteId(String rRequestprocessorRouteId) {
        this.rRequestprocessorRouteId = rRequestprocessorRouteId;
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

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public RRequestprocessor getRRequestprocessorId() {
        return rRequestprocessorId;
    }

    public void setRRequestprocessorId(RRequestprocessor rRequestprocessorId) {
        this.rRequestprocessorId = rRequestprocessorId;
    }

    public RRequesttype getRRequesttypeId() {
        return rRequesttypeId;
    }

    public void setRRequesttypeId(RRequesttype rRequesttypeId) {
        this.rRequesttypeId = rRequesttypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rRequestprocessorRouteId != null ? rRequestprocessorRouteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RRequestprocessorRoute)) {
            return false;
        }
        RRequestprocessorRoute other = (RRequestprocessorRoute) object;
        if ((this.rRequestprocessorRouteId == null && other.rRequestprocessorRouteId != null) || (this.rRequestprocessorRouteId != null && !this.rRequestprocessorRouteId.equals(other.rRequestprocessorRouteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RRequestprocessorRoute[ rRequestprocessorRouteId=" + rRequestprocessorRouteId + " ]";
    }
    
}
