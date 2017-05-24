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
@Table(name = "c_settlement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CSettlement.findAll", query = "SELECT c FROM CSettlement c"),
    @NamedQuery(name = "CSettlement.findByCSettlementId", query = "SELECT c FROM CSettlement c WHERE c.cSettlementId = :cSettlementId"),
    @NamedQuery(name = "CSettlement.findByIsactive", query = "SELECT c FROM CSettlement c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CSettlement.findByCreated", query = "SELECT c FROM CSettlement c WHERE c.created = :created"),
    @NamedQuery(name = "CSettlement.findByCreatedby", query = "SELECT c FROM CSettlement c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CSettlement.findByUpdated", query = "SELECT c FROM CSettlement c WHERE c.updated = :updated"),
    @NamedQuery(name = "CSettlement.findByUpdatedby", query = "SELECT c FROM CSettlement c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CSettlement.findByDocumentno", query = "SELECT c FROM CSettlement c WHERE c.documentno = :documentno"),
    @NamedQuery(name = "CSettlement.findByDatetrx", query = "SELECT c FROM CSettlement c WHERE c.datetrx = :datetrx"),
    @NamedQuery(name = "CSettlement.findByProcessing", query = "SELECT c FROM CSettlement c WHERE c.processing = :processing"),
    @NamedQuery(name = "CSettlement.findByProcessed", query = "SELECT c FROM CSettlement c WHERE c.processed = :processed"),
    @NamedQuery(name = "CSettlement.findByPosted", query = "SELECT c FROM CSettlement c WHERE c.posted = :posted"),
    @NamedQuery(name = "CSettlement.findByUser1Id", query = "SELECT c FROM CSettlement c WHERE c.user1Id = :user1Id"),
    @NamedQuery(name = "CSettlement.findByUser2Id", query = "SELECT c FROM CSettlement c WHERE c.user2Id = :user2Id"),
    @NamedQuery(name = "CSettlement.findByCreatefrom", query = "SELECT c FROM CSettlement c WHERE c.createfrom = :createfrom"),
    @NamedQuery(name = "CSettlement.findByCancelednotchargeamt", query = "SELECT c FROM CSettlement c WHERE c.cancelednotchargeamt = :cancelednotchargeamt"),
    @NamedQuery(name = "CSettlement.findByGeneratedamt", query = "SELECT c FROM CSettlement c WHERE c.generatedamt = :generatedamt"),
    @NamedQuery(name = "CSettlement.findByChargedamt", query = "SELECT c FROM CSettlement c WHERE c.chargedamt = :chargedamt"),
    @NamedQuery(name = "CSettlement.findByDescription", query = "SELECT c FROM CSettlement c WHERE c.description = :description"),
    @NamedQuery(name = "CSettlement.findByCreatefile", query = "SELECT c FROM CSettlement c WHERE c.createfile = :createfile"),
    @NamedQuery(name = "CSettlement.findByDateacct", query = "SELECT c FROM CSettlement c WHERE c.dateacct = :dateacct"),
    @NamedQuery(name = "CSettlement.findBySettlementtype", query = "SELECT c FROM CSettlement c WHERE c.settlementtype = :settlementtype"),
    @NamedQuery(name = "CSettlement.findBySettlementopen", query = "SELECT c FROM CSettlement c WHERE c.settlementopen = :settlementopen"),
    @NamedQuery(name = "CSettlement.findByCopyfrom", query = "SELECT c FROM CSettlement c WHERE c.copyfrom = :copyfrom"),
    @NamedQuery(name = "CSettlement.findByIsgenerated", query = "SELECT c FROM CSettlement c WHERE c.isgenerated = :isgenerated"),
    @NamedQuery(name = "CSettlement.findByIstemplate", query = "SELECT c FROM CSettlement c WHERE c.istemplate = :istemplate")})
public class CSettlement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_settlement_id")
    private String cSettlementId;
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
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetrx")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetrx;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "processed")
    private String processed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Column(name = "createfrom")
    private Character createfrom;
    @Column(name = "cancelednotchargeamt")
    private BigInteger cancelednotchargeamt;
    @Column(name = "generatedamt")
    private BigInteger generatedamt;
    @Column(name = "chargedamt")
    private BigInteger chargedamt;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createfile")
    private Character createfile;
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Size(max = 60)
    @Column(name = "settlementtype")
    private String settlementtype;
    @Column(name = "settlementopen")
    private Character settlementopen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "copyfrom")
    private Character copyfrom;
    @Column(name = "isgenerated")
    private Character isgenerated;
    @Column(name = "istemplate")
    private Character istemplate;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cSettlementId")
    private List<CRemittance> cRemittanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cSettlementId")
    private List<CTaxpayment> cTaxpaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cSettlementCancelId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cSettlementGenerateId")
    private List<CDebtPayment> cDebtPaymentList1;

    public CSettlement() {
    }

    public CSettlement(String cSettlementId) {
        this.cSettlementId = cSettlementId;
    }

    public CSettlement(String cSettlementId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, Date datetrx, String processed, String posted, Character createfile, Character copyfrom) {
        this.cSettlementId = cSettlementId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.datetrx = datetrx;
        this.processed = processed;
        this.posted = posted;
        this.createfile = createfile;
        this.copyfrom = copyfrom;
    }

    public String getCSettlementId() {
        return cSettlementId;
    }

    public void setCSettlementId(String cSettlementId) {
        this.cSettlementId = cSettlementId;
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

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Date getDatetrx() {
        return datetrx;
    }

    public void setDatetrx(Date datetrx) {
        this.datetrx = datetrx;
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

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public Character getCreatefrom() {
        return createfrom;
    }

    public void setCreatefrom(Character createfrom) {
        this.createfrom = createfrom;
    }

    public BigInteger getCancelednotchargeamt() {
        return cancelednotchargeamt;
    }

    public void setCancelednotchargeamt(BigInteger cancelednotchargeamt) {
        this.cancelednotchargeamt = cancelednotchargeamt;
    }

    public BigInteger getGeneratedamt() {
        return generatedamt;
    }

    public void setGeneratedamt(BigInteger generatedamt) {
        this.generatedamt = generatedamt;
    }

    public BigInteger getChargedamt() {
        return chargedamt;
    }

    public void setChargedamt(BigInteger chargedamt) {
        this.chargedamt = chargedamt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getCreatefile() {
        return createfile;
    }

    public void setCreatefile(Character createfile) {
        this.createfile = createfile;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public String getSettlementtype() {
        return settlementtype;
    }

    public void setSettlementtype(String settlementtype) {
        this.settlementtype = settlementtype;
    }

    public Character getSettlementopen() {
        return settlementopen;
    }

    public void setSettlementopen(Character settlementopen) {
        this.settlementopen = settlementopen;
    }

    public Character getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(Character copyfrom) {
        this.copyfrom = copyfrom;
    }

    public Character getIsgenerated() {
        return isgenerated;
    }

    public void setIsgenerated(Character isgenerated) {
        this.isgenerated = isgenerated;
    }

    public Character getIstemplate() {
        return istemplate;
    }

    public void setIstemplate(Character istemplate) {
        this.istemplate = istemplate;
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

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @XmlTransient
    public List<CRemittance> getCRemittanceList() {
        return cRemittanceList;
    }

    public void setCRemittanceList(List<CRemittance> cRemittanceList) {
        this.cRemittanceList = cRemittanceList;
    }

    @XmlTransient
    public List<CTaxpayment> getCTaxpaymentList() {
        return cTaxpaymentList;
    }

    public void setCTaxpaymentList(List<CTaxpayment> cTaxpaymentList) {
        this.cTaxpaymentList = cTaxpaymentList;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList() {
        return cDebtPaymentList;
    }

    public void setCDebtPaymentList(List<CDebtPayment> cDebtPaymentList) {
        this.cDebtPaymentList = cDebtPaymentList;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList1() {
        return cDebtPaymentList1;
    }

    public void setCDebtPaymentList1(List<CDebtPayment> cDebtPaymentList1) {
        this.cDebtPaymentList1 = cDebtPaymentList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cSettlementId != null ? cSettlementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CSettlement)) {
            return false;
        }
        CSettlement other = (CSettlement) object;
        if ((this.cSettlementId == null && other.cSettlementId != null) || (this.cSettlementId != null && !this.cSettlementId.equals(other.cSettlementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CSettlement[ cSettlementId=" + cSettlementId + " ]";
    }
    
}
