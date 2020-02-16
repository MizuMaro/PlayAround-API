package com.playaround.playaroundapi.repository;

import com.playaround.playaroundapi.bo.UserPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryTest {

        @Autowired //<2>
        private UserRepository repository;

        @Test
        void userRepository_shouldExtendsCrudRepository() throws NoSuchMethodException {
            assertTrue(CrudRepository.class.isAssignableFrom(UserRepository.class)); //<3>
        }

        @Test
        void userRepositionryRepositoryShouldBeInstanciedBySpring(){
            assertNotNull(repository);
        }



    }
