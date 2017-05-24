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
@Table(name = "ma_sequence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaSequence.findAll", query = "SELECT m FROM MaSequence m"),
    @NamedQuery(name = "MaSequence.findByMaSequenceId", query = "SELECT m FROM MaSequence m WHERE m.maSequenceId = :maSequenceId"),
    @NamedQuery(name = "MaSequence.findByIsactive", query = "SELECT m FROM MaSequence m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaSequence.findByCreated", query = "SELECT m FROM MaSequence m WHERE m.created = :created"),
    @NamedQuery(name = "MaSequence.findByCreatedby", query = "SELECT m FROM MaSequence m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaSequence.findByUpdated", query = "SELECT m FROM MaSequence m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaSequence.findByUpdatedby", query = "SELECT m FROM MaSequence m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaSequence.findByValue", query = "SELECT m FROM MaSequence m WHERE m.value = :value"),
    @NamedQuery(name = "MaSequence.findByName", query = "SELECT m FROM MaSequence m WHERE m.name = :name"),
    @NamedQuery(name = "MaSequence.findByDescription", query = "SELECT m FROM MaSequence m WHERE m.description = :description"),
    @NamedQuery(name = "MaSequence.findByCostcenteruse", query = "SELECT m FROM MaSequence m WHERE m.costcenteruse = :costcenteruse"),
    @NamedQuery(name = "MaSequence.findByPreptime", query = "SELECT m FROM MaSequence m WHERE m.preptime = :preptime"),
    @NamedQuery(name = "MaSequence.findByMultiplier", query = "SELECT m FROM MaSequence m WHERE m.multiplier = :multiplier"),
    @NamedQuery(name = "MaSequence.findBySeqno", query = "SELECT m FROM MaSequence m WHERE m.seqno = :seqno"),
    @NamedQuery(name = "MaSequence.findByNoqty", query = "SELECT m FROM MaSequence m WHERE m.noqty = :noqty"),
    @NamedQuery(name = "MaSequence.findByGroupuse", query = "SELECT m FROM MaSequence m WHERE m.groupuse = :groupuse"),
    @NamedQuery(name = "MaSequence.findByCalculated", query = "SELECT m FROM MaSequence m WHERE m.calculated = :calculated"),
    @NamedQuery(name = "MaSequence.findByCostcentercost", query = "SELECT m FROM MaSequence m WHERE m.costcentercost = :costcentercost"),
    @NamedQuery(name = "MaSequence.findByOutsourced", query = "SELECT m FROM MaSequence m WHERE m.outsourced = :outsourced"),
    @NamedQuery(name = "MaSequence.findByOutsourcingcost", query = "SELECT m FROM MaSequence m WHERE m.outsourcingcost = :outsourcingcost"),
    @NamedQuery(name = "MaSequence.findByIsdefault", query = "SELECT m FROM MaSequence m WHERE m.isdefault = :isdefault"),
    @NamedQuery(name = "MaSequence.findByMaProcessplanVersionId", query = "SELECT m FROM MaSequence m WHERE m.maProcessplanVersionId = :maProcessplanVersionId and m.isactive = :isactive order by m.seqno")
    
})
public class MaSequence extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_sequence_id")
    private String maSequenceId;

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
    @Column(name = "value")
    private String value;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @Column(name = "costcenteruse")
    private BigDecimal costcenteruse;
    
    @Basic(optional = false)
    @Column(name = "preptime")
    private BigDecimal preptime;
    
    @Basic(optional = false)
    @Column(name = "multiplier")
    private BigDecimal multiplier;
    
    @Basic(optional = false)
    @Column(name = "seqno")
    private long seqno;
    
    @Basic(optional = false)
    @Column(name = "noqty")
    private YesNo noqty;
    
    @Basic(optional = false)
    @Column(name = "groupuse")
    private YesNo groupuse;
    
    @Basic(optional = false)
    @Column(name = "calculated")
    private YesNo calculated;
    
    @Column(name = "costcentercost")
    private BigDecimal costcentercost;
    
    @Basic(optional = false)
    @Column(name = "outsourced")
    private YesNo outsourced;
    
    @Column(name = "outsourcingcost")
    private BigDecimal outsourcingcost;
    
    @Basic(optional = false)
    @Column(name = "isdefault")
    private YesNo isdefault;
    
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maSequenceId")
    private List<MaSequenceMachine> maSequenceMachineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_process_id", referencedColumnName = "ma_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaProcess maProcessId;
    @JoinColumn(name = "ma_processplan_version_id", referencedColumnName = "ma_processplan_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaProcessplanVersion maProcessplanVersionId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maSequenceId")
    private List<MaSequenceIc> maSequenceIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maSequenceId")
    private List<MaSequenceproduct> maSequenceproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maSequenceId")
    private List<MaWrphase> maWrphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maSequenceId")
    private List<MaSequenceEmployee> maSequenceEmployeeList;

    public MaSequence() {
    }

    public MaSequence(String maSequenceId) {
        this.maSequenceId = maSequenceId;
    }

    public String getMaSequenceId() {
        return maSequenceId;
    }

    public void setMaSequenceId(String maSequenceId) {
        this.maSequenceId = maSequenceId;
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

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
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

	public BigDecimal getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(BigDecimal multiplier) {
		this.multiplier = multiplier;
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

	public YesNo getCalculated() {
		return calculated;
	}

	public void setCalculated(YesNo calculated) {
		this.calculated = calculated;
	}

	public BigDecimal getCostcentercost() {
		return costcentercost;
	}

	public void setCostcentercost(BigDecimal costcentercost) {
		this.costcentercost = costcentercost;
	}

	public YesNo getOutsourced() {
		return outsourced;
	}

	public void setOutsourced(YesNo outsourced) {
		this.outsourced = outsourced;
	}

	public BigDecimal getOutsourcingcost() {
		return outsourcingcost;
	}

	public void setOutsourcingcost(BigDecimal outsourcingcost) {
		this.outsourcingcost = outsourcingcost;
	}

	public YesNo getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(YesNo isdefault) {
		this.isdefault = isdefault;
	}

	@XmlTransient
    public List<MaSequenceMachine> getMaSequenceMachineList() {
        return maSequenceMachineList;
    }

    public void setMaSequenceMachineList(List<MaSequenceMachine> maSequenceMachineList) {
        this.maSequenceMachineList = maSequenceMachineList;
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

    public MaProcessplanVersion getMaProcessplanVersionId() {
        return maProcessplanVersionId;
    }

    public void setMaProcessplanVersionId(MaProcessplanVersion maProcessplanVersionId) {
        this.maProcessplanVersionId = maProcessplanVersionId;
    }

    @XmlTransient
    public List<MaSequenceIc> getMaSequenceIcList() {
        return maSequenceIcList;
    }

    public void setMaSequenceIcList(List<MaSequenceIc> maSequenceIcList) {
        this.maSequenceIcList = maSequenceIcList;
    }

    @XmlTransient
    public List<MaSequenceproduct> getMaSequenceproductList() {
        return maSequenceproductList;
    }

    public void setMaSequenceproductList(List<MaSequenceproduct> maSequenceproductList) {
        this.maSequenceproductList = maSequenceproductList;
    }

    @XmlTransient
    public List<MaWrphase> getMaWrphaseList() {
        return maWrphaseList;
    }

    public void setMaWrphaseList(List<MaWrphase> maWrphaseList) {
        this.maWrphaseList = maWrphaseList;
    }

    @XmlTransient
    public List<MaSequenceEmployee> getMaSequenceEmployeeList() {
        return maSequenceEmployeeList;
    }

    public void setMaSequenceEmployeeList(List<MaSequenceEmployee> maSequenceEmployeeList) {
        this.maSequenceEmployeeList = maSequenceEmployeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSequenceId != null ? maSequenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaSequence)) {
            return false;
        }
        MaSequence other = (MaSequence) object;
        if ((this.maSequenceId == null && other.maSequenceId != null) || (this.maSequenceId != null && !this.maSequenceId.equals(other.maSequenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaSequence[ maSequenceId=" + maSequenceId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maSequenceId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maSequenceId = id;
	}
    
}
