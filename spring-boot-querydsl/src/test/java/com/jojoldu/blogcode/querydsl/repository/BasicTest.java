package com.jojoldu.blogcode.querydsl.repository;

import com.jojoldu.blogcode.querydsl.domain.academy.Academy;
import com.jojoldu.blogcode.querydsl.domain.academy.AcademyQueryRepository;
import com.jojoldu.blogcode.querydsl.domain.academy.AcademyRepository;
import com.jojoldu.blogcode.querydsl.domain.academy.AcademyRepositorySupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by jojoldu@gmail.com on 2018-12-29
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BasicTest {
    
    @Autowired
    private AcademyRepository academyRepository;
    
    @Autowired
    private AcademyRepositorySupport academyRepositorySupport;

    @Autowired
    private AcademyQueryRepository academyQueryRepository;

    @AfterEach
    public void tearDown() throws Exception {
        academyRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_기본_기능_확인() {
        //given
        String name = "jojoldu";
        String address = "jojoldu@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyRepositorySupport.findByName(name);

        //then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getAddress()).isEqualTo(address);
    }

    @Test
    public void querydsl_기본_기능_확인2() {
        //given
        String name = "jojoldu";
        String address = "jojoldu@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyQueryRepository.findByName(name);

        //then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getAddress()).isEqualTo(address);
    }
}
