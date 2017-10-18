package com.trendsmixed.fma.module.mailconfiguration;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "mail_configuration")
@NamedQueries({
    @NamedQuery(name = "MailConfiguration.findAll", query = "SELECT i FROM MailConfiguration i")})
public class MailConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(MailConfigurationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(MailConfigurationView.Host.class)
    @Column(name = "host")
    private String host;
    @JsonView(MailConfigurationView.Port.class)
    @Column(name = "port")
    private String port;
    @JsonView(MailConfigurationView.User.class)
    @Column(name = "user")
    private String user;
    @JsonView(MailConfigurationView.Password.class)
    @Column(name = "password")
    private String password;

}
