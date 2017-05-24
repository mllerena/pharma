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
@Table(name = "c_doctype_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CDoctypeTrl.findAll", query = "SELECT c FROM CDoctypeTrl c"),
    @NamedQuery(name = "CDoctypeTrl.findByCDoctypeTrlId", query = "SELECT c FROM CDoctypeTrl c WHERE c.cDoctypeTrlId = :cDoctypeTrlId"),
    @NamedQuery(name = "CDoctypeTrl.findByIsactive", query = "SELECT c FROM CDoctypeTrl c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CDoctypeTrl.findByCreated", query = "SELECT c FROM CDoctypeTrl c WHERE c.created = :created"),
    @NamedQuery(name = "CDoctypeTrl.findByCreatedby", query = "SELECT c FROM CDoctypeTrl c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CDoctypeTrl.findByUpdated", query = "SELECT c FROM CDoctypeTrl c WHERE c.updated = :updated"),
    @NamedQuery(name = "CDoctypeTrl.findByUpdatedby", query = "SELECT c FROM CDoctypeTrl c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CDoctypeTrl.findByName", query = "SELECT c FROM CDoctypeTrl c WHERE c.name = :name"),
    @NamedQuery(name = "CDoctypeTrl.findByPrintname", query = "SELECT c FROM CDoctypeTrl c WHERE c.printname = :printname"),
    @NamedQuery(name = "CDoctypeTrl.findByDocumentnote", query = "SELECT c FROM CDoctypeTrl c WHERE c.documentnote = :documentnote"),
    @NamedQuery(name = "CDoctypeTrl.findByIstranslated", query = "SELECT c FROM CDoctypeTrl c WHERE c.istranslated = :istranslated")})
public class CDoctypeTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_doctype_trl_id")
    private String cDoctypeTrlId;
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
    @Size(max = 2000)
    @Column(name = "documentnote")
    private String documentnote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslated")
    private Character istranslated;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;

    public CDoctypeTrl() {
    }

    public CDoctypeTrl(String cDoctypeTrlId) {
        this.cDoctypeTrlId = cDoctypeTrlId;
    }

    public CDoctypeTrl(String cDoctypeTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String printname, Character istranslated) {
        this.cDoctypeTrlId = cDoctypeTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.printname = printname;
        this.istranslated = istranslated;
    }

    public String getCDoctypeTrlId() {
        return cDoctypeTrlId;
    }

    public void setCDoctypeTrlId(String cDoctypeTrlId) {
        this.cDoctypeTrlId = cDoctypeTrlId;
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

    public String getDocumentnote() {
        return documentnote;
    }

    public void setDocumentnote(String documentnote) {
        this.documentnote = documentnote;
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

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDoctypeTrlId != null ? cDoctypeTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDoctypeTrl)) {
            return false;
        }
        CDoctypeTrl other = (CDoctypeTrl) object;
        if ((this.cDoctypeTrlId == null && other.cDoctypeTrlId != null) || (this.cDoctypeTrlId != null && !this.cDoctypeTrlId.equals(other.cDoctypeTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CDoctypeTrl[ cDoctypeTrlId=" + cDoctypeTrlId + " ]";
    }
    
}
