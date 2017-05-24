/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "c_paymenttermline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPaymenttermline.findAll", query = "SELECT c FROM CPaymenttermline c"),
    @NamedQuery(name = "CPaymenttermline.findByCPaymenttermlineId", query = "SELECT c FROM CPaymenttermline c WHERE c.cPaymenttermlineId = :cPaymenttermlineId"),
    @NamedQuery(name = "CPaymenttermline.findByIsactive", query = "SELECT c FROM CPaymenttermline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPaymenttermline.findByCreated", query = "SELECT c FROM CPaymenttermline c WHERE c.created = :created"),
    @NamedQuery(name = "CPaymenttermline.findByCreatedby", query = "SELECT c FROM CPaymenttermline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPaymenttermline.findByUpdated", query = "SELECT c FROM CPaymenttermline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPaymenttermline.findByUpdatedby", query = "SELECT c FROM CPaymenttermline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPaymenttermline.findByLine", query = "SELECT c FROM CPaymenttermline c WHERE c.line = :line"),
    @NamedQuery(name = "CPaymenttermline.findByPercentage", query = "SELECT c FROM CPaymenttermline c WHERE c.percentage = :percentage"),
    @NamedQuery(name = "CPaymenttermline.findByOnremainder", query = "SELECT c FROM CPaymenttermline c WHERE c.onremainder = :onremainder"),
    @NamedQuery(name = "CPaymenttermline.findByExcludetax", query = "SELECT c FROM CPaymenttermline c WHERE c.excludetax = :excludetax"),
    @NamedQuery(name = "CPaymenttermline.findByPaymentrule", query = "SELECT c FROM CPaymenttermline c WHERE c.paymentrule = :paymentrule"),
    @NamedQuery(name = "CPaymenttermline.findByIsduefixed", query = "SELECT c FROM CPaymenttermline c WHERE c.isduefixed = :isduefixed"),
    @NamedQuery(name = "CPaymenttermline.findByNetdays", query = "SELECT c FROM CPaymenttermline c WHERE c.netdays = :netdays"),
    @NamedQuery(name = "CPaymenttermline.findByFixmonthcutoff", query = "SELECT c FROM CPaymenttermline c WHERE c.fixmonthcutoff = :fixmonthcutoff"),
    @NamedQuery(name = "CPaymenttermline.findByFixmonthday", query = "SELECT c FROM CPaymenttermline c WHERE c.fixmonthday = :fixmonthday"),
    @NamedQuery(name = "CPaymenttermline.findByFixmonthday2", query = "SELECT c FROM CPaymenttermline c WHERE c.fixmonthday2 = :fixmonthday2"),
    @NamedQuery(name = "CPaymenttermline.findByFixmonthday3", query = "SELECT c FROM CPaymenttermline c WHERE c.fixmonthday3 = :fixmonthday3"),
    @NamedQuery(name = "CPaymenttermline.findByFixmonthoffset", query = "SELECT c FROM CPaymenttermline c WHERE c.fixmonthoffset = :fixmonthoffset"),
    @NamedQuery(name = "CPaymenttermline.findByIsnextbusinessday", query = "SELECT c FROM CPaymenttermline c WHERE c.isnextbusinessday = :isnextbusinessday"),
    @NamedQuery(name = "CPaymenttermline.findByNetday", query = "SELECT c FROM CPaymenttermline c WHERE c.netday = :netday")})
public class CPaymenttermline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_paymenttermline_id")
    private String cPaymenttermlineId;
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
    @Column(name = "line")
    private long line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentage")
    private BigInteger percentage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "onremainder")
    private Character onremainder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "excludetax")
    private Character excludetax;
    @Size(max = 60)
    @Column(name = "paymentrule")
    private String paymentrule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isduefixed")
    private Character isduefixed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "netdays")
    private long netdays;
    @Column(name = "fixmonthcutoff")
    private Long fixmonthcutoff;
    @Column(name = "fixmonthday")
    private Long fixmonthday;
    @Column(name = "fixmonthday2")
    private Long fixmonthday2;
    @Column(name = "fixmonthday3")
    private Long fixmonthday3;
    @Column(name = "fixmonthoffset")
    private Long fixmonthoffset;
    @Column(name = "isnextbusinessday")
    private Character isnextbusinessday;
    @Size(max = 60)
    @Column(name = "netday")
    private String netday;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CPaymentterm cPaymenttermId;
    @JoinColumn(name = "fin_paymentmethod_id", referencedColumnName = "fin_paymentmethod_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentmethod finPaymentmethodId;

    public CPaymenttermline() {
    }

    public CPaymenttermline(String cPaymenttermlineId) {
        this.cPaymenttermlineId = cPaymenttermlineId;
    }

    public CPaymenttermline(String cPaymenttermlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, BigInteger percentage, Character onremainder, Character excludetax, Character isduefixed, long netdays) {
        this.cPaymenttermlineId = cPaymenttermlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.percentage = percentage;
        this.onremainder = onremainder;
        this.excludetax = excludetax;
        this.isduefixed = isduefixed;
        this.netdays = netdays;
    }

    public String getCPaymenttermlineId() {
        return cPaymenttermlineId;
    }

    public void setCPaymenttermlineId(String cPaymenttermlineId) {
        this.cPaymenttermlineId = cPaymenttermlineId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public BigInteger getPercentage() {
        return percentage;
    }

    public void setPercentage(BigInteger percentage) {
        this.percentage = percentage;
    }

    public Character getOnremainder() {
        return onremainder;
    }

    public void setOnremainder(Character onremainder) {
        this.onremainder = onremainder;
    }

    public Character getExcludetax() {
        return excludetax;
    }

    public void setExcludetax(Character excludetax) {
        this.excludetax = excludetax;
    }

    public String getPaymentrule() {
        return paymentrule;
    }

    public void setPaymentrule(String paymentrule) {
        this.paymentrule = paymentrule;
    }

    public Character getIsduefixed() {
        return isduefixed;
    }

    public void setIsduefixed(Character isduefixed) {
        this.isduefixed = isduefixed;
    }

    public long getNetdays() {
        return netdays;
    }

    public void setNetdays(long netdays) {
        this.netdays = netdays;
    }

    public Long getFixmonthcutoff() {
        return fixmonthcutoff;
    }

    public void setFixmonthcutoff(Long fixmonthcutoff) {
        this.fixmonthcutoff = fixmonthcutoff;
    }

    public Long getFixmonthday() {
        return fixmonthday;
    }

    public void setFixmonthday(Long fixmonthday) {
        this.fixmonthday = fixmonthday;
    }

    public Long getFixmonthday2() {
        return fixmonthday2;
    }

    public void setFixmonthday2(Long fixmonthday2) {
        this.fixmonthday2 = fixmonthday2;
    }

    public Long getFixmonthday3() {
        return fixmonthday3;
    }

    public void setFixmonthday3(Long fixmonthday3) {
        this.fixmonthday3 = fixmonthday3;
    }

    public Long getFixmonthoffset() {
        return fixmonthoffset;
    }

    public void setFixmonthoffset(Long fixmonthoffset) {
        this.fixmonthoffset = fixmonthoffset;
    }

    public Character getIsnextbusinessday() {
        return isnextbusinessday;
    }

    public void setIsnextbusinessday(Character isnextbusinessday) {
        this.isnextbusinessday = isnextbusinessday;
    }

    public String getNetday() {
        return netday;
    }

    public void setNetday(String netday) {
        this.netday = netday;
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

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    public FinPaymentmethod getFinPaymentmethodId() {
        return finPaymentmethodId;
    }

    public void setFinPaymentmethodId(FinPaymentmethod finPaymentmethodId) {
        this.finPaymentmethodId = finPaymentmethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPaymenttermlineId != null ? cPaymenttermlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPaymenttermline)) {
            return false;
        }
        CPaymenttermline other = (CPaymenttermline) object;
        if ((this.cPaymenttermlineId == null && other.cPaymenttermlineId != null) || (this.cPaymenttermlineId != null && !this.cPaymenttermlineId.equals(other.cPaymenttermlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPaymenttermline[ cPaymenttermlineId=" + cPaymenttermlineId + " ]";
    }
    
}
