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
@Table(name = "c_commissionrun")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCommissionrun.findAll", query = "SELECT c FROM CCommissionrun c"),
    @NamedQuery(name = "CCommissionrun.findByCCommissionrunId", query = "SELECT c FROM CCommissionrun c WHERE c.cCommissionrunId = :cCommissionrunId"),
    @NamedQuery(name = "CCommissionrun.findByIsactive", query = "SELECT c FROM CCommissionrun c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCommissionrun.findByCreated", query = "SELECT c FROM CCommissionrun c WHERE c.created = :created"),
    @NamedQuery(name = "CCommissionrun.findByCreatedby", query = "SELECT c FROM CCommissionrun c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCommissionrun.findByUpdated", query = "SELECT c FROM CCommissionrun c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCommissionrun.findByUpdatedby", query = "SELECT c FROM CCommissionrun c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCommissionrun.findByDocumentno", query = "SELECT c FROM CCommissionrun c WHERE c.documentno = :documentno"),
    @NamedQuery(name = "CCommissionrun.findByDescription", query = "SELECT c FROM CCommissionrun c WHERE c.description = :description"),
    @NamedQuery(name = "CCommissionrun.findByStartdate", query = "SELECT c FROM CCommissionrun c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "CCommissionrun.findByGrandtotal", query = "SELECT c FROM CCommissionrun c WHERE c.grandtotal = :grandtotal"),
    @NamedQuery(name = "CCommissionrun.findByProcessing", query = "SELECT c FROM CCommissionrun c WHERE c.processing = :processing"),
    @NamedQuery(name = "CCommissionrun.findByProcessed", query = "SELECT c FROM CCommissionrun c WHERE c.processed = :processed")})
public class CCommissionrun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_commissionrun_id")
    private String cCommissionrunId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grandtotal")
    private BigInteger grandtotal;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_commission_id", referencedColumnName = "c_commission_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCommission cCommissionId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCommissionrunId")
    private List<CCommissionamt> cCommissionamtList;

    public CCommissionrun() {
    }

    public CCommissionrun(String cCommissionrunId) {
        this.cCommissionrunId = cCommissionrunId;
    }

    public CCommissionrun(String cCommissionrunId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, Date startdate, BigInteger grandtotal, Character processed) {
        this.cCommissionrunId = cCommissionrunId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.startdate = startdate;
        this.grandtotal = grandtotal;
        this.processed = processed;
    }

    public String getCCommissionrunId() {
        return cCommissionrunId;
    }

    public void setCCommissionrunId(String cCommissionrunId) {
        this.cCommissionrunId = cCommissionrunId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public BigInteger getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(BigInteger grandtotal) {
        this.grandtotal = grandtotal;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
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

    public CCommission getCCommissionId() {
        return cCommissionId;
    }

    public void setCCommissionId(CCommission cCommissionId) {
        this.cCommissionId = cCommissionId;
    }

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    @XmlTransient
    public List<CCommissionamt> getCCommissionamtList() {
        return cCommissionamtList;
    }

    public void setCCommissionamtList(List<CCommissionamt> cCommissionamtList) {
        this.cCommissionamtList = cCommissionamtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCommissionrunId != null ? cCommissionrunId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCommissionrun)) {
            return false;
        }
        CCommissionrun other = (CCommissionrun) object;
        if ((this.cCommissionrunId == null && other.cCommissionrunId != null) || (this.cCommissionrunId != null && !this.cCommissionrunId.equals(other.cCommissionrunId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCommissionrun[ cCommissionrunId=" + cCommissionrunId + " ]";
    }
    
}
