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
@Table(name = "fin_payment_priority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentPriority.findAll", query = "SELECT f FROM FinPaymentPriority f"),
    @NamedQuery(name = "FinPaymentPriority.findByFinPaymentPriorityId", query = "SELECT f FROM FinPaymentPriority f WHERE f.finPaymentPriorityId = :finPaymentPriorityId"),
    @NamedQuery(name = "FinPaymentPriority.findByCreated", query = "SELECT f FROM FinPaymentPriority f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentPriority.findByCreatedby", query = "SELECT f FROM FinPaymentPriority f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentPriority.findByUpdated", query = "SELECT f FROM FinPaymentPriority f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentPriority.findByUpdatedby", query = "SELECT f FROM FinPaymentPriority f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentPriority.findByIsactive", query = "SELECT f FROM FinPaymentPriority f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentPriority.findByPriority", query = "SELECT f FROM FinPaymentPriority f WHERE f.priority = :priority"),
    @NamedQuery(name = "FinPaymentPriority.findByName", query = "SELECT f FROM FinPaymentPriority f WHERE f.name = :name"),
    @NamedQuery(name = "FinPaymentPriority.findByDescription", query = "SELECT f FROM FinPaymentPriority f WHERE f.description = :description"),
    @NamedQuery(name = "FinPaymentPriority.findByIsdefault", query = "SELECT f FROM FinPaymentPriority f WHERE f.isdefault = :isdefault"),
    @NamedQuery(name = "FinPaymentPriority.findByColor", query = "SELECT f FROM FinPaymentPriority f WHERE f.color = :color")})
public class FinPaymentPriority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_priority_id")
    private String finPaymentPriorityId;
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
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priority")
    private long priority;
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
    @Size(max = 60)
    @Column(name = "color")
    private String color;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentPriorityId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentPriorityId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentPriorityId")
    private List<FinPaymentSchedule> finPaymentScheduleList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public FinPaymentPriority() {
    }

    public FinPaymentPriority(String finPaymentPriorityId) {
        this.finPaymentPriorityId = finPaymentPriorityId;
    }

    public FinPaymentPriority(String finPaymentPriorityId, Date created, String createdby, Date updated, String updatedby, Character isactive, long priority, String name, Character isdefault) {
        this.finPaymentPriorityId = finPaymentPriorityId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.priority = priority;
        this.name = name;
        this.isdefault = isdefault;
    }

    public String getFinPaymentPriorityId() {
        return finPaymentPriorityId;
    }

    public void setFinPaymentPriorityId(String finPaymentPriorityId) {
        this.finPaymentPriorityId = finPaymentPriorityId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<FinPaymentSchedule> getFinPaymentScheduleList() {
        return finPaymentScheduleList;
    }

    public void setFinPaymentScheduleList(List<FinPaymentSchedule> finPaymentScheduleList) {
        this.finPaymentScheduleList = finPaymentScheduleList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentPriorityId != null ? finPaymentPriorityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentPriority)) {
            return false;
        }
        FinPaymentPriority other = (FinPaymentPriority) object;
        if ((this.finPaymentPriorityId == null && other.finPaymentPriorityId != null) || (this.finPaymentPriorityId != null && !this.finPaymentPriorityId.equals(other.finPaymentPriorityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentPriority[ finPaymentPriorityId=" + finPaymentPriorityId + " ]";
    }
    
}
