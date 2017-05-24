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
@Table(name = "ad_window")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdWindow.findAll", query = "SELECT a FROM AdWindow a"),
    @NamedQuery(name = "AdWindow.findByAdWindowId", query = "SELECT a FROM AdWindow a WHERE a.adWindowId = :adWindowId"),
    @NamedQuery(name = "AdWindow.findByIsactive", query = "SELECT a FROM AdWindow a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdWindow.findByCreated", query = "SELECT a FROM AdWindow a WHERE a.created = :created"),
    @NamedQuery(name = "AdWindow.findByCreatedby", query = "SELECT a FROM AdWindow a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdWindow.findByUpdated", query = "SELECT a FROM AdWindow a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdWindow.findByUpdatedby", query = "SELECT a FROM AdWindow a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdWindow.findByName", query = "SELECT a FROM AdWindow a WHERE a.name = :name"),
    @NamedQuery(name = "AdWindow.findByDescription", query = "SELECT a FROM AdWindow a WHERE a.description = :description"),
    @NamedQuery(name = "AdWindow.findByHelp", query = "SELECT a FROM AdWindow a WHERE a.help = :help"),
    @NamedQuery(name = "AdWindow.findByWindowtype", query = "SELECT a FROM AdWindow a WHERE a.windowtype = :windowtype"),
    @NamedQuery(name = "AdWindow.findByIssotrx", query = "SELECT a FROM AdWindow a WHERE a.issotrx = :issotrx"),
    @NamedQuery(name = "AdWindow.findByProcessing", query = "SELECT a FROM AdWindow a WHERE a.processing = :processing"),
    @NamedQuery(name = "AdWindow.findByIsdefault", query = "SELECT a FROM AdWindow a WHERE a.isdefault = :isdefault")})
public class AdWindow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_window_id")
    private String adWindowId;
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
    @Size(max = 60)
    @Column(name = "windowtype")
    private String windowtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issotrx")
    private Character issotrx;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "isdefault")
    private Character isdefault;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adWindowId")
    private List<AdPreference> adPreferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adWindowId")
    private List<AdMenu> adMenuList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adWindowId")
    private List<AdWfNode> adWfNodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWindowId")
    private List<AdWindowAccess> adWindowAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWindowId")
    private List<AdTab> adTabList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adWindowId")
    private List<AdTable> adTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "poWindowId")
    private List<AdTable> adTableList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adWindowId")
    private List<AdWindowTrl> adWindowTrlList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_image_id", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage adImageId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdWindow() {
    }

    public AdWindow(String adWindowId) {
        this.adWindowId = adWindowId;
    }

    public AdWindow(String adWindowId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character issotrx) {
        this.adWindowId = adWindowId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.issotrx = issotrx;
    }

    public String getAdWindowId() {
        return adWindowId;
    }

    public void setAdWindowId(String adWindowId) {
        this.adWindowId = adWindowId;
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

    public String getWindowtype() {
        return windowtype;
    }

    public void setWindowtype(String windowtype) {
        this.windowtype = windowtype;
    }

    public Character getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(Character issotrx) {
        this.issotrx = issotrx;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    @XmlTransient
    public List<AdPreference> getAdPreferenceList() {
        return adPreferenceList;
    }

    public void setAdPreferenceList(List<AdPreference> adPreferenceList) {
        this.adPreferenceList = adPreferenceList;
    }

    @XmlTransient
    public List<AdMenu> getAdMenuList() {
        return adMenuList;
    }

    public void setAdMenuList(List<AdMenu> adMenuList) {
        this.adMenuList = adMenuList;
    }

    @XmlTransient
    public List<AdWfNode> getAdWfNodeList() {
        return adWfNodeList;
    }

    public void setAdWfNodeList(List<AdWfNode> adWfNodeList) {
        this.adWfNodeList = adWfNodeList;
    }

    @XmlTransient
    public List<AdWindowAccess> getAdWindowAccessList() {
        return adWindowAccessList;
    }

    public void setAdWindowAccessList(List<AdWindowAccess> adWindowAccessList) {
        this.adWindowAccessList = adWindowAccessList;
    }

    @XmlTransient
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    @XmlTransient
    public List<AdTable> getAdTableList() {
        return adTableList;
    }

    public void setAdTableList(List<AdTable> adTableList) {
        this.adTableList = adTableList;
    }

    @XmlTransient
    public List<AdTable> getAdTableList1() {
        return adTableList1;
    }

    public void setAdTableList1(List<AdTable> adTableList1) {
        this.adTableList1 = adTableList1;
    }

    @XmlTransient
    public List<AdWindowTrl> getAdWindowTrlList() {
        return adWindowTrlList;
    }

    public void setAdWindowTrlList(List<AdWindowTrl> adWindowTrlList) {
        this.adWindowTrlList = adWindowTrlList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdImage getAdImageId() {
        return adImageId;
    }

    public void setAdImageId(AdImage adImageId) {
        this.adImageId = adImageId;
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
        hash += (adWindowId != null ? adWindowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdWindow)) {
            return false;
        }
        AdWindow other = (AdWindow) object;
        if ((this.adWindowId == null && other.adWindowId != null) || (this.adWindowId != null && !this.adWindowId.equals(other.adWindowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdWindow[ adWindowId=" + adWindowId + " ]";
    }
    
}
