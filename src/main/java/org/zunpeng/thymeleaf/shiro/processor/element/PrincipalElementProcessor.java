/*****************************************************************************
 * Copyright (c) 2013, theborakompanioni (http://www.example.org)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ****************************************************************************/
package org.zunpeng.thymeleaf.shiro.processor.element;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.element.AbstractTextChildModifierElementProcessor;

import org.zunpeng.thymeleaf.shiro.dialect.ShiroFacade;

public class PrincipalElementProcessor extends AbstractElementTagProcessor {

    public static final PrincipalElementProcessor create() {
        return new PrincipalElementProcessor();
    }

    private static final String ELEMENT_NAME = "principal";
    private static final int PRECEDENCE = 300;

    protected PrincipalElementProcessor() {
        super(ELEMENT_NAME);
    }

    @Override
    public int getPrecedence() {
        return PRECEDENCE;
    }

    @Override
    protected String getText(final Arguments arguments, final Element element) {
        final String type = element.getAttributeValue("type");
        final String property = element.getAttributeValue("property");

        return ShiroFacade.getPrincipalText(type, property);
    }
}