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
@Table(name = "ad_wf_node_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdWfNodeTrl.findAll", query = "SELECT a FROM AdWfNodeTrl a"),
    @NamedQuery(name = "AdWfNodeTrl.findByAdWfNodeTrlId", query = "SELECT a FROM AdWfNodeTrl a WHERE a.adWfNodeTrlId = :adWfNodeTrlId"),
    @NamedQuery(name = "AdWfNodeTrl.findByIsactive", query = "SELECT a FROM AdWfNodeTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdWfNodeTrl.findByCreated", query = "SELECT a FROM AdWfNodeTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdWfNodeTrl.findByCreatedby", query = "SELECT a FROM AdWfNodeTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdWfNodeTrl.findByUpdated", query = "SELECT a FROM AdWfNodeTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdWfNodeTrl.findByUpdatedby", query = "SELECT a FROM AdWfNodeTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdWfNodeTrl.findByName", query = "SELECT a FROM AdWfNodeTrl a WHERE a.name = :name"),
    @NamedQuery(name = "AdWfNodeTrl.findByDescription", query = "SELECT a FROM AdWfNodeTrl a WHERE a.description = :description"),
    @NamedQuery(name = "AdWfNodeTrl.findByHelp", query = "SELECT a FROM AdWfNodeTrl a WHERE a.help = :help"),
    @NamedQuery(name = "AdWfNodeTrl.findByIstranslated", query = "SELECT a FROM AdWfNodeTrl a WHERE a.istranslated = :istranslated")})
public class AdWfNodeTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_wf_node_trl_id")
    private String adWfNodeTrlId;
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
    @JoinColumn(name = "ad_wf_node_id", referencedColumnName = "ad_wf_node_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdWfNode adWfNodeId;

    public AdWfNodeTrl() {
    }

    public AdWfNodeTrl(String adWfNodeTrlId) {
        this.adWfNodeTrlId = adWfNodeTrlId;
    }

    public AdWfNodeTrl(String adWfNodeTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.adWfNodeTrlId = adWfNodeTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getAdWfNodeTrlId() {
        return adWfNodeTrlId;
    }

    public void setAdWfNodeTrlId(String adWfNodeTrlId) {
        this.adWfNodeTrlId = adWfNodeTrlId;
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

    public AdWfNode getAdWfNodeId() {
        return adWfNodeId;
    }

    public void setAdWfNodeId(AdWfNode adWfNodeId) {
        this.adWfNodeId = adWfNodeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adWfNodeTrlId != null ? adWfNodeTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdWfNodeTrl)) {
            return false;
        }
        AdWfNodeTrl other = (AdWfNodeTrl) object;
        if ((this.adWfNodeTrlId == null && other.adWfNodeTrlId != null) || (this.adWfNodeTrlId != null && !this.adWfNodeTrlId.equals(other.adWfNodeTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdWfNodeTrl[ adWfNodeTrlId=" + adWfNodeTrlId + " ]";
    }
    
}
