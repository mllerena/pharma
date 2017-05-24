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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "ad_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdImage.findAll", query = "SELECT a FROM AdImage a"),
    @NamedQuery(name = "AdImage.findByAdImageId", query = "SELECT a FROM AdImage a WHERE a.adImageId = :adImageId"),
    @NamedQuery(name = "AdImage.findByIsactive", query = "SELECT a FROM AdImage a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdImage.findByCreated", query = "SELECT a FROM AdImage a WHERE a.created = :created"),
    @NamedQuery(name = "AdImage.findByCreatedby", query = "SELECT a FROM AdImage a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdImage.findByUpdated", query = "SELECT a FROM AdImage a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdImage.findByUpdatedby", query = "SELECT a FROM AdImage a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdImage.findByName", query = "SELECT a FROM AdImage a WHERE a.name = :name"),
    @NamedQuery(name = "AdImage.findByImageurl", query = "SELECT a FROM AdImage a WHERE a.imageurl = :imageurl")})
public class AdImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_image_id")
    private String adImageId;
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
    @Size(max = 120)
    @Column(name = "imageurl")
    private String imageurl;
    @Lob
    @Column(name = "binarydata")
    private byte[] binarydata;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adImageId")
    private List<MProduct> mProductList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourCompanyMenuImage")
    private List<AdSystemInfo> adSystemInfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourItServiceLoginImage")
    private List<AdSystemInfo> adSystemInfoList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourCompanyLoginImage")
    private List<AdSystemInfo> adSystemInfoList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "productionBannerImageId")
    private List<AdSystemInfo> adSystemInfoList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourCompanyBigImage")
    private List<AdSystemInfo> adSystemInfoList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourCompanyDocumentImage")
    private List<AdSystemInfo> adSystemInfoList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourCompanyDocumentImage")
    private List<AdOrginfo> adOrginfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adImageId")
    private List<AdTab> adTabList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourCompanyBigImage")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourCompanyMenuImage")
    private List<AdClientinfo> adClientinfoList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "yourCompanyDocumentImage")
    private List<AdClientinfo> adClientinfoList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adImageId")
    private List<AdWindow> adWindowList;

    public AdImage() {
    }

    public AdImage(String adImageId) {
        this.adImageId = adImageId;
    }

    public AdImage(String adImageId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.adImageId = adImageId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getAdImageId() {
        return adImageId;
    }

    public void setAdImageId(String adImageId) {
        this.adImageId = adImageId;
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

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public byte[] getBinarydata() {
        return binarydata;
    }

    public void setBinarydata(byte[] binarydata) {
        this.binarydata = binarydata;
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
    public List<AdSystemInfo> getAdSystemInfoList() {
        return adSystemInfoList;
    }

    public void setAdSystemInfoList(List<AdSystemInfo> adSystemInfoList) {
        this.adSystemInfoList = adSystemInfoList;
    }

    @XmlTransient
    public List<AdSystemInfo> getAdSystemInfoList1() {
        return adSystemInfoList1;
    }

    public void setAdSystemInfoList1(List<AdSystemInfo> adSystemInfoList1) {
        this.adSystemInfoList1 = adSystemInfoList1;
    }

    @XmlTransient
    public List<AdSystemInfo> getAdSystemInfoList2() {
        return adSystemInfoList2;
    }

    public void setAdSystemInfoList2(List<AdSystemInfo> adSystemInfoList2) {
        this.adSystemInfoList2 = adSystemInfoList2;
    }

    @XmlTransient
    public List<AdSystemInfo> getAdSystemInfoList3() {
        return adSystemInfoList3;
    }

    public void setAdSystemInfoList3(List<AdSystemInfo> adSystemInfoList3) {
        this.adSystemInfoList3 = adSystemInfoList3;
    }

    @XmlTransient
    public List<AdSystemInfo> getAdSystemInfoList4() {
        return adSystemInfoList4;
    }

    public void setAdSystemInfoList4(List<AdSystemInfo> adSystemInfoList4) {
        this.adSystemInfoList4 = adSystemInfoList4;
    }

    @XmlTransient
    public List<AdSystemInfo> getAdSystemInfoList5() {
        return adSystemInfoList5;
    }

    public void setAdSystemInfoList5(List<AdSystemInfo> adSystemInfoList5) {
        this.adSystemInfoList5 = adSystemInfoList5;
    }

    @XmlTransient
    public List<AdOrginfo> getAdOrginfoList() {
        return adOrginfoList;
    }

    public void setAdOrginfoList(List<AdOrginfo> adOrginfoList) {
        this.adOrginfoList = adOrginfoList;
    }

    @XmlTransient
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList() {
        return adClientinfoList;
    }

    public void setAdClientinfoList(List<AdClientinfo> adClientinfoList) {
        this.adClientinfoList = adClientinfoList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList1() {
        return adClientinfoList1;
    }

    public void setAdClientinfoList1(List<AdClientinfo> adClientinfoList1) {
        this.adClientinfoList1 = adClientinfoList1;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList2() {
        return adClientinfoList2;
    }

    public void setAdClientinfoList2(List<AdClientinfo> adClientinfoList2) {
        this.adClientinfoList2 = adClientinfoList2;
    }

    @XmlTransient
    public List<AdWindow> getAdWindowList() {
        return adWindowList;
    }

    public void setAdWindowList(List<AdWindow> adWindowList) {
        this.adWindowList = adWindowList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adImageId != null ? adImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdImage)) {
            return false;
        }
        AdImage other = (AdImage) object;
        if ((this.adImageId == null && other.adImageId != null) || (this.adImageId != null && !this.adImageId.equals(other.adImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdImage[ adImageId=" + adImageId + " ]";
    }
    
}
