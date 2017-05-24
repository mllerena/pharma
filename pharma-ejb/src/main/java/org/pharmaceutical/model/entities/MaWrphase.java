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
@Table(name = "ma_wrphase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaWrphase.findAll", query = "SELECT m FROM MaWrphase m"),
    @NamedQuery(name = "MaWrphase.findByMaWrphaseId", query = "SELECT m FROM MaWrphase m WHERE m.maWrphaseId = :maWrphaseId"),
    @NamedQuery(name = "MaWrphase.findByIsactive", query = "SELECT m FROM MaWrphase m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaWrphase.findByCreated", query = "SELECT m FROM MaWrphase m WHERE m.created = :created"),
    @NamedQuery(name = "MaWrphase.findByCreatedby", query = "SELECT m FROM MaWrphase m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaWrphase.findByUpdated", query = "SELECT m FROM MaWrphase m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaWrphase.findByUpdatedby", query = "SELECT m FROM MaWrphase m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaWrphase.findByQuantity", query = "SELECT m FROM MaWrphase m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MaWrphase.findByDonequantity", query = "SELECT m FROM MaWrphase m WHERE m.donequantity = :donequantity"),
    @NamedQuery(name = "MaWrphase.findByCostcenteruse", query = "SELECT m FROM MaWrphase m WHERE m.costcenteruse = :costcenteruse"),
    @NamedQuery(name = "MaWrphase.findByPreptime", query = "SELECT m FROM MaWrphase m WHERE m.preptime = :preptime"),
    @NamedQuery(name = "MaWrphase.findByClosed", query = "SELECT m FROM MaWrphase m WHERE m.closed = :closed"),
    @NamedQuery(name = "MaWrphase.findBySeqno", query = "SELECT m FROM MaWrphase m WHERE m.seqno = :seqno"),
    @NamedQuery(name = "MaWrphase.findByNoqty", query = "SELECT m FROM MaWrphase m WHERE m.noqty = :noqty"),
    @NamedQuery(name = "MaWrphase.findByGroupuse", query = "SELECT m FROM MaWrphase m WHERE m.groupuse = :groupuse"),
    @NamedQuery(name = "MaWrphase.findByName", query = "SELECT m FROM MaWrphase m WHERE m.name = :name"),
    @NamedQuery(name = "MaWrphase.findByDescription", query = "SELECT m FROM MaWrphase m WHERE m.description = :description"),
    @NamedQuery(name = "MaWrphase.findByOutsourced", query = "SELECT m FROM MaWrphase m WHERE m.outsourced = :outsourced"),
    @NamedQuery(name = "MaWrphase.findByMaWorkrequirementId", query = "SELECT m FROM MaWrphase m WHERE m.maWorkrequirementId = :maWorkrequirementId and m.isactive = :isactive order by m.seqno")
    
})
public class MaWrphase extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_wrphase_id")
    private String maWrphaseId;
    
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
    @Column(name = "quantity")
    private BigInteger quantity;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "donequantity")
    private BigInteger donequantity;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "costcenteruse")
    private BigDecimal costcenteruse;
    
    @Column(name = "preptime")
    private BigDecimal preptime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "closed")
    @Convert(converter=YesNoConverter.class) 
    private YesNo closed;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private long seqno;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "noqty")
    @Convert(converter=YesNoConverter.class)
    private YesNo noqty;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupuse")
    @Convert(converter=YesNoConverter.class)
    private YesNo groupuse;
    
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    
    @Column(name = "outsourced")
    @Convert(converter=YesNoConverter.class)
    private YesNo outsourced;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_process_id", referencedColumnName = "ma_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaProcess maProcessId;
    @JoinColumn(name = "ma_sequence_id", referencedColumnName = "ma_sequence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MaSequence maSequenceId;
    @JoinColumn(name = "ma_workrequirement_id", referencedColumnName = "ma_workrequirement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaWorkrequirement maWorkrequirementId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maWrphaseId")
    private List<MProductionplan> mProductionplanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maWrphaseId")
    private List<MaWrphaseproduct> maWrphaseproductList;

    public MaWrphase() {
    }

    public MaWrphase(String maWrphaseId) {
        this.maWrphaseId = maWrphaseId;
    }

    public String getMaWrphaseId() {
        return maWrphaseId;
    }

    public void setMaWrphaseId(String maWrphaseId) {
        this.maWrphaseId = maWrphaseId;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigInteger getDonequantity() {
        return donequantity;
    }

    public void setDonequantity(BigInteger donequantity) {
        this.donequantity = donequantity;
    }

    public BigDecimal getCostcenteruse() {
        return costcenteruse;
    }

    public void setCostcenteruse(BigDecimal costcenteruse) {
        this.costcenteruse = costcenteruse;
    }

    public BigDecimal getPreptime() {
        return preptime;
    }

    public void setPreptime(BigDecimal preptime) {
        this.preptime = preptime;
    }

    public YesNo getClosed() {
        return closed;
    }

    public void setClosed(YesNo closed) {
        this.closed = closed;
    }

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public YesNo getNoqty() {
        return noqty;
    }

    public void setNoqty(YesNo noqty) {
        this.noqty = noqty;
    }

    public YesNo getGroupuse() {
        return groupuse;
    }

    public void setGroupuse(YesNo groupuse) {
        this.groupuse = groupuse;
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

    public YesNo getOutsourced() {
        return outsourced;
    }

    public void setOutsourced(YesNo outsourced) {
        this.outsourced = outsourced;
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

    public MaProcess getMaProcessId() {
        return maProcessId;
    }

    public void setMaProcessId(MaProcess maProcessId) {
        this.maProcessId = maProcessId;
    }

    public MaSequence getMaSequenceId() {
        return maSequenceId;
    }

    public void setMaSequenceId(MaSequence maSequenceId) {
        this.maSequenceId = maSequenceId;
    }

    public MaWorkrequirement getMaWorkrequirementId() {
        return maWorkrequirementId;
    }

    public void setMaWorkrequirementId(MaWorkrequirement maWorkrequirementId) {
        this.maWorkrequirementId = maWorkrequirementId;
    }

    @XmlTransient
    public List<MProductionplan> getMProductionplanList() {
        return mProductionplanList;
    }

    public void setMProductionplanList(List<MProductionplan> mProductionplanList) {
        this.mProductionplanList = mProductionplanList;
    }

    @XmlTransient
    public List<MaWrphaseproduct> getMaWrphaseproductList() {
        return maWrphaseproductList;
    }

    public void setMaWrphaseproductList(List<MaWrphaseproduct> maWrphaseproductList) {
        this.maWrphaseproductList = maWrphaseproductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maWrphaseId != null ? maWrphaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaWrphase)) {
            return false;
        }
        MaWrphase other = (MaWrphase) object;
        if ((this.maWrphaseId == null && other.maWrphaseId != null) || (this.maWrphaseId != null && !this.maWrphaseId.equals(other.maWrphaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaWrphase[ maWrphaseId=" + maWrphaseId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maWrphaseId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maWrphaseId = id;
	}
    
}
