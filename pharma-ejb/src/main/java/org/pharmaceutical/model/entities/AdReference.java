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
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "ad_reference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdReference.findAll", query = "SELECT a FROM AdReference a"),
    @NamedQuery(name = "AdReference.findByAdReferenceId", query = "SELECT a FROM AdReference a WHERE a.adReferenceId = :adReferenceId"),
    @NamedQuery(name = "AdReference.findByIsactive", query = "SELECT a FROM AdReference a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdReference.findByCreated", query = "SELECT a FROM AdReference a WHERE a.created = :created"),
    @NamedQuery(name = "AdReference.findByCreatedby", query = "SELECT a FROM AdReference a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdReference.findByUpdated", query = "SELECT a FROM AdReference a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdReference.findByUpdatedby", query = "SELECT a FROM AdReference a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdReference.findByName", query = "SELECT a FROM AdReference a WHERE a.name = :name"),
    @NamedQuery(name = "AdReference.findByDescription", query = "SELECT a FROM AdReference a WHERE a.description = :description"),
    @NamedQuery(name = "AdReference.findByHelp", query = "SELECT a FROM AdReference a WHERE a.help = :help"),
    @NamedQuery(name = "AdReference.findByValidationtype", query = "SELECT a FROM AdReference a WHERE a.validationtype = :validationtype"),
    @NamedQuery(name = "AdReference.findByVformat", query = "SELECT a FROM AdReference a WHERE a.vformat = :vformat"),
    @NamedQuery(name = "AdReference.findByIsbasereference", query = "SELECT a FROM AdReference a WHERE a.isbasereference = :isbasereference"),
    @NamedQuery(name = "AdReference.findByModelImpl", query = "SELECT a FROM AdReference a WHERE a.modelImpl = :modelImpl"),
    @NamedQuery(name = "AdReference.findByWadImpl", query = "SELECT a FROM AdReference a WHERE a.wadImpl = :wadImpl"),
    @NamedQuery(name = "AdReference.findByUiImpl", query = "SELECT a FROM AdReference a WHERE a.uiImpl = :uiImpl"),
    @NamedQuery(name = "AdReference.findByIsvaluedisplayed", query = "SELECT a FROM AdReference a WHERE a.isvaluedisplayed = :isvaluedisplayed")})
public class AdReference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_reference_id")
    private String adReferenceId;
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
    @Column(name = "validationtype")
    private String validationtype;
    @Size(max = 40)
    @Column(name = "vformat")
    private String vformat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbasereference")
    private Character isbasereference;
    @Size(max = 300)
    @Column(name = "model_impl")
    private String modelImpl;
    @Size(max = 300)
    @Column(name = "wad_impl")
    private String wadImpl;
    @Size(max = 300)
    @Column(name = "ui_impl")
    private String uiImpl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isvaluedisplayed")
    private Character isvaluedisplayed;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adReferenceId")
    private List<AdRefList> adRefListList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adReferenceId")
    private List<AdColumn> adColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adReferenceValueId")
    private List<AdColumn> adColumnList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adReferenceId")
    private List<AdRefSearch> adRefSearchList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adReferenceId")
    private List<AdReferenceTrl> adReferenceTrlList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adReference")
    private AdRefTable adRefTable;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adReferenceId")
    private List<AdModelObject> adModelObjectList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "parentreferenceId")
    private List<AdReference> adReferenceList;
    @JoinColumn(name = "parentreference_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdReference parentreferenceId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adReferenceId")
    private List<AdProcessPara> adProcessParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adReferenceValueId")
    private List<AdProcessPara> adProcessParaList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adReferenceValueId")
    private List<FinPayExecProcessPara> finPayExecProcessParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adReferenceId")
    private List<FinPayExecProcessPara> finPayExecProcessParaList1;

    public AdReference() {
    }

    public AdReference(String adReferenceId) {
        this.adReferenceId = adReferenceId;
    }

    public AdReference(String adReferenceId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isbasereference, Character isvaluedisplayed) {
        this.adReferenceId = adReferenceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isbasereference = isbasereference;
        this.isvaluedisplayed = isvaluedisplayed;
    }

    public String getAdReferenceId() {
        return adReferenceId;
    }

    public void setAdReferenceId(String adReferenceId) {
        this.adReferenceId = adReferenceId;
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

    public String getValidationtype() {
        return validationtype;
    }

    public void setValidationtype(String validationtype) {
        this.validationtype = validationtype;
    }

    public String getVformat() {
        return vformat;
    }

    public void setVformat(String vformat) {
        this.vformat = vformat;
    }

    public Character getIsbasereference() {
        return isbasereference;
    }

    public void setIsbasereference(Character isbasereference) {
        this.isbasereference = isbasereference;
    }

    public String getModelImpl() {
        return modelImpl;
    }

    public void setModelImpl(String modelImpl) {
        this.modelImpl = modelImpl;
    }

    public String getWadImpl() {
        return wadImpl;
    }

    public void setWadImpl(String wadImpl) {
        this.wadImpl = wadImpl;
    }

    public String getUiImpl() {
        return uiImpl;
    }

    public void setUiImpl(String uiImpl) {
        this.uiImpl = uiImpl;
    }

    public Character getIsvaluedisplayed() {
        return isvaluedisplayed;
    }

    public void setIsvaluedisplayed(Character isvaluedisplayed) {
        this.isvaluedisplayed = isvaluedisplayed;
    }

    @XmlTransient
    public List<AdRefList> getAdRefListList() {
        return adRefListList;
    }

    public void setAdRefListList(List<AdRefList> adRefListList) {
        this.adRefListList = adRefListList;
    }

    @XmlTransient
    public List<AdColumn> getAdColumnList() {
        return adColumnList;
    }

    public void setAdColumnList(List<AdColumn> adColumnList) {
        this.adColumnList = adColumnList;
    }

    @XmlTransient
    public List<AdColumn> getAdColumnList1() {
        return adColumnList1;
    }

    public void setAdColumnList1(List<AdColumn> adColumnList1) {
        this.adColumnList1 = adColumnList1;
    }

    @XmlTransient
    public List<AdRefSearch> getAdRefSearchList() {
        return adRefSearchList;
    }

    public void setAdRefSearchList(List<AdRefSearch> adRefSearchList) {
        this.adRefSearchList = adRefSearchList;
    }

    @XmlTransient
    public List<AdReferenceTrl> getAdReferenceTrlList() {
        return adReferenceTrlList;
    }

    public void setAdReferenceTrlList(List<AdReferenceTrl> adReferenceTrlList) {
        this.adReferenceTrlList = adReferenceTrlList;
    }

    public AdRefTable getAdRefTable() {
        return adRefTable;
    }

    public void setAdRefTable(AdRefTable adRefTable) {
        this.adRefTable = adRefTable;
    }

    @XmlTransient
    public List<AdModelObject> getAdModelObjectList() {
        return adModelObjectList;
    }

    public void setAdModelObjectList(List<AdModelObject> adModelObjectList) {
        this.adModelObjectList = adModelObjectList;
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

    @XmlTransient
    public List<AdReference> getAdReferenceList() {
        return adReferenceList;
    }

    public void setAdReferenceList(List<AdReference> adReferenceList) {
        this.adReferenceList = adReferenceList;
    }

    public AdReference getParentreferenceId() {
        return parentreferenceId;
    }

    public void setParentreferenceId(AdReference parentreferenceId) {
        this.parentreferenceId = parentreferenceId;
    }

    @XmlTransient
    public List<AdProcessPara> getAdProcessParaList() {
        return adProcessParaList;
    }

    public void setAdProcessParaList(List<AdProcessPara> adProcessParaList) {
        this.adProcessParaList = adProcessParaList;
    }

    @XmlTransient
    public List<AdProcessPara> getAdProcessParaList1() {
        return adProcessParaList1;
    }

    public void setAdProcessParaList1(List<AdProcessPara> adProcessParaList1) {
        this.adProcessParaList1 = adProcessParaList1;
    }

    @XmlTransient
    public List<FinPayExecProcessPara> getFinPayExecProcessParaList() {
        return finPayExecProcessParaList;
    }

    public void setFinPayExecProcessParaList(List<FinPayExecProcessPara> finPayExecProcessParaList) {
        this.finPayExecProcessParaList = finPayExecProcessParaList;
    }

    @XmlTransient
    public List<FinPayExecProcessPara> getFinPayExecProcessParaList1() {
        return finPayExecProcessParaList1;
    }

    public void setFinPayExecProcessParaList1(List<FinPayExecProcessPara> finPayExecProcessParaList1) {
        this.finPayExecProcessParaList1 = finPayExecProcessParaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adReferenceId != null ? adReferenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdReference)) {
            return false;
        }
        AdReference other = (AdReference) object;
        if ((this.adReferenceId == null && other.adReferenceId != null) || (this.adReferenceId != null && !this.adReferenceId.equals(other.adReferenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdReference[ adReferenceId=" + adReferenceId + " ]";
    }
    
}
