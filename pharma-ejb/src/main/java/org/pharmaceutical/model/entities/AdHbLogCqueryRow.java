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
@Table(name = "ad_hb_log_cquery_row")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdHbLogCqueryRow.findAll", query = "SELECT a FROM AdHbLogCqueryRow a"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByAdHbLogCqueryRowId", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.adHbLogCqueryRowId = :adHbLogCqueryRowId"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByIsactive", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByCreated", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.created = :created"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByCreatedby", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByUpdated", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByUpdatedby", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByRowno", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.rowno = :rowno"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByPropertyname", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.propertyname = :propertyname"),
    @NamedQuery(name = "AdHbLogCqueryRow.findByPropertyvalue", query = "SELECT a FROM AdHbLogCqueryRow a WHERE a.propertyvalue = :propertyvalue")})
public class AdHbLogCqueryRow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_hb_log_cquery_row_id")
    private String adHbLogCqueryRowId;
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
    @Column(name = "rowno")
    private BigInteger rowno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "propertyname")
    private String propertyname;
    @Size(max = 2000)
    @Column(name = "propertyvalue")
    private String propertyvalue;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_hb_log_cquery_id", referencedColumnName = "ad_hb_log_cquery_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdHbLogCquery adHbLogCqueryId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdHbLogCqueryRow() {
    }

    public AdHbLogCqueryRow(String adHbLogCqueryRowId) {
        this.adHbLogCqueryRowId = adHbLogCqueryRowId;
    }

    public AdHbLogCqueryRow(String adHbLogCqueryRowId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger rowno, String propertyname) {
        this.adHbLogCqueryRowId = adHbLogCqueryRowId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.rowno = rowno;
        this.propertyname = propertyname;
    }

    public String getAdHbLogCqueryRowId() {
        return adHbLogCqueryRowId;
    }

    public void setAdHbLogCqueryRowId(String adHbLogCqueryRowId) {
        this.adHbLogCqueryRowId = adHbLogCqueryRowId;
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

    public BigInteger getRowno() {
        return rowno;
    }

    public void setRowno(BigInteger rowno) {
        this.rowno = rowno;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public String getPropertyvalue() {
        return propertyvalue;
    }

    public void setPropertyvalue(String propertyvalue) {
        this.propertyvalue = propertyvalue;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdHbLogCquery getAdHbLogCqueryId() {
        return adHbLogCqueryId;
    }

    public void setAdHbLogCqueryId(AdHbLogCquery adHbLogCqueryId) {
        this.adHbLogCqueryId = adHbLogCqueryId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adHbLogCqueryRowId != null ? adHbLogCqueryRowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdHbLogCqueryRow)) {
            return false;
        }
        AdHbLogCqueryRow other = (AdHbLogCqueryRow) object;
        if ((this.adHbLogCqueryRowId == null && other.adHbLogCqueryRowId != null) || (this.adHbLogCqueryRowId != null && !this.adHbLogCqueryRowId.equals(other.adHbLogCqueryRowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdHbLogCqueryRow[ adHbLogCqueryRowId=" + adHbLogCqueryRowId + " ]";
    }
    
}
