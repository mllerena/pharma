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
@Table(name = "ma_ccp_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaCcpGroup.findAll", query = "SELECT m FROM MaCcpGroup m"),
    @NamedQuery(name = "MaCcpGroup.findByMaCcpGroupId", query = "SELECT m FROM MaCcpGroup m WHERE m.maCcpGroupId = :maCcpGroupId"),
    @NamedQuery(name = "MaCcpGroup.findByIsactive", query = "SELECT m FROM MaCcpGroup m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaCcpGroup.findByCreated", query = "SELECT m FROM MaCcpGroup m WHERE m.created = :created"),
    @NamedQuery(name = "MaCcpGroup.findByCreatedby", query = "SELECT m FROM MaCcpGroup m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaCcpGroup.findByUpdated", query = "SELECT m FROM MaCcpGroup m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaCcpGroup.findByUpdatedby", query = "SELECT m FROM MaCcpGroup m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaCcpGroup.findByName", query = "SELECT m FROM MaCcpGroup m WHERE m.name = :name"),
    @NamedQuery(name = "MaCcpGroup.findByDescription", query = "SELECT m FROM MaCcpGroup m WHERE m.description = :description"),
    @NamedQuery(name = "MaCcpGroup.findByFrecuency", query = "SELECT m FROM MaCcpGroup m WHERE m.frecuency = :frecuency"),
    @NamedQuery(name = "MaCcpGroup.findBySeqno", query = "SELECT m FROM MaCcpGroup m WHERE m.seqno = :seqno")})
public class MaCcpGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_ccp_group_id")
    private String maCcpGroupId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "frecuency")
    @Temporal(TemporalType.TIMESTAMP)
    private Date frecuency;
    @Column(name = "seqno")
    private Long seqno;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maCcpGroupId")
    private List<MaCcp> maCcpList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maCcpGroupId")
    private List<MaCcpShift> maCcpShiftList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maCcpGroupId")
    private List<MaMeasureGroup> maMeasureGroupList;

    public MaCcpGroup() {
    }

    public MaCcpGroup(String maCcpGroupId) {
        this.maCcpGroupId = maCcpGroupId;
    }

    public MaCcpGroup(String maCcpGroupId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date frecuency) {
        this.maCcpGroupId = maCcpGroupId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.frecuency = frecuency;
    }

    public String getMaCcpGroupId() {
        return maCcpGroupId;
    }

    public void setMaCcpGroupId(String maCcpGroupId) {
        this.maCcpGroupId = maCcpGroupId;
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

    public Date getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(Date frecuency) {
        this.frecuency = frecuency;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    @XmlTransient
    public List<MaCcp> getMaCcpList() {
        return maCcpList;
    }

    public void setMaCcpList(List<MaCcp> maCcpList) {
        this.maCcpList = maCcpList;
    }

    @XmlTransient
    public List<MaCcpShift> getMaCcpShiftList() {
        return maCcpShiftList;
    }

    public void setMaCcpShiftList(List<MaCcpShift> maCcpShiftList) {
        this.maCcpShiftList = maCcpShiftList;
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
    public List<MaMeasureGroup> getMaMeasureGroupList() {
        return maMeasureGroupList;
    }

    public void setMaMeasureGroupList(List<MaMeasureGroup> maMeasureGroupList) {
        this.maMeasureGroupList = maMeasureGroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCcpGroupId != null ? maCcpGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaCcpGroup)) {
            return false;
        }
        MaCcpGroup other = (MaCcpGroup) object;
        if ((this.maCcpGroupId == null && other.maCcpGroupId != null) || (this.maCcpGroupId != null && !this.maCcpGroupId.equals(other.maCcpGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaCcpGroup[ maCcpGroupId=" + maCcpGroupId + " ]";
    }
    
}
