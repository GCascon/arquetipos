package es.gcascon.ws.endpoint;

import org.apache.cxf.tools.fortest.classnoanno.docwrapped.AddRequest;
import org.apache.cxf.tools.fortest.classnoanno.docwrapped.AddResponse;
import org.apache.cxf.tools.fortest.classnoanno.docwrapped.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CalculatorEndpoint {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CalculatorEndpoint.class);

  @PayloadRoot(
      namespace = "http://docwrapped.classnoanno.fortest.tools.cxf.apache.org/",
      localPart = "addRequest")
  @ResponsePayload
  public AddResponse add(@RequestPayload AddRequest request) {
    LOGGER.info("Endpoint received params[a={},b={}]",
        request.getA(), request.getB());

    int result=request.getA()+request.getB();

    ObjectFactory factory = new ObjectFactory();
    AddResponse response = factory.createAddResponse();
    response.setReturn(result);

    LOGGER.info("Endpoint sending response='{}'",
        response.getReturn());
    return response;
  }
}
