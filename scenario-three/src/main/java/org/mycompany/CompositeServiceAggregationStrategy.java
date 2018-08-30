package org.mycompany;

import java.util.ArrayList;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class CompositeServiceAggregationStrategy implements AggregationStrategy, CamelContextAware {

	private CamelContext camelContext;

	@Override
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	@Override
	public CamelContext getCamelContext() {
		return camelContext;
	}


    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
 	    Object newBody = newExchange.getIn().getBody();
     	ArrayList<Object> list = null;
         if (oldExchange == null) {
 		    list = new ArrayList<Object>();
 		    list.add(newBody);
 		    newExchange.getIn().setBody(list);
 		    return newExchange;
         } else {
 	        list = oldExchange.getIn().getBody(ArrayList.class);
 	    	list.add(newBody);
 		    return oldExchange;
 	    }
     }
 }
