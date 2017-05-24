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
@Table(name = "m_wh_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MWhSchedule.findAll", query = "SELECT m FROM MWhSchedule m"),
    @NamedQuery(name = "MWhSchedule.findByMWhScheduleId", query = "SELECT m FROM MWhSchedule m WHERE m.mWhScheduleId = :mWhScheduleId"),
    @NamedQuery(name = "MWhSchedule.findByIsactive", query = "SELECT m FROM MWhSchedule m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MWhSchedule.findByCreated", query = "SELECT m FROM MWhSchedule m WHERE m.created = :created"),
    @NamedQuery(name = "MWhSchedule.findByCreatedby", query = "SELECT m FROM MWhSchedule m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MWhSchedule.findByUpdated", query = "SELECT m FROM MWhSchedule m WHERE m.updated = :updated"),
    @NamedQuery(name = "MWhSchedule.findByUpdatedby", query = "SELECT m FROM MWhSchedule m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MWhSchedule.findByName", query = "SELECT m FROM MWhSchedule m WHERE m.name = :name"),
    @NamedQuery(name = "MWhSchedule.findByPeriodicity", query = "SELECT m FROM MWhSchedule m WHERE m.periodicity = :periodicity"),
    @NamedQuery(name = "MWhSchedule.findByGenerateperiods", query = "SELECT m FROM MWhSchedule m WHERE m.generateperiods = :generateperiods"),
    @NamedQuery(name = "MWhSchedule.findByActivateperiods", query = "SELECT m FROM MWhSchedule m WHERE m.activateperiods = :activateperiods")})
public class MWhSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_wh_schedule_id")
    private String mWhScheduleId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "periodicity")
    private String periodicity;
    @Column(name = "generateperiods")
    private Character generateperiods;
    @Column(name = "activateperiods")
    private Character activateperiods;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWhScheduleId")
    private List<MWhScheduleProduct> mWhScheduleProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mWhScheduleId")
    private List<MWhPeriod> mWhPeriodList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public MWhSchedule() {
    }

    public MWhSchedule(String mWhScheduleId) {
        this.mWhScheduleId = mWhScheduleId;
    }

    public MWhSchedule(String mWhScheduleId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String periodicity) {
        this.mWhScheduleId = mWhScheduleId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.periodicity = periodicity;
    }

    public String getMWhScheduleId() {
        return mWhScheduleId;
    }

    public void setMWhScheduleId(String mWhScheduleId) {
        this.mWhScheduleId = mWhScheduleId;
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

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Character getGenerateperiods() {
        return generateperiods;
    }

    public void setGenerateperiods(Character generateperiods) {
        this.generateperiods = generateperiods;
    }

    public Character getActivateperiods() {
        return activateperiods;
    }

    public void setActivateperiods(Character activateperiods) {
        this.activateperiods = activateperiods;
    }

    @XmlTransient
    public List<MWhScheduleProduct> getMWhScheduleProductList() {
        return mWhScheduleProductList;
    }

    public void setMWhScheduleProductList(List<MWhScheduleProduct> mWhScheduleProductList) {
        this.mWhScheduleProductList = mWhScheduleProductList;
    }

    @XmlTransient
    public List<MWhPeriod> getMWhPeriodList() {
        return mWhPeriodList;
    }

    public void setMWhPeriodList(List<MWhPeriod> mWhPeriodList) {
        this.mWhPeriodList = mWhPeriodList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mWhScheduleId != null ? mWhScheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MWhSchedule)) {
            return false;
        }
        MWhSchedule other = (MWhSchedule) object;
        if ((this.mWhScheduleId == null && other.mWhScheduleId != null) || (this.mWhScheduleId != null && !this.mWhScheduleId.equals(other.mWhScheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MWhSchedule[ mWhScheduleId=" + mWhScheduleId + " ]";
    }
    
}
