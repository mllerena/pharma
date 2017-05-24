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
@Table(name = "c_conversion_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CConversionRate.findAll", query = "SELECT c FROM CConversionRate c"),
    @NamedQuery(name = "CConversionRate.findByCConversionRateId", query = "SELECT c FROM CConversionRate c WHERE c.cConversionRateId = :cConversionRateId"),
    @NamedQuery(name = "CConversionRate.findByIsactive", query = "SELECT c FROM CConversionRate c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CConversionRate.findByCreated", query = "SELECT c FROM CConversionRate c WHERE c.created = :created"),
    @NamedQuery(name = "CConversionRate.findByCreatedby", query = "SELECT c FROM CConversionRate c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CConversionRate.findByUpdated", query = "SELECT c FROM CConversionRate c WHERE c.updated = :updated"),
    @NamedQuery(name = "CConversionRate.findByUpdatedby", query = "SELECT c FROM CConversionRate c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CConversionRate.findByValidfrom", query = "SELECT c FROM CConversionRate c WHERE c.validfrom = :validfrom"),
    @NamedQuery(name = "CConversionRate.findByValidto", query = "SELECT c FROM CConversionRate c WHERE c.validto = :validto"),
    @NamedQuery(name = "CConversionRate.findByConversionratetype", query = "SELECT c FROM CConversionRate c WHERE c.conversionratetype = :conversionratetype"),
    @NamedQuery(name = "CConversionRate.findByMultiplyrate", query = "SELECT c FROM CConversionRate c WHERE c.multiplyrate = :multiplyrate"),
    @NamedQuery(name = "CConversionRate.findByDividerate", query = "SELECT c FROM CConversionRate c WHERE c.dividerate = :dividerate")})
public class CConversionRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_conversion_rate_id")
    private String cConversionRateId;
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
    @Column(name = "validto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "conversionratetype")
    private String conversionratetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "multiplyrate")
    private BigInteger multiplyrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dividerate")
    private BigInteger dividerate;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id_to", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyIdTo;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;

    public CConversionRate() {
    }

    public CConversionRate(String cConversionRateId) {
        this.cConversionRateId = cConversionRateId;
    }

    public CConversionRate(String cConversionRateId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date validfrom, String conversionratetype, BigInteger multiplyrate, BigInteger dividerate) {
        this.cConversionRateId = cConversionRateId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.validfrom = validfrom;
        this.conversionratetype = conversionratetype;
        this.multiplyrate = multiplyrate;
        this.dividerate = dividerate;
    }

    public String getCConversionRateId() {
        return cConversionRateId;
    }

    public void setCConversionRateId(String cConversionRateId) {
        this.cConversionRateId = cConversionRateId;
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

    public Date getValidto() {
        return validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

    public String getConversionratetype() {
        return conversionratetype;
    }

    public void setConversionratetype(String conversionratetype) {
        this.conversionratetype = conversionratetype;
    }

    public BigInteger getMultiplyrate() {
        return multiplyrate;
    }

    public void setMultiplyrate(BigInteger multiplyrate) {
        this.multiplyrate = multiplyrate;
    }

    public BigInteger getDividerate() {
        return dividerate;
    }

    public void setDividerate(BigInteger dividerate) {
        this.dividerate = dividerate;
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

    public CCurrency getCCurrencyIdTo() {
        return cCurrencyIdTo;
    }

    public void setCCurrencyIdTo(CCurrency cCurrencyIdTo) {
        this.cCurrencyIdTo = cCurrencyIdTo;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cConversionRateId != null ? cConversionRateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CConversionRate)) {
            return false;
        }
        CConversionRate other = (CConversionRate) object;
        if ((this.cConversionRateId == null && other.cConversionRateId != null) || (this.cConversionRateId != null && !this.cConversionRateId.equals(other.cConversionRateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CConversionRate[ cConversionRateId=" + cConversionRateId + " ]";
    }
    
}
