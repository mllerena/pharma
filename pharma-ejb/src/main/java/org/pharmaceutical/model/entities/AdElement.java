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
import javax.persistence.FetchType;
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
@Table(name = "ad_element")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdElement.findAll", query = "SELECT a FROM AdElement a"),
    @NamedQuery(name = "AdElement.findByAdElementId", query = "SELECT a FROM AdElement a WHERE a.adElementId = :adElementId"),
    @NamedQuery(name = "AdElement.findByIsactive", query = "SELECT a FROM AdElement a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdElement.findByCreated", query = "SELECT a FROM AdElement a WHERE a.created = :created"),
    @NamedQuery(name = "AdElement.findByCreatedby", query = "SELECT a FROM AdElement a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdElement.findByUpdated", query = "SELECT a FROM AdElement a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdElement.findByUpdatedby", query = "SELECT a FROM AdElement a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdElement.findByColumnname", query = "SELECT a FROM AdElement a WHERE a.columnname = :columnname"),
    @NamedQuery(name = "AdElement.findByName", query = "SELECT a FROM AdElement a WHERE a.name = :name"),
    @NamedQuery(name = "AdElement.findByPrintname", query = "SELECT a FROM AdElement a WHERE a.printname = :printname"),
    @NamedQuery(name = "AdElement.findByDescription", query = "SELECT a FROM AdElement a WHERE a.description = :description"),
    @NamedQuery(name = "AdElement.findByHelp", query = "SELECT a FROM AdElement a WHERE a.help = :help"),
    @NamedQuery(name = "AdElement.findByPoName", query = "SELECT a FROM AdElement a WHERE a.poName = :poName"),
    @NamedQuery(name = "AdElement.findByPoPrintname", query = "SELECT a FROM AdElement a WHERE a.poPrintname = :poPrintname"),
    @NamedQuery(name = "AdElement.findByPoDescription", query = "SELECT a FROM AdElement a WHERE a.poDescription = :poDescription"),
    @NamedQuery(name = "AdElement.findByPoHelp", query = "SELECT a FROM AdElement a WHERE a.poHelp = :poHelp")})
public class AdElement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_element_id")
    private String adElementId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "columnname")
    private String columnname;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "printname")
    private String printname;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Size(max = 60)
    @Column(name = "po_name")
    private String poName;
    @Size(max = 60)
    @Column(name = "po_printname")
    private String poPrintname;
    @Size(max = 255)
    @Column(name = "po_description")
    private String poDescription;
    @Size(max = 2000)
    @Column(name = "po_help")
    private String poHelp;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adElementId")
    private List<AdColumn> adColumnList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adElementId")
    private List<AdElementTrl> adElementTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adElementId")
    private List<AdProcessPara> adProcessParaList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;

    public AdElement() {
    }

    public AdElement(String adElementId) {
        this.adElementId = adElementId;
    }

    public AdElement(String adElementId, Character isactive, Date created, Date updated, String columnname, String printname) {
        this.adElementId = adElementId;
        this.isactive = isactive;
        this.created = created;
        this.updated = updated;
        this.columnname = columnname;
        this.printname = printname;
    }

    public String getAdElementId() {
        return adElementId;
    }

    public void setAdElementId(String adElementId) {
        this.adElementId = adElementId;
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

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrintname() {
        return printname;
    }

    public void setPrintname(String printname) {
        this.printname = printname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }

    public String getPoPrintname() {
        return poPrintname;
    }

    public void setPoPrintname(String poPrintname) {
        this.poPrintname = poPrintname;
    }

    public String getPoDescription() {
        return poDescription;
    }

    public void setPoDescription(String poDescription) {
        this.poDescription = poDescription;
    }

    public String getPoHelp() {
        return poHelp;
    }

    public void setPoHelp(String poHelp) {
        this.poHelp = poHelp;
    }

    @XmlTransient
    public List<AdColumn> getAdColumnList() {
        return adColumnList;
    }

    public void setAdColumnList(List<AdColumn> adColumnList) {
        this.adColumnList = adColumnList;
    }

    @XmlTransient
    public List<AdElementTrl> getAdElementTrlList() {
        return adElementTrlList;
    }

    public void setAdElementTrlList(List<AdElementTrl> adElementTrlList) {
        this.adElementTrlList = adElementTrlList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adElementId != null ? adElementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdElement)) {
            return false;
        }
        AdElement other = (AdElement) object;
        if ((this.adElementId == null && other.adElementId != null) || (this.adElementId != null && !this.adElementId.equals(other.adElementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdElement[ adElementId=" + adElementId + " ]";
    }
    
}
