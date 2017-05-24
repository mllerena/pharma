/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "c_revenuerecognition_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRevenuerecognitionPlan.findAll", query = "SELECT c FROM CRevenuerecognitionPlan c"),
    @NamedQuery(name = "CRevenuerecognitionPlan.findByCRevenuerecognitionPlanId", query = "SELECT c FROM CRevenuerecognitionPlan c WHERE c.cRevenuerecognitionPlanId = :cRevenuerecognitionPlanId"),
    @NamedQuery(name = "CRevenuerecognitionPlan.findByIsactive", query = "SELECT c FROM CRevenuerecognitionPlan c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CRevenuerecognitionPlan.findByCreated", query = "SELECT c FROM CRevenuerecognitionPlan c WHERE c.created = :created"),
    @NamedQuery(name = "CRevenuerecognitionPlan.findByCreatedby", query = "SELECT c FROM CRevenuerecognitionPlan c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CRevenuerecognitionPlan.findByUpdated", query = "SELECT c FROM CRevenuerecognitionPlan c WHERE c.updated = :updated"),
    @NamedQuery(name = "CRevenuerecognitionPlan.findByUpdatedby", query = "SELECT c FROM CRevenuerecognitionPlan c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CRevenuerecognitionPlan.findByTotalamt", query = "SELECT c FROM CRevenuerecognitionPlan c WHERE c.totalamt = :totalamt"),
    @NamedQuery(name = "CRevenuerecognitionPlan.findByRecognizedamt", query = "SELECT c FROM CRevenuerecognitionPlan c WHERE c.recognizedamt = :recognizedamt")})
public class CRevenuerecognitionPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_revenuerecognition_plan_id")
    private String cRevenuerecognitionPlanId;
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
    @Column(name = "totalamt")
    private BigInteger totalamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recognizedamt")
    private BigInteger recognizedamt;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cRevenuerecognitionPlanId")
    private List<CServicelevel> cServicelevelList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "c_revenuerecognition_id", referencedColumnName = "c_revenuerecognition_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CRevenuerecognition cRevenuerecognitionId;
    @JoinColumn(name = "unearnedrevenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination unearnedrevenueAcct;
    @JoinColumn(name = "p_revenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination pRevenueAcct;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cRevenuerecognitionPlanId")
    private List<CRevenuerecognitionRun> cRevenuerecognitionRunList;

    public CRevenuerecognitionPlan() {
    }

    public CRevenuerecognitionPlan(String cRevenuerecognitionPlanId) {
        this.cRevenuerecognitionPlanId = cRevenuerecognitionPlanId;
    }

    public CRevenuerecognitionPlan(String cRevenuerecognitionPlanId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger totalamt, BigInteger recognizedamt) {
        this.cRevenuerecognitionPlanId = cRevenuerecognitionPlanId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.totalamt = totalamt;
        this.recognizedamt = recognizedamt;
    }

    public String getCRevenuerecognitionPlanId() {
        return cRevenuerecognitionPlanId;
    }

    public void setCRevenuerecognitionPlanId(String cRevenuerecognitionPlanId) {
        this.cRevenuerecognitionPlanId = cRevenuerecognitionPlanId;
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

    public BigInteger getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(BigInteger totalamt) {
        this.totalamt = totalamt;
    }

    public BigInteger getRecognizedamt() {
        return recognizedamt;
    }

    public void setRecognizedamt(BigInteger recognizedamt) {
        this.recognizedamt = recognizedamt;
    }

    @XmlTransient
    public List<CServicelevel> getCServicelevelList() {
        return cServicelevelList;
    }

    public void setCServicelevelList(List<CServicelevel> cServicelevelList) {
        this.cServicelevelList = cServicelevelList;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public CRevenuerecognition getCRevenuerecognitionId() {
        return cRevenuerecognitionId;
    }

    public void setCRevenuerecognitionId(CRevenuerecognition cRevenuerecognitionId) {
        this.cRevenuerecognitionId = cRevenuerecognitionId;
    }

    public CValidcombination getUnearnedrevenueAcct() {
        return unearnedrevenueAcct;
    }

    public void setUnearnedrevenueAcct(CValidcombination unearnedrevenueAcct) {
        this.unearnedrevenueAcct = unearnedrevenueAcct;
    }

    public CValidcombination getPRevenueAcct() {
        return pRevenueAcct;
    }

    public void setPRevenueAcct(CValidcombination pRevenueAcct) {
        this.pRevenueAcct = pRevenueAcct;
    }

    @XmlTransient
    public List<CRevenuerecognitionRun> getCRevenuerecognitionRunList() {
        return cRevenuerecognitionRunList;
    }

    public void setCRevenuerecognitionRunList(List<CRevenuerecognitionRun> cRevenuerecognitionRunList) {
        this.cRevenuerecognitionRunList = cRevenuerecognitionRunList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRevenuerecognitionPlanId != null ? cRevenuerecognitionPlanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRevenuerecognitionPlan)) {
            return false;
        }
        CRevenuerecognitionPlan other = (CRevenuerecognitionPlan) object;
        if ((this.cRevenuerecognitionPlanId == null && other.cRevenuerecognitionPlanId != null) || (this.cRevenuerecognitionPlanId != null && !this.cRevenuerecognitionPlanId.equals(other.cRevenuerecognitionPlanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CRevenuerecognitionPlan[ cRevenuerecognitionPlanId=" + cRevenuerecognitionPlanId + " ]";
    }
    
}
