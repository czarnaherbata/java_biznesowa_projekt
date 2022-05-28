package com.example.forum.models;

import javax.persistence.*;
import java.sql.Date;

public class Ad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "title", nullable = true, length = -1)
    private String title;
    @Basic
    @Column(name = "content", nullable = true, length = -1)
    private String content;
    @Basic
    @Column(name = "link", nullable = true, length = -1)
    private String link;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_user_fk", referencedColumnName = "id")
    private User userByIdUserFk;
    @ManyToOne
    @JoinColumn(name = "id_category_fk", referencedColumnName = "id")
    private Category categoryByIdCategoryFk;

}
