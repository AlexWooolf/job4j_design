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
        assertThat(config.value("surname"), is("Volkov="));
        assertThat(config.value("class"), is(Matchers.nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutKey() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test
    public void whenPairWith2Keys() {
        String path = "./data/pair_with_2key.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Alex=Volkov"));
        assertThat(config.value("surname"), is("Volkov"));
    }

    @Test
    public void whenEmptyLine() {
        String path = "./data/pair_with_emptyLines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Alex"));
    }
}
