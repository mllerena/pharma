/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "c_calendar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCalendar.findAll", query = "SELECT c FROM CCalendar c"),
    @NamedQuery(name = "CCalendar.findByCCalendarId", query = "SELECT c FROM CCalendar c WHERE c.cCalendarId = :cCalendarId"),
    @NamedQuery(name = "CCalendar.findByIsactive", query = "SELECT c FROM CCalendar c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCalendar.findByCreated", query = "SELECT c FROM CCalendar c WHERE c.created = :created"),
    @NamedQuery(name = "CCalendar.findByCreatedby", query = "SELECT c FROM CCalendar c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCalendar.findByUpdated", query = "SELECT c FROM CCalendar c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCalendar.findByUpdatedby", query = "SELECT c FROM CCalendar c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCalendar.findByName", query = "SELECT c FROM CCalendar c WHERE c.name = :name"),
    @NamedQuery(name = "CCalendar.findByDescription", query = "SELECT c FROM CCalendar c WHERE c.description = :description")})
public class CCalendar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_calendar_id")
    private String cCalendarId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCalendarId")
    private List<CYear> cYearList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCalendarId")
    private List<CNonbusinessday> cNonbusinessdayList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCalendarId")
    private List<CPeriodcontrolLog> cPeriodcontrolLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCalendarId")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCalendarId")
    private List<AdOrg> adOrgList;

    public CCalendar() {
    }

    public CCalendar(String cCalendarId) {
        this.cCalendarId = cCalendarId;
    }

    public CCalendar(String cCalendarId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cCalendarId = cCalendarId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCCalendarId() {
        return cCalendarId;
    }

    public void setCCalendarId(String cCalendarId) {
        this.cCalendarId = cCalendarId;
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

    @XmlTransient
    public List<CYear> getCYearList() {
        return cYearList;
    }

    public void setCYearList(List<CYear> cYearList) {
        this.cYearList = cYearList;
    }

    @XmlTransient
    public List<CNonbusinessday> getCNonbusinessdayList() {
        return cNonbusinessdayList;
    }

    public void setCNonbusinessdayList(List<CNonbusinessday> cNonbusinessdayList) {
        this.cNonbusinessdayList = cNonbusinessdayList;
    }

    @XmlTransient
    public List<CPeriodcontrolLog> getCPeriodcontrolLogList() {
        return cPeriodcontrolLogList;
    }

    public void setCPeriodcontrolLogList(List<CPeriodcontrolLog> cPeriodcontrolLogList) {
        this.cPeriodcontrolLogList = cPeriodcontrolLogList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList() {
        return adClientinfoList;
    }

    public void setAdClientinfoList(List<AdClientinfo> adClientinfoList) {
        this.adClientinfoList = adClientinfoList;
    }

    @XmlTransient
    public List<AdOrg> getAdOrgList() {
        return adOrgList;
    }

    public void setAdOrgList(List<AdOrg> adOrgList) {
        this.adOrgList = adOrgList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCalendarId != null ? cCalendarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCalendar)) {
            return false;
        }
        CCalendar other = (CCalendar) object;
        if ((this.cCalendarId == null && other.cCalendarId != null) || (this.cCalendarId != null && !this.cCalendarId.equals(other.cCalendarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCalendar[ cCalendarId=" + cCalendarId + " ]";
    }
    
}
