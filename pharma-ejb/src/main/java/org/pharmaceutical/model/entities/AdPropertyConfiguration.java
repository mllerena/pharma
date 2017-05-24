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
@Table(name = "ad_property_configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdPropertyConfiguration.findAll", query = "SELECT a FROM AdPropertyConfiguration a"),
    @NamedQuery(name = "AdPropertyConfiguration.findByAdPropertyConfigurationId", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.adPropertyConfigurationId = :adPropertyConfigurationId"),
    @NamedQuery(name = "AdPropertyConfiguration.findByIsactive", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdPropertyConfiguration.findByCreated", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.created = :created"),
    @NamedQuery(name = "AdPropertyConfiguration.findByCreatedby", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdPropertyConfiguration.findByUpdated", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdPropertyConfiguration.findByUpdatedby", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdPropertyConfiguration.findByProperty", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.property = :property"),
    @NamedQuery(name = "AdPropertyConfiguration.findByValue", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.value = :value"),
    @NamedQuery(name = "AdPropertyConfiguration.findBySelected", query = "SELECT a FROM AdPropertyConfiguration a WHERE a.selected = :selected")})
public class AdPropertyConfiguration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_property_configuration_id")
    private String adPropertyConfigurationId;
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
    @Column(name = "property")
    private String property;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @Column(name = "selected")
    private Character selected;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdPropertyConfiguration() {
    }

    public AdPropertyConfiguration(String adPropertyConfigurationId) {
        this.adPropertyConfigurationId = adPropertyConfigurationId;
    }

    public AdPropertyConfiguration(String adPropertyConfigurationId, Character isactive, Date created, String createdby, Date updated, String updatedby, String property) {
        this.adPropertyConfigurationId = adPropertyConfigurationId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.property = property;
    }

    public String getAdPropertyConfigurationId() {
        return adPropertyConfigurationId;
    }

    public void setAdPropertyConfigurationId(String adPropertyConfigurationId) {
        this.adPropertyConfigurationId = adPropertyConfigurationId;
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

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Character getSelected() {
        return selected;
    }

    public void setSelected(Character selected) {
        this.selected = selected;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
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
        hash += (adPropertyConfigurationId != null ? adPropertyConfigurationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdPropertyConfiguration)) {
            return false;
        }
        AdPropertyConfiguration other = (AdPropertyConfiguration) object;
        if ((this.adPropertyConfigurationId == null && other.adPropertyConfigurationId != null) || (this.adPropertyConfigurationId != null && !this.adPropertyConfigurationId.equals(other.adPropertyConfigurationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdPropertyConfiguration[ adPropertyConfigurationId=" + adPropertyConfigurationId + " ]";
    }
    
}
