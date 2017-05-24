/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "m_productionplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductionplan.findAll", query = "SELECT m FROM MProductionplan m"),
    @NamedQuery(name = "MProductionplan.findByMProductionplanId", query = "SELECT m FROM MProductionplan m WHERE m.mProductionplanId = :mProductionplanId"),
    @NamedQuery(name = "MProductionplan.findByIsactive", query = "SELECT m FROM MProductionplan m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductionplan.findByCreated", query = "SELECT m FROM MProductionplan m WHERE m.created = :created"),
    @NamedQuery(name = "MProductionplan.findByCreatedby", query = "SELECT m FROM MProductionplan m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductionplan.findByUpdated", query = "SELECT m FROM MProductionplan m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductionplan.findByUpdatedby", query = "SELECT m FROM MProductionplan m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductionplan.findByLine", query = "SELECT m FROM MProductionplan m WHERE m.line = :line"),
    @NamedQuery(name = "MProductionplan.findByProductionqty", query = "SELECT m FROM MProductionplan m WHERE m.productionqty = :productionqty"),
    @NamedQuery(name = "MProductionplan.findByDescription", query = "SELECT m FROM MProductionplan m WHERE m.description = :description"),
    @NamedQuery(name = "MProductionplan.findByConversionrate", query = "SELECT m FROM MProductionplan m WHERE m.conversionrate = :conversionrate"),
    @NamedQuery(name = "MProductionplan.findByMaCostcenteruse", query = "SELECT m FROM MProductionplan m WHERE m.maCostcenteruse = :maCostcenteruse"),
    @NamedQuery(name = "MProductionplan.findByNeededquantity", query = "SELECT m FROM MProductionplan m WHERE m.neededquantity = :neededquantity"),
    @NamedQuery(name = "MProductionplan.findByProcessed", query = "SELECT m FROM MProductionplan m WHERE m.processed = :processed"),
    @NamedQuery(name = "MProductionplan.findByRejectedquantity", query = "SELECT m FROM MProductionplan m WHERE m.rejectedquantity = :rejectedquantity"),
    @NamedQuery(name = "MProductionplan.findBySecondaryqty", query = "SELECT m FROM MProductionplan m WHERE m.secondaryqty = :secondaryqty"),
    @NamedQuery(name = "MProductionplan.findBySecondaryunit", query = "SELECT m FROM MProductionplan m WHERE m.secondaryunit = :secondaryunit"),
    @NamedQuery(name = "MProductionplan.findByUsedmaterial", query = "SELECT m FROM MProductionplan m WHERE m.usedmaterial = :usedmaterial"),
    @NamedQuery(name = "MProductionplan.findByCalccost", query = "SELECT m FROM MProductionplan m WHERE m.calccost = :calccost"),
    @NamedQuery(name = "MProductionplan.findByOutsourced", query = "SELECT m FROM MProductionplan m WHERE m.outsourced = :outsourced"),
    @NamedQuery(name = "MProductionplan.findByMaWrphaseId", query = "SELECT m FROM MProductionplan m WHERE m.maWrphaseId.name = :name and  m.isactive = :isactive"),
    @NamedQuery(name = "MProductionplan.findByMProductionId", query = "SELECT m FROM MProductionplan m WHERE m.mProductionId = :mProductionId and  m.isactive = :isactive order by m.line") 
    
})
public class MProductionplan extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "m_productionplan_id")
    private String mProductionplanId;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive;
    
    @Basic(optional = false)
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    
    @Basic(optional = false)
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "line")
    private long line;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "productionqty")
    private BigInteger productionqty;
    
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "conversionrate")
    private BigInteger conversionrate;
    
    @Column(name = "ma_costcenteruse")
    private BigDecimal maCostcenteruse;
    
    @Column(name = "neededquantity")
    private BigInteger neededquantity;
    
    @Column(name = "processed")
    @Convert(converter=YesNoConverter.class) 
    private YesNo processed;
    
    @Column(name = "rejectedquantity")
    private BigInteger rejectedquantity;
    
    @Column(name = "secondaryqty")
    private Long secondaryqty;
    
    @Size(max = 40)
    @Column(name = "secondaryunit")
    private String secondaryunit;
    
    @Column(name = "usedmaterial")
    @Convert(converter=YesNoConverter.class) 
    private YesNo usedmaterial;
    
    @Column(name = "calccost")
    private BigDecimal calccost;
    
    @Column(name = "outsourced")
    @Convert(converter=YesNoConverter.class) 
    private YesNo outsourced;
    
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionplanId")
    private List<MaPlInvoiceline> maPlInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionplanId")
    private List<MProductionline> mProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionplanId")
    private List<MaToolsetused> maToolsetusedList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionplanId")
    private List<MaPlIc> maPlIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionplanId")
    private List<MaPlEmployee> maPlEmployeeList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_production_id", referencedColumnName = "m_production_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduction mProductionId;
    @JoinColumn(name = "ma_costcenter_version_id", referencedColumnName = "ma_costcenter_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaCostcenterVersion maCostcenterVersionId;
    @JoinColumn(name = "ma_wrphase_id", referencedColumnName = "ma_wrphase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaWrphase maWrphaseId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductionplanId")
    private List<MaPlMachine> maPlMachineList;

    public MProductionplan() {
    }

    public MProductionplan(String mProductionplanId) {
        this.mProductionplanId = mProductionplanId;
    }

    public String getMProductionplanId() {
        return mProductionplanId;
    }

    public void setMProductionplanId(String mProductionplanId) {
        this.mProductionplanId = mProductionplanId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public BigInteger getProductionqty() {
        return productionqty;
    }

    public void setProductionqty(BigInteger productionqty) {
        this.productionqty = productionqty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getConversionrate() {
        return conversionrate;
    }

    public void setConversionrate(BigInteger conversionrate) {
        this.conversionrate = conversionrate;
    }

    public BigDecimal getMaCostcenteruse() {
        return maCostcenteruse;
    }

    public void setMaCostcenteruse(BigDecimal maCostcenteruse) {
        this.maCostcenteruse = maCostcenteruse;
    }

    public BigInteger getNeededquantity() {
        return neededquantity;
    }

    public void setNeededquantity(BigInteger neededquantity) {
        this.neededquantity = neededquantity;
    }

    public YesNo getProcessed() {
        return processed;
    }

    public void setProcessed(YesNo processed) {
        this.processed = processed;
    }

    public BigInteger getRejectedquantity() {
        return rejectedquantity;
    }

    public void setRejectedquantity(BigInteger rejectedquantity) {
        this.rejectedquantity = rejectedquantity;
    }

    public Long getSecondaryqty() {
        return secondaryqty;
    }

    public void setSecondaryqty(Long secondaryqty) {
        this.secondaryqty = secondaryqty;
    }

    public String getSecondaryunit() {
        return secondaryunit;
    }

    public void setSecondaryunit(String secondaryunit) {
        this.secondaryunit = secondaryunit;
    }

    public YesNo getUsedmaterial() {
        return usedmaterial;
    }

    public void setUsedmaterial(YesNo usedmaterial) {
        this.usedmaterial = usedmaterial;
    }

    public BigDecimal getCalccost() {
        return calccost;
    }

    public void setCalccost(BigDecimal calccost) {
        this.calccost = calccost;
    }

    public YesNo getOutsourced() {
        return outsourced;
    }

    public void setOutsourced(YesNo outsourced) {
        this.outsourced = outsourced;
    }

    @XmlTransient
    public List<MaPlInvoiceline> getMaPlInvoicelineList() {
        return maPlInvoicelineList;
    }

    public void setMaPlInvoicelineList(List<MaPlInvoiceline> maPlInvoicelineList) {
        this.maPlInvoicelineList = maPlInvoicelineList;
    }

    @XmlTransient
    public List<MProductionline> getMProductionlineList() {
        return mProductionlineList;
    }

    public void setMProductionlineList(List<MProductionline> mProductionlineList) {
        this.mProductionlineList = mProductionlineList;
    }

    @XmlTransient
    public List<MaToolsetused> getMaToolsetusedList() {
        return maToolsetusedList;
    }

    public void setMaToolsetusedList(List<MaToolsetused> maToolsetusedList) {
        this.maToolsetusedList = maToolsetusedList;
    }

    @XmlTransient
    public List<MaPlIc> getMaPlIcList() {
        return maPlIcList;
    }

    public void setMaPlIcList(List<MaPlIc> maPlIcList) {
        this.maPlIcList = maPlIcList;
    }

    @XmlTransient
    public List<MaPlEmployee> getMaPlEmployeeList() {
        return maPlEmployeeList;
    }

    public void setMaPlEmployeeList(List<MaPlEmployee> maPlEmployeeList) {
        this.maPlEmployeeList = maPlEmployeeList;
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

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MProduction getMProductionId() {
        return mProductionId;
    }

    public void setMProductionId(MProduction mProductionId) {
        this.mProductionId = mProductionId;
    }

    public MaCostcenterVersion getMaCostcenterVersionId() {
        return maCostcenterVersionId;
    }

    public void setMaCostcenterVersionId(MaCostcenterVersion maCostcenterVersionId) {
        this.maCostcenterVersionId = maCostcenterVersionId;
    }

    public MaWrphase getMaWrphaseId() {
        return maWrphaseId;
    }

    public void setMaWrphaseId(MaWrphase maWrphaseId) {
        this.maWrphaseId = maWrphaseId;
    }

    @XmlTransient
    public List<MaPlMachine> getMaPlMachineList() {
        return maPlMachineList;
    }

    public void setMaPlMachineList(List<MaPlMachine> maPlMachineList) {
        this.maPlMachineList = maPlMachineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductionplanId != null ? mProductionplanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductionplan)) {
            return false;
        }
        MProductionplan other = (MProductionplan) object;
        if ((this.mProductionplanId == null && other.mProductionplanId != null) || (this.mProductionplanId != null && !this.mProductionplanId.equals(other.mProductionplanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductionplan[ mProductionplanId=" + mProductionplanId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return mProductionplanId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		mProductionplanId = id;
	}
    
}
