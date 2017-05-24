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
@Table(name = "c_period")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPeriod.findAll", query = "SELECT c FROM CPeriod c"),
    @NamedQuery(name = "CPeriod.findByCPeriodId", query = "SELECT c FROM CPeriod c WHERE c.cPeriodId = :cPeriodId"),
    @NamedQuery(name = "CPeriod.findByIsactive", query = "SELECT c FROM CPeriod c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPeriod.findByCreated", query = "SELECT c FROM CPeriod c WHERE c.created = :created"),
    @NamedQuery(name = "CPeriod.findByCreatedby", query = "SELECT c FROM CPeriod c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPeriod.findByUpdated", query = "SELECT c FROM CPeriod c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPeriod.findByUpdatedby", query = "SELECT c FROM CPeriod c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPeriod.findByName", query = "SELECT c FROM CPeriod c WHERE c.name = :name"),
    @NamedQuery(name = "CPeriod.findByPeriodno", query = "SELECT c FROM CPeriod c WHERE c.periodno = :periodno"),
    @NamedQuery(name = "CPeriod.findByStartdate", query = "SELECT c FROM CPeriod c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "CPeriod.findByEnddate", query = "SELECT c FROM CPeriod c WHERE c.enddate = :enddate"),
    @NamedQuery(name = "CPeriod.findByPeriodtype", query = "SELECT c FROM CPeriod c WHERE c.periodtype = :periodtype"),
    @NamedQuery(name = "CPeriod.findByProcessing", query = "SELECT c FROM CPeriod c WHERE c.processing = :processing"),
    @NamedQuery(name = "CPeriod.findByCloseFactAcctGroupId", query = "SELECT c FROM CPeriod c WHERE c.closeFactAcctGroupId = :closeFactAcctGroupId"),
    @NamedQuery(name = "CPeriod.findByRegFactAcctGroupId", query = "SELECT c FROM CPeriod c WHERE c.regFactAcctGroupId = :regFactAcctGroupId"),
    @NamedQuery(name = "CPeriod.findByDivideupFactAcctGroupId", query = "SELECT c FROM CPeriod c WHERE c.divideupFactAcctGroupId = :divideupFactAcctGroupId"),
    @NamedQuery(name = "CPeriod.findByOpenFactAcctGroupId", query = "SELECT c FROM CPeriod c WHERE c.openFactAcctGroupId = :openFactAcctGroupId")})
public class CPeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_period_id")
    private String cPeriodId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodno")
    private long periodno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "periodtype")
    private String periodtype;
    @Column(name = "processing")
    private Character processing;
    @Size(max = 32)
    @Column(name = "close_fact_acct_group_id")
    private String closeFactAcctGroupId;
    @Size(max = 32)
    @Column(name = "reg_fact_acct_group_id")
    private String regFactAcctGroupId;
    @Size(max = 32)
    @Column(name = "divideup_fact_acct_group_id")
    private String divideupFactAcctGroupId;
    @Size(max = 32)
    @Column(name = "open_fact_acct_group_id")
    private String openFactAcctGroupId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cPeriodId")
    private List<CPeriodcontrol> cPeriodcontrolList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPeriodId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPeriodId")
    private List<GlJournalbatch> glJournalbatchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "periodno")
    private List<CPeriodcontrolLog> cPeriodcontrolLogList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPeriodId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPeriodId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPeriodId")
    private List<CBudgetline> cBudgetlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_year_id", referencedColumnName = "c_year_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CYear cYearId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cPeriodId")
    private List<GlJournal> glJournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPeriodId")
    private List<CAcctschema> cAcctschemaList;

    public CPeriod() {
    }

    public CPeriod(String cPeriodId) {
        this.cPeriodId = cPeriodId;
    }

    public CPeriod(String cPeriodId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, long periodno, Date startdate, String periodtype) {
        this.cPeriodId = cPeriodId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.periodno = periodno;
        this.startdate = startdate;
        this.periodtype = periodtype;
    }

    public String getCPeriodId() {
        return cPeriodId;
    }

    public void setCPeriodId(String cPeriodId) {
        this.cPeriodId = cPeriodId;
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

    public long getPeriodno() {
        return periodno;
    }

    public void setPeriodno(long periodno) {
        this.periodno = periodno;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getPeriodtype() {
        return periodtype;
    }

    public void setPeriodtype(String periodtype) {
        this.periodtype = periodtype;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public String getCloseFactAcctGroupId() {
        return closeFactAcctGroupId;
    }

    public void setCloseFactAcctGroupId(String closeFactAcctGroupId) {
        this.closeFactAcctGroupId = closeFactAcctGroupId;
    }

    public String getRegFactAcctGroupId() {
        return regFactAcctGroupId;
    }

    public void setRegFactAcctGroupId(String regFactAcctGroupId) {
        this.regFactAcctGroupId = regFactAcctGroupId;
    }

    public String getDivideupFactAcctGroupId() {
        return divideupFactAcctGroupId;
    }

    public void setDivideupFactAcctGroupId(String divideupFactAcctGroupId) {
        this.divideupFactAcctGroupId = divideupFactAcctGroupId;
    }

    public String getOpenFactAcctGroupId() {
        return openFactAcctGroupId;
    }

    public void setOpenFactAcctGroupId(String openFactAcctGroupId) {
        this.openFactAcctGroupId = openFactAcctGroupId;
    }

    @XmlTransient
    public List<CPeriodcontrol> getCPeriodcontrolList() {
        return cPeriodcontrolList;
    }

    public void setCPeriodcontrolList(List<CPeriodcontrol> cPeriodcontrolList) {
        this.cPeriodcontrolList = cPeriodcontrolList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<GlJournalbatch> getGlJournalbatchList() {
        return glJournalbatchList;
    }

    public void setGlJournalbatchList(List<GlJournalbatch> glJournalbatchList) {
        this.glJournalbatchList = glJournalbatchList;
    }

    @XmlTransient
    public List<CPeriodcontrolLog> getCPeriodcontrolLogList() {
        return cPeriodcontrolLogList;
    }

    public void setCPeriodcontrolLogList(List<CPeriodcontrolLog> cPeriodcontrolLogList) {
        this.cPeriodcontrolLogList = cPeriodcontrolLogList;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList() {
        return iBudgetlineList;
    }

    public void setIBudgetlineList(List<IBudgetline> iBudgetlineList) {
        this.iBudgetlineList = iBudgetlineList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
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

    public CYear getCYearId() {
        return cYearId;
    }

    public void setCYearId(CYear cYearId) {
        this.cYearId = cYearId;
    }

    @XmlTransient
    public List<GlJournal> getGlJournalList() {
        return glJournalList;
    }

    public void setGlJournalList(List<GlJournal> glJournalList) {
        this.glJournalList = glJournalList;
    }

    @XmlTransient
    public List<CAcctschema> getCAcctschemaList() {
        return cAcctschemaList;
    }

    public void setCAcctschemaList(List<CAcctschema> cAcctschemaList) {
        this.cAcctschemaList = cAcctschemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPeriodId != null ? cPeriodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPeriod)) {
            return false;
        }
        CPeriod other = (CPeriod) object;
        if ((this.cPeriodId == null && other.cPeriodId != null) || (this.cPeriodId != null && !this.cPeriodId.equals(other.cPeriodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPeriod[ cPeriodId=" + cPeriodId + " ]";
    }
    
}
