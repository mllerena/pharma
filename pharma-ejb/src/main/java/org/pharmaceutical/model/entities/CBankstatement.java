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
@Table(name = "c_bankstatement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBankstatement.findAll", query = "SELECT c FROM CBankstatement c"),
    @NamedQuery(name = "CBankstatement.findByCBankstatementId", query = "SELECT c FROM CBankstatement c WHERE c.cBankstatementId = :cBankstatementId"),
    @NamedQuery(name = "CBankstatement.findByIsactive", query = "SELECT c FROM CBankstatement c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBankstatement.findByCreated", query = "SELECT c FROM CBankstatement c WHERE c.created = :created"),
    @NamedQuery(name = "CBankstatement.findByCreatedby", query = "SELECT c FROM CBankstatement c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBankstatement.findByUpdated", query = "SELECT c FROM CBankstatement c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBankstatement.findByUpdatedby", query = "SELECT c FROM CBankstatement c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBankstatement.findByName", query = "SELECT c FROM CBankstatement c WHERE c.name = :name"),
    @NamedQuery(name = "CBankstatement.findByDescription", query = "SELECT c FROM CBankstatement c WHERE c.description = :description"),
    @NamedQuery(name = "CBankstatement.findByIsmanual", query = "SELECT c FROM CBankstatement c WHERE c.ismanual = :ismanual"),
    @NamedQuery(name = "CBankstatement.findByStatementdate", query = "SELECT c FROM CBankstatement c WHERE c.statementdate = :statementdate"),
    @NamedQuery(name = "CBankstatement.findByBeginningbalance", query = "SELECT c FROM CBankstatement c WHERE c.beginningbalance = :beginningbalance"),
    @NamedQuery(name = "CBankstatement.findByEndingbalance", query = "SELECT c FROM CBankstatement c WHERE c.endingbalance = :endingbalance"),
    @NamedQuery(name = "CBankstatement.findByStatementdifference", query = "SELECT c FROM CBankstatement c WHERE c.statementdifference = :statementdifference"),
    @NamedQuery(name = "CBankstatement.findByCreatefrom", query = "SELECT c FROM CBankstatement c WHERE c.createfrom = :createfrom"),
    @NamedQuery(name = "CBankstatement.findByProcessing", query = "SELECT c FROM CBankstatement c WHERE c.processing = :processing"),
    @NamedQuery(name = "CBankstatement.findByProcessed", query = "SELECT c FROM CBankstatement c WHERE c.processed = :processed"),
    @NamedQuery(name = "CBankstatement.findByPosted", query = "SELECT c FROM CBankstatement c WHERE c.posted = :posted")})
public class CBankstatement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bankstatement_id")
    private String cBankstatementId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ismanual")
    private Character ismanual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statementdate;
    @Column(name = "beginningbalance")
    private BigInteger beginningbalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endingbalance")
    private BigInteger endingbalance;
    @Column(name = "statementdifference")
    private BigInteger statementdifference;
    @Column(name = "createfrom")
    private Character createfrom;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBankstatementId")
    private List<IBankstatement> iBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBankstatementId")
    private List<CBankstatementline> cBankstatementlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBankaccount cBankaccountId;

    public CBankstatement() {
    }

    public CBankstatement(String cBankstatementId) {
        this.cBankstatementId = cBankstatementId;
    }

    public CBankstatement(String cBankstatementId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character ismanual, Date statementdate, BigInteger endingbalance, String processed, String posted) {
        this.cBankstatementId = cBankstatementId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.ismanual = ismanual;
        this.statementdate = statementdate;
        this.endingbalance = endingbalance;
        this.processed = processed;
        this.posted = posted;
    }

    public String getCBankstatementId() {
        return cBankstatementId;
    }

    public void setCBankstatementId(String cBankstatementId) {
        this.cBankstatementId = cBankstatementId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIsmanual() {
        return ismanual;
    }

    public void setIsmanual(Character ismanual) {
        this.ismanual = ismanual;
    }

    public Date getStatementdate() {
        return statementdate;
    }

    public void setStatementdate(Date statementdate) {
        this.statementdate = statementdate;
    }

    public BigInteger getBeginningbalance() {
        return beginningbalance;
    }

    public void setBeginningbalance(BigInteger beginningbalance) {
        this.beginningbalance = beginningbalance;
    }

    public BigInteger getEndingbalance() {
        return endingbalance;
    }

    public void setEndingbalance(BigInteger endingbalance) {
        this.endingbalance = endingbalance;
    }

    public BigInteger getStatementdifference() {
        return statementdifference;
    }

    public void setStatementdifference(BigInteger statementdifference) {
        this.statementdifference = statementdifference;
    }

    public Character getCreatefrom() {
        return createfrom;
    }

    public void setCreatefrom(Character createfrom) {
        this.createfrom = createfrom;
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

    @XmlTransient
    public List<IBankstatement> getIBankstatementList() {
        return iBankstatementList;
    }

    public void setIBankstatementList(List<IBankstatement> iBankstatementList) {
        this.iBankstatementList = iBankstatementList;
    }

    @XmlTransient
    public List<CBankstatementline> getCBankstatementlineList() {
        return cBankstatementlineList;
    }

    public void setCBankstatementlineList(List<CBankstatementline> cBankstatementlineList) {
        this.cBankstatementlineList = cBankstatementlineList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBankstatementId != null ? cBankstatementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBankstatement)) {
            return false;
        }
        CBankstatement other = (CBankstatement) object;
        if ((this.cBankstatementId == null && other.cBankstatementId != null) || (this.cBankstatementId != null && !this.cBankstatementId.equals(other.cBankstatementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBankstatement[ cBankstatementId=" + cBankstatementId + " ]";
    }
    
}
