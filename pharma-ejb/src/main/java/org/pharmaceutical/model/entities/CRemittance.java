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
@Table(name = "c_remittance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRemittance.findAll", query = "SELECT c FROM CRemittance c"),
    @NamedQuery(name = "CRemittance.findByCRemittanceId", query = "SELECT c FROM CRemittance c WHERE c.cRemittanceId = :cRemittanceId"),
    @NamedQuery(name = "CRemittance.findByIsactive", query = "SELECT c FROM CRemittance c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CRemittance.findByCreated", query = "SELECT c FROM CRemittance c WHERE c.created = :created"),
    @NamedQuery(name = "CRemittance.findByCreatedby", query = "SELECT c FROM CRemittance c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CRemittance.findByUpdated", query = "SELECT c FROM CRemittance c WHERE c.updated = :updated"),
    @NamedQuery(name = "CRemittance.findByUpdatedby", query = "SELECT c FROM CRemittance c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CRemittance.findByName", query = "SELECT c FROM CRemittance c WHERE c.name = :name"),
    @NamedQuery(name = "CRemittance.findByCreatefrom", query = "SELECT c FROM CRemittance c WHERE c.createfrom = :createfrom"),
    @NamedQuery(name = "CRemittance.findByDatetrx", query = "SELECT c FROM CRemittance c WHERE c.datetrx = :datetrx"),
    @NamedQuery(name = "CRemittance.findByDocumentno", query = "SELECT c FROM CRemittance c WHERE c.documentno = :documentno"),
    @NamedQuery(name = "CRemittance.findByDuedate", query = "SELECT c FROM CRemittance c WHERE c.duedate = :duedate"),
    @NamedQuery(name = "CRemittance.findByGetfile", query = "SELECT c FROM CRemittance c WHERE c.getfile = :getfile"),
    @NamedQuery(name = "CRemittance.findByProcessed", query = "SELECT c FROM CRemittance c WHERE c.processed = :processed"),
    @NamedQuery(name = "CRemittance.findByProcessing", query = "SELECT c FROM CRemittance c WHERE c.processing = :processing")})
public class CRemittance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_remittance_id")
    private String cRemittanceId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Column(name = "createfrom")
    private Character createfrom;
    @Column(name = "datetrx")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetrx;
    @Size(max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Column(name = "duedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @Column(name = "getfile")
    private Character getfile;
    @Size(max = 60)
    @Column(name = "processed")
    private String processed;
    @Column(name = "processing")
    private Character processing;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankaccount cBankaccountId;
    @JoinColumn(name = "c_dp_management_id", referencedColumnName = "c_dp_management_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDpManagement cDpManagementId;
    @JoinColumn(name = "c_remittance_type_id", referencedColumnName = "c_remittance_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRemittanceType cRemittanceTypeId;
    @JoinColumn(name = "c_settlement_id", referencedColumnName = "c_settlement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSettlement cSettlementId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cRemittanceId")
    private List<CRemittanceline> cRemittancelineList;

    public CRemittance() {
    }

    public CRemittance(String cRemittanceId) {
        this.cRemittanceId = cRemittanceId;
    }

    public CRemittance(String cRemittanceId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cRemittanceId = cRemittanceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCRemittanceId() {
        return cRemittanceId;
    }

    public void setCRemittanceId(String cRemittanceId) {
        this.cRemittanceId = cRemittanceId;
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

    public Date getDatetrx() {
        return datetrx;
    }

    public void setDatetrx(Date datetrx) {
        this.datetrx = datetrx;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Character getGetfile() {
        return getfile;
    }

    public void setGetfile(Character getfile) {
        this.getfile = getfile;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
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

    public CBankaccount getCBankaccountId() {
        return cBankaccountId;
    }

    public void setCBankaccountId(CBankaccount cBankaccountId) {
        this.cBankaccountId = cBankaccountId;
    }

    public CDpManagement getCDpManagementId() {
        return cDpManagementId;
    }

    public void setCDpManagementId(CDpManagement cDpManagementId) {
        this.cDpManagementId = cDpManagementId;
    }

    public CRemittanceType getCRemittanceTypeId() {
        return cRemittanceTypeId;
    }

    public void setCRemittanceTypeId(CRemittanceType cRemittanceTypeId) {
        this.cRemittanceTypeId = cRemittanceTypeId;
    }

    public CSettlement getCSettlementId() {
        return cSettlementId;
    }

    public void setCSettlementId(CSettlement cSettlementId) {
        this.cSettlementId = cSettlementId;
    }

    @XmlTransient
    public List<CRemittanceline> getCRemittancelineList() {
        return cRemittancelineList;
    }

    public void setCRemittancelineList(List<CRemittanceline> cRemittancelineList) {
        this.cRemittancelineList = cRemittancelineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRemittanceId != null ? cRemittanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRemittance)) {
            return false;
        }
        CRemittance other = (CRemittance) object;
        if ((this.cRemittanceId == null && other.cRemittanceId != null) || (this.cRemittanceId != null && !this.cRemittanceId.equals(other.cRemittanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CRemittance[ cRemittanceId=" + cRemittanceId + " ]";
    }
    
}
