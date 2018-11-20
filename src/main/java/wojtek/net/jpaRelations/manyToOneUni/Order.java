package wojtek.net.jpaRelations.manyToOneUni;

import org.springframework.data.jpa.repository.JpaRepository;
import wojtek.net.jpaRelations.oneToOneBiRel.CarDao;

public interface Order extends JpaRepository<OrderDao, Long> {
}
