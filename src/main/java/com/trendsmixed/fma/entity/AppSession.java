package com.trendsmixed.fma.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionView;

import lombok.Data;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@Table(name = "app_session")
public class AppSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @JsonView(AppSessionView.Email.class)
    @Column(name = "email")
    private String email;
    @JsonView(AppSessionView.Ip.class)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @JsonView(AppSessionView.LoginTimeMills.class)
    @Column(name = "login_time_mills")
    private long loginTimeMills;
    @Basic(optional = false)
    @JsonView(AppSessionView.LastTime.class)
    @Column(name = "last_time")
    private long lastTime;

    public AppSession() {
    }

    public AppSession(String email) {
        this.email = email;
    }

    public AppSession(String email, long lastTime) {
        this.email = email;
        this.lastTime = lastTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppSession)) {
            return false;
        }
        AppSession other = (AppSession) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.trendsmixed.fma.entity.AppSession[ email=" + email + " ]";
    }

}
