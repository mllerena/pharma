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
import javax.persistence.FetchType;
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
@Table(name = "a_asset_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AAssetGroup.findAll", query = "SELECT a FROM AAssetGroup a"),
    @NamedQuery(name = "AAssetGroup.findByAAssetGroupId", query = "SELECT a FROM AAssetGroup a WHERE a.aAssetGroupId = :aAssetGroupId"),
    @NamedQuery(name = "AAssetGroup.findByIsactive", query = "SELECT a FROM AAssetGroup a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AAssetGroup.findByCreated", query = "SELECT a FROM AAssetGroup a WHERE a.created = :created"),
    @NamedQuery(name = "AAssetGroup.findByCreatedby", query = "SELECT a FROM AAssetGroup a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AAssetGroup.findByUpdated", query = "SELECT a FROM AAssetGroup a WHERE a.updated = :updated"),
    @NamedQuery(name = "AAssetGroup.findByUpdatedby", query = "SELECT a FROM AAssetGroup a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AAssetGroup.findByName", query = "SELECT a FROM AAssetGroup a WHERE a.name = :name"),
    @NamedQuery(name = "AAssetGroup.findByDescription", query = "SELECT a FROM AAssetGroup a WHERE a.description = :description"),
    @NamedQuery(name = "AAssetGroup.findByHelp", query = "SELECT a FROM AAssetGroup a WHERE a.help = :help"),
    @NamedQuery(name = "AAssetGroup.findByIsowned", query = "SELECT a FROM AAssetGroup a WHERE a.isowned = :isowned"),
    @NamedQuery(name = "AAssetGroup.findByIsdepreciated", query = "SELECT a FROM AAssetGroup a WHERE a.isdepreciated = :isdepreciated")})
public class AAssetGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "a_asset_group_id")
    private String aAssetGroupId;
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
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isowned")
    private Character isowned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdepreciated")
    private Character isdepreciated;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aAssetGroupId")
    private List<AAssetGroupAcct> aAssetGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aAssetGroupId")
    private List<MProductCategory> mProductCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aAssetGroupId")
    private List<AAsset> aAssetList;

    public AAssetGroup() {
    }

    public AAssetGroup(String aAssetGroupId) {
        this.aAssetGroupId = aAssetGroupId;
    }

    public AAssetGroup(String aAssetGroupId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isowned, Character isdepreciated) {
        this.aAssetGroupId = aAssetGroupId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isowned = isowned;
        this.isdepreciated = isdepreciated;
    }

    public String getAAssetGroupId() {
        return aAssetGroupId;
    }

    public void setAAssetGroupId(String aAssetGroupId) {
        this.aAssetGroupId = aAssetGroupId;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Character getIsowned() {
        return isowned;
    }

    public void setIsowned(Character isowned) {
        this.isowned = isowned;
    }

    public Character getIsdepreciated() {
        return isdepreciated;
    }

    public void setIsdepreciated(Character isdepreciated) {
        this.isdepreciated = isdepreciated;
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
    public List<AAssetGroupAcct> getAAssetGroupAcctList() {
        return aAssetGroupAcctList;
    }

    public void setAAssetGroupAcctList(List<AAssetGroupAcct> aAssetGroupAcctList) {
        this.aAssetGroupAcctList = aAssetGroupAcctList;
    }

    @XmlTransient
    public List<MProductCategory> getMProductCategoryList() {
        return mProductCategoryList;
    }

    public void setMProductCategoryList(List<MProductCategory> mProductCategoryList) {
        this.mProductCategoryList = mProductCategoryList;
    }

    @XmlTransient
    public List<AAsset> getAAssetList() {
        return aAssetList;
    }

    public void setAAssetList(List<AAsset> aAssetList) {
        this.aAssetList = aAssetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aAssetGroupId != null ? aAssetGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AAssetGroup)) {
            return false;
        }
        AAssetGroup other = (AAssetGroup) object;
        if ((this.aAssetGroupId == null && other.aAssetGroupId != null) || (this.aAssetGroupId != null && !this.aAssetGroupId.equals(other.aAssetGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AAssetGroup[ aAssetGroupId=" + aAssetGroupId + " ]";
    }
    
}
