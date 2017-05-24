/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_discountschemaline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDiscountschemaline.findAll", query = "SELECT m FROM MDiscountschemaline m"),
    @NamedQuery(name = "MDiscountschemaline.findByMDiscountschemalineId", query = "SELECT m FROM MDiscountschemaline m WHERE m.mDiscountschemalineId = :mDiscountschemalineId"),
    @NamedQuery(name = "MDiscountschemaline.findByIsactive", query = "SELECT m FROM MDiscountschemaline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MDiscountschemaline.findByCreated", query = "SELECT m FROM MDiscountschemaline m WHERE m.created = :created"),
    @NamedQuery(name = "MDiscountschemaline.findByCreatedby", query = "SELECT m FROM MDiscountschemaline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MDiscountschemaline.findByUpdated", query = "SELECT m FROM MDiscountschemaline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MDiscountschemaline.findByUpdatedby", query = "SELECT m FROM MDiscountschemaline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MDiscountschemaline.findBySeqno", query = "SELECT m FROM MDiscountschemaline m WHERE m.seqno = :seqno"),
    @NamedQuery(name = "MDiscountschemaline.findByConversionratetype", query = "SELECT m FROM MDiscountschemaline m WHERE m.conversionratetype = :conversionratetype"),
    @NamedQuery(name = "MDiscountschemaline.findByConversiondate", query = "SELECT m FROM MDiscountschemaline m WHERE m.conversiondate = :conversiondate"),
    @NamedQuery(name = "MDiscountschemaline.findByListBase", query = "SELECT m FROM MDiscountschemaline m WHERE m.listBase = :listBase"),
    @NamedQuery(name = "MDiscountschemaline.findByListAddamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.listAddamt = :listAddamt"),
    @NamedQuery(name = "MDiscountschemaline.findByListDiscount", query = "SELECT m FROM MDiscountschemaline m WHERE m.listDiscount = :listDiscount"),
    @NamedQuery(name = "MDiscountschemaline.findByListRounding", query = "SELECT m FROM MDiscountschemaline m WHERE m.listRounding = :listRounding"),
    @NamedQuery(name = "MDiscountschemaline.findByListMinamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.listMinamt = :listMinamt"),
    @NamedQuery(name = "MDiscountschemaline.findByListMaxamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.listMaxamt = :listMaxamt"),
    @NamedQuery(name = "MDiscountschemaline.findByListFixed", query = "SELECT m FROM MDiscountschemaline m WHERE m.listFixed = :listFixed"),
    @NamedQuery(name = "MDiscountschemaline.findByStdBase", query = "SELECT m FROM MDiscountschemaline m WHERE m.stdBase = :stdBase"),
    @NamedQuery(name = "MDiscountschemaline.findByStdAddamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.stdAddamt = :stdAddamt"),
    @NamedQuery(name = "MDiscountschemaline.findByStdDiscount", query = "SELECT m FROM MDiscountschemaline m WHERE m.stdDiscount = :stdDiscount"),
    @NamedQuery(name = "MDiscountschemaline.findByStdRounding", query = "SELECT m FROM MDiscountschemaline m WHERE m.stdRounding = :stdRounding"),
    @NamedQuery(name = "MDiscountschemaline.findByStdMinamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.stdMinamt = :stdMinamt"),
    @NamedQuery(name = "MDiscountschemaline.findByStdMaxamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.stdMaxamt = :stdMaxamt"),
    @NamedQuery(name = "MDiscountschemaline.findByStdFixed", query = "SELECT m FROM MDiscountschemaline m WHERE m.stdFixed = :stdFixed"),
    @NamedQuery(name = "MDiscountschemaline.findByLimitBase", query = "SELECT m FROM MDiscountschemaline m WHERE m.limitBase = :limitBase"),
    @NamedQuery(name = "MDiscountschemaline.findByLimitAddamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.limitAddamt = :limitAddamt"),
    @NamedQuery(name = "MDiscountschemaline.findByLimitDiscount", query = "SELECT m FROM MDiscountschemaline m WHERE m.limitDiscount = :limitDiscount"),
    @NamedQuery(name = "MDiscountschemaline.findByLimitRounding", query = "SELECT m FROM MDiscountschemaline m WHERE m.limitRounding = :limitRounding"),
    @NamedQuery(name = "MDiscountschemaline.findByLimitMinamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.limitMinamt = :limitMinamt"),
    @NamedQuery(name = "MDiscountschemaline.findByLimitMaxamt", query = "SELECT m FROM MDiscountschemaline m WHERE m.limitMaxamt = :limitMaxamt"),
    @NamedQuery(name = "MDiscountschemaline.findByLimitFixed", query = "SELECT m FROM MDiscountschemaline m WHERE m.limitFixed = :limitFixed")})
public class MDiscountschemaline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_discountschemaline_id")
    private String mDiscountschemalineId;
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
    @Column(name = "seqno")
    private long seqno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "conversionratetype")
    private String conversionratetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conversiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conversiondate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "list_base")
    private String listBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "list_addamt")
    private BigInteger listAddamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "list_discount")
    private BigInteger listDiscount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "list_rounding")
    private String listRounding;
    @Basic(optional = false)
    @NotNull
    @Column(name = "list_minamt")
    private BigInteger listMinamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "list_maxamt")
    private BigInteger listMaxamt;
    @Column(name = "list_fixed")
    private BigInteger listFixed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "std_base")
    private String stdBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_addamt")
    private BigInteger stdAddamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_discount")
    private BigInteger stdDiscount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "std_rounding")
    private String stdRounding;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_minamt")
    private BigInteger stdMinamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_maxamt")
    private BigInteger stdMaxamt;
    @Column(name = "std_fixed")
    private BigInteger stdFixed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "limit_base")
    private String limitBase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limit_addamt")
    private BigInteger limitAddamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limit_discount")
    private BigInteger limitDiscount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "limit_rounding")
    private String limitRounding;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limit_minamt")
    private BigInteger limitMinamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limit_maxamt")
    private BigInteger limitMaxamt;
    @Column(name = "limit_fixed")
    private BigInteger limitFixed;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "m_discountschema_id", referencedColumnName = "m_discountschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MDiscountschema mDiscountschemaId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;

    public MDiscountschemaline() {
    }

    public MDiscountschemaline(String mDiscountschemalineId) {
        this.mDiscountschemalineId = mDiscountschemalineId;
    }

    public MDiscountschemaline(String mDiscountschemalineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno, String conversionratetype, Date conversiondate, String listBase, BigInteger listAddamt, BigInteger listDiscount, String listRounding, BigInteger listMinamt, BigInteger listMaxamt, String stdBase, BigInteger stdAddamt, BigInteger stdDiscount, String stdRounding, BigInteger stdMinamt, BigInteger stdMaxamt, String limitBase, BigInteger limitAddamt, BigInteger limitDiscount, String limitRounding, BigInteger limitMinamt, BigInteger limitMaxamt) {
        this.mDiscountschemalineId = mDiscountschemalineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
        this.conversionratetype = conversionratetype;
        this.conversiondate = conversiondate;
        this.listBase = listBase;
        this.listAddamt = listAddamt;
        this.listDiscount = listDiscount;
        this.listRounding = listRounding;
        this.listMinamt = listMinamt;
        this.listMaxamt = listMaxamt;
        this.stdBase = stdBase;
        this.stdAddamt = stdAddamt;
        this.stdDiscount = stdDiscount;
        this.stdRounding = stdRounding;
        this.stdMinamt = stdMinamt;
        this.stdMaxamt = stdMaxamt;
        this.limitBase = limitBase;
        this.limitAddamt = limitAddamt;
        this.limitDiscount = limitDiscount;
        this.limitRounding = limitRounding;
        this.limitMinamt = limitMinamt;
        this.limitMaxamt = limitMaxamt;
    }

    public String getMDiscountschemalineId() {
        return mDiscountschemalineId;
    }

    public void setMDiscountschemalineId(String mDiscountschemalineId) {
        this.mDiscountschemalineId = mDiscountschemalineId;
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

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getConversionratetype() {
        return conversionratetype;
    }

    public void setConversionratetype(String conversionratetype) {
        this.conversionratetype = conversionratetype;
    }

    public Date getConversiondate() {
        return conversiondate;
    }

    public void setConversiondate(Date conversiondate) {
        this.conversiondate = conversiondate;
    }

    public String getListBase() {
        return listBase;
    }

    public void setListBase(String listBase) {
        this.listBase = listBase;
    }

    public BigInteger getListAddamt() {
        return listAddamt;
    }

    public void setListAddamt(BigInteger listAddamt) {
        this.listAddamt = listAddamt;
    }

    public BigInteger getListDiscount() {
        return listDiscount;
    }

    public void setListDiscount(BigInteger listDiscount) {
        this.listDiscount = listDiscount;
    }

    public String getListRounding() {
        return listRounding;
    }

    public void setListRounding(String listRounding) {
        this.listRounding = listRounding;
    }

    public BigInteger getListMinamt() {
        return listMinamt;
    }

    public void setListMinamt(BigInteger listMinamt) {
        this.listMinamt = listMinamt;
    }

    public BigInteger getListMaxamt() {
        return listMaxamt;
    }

    public void setListMaxamt(BigInteger listMaxamt) {
        this.listMaxamt = listMaxamt;
    }

    public BigInteger getListFixed() {
        return listFixed;
    }

    public void setListFixed(BigInteger listFixed) {
        this.listFixed = listFixed;
    }

    public String getStdBase() {
        return stdBase;
    }

    public void setStdBase(String stdBase) {
        this.stdBase = stdBase;
    }

    public BigInteger getStdAddamt() {
        return stdAddamt;
    }

    public void setStdAddamt(BigInteger stdAddamt) {
        this.stdAddamt = stdAddamt;
    }

    public BigInteger getStdDiscount() {
        return stdDiscount;
    }

    public void setStdDiscount(BigInteger stdDiscount) {
        this.stdDiscount = stdDiscount;
    }

    public String getStdRounding() {
        return stdRounding;
    }

    public void setStdRounding(String stdRounding) {
        this.stdRounding = stdRounding;
    }

    public BigInteger getStdMinamt() {
        return stdMinamt;
    }

    public void setStdMinamt(BigInteger stdMinamt) {
        this.stdMinamt = stdMinamt;
    }

    public BigInteger getStdMaxamt() {
        return stdMaxamt;
    }

    public void setStdMaxamt(BigInteger stdMaxamt) {
        this.stdMaxamt = stdMaxamt;
    }

    public BigInteger getStdFixed() {
        return stdFixed;
    }

    public void setStdFixed(BigInteger stdFixed) {
        this.stdFixed = stdFixed;
    }

    public String getLimitBase() {
        return limitBase;
    }

    public void setLimitBase(String limitBase) {
        this.limitBase = limitBase;
    }

    public BigInteger getLimitAddamt() {
        return limitAddamt;
    }

    public void setLimitAddamt(BigInteger limitAddamt) {
        this.limitAddamt = limitAddamt;
    }

    public BigInteger getLimitDiscount() {
        return limitDiscount;
    }

    public void setLimitDiscount(BigInteger limitDiscount) {
        this.limitDiscount = limitDiscount;
    }

    public String getLimitRounding() {
        return limitRounding;
    }

    public void setLimitRounding(String limitRounding) {
        this.limitRounding = limitRounding;
    }

    public BigInteger getLimitMinamt() {
        return limitMinamt;
    }

    public void setLimitMinamt(BigInteger limitMinamt) {
        this.limitMinamt = limitMinamt;
    }

    public BigInteger getLimitMaxamt() {
        return limitMaxamt;
    }

    public void setLimitMaxamt(BigInteger limitMaxamt) {
        this.limitMaxamt = limitMaxamt;
    }

    public BigInteger getLimitFixed() {
        return limitFixed;
    }

    public void setLimitFixed(BigInteger limitFixed) {
        this.limitFixed = limitFixed;
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

    public MDiscountschema getMDiscountschemaId() {
        return mDiscountschemaId;
    }

    public void setMDiscountschemaId(MDiscountschema mDiscountschemaId) {
        this.mDiscountschemaId = mDiscountschemaId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
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
        hash += (mDiscountschemalineId != null ? mDiscountschemalineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MDiscountschemaline)) {
            return false;
        }
        MDiscountschemaline other = (MDiscountschemaline) object;
        if ((this.mDiscountschemalineId == null && other.mDiscountschemalineId != null) || (this.mDiscountschemalineId != null && !this.mDiscountschemalineId.equals(other.mDiscountschemalineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MDiscountschemaline[ mDiscountschemalineId=" + mDiscountschemalineId + " ]";
    }
    
}
