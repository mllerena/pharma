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
@Table(name = "c_bp_withholding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpWithholding.findAll", query = "SELECT c FROM CBpWithholding c"),
    @NamedQuery(name = "CBpWithholding.findByCBpWithholdingId", query = "SELECT c FROM CBpWithholding c WHERE c.cBpWithholdingId = :cBpWithholdingId"),
    @NamedQuery(name = "CBpWithholding.findByIsactive", query = "SELECT c FROM CBpWithholding c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpWithholding.findByCreated", query = "SELECT c FROM CBpWithholding c WHERE c.created = :created"),
    @NamedQuery(name = "CBpWithholding.findByCreatedby", query = "SELECT c FROM CBpWithholding c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpWithholding.findByUpdated", query = "SELECT c FROM CBpWithholding c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpWithholding.findByUpdatedby", query = "SELECT c FROM CBpWithholding c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpWithholding.findByIsmandatorywithholding", query = "SELECT c FROM CBpWithholding c WHERE c.ismandatorywithholding = :ismandatorywithholding"),
    @NamedQuery(name = "CBpWithholding.findByIstemporaryexempt", query = "SELECT c FROM CBpWithholding c WHERE c.istemporaryexempt = :istemporaryexempt"),
    @NamedQuery(name = "CBpWithholding.findByExemptreason", query = "SELECT c FROM CBpWithholding c WHERE c.exemptreason = :exemptreason"),
    @NamedQuery(name = "CBpWithholding.findByIsPercentWh", query = "SELECT c FROM CBpWithholding c WHERE c.isPercentWh = :isPercentWh"),
    @NamedQuery(name = "CBpWithholding.findByWhPercent", query = "SELECT c FROM CBpWithholding c WHERE c.whPercent = :whPercent"),
    @NamedQuery(name = "CBpWithholding.findByIncludeTax", query = "SELECT c FROM CBpWithholding c WHERE c.includeTax = :includeTax"),
    @NamedQuery(name = "CBpWithholding.findByIsdefault", query = "SELECT c FROM CBpWithholding c WHERE c.isdefault = :isdefault")})
public class CBpWithholding implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bp_withholding_id")
    private String cBpWithholdingId;
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
    @Column(name = "ismandatorywithholding")
    private Character ismandatorywithholding;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istemporaryexempt")
    private Character istemporaryexempt;
    @Size(max = 20)
    @Column(name = "exemptreason")
    private String exemptreason;
    @Column(name = "is_percent_wh")
    private Character isPercentWh;
    @Column(name = "wh_percent")
    private Long whPercent;
    @Column(name = "include_tax")
    private Character includeTax;
    @Column(name = "isdefault")
    private Character isdefault;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTax cTaxId;
    @JoinColumn(name = "c_withholding_id", referencedColumnName = "c_withholding_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CWithholding cWithholdingId;

    public CBpWithholding() {
    }

    public CBpWithholding(String cBpWithholdingId) {
        this.cBpWithholdingId = cBpWithholdingId;
    }

    public CBpWithholding(String cBpWithholdingId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character ismandatorywithholding, Character istemporaryexempt) {
        this.cBpWithholdingId = cBpWithholdingId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.ismandatorywithholding = ismandatorywithholding;
        this.istemporaryexempt = istemporaryexempt;
    }

    public String getCBpWithholdingId() {
        return cBpWithholdingId;
    }

    public void setCBpWithholdingId(String cBpWithholdingId) {
        this.cBpWithholdingId = cBpWithholdingId;
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

    public Character getIsmandatorywithholding() {
        return ismandatorywithholding;
    }

    public void setIsmandatorywithholding(Character ismandatorywithholding) {
        this.ismandatorywithholding = ismandatorywithholding;
    }

    public Character getIstemporaryexempt() {
        return istemporaryexempt;
    }

    public void setIstemporaryexempt(Character istemporaryexempt) {
        this.istemporaryexempt = istemporaryexempt;
    }

    public String getExemptreason() {
        return exemptreason;
    }

    public void setExemptreason(String exemptreason) {
        this.exemptreason = exemptreason;
    }

    public Character getIsPercentWh() {
        return isPercentWh;
    }

    public void setIsPercentWh(Character isPercentWh) {
        this.isPercentWh = isPercentWh;
    }

    public Long getWhPercent() {
        return whPercent;
    }

    public void setWhPercent(Long whPercent) {
        this.whPercent = whPercent;
    }

    public Character getIncludeTax() {
        return includeTax;
    }

    public void setIncludeTax(Character includeTax) {
        this.includeTax = includeTax;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CWithholding getCWithholdingId() {
        return cWithholdingId;
    }

    public void setCWithholdingId(CWithholding cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpWithholdingId != null ? cBpWithholdingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpWithholding)) {
            return false;
        }
        CBpWithholding other = (CBpWithholding) object;
        if ((this.cBpWithholdingId == null && other.cBpWithholdingId != null) || (this.cBpWithholdingId != null && !this.cBpWithholdingId.equals(other.cBpWithholdingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpWithholding[ cBpWithholdingId=" + cBpWithholdingId + " ]";
    }
    
}
