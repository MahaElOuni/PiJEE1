package sessionBeans;

import java.io.IOException;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletOutputStream;

/**
 * Session Bean implementation class SampleLongPollingNotifier
 */
@Singleton
@LocalBean
public class SampleLongPollingNotifier implements SampleLongPollingNotifierRemote{

	private final Queue<AsyncContext> peers = new ConcurrentLinkedQueue();
	 
    public void notifyPeers(@Observes Date date) {
        for (AsyncContext ac : peers) {
            try {
                final ServletOutputStream os = ac.getResponse().getOutputStream();
                os.println(date.toString());
                ac.complete();
            } catch (IOException ex) {
                // Nothing ToDo: Connection was most likely closed by client.
            } finally {
                peers.remove(ac);
            }
        }
    }
 
    public void addAsyncContext(final AsyncContext ac) {
        ac.addListener(new AsyncListener() {
        	@Override
            public void onComplete(AsyncEvent event) throws IOException {
                peers.remove(ac);
            }
        	@Override
            public void onTimeout(AsyncEvent event) throws IOException {
                peers.remove(ac);
            }
        	@Override
            public void onError(AsyncEvent event) throws IOException {
                peers.remove(ac);
            }
        	@Override
            public void onStartAsync(AsyncEvent event) throws IOException {
            }
        });
        peers.add(ac);
    }
}
