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
@Table(name = "ad_preference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdPreference.findAll", query = "SELECT a FROM AdPreference a"),
    @NamedQuery(name = "AdPreference.findByAdPreferenceId", query = "SELECT a FROM AdPreference a WHERE a.adPreferenceId = :adPreferenceId"),
    @NamedQuery(name = "AdPreference.findByIsactive", query = "SELECT a FROM AdPreference a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdPreference.findByCreated", query = "SELECT a FROM AdPreference a WHERE a.created = :created"),
    @NamedQuery(name = "AdPreference.findByCreatedby", query = "SELECT a FROM AdPreference a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdPreference.findByUpdated", query = "SELECT a FROM AdPreference a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdPreference.findByUpdatedby", query = "SELECT a FROM AdPreference a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdPreference.findByAttribute", query = "SELECT a FROM AdPreference a WHERE a.attribute = :attribute"),
    @NamedQuery(name = "AdPreference.findByValue", query = "SELECT a FROM AdPreference a WHERE a.value = :value"),
    @NamedQuery(name = "AdPreference.findByProperty", query = "SELECT a FROM AdPreference a WHERE a.property = :property"),
    @NamedQuery(name = "AdPreference.findByIspropertylist", query = "SELECT a FROM AdPreference a WHERE a.ispropertylist = :ispropertylist"),
    @NamedQuery(name = "AdPreference.findBySelected", query = "SELECT a FROM AdPreference a WHERE a.selected = :selected")})
public class AdPreference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_preference_id")
    private String adPreferenceId;
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
    @Column(name = "attribute")
    private String attribute;
    @Size(max = 2147483647)
    @Column(name = "value")
    private String value;
    @Size(max = 60)
    @Column(name = "property")
    private String property;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispropertylist")
    private Character ispropertylist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "selected")
    private Character selected;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "visibleat_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient visibleatClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "visibleat_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg visibleatOrgId;
    @JoinColumn(name = "visibleat_role_id", referencedColumnName = "ad_role_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdRole visibleatRoleId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "ad_window_id", referencedColumnName = "ad_window_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdWindow adWindowId;

    public AdPreference() {
    }

    public AdPreference(String adPreferenceId) {
        this.adPreferenceId = adPreferenceId;
    }

    public AdPreference(String adPreferenceId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character ispropertylist, Character selected) {
        this.adPreferenceId = adPreferenceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.ispropertylist = ispropertylist;
        this.selected = selected;
    }

    public String getAdPreferenceId() {
        return adPreferenceId;
    }

    public void setAdPreferenceId(String adPreferenceId) {
        this.adPreferenceId = adPreferenceId;
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

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Character getIspropertylist() {
        return ispropertylist;
    }

    public void setIspropertylist(Character ispropertylist) {
        this.ispropertylist = ispropertylist;
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

    public AdClient getVisibleatClientId() {
        return visibleatClientId;
    }

    public void setVisibleatClientId(AdClient visibleatClientId) {
        this.visibleatClientId = visibleatClientId;
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

    public AdOrg getVisibleatOrgId() {
        return visibleatOrgId;
    }

    public void setVisibleatOrgId(AdOrg visibleatOrgId) {
        this.visibleatOrgId = visibleatOrgId;
    }

    public AdRole getVisibleatRoleId() {
        return visibleatRoleId;
    }

    public void setVisibleatRoleId(AdRole visibleatRoleId) {
        this.visibleatRoleId = visibleatRoleId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public AdWindow getAdWindowId() {
        return adWindowId;
    }

    public void setAdWindowId(AdWindow adWindowId) {
        this.adWindowId = adWindowId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adPreferenceId != null ? adPreferenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdPreference)) {
            return false;
        }
        AdPreference other = (AdPreference) object;
        if ((this.adPreferenceId == null && other.adPreferenceId != null) || (this.adPreferenceId != null && !this.adPreferenceId.equals(other.adPreferenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdPreference[ adPreferenceId=" + adPreferenceId + " ]";
    }
    
}
