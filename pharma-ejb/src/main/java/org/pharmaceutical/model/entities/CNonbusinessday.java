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
@Table(name = "c_nonbusinessday")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CNonbusinessday.findAll", query = "SELECT c FROM CNonbusinessday c"),
    @NamedQuery(name = "CNonbusinessday.findByCNonbusinessdayId", query = "SELECT c FROM CNonbusinessday c WHERE c.cNonbusinessdayId = :cNonbusinessdayId"),
    @NamedQuery(name = "CNonbusinessday.findByIsactive", query = "SELECT c FROM CNonbusinessday c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CNonbusinessday.findByCreated", query = "SELECT c FROM CNonbusinessday c WHERE c.created = :created"),
    @NamedQuery(name = "CNonbusinessday.findByCreatedby", query = "SELECT c FROM CNonbusinessday c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CNonbusinessday.findByUpdated", query = "SELECT c FROM CNonbusinessday c WHERE c.updated = :updated"),
    @NamedQuery(name = "CNonbusinessday.findByUpdatedby", query = "SELECT c FROM CNonbusinessday c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CNonbusinessday.findByName", query = "SELECT c FROM CNonbusinessday c WHERE c.name = :name"),
    @NamedQuery(name = "CNonbusinessday.findByDate1", query = "SELECT c FROM CNonbusinessday c WHERE c.date1 = :date1")})
public class CNonbusinessday implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_nonbusinessday_id")
    private String cNonbusinessdayId;
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
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date1;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_calendar_id", referencedColumnName = "c_calendar_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCalendar cCalendarId;

    public CNonbusinessday() {
    }

    public CNonbusinessday(String cNonbusinessdayId) {
        this.cNonbusinessdayId = cNonbusinessdayId;
    }

    public CNonbusinessday(String cNonbusinessdayId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date date1) {
        this.cNonbusinessdayId = cNonbusinessdayId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.date1 = date1;
    }

    public String getCNonbusinessdayId() {
        return cNonbusinessdayId;
    }

    public void setCNonbusinessdayId(String cNonbusinessdayId) {
        this.cNonbusinessdayId = cNonbusinessdayId;
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

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
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

    public CCalendar getCCalendarId() {
        return cCalendarId;
    }

    public void setCCalendarId(CCalendar cCalendarId) {
        this.cCalendarId = cCalendarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cNonbusinessdayId != null ? cNonbusinessdayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CNonbusinessday)) {
            return false;
        }
        CNonbusinessday other = (CNonbusinessday) object;
        if ((this.cNonbusinessdayId == null && other.cNonbusinessdayId != null) || (this.cNonbusinessdayId != null && !this.cNonbusinessdayId.equals(other.cNonbusinessdayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CNonbusinessday[ cNonbusinessdayId=" + cNonbusinessdayId + " ]";
    }
    
}
