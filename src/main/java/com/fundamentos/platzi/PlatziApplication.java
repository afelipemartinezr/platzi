package com.fundamentos.platzi;

import com.fundamentos.platzi.bean.MyBean;
import com.fundamentos.platzi.bean.MyBeanWhitDependency;
import com.fundamentos.platzi.bean.MybeanWithProperties;
import com.fundamentos.platzi.bean.MybeanWithPropertiesImplement;
import com.fundamentos.platzi.component.ComponentDependency;
import com.fundamentos.platzi.entity.User;
import com.fundamentos.platzi.pojo.UserPojo;
import com.fundamentos.platzi.repository.UserRepository;
import com.fundamentos.platzi.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PlatziApplication implements CommandLineRunner {

    Log LOGGER = LogFactory.getLog(PlatziApplication.class);
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWhitDependency myBeanWhitDependency;
    private MybeanWithProperties mybeanWithProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;
    private UserService userService;

    public PlatziApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency, MyBean myBean, MyBeanWhitDependency myBeanWhitDependency, MybeanWithProperties mybeanWithProperties, UserPojo userPojo, UserRepository userRepository, UserService userService) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWhitDependency = myBeanWhitDependency;
        this.mybeanWithProperties = mybeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PlatziApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //previousExample();
        saveUserInDataBase();
        //getInformationJplFromUser();
        //saveWithErrorTransactional();

    }

    private void saveWithErrorTransactional(){
        User user1 = new User("Transaction1", "Transaction1@gmail.com", LocalDate.of(2021,12,24));
        User user2 = new User("Transaction2", "Transaction2@gmail.com", LocalDate.of(2021,12,24));
        User user3 = new User("Transaction3", "Transaction1@gmail.com", LocalDate.of(2021,12,24));
        User user4 = new User("Transaction4", "Transaction4@gmail.com", LocalDate.of(2021,12,24));

        List<User> users = Arrays.asList(user1,user2,user3,user4);
        try {
            userService.saveTransactional(users);
        }catch (Exception e){
            LOGGER.info("Hay un error en el metodo transactional : " + e );
        }
        userService.getAllUsers().stream().forEach(user -> LOGGER.info("Metodo Transactional:" + user));

    }

    private void getInformationJplFromUser() {

        System.out.println("IMPRESIONES ACA");

        // LOGGER.info("El usuario:" + userRepository.findByUserEmail("Juan@gmail.com").orElseThrow(() -> new RuntimeException("no se encontro")));

       // userRepository.findAndSort("Ju", Sort.by("id").descending()).stream().forEach(user -> LOGGER.info("User with method fin and sort" + user));

       //userRepository.findByName("Juan").stream().forEach(user -> LOGGER.info("Query Method 1: findByName " + user));

       //LOGGER.info( "Query Method 2: findByNameAndEmail " + userRepository.findByNameAndEmail("Felipe", "Felipe@gmail.com").toString());

       //userRepository.findByNameLike("%J%").stream().forEach(user -> LOGGER.info("findByNameLike" + user));

      //userRepository.findByNameOrEmail("Juan","Nadia@gmail.com").stream().forEach(user -> LOGGER.info("findByNameOrEmail" + user));

        // userRepository.findByBirthDateBetween(LocalDate.of(2021,12,25),LocalDate.of(2022,12,25)).stream().forEach(user -> LOGGER.info("findByBirthDateBetween" + user));

        //userRepository.findByNameLikeOrderByIdDesc("%J%").stream().forEach(user -> LOGGER.info("findByNameLikeOrderByIdDesc" + user));

        //userRepository.findByNameContainingOrderByIdDesc("i").stream().forEach(user -> LOGGER.info("findByNameLikeOrderByIdDesc" + user));

        LOGGER.info( "Query Method 2: findByNameAndEmail " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021,12,24),"Sebastian@gmail.com").orElseThrow(
                () -> new RuntimeException("no se encontro"))
        );



    }

    private void saveUserInDataBase() {
        User user = new User("Andres", "Andres@gmail.com", LocalDate.of(2021,12,24));
        User user2 = new User("Felipe", "Felipe@gmail.com", LocalDate.of(2021,12,24));
        User user3 = new User("Juan", "Juan@gmail.com", LocalDate.of(2021,12,24));
        User user4 = new User("Juan Sebastian", "Sebastian@gmail.com", LocalDate.of(2021,12,24));
        User user5 = new User("Nadia", "Nadia@gmail.com", LocalDate.of(2021,12,24));
        User user6 = new User("Monica", "Monica@gmail.com", LocalDate.now());
        User user7 = new User("Camilo", "Camilo@gmail.com", LocalDate.now());
        User user8 = new User("Lorena", "Lorena@gmail.com", LocalDate.now());

        List<User> users = Arrays.asList(user, user2, user3, user4, user5, user6, user7, user8);

        users.stream().forEach(userRepository::save);
    }

    private void previousExample() {
        componentDependency.saludar();
        myBean.print();
        myBeanWhitDependency.printWhitDependency();
        System.out.println(mybeanWithProperties.function());
        System.out.println(userPojo.getEmail() + "" + userPojo.getAge() + " " + userPojo.getPassword());
        try {
            int number = 10 / 0;
            LOGGER.debug("Mi valor es" + number);
            //
        } catch (Exception e) {
            LOGGER.error("Esto es un error " + e + "------" + e.getMessage() + "----" + e.getStackTrace());
        }
    }
}