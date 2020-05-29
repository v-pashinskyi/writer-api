package com.vpashynskyi.writer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/books")
class BookController (val bookRepository: BookRepository) {

    @GetMapping
    fun getBooks(): List<Book> {
        return bookRepository.findAll()
    }
}