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
@Table(name = "c_invoiceline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoiceline.findAll", query = "SELECT c FROM CInvoiceline c"),
    @NamedQuery(name = "CInvoiceline.findByCInvoicelineId", query = "SELECT c FROM CInvoiceline c WHERE c.cInvoicelineId = :cInvoicelineId"),
    @NamedQuery(name = "CInvoiceline.findByIsactive", query = "SELECT c FROM CInvoiceline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoiceline.findByCreated", query = "SELECT c FROM CInvoiceline c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoiceline.findByCreatedby", query = "SELECT c FROM CInvoiceline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoiceline.findByUpdated", query = "SELECT c FROM CInvoiceline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoiceline.findByUpdatedby", query = "SELECT c FROM CInvoiceline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CInvoiceline.findByLine", query = "SELECT c FROM CInvoiceline c WHERE c.line = :line"),
    @NamedQuery(name = "CInvoiceline.findByDescription", query = "SELECT c FROM CInvoiceline c WHERE c.description = :description"),
    @NamedQuery(name = "CInvoiceline.findByFinancialInvoiceLine", query = "SELECT c FROM CInvoiceline c WHERE c.financialInvoiceLine = :financialInvoiceLine"),
    @NamedQuery(name = "CInvoiceline.findByQtyinvoiced", query = "SELECT c FROM CInvoiceline c WHERE c.qtyinvoiced = :qtyinvoiced"),
    @NamedQuery(name = "CInvoiceline.findByPricelist", query = "SELECT c FROM CInvoiceline c WHERE c.pricelist = :pricelist"),
    @NamedQuery(name = "CInvoiceline.findByPriceactual", query = "SELECT c FROM CInvoiceline c WHERE c.priceactual = :priceactual"),
    @NamedQuery(name = "CInvoiceline.findByPricelimit", query = "SELECT c FROM CInvoiceline c WHERE c.pricelimit = :pricelimit"),
    @NamedQuery(name = "CInvoiceline.findByLinenetamt", query = "SELECT c FROM CInvoiceline c WHERE c.linenetamt = :linenetamt"),
    @NamedQuery(name = "CInvoiceline.findByChargeamt", query = "SELECT c FROM CInvoiceline c WHERE c.chargeamt = :chargeamt"),
    @NamedQuery(name = "CInvoiceline.findByTaxamt", query = "SELECT c FROM CInvoiceline c WHERE c.taxamt = :taxamt"),
    @NamedQuery(name = "CInvoiceline.findByIsdescription", query = "SELECT c FROM CInvoiceline c WHERE c.isdescription = :isdescription"),
    @NamedQuery(name = "CInvoiceline.findByQuantityorder", query = "SELECT c FROM CInvoiceline c WHERE c.quantityorder = :quantityorder"),
    @NamedQuery(name = "CInvoiceline.findByPricestd", query = "SELECT c FROM CInvoiceline c WHERE c.pricestd = :pricestd"),
    @NamedQuery(name = "CInvoiceline.findByExcludeforwithholding", query = "SELECT c FROM CInvoiceline c WHERE c.excludeforwithholding = :excludeforwithholding"),
    @NamedQuery(name = "CInvoiceline.findByIseditlinenetamt", query = "SELECT c FROM CInvoiceline c WHERE c.iseditlinenetamt = :iseditlinenetamt"),
    @NamedQuery(name = "CInvoiceline.findByTaxbaseamt", query = "SELECT c FROM CInvoiceline c WHERE c.taxbaseamt = :taxbaseamt")})
public class CInvoiceline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoiceline_id")
    private String cInvoicelineId;
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
    @Column(name = "line")
    private long line;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "financial_invoice_line")
    private Character financialInvoiceLine;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyinvoiced")
    private BigInteger qtyinvoiced;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricelist")
    private BigInteger pricelist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priceactual")
    private BigInteger priceactual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricelimit")
    private BigInteger pricelimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "linenetamt")
    private BigInteger linenetamt;
    @Column(name = "chargeamt")
    private BigInteger chargeamt;
    @Column(name = "taxamt")
    private BigInteger taxamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdescription")
    private Character isdescription;
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pricestd")
    private BigInteger pricestd;
    @Column(name = "excludeforwithholding")
    private Character excludeforwithholding;
    @Column(name = "iseditlinenetamt")
    private Character iseditlinenetamt;
    @Column(name = "taxbaseamt")
    private BigInteger taxbaseamt;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoicelineId")
    private List<MaPlInvoiceline> maPlInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoicelineId")
    private List<CInvoicelineOffer> cInvoicelineOfferList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoicelineId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoicelineId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoicelineId")
    private List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoicelineId")
    private List<CInvoicelinetax> cInvoicelinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoicelineId")
    private List<MCosting> mCostingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoicelineId")
    private List<MMatchinv> mMatchinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cInvoicelineId")
    private List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoicelineId")
    private List<CCommissiondetail> cCommissiondetailList;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCharge cChargeId;
    @JoinColumn(name = "account_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGlitem accountId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "c_invoice_discount_id", referencedColumnName = "c_invoice_discount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoiceDiscount cInvoiceDiscountId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_offer_id", referencedColumnName = "m_offer_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MOffer mOfferId;
    @JoinColumn(name = "s_resourceassignment_id", referencedColumnName = "s_resourceassignment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private SResourceassignment sResourceassignmentId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderline cOrderlineId;
    @JoinColumn(name = "c_projectline_id", referencedColumnName = "c_projectline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProjectline cProjectlineId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_inoutline_id", referencedColumnName = "m_inoutline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInoutline mInoutlineId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoicelineId")
    private List<MMatchpo> mMatchpoList;

    public CInvoiceline() {
    }

    public CInvoiceline(String cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public CInvoiceline(String cInvoicelineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, Character financialInvoiceLine, BigInteger qtyinvoiced, BigInteger pricelist, BigInteger priceactual, BigInteger pricelimit, BigInteger linenetamt, Character isdescription, BigInteger pricestd) {
        this.cInvoicelineId = cInvoicelineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.financialInvoiceLine = financialInvoiceLine;
        this.qtyinvoiced = qtyinvoiced;
        this.pricelist = pricelist;
        this.priceactual = priceactual;
        this.pricelimit = pricelimit;
        this.linenetamt = linenetamt;
        this.isdescription = isdescription;
        this.pricestd = pricestd;
    }

    public String getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(String cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getFinancialInvoiceLine() {
        return financialInvoiceLine;
    }

    public void setFinancialInvoiceLine(Character financialInvoiceLine) {
        this.financialInvoiceLine = financialInvoiceLine;
    }

    public BigInteger getQtyinvoiced() {
        return qtyinvoiced;
    }

    public void setQtyinvoiced(BigInteger qtyinvoiced) {
        this.qtyinvoiced = qtyinvoiced;
    }

    public BigInteger getPricelist() {
        return pricelist;
    }

    public void setPricelist(BigInteger pricelist) {
        this.pricelist = pricelist;
    }

    public BigInteger getPriceactual() {
        return priceactual;
    }

    public void setPriceactual(BigInteger priceactual) {
        this.priceactual = priceactual;
    }

    public BigInteger getPricelimit() {
        return pricelimit;
    }

    public void setPricelimit(BigInteger pricelimit) {
        this.pricelimit = pricelimit;
    }

    public BigInteger getLinenetamt() {
        return linenetamt;
    }

    public void setLinenetamt(BigInteger linenetamt) {
        this.linenetamt = linenetamt;
    }

    public BigInteger getChargeamt() {
        return chargeamt;
    }

    public void setChargeamt(BigInteger chargeamt) {
        this.chargeamt = chargeamt;
    }

    public BigInteger getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(BigInteger taxamt) {
        this.taxamt = taxamt;
    }

    public Character getIsdescription() {
        return isdescription;
    }

    public void setIsdescription(Character isdescription) {
        this.isdescription = isdescription;
    }

    public BigInteger getQuantityorder() {
        return quantityorder;
    }

    public void setQuantityorder(BigInteger quantityorder) {
        this.quantityorder = quantityorder;
    }

    public BigInteger getPricestd() {
        return pricestd;
    }

    public void setPricestd(BigInteger pricestd) {
        this.pricestd = pricestd;
    }

    public Character getExcludeforwithholding() {
        return excludeforwithholding;
    }

    public void setExcludeforwithholding(Character excludeforwithholding) {
        this.excludeforwithholding = excludeforwithholding;
    }

    public Character getIseditlinenetamt() {
        return iseditlinenetamt;
    }

    public void setIseditlinenetamt(Character iseditlinenetamt) {
        this.iseditlinenetamt = iseditlinenetamt;
    }

    public BigInteger getTaxbaseamt() {
        return taxbaseamt;
    }

    public void setTaxbaseamt(BigInteger taxbaseamt) {
        this.taxbaseamt = taxbaseamt;
    }

    @XmlTransient
    public List<MaPlInvoiceline> getMaPlInvoicelineList() {
        return maPlInvoicelineList;
    }

    public void setMaPlInvoicelineList(List<MaPlInvoiceline> maPlInvoicelineList) {
        this.maPlInvoicelineList = maPlInvoicelineList;
    }

    @XmlTransient
    public List<CInvoicelineOffer> getCInvoicelineOfferList() {
        return cInvoicelineOfferList;
    }

    public void setCInvoicelineOfferList(List<CInvoicelineOffer> cInvoicelineOfferList) {
        this.cInvoicelineOfferList = cInvoicelineOfferList;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<STimeexpenseline> getSTimeexpenselineList() {
        return sTimeexpenselineList;
    }

    public void setSTimeexpenselineList(List<STimeexpenseline> sTimeexpenselineList) {
        this.sTimeexpenselineList = sTimeexpenselineList;
    }

    @XmlTransient
    public List<CInvoicelineAcctdimension> getCInvoicelineAcctdimensionList() {
        return cInvoicelineAcctdimensionList;
    }

    public void setCInvoicelineAcctdimensionList(List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList) {
        this.cInvoicelineAcctdimensionList = cInvoicelineAcctdimensionList;
    }

    @XmlTransient
    public List<CInvoicelinetax> getCInvoicelinetaxList() {
        return cInvoicelinetaxList;
    }

    public void setCInvoicelinetaxList(List<CInvoicelinetax> cInvoicelinetaxList) {
        this.cInvoicelinetaxList = cInvoicelinetaxList;
    }

    @XmlTransient
    public List<MCosting> getMCostingList() {
        return mCostingList;
    }

    public void setMCostingList(List<MCosting> mCostingList) {
        this.mCostingList = mCostingList;
    }

    @XmlTransient
    public List<MMatchinv> getMMatchinvList() {
        return mMatchinvList;
    }

    public void setMMatchinvList(List<MMatchinv> mMatchinvList) {
        this.mMatchinvList = mMatchinvList;
    }

    @XmlTransient
    public List<CRevenuerecognitionPlan> getCRevenuerecognitionPlanList() {
        return cRevenuerecognitionPlanList;
    }

    public void setCRevenuerecognitionPlanList(List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList) {
        this.cRevenuerecognitionPlanList = cRevenuerecognitionPlanList;
    }

    @XmlTransient
    public List<CCommissiondetail> getCCommissiondetailList() {
        return cCommissiondetailList;
    }

    public void setCCommissiondetailList(List<CCommissiondetail> cCommissiondetailList) {
        this.cCommissiondetailList = cCommissiondetailList;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
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

    public CCharge getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(CCharge cChargeId) {
        this.cChargeId = cChargeId;
    }

    public CGlitem getAccountId() {
        return accountId;
    }

    public void setAccountId(CGlitem accountId) {
        this.accountId = accountId;
    }

    public MProductUom getMProductUomId() {
        return mProductUomId;
    }

    public void setMProductUomId(MProductUom mProductUomId) {
        this.mProductUomId = mProductUomId;
    }

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    public CInvoiceDiscount getCInvoiceDiscountId() {
        return cInvoiceDiscountId;
    }

    public void setCInvoiceDiscountId(CInvoiceDiscount cInvoiceDiscountId) {
        this.cInvoiceDiscountId = cInvoiceDiscountId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MOffer getMOfferId() {
        return mOfferId;
    }

    public void setMOfferId(MOffer mOfferId) {
        this.mOfferId = mOfferId;
    }

    public SResourceassignment getSResourceassignmentId() {
        return sResourceassignmentId;
    }

    public void setSResourceassignmentId(SResourceassignment sResourceassignmentId) {
        this.sResourceassignmentId = sResourceassignmentId;
    }

    public COrderline getCOrderlineId() {
        return cOrderlineId;
    }

    public void setCOrderlineId(COrderline cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
    }

    public CProjectline getCProjectlineId() {
        return cProjectlineId;
    }

    public void setCProjectlineId(CProjectline cProjectlineId) {
        this.cProjectlineId = cProjectlineId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MInoutline getMInoutlineId() {
        return mInoutlineId;
    }

    public void setMInoutlineId(MInoutline mInoutlineId) {
        this.mInoutlineId = mInoutlineId;
    }

    @XmlTransient
    public List<MMatchpo> getMMatchpoList() {
        return mMatchpoList;
    }

    public void setMMatchpoList(List<MMatchpo> mMatchpoList) {
        this.mMatchpoList = mMatchpoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInvoicelineId != null ? cInvoicelineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoiceline)) {
            return false;
        }
        CInvoiceline other = (CInvoiceline) object;
        if ((this.cInvoicelineId == null && other.cInvoicelineId != null) || (this.cInvoicelineId != null && !this.cInvoicelineId.equals(other.cInvoicelineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoiceline[ cInvoicelineId=" + cInvoicelineId + " ]";
    }
    
}
