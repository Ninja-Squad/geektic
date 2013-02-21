package controllers;

import com.google.common.collect.Sets;
import models.Geek;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.*;

/**
 * TODO insert class documentation here
 * @author JB
 */
public class ApplicationUnitTest {

    private Geek likesJavaAndHateRuby;
    private Geek likesRubyAndHateJava;
    private List<Geek> geeks;

    @Before
    public void setUp() {
        likesJavaAndHateRuby = new Geek();
        likesJavaAndHateRuby.setLike1("Java");
        likesJavaAndHateRuby.setHate2("ruby");

        likesRubyAndHateJava = new Geek();
        likesRubyAndHateJava.setLike2("Ruby");
        likesRubyAndHateJava.setHate1("java");

        geeks = Arrays.asList(likesJavaAndHateRuby, likesRubyAndHateJava);
    }

    @Test
    public void splitQuestionShouldSplit() {
        String q = "Java Lambda";
        assertThat(Application.splitQuestion(q)).isEqualTo(Sets.newHashSet("java", "lambda"));
    }

    @Test
    public void findGeeksByLike() {
        assertThat(Application.findGeeksByLike(geeks, Sets.newHashSet("java", "fortran")))
            .containsExactly(likesJavaAndHateRuby);
    }

    @Test
    public void findGeeksByHate() {
        assertThat(Application.findGeeksByHate(geeks, Sets.newHashSet("java", "fortran")))
            .containsExactly(likesRubyAndHateJava);
    }
}
