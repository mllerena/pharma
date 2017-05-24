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
@Table(name = "ma_measure_time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMeasureTime.findAll", query = "SELECT m FROM MaMeasureTime m"),
    @NamedQuery(name = "MaMeasureTime.findByMaMeasureTimeId", query = "SELECT m FROM MaMeasureTime m WHERE m.maMeasureTimeId = :maMeasureTimeId"),
    @NamedQuery(name = "MaMeasureTime.findByIsactive", query = "SELECT m FROM MaMeasureTime m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMeasureTime.findByCreated", query = "SELECT m FROM MaMeasureTime m WHERE m.created = :created"),
    @NamedQuery(name = "MaMeasureTime.findByCreatedby", query = "SELECT m FROM MaMeasureTime m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMeasureTime.findByUpdated", query = "SELECT m FROM MaMeasureTime m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMeasureTime.findByUpdatedby", query = "SELECT m FROM MaMeasureTime m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMeasureTime.findByMeasurehour", query = "SELECT m FROM MaMeasureTime m WHERE m.measurehour = :measurehour"),
    @NamedQuery(name = "MaMeasureTime.findByExplode", query = "SELECT m FROM MaMeasureTime m WHERE m.explode = :explode"),
    @NamedQuery(name = "MaMeasureTime.findByProcessed", query = "SELECT m FROM MaMeasureTime m WHERE m.processed = :processed")})
public class MaMeasureTime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_measure_time_id")
    private String maMeasureTimeId;
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
    @Column(name = "measurehour")
    @Temporal(TemporalType.TIMESTAMP)
    private Date measurehour;
    @Column(name = "explode")
    private Character explode;
    @Column(name = "processed")
    private Character processed;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMeasureTimeId")
    private List<MaMeasureValues> maMeasureValuesList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_measure_group_id", referencedColumnName = "ma_measure_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMeasureGroup maMeasureGroupId;

    public MaMeasureTime() {
    }

    public MaMeasureTime(String maMeasureTimeId) {
        this.maMeasureTimeId = maMeasureTimeId;
    }

    public MaMeasureTime(String maMeasureTimeId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date measurehour) {
        this.maMeasureTimeId = maMeasureTimeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.measurehour = measurehour;
    }

    public String getMaMeasureTimeId() {
        return maMeasureTimeId;
    }

    public void setMaMeasureTimeId(String maMeasureTimeId) {
        this.maMeasureTimeId = maMeasureTimeId;
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

    public Date getMeasurehour() {
        return measurehour;
    }

    public void setMeasurehour(Date measurehour) {
        this.measurehour = measurehour;
    }

    public Character getExplode() {
        return explode;
    }

    public void setExplode(Character explode) {
        this.explode = explode;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    @XmlTransient
    public List<MaMeasureValues> getMaMeasureValuesList() {
        return maMeasureValuesList;
    }

    public void setMaMeasureValuesList(List<MaMeasureValues> maMeasureValuesList) {
        this.maMeasureValuesList = maMeasureValuesList;
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

    public MaMeasureGroup getMaMeasureGroupId() {
        return maMeasureGroupId;
    }

    public void setMaMeasureGroupId(MaMeasureGroup maMeasureGroupId) {
        this.maMeasureGroupId = maMeasureGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMeasureTimeId != null ? maMeasureTimeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMeasureTime)) {
            return false;
        }
        MaMeasureTime other = (MaMeasureTime) object;
        if ((this.maMeasureTimeId == null && other.maMeasureTimeId != null) || (this.maMeasureTimeId != null && !this.maMeasureTimeId.equals(other.maMeasureTimeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMeasureTime[ maMeasureTimeId=" + maMeasureTimeId + " ]";
    }
    
}
