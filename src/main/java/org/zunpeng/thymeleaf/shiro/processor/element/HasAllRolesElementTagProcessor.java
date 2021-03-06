package org.zunpeng.thymeleaf.shiro.processor.element;

import org.apache.commons.lang.StringUtils;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import org.zunpeng.thymeleaf.shiro.ShiroFacade;

/**
 * Created by dapeng on 16/8/13.
 */
public class HasAllRolesElementTagProcessor extends AbstractElementTagProcessor {

	private static final String TAG_NAME = "hasAllRoles";

	private static final String DELIMITER = ",";

	private static final int PRECEDENCE = 300;


	public HasAllRolesElementTagProcessor(final String dialectPrefix) {
		super(
				TemplateMode.HTML, // This processor will apply only to HTML mode
				dialectPrefix,     // Prefix to be applied to name for matching
				TAG_NAME,          // Tag name: match specifically this tag
				true,              // Apply dialect prefix to tag name
				null,              // No attribute name: will match by tag name
				false,             // No prefix to be applied to attribute name
				PRECEDENCE);       // Precedence (inside dialect's own precedence)
	}

	@Override
	protected void doProcess(
			final ITemplateContext context, final IProcessableElementTag tag,
			final IElementTagStructureHandler structureHandler) {

		final String allRolesStr = tag.getAttributeValue("name");

		final String[] roles = StringUtils.split(allRolesStr, DELIMITER);

		if(ShiroFacade.hasAllRoles(roles)){
			structureHandler.removeTags();
		} else {
			structureHandler.removeElement();
		}
	}
}
