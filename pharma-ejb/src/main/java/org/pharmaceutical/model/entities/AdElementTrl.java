/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
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

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ad_element_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdElementTrl.findAll", query = "SELECT a FROM AdElementTrl a"),
    @NamedQuery(name = "AdElementTrl.findByAdElementTrlId", query = "SELECT a FROM AdElementTrl a WHERE a.adElementTrlId = :adElementTrlId"),
    @NamedQuery(name = "AdElementTrl.findByIsactive", query = "SELECT a FROM AdElementTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdElementTrl.findByCreated", query = "SELECT a FROM AdElementTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdElementTrl.findByCreatedby", query = "SELECT a FROM AdElementTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdElementTrl.findByUpdated", query = "SELECT a FROM AdElementTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdElementTrl.findByUpdatedby", query = "SELECT a FROM AdElementTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdElementTrl.findByName", query = "SELECT a FROM AdElementTrl a WHERE a.name = :name"),
    @NamedQuery(name = "AdElementTrl.findByPrintname", query = "SELECT a FROM AdElementTrl a WHERE a.printname = :printname"),
    @NamedQuery(name = "AdElementTrl.findByDescription", query = "SELECT a FROM AdElementTrl a WHERE a.description = :description"),
    @NamedQuery(name = "AdElementTrl.findByHelp", query = "SELECT a FROM AdElementTrl a WHERE a.help = :help"),
    @NamedQuery(name = "AdElementTrl.findByPoName", query = "SELECT a FROM AdElementTrl a WHERE a.poName = :poName"),
    @NamedQuery(name = "AdElementTrl.findByPoPrintname", query = "SELECT a FROM AdElementTrl a WHERE a.poPrintname = :poPrintname"),
    @NamedQuery(name = "AdElementTrl.findByPoDescription", query = "SELECT a FROM AdElementTrl a WHERE a.poDescription = :poDescription"),
    @NamedQuery(name = "AdElementTrl.findByPoHelp", query = "SELECT a FROM AdElementTrl a WHERE a.poHelp = :poHelp"),
    @NamedQuery(name = "AdElementTrl.findByIstranslated", query = "SELECT a FROM AdElementTrl a WHERE a.istranslated = :istranslated")})
public class AdElementTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_element_trl_id")
    private String adElementTrlId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslated")
    private Character istranslated;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_element_id", referencedColumnName = "ad_element_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdElement adElementId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdElementTrl() {
    }

    public AdElementTrl(String adElementTrlId) {
        this.adElementTrlId = adElementTrlId;
    }

    public AdElementTrl(String adElementTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String printname, Character istranslated) {
        this.adElementTrlId = adElementTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.printname = printname;
        this.istranslated = istranslated;
    }

    public String getAdElementTrlId() {
        return adElementTrlId;
    }

    public void setAdElementTrlId(String adElementTrlId) {
        this.adElementTrlId = adElementTrlId;
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

    public Character getIstranslated() {
        return istranslated;
    }

    public void setIstranslated(Character istranslated) {
        this.istranslated = istranslated;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdElement getAdElementId() {
        return adElementId;
    }

    public void setAdElementId(AdElement adElementId) {
        this.adElementId = adElementId;
    }

    public AdLanguage getAdLanguage() {
        return adLanguage;
    }

    public void setAdLanguage(AdLanguage adLanguage) {
        this.adLanguage = adLanguage;
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
        hash += (adElementTrlId != null ? adElementTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdElementTrl)) {
            return false;
        }
        AdElementTrl other = (AdElementTrl) object;
        if ((this.adElementTrlId == null && other.adElementTrlId != null) || (this.adElementTrlId != null && !this.adElementTrlId.equals(other.adElementTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdElementTrl[ adElementTrlId=" + adElementTrlId + " ]";
    }
    
}
