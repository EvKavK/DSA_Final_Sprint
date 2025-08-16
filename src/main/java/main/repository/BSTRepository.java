package main.repository;

import main.entity.BSTResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BSTRepository extends JpaRepository<BSTResult, Long> {
}