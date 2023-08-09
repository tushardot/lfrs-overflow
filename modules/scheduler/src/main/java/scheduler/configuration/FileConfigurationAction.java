package scheduler.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import scheduler.constants.SchedulerPortletKeys;




@Component(configurationPid = "scheduler.configuration.FileConfiguration", configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true, property = "javax.portlet.name="
		+ SchedulerPortletKeys.SCHEDULER, service = ConfigurationAction.class)
public class FileConfigurationAction extends DefaultConfigurationAction {

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// include the configuration value created in the control panel
		_log.debug("include the configuration");
		request.setAttribute(FileConfiguration.class.getName(), _fileConfiguration);
		super.include(portletConfig, request, response);
	}
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String cronexpression = ParamUtil.getString(actionRequest, "cronexpression");
		_log.debug("cronexpresion is" + cronexpression);
		setPreference(actionRequest, "cronexpression", cronexpression);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_fileConfiguration = ConfigurableUtil.createConfigurable(FileConfiguration.class, properties);
	}
	
	private volatile FileConfiguration _fileConfiguration;
	private static final Log _log = LogFactoryUtil.getLog(FileConfigurationAction.class);
}
