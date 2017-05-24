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
@Table(name = "ad_registration_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdRegistrationInfo.findAll", query = "SELECT a FROM AdRegistrationInfo a"),
    @NamedQuery(name = "AdRegistrationInfo.findByAdRegistrationInfoId", query = "SELECT a FROM AdRegistrationInfo a WHERE a.adRegistrationInfoId = :adRegistrationInfoId"),
    @NamedQuery(name = "AdRegistrationInfo.findByIsactive", query = "SELECT a FROM AdRegistrationInfo a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdRegistrationInfo.findByCreated", query = "SELECT a FROM AdRegistrationInfo a WHERE a.created = :created"),
    @NamedQuery(name = "AdRegistrationInfo.findByCreatedby", query = "SELECT a FROM AdRegistrationInfo a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdRegistrationInfo.findByUpdated", query = "SELECT a FROM AdRegistrationInfo a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdRegistrationInfo.findByUpdatedby", query = "SELECT a FROM AdRegistrationInfo a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdRegistrationInfo.findByRegistrationId", query = "SELECT a FROM AdRegistrationInfo a WHERE a.registrationId = :registrationId"),
    @NamedQuery(name = "AdRegistrationInfo.findByIsregistrationactive", query = "SELECT a FROM AdRegistrationInfo a WHERE a.isregistrationactive = :isregistrationactive"),
    @NamedQuery(name = "AdRegistrationInfo.findByPostponeDate", query = "SELECT a FROM AdRegistrationInfo a WHERE a.postponeDate = :postponeDate")})
public class AdRegistrationInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_registration_info_id")
    private String adRegistrationInfoId;
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
    @Size(max = 60)
    @Column(name = "registration_id")
    private String registrationId;
    @Column(name = "isregistrationactive")
    private Character isregistrationactive;
    @Column(name = "postpone_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postponeDate;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdRegistrationInfo() {
    }

    public AdRegistrationInfo(String adRegistrationInfoId) {
        this.adRegistrationInfoId = adRegistrationInfoId;
    }

    public AdRegistrationInfo(String adRegistrationInfoId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adRegistrationInfoId = adRegistrationInfoId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdRegistrationInfoId() {
        return adRegistrationInfoId;
    }

    public void setAdRegistrationInfoId(String adRegistrationInfoId) {
        this.adRegistrationInfoId = adRegistrationInfoId;
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

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Character getIsregistrationactive() {
        return isregistrationactive;
    }

    public void setIsregistrationactive(Character isregistrationactive) {
        this.isregistrationactive = isregistrationactive;
    }

    public Date getPostponeDate() {
        return postponeDate;
    }

    public void setPostponeDate(Date postponeDate) {
        this.postponeDate = postponeDate;
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
        hash += (adRegistrationInfoId != null ? adRegistrationInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdRegistrationInfo)) {
            return false;
        }
        AdRegistrationInfo other = (AdRegistrationInfo) object;
        if ((this.adRegistrationInfoId == null && other.adRegistrationInfoId != null) || (this.adRegistrationInfoId != null && !this.adRegistrationInfoId.equals(other.adRegistrationInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdRegistrationInfo[ adRegistrationInfoId=" + adRegistrationInfoId + " ]";
    }
    
}
