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
@Table(name = "c_remittance_parameter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRemittanceParameter.findAll", query = "SELECT c FROM CRemittanceParameter c"),
    @NamedQuery(name = "CRemittanceParameter.findByCRemittanceParameterId", query = "SELECT c FROM CRemittanceParameter c WHERE c.cRemittanceParameterId = :cRemittanceParameterId"),
    @NamedQuery(name = "CRemittanceParameter.findByIsactive", query = "SELECT c FROM CRemittanceParameter c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CRemittanceParameter.findByCreated", query = "SELECT c FROM CRemittanceParameter c WHERE c.created = :created"),
    @NamedQuery(name = "CRemittanceParameter.findByCreatedby", query = "SELECT c FROM CRemittanceParameter c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CRemittanceParameter.findByUpdated", query = "SELECT c FROM CRemittanceParameter c WHERE c.updated = :updated"),
    @NamedQuery(name = "CRemittanceParameter.findByUpdatedby", query = "SELECT c FROM CRemittanceParameter c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CRemittanceParameter.findByName", query = "SELECT c FROM CRemittanceParameter c WHERE c.name = :name"),
    @NamedQuery(name = "CRemittanceParameter.findByContent", query = "SELECT c FROM CRemittanceParameter c WHERE c.content = :content")})
public class CRemittanceParameter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_remittance_parameter_id")
    private String cRemittanceParameterId;
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
    @Size(max = 60)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_remittance_type_id", referencedColumnName = "c_remittance_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CRemittanceType cRemittanceTypeId;

    public CRemittanceParameter() {
    }

    public CRemittanceParameter(String cRemittanceParameterId) {
        this.cRemittanceParameterId = cRemittanceParameterId;
    }

    public CRemittanceParameter(String cRemittanceParameterId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cRemittanceParameterId = cRemittanceParameterId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCRemittanceParameterId() {
        return cRemittanceParameterId;
    }

    public void setCRemittanceParameterId(String cRemittanceParameterId) {
        this.cRemittanceParameterId = cRemittanceParameterId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public CRemittanceType getCRemittanceTypeId() {
        return cRemittanceTypeId;
    }

    public void setCRemittanceTypeId(CRemittanceType cRemittanceTypeId) {
        this.cRemittanceTypeId = cRemittanceTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRemittanceParameterId != null ? cRemittanceParameterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRemittanceParameter)) {
            return false;
        }
        CRemittanceParameter other = (CRemittanceParameter) object;
        if ((this.cRemittanceParameterId == null && other.cRemittanceParameterId != null) || (this.cRemittanceParameterId != null && !this.cRemittanceParameterId.equals(other.cRemittanceParameterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CRemittanceParameter[ cRemittanceParameterId=" + cRemittanceParameterId + " ]";
    }
    
}
