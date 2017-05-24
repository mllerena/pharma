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
@Table(name = "ad_process_para_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdProcessParaTrl.findAll", query = "SELECT a FROM AdProcessParaTrl a"),
    @NamedQuery(name = "AdProcessParaTrl.findByAdProcessParaTrlId", query = "SELECT a FROM AdProcessParaTrl a WHERE a.adProcessParaTrlId = :adProcessParaTrlId"),
    @NamedQuery(name = "AdProcessParaTrl.findByIsactive", query = "SELECT a FROM AdProcessParaTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdProcessParaTrl.findByCreated", query = "SELECT a FROM AdProcessParaTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdProcessParaTrl.findByCreatedby", query = "SELECT a FROM AdProcessParaTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdProcessParaTrl.findByUpdated", query = "SELECT a FROM AdProcessParaTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdProcessParaTrl.findByUpdatedby", query = "SELECT a FROM AdProcessParaTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdProcessParaTrl.findByName", query = "SELECT a FROM AdProcessParaTrl a WHERE a.name = :name"),
    @NamedQuery(name = "AdProcessParaTrl.findByDescription", query = "SELECT a FROM AdProcessParaTrl a WHERE a.description = :description"),
    @NamedQuery(name = "AdProcessParaTrl.findByHelp", query = "SELECT a FROM AdProcessParaTrl a WHERE a.help = :help"),
    @NamedQuery(name = "AdProcessParaTrl.findByIstranslated", query = "SELECT a FROM AdProcessParaTrl a WHERE a.istranslated = :istranslated")})
public class AdProcessParaTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_process_para_trl_id")
    private String adProcessParaTrlId;
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
    @JoinColumn(name = "ad_process_para_id", referencedColumnName = "ad_process_para_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdProcessPara adProcessParaId;

    public AdProcessParaTrl() {
    }

    public AdProcessParaTrl(String adProcessParaTrlId) {
        this.adProcessParaTrlId = adProcessParaTrlId;
    }

    public AdProcessParaTrl(String adProcessParaTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.adProcessParaTrlId = adProcessParaTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getAdProcessParaTrlId() {
        return adProcessParaTrlId;
    }

    public void setAdProcessParaTrlId(String adProcessParaTrlId) {
        this.adProcessParaTrlId = adProcessParaTrlId;
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

    public AdProcessPara getAdProcessParaId() {
        return adProcessParaId;
    }

    public void setAdProcessParaId(AdProcessPara adProcessParaId) {
        this.adProcessParaId = adProcessParaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adProcessParaTrlId != null ? adProcessParaTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdProcessParaTrl)) {
            return false;
        }
        AdProcessParaTrl other = (AdProcessParaTrl) object;
        if ((this.adProcessParaTrlId == null && other.adProcessParaTrlId != null) || (this.adProcessParaTrlId != null && !this.adProcessParaTrlId.equals(other.adProcessParaTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdProcessParaTrl[ adProcessParaTrlId=" + adProcessParaTrlId + " ]";
    }
    
}