package org.zunpeng.thymeleaf.shiro.dialect;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.zunpeng.thymeleaf.shiro.processor.attribute.*;
import org.zunpeng.thymeleaf.shiro.processor.element.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dapeng on 16/8/11.
 */
public class ShiroDialect extends AbstractProcessorDialect {

	private static final String DIALECT_NAME = "Shiro Dialect";

	public ShiroDialect() {
		super(DIALECT_NAME, "shiro", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new GuestAttributeTagProcessor(dialectPrefix));
		processors.add(new GuestElementTagProcessor(dialectPrefix));

		processors.add(new UserAttributeTagProcessor(dialectPrefix));
		processors.add(new UserElementTagProcessor(dialectPrefix));

		processors.add(new HasAllRolesAttributeTagProcessor(dialectPrefix));
		processors.add(new HasAllRolesElementTagProcessor(dialectPrefix));

		processors.add(new HasAnyRolesAttributeTagProcessor(dialectPrefix));
		processors.add(new HasAnyRolesElementTagProcessor(dialectPrefix));

		processors.add(new HasRoleAttributeTagProcessor(dialectPrefix));
		processors.add(new HasRoleElementTagProcessor(dialectPrefix));

		processors.add(new LacksRoleAttributeTagProcessor(dialectPrefix));
		processors.add(new LacksRoleElementTagProcessor(dialectPrefix));

		processors.add(new HasAllPermissionsAttributeTagProcessor(dialectPrefix));
		processors.add(new HasAllPermissionsElementTagProcessor(dialectPrefix));

		processors.add(new HasAnyPermissionsAttributeTagProcessor(dialectPrefix));
		processors.add(new HasAnyPermissionsElementTagProcessor(dialectPrefix));

		processors.add(new HasPermissionAttributeTagProcessor(dialectPrefix));
		processors.add(new HasPermissionElementTagProcessor(dialectPrefix));

		processors.add(new lacksPermissionAttributeTagProcessor(dialectPrefix));
		processors.add(new LacksPermissionElementTagProcessor(dialectPrefix));

		return processors;
	}
}
