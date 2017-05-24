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
import javax.persistence.ConstructorResult;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
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
@Table(name = "ma_workrequirement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaWorkrequirement.findAll", query = "SELECT m FROM MaWorkrequirement m"),
    @NamedQuery(name = "MaWorkrequirement.findByMaWorkrequirementId", query = "SELECT m FROM MaWorkrequirement m WHERE m.maWorkrequirementId = :maWorkrequirementId"),
    @NamedQuery(name = "MaWorkrequirement.findByIsactive", query = "SELECT m FROM MaWorkrequirement m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaWorkrequirement.findByCreated", query = "SELECT m FROM MaWorkrequirement m WHERE m.created = :created"),
    @NamedQuery(name = "MaWorkrequirement.findByCreatedby", query = "SELECT m FROM MaWorkrequirement m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaWorkrequirement.findByUpdated", query = "SELECT m FROM MaWorkrequirement m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaWorkrequirement.findByUpdatedby", query = "SELECT m FROM MaWorkrequirement m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaWorkrequirement.findByName", query = "SELECT m FROM MaWorkrequirement m WHERE m.name = :name and m.isactive = :isactive"), 
    @NamedQuery(name = "MaWorkrequirement.findByQuantity", query = "SELECT m FROM MaWorkrequirement m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MaWorkrequirement.findByLaunchdate", query = "SELECT m FROM MaWorkrequirement m WHERE m.launchdate = :launchdate"),
    @NamedQuery(name = "MaWorkrequirement.findByStartdate", query = "SELECT m FROM MaWorkrequirement m WHERE m.startdate = :startdate"),
    @NamedQuery(name = "MaWorkrequirement.findByEnddate", query = "SELECT m FROM MaWorkrequirement m WHERE m.enddate = :enddate"),
    @NamedQuery(name = "MaWorkrequirement.findByClosed", query = "SELECT m FROM MaWorkrequirement m WHERE m.closed = :closed"),
    @NamedQuery(name = "MaWorkrequirement.findByExplote", query = "SELECT m FROM MaWorkrequirement m WHERE m.explote = :explote"),
    @NamedQuery(name = "MaWorkrequirement.findByProcessed", query = "SELECT m FROM MaWorkrequirement m WHERE m.processed = :processed"),
    @NamedQuery(name = "MaWorkrequirement.findByDocumentno", query = "SELECT m FROM MaWorkrequirement m WHERE m.documentno = :documentno"),
    @NamedQuery(name = "MaWorkrequirement.findByExplodephases", query = "SELECT m FROM MaWorkrequirement m WHERE m.explodephases = :explodephases"),
    @NamedQuery(name = "MaWorkrequirement.findBySecondaryqty", query = "SELECT m FROM MaWorkrequirement m WHERE m.secondaryqty = :secondaryqty"),
    @NamedQuery(name = "MaWorkrequirement.findBySecondaryunit", query = "SELECT m FROM MaWorkrequirement m WHERE m.secondaryunit = :secondaryunit"),
    @NamedQuery(name = "MaWorkrequirement.findByConversionrate", query = "SELECT m FROM MaWorkrequirement m WHERE m.conversionrate = :conversionrate"),
    @NamedQuery(name = "MaWorkrequirement.findByTaskId", query = "SELECT m FROM MaWorkrequirement m WHERE m.taskId = :taskId and m.isactive = :isactive")
    
})

@SqlResultSetMapping(
	    name = "VOID_MAPPING",
	    classes = {
	        @ConstructorResult(targetClass = VoidClass.class, columns = {}) 
	    }
	)
public class MaWorkrequirement extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_workrequirement_id")
    private String maWorkrequirementId;
    
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
    
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull 
    @Column(name = "quantity")
    private BigInteger quantity;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "launchdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date launchdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "closed")
    @Convert(converter=YesNoConverter.class) 
    private YesNo closed;
    
    @Column(name = "explote")
    @Convert(converter=YesNoConverter.class) 
    private YesNo explote;
    
    @Column(name = "processed")
    @Convert(converter=YesNoConverter.class) 
    private YesNo processed;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "explodephases")
    @Convert(converter=YesNoConverter.class) 
    private YesNo explodephases;
    
    @Column(name = "secondaryqty")
    private Long secondaryqty;
    
    @Size(max = 40)
    @Column(name = "secondaryunit")
    private String secondaryunit;
    
    @Column(name = "conversionrate")    
    private BigInteger conversionrate;
    
    @Column(name = "lot")
    private String lot;
    
    @Column(name = "task_id")
    private Long taskId;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_processplan_id", referencedColumnName = "ma_processplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaProcessplan maProcessplanId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maWorkrequirementId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maWorkrequirementId")
    private List<MaWrphase> maWrphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maWorkrequirementId")
    private List<MrpRunProductionline> mrpRunProductionlineList;

    public MaWorkrequirement() {
    }

    public MaWorkrequirement(String maWorkrequirementId) {
        this.maWorkrequirementId = maWorkrequirementId;
    }

    public String getMaWorkrequirementId() {
        return maWorkrequirementId;
    }

    public void setMaWorkrequirementId(String maWorkrequirementId) {
        this.maWorkrequirementId = maWorkrequirementId;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public Date getLaunchdate() {
        return launchdate;
    }

    public void setLaunchdate(Date launchdate) {
        this.launchdate = launchdate;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public YesNo getClosed() {
        return closed;
    }

    public void setClosed(YesNo closed) {
        this.closed = closed;
    }

    public YesNo getExplote() {
        return explote;
    }

    public void setExplote(YesNo explote) {
        this.explote = explote;
    }

    public YesNo getProcessed() {
        return processed;
    }

    public void setProcessed(YesNo processed) {
        this.processed = processed;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public YesNo getExplodephases() {
        return explodephases;
    }

    public void setExplodephases(YesNo explodephases) {
        this.explodephases = explodephases;
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

    public BigInteger getConversionrate() {
        return conversionrate;
    }

    public void setConversionrate(BigInteger conversionrate) {
        this.conversionrate = conversionrate;
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

    public MaProcessplan getMaProcessplanId() {
        return maProcessplanId;
    }

    public void setMaProcessplanId(MaProcessplan maProcessplanId) {
        this.maProcessplanId = maProcessplanId;
    }

    @XmlTransient
    public List<MrpRunPurchaseline> getMrpRunPurchaselineList() {
        return mrpRunPurchaselineList;
    }

    public void setMrpRunPurchaselineList(List<MrpRunPurchaseline> mrpRunPurchaselineList) {
        this.mrpRunPurchaselineList = mrpRunPurchaselineList;
    }

    @XmlTransient
    public List<MaWrphase> getMaWrphaseList() {
        return maWrphaseList;
    }

    public void setMaWrphaseList(List<MaWrphase> maWrphaseList) {
        this.maWrphaseList = maWrphaseList;
    }

    @XmlTransient
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maWorkrequirementId != null ? maWorkrequirementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaWorkrequirement)) {
            return false;
        }
        MaWorkrequirement other = (MaWorkrequirement) object;
        if ((this.maWorkrequirementId == null && other.maWorkrequirementId != null) || (this.maWorkrequirementId != null && !this.maWorkrequirementId.equals(other.maWorkrequirementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaWorkrequirement[ maWorkrequirementId=" + maWorkrequirementId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maWorkrequirementId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maWorkrequirementId = id;
	}
	
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getLot() { 
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}
	
	
	
    
}
