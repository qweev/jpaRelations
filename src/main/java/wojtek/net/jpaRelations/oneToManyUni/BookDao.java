package wojtek.net.jpaRelations.oneToManyUni;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "book")
public class BookDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "book_name", length = 20 )
    private String bookName;

    @Override
    public String toString(){
        return "book = id " + id + " - bookName: " + bookName;
    }

}
