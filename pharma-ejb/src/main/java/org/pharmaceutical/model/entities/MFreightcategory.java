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
@Table(name = "m_freightcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MFreightcategory.findAll", query = "SELECT m FROM MFreightcategory m"),
    @NamedQuery(name = "MFreightcategory.findByMFreightcategoryId", query = "SELECT m FROM MFreightcategory m WHERE m.mFreightcategoryId = :mFreightcategoryId"),
    @NamedQuery(name = "MFreightcategory.findByIsactive", query = "SELECT m FROM MFreightcategory m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MFreightcategory.findByCreated", query = "SELECT m FROM MFreightcategory m WHERE m.created = :created"),
    @NamedQuery(name = "MFreightcategory.findByCreatedby", query = "SELECT m FROM MFreightcategory m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MFreightcategory.findByUpdated", query = "SELECT m FROM MFreightcategory m WHERE m.updated = :updated"),
    @NamedQuery(name = "MFreightcategory.findByUpdatedby", query = "SELECT m FROM MFreightcategory m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MFreightcategory.findByValue", query = "SELECT m FROM MFreightcategory m WHERE m.value = :value"),
    @NamedQuery(name = "MFreightcategory.findByName", query = "SELECT m FROM MFreightcategory m WHERE m.name = :name"),
    @NamedQuery(name = "MFreightcategory.findByDescription", query = "SELECT m FROM MFreightcategory m WHERE m.description = :description"),
    @NamedQuery(name = "MFreightcategory.findByHelp", query = "SELECT m FROM MFreightcategory m WHERE m.help = :help"),
    @NamedQuery(name = "MFreightcategory.findByFreightUnit", query = "SELECT m FROM MFreightcategory m WHERE m.freightUnit = :freightUnit"),
    @NamedQuery(name = "MFreightcategory.findByLineRound", query = "SELECT m FROM MFreightcategory m WHERE m.lineRound = :lineRound"),
    @NamedQuery(name = "MFreightcategory.findByTotalRound", query = "SELECT m FROM MFreightcategory m WHERE m.totalRound = :totalRound")})
public class MFreightcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_freightcategory_id")
    private String mFreightcategoryId;
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
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Size(max = 60)
    @Column(name = "freight_unit")
    private String freightUnit;
    @Size(max = 60)
    @Column(name = "line_round")
    private String lineRound;
    @Size(max = 60)
    @Column(name = "total_round")
    private String totalRound;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mFreightcategoryId")
    private List<MProduct> mProductList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mFreightcategoryId")
    private List<MFreight> mFreightList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mFreightcategoryId")
    private List<MInout> mInoutList;

    public MFreightcategory() {
    }

    public MFreightcategory(String mFreightcategoryId) {
        this.mFreightcategoryId = mFreightcategoryId;
    }

    public MFreightcategory(String mFreightcategoryId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name) {
        this.mFreightcategoryId = mFreightcategoryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
    }

    public String getMFreightcategoryId() {
        return mFreightcategoryId;
    }

    public void setMFreightcategoryId(String mFreightcategoryId) {
        this.mFreightcategoryId = mFreightcategoryId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getFreightUnit() {
        return freightUnit;
    }

    public void setFreightUnit(String freightUnit) {
        this.freightUnit = freightUnit;
    }

    public String getLineRound() {
        return lineRound;
    }

    public void setLineRound(String lineRound) {
        this.lineRound = lineRound;
    }

    public String getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(String totalRound) {
        this.totalRound = totalRound;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
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
    public List<MFreight> getMFreightList() {
        return mFreightList;
    }

    public void setMFreightList(List<MFreight> mFreightList) {
        this.mFreightList = mFreightList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mFreightcategoryId != null ? mFreightcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MFreightcategory)) {
            return false;
        }
        MFreightcategory other = (MFreightcategory) object;
        if ((this.mFreightcategoryId == null && other.mFreightcategoryId != null) || (this.mFreightcategoryId != null && !this.mFreightcategoryId.equals(other.mFreightcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MFreightcategory[ mFreightcategoryId=" + mFreightcategoryId + " ]";
    }
    
}
