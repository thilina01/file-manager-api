package com.trendsmixed.fma.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Table(name = "query")
public class Query implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
}
