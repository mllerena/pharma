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
@Table(name = "at_testdocument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtTestdocument.findAll", query = "SELECT a FROM AtTestdocument a"),
    @NamedQuery(name = "AtTestdocument.findByAtTestdocumentId", query = "SELECT a FROM AtTestdocument a WHERE a.atTestdocumentId = :atTestdocumentId"),
    @NamedQuery(name = "AtTestdocument.findByIsactive", query = "SELECT a FROM AtTestdocument a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AtTestdocument.findByCreated", query = "SELECT a FROM AtTestdocument a WHERE a.created = :created"),
    @NamedQuery(name = "AtTestdocument.findByCreatedby", query = "SELECT a FROM AtTestdocument a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AtTestdocument.findByUpdated", query = "SELECT a FROM AtTestdocument a WHERE a.updated = :updated"),
    @NamedQuery(name = "AtTestdocument.findByUpdatedby", query = "SELECT a FROM AtTestdocument a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AtTestdocument.findByName", query = "SELECT a FROM AtTestdocument a WHERE a.name = :name"),
    @NamedQuery(name = "AtTestdocument.findByDescription", query = "SELECT a FROM AtTestdocument a WHERE a.description = :description"),
    @NamedQuery(name = "AtTestdocument.findByExtension", query = "SELECT a FROM AtTestdocument a WHERE a.extension = :extension"),
    @NamedQuery(name = "AtTestdocument.findByHeader1", query = "SELECT a FROM AtTestdocument a WHERE a.header1 = :header1"),
    @NamedQuery(name = "AtTestdocument.findBySuffix", query = "SELECT a FROM AtTestdocument a WHERE a.suffix = :suffix"),
    @NamedQuery(name = "AtTestdocument.findByFooter", query = "SELECT a FROM AtTestdocument a WHERE a.footer = :footer"),
    @NamedQuery(name = "AtTestdocument.findByContenttype", query = "SELECT a FROM AtTestdocument a WHERE a.contenttype = :contenttype"),
    @NamedQuery(name = "AtTestdocument.findByHeader2", query = "SELECT a FROM AtTestdocument a WHERE a.header2 = :header2"),
    @NamedQuery(name = "AtTestdocument.findByHeader3", query = "SELECT a FROM AtTestdocument a WHERE a.header3 = :header3"),
    @NamedQuery(name = "AtTestdocument.findByHeader4", query = "SELECT a FROM AtTestdocument a WHERE a.header4 = :header4"),
    @NamedQuery(name = "AtTestdocument.findByLineInterchanger", query = "SELECT a FROM AtTestdocument a WHERE a.lineInterchanger = :lineInterchanger"),
    @NamedQuery(name = "AtTestdocument.findByPrefix", query = "SELECT a FROM AtTestdocument a WHERE a.prefix = :prefix"),
    @NamedQuery(name = "AtTestdocument.findByIntroduction", query = "SELECT a FROM AtTestdocument a WHERE a.introduction = :introduction")})
public class AtTestdocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "at_testdocument_id")
    private String atTestdocumentId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "extension")
    private String extension;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "header1")
    private String header1;
    @Size(max = 60)
    @Column(name = "suffix")
    private String suffix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "footer")
    private String footer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "contenttype")
    private String contenttype;
    @Size(max = 2000)
    @Column(name = "header2")
    private String header2;
    @Size(max = 2000)
    @Column(name = "header3")
    private String header3;
    @Size(max = 2000)
    @Column(name = "header4")
    private String header4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line_interchanger")
    private Character lineInterchanger;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prefix")
    private Character prefix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "introduction")
    private Character introduction;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "atTestdocumentId")
    private List<AtTestdocumentline> atTestdocumentlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AtTestdocument() {
    }

    public AtTestdocument(String atTestdocumentId) {
        this.atTestdocumentId = atTestdocumentId;
    }

    public AtTestdocument(String atTestdocumentId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String extension, String header1, String footer, String contenttype, Character lineInterchanger, Character prefix, Character introduction) {
        this.atTestdocumentId = atTestdocumentId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.extension = extension;
        this.header1 = header1;
        this.footer = footer;
        this.contenttype = contenttype;
        this.lineInterchanger = lineInterchanger;
        this.prefix = prefix;
        this.introduction = introduction;
    }

    public String getAtTestdocumentId() {
        return atTestdocumentId;
    }

    public void setAtTestdocumentId(String atTestdocumentId) {
        this.atTestdocumentId = atTestdocumentId;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getHeader1() {
        return header1;
    }

    public void setHeader1(String header1) {
        this.header1 = header1;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getHeader2() {
        return header2;
    }

    public void setHeader2(String header2) {
        this.header2 = header2;
    }

    public String getHeader3() {
        return header3;
    }

    public void setHeader3(String header3) {
        this.header3 = header3;
    }

    public String getHeader4() {
        return header4;
    }

    public void setHeader4(String header4) {
        this.header4 = header4;
    }

    public Character getLineInterchanger() {
        return lineInterchanger;
    }

    public void setLineInterchanger(Character lineInterchanger) {
        this.lineInterchanger = lineInterchanger;
    }

    public Character getPrefix() {
        return prefix;
    }

    public void setPrefix(Character prefix) {
        this.prefix = prefix;
    }

    public Character getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Character introduction) {
        this.introduction = introduction;
    }

    @XmlTransient
    public List<AtTestdocumentline> getAtTestdocumentlineList() {
        return atTestdocumentlineList;
    }

    public void setAtTestdocumentlineList(List<AtTestdocumentline> atTestdocumentlineList) {
        this.atTestdocumentlineList = atTestdocumentlineList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atTestdocumentId != null ? atTestdocumentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtTestdocument)) {
            return false;
        }
        AtTestdocument other = (AtTestdocument) object;
        if ((this.atTestdocumentId == null && other.atTestdocumentId != null) || (this.atTestdocumentId != null && !this.atTestdocumentId.equals(other.atTestdocumentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AtTestdocument[ atTestdocumentId=" + atTestdocumentId + " ]";
    }
    
}
