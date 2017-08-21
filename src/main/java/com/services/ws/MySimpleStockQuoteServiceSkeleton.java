package com.services.ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.services.model.Symbol;

import samples.services.GetFullQuoteDocument;
import samples.services.GetFullQuoteResponseDocument;
import samples.services.GetMarketActivityDocument;
import samples.services.GetMarketActivityResponseDocument;
import samples.services.GetQuoteDocument;
import samples.services.GetQuoteResponseDocument;
import samples.services.GetQuoteResponseDocument.GetQuoteResponse;
import samples.services.GetSimpleQuoteDocument;
import samples.services.GetSimpleQuoteResponseDocument;
import samples.services.PlaceOrderDocument;

public class MySimpleStockQuoteServiceSkeleton implements
		SimpleStockQuoteServiceSkeletonInterface {
	
	private static List<Symbol> symbol=new ArrayList<Symbol>();
	
	static
	{
		symbol.add(new Symbol("IBM"));
		symbol.add(new Symbol("WSO2"));
	}

	public GetQuoteResponseDocument getQuote(GetQuoteDocument getQuote)
			throws SimpleStockQuoteServiceExceptionException {
		String quoteSymbol=getQuote.getGetQuote().getRequest().getSymbol();
		
		Collection<samples.services.xsd.GetQuote> result = new ArrayList<samples.services.xsd.GetQuote>();
		
		if(quoteSymbol != null && !quoteSymbol.isEmpty())
		{
			synchronized (SimpleStockQuoteServiceSkeleton.class) {
				
				for(Symbol sy : symbol)
				{
					if(sy.getSymbol().equals(quoteSymbol))
					{
						samples.services.xsd.GetQuote getquote = samples.services.xsd.GetQuote.Factory.newInstance();
						
						getquote.setSymbol(sy.getSymbol());
						
						result.add(getquote);
						
						
					}
				}
			}
		}
		
		GetQuoteResponseDocument responseDocument = GetQuoteResponseDocument.Factory.newInstance();
		
		GetQuoteResponse response = GetQuoteResponse.Factory.newInstance();
		
		//response.set//(result.toArray(new samples.services.xsd.GetQuote[result.size()]));
	
		responseDocument.setGetQuoteResponse(response);
		
		return responseDocument;
	
	}
	

	public GetSimpleQuoteResponseDocument getSimpleQuote(
			GetSimpleQuoteDocument getSimpleQuote) {
		// TODO Auto-generated method stub
		return null;
	}

	public GetMarketActivityResponseDocument getMarketActivity(
			GetMarketActivityDocument getMarketActivity) {
		// TODO Auto-generated method stub
		return null;
	}

	public GetFullQuoteResponseDocument getFullQuote(
			GetFullQuoteDocument getFullQuote) {
		// TODO Auto-generated method stub
		return null;
	}

	public void placeOrder(PlaceOrderDocument placeOrder) {
		// TODO Auto-generated method stub

	}

}
