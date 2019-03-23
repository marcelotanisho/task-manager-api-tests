package APITests;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

public class UserTests {
	
	@Test
	public void getUser() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://172.16.14.103/vanhack/api/User");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void getNonExistingUser() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://172.16.14.103/vanhack/api/User/asd");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
	}
	
}
