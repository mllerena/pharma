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
@Table(name = "c_poc_email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPocEmail.findAll", query = "SELECT c FROM CPocEmail c"),
    @NamedQuery(name = "CPocEmail.findByCPocEmailId", query = "SELECT c FROM CPocEmail c WHERE c.cPocEmailId = :cPocEmailId"),
    @NamedQuery(name = "CPocEmail.findByIsactive", query = "SELECT c FROM CPocEmail c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPocEmail.findByCreated", query = "SELECT c FROM CPocEmail c WHERE c.created = :created"),
    @NamedQuery(name = "CPocEmail.findByCreatedby", query = "SELECT c FROM CPocEmail c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPocEmail.findByUpdated", query = "SELECT c FROM CPocEmail c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPocEmail.findByUpdatedby", query = "SELECT c FROM CPocEmail c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPocEmail.findByAddressFrom", query = "SELECT c FROM CPocEmail c WHERE c.addressFrom = :addressFrom"),
    @NamedQuery(name = "CPocEmail.findByAddressTo", query = "SELECT c FROM CPocEmail c WHERE c.addressTo = :addressTo"),
    @NamedQuery(name = "CPocEmail.findByAddressCc", query = "SELECT c FROM CPocEmail c WHERE c.addressCc = :addressCc"),
    @NamedQuery(name = "CPocEmail.findByAddressBcc", query = "SELECT c FROM CPocEmail c WHERE c.addressBcc = :addressBcc"),
    @NamedQuery(name = "CPocEmail.findByDateofemail", query = "SELECT c FROM CPocEmail c WHERE c.dateofemail = :dateofemail"),
    @NamedQuery(name = "CPocEmail.findBySubject", query = "SELECT c FROM CPocEmail c WHERE c.subject = :subject"),
    @NamedQuery(name = "CPocEmail.findByBody", query = "SELECT c FROM CPocEmail c WHERE c.body = :body"),
    @NamedQuery(name = "CPocEmail.findByEmailType", query = "SELECT c FROM CPocEmail c WHERE c.emailType = :emailType")})
public class CPocEmail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_poc_email_id")
    private String cPocEmailId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 200)
    @Column(name = "address_from")
    private String addressFrom;
    @Size(max = 1000)
    @Column(name = "address_to")
    private String addressTo;
    @Size(max = 1000)
    @Column(name = "address_cc")
    private String addressCc;
    @Size(max = 1000)
    @Column(name = "address_bcc")
    private String addressBcc;
    @Column(name = "dateofemail")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofemail;
    @Size(max = 1000)
    @Column(name = "subject")
    private String subject;
    @Size(max = 4000)
    @Column(name = "body")
    private String body;
    @Size(max = 32)
    @Column(name = "email_type")
    private String emailType;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPocEmailId")
    private List<CPocEmailUser> cPocEmailUserList;

    public CPocEmail() {
    }

    public CPocEmail(String cPocEmailId) {
        this.cPocEmailId = cPocEmailId;
    }

    public String getCPocEmailId() {
        return cPocEmailId;
    }

    public void setCPocEmailId(String cPocEmailId) {
        this.cPocEmailId = cPocEmailId;
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

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getAddressCc() {
        return addressCc;
    }

    public void setAddressCc(String addressCc) {
        this.addressCc = addressCc;
    }

    public String getAddressBcc() {
        return addressBcc;
    }

    public void setAddressBcc(String addressBcc) {
        this.addressBcc = addressBcc;
    }

    public Date getDateofemail() {
        return dateofemail;
    }

    public void setDateofemail(Date dateofemail) {
        this.dateofemail = dateofemail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    @XmlTransient
    public List<CPocEmailUser> getCPocEmailUserList() {
        return cPocEmailUserList;
    }

    public void setCPocEmailUserList(List<CPocEmailUser> cPocEmailUserList) {
        this.cPocEmailUserList = cPocEmailUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPocEmailId != null ? cPocEmailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPocEmail)) {
            return false;
        }
        CPocEmail other = (CPocEmail) object;
        if ((this.cPocEmailId == null && other.cPocEmailId != null) || (this.cPocEmailId != null && !this.cPocEmailId.equals(other.cPocEmailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPocEmail[ cPocEmailId=" + cPocEmailId + " ]";
    }
    
}
