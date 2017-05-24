/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ad_textinterfaces")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTextinterfaces.findAll", query = "SELECT a FROM AdTextinterfaces a"),
    @NamedQuery(name = "AdTextinterfaces.findByAdTextinterfacesId", query = "SELECT a FROM AdTextinterfaces a WHERE a.adTextinterfacesId = :adTextinterfacesId"),
    @NamedQuery(name = "AdTextinterfaces.findByIsactive", query = "SELECT a FROM AdTextinterfaces a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTextinterfaces.findByCreated", query = "SELECT a FROM AdTextinterfaces a WHERE a.created = :created"),
    @NamedQuery(name = "AdTextinterfaces.findByCreatedby", query = "SELECT a FROM AdTextinterfaces a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTextinterfaces.findByUpdated", query = "SELECT a FROM AdTextinterfaces a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTextinterfaces.findByUpdatedby", query = "SELECT a FROM AdTextinterfaces a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTextinterfaces.findByText", query = "SELECT a FROM AdTextinterfaces a WHERE a.text = :text"),
    @NamedQuery(name = "AdTextinterfaces.findByFilename", query = "SELECT a FROM AdTextinterfaces a WHERE a.filename = :filename"),
    @NamedQuery(name = "AdTextinterfaces.findByIsused", query = "SELECT a FROM AdTextinterfaces a WHERE a.isused = :isused")})
public class AdTextinterfaces implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_textinterfaces_id")
    private String adTextinterfacesId;
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
    @Size(max = 500)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isused")
    private Character isused;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTextinterfacesId")
    private List<AdTextinterfacesTrl> adTextinterfacesTrlList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdTextinterfaces() {
    }

    public AdTextinterfaces(String adTextinterfacesId) {
        this.adTextinterfacesId = adTextinterfacesId;
    }

    public AdTextinterfaces(String adTextinterfacesId, Character isactive, Date created, String createdby, Date updated, String updatedby, String text, Character isused) {
        this.adTextinterfacesId = adTextinterfacesId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.text = text;
        this.isused = isused;
    }

    public String getAdTextinterfacesId() {
        return adTextinterfacesId;
    }

    public void setAdTextinterfacesId(String adTextinterfacesId) {
        this.adTextinterfacesId = adTextinterfacesId;
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Character getIsused() {
        return isused;
    }

    public void setIsused(Character isused) {
        this.isused = isused;
    }

    @XmlTransient
    public List<AdTextinterfacesTrl> getAdTextinterfacesTrlList() {
        return adTextinterfacesTrlList;
    }

    public void setAdTextinterfacesTrlList(List<AdTextinterfacesTrl> adTextinterfacesTrlList) {
        this.adTextinterfacesTrlList = adTextinterfacesTrlList;
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
        hash += (adTextinterfacesId != null ? adTextinterfacesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTextinterfaces)) {
            return false;
        }
        AdTextinterfaces other = (AdTextinterfaces) object;
        if ((this.adTextinterfacesId == null && other.adTextinterfacesId != null) || (this.adTextinterfacesId != null && !this.adTextinterfacesId.equals(other.adTextinterfacesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTextinterfaces[ adTextinterfacesId=" + adTextinterfacesId + " ]";
    }
    
}
