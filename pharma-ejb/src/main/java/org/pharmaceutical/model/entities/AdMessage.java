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
@Table(name = "ad_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdMessage.findAll", query = "SELECT a FROM AdMessage a"),
    @NamedQuery(name = "AdMessage.findByAdMessageId", query = "SELECT a FROM AdMessage a WHERE a.adMessageId = :adMessageId"),
    @NamedQuery(name = "AdMessage.findByIsactive", query = "SELECT a FROM AdMessage a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdMessage.findByCreated", query = "SELECT a FROM AdMessage a WHERE a.created = :created"),
    @NamedQuery(name = "AdMessage.findByCreatedby", query = "SELECT a FROM AdMessage a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdMessage.findByUpdated", query = "SELECT a FROM AdMessage a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdMessage.findByUpdatedby", query = "SELECT a FROM AdMessage a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdMessage.findByValue", query = "SELECT a FROM AdMessage a WHERE a.value = :value"),
    @NamedQuery(name = "AdMessage.findByMsgtext", query = "SELECT a FROM AdMessage a WHERE a.msgtext = :msgtext"),
    @NamedQuery(name = "AdMessage.findByMsgtip", query = "SELECT a FROM AdMessage a WHERE a.msgtip = :msgtip"),
    @NamedQuery(name = "AdMessage.findByMsgtype", query = "SELECT a FROM AdMessage a WHERE a.msgtype = :msgtype")})
public class AdMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_message_id")
    private String adMessageId;
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
    @Column(name = "value")
    private String value;
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
    @Size(min = 1, max = 60)
    @Column(name = "msgtype")
    private String msgtype;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adMessageId")
    private List<AdMessageTrl> adMessageTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adMessageId")
    private List<AdNote> adNoteList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdMessage() {
    }

    public AdMessage(String adMessageId) {
        this.adMessageId = adMessageId;
    }

    public AdMessage(String adMessageId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String msgtext, String msgtype) {
        this.adMessageId = adMessageId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.msgtext = msgtext;
        this.msgtype = msgtype;
    }

    public String getAdMessageId() {
        return adMessageId;
    }

    public void setAdMessageId(String adMessageId) {
        this.adMessageId = adMessageId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    @XmlTransient
    public List<AdMessageTrl> getAdMessageTrlList() {
        return adMessageTrlList;
    }

    public void setAdMessageTrlList(List<AdMessageTrl> adMessageTrlList) {
        this.adMessageTrlList = adMessageTrlList;
    }

    @XmlTransient
    public List<AdNote> getAdNoteList() {
        return adNoteList;
    }

    public void setAdNoteList(List<AdNote> adNoteList) {
        this.adNoteList = adNoteList;
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
        hash += (adMessageId != null ? adMessageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdMessage)) {
            return false;
        }
        AdMessage other = (AdMessage) object;
        if ((this.adMessageId == null && other.adMessageId != null) || (this.adMessageId != null && !this.adMessageId.equals(other.adMessageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdMessage[ adMessageId=" + adMessageId + " ]";
    }
    
}
