
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sinbugs.rest.controller.RestApi;
import com.sinbugs.rest.service.ApiService;

public class ResApiControllerUnitTest {
	
	private RestApi controller;
    private ApiService restService;

    @Before
    public void setUp() {
    	restService = Mockito.mock(ApiService.class);
        controller = new RestApi(restService);
    }

    @Test
    public void itShouldReturnTheServiceValueWith200StatusCode() throws MalformedURLException, IOException {
        Mockito.when(restService.api_retorna()).thenReturn("TODO OK");
        ResponseEntity<String> httpResponse = controller.retorna_api();

        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals("TODO OK", httpResponse.getBody());
    }

}
