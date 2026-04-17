package christopherfa.U5_W2_D5.repositories;

import christopherfa.U5_W2_D5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> { }
