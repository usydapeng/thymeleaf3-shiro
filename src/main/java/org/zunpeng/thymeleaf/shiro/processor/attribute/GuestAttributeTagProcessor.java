package org.zunpeng.thymeleaf.shiro.processor.attribute;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import org.zunpeng.thymeleaf.shiro.ShiroFacade;

/**
 * Created by dapeng on 16/8/13.
 */
public class GuestAttributeTagProcessor extends AbstractAttributeTagProcessor {

	private static final String ATTRIBUTE_NAME = "guest";

	private static final int PRECEDENCE = 12000;

	public GuestAttributeTagProcessor(final String dialectPrefix) {
		super(
				TemplateMode.HTML, // This processor will apply only to HTML mode
				dialectPrefix,     // Prefix to be applied to name for matching
				null,              // No tag name: match any tag name
				false,             // No prefix to be applied to tag name
				ATTRIBUTE_NAME,         // Name of the attribute that will be matched
				true,              // Apply dialect prefix to attribute name
				PRECEDENCE,        // Precedence (inside dialect's precedence)
				true);             // Remove the matched attribute afterwards

	}

	@Override
	protected void doProcess(
			final ITemplateContext context, final IProcessableElementTag tag,
			final AttributeName attributeName, final String attributeValue,
			final IElementTagStructureHandler structureHandler) {

		if(!ShiroFacade.isGuest()){
			structureHandler.removeElement();
		}
	}
}
