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
@Table(name = "ad_alert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdAlert.findAll", query = "SELECT a FROM AdAlert a"),
    @NamedQuery(name = "AdAlert.findByAdAlertId", query = "SELECT a FROM AdAlert a WHERE a.adAlertId = :adAlertId"),
    @NamedQuery(name = "AdAlert.findByIsactive", query = "SELECT a FROM AdAlert a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdAlert.findByCreated", query = "SELECT a FROM AdAlert a WHERE a.created = :created"),
    @NamedQuery(name = "AdAlert.findByCreatedby", query = "SELECT a FROM AdAlert a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdAlert.findByUpdated", query = "SELECT a FROM AdAlert a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdAlert.findByUpdatedby", query = "SELECT a FROM AdAlert a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdAlert.findByDescription", query = "SELECT a FROM AdAlert a WHERE a.description = :description"),
    @NamedQuery(name = "AdAlert.findByIsfixed", query = "SELECT a FROM AdAlert a WHERE a.isfixed = :isfixed"),
    @NamedQuery(name = "AdAlert.findByNote", query = "SELECT a FROM AdAlert a WHERE a.note = :note"),
    @NamedQuery(name = "AdAlert.findByRecordId", query = "SELECT a FROM AdAlert a WHERE a.recordId = :recordId"),
    @NamedQuery(name = "AdAlert.findByReferencekeyId", query = "SELECT a FROM AdAlert a WHERE a.referencekeyId = :referencekeyId")})
public class AdAlert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_alert_id")
    private String adAlertId;
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
    @Column(name = "description")
    private String description;
    @Column(name = "isfixed")
    private Character isfixed;
    @Size(max = 2000)
    @Column(name = "note")
    private String note;
    @Size(max = 100)
    @Column(name = "record_id")
    private String recordId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "referencekey_id")
    private String referencekeyId;
    @JoinColumn(name = "ad_alertrule_id", referencedColumnName = "ad_alertrule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdAlertrule adAlertruleId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_role_id", referencedColumnName = "ad_role_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdRole adRoleId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MWarehouse mWarehouseId;

    public AdAlert() {
    }

    public AdAlert(String adAlertId) {
        this.adAlertId = adAlertId;
    }

    public AdAlert(String adAlertId, Character isactive, Date created, String createdby, Date updated, String updatedby, String referencekeyId) {
        this.adAlertId = adAlertId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.referencekeyId = referencekeyId;
    }

    public String getAdAlertId() {
        return adAlertId;
    }

    public void setAdAlertId(String adAlertId) {
        this.adAlertId = adAlertId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIsfixed() {
        return isfixed;
    }

    public void setIsfixed(Character isfixed) {
        this.isfixed = isfixed;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getReferencekeyId() {
        return referencekeyId;
    }

    public void setReferencekeyId(String referencekeyId) {
        this.referencekeyId = referencekeyId;
    }

    public AdAlertrule getAdAlertruleId() {
        return adAlertruleId;
    }

    public void setAdAlertruleId(AdAlertrule adAlertruleId) {
        this.adAlertruleId = adAlertruleId;
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

    public AdRole getAdRoleId() {
        return adRoleId;
    }

    public void setAdRoleId(AdRole adRoleId) {
        this.adRoleId = adRoleId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adAlertId != null ? adAlertId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdAlert)) {
            return false;
        }
        AdAlert other = (AdAlert) object;
        if ((this.adAlertId == null && other.adAlertId != null) || (this.adAlertId != null && !this.adAlertId.equals(other.adAlertId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdAlert[ adAlertId=" + adAlertId + " ]";
    }
    
}
