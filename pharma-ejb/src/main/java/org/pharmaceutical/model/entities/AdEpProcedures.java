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
@Table(name = "ad_ep_procedures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdEpProcedures.findAll", query = "SELECT a FROM AdEpProcedures a"),
    @NamedQuery(name = "AdEpProcedures.findByAdEpProceduresId", query = "SELECT a FROM AdEpProcedures a WHERE a.adEpProceduresId = :adEpProceduresId"),
    @NamedQuery(name = "AdEpProcedures.findByIsactive", query = "SELECT a FROM AdEpProcedures a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdEpProcedures.findByCreated", query = "SELECT a FROM AdEpProcedures a WHERE a.created = :created"),
    @NamedQuery(name = "AdEpProcedures.findByCreatedby", query = "SELECT a FROM AdEpProcedures a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdEpProcedures.findByUpdated", query = "SELECT a FROM AdEpProcedures a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdEpProcedures.findByUpdatedby", query = "SELECT a FROM AdEpProcedures a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdEpProcedures.findByProcedurename", query = "SELECT a FROM AdEpProcedures a WHERE a.procedurename = :procedurename")})
public class AdEpProcedures implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_ep_procedures_id")
    private String adEpProceduresId;
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
    @Column(name = "procedurename")
    private String procedurename;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_extension_points_id", referencedColumnName = "ad_extension_points_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdExtensionPoints adExtensionPointsId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdEpProcedures() {
    }

    public AdEpProcedures(String adEpProceduresId) {
        this.adEpProceduresId = adEpProceduresId;
    }

    public AdEpProcedures(String adEpProceduresId, Character isactive, Date created, String createdby, Date updated, String updatedby, String procedurename) {
        this.adEpProceduresId = adEpProceduresId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.procedurename = procedurename;
    }

    public String getAdEpProceduresId() {
        return adEpProceduresId;
    }

    public void setAdEpProceduresId(String adEpProceduresId) {
        this.adEpProceduresId = adEpProceduresId;
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

    public String getProcedurename() {
        return procedurename;
    }

    public void setProcedurename(String procedurename) {
        this.procedurename = procedurename;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdExtensionPoints getAdExtensionPointsId() {
        return adExtensionPointsId;
    }

    public void setAdExtensionPointsId(AdExtensionPoints adExtensionPointsId) {
        this.adExtensionPointsId = adExtensionPointsId;
    }

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
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
        hash += (adEpProceduresId != null ? adEpProceduresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdEpProcedures)) {
            return false;
        }
        AdEpProcedures other = (AdEpProcedures) object;
        if ((this.adEpProceduresId == null && other.adEpProceduresId != null) || (this.adEpProceduresId != null && !this.adEpProceduresId.equals(other.adEpProceduresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdEpProcedures[ adEpProceduresId=" + adEpProceduresId + " ]";
    }
    
}
