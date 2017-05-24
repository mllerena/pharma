/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.FetchType;
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

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ad_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdRole.findAll", query = "SELECT a FROM AdRole a"),
    @NamedQuery(name = "AdRole.findByAdRoleId", query = "SELECT a FROM AdRole a WHERE a.adRoleId = :adRoleId"),
    @NamedQuery(name = "AdRole.findByIsactive", query = "SELECT a FROM AdRole a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdRole.findByCreated", query = "SELECT a FROM AdRole a WHERE a.created = :created"),
    @NamedQuery(name = "AdRole.findByCreatedby", query = "SELECT a FROM AdRole a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdRole.findByUpdated", query = "SELECT a FROM AdRole a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdRole.findByName", query = "SELECT a FROM AdRole a WHERE a.name = :name and a.isactive = :isactive"),
    @NamedQuery(name = "AdRole.findByUpdatedby", query = "SELECT a FROM AdRole a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdRole.findByDescription", query = "SELECT a FROM AdRole a WHERE a.description = :description"),
    @NamedQuery(name = "AdRole.findByUserlevel", query = "SELECT a FROM AdRole a WHERE a.userlevel = :userlevel"),
    @NamedQuery(name = "AdRole.findByClientlist", query = "SELECT a FROM AdRole a WHERE a.clientlist = :clientlist"),
    @NamedQuery(name = "AdRole.findByOrglist", query = "SELECT a FROM AdRole a WHERE a.orglist = :orglist"),
    @NamedQuery(name = "AdRole.findByAmtapproval", query = "SELECT a FROM AdRole a WHERE a.amtapproval = :amtapproval"),
    @NamedQuery(name = "AdRole.findByIsmanual", query = "SELECT a FROM AdRole a WHERE a.ismanual = :ismanual"),
    @NamedQuery(name = "AdRole.findByProcessing", query = "SELECT a FROM AdRole a WHERE a.processing = :processing"),
    @NamedQuery(name = "AdRole.findByIsClientAdmin", query = "SELECT a FROM AdRole a WHERE a.isClientAdmin = :isClientAdmin")})
public class AdRole extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_role_id")
    private String adRoleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class)
    private YesNo isactive;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "userlevel")
    private String userlevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "clientlist")
    private String clientlist;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "orglist")
    private String orglist;
    @Column(name = "amtapproval")
    private BigInteger amtapproval;
    @Column(name = "ismanual")
    private Character ismanual;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_client_admin")
    private Character isClientAdmin;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_tree_menu_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeMenuId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdTableAccess> adTableAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "visibleatRoleId")
    private List<AdPreference> adPreferenceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdAlertrecipient> adAlertrecipientList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "defaultAdRoleId")
    private List<AdUser> adUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdWindowAccess> adWindowAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdRoleOrgaccess> adRoleOrgaccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdTaskAccess> adTaskAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdProcessAccess> adProcessAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdFormAccess> adFormAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdWorkflowAccess> adWorkflowAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adRoleId")
    private List<AdAlert> adAlertList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdUserRoles> adUserRolesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdColumnAccess> adColumnAccessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRoleId")
    private List<AdRecordAccess> adRecordAccessList;

    public AdRole() {
    }

    public AdRole(String adRoleId) {
        this.adRoleId = adRoleId;
    }

   

    public String getAdRoleId() {
        return adRoleId;
    }

    public void setAdRoleId(String adRoleId) {
        this.adRoleId = adRoleId;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public String getClientlist() {
        return clientlist;
    }

    public void setClientlist(String clientlist) {
        this.clientlist = clientlist;
    }

    public String getOrglist() {
        return orglist;
    }

    public void setOrglist(String orglist) {
        this.orglist = orglist;
    }

    public BigInteger getAmtapproval() {
        return amtapproval;
    }

    public void setAmtapproval(BigInteger amtapproval) {
        this.amtapproval = amtapproval;
    }

    public Character getIsmanual() {
        return ismanual;
    }

    public void setIsmanual(Character ismanual) {
        this.ismanual = ismanual;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getIsClientAdmin() {
        return isClientAdmin;
    }

    public void setIsClientAdmin(Character isClientAdmin) {
        this.isClientAdmin = isClientAdmin;
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

    public AdTree getAdTreeMenuId() {
        return adTreeMenuId;
    }

    public void setAdTreeMenuId(AdTree adTreeMenuId) {
        this.adTreeMenuId = adTreeMenuId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @XmlTransient
    public List<AdTableAccess> getAdTableAccessList() {
        return adTableAccessList;
    }

    public void setAdTableAccessList(List<AdTableAccess> adTableAccessList) {
        this.adTableAccessList = adTableAccessList;
    }

    @XmlTransient
    public List<AdPreference> getAdPreferenceList() {
        return adPreferenceList;
    }

    public void setAdPreferenceList(List<AdPreference> adPreferenceList) {
        this.adPreferenceList = adPreferenceList;
    }

    @XmlTransient
    public List<AdAlertrecipient> getAdAlertrecipientList() {
        return adAlertrecipientList;
    }

    public void setAdAlertrecipientList(List<AdAlertrecipient> adAlertrecipientList) {
        this.adAlertrecipientList = adAlertrecipientList;
    }

    @XmlTransient
    public List<AdUser> getAdUserList() {
        return adUserList;
    }

    public void setAdUserList(List<AdUser> adUserList) {
        this.adUserList = adUserList;
    }

    @XmlTransient
    public List<AdWindowAccess> getAdWindowAccessList() {
        return adWindowAccessList;
    }

    public void setAdWindowAccessList(List<AdWindowAccess> adWindowAccessList) {
        this.adWindowAccessList = adWindowAccessList;
    }

    @XmlTransient
    public List<AdRoleOrgaccess> getAdRoleOrgaccessList() {
        return adRoleOrgaccessList;
    }

    public void setAdRoleOrgaccessList(List<AdRoleOrgaccess> adRoleOrgaccessList) {
        this.adRoleOrgaccessList = adRoleOrgaccessList;
    }

    @XmlTransient
    public List<AdTaskAccess> getAdTaskAccessList() {
        return adTaskAccessList;
    }

    public void setAdTaskAccessList(List<AdTaskAccess> adTaskAccessList) {
        this.adTaskAccessList = adTaskAccessList;
    }

    @XmlTransient
    public List<AdProcessAccess> getAdProcessAccessList() {
        return adProcessAccessList;
    }

    public void setAdProcessAccessList(List<AdProcessAccess> adProcessAccessList) {
        this.adProcessAccessList = adProcessAccessList;
    }

    @XmlTransient
    public List<AdFormAccess> getAdFormAccessList() {
        return adFormAccessList;
    }

    public void setAdFormAccessList(List<AdFormAccess> adFormAccessList) {
        this.adFormAccessList = adFormAccessList;
    }

    @XmlTransient
    public List<AdWorkflowAccess> getAdWorkflowAccessList() {
        return adWorkflowAccessList;
    }

    public void setAdWorkflowAccessList(List<AdWorkflowAccess> adWorkflowAccessList) {
        this.adWorkflowAccessList = adWorkflowAccessList;
    }

    @XmlTransient
    public List<AdAlert> getAdAlertList() {
        return adAlertList;
    }

    public void setAdAlertList(List<AdAlert> adAlertList) {
        this.adAlertList = adAlertList;
    }

    @XmlTransient
    public List<AdUserRoles> getAdUserRolesList() {
        return adUserRolesList;
    }

    public void setAdUserRolesList(List<AdUserRoles> adUserRolesList) {
        this.adUserRolesList = adUserRolesList;
    }

    @XmlTransient
    public List<AdColumnAccess> getAdColumnAccessList() {
        return adColumnAccessList;
    }

    public void setAdColumnAccessList(List<AdColumnAccess> adColumnAccessList) {
        this.adColumnAccessList = adColumnAccessList;
    }

    @XmlTransient
    public List<AdRecordAccess> getAdRecordAccessList() {
        return adRecordAccessList;
    }

    public void setAdRecordAccessList(List<AdRecordAccess> adRecordAccessList) {
        this.adRecordAccessList = adRecordAccessList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adRoleId != null ? adRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdRole)) {
            return false;
        }
        AdRole other = (AdRole) object;
        if ((this.adRoleId == null && other.adRoleId != null) || (this.adRoleId != null && !this.adRoleId.equals(other.adRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdRole[ adRoleId=" + adRoleId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return adRoleId;
	}
	
	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		adRoleId = id;
	}
    
}
