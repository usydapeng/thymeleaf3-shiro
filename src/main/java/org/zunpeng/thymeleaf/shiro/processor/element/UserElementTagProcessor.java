package org.zunpeng.thymeleaf.shiro.processor.element;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import org.zunpeng.thymeleaf.shiro.ShiroFacade;

/**
 * Created by dapeng on 16/8/13.
 */
public class UserElementTagProcessor extends AbstractElementTagProcessor {

	private static final String TAG_NAME = "user";

	private static final int PRECEDENCE = 1000;


	public UserElementTagProcessor(final String dialectPrefix) {
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

		if(ShiroFacade.isUser()){
			structureHandler.removeTags();
		} else {
			structureHandler.removeElement();
		}
	}
}
