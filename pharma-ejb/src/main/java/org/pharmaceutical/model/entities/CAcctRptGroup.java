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
@Table(name = "c_acct_rpt_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctRptGroup.findAll", query = "SELECT c FROM CAcctRptGroup c"),
    @NamedQuery(name = "CAcctRptGroup.findByCAcctRptGroupId", query = "SELECT c FROM CAcctRptGroup c WHERE c.cAcctRptGroupId = :cAcctRptGroupId"),
    @NamedQuery(name = "CAcctRptGroup.findByIsactive", query = "SELECT c FROM CAcctRptGroup c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctRptGroup.findByCreated", query = "SELECT c FROM CAcctRptGroup c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctRptGroup.findByCreatedby", query = "SELECT c FROM CAcctRptGroup c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctRptGroup.findByUpdated", query = "SELECT c FROM CAcctRptGroup c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctRptGroup.findByUpdatedby", query = "SELECT c FROM CAcctRptGroup c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctRptGroup.findByName", query = "SELECT c FROM CAcctRptGroup c WHERE c.name = :name"),
    @NamedQuery(name = "CAcctRptGroup.findByDescription", query = "SELECT c FROM CAcctRptGroup c WHERE c.description = :description"),
    @NamedQuery(name = "CAcctRptGroup.findByLine", query = "SELECT c FROM CAcctRptGroup c WHERE c.line = :line")})
public class CAcctRptGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acct_rpt_group_id")
    private String cAcctRptGroupId;
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
    @Column(name = "line")
    private BigInteger line;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctRptGroupId")
    private List<CAcctRptNode> cAcctRptNodeList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acct_rpt_id", referencedColumnName = "c_acct_rpt_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctRpt cAcctRptId;

    public CAcctRptGroup() {
    }

    public CAcctRptGroup(String cAcctRptGroupId) {
        this.cAcctRptGroupId = cAcctRptGroupId;
    }

    public CAcctRptGroup(String cAcctRptGroupId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cAcctRptGroupId = cAcctRptGroupId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCAcctRptGroupId() {
        return cAcctRptGroupId;
    }

    public void setCAcctRptGroupId(String cAcctRptGroupId) {
        this.cAcctRptGroupId = cAcctRptGroupId;
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

    public BigInteger getLine() {
        return line;
    }

    public void setLine(BigInteger line) {
        this.line = line;
    }

    @XmlTransient
    public List<CAcctRptNode> getCAcctRptNodeList() {
        return cAcctRptNodeList;
    }

    public void setCAcctRptNodeList(List<CAcctRptNode> cAcctRptNodeList) {
        this.cAcctRptNodeList = cAcctRptNodeList;
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

    public CAcctRpt getCAcctRptId() {
        return cAcctRptId;
    }

    public void setCAcctRptId(CAcctRpt cAcctRptId) {
        this.cAcctRptId = cAcctRptId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctRptGroupId != null ? cAcctRptGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctRptGroup)) {
            return false;
        }
        CAcctRptGroup other = (CAcctRptGroup) object;
        if ((this.cAcctRptGroupId == null && other.cAcctRptGroupId != null) || (this.cAcctRptGroupId != null && !this.cAcctRptGroupId.equals(other.cAcctRptGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctRptGroup[ cAcctRptGroupId=" + cAcctRptGroupId + " ]";
    }
    
}
