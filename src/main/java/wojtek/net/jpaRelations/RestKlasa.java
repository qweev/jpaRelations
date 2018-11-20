package wojtek.net.jpaRelations;



import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import wojtek.net.jpaRelations.manyToMany.Grupa;
import wojtek.net.jpaRelations.manyToMany.GrupaDao;
import wojtek.net.jpaRelations.manyToMany.Person;
import wojtek.net.jpaRelations.manyToMany.PersonDao;
import wojtek.net.jpaRelations.manyToOneUni.Order;
import wojtek.net.jpaRelations.manyToOneUni.Product;
import wojtek.net.jpaRelations.manyToOneUni.OrderDao;
import wojtek.net.jpaRelations.manyToOneUni.ProductDao;
import wojtek.net.jpaRelations.oneToManyBi.Comment;
import wojtek.net.jpaRelations.oneToManyBi.CommentDao;
import wojtek.net.jpaRelations.oneToManyBi.Post;
import wojtek.net.jpaRelations.oneToManyBi.PostDao;
import wojtek.net.jpaRelations.oneToManyUni.Student;
import wojtek.net.jpaRelations.oneToManyUni.StudentDao;
import wojtek.net.jpaRelations.oneToManyUni.Book;
import wojtek.net.jpaRelations.oneToManyUni.BookDao;
import wojtek.net.jpaRelations.oneToOneBiRel.Car;
import wojtek.net.jpaRelations.oneToOneBiRel.CarDao;
import wojtek.net.jpaRelations.oneToOneBiRel.Engine;
import wojtek.net.jpaRelations.oneToOneBiRel.EngineDao;
import wojtek.net.jpaRelations.oneToOneUniRel.Item;
import wojtek.net.jpaRelations.oneToOneUniRel.ItemDao;
import wojtek.net.jpaRelations.oneToOneUniRel.User;
import wojtek.net.jpaRelations.oneToOneUniRel.UserDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class RestKlasa {

    @Autowired
    Item item;
    @Autowired
    User user;

    @Autowired
    Car car;
    @Autowired
    Engine engine;

    @Autowired
    Product product;
    @Autowired
    Order order;

    @Autowired
    Book book;
    @Autowired
    Student student;

    @Autowired
    Post post;
    @Autowired
    Comment comment;

    @Autowired
    Grupa grupa;
    @Autowired
    Person person;

   Logger logger = LoggerFactory.getLogger(RestKlasa.class);

    @GetMapping("/oneToOneUni")
    public ResponseEntity<String> oneToOneUnidirectionalRelation(){

        ItemDao itemDao = new ItemDao();
        itemDao.setItemName("new item");
        itemDao.setQuantity(44);
        item.save(itemDao);

        UserDao userDao = new UserDao();
        userDao.setFullName("new full user");
        userDao.setName("nfu");
        userDao.setItemDao(itemDao);
        user.save(userDao);

        UserDao u = user.findById(4L).get();

//        System.out.println(u.toString());
        logger.info(u.toString());

        return ResponseEntity.status(HttpStatus.OK).body("jpa oneToOneUni == " + u.toString());
    }


    @GetMapping("/oneToOneBi")
    public ResponseEntity<String> oneToOneBidirectionalRelation(){

        CarDao carDao = new CarDao();
        carDao.setCarName("skoda");

        EngineDao engineDao = new EngineDao();
        engineDao.setEngineName("TSI");

        carDao.setEngineDao(engineDao);
        engineDao.setCarDaoRel(carDao);

        car.save(carDao);
        engine.save(engineDao);

        CarDao c = car.findById(1L).get();

        logger.info(c.toString());

        return ResponseEntity.status(HttpStatus.OK).body("jpa oneToOneBi == " + c.toString());
    }

    @GetMapping("/manyToOneUni")
    public ResponseEntity<String> manyToOneUnidirectionalRelation(){

        ProductDao productDao = new ProductDao();
        productDao.setProductName("jakis produkt");

        OrderDao orderDao1 = new OrderDao();
        orderDao1.setOrderName("order 1 jakis");
        orderDao1.setProduct(productDao);
        order.save(orderDao1);

        OrderDao orderDao2 = new OrderDao();
        orderDao2.setOrderName("order 2 jakis");
        orderDao2.setProduct(productDao);
        order.save(orderDao2);

        OrderDao o1 = order.findById(1L).get();
        OrderDao o2 = order.findById(2L).get();

        logger.info(o1.toString());
        logger.info(o2.toString());

        return ResponseEntity.status(HttpStatus.OK).body("jpa manyToOne == " + o1.toString() + " ||| " + o2.toString());
    }

    @GetMapping("/oneToManyUni")
    public ResponseEntity<String> oneToManyUnidirectionalRelation(){

        // nie musimy zapisywac encji book bo mamy SASCADE.ALL
        BookDao book1 = new BookDao();
        book1.setBookName("pierwszy");
        BookDao book2 = new BookDao();
        book2.setBookName("drugi");
        BookDao book3 = new BookDao();
        book3.setBookName("trzeci");
        BookDao book4 = new BookDao();
        book4.setBookName("czwarty");
        List<BookDao> list1 = new ArrayList<>();
        list1.add(book1);
        list1.add(book2);
        List<BookDao> list2 = new ArrayList<>();
        list2.add(book3);
        list2.add(book4);

        StudentDao studencik1 =  new StudentDao();
        studencik1.setStudentName("debil");
        studencik1.setBookList(list1);
        student.save(studencik1);

        StudentDao studencik2 =  new StudentDao();
        studencik2.setStudentName("cwel");
        studencik2.setBookList(list2);
        student.save(studencik2);
        student.flush();

        StudentDao s1 = student.findById(1L).get();
        StudentDao s2 = student.findById(2L).get();

        logger.info(s1.toString() + " || " +  s1.getBookList().toString());
        logger.info(s2.toString() + " || " +  s2.getBookList().toString());

        BookDao b = book.findById(1L).get();
        logger.info("pobrany book z bazy: " + b.toString());

        return ResponseEntity.status(HttpStatus.OK).body("jpa oneToMany == " + s1.toString() +  "||| \n"  + s2.toString() );
    }

    @GetMapping("/oneToManyBi")
    public ResponseEntity<String> oneToManyBidirectionalRelation(){

        // nie musimy zapisywac obu encji, wystarczy ze zapiszemy parenta a child sie sam juz zapisze bo mamy CASCADE.ALL
        // pamietaj aby przypisywac obiekty do kazdej ze stron relacji
        CommentDao commentDao1 = new CommentDao();
        commentDao1.setCommmentValue("commment 1");
        CommentDao commentDao2 = new CommentDao();
        commentDao2.setCommmentValue("commment 2");
        CommentDao commentDao3 = new CommentDao();
        commentDao3.setCommmentValue("commment 3");
        CommentDao commentDao4 = new CommentDao();
        commentDao4.setCommmentValue("commment 4");

        List<CommentDao> commentList1 = new ArrayList<>();
        commentList1.add(commentDao1);
        commentList1.add(commentDao2);
        List<CommentDao> commentList2 = new ArrayList<>();
        commentList2.add(commentDao3);
        commentList2.add(commentDao4);

        PostDao postDao1 = new PostDao();
        postDao1.setPostValue("jakis 1 post");
        postDao1.setCommentDaoList(commentList1);
        PostDao postDao2 = new PostDao();
        postDao2.setPostValue("jakis 2 post");
        postDao2.setCommentDaoList(commentList2);

        commentDao1.setPostDaoRel(postDao1);
        commentDao2.setPostDaoRel(postDao1);
        commentDao3.setPostDaoRel(postDao2);
        commentDao4.setPostDaoRel(postDao2);

        post.save(postDao1);
        post.save(postDao2);
        post.flush();

        PostDao p1 = post.findById(1L).get();
        PostDao p2 = post.findById(2L).get();


        logger.info(p1.toString() + " || \n" +  p1.getCommentDaoList().toString());
        logger.info(p2.toString() + " || \n" +  p2.getCommentDaoList().toString());

        CommentDao c = comment.findById(1L).get();
        logger.info("COMMENT " + c.toString());

        return ResponseEntity.status(HttpStatus.OK).body("jpa oneToMany == " + p1.toString() + "   comments list "
                + p1.getCommentDaoList().toString() + " ||| \n " + p2.toString() + "   comments list "
                + p2.getCommentDaoList().toString());
    }

    @GetMapping("/ManyToManyBi")
    public ResponseEntity<String> manyToManyBidirectionalRelation() {

        PersonDao p1 = new PersonDao();
        p1.setPersonName("pp 11");
        PersonDao p2 = new PersonDao();
        p2.setPersonName("pp 22");
        List<PersonDao> listaP1 = new ArrayList<>();
        listaP1.add(p1);
        listaP1.add(p2);

        PersonDao p3 = new PersonDao();
        p3.setPersonName("pp 33");
        PersonDao p4 = new PersonDao();
        p4.setPersonName("pp 44");
        List<PersonDao> listaP2 = new ArrayList<>();
        listaP2.add(p3);
        listaP2.add(p4);
        listaP2.add(p1);

        GrupaDao g1 = new GrupaDao();
        g1.setGrupaName("gg 11");
        g1.setPersons(listaP1);

        GrupaDao g2 = new GrupaDao();
        g2.setGrupaName("gg 22");
        g2.setPersons(listaP2);

        grupa.save(g1);
        grupa.save(g2);

        List<GrupaDao> listaG1 = new ArrayList<>();
        listaG1.add(g1);
        listaG1.add(g2);

        p1.setGrupyDao(listaG1);
        person.save(p1);

        return ResponseEntity.status(HttpStatus.OK).body("DRUKUJ GRUPA= " + g1.toString() + " showPersons " + g1.showPersons() +
                " ||| DRUKUJ PERSONS= " + p1.toString() + " showGroups " + p1.showGruops() );
    }

    }
