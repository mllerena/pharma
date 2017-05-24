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
import javax.persistence.OneToOne;
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
@Table(name = "ad_ref_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdRefTable.findAll", query = "SELECT a FROM AdRefTable a"),
    @NamedQuery(name = "AdRefTable.findByAdReferenceId", query = "SELECT a FROM AdRefTable a WHERE a.adReferenceId = :adReferenceId"),
    @NamedQuery(name = "AdRefTable.findByIsactive", query = "SELECT a FROM AdRefTable a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdRefTable.findByCreated", query = "SELECT a FROM AdRefTable a WHERE a.created = :created"),
    @NamedQuery(name = "AdRefTable.findByCreatedby", query = "SELECT a FROM AdRefTable a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdRefTable.findByUpdated", query = "SELECT a FROM AdRefTable a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdRefTable.findByUpdatedby", query = "SELECT a FROM AdRefTable a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdRefTable.findByIsvaluedisplayed", query = "SELECT a FROM AdRefTable a WHERE a.isvaluedisplayed = :isvaluedisplayed"),
    @NamedQuery(name = "AdRefTable.findByWhereclause", query = "SELECT a FROM AdRefTable a WHERE a.whereclause = :whereclause"),
    @NamedQuery(name = "AdRefTable.findByOrderbyclause", query = "SELECT a FROM AdRefTable a WHERE a.orderbyclause = :orderbyclause"),
    @NamedQuery(name = "AdRefTable.findByHqlwhereclause", query = "SELECT a FROM AdRefTable a WHERE a.hqlwhereclause = :hqlwhereclause"),
    @NamedQuery(name = "AdRefTable.findByHqlorderbyclause", query = "SELECT a FROM AdRefTable a WHERE a.hqlorderbyclause = :hqlorderbyclause")})
public class AdRefTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_reference_id")
    private String adReferenceId;
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
    @Column(name = "isvaluedisplayed")
    private Character isvaluedisplayed;
    @Size(max = 2000)
    @Column(name = "whereclause")
    private String whereclause;
    @Size(max = 2000)
    @Column(name = "orderbyclause")
    private String orderbyclause;
    @Size(max = 2000)
    @Column(name = "hqlwhereclause")
    private String hqlwhereclause;
    @Size(max = 2000)
    @Column(name = "hqlorderbyclause")
    private String hqlorderbyclause;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_key", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdColumn adKey;
    @JoinColumn(name = "ad_display", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdColumn adDisplay;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_reference_id", referencedColumnName = "ad_reference_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AdReference adReference;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;

    public AdRefTable() {
    }

    public AdRefTable(String adReferenceId) {
        this.adReferenceId = adReferenceId;
    }

    public AdRefTable(String adReferenceId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isvaluedisplayed) {
        this.adReferenceId = adReferenceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isvaluedisplayed = isvaluedisplayed;
    }

    public String getAdReferenceId() {
        return adReferenceId;
    }

    public void setAdReferenceId(String adReferenceId) {
        this.adReferenceId = adReferenceId;
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

    public Character getIsvaluedisplayed() {
        return isvaluedisplayed;
    }

    public void setIsvaluedisplayed(Character isvaluedisplayed) {
        this.isvaluedisplayed = isvaluedisplayed;
    }

    public String getWhereclause() {
        return whereclause;
    }

    public void setWhereclause(String whereclause) {
        this.whereclause = whereclause;
    }

    public String getOrderbyclause() {
        return orderbyclause;
    }

    public void setOrderbyclause(String orderbyclause) {
        this.orderbyclause = orderbyclause;
    }

    public String getHqlwhereclause() {
        return hqlwhereclause;
    }

    public void setHqlwhereclause(String hqlwhereclause) {
        this.hqlwhereclause = hqlwhereclause;
    }

    public String getHqlorderbyclause() {
        return hqlorderbyclause;
    }

    public void setHqlorderbyclause(String hqlorderbyclause) {
        this.hqlorderbyclause = hqlorderbyclause;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdColumn getAdKey() {
        return adKey;
    }

    public void setAdKey(AdColumn adKey) {
        this.adKey = adKey;
    }

    public AdColumn getAdDisplay() {
        return adDisplay;
    }

    public void setAdDisplay(AdColumn adDisplay) {
        this.adDisplay = adDisplay;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdReference getAdReference() {
        return adReference;
    }

    public void setAdReference(AdReference adReference) {
        this.adReference = adReference;
    }

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adReferenceId != null ? adReferenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdRefTable)) {
            return false;
        }
        AdRefTable other = (AdRefTable) object;
        if ((this.adReferenceId == null && other.adReferenceId != null) || (this.adReferenceId != null && !this.adReferenceId.equals(other.adReferenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdRefTable[ adReferenceId=" + adReferenceId + " ]";
    }
    
}
