package wojtek.net.jpaRelations.oneToManyUni;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Book extends JpaRepository<BookDao, Long> {
}
