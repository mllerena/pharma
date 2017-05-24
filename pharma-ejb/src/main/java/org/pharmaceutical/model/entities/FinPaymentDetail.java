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
@Table(name = "fin_payment_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentDetail.findAll", query = "SELECT f FROM FinPaymentDetail f"),
    @NamedQuery(name = "FinPaymentDetail.findByFinPaymentDetailId", query = "SELECT f FROM FinPaymentDetail f WHERE f.finPaymentDetailId = :finPaymentDetailId"),
    @NamedQuery(name = "FinPaymentDetail.findByCreated", query = "SELECT f FROM FinPaymentDetail f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentDetail.findByCreatedby", query = "SELECT f FROM FinPaymentDetail f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentDetail.findByUpdated", query = "SELECT f FROM FinPaymentDetail f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentDetail.findByUpdatedby", query = "SELECT f FROM FinPaymentDetail f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentDetail.findByAmount", query = "SELECT f FROM FinPaymentDetail f WHERE f.amount = :amount"),
    @NamedQuery(name = "FinPaymentDetail.findByRefund", query = "SELECT f FROM FinPaymentDetail f WHERE f.refund = :refund"),
    @NamedQuery(name = "FinPaymentDetail.findByIsactive", query = "SELECT f FROM FinPaymentDetail f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentDetail.findByWriteoffamt", query = "SELECT f FROM FinPaymentDetail f WHERE f.writeoffamt = :writeoffamt"),
    @NamedQuery(name = "FinPaymentDetail.findByIsprepayment", query = "SELECT f FROM FinPaymentDetail f WHERE f.isprepayment = :isprepayment")})
public class FinPaymentDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_detail_id")
    private String finPaymentDetailId;
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
    @Column(name = "refund")
    private Character refund;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "writeoffamt")
    private BigInteger writeoffamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isprepayment")
    private Character isprepayment;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentDetailId")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGlitem cGlitemId;
    @JoinColumn(name = "fin_payment_id", referencedColumnName = "fin_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPayment finPaymentId;

    public FinPaymentDetail() {
    }

    public FinPaymentDetail(String finPaymentDetailId) {
        this.finPaymentDetailId = finPaymentDetailId;
    }

    public FinPaymentDetail(String finPaymentDetailId, Date created, String createdby, Date updated, String updatedby, BigInteger amount, Character isprepayment) {
        this.finPaymentDetailId = finPaymentDetailId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.amount = amount;
        this.isprepayment = isprepayment;
    }

    public String getFinPaymentDetailId() {
        return finPaymentDetailId;
    }

    public void setFinPaymentDetailId(String finPaymentDetailId) {
        this.finPaymentDetailId = finPaymentDetailId;
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

    public Character getRefund() {
        return refund;
    }

    public void setRefund(Character refund) {
        this.refund = refund;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public BigInteger getWriteoffamt() {
        return writeoffamt;
    }

    public void setWriteoffamt(BigInteger writeoffamt) {
        this.writeoffamt = writeoffamt;
    }

    public Character getIsprepayment() {
        return isprepayment;
    }

    public void setIsprepayment(Character isprepayment) {
        this.isprepayment = isprepayment;
    }

    @XmlTransient
    public List<FinPaymentScheduledetail> getFinPaymentScheduledetailList() {
        return finPaymentScheduledetailList;
    }

    public void setFinPaymentScheduledetailList(List<FinPaymentScheduledetail> finPaymentScheduledetailList) {
        this.finPaymentScheduledetailList = finPaymentScheduledetailList;
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

    public FinPayment getFinPaymentId() {
        return finPaymentId;
    }

    public void setFinPaymentId(FinPayment finPaymentId) {
        this.finPaymentId = finPaymentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentDetailId != null ? finPaymentDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentDetail)) {
            return false;
        }
        FinPaymentDetail other = (FinPaymentDetail) object;
        if ((this.finPaymentDetailId == null && other.finPaymentDetailId != null) || (this.finPaymentDetailId != null && !this.finPaymentDetailId.equals(other.finPaymentDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentDetail[ finPaymentDetailId=" + finPaymentDetailId + " ]";
    }
    
}
