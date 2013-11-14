package com.etrubenok.java;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene
 * Date: 16.10.13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public class LanguageChecks {
    public int overload(int i1) throws IOException {
        if ( i1 > 100 )
            throw new IOException("i1 more than 100");
        return i1;
    }

    public int overload(int i1, int i2) throws Exception, HTTPException {

        if ( i2 > 100 )
            throw new Exception("i2 more than 100");
        int r = i1*i2;
        i1=5;
        return r;
    }


   public AtomicInteger multiply(AtomicInteger i1, AtomicInteger i2) {

       AtomicInteger r = new AtomicInteger(i1.get() * i2.get());
       i1.set(5);
       return r;
   }
}
