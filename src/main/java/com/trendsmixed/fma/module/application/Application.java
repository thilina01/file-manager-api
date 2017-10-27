package com.trendsmixed.fma.module.application;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.*;
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
@Table(name = "application")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ApplicationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ApplicationView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ApplicationView.Name.class)
    @Column(name = "name", unique = true)
    private String name;
    @JsonView(ApplicationView.ShortName.class)
    @Column(name = "short_name", unique = true)
    private String shortName;

}
