package wojtek.net.jpaRelations.oneToManyUni;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "student_name", length = 20 )
    private String studentName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id") // jak sie wykomentuje to tez dziala, ale tworzy sie dodatkowa tabela z ID z obu encji
    private List<BookDao> bookList;

    @Override
    public String toString(){
        return "Student = id " + id + " - studentName: " + studentName + " - book list: " +getBookList().toString();
    }


}
