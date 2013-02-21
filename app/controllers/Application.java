package controllers;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import jobs.DataLoader;
import models.Geek;
import play.mvc.Controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void like(String q) {
        Set<String> likes = splitQuestion(q);
        List<Geek> geeks = findGeeksByLike(DataLoader.geeks(), likes);
        render("geeks.html", geeks);
    }

    public static void hate(String q) {
        Set<String> hates = splitQuestion(q);
        List<Geek> geeks = findGeeksByHate(DataLoader.geeks(), hates);
        render("geeks.html", geeks);
    }

    protected static List<Geek> findGeeksByLike(List<Geek> geeks, Set<String> likes) {
        return FluentIterable.from(geeks)
                             .filter(new LikePredicate(likes))
                             .toList();
    }

    protected static List<Geek> findGeeksByHate(List<Geek> geeks, Set<String> hates) {
        return FluentIterable.from(geeks)
                             .filter(new HatePredicate(hates))
                             .toList();
    }

    protected static Set<String> splitQuestion(String question) {
        return new HashSet<String>(Arrays.asList(question.split("\\s")));
    }

    private static class LikePredicate implements Predicate<Geek> {
        private final Set<String> likes;

        private LikePredicate(Set<String> likes) {
            this.likes = likes;
        }

        @Override
        public boolean apply(Geek geek) {
            return this.likes.contains(geek.getLike1())
                   || this.likes.contains(geek.getLike2())
                   || this.likes.contains(geek.getLike3());
        }
    }

    private static class HatePredicate implements Predicate<Geek> {
        private final Set<String> hates;

        private HatePredicate(Set<String> hates) {
            this.hates = hates;
        }

        @Override
        public boolean apply(Geek geek) {
            return this.hates.contains(geek.getHate1())
                   || this.hates.contains(geek.getHate2());
        }
    }
}