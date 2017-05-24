/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ma_measure_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMeasureGroup.findAll", query = "SELECT m FROM MaMeasureGroup m"),
    @NamedQuery(name = "MaMeasureGroup.findByMaMeasureGroupId", query = "SELECT m FROM MaMeasureGroup m WHERE m.maMeasureGroupId = :maMeasureGroupId"),
    @NamedQuery(name = "MaMeasureGroup.findByIsactive", query = "SELECT m FROM MaMeasureGroup m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMeasureGroup.findByCreated", query = "SELECT m FROM MaMeasureGroup m WHERE m.created = :created"),
    @NamedQuery(name = "MaMeasureGroup.findByCreatedby", query = "SELECT m FROM MaMeasureGroup m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMeasureGroup.findByUpdated", query = "SELECT m FROM MaMeasureGroup m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMeasureGroup.findByUpdatedby", query = "SELECT m FROM MaMeasureGroup m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMeasureGroup.findBySeqno", query = "SELECT m FROM MaMeasureGroup m WHERE m.seqno = :seqno")})
public class MaMeasureGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_measure_group_id")
    private String maMeasureGroupId;
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
    @Column(name = "seqno")
    private BigInteger seqno;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMeasureGroupId")
    private List<MaMeasureTime> maMeasureTimeList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_ccp_group_id", referencedColumnName = "ma_ccp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaCcpGroup maCcpGroupId;
    @JoinColumn(name = "ma_measure_shift_id", referencedColumnName = "ma_measure_shift_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaMeasureShift maMeasureShiftId;

    public MaMeasureGroup() {
    }

    public MaMeasureGroup(String maMeasureGroupId) {
        this.maMeasureGroupId = maMeasureGroupId;
    }

    public MaMeasureGroup(String maMeasureGroupId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.maMeasureGroupId = maMeasureGroupId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMaMeasureGroupId() {
        return maMeasureGroupId;
    }

    public void setMaMeasureGroupId(String maMeasureGroupId) {
        this.maMeasureGroupId = maMeasureGroupId;
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

    public BigInteger getSeqno() {
        return seqno;
    }

    public void setSeqno(BigInteger seqno) {
        this.seqno = seqno;
    }

    @XmlTransient
    public List<MaMeasureTime> getMaMeasureTimeList() {
        return maMeasureTimeList;
    }

    public void setMaMeasureTimeList(List<MaMeasureTime> maMeasureTimeList) {
        this.maMeasureTimeList = maMeasureTimeList;
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

    public MaCcpGroup getMaCcpGroupId() {
        return maCcpGroupId;
    }

    public void setMaCcpGroupId(MaCcpGroup maCcpGroupId) {
        this.maCcpGroupId = maCcpGroupId;
    }

    public MaMeasureShift getMaMeasureShiftId() {
        return maMeasureShiftId;
    }

    public void setMaMeasureShiftId(MaMeasureShift maMeasureShiftId) {
        this.maMeasureShiftId = maMeasureShiftId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMeasureGroupId != null ? maMeasureGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMeasureGroup)) {
            return false;
        }
        MaMeasureGroup other = (MaMeasureGroup) object;
        if ((this.maMeasureGroupId == null && other.maMeasureGroupId != null) || (this.maMeasureGroupId != null && !this.maMeasureGroupId.equals(other.maMeasureGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMeasureGroup[ maMeasureGroupId=" + maMeasureGroupId + " ]";
    }
    
}
