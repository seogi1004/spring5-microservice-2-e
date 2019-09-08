package com.brownfield.pss.book.repository


import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.pss.book.entity.BookingRecord

interface BookingRepository : JpaRepository<BookingRecord, Long>
