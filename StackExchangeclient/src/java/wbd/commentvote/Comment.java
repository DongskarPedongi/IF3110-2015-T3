/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wbd.commentvote;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author gazandic
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
  @NamedQuery(name = "Comment.findById", query = "SELECT c FROM Comment c WHERE c.id = :id"),
  @NamedQuery(name = "Comment.findByQid", query = "SELECT c FROM Comment c WHERE c.qid = :qid"),
  @NamedQuery(name = "Comment.findByUid", query = "SELECT c FROM Comment c WHERE c.uid = :uid"),
  @NamedQuery(name = "Comment.findByDate", query = "SELECT c FROM Comment c WHERE c.date = :date")})
public class Comment implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "qid")
  private int qid;
  @Basic(optional = false)
  @NotNull
  @Column(name = "uid")
  private int uid;
  @Basic(optional = false)
  @NotNull
  @Column(name = "date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "content")
  private String content;

  public Comment() {
  }

  public Comment(Integer id) {
    this.id = id;
  }

  public Comment(Integer id, int qid, int uid, Date date, String content) {
    this.id = id;
    this.qid = qid;
    this.uid = uid;
    this.date = date;
    this.content = content;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getQid() {
    return qid;
  }

  public void setQid(int qid) {
    this.qid = qid;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Comment)) {
      return false;
    }
    Comment other = (Comment) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "wbd.commentvote.Comment[ id=" + id + " ]";
  }
  
}
