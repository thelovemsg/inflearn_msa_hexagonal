package com.msa.book.framework.web;

import com.msa.book.application.usecase.AddBookUsecase;
import com.msa.book.application.usecase.InqueryUsecase;
import com.msa.book.application.usecase.MakeAvailableUsecase;
import com.msa.book.application.usecase.MakeUnavailableUsecase;
import com.msa.book.framework.web.dto.BookInfoDTO;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final AddBookUsecase addBookUsecase;
    private final InqueryUsecase inqueryUsecase;
    private final MakeAvailableUsecase makeAvailableUsecase;
    private final MakeUnavailableUsecase makeUnavailableUsecase;

    @PostMapping("/book")
    public ResponseEntity<BookOutPutDTO> createBook(@RequestBody BookInfoDTO bookInfoDTO) {
        BookOutPutDTO bookOutPutDTO = addBookUsecase.addBook(bookInfoDTO);
        return ResponseEntity.ok(bookOutPutDTO);
    }

    @GetMapping("/book/{no}")
    public ResponseEntity<BookOutPutDTO> getBook(@PathVariable("no") String bookNo) {
        BookOutPutDTO bookInfo = inqueryUsecase.getBookInfo(Long.parseLong(bookNo));
        return bookInfo != null ? new ResponseEntity<>(bookInfo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
