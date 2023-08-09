package scheduler.filescheduler;



import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import scheduler.configuration.FileConfiguration;
import scheduler.util.FileUtil;

@Component(
		  immediate = true, property = {"cron.expression=0 */5 * ? * *"},
		  service = DeleteFileScheduler.class,
		  configurationPid = "scheduler.configuration.FileConfiguration"
		)
public class DeleteFileScheduler extends BaseMessageListener {
	
	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub

		try {
			FileUtil.deletFile();
			System.out.println("deleted");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
		}
		

	}
	 @Activate
	  @Modified
	  protected void activate(Map<String,Object> properties) throws PortalException {
		 System.out.println("activate function");
		 
		 List<DLFileEntry> DLFiles = new ArrayList<>();
			DLFiles = DLFileEntryLocalServiceUtil.getFileEntries(0, DLFileEntryLocalServiceUtil.getFileEntriesCount());
		
			for(DLFileEntry dlfile : DLFiles) {
				String path = dlfile.getTreePath();
				System.out.println(path);
			}
//			Date date = dlfile.getCreateDate();
//			Date crrdate = new Date();
//			System.out.println("given Date "+date.getTime());
//			System.out.println("current Date " + crrdate.getTime());
//
//			long diff = FileUtil.getDateDifference(date, crrdate, TimeUnit.SECONDS );
//			long diffinsec =   crrdate.getTime()- date.getTime();
//			System.out.println("Difference = " +diff + "In sec " + diffinsec/1000);
//			}
//			if(diff<=0) {
//		
//			}}
		 
//		 try {
//				FileUtil.deletFile();
//				System.out.println("deleted");
//			} catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("Hello");
//			}
		 _fileConfiguration = ConfigurableUtil.createConfigurable(FileConfiguration.class, properties);
        

		  String cronExpressioncustomer = GetterUtil.getString(_fileConfiguration.chronexpressionCustomer(),_DEFAULT_CRON_EXPRESSION);

			// create a new trigger definition for the jobs.
			//create a trigger for saleshierarchy job
			
			String listenerClass = getClass().getName();
		
			Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass, listenerClass, new Date(), null,
					cronExpressioncustomer);
			
			_schedulerEntryImpl = new SchedulerEntryImpl(listenerClass, jobTrigger);
			// if we were initialized (i.e. if this is called due to CA modification)
			if (_initialized) {
				// first deactivate the current job before we schedule.
				deactivate();
			
			}

			// register the scheduled task
			_schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
		
			// set the initialized flag.
			_initialized = true;
		}
	  
	  @Deactivate
		protected void deactivate() {
			if (_initialized) {
				// unregister this listener
				_schedulerEngineHelper.unregister(this);
	          

			}

			// clear the initialized flag
			_initialized = false;
		}
	  
	  protected StorageType getStorageType() {
			if (_schedulerEntryImpl instanceof StorageTypeAware) {
				return ((StorageTypeAware) _schedulerEntryImpl).getStorageType();
			}

			return StorageType.MEMORY_CLUSTERED;
		}
	  
	  @Reference(unbind = "-")
		protected void setTriggerFactory(TriggerFactory triggerFactory) {
			_triggerFactory = triggerFactory;
		}
	  @Reference(unbind = "-")
		protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {
			_schedulerEngineHelper = schedulerEngineHelper;
		}
	  private volatile boolean _initialized;
	  private TriggerFactory _triggerFactory;
	  private static final String _DEFAULT_CRON_EXPRESSION = "0 */5 * ? * *";
	  private SchedulerEntryImpl _schedulerEntryImpl;
	  private SchedulerEngineHelper _schedulerEngineHelper;
	  private volatile FileConfiguration _fileConfiguration;

}

