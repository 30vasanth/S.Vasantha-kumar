package net.cerditcardmanagement.springboot.repository;

import net.cerditcardmanagement.springboot.model.Cardtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardtypeRepository extends JpaRepository<Cardtype, Integer> {

}
