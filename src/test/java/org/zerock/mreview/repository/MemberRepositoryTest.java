package org.zerock.mreview.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mreview.entity.Member;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void insertMembers() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder()
                    .email("r" + i + "@zerock.org")
                    .pw("1111")
                    .nickname("reviewer" + i)
                    .build();

            memberRepository.save(member);
        });
    }

    @Transactional
    @Commit
    @Test
    void testDeleteMember() {

        Long mid = 2L;

        Member member = Member.builder().mid(mid).build();
        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);

    }


}