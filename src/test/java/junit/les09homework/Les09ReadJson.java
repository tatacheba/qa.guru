package junit.les09homework;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import pages.components.User;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class Les09ReadJson {

    @Test
    void readJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User us = mapper.readValue(Paths.get("src/test/resources/SimpleJSON.json").toFile(), User.class);
        assertThat(us.profile.name).isEqualTo("Tatiana");
        assertThat(us.lines.depth).isEqualTo(34);
    }

}




