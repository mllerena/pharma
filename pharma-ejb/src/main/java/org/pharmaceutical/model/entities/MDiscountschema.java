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
@Table(name = "m_discountschema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDiscountschema.findAll", query = "SELECT m FROM MDiscountschema m"),
    @NamedQuery(name = "MDiscountschema.findByMDiscountschemaId", query = "SELECT m FROM MDiscountschema m WHERE m.mDiscountschemaId = :mDiscountschemaId"),
    @NamedQuery(name = "MDiscountschema.findByIsactive", query = "SELECT m FROM MDiscountschema m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MDiscountschema.findByCreated", query = "SELECT m FROM MDiscountschema m WHERE m.created = :created"),
    @NamedQuery(name = "MDiscountschema.findByCreatedby", query = "SELECT m FROM MDiscountschema m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MDiscountschema.findByUpdated", query = "SELECT m FROM MDiscountschema m WHERE m.updated = :updated"),
    @NamedQuery(name = "MDiscountschema.findByUpdatedby", query = "SELECT m FROM MDiscountschema m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MDiscountschema.findByName", query = "SELECT m FROM MDiscountschema m WHERE m.name = :name"),
    @NamedQuery(name = "MDiscountschema.findByDescription", query = "SELECT m FROM MDiscountschema m WHERE m.description = :description"),
    @NamedQuery(name = "MDiscountschema.findByValidfrom", query = "SELECT m FROM MDiscountschema m WHERE m.validfrom = :validfrom"),
    @NamedQuery(name = "MDiscountschema.findByDiscounttype", query = "SELECT m FROM MDiscountschema m WHERE m.discounttype = :discounttype"),
    @NamedQuery(name = "MDiscountschema.findByScript", query = "SELECT m FROM MDiscountschema m WHERE m.script = :script"),
    @NamedQuery(name = "MDiscountschema.findByFlatdiscount", query = "SELECT m FROM MDiscountschema m WHERE m.flatdiscount = :flatdiscount"),
    @NamedQuery(name = "MDiscountschema.findByIsquantitybased", query = "SELECT m FROM MDiscountschema m WHERE m.isquantitybased = :isquantitybased"),
    @NamedQuery(name = "MDiscountschema.findByCumulativelevel", query = "SELECT m FROM MDiscountschema m WHERE m.cumulativelevel = :cumulativelevel"),
    @NamedQuery(name = "MDiscountschema.findByProcessing", query = "SELECT m FROM MDiscountschema m WHERE m.processing = :processing")})
public class MDiscountschema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_discountschema_id")
    private String mDiscountschemaId;
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
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Size(max = 60)
    @Column(name = "discounttype")
    private String discounttype;
    @Size(max = 2000)
    @Column(name = "script")
    private String script;
    @Column(name = "flatdiscount")
    private BigInteger flatdiscount;
    @Column(name = "isquantitybased")
    private Character isquantitybased;
    @Size(max = 60)
    @Column(name = "cumulativelevel")
    private String cumulativelevel;
    @Column(name = "processing")
    private Character processing;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mDiscountschemaId")
    private List<MPricelistVersion> mPricelistVersionList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mDiscountschemaId")
    private List<MDiscountschemaline> mDiscountschemalineList;

    public MDiscountschema() {
    }

    public MDiscountschema(String mDiscountschemaId) {
        this.mDiscountschemaId = mDiscountschemaId;
    }

    public MDiscountschema(String mDiscountschemaId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.mDiscountschemaId = mDiscountschemaId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getMDiscountschemaId() {
        return mDiscountschemaId;
    }

    public void setMDiscountschemaId(String mDiscountschemaId) {
        this.mDiscountschemaId = mDiscountschemaId;
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

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public String getDiscounttype() {
        return discounttype;
    }

    public void setDiscounttype(String discounttype) {
        this.discounttype = discounttype;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public BigInteger getFlatdiscount() {
        return flatdiscount;
    }

    public void setFlatdiscount(BigInteger flatdiscount) {
        this.flatdiscount = flatdiscount;
    }

    public Character getIsquantitybased() {
        return isquantitybased;
    }

    public void setIsquantitybased(Character isquantitybased) {
        this.isquantitybased = isquantitybased;
    }

    public String getCumulativelevel() {
        return cumulativelevel;
    }

    public void setCumulativelevel(String cumulativelevel) {
        this.cumulativelevel = cumulativelevel;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    @XmlTransient
    public List<MPricelistVersion> getMPricelistVersionList() {
        return mPricelistVersionList;
    }

    public void setMPricelistVersionList(List<MPricelistVersion> mPricelistVersionList) {
        this.mPricelistVersionList = mPricelistVersionList;
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
    public List<MDiscountschemaline> getMDiscountschemalineList() {
        return mDiscountschemalineList;
    }

    public void setMDiscountschemalineList(List<MDiscountschemaline> mDiscountschemalineList) {
        this.mDiscountschemalineList = mDiscountschemalineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mDiscountschemaId != null ? mDiscountschemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MDiscountschema)) {
            return false;
        }
        MDiscountschema other = (MDiscountschema) object;
        if ((this.mDiscountschemaId == null && other.mDiscountschemaId != null) || (this.mDiscountschemaId != null && !this.mDiscountschemaId.equals(other.mDiscountschemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MDiscountschema[ mDiscountschemaId=" + mDiscountschemaId + " ]";
    }
    
}
