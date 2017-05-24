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
@Table(name = "m_attributeset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAttributeset.findAll", query = "SELECT m FROM MAttributeset m"),
    @NamedQuery(name = "MAttributeset.findByMAttributesetId", query = "SELECT m FROM MAttributeset m WHERE m.mAttributesetId = :mAttributesetId"),
    @NamedQuery(name = "MAttributeset.findByIsactive", query = "SELECT m FROM MAttributeset m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MAttributeset.findByCreated", query = "SELECT m FROM MAttributeset m WHERE m.created = :created"),
    @NamedQuery(name = "MAttributeset.findByCreatedby", query = "SELECT m FROM MAttributeset m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MAttributeset.findByUpdated", query = "SELECT m FROM MAttributeset m WHERE m.updated = :updated"),
    @NamedQuery(name = "MAttributeset.findByUpdatedby", query = "SELECT m FROM MAttributeset m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MAttributeset.findByName", query = "SELECT m FROM MAttributeset m WHERE m.name = :name"),
    @NamedQuery(name = "MAttributeset.findByDescription", query = "SELECT m FROM MAttributeset m WHERE m.description = :description"),
    @NamedQuery(name = "MAttributeset.findByIsserno", query = "SELECT m FROM MAttributeset m WHERE m.isserno = :isserno"),
    @NamedQuery(name = "MAttributeset.findByIslot", query = "SELECT m FROM MAttributeset m WHERE m.islot = :islot"),
    @NamedQuery(name = "MAttributeset.findByIsguaranteedate", query = "SELECT m FROM MAttributeset m WHERE m.isguaranteedate = :isguaranteedate"),
    @NamedQuery(name = "MAttributeset.findByGuaranteedays", query = "SELECT m FROM MAttributeset m WHERE m.guaranteedays = :guaranteedays"),
    @NamedQuery(name = "MAttributeset.findByIslockable", query = "SELECT m FROM MAttributeset m WHERE m.islockable = :islockable"),
    @NamedQuery(name = "MAttributeset.findByIsoneattrsetvalrequired", query = "SELECT m FROM MAttributeset m WHERE m.isoneattrsetvalrequired = :isoneattrsetvalrequired"),
    @NamedQuery(name = "MAttributeset.findByIsreceptiondateshown", query = "SELECT m FROM MAttributeset m WHERE m.isreceptiondateshown = :isreceptiondateshown")})
public class MAttributeset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_attributeset_id")
    private String mAttributesetId;
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
    @Column(name = "isserno")
    private Character isserno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "islot")
    private Character islot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isguaranteedate")
    private Character isguaranteedate;
    @Column(name = "guaranteedays")
    private Long guaranteedays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "islockable")
    private Character islockable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isoneattrsetvalrequired")
    private Character isoneattrsetvalrequired;
    @Column(name = "isreceptiondateshown")
    private Character isreceptiondateshown;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mAttributesetId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mAttributesetId")
    private List<MAttributeuse> mAttributeuseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mAttributesetId")
    private List<MAttributesetinstance> mAttributesetinstanceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_lotctl_id", referencedColumnName = "m_lotctl_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLotctl mLotctlId;
    @JoinColumn(name = "m_sernoctl_id", referencedColumnName = "m_sernoctl_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MSernoctl mSernoctlId;

    public MAttributeset() {
    }

    public MAttributeset(String mAttributesetId) {
        this.mAttributesetId = mAttributesetId;
    }

    public MAttributeset(String mAttributesetId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isserno, Character islot, Character isguaranteedate, Character islockable, Character isoneattrsetvalrequired) {
        this.mAttributesetId = mAttributesetId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isserno = isserno;
        this.islot = islot;
        this.isguaranteedate = isguaranteedate;
        this.islockable = islockable;
        this.isoneattrsetvalrequired = isoneattrsetvalrequired;
    }

    public String getMAttributesetId() {
        return mAttributesetId;
    }

    public void setMAttributesetId(String mAttributesetId) {
        this.mAttributesetId = mAttributesetId;
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

    public Character getIsserno() {
        return isserno;
    }

    public void setIsserno(Character isserno) {
        this.isserno = isserno;
    }

    public Character getIslot() {
        return islot;
    }

    public void setIslot(Character islot) {
        this.islot = islot;
    }

    public Character getIsguaranteedate() {
        return isguaranteedate;
    }

    public void setIsguaranteedate(Character isguaranteedate) {
        this.isguaranteedate = isguaranteedate;
    }

    public Long getGuaranteedays() {
        return guaranteedays;
    }

    public void setGuaranteedays(Long guaranteedays) {
        this.guaranteedays = guaranteedays;
    }

    public Character getIslockable() {
        return islockable;
    }

    public void setIslockable(Character islockable) {
        this.islockable = islockable;
    }

    public Character getIsoneattrsetvalrequired() {
        return isoneattrsetvalrequired;
    }

    public void setIsoneattrsetvalrequired(Character isoneattrsetvalrequired) {
        this.isoneattrsetvalrequired = isoneattrsetvalrequired;
    }

    public Character getIsreceptiondateshown() {
        return isreceptiondateshown;
    }

    public void setIsreceptiondateshown(Character isreceptiondateshown) {
        this.isreceptiondateshown = isreceptiondateshown;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<MAttributeuse> getMAttributeuseList() {
        return mAttributeuseList;
    }

    public void setMAttributeuseList(List<MAttributeuse> mAttributeuseList) {
        this.mAttributeuseList = mAttributeuseList;
    }

    @XmlTransient
    public List<MAttributesetinstance> getMAttributesetinstanceList() {
        return mAttributesetinstanceList;
    }

    public void setMAttributesetinstanceList(List<MAttributesetinstance> mAttributesetinstanceList) {
        this.mAttributesetinstanceList = mAttributesetinstanceList;
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

    public MLotctl getMLotctlId() {
        return mLotctlId;
    }

    public void setMLotctlId(MLotctl mLotctlId) {
        this.mLotctlId = mLotctlId;
    }

    public MSernoctl getMSernoctlId() {
        return mSernoctlId;
    }

    public void setMSernoctlId(MSernoctl mSernoctlId) {
        this.mSernoctlId = mSernoctlId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mAttributesetId != null ? mAttributesetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MAttributeset)) {
            return false;
        }
        MAttributeset other = (MAttributeset) object;
        if ((this.mAttributesetId == null && other.mAttributesetId != null) || (this.mAttributesetId != null && !this.mAttributesetId.equals(other.mAttributesetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MAttributeset[ mAttributesetId=" + mAttributesetId + " ]";
    }
    
}
