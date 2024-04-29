package com.msa.bestbookms.persistence;

import com.msa.bestbookms.domain.model.BestBook;
import com.msa.bestbookms.domain.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestBookRepository extends MongoRepository<BestBook, String> {
    BestBook findBestBookByItem(Item item);
}
