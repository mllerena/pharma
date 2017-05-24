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
import javax.persistence.Convert;
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
@Table(name = "c_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CLocation.findAll", query = "SELECT c FROM CLocation c"),
    @NamedQuery(name = "CLocation.findByCLocationId", query = "SELECT c FROM CLocation c WHERE c.cLocationId = :cLocationId"),
    @NamedQuery(name = "CLocation.findByIsactive", query = "SELECT c FROM CLocation c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CLocation.findByCreated", query = "SELECT c FROM CLocation c WHERE c.created = :created"),
    @NamedQuery(name = "CLocation.findByCreatedby", query = "SELECT c FROM CLocation c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CLocation.findByUpdated", query = "SELECT c FROM CLocation c WHERE c.updated = :updated"),
    @NamedQuery(name = "CLocation.findByUpdatedby", query = "SELECT c FROM CLocation c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CLocation.findByAddress1", query = "SELECT c FROM CLocation c WHERE c.address1 = :address1"),
    @NamedQuery(name = "CLocation.findByAddress2", query = "SELECT c FROM CLocation c WHERE c.address2 = :address2"),
    @NamedQuery(name = "CLocation.findByCity", query = "SELECT c FROM CLocation c WHERE c.city = :city"),
    @NamedQuery(name = "CLocation.findByPostal", query = "SELECT c FROM CLocation c WHERE c.postal = :postal"),
    @NamedQuery(name = "CLocation.findByPostalAdd", query = "SELECT c FROM CLocation c WHERE c.postalAdd = :postalAdd"),
    @NamedQuery(name = "CLocation.findByRegionname", query = "SELECT c FROM CLocation c WHERE c.regionname = :regionname")})
public class CLocation extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_location_id")
    private String cLocationId;
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
    @Size(max = 60)
    @Column(name = "address1")
    private String address1;
    @Size(max = 60)
    @Column(name = "address2")
    private String address2;
    @Size(max = 60)
    @Column(name = "city")
    private String city;
    @Size(max = 10)
    @Column(name = "postal")
    private String postal;
    @Size(max = 10)
    @Column(name = "postal_add")
    private String postalAdd;
    @Size(max = 40)
    @Column(name = "regionname")
    private String regionname;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocfromId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLoctoId")
    private List<IGljournal> iGljournalList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<CBpartnerLocation> cBpartnerLocationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cLocationId")
    private List<MWarehouse> mWarehouseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<FinFinancialAccount> finFinancialAccountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocfromId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLoctoId")
    private List<CValidcombination> cValidcombinationList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocfromId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLoctoId")
    private List<FactAcct> factAcctList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<AdOrginfo> adOrginfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<CBank> cBankList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_city_id", referencedColumnName = "c_city_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCity cCityId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCountry cCountryId;
    @JoinColumn(name = "c_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion cRegionId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cLocationId")
    private List<CProject> cProjectList;

    public CLocation() {
    }

    public CLocation(String cLocationId) {
        this.cLocationId = cLocationId;
    }

    public String getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(String cLocationId) {
        this.cLocationId = cLocationId;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getPostalAdd() {
        return postalAdd;
    }

    public void setPostalAdd(String postalAdd) {
        this.postalAdd = postalAdd;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<AdTest> getAdTestList() {
        return adTestList;
    }

    public void setAdTestList(List<AdTest> adTestList) {
        this.adTestList = adTestList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList1() {
        return iGljournalList1;
    }

    public void setIGljournalList1(List<IGljournal> iGljournalList1) {
        this.iGljournalList1 = iGljournalList1;
    }

    @XmlTransient
    public List<CBpartnerLocation> getCBpartnerLocationList() {
        return cBpartnerLocationList;
    }

    public void setCBpartnerLocationList(List<CBpartnerLocation> cBpartnerLocationList) {
        this.cBpartnerLocationList = cBpartnerLocationList;
    }

    @XmlTransient
    public List<MWarehouse> getMWarehouseList() {
        return mWarehouseList;
    }

    public void setMWarehouseList(List<MWarehouse> mWarehouseList) {
        this.mWarehouseList = mWarehouseList;
    }

    @XmlTransient
    public List<FinFinancialAccount> getFinFinancialAccountList() {
        return finFinancialAccountList;
    }

    public void setFinFinancialAccountList(List<FinFinancialAccount> finFinancialAccountList) {
        this.finFinancialAccountList = finFinancialAccountList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<CValidcombination> getCValidcombinationList() {
        return cValidcombinationList;
    }

    public void setCValidcombinationList(List<CValidcombination> cValidcombinationList) {
        this.cValidcombinationList = cValidcombinationList;
    }

    @XmlTransient
    public List<CValidcombination> getCValidcombinationList1() {
        return cValidcombinationList1;
    }

    public void setCValidcombinationList1(List<CValidcombination> cValidcombinationList1) {
        this.cValidcombinationList1 = cValidcombinationList1;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList1() {
        return factAcctList1;
    }

    public void setFactAcctList1(List<FactAcct> factAcctList1) {
        this.factAcctList1 = factAcctList1;
    }

    @XmlTransient
    public List<AdOrginfo> getAdOrginfoList() {
        return adOrginfoList;
    }

    public void setAdOrginfoList(List<AdOrginfo> adOrginfoList) {
        this.adOrginfoList = adOrginfoList;
    }

    @XmlTransient
    public List<CBank> getCBankList() {
        return cBankList;
    }

    public void setCBankList(List<CBank> cBankList) {
        this.cBankList = cBankList;
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

    public CCity getCCityId() {
        return cCityId;
    }

    public void setCCityId(CCity cCityId) {
        this.cCityId = cCityId;
    }

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    public CRegion getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(CRegion cRegionId) {
        this.cRegionId = cRegionId;
    }

    @XmlTransient
    public List<AAsset> getAAssetList() {
        return aAssetList;
    }

    public void setAAssetList(List<AAsset> aAssetList) {
        this.aAssetList = aAssetList;
    }

    @XmlTransient
    public List<CAcctschemaElement> getCAcctschemaElementList() {
        return cAcctschemaElementList;
    }

    public void setCAcctschemaElementList(List<CAcctschemaElement> cAcctschemaElementList) {
        this.cAcctschemaElementList = cAcctschemaElementList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cLocationId != null ? cLocationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CLocation)) {
            return false;
        }
        CLocation other = (CLocation) object;
        if ((this.cLocationId == null && other.cLocationId != null) || (this.cLocationId != null && !this.cLocationId.equals(other.cLocationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CLocation[ cLocationId=" + cLocationId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return cLocationId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		cLocationId = id;
	}
    
}
