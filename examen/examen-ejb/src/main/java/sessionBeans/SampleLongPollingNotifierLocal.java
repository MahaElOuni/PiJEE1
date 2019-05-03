package sessionBeans;

import javax.ejb.Local;
import javax.servlet.AsyncEvent;

@Local
public interface SampleLongPollingNotifierLocal {
	public void onComplete(AsyncEvent event);
	public void onTimeout(AsyncEvent event);
	 public void onError(AsyncEvent event);
	 public void onStartAsync(AsyncEvent event);

}
