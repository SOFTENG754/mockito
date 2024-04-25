package example.lecture;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MessengerTest {
	private static final String CLIENT_EMAIL = "some@auckland.ac.nz";
	private static final String MSG_CONTENT = "Dear Friend, your are late! ";

	@Test
	public void shouldSendEmail() {
		Template template = mock(Template.class);
		Client client = Mockito.mock(Client.class);
		MailServer mailServer = mock(MailServer.class);
		TemplateEngine templateEngine = mock(TemplateEngine.class);

		Messenger sut = new Messenger(mailServer, templateEngine);

		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
		when(templateEngine.prepareMessage(template, client))
				.thenReturn(MSG_CONTENT);

		sut.sendMessage(client, template);

		Mockito.verify(mailServer, times(1)).send(CLIENT_EMAIL, MSG_CONTENT);
	}
}

