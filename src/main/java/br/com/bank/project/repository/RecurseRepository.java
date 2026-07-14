package br.com.bank.project.repository;

import br.com.bank.project.entity.RecurseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurseRepository extends JpaRepository<RecurseEntity, Long> {
}
