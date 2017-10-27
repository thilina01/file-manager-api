package com.trendsmixed.fma.module.mailconfiguration;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "mail_configuration")
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
