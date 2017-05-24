/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "m_freight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MFreight.findAll", query = "SELECT m FROM MFreight m"),
    @NamedQuery(name = "MFreight.findByMFreightId", query = "SELECT m FROM MFreight m WHERE m.mFreightId = :mFreightId"),
    @NamedQuery(name = "MFreight.findByIsactive", query = "SELECT m FROM MFreight m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MFreight.findByCreated", query = "SELECT m FROM MFreight m WHERE m.created = :created"),
    @NamedQuery(name = "MFreight.findByCreatedby", query = "SELECT m FROM MFreight m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MFreight.findByUpdated", query = "SELECT m FROM MFreight m WHERE m.updated = :updated"),
    @NamedQuery(name = "MFreight.findByUpdatedby", query = "SELECT m FROM MFreight m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MFreight.findByValidfrom", query = "SELECT m FROM MFreight m WHERE m.validfrom = :validfrom"),
    @NamedQuery(name = "MFreight.findByFreightamt", query = "SELECT m FROM MFreight m WHERE m.freightamt = :freightamt"),
    @NamedQuery(name = "MFreight.findByFreightUnit", query = "SELECT m FROM MFreight m WHERE m.freightUnit = :freightUnit"),
    @NamedQuery(name = "MFreight.findByIsprice", query = "SELECT m FROM MFreight m WHERE m.isprice = :isprice"),
    @NamedQuery(name = "MFreight.findByLineRound", query = "SELECT m FROM MFreight m WHERE m.lineRound = :lineRound"),
    @NamedQuery(name = "MFreight.findByQtyfrom", query = "SELECT m FROM MFreight m WHERE m.qtyfrom = :qtyfrom"),
    @NamedQuery(name = "MFreight.findByQtyto", query = "SELECT m FROM MFreight m WHERE m.qtyto = :qtyto"),
    @NamedQuery(name = "MFreight.findByTotalRound", query = "SELECT m FROM MFreight m WHERE m.totalRound = :totalRound")})
public class MFreight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_freight_id")
    private String mFreightId;
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
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "freightamt")
    private BigInteger freightamt;
    @Size(max = 60)
    @Column(name = "freight_unit")
    private String freightUnit;
    @Column(name = "isprice")
    private Character isprice;
    @Size(max = 60)
    @Column(name = "line_round")
    private String lineRound;
    @Column(name = "qtyfrom")
    private BigInteger qtyfrom;
    @Column(name = "qtyto")
    private BigInteger qtyto;
    @Size(max = 60)
    @Column(name = "total_round")
    private String totalRound;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;
    @JoinColumn(name = "to_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry toCountryId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion cRegionId;
    @JoinColumn(name = "to_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion toRegionId;
    @JoinColumn(name = "m_freightcategory_id", referencedColumnName = "m_freightcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MFreightcategory mFreightcategoryId;
    @JoinColumn(name = "m_shipper_id", referencedColumnName = "m_shipper_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MShipper mShipperId;

    public MFreight() {
    }

    public MFreight(String mFreightId) {
        this.mFreightId = mFreightId;
    }

    public MFreight(String mFreightId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date validfrom, BigInteger freightamt) {
        this.mFreightId = mFreightId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.validfrom = validfrom;
        this.freightamt = freightamt;
    }

    public String getMFreightId() {
        return mFreightId;
    }

    public void setMFreightId(String mFreightId) {
        this.mFreightId = mFreightId;
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

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public BigInteger getFreightamt() {
        return freightamt;
    }

    public void setFreightamt(BigInteger freightamt) {
        this.freightamt = freightamt;
    }

    public String getFreightUnit() {
        return freightUnit;
    }

    public void setFreightUnit(String freightUnit) {
        this.freightUnit = freightUnit;
    }

    public Character getIsprice() {
        return isprice;
    }

    public void setIsprice(Character isprice) {
        this.isprice = isprice;
    }

    public String getLineRound() {
        return lineRound;
    }

    public void setLineRound(String lineRound) {
        this.lineRound = lineRound;
    }

    public BigInteger getQtyfrom() {
        return qtyfrom;
    }

    public void setQtyfrom(BigInteger qtyfrom) {
        this.qtyfrom = qtyfrom;
    }

    public BigInteger getQtyto() {
        return qtyto;
    }

    public void setQtyto(BigInteger qtyto) {
        this.qtyto = qtyto;
    }

    public String getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(String totalRound) {
        this.totalRound = totalRound;
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

    public CCountry getToCountryId() {
        return toCountryId;
    }

    public void setToCountryId(CCountry toCountryId) {
        this.toCountryId = toCountryId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CRegion getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(CRegion cRegionId) {
        this.cRegionId = cRegionId;
    }

    public CRegion getToRegionId() {
        return toRegionId;
    }

    public void setToRegionId(CRegion toRegionId) {
        this.toRegionId = toRegionId;
    }

    public MFreightcategory getMFreightcategoryId() {
        return mFreightcategoryId;
    }

    public void setMFreightcategoryId(MFreightcategory mFreightcategoryId) {
        this.mFreightcategoryId = mFreightcategoryId;
    }

    public MShipper getMShipperId() {
        return mShipperId;
    }

    public void setMShipperId(MShipper mShipperId) {
        this.mShipperId = mShipperId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mFreightId != null ? mFreightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MFreight)) {
            return false;
        }
        MFreight other = (MFreight) object;
        if ((this.mFreightId == null && other.mFreightId != null) || (this.mFreightId != null && !this.mFreightId.equals(other.mFreightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MFreight[ mFreightId=" + mFreightId + " ]";
    }
    
}
