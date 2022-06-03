package uz.namangan.rest.service;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseCrudService<T,R extends JpaRepository<T,Long>> extends BaseService {
}
