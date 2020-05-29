package com.vpashynskyi.writer

import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Long>
interface PublisherRepository: JpaRepository<Publisher, Long>
interface PublicationRequestRepository: JpaRepository<PublicationRequest, Long>
interface PublicationRepository: JpaRepository<Publication, Long>