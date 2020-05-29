package com.vpashynskyi.writer

import java.time.Instant
import javax.persistence.*

@Entity
class Book(
        @Id
        val id: Long = 0,
        val title: String = "",
        @Enumerated(EnumType.STRING)
        val type: BookType = BookType.NONE,
        @Enumerated(EnumType.STRING)
        val stage: BookStage = BookStage.IDEA)

@Entity
class Publisher(
        @Id
        val id: Long = 0,
        val name: String = "")

@Entity
class PublicationRequest(
        @Id
        val id: Long = 0,
        @ManyToOne
        val book: Book = Book(),
        @ManyToOne
        val publisher: Publisher = Publisher(),
        val requestDate: Instant = Instant.now(),
        val responseDate: Instant? = null,
        val responseDescription: String? = null)

@Entity
class Publication(
        @Id
        val id: Long = 0,
        @ManyToOne
        val book: Book = Book(),
        @ManyToOne
        val publisher: Publisher = Publisher(),
        val date: Instant = Instant.now())

enum class BookType {
        PICTURE_BOOK,
        YOUNG_ADULT,
        FAIRY_TALES,
        NONE
}

enum class BookStage {
        IDEA,
        WRITING,
        REFINEMENT,
        COMPLETED,
        WAITING_PUBLICATION,
        PUBLISHED
}