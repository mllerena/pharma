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
@Table(name = "c_projectproposal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjectproposal.findAll", query = "SELECT c FROM CProjectproposal c"),
    @NamedQuery(name = "CProjectproposal.findByCProjectproposalId", query = "SELECT c FROM CProjectproposal c WHERE c.cProjectproposalId = :cProjectproposalId"),
    @NamedQuery(name = "CProjectproposal.findByIsactive", query = "SELECT c FROM CProjectproposal c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjectproposal.findByCreated", query = "SELECT c FROM CProjectproposal c WHERE c.created = :created"),
    @NamedQuery(name = "CProjectproposal.findByCreatedby", query = "SELECT c FROM CProjectproposal c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjectproposal.findByUpdated", query = "SELECT c FROM CProjectproposal c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjectproposal.findByUpdatedby", query = "SELECT c FROM CProjectproposal c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjectproposal.findByDatesend", query = "SELECT c FROM CProjectproposal c WHERE c.datesend = :datesend"),
    @NamedQuery(name = "CProjectproposal.findByCopyfrom", query = "SELECT c FROM CProjectproposal c WHERE c.copyfrom = :copyfrom"),
    @NamedQuery(name = "CProjectproposal.findByHeadernote", query = "SELECT c FROM CProjectproposal c WHERE c.headernote = :headernote"),
    @NamedQuery(name = "CProjectproposal.findByFootnote", query = "SELECT c FROM CProjectproposal c WHERE c.footnote = :footnote"),
    @NamedQuery(name = "CProjectproposal.findByIssotrx", query = "SELECT c FROM CProjectproposal c WHERE c.issotrx = :issotrx"),
    @NamedQuery(name = "CProjectproposal.findByPaymentrule", query = "SELECT c FROM CProjectproposal c WHERE c.paymentrule = :paymentrule"),
    @NamedQuery(name = "CProjectproposal.findByProjectwon", query = "SELECT c FROM CProjectproposal c WHERE c.projectwon = :projectwon")})
public class CProjectproposal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_projectproposal_id")
    private String cProjectproposalId;
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
    @Column(name = "datesend")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datesend;
    @Column(name = "copyfrom")
    private Character copyfrom;
    @Size(max = 2000)
    @Column(name = "headernote")
    private String headernote;
    @Size(max = 2000)
    @Column(name = "footnote")
    private String footnote;
    @Column(name = "issotrx")
    private Character issotrx;
    @Size(max = 60)
    @Column(name = "paymentrule")
    private String paymentrule;
    @Column(name = "projectwon")
    private Character projectwon;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPaymentterm cPaymenttermId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProject cProjectId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentmethod finPaymentmethodId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectproposalId")
    private List<CProjectproposaltask> cProjectproposaltaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectproposalId")
    private List<CProjectproposalline> cProjectproposallineList;

    public CProjectproposal() {
    }

    public CProjectproposal(String cProjectproposalId) {
        this.cProjectproposalId = cProjectproposalId;
    }

    public CProjectproposal(String cProjectproposalId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cProjectproposalId = cProjectproposalId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCProjectproposalId() {
        return cProjectproposalId;
    }

    public void setCProjectproposalId(String cProjectproposalId) {
        this.cProjectproposalId = cProjectproposalId;
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

    public Date getDatesend() {
        return datesend;
    }

    public void setDatesend(Date datesend) {
        this.datesend = datesend;
    }

    public Character getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(Character copyfrom) {
        this.copyfrom = copyfrom;
    }

    public String getHeadernote() {
        return headernote;
    }

    public void setHeadernote(String headernote) {
        this.headernote = headernote;
    }

    public String getFootnote() {
        return footnote;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }

    public Character getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(Character issotrx) {
        this.issotrx = issotrx;
    }

    public String getPaymentrule() {
        return paymentrule;
    }

    public void setPaymentrule(String paymentrule) {
        this.paymentrule = paymentrule;
    }

    public Character getProjectwon() {
        return projectwon;
    }

    public void setProjectwon(Character projectwon) {
        this.projectwon = projectwon;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public FinPaymentmethod getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(FinPaymentmethod finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    @XmlTransient
    public List<CProjectproposaltask> getCProjectproposaltaskList() {
        return cProjectproposaltaskList;
    }

    public void setCProjectproposaltaskList(List<CProjectproposaltask> cProjectproposaltaskList) {
        this.cProjectproposaltaskList = cProjectproposaltaskList;
    }

    @XmlTransient
    public List<CProjectproposalline> getCProjectproposallineList() {
        return cProjectproposallineList;
    }

    public void setCProjectproposallineList(List<CProjectproposalline> cProjectproposallineList) {
        this.cProjectproposallineList = cProjectproposallineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProjectproposalId != null ? cProjectproposalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjectproposal)) {
            return false;
        }
        CProjectproposal other = (CProjectproposal) object;
        if ((this.cProjectproposalId == null && other.cProjectproposalId != null) || (this.cProjectproposalId != null && !this.cProjectproposalId.equals(other.cProjectproposalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjectproposal[ cProjectproposalId=" + cProjectproposalId + " ]";
    }
    
}
