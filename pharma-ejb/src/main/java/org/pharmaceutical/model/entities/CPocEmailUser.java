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
@Table(name = "c_poc_email_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPocEmailUser.findAll", query = "SELECT c FROM CPocEmailUser c"),
    @NamedQuery(name = "CPocEmailUser.findByCPocEmailUserId", query = "SELECT c FROM CPocEmailUser c WHERE c.cPocEmailUserId = :cPocEmailUserId"),
    @NamedQuery(name = "CPocEmailUser.findByIsactive", query = "SELECT c FROM CPocEmailUser c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPocEmailUser.findByCreated", query = "SELECT c FROM CPocEmailUser c WHERE c.created = :created"),
    @NamedQuery(name = "CPocEmailUser.findByCreatedby", query = "SELECT c FROM CPocEmailUser c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPocEmailUser.findByUpdated", query = "SELECT c FROM CPocEmailUser c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPocEmailUser.findByUpdatedby", query = "SELECT c FROM CPocEmailUser c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPocEmailUser.findByAddressType", query = "SELECT c FROM CPocEmailUser c WHERE c.addressType = :addressType")})
public class CPocEmailUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_poc_email_user_id")
    private String cPocEmailUserId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "address_type")
    private String addressType;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_poc_email_id", referencedColumnName = "c_poc_email_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPocEmail cPocEmailId;

    public CPocEmailUser() {
    }

    public CPocEmailUser(String cPocEmailUserId) {
        this.cPocEmailUserId = cPocEmailUserId;
    }

    public CPocEmailUser(String cPocEmailUserId, String addressType) {
        this.cPocEmailUserId = cPocEmailUserId;
        this.addressType = addressType;
    }

    public String getCPocEmailUserId() {
        return cPocEmailUserId;
    }

    public void setCPocEmailUserId(String cPocEmailUserId) {
        this.cPocEmailUserId = cPocEmailUserId;
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

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CPocEmail getCPocEmailId() {
        return cPocEmailId;
    }

    public void setCPocEmailId(CPocEmail cPocEmailId) {
        this.cPocEmailId = cPocEmailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPocEmailUserId != null ? cPocEmailUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPocEmailUser)) {
            return false;
        }
        CPocEmailUser other = (CPocEmailUser) object;
        if ((this.cPocEmailUserId == null && other.cPocEmailUserId != null) || (this.cPocEmailUserId != null && !this.cPocEmailUserId.equals(other.cPocEmailUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPocEmailUser[ cPocEmailUserId=" + cPocEmailUserId + " ]";
    }
    
}
