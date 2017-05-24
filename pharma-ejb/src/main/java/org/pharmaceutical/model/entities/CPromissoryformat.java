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
@Table(name = "c_promissoryformat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPromissoryformat.findAll", query = "SELECT c FROM CPromissoryformat c"),
    @NamedQuery(name = "CPromissoryformat.findByCPromissoryformatId", query = "SELECT c FROM CPromissoryformat c WHERE c.cPromissoryformatId = :cPromissoryformatId"),
    @NamedQuery(name = "CPromissoryformat.findByIsactive", query = "SELECT c FROM CPromissoryformat c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPromissoryformat.findByCreated", query = "SELECT c FROM CPromissoryformat c WHERE c.created = :created"),
    @NamedQuery(name = "CPromissoryformat.findByCreatedby", query = "SELECT c FROM CPromissoryformat c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPromissoryformat.findByUpdated", query = "SELECT c FROM CPromissoryformat c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPromissoryformat.findByUpdatedby", query = "SELECT c FROM CPromissoryformat c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPromissoryformat.findByName", query = "SELECT c FROM CPromissoryformat c WHERE c.name = :name"),
    @NamedQuery(name = "CPromissoryformat.findByDescription", query = "SELECT c FROM CPromissoryformat c WHERE c.description = :description"),
    @NamedQuery(name = "CPromissoryformat.findByLine1top", query = "SELECT c FROM CPromissoryformat c WHERE c.line1top = :line1top"),
    @NamedQuery(name = "CPromissoryformat.findByLine1left", query = "SELECT c FROM CPromissoryformat c WHERE c.line1left = :line1left"),
    @NamedQuery(name = "CPromissoryformat.findByLine2top", query = "SELECT c FROM CPromissoryformat c WHERE c.line2top = :line2top"),
    @NamedQuery(name = "CPromissoryformat.findByLine2left", query = "SELECT c FROM CPromissoryformat c WHERE c.line2left = :line2left"),
    @NamedQuery(name = "CPromissoryformat.findByLine3top", query = "SELECT c FROM CPromissoryformat c WHERE c.line3top = :line3top"),
    @NamedQuery(name = "CPromissoryformat.findByLine3left", query = "SELECT c FROM CPromissoryformat c WHERE c.line3left = :line3left"),
    @NamedQuery(name = "CPromissoryformat.findByLine4top", query = "SELECT c FROM CPromissoryformat c WHERE c.line4top = :line4top"),
    @NamedQuery(name = "CPromissoryformat.findByLine4left", query = "SELECT c FROM CPromissoryformat c WHERE c.line4left = :line4left"),
    @NamedQuery(name = "CPromissoryformat.findByParam11", query = "SELECT c FROM CPromissoryformat c WHERE c.param11 = :param11"),
    @NamedQuery(name = "CPromissoryformat.findByParam12", query = "SELECT c FROM CPromissoryformat c WHERE c.param12 = :param12"),
    @NamedQuery(name = "CPromissoryformat.findByParam13", query = "SELECT c FROM CPromissoryformat c WHERE c.param13 = :param13"),
    @NamedQuery(name = "CPromissoryformat.findByParam31", query = "SELECT c FROM CPromissoryformat c WHERE c.param31 = :param31"),
    @NamedQuery(name = "CPromissoryformat.findByParam32", query = "SELECT c FROM CPromissoryformat c WHERE c.param32 = :param32"),
    @NamedQuery(name = "CPromissoryformat.findByParam41", query = "SELECT c FROM CPromissoryformat c WHERE c.param41 = :param41"),
    @NamedQuery(name = "CPromissoryformat.findByParam42", query = "SELECT c FROM CPromissoryformat c WHERE c.param42 = :param42"),
    @NamedQuery(name = "CPromissoryformat.findByParam43", query = "SELECT c FROM CPromissoryformat c WHERE c.param43 = :param43"),
    @NamedQuery(name = "CPromissoryformat.findByPrintbankloc", query = "SELECT c FROM CPromissoryformat c WHERE c.printbankloc = :printbankloc"),
    @NamedQuery(name = "CPromissoryformat.findByFontdayplanned", query = "SELECT c FROM CPromissoryformat c WHERE c.fontdayplanned = :fontdayplanned"),
    @NamedQuery(name = "CPromissoryformat.findByFontmonthplanned", query = "SELECT c FROM CPromissoryformat c WHERE c.fontmonthplanned = :fontmonthplanned"),
    @NamedQuery(name = "CPromissoryformat.findByFontyearplanned", query = "SELECT c FROM CPromissoryformat c WHERE c.fontyearplanned = :fontyearplanned"),
    @NamedQuery(name = "CPromissoryformat.findByFontamount", query = "SELECT c FROM CPromissoryformat c WHERE c.fontamount = :fontamount"),
    @NamedQuery(name = "CPromissoryformat.findByFontpartnername", query = "SELECT c FROM CPromissoryformat c WHERE c.fontpartnername = :fontpartnername"),
    @NamedQuery(name = "CPromissoryformat.findByFontamounttext", query = "SELECT c FROM CPromissoryformat c WHERE c.fontamounttext = :fontamounttext"),
    @NamedQuery(name = "CPromissoryformat.findByFontdaytoday", query = "SELECT c FROM CPromissoryformat c WHERE c.fontdaytoday = :fontdaytoday"),
    @NamedQuery(name = "CPromissoryformat.findByFontmonthtoday", query = "SELECT c FROM CPromissoryformat c WHERE c.fontmonthtoday = :fontmonthtoday"),
    @NamedQuery(name = "CPromissoryformat.findByFontyeartoday", query = "SELECT c FROM CPromissoryformat c WHERE c.fontyeartoday = :fontyeartoday"),
    @NamedQuery(name = "CPromissoryformat.findByFontbanklocation", query = "SELECT c FROM CPromissoryformat c WHERE c.fontbanklocation = :fontbanklocation")})
public class CPromissoryformat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_promissoryformat_id")
    private String cPromissoryformatId;
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
    @Column(name = "line1top")
    private BigInteger line1top;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line1left")
    private BigInteger line1left;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line2top")
    private BigInteger line2top;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line2left")
    private BigInteger line2left;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line3top")
    private BigInteger line3top;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line3left")
    private BigInteger line3left;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line4top")
    private BigInteger line4top;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line4left")
    private BigInteger line4left;
    @Basic(optional = false)
    @NotNull
    @Column(name = "param11")
    private BigInteger param11;
    @Basic(optional = false)
    @NotNull
    @Column(name = "param12")
    private BigInteger param12;
    @Basic(optional = false)
    @NotNull
    @Column(name = "param13")
    private BigInteger param13;
    @Basic(optional = false)
    @NotNull
    @Column(name = "param31")
    private BigInteger param31;
    @Basic(optional = false)
    @NotNull
    @Column(name = "param32")
    private BigInteger param32;
    @Basic(optional = false)
    @NotNull
    @Column(name = "param41")
    private BigInteger param41;
    @Basic(optional = false)
    @NotNull
    @Column(name = "param42")
    private BigInteger param42;
    @Basic(optional = false)
    @NotNull
    @Column(name = "param43")
    private BigInteger param43;
    @Basic(optional = false)
    @NotNull
    @Column(name = "printbankloc")
    private Character printbankloc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontdayplanned")
    private BigInteger fontdayplanned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontmonthplanned")
    private BigInteger fontmonthplanned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontyearplanned")
    private BigInteger fontyearplanned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontamount")
    private BigInteger fontamount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontpartnername")
    private BigInteger fontpartnername;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontamounttext")
    private BigInteger fontamounttext;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontdaytoday")
    private BigInteger fontdaytoday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontmonthtoday")
    private BigInteger fontmonthtoday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontyeartoday")
    private BigInteger fontyeartoday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fontbanklocation")
    private BigInteger fontbanklocation;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBankaccount cBankaccountId;

    public CPromissoryformat() {
    }

    public CPromissoryformat(String cPromissoryformatId) {
        this.cPromissoryformatId = cPromissoryformatId;
    }

    public CPromissoryformat(String cPromissoryformatId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, BigInteger line1top, BigInteger line1left, BigInteger line2top, BigInteger line2left, BigInteger line3top, BigInteger line3left, BigInteger line4top, BigInteger line4left, BigInteger param11, BigInteger param12, BigInteger param13, BigInteger param31, BigInteger param32, BigInteger param41, BigInteger param42, BigInteger param43, Character printbankloc, BigInteger fontdayplanned, BigInteger fontmonthplanned, BigInteger fontyearplanned, BigInteger fontamount, BigInteger fontpartnername, BigInteger fontamounttext, BigInteger fontdaytoday, BigInteger fontmonthtoday, BigInteger fontyeartoday, BigInteger fontbanklocation) {
        this.cPromissoryformatId = cPromissoryformatId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.line1top = line1top;
        this.line1left = line1left;
        this.line2top = line2top;
        this.line2left = line2left;
        this.line3top = line3top;
        this.line3left = line3left;
        this.line4top = line4top;
        this.line4left = line4left;
        this.param11 = param11;
        this.param12 = param12;
        this.param13 = param13;
        this.param31 = param31;
        this.param32 = param32;
        this.param41 = param41;
        this.param42 = param42;
        this.param43 = param43;
        this.printbankloc = printbankloc;
        this.fontdayplanned = fontdayplanned;
        this.fontmonthplanned = fontmonthplanned;
        this.fontyearplanned = fontyearplanned;
        this.fontamount = fontamount;
        this.fontpartnername = fontpartnername;
        this.fontamounttext = fontamounttext;
        this.fontdaytoday = fontdaytoday;
        this.fontmonthtoday = fontmonthtoday;
        this.fontyeartoday = fontyeartoday;
        this.fontbanklocation = fontbanklocation;
    }

    public String getCPromissoryformatId() {
        return cPromissoryformatId;
    }

    public void setCPromissoryformatId(String cPromissoryformatId) {
        this.cPromissoryformatId = cPromissoryformatId;
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

    public BigInteger getLine1top() {
        return line1top;
    }

    public void setLine1top(BigInteger line1top) {
        this.line1top = line1top;
    }

    public BigInteger getLine1left() {
        return line1left;
    }

    public void setLine1left(BigInteger line1left) {
        this.line1left = line1left;
    }

    public BigInteger getLine2top() {
        return line2top;
    }

    public void setLine2top(BigInteger line2top) {
        this.line2top = line2top;
    }

    public BigInteger getLine2left() {
        return line2left;
    }

    public void setLine2left(BigInteger line2left) {
        this.line2left = line2left;
    }

    public BigInteger getLine3top() {
        return line3top;
    }

    public void setLine3top(BigInteger line3top) {
        this.line3top = line3top;
    }

    public BigInteger getLine3left() {
        return line3left;
    }

    public void setLine3left(BigInteger line3left) {
        this.line3left = line3left;
    }

    public BigInteger getLine4top() {
        return line4top;
    }

    public void setLine4top(BigInteger line4top) {
        this.line4top = line4top;
    }

    public BigInteger getLine4left() {
        return line4left;
    }

    public void setLine4left(BigInteger line4left) {
        this.line4left = line4left;
    }

    public BigInteger getParam11() {
        return param11;
    }

    public void setParam11(BigInteger param11) {
        this.param11 = param11;
    }

    public BigInteger getParam12() {
        return param12;
    }

    public void setParam12(BigInteger param12) {
        this.param12 = param12;
    }

    public BigInteger getParam13() {
        return param13;
    }

    public void setParam13(BigInteger param13) {
        this.param13 = param13;
    }

    public BigInteger getParam31() {
        return param31;
    }

    public void setParam31(BigInteger param31) {
        this.param31 = param31;
    }

    public BigInteger getParam32() {
        return param32;
    }

    public void setParam32(BigInteger param32) {
        this.param32 = param32;
    }

    public BigInteger getParam41() {
        return param41;
    }

    public void setParam41(BigInteger param41) {
        this.param41 = param41;
    }

    public BigInteger getParam42() {
        return param42;
    }

    public void setParam42(BigInteger param42) {
        this.param42 = param42;
    }

    public BigInteger getParam43() {
        return param43;
    }

    public void setParam43(BigInteger param43) {
        this.param43 = param43;
    }

    public Character getPrintbankloc() {
        return printbankloc;
    }

    public void setPrintbankloc(Character printbankloc) {
        this.printbankloc = printbankloc;
    }

    public BigInteger getFontdayplanned() {
        return fontdayplanned;
    }

    public void setFontdayplanned(BigInteger fontdayplanned) {
        this.fontdayplanned = fontdayplanned;
    }

    public BigInteger getFontmonthplanned() {
        return fontmonthplanned;
    }

    public void setFontmonthplanned(BigInteger fontmonthplanned) {
        this.fontmonthplanned = fontmonthplanned;
    }

    public BigInteger getFontyearplanned() {
        return fontyearplanned;
    }

    public void setFontyearplanned(BigInteger fontyearplanned) {
        this.fontyearplanned = fontyearplanned;
    }

    public BigInteger getFontamount() {
        return fontamount;
    }

    public void setFontamount(BigInteger fontamount) {
        this.fontamount = fontamount;
    }

    public BigInteger getFontpartnername() {
        return fontpartnername;
    }

    public void setFontpartnername(BigInteger fontpartnername) {
        this.fontpartnername = fontpartnername;
    }

    public BigInteger getFontamounttext() {
        return fontamounttext;
    }

    public void setFontamounttext(BigInteger fontamounttext) {
        this.fontamounttext = fontamounttext;
    }

    public BigInteger getFontdaytoday() {
        return fontdaytoday;
    }

    public void setFontdaytoday(BigInteger fontdaytoday) {
        this.fontdaytoday = fontdaytoday;
    }

    public BigInteger getFontmonthtoday() {
        return fontmonthtoday;
    }

    public void setFontmonthtoday(BigInteger fontmonthtoday) {
        this.fontmonthtoday = fontmonthtoday;
    }

    public BigInteger getFontyeartoday() {
        return fontyeartoday;
    }

    public void setFontyeartoday(BigInteger fontyeartoday) {
        this.fontyeartoday = fontyeartoday;
    }

    public BigInteger getFontbanklocation() {
        return fontbanklocation;
    }

    public void setFontbanklocation(BigInteger fontbanklocation) {
        this.fontbanklocation = fontbanklocation;
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

    public CBankaccount getCBankaccountId() {
        return cBankaccountId;
    }

    public void setCBankaccountId(CBankaccount cBankaccountId) {
        this.cBankaccountId = cBankaccountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPromissoryformatId != null ? cPromissoryformatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPromissoryformat)) {
            return false;
        }
        CPromissoryformat other = (CPromissoryformat) object;
        if ((this.cPromissoryformatId == null && other.cPromissoryformatId != null) || (this.cPromissoryformatId != null && !this.cPromissoryformatId.equals(other.cPromissoryformatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPromissoryformat[ cPromissoryformatId=" + cPromissoryformatId + " ]";
    }
    
}
