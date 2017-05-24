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
@Table(name = "c_remittance_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRemittanceType.findAll", query = "SELECT c FROM CRemittanceType c"),
    @NamedQuery(name = "CRemittanceType.findByCRemittanceTypeId", query = "SELECT c FROM CRemittanceType c WHERE c.cRemittanceTypeId = :cRemittanceTypeId"),
    @NamedQuery(name = "CRemittanceType.findByIsactive", query = "SELECT c FROM CRemittanceType c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CRemittanceType.findByCreated", query = "SELECT c FROM CRemittanceType c WHERE c.created = :created"),
    @NamedQuery(name = "CRemittanceType.findByCreatedby", query = "SELECT c FROM CRemittanceType c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CRemittanceType.findByUpdated", query = "SELECT c FROM CRemittanceType c WHERE c.updated = :updated"),
    @NamedQuery(name = "CRemittanceType.findByUpdatedby", query = "SELECT c FROM CRemittanceType c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CRemittanceType.findByName", query = "SELECT c FROM CRemittanceType c WHERE c.name = :name"),
    @NamedQuery(name = "CRemittanceType.findByConsolidate", query = "SELECT c FROM CRemittanceType c WHERE c.consolidate = :consolidate"),
    @NamedQuery(name = "CRemittanceType.findByStatusTo", query = "SELECT c FROM CRemittanceType c WHERE c.statusTo = :statusTo"),
    @NamedQuery(name = "CRemittanceType.findByPaymentruleconsolidated", query = "SELECT c FROM CRemittanceType c WHERE c.paymentruleconsolidated = :paymentruleconsolidated"),
    @NamedQuery(name = "CRemittanceType.findByStatusReturned", query = "SELECT c FROM CRemittanceType c WHERE c.statusReturned = :statusReturned"),
    @NamedQuery(name = "CRemittanceType.findByIsreceipt", query = "SELECT c FROM CRemittanceType c WHERE c.isreceipt = :isreceipt")})
public class CRemittanceType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_remittance_type_id")
    private String cRemittanceTypeId;
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
    @Column(name = "consolidate")
    private Character consolidate;
    @Size(max = 60)
    @Column(name = "status_to")
    private String statusTo;
    @Size(max = 60)
    @Column(name = "paymentruleconsolidated")
    private String paymentruleconsolidated;
    @Size(max = 60)
    @Column(name = "status_returned")
    private String statusReturned;
    @Column(name = "isreceipt")
    private Character isreceipt;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRemittanceTypeId")
    private List<CRemittance> cRemittanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cRemittanceTypeId")
    private List<CRemittanceParameter> cRemittanceParameterList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public CRemittanceType() {
    }

    public CRemittanceType(String cRemittanceTypeId) {
        this.cRemittanceTypeId = cRemittanceTypeId;
    }

    public CRemittanceType(String cRemittanceTypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character consolidate) {
        this.cRemittanceTypeId = cRemittanceTypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.consolidate = consolidate;
    }

    public String getCRemittanceTypeId() {
        return cRemittanceTypeId;
    }

    public void setCRemittanceTypeId(String cRemittanceTypeId) {
        this.cRemittanceTypeId = cRemittanceTypeId;
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

    public Character getConsolidate() {
        return consolidate;
    }

    public void setConsolidate(Character consolidate) {
        this.consolidate = consolidate;
    }

    public String getStatusTo() {
        return statusTo;
    }

    public void setStatusTo(String statusTo) {
        this.statusTo = statusTo;
    }

    public String getPaymentruleconsolidated() {
        return paymentruleconsolidated;
    }

    public void setPaymentruleconsolidated(String paymentruleconsolidated) {
        this.paymentruleconsolidated = paymentruleconsolidated;
    }

    public String getStatusReturned() {
        return statusReturned;
    }

    public void setStatusReturned(String statusReturned) {
        this.statusReturned = statusReturned;
    }

    public Character getIsreceipt() {
        return isreceipt;
    }

    public void setIsreceipt(Character isreceipt) {
        this.isreceipt = isreceipt;
    }

    @XmlTransient
    public List<CRemittance> getCRemittanceList() {
        return cRemittanceList;
    }

    public void setCRemittanceList(List<CRemittance> cRemittanceList) {
        this.cRemittanceList = cRemittanceList;
    }

    @XmlTransient
    public List<CRemittanceParameter> getCRemittanceParameterList() {
        return cRemittanceParameterList;
    }

    public void setCRemittanceParameterList(List<CRemittanceParameter> cRemittanceParameterList) {
        this.cRemittanceParameterList = cRemittanceParameterList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRemittanceTypeId != null ? cRemittanceTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRemittanceType)) {
            return false;
        }
        CRemittanceType other = (CRemittanceType) object;
        if ((this.cRemittanceTypeId == null && other.cRemittanceTypeId != null) || (this.cRemittanceTypeId != null && !this.cRemittanceTypeId.equals(other.cRemittanceTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CRemittanceType[ cRemittanceTypeId=" + cRemittanceTypeId + " ]";
    }
    
}
