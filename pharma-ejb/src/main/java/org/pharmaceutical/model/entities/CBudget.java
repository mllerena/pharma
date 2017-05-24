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
@Table(name = "c_budget")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBudget.findAll", query = "SELECT c FROM CBudget c"),
    @NamedQuery(name = "CBudget.findByCBudgetId", query = "SELECT c FROM CBudget c WHERE c.cBudgetId = :cBudgetId"),
    @NamedQuery(name = "CBudget.findByIsactive", query = "SELECT c FROM CBudget c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBudget.findByCreated", query = "SELECT c FROM CBudget c WHERE c.created = :created"),
    @NamedQuery(name = "CBudget.findByCreatedby", query = "SELECT c FROM CBudget c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBudget.findByUpdated", query = "SELECT c FROM CBudget c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBudget.findByUpdatedby", query = "SELECT c FROM CBudget c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBudget.findByName", query = "SELECT c FROM CBudget c WHERE c.name = :name"),
    @NamedQuery(name = "CBudget.findByDescription", query = "SELECT c FROM CBudget c WHERE c.description = :description"),
    @NamedQuery(name = "CBudget.findByCopybudget", query = "SELECT c FROM CBudget c WHERE c.copybudget = :copybudget"),
    @NamedQuery(name = "CBudget.findByBudgetType", query = "SELECT c FROM CBudget c WHERE c.budgetType = :budgetType"),
    @NamedQuery(name = "CBudget.findByExportexcel", query = "SELECT c FROM CBudget c WHERE c.exportexcel = :exportexcel"),
    @NamedQuery(name = "CBudget.findByExportactual", query = "SELECT c FROM CBudget c WHERE c.exportactual = :exportactual")})
public class CBudget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_budget_id")
    private String cBudgetId;
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
    @Column(name = "copybudget")
    private Character copybudget;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "budget_type")
    private String budgetType;
    @Column(name = "exportexcel")
    private Character exportexcel;
    @Column(name = "exportactual")
    private Character exportactual;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBudgetId")
    private List<IBudgetline> iBudgetlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_year_id", referencedColumnName = "c_year_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CYear cYearId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBudgetId")
    private List<CBudgetline> cBudgetlineList;

    public CBudget() {
    }

    public CBudget(String cBudgetId) {
        this.cBudgetId = cBudgetId;
    }

    public CBudget(String cBudgetId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String budgetType) {
        this.cBudgetId = cBudgetId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.budgetType = budgetType;
    }

    public String getCBudgetId() {
        return cBudgetId;
    }

    public void setCBudgetId(String cBudgetId) {
        this.cBudgetId = cBudgetId;
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

    public Character getCopybudget() {
        return copybudget;
    }

    public void setCopybudget(Character copybudget) {
        this.copybudget = copybudget;
    }

    public String getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    public Character getExportexcel() {
        return exportexcel;
    }

    public void setExportexcel(Character exportexcel) {
        this.exportexcel = exportexcel;
    }

    public Character getExportactual() {
        return exportactual;
    }

    public void setExportactual(Character exportactual) {
        this.exportactual = exportactual;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList() {
        return iBudgetlineList;
    }

    public void setIBudgetlineList(List<IBudgetline> iBudgetlineList) {
        this.iBudgetlineList = iBudgetlineList;
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
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBudgetId != null ? cBudgetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBudget)) {
            return false;
        }
        CBudget other = (CBudget) object;
        if ((this.cBudgetId == null && other.cBudgetId != null) || (this.cBudgetId != null && !this.cBudgetId.equals(other.cBudgetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBudget[ cBudgetId=" + cBudgetId + " ]";
    }
    
}
