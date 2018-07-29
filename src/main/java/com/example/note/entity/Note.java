package com.example.note.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author RC$
 */
@Entity
@Table(name = "NOTE")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Note implements Serializable {

    private static final long serialVersionUID = -2023965252799804172L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String body;

    @Column(name = "CREATED_TIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd @ HH:mm:ss")
    private LocalDateTime createdDate;

    @Column(name = "MODIFIED_TIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd @ HH:mm:ss")
    private LocalDateTime modifiedDate;
    
}
