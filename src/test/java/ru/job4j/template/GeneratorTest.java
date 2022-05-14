package ru.job4j.template;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Ignore
    @Test
    public void produce() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String rsl = generator.produce(template, map);
        assertThat(rsl, Matchers.is("I am a Petr Arsentev, Who are you?"));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNoSubjectKey() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        generator.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenExcessKeys() {
        Generator generator = new GeneratorImpl();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        generator.produce("I am a ${name}", map);
    }
}