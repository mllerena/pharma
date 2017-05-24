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
@Table(name = "a_asset_group_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AAssetGroupAcct.findAll", query = "SELECT a FROM AAssetGroupAcct a"),
    @NamedQuery(name = "AAssetGroupAcct.findByAAssetGroupAcctId", query = "SELECT a FROM AAssetGroupAcct a WHERE a.aAssetGroupAcctId = :aAssetGroupAcctId"),
    @NamedQuery(name = "AAssetGroupAcct.findByIsactive", query = "SELECT a FROM AAssetGroupAcct a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AAssetGroupAcct.findByCreated", query = "SELECT a FROM AAssetGroupAcct a WHERE a.created = :created"),
    @NamedQuery(name = "AAssetGroupAcct.findByCreatedby", query = "SELECT a FROM AAssetGroupAcct a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AAssetGroupAcct.findByUpdated", query = "SELECT a FROM AAssetGroupAcct a WHERE a.updated = :updated"),
    @NamedQuery(name = "AAssetGroupAcct.findByUpdatedby", query = "SELECT a FROM AAssetGroupAcct a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AAssetGroupAcct.findByProcessing", query = "SELECT a FROM AAssetGroupAcct a WHERE a.processing = :processing")})
public class AAssetGroupAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "a_asset_group_acct_id")
    private String aAssetGroupAcctId;
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
    @Column(name = "processing")
    private Character processing;
    @JoinColumn(name = "a_asset_group_id", referencedColumnName = "a_asset_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AAssetGroup aAssetGroupId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "a_accumdepreciation_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination aAccumdepreciationAcct;
    @JoinColumn(name = "a_disposal_gain", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination aDisposalGain;
    @JoinColumn(name = "a_disposal_loss", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination aDisposalLoss;
    @JoinColumn(name = "a_depreciation_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination aDepreciationAcct;

    public AAssetGroupAcct() {
    }

    public AAssetGroupAcct(String aAssetGroupAcctId) {
        this.aAssetGroupAcctId = aAssetGroupAcctId;
    }

    public AAssetGroupAcct(String aAssetGroupAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.aAssetGroupAcctId = aAssetGroupAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAAssetGroupAcctId() {
        return aAssetGroupAcctId;
    }

    public void setAAssetGroupAcctId(String aAssetGroupAcctId) {
        this.aAssetGroupAcctId = aAssetGroupAcctId;
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

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public AAssetGroup getAAssetGroupId() {
        return aAssetGroupId;
    }

    public void setAAssetGroupId(AAssetGroup aAssetGroupId) {
        this.aAssetGroupId = aAssetGroupId;
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

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CValidcombination getAAccumdepreciationAcct() {
        return aAccumdepreciationAcct;
    }

    public void setAAccumdepreciationAcct(CValidcombination aAccumdepreciationAcct) {
        this.aAccumdepreciationAcct = aAccumdepreciationAcct;
    }

    public CValidcombination getADisposalGain() {
        return aDisposalGain;
    }

    public void setADisposalGain(CValidcombination aDisposalGain) {
        this.aDisposalGain = aDisposalGain;
    }

    public CValidcombination getADisposalLoss() {
        return aDisposalLoss;
    }

    public void setADisposalLoss(CValidcombination aDisposalLoss) {
        this.aDisposalLoss = aDisposalLoss;
    }

    public CValidcombination getADepreciationAcct() {
        return aDepreciationAcct;
    }

    public void setADepreciationAcct(CValidcombination aDepreciationAcct) {
        this.aDepreciationAcct = aDepreciationAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aAssetGroupAcctId != null ? aAssetGroupAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AAssetGroupAcct)) {
            return false;
        }
        AAssetGroupAcct other = (AAssetGroupAcct) object;
        if ((this.aAssetGroupAcctId == null && other.aAssetGroupAcctId != null) || (this.aAssetGroupAcctId != null && !this.aAssetGroupAcctId.equals(other.aAssetGroupAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AAssetGroupAcct[ aAssetGroupAcctId=" + aAssetGroupAcctId + " ]";
    }
    
}
