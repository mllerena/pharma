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
@Table(name = "c_projectproposaltask")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjectproposaltask.findAll", query = "SELECT c FROM CProjectproposaltask c"),
    @NamedQuery(name = "CProjectproposaltask.findByCProjectproposaltaskId", query = "SELECT c FROM CProjectproposaltask c WHERE c.cProjectproposaltaskId = :cProjectproposaltaskId"),
    @NamedQuery(name = "CProjectproposaltask.findByIsactive", query = "SELECT c FROM CProjectproposaltask c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjectproposaltask.findByCreated", query = "SELECT c FROM CProjectproposaltask c WHERE c.created = :created"),
    @NamedQuery(name = "CProjectproposaltask.findByCreatedby", query = "SELECT c FROM CProjectproposaltask c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjectproposaltask.findByUpdated", query = "SELECT c FROM CProjectproposaltask c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjectproposaltask.findByUpdatedby", query = "SELECT c FROM CProjectproposaltask c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjectproposaltask.findByNote", query = "SELECT c FROM CProjectproposaltask c WHERE c.note = :note")})
public class CProjectproposaltask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_projectproposaltask_id")
    private String cProjectproposaltaskId;
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
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_projectproposal_id", referencedColumnName = "c_projectproposal_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProjectproposal cProjectproposalId;

    public CProjectproposaltask() {
    }

    public CProjectproposaltask(String cProjectproposaltaskId) {
        this.cProjectproposaltaskId = cProjectproposaltaskId;
    }

    public CProjectproposaltask(String cProjectproposaltaskId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cProjectproposaltaskId = cProjectproposaltaskId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCProjectproposaltaskId() {
        return cProjectproposaltaskId;
    }

    public void setCProjectproposaltaskId(String cProjectproposaltaskId) {
        this.cProjectproposaltaskId = cProjectproposaltaskId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public CProjectproposal getCProjectproposalId() {
        return cProjectproposalId;
    }

    public void setCProjectproposalId(CProjectproposal cProjectproposalId) {
        this.cProjectproposalId = cProjectproposalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProjectproposaltaskId != null ? cProjectproposaltaskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjectproposaltask)) {
            return false;
        }
        CProjectproposaltask other = (CProjectproposaltask) object;
        if ((this.cProjectproposaltaskId == null && other.cProjectproposaltaskId != null) || (this.cProjectproposaltaskId != null && !this.cProjectproposaltaskId.equals(other.cProjectproposaltaskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjectproposaltask[ cProjectproposaltaskId=" + cProjectproposaltaskId + " ]";
    }
    
}
