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
@Table(name = "c_acctschema_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctschemaTable.findAll", query = "SELECT c FROM CAcctschemaTable c"),
    @NamedQuery(name = "CAcctschemaTable.findByCAcctschemaTableId", query = "SELECT c FROM CAcctschemaTable c WHERE c.cAcctschemaTableId = :cAcctschemaTableId"),
    @NamedQuery(name = "CAcctschemaTable.findByIsactive", query = "SELECT c FROM CAcctschemaTable c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctschemaTable.findByCreated", query = "SELECT c FROM CAcctschemaTable c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctschemaTable.findByCreatedby", query = "SELECT c FROM CAcctschemaTable c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctschemaTable.findByUpdated", query = "SELECT c FROM CAcctschemaTable c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctschemaTable.findByUpdatedby", query = "SELECT c FROM CAcctschemaTable c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctschemaTable.findByAcctdescription", query = "SELECT c FROM CAcctschemaTable c WHERE c.acctdescription = :acctdescription"),
    @NamedQuery(name = "CAcctschemaTable.findByIsbackgrounddisabled", query = "SELECT c FROM CAcctschemaTable c WHERE c.isbackgrounddisabled = :isbackgrounddisabled")})
public class CAcctschemaTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acctschema_table_id")
    private String cAcctschemaTableId;
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
    @Size(max = 2000)
    @Column(name = "acctdescription")
    private String acctdescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbackgrounddisabled")
    private Character isbackgrounddisabled;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaTableId")
    private List<CAcctschemaTableDoctype> cAcctschemaTableDoctypeList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_createfact_template_id", referencedColumnName = "ad_createfact_template_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdCreatefactTemplate adCreatefactTemplateId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;

    public CAcctschemaTable() {
    }

    public CAcctschemaTable(String cAcctschemaTableId) {
        this.cAcctschemaTableId = cAcctschemaTableId;
    }

    public CAcctschemaTable(String cAcctschemaTableId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isbackgrounddisabled) {
        this.cAcctschemaTableId = cAcctschemaTableId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isbackgrounddisabled = isbackgrounddisabled;
    }

    public String getCAcctschemaTableId() {
        return cAcctschemaTableId;
    }

    public void setCAcctschemaTableId(String cAcctschemaTableId) {
        this.cAcctschemaTableId = cAcctschemaTableId;
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

    public String getAcctdescription() {
        return acctdescription;
    }

    public void setAcctdescription(String acctdescription) {
        this.acctdescription = acctdescription;
    }

    public Character getIsbackgrounddisabled() {
        return isbackgrounddisabled;
    }

    public void setIsbackgrounddisabled(Character isbackgrounddisabled) {
        this.isbackgrounddisabled = isbackgrounddisabled;
    }

    @XmlTransient
    public List<CAcctschemaTableDoctype> getCAcctschemaTableDoctypeList() {
        return cAcctschemaTableDoctypeList;
    }

    public void setCAcctschemaTableDoctypeList(List<CAcctschemaTableDoctype> cAcctschemaTableDoctypeList) {
        this.cAcctschemaTableDoctypeList = cAcctschemaTableDoctypeList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdCreatefactTemplate getAdCreatefactTemplateId() {
        return adCreatefactTemplateId;
    }

    public void setAdCreatefactTemplateId(AdCreatefactTemplate adCreatefactTemplateId) {
        this.adCreatefactTemplateId = adCreatefactTemplateId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
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
        hash += (cAcctschemaTableId != null ? cAcctschemaTableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctschemaTable)) {
            return false;
        }
        CAcctschemaTable other = (CAcctschemaTable) object;
        if ((this.cAcctschemaTableId == null && other.cAcctschemaTableId != null) || (this.cAcctschemaTableId != null && !this.cAcctschemaTableId.equals(other.cAcctschemaTableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctschemaTable[ cAcctschemaTableId=" + cAcctschemaTableId + " ]";
    }
    
}
