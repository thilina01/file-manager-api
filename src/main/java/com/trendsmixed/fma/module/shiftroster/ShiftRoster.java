package com.trendsmixed.fma.module.shiftroster;

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
@Table(name = "shift_roster")
public class ShiftRoster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ShiftRosterView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ShiftRosterView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ShiftRosterView.Name.class)
    @Column(name = "name")
    private String name;

}
