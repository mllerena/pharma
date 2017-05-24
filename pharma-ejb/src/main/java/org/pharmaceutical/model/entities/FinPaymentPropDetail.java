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
@Table(name = "fin_payment_prop_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentPropDetail.findAll", query = "SELECT f FROM FinPaymentPropDetail f"),
    @NamedQuery(name = "FinPaymentPropDetail.findByFinPaymentPropDetailId", query = "SELECT f FROM FinPaymentPropDetail f WHERE f.finPaymentPropDetailId = :finPaymentPropDetailId"),
    @NamedQuery(name = "FinPaymentPropDetail.findByIsactive", query = "SELECT f FROM FinPaymentPropDetail f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentPropDetail.findByCreated", query = "SELECT f FROM FinPaymentPropDetail f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentPropDetail.findByCreatedby", query = "SELECT f FROM FinPaymentPropDetail f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentPropDetail.findByUpdated", query = "SELECT f FROM FinPaymentPropDetail f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentPropDetail.findByUpdatedby", query = "SELECT f FROM FinPaymentPropDetail f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentPropDetail.findByAmount", query = "SELECT f FROM FinPaymentPropDetail f WHERE f.amount = :amount"),
    @NamedQuery(name = "FinPaymentPropDetail.findByWriteoffamt", query = "SELECT f FROM FinPaymentPropDetail f WHERE f.writeoffamt = :writeoffamt")})
public class FinPaymentPropDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_prop_detail_id")
    private String finPaymentPropDetailId;
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
    @Column(name = "amount")
    private BigInteger amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "writeoffamt")
    private BigInteger writeoffamt;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGlitem cGlitemId;
    @JoinColumn(name = "fin_payment_proposal_id", referencedColumnName = "fin_payment_proposal_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPaymentProposal finPaymentProposalId;
    @JoinColumn(name = "fin_payment_scheduledetail_id", referencedColumnName = "fin_payment_scheduledetail_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPaymentScheduledetail finPaymentScheduledetailId;

    public FinPaymentPropDetail() {
    }

    public FinPaymentPropDetail(String finPaymentPropDetailId) {
        this.finPaymentPropDetailId = finPaymentPropDetailId;
    }

    public FinPaymentPropDetail(String finPaymentPropDetailId, Date created, String createdby, Date updated, String updatedby, BigInteger amount, BigInteger writeoffamt) {
        this.finPaymentPropDetailId = finPaymentPropDetailId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.amount = amount;
        this.writeoffamt = writeoffamt;
    }

    public String getFinPaymentPropDetailId() {
        return finPaymentPropDetailId;
    }

    public void setFinPaymentPropDetailId(String finPaymentPropDetailId) {
        this.finPaymentPropDetailId = finPaymentPropDetailId;
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

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getWriteoffamt() {
        return writeoffamt;
    }

    public void setWriteoffamt(BigInteger writeoffamt) {
        this.writeoffamt = writeoffamt;
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

    public CGlitem getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(CGlitem cGlitemId) {
        this.cGlitemId = cGlitemId;
    }

    public FinPaymentProposal getFinPaymentProposalId() {
        return finPaymentProposalId;
    }

    public void setFinPaymentProposalId(FinPaymentProposal finPaymentProposalId) {
        this.finPaymentProposalId = finPaymentProposalId;
    }

    public FinPaymentScheduledetail getFinPaymentScheduledetailId() {
        return finPaymentScheduledetailId;
    }

    public void setFinPaymentScheduledetailId(FinPaymentScheduledetail finPaymentScheduledetailId) {
        this.finPaymentScheduledetailId = finPaymentScheduledetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentPropDetailId != null ? finPaymentPropDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentPropDetail)) {
            return false;
        }
        FinPaymentPropDetail other = (FinPaymentPropDetail) object;
        if ((this.finPaymentPropDetailId == null && other.finPaymentPropDetailId != null) || (this.finPaymentPropDetailId != null && !this.finPaymentPropDetailId.equals(other.finPaymentPropDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentPropDetail[ finPaymentPropDetailId=" + finPaymentPropDetailId + " ]";
    }
    
}
