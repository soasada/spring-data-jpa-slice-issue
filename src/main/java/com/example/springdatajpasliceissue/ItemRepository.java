package com.example.springdatajpasliceissue;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * The CrudRepository JPA implementation is SimpleJpaRepository and implements PagingAndSortingRepository which
 * contains a 'Page<T> findAll(Pageable pageable)' method. I was trying to re-implement the method with different
 * signature but the implementation must be compliant with the PagingAndSortingRepository interface that was returning a
 * PageImpl instead of a SliceImpl.
 *
 * A possible workaround is create a query method that is called differently from the findAll signature, for example: findAllBy
 */
public interface ItemRepository extends CrudRepository<Item, UUID> {
    Slice<Item> findAllBy(Pageable pageable);
}
