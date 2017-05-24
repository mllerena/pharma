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
@Table(name = "c_acct_rpt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctRpt.findAll", query = "SELECT c FROM CAcctRpt c"),
    @NamedQuery(name = "CAcctRpt.findByCAcctRptId", query = "SELECT c FROM CAcctRpt c WHERE c.cAcctRptId = :cAcctRptId"),
    @NamedQuery(name = "CAcctRpt.findByIsactive", query = "SELECT c FROM CAcctRpt c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctRpt.findByCreated", query = "SELECT c FROM CAcctRpt c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctRpt.findByCreatedby", query = "SELECT c FROM CAcctRpt c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctRpt.findByUpdated", query = "SELECT c FROM CAcctRpt c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctRpt.findByUpdatedby", query = "SELECT c FROM CAcctRpt c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctRpt.findByName", query = "SELECT c FROM CAcctRpt c WHERE c.name = :name"),
    @NamedQuery(name = "CAcctRpt.findByDescription", query = "SELECT c FROM CAcctRpt c WHERE c.description = :description"),
    @NamedQuery(name = "CAcctRpt.findByIsorgbalanced", query = "SELECT c FROM CAcctRpt c WHERE c.isorgbalanced = :isorgbalanced"),
    @NamedQuery(name = "CAcctRpt.findByReporttype", query = "SELECT c FROM CAcctRpt c WHERE c.reporttype = :reporttype")})
public class CAcctRpt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acct_rpt_id")
    private String cAcctRptId;
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
    @Column(name = "isorgbalanced")
    private Character isorgbalanced;
    @Size(max = 60)
    @Column(name = "reporttype")
    private String reporttype;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctRptId")
    private List<CAcctRptGroup> cAcctRptGroupList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschemaId;

    public CAcctRpt() {
    }

    public CAcctRpt(String cAcctRptId) {
        this.cAcctRptId = cAcctRptId;
    }

    public CAcctRpt(String cAcctRptId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isorgbalanced) {
        this.cAcctRptId = cAcctRptId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isorgbalanced = isorgbalanced;
    }

    public String getCAcctRptId() {
        return cAcctRptId;
    }

    public void setCAcctRptId(String cAcctRptId) {
        this.cAcctRptId = cAcctRptId;
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

    public Character getIsorgbalanced() {
        return isorgbalanced;
    }

    public void setIsorgbalanced(Character isorgbalanced) {
        this.isorgbalanced = isorgbalanced;
    }

    public String getReporttype() {
        return reporttype;
    }

    public void setReporttype(String reporttype) {
        this.reporttype = reporttype;
    }

    @XmlTransient
    public List<CAcctRptGroup> getCAcctRptGroupList() {
        return cAcctRptGroupList;
    }

    public void setCAcctRptGroupList(List<CAcctRptGroup> cAcctRptGroupList) {
        this.cAcctRptGroupList = cAcctRptGroupList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctRptId != null ? cAcctRptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctRpt)) {
            return false;
        }
        CAcctRpt other = (CAcctRpt) object;
        if ((this.cAcctRptId == null && other.cAcctRptId != null) || (this.cAcctRptId != null && !this.cAcctRptId.equals(other.cAcctRptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctRpt[ cAcctRptId=" + cAcctRptId + " ]";
    }
    
}
