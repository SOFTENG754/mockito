package example.lecture;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessengerTest2 {

	private static final String CLIENT_EMAIL = "some@auckland.ac.nz";
	private static final String MSG_CONTENT = "Dear Friend, your are late! ";

	@Mock
	Client client;
	@Mock
	Template template;
	@Mock
	MailServer mailServer;
	@Mock
	TemplateEngine templateEngine;

	@Test
	public void shouldSendEmail() {
		Messenger msg = new Messenger(mailServer, templateEngine);

		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
		when(templateEngine.prepareMessage(template, client))
				.thenReturn(MSG_CONTENT);

		msg.sendMessage(client, template);

		verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
	}
}

