# spring-data-jpa-slice-issue
Example repo for https://github.com/spring-projects/spring-data-jpa/issues/1782 reproduction

Some times you want to use a Slice instead of Page to avoid the count query performed by Spring Data JPA. If you are using `JpaRepository` or `CrudRepository` bear in mind that JPA implementation of these interfaces implement `PagingAndSortingRepository` that contains the following:

`Page<T> findAll(Pageable pageable)`

...so if you are doing something like:

`Slice<T> findAll(Pageable pageable)`

It will return PageImpl instead of SliceImpl and the count query will be executed, this is because you are overriding `PagingAndSortingRepository` method and at runtime the implementation of the repository needs to satisfy the contract of `PagingAndSortingRepository` which has the signature mentioned above. You can be fooled by this. One way of solving it is changing the name a the method you want to create with Slice to something like:

`Slice<T> findAllBy(Pageable pageable)`
