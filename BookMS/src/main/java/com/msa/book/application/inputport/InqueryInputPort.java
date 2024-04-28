package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutPutPort;
import com.msa.book.application.usecase.InqueryUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InqueryInputPort implements InqueryUsecase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutPutDTO getBookInfo(long bookNo) {
        Book loadedBook = bookOutPutPort.loadBook(bookNo);
        return BookOutPutDTO.mapToDTO(loadedBook);
    }
}
