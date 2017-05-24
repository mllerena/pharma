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
@Table(name = "c_tax_report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxReport.findAll", query = "SELECT c FROM CTaxReport c"),
    @NamedQuery(name = "CTaxReport.findByCTaxReportId", query = "SELECT c FROM CTaxReport c WHERE c.cTaxReportId = :cTaxReportId"),
    @NamedQuery(name = "CTaxReport.findByIsactive", query = "SELECT c FROM CTaxReport c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxReport.findByCreated", query = "SELECT c FROM CTaxReport c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxReport.findByCreatedby", query = "SELECT c FROM CTaxReport c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxReport.findByUpdated", query = "SELECT c FROM CTaxReport c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxReport.findByUpdatedby", query = "SELECT c FROM CTaxReport c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxReport.findByName", query = "SELECT c FROM CTaxReport c WHERE c.name = :name"),
    @NamedQuery(name = "CTaxReport.findByDescription", query = "SELECT c FROM CTaxReport c WHERE c.description = :description"),
    @NamedQuery(name = "CTaxReport.findByIsreport", query = "SELECT c FROM CTaxReport c WHERE c.isreport = :isreport"),
    @NamedQuery(name = "CTaxReport.findByIsshown", query = "SELECT c FROM CTaxReport c WHERE c.isshown = :isshown"),
    @NamedQuery(name = "CTaxReport.findByIssummary", query = "SELECT c FROM CTaxReport c WHERE c.issummary = :issummary"),
    @NamedQuery(name = "CTaxReport.findByIssotrx", query = "SELECT c FROM CTaxReport c WHERE c.issotrx = :issotrx"),
    @NamedQuery(name = "CTaxReport.findByIsnegative", query = "SELECT c FROM CTaxReport c WHERE c.isnegative = :isnegative")})
public class CTaxReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_tax_report_id")
    private String cTaxReportId;
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
    @Column(name = "isreport")
    private Character isreport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isshown")
    private Character isshown;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issummary")
    private Character issummary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issotrx")
    private Character issotrx;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isnegative")
    private Character isnegative;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;

    public CTaxReport() {
    }

    public CTaxReport(String cTaxReportId) {
        this.cTaxReportId = cTaxReportId;
    }

    public CTaxReport(String cTaxReportId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isreport, Character isshown, Character issummary, Character issotrx, Character isnegative) {
        this.cTaxReportId = cTaxReportId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isreport = isreport;
        this.isshown = isshown;
        this.issummary = issummary;
        this.issotrx = issotrx;
        this.isnegative = isnegative;
    }

    public String getCTaxReportId() {
        return cTaxReportId;
    }

    public void setCTaxReportId(String cTaxReportId) {
        this.cTaxReportId = cTaxReportId;
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

    public Character getIsreport() {
        return isreport;
    }

    public void setIsreport(Character isreport) {
        this.isreport = isreport;
    }

    public Character getIsshown() {
        return isshown;
    }

    public void setIsshown(Character isshown) {
        this.isshown = isshown;
    }

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
    }

    public Character getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(Character issotrx) {
        this.issotrx = issotrx;
    }

    public Character getIsnegative() {
        return isnegative;
    }

    public void setIsnegative(Character isnegative) {
        this.isnegative = isnegative;
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

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxReportId != null ? cTaxReportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxReport)) {
            return false;
        }
        CTaxReport other = (CTaxReport) object;
        if ((this.cTaxReportId == null && other.cTaxReportId != null) || (this.cTaxReportId != null && !this.cTaxReportId.equals(other.cTaxReportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxReport[ cTaxReportId=" + cTaxReportId + " ]";
    }
    
}
