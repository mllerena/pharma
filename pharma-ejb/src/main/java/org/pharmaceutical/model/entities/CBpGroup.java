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
@Table(name = "c_bp_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpGroup.findAll", query = "SELECT c FROM CBpGroup c"),
    @NamedQuery(name = "CBpGroup.findByCBpGroupId", query = "SELECT c FROM CBpGroup c WHERE c.cBpGroupId = :cBpGroupId"),
    @NamedQuery(name = "CBpGroup.findByIsactive", query = "SELECT c FROM CBpGroup c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpGroup.findByCreated", query = "SELECT c FROM CBpGroup c WHERE c.created = :created"),
    @NamedQuery(name = "CBpGroup.findByCreatedby", query = "SELECT c FROM CBpGroup c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpGroup.findByUpdated", query = "SELECT c FROM CBpGroup c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpGroup.findByUpdatedby", query = "SELECT c FROM CBpGroup c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpGroup.findByValue", query = "SELECT c FROM CBpGroup c WHERE c.value = :value"),
    @NamedQuery(name = "CBpGroup.findByName", query = "SELECT c FROM CBpGroup c WHERE c.name = :name"),
    @NamedQuery(name = "CBpGroup.findByDescription", query = "SELECT c FROM CBpGroup c WHERE c.description = :description"),
    @NamedQuery(name = "CBpGroup.findByIsdefault", query = "SELECT c FROM CBpGroup c WHERE c.isdefault = :isdefault")})
public class CBpGroup extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bp_group_id")
    private String cBpGroupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class)
    private YesNo isactive;
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
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpGroupId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpGroupId")
    private List<MrpRunPurchase> mrpRunPurchaseList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpGroupId")
    private List<IBpartner> iBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpGroupId")
    private List<CBpGroupAcct> cBpGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpGroupId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpGroupId")
    private List<MrpRunProduction> mrpRunProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpGroupId")
    private List<CCommissionline> cCommissionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBpGroupId")
    private List<MOfferBpGroup> mOfferBpGroupList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpGroupId")
    private List<CBudgetline> cBudgetlineList;

    public CBpGroup() {
    }

    public CBpGroup(String cBpGroupId) {
        this.cBpGroupId = cBpGroupId;
    }

    public String getCBpGroupId() {
        return cBpGroupId;
    }

    public void setCBpGroupId(String cBpGroupId) {
        this.cBpGroupId = cBpGroupId;
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

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<MrpRunPurchase> getMrpRunPurchaseList() {
        return mrpRunPurchaseList;
    }

    public void setMrpRunPurchaseList(List<MrpRunPurchase> mrpRunPurchaseList) {
        this.mrpRunPurchaseList = mrpRunPurchaseList;
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
    public List<IBpartner> getIBpartnerList() {
        return iBpartnerList;
    }

    public void setIBpartnerList(List<IBpartner> iBpartnerList) {
        this.iBpartnerList = iBpartnerList;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList() {
        return cBpGroupAcctList;
    }

    public void setCBpGroupAcctList(List<CBpGroupAcct> cBpGroupAcctList) {
        this.cBpGroupAcctList = cBpGroupAcctList;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList() {
        return iBudgetlineList;
    }

    public void setIBudgetlineList(List<IBudgetline> iBudgetlineList) {
        this.iBudgetlineList = iBudgetlineList;
    }

    @XmlTransient
    public List<MrpRunProduction> getMrpRunProductionList() {
        return mrpRunProductionList;
    }

    public void setMrpRunProductionList(List<MrpRunProduction> mrpRunProductionList) {
        this.mrpRunProductionList = mrpRunProductionList;
    }

    @XmlTransient
    public List<CCommissionline> getCCommissionlineList() {
        return cCommissionlineList;
    }

    public void setCCommissionlineList(List<CCommissionline> cCommissionlineList) {
        this.cCommissionlineList = cCommissionlineList;
    }

    @XmlTransient
    public List<MOfferBpGroup> getMOfferBpGroupList() {
        return mOfferBpGroupList;
    }

    public void setMOfferBpGroupList(List<MOfferBpGroup> mOfferBpGroupList) {
        this.mOfferBpGroupList = mOfferBpGroupList;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpGroupId != null ? cBpGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpGroup)) {
            return false;
        }
        CBpGroup other = (CBpGroup) object;
        if ((this.cBpGroupId == null && other.cBpGroupId != null) || (this.cBpGroupId != null && !this.cBpGroupId.equals(other.cBpGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpGroup[ cBpGroupId=" + cBpGroupId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return cBpGroupId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		cBpGroupId = id;
	}
    
}
