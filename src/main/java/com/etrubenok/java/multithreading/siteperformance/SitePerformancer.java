package com.etrubenok.java.multithreading.siteperformance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

/**
 * Requests the page and returns the number of milliseconds in which the website replies
 * @author Eugene Trubenok
 */
public class SitePerformancer implements Callable<SitePerformancer.Pair> {

    private URL webPage;
    private Semaphore semaphore;

    public SitePerformancer(URL webPage) {
        this.webPage = webPage;
    }

    public SitePerformancer(URL webPage, Semaphore semaphore) {
        this.webPage = webPage;
        this.semaphore = semaphore;
    }

    @Override
    public SitePerformancer.Pair call() throws Exception {

        if ( semaphore != null )
            semaphore.acquire();

        Date start = new Date();
        URLConnection connection = webPage.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while (in.readLine() != null) {}
        in.close();
        Date finish = new Date();

        if ( semaphore != null )
            semaphore.release();

        return new SitePerformancer.Pair(webPage, finish.getTime() - start.getTime());
    }

    public URL getWebPage() {
        return webPage;
    }

    public static class Pair {
        private URL site;
        private long responseTime;

        public Pair(URL site, Long responseTime) {
            this.site = site;
            this.responseTime = responseTime;
        }

        public URL getSite() {
            return site;
        }

        public long getResponseTime() {
            return responseTime;
        }
    }
}
