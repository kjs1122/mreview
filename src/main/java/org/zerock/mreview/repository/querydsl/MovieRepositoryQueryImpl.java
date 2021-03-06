package org.zerock.mreview.repository.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.QMovie;
import org.zerock.mreview.entity.QMovieImage;
import org.zerock.mreview.entity.QReview;

import javax.persistence.criteria.From;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class MovieRepositoryQueryImpl extends QuerydslRepositorySupport implements MovieRepositoryQuery{

    public MovieRepositoryQueryImpl(Class<?> domainClass) {
        super(Movie.class);
    }

//    @Override
//    public Page<Object[]> listPage(Pageable pageable) {
//
//        QMovie movie = QMovie.movie;
//        QReview review = QReview.review;
//        QMovieImage movieImage = QMovieImage.movieImage;
//
//        JPQLQuery<Movie> jpqlQuery = from(movie);
//        jpqlQuery.leftJoin(movieImage).on(movieImage.movie.eq(movie));
//        jpqlQuery.leftJoin(review).on(review.movie.eq(movie));
//
//        JPQLQuery<Tuple> tuple = jpqlQuery.select(movie, movieImage, review.grade.avg(), review.countDistinct());
//
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//        BooleanExpression expression = movie.mno.gt(0L);
//        booleanBuilder.and(expression);
//
//        tuple.where(booleanBuilder);
//
//        Sort sort = pageable.getSort();
//
//        sort.stream().forEach(order -> {
//            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
//            String prop = order.getProperty();
//
//            PathBuilder orderExpression = new PathBuilder(Movie.class, "movie");
//
//            tuple.orderBy(new OrderSpecifier<>(direction, orderExpression.get(prop)));
//        });
//
//        tuple.groupBy(movie);
//
//        tuple.offset(pageable.getOffset());
//        tuple.limit(pageable.getPageSize());
//
//        List<Tuple> result = tuple.fetch();
//        log.info(result);
//
//
//        return new PageImpl<Object[]>(result.stream().map(t -> t.toArray()).collect(Collectors.toList()));
//    }
}
