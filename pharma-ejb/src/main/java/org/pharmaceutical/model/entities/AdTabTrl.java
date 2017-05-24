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
@Table(name = "ad_tab_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTabTrl.findAll", query = "SELECT a FROM AdTabTrl a"),
    @NamedQuery(name = "AdTabTrl.findByAdTabTrlId", query = "SELECT a FROM AdTabTrl a WHERE a.adTabTrlId = :adTabTrlId"),
    @NamedQuery(name = "AdTabTrl.findByIsactive", query = "SELECT a FROM AdTabTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTabTrl.findByCreated", query = "SELECT a FROM AdTabTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdTabTrl.findByCreatedby", query = "SELECT a FROM AdTabTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTabTrl.findByUpdated", query = "SELECT a FROM AdTabTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTabTrl.findByUpdatedby", query = "SELECT a FROM AdTabTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTabTrl.findByName", query = "SELECT a FROM AdTabTrl a WHERE a.name = :name"),
    @NamedQuery(name = "AdTabTrl.findByDescription", query = "SELECT a FROM AdTabTrl a WHERE a.description = :description"),
    @NamedQuery(name = "AdTabTrl.findByHelp", query = "SELECT a FROM AdTabTrl a WHERE a.help = :help"),
    @NamedQuery(name = "AdTabTrl.findByCommitwarning", query = "SELECT a FROM AdTabTrl a WHERE a.commitwarning = :commitwarning"),
    @NamedQuery(name = "AdTabTrl.findByIstranslated", query = "SELECT a FROM AdTabTrl a WHERE a.istranslated = :istranslated")})
public class AdTabTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_tab_trl_id")
    private String adTabTrlId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Size(max = 2000)
    @Column(name = "commitwarning")
    private String commitwarning;
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
    @JoinColumn(name = "ad_tab_id", referencedColumnName = "ad_tab_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTab adTabId;

    public AdTabTrl() {
    }

    public AdTabTrl(String adTabTrlId) {
        this.adTabTrlId = adTabTrlId;
    }

    public AdTabTrl(String adTabTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.adTabTrlId = adTabTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getAdTabTrlId() {
        return adTabTrlId;
    }

    public void setAdTabTrlId(String adTabTrlId) {
        this.adTabTrlId = adTabTrlId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getCommitwarning() {
        return commitwarning;
    }

    public void setCommitwarning(String commitwarning) {
        this.commitwarning = commitwarning;
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

    public AdTab getAdTabId() {
        return adTabId;
    }

    public void setAdTabId(AdTab adTabId) {
        this.adTabId = adTabId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTabTrlId != null ? adTabTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTabTrl)) {
            return false;
        }
        AdTabTrl other = (AdTabTrl) object;
        if ((this.adTabTrlId == null && other.adTabTrlId != null) || (this.adTabTrlId != null && !this.adTabTrlId.equals(other.adTabTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTabTrl[ adTabTrlId=" + adTabTrlId + " ]";
    }
    
}
