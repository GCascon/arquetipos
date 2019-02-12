package com.gcascon.calculatorClient;

import com.gcascon.generated.ws.AddRequest;
import com.gcascon.generated.ws.AddResponse;
import com.gcascon.generated.ws.Calculator;
import com.gcascon.generated.ws.CalculatorPortType;
import com.gcascon.generated.ws.ObjectFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Calculator service=new Calculator();
    	CalculatorPortType port=service.getCalculatorPort();
    	
    	AddRequest request=new AddRequest();
    	request.setA(3);
    	request.setB(2);
    	AddResponse resp=port.add(request);
    	
    	System.out.println( "Response="+resp.getReturn() );
    }
}
