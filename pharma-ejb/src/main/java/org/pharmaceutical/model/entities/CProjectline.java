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
@Table(name = "c_projectline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjectline.findAll", query = "SELECT c FROM CProjectline c"),
    @NamedQuery(name = "CProjectline.findByCProjectlineId", query = "SELECT c FROM CProjectline c WHERE c.cProjectlineId = :cProjectlineId"),
    @NamedQuery(name = "CProjectline.findByIsactive", query = "SELECT c FROM CProjectline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjectline.findByCreated", query = "SELECT c FROM CProjectline c WHERE c.created = :created"),
    @NamedQuery(name = "CProjectline.findByCreatedby", query = "SELECT c FROM CProjectline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjectline.findByUpdated", query = "SELECT c FROM CProjectline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjectline.findByUpdatedby", query = "SELECT c FROM CProjectline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjectline.findByLine", query = "SELECT c FROM CProjectline c WHERE c.line = :line"),
    @NamedQuery(name = "CProjectline.findByDescription", query = "SELECT c FROM CProjectline c WHERE c.description = :description"),
    @NamedQuery(name = "CProjectline.findByPlannedqty", query = "SELECT c FROM CProjectline c WHERE c.plannedqty = :plannedqty"),
    @NamedQuery(name = "CProjectline.findByPlannedprice", query = "SELECT c FROM CProjectline c WHERE c.plannedprice = :plannedprice"),
    @NamedQuery(name = "CProjectline.findByPlannedamt", query = "SELECT c FROM CProjectline c WHERE c.plannedamt = :plannedamt"),
    @NamedQuery(name = "CProjectline.findByPlannedmarginamt", query = "SELECT c FROM CProjectline c WHERE c.plannedmarginamt = :plannedmarginamt"),
    @NamedQuery(name = "CProjectline.findByCommittedamt", query = "SELECT c FROM CProjectline c WHERE c.committedamt = :committedamt"),
    @NamedQuery(name = "CProjectline.findByInvoicedamt", query = "SELECT c FROM CProjectline c WHERE c.invoicedamt = :invoicedamt"),
    @NamedQuery(name = "CProjectline.findByInvoicedqty", query = "SELECT c FROM CProjectline c WHERE c.invoicedqty = :invoicedqty"),
    @NamedQuery(name = "CProjectline.findByCommittedqty", query = "SELECT c FROM CProjectline c WHERE c.committedqty = :committedqty"),
    @NamedQuery(name = "CProjectline.findByIsprinted", query = "SELECT c FROM CProjectline c WHERE c.isprinted = :isprinted"),
    @NamedQuery(name = "CProjectline.findByProcessed", query = "SELECT c FROM CProjectline c WHERE c.processed = :processed"),
    @NamedQuery(name = "CProjectline.findByDopricing", query = "SELECT c FROM CProjectline c WHERE c.dopricing = :dopricing"),
    @NamedQuery(name = "CProjectline.findByPlannedpoprice", query = "SELECT c FROM CProjectline c WHERE c.plannedpoprice = :plannedpoprice"),
    @NamedQuery(name = "CProjectline.findByProductDescription", query = "SELECT c FROM CProjectline c WHERE c.productDescription = :productDescription"),
    @NamedQuery(name = "CProjectline.findByProductName", query = "SELECT c FROM CProjectline c WHERE c.productName = :productName"),
    @NamedQuery(name = "CProjectline.findByProductValue", query = "SELECT c FROM CProjectline c WHERE c.productValue = :productValue")})
public class CProjectline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_projectline_id")
    private String cProjectlineId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedqty")
    private BigInteger plannedqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedprice")
    private BigInteger plannedprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedamt")
    private BigInteger plannedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedmarginamt")
    private BigInteger plannedmarginamt;
    @Column(name = "committedamt")
    private BigInteger committedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoicedamt")
    private BigInteger invoicedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoicedqty")
    private BigInteger invoicedqty;
    @Column(name = "committedqty")
    private BigInteger committedqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isprinted")
    private Character isprinted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Column(name = "dopricing")
    private Character dopricing;
    @Column(name = "plannedpoprice")
    private BigInteger plannedpoprice;
    @Size(max = 2000)
    @Column(name = "product_description")
    private String productDescription;
    @Size(max = 60)
    @Column(name = "product_name")
    private String productName;
    @Size(max = 40)
    @Column(name = "product_value")
    private String productValue;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectlineId")
    private List<CInvoiceline> cInvoicelineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_orderpo_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderpoId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProject cProjectId;
    @JoinColumn(name = "c_projectissue_id", referencedColumnName = "c_projectissue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProjectissue cProjectissueId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;

    public CProjectline() {
    }

    public CProjectline(String cProjectlineId) {
        this.cProjectlineId = cProjectlineId;
    }

    public CProjectline(String cProjectlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, BigInteger plannedqty, BigInteger plannedprice, BigInteger plannedamt, BigInteger plannedmarginamt, BigInteger invoicedamt, BigInteger invoicedqty, Character isprinted, Character processed) {
        this.cProjectlineId = cProjectlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.plannedqty = plannedqty;
        this.plannedprice = plannedprice;
        this.plannedamt = plannedamt;
        this.plannedmarginamt = plannedmarginamt;
        this.invoicedamt = invoicedamt;
        this.invoicedqty = invoicedqty;
        this.isprinted = isprinted;
        this.processed = processed;
    }

    public String getCProjectlineId() {
        return cProjectlineId;
    }

    public void setCProjectlineId(String cProjectlineId) {
        this.cProjectlineId = cProjectlineId;
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

    public BigInteger getPlannedqty() {
        return plannedqty;
    }

    public void setPlannedqty(BigInteger plannedqty) {
        this.plannedqty = plannedqty;
    }

    public BigInteger getPlannedprice() {
        return plannedprice;
    }

    public void setPlannedprice(BigInteger plannedprice) {
        this.plannedprice = plannedprice;
    }

    public BigInteger getPlannedamt() {
        return plannedamt;
    }

    public void setPlannedamt(BigInteger plannedamt) {
        this.plannedamt = plannedamt;
    }

    public BigInteger getPlannedmarginamt() {
        return plannedmarginamt;
    }

    public void setPlannedmarginamt(BigInteger plannedmarginamt) {
        this.plannedmarginamt = plannedmarginamt;
    }

    public BigInteger getCommittedamt() {
        return committedamt;
    }

    public void setCommittedamt(BigInteger committedamt) {
        this.committedamt = committedamt;
    }

    public BigInteger getInvoicedamt() {
        return invoicedamt;
    }

    public void setInvoicedamt(BigInteger invoicedamt) {
        this.invoicedamt = invoicedamt;
    }

    public BigInteger getInvoicedqty() {
        return invoicedqty;
    }

    public void setInvoicedqty(BigInteger invoicedqty) {
        this.invoicedqty = invoicedqty;
    }

    public BigInteger getCommittedqty() {
        return committedqty;
    }

    public void setCommittedqty(BigInteger committedqty) {
        this.committedqty = committedqty;
    }

    public Character getIsprinted() {
        return isprinted;
    }

    public void setIsprinted(Character isprinted) {
        this.isprinted = isprinted;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getDopricing() {
        return dopricing;
    }

    public void setDopricing(Character dopricing) {
        this.dopricing = dopricing;
    }

    public BigInteger getPlannedpoprice() {
        return plannedpoprice;
    }

    public void setPlannedpoprice(BigInteger plannedpoprice) {
        this.plannedpoprice = plannedpoprice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
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

    public COrder getCOrderpoId() {
        return cOrderpoId;
    }

    public void setCOrderpoId(COrder cOrderpoId) {
        this.cOrderpoId = cOrderpoId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public CProjectissue getCProjectissueId() {
        return cProjectissueId;
    }

    public void setCProjectissueId(CProjectissue cProjectissueId) {
        this.cProjectissueId = cProjectissueId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
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
        hash += (cProjectlineId != null ? cProjectlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjectline)) {
            return false;
        }
        CProjectline other = (CProjectline) object;
        if ((this.cProjectlineId == null && other.cProjectlineId != null) || (this.cProjectlineId != null && !this.cProjectlineId.equals(other.cProjectlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjectline[ cProjectlineId=" + cProjectlineId + " ]";
    }
    
}
