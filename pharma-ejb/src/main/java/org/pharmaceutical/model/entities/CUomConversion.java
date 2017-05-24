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
@Table(name = "c_uom_conversion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CUomConversion.findAll", query = "SELECT c FROM CUomConversion c"),
    @NamedQuery(name = "CUomConversion.findByCUomConversionId", query = "SELECT c FROM CUomConversion c WHERE c.cUomConversionId = :cUomConversionId"),
    @NamedQuery(name = "CUomConversion.findByIsactive", query = "SELECT c FROM CUomConversion c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CUomConversion.findByCreated", query = "SELECT c FROM CUomConversion c WHERE c.created = :created"),
    @NamedQuery(name = "CUomConversion.findByCreatedby", query = "SELECT c FROM CUomConversion c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CUomConversion.findByUpdated", query = "SELECT c FROM CUomConversion c WHERE c.updated = :updated"),
    @NamedQuery(name = "CUomConversion.findByUpdatedby", query = "SELECT c FROM CUomConversion c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CUomConversion.findByMultiplyrate", query = "SELECT c FROM CUomConversion c WHERE c.multiplyrate = :multiplyrate"),
    @NamedQuery(name = "CUomConversion.findByDividerate", query = "SELECT c FROM CUomConversion c WHERE c.dividerate = :dividerate")})
public class CUomConversion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_uom_conversion_id")
    private String cUomConversionId;
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
    @JoinColumn(name = "c_uom_to_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomToId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;

    public CUomConversion() {
    }

    public CUomConversion(String cUomConversionId) {
        this.cUomConversionId = cUomConversionId;
    }

    public CUomConversion(String cUomConversionId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger multiplyrate, BigInteger dividerate) {
        this.cUomConversionId = cUomConversionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.multiplyrate = multiplyrate;
        this.dividerate = dividerate;
    }

    public String getCUomConversionId() {
        return cUomConversionId;
    }

    public void setCUomConversionId(String cUomConversionId) {
        this.cUomConversionId = cUomConversionId;
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

    public CUom getCUomToId() {
        return cUomToId;
    }

    public void setCUomToId(CUom cUomToId) {
        this.cUomToId = cUomToId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cUomConversionId != null ? cUomConversionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CUomConversion)) {
            return false;
        }
        CUomConversion other = (CUomConversion) object;
        if ((this.cUomConversionId == null && other.cUomConversionId != null) || (this.cUomConversionId != null && !this.cUomConversionId.equals(other.cUomConversionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CUomConversion[ cUomConversionId=" + cUomConversionId + " ]";
    }
    
}
