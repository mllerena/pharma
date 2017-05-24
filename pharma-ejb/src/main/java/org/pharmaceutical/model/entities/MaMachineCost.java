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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.CostUOMConverter;
import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_machine_cost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMachineCost.findAll", query = "SELECT m FROM MaMachineCost m"),
    @NamedQuery(name = "MaMachineCost.findByMaMachineCostId", query = "SELECT m FROM MaMachineCost m WHERE m.maMachineCostId = :maMachineCostId"),
    @NamedQuery(name = "MaMachineCost.findByCreated", query = "SELECT m FROM MaMachineCost m WHERE m.created = :created"),
    @NamedQuery(name = "MaMachineCost.findByCreatedby", query = "SELECT m FROM MaMachineCost m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMachineCost.findByUpdated", query = "SELECT m FROM MaMachineCost m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMachineCost.findByUpdatedby", query = "SELECT m FROM MaMachineCost m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMachineCost.findByCost", query = "SELECT m FROM MaMachineCost m WHERE m.cost = :cost"),
    @NamedQuery(name = "MaMachineCost.findByIsactive", query = "SELECT m FROM MaMachineCost m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMachineCost.findByValidfrom", query = "SELECT m FROM MaMachineCost m WHERE m.validfrom = :validfrom"),
    @NamedQuery(name = "MaMachineCost.findByCostuom", query = "SELECT m FROM MaMachineCost m WHERE m.costuom = :costuom"),
    @NamedQuery(name = "MaMachineCost.findByAmortization", query = "SELECT m FROM MaMachineCost m WHERE m.amortization = :amortization"),
    @NamedQuery(name = "MaMachineCost.findByConsume", query = "SELECT m FROM MaMachineCost m WHERE m.consume = :consume"),
    @NamedQuery(name = "MaMachineCost.findByCostuomyear", query = "SELECT m FROM MaMachineCost m WHERE m.costuomyear = :costuomyear"),
    @NamedQuery(name = "MaMachineCost.findByDayhours", query = "SELECT m FROM MaMachineCost m WHERE m.dayhours = :dayhours"),
    @NamedQuery(name = "MaMachineCost.findByDaysyear", query = "SELECT m FROM MaMachineCost m WHERE m.daysyear = :daysyear"),
    @NamedQuery(name = "MaMachineCost.findByImproductivehoursyear", query = "SELECT m FROM MaMachineCost m WHERE m.improductivehoursyear = :improductivehoursyear"),
    @NamedQuery(name = "MaMachineCost.findByPurchaseamt", query = "SELECT m FROM MaMachineCost m WHERE m.purchaseamt = :purchaseamt"),
    @NamedQuery(name = "MaMachineCost.findByToolsetamt", query = "SELECT m FROM MaMachineCost m WHERE m.toolsetamt = :toolsetamt"),
    @NamedQuery(name = "MaMachineCost.findByYearvalue", query = "SELECT m FROM MaMachineCost m WHERE m.yearvalue = :yearvalue"),
    @NamedQuery(name = "MaMachineCost.findByMaMachineId", query = "SELECT m FROM MaMachineCost m WHERE m.maMachineId = :maMachineId and m.isactive = :isactive order by m.maMachineCostId") 
    

})
public class MaMachineCost  extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_machine_cost_id")
    private String maMachineCostId;
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
    @Column(name = "cost")
    private BigDecimal cost; 
    @Basic(optional = false)
    @Convert(converter=YesNoConverter.class)
    @Column(name = "isactive")
    private YesNo isactive;
    @Basic(optional = false)
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    
    @Basic(optional = false)
    @Column(name = "costuom")
    @Convert(converter=CostUOMConverter.class) 
    private CostUOM costuom;
    
    @Column(name = "amortization")
    private BigInteger amortization;
    @Column(name = "consume")
    private BigInteger consume;
    @Column(name = "costuomyear")
    private BigInteger costuomyear;
    @Column(name = "dayhours")
    private BigInteger dayhours;
    @Column(name = "daysyear")
    private BigInteger daysyear;
    @Column(name = "improductivehoursyear")
    private BigInteger improductivehoursyear;
    @Column(name = "purchaseamt")
    private BigDecimal purchaseamt;
    @Column(name = "toolsetamt")
    private BigInteger toolsetamt;
    @Column(name = "yearvalue")
    private BigInteger yearvalue;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_machine_id", referencedColumnName = "ma_machine_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMachine maMachineId;

    public MaMachineCost() {
    }

    public MaMachineCost(String maMachineCostId) {
        this.maMachineCostId = maMachineCostId;
    }

    public String getMaMachineCostId() {
        return maMachineCostId;
    }

    public void setMaMachineCostId(String maMachineCostId) {
        this.maMachineCostId = maMachineCostId;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
        this.isactive = isactive;
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public CostUOM getCostuom() {
        return costuom;
    }

    public void setCostuom(CostUOM costuom) {
        this.costuom = costuom; 
    }

    public BigInteger getAmortization() {
        return amortization;
    }

    public void setAmortization(BigInteger amortization) {
        this.amortization = amortization;
    }

    public BigInteger getConsume() {
        return consume;
    }

    public void setConsume(BigInteger consume) {
        this.consume = consume;
    }

    public BigInteger getCostuomyear() {
        return costuomyear;
    }

    public void setCostuomyear(BigInteger costuomyear) {
        this.costuomyear = costuomyear;
    }

    public BigInteger getDayhours() {
        return dayhours;
    }

    public void setDayhours(BigInteger dayhours) {
        this.dayhours = dayhours;
    }

    public BigInteger getDaysyear() {
        return daysyear;
    }

    public void setDaysyear(BigInteger daysyear) {
        this.daysyear = daysyear;
    }

    public BigInteger getImproductivehoursyear() {
        return improductivehoursyear;
    }

    public void setImproductivehoursyear(BigInteger improductivehoursyear) {
        this.improductivehoursyear = improductivehoursyear;
    }

    public BigDecimal getPurchaseamt() {
        return purchaseamt;
    }

    public void setPurchaseamt(BigDecimal purchaseamt) {
        this.purchaseamt = purchaseamt; 
    }

    public BigInteger getToolsetamt() {
        return toolsetamt;
    }

    public void setToolsetamt(BigInteger toolsetamt) {
        this.toolsetamt = toolsetamt;
    }

    public BigInteger getYearvalue() {
        return yearvalue;
    }

    public void setYearvalue(BigInteger yearvalue) {
        this.yearvalue = yearvalue;
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

    public MaMachine getMaMachineId() {
        return maMachineId;
    }

    public void setMaMachineId(MaMachine maMachineId) {
        this.maMachineId = maMachineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMachineCostId != null ? maMachineCostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMachineCost)) {
            return false;
        }
        MaMachineCost other = (MaMachineCost) object;
        if ((this.maMachineCostId == null && other.maMachineCostId != null) || (this.maMachineCostId != null && !this.maMachineCostId.equals(other.maMachineCostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMachineCost[ maMachineCostId=" + maMachineCostId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maMachineCostId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maMachineCostId = id; 
	}
    
}
