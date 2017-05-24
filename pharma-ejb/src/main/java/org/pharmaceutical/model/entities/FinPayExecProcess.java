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
@Table(name = "fin_pay_exec_process")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPayExecProcess.findAll", query = "SELECT f FROM FinPayExecProcess f"),
    @NamedQuery(name = "FinPayExecProcess.findByFinPayExecProcessId", query = "SELECT f FROM FinPayExecProcess f WHERE f.finPayExecProcessId = :finPayExecProcessId"),
    @NamedQuery(name = "FinPayExecProcess.findByCreated", query = "SELECT f FROM FinPayExecProcess f WHERE f.created = :created"),
    @NamedQuery(name = "FinPayExecProcess.findByCreatedby", query = "SELECT f FROM FinPayExecProcess f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPayExecProcess.findByUpdated", query = "SELECT f FROM FinPayExecProcess f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPayExecProcess.findByUpdatedby", query = "SELECT f FROM FinPayExecProcess f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPayExecProcess.findByIsactive", query = "SELECT f FROM FinPayExecProcess f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPayExecProcess.findByName", query = "SELECT f FROM FinPayExecProcess f WHERE f.name = :name"),
    @NamedQuery(name = "FinPayExecProcess.findByDescription", query = "SELECT f FROM FinPayExecProcess f WHERE f.description = :description"),
    @NamedQuery(name = "FinPayExecProcess.findByClassname", query = "SELECT f FROM FinPayExecProcess f WHERE f.classname = :classname")})
public class FinPayExecProcess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_pay_exec_process_id")
    private String finPayExecProcessId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "classname")
    private String classname;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "payoutExecutionProcessId")
    private List<FinFinaccPaymentmethod> finFinaccPaymentmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "payinExecutionProcessId")
    private List<FinFinaccPaymentmethod> finFinaccPaymentmethodList1;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPayExecProcessId")
    private List<FinPaymentRun> finPaymentRunList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPayExecProcessId")
    private List<FinPayExecProcessPara> finPayExecProcessParaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "payoutExecutionProcessId")
    private List<FinPaymentmethod> finPaymentmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "payinExecutionProcessId")
    private List<FinPaymentmethod> finPaymentmethodList1;

    public FinPayExecProcess() {
    }

    public FinPayExecProcess(String finPayExecProcessId) {
        this.finPayExecProcessId = finPayExecProcessId;
    }

    public FinPayExecProcess(String finPayExecProcessId, Date created, String createdby, Date updated, String updatedby, Character isactive, String name, String classname) {
        this.finPayExecProcessId = finPayExecProcessId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.name = name;
        this.classname = classname;
    }

    public String getFinPayExecProcessId() {
        return finPayExecProcessId;
    }

    public void setFinPayExecProcessId(String finPayExecProcessId) {
        this.finPayExecProcessId = finPayExecProcessId;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @XmlTransient
    public List<FinFinaccPaymentmethod> getFinFinaccPaymentmethodList() {
        return finFinaccPaymentmethodList;
    }

    public void setFinFinaccPaymentmethodList(List<FinFinaccPaymentmethod> finFinaccPaymentmethodList) {
        this.finFinaccPaymentmethodList = finFinaccPaymentmethodList;
    }

    @XmlTransient
    public List<FinFinaccPaymentmethod> getFinFinaccPaymentmethodList1() {
        return finFinaccPaymentmethodList1;
    }

    public void setFinFinaccPaymentmethodList1(List<FinFinaccPaymentmethod> finFinaccPaymentmethodList1) {
        this.finFinaccPaymentmethodList1 = finFinaccPaymentmethodList1;
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
    public List<FinPaymentRun> getFinPaymentRunList() {
        return finPaymentRunList;
    }

    public void setFinPaymentRunList(List<FinPaymentRun> finPaymentRunList) {
        this.finPaymentRunList = finPaymentRunList;
    }

    @XmlTransient
    public List<FinPayExecProcessPara> getFinPayExecProcessParaList() {
        return finPayExecProcessParaList;
    }

    public void setFinPayExecProcessParaList(List<FinPayExecProcessPara> finPayExecProcessParaList) {
        this.finPayExecProcessParaList = finPayExecProcessParaList;
    }

    @XmlTransient
    public List<FinPaymentmethod> getFinPaymentmethodList() {
        return finPaymentmethodList;
    }

    public void setFinPaymentmethodList(List<FinPaymentmethod> finPaymentmethodList) {
        this.finPaymentmethodList = finPaymentmethodList;
    }

    @XmlTransient
    public List<FinPaymentmethod> getFinPaymentmethodList1() {
        return finPaymentmethodList1;
    }

    public void setFinPaymentmethodList1(List<FinPaymentmethod> finPaymentmethodList1) {
        this.finPaymentmethodList1 = finPaymentmethodList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPayExecProcessId != null ? finPayExecProcessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPayExecProcess)) {
            return false;
        }
        FinPayExecProcess other = (FinPayExecProcess) object;
        if ((this.finPayExecProcessId == null && other.finPayExecProcessId != null) || (this.finPayExecProcessId != null && !this.finPayExecProcessId.equals(other.finPayExecProcessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPayExecProcess[ finPayExecProcessId=" + finPayExecProcessId + " ]";
    }
    
}
