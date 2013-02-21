package jobs;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Geek;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * TODO insert class documentation here
 * @author JB
 */
@OnApplicationStart
public class DataLoader extends Job<Void> {

    private static List<Geek> geeks;

    @Override
    public void doJob() {
        Type geekTypeToken = new TypeToken<List<Geek>>(){}.getType();
        DataLoader.geeks =
            new GsonBuilder().create()
                             .fromJson(new InputStreamReader(DataLoader.class.getResourceAsStream("codestory2013.json"),
                                                             StandardCharsets.UTF_8),
                                       geekTypeToken);
    }

    public static List<Geek> geeks() {
        return geeks;
    }
}
