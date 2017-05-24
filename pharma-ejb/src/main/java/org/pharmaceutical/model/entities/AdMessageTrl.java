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
@Table(name = "ad_message_trl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdMessageTrl.findAll", query = "SELECT a FROM AdMessageTrl a"),
    @NamedQuery(name = "AdMessageTrl.findByAdMessageTrlId", query = "SELECT a FROM AdMessageTrl a WHERE a.adMessageTrlId = :adMessageTrlId"),
    @NamedQuery(name = "AdMessageTrl.findByIsactive", query = "SELECT a FROM AdMessageTrl a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdMessageTrl.findByCreated", query = "SELECT a FROM AdMessageTrl a WHERE a.created = :created"),
    @NamedQuery(name = "AdMessageTrl.findByCreatedby", query = "SELECT a FROM AdMessageTrl a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdMessageTrl.findByUpdated", query = "SELECT a FROM AdMessageTrl a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdMessageTrl.findByUpdatedby", query = "SELECT a FROM AdMessageTrl a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdMessageTrl.findByMsgtext", query = "SELECT a FROM AdMessageTrl a WHERE a.msgtext = :msgtext"),
    @NamedQuery(name = "AdMessageTrl.findByMsgtip", query = "SELECT a FROM AdMessageTrl a WHERE a.msgtip = :msgtip"),
    @NamedQuery(name = "AdMessageTrl.findByIstranslated", query = "SELECT a FROM AdMessageTrl a WHERE a.istranslated = :istranslated")})
public class AdMessageTrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_message_trl_id")
    private String adMessageTrlId;
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
    @Size(min = 1, max = 2000)
    @Column(name = "msgtext")
    private String msgtext;
    @Size(max = 2000)
    @Column(name = "msgtip")
    private String msgtip;
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
    @JoinColumn(name = "ad_message_id", referencedColumnName = "ad_message_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdMessage adMessageId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdMessageTrl() {
    }

    public AdMessageTrl(String adMessageTrlId) {
        this.adMessageTrlId = adMessageTrlId;
    }

    public AdMessageTrl(String adMessageTrlId, Character isactive, Date created, String createdby, Date updated, String updatedby, String msgtext, Character istranslated) {
        this.adMessageTrlId = adMessageTrlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.msgtext = msgtext;
        this.istranslated = istranslated;
    }

    public String getAdMessageTrlId() {
        return adMessageTrlId;
    }

    public void setAdMessageTrlId(String adMessageTrlId) {
        this.adMessageTrlId = adMessageTrlId;
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

    public String getMsgtext() {
        return msgtext;
    }

    public void setMsgtext(String msgtext) {
        this.msgtext = msgtext;
    }

    public String getMsgtip() {
        return msgtip;
    }

    public void setMsgtip(String msgtip) {
        this.msgtip = msgtip;
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

    public AdMessage getAdMessageId() {
        return adMessageId;
    }

    public void setAdMessageId(AdMessage adMessageId) {
        this.adMessageId = adMessageId;
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
        hash += (adMessageTrlId != null ? adMessageTrlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdMessageTrl)) {
            return false;
        }
        AdMessageTrl other = (AdMessageTrl) object;
        if ((this.adMessageTrlId == null && other.adMessageTrlId != null) || (this.adMessageTrlId != null && !this.adMessageTrlId.equals(other.adMessageTrlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdMessageTrl[ adMessageTrlId=" + adMessageTrlId + " ]";
    }
    
}
