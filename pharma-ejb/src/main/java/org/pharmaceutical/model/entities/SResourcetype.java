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
@Table(name = "s_resourcetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SResourcetype.findAll", query = "SELECT s FROM SResourcetype s"),
    @NamedQuery(name = "SResourcetype.findBySResourcetypeId", query = "SELECT s FROM SResourcetype s WHERE s.sResourcetypeId = :sResourcetypeId"),
    @NamedQuery(name = "SResourcetype.findByIsactive", query = "SELECT s FROM SResourcetype s WHERE s.isactive = :isactive"),
    @NamedQuery(name = "SResourcetype.findByCreated", query = "SELECT s FROM SResourcetype s WHERE s.created = :created"),
    @NamedQuery(name = "SResourcetype.findByCreatedby", query = "SELECT s FROM SResourcetype s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SResourcetype.findByUpdated", query = "SELECT s FROM SResourcetype s WHERE s.updated = :updated"),
    @NamedQuery(name = "SResourcetype.findByUpdatedby", query = "SELECT s FROM SResourcetype s WHERE s.updatedby = :updatedby"),
    @NamedQuery(name = "SResourcetype.findByValue", query = "SELECT s FROM SResourcetype s WHERE s.value = :value"),
    @NamedQuery(name = "SResourcetype.findByName", query = "SELECT s FROM SResourcetype s WHERE s.name = :name"),
    @NamedQuery(name = "SResourcetype.findByDescription", query = "SELECT s FROM SResourcetype s WHERE s.description = :description"),
    @NamedQuery(name = "SResourcetype.findByIssingleassignment", query = "SELECT s FROM SResourcetype s WHERE s.issingleassignment = :issingleassignment"),
    @NamedQuery(name = "SResourcetype.findByAllowuomfractions", query = "SELECT s FROM SResourcetype s WHERE s.allowuomfractions = :allowuomfractions"),
    @NamedQuery(name = "SResourcetype.findByTimeslotstart", query = "SELECT s FROM SResourcetype s WHERE s.timeslotstart = :timeslotstart"),
    @NamedQuery(name = "SResourcetype.findByTimeslotend", query = "SELECT s FROM SResourcetype s WHERE s.timeslotend = :timeslotend"),
    @NamedQuery(name = "SResourcetype.findByIstimeslot", query = "SELECT s FROM SResourcetype s WHERE s.istimeslot = :istimeslot"),
    @NamedQuery(name = "SResourcetype.findByIsdateslot", query = "SELECT s FROM SResourcetype s WHERE s.isdateslot = :isdateslot"),
    @NamedQuery(name = "SResourcetype.findByOnsunday", query = "SELECT s FROM SResourcetype s WHERE s.onsunday = :onsunday"),
    @NamedQuery(name = "SResourcetype.findByOnmonday", query = "SELECT s FROM SResourcetype s WHERE s.onmonday = :onmonday"),
    @NamedQuery(name = "SResourcetype.findByOntuesday", query = "SELECT s FROM SResourcetype s WHERE s.ontuesday = :ontuesday"),
    @NamedQuery(name = "SResourcetype.findByOnwednesday", query = "SELECT s FROM SResourcetype s WHERE s.onwednesday = :onwednesday"),
    @NamedQuery(name = "SResourcetype.findByOnthursday", query = "SELECT s FROM SResourcetype s WHERE s.onthursday = :onthursday"),
    @NamedQuery(name = "SResourcetype.findByOnfriday", query = "SELECT s FROM SResourcetype s WHERE s.onfriday = :onfriday"),
    @NamedQuery(name = "SResourcetype.findByOnsaturday", query = "SELECT s FROM SResourcetype s WHERE s.onsaturday = :onsaturday"),
    @NamedQuery(name = "SResourcetype.findByChargeableqty", query = "SELECT s FROM SResourcetype s WHERE s.chargeableqty = :chargeableqty")})
public class SResourcetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "s_resourcetype_id")
    private String sResourcetypeId;
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
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
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
    @Column(name = "issingleassignment")
    private Character issingleassignment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allowuomfractions")
    private Character allowuomfractions;
    @Column(name = "timeslotstart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeslotstart;
    @Column(name = "timeslotend")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeslotend;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istimeslot")
    private Character istimeslot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdateslot")
    private Character isdateslot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onsunday")
    private Character onsunday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onmonday")
    private Character onmonday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ontuesday")
    private Character ontuesday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onwednesday")
    private Character onwednesday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onthursday")
    private Character onthursday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onfriday")
    private Character onfriday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onsaturday")
    private Character onsaturday;
    @Column(name = "chargeableqty")
    private BigInteger chargeableqty;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "sResourcetypeId")
    private List<SResource> sResourceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_taxcategory_id", referencedColumnName = "c_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTaxcategory cTaxcategoryId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductCategory mProductCategoryId;

    public SResourcetype() {
    }

    public SResourcetype(String sResourcetypeId) {
        this.sResourcetypeId = sResourcetypeId;
    }

    public SResourcetype(String sResourcetypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, Character issingleassignment, Character allowuomfractions, Character istimeslot, Character isdateslot, Character onsunday, Character onmonday, Character ontuesday, Character onwednesday, Character onthursday, Character onfriday, Character onsaturday) {
        this.sResourcetypeId = sResourcetypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.issingleassignment = issingleassignment;
        this.allowuomfractions = allowuomfractions;
        this.istimeslot = istimeslot;
        this.isdateslot = isdateslot;
        this.onsunday = onsunday;
        this.onmonday = onmonday;
        this.ontuesday = ontuesday;
        this.onwednesday = onwednesday;
        this.onthursday = onthursday;
        this.onfriday = onfriday;
        this.onsaturday = onsaturday;
    }

    public String getSResourcetypeId() {
        return sResourcetypeId;
    }

    public void setSResourcetypeId(String sResourcetypeId) {
        this.sResourcetypeId = sResourcetypeId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Character getIssingleassignment() {
        return issingleassignment;
    }

    public void setIssingleassignment(Character issingleassignment) {
        this.issingleassignment = issingleassignment;
    }

    public Character getAllowuomfractions() {
        return allowuomfractions;
    }

    public void setAllowuomfractions(Character allowuomfractions) {
        this.allowuomfractions = allowuomfractions;
    }

    public Date getTimeslotstart() {
        return timeslotstart;
    }

    public void setTimeslotstart(Date timeslotstart) {
        this.timeslotstart = timeslotstart;
    }

    public Date getTimeslotend() {
        return timeslotend;
    }

    public void setTimeslotend(Date timeslotend) {
        this.timeslotend = timeslotend;
    }

    public Character getIstimeslot() {
        return istimeslot;
    }

    public void setIstimeslot(Character istimeslot) {
        this.istimeslot = istimeslot;
    }

    public Character getIsdateslot() {
        return isdateslot;
    }

    public void setIsdateslot(Character isdateslot) {
        this.isdateslot = isdateslot;
    }

    public Character getOnsunday() {
        return onsunday;
    }

    public void setOnsunday(Character onsunday) {
        this.onsunday = onsunday;
    }

    public Character getOnmonday() {
        return onmonday;
    }

    public void setOnmonday(Character onmonday) {
        this.onmonday = onmonday;
    }

    public Character getOntuesday() {
        return ontuesday;
    }

    public void setOntuesday(Character ontuesday) {
        this.ontuesday = ontuesday;
    }

    public Character getOnwednesday() {
        return onwednesday;
    }

    public void setOnwednesday(Character onwednesday) {
        this.onwednesday = onwednesday;
    }

    public Character getOnthursday() {
        return onthursday;
    }

    public void setOnthursday(Character onthursday) {
        this.onthursday = onthursday;
    }

    public Character getOnfriday() {
        return onfriday;
    }

    public void setOnfriday(Character onfriday) {
        this.onfriday = onfriday;
    }

    public Character getOnsaturday() {
        return onsaturday;
    }

    public void setOnsaturday(Character onsaturday) {
        this.onsaturday = onsaturday;
    }

    public BigInteger getChargeableqty() {
        return chargeableqty;
    }

    public void setChargeableqty(BigInteger chargeableqty) {
        this.chargeableqty = chargeableqty;
    }

    @XmlTransient
    public List<SResource> getSResourceList() {
        return sResourceList;
    }

    public void setSResourceList(List<SResource> sResourceList) {
        this.sResourceList = sResourceList;
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

    public CTaxcategory getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(CTaxcategory cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sResourcetypeId != null ? sResourcetypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SResourcetype)) {
            return false;
        }
        SResourcetype other = (SResourcetype) object;
        if ((this.sResourcetypeId == null && other.sResourcetypeId != null) || (this.sResourcetypeId != null && !this.sResourcetypeId.equals(other.sResourcetypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.SResourcetype[ sResourcetypeId=" + sResourcetypeId + " ]";
    }
    
}
