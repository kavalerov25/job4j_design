package ru.job4j.io;

import org.junit.Test;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class ConfigTest {

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("first"), is("Arsentev"));
        assertThat(config.value("second"), is("Korobeynikov "));
    }

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("first"), is("Arsentev "));
        assertThat(config.value("second"), is(Matchers.nullValue()));
    }
}

