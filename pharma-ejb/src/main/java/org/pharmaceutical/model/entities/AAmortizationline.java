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
@Table(name = "a_amortizationline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AAmortizationline.findAll", query = "SELECT a FROM AAmortizationline a"),
    @NamedQuery(name = "AAmortizationline.findByAAmortizationlineId", query = "SELECT a FROM AAmortizationline a WHERE a.aAmortizationlineId = :aAmortizationlineId"),
    @NamedQuery(name = "AAmortizationline.findByIsactive", query = "SELECT a FROM AAmortizationline a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AAmortizationline.findByCreated", query = "SELECT a FROM AAmortizationline a WHERE a.created = :created"),
    @NamedQuery(name = "AAmortizationline.findByCreatedby", query = "SELECT a FROM AAmortizationline a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AAmortizationline.findByUpdated", query = "SELECT a FROM AAmortizationline a WHERE a.updated = :updated"),
    @NamedQuery(name = "AAmortizationline.findByUpdatedby", query = "SELECT a FROM AAmortizationline a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AAmortizationline.findByLine", query = "SELECT a FROM AAmortizationline a WHERE a.line = :line"),
    @NamedQuery(name = "AAmortizationline.findBySeqNoAsset", query = "SELECT a FROM AAmortizationline a WHERE a.seqNoAsset = :seqNoAsset"),
    @NamedQuery(name = "AAmortizationline.findByAmortizationPercentage", query = "SELECT a FROM AAmortizationline a WHERE a.amortizationPercentage = :amortizationPercentage"),
    @NamedQuery(name = "AAmortizationline.findByAmortizationamt", query = "SELECT a FROM AAmortizationline a WHERE a.amortizationamt = :amortizationamt")})
public class AAmortizationline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "a_amortizationline_id")
    private String aAmortizationlineId;
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
    @Column(name = "line")
    private Long line;
    @Column(name = "seq_no_asset")
    private Long seqNoAsset;
    @Column(name = "amortization_percentage")
    private BigInteger amortizationPercentage;
    @Column(name = "amortizationamt")
    private BigInteger amortizationamt;
    @JoinColumn(name = "a_amortization_id", referencedColumnName = "a_amortization_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AAmortization aAmortizationId;
    @JoinColumn(name = "a_asset_id", referencedColumnName = "a_asset_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AAsset aAssetId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;

    public AAmortizationline() {
    }

    public AAmortizationline(String aAmortizationlineId) {
        this.aAmortizationlineId = aAmortizationlineId;
    }

    public AAmortizationline(String aAmortizationlineId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.aAmortizationlineId = aAmortizationlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAAmortizationlineId() {
        return aAmortizationlineId;
    }

    public void setAAmortizationlineId(String aAmortizationlineId) {
        this.aAmortizationlineId = aAmortizationlineId;
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

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public Long getSeqNoAsset() {
        return seqNoAsset;
    }

    public void setSeqNoAsset(Long seqNoAsset) {
        this.seqNoAsset = seqNoAsset;
    }

    public BigInteger getAmortizationPercentage() {
        return amortizationPercentage;
    }

    public void setAmortizationPercentage(BigInteger amortizationPercentage) {
        this.amortizationPercentage = amortizationPercentage;
    }

    public BigInteger getAmortizationamt() {
        return amortizationamt;
    }

    public void setAmortizationamt(BigInteger amortizationamt) {
        this.amortizationamt = amortizationamt;
    }

    public AAmortization getAAmortizationId() {
        return aAmortizationId;
    }

    public void setAAmortizationId(AAmortization aAmortizationId) {
        this.aAmortizationId = aAmortizationId;
    }

    public AAsset getAAssetId() {
        return aAssetId;
    }

    public void setAAssetId(AAsset aAssetId) {
        this.aAssetId = aAssetId;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aAmortizationlineId != null ? aAmortizationlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AAmortizationline)) {
            return false;
        }
        AAmortizationline other = (AAmortizationline) object;
        if ((this.aAmortizationlineId == null && other.aAmortizationlineId != null) || (this.aAmortizationlineId != null && !this.aAmortizationlineId.equals(other.aAmortizationlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AAmortizationline[ aAmortizationlineId=" + aAmortizationlineId + " ]";
    }
    
}
