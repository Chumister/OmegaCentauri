package NASA.OmegaCentauri;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OmegaCentauriApplicationTests {

	private OmegaCentauriApplication omega;

	@BeforeEach
	void setUp() {
		omega = new OmegaCentauriApplication();
	}

	@Test
	void whenHome_thenReturnRedirect() {
		//given
		String expected = "redirect:swagger-ui.html";

		//when
		String actual = omega.toString();

		//then
		assertEquals(expected, actual);
	}
}
