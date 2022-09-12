import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;


public class ParcingTestHW2 {
    @Test
    void test() throws Exception {
        ClassLoader classLoader = ParcingTestHW2.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("ParcingHw2.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Danger danger = objectMapper.readValue(is, Danger.class);

        assertThat(danger.getAbility()).contains("power","thunder","lightning");
        assertThat(danger.getHarm()).isEqualTo("drain a rivers");
        assertThat(danger.getWhoKill()).isEqualTo("Indra");
        assertThat(danger.getMention()).isEqualTo(32);
        assertThat(danger.getFirstInfo().getType()).isEqualTo("Dragon");
        assertThat(danger.getFirstInfo().getCountry()).isEqualTo("India");
        assertThat(danger.getFirstInfo().getSecondName()).isEqualTo("Vritra");
        assertThat(danger.getFirstInfo().getParent()).isEqualTo("Danu");

    }
}
