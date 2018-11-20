package wojtek.net.jpaRelations.oneToOneUniRel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Item extends JpaRepository<ItemDao, Long> {
}
