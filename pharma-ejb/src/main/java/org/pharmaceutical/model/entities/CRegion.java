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
@Table(name = "c_region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRegion.findAll", query = "SELECT c FROM CRegion c"),
    @NamedQuery(name = "CRegion.findByCRegionId", query = "SELECT c FROM CRegion c WHERE c.cRegionId = :cRegionId"),
    @NamedQuery(name = "CRegion.findByIsactive", query = "SELECT c FROM CRegion c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CRegion.findByCreated", query = "SELECT c FROM CRegion c WHERE c.created = :created"),
    @NamedQuery(name = "CRegion.findByCreatedby", query = "SELECT c FROM CRegion c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CRegion.findByUpdated", query = "SELECT c FROM CRegion c WHERE c.updated = :updated"),
    @NamedQuery(name = "CRegion.findByUpdatedby", query = "SELECT c FROM CRegion c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CRegion.findByName", query = "SELECT c FROM CRegion c WHERE c.name = :name"),
    @NamedQuery(name = "CRegion.findByDescription", query = "SELECT c FROM CRegion c WHERE c.description = :description"),
    @NamedQuery(name = "CRegion.findByIsdefault", query = "SELECT c FROM CRegion c WHERE c.isdefault = :isdefault"),
    @NamedQuery(name = "CRegion.findByValue", query = "SELECT c FROM CRegion c WHERE c.value = :value")})
public class CRegion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_region_id")
    private String cRegionId;
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
    @Column(name = "isdefault")
    private Character isdefault;
    @Size(max = 2)
    @Column(name = "value")
    private String value;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRegionId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "toRegionId")
    private List<CTax> cTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRegionId")
    private List<CTax> cTaxList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRegionId")
    private List<MFreight> mFreightList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "toRegionId")
    private List<MFreight> mFreightList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRegionId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRegionId")
    private List<IBpartner> iBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "toRegionId")
    private List<CTaxZone> cTaxZoneList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "fromRegionId")
    private List<CTaxZone> cTaxZoneList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRegionId")
    private List<CCity> cCityList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRegionId")
    private List<CLocation> cLocationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cRegionId")
    private List<ITax> iTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "toRegionId")
    private List<ITax> iTaxList1;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCountry cCountryId;

    public CRegion() {
    }

    public CRegion(String cRegionId) {
        this.cRegionId = cRegionId;
    }

    public CRegion(String cRegionId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cRegionId = cRegionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(String cRegionId) {
        this.cRegionId = cRegionId;
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

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
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

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRegionId != null ? cRegionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRegion)) {
            return false;
        }
        CRegion other = (CRegion) object;
        if ((this.cRegionId == null && other.cRegionId != null) || (this.cRegionId != null && !this.cRegionId.equals(other.cRegionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CRegion[ cRegionId=" + cRegionId + " ]";
    }
    
}
