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
import javax.persistence.Column;
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "c_country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCountry.findAll", query = "SELECT c FROM CCountry c"),
    @NamedQuery(name = "CCountry.findByCCountryId", query = "SELECT c FROM CCountry c WHERE c.cCountryId = :cCountryId"),
    @NamedQuery(name = "CCountry.findByIsactive", query = "SELECT c FROM CCountry c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCountry.findByCreated", query = "SELECT c FROM CCountry c WHERE c.created = :created"),
    @NamedQuery(name = "CCountry.findByCreatedby", query = "SELECT c FROM CCountry c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCountry.findByUpdated", query = "SELECT c FROM CCountry c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCountry.findByUpdatedby", query = "SELECT c FROM CCountry c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCountry.findByName", query = "SELECT c FROM CCountry c WHERE c.name = :name"),
    @NamedQuery(name = "CCountry.findByDescription", query = "SELECT c FROM CCountry c WHERE c.description = :description"),
    @NamedQuery(name = "CCountry.findByCountrycode", query = "SELECT c FROM CCountry c WHERE c.countrycode = :countrycode"),
    @NamedQuery(name = "CCountry.findByHasregion", query = "SELECT c FROM CCountry c WHERE c.hasregion = :hasregion"),
    @NamedQuery(name = "CCountry.findByRegionname", query = "SELECT c FROM CCountry c WHERE c.regionname = :regionname"),
    @NamedQuery(name = "CCountry.findByExpressionphone", query = "SELECT c FROM CCountry c WHERE c.expressionphone = :expressionphone"),
    @NamedQuery(name = "CCountry.findByDisplaysequence", query = "SELECT c FROM CCountry c WHERE c.displaysequence = :displaysequence"),
    @NamedQuery(name = "CCountry.findByExpressionpostal", query = "SELECT c FROM CCountry c WHERE c.expressionpostal = :expressionpostal"),
    @NamedQuery(name = "CCountry.findByHaspostalAdd", query = "SELECT c FROM CCountry c WHERE c.haspostalAdd = :haspostalAdd"),
    @NamedQuery(name = "CCountry.findByExpressionpostalAdd", query = "SELECT c FROM CCountry c WHERE c.expressionpostalAdd = :expressionpostalAdd"),
    @NamedQuery(name = "CCountry.findByIsdefault", query = "SELECT c FROM CCountry c WHERE c.isdefault = :isdefault"),
    @NamedQuery(name = "CCountry.findByIbannodigits", query = "SELECT c FROM CCountry c WHERE c.ibannodigits = :ibannodigits"),
    @NamedQuery(name = "CCountry.findByIbancountry", query = "SELECT c FROM CCountry c WHERE c.ibancountry = :ibancountry")})
public class CCountry extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_country_id")
    private String cCountryId;
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
    @Size(min = 1, max = 2)
    @Column(name = "countrycode")
    private String countrycode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hasregion")
    private Character hasregion;
    @Size(max = 60)
    @Column(name = "regionname")
    private String regionname;
    @Size(max = 20)
    @Column(name = "expressionphone")
    private String expressionphone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "displaysequence")
    private String displaysequence;
    @Size(max = 20)
    @Column(name = "expressionpostal")
    private String expressionpostal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "haspostal_add")
    private Character haspostalAdd;
    @Size(max = 20)
    @Column(name = "expressionpostal_add")
    private String expressionpostalAdd;
    @Column(name = "isdefault")
    private Character isdefault;
    @Column(name = "ibannodigits")
    private BigInteger ibannodigits;
    @Size(max = 2)
    @Column(name = "ibancountry")
    private String ibancountry;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCountryId")
    private List<CCountryTrl> cCountryTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<CTax> cTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "toCountryId")
    private List<CTax> cTaxList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<MFreight> mFreightList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "toCountryId")
    private List<MFreight> mFreightList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<IBpartner> iBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "toCountryId")
    private List<CTaxZone> cTaxZoneList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "fromCountryId")
    private List<CTaxZone> cTaxZoneList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<CCity> cCityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<CBpBankaccount> cBpBankaccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<CBank> cBankList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCountryId")
    private List<CLocation> cLocationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "toCountryId")
    private List<ITax> iTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCountryId")
    private List<ITax> iTaxList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCountryId")
    private List<CRegion> cRegionList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cCountry1")
    private CCountry cCountry;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CCountry cCountry1;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;

    public CCountry() {
    }

    public CCountry(String cCountryId) {
        this.cCountryId = cCountryId;
    }

    public String getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(String cCountryId) {
        this.cCountryId = cCountryId;
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

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public Character getHasregion() {
        return hasregion;
    }

    public void setHasregion(Character hasregion) {
        this.hasregion = hasregion;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getExpressionphone() {
        return expressionphone;
    }

    public void setExpressionphone(String expressionphone) {
        this.expressionphone = expressionphone;
    }

    public String getDisplaysequence() {
        return displaysequence;
    }

    public void setDisplaysequence(String displaysequence) {
        this.displaysequence = displaysequence;
    }

    public String getExpressionpostal() {
        return expressionpostal;
    }

    public void setExpressionpostal(String expressionpostal) {
        this.expressionpostal = expressionpostal;
    }

    public Character getHaspostalAdd() {
        return haspostalAdd;
    }

    public void setHaspostalAdd(Character haspostalAdd) {
        this.haspostalAdd = haspostalAdd;
    }

    public String getExpressionpostalAdd() {
        return expressionpostalAdd;
    }

    public void setExpressionpostalAdd(String expressionpostalAdd) {
        this.expressionpostalAdd = expressionpostalAdd;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public BigInteger getIbannodigits() {
        return ibannodigits;
    }

    public void setIbannodigits(BigInteger ibannodigits) {
        this.ibannodigits = ibannodigits;
    }

    public String getIbancountry() {
        return ibancountry;
    }

    public void setIbancountry(String ibancountry) {
        this.ibancountry = ibancountry;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<CCountryTrl> getCCountryTrlList() {
        return cCountryTrlList;
    }

    public void setCCountryTrlList(List<CCountryTrl> cCountryTrlList) {
        this.cCountryTrlList = cCountryTrlList;
    }

    @XmlTransient
    public List<CTax> getCTaxList() {
        return cTaxList;
    }

    public void setCTaxList(List<CTax> cTaxList) {
        this.cTaxList = cTaxList;
    }

    @XmlTransient
    public List<CTax> getCTaxList1() {
        return cTaxList1;
    }

    public void setCTaxList1(List<CTax> cTaxList1) {
        this.cTaxList1 = cTaxList1;
    }

    @XmlTransient
    public List<MFreight> getMFreightList() {
        return mFreightList;
    }

    public void setMFreightList(List<MFreight> mFreightList) {
        this.mFreightList = mFreightList;
    }

    @XmlTransient
    public List<MFreight> getMFreightList1() {
        return mFreightList1;
    }

    public void setMFreightList1(List<MFreight> mFreightList1) {
        this.mFreightList1 = mFreightList1;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<IBpartner> getIBpartnerList() {
        return iBpartnerList;
    }

    public void setIBpartnerList(List<IBpartner> iBpartnerList) {
        this.iBpartnerList = iBpartnerList;
    }

    @XmlTransient
    public List<CTaxZone> getCTaxZoneList() {
        return cTaxZoneList;
    }

    public void setCTaxZoneList(List<CTaxZone> cTaxZoneList) {
        this.cTaxZoneList = cTaxZoneList;
    }

    @XmlTransient
    public List<CTaxZone> getCTaxZoneList1() {
        return cTaxZoneList1;
    }

    public void setCTaxZoneList1(List<CTaxZone> cTaxZoneList1) {
        this.cTaxZoneList1 = cTaxZoneList1;
    }

    @XmlTransient
    public List<CCity> getCCityList() {
        return cCityList;
    }

    public void setCCityList(List<CCity> cCityList) {
        this.cCityList = cCityList;
    }

    @XmlTransient
    public List<CBpBankaccount> getCBpBankaccountList() {
        return cBpBankaccountList;
    }

    public void setCBpBankaccountList(List<CBpBankaccount> cBpBankaccountList) {
        this.cBpBankaccountList = cBpBankaccountList;
    }

    @XmlTransient
    public List<CBank> getCBankList() {
        return cBankList;
    }

    public void setCBankList(List<CBank> cBankList) {
        this.cBankList = cBankList;
    }

    @XmlTransient
    public List<CLocation> getCLocationList() {
        return cLocationList;
    }

    public void setCLocationList(List<CLocation> cLocationList) {
        this.cLocationList = cLocationList;
    }

    @XmlTransient
    public List<ITax> getITaxList() {
        return iTaxList;
    }

    public void setITaxList(List<ITax> iTaxList) {
        this.iTaxList = iTaxList;
    }

    @XmlTransient
    public List<ITax> getITaxList1() {
        return iTaxList1;
    }

    public void setITaxList1(List<ITax> iTaxList1) {
        this.iTaxList1 = iTaxList1;
    }

    @XmlTransient
    public List<CRegion> getCRegionList() {
        return cRegionList;
    }

    public void setCRegionList(List<CRegion> cRegionList) {
        this.cRegionList = cRegionList;
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

    public CCountry getCCountry() {
        return cCountry;
    }

    public void setCCountry(CCountry cCountry) {
        this.cCountry = cCountry;
    }

    public CCountry getCCountry1() {
        return cCountry1;
    }

    public void setCCountry1(CCountry cCountry1) {
        this.cCountry1 = cCountry1;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCountryId != null ? cCountryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCountry)) {
            return false;
        }
        CCountry other = (CCountry) object;
        if ((this.cCountryId == null && other.cCountryId != null) || (this.cCountryId != null && !this.cCountryId.equals(other.cCountryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCountry[ cCountryId=" + cCountryId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return cCountryId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		cCountryId = id;
	}
    
}
