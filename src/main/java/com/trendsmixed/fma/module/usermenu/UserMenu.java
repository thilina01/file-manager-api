package com.trendsmixed.fma.module.usermenu;

import com.trendsmixed.fma.module.user.User;
import com.trendsmixed.fma.module.menu.Menu;
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
@Table(name = "user_menu", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "menu_id"})})
public class UserMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(UserMenuView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(UserMenuView.Menu.class)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Menu menu;
    @JsonView(UserMenuView.User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

}
