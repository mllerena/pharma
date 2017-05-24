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
import javax.persistence.FetchType;
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
@Table(name = "ad_language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdLanguage.findAll", query = "SELECT a FROM AdLanguage a"),
    @NamedQuery(name = "AdLanguage.findByAdLanguageId", query = "SELECT a FROM AdLanguage a WHERE a.adLanguageId = :adLanguageId"),
    @NamedQuery(name = "AdLanguage.findByAdLanguage", query = "SELECT a FROM AdLanguage a WHERE a.adLanguage = :adLanguage"),
    @NamedQuery(name = "AdLanguage.findByIsactive", query = "SELECT a FROM AdLanguage a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdLanguage.findByCreated", query = "SELECT a FROM AdLanguage a WHERE a.created = :created"),
    @NamedQuery(name = "AdLanguage.findByCreatedby", query = "SELECT a FROM AdLanguage a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdLanguage.findByUpdated", query = "SELECT a FROM AdLanguage a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdLanguage.findByUpdatedby", query = "SELECT a FROM AdLanguage a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdLanguage.findByName", query = "SELECT a FROM AdLanguage a WHERE a.name = :name"),
    @NamedQuery(name = "AdLanguage.findByLanguageiso", query = "SELECT a FROM AdLanguage a WHERE a.languageiso = :languageiso"),
    @NamedQuery(name = "AdLanguage.findByCountrycode", query = "SELECT a FROM AdLanguage a WHERE a.countrycode = :countrycode"),
    @NamedQuery(name = "AdLanguage.findByIsbaselanguage", query = "SELECT a FROM AdLanguage a WHERE a.isbaselanguage = :isbaselanguage"),
    @NamedQuery(name = "AdLanguage.findByIssystemlanguage", query = "SELECT a FROM AdLanguage a WHERE a.issystemlanguage = :issystemlanguage"),
    @NamedQuery(name = "AdLanguage.findByProcessing", query = "SELECT a FROM AdLanguage a WHERE a.processing = :processing"),
    @NamedQuery(name = "AdLanguage.findByPixelsize", query = "SELECT a FROM AdLanguage a WHERE a.pixelsize = :pixelsize"),
    @NamedQuery(name = "AdLanguage.findByTranslatedby", query = "SELECT a FROM AdLanguage a WHERE a.translatedby = :translatedby"),
    @NamedQuery(name = "AdLanguage.findByIsrtl", query = "SELECT a FROM AdLanguage a WHERE a.isrtl = :isrtl")})
public class AdLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_language_id")
    private String adLanguageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ad_language")
    private String adLanguage;
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
    @Size(max = 2)
    @Column(name = "languageiso")
    private String languageiso;
    @Size(max = 2)
    @Column(name = "countrycode")
    private String countrycode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbaselanguage")
    private Character isbaselanguage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issystemlanguage")
    private Character issystemlanguage;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "pixelsize")
    private Long pixelsize;
    @Size(max = 255)
    @Column(name = "translatedby")
    private String translatedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isrtl")
    private Character isrtl;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CTaxcategoryTrl> cTaxcategoryTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CCountryTrl> cCountryTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adLanguage")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdMessageTrl> adMessageTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdWfNodeTrl> adWfNodeTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CDoctypeTrl> cDoctypeTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CTaxTrl> cTaxTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdElementTrl> adElementTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdFormTrl> adFormTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CGreetingTrl> cGreetingTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdRefListTrl> adRefListTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdTaskTrl> adTaskTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AtCommandTrl> atCommandTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdModuleTrl> adModuleTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adLanguage")
    private List<AdClient> adClientList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CElementvalueTrl> cElementvalueTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdReferenceTrl> adReferenceTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdTextinterfacesTrl> adTextinterfacesTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "defaultAdLanguage")
    private List<AdUser> adUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adLanguage")
    private List<AtTestdocument> atTestdocumentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdAlertruleTrl> adAlertruleTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CCurrencyTrl> cCurrencyTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adLanguage")
    private List<AdModule> adModuleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdFieldTrl> adFieldTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdWorkflowTrl> adWorkflowTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdProcessParaTrl> adProcessParaTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdFieldgroupTrl> adFieldgroupTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<MProductTrl> mProductTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdWindowTrl> adWindowTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdProcessTrl> adProcessTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdMonthTrl> adMonthTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adLanguage")
    private List<CPocEmaildefinition> cPocEmaildefinitionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CPaymenttermTrl> cPaymenttermTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdTabTrl> adTabTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<CUomTrl> cUomTrlList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adLanguage")
    private List<CCountry> cCountryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adLanguage")
    private List<AdMenuTrl> adMenuTrlList;

    public AdLanguage() {
    }

    public AdLanguage(String adLanguageId) {
        this.adLanguageId = adLanguageId;
    }

    public AdLanguage(String adLanguageId, String adLanguage, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isbaselanguage, Character issystemlanguage, Character isrtl) {
        this.adLanguageId = adLanguageId;
        this.adLanguage = adLanguage;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isbaselanguage = isbaselanguage;
        this.issystemlanguage = issystemlanguage;
        this.isrtl = isrtl;
    }

    public String getAdLanguageId() {
        return adLanguageId;
    }

    public void setAdLanguageId(String adLanguageId) {
        this.adLanguageId = adLanguageId;
    }

    public String getAdLanguage() {
        return adLanguage;
    }

    public void setAdLanguage(String adLanguage) {
        this.adLanguage = adLanguage;
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

    public String getLanguageiso() {
        return languageiso;
    }

    public void setLanguageiso(String languageiso) {
        this.languageiso = languageiso;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public Character getIsbaselanguage() {
        return isbaselanguage;
    }

    public void setIsbaselanguage(Character isbaselanguage) {
        this.isbaselanguage = isbaselanguage;
    }

    public Character getIssystemlanguage() {
        return issystemlanguage;
    }

    public void setIssystemlanguage(Character issystemlanguage) {
        this.issystemlanguage = issystemlanguage;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Long getPixelsize() {
        return pixelsize;
    }

    public void setPixelsize(Long pixelsize) {
        this.pixelsize = pixelsize;
    }

    public String getTranslatedby() {
        return translatedby;
    }

    public void setTranslatedby(String translatedby) {
        this.translatedby = translatedby;
    }

    public Character getIsrtl() {
        return isrtl;
    }

    public void setIsrtl(Character isrtl) {
        this.isrtl = isrtl;
    }

    @XmlTransient
    public List<CTaxcategoryTrl> getCTaxcategoryTrlList() {
        return cTaxcategoryTrlList;
    }

    public void setCTaxcategoryTrlList(List<CTaxcategoryTrl> cTaxcategoryTrlList) {
        this.cTaxcategoryTrlList = cTaxcategoryTrlList;
    }

    @XmlTransient
    public List<CCountryTrl> getCCountryTrlList() {
        return cCountryTrlList;
    }

    public void setCCountryTrlList(List<CCountryTrl> cCountryTrlList) {
        this.cCountryTrlList = cCountryTrlList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<AdMessageTrl> getAdMessageTrlList() {
        return adMessageTrlList;
    }

    public void setAdMessageTrlList(List<AdMessageTrl> adMessageTrlList) {
        this.adMessageTrlList = adMessageTrlList;
    }

    @XmlTransient
    public List<AdWfNodeTrl> getAdWfNodeTrlList() {
        return adWfNodeTrlList;
    }

    public void setAdWfNodeTrlList(List<AdWfNodeTrl> adWfNodeTrlList) {
        this.adWfNodeTrlList = adWfNodeTrlList;
    }

    @XmlTransient
    public List<CDoctypeTrl> getCDoctypeTrlList() {
        return cDoctypeTrlList;
    }

    public void setCDoctypeTrlList(List<CDoctypeTrl> cDoctypeTrlList) {
        this.cDoctypeTrlList = cDoctypeTrlList;
    }

    @XmlTransient
    public List<CTaxTrl> getCTaxTrlList() {
        return cTaxTrlList;
    }

    public void setCTaxTrlList(List<CTaxTrl> cTaxTrlList) {
        this.cTaxTrlList = cTaxTrlList;
    }

    @XmlTransient
    public List<AdElementTrl> getAdElementTrlList() {
        return adElementTrlList;
    }

    public void setAdElementTrlList(List<AdElementTrl> adElementTrlList) {
        this.adElementTrlList = adElementTrlList;
    }

    @XmlTransient
    public List<AdFormTrl> getAdFormTrlList() {
        return adFormTrlList;
    }

    public void setAdFormTrlList(List<AdFormTrl> adFormTrlList) {
        this.adFormTrlList = adFormTrlList;
    }

    @XmlTransient
    public List<CGreetingTrl> getCGreetingTrlList() {
        return cGreetingTrlList;
    }

    public void setCGreetingTrlList(List<CGreetingTrl> cGreetingTrlList) {
        this.cGreetingTrlList = cGreetingTrlList;
    }

    @XmlTransient
    public List<AdRefListTrl> getAdRefListTrlList() {
        return adRefListTrlList;
    }

    public void setAdRefListTrlList(List<AdRefListTrl> adRefListTrlList) {
        this.adRefListTrlList = adRefListTrlList;
    }

    @XmlTransient
    public List<AdTaskTrl> getAdTaskTrlList() {
        return adTaskTrlList;
    }

    public void setAdTaskTrlList(List<AdTaskTrl> adTaskTrlList) {
        this.adTaskTrlList = adTaskTrlList;
    }

    @XmlTransient
    public List<AtCommandTrl> getAtCommandTrlList() {
        return atCommandTrlList;
    }

    public void setAtCommandTrlList(List<AtCommandTrl> atCommandTrlList) {
        this.atCommandTrlList = atCommandTrlList;
    }

    @XmlTransient
    public List<AdModuleTrl> getAdModuleTrlList() {
        return adModuleTrlList;
    }

    public void setAdModuleTrlList(List<AdModuleTrl> adModuleTrlList) {
        this.adModuleTrlList = adModuleTrlList;
    }

    @XmlTransient
    public List<AdClient> getAdClientList() {
        return adClientList;
    }

    public void setAdClientList(List<AdClient> adClientList) {
        this.adClientList = adClientList;
    }

    @XmlTransient
    public List<CElementvalueTrl> getCElementvalueTrlList() {
        return cElementvalueTrlList;
    }

    public void setCElementvalueTrlList(List<CElementvalueTrl> cElementvalueTrlList) {
        this.cElementvalueTrlList = cElementvalueTrlList;
    }

    @XmlTransient
    public List<AdReferenceTrl> getAdReferenceTrlList() {
        return adReferenceTrlList;
    }

    public void setAdReferenceTrlList(List<AdReferenceTrl> adReferenceTrlList) {
        this.adReferenceTrlList = adReferenceTrlList;
    }

    @XmlTransient
    public List<AdTextinterfacesTrl> getAdTextinterfacesTrlList() {
        return adTextinterfacesTrlList;
    }

    public void setAdTextinterfacesTrlList(List<AdTextinterfacesTrl> adTextinterfacesTrlList) {
        this.adTextinterfacesTrlList = adTextinterfacesTrlList;
    }

    @XmlTransient
    public List<AdUser> getAdUserList() {
        return adUserList;
    }

    public void setAdUserList(List<AdUser> adUserList) {
        this.adUserList = adUserList;
    }

    @XmlTransient
    public List<AtTestdocument> getAtTestdocumentList() {
        return atTestdocumentList;
    }

    public void setAtTestdocumentList(List<AtTestdocument> atTestdocumentList) {
        this.atTestdocumentList = atTestdocumentList;
    }

    @XmlTransient
    public List<AdAlertruleTrl> getAdAlertruleTrlList() {
        return adAlertruleTrlList;
    }

    public void setAdAlertruleTrlList(List<AdAlertruleTrl> adAlertruleTrlList) {
        this.adAlertruleTrlList = adAlertruleTrlList;
    }

    @XmlTransient
    public List<CCurrencyTrl> getCCurrencyTrlList() {
        return cCurrencyTrlList;
    }

    public void setCCurrencyTrlList(List<CCurrencyTrl> cCurrencyTrlList) {
        this.cCurrencyTrlList = cCurrencyTrlList;
    }

    @XmlTransient
    public List<AdModule> getAdModuleList() {
        return adModuleList;
    }

    public void setAdModuleList(List<AdModule> adModuleList) {
        this.adModuleList = adModuleList;
    }

    @XmlTransient
    public List<AdFieldTrl> getAdFieldTrlList() {
        return adFieldTrlList;
    }

    public void setAdFieldTrlList(List<AdFieldTrl> adFieldTrlList) {
        this.adFieldTrlList = adFieldTrlList;
    }

    @XmlTransient
    public List<AdWorkflowTrl> getAdWorkflowTrlList() {
        return adWorkflowTrlList;
    }

    public void setAdWorkflowTrlList(List<AdWorkflowTrl> adWorkflowTrlList) {
        this.adWorkflowTrlList = adWorkflowTrlList;
    }

    @XmlTransient
    public List<AdProcessParaTrl> getAdProcessParaTrlList() {
        return adProcessParaTrlList;
    }

    public void setAdProcessParaTrlList(List<AdProcessParaTrl> adProcessParaTrlList) {
        this.adProcessParaTrlList = adProcessParaTrlList;
    }

    @XmlTransient
    public List<AdFieldgroupTrl> getAdFieldgroupTrlList() {
        return adFieldgroupTrlList;
    }

    public void setAdFieldgroupTrlList(List<AdFieldgroupTrl> adFieldgroupTrlList) {
        this.adFieldgroupTrlList = adFieldgroupTrlList;
    }

    @XmlTransient
    public List<MProductTrl> getMProductTrlList() {
        return mProductTrlList;
    }

    public void setMProductTrlList(List<MProductTrl> mProductTrlList) {
        this.mProductTrlList = mProductTrlList;
    }

    @XmlTransient
    public List<AdWindowTrl> getAdWindowTrlList() {
        return adWindowTrlList;
    }

    public void setAdWindowTrlList(List<AdWindowTrl> adWindowTrlList) {
        this.adWindowTrlList = adWindowTrlList;
    }

    @XmlTransient
    public List<AdProcessTrl> getAdProcessTrlList() {
        return adProcessTrlList;
    }

    public void setAdProcessTrlList(List<AdProcessTrl> adProcessTrlList) {
        this.adProcessTrlList = adProcessTrlList;
    }

    @XmlTransient
    public List<AdMonthTrl> getAdMonthTrlList() {
        return adMonthTrlList;
    }

    public void setAdMonthTrlList(List<AdMonthTrl> adMonthTrlList) {
        this.adMonthTrlList = adMonthTrlList;
    }

    @XmlTransient
    public List<CPocEmaildefinition> getCPocEmaildefinitionList() {
        return cPocEmaildefinitionList;
    }

    public void setCPocEmaildefinitionList(List<CPocEmaildefinition> cPocEmaildefinitionList) {
        this.cPocEmaildefinitionList = cPocEmaildefinitionList;
    }

    @XmlTransient
    public List<CPaymenttermTrl> getCPaymenttermTrlList() {
        return cPaymenttermTrlList;
    }

    public void setCPaymenttermTrlList(List<CPaymenttermTrl> cPaymenttermTrlList) {
        this.cPaymenttermTrlList = cPaymenttermTrlList;
    }

    @XmlTransient
    public List<AdTabTrl> getAdTabTrlList() {
        return adTabTrlList;
    }

    public void setAdTabTrlList(List<AdTabTrl> adTabTrlList) {
        this.adTabTrlList = adTabTrlList;
    }

    @XmlTransient
    public List<CUomTrl> getCUomTrlList() {
        return cUomTrlList;
    }

    public void setCUomTrlList(List<CUomTrl> cUomTrlList) {
        this.cUomTrlList = cUomTrlList;
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

    @XmlTransient
    public List<CCountry> getCCountryList() {
        return cCountryList;
    }

    public void setCCountryList(List<CCountry> cCountryList) {
        this.cCountryList = cCountryList;
    }

    @XmlTransient
    public List<AdMenuTrl> getAdMenuTrlList() {
        return adMenuTrlList;
    }

    public void setAdMenuTrlList(List<AdMenuTrl> adMenuTrlList) {
        this.adMenuTrlList = adMenuTrlList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adLanguageId != null ? adLanguageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdLanguage)) {
            return false;
        }
        AdLanguage other = (AdLanguage) object;
        if ((this.adLanguageId == null && other.adLanguageId != null) || (this.adLanguageId != null && !this.adLanguageId.equals(other.adLanguageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdLanguage[ adLanguageId=" + adLanguageId + " ]";
    }
    
}
