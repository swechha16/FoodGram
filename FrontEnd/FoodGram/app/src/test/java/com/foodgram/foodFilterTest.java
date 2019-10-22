package com.foodgram;
import android.widget.Button;

import junit.framework.Assert;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class foodFilterTest {

  @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Test
    public void getLinkTest_returnsTrue() throws JSONException{

    //create an instance (mock) of filteredFoodFeed without full implementation
      LinkHandler test = mock(LinkHandler.class);
      FilteredFoodFeed testLink = new FilteredFoodFeed();
    //expected
      String urlCorrect = "italian";
      String priceCorrect = "$";
// create json object to test
      JSONObject link = new JSONObject();
//retrieval is a success
      link.put("linkSuccess", new Boolean(true));



      when(test.getLink(urlCorrect, priceCorrect)).thenReturn(link);
      Assert.assertEquals(testLink.tryRecieving(urlCorrect,priceCorrect,test),link.getBoolean("linkSuccess"));
  }


}
