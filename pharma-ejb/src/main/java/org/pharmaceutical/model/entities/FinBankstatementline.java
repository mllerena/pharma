/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "fin_bankstatementline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinBankstatementline.findAll", query = "SELECT f FROM FinBankstatementline f"),
    @NamedQuery(name = "FinBankstatementline.findByFinBankstatementlineId", query = "SELECT f FROM FinBankstatementline f WHERE f.finBankstatementlineId = :finBankstatementlineId"),
    @NamedQuery(name = "FinBankstatementline.findByCreated", query = "SELECT f FROM FinBankstatementline f WHERE f.created = :created"),
    @NamedQuery(name = "FinBankstatementline.findByCreatedby", query = "SELECT f FROM FinBankstatementline f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinBankstatementline.findByUpdated", query = "SELECT f FROM FinBankstatementline f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinBankstatementline.findByUpdatedby", query = "SELECT f FROM FinBankstatementline f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinBankstatementline.findByIsactive", query = "SELECT f FROM FinBankstatementline f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinBankstatementline.findByLine", query = "SELECT f FROM FinBankstatementline f WHERE f.line = :line"),
    @NamedQuery(name = "FinBankstatementline.findByBpartnername", query = "SELECT f FROM FinBankstatementline f WHERE f.bpartnername = :bpartnername"),
    @NamedQuery(name = "FinBankstatementline.findByDatetrx", query = "SELECT f FROM FinBankstatementline f WHERE f.datetrx = :datetrx"),
    @NamedQuery(name = "FinBankstatementline.findByCramount", query = "SELECT f FROM FinBankstatementline f WHERE f.cramount = :cramount"),
    @NamedQuery(name = "FinBankstatementline.findByDramount", query = "SELECT f FROM FinBankstatementline f WHERE f.dramount = :dramount"),
    @NamedQuery(name = "FinBankstatementline.findByReferenceno", query = "SELECT f FROM FinBankstatementline f WHERE f.referenceno = :referenceno"),
    @NamedQuery(name = "FinBankstatementline.findByMatchingtype", query = "SELECT f FROM FinBankstatementline f WHERE f.matchingtype = :matchingtype"),
    @NamedQuery(name = "FinBankstatementline.findByDescription", query = "SELECT f FROM FinBankstatementline f WHERE f.description = :description")})
public class FinBankstatementline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_bankstatementline_id")
    private String finBankstatementlineId;
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
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line")
    private long line;
    @Size(max = 60)
    @Column(name = "bpartnername")
    private String bpartnername;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datetrx")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetrx;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cramount")
    private BigInteger cramount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dramount")
    private BigInteger dramount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "referenceno")
    private String referenceno;
    @Size(max = 60)
    @Column(name = "matchingtype")
    private String matchingtype;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "fin_bankstatement_id", referencedColumnName = "fin_bankstatement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinBankstatement finBankstatementId;
    @JoinColumn(name = "fin_finacc_transaction_id", referencedColumnName = "fin_finacc_transaction_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinFinaccTransaction finFinaccTransactionId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finBankstatementlineId")
    private List<FinReclineTemp> finReclineTempList;

    public FinBankstatementline() {
    }

    public FinBankstatementline(String finBankstatementlineId) {
        this.finBankstatementlineId = finBankstatementlineId;
    }

    public FinBankstatementline(String finBankstatementlineId, Date created, String createdby, Date updated, String updatedby, long line, Date datetrx, BigInteger cramount, BigInteger dramount, String referenceno) {
        this.finBankstatementlineId = finBankstatementlineId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.datetrx = datetrx;
        this.cramount = cramount;
        this.dramount = dramount;
        this.referenceno = referenceno;
    }

    public String getFinBankstatementlineId() {
        return finBankstatementlineId;
    }

    public void setFinBankstatementlineId(String finBankstatementlineId) {
        this.finBankstatementlineId = finBankstatementlineId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public String getBpartnername() {
        return bpartnername;
    }

    public void setBpartnername(String bpartnername) {
        this.bpartnername = bpartnername;
    }

    public Date getDatetrx() {
        return datetrx;
    }

    public void setDatetrx(Date datetrx) {
        this.datetrx = datetrx;
    }

    public BigInteger getCramount() {
        return cramount;
    }

    public void setCramount(BigInteger cramount) {
        this.cramount = cramount;
    }

    public BigInteger getDramount() {
        return dramount;
    }

    public void setDramount(BigInteger dramount) {
        this.dramount = dramount;
    }

    public String getReferenceno() {
        return referenceno;
    }

    public void setReferenceno(String referenceno) {
        this.referenceno = referenceno;
    }

    public String getMatchingtype() {
        return matchingtype;
    }

    public void setMatchingtype(String matchingtype) {
        this.matchingtype = matchingtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public FinBankstatement getFinBankstatementId() {
        return finBankstatementId;
    }

    public void setFinBankstatementId(FinBankstatement finBankstatementId) {
        this.finBankstatementId = finBankstatementId;
    }

    public FinFinaccTransaction getFinFinaccTransactionId() {
        return finFinaccTransactionId;
    }

    public void setFinFinaccTransactionId(FinFinaccTransaction finFinaccTransactionId) {
        this.finFinaccTransactionId = finFinaccTransactionId;
    }

    @XmlTransient
    public List<FinReclineTemp> getFinReclineTempList() {
        return finReclineTempList;
    }

    public void setFinReclineTempList(List<FinReclineTemp> finReclineTempList) {
        this.finReclineTempList = finReclineTempList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finBankstatementlineId != null ? finBankstatementlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinBankstatementline)) {
            return false;
        }
        FinBankstatementline other = (FinBankstatementline) object;
        if ((this.finBankstatementlineId == null && other.finBankstatementlineId != null) || (this.finBankstatementlineId != null && !this.finBankstatementlineId.equals(other.finBankstatementlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinBankstatementline[ finBankstatementlineId=" + finBankstatementlineId + " ]";
    }
    
}
