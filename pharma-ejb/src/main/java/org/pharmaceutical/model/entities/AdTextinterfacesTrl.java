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
@Table(name = "ad_textinterfaces_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTextinterfacesTrl.findAll", query = "SELECT a FROM AdTextinterfacesTrl a"),
    @NamedQuery(name = "AdTextinterfacesTrl.findByAdTextinterfacesTrlId", query = "SELECT a FROM AdTextinterfacesTrl a WHERE a.adTextinterfacesTrlId = :adTextinterfacesTrlId"),
    @NamedQuery(name = "AdTextinterfacesTrl.findByIsactive", query = "SELECT a FROM AdTextinterfacesTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTextinterfacesTrl.findByCreated", query = "SELECT a FROM AdTextinterfacesTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdTextinterfacesTrl.findByCreatedby", query = "SELECT a FROM AdTextinterfacesTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTextinterfacesTrl.findByUpdated", query = "SELECT a FROM AdTextinterfacesTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTextinterfacesTrl.findByUpdatedby", query = "SELECT a FROM AdTextinterfacesTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTextinterfacesTrl.findByText", query = "SELECT a FROM AdTextinterfacesTrl a WHERE a.text = :text"),
    @NamedQuery(name = "AdTextinterfacesTrl.findByIstranslated", query = "SELECT a FROM AdTextinterfacesTrl a WHERE a.istranslated = :istranslated")})
public class AdTextinterfacesTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_textinterfaces_trl_id")
    private String adTextinterfacesTrlId;
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
    @Size(min = 1, max = 4000)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslated")
    private Character istranslated;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_textinterfaces_id", referencedColumnName = "ad_textinterfaces_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTextinterfaces adTextinterfacesId;

    public AdTextinterfacesTrl() {
    }

    public AdTextinterfacesTrl(String adTextinterfacesTrlId) {
        this.adTextinterfacesTrlId = adTextinterfacesTrlId;
    }

    public AdTextinterfacesTrl(String adTextinterfacesTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String text, Character istranslated) {
        this.adTextinterfacesTrlId = adTextinterfacesTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.text = text;
        this.istranslated = istranslated;
    }

    public String getAdTextinterfacesTrlId() {
        return adTextinterfacesTrlId;
    }

    public void setAdTextinterfacesTrlId(String adTextinterfacesTrlId) {
        this.adTextinterfacesTrlId = adTextinterfacesTrlId;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Character getIstranslated() {
        return istranslated;
    }

    public void setIstranslated(Character istranslated) {
        this.istranslated = istranslated;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdLanguage getAdLanguage() {
        return adLanguage;
    }

    public void setAdLanguage(AdLanguage adLanguage) {
        this.adLanguage = adLanguage;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdTextinterfaces getAdTextinterfacesId() {
        return adTextinterfacesId;
    }

    public void setAdTextinterfacesId(AdTextinterfaces adTextinterfacesId) {
        this.adTextinterfacesId = adTextinterfacesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTextinterfacesTrlId != null ? adTextinterfacesTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTextinterfacesTrl)) {
            return false;
        }
        AdTextinterfacesTrl other = (AdTextinterfacesTrl) object;
        if ((this.adTextinterfacesTrlId == null && other.adTextinterfacesTrlId != null) || (this.adTextinterfacesTrlId != null && !this.adTextinterfacesTrlId.equals(other.adTextinterfacesTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTextinterfacesTrl[ adTextinterfacesTrlId=" + adTextinterfacesTrlId + " ]";
    }
    
}
