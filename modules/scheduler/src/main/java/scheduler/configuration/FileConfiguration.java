package scheduler.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedAttributeDefinition;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "panasonic", scope = ExtendedObjectClassDefinition.Scope.COMPANY)
@Meta.OCD(id="scheduler.configuration.FileConfiguration", name = "File configuration")


public interface FileConfiguration {

	
	
	@Meta.AD(required = false, deflt = "0 * * ? * *")
	public String chronexpressionCustomer();


}
