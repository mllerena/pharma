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
@Table(name = "fin_matching_algorithm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinMatchingAlgorithm.findAll", query = "SELECT f FROM FinMatchingAlgorithm f"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByFinMatchingAlgorithmId", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.finMatchingAlgorithmId = :finMatchingAlgorithmId"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByCreated", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.created = :created"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByCreatedby", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByUpdated", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByUpdatedby", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByIsactive", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByName", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.name = :name"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByDescription", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.description = :description"),
    @NamedQuery(name = "FinMatchingAlgorithm.findByClassname", query = "SELECT f FROM FinMatchingAlgorithm f WHERE f.classname = :classname")})
public class FinMatchingAlgorithm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_matching_algorithm_id")
    private String finMatchingAlgorithmId;
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
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "classname")
    private String classname;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finMatchingAlgorithmId")
    private List<FinFinancialAccount> finFinancialAccountList;

    public FinMatchingAlgorithm() {
    }

    public FinMatchingAlgorithm(String finMatchingAlgorithmId) {
        this.finMatchingAlgorithmId = finMatchingAlgorithmId;
    }

    public FinMatchingAlgorithm(String finMatchingAlgorithmId, Date created, String createdby, Date updated, String updatedby, Character isactive, String name, String classname) {
        this.finMatchingAlgorithmId = finMatchingAlgorithmId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.name = name;
        this.classname = classname;
    }

    public String getFinMatchingAlgorithmId() {
        return finMatchingAlgorithmId;
    }

    public void setFinMatchingAlgorithmId(String finMatchingAlgorithmId) {
        this.finMatchingAlgorithmId = finMatchingAlgorithmId;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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

    @XmlTransient
    public List<FinFinancialAccount> getFinFinancialAccountList() {
        return finFinancialAccountList;
    }

    public void setFinFinancialAccountList(List<FinFinancialAccount> finFinancialAccountList) {
        this.finFinancialAccountList = finFinancialAccountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finMatchingAlgorithmId != null ? finMatchingAlgorithmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinMatchingAlgorithm)) {
            return false;
        }
        FinMatchingAlgorithm other = (FinMatchingAlgorithm) object;
        if ((this.finMatchingAlgorithmId == null && other.finMatchingAlgorithmId != null) || (this.finMatchingAlgorithmId != null && !this.finMatchingAlgorithmId.equals(other.finMatchingAlgorithmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinMatchingAlgorithm[ finMatchingAlgorithmId=" + finMatchingAlgorithmId + " ]";
    }
    
}
