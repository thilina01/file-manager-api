package com.trendsmixed.fma.module.contacttype;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.contact.Contact;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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
@Table(name = "contact_type")
public class ContactType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ContactTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ContactTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ContactTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "contactType")
    private List<Contact> contactList;
}
