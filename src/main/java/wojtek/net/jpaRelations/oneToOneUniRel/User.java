package wojtek.net.jpaRelations.oneToOneUniRel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface User extends JpaRepository<UserDao, Long> {
}
