package jobs;

import com.google.common.base.Predicate;
import models.Geek;
import org.junit.Test;

import java.util.Set;

import static org.fest.assertions.Assertions.*;

/**
 * TODO insert class documentation here
 * @author JB
 */
public class DataLoaderTest {
    @Test
    public void shouldLoadGeeks() {
        new DataLoader().doJob();
        assertThat(DataLoader.geeks()).isNotEmpty();
        assertThat(DataLoader.geeks().get(0).getNom()).isEqualTo("Antoine");
    }
}
