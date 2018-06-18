package com.trendsmixed.fma.module.status;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "status")
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(StatusView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(StatusView.Name.class)
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "status")
    private List<User> userList;

    @JsonView(StatusView.All.class)
    public String getDisplay() {
        return  name;
    }
}
