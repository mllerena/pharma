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
@Table(name = "ad_val_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdValRule.findAll", query = "SELECT a FROM AdValRule a"),
    @NamedQuery(name = "AdValRule.findByAdValRuleId", query = "SELECT a FROM AdValRule a WHERE a.adValRuleId = :adValRuleId"),
    @NamedQuery(name = "AdValRule.findByIsactive", query = "SELECT a FROM AdValRule a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdValRule.findByCreated", query = "SELECT a FROM AdValRule a WHERE a.created = :created"),
    @NamedQuery(name = "AdValRule.findByCreatedby", query = "SELECT a FROM AdValRule a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdValRule.findByUpdated", query = "SELECT a FROM AdValRule a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdValRule.findByUpdatedby", query = "SELECT a FROM AdValRule a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdValRule.findByName", query = "SELECT a FROM AdValRule a WHERE a.name = :name"),
    @NamedQuery(name = "AdValRule.findByDescription", query = "SELECT a FROM AdValRule a WHERE a.description = :description"),
    @NamedQuery(name = "AdValRule.findByType", query = "SELECT a FROM AdValRule a WHERE a.type = :type"),
    @NamedQuery(name = "AdValRule.findByCode", query = "SELECT a FROM AdValRule a WHERE a.code = :code")})
public class AdValRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_val_rule_id")
    private String adValRuleId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 60)
    @Column(name = "type")
    private String type;
    @Size(max = 2000)
    @Column(name = "code")
    private String code;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adValRuleId")
    private List<AdColumn> adColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adValRuleId")
    private List<AdProcessPara> adProcessParaList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adValRuleId")
    private List<FinPayExecProcessPara> finPayExecProcessParaList;

    public AdValRule() {
    }

    public AdValRule(String adValRuleId) {
        this.adValRuleId = adValRuleId;
    }

    public AdValRule(String adValRuleId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.adValRuleId = adValRuleId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getAdValRuleId() {
        return adValRuleId;
    }

    public void setAdValRuleId(String adValRuleId) {
        this.adValRuleId = adValRuleId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public List<AdColumn> getAdColumnList() {
        return adColumnList;
    }

    public void setAdColumnList(List<AdColumn> adColumnList) {
        this.adColumnList = adColumnList;
    }

    @XmlTransient
    public List<AdProcessPara> getAdProcessParaList() {
        return adProcessParaList;
    }

    public void setAdProcessParaList(List<AdProcessPara> adProcessParaList) {
        this.adProcessParaList = adProcessParaList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    @XmlTransient
    public List<FinPayExecProcessPara> getFinPayExecProcessParaList() {
        return finPayExecProcessParaList;
    }

    public void setFinPayExecProcessParaList(List<FinPayExecProcessPara> finPayExecProcessParaList) {
        this.finPayExecProcessParaList = finPayExecProcessParaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adValRuleId != null ? adValRuleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdValRule)) {
            return false;
        }
        AdValRule other = (AdValRule) object;
        if ((this.adValRuleId == null && other.adValRuleId != null) || (this.adValRuleId != null && !this.adValRuleId.equals(other.adValRuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdValRule[ adValRuleId=" + adValRuleId + " ]";
    }
    
}
