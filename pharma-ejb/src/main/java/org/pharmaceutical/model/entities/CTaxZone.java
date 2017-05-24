/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "c_tax_zone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxZone.findAll", query = "SELECT c FROM CTaxZone c"),
    @NamedQuery(name = "CTaxZone.findByCTaxZoneId", query = "SELECT c FROM CTaxZone c WHERE c.cTaxZoneId = :cTaxZoneId"),
    @NamedQuery(name = "CTaxZone.findByIsactive", query = "SELECT c FROM CTaxZone c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxZone.findByCreated", query = "SELECT c FROM CTaxZone c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxZone.findByCreatedby", query = "SELECT c FROM CTaxZone c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxZone.findByUpdated", query = "SELECT c FROM CTaxZone c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxZone.findByUpdatedby", query = "SELECT c FROM CTaxZone c WHERE c.updatedby = :updatedby")})
public class CTaxZone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_tax_zone_id")
    private String cTaxZoneId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "to_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry toCountryId;
    @JoinColumn(name = "from_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry fromCountryId;
    @JoinColumn(name = "to_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion toRegionId;
    @JoinColumn(name = "from_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion fromRegionId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;

    public CTaxZone() {
    }

    public CTaxZone(String cTaxZoneId) {
        this.cTaxZoneId = cTaxZoneId;
    }

    public String getCTaxZoneId() {
        return cTaxZoneId;
    }

    public void setCTaxZoneId(String cTaxZoneId) {
        this.cTaxZoneId = cTaxZoneId;
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

    public CCountry getToCountryId() {
        return toCountryId;
    }

    public void setToCountryId(CCountry toCountryId) {
        this.toCountryId = toCountryId;
    }

    public CCountry getFromCountryId() {
        return fromCountryId;
    }

    public void setFromCountryId(CCountry fromCountryId) {
        this.fromCountryId = fromCountryId;
    }

    public CRegion getToRegionId() {
        return toRegionId;
    }

    public void setToRegionId(CRegion toRegionId) {
        this.toRegionId = toRegionId;
    }

    public CRegion getFromRegionId() {
        return fromRegionId;
    }

    public void setFromRegionId(CRegion fromRegionId) {
        this.fromRegionId = fromRegionId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxZoneId != null ? cTaxZoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxZone)) {
            return false;
        }
        CTaxZone other = (CTaxZone) object;
        if ((this.cTaxZoneId == null && other.cTaxZoneId != null) || (this.cTaxZoneId != null && !this.cTaxZoneId.equals(other.cTaxZoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxZone[ cTaxZoneId=" + cTaxZoneId + " ]";
    }
    
}
