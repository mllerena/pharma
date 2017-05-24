/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ad_script_sql")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdScriptSql.findAll", query = "SELECT a FROM AdScriptSql a"),
    @NamedQuery(name = "AdScriptSql.findBySeqno", query = "SELECT a FROM AdScriptSql a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdScriptSql.findByStrsql", query = "SELECT a FROM AdScriptSql a WHERE a.strsql = :strsql")})
public class AdScriptSql implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private Long seqno;
    @Size(max = 4000)
    @Column(name = "strsql")
    private String strsql;

    public AdScriptSql() {
    }

    public AdScriptSql(Long seqno) {
        this.seqno = seqno;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public String getStrsql() {
        return strsql;
    }

    public void setStrsql(String strsql) {
        this.strsql = strsql;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqno != null ? seqno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdScriptSql)) {
            return false;
        }
        AdScriptSql other = (AdScriptSql) object;
        if ((this.seqno == null && other.seqno != null) || (this.seqno != null && !this.seqno.equals(other.seqno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdScriptSql[ seqno=" + seqno + " ]";
    }
    
}
