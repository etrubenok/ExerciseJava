package javaTest.multithreading.siteperformance;


import com.etrubenok.java.multithreading.siteperformance.SitePerformancer;
import org.junit.Test;

import java.net.URL;
import java.util.*;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene
 * Date: 14.11.13
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public class SitePerformancerTest {

    @Test
    public void requestGoogleCom() throws Exception {
        FutureTask<SitePerformancer.Pair> futureTask = new FutureTask<SitePerformancer.Pair>(new SitePerformancer(new URL("http://www.google.com")));
        futureTask.run();
        System.out.println((new Date()).toString() + ": requestGoogleCom : Google.com replied in " + futureTask.get().getResponseTime() + " ms");
    }

    /**
     * Have a drawback which is that it may print the results only after the longest response is received
     * @throws Exception
     */
    @Test
    public void requestCollectionOfWebsites() throws Exception {
        List<SitePerformancer> sites = new ArrayList<SitePerformancer>();
        sites.add(new SitePerformancer(new URL("http://www.google.com")));
        sites.add(new SitePerformancer(new URL("http://www.yandex.ru")));
        sites.add(new SitePerformancer(new URL("http://www.mail.ru")));
        sites.add(new SitePerformancer(new URL("http://www.gmail.com")));
        sites.add(new SitePerformancer(new URL("http://www.bing.com")));
        sites.add(new SitePerformancer(new URL("http://www.yahoo.com")));
        sites.add(new SitePerformancer(new URL("http://www.microsoft.com")));

        List<Future<SitePerformancer.Pair>> results = new ArrayList<Future<SitePerformancer.Pair>>();
        Date start = new Date();
        for ( SitePerformancer site : sites ) {
            FutureTask<SitePerformancer.Pair> futureTask = new FutureTask<SitePerformancer.Pair>(site);
            futureTask.run();
            results.add(futureTask);
        }

        for ( Future<SitePerformancer.Pair> result : results ) {
            System.out.println((new Date()).toString() + ": requestCollectionOfWebsites :" + result.get().getSite() + " replied in " + result.get().getResponseTime() + " ms");
        }
        Date finish = new Date();
        System.out.println((new Date()).toString() + ": requestCollectionOfWebsites : time = " + ( finish.getTime() - start.getTime() ));
    }

    @Test
    public void requestCollectionOfWebsitesViaCompleteionService() throws Exception {
        List<SitePerformancer> sites = new ArrayList<SitePerformancer>();
        sites.add(new SitePerformancer(new URL("http://www.google.com")));
        sites.add(new SitePerformancer(new URL("http://www.yandex.ru")));
        sites.add(new SitePerformancer(new URL("http://www.mail.ru")));
        sites.add(new SitePerformancer(new URL("http://www.gmail.com")));
        sites.add(new SitePerformancer(new URL("http://www.bing.com")));
        sites.add(new SitePerformancer(new URL("http://www.yahoo.com")));
        sites.add(new SitePerformancer(new URL("http://www.microsoft.com")));

        Executor executor = Executors.newCachedThreadPool();
        ExecutorCompletionService<SitePerformancer.Pair> service = new ExecutorCompletionService<SitePerformancer.Pair>(executor);

        Date start = new Date();
        for ( SitePerformancer site : sites ) {
            service.submit(site);
        }

        List<SitePerformancer.Pair> results = new ArrayList<SitePerformancer.Pair>();

        for ( int i = 0; i < sites.size(); i++ ) {
            Future<SitePerformancer.Pair> result = service.take();
            results.add(result.get());

            System.out.println((new Date()).toString() + ": requestCollectionOfWebsitesViaCompleteionService :" + result.get().getSite() + " replied in " + result.get().getResponseTime() + " ms");

        }

        Date finish = new Date();

        System.out.println((new Date()).toString() + ": requestCollectionOfWebsitesViaCompleteionService : time = " + ( finish.getTime() - start.getTime() ));
        System.out.println((new Date()).toString() + ": requestCollectionOfWebsitesViaCompleteionService : pool size = " + ((ThreadPoolExecutor) executor).getLargestPoolSize());


        assertEquals(sites.size(), results.size());

        for ( int i = 1; i < results.size(); i++ ) {
            if ( results.get(i-1).getResponseTime() > results.get(i).getResponseTime() ) {
                fail("the array is not in an increasing order");
            }
        }

    }

    @Test
    public void requestCollectionOfWebsitesWithSemaphore() throws Exception {
        Semaphore semaphore = new Semaphore(5);

        List<SitePerformancer> sites = new ArrayList<SitePerformancer>();
        sites.add(new SitePerformancer(new URL("http://www.google.com"), semaphore));
        sites.add(new SitePerformancer(new URL("http://www.yandex.ru"), semaphore));
        sites.add(new SitePerformancer(new URL("http://www.mail.ru"), semaphore));
        sites.add(new SitePerformancer(new URL("http://www.gmail.com"), semaphore));
        sites.add(new SitePerformancer(new URL("http://www.bing.com"), semaphore));
        sites.add(new SitePerformancer(new URL("http://www.yahoo.com"), semaphore));
        sites.add(new SitePerformancer(new URL("http://www.microsoft.com"), semaphore));

        Executor executor = Executors.newCachedThreadPool();
        ExecutorCompletionService<SitePerformancer.Pair> service = new ExecutorCompletionService<SitePerformancer.Pair>(executor);

        Date start = new Date();
        for ( SitePerformancer site : sites ) {
            service.submit(site);
        }

        List<SitePerformancer.Pair> results = new ArrayList<SitePerformancer.Pair>();

        for ( int i = 0; i < sites.size(); i++ ) {
            Future<SitePerformancer.Pair> result = service.take();
            results.add(result.get());

            System.out.println((new Date()).toString() + ": requestCollectionOfWebsitesWithSemaphore :" + result.get().getSite() + " replied in " + result.get().getResponseTime() + " ms");

        }
        Date finish = new Date();

        System.out.println((new Date()).toString() + ": requestCollectionOfWebsitesWithSemaphore : time = " + ( finish.getTime() - start.getTime() ));
        System.out.println((new Date()).toString() + ": requestCollectionOfWebsitesWithSemaphore : pool size = " + ((ThreadPoolExecutor) executor).getLargestPoolSize());

        assertEquals(sites.size(), results.size());

    }

}
