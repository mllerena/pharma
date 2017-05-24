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
@Table(name = "c_city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCity.findAll", query = "SELECT c FROM CCity c"),
    @NamedQuery(name = "CCity.findByCCityId", query = "SELECT c FROM CCity c WHERE c.cCityId = :cCityId"),
    @NamedQuery(name = "CCity.findByIsactive", query = "SELECT c FROM CCity c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCity.findByCreated", query = "SELECT c FROM CCity c WHERE c.created = :created"),
    @NamedQuery(name = "CCity.findByCreatedby", query = "SELECT c FROM CCity c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCity.findByUpdated", query = "SELECT c FROM CCity c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCity.findByUpdatedby", query = "SELECT c FROM CCity c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCity.findByName", query = "SELECT c FROM CCity c WHERE c.name = :name"),
    @NamedQuery(name = "CCity.findByLocode", query = "SELECT c FROM CCity c WHERE c.locode = :locode"),
    @NamedQuery(name = "CCity.findByCoordinates", query = "SELECT c FROM CCity c WHERE c.coordinates = :coordinates"),
    @NamedQuery(name = "CCity.findByPostal", query = "SELECT c FROM CCity c WHERE c.postal = :postal"),
    @NamedQuery(name = "CCity.findByAreacode", query = "SELECT c FROM CCity c WHERE c.areacode = :areacode")})
public class CCity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_city_id")
    private String cCityId;
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
    @Size(max = 10)
    @Column(name = "locode")
    private String locode;
    @Size(max = 15)
    @Column(name = "coordinates")
    private String coordinates;
    @Size(max = 10)
    @Column(name = "postal")
    private String postal;
    @Size(max = 10)
    @Column(name = "areacode")
    private String areacode;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;
    @JoinColumn(name = "c_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion cRegionId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCityId")
    private List<CLocation> cLocationList;

    public CCity() {
    }

    public CCity(String cCityId) {
        this.cCityId = cCityId;
    }

    public CCity(String cCityId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cCityId = cCityId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCCityId() {
        return cCityId;
    }

    public void setCCityId(String cCityId) {
        this.cCityId = cCityId;
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

    public String getLocode() {
        return locode;
    }

    public void setLocode(String locode) {
        this.locode = locode;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
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

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    public CRegion getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(CRegion cRegionId) {
        this.cRegionId = cRegionId;
    }

    @XmlTransient
    public List<CLocation> getCLocationList() {
        return cLocationList;
    }

    public void setCLocationList(List<CLocation> cLocationList) {
        this.cLocationList = cLocationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCityId != null ? cCityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCity)) {
            return false;
        }
        CCity other = (CCity) object;
        if ((this.cCityId == null && other.cCityId != null) || (this.cCityId != null && !this.cCityId.equals(other.cCityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCity[ cCityId=" + cCityId + " ]";
    }
    
}
