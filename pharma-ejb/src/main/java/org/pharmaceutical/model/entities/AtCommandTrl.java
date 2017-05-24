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
@Table(name = "at_command_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtCommandTrl.findAll", query = "SELECT a FROM AtCommandTrl a"),
    @NamedQuery(name = "AtCommandTrl.findByAtCommandTrlId", query = "SELECT a FROM AtCommandTrl a WHERE a.atCommandTrlId = :atCommandTrlId"),
    @NamedQuery(name = "AtCommandTrl.findByIsactive", query = "SELECT a FROM AtCommandTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AtCommandTrl.findByCreated", query = "SELECT a FROM AtCommandTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AtCommandTrl.findByCreatedby", query = "SELECT a FROM AtCommandTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AtCommandTrl.findByUpdated", query = "SELECT a FROM AtCommandTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AtCommandTrl.findByUpdatedby", query = "SELECT a FROM AtCommandTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AtCommandTrl.findByName", query = "SELECT a FROM AtCommandTrl a WHERE a.name = :name"),
    @NamedQuery(name = "AtCommandTrl.findByDescription", query = "SELECT a FROM AtCommandTrl a WHERE a.description = :description"),
    @NamedQuery(name = "AtCommandTrl.findByIstranslated", query = "SELECT a FROM AtCommandTrl a WHERE a.istranslated = :istranslated"),
    @NamedQuery(name = "AtCommandTrl.findByArghelp1", query = "SELECT a FROM AtCommandTrl a WHERE a.arghelp1 = :arghelp1"),
    @NamedQuery(name = "AtCommandTrl.findByArghelp2", query = "SELECT a FROM AtCommandTrl a WHERE a.arghelp2 = :arghelp2"),
    @NamedQuery(name = "AtCommandTrl.findByArghelp3", query = "SELECT a FROM AtCommandTrl a WHERE a.arghelp3 = :arghelp3")})
public class AtCommandTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "at_command_trl_id")
    private String atCommandTrlId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslated")
    private Character istranslated;
    @Size(max = 60)
    @Column(name = "arghelp1")
    private String arghelp1;
    @Size(max = 60)
    @Column(name = "arghelp2")
    private String arghelp2;
    @Size(max = 60)
    @Column(name = "arghelp3")
    private String arghelp3;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "at_command_id", referencedColumnName = "at_command_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AtCommand atCommandId;

    public AtCommandTrl() {
    }

    public AtCommandTrl(String atCommandTrlId) {
        this.atCommandTrlId = atCommandTrlId;
    }

    public AtCommandTrl(String atCommandTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istranslated) {
        this.atCommandTrlId = atCommandTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istranslated = istranslated;
    }

    public String getAtCommandTrlId() {
        return atCommandTrlId;
    }

    public void setAtCommandTrlId(String atCommandTrlId) {
        this.atCommandTrlId = atCommandTrlId;
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

    public Character getIstranslated() {
        return istranslated;
    }

    public void setIstranslated(Character istranslated) {
        this.istranslated = istranslated;
    }

    public String getArghelp1() {
        return arghelp1;
    }

    public void setArghelp1(String arghelp1) {
        this.arghelp1 = arghelp1;
    }

    public String getArghelp2() {
        return arghelp2;
    }

    public void setArghelp2(String arghelp2) {
        this.arghelp2 = arghelp2;
    }

    public String getArghelp3() {
        return arghelp3;
    }

    public void setArghelp3(String arghelp3) {
        this.arghelp3 = arghelp3;
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

    public AtCommand getAtCommandId() {
        return atCommandId;
    }

    public void setAtCommandId(AtCommand atCommandId) {
        this.atCommandId = atCommandId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atCommandTrlId != null ? atCommandTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtCommandTrl)) {
            return false;
        }
        AtCommandTrl other = (AtCommandTrl) object;
        if ((this.atCommandTrlId == null && other.atCommandTrlId != null) || (this.atCommandTrlId != null && !this.atCommandTrlId.equals(other.atCommandTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AtCommandTrl[ atCommandTrlId=" + atCommandTrlId + " ]";
    }
    
}
