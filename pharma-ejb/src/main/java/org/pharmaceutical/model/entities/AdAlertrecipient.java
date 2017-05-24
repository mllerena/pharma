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
@Table(name = "ad_alertrecipient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdAlertrecipient.findAll", query = "SELECT a FROM AdAlertrecipient a"),
    @NamedQuery(name = "AdAlertrecipient.findByIsactive", query = "SELECT a FROM AdAlertrecipient a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdAlertrecipient.findByCreated", query = "SELECT a FROM AdAlertrecipient a WHERE a.created = :created"),
    @NamedQuery(name = "AdAlertrecipient.findByCreatedby", query = "SELECT a FROM AdAlertrecipient a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdAlertrecipient.findByUpdated", query = "SELECT a FROM AdAlertrecipient a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdAlertrecipient.findByUpdatedby", query = "SELECT a FROM AdAlertrecipient a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdAlertrecipient.findByAdAlertrecipientId", query = "SELECT a FROM AdAlertrecipient a WHERE a.adAlertrecipientId = :adAlertrecipientId"),
    @NamedQuery(name = "AdAlertrecipient.findBySendemail", query = "SELECT a FROM AdAlertrecipient a WHERE a.sendemail = :sendemail")})
public class AdAlertrecipient implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_alertrecipient_id")
    private String adAlertrecipientId;
    @Column(name = "sendemail")
    private Character sendemail;
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
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdRole adRoleId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;

    public AdAlertrecipient() {
    }

    public AdAlertrecipient(String adAlertrecipientId) {
        this.adAlertrecipientId = adAlertrecipientId;
    }

    public AdAlertrecipient(String adAlertrecipientId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adAlertrecipientId = adAlertrecipientId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
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

    public String getAdAlertrecipientId() {
        return adAlertrecipientId;
    }

    public void setAdAlertrecipientId(String adAlertrecipientId) {
        this.adAlertrecipientId = adAlertrecipientId;
    }

    public Character getSendemail() {
        return sendemail;
    }

    public void setSendemail(Character sendemail) {
        this.sendemail = sendemail;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adAlertrecipientId != null ? adAlertrecipientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdAlertrecipient)) {
            return false;
        }
        AdAlertrecipient other = (AdAlertrecipient) object;
        if ((this.adAlertrecipientId == null && other.adAlertrecipientId != null) || (this.adAlertrecipientId != null && !this.adAlertrecipientId.equals(other.adAlertrecipientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdAlertrecipient[ adAlertrecipientId=" + adAlertrecipientId + " ]";
    }
    
}
