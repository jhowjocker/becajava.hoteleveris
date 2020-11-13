package hoteleveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hoteleveris.app.model.*;

@Repository
public interface TipoQuartoRepository extends JpaRepository<TipoQuarto,Long> {

	

}
