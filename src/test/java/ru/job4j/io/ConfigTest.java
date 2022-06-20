package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Alex"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutKey() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Alex"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
        assertThat(config.value("="), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWith2Keys() {
        String path = "./data/pair_with_2key.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Alex=Volkov"));
    }
}
