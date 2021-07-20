package com.trendsmixed.fma.module.skill;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "skill")
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SkillView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SkillView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(SkillView.Name.class)
    @Column(name = "name")
    private String name;

    public Skill(Integer id) {
        this.id = id;
    }

    @JsonView(SkillView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
