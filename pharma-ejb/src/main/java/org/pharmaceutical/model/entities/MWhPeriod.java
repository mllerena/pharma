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
@Table(name = "m_wh_period")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MWhPeriod.findAll", query = "SELECT m FROM MWhPeriod m"),
    @NamedQuery(name = "MWhPeriod.findByMWhPeriodId", query = "SELECT m FROM MWhPeriod m WHERE m.mWhPeriodId = :mWhPeriodId"),
    @NamedQuery(name = "MWhPeriod.findByIsactive", query = "SELECT m FROM MWhPeriod m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MWhPeriod.findByCreated", query = "SELECT m FROM MWhPeriod m WHERE m.created = :created"),
    @NamedQuery(name = "MWhPeriod.findByCreatedby", query = "SELECT m FROM MWhPeriod m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MWhPeriod.findByUpdated", query = "SELECT m FROM MWhPeriod m WHERE m.updated = :updated"),
    @NamedQuery(name = "MWhPeriod.findByUpdatedby", query = "SELECT m FROM MWhPeriod m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MWhPeriod.findByStartdate", query = "SELECT m FROM MWhPeriod m WHERE m.startdate = :startdate"),
    @NamedQuery(name = "MWhPeriod.findByEnddate", query = "SELECT m FROM MWhPeriod m WHERE m.enddate = :enddate")})
public class MWhPeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_wh_period_id")
    private String mWhPeriodId;
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
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWhPeriodId")
    private List<MWhPeriodInvoiced> mWhPeriodInvoicedList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_wh_schedule_id", referencedColumnName = "m_wh_schedule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWhSchedule mWhScheduleId;

    public MWhPeriod() {
    }

    public MWhPeriod(String mWhPeriodId) {
        this.mWhPeriodId = mWhPeriodId;
    }

    public MWhPeriod(String mWhPeriodId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date startdate, Date enddate) {
        this.mWhPeriodId = mWhPeriodId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public String getMWhPeriodId() {
        return mWhPeriodId;
    }

    public void setMWhPeriodId(String mWhPeriodId) {
        this.mWhPeriodId = mWhPeriodId;
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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @XmlTransient
    public List<MWhPeriodInvoiced> getMWhPeriodInvoicedList() {
        return mWhPeriodInvoicedList;
    }

    public void setMWhPeriodInvoicedList(List<MWhPeriodInvoiced> mWhPeriodInvoicedList) {
        this.mWhPeriodInvoicedList = mWhPeriodInvoicedList;
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

    public MWhSchedule getMWhScheduleId() {
        return mWhScheduleId;
    }

    public void setMWhScheduleId(MWhSchedule mWhScheduleId) {
        this.mWhScheduleId = mWhScheduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mWhPeriodId != null ? mWhPeriodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MWhPeriod)) {
            return false;
        }
        MWhPeriod other = (MWhPeriod) object;
        if ((this.mWhPeriodId == null && other.mWhPeriodId != null) || (this.mWhPeriodId != null && !this.mWhPeriodId.equals(other.mWhPeriodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MWhPeriod[ mWhPeriodId=" + mWhPeriodId + " ]";
    }
    
}
