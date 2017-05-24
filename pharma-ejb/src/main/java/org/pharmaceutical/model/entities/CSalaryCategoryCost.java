/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "c_salary_category_cost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CSalaryCategoryCost.findAll", query = "SELECT c FROM CSalaryCategoryCost c"),
    @NamedQuery(name = "CSalaryCategoryCost.findByCSalaryCategoryCostId", query = "SELECT c FROM CSalaryCategoryCost c WHERE c.cSalaryCategoryCostId = :cSalaryCategoryCostId"),
    @NamedQuery(name = "CSalaryCategoryCost.findByCreated", query = "SELECT c FROM CSalaryCategoryCost c WHERE c.created = :created"),
    @NamedQuery(name = "CSalaryCategoryCost.findByCreatedby", query = "SELECT c FROM CSalaryCategoryCost c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CSalaryCategoryCost.findByUpdated", query = "SELECT c FROM CSalaryCategoryCost c WHERE c.updated = :updated"),
    @NamedQuery(name = "CSalaryCategoryCost.findByUpdatedby", query = "SELECT c FROM CSalaryCategoryCost c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CSalaryCategoryCost.findByDatefrom", query = "SELECT c FROM CSalaryCategoryCost c WHERE c.datefrom = :datefrom"),
    @NamedQuery(name = "CSalaryCategoryCost.findByCost", query = "SELECT c FROM CSalaryCategoryCost c WHERE c.cost = :cost"),
    @NamedQuery(name = "CSalaryCategoryCost.findByCostuom", query = "SELECT c FROM CSalaryCategoryCost c WHERE c.costuom = :costuom")})
public class CSalaryCategoryCost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_salary_category_cost_id")
    private String cSalaryCategoryCostId;
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
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private BigInteger cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "costuom")
    private String costuom;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_salary_category_id", referencedColumnName = "c_salary_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CSalaryCategory cSalaryCategoryId;

    public CSalaryCategoryCost() {
    }

    public CSalaryCategoryCost(String cSalaryCategoryCostId) {
        this.cSalaryCategoryCostId = cSalaryCategoryCostId;
    }

    public CSalaryCategoryCost(String cSalaryCategoryCostId, Date created, String createdby, Date updated, String updatedby, Date datefrom, BigInteger cost, String costuom) {
        this.cSalaryCategoryCostId = cSalaryCategoryCostId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.datefrom = datefrom;
        this.cost = cost;
        this.costuom = costuom;
    }

    public String getCSalaryCategoryCostId() {
        return cSalaryCategoryCostId;
    }

    public void setCSalaryCategoryCostId(String cSalaryCategoryCostId) {
        this.cSalaryCategoryCostId = cSalaryCategoryCostId;
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

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

    public String getCostuom() {
        return costuom;
    }

    public void setCostuom(String costuom) {
        this.costuom = costuom;
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

    public CSalaryCategory getCSalaryCategoryId() {
        return cSalaryCategoryId;
    }

    public void setCSalaryCategoryId(CSalaryCategory cSalaryCategoryId) {
        this.cSalaryCategoryId = cSalaryCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cSalaryCategoryCostId != null ? cSalaryCategoryCostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CSalaryCategoryCost)) {
            return false;
        }
        CSalaryCategoryCost other = (CSalaryCategoryCost) object;
        if ((this.cSalaryCategoryCostId == null && other.cSalaryCategoryCostId != null) || (this.cSalaryCategoryCostId != null && !this.cSalaryCategoryCostId.equals(other.cSalaryCategoryCostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CSalaryCategoryCost[ cSalaryCategoryCostId=" + cSalaryCategoryCostId + " ]";
    }
    
}
