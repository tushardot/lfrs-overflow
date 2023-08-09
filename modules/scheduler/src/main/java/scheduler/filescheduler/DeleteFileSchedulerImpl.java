package scheduler.filescheduler;

import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;

public class DeleteFileSchedulerImpl extends SchedulerEntryImpl implements SchedulerEntry, StorageTypeAware {

	
	public DeleteFileSchedulerImpl(String eventListenerClass, Trigger trigger) {
		super(eventListenerClass, trigger);
		// TODO Auto-generated constructor stub
	}
	
	public DeleteFileSchedulerImpl(SchedulerEntryImpl _schedulerEntryImpl, StorageType persisted) {
		super(_schedulerEntryImpl.getEventListenerClass(), _schedulerEntryImpl.getTrigger());
		_storageType = persisted;
		_schedulerEntry = _schedulerEntryImpl;
	}
	@Override
	public StorageType getStorageType() {
		// TODO Auto-generated method stub
		return _storageType;
	}

	private SchedulerEntryImpl _schedulerEntry;
	private StorageType _storageType;
}
