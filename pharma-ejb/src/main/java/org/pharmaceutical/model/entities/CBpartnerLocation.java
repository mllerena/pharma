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
@Table(name = "c_bpartner_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpartnerLocation.findAll", query = "SELECT c FROM CBpartnerLocation c"),
    @NamedQuery(name = "CBpartnerLocation.findByCBpartnerLocationId", query = "SELECT c FROM CBpartnerLocation c WHERE c.cBpartnerLocationId = :cBpartnerLocationId"),
    @NamedQuery(name = "CBpartnerLocation.findByIsactive", query = "SELECT c FROM CBpartnerLocation c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpartnerLocation.findByCreated", query = "SELECT c FROM CBpartnerLocation c WHERE c.created = :created"),
    @NamedQuery(name = "CBpartnerLocation.findByCreatedby", query = "SELECT c FROM CBpartnerLocation c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpartnerLocation.findByUpdated", query = "SELECT c FROM CBpartnerLocation c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpartnerLocation.findByUpdatedby", query = "SELECT c FROM CBpartnerLocation c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpartnerLocation.findByName", query = "SELECT c FROM CBpartnerLocation c WHERE c.name = :name"),
    @NamedQuery(name = "CBpartnerLocation.findByIsbillto", query = "SELECT c FROM CBpartnerLocation c WHERE c.isbillto = :isbillto"),
    @NamedQuery(name = "CBpartnerLocation.findByIsshipto", query = "SELECT c FROM CBpartnerLocation c WHERE c.isshipto = :isshipto"),
    @NamedQuery(name = "CBpartnerLocation.findByIspayfrom", query = "SELECT c FROM CBpartnerLocation c WHERE c.ispayfrom = :ispayfrom"),
    @NamedQuery(name = "CBpartnerLocation.findByIsremitto", query = "SELECT c FROM CBpartnerLocation c WHERE c.isremitto = :isremitto"),
    @NamedQuery(name = "CBpartnerLocation.findByPhone", query = "SELECT c FROM CBpartnerLocation c WHERE c.phone = :phone"),
    @NamedQuery(name = "CBpartnerLocation.findByPhone2", query = "SELECT c FROM CBpartnerLocation c WHERE c.phone2 = :phone2"),
    @NamedQuery(name = "CBpartnerLocation.findByFax", query = "SELECT c FROM CBpartnerLocation c WHERE c.fax = :fax"),
    @NamedQuery(name = "CBpartnerLocation.findByIstaxlocation", query = "SELECT c FROM CBpartnerLocation c WHERE c.istaxlocation = :istaxlocation"),
    @NamedQuery(name = "CBpartnerLocation.findByUpc", query = "SELECT c FROM CBpartnerLocation c WHERE c.upc = :upc"),
    @NamedQuery(name = "CBpartnerLocation.findByCBpartnerId", query = "SELECT c FROM CBpartnerLocation c WHERE c.cBpartnerId = :cBpartnerId and c.isactive = :isactive"),
})



public class CBpartnerLocation extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bpartner_location_id")
    private String cBpartnerLocationId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbillto")
    @Convert(converter=YesNoConverter.class)
    private YesNo isbillto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isshipto")
    @Convert(converter=YesNoConverter.class)
    private YesNo isshipto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispayfrom")
    @Convert(converter=YesNoConverter.class)
    private YesNo ispayfrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isremitto")
    @Convert(converter=YesNoConverter.class)
    private YesNo isremitto;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "phone")
    private String phone;
    @Size(max = 40)
    @Column(name = "phone2")
    private String phone2;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "fax")
    private String fax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istaxlocation")
    @Convert(converter=YesNoConverter.class)
    private YesNo istaxlocation;
    @Size(max = 30)
    @Column(name = "upc")
    private String upc;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerLocationId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerLocationId")
    private List<CInvoice> cInvoiceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "billtoId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerLocationId")
    private List<COrder> cOrderList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "deliveryLocationId")
    private List<COrder> cOrderList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "dropshipLocationId")
    private List<COrder> cOrderList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "billtoId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerLocationId")
    private List<IOrder> iOrderList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerLocationId")
    private List<AdUser> adUserList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerLocationId")
    private List<CProjectproposal> cProjectproposalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerLocationId")
    private List<IBpartner> iBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerLocationId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerLocationId")
    private List<AAsset> aAssetList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "deliveryLocationId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpartnerLocationId")
    private List<MInout> mInoutList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "billtoId")
    private List<CProject> cProjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpartnerLocationId")
    private List<CProject> cProjectList1;

    public CBpartnerLocation() {
    }

    public CBpartnerLocation(String cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public String getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(String cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
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

    public YesNo getIsbillto() {
        return isbillto;
    }

    public void setIsbillto(YesNo isbillto) {
        this.isbillto = isbillto;
    }

    public YesNo getIsshipto() {
        return isshipto;
    }

    public void setIsshipto(YesNo isshipto) {
        this.isshipto = isshipto;
    }

    public YesNo getIspayfrom() {
        return ispayfrom;
    }

    public void setIspayfrom(YesNo ispayfrom) {
        this.ispayfrom = ispayfrom;
    }

    public YesNo getIsremitto() {
        return isremitto;
    }

    public void setIsremitto(YesNo isremitto) {
        this.isremitto = isremitto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public YesNo getIstaxlocation() {
        return istaxlocation;
    }

    public void setIstaxlocation(YesNo istaxlocation) {
        this.istaxlocation = istaxlocation;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    public CSalesregion getCSalesregionId() {
        return cSalesregionId;
    }

    public void setCSalesregionId(CSalesregion cSalesregionId) {
        this.cSalesregionId = cSalesregionId;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<COrder> getCOrderList1() {
        return cOrderList1;
    }

    public void setCOrderList1(List<COrder> cOrderList1) {
        this.cOrderList1 = cOrderList1;
    }

    @XmlTransient
    public List<COrder> getCOrderList2() {
        return cOrderList2;
    }

    public void setCOrderList2(List<COrder> cOrderList2) {
        this.cOrderList2 = cOrderList2;
    }

    @XmlTransient
    public List<COrder> getCOrderList3() {
        return cOrderList3;
    }

    public void setCOrderList3(List<COrder> cOrderList3) {
        this.cOrderList3 = cOrderList3;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList1() {
        return iOrderList1;
    }

    public void setIOrderList1(List<IOrder> iOrderList1) {
        this.iOrderList1 = iOrderList1;
    }

    @XmlTransient
    public List<AdUser> getAdUserList() {
        return adUserList;
    }

    public void setAdUserList(List<AdUser> adUserList) {
        this.adUserList = adUserList;
    }

    @XmlTransient
    public List<CProjectproposal> getCProjectproposalList() {
        return cProjectproposalList;
    }

    public void setCProjectproposalList(List<CProjectproposal> cProjectproposalList) {
        this.cProjectproposalList = cProjectproposalList;
    }

    @XmlTransient
    public List<IBpartner> getIBpartnerList() {
        return iBpartnerList;
    }

    public void setIBpartnerList(List<IBpartner> iBpartnerList) {
        this.iBpartnerList = iBpartnerList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<AAsset> getAAssetList() {
        return aAssetList;
    }

    public void setAAssetList(List<AAsset> aAssetList) {
        this.aAssetList = aAssetList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @XmlTransient
    public List<MInout> getMInoutList1() {
        return mInoutList1;
    }

    public void setMInoutList1(List<MInout> mInoutList1) {
        this.mInoutList1 = mInoutList1;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @XmlTransient
    public List<CProject> getCProjectList1() {
        return cProjectList1;
    }

    public void setCProjectList1(List<CProject> cProjectList1) {
        this.cProjectList1 = cProjectList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpartnerLocationId != null ? cBpartnerLocationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpartnerLocation)) {
            return false;
        }
        CBpartnerLocation other = (CBpartnerLocation) object;
        if ((this.cBpartnerLocationId == null && other.cBpartnerLocationId != null) || (this.cBpartnerLocationId != null && !this.cBpartnerLocationId.equals(other.cBpartnerLocationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpartnerLocation[ cBpartnerLocationId=" + cBpartnerLocationId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return cBpartnerLocationId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		cBpartnerLocationId = id;
	}
    
}
