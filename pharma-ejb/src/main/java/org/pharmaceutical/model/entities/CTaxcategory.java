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
@Table(name = "c_taxcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxcategory.findAll", query = "SELECT c FROM CTaxcategory c"),
    @NamedQuery(name = "CTaxcategory.findByCTaxcategoryId", query = "SELECT c FROM CTaxcategory c WHERE c.cTaxcategoryId = :cTaxcategoryId"),
    @NamedQuery(name = "CTaxcategory.findByIsactive", query = "SELECT c FROM CTaxcategory c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxcategory.findByCreated", query = "SELECT c FROM CTaxcategory c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxcategory.findByCreatedby", query = "SELECT c FROM CTaxcategory c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxcategory.findByUpdated", query = "SELECT c FROM CTaxcategory c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxcategory.findByUpdatedby", query = "SELECT c FROM CTaxcategory c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxcategory.findByName", query = "SELECT c FROM CTaxcategory c WHERE c.name = :name"),
    @NamedQuery(name = "CTaxcategory.findByDescription", query = "SELECT c FROM CTaxcategory c WHERE c.description = :description"),
    @NamedQuery(name = "CTaxcategory.findByIsdefault", query = "SELECT c FROM CTaxcategory c WHERE c.isdefault = :isdefault")})
public class CTaxcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_taxcategory_id")
    private String cTaxcategoryId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxcategoryId")
    private List<CTaxcategoryTrl> cTaxcategoryTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxcategoryId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxcategoryId")
    private List<CTax> cTaxList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxcategoryId")
    private List<CCharge> cChargeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxcategoryId")
    private List<SExpensetype> sExpensetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxcategoryId")
    private List<SResourcetype> sResourcetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxcategoryId")
    private List<ITax> iTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxcategoryId")
    private List<CGlitem> cGlitemList;

    public CTaxcategory() {
    }

    public CTaxcategory(String cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    public CTaxcategory(String cTaxcategoryId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isdefault) {
        this.cTaxcategoryId = cTaxcategoryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isdefault = isdefault;
    }

    public String getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(String cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
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

    @XmlTransient
    public List<CTaxcategoryTrl> getCTaxcategoryTrlList() {
        return cTaxcategoryTrlList;
    }

    public void setCTaxcategoryTrlList(List<CTaxcategoryTrl> cTaxcategoryTrlList) {
        this.cTaxcategoryTrlList = cTaxcategoryTrlList;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<CTax> getCTaxList() {
        return cTaxList;
    }

    public void setCTaxList(List<CTax> cTaxList) {
        this.cTaxList = cTaxList;
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
    public List<CCharge> getCChargeList() {
        return cChargeList;
    }

    public void setCChargeList(List<CCharge> cChargeList) {
        this.cChargeList = cChargeList;
    }

    @XmlTransient
    public List<SExpensetype> getSExpensetypeList() {
        return sExpensetypeList;
    }

    public void setSExpensetypeList(List<SExpensetype> sExpensetypeList) {
        this.sExpensetypeList = sExpensetypeList;
    }

    @XmlTransient
    public List<SResourcetype> getSResourcetypeList() {
        return sResourcetypeList;
    }

    public void setSResourcetypeList(List<SResourcetype> sResourcetypeList) {
        this.sResourcetypeList = sResourcetypeList;
    }

    @XmlTransient
    public List<ITax> getITaxList() {
        return iTaxList;
    }

    public void setITaxList(List<ITax> iTaxList) {
        this.iTaxList = iTaxList;
    }

    @XmlTransient
    public List<CGlitem> getCGlitemList() {
        return cGlitemList;
    }

    public void setCGlitemList(List<CGlitem> cGlitemList) {
        this.cGlitemList = cGlitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxcategoryId != null ? cTaxcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxcategory)) {
            return false;
        }
        CTaxcategory other = (CTaxcategory) object;
        if ((this.cTaxcategoryId == null && other.cTaxcategoryId != null) || (this.cTaxcategoryId != null && !this.cTaxcategoryId.equals(other.cTaxcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxcategory[ cTaxcategoryId=" + cTaxcategoryId + " ]";
    }
    
}
