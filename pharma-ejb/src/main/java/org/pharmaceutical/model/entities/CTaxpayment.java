/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "c_taxpayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxpayment.findAll", query = "SELECT c FROM CTaxpayment c"),
    @NamedQuery(name = "CTaxpayment.findByIsactive", query = "SELECT c FROM CTaxpayment c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxpayment.findByCreated", query = "SELECT c FROM CTaxpayment c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxpayment.findByCreatedby", query = "SELECT c FROM CTaxpayment c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxpayment.findByUpdated", query = "SELECT c FROM CTaxpayment c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxpayment.findByUpdatedby", query = "SELECT c FROM CTaxpayment c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxpayment.findByCTaxpaymentId", query = "SELECT c FROM CTaxpayment c WHERE c.cTaxpaymentId = :cTaxpaymentId"),
    @NamedQuery(name = "CTaxpayment.findByDatefrom", query = "SELECT c FROM CTaxpayment c WHERE c.datefrom = :datefrom"),
    @NamedQuery(name = "CTaxpayment.findByDateto", query = "SELECT c FROM CTaxpayment c WHERE c.dateto = :dateto"),
    @NamedQuery(name = "CTaxpayment.findByGeneratepayment", query = "SELECT c FROM CTaxpayment c WHERE c.generatepayment = :generatepayment"),
    @NamedQuery(name = "CTaxpayment.findByProcessing", query = "SELECT c FROM CTaxpayment c WHERE c.processing = :processing"),
    @NamedQuery(name = "CTaxpayment.findByProcessed", query = "SELECT c FROM CTaxpayment c WHERE c.processed = :processed"),
    @NamedQuery(name = "CTaxpayment.findByName", query = "SELECT c FROM CTaxpayment c WHERE c.name = :name"),
    @NamedQuery(name = "CTaxpayment.findByCreatefrom", query = "SELECT c FROM CTaxpayment c WHERE c.createfrom = :createfrom")})
public class CTaxpayment implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_taxpayment_id")
    private String cTaxpaymentId;
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Column(name = "generatepayment")
    private Character generatepayment;
    @Column(name = "processing")
    private Character processing;
    @Size(max = 60)
    @Column(name = "processed")
    private String processed;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Column(name = "createfrom")
    private Character createfrom;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxpaymentId")
    private List<CTaxregister> cTaxregisterList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_settlement_id", referencedColumnName = "c_settlement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSettlement cSettlementId;
    @JoinColumn(name = "fin_payment_id", referencedColumnName = "fin_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPayment finPaymentId;
    @JoinColumn(name = "gl_journal_id", referencedColumnName = "gl_journal_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private GlJournal glJournalId;

    public CTaxpayment() {
    }

    public CTaxpayment(String cTaxpaymentId) {
        this.cTaxpaymentId = cTaxpaymentId;
    }

    public CTaxpayment(String cTaxpaymentId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cTaxpaymentId = cTaxpaymentId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
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

    public String getCTaxpaymentId() {
        return cTaxpaymentId;
    }

    public void setCTaxpaymentId(String cTaxpaymentId) {
        this.cTaxpaymentId = cTaxpaymentId;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public Character getGeneratepayment() {
        return generatepayment;
    }

    public void setGeneratepayment(Character generatepayment) {
        this.generatepayment = generatepayment;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCreatefrom() {
        return createfrom;
    }

    public void setCreatefrom(Character createfrom) {
        this.createfrom = createfrom;
    }

    @XmlTransient
    public List<CTaxregister> getCTaxregisterList() {
        return cTaxregisterList;
    }

    public void setCTaxregisterList(List<CTaxregister> cTaxregisterList) {
        this.cTaxregisterList = cTaxregisterList;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CSettlement getCSettlementId() {
        return cSettlementId;
    }

    public void setCSettlementId(CSettlement cSettlementId) {
        this.cSettlementId = cSettlementId;
    }

    public FinPayment getFinPaymentId() {
        return finPaymentId;
    }

    public void setFinPaymentId(FinPayment finPaymentId) {
        this.finPaymentId = finPaymentId;
    }

    public GlJournal getGlJournalId() {
        return glJournalId;
    }

    public void setGlJournalId(GlJournal glJournalId) {
        this.glJournalId = glJournalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxpaymentId != null ? cTaxpaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxpayment)) {
            return false;
        }
        CTaxpayment other = (CTaxpayment) object;
        if ((this.cTaxpaymentId == null && other.cTaxpaymentId != null) || (this.cTaxpaymentId != null && !this.cTaxpaymentId.equals(other.cTaxpaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxpayment[ cTaxpaymentId=" + cTaxpaymentId + " ]";
    }
    
}
