package jobs;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

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
