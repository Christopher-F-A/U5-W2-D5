package christopherfa.U5_W2_D5.repositories;

import christopherfa.U5_W2_D5.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {}