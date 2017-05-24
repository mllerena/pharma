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
@Table(name = "c_year")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CYear.findAll", query = "SELECT c FROM CYear c"),
    @NamedQuery(name = "CYear.findByCYearId", query = "SELECT c FROM CYear c WHERE c.cYearId = :cYearId"),
    @NamedQuery(name = "CYear.findByIsactive", query = "SELECT c FROM CYear c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CYear.findByCreated", query = "SELECT c FROM CYear c WHERE c.created = :created"),
    @NamedQuery(name = "CYear.findByCreatedby", query = "SELECT c FROM CYear c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CYear.findByUpdated", query = "SELECT c FROM CYear c WHERE c.updated = :updated"),
    @NamedQuery(name = "CYear.findByUpdatedby", query = "SELECT c FROM CYear c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CYear.findByYear", query = "SELECT c FROM CYear c WHERE c.year = :year"),
    @NamedQuery(name = "CYear.findByDescription", query = "SELECT c FROM CYear c WHERE c.description = :description"),
    @NamedQuery(name = "CYear.findByProcessing", query = "SELECT c FROM CYear c WHERE c.processing = :processing"),
    @NamedQuery(name = "CYear.findByCreateRegFactAcct", query = "SELECT c FROM CYear c WHERE c.createRegFactAcct = :createRegFactAcct"),
    @NamedQuery(name = "CYear.findByDropRegFactAcct", query = "SELECT c FROM CYear c WHERE c.dropRegFactAcct = :dropRegFactAcct")})
public class CYear implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_year_id")
    private String cYearId;
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
    @Size(min = 1, max = 10)
    @Column(name = "year")
    private String year;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "create_reg_fact_acct")
    private Character createRegFactAcct;
    @Column(name = "drop_reg_fact_acct")
    private Character dropRegFactAcct;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_calendar_id", referencedColumnName = "c_calendar_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCalendar cCalendarId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cYearId")
    private List<CPeriodcontrolLog> cPeriodcontrolLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cYearId")
    private List<CBudget> cBudgetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cYearId")
    private List<AdOrgClosing> adOrgClosingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cYearId")
    private List<CPeriod> cPeriodList;

    public CYear() {
    }

    public CYear(String cYearId) {
        this.cYearId = cYearId;
    }

    public CYear(String cYearId, Character isactive, Date created, String createdby, Date updated, String updatedby, String year) {
        this.cYearId = cYearId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.year = year;
    }

    public String getCYearId() {
        return cYearId;
    }

    public void setCYearId(String cYearId) {
        this.cYearId = cYearId;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getCreateRegFactAcct() {
        return createRegFactAcct;
    }

    public void setCreateRegFactAcct(Character createRegFactAcct) {
        this.createRegFactAcct = createRegFactAcct;
    }

    public Character getDropRegFactAcct() {
        return dropRegFactAcct;
    }

    public void setDropRegFactAcct(Character dropRegFactAcct) {
        this.dropRegFactAcct = dropRegFactAcct;
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

    @XmlTransient
    public List<CPeriodcontrolLog> getCPeriodcontrolLogList() {
        return cPeriodcontrolLogList;
    }

    public void setCPeriodcontrolLogList(List<CPeriodcontrolLog> cPeriodcontrolLogList) {
        this.cPeriodcontrolLogList = cPeriodcontrolLogList;
    }

    @XmlTransient
    public List<CBudget> getCBudgetList() {
        return cBudgetList;
    }

    public void setCBudgetList(List<CBudget> cBudgetList) {
        this.cBudgetList = cBudgetList;
    }

    @XmlTransient
    public List<AdOrgClosing> getAdOrgClosingList() {
        return adOrgClosingList;
    }

    public void setAdOrgClosingList(List<AdOrgClosing> adOrgClosingList) {
        this.adOrgClosingList = adOrgClosingList;
    }

    @XmlTransient
    public List<CPeriod> getCPeriodList() {
        return cPeriodList;
    }

    public void setCPeriodList(List<CPeriod> cPeriodList) {
        this.cPeriodList = cPeriodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cYearId != null ? cYearId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CYear)) {
            return false;
        }
        CYear other = (CYear) object;
        if ((this.cYearId == null && other.cYearId != null) || (this.cYearId != null && !this.cYearId.equals(other.cYearId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CYear[ cYearId=" + cYearId + " ]";
    }
    
}
