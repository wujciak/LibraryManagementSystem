package com.jwojciak.book_service.entity;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "book_details_id")
    private UUID bookDetailsId;

    @Basic
    @Column(name = "genre")
    private String genre;

    @Basic
    @Column(name = "genre")
    private String summary;

    @Basic
    @Column(name = "genre")
    private String coverImageUrl;

    @OneToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
}
