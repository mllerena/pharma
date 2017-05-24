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
@Table(name = "c_cashbook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCashbook.findAll", query = "SELECT c FROM CCashbook c"),
    @NamedQuery(name = "CCashbook.findByCCashbookId", query = "SELECT c FROM CCashbook c WHERE c.cCashbookId = :cCashbookId"),
    @NamedQuery(name = "CCashbook.findByIsactive", query = "SELECT c FROM CCashbook c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCashbook.findByCreated", query = "SELECT c FROM CCashbook c WHERE c.created = :created"),
    @NamedQuery(name = "CCashbook.findByCreatedby", query = "SELECT c FROM CCashbook c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCashbook.findByUpdated", query = "SELECT c FROM CCashbook c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCashbook.findByUpdatedby", query = "SELECT c FROM CCashbook c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCashbook.findByName", query = "SELECT c FROM CCashbook c WHERE c.name = :name"),
    @NamedQuery(name = "CCashbook.findByDescription", query = "SELECT c FROM CCashbook c WHERE c.description = :description"),
    @NamedQuery(name = "CCashbook.findByIsdefault", query = "SELECT c FROM CCashbook c WHERE c.isdefault = :isdefault")})
public class CCashbook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_cashbook_id")
    private String cCashbookId;
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
    @Column(name = "isdefault")
    private Character isdefault;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCashbookId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCashbookId")
    private List<CCashbookAcct> cCashbookAcctList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCashbookId")
    private List<CCash> cCashList;

    public CCashbook() {
    }

    public CCashbook(String cCashbookId) {
        this.cCashbookId = cCashbookId;
    }

    public CCashbook(String cCashbookId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isdefault) {
        this.cCashbookId = cCashbookId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isdefault = isdefault;
    }

    public String getCCashbookId() {
        return cCashbookId;
    }

    public void setCCashbookId(String cCashbookId) {
        this.cCashbookId = cCashbookId;
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

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList() {
        return cDebtPaymentList;
    }

    public void setCDebtPaymentList(List<CDebtPayment> cDebtPaymentList) {
        this.cDebtPaymentList = cDebtPaymentList;
    }

    @XmlTransient
    public List<CCashbookAcct> getCCashbookAcctList() {
        return cCashbookAcctList;
    }

    public void setCCashbookAcctList(List<CCashbookAcct> cCashbookAcctList) {
        this.cCashbookAcctList = cCashbookAcctList;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @XmlTransient
    public List<CCash> getCCashList() {
        return cCashList;
    }

    public void setCCashList(List<CCash> cCashList) {
        this.cCashList = cCashList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCashbookId != null ? cCashbookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCashbook)) {
            return false;
        }
        CCashbook other = (CCashbook) object;
        if ((this.cCashbookId == null && other.cCashbookId != null) || (this.cCashbookId != null && !this.cCashbookId.equals(other.cCashbookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCashbook[ cCashbookId=" + cCashbookId + " ]";
    }
    
}
