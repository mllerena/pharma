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
@Table(name = "ad_accountingrpt_element")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdAccountingrptElement.findAll", query = "SELECT a FROM AdAccountingrptElement a"),
    @NamedQuery(name = "AdAccountingrptElement.findByAdAccountingrptElementId", query = "SELECT a FROM AdAccountingrptElement a WHERE a.adAccountingrptElementId = :adAccountingrptElementId"),
    @NamedQuery(name = "AdAccountingrptElement.findByUpdated", query = "SELECT a FROM AdAccountingrptElement a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdAccountingrptElement.findByUpdatedby", query = "SELECT a FROM AdAccountingrptElement a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdAccountingrptElement.findByCreated", query = "SELECT a FROM AdAccountingrptElement a WHERE a.created = :created"),
    @NamedQuery(name = "AdAccountingrptElement.findByCreatedby", query = "SELECT a FROM AdAccountingrptElement a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdAccountingrptElement.findByIsactive", query = "SELECT a FROM AdAccountingrptElement a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdAccountingrptElement.findByName", query = "SELECT a FROM AdAccountingrptElement a WHERE a.name = :name"),
    @NamedQuery(name = "AdAccountingrptElement.findByDescription", query = "SELECT a FROM AdAccountingrptElement a WHERE a.description = :description"),
    @NamedQuery(name = "AdAccountingrptElement.findByIssummary", query = "SELECT a FROM AdAccountingrptElement a WHERE a.issummary = :issummary"),
    @NamedQuery(name = "AdAccountingrptElement.findByIsshown", query = "SELECT a FROM AdAccountingrptElement a WHERE a.isshown = :isshown"),
    @NamedQuery(name = "AdAccountingrptElement.findByFilteredbyorganization", query = "SELECT a FROM AdAccountingrptElement a WHERE a.filteredbyorganization = :filteredbyorganization"),
    @NamedQuery(name = "AdAccountingrptElement.findByTemporaryfiltertype", query = "SELECT a FROM AdAccountingrptElement a WHERE a.temporaryfiltertype = :temporaryfiltertype"),
    @NamedQuery(name = "AdAccountingrptElement.findByIsreport", query = "SELECT a FROM AdAccountingrptElement a WHERE a.isreport = :isreport"),
    @NamedQuery(name = "AdAccountingrptElement.findByReportType", query = "SELECT a FROM AdAccountingrptElement a WHERE a.reportType = :reportType"),
    @NamedQuery(name = "AdAccountingrptElement.findByIsinitialbalance", query = "SELECT a FROM AdAccountingrptElement a WHERE a.isinitialbalance = :isinitialbalance")})
public class AdAccountingrptElement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_accountingrpt_element_id")
    private String adAccountingrptElementId;
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
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "isactive")
    private Character isactive;
    @Size(max = 510)
    @Column(name = "name")
    private String name;
    @Size(max = 510)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issummary")
    private Character issummary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isshown")
    private Character isshown;
    @Column(name = "filteredbyorganization")
    private Character filteredbyorganization;
    @Size(max = 60)
    @Column(name = "temporaryfiltertype")
    private String temporaryfiltertype;
    @Column(name = "isreport")
    private Character isreport;
    @Size(max = 60)
    @Column(name = "report_type")
    private String reportType;
    @Column(name = "isinitialbalance")
    private Character isinitialbalance;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "account_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CElementvalue accountId;

    public AdAccountingrptElement() {
    }

    public AdAccountingrptElement(String adAccountingrptElementId) {
        this.adAccountingrptElementId = adAccountingrptElementId;
    }

    public AdAccountingrptElement(String adAccountingrptElementId, Date updated, String updatedby, Date created, String createdby, Character issummary, Character isshown) {
        this.adAccountingrptElementId = adAccountingrptElementId;
        this.updated = updated;
        this.updatedby = updatedby;
        this.created = created;
        this.createdby = createdby;
        this.issummary = issummary;
        this.isshown = isshown;
    }

    public String getAdAccountingrptElementId() {
        return adAccountingrptElementId;
    }

    public void setAdAccountingrptElementId(String adAccountingrptElementId) {
        this.adAccountingrptElementId = adAccountingrptElementId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
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

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
    }

    public Character getIsshown() {
        return isshown;
    }

    public void setIsshown(Character isshown) {
        this.isshown = isshown;
    }

    public Character getFilteredbyorganization() {
        return filteredbyorganization;
    }

    public void setFilteredbyorganization(Character filteredbyorganization) {
        this.filteredbyorganization = filteredbyorganization;
    }

    public String getTemporaryfiltertype() {
        return temporaryfiltertype;
    }

    public void setTemporaryfiltertype(String temporaryfiltertype) {
        this.temporaryfiltertype = temporaryfiltertype;
    }

    public Character getIsreport() {
        return isreport;
    }

    public void setIsreport(Character isreport) {
        this.isreport = isreport;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Character getIsinitialbalance() {
        return isinitialbalance;
    }

    public void setIsinitialbalance(Character isinitialbalance) {
        this.isinitialbalance = isinitialbalance;
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

    public CElementvalue getAccountId() {
        return accountId;
    }

    public void setAccountId(CElementvalue accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adAccountingrptElementId != null ? adAccountingrptElementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdAccountingrptElement)) {
            return false;
        }
        AdAccountingrptElement other = (AdAccountingrptElement) object;
        if ((this.adAccountingrptElementId == null && other.adAccountingrptElementId != null) || (this.adAccountingrptElementId != null && !this.adAccountingrptElementId.equals(other.adAccountingrptElementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdAccountingrptElement[ adAccountingrptElementId=" + adAccountingrptElementId + " ]";
    }
    
}
